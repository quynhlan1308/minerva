package pages.authentication;

import pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ElementAction;
import utilities.LogUtils;
import utilities.PageGenerator;

public class LoginPage extends BasePage {

    public LoginPage() {
        LogUtils.info("You are now on Log In page");
    }

    /*
     * ELEMENTS
     */
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@name='commit']")
    private WebElement loginButton;
    @FindBy(className = "alert-danger")
    private WebElement validationMessage;
    @FindBy(xpath = "//span[text()='Sign Up']")
    private WebElement btnSignUp;

    //a[contains(text(),'Forgot your password')]
    @FindBy(xpath="//a[contains(text(),'Forgot your password')]")
    private WebElement forgotPasswordLink;

    /*
     * PUBLIC ACTIONS
     */
    public LoginPage typeEmail(String email) {
        ElementAction.type(emailInput, "Email", email);
        return this;
    }

    public LoginPage typePassword(String password) {
        ElementAction.type(passwordInput, "Password", password);
        return this;
    }



    /*
     * PUBLIC EXPECTATIONS
     */
    public String seeValidationMessage(String msg) {
        String actualMessage = validationMessage.getText();
        boolean result = actualMessage.equals(msg);
        String log = String.format("   [Expectation] See error message '%s': %b", msg, result);
        if (result) {
            LogUtils.info(log);
        } else {
            LogUtils.warn(log + String.format(" (actual: '%s')", actualMessage));
        }
        return actualMessage;
    }

}
