/*
 ============================================================================
 Name        : CountProgram.c
 Author      : Roberto Della Rocca
 Version     :
 Copyright   : Your copyright notice
 Description : Questo programma conta fino a sizeTot. L'esecuzione di questo programma puo' essere di tre tipi:
 	 	 	   sequeziale, concorrente o in parallelo. Per sequenziale e in parallelo verranno creati N_PROC_THREAD
 	 	 	   processi/thread. Alla fine del job verra' restituito le risorse e i tempi di esecuzione per ogni
 	 	 	   tipo di esecuzione. La funzione di questo programma e' confrontare i dati ottenuti in ogni approccio.
 ============================================================================
 */

/*
 * DESCRIZIONE MACCHINA TEST -> Macbook Air M1 (8 Core CPU , 7 Core GPU) - 16GB RAM (memoria unificata per essere precisi)
 * 								Test su Macchina Virtuale UTM su Ubuntu Server 21.10 ARM
 * 								Macchina Virtual con 4 Core - 8GB RAM
 *
 * TABELLA RISULTATI (elapsed time)
 *
 * SEQUENZIALE -> 59.227 s
 *
 * CONCORRENTE
 * 		4 PROCESSI  -> 17.357 s
 * 		8 PROCESSI  -> 16.563 s
 * 		16 PROCESSI -> 16.557 s
 *
 * PARALLELO
 * 		4 THREADS  -> 15.883 s
 * 		8 THREADS  -> 15.779 s
 * 		16 THREADS -> 15.982 s
 *
 * */


#include <ourhdr.h>
#include <pthread.h>

#define N_PROC_THREAD 4 //costante che definisce il numero di processi/thread da creare e utilizzare

//struttura per passaggio di paramentri per i threads
typedef struct param {
	int tid; //id del thread
	long da;
	long a;
}Params;

void *count (void *params); //worker del thread(esegue le stesse operazioni di conta)
void conta(int pid, long da, long a); //funzione che conta <da> a <a>
void sequentialProgram(int sizeTot, int sizeWorker); //funzione che esegue il programma in modo sequenziale
void concurrentProgram(int sizeTot, int sizeWorker); //funzione che esegue il programma in modo concorrente
void parallelProgram(int sizeTot, int sizeWorker); //funzione che esegue il programma in parallelo

int main(void) {

	long sizeTot = 1000000000; //numero che finale che dobbiamo arrivare
	long sizeWorker = sizeTot / N_PROC_THREAD; //divisione dei conteggi per N_PROC_THREAD processi/thread
	int choose = 0;

	do {
		printf("Come vuoi eseguire il programma?\n1. Sequenziale\n2. Concorrente (Processi)\n3. Parallelo (Threads)\n--> ");
		scanf("%d", &choose);
		if (choose < 1 || choose > 3)
			printf("Scegli di nuovo!\n");
	}while(choose < 1 || choose > 3);

	switch(choose) {
		case 1:
			sequentialProgram(sizeTot, sizeWorker);
			break;
		case 2:
			concurrentProgram(sizeTot, sizeWorker);
			break;
		case 3:
			parallelProgram(sizeTot, sizeWorker);
			break;
	}

}


void *count (void *params) {

	Params *p = (Params *) params;
	char buf[30];
	long i;

	for (i = p->da; i < p->a; i++) {
		sprintf(buf, "(id: %d->%ld)\n", p->tid, i);

		if(i % 10000000 == 0) {
			buf[0] = '.';
			buf[1] = '\0';
			if(write(STDOUT_FILENO, buf, strlen(buf))<0) //send a message to another user
					err_sys("Write Failed");
		}
	}

	pthread_exit(0);


}

void conta(int pid, long da, long a) {

	char buf[30];
	long i;

	for(i = da; i < a; i++) {
		sprintf(buf, "(id: %d->%ld)\n", pid, i);

		if(i % 10000000 == 0) {
			buf[0] = '.';
			buf[1] = '\0';
			if(write(STDOUT_FILENO, buf, strlen(buf))<0) //send a message to another user
					err_sys("Write Failed");
		}
		//usleep((random()%100000)+1000); //systemcall uspend execution for microsecond intervals
	}

}


void sequentialProgram(int sizeTot, int sizeWorker) {

	startCounting();
	conta(0,1L,sizeTot);
	stopCounting();
	printResourceUsage(RUSAGE_SELF);

}

void concurrentProgram(int sizeTot, int sizeWorker) {

	int i;
	int pid;

	startCounting();

	for (i = 0; i < N_PROC_THREAD; i++) {
		if ((pid = fork()) < 0)
			err_sys("Error fork!");
		else if (pid == 0) {
			conta(getpid(), sizeWorker * i, sizeWorker * (i + 1));
			exit(1);
		}
	}

	for (i = 0; i < N_PROC_THREAD; i++) {
		if ((pid = wait(NULL)) < 0)
			err_sys("Father process must wait that all child finish their jobs");
		else
			printf("\nProcess %d terminated\n", pid);
	}

	stopCounting();
	printResourceUsage(RUSAGE_CHILDREN);

}

void parallelProgram(int sizeTot, int sizeWorker) {

	long i;
	pthread_t tids[N_PROC_THREAD]; //Threads che puntano al PCB del processo
	pthread_attr_t attr;

	Params tcb[N_PROC_THREAD];

	if (pthread_attr_init(&attr))
		err_sys("Thread attributes initialization failed");

	startCounting();

	for (i = 0; i < N_PROC_THREAD; i++) {
		tcb[i].tid = i;
		tcb[i].da = sizeWorker * i;
		tcb[i].a = sizeWorker * (i + 1);

		if (pthread_create(&tids[i], &attr, count, (void *) &tcb[i]) != 0)
			err_sys("Error thread creation");

	}

	for (i = 0; i < N_PROC_THREAD; i++) {
		if(pthread_join(tids[i], NULL) != 0)
			err_sys("Error joining thread");
		else
			printf("\nThread %ld terminated\n", i);
	}

	stopCounting();
	printResourceUsage(RUSAGE_SELF); //RUSAGE_THREAD non restituisce valori completi/corretti

}
