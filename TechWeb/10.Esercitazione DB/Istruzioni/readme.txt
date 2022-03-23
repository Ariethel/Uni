Si crei una nuova applicazione estendendo l'applicazione modelloMVC come segue:

1. crea un nuovo progetto modelloMVCdb
2. copia in esso tutte le cartelle e files di modelloMVC
3. controlla che l'esecuzione di modelloMVCdb si comporti allo stesso modo di modelloMVC

4. aggiungi il file ConPool.java (Allegato) alla cartella src/main/java/model

5. aggiungi al POM.xml nell'elemento <dependencies> il seguente elemento

<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jdbc</artifactId>
    <version>10.0.17</version>
</dependency>

6. con bottone destro su pom.xml selezionare Maven/Reload project ed attendere che tutti gli errori in ConPool.java vengano eliminati

7. sostituisci le classi ShowBalance.java, CustomerDAO.java e Customer.java  con le nuove classi in allegato.
8. istalla mysql da https://dev.mysql.com/downloads/mysql versione 8.0.28
   senza fare login o signup (in basso c'e' scritto No thanks, just start my download)
8.1 poni username: "root", password: "studentiTSW" 
8.2 istalla il workbench mysql da https://dev.mysql.com/downloads/workbench/ 
   Assicurarsi tramite il pannello di preferenze che il server mySQL sia attivo
9. crea un database con nome "modelloMVCdb"", (ricordare di di fare sempre l'Apply) 
	(o cambia i relativi dati in ConPool.java) e con tabella "customer" con quattro colonne: "id" : int, "firstName", "lastName" : varchar e "balance"": double 
	(o cambia i relativi dati nella nuova classe CustomerDAO)
	(ATTENZIONE: id deve avere marcati PK, NN, AI, cioè, Primary Key, Not Null, Auto Increment)
10. popola il database con i valori 
	(1,'Harry','Hacker', '-3456.78')
	(2,'Codie', 'Coder', '234.56')
	(3,'Polly', 'Programmer', '987654.32')
11. E' possibile usare il tab Database (tutto a destra in verticale) in IntelliJ per 
    visualizzare il database  modelloMVCdb all'interno di IntelliJ (cliccare +, scegliere 	
    MySQL, ed inserire nome del database, login e password)
12. elimina gli ultimi problemi (ad esempio, se nell'input si inserisce una stringa non numerica come id l'applicazione deve andare su una pagina di errore)

Quando l'applicazione si comporta esattamente come prima (ovvero la modelloMVC originale a meno degli id che ora sono interi e non stringhe):

13. aggiungere all'applicazione una pagina web che presenti un form 
che permetta di popolare il database usando la funzione doSave della nuova classe CustomerDAO

14. ricordarsi di fare stop del server MySQL alla fine dal pannello MySQL


