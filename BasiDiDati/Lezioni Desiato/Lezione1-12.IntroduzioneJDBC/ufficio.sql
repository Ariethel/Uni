drop schema ufficio;
create schema ufficio;
use ufficio;

create table dipartimenti(
nomedip char(30) primary key,
via varchar(50) not null,
cv char(3) not null,
citta varchar(10) not null
);

create table impiegati(
matricola char(4) primary key,
nome varchar(15) not null,
cognome varchar(15) not null,
dipart char(30) 
	references dipartimenti(nomedip)
    on delete set null
    on update cascade,
ufficio dec(3) not null,
stipendio dec(5) default 0
);



insert into impiegati values
("I01","Mario","Rossi","Amministrazione",10,45),
("I02","Carlo","Bianchi","Produzione",20,36),
("I03","Giovanni","Verdi","Amministrazione",20,40),
("I04","Franco","Neri","Distribuzione",16,45),
("I05","Carlo","Rossi","Direzione",14,80),
("I06","Lorenzo","Gialli","Direzione",7,75),
("I07","Paola","Rosati","Amministrazione",75,40),
("I08","Marco","Franco","Produzione",20,46),
("I09","Matteo","Brutti",null,25,11);

insert into dipartimenti values
("Amministrazione","Tito Livio","27","Milano"),
("Direzione","Tito Livio","27","Milano"),
("Distribuzione","Segre","9","Roma"),
("Produzione","P.Ie Lavater","3","Torino"),
("Ricerca","Venosa","6","Milano");

