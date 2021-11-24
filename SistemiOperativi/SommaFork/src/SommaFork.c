/*
 * Scrivere un programma che dato un array, lo divida in due e ne calcoli
 * la somma degli elementi tramite una pipe
*/

#include <ourhdr.h>

void worker(int fp, int *array, int dim){

	int somma = 0;

	for(int i = 0; i < dim; i++){
		printf("Interi sommati nel figlio: %d\n",array[i]);
		somma += array[i];
	}

	if (write(fp, &somma, sizeof(int)) == -1)
		err_sys("Write failed");
	close(fp); //Chiudo la pipe in scrittura del figlio
}

int main(void) {
	int array[5] = {1,2,3,4,5};
	int fp[2];
	int pid;
	int dimArray = sizeof(array) / sizeof(int); //Calcolo la dimensione dell'array

	//Creo la pipe
	if (pipe(fp) == -1){
		err_sys("pipe failed");
	}

	//Creo il figlio
	if ((pid = fork()) == -1)
		err_sys("Fork Failed");
	if (pid == 0){
		close(fp[READ_END]); //Chiudo la pipe in lettura del figlio

		worker(fp[WRITE_END],array,dimArray/2);
		exit(1);
	}

	int somma;
	close(fp[WRITE_END]); //Chiudo la pipe in scrittura del padre
	if (read(fp[READ_END],&somma, sizeof(int)) == -1) //Leggo dalla pipe dove ha scritto il figlio
		err_sys("read failed");

	close(fp[READ_END]); //Chiudo la pipe in lettura del padre

	for (int i = (dimArray/2); i < dimArray ; i++){
		printf("Interi sommati nel padre: %d\n",array[i]);
		somma+=array[i];
	}


	wait(NULL);
	printf("La somma e': %d",somma);



	return EXIT_SUCCESS;
}
