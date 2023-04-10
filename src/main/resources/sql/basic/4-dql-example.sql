
-- SELECT all, column
select * from advanced_students;
select name from advanced_students;

-- SELECT -> WHERE
select * from advanced_students
 where name = 'John Doe';

select * from advanced_students
    where course_id = 12
        AND age = 20;

-- SELECT -> LIMIT, OFFSET
select * from advanced_students
    limit 5
    offset 5;

-- SELECT -> ORDER BY
select * from students
    order by created_at desc;

-- row function:
-- 1. Date and Time Functions: CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP, EXTRACT, DATE_PART, DATE_TRUNC, TO_CHAR, TO_DATE, AGE, etc.
SELECT CURRENT_DATE;
SELECT CURRENT_TIME;
SELECT CURRENT_TIMESTAMP;
SELECT TO_CHAR(created_at, 'Month YYYY') AS month from students;

-- 2. String Functions: CONCAT, LENGTH, SUBSTR, TRIM, UPPER, LOWER, INITCAP, REPLACE, TRANSLATE, etc.
SELECT concat('Hello', ', ', 'World'); --from dual;
SELECT concat('Student: ', name) from advanced_students;
SELECT name, upper(name), lower(name) from advanced_students;
SELECT name, length(name) as len from advanced_students;
-- SELECT name, length(name) as len FROM advanced_students where length(name) > 10;
-- SELECT * FROM (SELECT name, length(name) as len from advanced_students) as k where len > 10;

-- 3. Mathematical Functions: ABS, CEIL, FLOOR, ROUND, TRUNC, MOD, POWER, SQRT, SIGN, EXP, LN, LOG10, RANDOM, etc.
SELECT ABS(-10);
SELECT * from advanced_students
    where ABS(age) > 20;

SELECT ROUND(5.4);
SELECT ROUND(5.5);
SELECT CEIL(5.1);
SELECT FLOOR(5.9);

SELECT TRUNC(123.456);
SELECT TRUNC(123.456, 2);

SELECT DIV(110, 3);
SELECT MOD(110, 3);

SELECT random();

--4. Conversion Functions: TO_CHAR, TO_DATE, TO_NUMBER, etc.
SELECT TO_CHAR(created_at, 'Month YYYY') from students;
SELECT TO_CHAR(1242.78, '9999.9');
SELECT TO_CHAR(18, '000099');
SELECT to_number('2020.2342', '99999.99');

SELECT *
FROM students
WHERE created_at > TO_DATE('2023-01-01', 'YYYY-MM-DD');

-- Group functions: AVG, COUNT, MAX, MIN, SUM, etc.

select avg(age) from advanced_students;
select max(age) from advanced_students;
select min(age) from advanced_students;
select count(*) from advanced_students;
select sum(age) from advanced_students;

select avg(age), max(age), min(age), count(*) from advanced_students;


-- pagination?
SELECT *, count(*) over () as total
FROM advanced_students
LIMIT 10 OFFSET 10;


-- SELECT -> GROUP BY

-- select name, count(*) from advanced_students;
-- select major, count(*) from advanced_students;

select major, avg(age), count(*) from students
    group by major;


-- distinct
select distinct major from students;