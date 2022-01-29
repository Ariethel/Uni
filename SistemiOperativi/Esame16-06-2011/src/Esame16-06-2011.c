/*
 Scrivere un programma C in cui il processo padre apre due pipe e crea un processo figlio. Il padre apre un file e
legge riga per riga il contenuto inviando la riga letta al processo figlio. Questo elimina tutte le vocali dalla linea
letta dalla pipe e rinvia la stringa risultante sulla pipe al padre. Il padre stampa la stringa ricevuta e legge la
prossima linea del file. Quanto raggiunge l’EOF manda la stringa “%%%” ed aspetta la terminazione del figlio.
Il processo figlio ricevuta la stringa chiude le pipe e termina restituendo al padre il numero di vocali eliminate
 */

#include <ourhdr.h>

void cancella_vocali(char *buffer, int rd){
	int j = 0;
	for(int i = 0; i < rd; i++){
		if (buffer[i] == 'a' || buffer[i] == 'e' || buffer[i] == 'i' || buffer[i] == 'o' || buffer[i] == 'u');
		buffer[j] = buffer[i];
		j++;
	}
}

int main(void) {
	int fp1[2]; // P ==> F
	int fp2[2]; // F ==> P

	FILE *file = fopen("prova.txt", "r");

	if (pipe(fp1) < 0) err_sys("pipe 1 failed");
	if (pipe(fp2) < 0) err_sys("pipe 2 failed");

	if (file == NULL) err_sys("Open failed");

	int pid;
	if ((pid = fork()) < 0) err_sys("fork failed");
	if (pid == 0){
		close(fp1[WRITE_END]);
		char buffer[5] = "";
		int rd;
		while (strcmp(buffer, "%%%") != 0){
			if ((rd = read(fp1[READ_END], &buffer, sizeof(buffer))) < 0) err_sys("Read failed");
			cancella_vocali(&buffer,rd);
			printf("result: %s\n", buffer);
		}

		close(fp1[READ_END]);
		exit(1);
	}
	close(fp1[READ_END]);
	size_t n = 0;
	char *lineptr = NULL;
	int rd;
	while((rd = getline(&lineptr, &n, file)) != -1){
		if (write(fp1[WRITE_END], lineptr, rd) < 0) err_sys("Write failed");
		free(lineptr);
		lineptr = NULL;
	}
	char endline[4] = "%%%";
	if (write(fp1[WRITE_END], &endline, sizeof(endline)) < 0) err_sys("Write failed");
	close(fp1[WRITE_END]);
	close(file);
	wait(NULL);
	return EXIT_SUCCESS;
}
