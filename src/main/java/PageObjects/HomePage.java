package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * The HomePage class represents the home page of the application.
 * It provides methods to interact with elements on the home page, particularly the navigation menu.
 *
 * <p>This class extends the DriverBase class, inheriting the WebDriver instance required for interactions.</p>
 *
 * <p>Usage:</p>
 * <pre>
 *     WebDriver driver = new FirefoxDriver();
 *     HomePage homePage = new HomePage(driver);
 *     homePage.selectMenuOption("OptionName");
 * </pre>
 */
public class HomePage extends DriverBase {

    /**
     * A list of menu items located in the navigation bar.
     */
    @FindBy(xpath = "//ul[@id='ast-hf-menu-1']/li")
    private List<WebElement> lst_menu;

    /**
     * Constructs a HomePage object and initializes the WebDriver instance.
     *
     * @param driver the WebDriver instance used to interact with the web browser
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects a menu option by clicking on the corresponding menu item.
     *
     * @param menuOption the text of the menu option to select
     */
    public void selectMenuOption(String menuOption) {
        WebElement menuItem = driver.findElement(By.xpath("//a[@class='menu-link' and text()='" + menuOption + "']"));
        menuItem.click();
    }
}
