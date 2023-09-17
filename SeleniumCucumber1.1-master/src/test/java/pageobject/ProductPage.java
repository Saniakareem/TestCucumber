package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private By productItems = By.cssSelector(".inventory_item");
    private By logoutButton = By.id("logout_sidebar_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProductItems() {
        return driver.findElements(productItems);
    }

    public void logout() {
        WebElement logoutLink = driver.findElement(logoutButton);
        logoutLink.click();
    }
}
