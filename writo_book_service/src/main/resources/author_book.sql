drop database if exists writo_author;
create schema writo_author;

use writo_author;

create tabe author(
	author_id int primary key,
	name varchar(30),
	email varchar(30),
	phone_no bigint
);


drop database if exists writo_book;
create schema writo_book;

use writo_book;

create table book (
	book_id int primary key,
	book_name varchar(50),
	genere varchar(12),
	author_id int
);




