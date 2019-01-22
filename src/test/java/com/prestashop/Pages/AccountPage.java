package com.prestashop.Pages;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;
import com.sun.javafx.geom.Quat4f;
import com.sun.tools.javac.tree.DCTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {

    public AccountPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void open(){

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @FindBy (css = "a[href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement signIn;

    @FindBy(id = "email")
    public  WebElement email;

    @FindBy (id = "email_create")
    public WebElement emailCreate;

    @FindBy (id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy (xpath = "//form[@class='std box']/div[1]/div[4]/input")
    public  WebElement actualEmail;

    @FindBy (id = "customer_firstname")
    public  WebElement firstNameCreate;

    @FindBy (id = "customer_lastname")
    public  WebElement lastNameCreate;

    @FindBy (id = "passwd")
    public  WebElement passwordCreate;

    @FindBy (id = "address1")
    public  WebElement streetCreate;

    @FindBy (id = "city")
    public WebElement cityCreate;

    @FindBy (id = "postcode")
    public  WebElement postCode;

    @FindBy (id = "id_country")
    public  WebElement countryCreate;

    @FindBy (id = "phone_mobile")
    public  WebElement phonenumber;

    @FindBy (xpath = "//button[@class='btn btn-default button button-medium']")
    public  WebElement registerButton;

    @FindBy (xpath = "//span[.='My personal information']")
    public  WebElement personalInfLink;

    @FindBy (id = "id_state")
    public  WebElement stateCreate;

    @FindBy(id="passwd")
    public  WebElement password;

    @FindBy(css = "#firstname")
    public  WebElement firstName;

    @FindBy(css = "#lastname")
    public  WebElement lastName;

    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=identity']/span")
    public  WebElement personalInfButton;

    @FindBy (xpath = "//li[.='The password you entered is incorrect.']")
    public  WebElement errorMessage;

    @FindBy(name = "submitIdentity")
    public WebElement saveButton;

    @FindBy (partialLinkText = "Back to your account")
    public WebElement backToAccountButton;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=addresses']")
    public  WebElement myAddress;

    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=address']")
    public  WebElement addNewAddress;

    @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?controller=my-account']")
    public WebElement fullNameOnTop;

    @FindBy (css = "#firstname")
    public  WebElement firstname2;

    @FindBy (id = "submitAddress")
    public  WebElement saveButton2;

   @FindBy (tagName = "ol")
    public  WebElement error;

   @FindBy (xpath = "(//li)[18]//span")
    public  WebElement addressConfirm;

   @FindBy (xpath = "(//li)[19]//span")
    public WebElement cityConfirm;

   @FindBy (xpath = "(//li)[19]//span[2]")
    public  WebElement stateConfirm;

   @FindBy (xpath = "(//li)[19]//span[3]")
    public WebElement zipcodeConfirm;

   @FindBy (xpath = "(//li)[20]//span")
    public WebElement countryConfirm;

   @FindBy (xpath = "//a[@href='http://automationpractice.com/index.php?mylogout=']")
    public  WebElement signOut;

   @FindBy (xpath = "//div[@id='center_column']/div[1]/ol/li")
   public  WebElement errorMessageFirstname;

   @FindBy (id = "SubmitLogin")
   public  WebElement signInSubmitButton;

   @FindBy (xpath = "//p[.='There is 1 error']")
   public  WebElement errorMessage1;

   public  String cityConfirm(WebElement city){

       String cityName = city.getText();
       cityName = cityName.substring(0,cityName.length()-1);
       return cityName;
   }

  
    public WebElement fullName(String fullName){

        String xpath = "//span[.='"+fullName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));

    }














}
