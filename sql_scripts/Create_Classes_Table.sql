create table classes (
id integer not null auto_increment,
class_location varchar(100) not null,
class_name varchar(100) not null,
num_students integer not null,
primary key (id)
) engine=InnoDB
