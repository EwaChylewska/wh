package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyReader;

import java.util.List;


public abstract class PageActions {

    protected final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Page Actions constructor. Uses the driver created fo given scenario and creates WebDriverWait (FluentWait)  with timeout
     * read from config.properties file
     *
     * @param driver driver
     */
    public PageActions(WebDriver driver) {
        this.driver = driver;
        String timeout = new PropertyReader().readProperty("timeout");
        this.wait = new WebDriverWait(driver, Integer.parseInt(timeout));
    }


    /**
     * Clicks element with given locator. I used ExpectedConditions.elementToBeClickable predicate before, but I noticed that elements
     * on the WH page tends to be clickable before they are visible (tested around 10pm, when the page was loading really slow), so I
     * changed to ExpectedConditions.visibilityOfElementLocated.
     *
     * @param by locator
     */
    protected void clickElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    /**
     * Types text to the element with given locator
     *
     * @param by   locator
     * @param text text to be typed
     */
    protected void typeText(By by, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
    }


    /**
     * Not very nice workaround for clicking elements which are prone to StaleElementReferenceException. I know that
     * Thread.sleep should not be used and the method works correctly in most cases without it. However, in the evening,
     * when the website is under heavy load, the method stops working if there is no sleep.
     * <p>
     * The method is not bulletproof - around 10pm, when the traffic on the site is really big fluent waits and sleep are
     * still not enough. I believe that it will not be the issue in 'real life testing' as there will be stable
     * dedicated environment for automated tests.
     *
     * @param by locator
     */
    protected void clickElementWithStaleException(By by) {
        try {
            Thread.sleep(500);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
            } catch (StaleElementReferenceException ex) {
                Thread.sleep(500);
                wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads text from the element. Note: the element has to be visible.
     *
     * @param by locator
     * @return text
     */
    protected String getElementsText(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }


    /**
     * Reads attribute value from the element. Note: the element does not have to be visible.
     *
     * @param by        locator
     * @param attribute attribute name
     * @return attribute value
     */
    protected String getElementsAttribute(By by, String attribute) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getAttribute(attribute);
    }

    /**
     * Searches for the visible element with given locator and clicks it.
     * <p>
     * Another nasty workaround, so the tests work correctly both on desktop nad mobile emulation. Should be used if there
     * are two (or more) elements with the same locator, but one of them is visible on mobile and the other on desktop.
     *
     * @param by locator
     */
    protected void clickDisplayedElementFromElementList(By by) {
        List<WebElement> elements = driver.findElements(by);
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                element.click();
                break;
            }
        }
    }


}
