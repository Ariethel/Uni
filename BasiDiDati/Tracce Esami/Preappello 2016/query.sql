select Tessera
from Artisti
where Artisti.Tessera not in (select Tessera
							  from Lavoro
                              where Lavoro.Anno = 2016)
order by Artisti.ddnascita;
                              
                              
select distinct Arte, count(Genere) as num_generi
from Settore
group by Arte;


select distinct Nome, Anno
from Spettacolo
where Nome  = any (
select Nome
from Spettacolo
group by Nome
having count(*) >= 3);

select Nome, Max(Anno)
from Spettacolo
group by Nome;
