alter table reserva
    add column duracao_dias integer;

alter table reserva
    add column hotel_id integer not null;

alter table reserva
    add constraint FK_RESERVA_HOTEL
    foreign key (hotel_id)
    references hotel (id);