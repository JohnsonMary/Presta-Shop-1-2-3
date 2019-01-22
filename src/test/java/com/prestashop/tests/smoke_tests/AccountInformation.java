package com.prestashop.tests.smoke_tests;

import com.prestashop.Pages.AccountPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AccountInformation extends TestBase {

    AccountPage page1 = new AccountPage();


    @Test
    public void myAccount() throws InterruptedException {
/*
1. Go to http://automationpractice.com/index.php
2. Click Sign in link
3. Login using valid username and password
4. Verify that title contains My account
 */
        page1.open();
        page1.signIn.click();

        page1.email.sendKeys(ConfigurationReader.getProperty("emailMary"));
        Thread.sleep(1000);
        page1.password.sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);
        Thread.sleep(1000);

        Assert.assertTrue(Driver.getDriver().getTitle().contains("My account"));
/*
5. Verify that account holder full name is displayed next to the Sign out link
Login: My personal information
6. Click on My personal information button
7. Verify title contains Identity

 */


        Assert.assertEquals(page1.fullName(ConfigurationReader.getProperty("fullName")).getText(),ConfigurationReader.getProperty("fullName"));
        page1.personalInfButton.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Identity"));
        Thread.sleep(1000);
/*
8. Verify that first name and last name matches the full name on top
9. Click on Save button
10. Verify error message “The password you entered is incorrect.”

 */
        String firstName = page1.firstName.getAttribute("value");
        String lastName = page1.lastName.getAttribute("value");

        Assert.assertEquals(page1.fullName(ConfigurationReader.getProperty("fullName")).getText(),ConfigurationReader.getProperty("fullName"));
        page1.saveButton.click();
        String errorMessage = page1.errorMessage.getText();
        Assert.assertEquals(page1.errorMessage.getText(),"The password you entered is incorrect.");

        Thread.sleep(1000);
/*
11. Click on Back to your account
12. Verify that title contains My account
Login: My addresses
13. Click on My addresses
14. Click on Add a new address
15. Verify that first name and last name matches the full name on top
16. Delete the first name
17. Click save
18. Verify error message “firstname is required.”



 */
    page1.backToAccountButton.click();
    Assert.assertTrue(Driver.getDriver().getTitle().contains("My account"));

    page1.myAddress.click();
    page1.addNewAddress.click();
    Assert.assertEquals(page1.fullNameOnTop.getText(),ConfigurationReader.getProperty("fullName"));
    page1.firstname2.clear();
    page1.saveButton2.click();

    Assert.assertTrue(page1.error.getText().contains("firstname is required"));

    }


}












