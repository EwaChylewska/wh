package locators;

import org.openqa.selenium.By;


public class BetSlipPageLocators {

    public By inputStake = By.xpath("//input[contains(@class,'stake-input')]");
    public By betOdds = By.xpath("//span[contains(@id,'bet-price')]");
    public By estimatedReturns = By.xpath("//span[@class='estimated-returns']");
    public By placeBetButton = By.id("place-bet-button");
}
