## Dichiarare un array in Java

La sintassi per la dichiarazione di una variabile di tipo array è la seguente:

```java
Tipo[] nome;
```

nella quale si deve osservare l’uso delle parentesi quadre ‘`[]`‘ tra il tipo ed il nome della variabile (anche se la documentazione riporta sempre questa forma della dichiarazione è ammissibile anche postporre le parentesi quadre dopo l’identificatore:

```java
Tipo nome[];
```

Copy

`Tipo` può essere sia un tipo primitivo di java, sia il nome di una classe.

### Allocare l’array

Per default le variabili di tipo array sono inizializzate con il valore `null`. Quindi, prima di poterle usare, dovremo inizializzarle allocando per esse la memoria per mezzo della consueta keyword ‘new’:

```java
nome = new Tipo[n];
```

## Usare gli array

Una volta creato l’array, possiamo **accedere ai singoli elementi** indicandone la posizione (detta _indice_) all’interno contenitore, grazie all’operatore ‘`[]`‘ (parentesi quadre). Ad esempio:

```java
nome[3]; // indica il quarto elemento della collezione
```

Bisogna ricordare che gli elementi sono numerati _a partire da zero_, quindi `nome[0]` farà riferimento al primo elemento, `nome[1]` al secondo e così via fino all’ultimo indicato da `nome[lunghezza-1]`.

Come detto sopra la lunghezza di un array è fissata in fase di creazione e si può in qualsiasi momento accedere al suo valore utilizzando la proprietà **length** che è presente in ogni array java con la sintassi: `nome.length`.

Gli array sono spesso utilizzati per mantenere informazioni statiche all’interno di un programma

## java.util.Arrays

Gli array sono un costrutto classico di praticamente ogni linguaggio di programmazione e, nonostante il limite notevole di non poter cambiare dimensione (size) dopo la creazione (e qualche complicanza sintattica degli array multidimensionali), il loro utilizzo è estremamente comune in molti ambiti. Perciò Java mette a disposizione la classe **java.util.Arrays** con numerosi algoritmi per operare sugli array:

-   ricerca;
-   sorting (ordinamento);
-   copia;

e altri strumenti per la manipolazione, tutti sotto forma di metodi statici.