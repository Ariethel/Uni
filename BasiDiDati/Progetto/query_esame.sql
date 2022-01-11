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
<<<<<<< HEAD
=======
SELECT SUM(NumeroCanzoni) NumeroTotaleCanzoni
FROM playlist;

				 	

>>>>>>> 0fa15f4efab9e649bd427e3ebeec1b6bf1755f60

SELECT SUM(Numero)
FROM NumCanzoni;
											
# 4 - Selezione aggregata su raggruppamenti
# Selezionare la somma delle canzoni di ogni playlist (Codice, #Canzoni)
drop view if exists NumCanzoni;
CREATE VIEW NumCanzoni AS 
	(SELECT Codice, COUNT(Titolo) as Numero
	 FROM raccogliere
     GROUP BY Codice);

SELECT *
from NumCanzoni;
			





