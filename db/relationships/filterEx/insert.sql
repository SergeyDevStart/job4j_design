INSERT INTO type (name) VALUES ('СЫР'), ('МОЛОКО'), ('ХЛЕБ'), ('ШОКОЛАД'), ('МЯСО');

INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('сыр твёрдый', '2024-05-15', 100, 1);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('сыр творожный', '2024-03-15', 98.67, 1);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('творог', '2023-12-15', 67.45, 2);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('молоко топлёное', '2023-12-01', 120, 2);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('шоколад молочный', '2023-05-15', 79.5, 4);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('шоколад горький', '2024-01-25', 150, 4);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('хлеб пшеничный', '2023-10-15', 50, 3);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('батон', '2023-05-15', 55, 3);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('молоко козье', '2023-11-15', 250, 2);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('сыр моцарелла', '2024-02-15', 160, 1);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('говяжья вырезка', '2024-01-01', 500, 5);
INSERT INTO product (name, expired_date, price, type_fk) 
VALUES ('филе индейки', '2024-01-01', 500, 5);
