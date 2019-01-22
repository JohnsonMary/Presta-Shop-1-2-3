package com.prestashop.Pages;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void open (){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @FindBy (xpath = "//button[@class='exclusive']")
    public  WebElement addToCartButton;

    @FindBy (xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']/span")
    public  WebElement xIcon;

    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=order']")
    public  WebElement cart;

    @FindBy (xpath = "//a[@class='cart_block_product_name']")
    public  WebElement productPlace;

    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=my-account']")
    public  WebElement signIn;

    @FindBy (id = "email")
    public  WebElement email;

    @FindBy (id = "SubmitLogin")
    public WebElement signinButton;

    @FindBy (id = "passwd")
    public  WebElement password;

    @FindBy (xpath = "(//a[@class='btn btn-default button button-small'])[2]")
    public  WebElement turnBackHome;

    @FindBy (linkText = "Sign out")
    public  WebElement signOut;

    @FindBy (xpath = "//a[@title='View my shopping cart']/span[5]")
    public  WebElement emptyCart;




    public WebElement product(String productName){

        String xpath = "//a[@title='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebDriver  frame(){

        return Driver.getDriver().switchTo().frame(3);
    }



}
