# Tipi e variabili

Ogni ==valore== ha un *tipo*, un esempio di dichiarazione di variabile puo' essere

```java
String greeting = "Hello, World!"; 
PrintStream printer = System.out; 
int luckyNumber = 13;
```

le ==variabili== memorizzano valori e possono essere utilizzate per riferirsi ad oggetti

---
## Identificatori

Possono essere una variabile, un metodo o una classe. Per convenzione

###
- I nomi delle variabili cominciano per lettera minuscola
- I nomi delle classi cominciano per lettera maiuscola
- Nomi composti usano maiuscola ad ogni inizio nuova parola

---
## Oggetto

Entita' di un programma dotata di tre caratteristiche

###
- Stato
- Comportamento
- Identita'

Lo *Stato* e' rappresentato dalle informazioni conservate nelle ==variabili di istanza== dell'oggetto, puo' variare nel tempo per mezzo di operazioni.

Il *Comportamento* viene definito dai ==metodi== che possono essere eseguiti sull'oggetto. I metodi possono cambiare lo stato.

---
## Overloading dei metodi
I metodi sono individuati dalla frima e non solo dal nome. La possibilita' di avere una classe che definisca metodi differenti con lo stesso nome si chiama ==overloading==

---
## Tipi primitivi

Sono 8 e cisascuno di essi e' pensato per rappresentare un certo tipo di informazione 

###
- byte
- int
- long
- float
- double
- boolean
- char

Questi servono a creare variabili ==atomiche==, se si volesse invece creare un *Oggetto*, ad esempio, di tipo int per poi definirvi dei metodi basterebbe sostiture la prima lettera con la maiuscola

```java
int a; //Variabile intera
Integer a; //Oggetto di tipo intero
```

