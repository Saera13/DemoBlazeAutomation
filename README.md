# DemoBlaze Automation (Selenium + Java)

This project automates an end-to-end purchase flow on https://www.demoblaze.com using **Selenium, Java, TestNG, Maven**, and **CSV data-driven testing**.

---

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- CSV (OpenCSV)

---

## Project Structure
Seleniumpractice
│
├── src
│ ├── test
│ │ ├── java
│ │ │ ├── base
│ │ │ │ └── BaseTest.java
│ │ │ ├── pages
│ │ │ │ ├── HomePage.java
│ │ │ │ ├── ProductPage.java
│ │ │ │ ├── CartPage.java
│ │ │ │ └── PlaceOrderPage.java
│ │ │ ├── tests
│ │ │ │ └── PurchaseTest.java
│ │ │ └── utils
│ │ │ ├── CSVUtils.java
│ │ │ ├── WaitUtils.java
│ │ │ └── ScreenshotUtils.java
│ │ └── resources
│ │ └── testdata.csv
│
├── testng.xml
├── pom.xml
├── README.md

---

## 📄 CSV Test Data

Location:src/test/resources/testdata.csv



Each row represents **one complete order**.

---

## ▶️ How to Run the Test

### 🔹 Option 1: Run using TestNG (Recommended)

1. Open the project in **Eclipse / IntelliJ**
2. Right-click on **testng.xml**
3. Select **Run As → TestNG Suite**

---

### 🔹 Option 2: Run Individual Test

1. Navigate to:src/test/java/tests/PurchaseTest.java
2. 2. Right-click the file
3. Select **Run As → TestNG Test**

---

### 🔹 Option 3: Run via Maven (CLI)

Open terminal in project root:

```bash
mvn clean test


