package com.prestashop.tests.functional_tests.login;

import com.prestashop.Pages.AccountPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WONegativeLoginTests extends TestBase {
    AccountPage a2 = new AccountPage();

    @Test
    public void test2Login() throws InterruptedException {

        driver.get(ConfigurationReader.getProperty("url"));
        a2.signIn.click();
        a2.email.sendKeys("pinarercans@hotmail.com");
        a2.password.sendKeys("0000"+Keys.ENTER);
        String errorMessage = a2.errorMessage1.getText();
        Assert.assertEquals(errorMessage,"There is 1 error");


    }
}
