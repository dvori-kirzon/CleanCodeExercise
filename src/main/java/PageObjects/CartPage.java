package PageObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The CartPage class represents the shopping cart page of the application.
 * It provides methods to view the cart and proceed to the checkout process.
 *
 * <p>This class extends the DriverBase class, which provides access to the WebDriver instance.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     CartPage cartPage = new CartPage(driver);
 *     cartPage.viewCart();
 *     cartPage.proceedToCheckout();
 * </pre>
 */
public class CartPage extends DriverBase {

    private Actions actions; // Actions instance for performing complex user interactions
    private WebDriver driver; // WebDriver instance for interacting with the browser

    /**
     * The container for the shopping cart.
     */
    @FindBy(className = "cart-container")
    private WebElement cart;

    /**
     * The button to view the cart.
     */
    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement btn_view_cart;

    /**
     * The button to proceed to checkout.
     */
    @FindBy(className = "checkout")
    private WebElement btn_checkout;

    /**
     * Constructs a CartPage instance and initializes the WebDriver and Actions.
     *
     * @param driver the WebDriver instance to be used for interacting with the page
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;  // Initialize the driver
        this.actions = new Actions(driver);  // Create an Actions object
        PageFactory.initElements(driver, this);  // Initialize the page elements
    }

    /**
     * Views the shopping cart by hovering over the cart and clicking the "View Cart" button.
     */
    public void viewCart() {
        // Hover over the shopping cart
        actions.moveToElement(cart).perform();
        // Click the "View Cart" button
        btn_view_cart.click();
    }

    /**
     * Proceeds to the checkout process by hovering over the cart and clicking the "Checkout" button.
     * Waits until the button is clickable before performing the click action.
     */
    public void proceedToCheckout() {
        // Hover over the shopping cart
        actions.moveToElement(cart).perform();

        // Wait until the "Checkout" button is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btn_checkout));

        // Click the "Checkout" button
        btn_checkout.click();
    }
}
