create table students (
id integer not null auto_increment,
email varchar(45) not null,
first_name varchar(45) not null,
last_name varchar(45) not null,
password varchar(15) not null,
major varchar(45),
classification varchar(45) not null,
class_id integer,
primary key (id)
) engine=InnoDB
