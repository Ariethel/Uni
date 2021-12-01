/*
 Scrivere un programma C che legge dalla linea di comando la dimensione totale di memoria (TotalSize) da allocare
 attraverso 3 matrici quadrate (n * n => n = sqrt((TotalSize * 1024 * 1024)/ 3*4)))
 e un intero NumOps

 Una volta allocate le matrici, inizializzarle con valori a caso compresi tra -10 e 10

 Una volta allocate le 3 matrici, si effettuino NumOps operazioni. Ogni operazione consiste nel selezionare un elemento a caso
 dalla matrice A, uno a caso dalla matrice B, effettuare la moltiplicazione e assegnare il risultato ad un elemento della matrice C: C[i][j] += A[k][l] * B[m][o]

 Al termine il programma stampa il numero di operazioni al secondo TempoTotale/NumOps.
 */

#include <math.h>
#include <ourhdr.h>

int main(void) {
	int **alloc_matrix(){

	}

	return EXIT_SUCCESS;
}
