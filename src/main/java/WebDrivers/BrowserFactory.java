package WebDrivers;

import org.openqa.selenium.WebDriver;

/**
 * The {@code BrowserFactory} class provides a factory method for creating
 * browser driver instances based on the specified {@link BrowserType}.
 *
 * <p>It encapsulates the logic for instantiating different WebDriver implementations
 * without the need to directly reference specific driver classes in the client code.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     MyWebDriver driver = BrowserFactory.createDriver(BrowserType.CHROME);
 * </pre>
 */
public class BrowserFactory {

    /**
     * Creates a WebDriver instance based on the provided {@code BrowserType}.
     *
     * @param browserType the type of browser to instantiate
     * @return a new instance of {@link MyWebDriver}
     * @throws Exception if an error occurs during driver instantiation
     */
    public static MyWebDriver createDriver(BrowserType browserType) throws Exception {
        return browserType.getDriverClass().getDeclaredConstructor().newInstance();
    }
}
