use progetto;

# 1 - selezione ordinata su attributo con AND e OR
# selezionare tutti gli utenti di Palermo con abbonamento annuale (CF, Nome, Cognome)
SELECT u.CF, u.Nome, u.Cognome
FROM utenti u
WHERE u.Citta = "Palermo" AND u.TipoAbbonamento = "Annuale"
ORDER BY u.CF, u.Nome, u.Cognome;

# selezionare tutti gli utenti di Milano con abbonamento mensile oppure free (CF, Nome, Cognome, Tipo Abbonamento)
SELECT u.CF, u.Nome, u.Cognome, u.TipoAbbonamento
FROM utenti u
WHERE u.Citta = "Milano" AND (u.TipoAbbonamento = "Mensile" OR u.Tipo = "Free")
ORDER BY u.CF, u.Nome, u.Cognome;




# 2 - selezione su due o piu' tabelle con condizioni
# Selezionare tutte le canzoni dei Folkstone dalla playlist di Giacomo Poretti (Titolo)
SELECT r.Titolo
FROM raccogliere r, playlist p, utenti u
WHERE r.Codice = p.Codice AND p.CF = u.CF AND u.Nome = "Giacomo" AND u.Cognome = "Poretti";



																					
# 3 - Selezione aggregata su tutti i valori
# Selezionare il numero totale di canzoni presenti in tutte le playlist (NumeroTotale)
SELECT * # Query dimostrativa della view NumCanzoni
FROM NumCanzoni;

SELECT SUM(Numero) as NumeroTotale
FROM NumCanzoni;



											
# 4 - Selezione aggregata su raggruppamenti
# Selezionare la somma delle canzoni di ogni playlist (Codice, #Canzoni)
SELECT * # Versione sfruttando la view
from NumCanzoni;

# Query normale
SELECT Codice, COUNT(Titolo) as Numero
FROM raccogliere
GROUP BY Codice;




# 5 - Selezione aggregata su raggruppamenti con condizione
# Selezionare tutti gli album piu' lunghi di 25 minuti (Forse e' inutile)
SELECT Titolo
FROM LunghezzaAlbum
WHERE Durata > 25.00;

# Selezionare gli album che hanno almeno 10 canzoni (NomeAlbum)
SELECT a.NomeAlbum
FROM album a inner join canzoni c ON a.NomeAlbum = c.NomeAlbum
GROUP BY a.NomeAlbum
HAVING count(*) >= 10;




# 6 - Selezione aggregata su raggruppamenti con condizioni che includano un'altra funzione di raggruppamento
# Selezionare l'Album piu' lungo che contiene al massimo 10 canzoni (Titolo, Durata)
SELECT Titolo, Durata
FROM LunghezzaAlbum
WHERE Durata = 	(SELECT MAX(a.Durata)
				 FROM (SELECT la.Durata
					  FROM LunghezzaAlbum la join canzoni c on la.Titolo = c.NomeAlbum
					  GROUP BY la.Titolo
					  HAVING COUNT(*) <= 10) a);
                
                
                

# 7 - Selezione con operazioni sugli insieme (in o not in)
# Selezionare tutte le ballate che non sono state scritte da De Andre(Titolo, NomeAutore)
SELECT Titolo, NomeAutore
FROM comporre
WHERE Titolo in (SELECT Titolo
				 FROM afferire
				 WHERE Nome = "Ballad") 
AND NomeAutore <> "Fabrizio De Andre";
                 
                 
                 

# 8 - Una selezione con l'uso appropriato del doppio not exists
# Playlist che contiene tutte le canzoni
SELECT *
FROM playlist p
WHERE NOT EXISTS (SELECT *
				  FROM canzoni c
                  WHERE NOT EXISTS (SELECT *
									FROM raccogliere r
                                    WHERE p.Codice = r.Codice AND c.Titolo = r.Titolo));
                                          

                     

 







			





