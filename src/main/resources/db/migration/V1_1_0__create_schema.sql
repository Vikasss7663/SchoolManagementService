CREATE TABLE IF NOT EXISTS  student (
student_id INT AUTO_INCREMENT,
student_name varchar(255) NOT NULL,
student_semester INT,
student_year INT,
PRIMARY KEY(student_id)
);

CREATE TABLE IF NOT EXISTS course (
course_id INT AUTO_INCREMENT,
course_name varchar(255) NOT NULL,
course_semester INT,
PRIMARY KEY(course_id)
);

CREATE TABLE IF NOT EXISTS registration (
id INT AUTO_INCREMENT,
course_id INT,
student_id INT,
PRIMARY KEY(id),
FOREIGN KEY(course_id) REFERENCES course(course_id),
FOREIGN KEY(student_id) REFERENCES student(student_id)
);

CREATE TABLE IF NOT EXISTS location (
location_id INT AUTO_INCREMENT,
building varchar(255) NOT NULL,
floor varchar(255) NOT NULL,
room varchar(255) NOT NULL,
PRIMARY KEY(location_id)
);

CREATE TABLE IF NOT EXISTS schedule (
schedule_id INT AUTO_INCREMENT,
week_day varchar(255) NOT NULL,
start_time varchar(255) NOT NULL,
end_time varchar(255) NOT NULL,
PRIMARY KEY(schedule_id)
);

CREATE TABLE IF NOT EXISTS time_table (
id INT AUTO_INCREMENT,
course_id INT,
location_id INT,
schedule_id INT,
PRIMARY KEY(id),
FOREIGN KEY(course_id) REFERENCES course(course_id),
FOREIGN KEY(location_id) REFERENCES location(location_id),
FOREIGN KEY(schedule_id) REFERENCES schedule(schedule_id)
);

CREATE TABLE IF NOT EXISTS test (
test_id INT AUTO_INCREMENT,
test_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(test_id)
);