### 1 ###
select a.nome, a.cognome, a.esperienza
from artista a, lavoro l, specialita s
order by a.cognome asc
where a.tessera = l.tessera and esperienza = 3 and a.arte = s.genere and a.genere continua...



### 2 ###
select l.nome,l.anno
from lavoro l
group by (l.nome,l.anno)
having count(*) > 10 


### 3 ###
select a.nome,a.cognome
from artista a , lavoro l
where a.tessera = l.tessera and l.nome = "Allegria" and a.tessera not in (select a.tessera
                                                                        from artista a, lavroro l
                                                                        where a.tessra = l.tessera and l.nome = "Vamos")



### 4 ### trovare gli artisti che hanno lavorato in tutti gli spettacoli (#tessera)
select a.tessera
from artista a
where not exists
    (select *
     from spettacoli s
     where not exists
        (select *
         from lavoro l
         where l.anno = s.anno and l.nome = s.nome and l.tessera = a.tessera) 



### 5 ### -- Selezionare l'artista con il minimo totale di ingaggio (#tessera) --
create view Calcola_Ingaggi as (
select l.tessera,sum(ingaggio) as somma_ingaggi
from lavoro l
group by tessera)



select l.tessera
from Calcola_Ingaggi
where somma_ingaggi = (select min(somma_ingaggi) from Calcola_Ingaggi)


