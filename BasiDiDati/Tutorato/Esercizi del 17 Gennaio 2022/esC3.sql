Select s.PIVA, s.nome
from sponsor s, sponsorizzazione sz, citta c
where  s.PIVA = sz.sponsor and sz.e_citta = c.cap
and c.nome = "Salerno" 
and s.PIVA not in (Select s.PIVA
from sponsor s, sponsorizzazione sz, citta c
where  s.PIVA = sz.sponsor and sz.e_citta = c.cap
and c.nome = "Napoli");