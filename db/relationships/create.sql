CREATE TABLE roles (
	id serial PRIMARY KEY,
	name varchar(255)
);

CREATE TABLE rights (
	id serial PRIMARY KEY,
	name varchar(30)
);

CREATE TABLE roles_rights (
	id serial PRIMARY KEY,
	fk_role int REFERENCES roles(id),
	fk_right int REFERENCES rights(id)
);

CREATE TABLE users (
	id serial PRIMARY KEY,
	name varchar(255),
	fk_role int REFERENCES roles(id)
);

CREATE TABLE categories (
	id serial PRIMARY KEY,
	category varchar(255)
);

CREATE TABLE states (
	id serial PRIMARY KEY,
	state varchar(255)
);

CREATE TABLE items (
	id serial PRIMARY KEY,
	name varchar(255),
	fk_user int REFERENCES users(id),
	fk_category int REFERENCES categories(id),
	fk_state int REFERENCES states(id)
);

CREATE TABLE comments (
	id serial PRIMARY KEY,
	comment text,
	fk_item int REFERENCES items(id)
);

CREATE TABLE attachments (
	id serial PRIMARY KEY,
	attachment varchar(255),
	fk_item int REFERENCES items(id)
);