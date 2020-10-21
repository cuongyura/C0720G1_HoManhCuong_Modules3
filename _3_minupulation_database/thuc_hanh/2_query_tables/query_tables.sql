create database `erxecise_2`;
use `erxecise_2`;

create table customer(
customerNumber int,
customerName varchar(50),
contactLastName varchar(50),
contactFirstName varchar(50),
addressLine1 varchar(50), 
addressLine2 varchar(50),
phone varchar(11),
city varchar(20),
state varchar(15),
postalCode varchar(50),
country varchar(50),
saleRepEmployeeNuber int,
creditLimit varchar(20),
primary key(customerNumber)
);

create table orders(
orderNumber int,
orderDate date,
requiredDate date,
status varchar(50),
comments varchar(50),
customerNumber int,
primary key(orderNumber),
foreign key(customerNumber) references customer(customerNumber)
);

create table payments(
customerNumber int,
checkNumber int,
paymentDate date,
amount float,
primary key(customerNumber,checkNumber),
foreign key(customerNumber) references customer(customerNumber)
);


insert into customer values(1,1,1,1,1,1,1,1,1,1,1,1,1);      
insert into orders values (1, "2020/01/01", "2020/01/01", "status1", "comment1", 1);
insert into payments values (1, 1, "2200/12/12", 1);

select customer.customerNumber, customerName, phone, paymentDate, amount from customer
inner join payments
on customer.customerNumber = payments.customerNumber
where city = '1';

select customer.customerNumber, customer.customerName, orders.orderNumber, orders.status
from customer
left join orders
on customer.customerNumber = orders.customerNumber;

select customer.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customer LEFT JOIN orders
on customer.customerNumber = orders.customerNumber
where orderNumber is null;