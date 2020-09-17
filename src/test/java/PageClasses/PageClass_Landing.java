package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wrappers;

import java.time.LocalDate;
import java.util.List;


public class PageClass_Landing extends Wrappers {
    //WebDriver driver;

     @FindBy(xpath="//a[text()='Book Flight']") private WebElement lnk_bookFlight;
    private @FindBy(xpath="//a[text()='Check-in']") WebElement lnk_checkIn;
    private @FindBy(xpath="//a[text()='Flight Status]") WebElement lnk_flightStatus;
    private @FindBy(xpath = "//input[@class='form-control or-src-city']") WebElement input_source;
    private @FindBy(xpath="//input[@class='form-control or-dest-city']") WebElement input_destination;
    private @FindBy(xpath="//*[text()='Round Trip']") WebElement rdbtn_roundTrip;
    private @FindBy(className="hp-src-btn") WebElement btn_searchFlight;
    private @FindBy(xpath="//*[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']//td")   List<WebElement> from_dates;
    private @FindBy(xpath="//*[@class='ui-datepicker-row-break']//*[text()='Done']") WebElement btn_done;
    private @FindBy(xpath="//*[text()='Contact ']") WebElement lnk_contact;
    private @FindBy(xpath="//*[@class='btn btn-primary btn-acc-cookie']") WebElement btn_accept_cookies;

    //*[@class='ui-datepicker-row-break']//*[text()='Done']




    public PageClass_Landing(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public PageClass_Landing click_Book_a_flight(){

        click(lnk_bookFlight,driver);
        return this;
    }

    public PageClass_Landing click_accept_cookies(){

        click(btn_accept_cookies,driver);
        return this;
    }

    public PageClass_Landing click_date_picker_done(){

        click(btn_done,driver);
        return this;
    }

    public PageClass_ContactIndigo click_contact_indigo(){

        click(lnk_contact,driver);
        return new PageClass_ContactIndigo(driver);
    }

    public PageClass_Landing click_CheckIn(){

        click(lnk_checkIn,driver);
        return this;
    }

    public PageClass_Landing click_roundTrip_radioButton(){

        click(rdbtn_roundTrip,driver);
        return this;
    }

    public PageClass_Landing enter_from_city(String fromCity){
        enterKeyBoardKey(input_source,"backspace");
        enterText(input_source,driver,fromCity);
        enterKeyBoardKey(input_source,"enter");
        return this;
    }

    public PageClass_Landing enter_to_city(String toCity){
        enterKeyBoardKey(input_source,"backspace");
        enterText(input_destination,driver,toCity);
        enterKeyBoardKey(input_destination,"enter");
        return this;
    }

    public PageClass_Landing click_flightStatus(){
        click(lnk_flightStatus,driver);
        return this;
    }

    public PageClass_Booking click_searchFlight_button(){
        click(btn_searchFlight,driver);
        return new PageClass_Booking(driver);
    }

    public PageClass_Landing select_next_day(){


        System.out.println("Size is "+from_dates.size());
        LocalDate currentdate = LocalDate.now();


        int currentDay = currentdate.getDayOfMonth();
        System.out.println("Current day: "+currentdate);
        String abc = Integer.toString(currentdate.getDayOfMonth());
        //System.out.println("Current date: "+abc);
        for(WebElement date:from_dates){

            String dayOfMonth = getText(date,driver);
           System.out.println("dayOfMonth "+dayOfMonth);
            if(!(dayOfMonth.equals(""))){
                System.out.println("FOUND DATE");
               click(date,driver);
                System.out.println("Clicked");
               break;
            }

        }

        //click(btn_searchFlight,driver);
        return this;
    }



}
