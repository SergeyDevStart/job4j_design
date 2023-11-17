CREATE TABLE type (
	id serial PRIMARY KEY,
	name varchar(30)
);

CREATE TABLE product(
	id serial PRIMARY KEY,
	name varchar(255),
	expired_date date,
	price float,
	type_fk int REFERENCES type(id)
);