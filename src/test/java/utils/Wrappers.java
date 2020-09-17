package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class Wrappers extends TestUtils {

    public WebDriver driver;

    public WebDriver initiateDriver(String browser,String URL){
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".//chromedriver");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "path to ie driver");
            driver = new InternetExplorerDriver();
        }else if(browser.equalsIgnoreCase("FireFox")){
            System.setProperty("webdriver.firefox.driver", "path to firefox driver");
            driver = new FirefoxDriver();
        }
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void validateBrowserTitle(WebDriver driver,String expectedTitle) {
        try {
            String title= driver.getTitle().trim();
            System.out.println("title is"+title);
            Assert.assertTrue(title.equalsIgnoreCase(expectedTitle),"Validating page Title expected"+expectedTitle+"Found "+title);
        } catch (NoSuchElementException e) {
            System.out.println("Element could not be found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterText(WebElement element, WebDriver driver, String text) {
        try {
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            System.out.println("Element could not be found.Element details "+element);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.ignoring(StaleElementReferenceException.class);
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element could not be found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText(WebElement element, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.ignoring(StaleElementReferenceException.class);

            return element.getText();
        } catch (NoSuchElementException e) {
            System.out.println("Element could not be found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void enterKeyBoardKey(WebElement element,String key) {
        try {
            if(key.equalsIgnoreCase("enter")){
                element.sendKeys(Keys.ENTER);
            }else if(key.equalsIgnoreCase("tab")){
                element.sendKeys(Keys.TAB);
            }else if(key.equalsIgnoreCase("backspace")){
                element.sendKeys(Keys.BACK_SPACE);
            }
            else{
                System.out.println("Invalid key please add to wrapper method");
            }


        } catch (NoSuchElementException e) {
            System.out.println("Element could not be found");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}



