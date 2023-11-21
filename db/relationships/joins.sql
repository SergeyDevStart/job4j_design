CREATE TABLE department (
	id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE emplouee (
	id serial PRIMARY KEY,
	name varchar(50),
	department_fk int REFERENCES department(id)
);

INSERT INTO department (name) VALUES ('AAA'), ('BBB'), ('CCC');

INSERT INTO emplouee (name, department_fk) VALUES ('EM1', 1), ('EM2', 2), ('EM3', 3),
('EM4', 1), ('EM5', NULL), (NULL, NULL);

SELECT * FROM emplouee e LEFT JOIN department d ON e.department_fk = d.id;
SELECT * FROM emplouee e  RIGHT JOIN department d ON e.department_fk = d.id;
SELECT * FROM department d FULL JOIN emplouee e ON e.department_fk = d.id;
SELECT * FROM emplouee CROSS JOIN department;

SELECT * FROM emplouee e LEFT JOIN department d ON e.department_fk = d.id
WHERE d.id IS NULL;

SELECT e.name, d.name FROM emplouee e LEFT JOIN department d ON e.department_fk = d.id;
SELECT e.name, d.name FROM department d RIGHT JOIN emplouee e ON e.department_fk = d.id;

SELECT e.name, d.name FROM department d  LEFT JOIN emplouee e ON e.department_fk = d.id;
SELECT e.name, d.name FROM emplouee e  RIGHT JOIN department d ON e.department_fk = d.id;

CREATE TABLE teens (
	id serial PRIMARY KEY,
	name varchar(30),
	gender boolean
);

INSERT INTO teens (name, gender) VALUES ('A', true), ('B', true), ('C', false), ('D', false);

SELECT t1.name AS men, t2.name AS women
FROM teens t1
CROSS JOIN teens t2
where t1.gender <> t2.gender;