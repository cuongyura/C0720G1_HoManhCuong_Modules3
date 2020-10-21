-- create csdl:
create database `exercise`;

-- use csdl:
use `exercise`;

-- create table:
create table products(
productCode int not null unique,
productName varchar(50),
productLine varchar(50),
productScale varchar(50),
productVendor varchar(50),
productDescription varchar(50),
quanlityStock float,
buyPrice float,
MSRP varchar(50),
primary key(productLine),
foreign key(productLine) references productlines(productLine)
);

create table productlines(
productLine varchar(50),
textDescription varchar(50),
htmlDescription varchar(50),
image varchar(50),
primary key(productLine)
);

insert into products
values (1, "Name1", "Line1", "Scale1", "Vendor1", "Description1", 100, 55,"MSRP"),
       (2, "Name2", "Line2", "Scale2", "Vendor2", "Description2", 76, 72,"MSRP2"),
       (3, "Name3", "Line3", "Scale3", "Vendor3", "Description3", 52, 46,"MSRP3"),
       (4, "Name4", "Line4", "Scale4", "Vendor4", "Description4", 48, 31,"MSRP4"),
       (5, "Name5", "Line5", "Scale5", "Vendor5", "Description5", 90, 92,"MSRP5");
       
insert into productlines
values ("Product line1", "textDescription1","htmlDescription1","image1"),    
       ( "Product line2", "textDescription2","htmlDescription2","image2"),       
       ( "Product line3", "textDescription4","htmlDescription3","image3"),       
       ( "Product line4", "textDescription4","htmlDescription4","image4"),       
       ( "Product line5", "textDescription5","htmlDescription5","image5");       
       
select* from products;
select* from productlines;       

select productCode, productName, buyPrice, quanlityStock from products
where buyPrice > 31 and  quanlityStock > 10;

SELECT productCode,productName, buyPrice, textDescription
FROM products p
JOIN productlines pl
ON p.productline = pl.productline
WHERE buyPrice > 46 AND buyPrice < 94;

select productCode, productName, buyPrice, quanlityStock, productVendor, productLine 
from products 
where productLine = 'line1' or productVendor = 'Vendor1';
