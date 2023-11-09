CREATE TABLE persons (
	id serial PRIMARY KEY,
	name varchar(30),
	age integer
);

CREATE TABLE kind_of_sports (
	id serial PRIMARY KEY,
	name varchar(30)
);

CREATE TABLE persons_sports (
	id serial PRIMARY KEY,
	fk_kind_of_sport int REFERENCES persons(id),
	fk_person int REFERENCES kind_of_sports(id)
);