#include <ourhdr.h>
#define N 10


int main(){
    int fp;
    //Apro la FIFO in lettura
    if (fp = open("sum",O_RDONLY) == -1){
        err_sys("Failed opening the FIFO\n");
    }

    int array[N];

    //Leggo gli interi nell'array N
    for (int i = 0; i < N; i++){
        if (read(fp,&array[i],sizeof(int)) == -1){
            err_sys("read failed");
        }
        printf("Letto: %d\n",array[i]);
    }
    

    close(fp); //Chiudo la FIFO in lettura

    //Calcolo la somma
    int sum = 0;
    for (int i = 0; i < N; i++){
        sum += array[i];
        printf("Sommato: %d\n",array[i]);
    }


    //Apro la FIFO in scrittura
    if (fp = open("sum",O_WRONLY | O_TRUNC) < 0 ){
        err_sys("Failed opening the FIFO\n");
    }
    //Scrivo la somma
    if (write(fp,&sum,sizeof(int)) == -1)
        err_sys("write failed");

    close(fp); //Chiudo la FIFO in scrittura
    printf("Somma inviata dal main 2: %d\n",sum);

}