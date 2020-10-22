create database `exciers`;
use `exciers`;

create table student(
student_id int,
student_name varchar(20),
age int,
course varchar(20),
money float
);

insert into student values (1, "Hoang", 21, "CNTT", 40000.0);
insert into student values (2, "Viet", 19, "DTVT", 320000.0);
insert into student values (3, "Thanh", 18, "KTDN", 45000.0);
insert into student values (4, "Nhan", 19, "CK", 45000.0);
insert into student values (5, "Hoang", 20, "TCNH", 50000.0);
insert into student values (5, "Hoang", 20, "TCNH", 200000.0);

select * from student;
select * from student where student.student_name = "Huong";
select student_name, sum(money) from student where student.student_name = "Huong";
select distinct student_name from student ;