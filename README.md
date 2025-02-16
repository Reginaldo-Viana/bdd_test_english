# 📚 Project: Automated Tests for Amazon

This project uses **Selenium WebDriver** with **Cucumber** to **automate tests** for Amazon's website functionalities, including:
- **Login with OTP (One-Time Password)**
- **Product Search**

---

## ⚙️ Technologies Used:
- **Java** (JDK 11 or higher)
- **Selenium WebDriver**
- **Cucumber** (BDD)
- **JUnit** (for test execution)
- **Maven** (dependency management)

---

## 📂 Project Structure:
```plaintext
src
├── test
│   ├── java
│   │   ├── hooks           # Hooks for test setup and teardown
│   │   ├── page            # Page Objects for Amazon pages
│   │   ├── Runners         # Cucumber Test Runner configurations
│   │   └── Steps           # Step definitions for feature files
│   │
│   └── resources
│       └── Features        # .feature files containing BDD scenarios
│           ├── amazon_login_with_otp.feature
│           └── search_amazon_products.feature
│
└── target                  # Compiled output and test reports
🚀 Running the Project:
1. Prerequisites:
Java (JDK 11+) and Maven installed.
ChromeDriver added to the system PATH.
2. Configuration:
In Browser.java, set the ChromeDriver path if needed.
To run in headless mode or in a specific language, adjust the settings in the getChromeOptions() method.
3. Install Dependencies:
bash
Copiar
Editar
mvn clean install
4. Run Tests:
bash
Copiar
Editar
mvn test
5. Test Reports:
Reports are generated in the folder: target/cucumber-reports
📋 Features Tested:
🔑 Login with OTP
Accesses the Amazon Login Page.
Inputs email and password.
Verifies the error message when entering an invalid OTP.
🔎 Product Search
Navigates to the Amazon homepage.
Searches for a product.
Validates the display of search results.
📑 How to Write New Scenarios:
Create a new .feature file in:
swift
Copiar
Editar
src/test/resources/Features/
Define the scenario using Gherkin syntax:
gherkin
Copiar
Editar
Feature: Product Search on Amazon
  Scenario: Search for a specific product
    Given the user navigates to "https://www.amazon.com/"
    When the user searches for "Laptop"
    Then the user should see search results related to "Laptop"
Implement the step definitions in:
swift
Copiar
Editar
src/test/java/Steps/
🔧 Specific Configurations:
Open in Incognito Mode:
java
Copiar
Editar
options.addArguments("--incognito");
Run in Headless Mode:
java
Copiar
Editar
options.setHeadless(true);
Set Language to English:
java
Copiar
Editar
options.addArguments("--lang=en-US");
🎯 Future Improvements:
Implement tests for adding products to the cart.
Include price validation.
Automate the login using a cookie manager.
📄 License:
This project is for educational purposes and does not have commercial licensing.

🤝 Contributions:
Contributions are welcome! Fork the repository, add your changes, and open a Pull Request.

📝 Important Notes:
This project is for educational purposes only and should not be used for automation in production environments on Amazon.
Automating public websites is subject to the website's Terms of Use.
sql
Copiar
Editar

### 🔖 Instructions:
- Create a file named **README.md** in the root of your project.
- **Copy and paste** the content above into the file.
- Save the file and commit it with the following commands:
```bash
git add README.md
git commit -m "Added README.md to the project"
git push
