# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  id                        integer auto_increment not null,
  author                    varchar(255),
  collection                varchar(255),
  other                     varchar(255),
  title                     varchar(255),
  user                      varchar(255),
  constraint pk_book primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table book;

SET FOREIGN_KEY_CHECKS=1;

