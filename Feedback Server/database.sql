create table if not exists answer
(
    id int auto_increment
    primary key,
    question_id int null,
    answer varchar(200) null
    );

create table if not exists feedback
(
    id int auto_increment
    primary key,
    customer_name varchar(200) null,
    answer_id int null,
    received_date datetime null
    );

create table if not exists question
(
    id int auto_increment
    primary key,
    question varchar(200) null,
    type varchar(200) null
    );

create table if not exists user
(
    id int auto_increment
    primary key,
    username varchar(200) null,
    password varchar(200) null,
    role varchar(200) null
    );

