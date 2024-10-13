package WebDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

/**
 * The FirefoxMyWebDriver class extends the FirefoxDriver and implements the MyWebDriver interface.
 * It provides a wrapper around the FirefoxDriver to manage WebDriver functionalities effectively.
 *
 * <p>This class is responsible for initializing the FirefoxDriver and providing methods for
 * navigating and managing browser behavior.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     FirefoxMyWebDriver myDriver = new FirefoxMyWebDriver();
 *     myDriver.get("https://example.com");
 *     System.out.println(myDriver.getTitle());
 *     myDriver.quit();
 * </pre>
 */
public class FirefoxMyWebDriver implements MyWebDriver {
    private FirefoxDriver driver;

    /**
     * Constructs a new instance of FirefoxMyWebDriver and initializes the FirefoxDriver.
     */
    public FirefoxMyWebDriver() {
        driver = new FirefoxDriver();
    }

    /**
     * Returns the underlying FirefoxDriver instance.
     *
     * @return the FirefoxDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Navigates to the specified URL.
     *
     * @param url the URL to navigate to
     */
    @Override
    public void get(String url) {
        driver.get(url);
    }

    /**
     * Retrieves the title of the current page.
     *
     * @return the title of the current page
     */
    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Closes the browser and quits the driver.
     */
    @Override
    public void quit() {
        driver.quit();
    }

    /**
     * Maximizes the browser window.
     */
    @Override
    public void maximize() {
        driver.manage().window().maximize();
    }

    /**
     * Sets the timeouts for implicit waits and page load.
     */
    @Override
    public void timeouts() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
}
