package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Wrappers;

public class PageClass_Booking extends Wrappers {

    //WebDriver driver;
    @FindBy(className="from") WebElement text_from;
    @FindBy(className="to") WebElement text_to;
    @FindBy(id="continue-button") WebElement button_continue;

    public PageClass_Booking(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void validteBookingTitle(String title,WebDriver driver){

        validateBrowserTitle(driver,title);
    }

    public PageClass_Booking validate_from_text(String expected){


            Assert.assertTrue(getText(text_from,driver).contains(expected),"Validating from Text. Found "+getText(text_from,driver));
            return this;

    }

    public PageClass_Booking validate_to_text(String expected){


        Assert.assertTrue(getText(text_to,driver).contains(expected),"Validating to text. Found"+getText(text_to,driver));

        return this;

    }



}
