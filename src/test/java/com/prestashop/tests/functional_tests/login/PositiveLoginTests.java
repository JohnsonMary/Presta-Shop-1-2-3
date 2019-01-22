package com.prestashop.tests.functional_tests.login;

import com.prestashop.Pages.AccountPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestBase {
    AccountPage a1 = new AccountPage();


    @Test
    public void test1MyAccount() throws InterruptedException {

        driver.get(ConfigurationReader.getProperty("url"));
        a1.signIn.click();
        a1.email.sendKeys("pinarercans@gmail.com");
        a1.password.sendKeys("00000");
        a1.signInSubmitButton.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("My account"));

    }
}
