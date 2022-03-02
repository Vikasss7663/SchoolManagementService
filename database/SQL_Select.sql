select * from student;
select * from course;
select * from time_table;
-- enrolled students
-- registered courses
select s.student_id, s.student_name, c.course_id, c.course_name from course as c  
inner join registration as r on c.course_id = r.course_id
inner join student as s on s.student_id = r.student_id;

-- full schedule
select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c 
inner join time_table as tt on c.course_id = tt.course_id
inner join location as l on l.location_id = tt.location_id
inner join schedule as s on s.schedule_id = tt.schedule_id;

-- course schedule
select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c 
inner join time_table as tt on c.course_id = tt.course_id
inner join location as l on l.location_id = tt.location_id
inner join schedule as s on s.schedule_id = tt.schedule_id where c.course_id = "BMT499";

-- room schedule
select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c 
inner join time_table as tt on c.course_id = tt.course_id
inner join location as l on l.location_id = tt.location_id
inner join schedule as s on s.schedule_id = tt.schedule_id where l.location_id = 2;

-- student schedule
select c.course_id, c.course_name,l.building,
l.floor,l.room,sd.week_day,sd.start_time,sd.end_time from course as c  
inner join registration as r on c.course_id = r.course_id
inner join student as s on s.student_id = r.student_id
inner join time_table as tt on c.course_id = tt.course_id
inner join location as l on l.location_id = tt.location_id
inner join schedule as sd on sd.schedule_id = tt.schedule_id where s.student_id = "2018UEC1023";


SELECT c.course_id as course_id, c.course_name, c.course_semester FROM course as c
INNER JOIN registration as r ON c.course_id = r.course_id WHERE r.student_id = "2018UEC1001";

SELECT s.student_id as student_id, s.student_name, s.student_semester, s.student_year FROM student as s
INNER JOIN registration as r ON s.student_id = r.student_id WHERE r.course_id = "BMT499";