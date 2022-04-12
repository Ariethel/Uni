drop schema if exists MvcCat;
create schema MvcCat;
use MvcCat;

create table prodotto(
id_prod int primary key,
nome varchar(255) not null,
descrizione varchar(255),
prezzo double not null
);

create table categoria(
id_cat int primary key,
nome varchar(255) not null,
descrizione varchar(255)
);

create table prod_cat(
id_prod int,
id_cat int,
primary key(id_prod,id_cat)
);


insert into prodotto(id_prod,nome,descrizione,prezzo) values
(1,"prod 1",null, 40),
(2,"prod 2",null, 40),
(3,"prod 3",null, 40),
(4,"prod 4",null, 40),
(5,"prod 5",null, 40);

insert into categoria values
(1,"cat 1",null),
(2,"cat 2",null),
(3,"cat 3",null);

insert into prod_cat values
(1,1),
(2,1),
(3,2),
(4,3),
(5,3);