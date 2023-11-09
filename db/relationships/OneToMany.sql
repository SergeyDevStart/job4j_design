CREATE TABLE genres (
	id serial PRIMARY KEY,
	name varchar(30)
);

CREATE TABLE films (
	id serial PRIMARY KEY,
	name varchar(30),
	fk_genres int REFERENCES genres(id)
);