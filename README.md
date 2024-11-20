# Selenium Automation Framework #
## Overview ##
This project is a Selenium Automation Framework designed to perform automated testing for web applications. The framework is built using Java and incorporates best practices for test automation. It leverages TestNG, Page Object Model (POM), Retry Listeners, Extent Reports, and more to ensure modularity, scalability, and reliability.

### Features ###
TestNG Integration: Provides robust testing support, including annotations, test grouping, and parallel execution.
Page Object Model (POM): Ensures better maintainability and readability of code.
Retry Listeners: Automatically retries failed tests.
Logging: Implemented using Log4J for better traceability and debugging.
Reports: Generates interactive test reports using Extent Reports.
Configuration Management: Centralized configuration using a config.properties file.
Dependency Management: Handled with Maven (pom.xml).


## Project Structure ##
```
Selenium-Automation-Framework/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │       ├── analyzer/                 # Retry logic
│   │   │       │   ├── RetryAnalyzer.java
│   │   │       │   └── RetryTransformer.java
│   │   │       ├── ecom/qa/
│   │   │           ├── base/                # Base setup for tests
│   │   │           │   └── TestBase.java
│   │   │           ├── config/              # Configuration files
│   │   │           │   └── config.properties
│   │   │           ├── ExtentReportListener/ # Custom listeners for reporting
│   │   │           │   └── ExtentReportListener.java
│   │   │           ├── pages/               # Page classes implementing POM
│   │   │           │   ├── AddAddressPage.java
│   │   │           │   ├── LoginPage.java
│   │   │           │   ├── MyAccount.java
│   │   │           │   ├── SignUpPage.java
│   │   │           │   └── WhatsNewPage.java
│   │   │           ├── testdata/            # Test data files
│   │   │           │   └── loginData.xlsx
│   │   │           └── util/                # Utility functions
│   │   │               └── TestUtil.java
│   │   └── resources/
│   │       └── log4j.properties             # Log4J configuration file
│   ├── test/
│       ├── java/
│       │   ├── com/ecom/qa/tests/           # Test classes
│       │       ├── AddAddressTest.java
│       │       ├── LoginTest.java
│       │       └── MyAccountTest.java
│
├── target/                                   # Maven build files
│   ├── test-output/                          # TestNG output
│
├── .gitignore                                # Git ignore file
├── application.log                           # Log file
├── pom.xml                                   # Maven dependencies
└── README.md                                 # Project documentation

```
 ## Reporting ##
After test execution, the Extent Report is generated under the target/reports/ directory.
Open ExtentReport.html in a browser to view the interactive report

## Logging ##
Logs are captured using Log4J and can be found in the application.logs.
Update the log4j.properties file to modify log levels and formats.

## Key Technologies Used ##
Language: Java
Framework: Selenium, TestNG
Reporting: Extent Reports
Dependency Management: Maven
Logging: Log4J

## Acknowledgments ##
Special thanks to the open-source community and contributors for their support and inspiration.


