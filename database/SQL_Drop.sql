drop table registration;
drop table time_table;
drop table student;
drop table course;
drop table schedule;
drop table location;

delete from schedule where schedule_id = 1;
delete from time_table where schedule_id = 1;

explain course;
explain schedule;
explain location;
explain time_table;
explain registration;