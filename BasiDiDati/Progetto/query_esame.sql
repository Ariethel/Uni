use progetto;

# 1 - selezione ordinata su attributo con AND e OR
# selezionare tutti gli utenti di Palermo con abbonamento annuale (CF, Nome, Cognome)
SELECT u.CF, u.Nome, u.Cognome
FROM utenti u
WHERE u.Citta = "Palermo" AND u.TipoAbbonamento = "Annuale"
ORDER BY u.CF, u.Nome, u.Cognome;

# selezionare tutti gli utenti di Milano con abbonamento mensile oppure free (CF, Nome, Cognome)
SELECT u.CF, u.Nome, u.Cognome
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
							 WHERE Nome = "Giacomo" and Cognome = "Poretti")) AND Titolo in (SELECT Titolo
																							 FROM comporre
																							 WHERE NomeAutore = "Folkstone");
                                                                                             
# 3 - Selezione aggregata su tutti i valori
# Selezionare la somma di tutte le canzoni che partecipano ad una playlist
SELECT SUM(Numero)
FROM NumCanzoni;
											
# 4 - Selezione aggregata su raggruppamenti
# Selezionare la somma delle canzoni di ogni playlist (Codice, #Canzoni)

SELECT *
from NumCanzoni;

# 5 - Selezione aggregata su raggruppamenti con condizione
# Selezionare tutte le canzoni piu' lunghe di 3 minuti per album (Titolo, Lunghezza)

SELECT Titolo, Lunghezza
FROM canzoni
GROUP BY Titolo, Lunghezza
HAVING Lunghezza > 03.00;


# 6 - Selezione aggregata su raggruppamenti con condizioni che includano un'altra funzione di raggruppamento
# Selezionare l'Album piu' lungo

SELECT la.Titolo, la.Durata
FROM LunghezzaAlbum la
WHERE Durata = (SELECT max(durata)
				FROM LunghezzaAlbum);

# 7 - Selezione con operazioni sugli insieme (in o not in)
# Selezionare tutte le ballate che non ha scritto De Andre
SELECT *
FROM comporre
WHERE Titolo in (SELECT Titolo
				 FROM afferire
				 WHERE Nome = "Ballad") and NomeAutore <> "Fabrizio De Andre";
                 
                 
# 8 - Una selezione con l'uso appropriato del doppio not exists
# Estrarre gli utenti che non hanno ascoltato alcuna canzone dell'album "Fallen"
SELECT *
FROM utenti u
WHERE CF not in (SELECT CF
				 FROM ascoltare
				 WHERE titolo not in (SELECT c.Titolo
								      FROM canzoni c
								      WHERE c.NomeAlbum != "Fallen"));


                                          

                     

 







			





