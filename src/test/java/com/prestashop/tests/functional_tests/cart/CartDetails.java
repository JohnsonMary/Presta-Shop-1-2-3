package com.prestashop.tests.functional_tests.cart;

import com.prestashop.Pages.CartPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1. Open browser
2. Go to http://automationpractice.com/index.php
3. Click on any product that is not on sale
4. Enter a random quantity between 2 and 5
5. Select a different size
6. Click on add to cart
7. Verify confirmation message Product successfully added to your shopping cart
8. Dismiss the confirmation window by clicking on the x icon
9. Click on the company logo
10. Click on any product that is on sale
11. Enter a random quantity between 2 and 5

12. Select a different size
13. Click on add to cart
14. Verify confirmation message Product successfully added to your
shopping cart
15. Dismiss the confirmation window by clicking on the x icon
16. Hover over the Cart icon
17. Verify that correct total is displayed
18. Verify that total is correct based on the price and item count of the
products you added to cart. (Shipping is always $2)
 */
public class CartDetails extends TestBase {

    CartPage cartPage = new CartPage();

@Test
public void test1() throws InterruptedException {

   // 1. Open browser
   // 2. Go to http://automationpractice.com/index.php
   // 3. Click on any product that is not on sale

    driver.get(ConfigurationReader.getProperty("url"));
    cartPage.signIn.click();
    cartPage.email.sendKeys("bcn@gmail.com");
    cartPage.password.sendKeys("00000"+Keys.ENTER);

    cartPage.womenLink.click();
    cartPage.notOnSaleItem(ConfigurationReader.getProperty("notOnSaleItem")).click();

    //4. Enter a random quantity between 2 and 5quantity_wanted
    //5. Select a different size
    //6. Click on add to cart

    Thread.sleep(1000);
    Driver.getDriver().switchTo().frame(cartPage.frame);

    cartPage.quantity.clear();
    cartPage.quantity.sendKeys("4");

    Select sizeOptions = new Select(cartPage.size);
    sizeOptions.selectByValue("2");
    cartPage.addToCart.click();

    // 7. Verify confirmation message Product successfully added to your shopping cart
    // 8. Dismiss the confirmation window by clicking on the x icon
    // 9. Click on the company logo

    Assert.assertEquals(cartPage.confirmMsg.getAttribute("innerText").trim(),"Product successfully added to your shopping cart");

    //10. Click on any product that is on sale
    //    11. Enter a random quantity between 2 and 5
    //    12. Select a different size
    //    13. Click on add to cart
    //    14. Verify confirmation message Product successfully added to your
    //    shopping cart

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


    //15. Dismiss the confirmation window by clicking on the x icon
    //16. Hover over the Cart icon
    Thread.sleep(1000);
    cartPage.xIcon2.click();
    actions.moveToElement(cartPage.cart).perform();

    //17. Verify that correct total is displayed
    // 18. Verify that total is correct based on the price and item count of the
    //products you added to cart. (Shipping is always $2)

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














    // String quantity = cartPage.quantity1


    /*
    String  totalPrice = driver.findElement(By.xpath("//div[@class='cart-prices-line last-line']/span")).getText();
    System.out.println("Total price: "+totalPrice);

    Assert.assertEquals(totalPrice,"$196.94");

    totalPrice = totalPrice.substring(1);

    WebElement checkOutButton = driver.findElement(By.id("button_order_cart"));
    checkOutButton.click();

    Thread.sleep(1000);
    String   quantity1 = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[5]/input[2]")).getAttribute("value");
    System.out.println("Quantity of the first product: "+quantity1);

    String  priceFirstItem = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[4]/span/span")).getText();
    System.out.println("First item's price: "+priceFirstItem);

    priceFirstItem = priceFirstItem.substring(1);
    Thread.sleep(1000);

    String quantity2 = driver.findElement(By.xpath("(//table[@id='cart_summary']/tbody/tr/td[5]/input[2])[2]")).getAttribute("value");
    System.out.println("Quantity of the first product: "+quantity2);

    String  priceSecondItem = driver.findElement(By.xpath("(//table[@id='cart_summary']/tbody/tr/td[4]/span/span)[2]")).getText();
    System.out.println("Second item's price: "+priceSecondItem);

    priceSecondItem = priceSecondItem.substring(1);

    double totalFirstItem =  Double.parseDouble(quantity1)*Double.parseDouble(priceFirstItem);
    double totalSecondItem = Double.parseDouble(quantity2)*Double.parseDouble(priceSecondItem);

    double total = totalFirstItem+totalSecondItem+2;

   Assert.assertEquals(total,Double.parseDouble(totalPrice));
*/
    }
}
