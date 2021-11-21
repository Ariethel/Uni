/*
 ============================================================================
 Name        : ExecveDup.c
 Author      : Roberto Della Rocca
 Version     :
 Copyright   : Your copyright notice
 Description : Scrivere un programma C che prende sulla linea di comando un numero arbitrario
 di path. Per ogni path il main dovrà creare un sotto processo che esegue il comando /bin/ls sulla apth indicata
 il processo padre dovrà attendere la terminazione di tutti i fili prima
 di stampare il numero totale dei processi eseguiti con successo (exit code = 0) ed uscire

 ============================================================================
 */

#include <ourhdr.h>

char pathCommand[] = "/usr/bin/ls";

void worker(int fileDescriptor, char argv[]) {


	if (dup2(fileDescriptor, STDOUT_FILENO) < 0)
		err_sys("dup2 failed");

	if (dup2(fileDescriptor, STDERR_FILENO) < 0)
		err_sys("dup2 failed");
	close(fileDescriptor);

	char *tmpArgv[] = {"ls", "-C1", argv, NULL}; //creo il argv temporaneo per execve, contiene il comando da eseguire

	execve(pathCommand, tmpArgv, NULL);
}

int main(int argc, char *argv[]) {

	int i, pid;
	int fileLog;

	if (argc == 1)
		err_sys("Error paramaters! ./ExecveDup <path> <path> ...");

	if ((fileLog = open("exec.log", O_CREAT | O_WRONLY | O_TRUNC | O_APPEND, 0x664)) < 0)
		err_sys("Cannot open file exec.log");

	for (i = 1; i < argc; i++) {
		if ((pid = fork()) < 0)
			err_sys("Error fork");
		else if (pid == 0) {
			//operazioni del processo figlio
			worker(fileLog, argv[i]);
		}
	}


	for (i = 1; i < argc; i++) {
		if ((pid = wait(NULL)) < 0)
			err_sys("Father process must wait that all child finish their jobs");
		else
			printf("Process %d terminated\n", pid);
	}

}
