package id.minerva.com;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utilities.*;

public class BaseTest {

    private WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected DataReader dataReader = new DataReader(Const.DATA_FILE);
    protected JSONObject testData;

    @Parameters("browser")
    @BeforeTest
    public void initializeTest(String browserName) {
        driver = DriverFactory.getDriverInstance(browserName);
        driver.get(Const.SITE_URL);
        PageGenerator.initializeDriver(driver);
        ElementFinder.initializeDriver(driver);
        LogUtils.info("Go to Heroku site home page");
    }

    @AfterTest
    public void cleanUpTest() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeEachMethod() {
        softAssert = new SoftAssert();
    }
    public WebDriver getDriver(){
        return driver;
    }

}


