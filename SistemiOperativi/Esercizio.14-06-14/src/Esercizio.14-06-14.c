/*
 Scrivere un programma C che apre il file "DivinaCommedia.txt" e crea n figli.
 Ogni figlio processera' una sezione del file di taglia 1/n del file originale cercando l'occorrenza della stringa
 "beatrice". Appena trovata la prima occorrenza lo segnalera' al padre tramite il segnale SIGUSR1. Ricevuto il segnale, il
 padre terminera' dopo aver arrestato tutti i figli.

 Opzionalmente se il padre volesse conoscere quale figlio ha trovato l'occorrenza e/o l'offset all'interno del file dove e' stata
 trovata, come dovrebbe essere modificato il programma?
*/

#include <ourhdr.h>
#define n 4

int pid[n];
void termina(int s){
	if (s == SIGUSR1){
		for (int i = 0; i < n; i++){
			kill(pid[i], SIGKILL);
		}
	}

}

void worker(){
	printf("Hello World");
}

int main(void) {
	int fp;

	if ((fp = open("DivinaCommedia.txt", O_RDONLY))) err_sys("File not found\n");
	struct stat *statbuf;
	if (lstat(fp, &statbuf) < 0){
		err_sys("stat failed");
	}


	for (int i = 0; i < n; i++){
		if ((pid[i] = fork()) < 0)
			err_sys("fork failed");
		if (pid[i] == 0){
			worker(i, fp, statbuf->st_size/n);
			exit(1);
		}
	}

	signal(SIGUSR1, &termina);



	return EXIT_SUCCESS;
}
