package pages;

import org.openqa.selenium.WebDriver;
import locators.FootballMatchPageLocators;

public class FootballMatchPage extends BettingMainPage {

    private FootballMatchPageLocators locators;

    public FootballMatchPage(WebDriver driver) {
        super(driver);
        locators = new FootballMatchPageLocators();
    }

    public FootballMatchPage selectWinner(String country){
        clickElement(locators.getCountryLocator(country));
        return this;
    }

    /**
     * Reads odds from selected button. The text is read by getElementAttribute instead of getElementText,
     * because the element is not visible in mobile emulation and getElementAttribute works both on visible and
     * invisible elements, if they are attached to DOM.
     * @return selected odds value
     */
    public String getSelectedOddsText(){
        return getElementsAttribute(locators.oddsButton, "data-odds");
    }
}
