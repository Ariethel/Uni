# Classi Abstract

sono utilizzate per poter dichiarare caratteristiche comuni fra classi di una determinata gerarchia. Pur definendo il nome di un tipo, la classe astratta non può essere instanziata, analogamente a quanto accade per le interfacce; ma a differenza di una interfaccia può avere field non statici, metodi non pubblici, un costruttore, insomma una classe a tutti gli effetti ma non istanziabile.

La sua dichiarazione è caratterizzata dall’utilizzo della keyword **abstract**:

```java
public abstract class A {
	//campi
	//metodi
}
```

Una classe astratta può contenere o meno metodi astratti, ma una classe che contiene metodi astratti deve necessariamente essere dichiarata come astratta, i.e. facendo uso della keyword abstract.
  
di 134

# Classi astratte in Java
Le **classi astratte in Java** sono utilizzate per poter dichiarare caratteristiche comuni fra classi di una determinata gerarchia. Pur definendo il nome di un tipo, la classe astratta non può essere instanziata, analogamente a quanto accade per le interfacce; ma a differenza di una interfaccia può avere field non statici, metodi non pubblici, un costruttore, insomma una classe a tutti gli effetti ma non istanziabile.

La sua dichiarazione è caratterizzata dall’utilizzo della keyword **abstract**:

```java
public abstract class A {
	//campi
	//metodi
}
```

Copy

Una classe astratta può contenere o meno metodi astratti, ma una classe che contiene metodi astratti deve necessariamente essere dichiarata come astratta, i.e. facendo uso della keyword abstract.

## Esempi, classi e metodi astratti

Il seguente esempio mostra una classe `A` che dichiara al suo iterno un metodo astratto. Questo codice dà errore di compilazione, in quanto, in base a quanto detto sopra, una classe che contiene metodi astratti deve necessariamente essere dichiarata come astratta.

```java
public class A {
	public abstract void metodo();
}
```

L’esempio che segue invece è corretto dal punto di vista sintattico, infatti la classe ha dichiarato al suo interno un metodo abstract e la classe è di tipo astratto.

```java
public abstract class A {
    //campi
    private boolean visible=true;
    //metodi
    public boolean isVisible() { return this.visible; }
    public abstract void metodo();
}
```

Vale la pena di osservere che come in ogni altra classe, una classe astratta può dichiarare dei campi (che ne descrivono lo stato) e dei metodi (non astratti) che ne specificano il funzionamento.

Un metodo astratto è un metodo che può essere dichiarato ma per il quale non viene fornita una implementazione; la sintassi da utilizzare in generale è la seguente:

```java
abstract <return type> nomeMetodo(lista dei parametri);
```

_Una classe astratta non può in alcun modo essere istanziata_, quindi può essere utilizzata esclusivamente come classe base. Quando estendiamo (o deriviamo) da una classe astratta, la **classe derivata deve fornire una implementazione per tutti i metodi astratti** dichiarati nella classe genitrice; se così non dovesse essere, anche la sotto-classe deve essere dichiarata come _abstract_.

Lo scopo e l’utilità delle classi astratte è di gestire il comportamento di base delle classi che la derivano e che può essere ampliato e specializzato da queste ultime.

Per esempio, immaginiamo che un certo processo necessita di tre fasi:

1.  Inizializzazione del processo
2.  Azione principale
3.  Step successivo all’azione

Se le due fasi di inizializzazione e lo step successivo all’azione rimangono invariati, il terzo passo (cioè l’azione principale) può essere implementato e considerato come una classe astratta (in modo da essere specializzato dalle classi derivate).

```java
public abstract class AbstractProcess {
	public void process() {
		init();
		baseAction();
		stepAfter();
	}
	public void init() {
		// metodo dichiarato direttamente
		// all'interno della classe astratta
	}
	public abstract void baseAction();
	// metodo astratto la cui implementazione
	// è demandata alla sottoclasse
	public void stepAfter() {
		// metodo dichiarato direttamente
		// all'interno della classe astratta
	}
}
class MyProcess extends AbstractProcess {
	@Override
	public void baseAction() {
		// implementazione del metodo baseAction()
	}
}
```

### Quando utilizzare l’interfaccia e quando la classe astratta?

In base a quanto detto, cosa è meglio utilizzare? Ed in quali circostanze?

-   Si usa una **classe astratta** per condividere codice fra più classi, se più classi hanno in comune metodi e campi o se si vogliono dichiarare metodi comuni che non siano necessariamente campi `static` e `final`.
-   Si decide di utilizzare una **interfaccia** se ci si trova nella situazione in cui alcune classi (assolutamente non legate fra di loro) si trovano a condividere i metodi di una interfaccia, se si vuole _specificare il comportamento di un certo tipo di dato_ (ma non implementarne il comportamento) o se si vuole avere la possibilità di sfruttare la “multiple inheritance”.