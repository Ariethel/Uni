#include <ourhdr.h>
#include <string.h>



char *cancella_vocali(char *buf,int dimBuf){
	char result[dimBuf];
	int c = 0;
	for (int i = 0; i < dimBuf; i++){
		if (buf[i] == 'a' || buf[i] == 'e' || buf[i] == 'i' || buf[i] == 'o' || buf[i] == 'u')
			continue;
		else{
			result[c] = buf[i];
			c++;
		}
	}
	return result;
}

void worker(int rdp,int wrp){
	printf("Sono nel figlio");
	int rd;
	char buf[1000];
	while((rd = read(rdp,buf,sizeof(buf))) > 0){

	}if (rd < 0)
		err_sys("read failed in child");

	printf("%s\n",buf);
	exit(1);
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
	}


	//apro il file
	int fd;
	if ((fd = open("testo.txt",O_RDONLY)) < 0)
		err_sys("Open Failed");
	else
		printf("File opened");


	//leggo riga per riga
	char *line;
	size_t bufsize = 32;
	size_t characters;

	line = (char *)malloc(bufsize * sizeof(char));
	if( line == NULL){
		err_sys("Unable to allocate buffer");
		exit(1);
	}

	int rd;
	char result[1000];
	while((rd = getline(&line,&bufsize,fd)) > 0){
		if (write(pipes[0][WRITE_END],line,strlen(line)) < 0)
			err_sys("write failed in father");

		if (read(pipes[1][READ_END],result,sizeof(result)) < 0)
				err_sys("read failed in father");
		else
			printf("La stringa ricevuta dal padre e' %s\n",result);


	}if (rd < 0)
		err_sys("read failed");

	//aspetto termini il figlio
	waitpid(pid,NULL,0);

	return EXIT_SUCCESS;
}
