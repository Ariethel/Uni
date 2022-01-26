/*
 Scrivere un programma che prima scrive in un file 10.000 interi casuali e successivamente genera 2 processi P1
e P2. P1 leggerà dal file tutti gli interi in posizione dispari (1,3, ecc.) e P2 quelli in posizioni pari. Entrambi i
processi ogni volta che trovano un intero x congruo a 0 modulo 31 invierà un segnale al processo padre
(SIGUSR1 P1 e SIGUSR2 P2). Una volta letto l’intero file i 2 figli termineranno la propria esecuzione.
Il padre attende la terminazione dei figli e prima di terminare stamperà il numero totale dei segnali ricevuti da
ognuno dei figli.
 */

#include <ourhdr.h>
int p1 = 0;
int p2 = 0;
int fp;

void incrementaP1(int p){
	if (p == SIGUSR1)
		p1++;
}

void incrementaP2(int p){
	if (p == SIGUSR2)
		p2++;
}

void workerP1(int fp){
	int buf;
	fseek(fp, sizeof(int), SEEK_SET);
	while(!feof(fp)){
		fseek(fp, sizeof(int) * 2, SEEK_CUR);
		if (read(fp, &buf, sizeof(int)) < 0) err_sys("Read Failed in P1");
		printf("Letto P1: %d\n",buf);
		if (buf % 31 == 0) kill(getppid(),SIGUSR1);
	}
}

void workerP2(int fp){
	int buf;
	fseek(fp, 0, SEEK_SET);
	while(!feof(fp)){
		fseek(fp, sizeof(int) * 2, SEEK_CUR);
		if (read(fp, &buf, sizeof(int)) < 0) err_sys("Read Failed in P2");
		printf("Letto P2: %d\n",buf);
		if (buf % 31 == 0) kill(getppid(),SIGUSR2);
	}
}


int main(void) {
	int pid[2];
	if ((fp = open("testo.txt", O_CREAT | O_RDWR | O_TRUNC, 0777)) < 0) err_sys("Open failed");
	srand(time(NULL));
	int r;
	for (int i = 0; i < 10000; i++){
		//Devo scrivere 10000 interi casuali
		r = rand() % 11;
		if (write(fp, &r, sizeof(int)) == -1) err_sys("write failed at %d",i);
	}

	for (int i = 0; i < 2; i++){
		if ((pid[i] = fork()) < 0) err_sys("Fork %d failed\n",i);
		if (pid[i] == 0) {
			if (i == 0) //Compito del figlio P1
				workerP1(fp);

			if (i == 1) //Compito del figlio P2
				workerP2(fp);
			exit(1);
		}
	}

	if (signal(SIGUSR1, incrementaP1) == SIG_ERR) err_sys("Signal failed from P1"); //Gestione segnali P1
	if (signal(SIGUSR2, incrementaP2) == SIG_ERR) err_sys("Signal failed from P2"); //Gestione segnali P2

	for (int i = 0; i < 2; i++) wait(NULL);
	printf("P1: %d\n", p1);
	printf("P2: %d\n", p2);
	close(fp);
	return EXIT_SUCCESS;
}
