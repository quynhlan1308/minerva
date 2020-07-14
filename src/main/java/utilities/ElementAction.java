package utilities;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;

public class ElementAction {

    public static void click(WebElement ele, String eleName) {
        if (ele != null) {
            ele.click();
            LogUtils.info(String.format("Click %s", eleName));
        }
    }

    public static void type(WebElement ele, String eleName, String value) {
        if (ele != null) {
            ele.clear();
            ele.sendKeys(value);
            LogUtils.info(String.format("Type '%s' into '%s' input", eleName, value));
        }
    }
    public static String getText(WebElement ele) {
        if (ele != null) {
            LogUtils.info(ele.getText());
            return ele.getText();
         }
        return  null;
    }

}
