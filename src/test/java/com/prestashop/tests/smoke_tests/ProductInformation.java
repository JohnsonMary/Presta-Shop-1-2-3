package com.prestashop.tests.smoke_tests;

import com.prestashop.Pages.ProductPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductInformation extends TestBase {

    ProductPage productPage = new ProductPage();
    
    @Test(priority = 0)
    public void price() throws InterruptedException {

        productPage.open();

        String productName = productPage.product(ConfigurationReader.getProperty("productName1")).getText();
        Thread.sleep(1000);

        String price = productPage.price.getText();
        System.out.println("Price1 : " + price);

        productPage.product(ConfigurationReader.getProperty("productName1")).click();
        productPage.productShown(ConfigurationReader.getProperty("productName1"));

        Assert.assertEquals(productName, productPage.productShown(ConfigurationReader.getProperty("productName1")).getText());
        Thread.sleep(1000);

        Assert.assertEquals(price, productPage.priceShown.getText());

    }

    @Test(priority = 1)
    public void details() throws InterruptedException {

        productPage.open();
        productPage.product(ConfigurationReader.getProperty("productName2")).click();

        Assert.assertEquals(productPage.defaultQuantity.getAttribute("value"), "1");
        Assert.assertEquals(productPage.defaultSize(), "S");
        productPage.sizeOptions();


    }

    @Test(priority = 2)
    public void addToCart() throws InterruptedException {

        productPage.open();
        productPage.product(ConfigurationReader.getProperty("productName3")).click();
        productPage.addToCart.click();
        Thread.sleep(2000);

        Assert.assertEquals(productPage.message.getText(), "Product successfully added to your shopping cart");

        Thread.sleep(2000);

        productPage.cross.click();

        Driver.getDriver().navigate().back();

        productPage.product(ConfigurationReader.getProperty("productName3")).click();

        Assert.assertEquals(productPage.defaultQuantity.getAttribute("value"), "1");
        Assert.assertEquals(productPage.defaultSize(), "S");


    }

}













