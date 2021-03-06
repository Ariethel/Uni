drop schema if exists modelloMvcDB;
create schema modelloMvcDB;
use modelloMvcDB;

create table utente(
id int primary key auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
balance double not null,
bookmark boolean default 0
);

insert into utente(first_name,last_name,balance,bookmark) values
("Harry", "Hacker", "-3456.78",1),
("Codie", "Coder", "234.56",0),
("Polly", "Programmer", "987654.32",0utente);