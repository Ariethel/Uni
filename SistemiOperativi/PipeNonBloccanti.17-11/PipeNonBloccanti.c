/*
 * Scrivere un programma C che scrive in un file 100000 interi randomici.
 * Successivamente crea 4 figli. Ogni figlio processera' l'intero file e, tramite una pipe, indichera' al padre la posizione di ogni intero multiplo
 * rispettivamente di: 991, 1117, 2221, 3323.
 * Il padre una volta terminati tutti i figli stampera' tutti i risultati ricevuti. Si suggerisce di utilizzare pipe2 con il flag O_NONBLOCK*/

#include <ourhdr.h>
#include <errno.h>

#define FILE_NAME "file.txt"

#define READ 0

#define WRITE 1

#define NPROC 4

void closePipes (int n, int pipes[][2]){
	int k ;

	for(k = 0; k <= NPROC; k++)
	{
		if (k == n)
		{
			// chiude solo l'estremità in lettura
			close(pipes[k][READ_END]);
		}

		else
		{
			// altrimenti le chiude entrambe
			close(pipes[k][READ_END]);
			close(pipes[k][WRITE_END]);
		}

	}
}

int worker(int id, int pipes[][2],int mul)
{
	closePipes(id,pipes);
	int f=open(FILE_NAME,O_RDONLY,0664);
	int num;
	off_t off;
	while((read(f,&num,sizeof(int)))>0)
	if((num%mul)==0)
	{
		off=lseek(f,0l,SEEK_CUR)-sizeof(int);
		write(pipes[id][WRITE],&off,sizeof(off_t));
	}
	close(f);
	close(pipes[id][WRITE]);
	exit(1);
}

int main(void)
{
	srand(time(NULL));
	int f = open(FILE_NAME, O_CREAT | O_WRONLY | O_TRUNC ,0664);
	if(f<0)
	{
		err_sys("Open Failed");
		return -1;
	}
	int num;
	for (int i=0; i<100; i++)
	{
			num=rand()%100;
			write(f,&num,sizeof(num));
	}
	close(f);

	int mul[NPROC]={2, 3, 5, 7};
	int p[NPROC][2];
	int pid[NPROC];
	for(int i=0;i<NPROC;i++)
	{
		pipe2(p[i],O_NONBLOCK);
		pid[i]=fork();
		if(pid[i]==0)	worker(i,p,mul[i]);
		else if(pid[i] < 0) 	err_sys("Fork Error");
		close(p[i][WRITE]);
	}

	int rd;
	int cnt = NPROC;
	off_t off;
	while(cnt>0)
	{
		for(int i=0;i<NPROC;i++)
		{
			if( (pid[i]!=0) && ((rd=read(p[i][READ],&off,sizeof(off_t)))>0) )
				write(STDOUT_FILENO,&off,sizeof(off_t));
			else if (rd == 0) //
			{
				cnt--;
				pid[i]=0;
			}
			else if((errno != EWOULDBLOCK) || (errno != EAGAIN))
					err_sys("Read Failed\n");
		}
		usleep(1000);
	}
	for(int i=0;i<NPROC;i++)
		close(p[i][READ]);
	return 0;
}
