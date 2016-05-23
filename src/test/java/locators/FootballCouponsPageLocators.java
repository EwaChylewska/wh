package locators;

import org.openqa.selenium.By;


public class FootballCouponsPageLocators{

    public By getCompetitionLocator (String competition) {
        return By.linkText(competition);
    }
}
