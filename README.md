# AlphaSenseNew Test Framework

Reworked Home task from AlphaSense.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You need to install the following:
- Apache Maven 3.6.0

## Running the tests

1. Tests can be run by executing the following command in project directory:
```
mvn clean test -DbaseUrl="http://petstore.swagger.io" -Dcucumber.options="--tags '@category-all' --plugin io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm" allure:serve
```
where you can specify annotation to choose which tests you want to execute. It is possible to specify the following annotations:
@category-all - allows you to run all tests in project
@category-one - allows you to run 1st test (pet testing)
@category-two - allows you to run 2nd test (order testing)

- also now you can optionally specify baseUrl parameter (DbaseUrl in command line above) with actual url of the test product.
- allure:serve - open web page with test report generated with allure

All tests are stored in _PetStore.feature_ file.

## Author

* **Mikhail Yakushev** - *Automation QA Engineer*
