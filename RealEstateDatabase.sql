create database if not exists estate;

use estate;

drop table if exists application;
drop table if exists owner;
drop table if exists contract;
drop table if exists lease;
drop table if exists rental;
drop table if exists task;
drop table if exists applicant;
drop table if exists tenant;
drop table if exists contractor;
drop table if exists landlord;

/* landlord */
create table landlord (
   id int NOT NULL AUTO_INCREMENT,
   first_name varchar(32) NOT NULL,
   middle_name varchar(32),
   last_name varchar(32) NOT NULL,
   password varchar(32),
   username varchar(32),
   role varchar(32) default 'USER',
   enabled tinyint(1) default '1',
   primary key (id));
   
/* contractor */
create table contractor (
   id int NOT NULL AUTO_INCREMENT,
   first_name varchar(32) NOT NULL,
   middle_name varchar(32),
   last_name varchar(32) NOT NULL,
   type varchar(32) NOT NULL,
   primary key (id));

/* tenant */
create table tenant (
   id int NOT NULL AUTO_INCREMENT,
   first_name varchar(32) NOT NULL,
   middle_name varchar(32),
   last_name varchar(32) NOT NULL,
   job varchar(32),
   primary key (id));

/* applicant */
create table applicant (
   id int NOT NULL AUTO_INCREMENT,
   first_name varchar(32) NOT NULL,
   middle_name varchar(32),
   last_name varchar(32) NOT NULL,
   accepted BIT,
   job varchar(32),
   primary key (id));

/* task */
create table task (
   id int NOT NULL AUTO_INCREMENT,
   type varchar(32) NOT NULL,
   description varchar(128),
   primary key (id));

/* rental */
create table rental (
   id int NOT NULL AUTO_INCREMENT,
   street_number int NOT NULL,
   street_name varchar(32) NOT NULL,
   city varchar(32) NOT NULL,
   state varchar(32) NOT NULL,
   primary key (id));

/* Lease */
create table lease (
   start_date DATE NOT NULL,
   end_date DATE,
   rent REAL,
   lease_data BLOB,
   landlord_id int NOT NULL,
   tenant_id int NOT NULL,
   rental_id int NOT NULL,
   primary key (start_date),
   foreign key (landlord_id) references landlord(id),
   foreign key (tenant_id) references tenant(id),
   foreign key (rental_id) references rental(id));

/* contract */
create table contract (
   start_date DATE NOT NULL,
   end_date DATE,
   cost REAL,
   contract_data BLOB,
   landlord_id int NOT NULL,
   contractor_id int NOT NULL,
   task_id int NOT NULL,
   rental_id int NOT NULL,
   primary key (start_date),
   foreign key (landlord_id) references landlord(id),
   foreign key (contractor_id) references contractor(id),
   foreign key (task_id) references task(id),
   foreign key (rental_id) references rental(id));

/* owner */
create table owner (
   purchase_date DATE NOT NULL,
   price REAL,
   deed_data BLOB,
   landlord_id int NOT NULL,
   rental_id int NOT NULL,
   primary key (purchase_date),
   foreign key (landlord_id) references landlord(id),
   foreign key (rental_id) references rental(id));

/* application */
create table application (
   move_date DATE NOT NULL,
   applicant_id int NOT NULL,
   rental_id int NOT NULL,
   primary key (move_date),
   foreign key (applicant_id) references applicant(id),
   foreign key (rental_id) references rental(id));
