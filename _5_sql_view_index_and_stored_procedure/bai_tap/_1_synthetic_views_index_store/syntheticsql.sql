create database `asc`;
use `asc`;

-- Bước 1: Tạo cơ sở dữ liệu demo
-- Bước 2: Tạo bảng Products với các trường dữ liệu sau:
    create table products(
	id int(11),
	productCode int(11),
	productName varchar(50),
	productPrice float,
	productAmount float,
	productDescription varchar(50),
	productStatus varchar(50),

	primary key(id, productCode)
	);

	create table category_product(
	id int(11),
	category_name varchar(50),

	primary key(id),
	foreign key(id) references Products(id)
	);

-- insert data in products:
insert into Products values(1,1,"Máy Tính DELL-RY1", 1000.0, 1000.0, "Hàng chất lượng USA", "Mua sẽ biết"),
                           (2,2,"Máy Tính ASUS-COLL23Z", 8000.0, 8000.0, "Hàng chất lượng JAPAN", "Mua sẽ biết"),
                           (3,3,"Máy Tính MOGONA-TRIP", 7000.0, 7000.0, "Hàng chất lượng LAO", "Mua sẽ biết"),
                           (4,4,"Máy Tính SLIDER-CD", 6000.0, 6000.0, "Hàng chất lượng CHINA", "Mua sẽ biết"),
                           (5,5,"Máy Tính COOFUL_1", 2000.0, 2000.0, "Hàng chất lượng IRAC-IRAN", "Mua sẽ biết");
                           
insert into category_product
values 
      (1,"DELL"),                           
      (2,"ASUS"),                           
      (3,"MOGONA"),                           
      (4,"SLIER"),                           
      (5,"COOFUL");                  
        
        -- Câu 3: index
      
         create unique index idx_productCode on products(productCode);
	     create index idx_productName_productPrice on products(productName, productPrice);
         
         select * from products where products.productCode = 1;
         select * from products where products.productCode = 1 or products.productPrice = 8000.0 ;
         
         explain select * from products where products.productCode = 1;
         explain select * from products where products.productCode = 1 or products.productPrice = 8000.0 ;
         
        -- Câu 4: views:
         create view products_views as
         select productCode, productName, productPrice, productStatus
         from products;
         
         -- update views:
         create or replace view products_views as
         select productCode, productName, productPrice, productStatus
         from products
         where productPrice = 8000.0;
         
         -- delete views:
         drop view products_views;
         
         -- Câu 5: 
          
          -- a) lấy all thông tin:
          DELIMITER //
          CREATE PROCEDURE findAllProducts()
          BEGIN
          SELECT * FROM products;
          END //
          DELIMITER ;
          
          -- b) thêm một sản phẩm mới:
          DELIMITER //
          CREATE PROCEDURE inserProducts(in id int(11),productCode int(11),productName varchar(50),
                                         productPrice float,productAmount float,productDescription varchar(50),productStatus varchar(50))
          BEGIN 
          insert into products values (id, productCode, productName, productPrice, productAmount, productDescription, productStatus);
          END //
          DELIMITER ;
          
        
		-- c) update:
	     DELIMITER //
		 Create procedure set_product(
            id int(11),
            productCode int(11),
            productName varchar(50),
            productPrice float,
            productAmount float,
            productDescription varchar(50),
            productStatus varchar(50)
          )
		 begin
		    update products set products.productCode = productCode where products.id = id;
		    update products set products.productName = productName where products.id = id;
		    update products set products.productPrice = productPrice where products.id = id;
		    update products set products.productAmount = productAmount where products.id = id;
		    update products set products.productDescription = productDescription where products.id = id;
		    update products set products.productStatus = productStatus where products.id = id;
		   end //
		    DELIMITER ;
		    call set_product('7', 'PD_07', 'Xe tăng', '2500', '7', 'abcd', 'dbca');
		    DELIMITER //
		    DROP PROCEDURE IF EXISTS `set_product`//
            
            -- d) delete:
             DELIMITER //
             Create procedure del_product(in id int)
             begin
             delete from products where products.id = id;
             end //
             DELIMITER ;
            call del_product('9');
          
          
          
          
        
        
       
                           
                           