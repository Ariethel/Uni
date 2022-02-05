# elencare gli eventi che hanno avuto il maggior numero di prenotazioni (Anno Evento, Nome Evento, Nome Città Evento, #prenotazioni)
select p.e_anno, p.e_nome, c.nome, count(p.e_nome) as n_prenot
from prenotazione p, citta c
where p.e_citta = c.CAP
group by p.e_anno, p.e_nome, p.e_citta, c.nome
having n_prenot >= all (select count(*)
from prenotazione p, citta c
where p.e_citta = c.CAP
group by  p.e_anno, p.e_nome, p.e_citta, c.nome);


drop view if exists conteggio;
create view conteggio as 
select p.e_anno, p.e_nome, c.nome, count(p.e_nome) as n_prenot
from prenotazione p, citta c
where p.e_citta = c.CAP
group by p.e_anno, p.e_nome, p.e_citta, c.nome;

select * from conteggio
where n_prenot = (select max(n_prenot) from conteggio);

# Verifica
select p.e_anno, p.e_nome, c.nome, c.CAP, count(p.e_nome) as n_prenot
from prenotazione p, citta c
where p.e_citta = c.CAP
group by p.e_anno, p.e_nome, p.e_citta, c.nome