-- Should be possible to assign an order/receipt to a table and restart the purchases of the table.
DROP PROCEDURE IF EXISTS assignOrderToTable;
delimiter $$
CREATE PROCEDURE assignOrderToTable(IN table_id INT, IN order_id INT)
BEGIN
UPDATE `work_table`
SET `order_id` = order_id
WHERE `work_table`.`id` = table_id;
END 
$$

CALL assignOrderToTable(2,1); -- Table 2 is busy with order 1 :)

SELECT * FROM `work_table`
WHERE `work_table`.`id` = 2;


-- Selects all the ENABLED menu products 3.a
-- COMPLETED 3 a)
SELECT * FROM `restaurant`.`product`
WHERE `is_enabled` = 1;

-- Selects all ENABLED menu products that start with C 3.b
-- COMPLETED 3 b)
SELECT *
FROM `restaurant`.`product`
WHERE `name` LIKE 'C%' AND `is_enabled` = 1; -- Club Sandwich starts with 'C' !!!

-- Selects all the orders and the ordered items for each order sorted by order ID 3.c
-- COMPLETED 3 c)
SELECT `orders`.`id`, `orders`.`date_time`, `orders`.`total_price`, `item`.`quantity`, `product`.`name`, `orders`.`current_status`
FROM `restaurant`.`orders` 
JOIN `restaurant`.`item`
ON `orders`.`id` = `item`.`order_id`
JOIN `restaurant`.`product`
ON `item`.`product_id` = `product`.`id`
ORDER BY `id`;


-- Search sold menu items during a period (hour(s), day(s), month(s), and/or year(s) - select matching menu items) - select all matching menu items ordered by date and time. Do not group the result. 
-- (Optional) create a stored procedure for that search with parameters start and end of the search period which will return the matching items. Add invocation of that stored procedure.
-- COMPLETED 3 d) i)
DROP PROCEDURE IF EXISTS soldProductsBetweenTwoDates;
delimiter $$
CREATE PROCEDURE soldProductsBetweenTwoDates(IN date1 datetime, IN date2 datetime)
BEGIN
SELECT `product`.`name`, `item`.`quantity` as quantity, `orders`.`date_time`, `item`.`price_per_product` AS sold_at
FROM `restaurant`.`product`
JOIN `restaurant`.`item`
ON `product`.`id` = `item`.`product_id`
JOIN `restaurant`.`orders`
ON `item`.`order_id` = `orders`.`id`
WHERE `orders`.`date_time` BETWEEN date1 AND date2 AND `orders`.`current_status` = 'COMPLETED' -- ONLY COMPLETED ORDERS!
ORDER BY `orders`.`date_time`;
END 
$$
-- CALLS PROCEDURE
CALL soldProductsBetweenTwoDates('2018-08-22 00:00:00','2021-08-26 00:00:00');


-- Search sold menu items for the last month 
-- select all sold menu items for the period and show aggregated quantity and aggregated price for all sales. 
-- Group the result - every matching menu item should exist once into the result and for this menu item should show the total count and total price of sold items for the period. 
-- Keep in mind that the menu item’s price could be changed multiple times during the period.
-- (Optional) Create a SQL view for that search. Add a query to select data from that view.
-- COMPLETED 3 e) i)
DROP VIEW IF EXISTS sold_items_for_past_month;
CREATE VIEW sold_items_for_past_month 
AS 
SELECT `product`.`name`, SUM(`item`.`quantity`) AS `total_quantity`, case when price > 0 then SUM(`item`.`quantity`)*`price_per_product` else 0 end AS `total_price`
FROM `restaurant`.`product`
JOIN `restaurant`.`item`
ON `product`.`id` = `item`.`product_id`
JOIN `restaurant`.`orders`
ON `item`.`order_id` = `orders`.`id`
WHERE `orders`.`date_time` BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW() AND `orders`.`current_status` = 'COMPLETED' -- ONLY COMPLETED ORDERS!;
GROUP BY `product`.`name`
ORDER BY `orders`.`date_time`;

SELECT * FROM sold_items_for_past_month;