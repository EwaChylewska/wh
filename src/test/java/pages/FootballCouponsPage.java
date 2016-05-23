package pages;

import org.openqa.selenium.WebDriver;
import locators.FootballCouponsPageLocators;


public class FootballCouponsPage extends BettingMainPage {

    private FootballCouponsPageLocators locators;


    FootballCouponsPage(WebDriver driver) {
        super(driver);
        locators = new FootballCouponsPageLocators();
    }

    public CouponsCompetitionPage goToCompetitionPage(String competition){
        clickElement(locators.getCompetitionLocator(competition));
        return new CouponsCompetitionPage(driver);
    }
}
