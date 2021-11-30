//Eseguire ls su una directory a piacere
#include <ourhdr.h>
char pathname[] = "/usr/bin/ls";

void worker(){
    char *args[]= {"ls","/usr/local/include",NULL};
    execv(pathname,args);
}

int main(int argc, char **argv){
    
}