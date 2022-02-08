drop database if exists unisa2022;
create database unisa2022;
use unisa2022;

create table utenti (
CF char(16) primary key,
nome varchar(30) not null,
cognome varchar(30) not null,
eta dec
);

create table citta (
nome char(40),
prov char(5),
descrizione varchar(255),
primary key (nome,prov) /* Scrivo per dire che la chiave di questa tabella e' formata da nome e provincia */
);

create table visite (
CF char(16),
citta char(40),
prov char(5),
giorno date not null,
primary key (CF,citta,prov),
foreign key (CF) references utenti(CF),
foreign key (citta, prov) references citta(nome, prov)
);

create table auto (
targa char(8) primary key,
modello char(20) not null,
marca char(20) not null,
cat char(1) not null
);

create table noleggio(
CF char(16),
targa char(8),
dal date not null,
al date,
primary key (CF, targa),
foreign key (CF) references utenti(CF), /*Imposto il vincolo ViR tra CF di noleggio e CF di utenti*/
foreign key (targa) references auto(targa) /* Altro vincolo di integrita referenziale*/
);


/* Inserisco dei valori nella tabella utenti */
insert into utenti values
("AAA", "Pippo", "Bianco", 25),
("BBB", "Antonio", "Verdi", null),
("CCC", "Marco", "Rossi", 56)
;

/* Inserisco dei valori nella tabella citta */
insert into citta values
("Roma", "RM", "Capitale Italia"),
("Napoli", "NA", null),
("Fisciano", "SA", "Sede UniSA")
;

insert into visite values
("AAA","Roma","RM","2021-11-20"), # La data e' di tipo aa/mm/dd
("CCC", "Fisciano","SA","2021-11-30");

insert into auto values
("ABC","A4","Audi","A"),
("DEF","Clio","Renault","C"),
("GHI", "Panga", "Fiat", "C");

insert into noleggio values
("CCC","ABC","2021-11-30",null);