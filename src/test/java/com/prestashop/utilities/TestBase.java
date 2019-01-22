package com.prestashop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected SoftAssert softAssert;
    protected WebDriver driver;
    protected Actions actions;


    //public void setUp(@Optional String browser) {
    //		driver = Driver.getDriver(browser);
    //		driver.get(ConfigurationReader.getProperty("url"));
    //	}
    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.getDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        softAssert= new SoftAssert();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
        softAssert.assertAll();



    }



}
