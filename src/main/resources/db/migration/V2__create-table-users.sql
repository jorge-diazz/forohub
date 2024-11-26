create table users(
    id bigint not null auto_increment,
    username varchar(100) not null,
    password varchar(300) not null,
    primary key (id)
);