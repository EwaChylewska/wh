package locators;

import org.openqa.selenium.By;


public class CouponsCompetitionPageLocators{

    public By getMatchLocator(String matchName) {
        return By.xpath("//a[@title='" + matchName + "']");
    }
}
