DROP TRIGGER IF EXISTS after_product_update;
delimiter $$
CREATE TRIGGER after_product_update AFTER UPDATE ON `restaurant`.`product`
FOR EACH ROW 
BEGIN
INSERT INTO audit_log(
user_id,
action,
old_name,
new_name,
old_product_id,
new_product_id,
old_price,
new_price,
old_is_enabled,
new_is_enabled,
old_image_path,
new_image_path,
old_type,
new_type,
time_of_action)
VALUES (
'1'
,'UPDATE',
OLD.name,
CASE NEW.name WHEN OLD.name THEN NULL ELSE NEW.name END,
OLD.id,
CASE NEW.id WHEN OLD.id THEN NULL ELSE NEW.id END,
OLD.price,
CASE NEW.price WHEN OLD.price THEN NULL ELSE NEW.price END,
OLD.is_enabled,
CASE NEW.is_enabled WHEN OLD.is_enabled THEN NULL ELSE NEW.is_enabled END,
OLD.image_path,
CASE NEW.image_path WHEN OLD.image_path THEN NULL ELSE NEW.image_path END,
OLD.type,
CASE NEW.type WHEN OLD.type THEN NULL ELSE NEW.type END,
NOW());
END;
$$
Delimiter ;

-- UPDATE THE MOJITO WITH DISABLE CHANGE! SEE RESULTS IN THE AUDIT LOG
UPDATE product
SET is_enabled = 0
WHERE id = 2;