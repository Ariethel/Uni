## Definire un metodo in Java

La sintassi per la definizione di un metodo è molto simile a quella per la definizione di una variabile con la quale mutua peraltro numerose caratteristiche:

```java
[public|protected|private] [static] [final] Tipo
	identificatore([Tipo1 parametro1, Tipo2 parametro2, ..., TipoN parametroN])
	[throws Eccezione1, Eccezzione2, ...] {
		// blocco di codice appartenente al metodo
	return varTipo;
}
```
---
## I parametri

La sezione `[Tipo1 parametro1, ... TipoN parametroN]` è detto insieme dei **parametri (formali) del metodo** in cui si dichiara il tipo ed il nome simbolico delle variabili che il blocco di codice dovrà ricevere dal programma chiamante per poter svolgere il proprio compito.

Ad esempio, per scrivere un metodo che calcoli l’area di un parallelelogramma dovremo scrivere del codice che, noti i valori della lunghezza della base e dell’altezza esegua l’operazione `base * altezza`.

La dichiarazione:

```java
public double areaParallelogramma(double base, double altezza) {
	// ...
}
```
---
## Signature, la firma dei metodi

È importante notare che in Java un metodo è univocamente determinato (oltre che dalla classe a cui appartiene naturalmente) dal suo identificatore e dalla _lista dei tipi dei parametri_ che riceve in input. Tutto questo definisce la **signature del metodo** (la firma) il che significa che siamo liberi di ridefinire il medesimo metodo più volte a patto che ogni definizione abbia una lista di parametri diversa (tipi dei parametri, i nomi non contano, non conta nemmeno il tipo di ritorno).

In questo modo possiamo sovraccaricare un identificatore di metodo con diverse definizioni ed effettuare il cosiddetto **overloading**. Capita spesso quindi che un metodo abbia diversi _overload_.

Sarebbe quindi del tutto lecito definire, accanto al metodo che prende in input il valore della base e dell’altezza definire, ad esempio, un metodo areaParallelogramma che prenda in input le lunghezze di due lati incidenti e l’angolo tra di loro:

```java
public double areaParallelogramma(double c1, double c2, double alfa)
		throws IllegalArgumentException {
	if(c1 < 0)
		throw new IllegalArgumentException("c1 negativa");
	if(c2 < 0)
		throw new IllegalArgumentException("c2 negativa");
	if(c1 == 0.0 || c2 == 0.0)
		return 0.0;
	double a = c1 * c2 * Math.sin(alpha);
	return a;
}
```
---
  
di 134

# I Metodi in Java
## Cos’è un metodo

Tutti i linguaggi di programmazione forniscono la possibilità di definire, sotto un solo nome, interi gruppi di istruzioni o insiemi di linee di codice o blocchi di espressioni (statements), che dir si voglia. In questo modo possiamo riutilizzare un blocco di codice in molte parti del programma, semplicemente richiamando il nome con cui l’abbiamo definito, senza dover riscrivere tutto il blocco ogni volta.

Questi aggregati, a seconda del linguaggio, si chiamano funzioni, procedure, subroutines o sottoprogrammi. In Java utilizziamo la logica definita dai blocchi istruzioni per rappresentare il comportamento di classi di oggetti e questi blocchi di codice prendono il nome di **metodi**.

## Definire un metodo in Java

La sintassi per la definizione di un metodo è molto simile a quella per la definizione di una variabile con la quale mutua peraltro numerose caratteristiche:

```java
[public|protected|private] [static] [final] Tipo
	identificatore([Tipo1 parametro1, Tipo2 parametro2, ..., TipoN parametroN])
	[throws Eccezione1, Eccezzione2, ...] {
		// blocco di codice appartenente al metodo
	return varTipo;
}
```

Copy

Come di consuetidine tutte le parti tra parentesi quadre sono da considerarsi opzionali e, come vedremo tra poco lo statement **return** è opzionale nel caso in cui `Tipo` (il tipo di fronte all’identificatore) sia `void`.

Nella definizione di un metodo, l’`identificatore` è il nome assegnato al blocco di codice e che dovrà essere utilizzato per chiamare (eseguire) il metodo; sintatticamente si applicano esattamente le medesime considerazioni fatte per le variabili e come per esse vige la convenzione di far iniziare i nomi dei metodi con un carattere minuscolo e proseguire con il consueto _camelcase_.

## I parametri

La sezione `[Tipo1 parametro1, ... TipoN parametroN]` è detto insieme dei **parametri (formali) del metodo** in cui si dichiara il tipo ed il nome simbolico delle variabili che il blocco di codice dovrà ricevere dal programma chiamante per poter svolgere il proprio compito.

Ad esempio, per scrivere un metodo che calcoli l’area di un parallelelogramma dovremo scrivere del codice che, noti i valori della lunghezza della base e dell’altezza esegua l’operazione `base * altezza`.

La dichiarazione:

```java
public double areaParallelogramma(double base, double altezza) {
	// ...
}
```

Copy

ha lo scopo di avvertire il compilatore che nel corpo del metodo (tra le parentesi graffe come al solito) i nomi `base` e `altezza` fanno riferimento ai valori di tipo `double` che saranno passati al metodo quando lo utilizzeremo. Per inciso i valori che inseriamo al momento della chiamata del metodo sono detti _parametri attuali_.

Quindi possiamo scrivere il metodo in questo modo:

```java
public double areaParallelogramma(double base, double altezza) {
	double a = base * altezza;
	return a;
}
```

Copy

## Richiamare il metodo

Per chiamare il nostro metodo all’interno della classe in cui lo stiamo definendo (fuori dalla classe di definizione occorre una sintassi differente, che vedremo in seguito), sarà sufficiente scrivere qualcosa del genere:

```java
double areaCalcolata;
areaCalcolata = areaParallelogramma(7.0, 6.0);
```

Copy

Una volta eseguito questo codice la variabile `areaCalcolata` avrà valore `42.0`.

Possiamo pensare che la macchina virtuale durante l’esecuzione del codice della chiamata al metodo salti letteralmente all’inizio della dichiarazione del metodo, inizializzi le variabili (formali) `base` ed `altezza` con i valori (attuali) `7.0` e `6.0`, esegua quindi il corpo del metodo fino a quando non incontri la keyword `return` e a quel punto prenda il valore dell’argomento di return e lo utilizzi per assegnare il valore alla variabile `areaCalcolata`.

## Return e il valore di ritorno del metodo

Il valore specificato accanto a **return** deve essere del medesimo tipo specificato nella dichiarazione del metodo ma deve essere omesso se il metodo è stato dichiarato come `void`.

Traducibile come “vuoto” dichiarare un metodo `void` significa dire che il metodo non ritornerà alcun valore ed in tal caso la keyword `return` può essere anche omessa.

Lo statement **return** merita una certa attenzione anche perché, pur essendo strettamente legato ai metodi, potremmo accomunarlo a `break` e `continue` introdotti in precedenza. Infatti anche l’esecuzione del `return` provoca un salto nell’esecuzione, in questo caso _un salto fuori dal metodo_.

Questa caratteristica risulta più chiara se immaginiamo di voler modificare il calcolo dell’area in modo che il prodotto venga eseguito solo se i parametri sono diversi da 0:

```java
public double areaParallelogramma(double base, double altezza) {
	if(base == 0.0 || altezza == 0.0)
		return 0.0; // questo return causa l'uscita dal metodo
	double a = base * altezza;
	return a;
}
```

Copy

Se uno dei due parametri è 0, viene eseguito il primo `return` e il controllo passa al codice chiamante. Quindi il calcolo del prodotto viene effettuato solo nel caso in cui entrambi i parametri siano diversi da 0.

## Throws, sollevare o rilanciare le eccezioni

Della keyword `throws` e dei tipi che la seguono parleremo in una opportuna sezione sulle eccezioni ma l’idea generale è che Java ci consente di sollevare delle eccezioni circa le operazioni di un metodo e queste eccezioni possono essere poi utilizzate dal nostro codice per gestire le condizioni di errore.

Per fissare le idee possiamo immaginare, sempre nel caso dell’area, di voler gestire il fatto che sia base che altezza sono da considerarsi lunghezze e quindi non ha senso che possano essere specificate come quantità negative (ma d’altro canto il tipo `double` non è abbaastanza espressivo per vincolare le nostre variabili ad essere positive); scriveremmo in tal caso qualcosa del tipo:

```java
public double areaParallelogramma(double base, double altezza)
		throws IllegalArgumentException {
	if(base < 0)
		throw new IllegalArgumentException("base negativa");
	if(altezza < 0)
		throw new IllegalArgumentException("altezza negativa");
	if(base == 0.0 || altezza == 0.0)
		return 0.0;
	double a = base * altezza;
	return a;
}
```

Copy

Senza dilungarci troppo, anche `throw` termina l’esecuzione del blocco corrente come `return` ma senza che debba essere specificato un valore di ritorno.

## Signature, la firma dei metodi

È importante notare che in Java un metodo è univocamente determinato (oltre che dalla classe a cui appartiene naturalmente) dal suo identificatore e dalla _lista dei tipi dei parametri_ che riceve in input. Tutto questo definisce la **signature del metodo** (la firma) il che significa che siamo liberi di ridefinire il medesimo metodo più volte a patto che ogni definizione abbia una lista di parametri diversa (tipi dei parametri, i nomi non contano, non conta nemmeno il tipo di ritorno).

In questo modo possiamo sovraccaricare un identificatore di metodo con diverse definizioni ed effettuare il cosiddetto **overloading**. Capita spesso quindi che un metodo abbia diversi _overload_.

Sarebbe quindi del tutto lecito definire, accanto al metodo che prende in input il valore della base e dell’altezza definire, ad esempio, un metodo areaParallelogramma che prenda in input le lunghezze di due lati incidenti e l’angolo tra di loro:

```java
public double areaParallelogramma(double c1, double c2, double alfa)
		throws IllegalArgumentException {
	if(c1 < 0)
		throw new IllegalArgumentException("c1 negativa");
	if(c2 < 0)
		throw new IllegalArgumentException("c2 negativa");
	if(c1 == 0.0 || c2 == 0.0)
		return 0.0;
	double a = c1 * c2 * Math.sin(alpha);
	return a;
}
```

Copy

sarà il compilatore a scegliere al momento della chiamata quale metodo utilizzare sulla base del tipo (e del numero) degli argomenti attuali passati.

```java
// chiama il primo
areaParallelogramma(5.0, 4.0);
// chiama il secondo
areaParallelogramma(5.0, 4.0, 0.5);
// errore in fase di compilazione:
// non esiste un metodo che prende solo un argomento
areaParallelogramma(5.0);
```

Copy

## Modificatori di visibilità

Resta a questo punto da parlare solamente dei qualificatori del metodo i primi (`public`, `private` e `protected`) hanno il medesimo significato che avevano per le variabili e detetminano chi (quale parte del codice) possa vedere (utilizzare) in metodo:

-    **public** significa che sarà visibile dovunque,
-    **private** solo alla classe,
-    **protected** solo dalle classi che stanno nel medesimo package di quella in cui è definito il metodo e dalle classi da essa derivate,
-   infine **default** (come al solito identificato dalla omissione del qualificatore) implicherà visibilità alle classi nel medesimo package.
---
## Metodi final

Il qualificatore **final** serve, nel caso dei metodi, per rendere un metodo non ridefinibile dalle sottoclassi: se un metodo viene contrassegnato come `final` le sottoclassi lo potranno utilizzare e lo erediteranno (quindi lo avranno disponibile) ma non potranno modificarlo (o come si dice comunemente: non potranno fare _override del metodo_).

---
## Metodi Static
Sappiamo che da una classe possiamo ottenere molteplici istanze e per ciascuna istanza si hanno variabili dai nomi identici ma dai valori distinti (forse “che puntano a locazioni di memoria diverse” sarebbe una definizione più chiara). Se poi vogliamo che una variabile sia la medesima per tutte le istanze di una classe sappiamo che la dobbiamo invece definire come `static`.

Per i metodi avviene sostanzialmente la medesima cosa: possiamo pensare che dei metodi definiti in una classe ne esista normalmente (cioè se non si specifica `static`) una “copia” per ogni istanza della classe, mentre dei metodi statici ne esista una sola copia associata alla classe stessa. Per scendere più in dettaglio:

-   i **metodi non statici** sono associati ad ogni singola istanza di una classe e perciò il loro contesto di esecuzione (quindi l’insieme delle variabili cui possono accedere) è relativo all’istanza stessa: possono accedere e modificare le variabili dell’istanza e modificarne lo stato;
-   in contapposizione i **metodi statici** non sono associati ad una istanza ma solo ad una classe. Quindi non potranno interagire con le variabili di istanza, ma solamente con quelle statiche.