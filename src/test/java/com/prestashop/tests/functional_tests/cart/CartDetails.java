package com.prestashop.tests.functional_tests.cart;

import com.prestashop.Pages.CartPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartDetails extends TestBase {

    CartPage cartPage = new CartPage();

@Test
public void test1() throws InterruptedException {

    driver.get(ConfigurationReader.getProperty("url"));
    cartPage.signIn.click();
    cartPage.email.sendKeys("bcn@gmail.com");
    cartPage.password.sendKeys("00000"+Keys.ENTER);

    cartPage.womenLink.click();
    cartPage.notOnSaleItem(ConfigurationReader.getProperty("notOnSaleItem")).click();

    Thread.sleep(1000);
    Driver.getDriver().switchTo().frame(cartPage.frame);

    cartPage.quantity.clear();
    cartPage.quantity.sendKeys("4");

    Select sizeOptions = new Select(cartPage.size);
    sizeOptions.selectByValue("2");
    cartPage.addToCart.click();
    
    Assert.assertEquals(cartPage.confirmMsg.getAttribute("innerText").trim(),"Product successfully added to your shopping cart");
    
    Thread.sleep(1000);
    cartPage.xIcon.click();
    cartPage.womenLink.click();

    cartPage.frame();

    cartPage.quantity.clear();
    cartPage.quantity.sendKeys("3");

    Select sizeOption = new Select(cartPage.size);
    sizeOptions.selectByValue("3");

    cartPage.addToCart.click();
    Assert.assertEquals(cartPage.confirmMsg.getAttribute("innerText").trim(),"Product successfully added to your shopping cart");

    Thread.sleep(1000);
    cartPage.xIcon2.click();
    actions.moveToElement(cartPage.cart).perform();
    
    String totalPrice = cartPage.totalPrice.getText();
    Thread.sleep(1000);
    softAssert.assertEquals(totalPrice,"$192.94");

    Thread.sleep(1000);
    cartPage.checkOutButton.click();

    Thread.sleep(1000);
    cartPage.total();
    String totalPrice1 = cartPage.totalPrice.getAttribute("value");
    System.out.println("Total price: "+totalPrice1);

    totalPrice1 = totalPrice1.substring(1);
    Thread.sleep(1000);
    Assert.assertEquals(cartPage.total(),Double.parseDouble(totalPrice1));

    }
}
