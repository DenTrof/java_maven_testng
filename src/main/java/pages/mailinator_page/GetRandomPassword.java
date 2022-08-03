package pages.mailinator_page;

public class GetRandomPassword {

    public static String getRandomPassword() {
        String randomId = GetRandomName.getRandomName();
        String randomPassword = "123D" + randomId + "4";
        return randomPassword;
    }
}
