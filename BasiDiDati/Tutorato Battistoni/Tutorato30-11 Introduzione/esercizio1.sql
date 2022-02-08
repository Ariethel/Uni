/*Query per stampare nome, cognome ed eta di ogni istanza di utenti 
facendo anche una ridenominazione*/
SELECT nome as Nome, cognome as Family, eta
FROM utenti;

/*Query per stampare tutto dalle citta*/
SELECT *
FROM citta;

/*Elencami gli utenti che hanno visitato almeno una citta (CF,Cognome, nome della citta Descr Citta)*/
select utenti.CF, utenti.cognome, visite.citta, citta.descrizione      #indifferente se maiusc o minusc i comandi
from utenti, visite, citta
where utenti.CF = visite.CF and visite.citta = citta.nome and visite.prov=citta.prov;

/*
#Equivalente a questa
select utenti.CF, utenti.cognome, visite.citta, citta.descrizione      #indifferente se maiusc o minusc i comandi
from (utenti u join visite v on u.CF = v.CF) join citta c on v.citta = c.nome and v.prov = c.prov;
*/

/*Elencami per ogni utente le citta' visitate (Cognome, Citta)*/
select u.cognome, v.citta
from utenti u left join visite v on u.CF = v.CF

/**/
