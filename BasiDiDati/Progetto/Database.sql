drop schema if exists progetto;
create schema progetto;
use progetto;

create table utenti(
CF char(16) primary key,
Nome varchar(20) not null,
Cognome varchar(20) not null,
Citta varchar(20) not null,
CV numeric(4) not null,
Via varchar(20) not null,
Tipo varchar(20) not null,
DataIscrizione date not null,
TipoAbbonamento varchar(20),
ScadenzaAbbonamento date default null,
ScadenzaProva date default null
);


create table album(
NomeAlbum varchar(20) primary key,
DataPubblicazione date not null,
DurataComplessiva decimal(4,2) not null,
NumeroCanzoni int default 0
);

create table playlist(
Codice int primary key,
CF char(16) references utenti.CF
on update cascade,
DurataComplessiva decimal(4,2) not null,
NumeroCanzoni int not null
);

create table generi(
Nome varchar(20) primary key
);

create table autori(
NomeAutore varchar(20) primary key,
AnniEsperienza int not null
);

create table ascoltare(
CF char(16) references utenti.CF on update cascade,
Titolo varchar(20) references canzoni.titolo on update cascade,
UltimoAscolto date not null
);

create table raccogliere(
Codice int references playlist.Codice on update cascade,
Titolo varchar(20) references canzoni.titolo on update cascade
);

create table canzoni(
Titolo varchar(20) primary key,
NomeAlbum varchar(20) references album.NomeAlbum on update cascade,
Lunghezza decimal(4,2) not null
);

create table afferire(
Titolo varchar(20) references canzoni.Titolo on update cascade,
Nome varchar(20) references generi.nome on update cascade
);

create table comporre(
Titolo varchar(20) references canzoni.Titolo on update cascade,
NomeAutore varchar(20) references autori.NomeAutore on update cascade
);

create table incidere(
NomeAutore varchar(20) references autori.NomeAutore on update cascade,
NomeAlbum varchar(20) references album.NomeAlbum on update cascade
);

insert into utenti(CF, Nome, Cognome, Citta, CV, Via, Tipo, DataIscrizione, TipoAbbonamento) values
("AAAAAAAAAAAAAAAA", "Donald", "Duck", "Napoli", "15", "V. Leoni", "Abbonato", "2022-01-01", "Mensile"), 
("BBBBBBBBBBBBBBBB", "Mickey", "Mouse", "Salerno", "21", "V. Vittoria", "Free", "2021-04-07", null),
("CCCCCCCCCCCCCCCC", "Aldo", "Baglio", "Palermo", "101", "V. Africa", "Abbonato", "2021-06-12", "Annuale"),
("DDDDDDDDDDDDDDDD", "Giovanni", "Storti", "Milano", "13", "Viale Amedeo", "Free", "2021-08-22", null),
("EEEEEEEEEEEEEEEE", "Giacomo", "Poretti", "Milano", "115", "Piazza Leopardi", "Abbonato", "2021-10-09","Mensile");

insert into album (NomeAlbum, DataPubblicazione, DurataComplessiva) values
("Fallen", "2003-03-04", (44.19)),
("Damnati ad Metalla", "2010-03-15", (50.36)),
("My Favorite Things", "1960-10-30", (90.45)),
("La buona novella", "1970-11-01", (35.21));

insert into generi values
("Folk Metal"),
("Goth Metal"),
("Jazz"),
("Musica d'autore");

insert into autori values
("Evanecence", 27),
("Folkstone", 11),
("Coltrane", 56),
("Fabrizio De Andre", 59);

insert into canzoni values
("Going Under","Fallen",03.34),
("Bring Me to Life", "Fallen", 03.57),
("Everybody's fool", "Fallen", 03.15),
("My Immortal", "Fallen", 04.24),
("Haunted", "Fallen", 03.06),
("Tourniquet", "Fallen", 04.38),
("Imaginary", "Fallen", 04.17),
("Taking Over Me", "Fallen", 03.49),
("Hello", "Fallen", 03.40),
("My Last Breath", "Fallen", 04.07),
("Whisper", "Fallen", 05.27),
("Ol bal di Oss ", "Damnati ad Metalla", "01.52"),
("Longobardia", "Damnati ad Metalla", "01.52");