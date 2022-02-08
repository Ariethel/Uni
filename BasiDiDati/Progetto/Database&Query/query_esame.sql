use progetto;

# 1 - selezione ordinata su attributo con AND e OR
# selezionare tutti gli utenti di Palermo con abbonamento annuale (CF, Nome, Cognome)
SELECT u.CF, u.Nome, u.Cognome
FROM utenti u
WHERE u.Citta = "Palermo" AND u.TipoAbbonamento = "Annuale"
ORDER BY u.CF, u.Nome, u.Cognome;

# selezionare tutti gli utenti di Milano con abbonamento mensile oppure free (CF, Nome, Cognome)
SELECT u.CF, u.Nome, u.Cognome, u.TipoAbbonamento
FROM utenti u
WHERE u.Citta = "Milano" AND (u.TipoAbbonamento = "Mensile" OR u.Tipo = "Free")
ORDER BY u.CF, u.Nome, u.Cognome;








# 2 - selezione su due o piu' tabelle con condizioni
# Selezionare tutte le canzoni dei Folkstone dalla playlist di Giacomo Poretti (Titolo)
SELECT Titolo
FROM raccogliere
WHERE Codice = (SELECT Codice
				FROM playlist
				where CF = (SELECT CF
							 FROM utenti
							 WHERE Nome = "Giacomo" and Cognome = "Poretti")) 
AND Titolo in (SELECT Titolo
			   FROM comporre
			   WHERE NomeAutore = "Folkstone");








																					
# 3 - Selezione aggregata su tutti i valori
# Selezionare il numero totale di canzoni in tutte le playlist
SELECT * # Query dimostrativa della view NumCanzoni
FROM NumCanzoni;

SELECT SUM(Numero)
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

# Selezionare tutte le canzoni piu' lunghe di 3 minuti (NomeAlbum, Titolo, Lunghezza)
SELECT NomeAlbum, Titolo, Lunghezza
FROM canzoni
GROUP BY NomeAlbum, Titolo , Lunghezza
HAVING Lunghezza > 03.00
ORDER BY NomeAlbum;













# 6 - Selezione aggregata su raggruppamenti con condizioni che includano un'altra funzione di raggruppamento
# Selezionare l'Album piu' lungo che contiene al massimo 10 canzoni

SELECT Titolo, Durata # Questa in realta' serve solo per formattare l'output
FROM LunghezzaAlbum
WHERE Durata = 	(SELECT MAX(a.Durata)
				 FROM (SELECT la.Durata
					  FROM LunghezzaAlbum la join canzoni c on la.Titolo = c.NomeAlbum
					  GROUP BY la.Titolo
					  HAVING COUNT(c.Titolo) <= 10) a);
                
SELECT * # Query dimostrativa dopo il join, serve per contare il numero di canzoni
FROM LunghezzaAlbum la join canzoni c on la.Titolo = c.NomeAlbum
ORDER BY la.Titolo;


SELECT * # Query dimostrativa della view
FROM LunghezzaAlbum;










# 7 - Selezione con operazioni sugli insieme (in o not in)
# Selezionare tutte le ballate che non ha scritto De Andre
SELECT *
FROM comporre
WHERE Titolo in (SELECT Titolo
				 FROM afferire
				 WHERE Nome = "Ballad") 
AND NomeAutore <> "Fabrizio De Andre";
                 











                 
# 8 - Una selezione con l'uso appropriato del doppio not exists
# Estrarre gli utenti che non hanno ascoltato alcuna canzone dell'album "Fallen"
SELECT * 
FROM utenti u
WHERE CF not in (SELECT CF # CF di quelli che hanno ascoltato almeno una canzone da Fallen
				 FROM ascoltare
				 WHERE titolo not in (SELECT c.Titolo # Canzoni che non fanno parte di Fallen
								      FROM canzoni c
								      WHERE c.NomeAlbum != "Fallen"));


                                          

                     

 







			





