/*
 * leggere una directory e per ciascun file regolare creare un figlio, a questo punto ogni figlio deve cercare un buco o il carattere proibito "&"
 * nel file che gli compete, se la trova stampa la path, la size e il n_blocchi di questo file. Invia inoltre un segnale al padre che
 * a questo punto termina tutti i processi figli
 */

#include <dirent.h>
#include <ourhdr.h>
#include <signal.h>
int n; //numero di file regolari letti e, di conseguenza, di figli creati
pid_t *pids;

int filter(const struct dirent *entry){
	if (entry-> d_type == DT_REG)
		return 1;
	return 0;
}

void worker(char *path){
	struct stat *statbuf;
	int fd,rd;
	if (lstat(path, &statbuf) < 0)
		err_sys("Stat failed");
	//controllo se il file contiene un buco
	if (statbuf->st_size > (statbuf->st_blocks)*512){ //size contiene la taglia virtuale del file, mentre st_blocks*512 rappresenta quella reale in unix
		printf("Il file %s ha size %ld ed il suo numero di blocchi e' %ld",path,statbuf->st_size,statbuf->st_blocks);
		kill(getppid(),SIGUSR1);
		exit(EXIT_SUCCESS);
	}
	if ((fd = open(path,O_RDONLY)) < 0)
		err_sys("Open failed");

	char buffer;
	while ((rd = read(fd,&buffer,sizeof(buffer))) > 0){
		if (strcmp(buffer, "&") == 0){ //Controlla se il file contiene il carattere &
			printf("Il file %s contiene il carattere proibito ed ha %ld",path,statbuf->st_blocks);
			kill(getppid(),SIGUSR1);
			exit(EXIT_SUCCESS);
		}
	}if (rd < 0)
		err_sys("Read failed");


	sleep(10); //Lascio il figlio in pausa per 10 sec se non trova nulla di utile
	exit(EXIT_SUCCESS);
}


void handler(int sig){
	if (sig == SIGUSR1){
		if (killpg(0, SIGKILL) < 0)//Invia un segnale a tutto il process group
			err_sys("Killpg failed");
	}
}

int main(int argc, char *argv[]) {
	if (argc < 2)
		err_sys("Need more arguments");


	struct dirent **array;
	if ((n = scandir(argv[1],&array,filter,NULL)) < 0)
		err_sys("Scandir failed");


	pids = malloc(sizeof(pid_t) * n);
	char fullpath[PATH_MAX];
	for (int i = 0; i < n; i++){
		if ((pids[i] = fork()) < 0)
			err_sys("Fork Failed");
		if (pids[i] == 0){
			//Sono nel figlio
			sleep(1); //Per evitare che il figlio venga generato prima della registrazione dell'handler
			sprintf(fullpath,"%s/%s",argv[1],array[i]->d_name);
			worker(fullpath);
		}
	}


	if (signal(SIGUSR1,handler) < 0)
		err_sys("handler failed");

	for (int i = 0; i < n; i++){
		if (wait(NULL) < 0)
			err_sys("Wait failed");
	}

	free(pids);


	return EXIT_SUCCESS;
}
