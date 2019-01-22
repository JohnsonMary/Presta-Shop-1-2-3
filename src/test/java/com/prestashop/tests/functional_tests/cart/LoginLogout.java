package com.prestashop.tests.functional_tests.cart;

import com.prestashop.Pages.AccountPage;
import com.prestashop.Pages.LoginPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class LoginLogout extends TestBase {

    LoginPage l1 = new LoginPage();

    @Test
    public void cartLoginTest () throws InterruptedException {

    l1.open();
    l1.product(ConfigurationReader.getProperty("productName1")).click();
    l1.frame();
    l1.addToCartButton.click();
    Thread.sleep(1000);
    l1.xIcon.click();
    actions.moveToElement(l1.cart).perform();
    Assert.assertEquals(l1.product(ConfigurationReader.getProperty("productName1")).getText(),l1.productPlace.getText());

    }

    @Test
    public void logoutTest() throws InterruptedException {

        l1.open();
        l1.signIn.click();
        l1.email.sendKeys(ConfigurationReader.getProperty("emailP"));
        l1.password.sendKeys(ConfigurationReader.getProperty("password"));
        l1.signinButton.click();
        Thread.sleep(1000);
        l1.turnBackHome.click();
        l1.product(ConfigurationReader.getProperty("productName2")).click();
        l1.frame();
        l1.addToCartButton.click();
        Thread.sleep(1000);
        l1.xIcon.click();
        actions.moveToElement(l1.cart).perform();
        Thread.sleep(1000);
        Assert.assertEquals(l1.productPlace.getText(),l1.product(ConfigurationReader.getProperty("productName2")).getText());

        l1.signOut.click();
        Assert.assertEquals(l1.emptyCart.getText(),"(empty)");


    }


}
