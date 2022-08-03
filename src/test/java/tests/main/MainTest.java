package tests.main;

import common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import pages.login_page.LoginPage;
import pages.mailinator_page.GetRandomEmail;
import pages.mailinator_page.GetRandomName;
import pages.mailinator_page.GetRandomPassword;
import pages.mailinator_page.MailinatorPage;
import pages.main.MainPage;

import static common.ConfigConstants.CLEAR_BROWSER;

public class MainTest {

    protected WebDriver driver = CommonAction.createDriver();

    protected MainPage mainPage = new MainPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected GetRandomEmail getRandomEmail = new GetRandomEmail();
    protected GetRandomPassword getRandomPassword = new GetRandomPassword();
    protected GetRandomName getRandomName = new GetRandomName();
    protected MailinatorPage mailinatorPage = new MailinatorPage(driver);

    @AfterTest
    public void clearCookiAndLocalStorage() {
        if(CLEAR_BROWSER) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
}
