# Automation Exercise E-commerce Website

## Overview
This project focuses on testing the entire **E-commerce Website** [Automation Exercise](https://automationexercise.com/). 
We will perform **Manual, API, and Automation Testing** to ensure the application's reliability, functionality, and performance.

## Testing Approach
We will use multiple testing methodologies:

### 1. Manual Testing
- Test cases are designed and executed manually.
- Identifies UI/UX issues and functional bugs.
- Ensures compliance with business requirements.

### 2. API Testing (Postman)
- Verifies the API responses and status codes.
- Tests request methods (GET, POST, PUT, DELETE).
- Ensures API reliability, security, and performance.

### 3. Automation Testing
- **Tool:** Selenium WebDriver
- **Language:** Java
- **Framework:** TestNG
- **Design Pattern:** Page Object Model (POM)
- **Reporting:** Allure Report
- **Execution:** Automated test scripts for regression and functional testing

## Project Structure
```
|-- src/test/java
|   |-- pages/        # Page Object Model classes
|   |-- tests/        # Test cases
|   |-- utils/        # Utility classes (e.g., WebDriver setup)
|-- src/test/resources
|   |-- testdata/     # Test data files
|-- reports/          # Allure reports
|-- pom.xml           # Maven dependencies
|-- README.md         # Project documentation
```

## Prerequisites
- Java JDK 8 or later
- Maven installed
- Selenium WebDriver
- TestNG framework
- Postman for API testing
- Allure for test reports

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/ecommerce-testing.git
   ```
2. Navigate to the project directory:
   ```sh
   cd ecommerce-testing
   ```
3. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```
4. Run test cases:
   - **Manual tests:** Follow the test cases documentation.
   - **API tests:** Use Postman collection.
   - **Automation tests:**
     ```sh
     mvn test
     ```

## Test Reports
- **Allure Report Generation:**
  ```sh
  mvn allure:serve
  ```
- View the generated test execution report in a browser.

## Contribution Guidelines
- Follow the project structure for adding new test cases.
- Ensure proper naming conventions and code documentation.
- Run all tests before committing new changes.

## Contact
For any issues or suggestions, please create an issue in the repository or reach out to the project contributors.

