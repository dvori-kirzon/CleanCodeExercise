package PageObjects;

import org.openqa.selenium.WebDriver;

/**
 * The {@code DriverBase} class serves as a base class for managing
 * the WebDriver instance used in the automation framework. It
 * provides a common field for derived classes to access the
 * WebDriver, allowing for consistent handling of browser interactions.
 *
 * <p>
 * This class is designed to be extended by other page object classes
 * that require access to the WebDriver. By encapsulating the WebDriver
 * instance in a base class, we promote code reusability and adhere
 * to the Single Responsibility Principle (SRP).
 * </p>
 *
 * <p>
 * Usage example:
 * <pre>
 * public class HomePage extends DriverBase {
 *     public void someHomePageMethod() {
 *         // Use the driver instance here
 *     }
 * }
 * </pre>
 * </p>
 *
 * @see WebDriver
 */
public class DriverBase {

    /**
     * The WebDriver instance used for browser automation.
     * This field is protected, allowing access to subclasses.
     */
    protected WebDriver driver;

}
