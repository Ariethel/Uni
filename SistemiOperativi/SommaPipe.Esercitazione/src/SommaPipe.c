/*
 Fare una somma utilizzando le pipe
 */

#include <ourhdr.h>

int main(void) {
	int pid;
	int fpPadre[2];
	int fpFiglio[2];
	if ((pipe(fpPadre)) < 0){
		err_sys("pipe failed");
	}

	if ((pipe(fpFiglio)) < 0){
			err_sys("pipe failed");
	}

	if ((pid = fork()) < 0)
		err_sys("Fork failed\n");
	if (pid == 0){
		// Sono nel figlio
		close(fpPadre[WRITE_END]);
		close(fpFiglio[READ_END]);
		int sum = 0;
		for (int i = 0; i < 5; i++){
			int ciph;
			if (read(fpPadre[READ_END], &ciph, sizeof(int)) < 0)
				err_sys("read failed");
			sum += ciph;
		}

		if (write(fpFiglio[WRITE_END],&sum, sizeof(int)) < 0)
			err_sys("Write failed on child");
		exit(0);

	}else{
		// Sono nel padre
		close(fpPadre[READ_END]);
		close(fpFiglio[WRITE_END]);
		int array[5] = {1,2,3,4,5};
		for (int i = 0; i < 5; i++){
			write(fpPadre[WRITE_END],"%d",array[i]);
		}
		int sum;
		if (read(fpFiglio[READ_END], &sum, sizeof(int)) < 0){
			err_sys("Read failed in father");
		}

		//wait(NULL);
		printf("SOMMA : %d\n", sum);

	}
	return EXIT_SUCCESS;
}
