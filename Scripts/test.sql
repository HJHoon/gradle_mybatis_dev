select user(), database;

select * from addresses;
select * from course_enrollment;
select * from courses;
select * from students;
select * from tutors;

select stud_id, name, email, dob, phone
from students where stud_id=1;

select stud_id, name, email, dob, phone, substring(phone,1,3) as f,substring(phone,5,3) as m,substring(phone,9,4) as 1
from students where stud_id=1;

select * from addresses where addr_id = 3;
select STUD_ID, name, email,phone, a.addr_id, street,city,state,zip,country
from students s left join addresses a on s.addr_id = a.addr_id;

select * from tutors;
select * from courses;

select t.tutor_id, t.name as tutor_name, email, c.course_id, c.name, description, start_date, end_date
from tutors t left join courses c on t.tutor_id = c.tutor_id
where t.tutor_id = 1;

alter table students add gender tinyint unsigned; --성별 추가
desc students;