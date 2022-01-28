/*
Scrivere un programma che prende 3 parametri sulla linea di comando: un pattern (stringa da ricercare), una
path di un file esistente ed un intero n. Il programma dovrà creare n processi figli ognuno dei quali dovrà
ricercare il pattern in una sottosezione (diversa) del file path di dimensione pari a 1/n della taglia totale del file.
Il processo padre dovrà attendere la terminazione di tutti i figli e restituire il numero totale di occorrenze del
pattern all’interno dell’intero file.
 */

#include <ourhdr.h>
int count = 0;


void worker(int fp, char *pattern, int inizio, int fine){
	char buffer[14];
	if (read(fp, &buffer, sizeof(buffer)) < 0) err_sys("Read failed");
	printf("Buffer: %s", buffer);
	if (strstr(buffer, pattern)) count++;
}



int main(int argc, char **argv) {
	if (argc < 4) err_sys("Not enough arguments");
	char *pattern = argv[1];
	char *path = argv[2];
	int n = atoi(argv[3]);
	int pid[n];

	struct stat statbuf;

	if (stat(path, &statbuf) == -1) err_sys("Stat failed");
	int fullsize = statbuf.st_size;
	int sizePerProcess = fullsize / n;
	for (int i = 0; i < n; i++){
		if ((pid[i] = fork()) < 0) err_sys("Fork %d failed", i);
		if (pid[i] == 0){
			//Sono nei figli
			int fp;
			if ((fp = open(path, O_RDONLY)) < 0) err_sys("Open failed");
			int inizio = sizePerProcess * i;
			int fine = sizePerProcess * (i+1);
			worker(fp, pattern, inizio, fine);
			exit(1);
		}
	}

	for ( int i = 0; i < n; i++){
		wait(NULL);
	}

	printf("Occorrenze di %s: %d\n",pattern, count);
	return EXIT_SUCCESS;
}
