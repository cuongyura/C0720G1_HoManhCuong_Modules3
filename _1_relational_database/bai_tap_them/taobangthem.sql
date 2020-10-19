-- tạo csdl:
create database `exercise`;

use `exercise`;
-- tạo bảng product:
create table Products(
   Id int,
   Name nvarchar(50),
   UmageUrl nvarchar(1000),
   Price int,
   Discount int,
   Stock int,
   CategoryId int,
   SupplierId int,
   Description nvarchar(200)	
);


insert into Products
values(1, 'Na', 'ddd.png', 32, 10, 15, 5, 6, 'jjjj');
SET SQL_SAFE_UPDATES = 0;

select* from Products;

delete from Products
where id=1;

-- tạo bảng Orders:

create table Orders(
Id int,
createDate datetime,
shippedDate datetime,
Status varchar(50),
Description nvarchar(100),
ShippingCity nvarchar(50),
PaymentType varchar(20),
CustomerId varchar(50),
EmpoyeeId varchar(50)
);

select * from Orders;
