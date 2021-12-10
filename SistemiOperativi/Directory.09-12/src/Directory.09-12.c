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
int max_depth = 0;

void visitaRicorsiva(char *path){
	DIR *dir;
	char buffer[256];
	printf("\n");


	if ((dir = opendir(path)) == NULL)
		err_sys("Failed opening %s",path);

	struct dirent *entry;

	while((entry = readdir(dir)) != NULL){
		switch(entry->d_type){
		case DT_REG:
			printf("%s->%s\n",path,entry->d_name);
			break;
		case DT_DIR:
			if (strcmp(entry -> d_name,".") == 0 || strcmp(entry -> d_name,"..") == 0)
				continue;
			sprintf(buffer, "%s/%s",path,entry->d_name);
			visitaRicorsiva(buffer);
			break;
		default:
			printf("%s->%s (unknown file type)\n",path,entry->d_name);
		}

	}
	closedir(dir);
}





void visitaRicorsivaPrfondita(char *path, int depth){
	DIR *dir;
	char buffer[256];

	if (depth > max_depth)
		max_depth = depth;

	printf("\n");


	if ((dir = opendir(path)) == NULL)
		err_sys("Failed opening %s",path);

	struct dirent *entry;

	while((entry = readdir(dir)) != NULL){
		switch(entry->d_type){
		case DT_REG:
			printf("%s->%s\n",path,entry->d_name);
			break;
		case DT_DIR:
			if (strcmp(entry -> d_name,".") == 0 || strcmp(entry -> d_name,"..") == 0)
				continue;
			sprintf(buffer, "%s/%s",path,entry->d_name);
			visitaRicorsivaPrfondita(buffer,depth+1);
			break;
		default:
			printf("%s->%s (unknown file type)\n",path,entry->d_name);
		}

	}
	closedir(dir);
}




int main(int argc, char *argv[]) {
	DIR *dir;
	if ((dir = opendir(argv[1])) == NULL)
		err_sys("error opening dir %s",argv[1]);


	struct dirent *entry;
	while ((entry = readdir(dir)) != NULL){
		printf("file: %s -> type: %d\n",entry->d_name,entry->d_type);
	}




	//INIZIO SECONDA TRACCIA
	printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	visitaRicorsiva(argv[1]);


	//INIZIO TERZA TRACCIA
	printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	int depth = 0;
	visitaRicorsivaPrfondita(argv[1],depth);
	printf("Profondita' massima: %d\n",max_depth);

	closedir(dir);
	return EXIT_SUCCESS;
}
