package com.prestashop.tests.functional_tests.login;

import com.prestashop.Pages.AccountPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
2. Go to http://automationpractice.com/index.php
3. Click Sign in link
4. Enter new valid email to the email field
5. Click on Create Account
6. Fill all the required steps except for first name
7. Click on Register
8. Verify that error message firstname is required. is displayed
c */
public class ErrorMessageValidation extends TestBase {
    AccountPage a1 = new AccountPage();
    Select list;

    @Test
    public void test1() throws InterruptedException {

        driver.get(ConfigurationReader.getProperty("url"));
        a1.signIn.click();

        a1.emailCreate.sendKeys("ccc@hotmail.com");
        a1.createAccountButton.click();

        a1.lastNameCreate.sendKeys("Harrison");
        Thread.sleep(2000);

        a1.passwordCreate.sendKeys("00000");
        Thread.sleep(2000);


        a1.streetCreate.sendKeys("10 Rogers Pl.");
        a1.cityCreate.sendKeys("Bloomfield");

        Select state = new Select(a1.stateCreate);
        state.selectByVisibleText("New Jersey");

        a1.postCode.sendKeys("07003");

        list = new Select(a1.countryCreate);
        list.selectByIndex(1);

        a1.phonenumber.sendKeys("3635452299");
        a1.registerButton.click();

        String errorMessage = a1.errorMessageFirstname.getText();
        Assert.assertTrue(errorMessage.contains(" is required."));


    }
}
