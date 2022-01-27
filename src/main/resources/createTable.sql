create table cryptocurrency
(
    id     bigint       not null
        primary key,
    price  double       null,
    symbol varchar(255) null
);

create table orders
(
    id                bigint auto_increment
        primary key,
    saved_price       double       null,
    username          varchar(255) null,
    cryptocurrency_id bigint       null,
    constraint FKjv3synk5sb0045f6p4285wceg
        foreign key (cryptocurrency_id) references cryptocurrency (id)
);



insert into crypto_currency_watcher.cryptocurrency (id, price, symbol)
values  (80, 2381.05, 'ETH'),
        (90, 36095.58, 'BTC'),
        (48543, 89.11, 'SOL');