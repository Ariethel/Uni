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
int DpipeA[2]; //Pipe dal figlio D al padre A

void d_worker(char str[]){
	char strn[500];
	strcat(strn,str);
	strcat(strn,", Figlio D.\n");
	if (write(DpipeA[WRITE_END], &strn,sizeof(strn)) < 0) err_sys("Write from C to D failed");
	close(DpipeA[WRITE_END]);
}


void c_worker(char str[]){
	int pidD;
	char strn[50];
	strcat(strn,str);
	strcat(strn,", Figlio C");
	int CpipeD[2];
	if (pipe(CpipeD) < 0) err_sys("Pipe da C a D failed");
	if ((pidD = fork()) < 0) err_sys("Fork D Failed");
	if (pidD == 0){
		//Sono dentro D
		close(CpipeD[WRITE_END]);
		char str[50];
		if (read(CpipeD[READ_END],&str, sizeof(str)) < 0) err_sys("Read frome C to D failed");
		close(CpipeD[READ_END]);
		d_worker(str);
		exit(0);
	}
	close(CpipeD[READ_END]);
	if (write(CpipeD[WRITE_END], &strn,sizeof(strn)) < 0) err_sys("Write from C to D failed");
	close(CpipeD[WRITE_END]);
}


void b_worker(char str[]){
	int pidC;
	char strn[50];
	strcat(strn,str);
	strcat(strn,", Figlio B");
	int BpipeC[2];
	if (pipe(BpipeC) < 0) err_sys("Pipe da B a C failed");
	if ((pidC = fork()) < 0) err_sys("Fork C Failed");
	if (pidC == 0){
		//Sono dentro C
		close(BpipeC[WRITE_END]);
		char str[50];
		if (read(BpipeC[READ_END], &str, sizeof(str)) < 0) err_sys("Read from B to C failed");
		close(BpipeC[READ_END]);
		c_worker(str);
		exit(0);
	}
	close(BpipeC[READ_END]);
	if (write(BpipeC[WRITE_END],&strn, sizeof(strn)) < 0) err_sys("Write from B to C failed");
	close(BpipeC[WRITE_END]);

}

int main(void) {
	if (pipe(DpipeA) < 0) err_sys("Pipe da D a A failed");
	int pidB;
	int ApipeB[2];
	if (pipe(ApipeB) < 0) err_sys("Pipe da A a B failed");

	if ((pidB = fork()) < 0)
		err_sys("Fork B Failed");
	if (pidB == 0){
		//Sono dentro B
		close(ApipeB[WRITE_END]);
		char str[50];
		if (read(ApipeB[READ_END], &str, sizeof(str)) < 0) err_sys("Read failed from A to B");
		b_worker(str);
		close(ApipeB[READ_END]);
		exit(0);
	}
	close(ApipeB[READ_END]);
	char str[50] = "Padre A";
	if (write(ApipeB[WRITE_END],&str,sizeof(str)) < 0) err_sys("Write failed from A to B");
	close(ApipeB[WRITE_END]);
	for (int i = 0; i < 3; i++) wait(NULL);
	char strfinal[50];
	if (read(DpipeA[READ_END], &strfinal, sizeof(strfinal)) < 0) err_sys("Read failed from D to A");
	close(DpipeA[READ_END]);
	printf("Stringa ricevuta da A ---> %s", strfinal);
	return EXIT_SUCCESS;
}
