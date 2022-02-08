use unisa2;

-- a) Elencare i magazzini che hanno movimentato tutti i prodotti
select m.id,m.nome,m.negozio
from Magazzino m
where m.id in (select Mag_ID
			   from Movimenti);
-- b) Elencare i magazzini che hanno disponibilità di tutti i prodotti

-- c) Elencare i prodotti che sono stati movimentati nel magazzino 'Mag B' ma non nel magazzino 'Via Amelia'
select *
from Magazzino m, catalogo g, movimenti mov
where m.nome = "Mag B"
not in
select *
from 
-- d) Elencare il Prodotto più movimentato

-- e) Elencare il magazzino con il maggior assortimento di prodotti (ID Magazzino, ID Negozio e numero Prodotti)

-- f) Elencare il magazzino con maggiore numero di prodotti (ID Magazzino, ID Negozio e numero Prodotti)

-- g) Elencare il magazzino con maggiore numero di prodotti (ID Magazzino, ID Negozio e numero Prodotti)

