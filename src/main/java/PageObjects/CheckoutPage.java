package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The CheckoutPage class represents the checkout page of the application.
 * It provides methods to fill in billing details and place an order.
 *
 * <p>This class extends the DriverBase class, which provides access to the WebDriver instance.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     CheckoutPage checkoutPage = new CheckoutPage(driver);
 *     checkoutPage.fillBillingDetails("John", "Doe", "MyCompany", "USA", "123 Main St", "12345", "City", "1234567890", "email@example.com");
 *     checkoutPage.placeOrder();
 * </pre>
 */
public class CheckoutPage extends DriverBase {

    /**
     * The input field for the billing first name.
     */
    @FindBy(id = "billing_first_name")
    private WebElement first_name;

    /**
     * The input field for the billing last name.
     */
    @FindBy(id = "billing_last_name")
    private WebElement last_name;

    /**
     * The input field for the billing company name (optional).
     */
    @FindBy(id = "billing_company")
    private WebElement company_name;

    /**
     * The element to click for selecting the billing country.
     */
    @FindBy(id = "select2-billing_country-container")
    private WebElement country_click;

    /**
     * The input field for entering the billing country name.
     */
    @FindBy(className = "select2-search__field")
    private WebElement country_name;

    /**
     * The input field for the billing address.
     */
    @FindBy(id = "billing_address_1")
    private WebElement address_name;

    /**
     * The input field for the billing postcode.
     */
    @FindBy(id = "billing_postcode")
    private WebElement postcode;

    /**
     * The input field for the billing city.
     */
    @FindBy(id = "billing_city")
    private WebElement city;

    /**
     * The input field for the billing phone number.
     */
    @FindBy(id = "billing_phone")
    private WebElement phone;

    /**
     * The input field for the billing email address.
     */
    @FindBy(id = "billing_email")
    private WebElement email;

    /**
     * The button to place the order.
     */
    @FindBy(id = "place_order")
    private WebElement btn_place_order;

    /**
     * The element that displays error messages, if any.
     */
    @FindBy(className = "woocommerce-error")
    private WebElement txt_error;

    /**
     * Fills in the billing details required to complete the order.
     *
     * <p>This method clears existing values and enters the provided details into the corresponding fields.</p>
     *
     * @param firstName    the billing first name
     * @param lastName     the billing last name
     * @param companyName   the billing company name (optional)
     * @param countryName   the billing country name
     * @param address      the billing address
     * @param myPostcode   the billing postcode
     * @param cityName     the billing city
     * @param phoneNum     the billing phone number
     * @param emailAdress  the billing email address
     */
    public void fillBillingDetails(String firstName, String lastName, String companyName, String countryName,
                                   String address, String myPostcode, String cityName, String phoneNum,
                                   String emailAdress) {
        // Clear and enter the first name
        first_name.clear();
        first_name.sendKeys(firstName);
        // Clear and enter the last name
        last_name.clear();
        last_name.sendKeys(lastName);
        // Clear and enter the company name (optional)
        company_name.clear();
        company_name.sendKeys(companyName);
        // Click to select the country
        country_click.click();
        country_name.sendKeys(countryName);
        country_name.sendKeys(Keys.ENTER);  // Confirm selection
        // Clear and enter the address
        address_name.clear();
        address_name.sendKeys(address);
        // Clear and enter the postcode
        postcode.clear();
        postcode.sendKeys(myPostcode);
        // Clear and enter the city
        city.clear();
        city.sendKeys(cityName);
        // Clear and enter the phone number
        phone.clear();
        phone.sendKeys(phoneNum);
        // Clear and enter the email address
        email.clear();
        email.sendKeys(emailAdress);
    }

    /**
     * Clicks the button to place the order.
     */
    public void placeOrder() {
        btn_place_order.click();
    }

    /**
     * Checks if the error message element is displayed.
     *
     * @return true if the error message is displayed, false otherwise
     */
    public boolean isErrorDisplayed() {
        try {
            return txt_error.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Returns false if the element is not found
        }
    }
}
