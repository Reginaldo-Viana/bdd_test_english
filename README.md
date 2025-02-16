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
2. Configuration:
To run in headless mode or in a specific language, adjust the settings in the getChromeOptions() method.
3. Install Dependencies:
bash
mvn clean install
4. Run Tests:
mvn test
