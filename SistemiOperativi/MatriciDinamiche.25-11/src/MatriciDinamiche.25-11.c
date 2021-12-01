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

int **allocMatrix(int size){ //Uso la calloc perche' alloca in zone contigue
	int i, **m;
	m = calloc(size,sizeof(int *)); //In questo momento m e' un array monodimensionale

	for (int i = 0; i < size; i++){
		m[i] = calloc(size,sizeof(int)); //Alloco size colonne per ogni riga
	}

	return m;
}

void initializeMatrix(int **matrix,int size){
	for (int i = 0; i < size; i++){
		for (int j = 0; j < size; j++){
			matrix[i][j] = random() % 21 - 10;
		}
	}
}

void printMatrix(int **matrix,int size){
	for(int i = 0; i < size; i++){
		for (int j = 0; j < size; j++){
			printf("%3d",matrix[i][j]);
		}
		printf("\n");
	}

	printf("----------------------------------------------------\n\n");
}


int main(int argc,int *argv[]) {
	long TotalSize,NumOps;
	int MatrixSize;
	int TotalSizeMb;
	int n;
	if (argc != 3) //Controllo che ci siano abbastanza parametri nella riga di coamando (memoria e n operazioni)
		err_sys("Not enough arguments");


	//Lettura parametri
	TotalSizeMb = atoi(argv[1]); //Converto in int
	TotalSize = TotalSizeMb * 1024 * 1024; //Converto in byte
	NumOps = atol(argv[2]); //Converto in long
	MatrixSize = TotalSize/(3*4); //Moltiplico per 4 poiche' ogni int e' 4 byte
	n = (int) sqrt(MatrixSize); //Numero di colonne/righe di ogni matrice (quadrata)


	//Allocazione ed inizializzazione di A,B e C
	//int A[n][n], B[n][n], C[n][n]; Funziona ma il prof e' stronzo e non si puo' fare
	int **a,**b,**c;
	a = allocMatrix(n);
	b = allocMatrix(n);
	c = allocMatrix(n);

	initializeMatrix(a,n);
	initializeMatrix(b,n);
	initializeMatrix(c,n);

	//Stampo le matrici (ne stampo solo 10 elementi per praticita')
	printMatrix(a,10);
	printMatrix(b,10);
	printMatrix(c,10);


	//Effettuo NumOps operazioni
	long i;
	int elem1,elem2,elem3;
	char point = '.';
	startCounting();
	for (i = 0; i < NumOps; i++){
		//esegui operazione i-esima
		elem1 = a[random()%n][random()%n];
		elem2 = b[random()%n][random()%n];
		elem3 = elem1 * elem2;
		c[random()%n][random()%n] += elem3;
		if (i % 100000 == 0)
			write(STDOUT_FILENO,&point,sizeof(char));
	}
	stopCounting();
	printf("\nNumero operazioni al secondo %.2f",NumOps/getRealTime());

	printResourceUsage(RUSAGE_SELF);

	return EXIT_SUCCESS;
}
