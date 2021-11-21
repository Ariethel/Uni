# Polimorfismo

## overload dei metodi

Detta più comunemente “**method overloading**” (oppure “_operator overloding_” nel caso che sia applicato ad operatori come nell’esempio `a + b`) questa forma di polimorfismo è nota ed utilizzata sin dagli anni ’60 quando viene citata anche nel compendio “_Fundamental Concepts in Programming Languages_” di Christopher Strachey (1967), e consiste concretamente nella possibilità di “ridefinire” un medesimo metodo per set di parametri diversi.

Prendiamo per esempio la situazione in cui abbiamo la classe Triangolo e dobbiamo implementare il metodo _“area”_. Dovremo utilizzare una delle formule per il calcolo dell’area, ad esempio:

```markup
Area = base * altezza / 2
```

per applicare la quale è necessario conoscere `base` e `altezza`.
Oppure la formula:

![Area = det([X][Y][1])/2](https://static.html.it/app/uploads/2015/02/java23_01.png)

che invece prevede la conoscenza delle coordinate `(xi, yi), {i=1,2,3}` dei vertici del triangolo.

Entrambe le formule potrebbero essere utili ed entrambe avrebbero soprattutto il diritto di avere implementazione in un metodo che si chiama `area`. Il polimorfismo ci consente proprio di ridefinire il metodo area per set di parametri diversi: 
```java
public double area(double base, double altezza) {
	return base * altezza * 0.5;
}
public double area(double x1, double y1,
                   double x2, double y2,
                   double x3, double y3) {
	return 0.5 * (x1*y2 + y1*x3 + x2*y3 - x3*y2 - y3*x1 - x2*y1);
}
```

Java è in grado di capire, durante la compilazione (a “compile-time”), quale è il metodo che intendiamo utilizzare e decidere quindi quale invocare.

Se il linguaggio non permettesse l’overloading (es. il C) potremmo comunque implementare i 2 metodi ma saremmo costretti a utilizzare per loro due nomi diversi (per esempio `areaDataBaseEdAltezza` e `areaDatiIVertici`) e ottenere il medesimo risultato, al costo però di commettere una, seppure piccola, **violazione del principio di incapsulamento** avendo dovuto esplicitare nel nome di un messaggio (metodo) alcune informazioni circa la sua implementazione, cosa che, se evitabile, è bene non fare.

## Ridefinire i metodi ereditati
questa forma di polimorfismo è strettamente legata al concetto di ereditarietà e di sub-typing e consiste nella possibilità che una sottoclasse _A_ di una data classe _B_ ridefinisca uno dei metodi della super-classe e che quindi quando verrà utilizzata una istanza della classe _A_ le invocazioni al metodo ridefinito (spesso detto **overridden**) eseguiranno il codice definito nella sotto-classe.

Ricordiamo che per il principio di sostituzione di Liskov le istanze della classe _A_ dovranno poter essere utilizzate in ogni espressione che preveda l’utilizzo di una istanza della classe _B_ e a queste espressioni si applica dunque la definizione di espressione polimorfa data all’inizio di questa pagina.

In Java per default tutti i metodi non `private` sono ridefinibili ma è possibile specificare la keyword **final** per istruire il compilatore a non ammetterne la ridefinizione.

Se osserviamo invece il seguente main program:

```java
public static void main(String[] args) {
	B b = new B();
	A a = new A();
	B aa = new A(); // A è sottoclasse di B quindi è
                    // assegnabile a variabili di tipo B
	int c;
	c = b.metodo(5, 7);
	System.out.println(c);
	c = a.metodo(5, 7);
	System.out.println(c);
	c = aa.metodo(5, 7);
	System.out.println(c);
}
```

Copy

che fornisce come output

```markup
12
-2
-2
```

è possibile convincersi che la sovrascrittura dei metodi nel subtyping è operazione dinamica (diversamente dall’overloading che avviene sempre a compile time):

-   La prima riga dell’output ci dice che è stato chiamato il metodo `metodo` così come implementato nella classe `B` e sia la variabile che l’istanza sono di tipo B.
-   Il secondo risultato indica che è stata utilizzata l’implementazione data nella classe _A_, poiché sia la variabile che l’istanza sono di tipo A.
-   Il fatto che l’ultima riga di output sia `-1` implica invece che nonostante la variabile `aa` sia di tipo `B`, l’oggetto ritornato dal costruttore `A()`, benchè assegnabile a una variabile di tipo `B`, ha dentro di sé riferimenti ai metodi come definiti per la classe A.

Tale associazione tra istanze e metodi è di solito implementata attraverso una tavola di “puntatori” a metodi che viene associata a run-time ad ogni istanza generata durante l’esecuzione e che servono per risolvere, nella maniera opportuna, le chiamate ai metodi degli oggetti in un programma.