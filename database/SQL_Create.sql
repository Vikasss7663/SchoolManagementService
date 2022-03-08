
CREATE TABLE student(
student_id INT,
student_name varchar(255),
student_semester INT,
student_year INT,
PRIMARY KEY(student_id)
);

CREATE TABLE course(
course_id INT,
course_name varchar(255),
course_semester INT,
PRIMARY KEY(course_id)
);

CREATE TABLE registration(
id INT,
course_id INT,
student_id INT
);
