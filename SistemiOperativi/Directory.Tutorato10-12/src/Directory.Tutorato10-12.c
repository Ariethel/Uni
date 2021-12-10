/*
Scrivere un programma C che, data in input una path da riga di comando, stampi il nome
e la dimensione del più grande file presente nella directory passata ed in tutto il suo sottoalbero*/



#include <ourhdr.h>
#include <dirent.h>

struct valoriRitorno{
	char nome;
	int size;
};

struct valoriRitorno *vr = NULL;

void greater(char *path){
	DIR *dir;
	char buffer[256];

	if ((dir = opendir(path)) == NULL)
		err_sys("Impossibile aprire la directory");

	struct dirent *entry;
	struct stat *statbuf;
	while((entry = readdir(path)) != NULL){
		switch(entry->d_type){
		case DT_REG:
			char filename = strcat("//",entry -> d_name);
			stat(strcat(path,filename),statbuf);
			if (statbuf -> st_size > vr -> size){
				vr -> size = statbuf -> st_size;
				vr -> nome = entry -> d_name;
			}
			break;
		case DT_DIR:
			if (strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, ".."))
				continue;
			sprintf(buffer, "%s/%s",path,entry->d_name);
			greater(buffer);
			break;
		default:
			continue;
		}
	}
}

int main(int argc, char *argv[]){
	if (argc < 2 )
		err_sys("Servono piu' argomenti");


	vr -> size = 0;
	greater(argv[1]);

	printf("Nome: %s, Taglia: %d\n",vr -> nome, vr -> size);
	return 0;
}
