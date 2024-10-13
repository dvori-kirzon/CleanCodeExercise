package WebDrivers;

import org.openqa.selenium.WebDriver;

/**
 * The MyWebDriver interface provides an abstraction for WebDriver implementations.
 * It defines essential methods for browser management and navigation.
 *
 * <p>This interface should be implemented by any class that wraps a WebDriver instance,
 * allowing for consistent handling of browser actions across different WebDriver types.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     class CustomWebDriver implements MyWebDriver {
 *         // Implementation of methods
 *     }
 * </pre>
 */
public interface MyWebDriver {
    /**
     * Retrieves the underlying WebDriver instance.
     *
     * @return the WebDriver instance
     */
    WebDriver getDriver();

    /**
     * Navigates to the specified URL.
     *
     * @param url the URL to navigate to
     */
    void get(String url);

    /**
     * Retrieves the title of the current page.
     *
     * @return the title of the current page
     */
    String getTitle();

    /**
     * Closes the browser and quits the driver.
     */
    void quit();

    /**
     * Maximizes the browser window.
     */
    void maximize();

    /**
     * Sets the timeouts for implicit waits and page loads.
     */
    void timeouts();
}
