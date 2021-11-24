/*
 * Scrivere un programma che dato un array, lo divida in 3 e ne calcoli
 * la somma degli elementi tramite una pipe
*/

#include <ourhdr.h>
#define N_PROC 3

void worker(int id,int pwr,int *array,int start,int end){
	int somma = 0;
	printf("FIGLIO START: %d, END:%d\n",start,end);
	for (int i = start; i < end; i++){
		somma += array[i];
	}
	if (write(pwr, &somma, sizeof(int)) == -1)
		err_sys("Write failed");

	printf("Il figlio %d ha scritto la somma: %d\n",id,somma);
	close(pwr);//Chiudo la pipe in scrittura
}

int main(void) {
	int array[100] = {1,2,3,4,5,6,1,1};
	int pid;
	int sommaTot = 0,tmp = 0;
	int pipes[N_PROC][2];
	int dimArray = sizeof(array) / sizeof(int);

	//Creo le pipe
	for (int i = 0; i < N_PROC; i++){
		if (pipe(pipes[i]) == -1)
			err_sys("Pipe %d failed",i);
	}

	//Creo i figli
	for (int i = 0; i < N_PROC; i++){
		if((pid = fork()) == -1)
			err_sys("fork %d failed",i);
		if (pid == 0){ //Sono nel figlio
			int start = (dimArray/N_PROC) * i;
			int end = (dimArray/N_PROC) * (i+1);
			worker(i,pipes[i][WRITE_END],array,start,end);
			exit(0);
		}
	}

	//Aspetto la terminazione dei processi
	for (int i = 0; i < N_PROC; i++) {
		if ((pid = wait(NULL)) < 0)
			err_sys("Father process must wait that all child finish their jobs");
		else
			printf("\nProcess %d terminated\n", pid);
	}

	//Sono nel padre
	for (int i = 0; i < N_PROC; i++){
		fflush(stdout);
		if (read(pipes[i][READ_END], &tmp, sizeof(int)) == -1)
				err_sys("Read failed");


		close(pipes[i][READ_END]);//Chiudo la pipe in lettura

		printf("Ho letto %d dal figlio %d\n",tmp,i);
		sommaTot += tmp;

	}




	printf("Somma totale: %d",sommaTot);

	return EXIT_SUCCESS;
}
