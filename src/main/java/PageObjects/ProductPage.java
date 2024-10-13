package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The ProductPage class represents the product page of the application.
 * It provides methods to interact with the page elements such as adding a product to the cart and adjusting the quantity.
 *
 * <p>This class extends the DriverBase class, which provides access to the WebDriver instance.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     ProductPage productPage = new ProductPage(driver);
 *     productPage.clickAddToCart(3);
 * </pre>
 */
public class ProductPage extends DriverBase {

    /**
     * The "Add to Cart" button on the product page.
     */
    @FindBy(className = "single_add_to_cart_button")
    private WebElement btn_addToCart;

    /**
     * The quantity input field where the user can specify how many items to add to the cart.
     */
    @FindBy(className = "qty")
    private WebElement input_quantity;

    /**
     * Adds the specified quantity of the product to the shopping cart.
     *
     * <p>This method clears the quantity input field, enters the desired quantity,
     * and then clicks the "Add to Cart" button.</p>
     *
     * @param quantity the number of items to add to the cart
     */
    public void clickAddToCart(int quantity) {
        // Clear the quantity input to avoid appending previous values
        input_quantity.clear();
        // Convert the quantity to String and input it into the quantity field
        input_quantity.sendKeys(String.valueOf(quantity));
        // Click the "Add to Cart" button
        btn_addToCart.click();
    }
}
