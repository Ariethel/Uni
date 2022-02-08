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
DurataComplessiva decimal(4,2) default 0,
NumeroCanzoni int default 0
);

create table generi( 
Nome varchar(20) primary key
);

create table autori( 
NomeAutore varchar(20) primary key,
AnniEsperienza int not null
);

create table ascoltare( 
Titolo varchar(20) references canzoni.titolo on update cascade,
CF char(16) references utenti.CF on update cascade,
UltimoAscolto date not null,
primary key (Titolo,CF)
);

create table raccogliere( 
Codice int references playlist.Codice on update cascade,
Titolo varchar(20) references canzoni.titolo on update cascade,
primary key (Codice,Titolo)
);

create table canzoni( 
Titolo varchar(20) primary key,
NomeAlbum varchar(20) references album.NomeAlbum on update cascade,
Lunghezza decimal(4,2) not null
);

create table afferire( 
Titolo varchar(20) references canzoni.Titolo on update cascade,
Nome varchar(20) references generi.nome on update cascade,
primary key (Titolo,Nome)
);

create table comporre( 
Titolo varchar(20) references canzoni.Titolo on update cascade,
NomeAutore varchar(20) references autori.NomeAutore on update cascade,
primary key (Titolo,NomeAutore)
);

create table incidere( 
NomeAutore varchar(20) references autori.NomeAutore on update cascade,
NomeAlbum varchar(20) references album.NomeAlbum on update cascade,
primary key (NomeAutore,NomeAlbum)
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
("Ol bal di Oss", "Damnati ad Metalla", 01.52),
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

insert into ascoltare values
("Going Under","AAAAAAAAAAAAAAAA","2003-03-04"),
("Bring Me to Life", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Everybody's fool", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("My Immortal", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Haunted", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Tourniquet", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Imaginary", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Taking Over Me", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Hello", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("My Last Breath", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Whisper", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Ol bal di Oss", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Longobardia", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Aufstand", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Anime dannate", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Freri", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Un'altra VoltaAncora", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Luppulus in fabula", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Terra santa", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Senza certezze", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Vortici scuri", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Nell'altro cadro", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Vanita di vanita", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Rocce nere", "AAAAAAAAAAAAAAAA", "2003-03-04"),
("Part 1","AAAAAAAAAAAAAAAA","2003-03-04"),
("Part 2","AAAAAAAAAAAAAAAA","2003-03-04"),
("Laudate Dominum","AAAAAAAAAAAAAAAA", "2003-03-04"),
("L'infanzia diMaria","AAAAAAAAAAAAAAAA", "2003-03-04"),
("Il ritornodiGiuseppe","AAAAAAAAAAAAAAAA", "2003-03-04"),
("Il sogno di Maria","AAAAAAAAAAAAAAAA", "2003-03-04"),
("Ave Maria","AAAAAAAAAAAAAAAA", "2003-03-04"),
("Via della croce","AAAAAAAAAAAAAAAA", "2003-03-04"),
("Tre madri","AAAAAAAAAAAAAAAA", "2003-03-04"),
("Il testamento diTito","AAAAAAAAAAAAAAAA", "2003-03-04"),
("Tre madri","BBBBBBBBBBBBBBBB", "2003-03-04"),
("Il testamento diTito","BBBBBBBBBBBBBBBB", "2003-03-04"),
("Laudate Hominem","BBBBBBBBBBBBBBBB", "2003-03-04"),
("Laudate Hominem","AAAAAAAAAAAAAAAA", "2003-03-04");

insert into playlist (Codice,CF) values
(111, "AAAAAAAAAAAAAAAA"),
(222, "CCCCCCCCCCCCCCCC"),
(333, "EEEEEEEEEEEEEEEE"),
(444, "DDDDDDDDDDDDDDDD");

insert into raccogliere values
(111,"Ave Maria"),
(111,"Part 2"),
(111,"Freri"),
(222,"Ave Maria"),
(222,"Il testamento diTito"),
(222,"Going Under"),
(333,"Ave Maria"),
(333,"Longobardia"),
(333,"Rocce Nere"),
(333,"Freri"),
(333,"Whisper"),
(444, "Going Under"),
(444, "Bring Me to Life"),
(444, "Everybody's fool"),
(444, "My Immortal"),
(444, "Haunted"),
(444, "Tourniquet"),
(444, "Imaginary"),
(444, "Taking Over Me"),
(444, "Hello"),
(444, "My Last Breath"),
(444, "Whisper"),
(444, "Ol bal di Oss"),
(444, "Longobardia"),
(444, "Aufstand"),
(444, "Anime dannate"),
(444, "Freri"),
(444, "Un'altra VoltaAncora"),
(444, "Luppulus in fabula"),
(444, "Terra santa"),
(444, "Senza certezze"),
(444, "Vortici scuri"),
(444, "Nell'altro cadro"),
(444, "Vanita di vanita"),
(444, "Rocce nere"),
(444, "Part 1"),
(444, "Part 2"),
(444, "Laudate Dominum"),
(444, "L'infanzia diMaria"),
(444, "Il ritornodiGiuseppe"),
(444, "Il sogno di Maria"),
(444, "Ave Maria"),
(444, "Via della croce"),
(444, "Tre madri"),
(444, "Il testamento diTito"),
(444, "Laudate Hominem");


insert into afferire values
("Aufstand", "Folk Metal"),
("Aufstand", "Celtic"),
("Part 1", "Jazz"),
("Part 2", "Jazz"),
("Bring Me to Life","Goth Metal"),
("Bring Me to Life","Musica d'autore"),
("My Immortal", "Ballad"),
("Laudate Dominum", "Ballad");


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

## HO DOVUTO USARE ADDDATE PER AGGIUNGERE I GIORNI NECESSARI ALLE RISPETTIVE DATE DI OGNI UTENTE ## 

# Update ScadenzaAbbonamento per utenti mensili
UPDATE utenti
SET ScadenzaAbbonamento = adddate(DataIscrizione, INTERVAL 30 DAY)
WHERE Tipo = "Abbonato" AND TipoAbbonamento = "Mensile";

# Update ScadenzaAbbonamento per utenti annuali
UPDATE utenti
SET ScadenzaAbbonamento = adddate(DataIscrizione, INTERVAL 365 DAY)
WHERE Tipo = "Abbonato" AND TipoAbbonamento = "Annuale";

# Update ScadenzaProva per utenti free
UPDATE utenti
SET ScadenzaProva = adddate(DataIscrizione, INTERVAL 5 DAY)
WHERE Tipo = "Free";

# View Playlist
drop view if exists NumCanzoni;
CREATE VIEW NumCanzoni AS 
	(SELECT Codice, COUNT(Titolo) as Numero
	 FROM raccogliere
     GROUP BY Codice);
     
drop view if exists DurataPlaylist;
CREATE VIEW DurataPlaylist AS
	(SELECT p.Codice, SUM(c.Lunghezza) as Durata
     FROM playlist p inner join raccogliere r ON p.codice = r.Codice inner join canzoni c ON r.Titolo = c.Titolo
     GROUP BY p.Codice);
     
# View Album
drop view if exists LunghezzaAlbum;
CREATE view LunghezzaAlbum AS
	(SELECT a.NomeAlbum as Titolo, sum(Lunghezza) as Durata
	FROM canzoni c join album a on c.NomeAlbum = a.NomeAlbum
    WHERE c.NomeAlbum = a.NomeAlbum
    GROUP BY a.NomeAlbum);
    
drop view if exists NumeroCanzoniAlbum;
CREATE VIEW NumeroCanzoniAlbum AS
	(SELECT a.NomeAlbum, Count(*) as NumCanzoni
	 FROM album a inner join canzoni c ON a.NomeAlbum = c.NomeAlbum
     GROUP BY a.NomeAlbum);