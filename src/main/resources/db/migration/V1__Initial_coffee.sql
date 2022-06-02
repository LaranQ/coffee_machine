create table coffee
(
    id    int4 generated by default as identity,
    name  varchar(16) not null,
    beans int4        not null,
    milk  int4        not null,
    water int4        not null,
    primary key (id)
);

create table coffee_machine
(
    id                 int4 generated by default as identity,
    name               varchar(32) not null,
    beans              int4        not null,
    milk               int4        not null,
    water              int4        not null,
    count_before_dirty int4        not null default 5,
    primary key (id)
);

create table coffee_orders
(
    id             int4 generated by default as identity,
    coffee         int4,
    coffee_machine int4,
    date           timestamp not null,
    primary key (id)
);

alter table if exists coffee_orders
    add constraint FKnro7h9l5l2l0fgj14w012kgjb
        foreign key (coffee) references coffee;

alter table if exists coffee_orders
    add constraint FK7bywc6p97r38jeshncbmfynsq
        foreign key (coffee_machine) references coffee_machine;