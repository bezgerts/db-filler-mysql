CREATE TABLE otus_db_example.products
(
    id          varchar(50)   not null,
    name        varchar(50)   not null,
    description varchar(1024) not null,
    link        varchar(50)   not null,
    supplier_id varchar(50)   not null,
    cost        integer       not null,

    constraint products_pk primary key (id),
    constraint products_suppliers_id_fk foreign key (supplier_id) references otus_db_example.suppliers (id)
);