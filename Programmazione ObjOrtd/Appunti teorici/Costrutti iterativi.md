## while

Il **ciclo while** esegue una istruzione o un blocco di codice finché rimane verificata una certa condizione. In italiano diremmo: “fino a quando la condizione è vera esegui il blocco” ecco un esempio:

```java
while(condizione) {
	// ...
}
```

---
## do-while

il **ciclo do-while** è simile al `while` ma la prima volta esegue l'istruzione senza considerare alcuna condizione.

```java
do {
	// ...
} while(condizione);
```
---
## for

Il **ciclo for** è un costrutto tra i più conosciuti, comune praticamente a tutti i linguaggi e, pur servendo come i precedenti ad eseguire ripetutamente un blocco, fornisce una semplice sintassi per accomodare:
###
-   una espressione di inizializzazione eseguita solo una volta prima di iniziare il ciclo;
-   una espressione di ‘aggiornamento’ (tipicamente un incremento) da eseguire al termine di ogni esecuzione del blocco;
-   una condizione di terminazione (o uscita) dall’esecuzione iterativa.


```java
for(inizializzazione; condizione; incremento) {
	// ...
}
```
---
## for each

Una importante variante del ciclo `for` è quella che potremmo definire **for-each** (detta anche _for-in_) che serve nel caso particolare (ma comune) in cui si voglia eseguire un determinato blocco di codice per ogni elemento di una data collezione (o array).

Pur dovendo rimandare una completa descrizione di questa variante a quando parleremo di _Collection_ e _array_ possiamo comunque mostrarne la sintassi:

```java
for( Type item : itemCollection ) {
	// ...
}
```