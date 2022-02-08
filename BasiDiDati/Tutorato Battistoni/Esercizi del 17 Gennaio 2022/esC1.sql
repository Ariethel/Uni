SELECT s.PIVA, s.Nome
FROM Sponsorizzazione sp, Sponsor s, Citta c
WHERE sp.Sponsor = s.PIVA AND sp.e_citta=c.CAP
AND c.Nome="Salerno"
ORDER by s.Nome DESC;