package pages;

import org.openqa.selenium.WebDriver;
import locators.CouponsCompetitionPageLocators;

public class CouponsCompetitionPage extends BettingMainPage {

    private CouponsCompetitionPageLocators locators;

    public CouponsCompetitionPage(WebDriver driver) {
        super(driver);
        locators = new CouponsCompetitionPageLocators();
    }

    public FootballMatchPage selectMatchByName(String matchName) {
        clickElementWithStaleException(locators.getMatchLocator(matchName));
        return new FootballMatchPage(driver);
    }
}
