drop table course_registration;
drop table course_time_table;
drop table student;
drop table course;
drop table schedule;
drop table location;

delete from schedule where schedule_id = 1;
delete from course_time_table where schedule_id = 1;

explain schedule;
explain location;