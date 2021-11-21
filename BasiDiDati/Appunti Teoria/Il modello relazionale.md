# Modello Relazionale
## Modelli logici nei sistemi di basi di dati
Il modello relazionale si basa su due concetti: ==Relazione== e ==Tabella==

La nozione di *relazione* proviene dalla matematica, in particolare dalle teoria degli insiemi, mentre il concetto di *tabella* e' semplice ed intuitivo.
La presenza contemporanea di questi due concetti, l'uno formale e l'altro intuitivo, e' responsabile del grande successo ottenuto dal modello relazionale.
Infatti le tabelle risultano naturali e comprensibili anche per gli utenti finali.
D'alta parte, la disponibilita' di una formalizzazione semplice e precisa ha permesso anche uno sviluppo teorico a supporto del modello con risultati di interesse concreto. Il modello relazionale prevede una distinzione nella descrizione dei dati, fra il livello fisico e il livello logico; Gli utenti che accedono ai dati e i programmatori che sviluppano le applicazioni fanno riferimento solo al livello ==logico==.
I dati descritti al livello logico sono poi concretamente organizzati per mezzo di opportune strutture ==fisiche==, ma non e' necessario conoscerle per accedere ai dati

## Relazioni e tabelle

Siano D1 e D2 due insieme, si dice ==prodotto cartesiano==, in simboli `D1xD2` l'insieme delle coppie ordinate `(v1,v2)` tali che `v1 appartiene a D1 e v2 appartiene a D2`. 
Una ==Relazione Matematica== sugli insiemi D1 e D2 e' un *sottoinsieme* di `D1xD2`. Le relazioni possono essere rappresentate graficamente sotto forma tabellare, e per tale motivo devono essere finite. Il numero *n* delle componenti del prodotto (quindi ogni n-upla) cartesiano viene detto ==grado== della relazione. Il numero di elementi (cioe' di n-uple) viene detto ==cardinalita== della relazione.
 
 
## Relazioni con attributi
Possiamo ricordare che una relazione e' un *insieme*, quind:
- Non e' definito alcun ordinamento fra le n-uple;Due tabelle con le stesse righe ma ordine differente rappresentano la stessa relazione
- Le n-uple di una relazione sono distinte l'una dall'altra, in quanto tra gli elementi di un insieme non ne possono essere presenti due uguali fra loro.
