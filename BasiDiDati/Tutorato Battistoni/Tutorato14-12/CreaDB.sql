drop schema if exists unisa2 ;
CREATE SCHEMA unisa2;
use unisa2;

CREATE table Catalogo (
Codice numeric primary key,
Descrizione varchar(200),
Prezzo decimal(8,2)
);

Create table Negozio (
ID numeric primary key,
Nome char(20) not null,
Citta char(20) not null
);

Create table Magazzino(
ID numeric,
Negozio numeric references Negozio(ID),
Nome char(20) not null,
Primary key (ID, Negozio)
);

Create table Movimenti (
ID numeric,
Prodotto numeric references Catalogo(ID),
Mag_ID numeric,
Negozio numeric,
data date not null,
quantita numeric,
Primary key (ID, Prodotto, Mag_ID, Negozio),
foreign key (Mag_ID, Negozio) references Magazzino(ID, Negozio)
);

INSERT INTO Catalogo (Codice, Descrizione, Prezzo) values
(1, "Cappello da Uomo", 10.50),
(2, "Cappello da Donna", 20.00),
(3, "Occhiali da Sole", 20.00),
(4, "Ombrello",30.50);

INSERT INTO Negozio values
(1, "Casa Mia", "Roma"),
(2, "Casa Tua", "Napoli"),
(3, "Tutto per tutti", "Napoli"),
(4, "Uno di tutto","Milano");

INSERT INTO Magazzino VALUES
(1, 1, "Via Amelia"),
(2, 1, "Magazzino B"),
(1, 2, "Mag A"),
(2, 2, "Mag B"),
(1, 3, "A"),
(1, 4, "A");

INSERT INTO Movimenti VALUES
(1, 1, 1, 1, "2021-12-12", 10),
(2, 1, 1, 1, "2021-12-12", -5),
(3, 2, 1, 1, "2021-12-12", 10),
(4, 2, 1, 1, "2021-12-12", 10),
(5, 1, 2, 2, "2021-12-12", 10),
(6, 2, 2, 2, "2021-12-12", 10),
(7, 3, 2, 2, "2021-12-12", 10),
(8, 4, 2, 2, "2021-12-12", 10),
(9, 2, 1, 1, "2021-12-12", -20);

