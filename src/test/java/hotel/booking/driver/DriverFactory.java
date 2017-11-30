package hotel.booking.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;


public class DriverFactory {

    static WebDriver driver = null;

    static WebDriver createInstance(String browserName) throws IOException {

        switch (browserName) {
            case "firefox":
                driver = getFireFoxDriver();
                break;
            case "chrome":
                driver = getChromeDriver();
                break;
            default:
                driver = getChromeDriver();
                break;
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

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        ChromeDriverManager.getInstance().setup();
        WebDriver chromeDriver = new ChromeDriver(capabilities);
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}


