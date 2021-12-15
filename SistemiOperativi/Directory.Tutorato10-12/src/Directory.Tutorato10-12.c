/*
Scrivere un programma C che, data in input una path da riga di comando, stampi il nome
e la dimensione del più grande file presente nella directory ed in tutto il suo sottoalbero*/



#include <ourhdr.h>
#include <dirent.h>

struct valoriRitorno{
	char nome[256];
	int size;
};

//Filtro per la scandir che restituisce uno soltanto se vede file regolari o directory
int filter(const struct dirent *dir){
	if (dir->d_type == DT_DIR || dir->d_type == DT_REG)
		if (strcmp(dir->d_name,".") != 0 && strcmp(dir->d_name,"..") != 0)
		return 1;
	return 0;
}

struct valoriRitorno greater(char *path){
	struct dirent **array;
	struct valoriRitorno vr, tmp; //Risultato finale
	struct stat statbuf; //Struttura necessaria per la syscall stat
	char fullpath[PATH_MAX];
	vr.size = -1;
	int n,i;


	n = scandir(path, &array, filter, NULL);

	for (i = 0; i < n; i++){
		sprintf(fullpath, "%s/%s",path,array[i]->d_name);
		if (array[i]->d_type == DT_REG){
			if (stat(fullpath, &statbuf) < 0){
				err_sys("stat failed");
			}
			if (statbuf.st_size > vr.size){
				vr.size = statbuf.st_size;
				sprintf(vr.nome, "%s",array[i]->d_name);
			}
		}
		else if (array[i]->d_type == DT_DIR){
			tmp = greater(fullpath);
			if (tmp.size > vr.size){
				vr.size = tmp.size;
				sprintf(vr.nome, "%s",tmp.nome);
			}

		}
	}

	free(array);
	return vr;
}

int main(int argc, char *argv[]){
	if (argc < 2 )
		err_sys("Servono piu' argomenti");

	struct valoriRitorno result;

	result = greater(argv[1]);

	printf("Nome: %s, Taglia: %d\n",result.nome, result.size);
	return 0;
}
