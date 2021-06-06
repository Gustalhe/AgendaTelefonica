CREATE DATABASE dbAgenda;
USE dbAgenda;

CREATE TABLE tbAgenda(
	id int auto_increment,
	nome varchar(55),
    sobrenome varchar(55),
    dataNac varchar(25),
    numero1 varchar(25),
    numero2 varchar(25),
    numero3 varchar(25),
    parentesco varchar(25),
	 CONSTRAINT pk_tbAgenda PRIMARY KEY (id)
);

select * from tbAgenda;


