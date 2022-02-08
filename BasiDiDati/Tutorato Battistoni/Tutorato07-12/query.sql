#Quante volte ho noleggiato le auto? (in totale)
select count(*)
from noleggio;

#Per ogni utente dire quante volte ha noleggiato un auto
select CF, count(*) as noleggio
from noleggio
group by CF;

#Elencare tutti i noleggi per utenti che hanno eta > 25 anni (CF, #Noleggi)
select noleggio.CF, count(*) as Noleggi
from noleggio, utenti
where noleggio.CF = utenti.CF and utenti.eta > 25
group by CF;

#Elencare gli utenti con piu' di un noleggio
select noleggio.CF, count(*) as Noleggi
from noleggio, utenti
where noleggio.CF = utenti.CF and utenti.eta > 25
group by CF, utenti.cognome
having count(*) >= 1;
