DROP DATABASE IF EXISTS restaurant;
CREATE DATABASE restaurant;
USE restaurant;

-- Creating Tables
CREATE TABLE ingredient (
	id INT NOT NULL AUTO_INCREMENT,
	name NVARCHAR(255),
	PRIMARY KEY (id)
	) ENGINE = InnoDB;

CREATE TABLE item (
	id INT NOT NULL AUTO_INCREMENT,
	quantity INT NOT NULL,
	product_id INT,
	price_per_product FLOAT,
	order_id INT,
	PRIMARY KEY (id)
	) ENGINE = InnoDB;

CREATE TABLE orders (
	id INT NOT NULL AUTO_INCREMENT,
	date_time DATETIME NOT NULL,
	total_price FLOAT NOT NULL,
	current_status NVARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	) ENGINE = InnoDB;

CREATE TABLE product (
	id INT NOT NULL AUTO_INCREMENT,
	is_enabled BIT NOT NULL,
	description NVARCHAR(255),
	image_path NVARCHAR(255) NOT NULL,
	name NVARCHAR(255) NOT NULL,
	price FLOAT NOT NULL,
	type NVARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	) ENGINE = InnoDB;

CREATE TABLE product_ingredient (
	product_id INT NOT NULL,
	ingredient_id INT NOT NULL,
	PRIMARY KEY (product_id,ingredient_id)
	) ENGINE = InnoDB;

CREATE TABLE work_table (
	id INT NOT NULL AUTO_INCREMENT,
	table_code NVARCHAR(255) NOT NULL,
	is_busy BIT NOT NULL,
	order_id INT,
	PRIMARY KEY (id)
	) ENGINE = InnoDB;

CREATE TABLE product_audit_log (
	id INT NOT NULL AUTO_INCREMENT,
	user_id INT,
	action NVARCHAR(255),
	new_name NVARCHAR(255),
	old_name NVARCHAR(255),
	new_product_id INT,
	old_product_id INT,
	new_price FLOAT,
	old_price FLOAT,
	new_is_enabled BIT,
	old_is_enabled BIT,
	new_image_path NVARCHAR(255),
	old_image_path NVARCHAR(255),
	new_type NVARCHAR(255),
	old_type NVARCHAR(255),
	time_of_action DATETIME NOT NULL,
	PRIMARY KEY (id)
	) ENGINE = InnoDB;

-- Creating relationships and constraints
ALTER TABLE product 
	ADD CONSTRAINT UK_product_name unique (name);
       
ALTER TABLE work_table 
	ADD CONSTRAINT UK_work_table unique (table_code);

ALTER TABLE item 
	ADD CONSTRAINT FK_TABLE_ITEM_product_id 
	FOREIGN KEY (product_id) 
	REFERENCES product (id);

ALTER TABLE item 
	ADD CONSTRAINT FK_TABLE_ITEM_order_id 
	FOREIGN KEY (order_id) 
	REFERENCES orders (id);

ALTER TABLE product_ingredient 
	ADD CONSTRAINT FK_TABLE_PRODUCT_INGREDIENT_ingredient_id 
	FOREIGN KEY (ingredient_id) 
	REFERENCES ingredient (id);

ALTER TABLE product_ingredient 
	ADD CONSTRAINT FK_TABLE_PRODUCT_INGREDIENT_product_id  
	FOREIGN KEY (product_id) 
	references product (id);
       
ALTER TABLE work_table 
	ADD CONSTRAINT FK_TABLE_WORK_TABLE_order_id 
	FOREIGN KEY (order_id) 
	REFERENCES orders (id);