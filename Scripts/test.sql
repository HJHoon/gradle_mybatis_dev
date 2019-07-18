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