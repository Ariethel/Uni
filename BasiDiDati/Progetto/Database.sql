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