package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.BetSlipPage;
import pages.CouponsCompetitionPage;
import pages.FootballMatchPage;
import pages.BettingMainPage;
import util.BetCounter;
import util.DriverFactory;
import org.openqa.selenium.WebDriver;


public class BettingSteps {

    private WebDriver driver;

    /**
     * Initializes the driver for before the scenario starts
     */
    @Before
    public void beforeScenario() {
        driver = new DriverFactory().getDriver();
    }

    /**
     * Destroys the driver after scenario is finished, no matter if it passed or failed
     */
    @After
    public void afterScenario() {
        new DriverFactory().destroyDriver();
    }


    @Given("^I am on (.+) page$")
    public void iAmOnPage(String page) throws Throwable {
        driver.get(page);
    }

    @When("^I navigate to (.+) football event$")
    public void iNavigateToEuroInternationalFootballEvent(String competition) throws Throwable {
        BettingMainPage page = new BettingMainPage(driver);

        page.goToFootballPage()
            .goToFootballCouponsPage()
            .goToCompetitionPage(competition);
    }


    @When("^I select match (.+)$")
    public void iSelectMatch(String matchName) throws Throwable {
        CouponsCompetitionPage page = new CouponsCompetitionPage(driver);
        page.selectMatchByName(matchName);
    }

    @When("^I place a (.+) bet on (.+) to win$")
    public void iPlaceABetOnCountryToWin(String bet, String country) throws Throwable {
        FootballMatchPage page = new FootballMatchPage(driver);
        page.selectWinner(country)
                .goToBetslipPage()
                .typeStake(bet)
                .clickPlaceBetButton();
    }

    @Then("^odds in bet are the same as selected$")
    public void oddsInBetAreTheSameAsSelected() throws Throwable {
        String selectedOdds = new FootballMatchPage(driver).getSelectedOddsText();
        String betOdds = new BetSlipPage(driver).getOdds();
        Assert.assertEquals(selectedOdds, betOdds);
    }


    @Then("^estimated returns equal (.+) times odds plus stake$")
    public void estimatedReturnsEqualTimesOdds(String bet) throws Throwable {
        BetSlipPage page = new BetSlipPage(driver);
        String expectedReturns = new BetCounter().countReturns(bet, page.getOdds());
        String actualReturns = page.getEstimatedReturns();
        Assert.assertEquals(actualReturns, expectedReturns);
    }
}
