/*
Scrivere un programam che conta fino a sizeTot dividendo la conta in 4 processi
 */

#include <ourhdr.h>
#define N_PROC 4
#define sizeTot 10000

void worker(int pid, int inizio, int fine){
	for (int i = 0; i < fine; i++){
		fprintf(stdout,"%d: %d \n",pid, i);
	}
}

int main(void) {
	int pid[N_PROC];
	int sizeParziale = sizeTot/N_PROC;
	for (int i = 0; i < N_PROC; i++){
		if ((pid[i] = fork()) < 0)
			err_sys("Fork %d failed \n",i);
		if (pid[i] == 0){
			worker(getpid(), sizeParziale*i, sizeParziale * (i+1));
			exit(0);
		}
	}

	for (int i = 0; i < N_PROC; i++) wait(NULL);
	return EXIT_SUCCESS;
}
