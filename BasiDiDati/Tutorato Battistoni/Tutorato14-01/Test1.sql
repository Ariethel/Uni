drop schema if exists unisa4 ;
CREATE SCHEMA unisa4;
use unisa4;



Create Table Utente (
CF char(16) primary key,
Nome char(30) not null,
Cognome char(30) not null);

Create table Fornitore (
PIVA char(5) primary key,
Nome char(30) not null,
Nazione char(30) not null);


Create table Prodotto (
Cod char(13),
Marchio char(30) not null,
Anno INT not null,
Descrizione varchar(200),
Fornitore CHAR(5) references Fornitore(PIVA),
primary key (Cod, Marchio)
);

Create table Negozio (
PIVA char(11) primary key,
Nome char(30) not null
);

# creare tabella acquisto
create table Acquisto(
NScontrino int,
utente char(16) references Utente.CF,
CodProdotto char(13),
Marchio char(30),
negozio char(11) references Negozio.PIVA,
primary key(NScontrino, utente,CodProdotto,Marchio),
foreign key (CodProdotto, Marchio) references Prodotto(Cod, Marchio)
);

INSERT INTO Utente values
("AA", "Pippo", "Bianchi"),
("BB", "Antonio", "Neri"),
("CC", "Vincenzo", "Rossi");

INSERT INTO Fornitore values
("11", "Alfa", "Italia"),
("22", "Beta", "Francia"),
("33", "Delta", "Spagna");

INSERT INTO Prodotto VALUES 
("1A", "Sony", 2021, null, "11"),
("2B", "IBM", 2020, "PC", "22"),
("1A", "IBM", 2021, "PC", "11");

INSERT INTO Negozio VALUES
("44", "Uno"),
("55", "Due"),
("66", "Tre");

INSERT INTO Acquisto values
(1, "AA", "1A", "Sony", "44"),
(2, "BB", "1A", "Sony", "55"),
(4, "CC", "1A", "Sony", "55"),
(3, "CC", "1A", "IBM", "55");
