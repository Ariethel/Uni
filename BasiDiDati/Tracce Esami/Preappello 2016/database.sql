drop schema if exists preappello2016;
create schema preappello2016;
use preappello2016; 

create table Spettacolo(
Nome varchar(16),
Anno int not null 
);


create table Artisti(
Tessera int primary key,
ddnascita int
);

create table Lavoro(
Tessera int references Artisti.Tessera,
Anno int
);

insert into Spettacolo values
("Soledad",2006),
("Soledad", 2007),
("Soledad", 2008),
("Matteo", 2009);

insert into Artisti values
(123, 2016),
(234, 2017);

insert into Lavoro values
(123, 2016),
(123, 2017),
(234, 2020);