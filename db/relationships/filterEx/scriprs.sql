SELECT * FROM product
JOIN type 
ON product.type_fk=type.id AND type.name LIKE 'СЫР';

SELECT * FROM product
WHERE name LIKE '%молоко%';

SELECT * FROM product
WHERE CURRENT_DATE > expired_date;

SELECT * FROM product
WHERE price = (SELECT MAX(price) FROM product);

SELECT t.name AS Имя_типа, COUNT(t.name) AS количество
FROM product AS p 
JOIN type AS t
ON p.type_fk=t.id
GROUP BY t.name;

SELECT * FROM product AS p
JOIN type AS t 
ON p.type_fk=t.id
WHERE t.name LIKE 'СЫР' OR t.name LIKE 'МОЛОКО';

SELECT type.name FROM type 
JOIN product 
ON product.type_fk=type.id
GROUP BY type.name
HAVING COUNT(type.name) < 10;

SELECT * FROM product 
JOIN type
ON product.type_fk=type.id
ORDER BY type.id;