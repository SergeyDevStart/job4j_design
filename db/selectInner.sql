CREATE TABLE customer(
    id serial PRIMARY KEY,
    first_name text,
    last_name text,
    age int,
    country text
);

insert into customer (first_name, last_name, age, country) values ('Clarinda', 'Sales', 11, 'Cyprus');
insert into customer (first_name, last_name, age, country) values ('Neile', 'Grzeszczak', 22, 'Papua New Guinea');
insert into customer (first_name, last_name, age, country) values ('Jermaine', 'Jiroutka', 23, 'Japan');
insert into customer (first_name, last_name, age, country) values ('Kimberley', 'Danilin', 11, 'Indonesia');
insert into customer (first_name, last_name, age, country) values ('Leann', 'Boake', 15, 'Argentina');
insert into customer (first_name, last_name, age, country) values ('Hortensia', 'Fearenside', 11, 'Chile');
insert into customer (first_name, last_name, age, country) values ('Heidi', 'Dewen', 75, 'Brazil');
insert into customer (first_name, last_name, age, country) values ('Tresa', 'O'' Clovan', 18, 'Guinea');
insert into customer (first_name, last_name, age, country) values ('Maxie', 'Jindra', 19, 'Brazil');
insert into customer (first_name, last_name, age, country) values ('Allys', 'Songust', 11, 'China');


SELECT * FROM customer
WHERE customer.age = (SELECT MIN(age) FROM customer);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customer(id)
);

insert into orders (amount, customer_id) values (4, 6), (5, 2), (3, 3);

SELECT * FROM customer
WHERE customer.id NOT IN (SELECT
						 customer_id FROM orders);





