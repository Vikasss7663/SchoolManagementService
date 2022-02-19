curl http://localhost:9090/welcome

curl http://localhost:9090/

curl http://localhost:9090/{id}
curl http://localhost:9090/1

curl -d '{"courseId":"1","courseName":"Java Programming"}' -H "Content-Type: application/json" -X POST http://localhost:9090/

curl -d '{"courseId":"1","courseName":"Java Programming"}' -H "Content-Type: application/json" -X PUT http://localhost:9090/{id}
curl -d '{"courseId":"1","courseName":"Java Programming"}' -H "Content-Type: application/json" -X PUT http://localhost:9090/1

curl -X DELETE http://localhost:9090/{id}
curl -X DELETE http://localhost:9090/1
