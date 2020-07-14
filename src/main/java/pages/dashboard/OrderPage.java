package pages.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.ElementAction;
import utilities.PageGenerator;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Category 3')]")
    private WebElement menuitem3;

    @FindBy(xpath = "//a[contains(text(),'Category 2')]")
    private WebElement menuitem2;

    @FindBy(xpath = "//a[contains(text(),'Category 1')]")
    private WebElement menuitem1;

    @FindBy(xpath = "//div[contains(@class,'caption')]//a[contains(text(),'Product 9')]")
    private WebElement productName;
//
    @FindBy(xpath = "//a[contains(@class,'btn btn-success')]")
    private WebElement buttonOrder;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "full_name")
    private WebElement fullNameInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "address")
    private WebElement addressInput;

   @FindBy(id = "note")
    private WebElement noteInput;

   ////button[contains(@class,'btn btn-success')]
   @FindBy(xpath = "//button[contains(@class,'btn btn-success')]")
   private WebElement buttonSubmit;

   public  OrderPage clickOnCategory3(){
        ElementAction.click(menuitem3,"Menu Category3");
        return this;
   }

    public  OrderPage clickOnCategory2(){
        ElementAction.click(menuitem2,"Menu Category 2");
        return this;
    }

    public  OrderPage clickOnCategory1(){
        ElementAction.click(menuitem1,"Menu Category 1");
        return this;
    }

    public  OrderPage clickOnAProduct(){
        ElementAction.click(productName,"Product of Menu Category 3");
        return this;
    }

    public  OrderPage clickOrderButton(){
        ElementAction.click(buttonOrder,"Order button");
        return this;
    }

    public  OrderPage typeEmail(String email){
        ElementAction.type(emailInput,"Email",email);
        return this;
    }

    public  OrderPage typeFullName(String fullName){
        ElementAction.type(fullNameInput,"Full Name",fullName);
        return this;
    }
    public  OrderPage typePhone(String phone){
        ElementAction.type(phoneInput,"Phone",phone);
        return this;
    }

    public  OrderPage typeAddress(String address){
        ElementAction.type(addressInput,"Address",address);
        return this;
    }


    public  OrderPage typeNote(String note){
        ElementAction.type(noteInput,"Note",note);
        return this;
    }
    public  OrderInfoPage clickOnSubmitButton(){
        ElementAction.click(buttonSubmit,"Submit Button");
        return PageGenerator.getInstance(OrderInfoPage.class);
    }

    public  String getEmailErrorMessage() {
       String msg=emailInput.getAttribute("validationMessage");
       return msg;
    }
    public  String getAddressErrorMessage() {
        String msg=addressInput.getAttribute("validationMessage");
        return msg;
    }
    public  String getFullNameErrorMessage() {
        String msg=fullNameInput.getAttribute("validationMessage");
        return msg;
    }
}
