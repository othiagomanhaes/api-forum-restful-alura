create table curso(
    id bigint not null AUTO_INCREMENT,
    nome varchar(50) not null,
    categoria varchar(50) not null,
    primary key(id)
);

insert into curso values(1, 'Kotlin', 'Programação');