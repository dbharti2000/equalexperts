package hotel.booking.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;


public class DriverFactory {

    static WebDriver driver = null;

    static WebDriver createInstance(String browserName) throws IOException {

        if (browserName.toLowerCase().contains("firefox")) {
            driver = getFireFoxDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome")) {
            driver = getChromeDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("local")) {
            driver = new FirefoxDriver();
            return driver;
        }
        return driver;
    }

    public static WebDriver getFireFoxDriver() {

        WebDriver firefoxDriver = new FirefoxDriver();
        // maximize window
        firefoxDriver.manage().window().maximize();
        return firefoxDriver;


    }

    public static WebDriver getChromeDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/testDrivers/chromedriver");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability("chrome.binary", "src/test/resources/testDrivers/chromedriver");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver chromeDriver = new ChromeDriver(capabilities);
        return chromeDriver;
    }

}

