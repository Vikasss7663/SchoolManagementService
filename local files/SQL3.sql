select * from student;

-- enrolled students
-- registered courses
select s.student_id, s.student_name, c.course_id, c.course_name from course as c  
inner join course_registration as cr on c.course_id = cr.course_id 
inner join student as s on s.student_id = cr.student_id;

-- full schedule
select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c 
inner join course_time_table as ctt on c.course_id = ctt.course_id 
inner join location as l on l.location_id = ctt.location_id 
inner join schedule as s on s.schedule_id = ctt.schedule_id;

-- course schedule
select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c 
inner join course_time_table as ctt on c.course_id = ctt.course_id 
inner join location as l on l.location_id = ctt.location_id 
inner join schedule as s on s.schedule_id = ctt.schedule_id where c.course_id = "BMT499";

-- room schedule
select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c 
inner join course_time_table as ctt on c.course_id = ctt.course_id 
inner join location as l on l.location_id = ctt.location_id 
inner join schedule as s on s.schedule_id = ctt.schedule_id where l.location_id = 2;

-- student schedule
select s.student_id, s.student_name, c.course_id, c.course_name,l.building,
l.floor,l.room,sd.week_day,sd.start_time,sd.end_time from course as c  
inner join course_registration as cr on c.course_id = cr.course_id  
inner join student as s on s.student_id = cr.student_id 
inner join course_time_table as ctt on c.course_id = ctt.course_id 
inner join location as l on l.location_id = ctt.location_id 
inner join schedule as sd on sd.schedule_id = ctt.schedule_id where s.student_id = "2018UEC1675";