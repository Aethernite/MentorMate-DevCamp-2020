DROP DATABASE IF EXISTS restaurant;
CREATE DATABASE restaurant;
USE restaurant;
-- Creating Tables
	CREATE TABLE ingredient (
       id INTEGER NOT NULL AUTO_INCREMENT,
        name NVARCHAR(255),
        PRIMARY KEY (id)
	) ENGINE=InnoDB;

    CREATE TABLE item (
	   id INTEGER NOT NULL AUTO_INCREMENT,
        quantity INTEGER NOT NULL,
        product_id INTEGER NOT NULL,
        price_per_product DOUBLE PRECISION,
        PRIMARY KEY (id)
    ) ENGINE=InnoDB;

    CREATE TABLE order_item (
       order_id INTEGER NOT NULL,
        item_id INTEGER NOT NULL,
        PRIMARY KEY (order_id, item_id)
    ) ENGINE=InnoDB;

    CREATE TABLE orders (
       id INTEGER NOT NULL AUTO_INCREMENT,
        date_time DATETIME NOT NULL,
        total_price DOUBLE PRECISION NOT NULL,
        current_status NVARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    ) ENGINE=InnoDB;

    CREATE TABLE product (
       id INTEGER NOT NULL AUTO_INCREMENT,
        ACTIVE BIT NOT NULL,
        DESCRIPTION NVARCHAR(255),
        image_path NVARCHAR(255) NOT NULL,
        NAME NVARCHAR(255) NOT NULL,
        price DOUBLE PRECISION NOT NULL,
        TYPE NVARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    ) ENGINE=InnoDB;

    CREATE TABLE product_ingredient (
       product_id INTEGER NOT NULL,
        ingredient_id INTEGER NOT NULL,
        PRIMARY KEY (product_id, ingredient_id)
    ) ENGINE=InnoDB;

    CREATE TABLE table_order (
       table_id INTEGER NOT NULL,
        order_id INTEGER NOT NULL,
        PRIMARY KEY (table_id, order_id)
    ) engine=InnoDB;

    CREATE TABLE work_table (
       id INTEGER NOT NULL AUTO_INCREMENT,
        table_code NVARCHAR(255),
        PRIMARY KEY (id)
    ) ENGINE=InnoDB;

-- Creating relationships and constraints
    ALTER TABLE product 
       ADD CONSTRAINT UK_jmivyxk9rmgysrmsqw15lqr5b unique (name);

    ALTER TABLE item 
       ADD CONSTRAINT FKd1g72rrhgq1sf7m4uwfvuhlhe 
       FOREIGN KEY (product_id) 
       REFERENCES product (id);

    ALTER TABLE order_item 
       ADD CONSTRAINT FKija6hjjiit8dprnmvtvgdp6ru 
       FOREIGN KEY (item_id) 
       REFERENCES item (id);

    ALTER TABLE order_item 
       ADD CONSTRAINT FKt4dc2r9nbvbujrljv3e23iibt 
       FOREIGN KEY (order_id) 
       REFERENCES orders (id);

    ALTER TABLE product_ingredient 
       ADD CONSTRAINT FKoexfkyxqal5o2c6cnendmu58e 
       FOREIGN KEY (ingredient_id) 
       REFERENCES ingredient (id);

    ALTER TABLE product_ingredient 
       ADD CONSTRAINT FK82j6ju1bhetgb0q2snlosewwb 
       FOREIGN KEY (product_id) 
       references product (id);

    ALTER TABLE table_order 
       ADD CONSTRAINT FKkpygihhpsq337tgxjs591jqgh 
       FOREIGN KEY (order_id) 
       references orders (id);

    ALTER TABLE table_order 
       ADD CONSTRAINT FK4aljbo9onjpqfnsyyk7u6vpii 
       FOREIGN KEY (table_id) 
       REFERENCES work_table (id);