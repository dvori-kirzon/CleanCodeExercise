package WebDrivers;

/**
 * The {@code BrowserType} enum defines the supported browser types for the automation framework.
 * Each enum constant corresponds to a specific web browser and its associated WebDriver implementation.
 *
 * <p>This enum is used to facilitate the instantiation of the appropriate WebDriver based on
 * the user's selection of the browser type. It encapsulates the mapping between the browser type
 * and its corresponding WebDriver class.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     BrowserType browserType = BrowserType.CHROME;
 *     MyWebDriver driver = BrowserFactory.createDriver(browserType);
 * </pre>
 */
public enum BrowserType {
    CHROME(ChromeMyWebDriver.class),
    FIREFOX(FirefoxMyWebDriver.class);

    private Class<? extends MyWebDriver> driverClass;

    /**
     * Constructor to initialize the BrowserType enum with the corresponding WebDriver class.
     *
     * @param driverClass the class of the WebDriver implementation for the browser type
     */
    BrowserType(Class<? extends MyWebDriver> driverClass) {
        this.driverClass = driverClass;
    }

    /**
     * Retrieves the WebDriver class associated with the browser type.
     *
     * @return the class of the WebDriver implementation
     */
    public Class<? extends MyWebDriver> getDriverClass() {
        return driverClass;
    }
}
