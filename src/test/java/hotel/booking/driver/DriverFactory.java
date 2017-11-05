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
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDrivers/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDrivers/chromedriver.exe");
        }

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver chromeDriver = new ChromeDriver(capabilities);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}


