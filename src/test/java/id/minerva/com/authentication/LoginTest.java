package id.minerva.com.authentication;

import id.minerva.com.BaseTest;
import pages.authentication.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.CommonUtil;
import utilities.PageGenerator;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        loginPage = PageGenerator.getInstance(LoginPage.class);
    }

}
