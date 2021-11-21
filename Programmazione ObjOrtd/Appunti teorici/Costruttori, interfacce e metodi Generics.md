Un **costruttore** di una classe può essere generico anche se la sua classe non lo è. Ad esempio possiamo inserire nella classe `BraccioAutomatico` un costruttore parametrizzato:

```java
public class BraccioAutomatico {
	private Bottiglia<? extends Bevanda> bottiglia;
	public <T extends Bottiglia<? extends Bevanda>> BraccioAutomatico(T bottiglia){
		this.bottiglia = bottiglia;
		System.out.println(this.bottiglia.getContenuto());
	}
	public BraccioAutomatico(){}
	public void prendiBottiglia(Bottiglia<? extends Bevanda> bottiglia){
		System.out.println("Ho preso "+bottiglia.getContenuto());
	}
}
```

La dichiarazione del parametro `T` avviene tra il modificatore di accesso e la dichiarazione del costruttore. Nel nostro caso `T` è limitato superiormente in modo tale da accettare tipi compatibili con `Bottiglia<? extends Bevanda>`. Oltre alle classi anche le **interfacce** possono essere generiche e dichiarare quindi parametri di tipo. Come esempio, modifichiamo l’interfaccia `Bevanda` rendendola Generics:

```java
public interface Bevanda<T> {
}
```

Modifichiamo anche l’implementazione delle classi `Acqua` e `Vino` in modo tale che specifichino il parametro di tipo richiesto dall’interfaccia:

```java
public class Acqua implements Bevanda<Acqua>{
	@Override
	public String toString(){
		return " una bottiglia d'acqua";
	}
}
public class Vino implements Bevanda<Vino>{
	@Override
	public String toString(){
		return " una bottiglia di vino";
	}
}
```

Per completare l’esempio aggiungiamo il metodo `versaBevanda()` alla classe `BraccioAutomatico`:

```java
public void versaBevanda(){
    if(bottiglia != null)
       System.out.println("Versa"+bottiglia.getContenuto().toString());
    else
       System.out.println("Bottiglia vuota");
}
```

Ed aggiorniamo il codice del metodo `main` della classe `Demo`:

```java
Bottiglia<Acqua> bottiglia1= new Bottiglia<Acqua>(new Acqua());
    Bottiglia<Vino>  bottiglia2= new Bottiglia<Vino>(new Vino());
    BraccioAutomatico braccio = new BraccioAutomatico(bottiglia1);
    braccio.prendiBottiglia();
    braccio.versaBevanda();
    braccio.prendiBottiglia(bottiglia2);
    braccio.versaBevanda();
```

Nel codice è importante notare l’utilizzo del costruttore generico per l’oggetto `bottiglia1`. Abbiamo completato un set di classi per l’emulazione del comportamento di un braccio meccanico in grado di prendere e versare bottiglie generiche con contenuti generici.

Concludiamo il capitolo con i **metodi generici**. La loro definizione è simile alla definizione di un costruttore generico, tutto ciò che dobbiamo fare è dichiare il tipo parametro locale tra il modificatore di accesso e la dichiarazione del metodo. Come esempio mostriamo una variante del metodo `prendiBottiglia()` della classe `BraccioAutomatico` che faccia uso di un metodo parametrizzato:

```java
public <T extends Bottiglia<? extends Bevanda<?>>> void prendiBottiglia(T bottiglia){
      System.out.println("Ho preso"+bottiglia.getContenuto());
      this.bottiglia=bottiglia;
}
```

In modo informale la lettura del metodo ci dice che il parametro di tipo `T`, accettato come argomento, è un tipo di `Bottiglia` generico con contenuto generico, ovvero un tipo compatibile con `Bottiglia<? extends Bevanda<?>`.