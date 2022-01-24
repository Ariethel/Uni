/*
 Scrivere un programma C che crea 4 processi, denominati A, B, C, D. A è il main e crea B, che a sua volta crea
C che provvede alla creazione di D. I 4 processi devono comunicare in maniera circolare attraverso l’uso della
system call pipe() di Unix e cioè A invia una stringa a B, B aggiunge il proprio PID e invia la stringa a C
che a sua volta aggiunge il proprio PID e invia il messaggio completo a D. Al termine D, aggiunge il proprio
PID ed invia il messaggio di nuovo ad A. A sceglie i 4 messaggi da inviare (una stringa costituita da un numero
casuale di 8 cifre) e dopo aver ricevuto le 4 risposte, invia un messaggio di terminazione (-1), ed aspetta la
terminazione di B (tutti i processi devono terminare).
 */

#include <ourhdr.h>
#define N_PROC 3

void d_worker(){
	printf("D creato\n");
}


void c_worker(){
	printf("C creato\n");
	int pidD;
	if ((pidD = fork()) < 0) err_sys("Fork D Failed");
	if (pidD == 0){
		d_worker();
		exit(0);
	}
}


void b_worker(){
	int pidC;
	printf("B creato\n");
	if ((pidC = fork()) < 0) err_sys("Fork C Failed");
	if (pidC == 0){
		c_worker();
		exit(0);
	}

}

int main(void) {
	int pidB;
	int ApipeB[2];
	if (pipe(ApipeB) < 0) err_sys("Pipe da A a B failed");

	if ((pidB = fork()) < 0)
		err_sys("Fork B Failed");
	if (pidB == 0){
		//CONTINUARE DA QUI
		b_worker();
		exit(0);
	}
	close(ApipeB[READ_END]);
	char str = "Padre: A";
	if (write(ApipeB[WRITE_END],&str,sizeof(str)) < 0) err_sys("Write failed from A to B");
	return EXIT_SUCCESS;
}
