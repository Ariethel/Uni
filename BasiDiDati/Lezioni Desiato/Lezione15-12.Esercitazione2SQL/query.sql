use ufficio;

# 1
select i1.*
from impiegati i1,impiegati i2
where i1.cognome = i2.cognome and i1.nome != i2.nome and i1.dipart = "Produzione" and i2.dipart = "Produzione";

# 2
select i.nome as nome, i.stipendio as stipendio
from impiegati i
where i.dipart = "Amministrazione" and i.stipendio > 40;

# 3
select i.*
from impiegati i
order by i.nome,i.cognome;

# 4
select i.*
from impiegati i
order by i.stipendio desc;

# 5
select count(*)
from impiegati i
group by i.dipart
having i.dipart = "Produzione";

# 6
select  count(distinct i.stipendio)
from impiegati i;

# 7 
select sum(i.stipendio)
from impiegati i
where i.dipart = "Amministrazione";

# 8
select min(i.stipendio), max(i.stipendio), avg(i.stipendio)
from impiegati i;

# 9
select max(i.stipendio)
from impiegati i, dipartimenti d
where d.citta = "Milano" and i.dipart = d.nomedip;

# 10
select sum(i.stipendio)
from impiegati i
group by dipart;

# 11 
select i.dipart,count(*),d.citta as Dipartimento
from impiegati i inner join dipartimenti d on i.dipart = d.nomedip
group by i.dipart,d.citta;

# 12
select i.dipart, sum(i.stipendio)
from impiegati i 
group by i.dipart
having sum(i.stipendio) > 100;

# 13
select i.dipart, avg(i.stipendio)
from impiegati i
where i.ufficio = 20
group by dipart
having avg(i.stipendio) > 25;

# 14
select i1.nome
from impiegati i1
union
select i2.cognome
from impiegati i2;

# 15
select i1.nome
from impiegati i1
where i1.dipart != "Amministrazione"
union all
select i2.cognome
from impiegati i2
where i2.dipart <> "Amministrazione";

# 16
select *
from impiegati i
where i.dipart = any (select d.nomedip
					  from dipartimenti d where d.citta = "Milano");
                      
# 17
select *
from impiegati i
where i.nome = any (select i2.nome
					from impiegati i2
					where i2.dipart = "Produzione");
                    
# 18
select d.nomedip
from dipartimenti d
where d.nomedip not in (select i.dipart
						from impiegati i
                        where i.cognome = "Rossi");
                        
# 19
select i1.dipart
from impiegati i1
where i1.stipendio = (select max(i2.stipendio)
					  from impiegati i2);
                      
# 20
select i1.dipart
from impiegati i1
where i1.stipendio >= all (select i2.stipendio
						  from impiegati i2);
                          
# 21
select *
from impiegati i1
where exists (select *
			  from impiegati i2
			  where (i1.cognome = i2.cognome) and (i1.nome <> i2.nome) and i1.dipart = "Produzione" and i2.dipart = "Produzione");
                         
