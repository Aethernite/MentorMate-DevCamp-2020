# Task
 Create a relational database (the DB only) for a project that should handle the restaurant’s purchases. The restaurant application should support a very long menu list. Menu items should be of any type - drinks, cocktails, soups, salads, meals/dishes, desserts, and etc.
 
# 1.  Database/application requirements:

- :heavy_check_mark: a) It should be possible to create, edit, and deactivate menu items.
 
- :heavy_check_mark: b) Each menu item should have at least identifier, unique name, type, a picture (absolute or relative path/URL to the file location), description, ingredients, price, is enabled flag. 
- :heavy_check_mark: c) Orders/Receipts history - date and time, menu items with quantities and prices, order/receipt number, final/total price. Keep in mind that the menu item’s price may change and we need to keep track of the price at the moment of the order/recipe created.
- :heavy_check_mark: d) (Optional) Should be possible to create, edit, and deactivate tables. Each table should have a unique name.
- :x: e) (Optional) Create stored procedures for:
    - Should be possible to assign menu items to a table. 
    - Should be possible to assign an order/receipt to a table and restart the purchases of the table.
 - :x: f) (Optional) Should be possible to group smaller sets of menus (like lunch menu or happy hour menu), that can be displayed on monitors in the restaurant and should be available in a given time (example: from 12:00 to 14:00). These groups should support their own price as a group.


# 2. Seed data
- :heavy_check_mark: a) Add the minimum number of enabled menu items that you need to cover the requirements. It’s not necessary to add tens or hundreds. You should have at least one disabled menu item.
- :heavy_check_mark: b) Add at least 3 orders/recipes with at least one menu item with a changed price at least 2 times (an order with initial menu item price, an order with the same menu item and fist price update and other order with the same menu item second price update - no duplicated prices).

# 3. Reports: (SQL SELECT queries and SQL views):
- :heavy_check_mark: a) Menu list - select all enabled menu items
 
- :heavy_check_mark: b) Search by part of a menu item name - select all matching menu items
 
- :heavy_check_mark: c) Search by order/receipt number - select all matching menu items from that order/recipe

- :heavy_check_mark: d) Search sold menu items during a period (hour(s), day(s), month(s), and/or year(s) - select matching menu items) - select all matching menu items ordered by date and time. Do not group the result.
    - :heavy_check_mark: (Optional) create a stored procedure for that search with parameters start and end of the search period which will return the matching items. Add invocation of that stored procedure.

- :heavy_check_mark: e) Search sold menu items for the last month - select all sold menu items for the period and show aggregated quantity and aggregated price for all sales. Group the result - every matching menu item should exist once into the result and for this menu item should show the total count and total price of sold items for the period. Keep in mind that the menu item’s price could be changed multiple times during the period.
  - :heavy_check_mark: (Optional) Create a SQL view for that search. Add a query to select data from that view.
- f) :heavy_check_mark: Add index on the appropriate places
- g) :heavy_check_mark: (Optional) Add audit log functionality to track changes on the menu items table (create a new table to store, a user id (any number as users are not part of this task), action, a short description ~~and create a stored procedure that will insert data to this table~~. ~~The stored procedure will be called/executed manually~~
> Instead of procedure I created a trigger that triggers on update on the table with products


---