CREATE TABLE otus_db_example.suppliers
(
    id            varchar(50)  not null,
    name varchar(50)  not null,
    address       varchar(150) not null,

    constraint pk_suppliers primary key (id)
);