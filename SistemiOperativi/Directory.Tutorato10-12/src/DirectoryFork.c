//Fare quello che fa l'esercizio 1 ma passando un array di path e creare un figlio per ogni path
//questo dovra' cercare l'elemento maggiore ed alla fine il padre dovra' restituire solo quello maggiore tra tutti quelli restituiti dai figli

#include <ourhdr.h>

struct info{
	char name[256];
	int size;
};

int main(int argc, char *argv[]){

	if (argc < 2)
		err_sys("Servono piu' argomenti");

	struct info result;
	result.size = -1;




	return EXIT_SUCCESS;
}


