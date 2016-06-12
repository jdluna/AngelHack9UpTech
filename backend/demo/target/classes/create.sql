create database demo;
create table PushNotifications (
        id bigint not null auto_increment,
        identificador varchar(13) not null,
        indicadorMetano float not null,
        indicadorAmoniaco float not null,
        indicadorTemperatura float not null,
        indicadorHumedad float not null,
        indicadorCrecimiento float not null,
        indicadorCo2 float not null,
        indicadorLuz float not null,
        longitud decimal(11,8) not null,
        latitud decimal(10,8) not null,
        fechaRegistro timestamp not null,
        primary key (id)
);
