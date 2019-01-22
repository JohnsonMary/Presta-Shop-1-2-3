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
    /*
1. Open	browser
2. Go	to	http://automationpractice.com/index.php
3. Add	any	product	in	the	homepage	to	the	cart
4. Hover	over	the	cart	icon
5. Verify	that	cart	contains	the	product
6. Login	as	any	valid	user
7. Hover	over	the	cart	icon
8. Verify that	cart	information	is	same	as	step	5
     */

    l1.open();
    l1.product(ConfigurationReader.getProperty("productName1")).click();
    l1.frame();
    l1.addToCartButton.click();
    Thread.sleep(1000);
    l1.xIcon.click();
    actions.moveToElement(l1.cart).perform();
    Assert.assertEquals(l1.product(ConfigurationReader.getProperty("productName1")).getText(),l1.productPlace.getText());

    }

    /*
1. Open	browser
2. Go	to	http://automationpractice.com/index.php
3. Login	as	any	valid	user
4. Go	back	to	home	page
5. Add	any	product	in	the	homepage	to	the	cart
6. Hover	over	the	cart	icon
7. Verify	that	cart	contains	the	product
8. Log	out
9. Verify	the	cart	contains the	word	empty
     */

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
