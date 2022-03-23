drop schema if exists modelloMvcDB;
create schema modelloMvcDB;
use modelloMvcDB;

create table utente(
id int primary key,
first_name varchar(255) not null,
last_utentename varchar(255) not null,
balance double not null
);

insert into utente(id,first_name,last_name,balance) values
(1,"Harry", "Hacker", "-3456.78"),
(2,"Codie", "Coder", "234.56"),
(3,"Polly", "Programmer", "987654.32");