/*
 Scrivere un programma C che crea 4 figli. Ogni figlio genera un intero x casuale tra 0 e 1000,
 crea un file nella directory corrente con nome x.txt e attende x msec. Terminera' dopo
 10000 iterazioni.
 Il padre, finche' non saranno terminati i figli, scorrera' continuamente la directory cancellando tutti i
 file con x > 500.

 Opzionalmente il padre stampera' poi la media dei valori cancellati
 */

#include <ourhdr.h>
int pid[4];

void worker(){
	srand(time(NULL));
	int i = 0;
	while (i < 10000){
		int rand = random() % 1001;
		char path[256];
		sprintf(path, "%d.txt", rand);
		printf("int: %d\n Path: %s", rand, path);
		int fp;
		if ((fp = open(path, O_CREAT| O_WRONLY)) < 0) err_sys("Write failed in children");
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
	return EXIT_SUCCESS;
}
