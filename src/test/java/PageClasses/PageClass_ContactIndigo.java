package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Wrappers;

public class PageClass_ContactIndigo extends Wrappers {
    //WebDriver driver;
    private @FindBy(xpath="//h1[text()='Contact us']") WebElement txt_contactUs_heading;
    private @FindBy(xpath="//h3[text()='Registered Office ']") WebElement txt_registeredOffice_heading;
    private @FindBy(xpath="//h3[text()='Corporate Office']") WebElement txt_corporateOffice_heading;
    private @FindBy(xpath="//h2[text()='Customer Support']") WebElement txt_customerSupport_heading;
    @FindBy(xpath="//*[text()='Save']") WebElement button_Save;
    @FindBy(xpath="//*[@name='Pop']") WebElement text_PopUp;
    @FindBy(xpath="//*[@name='Booking']") WebElement text_BookingNo;



    public PageClass_ContactIndigo(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public PageClass_ContactIndigo validate_contact_Indigo_title(){
        validateBrowserTitle(driver,"Contact Us, Low Cost Airline | IndiGo");
        return this;

    }

    public PageClass_ContactIndigo validate_contact_Indigo_Heading(){
        Assert.assertTrue(txt_contactUs_heading.isDisplayed(),"Validating heading of contact Indigo");
        Assert.assertTrue(txt_registeredOffice_heading.isDisplayed(),"Validating Registered Office heading");
        Assert.assertTrue(txt_corporateOffice_heading.isDisplayed(),"Validating corporate office heading");
        Assert.assertTrue(txt_customerSupport_heading.isDisplayed(),"Validating customer support heading");
        return this;
    }




}
