package com.prestashop.Pages;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.yaml.snakeyaml.events.Event;

import java.util.Set;

public class CartPage {

    public CartPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    public void open() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @FindBy (xpath = "//iframe[@class='fancybox-iframe']")
    public  WebElement frame;

    @FindBy(id = "email")
    public  WebElement email;

    @FindBy(id="passwd")
    public  WebElement password;

    @FindBy (linkText = "WOMEN")
    public  WebElement womenLink;

    @FindBy (css = "a[href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement signIn;

    @FindBy (css = "input#quantity_wanted")
    public  WebElement quantity;

    @FindBy (id = "group_1")
    public  WebElement size;

    @FindBy (xpath = "//button[@name='Submit']")
    public  WebElement addToCart;

    @FindBy (tagName = "h2")
    public  WebElement confirmMsg;


    @FindBy (xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    public  WebElement xIcon;

    @FindBy (xpath = "//span[@title='Close window']")
    public  WebElement xIcon2;

    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=order']")
    public  WebElement cart;

    @FindBy (xpath = "//a[@id='button_order_cart']")
    public  WebElement checkOutButton;

    @FindBy (xpath = "//div[@class='cart-prices-line last-line']/span[1]")
    public  WebElement totalPrice;

    @FindBy (xpath = "//table[@id='cart_summary']/tbody/tr/td[5]/input[2]")
    public  WebElement quantity1;

    @FindBy (xpath = "//table[@id='cart_summary']/tbody/tr/td[4]/span/span")
    public  WebElement priceFirstItem;

    @FindBy (xpath = "(//input[@class='cart_quantity_input form-control grey'])[2]")
    public  WebElement quantity2;

    @FindBy (xpath = "//span[@class='price special-price']")
    public  WebElement priceSecondItem;


    public WebElement notOnSaleItem(String productName){

        String xpath = "//img[@title='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }

    public WebElement onSaleItem(String productName){


        String xpath = "//a[@title='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }



    public WebDriver frame() throws InterruptedException {

        Thread.sleep(1000);
        onSaleItem(ConfigurationReader.getProperty("onSaleItem")).click();

        WebDriver framee = null;

        Set <String> windowHandles = Driver.getDriver().getWindowHandles();
        if(Driver.getDriver().getTitle().contains(ConfigurationReader.getProperty("onSaleItem"))){

            for(String handle: windowHandles){

              framee = Driver.getDriver().switchTo().window(handle);
             }
        }else {

              framee=  Driver.getDriver().switchTo().frame(frame);

        }return framee;


    }

  public double total(){

        double total;
        String quantityFirst = quantity1.getAttribute("value");
        System.out.println("First quantity: "+quantityFirst);

        String priceFirstIt = priceFirstItem.getText();
        System.out.println("First item price: "+priceFirstIt);
        priceFirstIt = priceFirstIt.substring(1);

        String quantitySecond = quantity2.getAttribute("value");
        System.out.println("Second quantity: "+quantitySecond);

        String priceSecondIt = priceSecondItem.getText();
        System.out.println("Second item price: "+priceSecondIt);

        priceSecondIt = priceSecondIt.substring(1);


        double totalFirstItem =  Double.parseDouble(quantityFirst)*Double.parseDouble(priceFirstIt);
        double totalSecondItem = Double.parseDouble(quantitySecond)*Double.parseDouble(priceSecondIt);
        return total = totalFirstItem+totalSecondItem+2;

    }
}
