/*
* Scrivere un programma C che prende su linea di comando
* un cammino (PATH) di una directory esistente e stampa in output
* tutte le direntry presenti nella directory
*
*
* TRACCIA 2
* Scrivere un programma C che prende su linea di comando
* una path e stampa tutti le direntries contenute nella directory
* e nelle sottodirectories




* TRACCIA 3
* Scrivere un programma C che prende su linea di comando una path e
* restituisce il cammino piu lungo visitando tutte le sottodirectory di
* PATH
*/

#include <ourhdr.h>
#include <dirent.h>

int visitaRicorsiva(char *path){
	DIR *dir;

	if ((dir = opendir(path)) == NULL)
		err_sys("Failed opening %s",path);

	struct dirent *entry;

	while((entry = readdir(dir)) != NULL){
		switch(entry->d_type){
		case DT_REG:


		}

	}
}




int main(int argc, char *argv[]) {
	DIR *dir;
	if ((dir = opendir(argv[1])) == NULL)
		err_sys("error opening dir %s",argv[1]);


	struct dirent *entry;
	while ((entry = readdir(dir)) != NULL){
		printf("file: %s -> type: %d\n",entry->d_name,entry->d_type);
	}


	//FINE PRIMA TRACCIA



	//INIZIO SECONDA TRACCIA


	closedir(dir);
	return EXIT_SUCCESS;
}
