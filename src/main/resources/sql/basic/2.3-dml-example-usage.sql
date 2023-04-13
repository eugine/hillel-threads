SELECT * FROM students ;

UPDATE students set age = 20 WHERE name = 'John Doe';
SELECT * FROM students WHERE name = 'John Doe';

DELETE FROM students WHERE 1=1;


SELECT major, count(*) AS c FROM students GROUP BY major ORDER BY c DESC;
