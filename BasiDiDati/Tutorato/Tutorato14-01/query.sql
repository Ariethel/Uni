# 1 Elencare in ordine desc sul nome i prodotti di fornitori italiani acquistati

SELECT f.PIVA, p.Marchio, a.Utente
FROM Fornitore f, Acquisto a, Prodotto p
WHERE f.PIVA = p.Fornitore AND p.Cod = a.CodProdotto AND p.Marchio = a.Marchio AND f.Nazione = "Italia"
ORDER BY p.Marchio desc;

# 2 Elencare i prodotti che hanno avuto il maggior numero di acquisti
drop view if exists AcquistiPerProdotto;

create view AcquistiPerProdotto as(
SELECT CodProdotto, Marchio, count(*) as numAcquisti
FROM Acquisto
GROUP BY CodProdotto, Marchio);

select *
from AcquistiPerProdotto a
where numAcquisti = (SELECT MAX(numAcquisti) from AcquistiPerProdotto);

# 3 Utente che ha acquistato solo prodotti da fornitori italiani (CF, Cognome)

SELECT u.CF, u.Cognome
FROM Utente u , Acquisto a, Prodotto p, Fornitore f
WHERE u.CF = a.utente 
AND a.CodProdotto = p.Cod 
AND a.Marchio = p.Marchio 
AND p.Fornitore = f.PIVA 
AND f.Nazione = "Italia" AND u.CF not in (SELECT u.CF
										FROM Utente u , Acquisto a, Prodotto p, Fornitore f
										WHERE u.CF = a.utente 
										AND a.CodProdotto = p.Cod 
										AND a.Marchio = p.Marchio 
										AND p.Fornitore = f.PIVA 
										AND f.Nazione <> "Italia");
                                        
                                        
# Elencare le persone che hanno acquistato tutti i prodotti del 2021

SELECT u.CF, u.Cognome
FROM Utente u
WHERE not exists (SELECT *
				  FROM Prodotto p
                  WHERE p.Anno = 2021 AND not exists (SELECT *
													  FROM Acquisto a
													  WHERE a.utente = u.CF AND a.CodProdotto = p.Cod AND a.Marchio = p.Marchio));
                                                      
# elencare i prodotti acquistati da tutte le persone
# La relazione che lega si mette sempre alla fine!!!
SELECT p.Cod, p.Marchio
FROM Prodotto p
WHERE not exists (SELECT *
				  FROM Utente u WHERE not exists (SELECT *
												  FROM Acquisto a
												  WHERE p.Cod = a.CodProdotto AND p.Marchio = a.Marchio AND u.CF = a.utente));