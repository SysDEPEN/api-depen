## How to run code ?

### First step:
- Create a database in POSTGRESQL with name: depen
- Run download sources on Maven in pom.xml
- Create a collection in Insomnia or Postman
- Default url: http://localhost:8080/api/v1/


### After create a collection in insomnia/Postman:
- Use this example Request JSON in METHOD POST to User:
  ```
  {
      "name": "João da silva",
      "document": "123456789002",
      "data_born": "1980-01-01",
      "email": "joaosilva@example.com",
      "password": "123456",
      "role": 1,
      "created_at": "2024-06-24T22:32:00",
      "updated_at": "2024-06-24T22:32:00"
  }

- Verify your route path in controller.
- Congratulations, you run the better code!! 😁😘