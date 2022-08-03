package pages.mailinator_page;

import org.openqa.selenium.By;

public class GetRandomEmail {

    private final By countRooms = By.xpath("//a[@href='https://passport.i.ua/']");

    public String getRandomEmail() {
        double prefix = (Math.random()*10000);
        int prefixInt = (int) prefix;
        String emailPrefix = String.valueOf(prefixInt);
        return emailPrefix;
    }
}
