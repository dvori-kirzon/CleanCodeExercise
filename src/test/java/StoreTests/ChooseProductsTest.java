package StoreTests;

import lombok.extern.slf4j.Slf4j;
import Actions.NavigationHelper;
import PageObjects.*;
import WebDrivers.BrowserFactory;
import WebDrivers.BrowserType;
import WebDrivers.MyWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import Extensions.LoggingExtension;
import Extensions.TestWatchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;

/**
 * The {@code ChooseProductsTest} class is a JUnit test class for automating the process of choosing products
 * and making purchases in an online store using Selenium WebDriver.
 *
 * <p>This test class includes methods for setting up the test environment, running the tests,
 * and tearing down the environment after the tests. It leverages the {@link MyWebDriver} interface
 * to interact with the browser.</p>
 *
 * <p>It uses JUnit 5 annotations and the Selenium Page Object Model to represent different pages
 * in the store, including the {@link HomePage}, {@link AccessoriesPage}, {@link ProductPage},
 * {@link CartPage}, and {@link CheckoutPage}.</p>
 *
 * <p>Logging and test-watching extensions are used for better tracking and debugging purposes.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * ChooseProductsTest test = new ChooseProductsTest();
 * test.chooseProductsAndMakingPurchaseTest("Accessories", 2, 1);
 * }
 * </pre>
 */
@Slf4j
@ExtendWith({LoggingExtension.class, TestWatchers.class})
public class ChooseProductsTest {

    /**
     * The driver instance that implements {@link MyWebDriver} to control the browser.
     */
    static MyWebDriver driver;

    static {
        try {
            driver = BrowserFactory.createDriver(BrowserType.CHROME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Page Object for navigating the store.
     */
    NavigationHelper navigationHelper;

    /**
     * Page Objects representing the various pages of the store.
     */
    HomePage homePage;
    AccessoriesPage accessoriesPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    /**
     * Initializes the test environment before all tests.
     * This method sets up the ChromeDriver and maximizes the browser window.
     */
    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver.maximize();
        driver.timeouts();
    }

    /**
     * Cleans up the test environment after all tests are executed.
     * This method quits the browser.
     */
    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    /**
     * Prepares the test environment before each test.
     * This method initializes the Page Objects and navigates to the store's homepage.
     */
    @BeforeEach
    void setUpBeforeEach() {
        System.out.println("Preparing environment for the test...");

        navigationHelper = PageFactory.initElements(driver.getDriver(), NavigationHelper.class);
        homePage = new HomePage(driver.getDriver());
        accessoriesPage = PageFactory.initElements(driver.getDriver(), AccessoriesPage.class);
        productPage = PageFactory.initElements(driver.getDriver(), ProductPage.class);
        cartPage = new CartPage(driver.getDriver());
        checkoutPage = PageFactory.initElements(driver.getDriver(), CheckoutPage.class);

        navigationHelper.navigateTo("https://atid.store/");
    }

    /**
     * Cleans up the test environment after each test.
     * This method is useful for logging or additional cleanup.
     */
    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Cleaning up environment after the test...");
    }

    /**
     * A parameterized test for selecting products, adding them to the cart, and making a purchase.
     * This test verifies if an error is displayed after attempting to place an order.
     *
     * @param menuOption the menu option to navigate to (e.g., "Accessories")
     * @param numProduct the index of the product to select
     * @param numQuantity the quantity of the product to add to the cart
     */
    @ParameterizedTest
    @CsvSource({
            "Accessories,2,1",
            "Accessories,1,2"
    })
    public void chooseProductsAndMakingPurchaseTest(String menuOption, int numProduct, int numQuantity) {
        homePage.selectMenuOption(menuOption);

        accessoriesPage.selectProducts(numProduct);

        productPage.clickAddToCart(numQuantity);

        cartPage.proceedToCheckout();

        checkoutPage.fillBillingDetails("John", "Doe", "Doe Enterprises",
                "Israel", "123 Main St", "90210", "Beverly Hills",
                "+1-310-555-1234", "john.doe@example.com");
        checkoutPage.placeOrder();
        Assertions.assertTrue(checkoutPage.isErrorDisplayed());



    }
}
