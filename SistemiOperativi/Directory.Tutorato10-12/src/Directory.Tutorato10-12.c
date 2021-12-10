/*
Scrivere un programma C che, data in input una path da riga di comando, stampi il nome
e la dimensione del più grande file presente nella directory passata ed in tutto il suo sottoalbero*/



#include <ourhdr.h>

struct valoriRitorno{
	char nome[256];
	int size;
};

struct valoriRitorno
int void (int argc, char *argv[]){
	if (argc < 2 )
		err_sys("Servono piu' argomenti");

	greater();
	return 0;
}
