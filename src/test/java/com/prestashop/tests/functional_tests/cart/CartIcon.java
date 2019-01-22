package com.prestashop.tests.functional_tests.cart;

import com.prestashop.Pages.CartIconPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartIcon extends TestBase {

    CartIconPage cart1 = new CartIconPage();

    /*
1. Open	browser
2. Go	to	http://automationpractice.com/index.php
3. Add	any	product	in	the	homepage	to	the	cart
4. Click	on	Continue	shopping
5. Hover	over	the	cart	icon
6. Click	the	x	to	delete	the	product
7. Verify	word	empty is	displayed	in	the	Cart	icon
 */

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

    /*
    1. Open	browser
2. Go	to	http://automationpractice.com/index.php
3. Add	any	product	in	the	homepage	to	the	cart
4. Click	on	Continue	shopping
5. Add	another	product	in	the	homepage	to	the	cart
6. Click	on	Proceed	to	checkout
7. Verify	message	Your	shopping	cart	contains:	2	Products
8. Click	the	delete	icon	to	delete	one	of	the	products
9. Verify	message	Your	shopping	cart	contains:	1	Product
10.Click	the	delete	icon	to	delete	the	second	product
11. Verify message Your shopping cart is empty.
     */

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
