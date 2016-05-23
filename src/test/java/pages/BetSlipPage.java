package pages;

import org.openqa.selenium.WebDriver;
import locators.BetSlipPageLocators;


public class BetSlipPage extends BettingMainPage {

    private BetSlipPageLocators locators;

    public BetSlipPage(WebDriver driver) {
        super(driver);
        locators = new BetSlipPageLocators();
    }

    public BetSlipPage typeStake(String stake){
        typeText(locators.inputStake, stake);
        return this;
    }

    public BetSlipPage clickPlaceBetButton(){
        clickElement(locators.placeBetButton);
        return this;
    }

    public String getOdds(){
        return getElementsText(locators.betOdds);
    }

    public String getEstimatedReturns(){
        return getElementsText(locators.estimatedReturns);
    }
}
