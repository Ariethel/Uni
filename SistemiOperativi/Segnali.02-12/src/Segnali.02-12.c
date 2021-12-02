/*PARTE 1
 * Scrivere un programma C che con probabilita' 9/10 stampa un puntino. 1/10 invece stampa la 'o'. Questo ogni 400 msec.
 * Quando viene inviato il segnale ^C il programma controlla che l'ultimo carattere sia 'o', e nel caso aumentare di uno un contatore.
 * In ogni caso il programma riprende. Dopo 1000 caratteri il programma termina stampando il valore del contatore. Quando il programma riceve il segnale SIGHUP
 * termina.
 *
 *
 *PARTE 2
 * Scrivere un programma C che registra un handler dei segnali e che quando riceve un segnale ne stampa l'identificativo e poi riprende l'esecuzione
 *
 *
 *PARTE 3
 * Scrivere un programma C che processa un input e ad un intervallo random di 100-600ms stampa un carattere
 *
 * PART 4
 * Scrivere due funzioni accelera e decelera
 * */
#include <ourhdr.h>
#include <signal.h>

typedef void (*sighandler_t)(int); //Un puntatore ad una funzione che riceve un argomento int e restituisce void (man signal per informazioni)
sighandler_t vecchioHandler[32];
char carattereCorrente;
int cont = 0;
int totO = 0;
int intervallo;


void myHandler(int s){ //Serve solo a capire quale segnale ho inviato, ma non serve realmente
    printf("Ricevuto segnale n. %d\n",s);
}


void checkCurrentTargetHandler(int p){
    if(carattereCorrente == 'o'){
        cont++;
        printf("Colpito!\n");
    }else{
        printf("Mancato!\n");
    }
}

void stampaCarattere(){
    int p = 0;
     p = random()%10;
     if (p == 0){
         carattereCorrente = 'o';
         totO++;
     }else{
         carattereCorrente = '.';
     }

     if (write(STDOUT_FILENO, &carattereCorrente, sizeof(carattereCorrente)) < 0)
        err_sys("Write failed");
}

void accelera(int p){
    if (p == SIGUSR1)
        intervallo -= 50000;
}

void rallenta(int p){
    if (p == SIGUSR2)
        intervallo += 50000;
}

void termina(int p){
    printf("Numero totale di vincite %d su %d\n",cont,totO);
    exit(0);
}

int main(int argc, int *argv[]) {
	int i = 0;

	printf("Started on pid: %d\n",getpid());

    //Se l'intervallo viene specificato come parametro uso quello, altrimenti 400msec
    if (argc > 1){
        intervallo = atoi(argv[1]) * 1000;
    }else{
        intervallo = 400000;
    }


    if ((vecchioHandler[SIGINT] = signal(SIGINT, checkCurrentTargetHandler)) == SIG_ERR)
        err_sys("Error registering handler for SigInt");

    if ((vecchioHandler[SIGTERM] = signal(SIGTERM, termina)) == SIG_ERR)
        err_sys("Signal 15");


    char c = '.';
    while (i < 1000){
        stampaCarattere();

        usleep(intervallo);
        i++;
    }

    //Definire due handler che ad 1 associamo l'evento "accelera" e a 2 associamo l'evento "decelera"

    if (signal(SIGUSR1, accelera) == SIG_ERR)
        err_sys("Error registering handler for SigUsr1");

    if (signal(SIGUSR2, rallenta) == SIG_ERR)
        err_sys("Error registering handler for SigUsr2");
	return EXIT_SUCCESS;
}
