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
# Selezionare la somma delle canzoni di ogni playlist (Codice, #Canzoni)
SELECT Codice, MAX(NumeroCanzoni) as Canzoni
FROM playlist
GROUP BY Codice
HAVING 
			





