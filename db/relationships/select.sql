CREATE TABLE fauna (
	id serial PRIMARY KEY,
	name text,
	avg_age int,
	discovery_date date
);

INSERT INTO fauna (name, avg_age, discovery_date) VALUES ('fish', 3000, '1900-05-15');
INSERT INTO fauna (name, avg_age, discovery_date) VALUES ('big fish', 10000, '1950-05-15');
INSERT INTO fauna (name, avg_age, discovery_date) VALUES ('mammal', 15000, '1800-05-20');
INSERT INTO fauna (name, avg_age, discovery_date) VALUES ('bird', 1000, null);
INSERT INTO fauna (name, avg_age, discovery_date) VALUES ('snake', 1500, '1900-05-15');
INSERT INTO fauna (name, avg_age, discovery_date) VALUES ('red bird', 2000, '2000-05-15');

SELECT * FROM fauna WHERE name LIKE '%fish%';
SELECT * FROM fauna WHERE avg_age BETWEEN 10000 AND 21000;
SELECT * FROM fauna WHERE discovery_date is null;
SELECT * FROM fauna WHERE discovery_date < '1950-01-01';