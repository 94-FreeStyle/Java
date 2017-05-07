drop database mse;

create database mse;

alter database mse character set utf8;

use mse;

create table mse.page_url(
    url varchar(128) primary key not null,
    local_path varchar(128) not null
)DEFAULT CHARSET=utf8;

create table mse.page_info(
    url varchar(128) primary key not null,
    title varchar(256),
    keywords varchar(512),
    con longtext not null,
    cre_date varchar(32), 
    got_time TIMESTAMP not null,
    page_rank double
)DEFAULT CHARSET=utf8;

create table mse.page_links(
    url varchar(128) not null,
    link varchar(128) not null,
    primary key(url, link)
)DEFAULT CHARSET=utf8;

create table mse.inverted_index(
    word varchar(64) not null,
    page_url char(128) not null,
    tf_idf double,
    primary key(word, page_url),
    foreign key(page_url) references mse.page_info(url)
)DEFAULT CHARSET=utf8;


