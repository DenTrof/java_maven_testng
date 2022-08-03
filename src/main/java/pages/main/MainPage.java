package pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import static common.ConfigConstants.CLOSE_BROWSER;
import static common.ConfigConstants.TimeOutVariable.WAIT_ELEMENT_TIME;

public class MainPage {
    protected static WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        if (CLOSE_BROWSER) {
            driver.quit();
        };
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_ELEMENT_TIME).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}