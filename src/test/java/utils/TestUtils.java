package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestUtils {
    //WebDriver driver;
    //Wrappers wrapper;




    @AfterTest(alwaysRun = true)
    public void AfterTest(WebDriver driver){

        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void AfterSuite(){

        System.out.println("After Suite called");
    }
}
