create table articulo (id bigint generated by default as identity (start with 1), descripcion varchar(200), id_producto varchar(10), modelo varchar(10), nombre varchar(20), precio numeric(10,2), primary key (id));
 alter table articulo add constraint UK_1ur1q81tjybrtrbmyn0apa6ep unique (id_producto);