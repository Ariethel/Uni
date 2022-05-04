drop schema if exists DBProgTSW;
create schema DBProgTSW;
use DBProgTSW;

create table utente(
email varchar(255) not null,
pass varchar(255) not null,
tipo varchar(255) not null,
primary key (email, pass)
);

create table ordine(
u_email varchar(255),
u_pass varchar(255),
n_ordine int primary key,
foreign key (u_email,u_pass) references utente(email,pass)
);

create table album(
a_titolo varchar(255) primary key,
prezzo double not null
);

create table compone(
n_ordine int references ordine(n_ordine),
a_titolo varchar(255) references album(a_titolo),
primary key(n_ordine,a_titolo)
);

create table seleziona(
u_email varchar(255) references utente(email),
u_pass varchar(255) references utente(pass),
a_titolo varchar(255) references album(a_titolo),
primary key(u_email,u_pass,a_titolo)
);

create table aggiunge(
u_email varchar(255) references utente(email),
u_pass varchar(255) references utente(pass),
a_titolo varchar(255) references album(a_titolo),
primary key(u_email,u_pass,a_titolo)
);

create table modifica(
u_email varchar(255) references utente(email),
u_pass varchar(255) references utente(pass),
a_titolo varchar(255) references album(a_titolo),
primary key(u_email,u_pass,a_titolo)
);

create table rimuove(
u_email varchar(255) references utente(email),
u_pass varchar(255) references utente(pass),
a_titolo varchar(255) references album(a_titolo),
primary key(u_email,u_pass,a_titolo)
);
