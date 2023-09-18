package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {

    @FindBy(id="user-name")
    @CacheLookup
    WebElement txt_username;

    @FindBy(id="password")
    @CacheLookup
    WebElement txt_password;

    @FindBy(id="login-button")
    WebElement btn_login;
    WebDriver driver;
    //Constructor to get driver instance and initialize Elements using method initElements
    public login_page(WebDriver driver1){
        this.driver= driver1;
        PageFactory.initElements(driver,  this);

    }
     public void enterUsername(String username){
         txt_username.sendKeys(username);
     }
    public void enterPassword(String password){
        txt_password.sendKeys(password);
    }

    public void clickLoginButton(){

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        driver.close();
    }
}
