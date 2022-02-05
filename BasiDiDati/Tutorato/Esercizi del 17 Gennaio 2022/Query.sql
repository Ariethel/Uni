# Elencare in ordine decrescente sul nome gli sponsor degli eventi di “Salerno” (PIVA, Nome, Sponsor, Importo)

SELECT s.PIVA, sp.sponsor, sp.e_nome, sp.importo
FROM sponsor s, sponsorizzazione sp
WHERE s.PIVA = sp.sponsor AND sp.e_citta = "84100"
ORDER BY sp.sponsor desc;

# Elencare gli eventi che hanno avuto il maggior numero di prenotazioni (Anno Evento, Nome, Evento, Nome Città Evento, #prenotazioni)
DROP VIEW IF EXISTS Vista1;

CREATE VIEW Vista1 AS
SELECT e_nome, count(*) as NumPrenotazioni
FROM prenotazione
GROUP BY e_nome;

SELECT v.e_nome 
FROM Vista1 v
WHERE v.NumPrenotazioni = (SELECT MAX(NumPrenotazioni) FROM Vista1);

# Elencare gli Sponsor di eventi a “Salerno” ma non a “Napoli”. (PIVA, Nome)

SELECT s.PIVA,s.nome
FROM sponsor s
WHERE s.PIVA in (SELECT sp1.sponsor
				 FROM sponsorizzazione sp1
                 WHERE sp1.e_citta = "84100")
AND s.PIVA not in (SELECT sp2.sponsor
				   FROM sponsorizzazione sp2
                   WHERE sp2.e_citta = "80100");
                   
# Elencare le Persone che hanno prenotato per tutti gli eventi del 2021 (CF, Cognome)

SELECT p.CF, p.cognome
FROM persona p
WHERE NOT EXISTS (SELECT *
				  FROM evento e
                  WHERE e.anno = 2021 AND NOT EXISTS (SELECT *
													  FROM prenotazione pp
													  WHERE pp.p_cf = p.CF AND pp.e_nome = e.nome AND pp.e_citta = e.citta AND pp.e_anno = e.anno));