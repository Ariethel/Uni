# Dato il seguente schema relazionale:


-- ================================= Esprimere le seguenti Query in SQL: =================================

-- 1) Elencare in ordine decrescente sul cod i Prodotti di fornitori Italiani Acquistati. (PIVA, Marchio, CF)
SELECT f.PIVA, p.Marchio, a.Utente, p.Cod
FROM Fornitore f, Acquisto a, Prodotto p
WHERE f.PIVA = p.Fornitore and a.Cod_prod=p.Cod and p.Marchio=a.Marchio
AND f.Nazione = "Italia"
ORDER BY p.Cod DESC; 

-- 2) Elencare i prodotti che hanno avuto il maggior numero di acquisti. (Cod, Marchio , #acquisti)
create view Vista1 as
SELECT a.Cod_prod, a.Marchio, count(*) as nacq
FROM Acquisto a 
Group By a.Cod_prod, a.Marchio;

select * 
from Vista1
where Vista1.nacq = (SELECT max(nacq) FROM Vista1);

-- 3) Elencare l’utente che ha acquistato solo prodotti da forntori Italiani. (CF, Cognome)
SELECT u.CF, u.Cognome
FROM Utente u, Acquisto a
WHERE u.CF=a.Utente 
and u.CF NOT IN (
SELECT u.CF
FROM Utente u, Acquisto a, Prodotto p, Fornitore f 
WHERE u.CF=a.Utente 
and a.Cod_prod=p.Cod AND a.Marchio=p.Marchio
and p.Fornitore = f.PIVA
and f.Nazione <> "Italia");


-- 4) Elencare le Persone che hanno acquistato tutti i prodotti del 2021. (CF, Cognome)
SELECT u.CF, u.Cognome
From Utente u
where NOT Exists ( SELECT * 
						FROM Prodotto p where p.Anno = 2021
                        AND
                        Not Exists (
                        Select * 
                        FROM Acquisto a
                        where a.Utente = u.CF AND p.Cod=a.Cod_prod and p.Marchio = a.Marchio));
				  
# Elencare I prodotti  acquistati da tutti gli utenti (Cod,Marchio)

Select p.Cod, p.Marchio
FROM Prodotto p 
where NOT Exists 
	(SELECT * FROM Utente u
    WHERE NOT EXISTS
    (SELECT *  
    FROM Acquisto a
		where a.Utente = u.CF AND p.Cod=a.Cod_prod and p.Marchio = a.Marchio));