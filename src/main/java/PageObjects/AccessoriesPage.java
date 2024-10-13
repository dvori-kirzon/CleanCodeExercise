package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * The AccessoriesPage class represents the accessories page of the application.
 * It provides methods to select products from the list of accessories.
 *
 * <p>This class extends the DriverBase class, which provides access to the WebDriver instance.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
 *     accessoriesPage.selectProducts(0); // Selects the first accessory product
 * </pre>
 */
public class AccessoriesPage extends DriverBase {

    /**
     * A list of accessory products displayed on the page.
     */
    @FindBy(className = "ast-col-sm-12")
    private List<WebElement> lst_accessories_products;

    /**
     * Selects a product from the list of accessories by its index.
     *
     * @param num the index of the product to be selected (0-based)
     */
    public void selectProducts(int num) {
        lst_accessories_products.get(num).click(); // Clicks the specified accessory product
    }
}

