#include <ourhdr.h>
#include <string.h>



void cancella_vocali(char *buf,char *result){
	int c = 0;
	for (int i = 0; i < strlen(buf); i++){
		if (buf[i] != 'a' && buf[i] != 'e' && buf[i] != 'i' && buf[i] != 'o' && buf[i] != 'u'){
			result[c] = buf[i];
			c++;
		}
	}
}

void worker(int rdp,int wrp){
	int rd;
	char buf[80];
	char result[80];
	while((rd = read(rdp,buf,sizeof(buf))) != -1){
		if (strcmp(buf,"%%%") == 0)
			exit(1);

		cancella_vocali(buf,result);


		if (write(wrp,result,strlen(result)) < 0)
			err_sys("write failed in child");


	}if (rd < 0)
		err_sys("read failed in child");

	printf("fine figlio\n");
	exit(0);
}

int main(){
	int pipes[2][2];
	int pid;

	//Creo le pipe
	for (int i = 0; i < 2; i++){
		if (pipe(pipes[i]) < 0)
			err_sys("Pipe %d failed",i);
		printf("Pipe %d created\n",i);
	}

	//Creo il figlio
	if ((pid = fork()) < 0)
		err_sys("fork failed");
	if (pid == 0){
		worker(pipes[0][READ_END],pipes[1][WRITE_END]);
	}else{
			//Apro il file
			FILE *fp = fopen("testo.txt", "r");
			if (fp != NULL)
				printf("File opened\n");

			fflush(stdout);

			//leggo riga per riga
			char *line = NULL;
			size_t bufsize = 0;

			size_t rd;
			char result[100];


			while((rd = getline(&line,&bufsize,fp)) != -1){

				if (write(pipes[0][WRITE_END],line,rd) < 0)
					err_sys("write failed in father");

				if (read(pipes[1][READ_END],result,sizeof(result)) < 0)
						err_sys("read failed in father");
				else
					printf("La stringa ricevuta dal padre e' %s\n",result);

			}

			char endOfFile = "%%%";
			if (write(pipes[0][WRITE_END],endOfFile,strlen(endOfFile)) < 0)
				err_sys("write failed");

			for (int i = 0; i < 2; i++){
				close(pipes[i][WRITE_END]);
				close(pipes[i][READ_END]);
			}

			//aspetto termini il figlio
			waitpid(pid,NULL,0);

			return EXIT_SUCCESS;
	}


}
