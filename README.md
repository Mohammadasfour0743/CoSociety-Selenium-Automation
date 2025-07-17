# CoSociety Selenium Automation

This project automates regression test cases of the CoSociety dashboard using **Selenium WebDriver** in **Java**, following the **Page Object Model (POM)** design pattern, which makes the project more scalable and efficient.

## Structure
The POM design pattern separates each page into a page and a test files. 
The **pages** can be found under the "io/cosociety/admin/pages" directory, and the **tests** for each page under the "test/java/part2/com/admin" directory.
There are two main pages in this project: Login and Dashboard pages, and there´s also the Base page. Each page has its corresponding test file that executes its own regression tests

## Tech Stack
- Selenium Webdriver (specifically Chrome)
- Java
- TestNG framework
- Maven
- Page Object Model (POM)
