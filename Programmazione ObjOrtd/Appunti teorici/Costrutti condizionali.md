## Il costrutto if in Java

Iniziamo da **if-else**. A volte si tende a chiamare questo costrutto condizionale _if-then-else_ anche se la keyword `then` non esiste.

```java
if(condizione1) {
// ...
} else if (condizione2) {
// ...
} else {
//...
}
```

Le condizioni espresse sono di tipo **boolean**.

---
## switch-case

Pur essendo possibile usare if-else per costruire strutture condizionli arbitarie, Java come molti altri linguaggi (il C ad esempio) ammette anche una secondo costrutto condizionale: **switch-case**.

```java
switch(c) {
case value1:
...
break;
case value2:
...
break;
// eventuali altri case
case valueN:
...
default:
}
```