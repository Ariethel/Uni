# Parametri di tipo limitati
Esistono situazioni in cui abbiamo la necessità di **applicare un limite al parametro di tipo per le classi che possono sostituirsi al parametro stesso**. Vediamo un esempio che chiarisce quanto appena detto. Riferendoci all’esempio del precedente capitolo, sarebbe perfettamente corretto dichiarare ed utilizzare un oggetto di classe `Bottiglia` nel seguente modo:

```java
....
  Bottiglia<String> b=new Bottiglia<String>(new String());
 ....
```

Un utilizzo di questo tipo non ha molto senso da un punto di vista semantico. Per quanto fatto in precedenza la nostra classe `Bottiglia` consente la definizione, all’interno di un’applicazione, di bottiglie di stringhe. Vorremmo poter limitare i tipi possibili per il parametro di tipo specificando un qualche limite superiore. Ad esempio vorremmo poter specificare che il parametro di tipo `T` della classe Bottiglia sia costituito da sottoclassi di una ipotetica classe, o interfaccia, `Bevanda` estesa dalle classi `Acqua` e `Vino`.

Convertiamo in codice quanto detto. Realizziamo un’interfaccia senza metodi `Bevanda`:

```java
public interface Bevanda {}
```

E modifichiamo il codice delle classi `Acqua` e `Vino` in modo tale che implementino questa interfaccia:

```java
public class Acqua implements Bevanda{
	@Override
	public String toString(){
		return " una bottiglia d'acqua";
	}
}
```

```java
public class Vino implements Bevanda {
	@Override
	public String toString(){
		return " una bottiglia di vino";
	}
}
```

Adesso ridefiniamo la classe `Bottiglia` utilizzando diversamente la notazione Generics specificando un limite superiore per il parametro di tipo:

```java
public class Bottiglia<T extends Bevanda> {
	private T contenuto;
	public Bottiglia(T t){
		contenuto=t;
	}
	public T getContenuto() {
		return contenuto;
	}
}
```

Apportate le precedenti modifiche, vedremo come il codice scritto precedentemente, dia errori in compilazione.

```java
....
   Bottiglia<String> b=new Bottiglia<String>(new String());
 ....
```

Abbiamo ora specificato che il parametro `T` deve essere sostituito da un tipo compatibile con `Bevanda`, la nostra classe ha adesso un significato d’uso decisamente migliore.

Evidenziamo ulteriormente quanto appena detto sottolineando che l’uso della parola chiave `extends`, applicata al parametro di tipo, non indica che la classe che sostituisce il parametro debba necessariamente implementare `Bevanda`, ma che deve essere un tipo compatibile con il tipo `Bevanda`.

Nel capitolo precedente abbiamo introdotto il **carattere Jolly** indicato con il punto interrogativo; esso è utile per specificare un tipo sconosciuto. Nel nostro caso ne abbiamo fatto uso nella classe `BraccioAutomatico`:

```java
public class BraccioAutomatico {
	public void prendiBottiglia(Bottiglia<?> bottiglia){
		System.out.println("Ho preso"+bottiglia.getContenuto());
	}
}
```

# Argomento Jolly
Il carattere Jolly ha permesso di realizzare un unico metodo `prendiBottiglia()` in grado di ricevere in input bottiglie con diversi tipi di contenuto. Senza il carattere Jolly saremmo stati costretti a definire un metodo per ciascuno tipo di `Bottiglia`.
I Jolly possono essere limitati sia superiormente che inferiormente. Ad esempio possiamo limitare superiormente il Jolly nel metodo `prendiBottiglia()` in modo tale da evitare il passaggio di tipi che non hanno significato:

```java
public class BraccioAutomatico {
    public void prendiBottiglia(Bottiglia<? extends Bevanda> bottiglia){
       System.out.println("Ho preso"+bottiglia.getContenuto());
    }
}
```

Possiamo anche specificare un limite inferiore del tipo `<? super sottoclasse>`.

In questo caso sono accettabili solo classi che sono super-tipi di sottoclasse. Concludiamo con il far notare che, mentre la limitazione superiore è inclusiva (il tipo limite è incluso nei possibili valori per il parametro), la limitazione inferiore è esclusiva: il tipo limite non è incluso nei possibili valori per il parametro.