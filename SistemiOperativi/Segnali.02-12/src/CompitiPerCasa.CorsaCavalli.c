/*Scrivere un programma C che genera 10 sotto processi.
Ogni figlio attende il segnale SIGUSR1 ed alla ricezione del segnale
incrementa il proprio contatore.
Quando il contatore raggiunge il valore 100, il processo termina.
Il padre ogni 100 msec invia il segnale SIGUSR1 ad uno dei figli scelti a caso.
Se un figlio termina, individua quale è terminato e uccide tutti gli altri
per poi terminare a sua volta.
*/
