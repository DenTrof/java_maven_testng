package pages.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.main.MainPage;

import java.util.concurrent.TimeUnit;

public class LoginPage extends MainPage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }
    private final By inputCheckbox = By.xpath("//label[@class='auth__form__check']");
    private final By inputEmail = By.xpath("//input[@name='Login']");
    private final By inputPassword = By.xpath("//input[@name='Password']");
    private final By registrationBtn = By.xpath("//button[@type='submit']");
    private final By registrationSuccess = By.xpath("//div[@class='user-summary__head__info__name']");

    public LoginPage enterEmailAutopro(String email, String password) {
        // System.out.println(email);
        // System.out.println(password);
        driver.findElement(inputCheckbox).click();
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);

        WebElement buttonSend = driver.findElement(registrationBtn);
        waitElementIsVisible(buttonSend).click();

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(registrationBtn).click();

        WebElement textElement = driver.findElement(registrationSuccess);
        String successText = waitElementIsVisible(textElement).getText();

        try {
            Assert.assertFalse(successText.isEmpty());
            System.out.println("You have registrated on Auto.pro");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            System.out.println("Registration failed");
            throw e;
        }

        return this;
    }
}
