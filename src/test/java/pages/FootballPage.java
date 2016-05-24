package pages;

import org.openqa.selenium.WebDriver;
import locators.FootballPageLocators;

public class FootballPage extends BettingMainPage {

    private FootballPageLocators locators;

    FootballPage(WebDriver driver){
        super(driver);
        locators  = new FootballPageLocators();
    }

    public FootballCouponsPage goToFootballCouponsPage() {
        clickElement(locators.couponsNav);
        return new FootballCouponsPage(driver);
    }
}
