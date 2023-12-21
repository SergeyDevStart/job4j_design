CREATE TABLE company (
	id int NOT NULL,
	name character varying,
	CONSTRAINT company_pkey PRIMARY KEY(id)
);

CREATE TABLE person (
	id int NOT NULL,
	name character varying,
	company_id int REFERENCES company(id),
	CONSTRAINT person_pkey PRIMARY KEY(id)
);

INSERT INTO company (id, name) 
VALUES (1, 'Facebook'), (2, 'Amazon'), (3, 'Apple'), (4, 'Netflix'), (5, 'Google');

INSERT INTO person (id, name, company_id)
VALUES (1, 'Alex', 1), (2, 'Bob', 1), (3, 'Connor', 1),
	(4, 'Davis', 2), (5, 'Evans', 2), (6, 'Smith', 2), (7, 'Lam', 3),
	(8, 'Lee', 4), (9, 'Roy', 5), (10, 'Jones', 5);
	
SELECT person.name, company.name 
FROM 
	person JOIN company
	ON person.company_id = company.id
WHERE person.company_id <> 5;

SELECT company.name, COUNT(person.name) AS amount
FROM
	company JOIN person
	ON company.id = person.company_id
GROUP BY company.name
HAVING COUNT(person.name) = (SELECT MAX(amount) 
							FROM (SELECT COUNT(person.name) AS amount
							FROM 
								person JOIN company
								ON person.company_id = company.id
								GROUP BY company.name));	
												