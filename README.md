
# Requirements to execute the project

1. Clone project from [Github Link](https://github.com/shekhfiroz/truck.git)
2. Import as Existing Maven Projects if it is Eclipse
3. Install mongodb in your local system with default port 27017
4. Run TruckApplication as Spring Boot App.


# How to test the Program
1. Install Postman
2. Go to [API Documentation](http://localhost:9999/swagger-ui.html) to know the API details.


# Example

**URL :** localhost:9999/signup

**Body :** application /json

**Input :**

```
{
    "firstName": "Sam",
    "lastName": "Altaf",
    "mobile": "7995504416",
    "email": "altaf@gmail.com",
    "password": "altaf",
    "role": "USER"
}
```

**Output :**

```
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1ZDM0NzcxMzc2YmYxNzNmMzBlMmU3M2IiLCJpYXQiOjE1NjM3MjAwODksImV4cCI6MTU2Mzc2MzI4OX0.02LH6OJCiT95pnFCMTwZV-rDUkPrAn5B4UuwWCz0vjKXnb15VZ9sdmdbKAXz9ZCkULSg0IAfYycHbZScMAGGoQ

```