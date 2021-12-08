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
int count = 0;

void worker(int s){
	if (s == SIGUSR1)
		count++;

	if (count == 100){
		printf("\n\n\n\n\n\n\n\nHa vinto il figlio %d\n",getpid());
		kill(getppid(),SIGCHLD);
		exit(0);
	}

}


void killaTutti(int s){
	if (s == SIGCHLD){
		for (int i = 0; i < 0; i++){
			kill(pid[i],SIGKILL);
		}
	}
}


void inviaSegnale(){
	int i = (random()%10) + 1;
	printf("Invio segnale %d a %d\n",SIGUSR1,pid[i]);
	kill(pid[i],SIGUSR1);
}

int main(){

	for (int i = 0; i < 10; i++){

		if ((pid[i] = fork()) < 0)
			err_sys("Fork failed");
		if (pid[i] == 0){
			//Sono nel figlio
			printf("Creato figlio %d\n",i);
			signal(SIGUSR1,&worker);
			pause(); //Aspetta l'arrivo di un segnale
		}
	}


	if (pid != 0){
		//Sono nel padre

		signal(SIGCHLD,&killaTutti); //Killa tutti i figlio se un processo finisce


		sleep(5); //Mi serve a vedere la creazione dei figlio


		while(1){
			inviaSegnale();

			usleep(100000);
		}
	}


	return 0;
}
