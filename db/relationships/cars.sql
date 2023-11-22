CREATE TABLE car_bodie (
	bodie_id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE car_engine (
	engine_id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE car_transmission (
	transmission_id serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE car (
	car_id serial PRIMARY KEY,
	name varchar(50),
	bodie_id int REFERENCES car_bodie(bodie_id),
	engine_id int REFERENCES car_engine(engine_id),
	transmission_id int REFERENCES car_transmission(transmission_id)
);

INSERT INTO car_bodie (name) VALUES ('Седан'), ('Хэтчбек'), ('Купе'), ('Внедорожник'), ('Универсал');

INSERT INTO car_engine (name) VALUES ('AAA'), ('BBB'), ('CCC'), ('DDD');

INSERT INTO car_transmission (name) VALUES ('Механика'), ('Автомат'), ('Гидравлика');

INSERT INTO car (name, bodie_id, engine_id, transmission_id)
VALUES ('A1', 1, 1 ,1), ('B2', 1, 2, 2), ('C3', 2, 1, 1),
	   ('D4', null, 3, 2), ('E5', 3, 1, null), ('F6', 3, 1, 2);

SELECT car.name, car_bodie.name, car_engine.name, car_transmission.name
FROM car
	LEFT JOIN car_bodie USING(bodie_id)
	LEFT JOIN car_engine USING(engine_id)
	LEFT JOIN car_transmission USING(transmission_id);

SELECT bodie_id, car_bodie.name 
FROM car
	RIGHT JOIN car_bodie USING(bodie_id)
WHERE car_id IS null;

SELECT engine_id, car_engine.name
FROM car
	RIGHT JOIN car_engine USING(engine_id)
WHERE car_id IS null;
	
SELECT transmission_id, car_transmission.name
FROM car
	RIGHT JOIN car_transmission USING(transmission_id)
WHERE car_id IS null;