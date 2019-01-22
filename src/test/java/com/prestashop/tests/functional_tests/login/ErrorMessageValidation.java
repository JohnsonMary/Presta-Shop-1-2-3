package com.prestashop.tests.functional_tests.login;

import com.prestashop.Pages.AccountPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

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


        a1.streetCreate.sendKeys("12 Clifton ave.");
        a1.cityCreate.sendKeys("Clifton");

        Select state = new Select(a1.stateCreate);
        state.selectByVisibleText("New Jersey");

        a1.postCode.sendKeys("07045");

        list = new Select(a1.countryCreate);
        list.selectByIndex(1);

        a1.phonenumber.sendKeys("3635452299");
        a1.registerButton.click();

        String errorMessage = a1.errorMessageFirstname.getText();
        Assert.assertTrue(errorMessage.contains(" is required."));


    }
}
