package com.prestashop.Pages;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.ConcurrentHashMap;

public class CartIconPage {

    public CartIconPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void open(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    public WebElement product(String productName){

        String xpath = "//a[@title='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebDriver frame(){

        return Driver.getDriver().switchTo().frame(3);
    }


    @FindBy(xpath = "//button[@class='exclusive']")
    public  WebElement addToCartButton;

    @FindBy (xpath = "//div[@class='button-container']/span")
    public  WebElement continueShopping;

    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=order']")
    public  WebElement cart;

    @FindBy (xpath = "//span[@class='remove_link']/a")
    public  WebElement xIconDeleteItem;

    @FindBy (xpath = "//a[@title='View my shopping cart']/span[5]")
    public  WebElement emptyCart;

    @FindBy (xpath = "//a[@title='Proceed to checkout']")
    public  WebElement proceedToCheckout;



}
