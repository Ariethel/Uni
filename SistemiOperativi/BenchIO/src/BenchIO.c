/*
 ============================================================================
 Name        : BenchIO.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : scrivere un programma C che legge dalla linea di comando la dimensione
 	 	 	   crea nella directory corrente un file di n byte e legge questo file
 	 	 	   per ogni operazione, I/O, stampa il tempo di esecuzione e il throughput in mb/sec
 ============================================================================
 */

#include <ourhdr.h>

#define FNAME "file.tmp" //nome file temporaneo
//#define blockSize 4096

int scrittura(int long dim, int blockSize) {

	/*
	 * Apro file FNAME
	 * scrivere almeno dim byte a blocchi di blockSize
	 * loop fin quando la variabile byteScritti e' < a dim, scrivo blockSize byte
	 * Chiudere il file
	 * */
	int fd; //file descriptor

	if ((fd = open(FNAME, O_WRONLY|O_CREAT|O_TRUNC, 0664)) < 0) {
		err_sys("open failed. Cannot open file %s for writing\n", FNAME);
	}

	int long byteScritti = 0;
	int wr;
	char buf[blockSize];

	while (byteScritti < dim) {
		if ((wr = write(fd, buf, blockSize)) < 0) {
			err_sys("write failed\n");
		}
		byteScritti += wr;
	}

	close(fd);

	return 0;
}

int lettura (int long dim, int blockSize) {

	int fd;

	if ((fd = open(FNAME, O_RDONLY)) < 0) {
		err_sys("open failed. Cannot open file %s for reading\n", FNAME);
	}

	int long byteLetti = 0;
	int rr;
	char buf[blockSize];

	while (byteLetti < dim) {
		if ((rr = read(fd, buf, blockSize)) < 0) {
			err_sys("read failed\n");
		}
		else if (rr == 0) {
			printf("EOF prematura. Dopo %ld byte\n", byteLetti);
			break;
		}
		byteLetti += rr;
	}

	close(fd);

	return 0;

}

int main(int argc, char *argv[]) {

	if (argc != 3) {
		printf("Errore nei parametri\n usage: %s dim\n", argv[0]);
		exit(-1);
	}

	int long dim = atol(argv[1]);
	int blockSize = atoi(argv[2]);
	double timeWriting, timeReading;

	// start cronometro (counting)
	startCounting();
	scrittura(dim, blockSize);
	// stop counting
	stopCounting();
	// print counters
	printResourceUsage();
	timeWriting = getRealTime();

	// start cronometro (counting)
	startCounting();
	lettura(dim, blockSize);
	// stop counting
	stopCounting();
	// print counters
	printResourceUsage();
	timeReading = getRealTime();

	//trasform dimension in mb from byte
	dim /= 1000000;

	printf("Tempo di scrittura = %f mb/sec\n", dim / timeWriting);
	printf("Tempo di lettura = %f mb/sec\n", dim / timeReading);


	return EXIT_SUCCESS;
}
