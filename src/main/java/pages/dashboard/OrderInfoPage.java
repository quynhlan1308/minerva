package pages.dashboard;

import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utilities.ElementAction;

public class OrderInfoPage  extends BasePage {
    //*[contains(@ref,'email')]
    @FindBy(xpath = "//*[contains(@ref,'email')]")
    private WebElement emaiConfirm;
    //full_name
    @FindBy(xpath = "//*[contains(@ref,'full_name')]")
    private WebElement full_nameConfirm;
    @FindBy(xpath = "//*[contains(@ref,'phone')]")
    private WebElement phoneConfirm;
    //address
    @FindBy(xpath = "//*[contains(@ref,'address')]")
    private WebElement addressConfirm;
    @FindBy(xpath = "//*[contains(@ref,'note')]")
    private WebElement noteConfirm;
    public String getEmail(){
        return emaiConfirm.getText();
    }
    public  String getPhone(){
        return phoneConfirm.getText();
    }

    public  String getAddress(){
        return addressConfirm.getText();
    }
    public  String getNote(){
        return  noteConfirm.getText();
    }
    public  String getFullName(){
        return full_nameConfirm.getText();
    }
}
