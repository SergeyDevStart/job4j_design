CREATE TABLE persons(
	id serial PRIMARY KEY,
	name varchar(30),
	last_name varchar(30)
);

CREATE TABLE fone_numbers(
	id serial PRIMARY KEY,
	number integer,
	fk_number_person int REFERENCES persons(id) UNIQUE
);