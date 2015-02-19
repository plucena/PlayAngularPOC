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

drop table if exists book cascade;

drop sequence if exists book_seq;

