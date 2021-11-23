/*
 * Scrivere un programma C che scrive in un file 100000 interi randomici.
 * Successivamente crea 4 figli. Ogni figlio processera' l'intero file e, tramite una pipe, indichera' al padre la posizione di ogni intero multiplo
 * rispettivamente di: 991, 1117, 2221, 3323.
 * Il padre una volta terminati tutti i figli stampera' tutti i risultati ricevuti. Si suggerisce di utilizzare pipe2 con il flag O_NONBLOCK*/

#include <ourhdr.h>
#include <errno.h>

#define FILE_NAME "file.txt"
#define NPROC 4

void closePipes (int n, int pipes[][2]){
	int k ;

	for(k = 0; k <= NPROC; k++){
		if (k == n){
			// chiude solo l'estremità in lettura
			close(pipes[k][READ_END]);
		}

		else{
			// altrimenti le chiude entrambe
			close(pipes[k][READ_END]);
			close(pipes[k][WRITE_END]);
		}

	}
}

int worker(int id, int pipes[][2],int mul){
	closePipes(id,pipes); //Chiudo la pipe non utsata
	int fp =open(FILE_NAME,O_RDONLY,0664);
	int num;
	off_t off;
	while((read(fp,&num,sizeof(int)))>0)
	if((num%mul)==0){ //se il numero e' multiplo
		off=lseek(fp,0l,SEEK_CUR)-sizeof(int); //salvo la posizione facendo: posizione corrente meno la dimensione dell'intero letto
		write(pipes[id][WRITE_END],&off,sizeof(off_t)); //Scrivo l'offset nella pipe
	}
	close(fp);
	close(pipes[id][WRITE_END]);
	exit(1);
}

int main(void){
	srand(time(NULL)); //Mi serve per generare i numeri random
	int fp = open(FILE_NAME, O_CREAT | O_WRONLY | O_TRUNC ,0664); //Creo il file o leggo il file
	if(fp <0){ //Controllo validita' del file
		err_sys("Open Failed");
		return -1;
	}


	int num;
	for (int i=0; i<100; i++){
		num=rand()%100;
		write(fp,&num,sizeof(num)); //Scrivo il numero generato nel file
	}
	close(fp);

	int mul[NPROC]={2, 3, 5, 7};
	int pipes[NPROC][2];
	int pid[NPROC];
	for(int i=0;i<NPROC;i++){
		pipe2(pipes[i],O_NONBLOCK); //Creo la pipe
		pid[i]=fork();
		if(pid[i]==0)	//Sono nel figlio
			worker(i,pipes,mul[i]);
		else if(pid[i] < 0)
			err_sys("Fork Error");
		close(pipes[i][WRITE_END]); //Chiudo la pipe
	}

	int rd;
	int cnt = NPROC;
	off_t off;
	while(cnt>0){
		for(int i=0;i<NPROC;i++){
			if( (pid[i]!=0) && ((rd=read(pipes[i][READ_END],&off,sizeof(off_t)))>0) )
				write(STDOUT_FILENO,&off,sizeof(off_t));
			else if (rd == 0){
				cnt--;
				pid[i]=0;
			}
			else if((errno != EWOULDBLOCK) || (errno != EAGAIN))
					err_sys("Read Failed\n");
		}
		usleep(1000);
	}
	for(int i=0;i<NPROC;i++)
		close(pipes[i][READ_END]);
	return 0;
}
