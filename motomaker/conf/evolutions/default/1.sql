# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  id                        integer not null,
  author                    varchar(255),
  collection                varchar(255),
  other                     varchar(255),
  title                     varchar(255),
  reader                    varchar(255),
  constraint pk_book primary key (id))
;

create sequence book_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists book;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists book_seq;

