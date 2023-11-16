CREATE TABLE devices (
	id serial PRIMARY KEY,
	name varchar(255),
	price float
);

CREATE TABLE people (
	id serial PRIMARY KEY,
	name varchar(255)
);

CREATE TABLE devices_people (
	id serial primary key,
	device_fk int REFERENCES devices(id),
	people_fk int REFERENCES people(id)
);

INSERT INTO devices (name, price) VALUES ('fone', 50.5);
INSERT INTO devices (name, price) VALUES ('computer', 150.07);
INSERT INTO devices (name, price) VALUES ('tv', 75.15);

INSERT INTO people (name) VALUES ('Alex');
INSERT INTO people (name) VALUES ('Roman');
INSERT INTO people (name) VALUES ('Sergey');

INSERT INTO devices_people (people_fk, device_fk) 
VALUES (1, 1), (2, 1), (2, 2), (3, 1), (3, 2), (3, 3);

SELECT AVG(price) AS Средняя_цена FROM devices;

SELECT p.name, AVG(d.price)
FROM devices_people AS d_p
JOIN devices AS d ON d_p.device_fk = d.id
JOIN people AS p ON d_p.people_fk = p.id
GROUP BY p.name;

SELECT p.name, AVG(d.price)
FROM devices_people AS d_p
JOIN devices AS d ON d_p.device_fk = d.id
JOIN people AS p ON d_p.people_fk = p.id
GROUP BY p.name
HAVING AVG(d.price) > 70.0;
