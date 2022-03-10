CREATE TABLE IF NOT EXISTS student(
student_id INT AUTO_INCREMENT,
student_name VARCHAR(255) NOT NULL,
student_semester INT,
student_year INT,
PRIMARY KEY(student_id)
);