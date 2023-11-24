CREATE TABLE product (
	id serial PRIMARY KEY,
	name varchar(50),
	producer varchar(50),
	count integer default 0,
	price int
);

CREATE TABLE history_of_price (
	id serial PRIMARY KEY,
	name varchar(50),
	price int,
	cur_date timestamp
);

insert into product (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 30);
insert into product (name, producer, count, price) VALUES ('product_2', 'producer_2', 5, 50);
insert into product (name, producer, count, price) VALUES ('product_3', 'producer_3', 7, 70);

CREATE OR REPLACE FUNCTION tax_on_everything()
	RETURNS TRIGGER AS
$$
	BEGIN
		UPDATE product
		SET price = price * 1.13
		WHERE id = (SELECT id FROM inserted);
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER general_tax AFTER INSERT ON product
	REFERENCING NEW TABLE AS inserted
	FOR EACH STATEMENT
	EXECUTE PROCEDURE tax_on_everything();

insert into product (name, producer, count, price) VALUES ('product_4', 'producer_4', 9, 90);
insert into product (name, producer, count, price) VALUES ('product_5', 'producer_5', 11, 110);

DROP TRIGGER general_tax ON product;

CREATE OR REPLACE FUNCTION tax()
	RETURNS TRIGGER AS
$$
	BEGIN
		NEW.price = NEW.price * 1.13;
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER tax BEFORE INSERT ON product
	FOR EACH ROW
	EXECUTE PROCEDURE tax();

insert into product (name, producer, count, price) VALUES ('product_6', 'producer_6', 13, 130);

DROP TRIGGER tax ON product;

CREATE OR REPLACE FUNCTION insert_data_in_other_table()
	RETURNS TRIGGER AS
$$
	BEGIN
		INSERT INTO history_of_price (name, price, cur_date)
		VALUES (NEW.name, NEW.price, now());
		RETURN NEW;
	END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER product_insert AFTER INSERT ON product
	FOR EACH ROW
	EXECUTE PROCEDURE insert_data_in_other_table();

insert into product (name, producer, count, price) VALUES ('product_7', 'producer_7', 15, 150);
insert into product (name, producer, count, price) VALUES ('product_8', 'producer_8', 17, 170);
insert into product (name, producer, count, price) VALUES ('product_9', 'producer_9', 19, 190);

DROP TRIGGER product_insert ON product;	