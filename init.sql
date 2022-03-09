CREATE DATABASE IF NOT EXISTS demo;

USE demo;

CREATE TABLE IF NOT EXISTS  student (
student_id INT,
student_name varchar(255) NOT NULL,
student_semester INT,
student_year INT,
PRIMARY KEY(student_id)
);

CREATE TABLE IF NOT EXISTS course (
course_id INT,
course_name varchar(255) NOT NULL,
course_semester INT,
PRIMARY KEY(course_id)
);

CREATE TABLE IF NOT EXISTS registration (
id INT,
course_id INT,
student_id INT,
PRIMARY KEY(id),
FOREIGN KEY(course_id) REFERENCES course(course_id),
FOREIGN KEY(student_id) REFERENCES student(student_id)
);

CREATE TABLE IF NOT EXISTS seq_student (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS seq_course (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB;