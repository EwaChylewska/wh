package locators;

import org.openqa.selenium.By;


public class FootballMatchPageLocators{

    public By oddsButton = By.xpath("//button[contains(@class,'active') and contains(@class,'oddsbutton')]");

    public By getCountryLocator(String country) {
        return By.xpath("//button[@data-player='" + country + "']");
    }
}
