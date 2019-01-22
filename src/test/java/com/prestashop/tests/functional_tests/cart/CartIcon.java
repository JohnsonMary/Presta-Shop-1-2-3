package com.prestashop.tests.functional_tests.cart;

import com.prestashop.Pages.CartIconPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartIcon extends TestBase {

    CartIconPage cart1 = new CartIconPage();

    @Test
    public void iconDeleteTest() throws InterruptedException {

        cart1.open();
        cart1.product(ConfigurationReader.getProperty("productName3")).click();
        Thread.sleep(1000);
        cart1.frame();

        cart1.addToCartButton.click();
        Thread.sleep(1000);
        cart1.continueShopping.click();
        actions.moveToElement(cart1.cart).perform();
        Thread.sleep(1000);
        cart1.xIconDeleteItem.click();
        Thread.sleep(1000);
        Assert.assertEquals(cart1.emptyCart.getText(),"(empty)");


    }

    @Test
    public void checkoutDeleteTest() throws InterruptedException {

        cart1.open();
        cart1.product(ConfigurationReader.getProperty("productName1")).click();
        cart1.frame();
        cart1.addToCartButton.click();
        Thread.sleep(1000);
        cart1.continueShopping.click();
        cart1.product(ConfigurationReader.getProperty("productName2")).click();
        Thread.sleep(1000);
        cart1.frame();
        cart1.addToCartButton.click();
        Thread.sleep(1000);
        cart1.proceedToCheckout.click();

    }



}
