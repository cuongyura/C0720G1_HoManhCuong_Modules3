-- create csdl:
CREATE DATABASE `designing_and_manipulating_data`;

-- use csdl:
USE `designing_and_manipulating_data`;

-- create table contacts:
CREATE TABLE contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

-- tạo bảng suppliers:
CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

-- delete bảng:
DROP TABLE customers;

-- edit bảng:
ALTER TABLE contacts
ADD last_name varchar(40) NOT NULL
AFTER contact_id;

-- delete a cloumn:
ALTER TABLE contacts
DROP COLUMN contact_type;

-- change name a cloumn:
ALTER TABLE contacts
CHANGE COLUMN contact_type ctype
varchar(20) NOT NULL;

-- change name table:
ALTER TABLE contacts
RENAME TO people;

