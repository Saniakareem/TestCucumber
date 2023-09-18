package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.ProductPage;
import pageobject.login_page;

import java.time.Duration;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;
    By EMAIL_FIELD = By.id("user-name");
    By PASSWORD_FIELD = By.id("password");

    @Given("the user is on the login page")
    public void givenUserIsOnLoginPage() {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters valid credentials")
    public void whenUserEntersValidCredentials(String username ,String password) {


        login_page login = new login_page(driver);
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void thenUserShouldBeLoggedInSuccessfully() {
        WebElement productTitle = driver.findElement(By.className("product_label"));
        assertTrue(productTitle.isDisplayed());
    }

    @When("the user enters invalid credentials")
    public void whenUserEntersInvalidCredentials(String username,String password) {
        login_page login = new login_page(driver);
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLoginButton();
    }

    @Then("the user should see an error message")
    public void thenUserShouldSeeErrorMessage() {
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test='error']"));
        assertTrue(errorElement.isDisplayed());
    }


    @Given("the user is logged in")
    public void givenUserIsLoggedIn() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        login_page login = new login_page(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLoginButton();
    }

    @When("the user clicks the logout button")
    public void whenUserClicksLogoutButton() {
        ProductPage productPage = new ProductPage(driver);
        productPage.logout();
    }

    @Then("the user should be logged out")
    public void thenUserShouldBeLoggedOut() {
        WebElement errorElement = driver.findElement(By.cssSelector("#root > div > div.login_logo"));
        assertTrue(errorElement.isDisplayed());
    }



}
