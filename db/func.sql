CREATE OR REPLACE procedure del(d_count int, d_id int) AS
$$
	BEGIN
		UPDATE product SET count = count - count WHERE id = d_id;
		DELETE FROM product WHERE count <= 0 AND id = d_id;
	END;
$$ language 'plpgsql';

CALL del(15, 1);

CREATE OR REPLACE FUNCTION del_func(d_price int) RETURNS void AS
$$
	BEGIN
		DELETE FROM product WHERE price < d_price;
	END;
$$ language 'plpgsql';

SELECT del_func(100);