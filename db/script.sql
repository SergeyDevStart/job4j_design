create table courses(
	id serial primary key,
	title text,
	hours integer,
	credit boolean
);
insert into courses(title, hours, credit) values('Math', 100, true);
update courses set hours = 120;
delete from courses;