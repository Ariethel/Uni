# Minimax Games
Questo semplice progetto è realizzato nel contesto del corso di *Fondamenti di Intelligenza Artificiale*.
Esso rappresenta un esempio di possibile implementazione di un agente risolutore di giochi a costo zero mediante l'algoritmo minimax.

## Contenuti
Sono presenti 2 package, ``ai`` e ``tictactoe``.

### Package AI
Nel primo risiede l'implementazione dell'agente, la classe ``MinimaxAI``, e due interfacce,  ``Board`` e ``Move``.
Tali interfacce permettono all'agente di poter effettuare i propri calcoli rimanendo agnostico rispetto al gioco effettivamente implementato.

In particolare, l'interfaccia ``Board`` rappresenta il piano di gioco, e quindi tutte le configurazioni che esso assume, e dunque anche gli stati visistati da minimax.
Inoltre, è la stessa astrazione che fornisce le azioni possibili, nonchè il valore di utilità quando si raggiunge uno stato terminale.

L'interfaccia ``Move``, invece, rappresenta una effettiva mossa di gioco, che tramite un **command pattern** reversibile, modifica lo stato del gioco.

A seconda dell'implementazione concreta di queste astrazioni, varia il gioco implemementato: tuttavia, l'agente può essere riutilizzato completamente.

### Package TicTacToe
In questo package sono contenute 3 classi: ``TicTacToeBoard``, ``TicTacToeMove`` (interna a board), e ``TicTacToeGame``.
Le prime due rappresentano l'implementazione concreta delle interfacce per l'agente, mentre la terza gestisce tutto l'andamento del gioco.
Nella classe ``TicTacToeBoard``, in particolare, oltre ai metodi ereditati dall'interfaccia, sono presenti dei metodi propri per gestire il gioco del Tris (o TicTacToe).
Da notare la possibilità di dare una dimensione alla game board: questo occorre per rendere evidente l'inefficienza in termini di computazione di minimax, e della necessità di ottimizzarlo.
