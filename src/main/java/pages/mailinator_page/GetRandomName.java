package pages.mailinator_page;

import java.util.Random;

public class GetRandomName {

    public static String getRandomName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder bufferName = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            bufferName.append((char) randomLimitedInt);
        }
        String userName= bufferName.toString();
        return userName;
    }
}
