CREATE TABLE ACTIVE_CHAT
(
    id      bigint auto_increment primary key not null,
    chat_id integer                           not null
);

create table incomes
(
    id      bigint auto_increment primary key not null,
    chat_id integer                           not null,
    income  numeric,
    date    TIMESTAMP                         not null
);

create table spend
(
    id      bigint auto_increment primary key not null,
    chat_id integer                           not null,
    spend   numeric,
    date    TIMESTAMP                         not null
);