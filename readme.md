# For testing purpose
curl http://localhost:9090/welcome


# GET ( Get All Courses )
curl http://localhost:9090/


# GET ( Get Course by Id)
curl http://localhost:9090/{id}
curl http://localhost:9090/1


# POST ( Add Course )
curl -d '{"courseId":"1","courseName":"Java Programming"}' -H "Content-Type: application/json" -X POST http://localhost:9090/
curl -d '{"courseName":"Auto Programming"}' -H "Content-Type: application/json" -X POST http://localhost:9090/



# PUT ( Update Course )
curl -d '{"courseId":"1","courseName":"Java Programming"}' -H "Content-Type: application/json" -X PUT http://localhost:9090/{id}
curl -d '{"courseId":"1","courseName":"Java Programming"}' -H "Content-Type: application/json" -X PUT http://localhost:9090/1


# DELETE ( Delete Course )
curl -X DELETE http://localhost:9090/{id}
curl -X DELETE http://localhost:9090/1


# Connection
Make sure to check you connection if error occured