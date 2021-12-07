/*Scrivere un programma C che genera 10 sotto processi.
Ogni figlio attende il segnale SIGUSR1 ed alla ricezione del segnale
incrementa il proprio contatore.
Quando il contatore raggiunge il valore 100, il processo termina.
Il padre ogni 100 msec invia il segnale SIGUSR1 ad uno dei figli scelti a caso.
Se un figlio termina, individua quale è terminato e uccide tutti gli altri
per poi terminare a sua volta.
*/


#include <ourhdr.h>
int pid[10];
const sigset_t *set;


void worker(){
	int count = 0;
	int *signal;
	sigwait(set,signal);
	if (signal == 10){
		printf("Received SIGUSR1 on child %d\n",getpid());
		count++;
	}


	if (count == 100)
		exit(count);
}

void inviaSegnale(){
	int i = (random()%10) + 1;
	printf("Invio segnale %d a %d",SIGUSR1,pid[i]);
	kill(pid[i],SIGUSR1);
}

int main(){
	int s;
	for (int i = 0; i < 10; i++){
		if ((pid[i] = fork()) < 0)
			err_sys("Fork failed");
		if (pid[i] == 0){
			//Sono nel figlio
			printf("Creato figlio %d\n",i);
			worker(s);
			exit(1);
		}
	}

	while(1){
		inviaSegnale();

		usleep(100);
	}


	int status;

	waitpid(pid, &status, 0);

	if ( WIFEXITED(status) )
	{
		int exit_status = WEXITSTATUS(status);
		printf("Exit status of the child was %d\n", exit_status);
	}


	return 0;
}
