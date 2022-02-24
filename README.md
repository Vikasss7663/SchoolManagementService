# Spring Boot Tutorial App

## API Calls

## Course API Calls

### GET ( Get All Courses )
curl http://localhost:9090/course

### GET ( Get Courses by Semester )
curl http://localhost:9090/course/semester={semester}

curl http://localhost:9090/course/semester=7

### GET ( Get Course)
curl http://localhost:9090/course/{id}

curl http://localhost:9090/course/"BMT499"

### POST ( Add Course )
curl -d '{"courseId":"BMT499","courseName":"Basic Management Course","courseSemester":7}' -H "Content-Type: application/json" -X POST http://localhost:9090/course

curl -d '{"courseId":"ECT567","courseName":"Optical Network","courseSemester":8}' -H "Content-Type: application/json" -X POST http://localhost:9090/course


### PUT ( Update Course )
curl -d '{"courseId":"BMT499","courseName":"Updated Basic Management Course","courseSemester":7}' -H "Content-Type: application/json" -X PUT http://localhost:9090/course


### DELETE ( Delete Course )
curl -X DELETE http://localhost:9090/course/{id}

curl -X DELETE http://localhost:9090/course/1


## Student API Calls

### GET ( Get All Students )
curl http://localhost:9090/student

### GET ( Get Students by Semester )
curl http://localhost:9090/student/semester={semester}

curl http://localhost:9090/student/semester=7

### GET ( Get Student)
curl http://localhost:9090/student/id={id}

curl http://localhost:9090/student/id="2018UEC1001"


### POST ( Add Student )
curl -d '{"studentId":"2018UEC1001","studentName":"Vishal Singh","studentSemester":7,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student

curl -d '{"studentId":"2018UEC1023","studentName":"Satyanarayan","studentSemester":7,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student

curl -d '{"studentId":"2018UEC1582","studentName":"Sushil Kumar","studentSemester":8,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student

curl -d '{"studentId":"2018UEC1675","studentName":"Manish Singh","studentSemester":8,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student


### PUT ( Update Student )
curl -d '{"studentId":"2018UEC1001","studentName":"Vishal Singh","studentSemester":7,"studentYear":2018}' -H "Content-Type: application/json" -X PUT http://localhost:9090/1


### DELETE ( Delete Student )
curl -X DELETE http://localhost:9090/student/{id}

curl -X DELETE http://localhost:9090/student/1