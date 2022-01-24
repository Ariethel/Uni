/*
 ============================================================================
 Name        : PipeProgramm.c
 Author      : Roberto Della Rocca
 Version     :
 Copyright   : Your copyright notice
 Description : Il processo padre apre un file e invia tutto il contenuto nella pipe.
 	 	 	   Il processo figlio legge dalla pipe e conta il numero di vocali.
 	 	 	   Quando la pipe e’ terminata, stampa il numero totale di vocali e termina.
 	 	 	   Quindi termina anche il padre.

 ============================================================================
 */

#include <ourhdr.h>
#include <ctype.h>

#define N_PROC 2
//definizione macro per pipe
#define WRITE_END 1
#define READ_END 0

int contaVocali(char buf[], int rd){

	char c;
	int i, totale = 0;

	for (i = 0; buf[i] != '\0'; i++) {
		c = tolower(buf[i]);
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
			totale++;
	}

	return totale;

}

void padre(int pipewr) {

	int fdread;
	char *fileName = "/home/roberto/workspace/PipeProgram/fileTestPipe.txt";

	if((fdread = open(fileName, O_RDONLY)) < 0)
		err_sys("Cannot open %s file", fileName);

	int rd, tot = 0;
	char buf[100];
	while ((rd = read(fdread, buf, sizeof(buf))) > 0) {
		if (write(pipewr, buf, rd) < 0)
			err_sys("Writing to pipe");

		tot += rd;
	}

	if (rd < 0)
		err_sys("Reading %s input file", fileName);

	printf("Totale byte letti -> %d\n", tot);
	close(pipewr);
}

int figlio(int piperd) {

	int rd, tot = 0;
	char buf[100];

	while((rd = read(piperd, buf, sizeof(buf))) > 0) {
		tot += contaVocali(buf, rd);
	}

	if (rd < 0)
		err_sys("Reading from pipe");

	close(piperd);
	printf("Numero totale di vocali ricevute -> %d\n", tot);
	exit(tot); //non dimenticare mai 0337 8 bit a 1
}


int main(void) {

	int pid;
	int pipefd[2];

	if (pipe(pipefd) < 0) {
		err_sys("Error pipe not alloced");
	}


	if ((pid = fork()) < 0) {
		err_sys("Error fork");
	}
	else if (pid == 0) { //figlio legge dalla pipe
		close(pipefd[WRITE_END]); //chiudo l'estremita' non utlizzata in scrittura
		figlio(pipefd[READ_END]);
	}
	else {
		close(pipefd[READ_END]); //chiudo l'estremita' non utlizzata in lettura
		padre(pipefd[WRITE_END]);

		int status;

		if (waitpid(pid, &status, 0) < 0)
			err_sys("Waitpid failed");

		if (WIFEXITED(status)) {
			status = WEXITSTATUS(status);
			printf("Il processo %d ha letto %d vocali\n",pid, status);
		}
		else {
			printf("il processo %d non e' stato terminato correttamente\n", pid);
		}
	}

	return EXIT_SUCCESS;
}
