drop schema if exists progetto;
create schema progetto;
use progetto;

create table utenti( #fatta
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


create table album( #fatta
NomeAlbum varchar(20) primary key,
DataPubblicazione date not null,
DurataComplessiva decimal(4,2) not null,
NumeroCanzoni int default 0
);

create table playlist( #fatta
Codice int primary key,
CF char(16) references utenti.CF
on update cascade,
DurataComplessiva decimal(4,2) default 0,
NumeroCanzoni int default 0
);

create table generi( #fatta
Nome varchar(20) primary key
);

create table autori( #fatta
NomeAutore varchar(20) primary key,
AnniEsperienza int not null
);

create table ascoltare( #Voglio inseirire canzoni ascoltate soltanto da GUI con un bottone ed una ricerca
CF char(16) references utenti.CF on update cascade,
Titolo varchar(20) references canzoni.titolo on update cascade,
UltimoAscolto date not null
);

create table raccogliere( #fatta
Codice int references playlist.Codice on update cascade,
Titolo varchar(20) references canzoni.titolo on update cascade
);

create table canzoni( #fatta
Titolo varchar(20) primary key,
NomeAlbum varchar(20) references album.NomeAlbum on update cascade,
Lunghezza decimal(4,2) not null
);

create table afferire( # fatta
Titolo varchar(20) references canzoni.Titolo on update cascade,
Nome varchar(20) references generi.nome on update cascade
);

create table comporre( #fatta
Titolo varchar(20) references canzoni.Titolo on update cascade,
NomeAutore varchar(20) references autori.NomeAutore on update cascade
);

create table incidere( #fatta
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
("Celtic"),
("Ballad"),
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
("Ol bal di Oss ", "Damnati ad Metalla", 01.52),
("Longobardia", "Damnati ad Metalla", 04.07),
("Aufstand", "Damnati ad Metalla", 03.48),
("Anime dannate", "Damnati ad Metalla", 04.51),
("Freri", "Damnati ad Metalla", 04.33),
("Un'altra VoltaAncora", "Damnati ad Metalla", 03.57),
("Luppulus in fabula", "Damnati ad Metalla", 04.42),
("Terra santa", "Damnati ad Metalla", 04.00),
("Senza certezze", "Damnati ad Metalla", 04.33),
("Vortici scuri", "Damnati ad Metalla", 03.48),
("Nell'altro cadro", "Damnati ad Metalla", 04.40),
("Vanita di vanita", "Damnati ad Metalla", 03.26),
("Rocce nere", "Damnati ad Metalla", 02.00),
("Part 1","My Favorite Things",02.45),
("Part 2","My Favorite Things",03.02),
("Laudate Dominum","La buona novella", 00.21),
("L'infanzia diMaria","La buona novella", 05.01),
("Il ritornodiGiuseppe","La buona novella", 04.04),
("Il sogno di Maria","La buona novella", 04.07),
("Ave Maria","La buona novella", 01.51),
("Via della croce","La buona novella", 04.31),
("Tre madri","La buona novella", 02.55),
("Il testamento diTito","La buona novella", 05.51),
("Laudate Hominem","La buona novella", 03.27);

insert into playlist (Codice,CF) values
(111, "AAAAAAAAAAAAAAAA"),
(222, "CCCCCCCCCCCCCCCC"),
(333, "EEEEEEEEEEEEEEEE");

insert into raccogliere values
(111,"Ave Maria"),
(111,"Part 2"),
(111,"Freri"),
(222,"Il testamento diTito"),
(222,"Going Under"),
(333,"Longobardia"),
(333,"Rocce Nere"),
(333,"Whisper");

insert into afferire values
("Aufstand", "Folk Metal"),
("Aufstand", "Celtic"),
("Part 1", "Jazz"),
("Part 2", "Jazz"),
("Bring Me to Life","Goth Metal"),
("Bring Me to Life","Musica d'autore");

insert into comporre values
("Going Under","Evanescence"),
("Bring Me to Life", "Evanescence"),
("Everybody's fool", "Evanescence"),
("My Immortal", "Evanescence"),
("Haunted", "Evanescence"),
("Tourniquet", "Evanescence"),
("Imaginary", "Evanescence"),
("Taking Over Me", "Evanescence"),
("Hello", "Evanescence"),
("My Last Breath", "Evanescence"),
("Whisper", "Evanescence"),
("Ol bal di Oss ", "Folkstone"),
("Longobardia", "Folkstone"),
("Aufstand", "Folkstone"),
("Anime dannate", "Folkstone"),
("Freri", "Folkstone"),
("Un'altra VoltaAncora", "Folkstone"),
("Luppulus in fabula", "Folkstone"),
("Terra santa", "Folkstone"),
("Senza certezze", "Folkstone"),
("Vortici scuri", "Folkstone"),
("Nell'altro cadro", "Folkstone"),
("Vanita di vanita", "Folkstone"),
("Rocce nere", "Folkstone"),
("Part 1","Coltrane"),
("Part 2","Coltrane"),
("Laudate Dominum","Fabrizio De Andre"),
("L'infanzia diMaria","Fabrizio De Andre"),
("Il ritornodiGiuseppe","Fabrizio De Andre"),
("Il sogno di Maria","Fabrizio De Andre"),
("Ave Maria","Fabrizio De Andre"),
("Via della croce","Fabrizio De Andre"),
("Tre madri","Fabrizio De Andre"),
("Il testamento diTito","Fabrizio De Andre"),
("Laudate Hominem","Fabrizio De Andre");

insert into incidere values
("Evanescence","Fallen"),
("Folkstone","Damnati ad Metalla"),
("Coltrane","My Favorite Things"),
("Fabrizio De Andre","La buona novella");