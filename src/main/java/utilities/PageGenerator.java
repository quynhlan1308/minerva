package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {

    private static WebDriver driver;

    public static void initializeDriver(WebDriver pDriver) {
        driver = pDriver;
    }

    // JAVA Generics to Create and return a New Page
    public static <TPage> TPage getInstance(Class<TPage> pageClass) {
//        try {
        // Initialize the Page with its elements and return it.
        return PageFactory.initElements(driver, pageClass);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//        }
    }

}
