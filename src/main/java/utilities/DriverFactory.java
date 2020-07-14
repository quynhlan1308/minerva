package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;

public class DriverFactory {

    public static WebDriver getDriverInstance(String browserName) {
        WebDriver driver;
        switch (browserName) {
            case FrameworkConst.BROWSER_FIREFOX:
                WebDriverManager.getInstance(FIREFOX).setup();
                driver = new FirefoxDriver();
                break;

            case FrameworkConst.BROWSER_IE:
                WebDriverManager.getInstance(IEXPLORER).setup();
                driver = new InternetExplorerDriver();
                break;

            default:
                WebDriverManager.getInstance(CHROME).setup();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//                DesiredCapabilities caps = DesiredCapabilities.chrome();
//                caps.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(options);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FrameworkConst.TIMEOUT_FINDING_ELEMENTS_IN_SECONDS, TimeUnit.SECONDS);
        return driver;
    }

}
