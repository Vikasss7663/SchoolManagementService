insert into student values ("2018UEC1001", "Vishal Singh", 8, 2018);
insert into student values ("2018UEC1023", "Satyanarayan", 8, 2018);
insert into student values ("2018UEC1675", "Manish Singh Patel", 8, 2018);
insert into student values ("2018UEC1582", "Sushil Kumar", 8, 2018);

insert into course values ("BMT499", "Basic Management Course", 7);
insert into course values ("ECT375", "Optical Network", 8);
insert into course values ("PHP202", "Theory of Relativity", 7);

insert into course_registration (course_id, student_id) values ("BMT499", "2018UEC1001");
insert into course_registration (course_id, student_id) values ("BMT499", "2018UEC1023");
insert into course_registration (course_id, student_id) values ("ECT375", "2018UEC1675");
insert into course_registration (course_id, student_id) values ("PHP202", "2018UEC1023");

insert into location values (1, "VLTC", "First Floor", "L304");
insert into location values (2, "Physics Department", "Ground Floor", "T14");
insert into location values (3, "Electronics Department", "Ground Floor", "LT15");
insert into location (building, floor, room) values ("Aurobindo", "Third Floor", "AF402");

insert into schedule values (1, "03:00 PM", "01:00 PM", "Monday");
insert into schedule values (2, "10:00 AM", "09:00 AM", "Wednesday");
insert into schedule values (3, "11:00 AM", "10:00 AM", "Thrusday");

insert into course_time_table values ("ECT375", 3, 1);
insert into course_time_table values ("ECT375", 3, 2);
insert into course_time_table values ("ECT375", 3, 3);
insert into course_time_table values ("PHP202", 2, 3);
insert into course_time_table values ("BMT499", 1, 3);