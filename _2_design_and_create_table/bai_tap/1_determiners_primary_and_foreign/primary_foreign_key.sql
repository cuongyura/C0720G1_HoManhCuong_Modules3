-- create database:
create database `java_web_back_end_development`;
-- use database:
use `java_web_back_end_development`;

-- create table Customers:
create table Customers(
customer_number int(11) not null unique auto_increment,
fullnamee varchar(50),
address varchar(50),
email varchar(30) unique,
phone varchar(11) unique,
PRIMARY KEY(customer_number)
);

-- create table Customers:
create table Accounts(
 account_number int(11) not null unique auto_increment ,
 account_type varchar(15),
 account_date datetime,
 balance float,
 
 PRIMARY KEY(account_number),
 FOREIGN KEY (customer_number) REFERENCES Customers(customer_number)
);

-- create table Customers:
create table  transactions(
tran_number varchar(11) unique,
account_number int(11),
account_date datetime,
amounts int,
Accounts_description varchar(50),

PRIMARY KEY(tran_number),
 FOREIGN KEY (account_number) REFERENCES Accounts(account_number)
);




