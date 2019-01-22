package com.prestashop.Pages;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.web.WebView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void open() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-item-of-mobile-line']/div[1]/div[2]/div")
    public WebElement price;


    @FindBy(xpath = "//div[@class='price']")
    public WebElement priceShown;


    @FindBy(id = "quantity_wanted")
    public WebElement defaultQuantity;


    @FindBy(css = "button.exclusive")
    public WebElement addToCart;


    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
    public WebElement message;


    @FindBy(xpath = "//span[@class='cross']")
    public  WebElement cross;


    public WebElement product(String productName){

        String xpath = "//h5/a[@title='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }

    public WebElement productShown(String productName){

        String xpath = "//h1[.='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }


    public  String  defaultSize(){

        Select sizeList = new Select(Driver.getDriver().findElement(By.xpath("//div[@id='uniform-group_1']/select")));

        String  defaultsize = sizeList.getFirstSelectedOption().getText();

        return defaultsize;

    }
    public void sizeOptions(){

        Select sizeList = new Select(Driver.getDriver().findElement(By.xpath("//div[@id='uniform-group_1']/select")));

        List<WebElement> options = sizeList.getOptions();

                for (int i = 0; i < options.size(); i++) {

    }               Assert.assertEquals(options.get(0).getText(), "S");
                    Assert.assertEquals(options.get(1).getText(), "M");
                    Assert.assertEquals(options.get(2).getText(), "L");
}
                }















