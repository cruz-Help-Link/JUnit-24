# JUnit, Code Coverage, Mocks, and API Testing

This repository demonstrates comprehensive testing techniques using JUnit and JaCoCo for code coverage, Hamcrest matchers, stubs, and mocks with Mockito, test planning with JMeter, and API testing using Postman.

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [JUnit Test Cases](#junit-test-cases)
- [JUnit Annotations](#junit-annotations)
- [Code Coverage with JaCoCo](#code-coverage-with-jacoco)
- [Hamcrest Matchers](#hamcrest-matchers)
- [Stubs and Mocks with Mockito](#stubs-and-mocks-with-mockito)
- [Test Planning with JMeter](#test-planning-with-jmeter)
- [API Testing with Postman](#api-testing-with-postman)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## Introduction

This project covers unit testing in Java using JUnit, including various annotations, matchers, code coverage analysis with JaCoCo, and mocking strategies with Mockito. Additionally, it provides guidelines for load and performance testing with JMeter and API testing using Postman.

---

## Getting Started

Clone the repository to your local machine:

```
git clone https://github.com/cruz-Help-Link/JUnit-24.git
cd JUnit-24
```

Install dependencies via Maven:

```
mvn clean install
```

---

## JUnit Test Cases

JUnit is a popular Java testing framework used to write and run repeatable tests. This project demonstrates various test cases using JUnit.

### Sample Test Case

```
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArithmeticTest {

    @Test
    public void testAddition() {
        assertEquals(10, 5 + 5);
    }
}
```

---

## JUnit Annotations

JUnit provides various annotations to manage the lifecycle of tests:

- `@Test`: Marks a method as a test case.
- `@Before`: Runs before each test method, useful for setting up.
- `@After`: Runs after each test method to clean up.
- `@BeforeClass`: Runs once before all test methods in the class.
- `@AfterClass`: Runs once after all test methods in the class.
- `@Ignore`: Ignores a test case.

### Example Usage

```
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LifecycleTest {

    @Before
    public void setUp() {
        // Set up resources
    }

    @Test
    public void testSomething() {
        assertTrue(true);
    }

    @After
    public void tearDown() {
        // Clean up resources
    }
}
```

---

## Code Coverage with JaCoCo

JaCoCo is used to track code coverage for your tests. It helps in identifying how much of your code is covered by your unit tests.

### Running Code Coverage

To generate a code coverage report using JaCoCo, run:

```
mvn test jacoco:report
```

The coverage report will be generated in the `/target/site/jacoco` folder.

---

## Hamcrest Matchers

Hamcrest is a library of matchers for creating more readable and flexible assertions.

### Sample Usage

```
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class HamcrestTest {

    @Test
    public void testMatchers() {
        assertThat("Hamcrest", containsString("rest"));
        assertThat(10, greaterThan(5));
    }
}
```

Common matchers include:
- `is()`
- `containsString()`
- `equalTo()`
- `greaterThan()`

---

## Stubs and Mocks with Mockito

Mockito is a powerful mocking framework used to mock objects and define behaviour for dependencies.

### Sample Mocking

```
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.Mockito;

public class MockTest {

    @Test
    public void testWithMock() {
        List mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(5);

        assertEquals(5, mockedList.size());
        verify(mockedList).size();
    }
}
```

### Key Annotations

- `@Mock`: Creates mock objects.
- `@InjectMocks`: Injects mocks into the object being tested.
- `@Spy`: Partially mocks an object, preserving real behaviour for some methods.

---

## Test Planning with JMeter

JMeter is used for load and performance testing of your APIs.

### Basic JMeter Test Plan

1. **Create a Thread Group**: Simulate multiple users by setting up threads, ramp-up time, and loops.
2. **Add HTTP Sampler**: Define the API request with method type, parameters, and headers.
3. **Add Assertions**: Validate response data using assertions.
4. **Add Listeners**: Capture results and generate reports using listeners like "View Results Tree" or "Summary Report."

Run JMeter and load the `.jmx` test plan to validate your API's performance under load.

---

## API Testing with Postman

Postman is used to validate the REST APIs of this project. You can easily test the APIs by importing the Postman collection included in the repository.

### API Testing Steps

1. **Start the Application**: 
   ```
   mvn spring-boot:run
   ```

2. **Import Postman Collection**: Import the provided `Postman_Collection.json` file into Postman.

3. **Execute API Requests**: Validate the API endpoints like:
   - **GET /api/users**: Retrieve users
   - **POST /api/users**: Add a new user
   - **PUT /api/users/{id}**: Update a user
   - **DELETE /api/users/{id}**: Remove a user

### Example API Request

- **POST /api/users**

  Create a user by sending a `POST` request with the following body:

  ```
  {
    "name": "John Doe",
    "email": "johndoe@example.com"
  }
  ```

---

## Project Structure

```
src/
 ├── main/
 │   ├── java/
 │   │   └── com.example/
 │   │       ├── controller/
 │   │       ├── service/
 │   │       └── model/
 │   └── resources/
 └── test/
     └── java/
         └── com.example/
             ├── unit/
             ├── integration/
             └── mocktests/
Postman_Collection.json
```

---

## Contributing

Feel free to submit pull requests or issues to improve the test coverage and functionality of the project.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



