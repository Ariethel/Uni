/*
Scrivere un programma C che a partire dalla root del file system (/) visiti ricorsivamente tutto il sottoalbero (il
root file system senza però cambiare device se ci sono altri file system montati) stampando tutti i nomi e le
dimensioni dei "plain file" di dimensioni superiori a 1 MB.
 */

#include <ourhdr.h>
#include <dirent.h>

void visita_ricorsiva(char *path){
	DIR *dir;
	char buffer[256];
	if ((dir = opendir(path)) == NULL) err_sys("Could not open directory");
	struct stat *statbuf;
	struct dirent *entry;
	while ((entry = readdir(path)) != NULL){
		switch(entry->d_type){
		case DT_REG:
			printf("%s -> %s\n", path, entry->d_name);
			stat(entry, statbuf);
			if (statbuf->st_size >= (1024 * 1000))
				printf("%s -> %s\n", path, entry->d_name);
			break;
		case DT_DIR:
			if (strcmp(entry -> d_name,'.') == 0 || strcmp(entry -> d_name,"..") == 0)
				continue;
			sprintf(buffer, "%s/%s", path, entry -> d_name);
			visita_ricorsiva(buffer);
			break;
		default:
			break;
		}
	}

}


int main(void) {
	char path[256] = "/";
	visita_ricorsiva(path);
	return EXIT_SUCCESS;
}
