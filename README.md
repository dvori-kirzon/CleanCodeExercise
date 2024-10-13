Selenium Automation Project
Project Description
This project is designed for automating web navigation using Selenium. The project adheres to the principles of Clean Code and SOLID in the class structure.

Clean Code and SOLID Principles
Single Responsibility Principle (SRP): Each class has one clear and distinct responsibility.
Open/Closed Principle (OCP): The code is open for extension but closed for modification, allowing new features without changing existing code.
Liskov Substitution Principle (LSP): Any subclass can replace its parent class without breaking functionality.
Interface Segregation Principle (ISP): Interfaces are divided so that each class uses only the methods relevant to it.
Dependency Inversion Principle (DIP): Dependencies rely on abstractions (interfaces) rather than concrete implementations.
Class Descriptions
DriverBase
Description: A base class that defines the driver field, making it available to all child classes.
Principle: SRP - It is solely responsible for storing the WebDriver. It performs no other actions.

HomePage
Description: Responsible for interactions on the homepage, including menu selection.
Principle: SRP - All actions are meant for homepage functionality only.
Clean Code Implementation: Clear method names, such as selectMenuOption, improve readability.

ProductPage
Description: Manages the process of adding a product to the cart.
Principle: SRP - Handles actions on the product page, such as selecting quantity and clicking the 'Add to Cart' button.
Clean Code: Each action is performed in dedicated methods like clickAddToCart.

CheckoutPage
Description: Responsible for filling in billing details and completing the order.
Principle: SRP - It only deals with actions related to the checkout page.
Clean Code: Clear actions such as fillBillingDetails enhance readability.

CartPage
Description: Manages the shopping cart and the checkout process.
Principle: SRP - Focuses only on interactions with the shopping cart.
LSP: The class can be replaced by different versions without affecting functionality.

AccessoriesPage
Description: Allows product selection from the accessories list.
Principle: SRP - Handles only the selection of products from the accessories page.

ChromeMyWebDriver & FirefoxMyWebDriver
Description: Specific implementations of MyWebDriver for different browsers.
Principle: ISP - The MyWebDriver interface separates the relevant functionalities for different browsers.
LSP: Each implementation replaces the parent class without breaking the system.

BrowserFactory
Description: Responsible for creating instances of WebDriver based on the selected browser.
Principle: SRP - Solely responsible for creating WebDriver instances, without additional logic.

BrowserType
Description: An enum that represents the supported browser types in the project.
Principle: SRP - Used only for defining the browser types in the system.

MyWebDriver
Description: Interface that defines basic browser actions.
Principle: ISP - The interface defines actions intended only for browsers, not for other operations.

LoggingExtension
Description: Handles logging actions before and after tests.
Principle: SRP - Only responsible for managing the test logs.

TestWatchers
Description: Manages tracking test results (success, failure, cancellation).
Principle: SRP - Only deals with tracking test results.

Conclusion
In this project, every class is implemented in accordance with Clean Code and SOLID principles, improving the readability, scalability, and maintainability of the code.

