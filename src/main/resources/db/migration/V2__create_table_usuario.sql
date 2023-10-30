create table usuario(
    id bigint not null AUTO_INCREMENT,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into usuario values(1, 'Thiago', 'thiago@email.com');