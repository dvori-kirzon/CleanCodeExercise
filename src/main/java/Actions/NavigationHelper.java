package Actions;

import org.openqa.selenium.WebDriver;

/**
 * The {@code NavigationHelper} class provides utility methods to help with navigating through web pages
 * in browser automation tests. It acts as a wrapper around the {@link WebDriver} to simplify navigation tasks.
 *
 * <p>This class is mainly responsible for navigating to specific URLs using the {@link WebDriver#get(String)} method.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * WebDriver driver = new ChromeDriver();
 * NavigationHelper navigationHelper = new NavigationHelper(driver);
 * navigationHelper.navigateTo("https://example.com");
 * </pre>
 */
public class NavigationHelper {

    /**
     * The WebDriver instance used to interact with the browser.
     */
    WebDriver driver;

    /**
     * Constructs a new {@code NavigationHelper} with the specified {@link WebDriver}.
     *
     * @param driver the WebDriver used for browser interaction
     */
    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigates the browser to the specified URL.
     *
     * @param url the URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

}
