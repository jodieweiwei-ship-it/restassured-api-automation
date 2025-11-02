# REST API Test Automation with RestAssured

## 📋 Overview
Comprehensive API test automation framework using RestAssured and TestNG. Validates RESTful web services including CRUD operations, authentication, and response validation.

## 🛠️ Tech Stack
- **Language**: Java 11
- **API Testing**: RestAssured 5.4
- **Testing Framework**: TestNG 7.8
- **Build Tool**: Maven
- **API Endpoint**: https://reqres.in (Demo REST API)

## 📁 Project Structure
```
restassured-api-automation/
├── src/
│   └── test/java/
│       ├── base/
│       │   └── BaseTest.java        # Base configuration
│       └── tests/
│           ├── UserAPITest.java     # User CRUD tests
│           └── AuthenticationTest.java  # Auth tests
├── pom.xml
├── testng.xml
└── README.md
```

## ✨ Features
- Complete REST API testing (GET, POST, PUT, PATCH, DELETE)
- Request and response validation
- JSON schema validation
- Response time assertions
- Authentication and authorization testing
- Positive and negative test scenarios
- Detailed test reporting with TestNG

## 🚀 Getting Started

### Prerequisites
- Java JDK 11 or higher
- Maven 3.6+

### Installation
```bash
git clone https://github.com/yourusername/restassured-api-automation.git
cd restassured-api-automation
mvn clean install
```

### Running Tests
Run all tests:
```bash
mvn test
```

Run specific test class:
```bash
mvn test -Dtest=UserAPITest
```

## 📊 Test Coverage

### User API Tests
- ✅ GET - Retrieve list of users with pagination
- ✅ GET - Retrieve single user by ID
- ✅ GET - Handle non-existent user (404)
- ✅ POST - Create new user
- ✅ PUT - Update existing user
- ✅ PATCH - Partial update user
- ✅ DELETE - Remove user
- ✅ Response time validation

### Authentication Tests
- ✅ Successful registration
- ✅ Registration validation (missing fields)
- ✅ Successful login
- ✅ Login with invalid credentials

## 🎯 Key Test Scenarios

### Example: User Creation Validation
```java
@Test
public void testCreateUser() {
    given()
        .contentType(ContentType.JSON)
        .body("{\"name\":\"Jodie Wei\",\"job\":\"SDET\"}")
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .body("name", equalTo("Jodie Wei"))
        .body("id", notNullValue());
}
```

### Example: Response Time Check
```java
@Test
public void testResponseTime() {
    Response response = given().get("/users?page=1");
    Assert.assertTrue(response.getTime() < 2000, 
        "Response time should be under 2 seconds");
}
```

## 📈 Future Enhancements
- [ ] Add data-driven testing with external data files
- [ ] Implement API chaining (use response from one test in another)
- [ ] Add Allure reporting
- [ ] Database validation integration
- [ ] API contract testing
- [ ] Performance testing scenarios
- [ ] CI/CD pipeline integration

## 📝 API Documentation
Using reqres.in demo API:
- Base URL: https://reqres.in/api
- Full documentation: https://reqres.in/

## 👤 Author
Wei Wei (Jodie)
- LinkedIn: [your-linkedin-url]
- Email: jodieweiwei@gmail.com

## 📄 License
This project is for educational and demonstration purposes.

---

## 🔍 Sample Test Output
```
[INFO] Running tests.UserAPITest
Status Code: 200
Response Time: 451ms
Response Body: {"page":1,"per_page":6,"total":12...}
Tests run: 8, Failures: 0, Errors: 0, Skipped: 0

[INFO] Running tests.AuthenticationTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] BUILD SUCCESS
```# restassured-api-automation
"API test automation using RestAssured and TestNG for RESTful services
