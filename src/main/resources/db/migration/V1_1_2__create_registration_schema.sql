CREATE TABLE IF NOT EXISTS registration (
id INT AUTO_INCREMENT,
course_id INT,
student_id INT,
PRIMARY KEY(id),
FOREIGN KEY(course_id) REFERENCES course(course_id),
FOREIGN KEY(student_id) REFERENCES student(student_id)
);