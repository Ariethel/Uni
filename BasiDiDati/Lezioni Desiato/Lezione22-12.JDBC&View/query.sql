use ufficio;
drop view IMPIEGATIMMIN;
drop view IMPIEGATIMMINPOVERI;
drop view BUDGETSTIPENDI;
drop view DIPARTUFFICI;

create view IMPIEGATIMMIN as
select i.*
from impiegati i
where i.dipart = "Amministrazione" and i.stipendio > 10;

create view IMPIEGATIMMINPOVERI as
select *
from IMPIEGATIMMIN
where stipendio > 10 and stipendio < 45;

create view BUDGETSTIPENDI as
select i.dipart,sum(i.stipendio) as somma
from impiegati i
group by i.dipart;

select max(somma)
from BUDGETSTIPENDI;

create view DIPARTUFFICI as
select distinct count(i.ufficio) as NumUffici
from impiegati i
group by dipart;

select avg(NumUffici)
from DIPARTUFFICI;
