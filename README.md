# Spring Boot Tutorial App

## API Calls

## Course API Calls

### GET ( Get All Courses )
curl http://localhost:9090/course

### GET ( Get Courses by Semester )
curl http://localhost:9090/course/semester={semester}

curl http://localhost:9090/course/semester=7

### GET ( Get All Courses by Student Id )
curl http://localhost:9090/course/student/{id}

curl http://localhost:9090/course/student/"2018UEC1001"

### GET ( Get Course by Course Id )
curl http://localhost:9090/course/{id}

curl http://localhost:9090/course/"BMT499"

### POST ( Add Course )
curl -d '{"courseId":"BMT499","courseName":"Basic Management Course","courseSemester":7}' -H "Content-Type: application/json" -X POST http://localhost:9090/course

curl -d '{"courseId":"ECT567","courseName":"Optical Network","courseSemester":8}' -H "Content-Type: application/json" -X POST http://localhost:9090/course

### POST ( Add Student )
curl -d '{"courseId":"ECT567","studentId":"2018UEC1001"}' -H "Content-Type: application/json" -X POST http://localhost:9090/course/student

curl -d '{"courseId":"ECT567","studentId":"2018UEC1675"}' -H "Content-Type: application/json" -X POST http://localhost:9090/course/student

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

### GET ( Get All Students by Course )
curl http://localhost:9090/student/course/{id}

curl http://localhost:9090/student/course/"BMT499"

### GET ( Get Student)
curl http://localhost:9090/student/{id}

curl http://localhost:9090/student/"2018UEC1001"

### POST ( Add Student )
curl -d '{"studentId":"2018UEC1001","studentName":"Vishal Singh","studentSemester":7,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student

curl -d '{"studentId":"2018UEC1023","studentName":"Satyanarayan","studentSemester":7,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student

curl -d '{"studentId":"2018UEC1582","studentName":"Sushil Kumar","studentSemester":8,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student

curl -d '{"studentId":"2018UEC1675","studentName":"Manish Singh","studentSemester":8,"studentYear":2018}' -H "Content-Type: application/json" -X POST http://localhost:9090/student

### POST ( Add Course )
curl -d '{"courseId":"BMT499","studentId":"2018UEC1001"}' -H "Content-Type: application/json" -X POST http://localhost:9090/student/course

curl -d '{"courseId":"BMT499","studentId":"2018UEC1675"}' -H "Content-Type: application/json" -X POST http://localhost:9090/student/course

### PUT ( Update Student )
curl -d '{"studentId":"2018UEC1001","studentName":"Vishal Singh ( Vikas )","studentSemester":7,"studentYear":2018}' -H "Content-Type: application/json" -X PUT http://localhost:9090/student/1


### DELETE ( Delete Student )
curl -X DELETE http://localhost:9090/student/{id}

curl -X DELETE http://localhost:9090/student/"2018UEC1705"


## Schedule API Calls

### GET ( Get All Schedules )
curl http://localhost:9090/schedule

### GET ( Get Schedule)
curl http://localhost:9090/schedule/{id}

curl http://localhost:9090/schedule/i

### POST ( Add Schedule )
curl -d '{"weekDay":"MONDAY","startTime":"01:00 PM","endTime":"02:00 PM"}' -H "Content-Type: application/json" -X POST http://localhost:9090/schedule

### PUT ( Update Schedule )
curl -d '{"weekDay":"MONDAY","startTime":"01:00 PM","endTime":"02:00 PM"}' -H "Content-Type: application/json" -X PUT http://localhost:9090/schedule/1


### DELETE ( Delete Schedule )
curl -X DELETE http://localhost:9090/schedule/{id}

curl -X DELETE http://localhost:9090/schedule/1


## Location API Calls

### GET ( Get All Locations )
curl http://localhost:9090/location

### GET ( Get Location)
curl http://localhost:9090/location/{id}

curl http://localhost:9090/location/1

### POST ( Add Location )
curl -d '{"building":"VLTC","floor":"First Floor","room":"L304"}' -H "Content-Type: application/json" -X POST http://localhost:9090/location

curl -d '{"building":"Chemistry Department","floor":"Ground Floor","room":"25"}' -H "Content-Type: application/json" -X POST http://localhost:9090/location/

### PUT ( Update Location )
curl -d '{"building":"VLTC - NEW","floor":"First Floor","room":"L304"}' -H "Content-Type: application/json" -X PUT http://localhost:9090/location/4

### DELETE ( Delete Location )
curl -X DELETE http://localhost:9090/location/{id}

curl -X DELETE http://localhost:9090/location/5