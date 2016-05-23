package util;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;


public class DriverFactory {

    private static WebDriver driver;


    public DriverFactory() {
        initialize();
    }

    /**
     * Creates new driver instance if there is none yet. The driver is created either for desktop chrome or
     * mobile emulation, based on property browser in config.properties file.
     */
    private void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() {
        String browser = new PropertyReader().readProperty("browser");
        switch (browser) {
            case "chrome":
                createNewDriverInstanceChrome();
                break;
            case "mobile":
                createNewDriverInstanceEmulator();
                break;
            default:
                System.out.println("can't read browser type");
                break;
        }
    }

    /**
     * Creates driver instance for desktop chrome. The browser is then maximized.
     */
    private void createNewDriverInstanceChrome(){
        System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    /**
     * Creates driver instance for mobile emulation. Only device metrics are set, because adding userAgent causes problems
     * with non standard number keyboard that appears when typing bet stake. Input field is set then to read-only, and the keyboard
     * does not react to click action. Probably touch action should be performed. If I were to automate it in "real life"
     * I'll go talk to developers and ask them for event listeners that they are using.
     *
     * When only device metrics are set, the keyboard does not appear at all - the emulation is not treated as mobile device.
     */
    private void createNewDriverInstanceEmulator(){
        System.setProperty("webdriver.chrome.driver", "src//test//resources//driver//chromedriver.exe");

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<>();

        mobileEmulation.put("deviceMetrics", deviceMetrics);
        //mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 5.0; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        Map<String, Object> chromeOptions = new HashMap<>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver(capabilities);
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Destroys the driver and closes the browser.
     */
    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}
