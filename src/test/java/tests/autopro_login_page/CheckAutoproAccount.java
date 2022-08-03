package tests.autopro_login_page;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import tests.main.MainTest;

import static common.ConfigConstants.Urls.*;

public class CheckAutoproAccount extends MainTest {

    private String name = getRandomName.getRandomName();
    private String email = name + MAILINATOR_EMAIL_PART;
    private String password = getRandomPassword.getRandomPassword();

    @Test (description = "Registrition test on Mailinator page")
    public void SetRegistrationData() {

        /*make email in Mailinator*/
        mainPage.open(MAILINATOR_PAGE);
        mailinatorPage.mailinatorRegistration(name);
    }

    @Test(
            description = "Registrition test on AUTOPRO page",
            dependsOnMethods = "SetRegistrationData"
    )
    public void SetAutoproAccount() {

        /*login in Autopro*/
        mainPage.open(AUTOPRO_REGISTRATION);
        loginPage.enterEmailAutopro(email, password);
    }

    @Test(
            description = "Confirmation test on Mailinator page",
            dependsOnMethods = "SetAutoproAccount",
            retryAnalyzer = Retry.class
    )
    public void CheckEmailOnMailinator() throws InterruptedException {
        Thread.sleep(15000);

        /*check mali from Autopro*/
        mainPage.open(MAILINATOR_PAGE);
        mailinatorPage.mailinatorAutoproConfirm(name);
        // mainPage.close();
    }

    @AfterSuite(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {

        // Close browser
        Thread.sleep(3000);
        driver.quit();
    }
}
