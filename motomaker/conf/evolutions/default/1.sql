# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  id                        integer not null,
  author                    varchar(255) not null,
  collection                varchar(255) not null,
  other                     varchar(255),
  title                     varchar(255) not null,
  reader                    varchar(255) not null,
  constraint pk_book primary key (id))
;

create sequence book_seq;




# --- !Downs

drop table if exists book cascade;

drop sequence if exists book_seq;

