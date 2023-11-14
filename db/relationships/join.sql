CREATE TABLE college (
	id serial PRIMARY KEY,
	name varchar(30)
);

CREATE TABLE student (
	id serial PRIMARY KEY,
	name varchar(30),
	course int,
	college_fk int REFERENCES college(id)
);

INSERT INTO college (name) VALUES ('col1');
INSERT INTO college (name) VALUES ('col2');

INSERT INTO student (name, course, college_fk) VALUES ('Alex', 1, 1);
INSERT INTO student (name, course, college_fk) VALUES ('Roman', 2, 1);
INSERT INTO student (name, course, college_fk) VALUES ('Anna', 2, 2);
INSERT INTO student (name, course, college_fk) VALUES ('Ulia', 5, 2);
INSERT INTO student (name, course, college_fk) VALUES ('Sergey', null, null);

SELECT s.name FROM student AS s inner join college AS c on s.college_fk = c.id;
SELECT s.name AS имя, s.course AS курс, c.name AS колледж 
FROM student AS s inner join college AS c on s.college_fk = c.id;
SELECT * FROM student AS s 
inner join college AS c 
on s.college_fk is not null AND s.college_fk = c.id;