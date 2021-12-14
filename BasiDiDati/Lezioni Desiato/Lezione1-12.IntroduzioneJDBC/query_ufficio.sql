#1
select *
from impiegati;

#2
select *
from dipartimenti;

#3
select *
from impiegati i
where i.cognome = "Rossi";

#4
select *
from impiegati i
where i.stipendio > 50;

#5
select i.nome as Nome,i.cognome as Cognome
from impiegati i
where i.dipart = "Amministrazione";

#6 e 7
select i.nome,i.cognome,i.dipart, d.via, d.cv, d.citta, i.ufficio
from impiegati i inner join dipartimenti d on i.dipart = d.nomedip
where i.cognome = "Rossi";

#8
select impiegati.nome, impiegati.cognome, dipartimenti.citta
from impiegati left join dipartimenti on impiegati.dipart = dipartimenti.nomedip;

#9
select impiegati.nome, impiegati.cognome, dipartimenti.citta
from impiegati right join dipartimenti on dipart = nomedip;

#10
select *
from dipartimenti
where dipartimenti.citta like 'T%';

#11
select i.matricola
from impiegati i inner join dipartimenti d on i.dipart = d.nomedip
where i.dipart <> "Amministrazione" and d.citta <> "Roma";

#12
select i.nome,i.cognome
from impiegati i join dipartimenti d on i.dipart = d.nomedip
where (d.citta = "Roma" or d.citta = "Milano") and (i.stipendio >= 50 and i.stipendio <= 80);