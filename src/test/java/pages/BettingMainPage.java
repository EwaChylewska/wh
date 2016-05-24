package pages;

import org.openqa.selenium.WebDriver;
import locators.BettingMainPageLocators;
import actions.PageActions;


public class BettingMainPage extends PageActions {

    private BettingMainPageLocators locators;

    public BettingMainPage(WebDriver driver) {
        super(driver);
        locators = new BettingMainPageLocators();
    }

    public FootballPage goToFootballPage() {
        clickElement(locators.footballNav);
        return new FootballPage(driver);
    }

    public BetSlipPage goToBetslipPage(){
        clickDisplayedElementFromElementList(locators.betSlipNav);
        return new BetSlipPage(driver);
    }

}
