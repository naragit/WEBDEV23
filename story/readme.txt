
curl --header "Content-Type: application/json"   --request POST   --data '{"id":2, "title":"xyz","body":"test sec"}'  http://localhost:8080/rest/story/create

curl http://localhost:8080/rest/story/get/1

curl http://localhost:8080/rest/story/getall



