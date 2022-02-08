Drop database if exists unisa5;
create database unisa5;
use unisa5;

create table citta (
CAP char(7) primary key,
nome char(30) not null
);

create table evento (
nome char(30) not null,
anno int not null,
citta char(7) not null,
primary key (nome, anno,citta),
foreign key (citta) references citta(CAP)
);

Create table sponsor (
PIVA char(13) primary key,
nome char(30) not null,
nazione char(20)
);

create table sponsorizzazione (
sponsor char(13) not null,
e_nome char(30) not null,
e_anno int not null,
e_citta char(7) not null,
importo decimal(10,2) not null,
primary key (sponsor, e_nome, e_anno, e_citta),
foreign key (e_nome, e_anno, e_citta) references evento(nome, anno, citta),
foreign key (sponsor) references sponsor(PIVA)
);

create table persona (
CF char(16) primary key,
cognome char(30) not null,
nome char(30) not null
);

create table prenotazione (
p_cf char(16) not null,
e_nome char(30) not null,
e_anno int not null,
e_citta char(7) not null,
foreign key (e_nome, e_anno, e_citta) references evento(nome, anno, citta),
data_pren date not null,
foreign key (p_cf) references persona(CF),
primary key (p_cf, e_nome, e_anno, e_citta, data_pren)
);

insert into citta values 
("80100", "Napoli"),
("84100", "Salerno"),
("00100", "Roma"),
("84019", "Vietri"),
("85058", "Vietri")
;

insert into evento values 
("evento uno", 2021, "80100"),
("evento due", 2020, "84100"),
("evento tre", 2022, "00100"),
("evento quattro", 2021, "84019"),
("evento cinque", 2020, "85058"),
("evento sei", 2022, "84019"),

("evento 1", 2018, "80100"),
("evento 2", 2019, "84100"),
("evento 3", 2020, "00100"),

("evento uno", 2019, "80100");

insert into sponsor values
("111", "Asso", "II"),
("222", "Due", "UK"),
("333", "Tre", "ES"),
("444", "Quattro", "II");

insert into sponsorizzazione values
("111", "evento uno", 2021, "80100", 10500),
("222", "evento uno", 2021, "80100", 10500),
("333", "evento uno", 2021, "80100", 10500),
("444", "evento due", 2020, "84100", 20000),
("111", "evento due", 2020, "84100", 10500),
("111", "evento tre", 2022, "00100", 10500);

insert into persona values
("CF1", "Rossi", "Antonio"),
("CF2", "Verdi", "Pasquale"),
("CF3", "Bianchi", "Cosimo"),
("CF4", "Marroni", "Pippo");

insert into prenotazione values
("CF1", "evento uno", 2021, "80100", "2021-01-01"),
("CF2", "evento uno", 2021, "80100", "2021-01-11"),
("CF3", "evento uno", 2021, "80100", "2021-01-21"),
("CF4", "evento uno", 2021, "80100", "2021-01-30"),
("CF1", "evento due", 2020, "84100", "2021-01-01"),
("CF2", "evento due", 2020, "84100", "2021-01-11"),
("CF3", "evento due", 2020, "84100", "2021-01-21"),
("CF1", "evento tre", 2022, "00100", "2021-01-01"),
("CF2", "evento tre", 2022, "00100", "2021-01-11"),
("CF1", "evento tre", 2022, "00100", "2021-01-02"),
("CF2", "evento tre", 2022, "00100", "2021-01-12"),
("CF1", "evento uno", 2019, "80100", "2021-01-01"),
("CF2", "evento uno", 2019, "80100", "2021-01-11"),
("CF1", "evento quattro", 2021, "84019", "2021-01-01"),
("CF2", "evento quattro", 2021, "84019", "2021-01-11"),
("CF3", "evento cinque", 2020, "85058", "2021-01-21"),
("CF4", "evento sei", 2022, "84019", "2021-01-30");





