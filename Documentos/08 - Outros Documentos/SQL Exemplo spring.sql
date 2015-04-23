create database sistema;
use sistema;
create table usuario
( 
	id serial not null,
	nome varchar(50),
	sobrenome varchar(50),
	username varchar(50),
	senha varchar(10),
	confirmaSenha varchar(10),
	email varchar(50),
	dataCadastro date,
	tipoUsuario varchar(50),
	CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

create table produto
(
  id serial not null,
  nome character varying(50),
  descricao character varying(100),
  preco double precision,
  datacadastro date,
  idUsuario int, 
  CONSTRAINT produto_pkey PRIMARY KEY (id)
);