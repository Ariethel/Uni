/*Scrivere un array di N interi in una fifo
Riceverla in un secondo programma, calcolarne la somma ed inviarla al primo programma
*/

#include <ourhdr.h>
#define N 10


int main(){

    srand(time(NULL));
    mkfifo("sum",0777);
    int fp;

    int array[N];

    //Genero array di numeri random
    for(int i = 0; i < N; i++){
        array[i] = rand() % 10;
        printf("Generato: %d\n",array[i]);
    }

    //Apro la FIFO
    if (fp = open("sum",O_WRONLY) < 0 ){
        err_sys("Failed opening the FIFO\n");
    }

    //Scrivo sulla FIFO
    for (int i = 0; i < N; i++){
        if (write(fp,&array[i],sizeof(int)) == -1){
            err_sys("write failed");
        }
        printf("Scritto: %d\n",array[i]);
    }
    
    close(fp);//Chiudo la FIFO in scrittura


    //Apro la FIFO in lettura
    if (fp = open("sum",O_RDONLY | O_TRUNC) == -1)
        err_sys("open failed");

    int sum = 0;


    //Leggo la somma
    if (read(fp,&sum,sizeof(int)) == -1){
        err_sys("read failed");
    }

    close(fp); //Chiudo la FIFO in lettura
    printf("La somma ricevuta dal main 1: %d\n",sum);

}