/*
 Fare una somma utilizzando le pipe
 */

#include <ourhdr.h>


int main(void) {
	int pid;
	int pipePadre[2];
	int pipeFiglio[2];

	if (pipe(pipePadre) < 0){
		err_sys("pipe failed");
	}

	if (pipe(pipeFiglio) < 0){
		err_sys("pipe failed");
	}

	if ((pid = fork()) == -1)
		err_sys("Fork failed\n");
	if (pid == 0){
		// Sono nel figlio
		close(pipePadre[WRITE_END]);
		close(pipeFiglio[READ_END]);
		int sum = 0;
		for (int i = 0; i < 5; i++){
			int ciph;
			if (read(pipePadre[READ_END], &ciph, sizeof(int)) < 0)
				err_sys("read failed");
			printf("cifra letta: %d\n", ciph);
			sum += ciph;
		}

		if (write(pipeFiglio[WRITE_END],&sum, sizeof(int)) < 0)
			err_sys("Write failed on child");

		close(pipePadre[READ_END]);
		close(pipeFiglio[WRITE_END]);
		exit(0);

	}
	// Sono nel padre
	close(pipePadre[READ_END]);
	close(pipeFiglio[WRITE_END]);
	int buf;
	for (int i = 0; i < 5; i++){
		scanf("%d", &buf);
		write(pipePadre[WRITE_END],&buf,sizeof(int));
	}
	int sum;
	if (read(pipeFiglio[READ_END], &sum, sizeof(int)) < 0){
		err_sys("Read failed in father");
	}


	wait(NULL);
	close(pipePadre[WRITE_END]);
	close(pipeFiglio[READ_END]);
	printf("SOMMA : %d\n", sum);
	return EXIT_SUCCESS;
}
