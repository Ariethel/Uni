select Nome, Anno
from Spettacolo
where Nome  = any (
select Nome
from Spettacolo
group by Nome
having count(*) >= 3);

select Tessera
from Artisti
where Artisti.Tessera not in (select Tessera
							  from Lavoro
                              where Lavoro.Anno = 2016);