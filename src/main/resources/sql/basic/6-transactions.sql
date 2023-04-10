
SELECT * FROM advanced_students;

START TRANSACTION;
-- BEGIN;

update advanced_students set age = 50
where id = 1;

select name, age from advanced_students
where id = 1;

COMMIT;
-- ROLLBACK ;