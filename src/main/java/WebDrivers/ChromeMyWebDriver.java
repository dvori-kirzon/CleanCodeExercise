package WebDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * The ChromeMyWebDriver class extends the ChromeDriver and implements the MyWebDriver interface.
 * It provides a wrapper around the ChromeDriver to manage WebDriver functionalities more effectively.
 *
 * <p>This class is responsible for initializing the ChromeDriver and providing methods for
 * navigating and managing browser behavior.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     ChromeMyWebDriver myDriver = new ChromeMyWebDriver();
 *     myDriver.get("https://example.com");
 *     System.out.println(myDriver.getTitle());
 *     myDriver.quit();
 * </pre>
 */
public class ChromeMyWebDriver implements MyWebDriver {
    private ChromeDriver driver;

    /**
     * Constructs a new instance of ChromeMyWebDriver and initializes the ChromeDriver.
     */
    public ChromeMyWebDriver() {
        driver = new ChromeDriver();
    }

    /**
     * Returns the underlying ChromeDriver instance.
     *
     * @return the ChromeDriver instance
     */
    public ChromeDriver getChromeMyWebDriver() {
        return driver;
    }

    @Override
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
