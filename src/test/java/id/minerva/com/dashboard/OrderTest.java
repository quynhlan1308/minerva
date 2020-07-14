package id.minerva.com.dashboard;

import id.minerva.com.BaseTest;
import id.minerva.com.Const;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.authentication.LoginPage;
import pages.dashboard.OrderInfoPage;
import pages.dashboard.OrderPage;

import utilities.DataReader;

import utilities.PageGenerator;

public class OrderTest extends BaseTest {
    private LoginPage loginPage;
    private OrderPage orderPage;
    private OrderInfoPage orderInfoPage;
    protected SoftAssert softAssert =new SoftAssert();
    @BeforeTest
    public void beforeClass(){
        loginPage = PageGenerator.getInstance(LoginPage.class);
        orderPage = PageGenerator.getInstance(OrderPage.class);
        orderInfoPage=PageGenerator.getInstance(OrderInfoPage.class);
        dataReader=new DataReader("data/orderinfo.json");
    }
 //  @Test(description = "Order a Product",enabled = true)
  @Test(groups={"check-Order"}, priority =0)
    public  void  order(){
        testData = dataReader.get("tc01");
        String EMAIL = (String) testData.get("email");
        String FULL_NAME = (String) testData.get("fullname");
        String PHONE = (String) testData.get("phone");
        String ADDRESS = (String) testData.get("adress");
        String NOTE = (String) testData.get("note");
        orderPage.clickOnCategory3().clickOnAProduct().clickOrderButton();
        orderPage.typeEmail(EMAIL).typeFullName(FULL_NAME).typePhone(PHONE).typeAddress(ADDRESS).typeNote(NOTE);
        orderInfoPage=orderPage.clickOnSubmitButton();
        softAssert.assertEquals(orderInfoPage.getEmail(), EMAIL,"EMAIL should be:"+EMAIL);
        softAssert.assertEquals(orderInfoPage.getAddress(),ADDRESS,"ADDRESS should be :"+ ADDRESS);
        softAssert.assertEquals(orderInfoPage.getFullName(),FULL_NAME,"FULL_NAME should be :"+ FULL_NAME);
        softAssert.assertEquals(orderInfoPage.getNote(),NOTE,"NOTE should be :"+ NOTE);
        softAssert.assertEquals(orderInfoPage.getPhone(),PHONE,"PHONE should be :"+ PHONE);
        softAssert.assertAll();
    }

    //@Test(description = "Order a Product 2 with incorrect format Email",enabled = true)
    @Test(groups={"check-Order"},description = "Order a Product 2" ,priority =1)
    public  void  order2(){
        getDriver().navigate().to(Const.SITE_URL);
        testData = dataReader.get("tc02");
        String EMAIL = (String) testData.get("email");
        String ERROR_MESSAGE=(String)  testData.get("errorMessage");
        orderPage.clickOnCategory3().clickOnAProduct().clickOrderButton();
        orderPage.typeEmail(EMAIL);
        orderPage.clickOnSubmitButton();
        softAssert =new SoftAssert();
        softAssert.assertEquals(orderPage.getEmailErrorMessage(), ERROR_MESSAGE,"Toot tip should be:"+ERROR_MESSAGE);
       softAssert.assertAll();
    }
  //  @Test(description = "Order a Product 2",enabled = true)
  @Test(groups={"check-Order"},description = "Order a Product 3", priority =2)
    public  void  order3(){
        //getDriver().navigate().to(Const.SITE_URL);
        testData = dataReader.get("tc03");
        String EMAIL = (String) testData.get("email");
        String ERROR_MESSAGE=(String)  testData.get("errorMessage");
       // orderPage.clickOnCategory3().clickOnAProduct().clickOrderButton();
        orderPage.typeEmail(EMAIL);
        orderPage.clickOnSubmitButton();
        softAssert =new SoftAssert();
        softAssert.assertEquals(orderPage.getEmailErrorMessage(), ERROR_MESSAGE,"Toot tip should be:"+ERROR_MESSAGE);
        softAssert.assertAll();
    }
    @Test(groups={"check-Order"},description = "Order a Product 4 with empty fullname  ", priority =3)
    public  void  order4(){
        //getDriver().navigate().to(Const.SITE_URL);
        testData = dataReader.get("tc04");
        String EMAIL = (String) testData.get("email");
        String ERROR_MESSAGE=(String)  testData.get("errorMessage");
        String FULL_NAME = (String) testData.get("fullname");
        orderPage.typeEmail(EMAIL).typeFullName(FULL_NAME);
        orderPage.clickOnSubmitButton();
        softAssert =new SoftAssert();
        softAssert.assertEquals(orderPage.getFullNameErrorMessage(), ERROR_MESSAGE,"Toot tip should be:"+ERROR_MESSAGE);
        softAssert.assertAll();
    }
    @Test(groups={"check-Order"},description = "Order a Product 5 with empty address  ", priority =4)
    public  void  order5(){
        //getDriver().navigate().to(Const.SITE_URL);
        testData = dataReader.get("tc05");
        String EMAIL = (String) testData.get("email");
        String ERROR_MESSAGE=(String)  testData.get("errorMessage");
        String FULL_NAME = (String) testData.get("fullname");
        String ADDRESS = (String) testData.get("adress");
        orderPage.typeEmail(EMAIL).typeFullName(FULL_NAME).typeAddress(ADDRESS);
        orderPage.clickOnSubmitButton();
        softAssert =new SoftAssert();
        softAssert.assertEquals(orderPage.getAddressErrorMessage(), ERROR_MESSAGE,"Toot tip should be:"+ERROR_MESSAGE);
        softAssert.assertAll();
    }
}
