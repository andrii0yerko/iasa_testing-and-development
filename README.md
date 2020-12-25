# iasa_testing-and-development
A repo for "Testing and Development" course hometasks, KPI IASA 2020

Chosen programming language - **JAVA**

# Home Task 3: Selenium
The aim of this assignment is to implement a little automation testing framework using [Selenium](https://www.selenium.dev/) and [Cucumber](https://cucumber.io/),
based on BDD test cases from the previous task.

## How to run:
### Preparing of external dependencies
This is a Java project, so if you don't have JDK 8 or later you should install it.

Also, it uses ChromeWebDriver for tests launching, which means you need to have Google Chrome installed.

If you prefer another browser you should change driver initialization it `TestContext.java`.
### Launching
1. Make sure that Maven is installed with
   ```mvn --version```, if not - install it (on Debian-based OS use `sudo apt-get install maven`)
2. Get this branch with `git clone --single-branch --branch andrii.yerko_lab3 https://github.com/andrii0yerko/iasa_testing-and-development.git`
   (or simply download it)
3. Open resulting folder `cd iasa_testing-and-development`
4. Then start tests using `mvn test`

Alternatively, you can import this project to your favorite IDE and run tests within it (I'm using IntelliJ IDEA)
   
---
Tasks are placed in different [branches](https://github.com/andrii0yerko/iasa_testing-and-development/branches)
* [Home Task 4: WebAPI basics](https://github.com/andrii0yerko/iasa_testing-and-development/tree/andrii.yerko_lab4)
* [Home Task 3: Selenium](https://github.com/andrii0yerko/iasa_testing-and-development/tree/andrii.yerko_lab3)
   * [Home Task 2: Test Automation Fundamentals](https://github.com/andrii0yerko/iasa_testing-and-development/tree/andrii.yerko_lab2)
* [Home Task 1: Basic knowledge in Java](https://github.com/andrii0yerko/iasa_testing-and-development/tree/andrii.yerko_lab1)
