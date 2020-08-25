-- All of the ingredients added to the database       
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Ham');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Tomatoes');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Bread');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Cheese');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Eggs');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Sugar');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Lime');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Water');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Rum');
INSERT INTO `restaurant`.`ingredient` (`name`) VALUES ('Beans');

-- Product insertion and ingredients <SANDWICH> with <Cheese>, <Ham>, <Bread>
INSERT INTO `restaurant`.`product` (`active`, `description`, `ImagePath`, `name`, `price`, `type`) VALUES (b'1', 'Itallian morning sandwich', 'imgurl', 'Club Sandwich', '4.00', 'MEAL');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('1', '4');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('1', '1');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('1', '3');

-- Product insertion and ingredients <Mojito> with <Sugar>, <Lime>, <Water>, <Rum>
INSERT INTO `restaurant`.`product` (`active`, `description`, `ImagePath`, `name`, `price`, `type`) VALUES (b'0', 'Icy summer cocktail', 'imgurl', 'Mojito', '6.50', 'ALCOHOLIC_DRINK');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('2', '6');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('2', '7');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('2', '8');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('2', '9');

-- Product insertion and ingredients <English Breakfast> with <Ham>, <Tomatoes>, <Eggs>, <Beans>
INSERT INTO `restaurant`.`product` (`active`, `description`, `ImagePath`, `name`, `price`, `type`) VALUES (b'1', 'Welcome to england!', 'imgurl', 'English Breakfast', '5.50', 'MEAL');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('3', '1');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('3', '2');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('3', '5');
INSERT INTO `restaurant`.`product_ingredient` (`product_id`, `ingredient_id`) VALUES ('3', '10');

-- Working Tables insertion
INSERT INTO `restaurant`.`work_table` (`table_code`) VALUES ('TB-100');
INSERT INTO `restaurant`.`work_table` (`table_code`) VALUES ('TB-101');
INSERT INTO `restaurant`.`work_table` (`table_code`) VALUES ('TB-102');
INSERT INTO `restaurant`.`work_table` (`table_code`) VALUES ('TB-103');
INSERT INTO `restaurant`.`work_table` (`table_code`) VALUES ('TB-104');

-- Item insertions (Item is a product plus the ordered quantity)
INSERT INTO `restaurant`.`item` (`quantity`, `product_id`, `price_per_product`) VALUES ('1', '3', '5.50'); -- 1x English Breakfast
INSERT INTO `restaurant`.`item` (`quantity`, `product_id`, `price_per_product`) VALUES ('2', '2', '6.50'); -- 2x Mojitos
INSERT INTO `restaurant`.`item` (`quantity`, `product_id`, `price_per_product`) VALUES ('1', '1', '4.00'); -- 1x Sandwich
INSERT INTO `restaurant`.`item` (`quantity`, `product_id`, `price_per_product`) VALUES ('1', '2', '6.50'); -- 1x Mojito

-- Order insertion (Order contains date and time plus the total price of the order)
INSERT INTO `restaurant`.`orders` (`date_time`, `total_price`, `current_status`) VALUES ('2020-08-25 21:52:41', '5.50','ACTIVE'); 
INSERT INTO `restaurant`.`orders` (`date_time`, `total_price`, `current_status`) VALUES ('2020-08-23 21:55:41', '13', 'COMPLETED');
INSERT INTO `restaurant`.`orders` (`date_time`, `total_price`, `current_status`) VALUES ('2020-08-21 18:52:41', '11.50', 'COMPLETED');

-- Here we connect given order with the ordered items
INSERT INTO `restaurant`.`order_item` (`order_id`, `item_id`) VALUES ('1', '1');
INSERT INTO `restaurant`.`order_item` (`order_id`, `item_id`) VALUES ('2', '2');
INSERT INTO `restaurant`.`order_item` (`order_id`, `item_id`) VALUES ('3', '3');
INSERT INTO `restaurant`.`order_item` (`order_id`, `item_id`) VALUES ('3', '4');

-- Here we connect given order with the table that created the order
INSERT INTO `restaurant`.`table_order` (`table_id`, `order_id`) VALUES ('1', '1');
INSERT INTO `restaurant`.`table_order` (`table_id`, `order_id`) VALUES ('2', '2');
INSERT INTO `restaurant`.`table_order` (`table_id`, `order_id`) VALUES ('3', '3');