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
ScadenzaAbbonamento date,
ScadenzaProva date
);


create table album(
NomeAlbum varchar(20) primary key,
DataPubblicazione date not null,
DurataComplessiva decimal(2,2) not null,
NumeroCanzoni int not null
);

create table playlist(
Codice int primary key,
CF char(16) references utenti.CF
on update cascade,
DurataComplessiva decimal(2,2) not null,
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
Lunghezza decimal(2,2) not null
);

create table afferire(
Titolo varchar(20) references canzoni.Titolo on update cascade,
Nome varchar(20) references generi.nome
);

create table comporre(
Titolo varchar(20) references canzoni.Titolo on update cascade,
NomeAutore varchar(20) references autori.NomeAutore on update cascade
);

create table incidere(
NomeAutore varchar(20) references autori.NomeAutore on update cascade,
NomeAlbum varchar(20) references album.NomeAlbum on update cascade
);