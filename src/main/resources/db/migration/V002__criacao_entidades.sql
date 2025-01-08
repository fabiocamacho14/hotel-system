drop table hotel;

create table hotel (
    id integer not null auto_increment,
    atualizado_em datetime(6),
    criado_em datetime(6) not null,
    numero_residencial varchar(20) not null,
    numero_telefone varchar(20) not null,
    bairro varchar(255) not null,
    cep varchar(255) not null,
    cidade varchar(255) not null,
    complemento varchar(255) not null,
    descricao varchar(255) not null,
    email varchar(255) not null,
    estado varchar(255) not null,
    logradouro varchar(255) not null,
    nome varchar(255) not null,
    numero varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table hotel_dono (
    hotel_id integer not null,
    usuario_id integer not null,
    primary key (hotel_id, usuario_id)
) engine=InnoDB;

create table quarto (
    hotel_id integer not null,
    id integer not null auto_increment,
    tem_banheiro bit not null,
    tipo_quarto tinyint not null check (tipo_quarto between 0 and 5),
    valor_diaria float(53) not null,
    atualizado_em datetime(6),
    criado_em datetime(6) not null,
    codigo_quarto varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table reserva (
    data_entrada date,
    data_saida date,
    forma_pagamento tinyint not null check (forma_pagamento between 0 and 5),
    id integer not null auto_increment,
    quarto_id integer not null,
    usuario_id integer not null,
    valor_total float(53) not null,
    atualizado_em datetime(6),
    criado_em datetime(6) not null,
    codigo_reserva varchar(255) not null,
    observacoes varchar(255),
    primary key (id)
) engine=InnoDB;

create table usuario (
    data_nascimento date,
    id integer not null auto_increment,
    atualizado_em datetime(6),
    criado_em datetime(6) not null,
    rg varchar(9) not null,
    cpf varchar(11) not null,
    numero_residencial varchar(20) not null,
    numero_telefone varchar(20) not null,
    bairro varchar(255) not null,
    cep varchar(255) not null,
    cidade varchar(255) not null,
    complemento varchar(255) not null,
    email varchar(255) not null,
    estado varchar(255) not null,
    logradouro varchar(255) not null,
    nacionalidade varchar(255) not null,
    nome varchar(255) not null,
    numero varchar(255) not null,
    primary key (id)
) engine=InnoDB;

alter table hotel_dono
    add constraint FK_USUARIO_HOTEL
    foreign key (usuario_id)
    references usuario (id);

alter table hotel_dono
    add constraint FK_HOTEL_USUARIO
    foreign key (hotel_id)
    references hotel (id);

alter table quarto
    add constraint FK_QUARTO_HOTEL
    foreign key (hotel_id)
    references hotel (id);

alter table reserva
    add constraint FK_RESERVA_QUARTO
    foreign key (quarto_id)
    references quarto (id);

alter table reserva
    add constraint FK_RESERVA_USUARIO
    foreign key (usuario_id)
    references usuario (id);