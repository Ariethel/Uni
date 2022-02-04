Drop table if exists Acquisto;

CREATE table Acquisto (
NScontrino INT,
Utente char(16) references Utente(CF),
Cod_prod char(13),
Marchio char(30),
Negozio char(11) references Negozio(PIVA),
Primary key (NScontrino, Cod_prod, Utente, Marchio, Negozio),
foreign key (Cod_prod, Marchio) references Prodotto(Cod, Marchio)
); 


INSERT INTO Acquisto VALUES 
(1, "AA", "1A", "Sony", "44"),
(2, "AA", "1A", "IBM", "44"),
(3, "AA", "2B", "IBM", "44"),
(4, "BB", "2B", "IBM", "55"),
(5, "CC", "2B", "IBM", "55"),
(6, "AA", "1A", "Sony", "44");