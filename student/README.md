
## Springboot MYSQL CURD App


```
git clone <repo>

cd student

# Launch mysql db docker instance
docker-compose up -d

# Launch App

# Add Record
curl --request POST  --url http://localhost:8082/api/students  --header 'Content-Type: application/json'  --data '{ "studentName":"Lokesh", "age":23 }'

# Get All students 
curl --request GET  --url http://localhost:8082/api/students  

# Update Record
curl --request PUT  --url http://localhost:8082/api/students/2  --header 'Content-Type: application/json'  --data '{ "studentName":"Lokesh", "age":23 }'

# Delete Record
curl --request DELETE  --url http://localhost:8082/api/students/2  

```

