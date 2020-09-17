package TestCases;

import PageClasses.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Wrappers;


public class SampleTests extends Wrappers{

       Wrappers wrapper;
        //WebDriver driver;



    @BeforeMethod
    @Parameters({"browser","URL"})
    public void beforeMethod(String browser,String URL){
        wrapper = new Wrappers();
        driver=wrapper.initiateDriver(browser,URL);
    }


        @Test(enabled=true,dataProvider = "inputData")
        public void bookTicket(String source,String destination){

            wrapper.validateBrowserTitle(driver,"Book Domestic & International Flights at Lowest Airfare - IndiGo");
            PageClass_Landing landing = new PageClass_Landing(driver);
                landing.click_Book_a_flight()
                        .click_accept_cookies()
                    .click_roundTrip_radioButton()
                    .enter_from_city(source)
                    .enter_to_city(destination)
                    .click_date_picker_done()
                    .click_date_picker_done()
                    .click_searchFlight_button()
                    .validate_from_text(source)
                    .validate_to_text(destination);



        }

    @Test(enabled=true)
    public void contact_Indigo(){
        System.out.println("in test");
        wrapper.validateBrowserTitle(driver,"Book Domestic & International Flights at Lowest Airfare - IndiGo");
        PageClass_Landing landing = new PageClass_Landing(driver);
        landing.click_contact_indigo()
         .validate_contact_Indigo_Heading()
        .validate_contact_Indigo_title();


    }

    @AfterMethod(alwaysRun = true)
    public void AfterMethod(){

        driver.close();
    }


    @DataProvider(name="inputData")
    public Object[][] data(){
        Object[][] data = new Object[2][2];

        data[0][0] ="BLR";
        data[0][1] = "DEL";


        data[1][0] ="CCU";
        data[1][1] = "BOM";


        return data;
    }

    }

