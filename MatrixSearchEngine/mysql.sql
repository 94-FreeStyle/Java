drop database mse;

create database mse;

alter database mse character set utf8;

use mse;

create table mse.spider(
    url varchar(128) primary key not null,
    local_path varchar(128) not null
)DEFAULT CHARSET=utf8;

create table mse.page_con(
    url varchar(128) primary key not null,
    title varchar(256),
    keywords varchar(512),
    con longtext not null,
    cre_date varchar(32), 
    page_rank double
)DEFAULT CHARSET=utf8;

create table mse.inverted_index(
    word varchar(64) not null,
    page_url char(128) not null,
    tf_idf double,
    primary key(word, page_url),
    foreign key(page_url) references mse.page_con(url)
)DEFAULT CHARSET=utf8;


