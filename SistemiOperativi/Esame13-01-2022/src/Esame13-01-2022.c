/*
 Scrivere un programma C che crea 4 figli. Ogni figlio genera un intero x casuale tra 0 e 1000,
 crea un file nella directory corrente con nome x.txt e attende x msec. Terminera' dopo
 10000 iterazioni.
 Il padre, finche' non saranno terminati i figli, scorrera' continuamente la directory cancellando tutti i
 file con x > 500.

 Opzionalmente il padre stampera' poi la media dei valori cancellati
 */

#include <ourhdr.h>
#include <dirent.h>
int pid[4];

void worker(){
	int i = 0;
	while (i < 10000){
		int rand = random() % 1001;
		char path[256];
		sprintf(path, "%d.txt", rand);
		printf("int: %d \t Path: %s\n", rand, path);
		int fp;
		if (((fp = open(path, O_CREAT| O_RDWR)) < 0) && !path) err_sys("Write failed in children");
		close(fp);
		usleep(rand);
		i++;
	}

}

int main(void) {
	for (int i = 0; i < 4; i++){
		if ((pid[i] = fork()) < 0) err_sys("Fork %d failed",i);
		if (pid[i] == 0){
			worker();
			exit(1);
		}
	}
	for (int i = 0; i < 4; i++){
			wait(NULL);
	}
	DIR *dir;
	int sum = 0, count = 0;
	char path[256] = "/home/amnesia/Uni/SistemiOperativi/Esame13-01-2022";
	if ((dir = opendir(path)) == NULL) err_sys("failed opening %s\n",path);
	struct dirent *entry;
	while((entry = readdir(dir)) != NULL){
		int num = entry->d_name + '0';
		if (num > 500){
			sum += num;
			count++;
			printf("Cancellato %s\n", entry->d_name);
			remove(entry->d_name);
		}

	}
	closedir(dir);
	printf("Media: %f", sum/count);
	return EXIT_SUCCESS;
}
