### Customer annotation interceptor get Caller from header: X-Caller-ID

POST /api/templates
```shell
curl --location 'http://localhost:8080/api/templates' \
--header 'X-Caller-ID: random-id-1' \
--header 'Content-Type: application/json' \
--data '{
"templateName": "Welcome Email",
"templateContent": "Hello, welcome to our service!"
}'
```
PUT /api/templates/{templateId}
```shell
curl --location --request PUT 'http://localhost:8080/api/templates/1' \
--header 'X-Caller-ID: random-id-1' \
--header 'Content-Type: application/json' \
--data '{
    "templateName": "Welcome Email - Updated",
    "templateContent": "Hello, welcome to our updated service!"
}'
```

GET /api/templates
```shell
curl --location 'http://localhost:8080/api/templates'
```