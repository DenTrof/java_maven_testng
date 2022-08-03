package pages.mailinator_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.main.MainPage;

import java.util.concurrent.TimeUnit;

public class MailinatorPage extends MainPage {
    public MailinatorPage(WebDriver driver) {
        super(driver);
    }

    private final By setMaileName = By.id("search");
    private final By goBtn = By.xpath("//button[@value='Search for public inbox for free' and text()='GO']");
    private final By pablicMassage = By.xpath("//h4[contains(@class,'fw-700')]");
    private final By autoproLastEmail = By.xpath("//tr[@class='ng-scope']");
    private final By emailConfirmButton = By.xpath("//a[@class='buttonClass']");
    private final By emailConfirmAlert = By.xpath("//div[@class='pro-alert']");

    public MailinatorPage mailinatorRegistration(String name) {
        driver.findElement(setMaileName).sendKeys(name);
        driver.findElement(goBtn).click();
        WebElement textEq = driver.findElement(pablicMassage);
        String textEqual = waitElementIsVisible(textEq).getText();
        try {
            Assert.assertEquals(textEqual, "Public Messages");
            System.out.println("Email adress in mailinator is ready");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return this;
    }

    public MailinatorPage mailinatorAutoproConfirm(String name) {
        this.mailinatorRegistration(name);
        driver.findElement(autoproLastEmail).click();
        driver.manage().timeouts().implicitlyWait(15000, TimeUnit.MILLISECONDS);
        WebElement emailConfirm = driver.findElement(emailConfirmButton);
        waitElementIsVisible(emailConfirm).click();

        WebElement textAlertConfirm = driver.findElement(emailConfirmAlert);
        String getTextConfirm = waitElementIsVisible(textAlertConfirm).getText();

        try {
            Assert.assertFalse(getTextConfirm.isEmpty());
            System.out.println("The confirmation text is find");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return this;
    }
}
