# Ereditarieta'
## Definizione di ereditarietà

Si dice che una classe **A è una sottoclasse di B** (e analogamente che _B è una superclasse di A_) quando:

-    _A_ eredita da _B_ sia il suo stato che il suo behavior (comportamento)
-   e quindi un’istanza della classe _A_ è utilizzabile in ogni parte del codice in cui sia possibile utilizzare una istanza della classe _B_.

Questa ultima parte della definizione va sotto il nome di “[Principio di sostituzione di Liskov](https://www.html.it/pag/32393/l-liskov-substitution-principle/ "Principio di sostituzione di Liskov")” ed è un invariante di importanza capitale che va tenuto presente ogni volta che si pensa a come strutturare una gerarchia di classi.

## Ereditatiertà strutturale (sub-typing)

In questa sezione analizziamo la più semplice forma di ereditarietà disponibile in Java (che potremmo definire strutturale o sub-typing) ma vale la pena di tenere da subito presente che la definizione di ereditarietà che abbiamo sopra dato è realizzabile in almeno 3 modi fondamentalmente dissimili:

-   Il primo consiste nell’esprimere il fatto che un elemento della classe A “**è anche**” un elemento della classe B (un cerchio è anche una figura piana);
-   il secondo consiste nel dire che gli elementi della classe A **si comportano come** elementi della classe B (il cerchio ha un’area ed un bounding-rectangle proprio come tutte le figure piane);
-   il terzo, infine, sintatticamente sensibilmente più complicato, quando si arriva al principio di sostituzione, esprime la relazione di ereditarietà per incapsulamento ed è leggibile come gli elementi della classe A hanno un elemento della classe B che può quindi essere usato quando ce ne fosse l’esigenza.

  

# Ereditarietà in Java
Tra gli elementi più importanti che caratterizzano il paradigma di sviluppo OOP c’è la _Gerarchia_. Tenendo a mente questo fatto non è difficile convincersi di quanto il concetto di **ereditarietà** sia centrale nella programmazione Object Oriented.

## Definizione di ereditarietà

Si dice che una classe **A è una sottoclasse di B** (e analogamente che _B è una superclasse di A_) quando:

-    _A_ eredita da _B_ sia il suo stato che il suo behavior (comportamento)
-   e quindi un’istanza della classe _A_ è utilizzabile in ogni parte del codice in cui sia possibile utilizzare una istanza della classe _B_.

Questa ultima parte della definizione va sotto il nome di “[Principio di sostituzione di Liskov](https://www.html.it/pag/32393/l-liskov-substitution-principle/ "Principio di sostituzione di Liskov")” ed è un invariante di importanza capitale che va tenuto presente ogni volta che si pensa a come strutturare una gerarchia di classi.

## Ereditatiertà strutturale (sub-typing)

In questa sezione analizziamo la più semplice forma di ereditarietà disponibile in Java (che potremmo definire strutturale o sub-typing) ma vale la pena di tenere da subito presente che la definizione di ereditarietà che abbiamo sopra dato è realizzabile in almeno 3 modi fondamentalmente dissimili:

-   Il primo consiste nell’esprimere il fatto che un elemento della classe A “**è anche**” un elemento della classe B (un cerchio è anche una figura piana);
-   il secondo consiste nel dire che gli elementi della classe A **si comportano come** elementi della classe B (il cerchio ha un’area ed un bounding-rectangle proprio come tutte le figure piane);
-   il terzo, infine, sintatticamente sensibilmente più complicato, quando si arriva al principio di sostituzione, esprime la relazione di ereditarietà per incapsulamento ed è leggibile come gli elementi della classe A hanno un elemento della classe B che può quindi essere usato quando ce ne fosse l’esigenza.

Nel seguito ci occuperemo esclusivamente della prima forma di ereditarietà (che va sotto il nome di ereditarietà strutturale ed anche sub-typing) lasciando la seconda alla discussione sulle interfacce mentre la terza verrà in qualche modo affrontata quando parleremo di OO Design e Patterns.

## Extends, estendere (o derivare da) una classe in Java

In Java la relazione di derivazione viene resa con la keyword **extends** che deve essere usata nella dichiarazione della classe:

```java
class A extends B {
	// ...
}
```

Implica che ogni istanza della classe _A_ sarà anche di tipo _B_ ed avrà a disposizione tutti i metodi della classe _B_ (potrà ricevere tutti i messaggi che può ricevere la classe _B_, usando la terminologia delle precedenti sezioni) e nel suo stato saranno presenti tutte le variabili che si trovano nella super classe _B_.

