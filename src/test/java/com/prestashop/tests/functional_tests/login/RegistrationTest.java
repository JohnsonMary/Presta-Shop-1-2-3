package com.prestashop.tests.functional_tests.login;

import com.prestashop.Pages.AccountPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    AccountPage accountPage = new AccountPage();


    @Test
    public void test1() throws InterruptedException {
        
        driver.get(ConfigurationReader.getProperty("url"));
        accountPage.signIn.click();


        accountPage.emailCreate.sendKeys("llsg@hotmail.com");
        accountPage.createAccountButton.click();

        accountPage.firstNameCreate.sendKeys("Pinar");
        accountPage.lastNameCreate.sendKeys("Ercan");
        accountPage.passwordCreate.sendKeys("00000");
        accountPage.streetCreate.sendKeys("20 Clifton Ave.");
        accountPage.cityCreate.sendKeys("Clifton");

        Select state = new Select(accountPage.stateCreate);
        state.selectByVisibleText("New Jersey");

        accountPage.postCode.sendKeys("07045");

        Select list = new Select(accountPage.countryCreate);
        list.selectByIndex(1);

        accountPage.phonenumber.sendKeys("2627897766");
        accountPage.registerButton.click();
        Thread.sleep(2000);

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get(ConfigurationReader.getProperty("url"));
        accountPage.signIn.click();

        accountPage.email.sendKeys(ConfigurationReader.getProperty("emailP"));
        accountPage.password.sendKeys(ConfigurationReader.getProperty("password")+Keys.ENTER);

        String expectedFullName = "Pinar Ercan";
        Assert.assertEquals(accountPage.fullNameOnTop.getText(),expectedFullName);

        accountPage.personalInfButton.click();
        Assert.assertEquals(accountPage.firstName.getAttribute("value"),"Pinar");
        Assert.assertEquals(accountPage.lastName.getAttribute("value"),"Ercan");
        Assert.assertEquals(accountPage.email.getAttribute("value"),"pinarercans@gmail.com");

        accountPage.signIn.click();
        accountPage.myAddress.click();

        Assert.assertEquals(accountPage.addressConfirm.getText(),"20 Clifton Ave.");
        Assert.assertEquals(accountPage.cityConfirm(accountPage.cityConfirm),"Clifton");
        Assert.assertEquals(accountPage.stateConfirm.getText(),"New Jersey");
        Assert.assertEquals(accountPage.zipcodeConfirm.getText(),"07045");
        Assert.assertEquals(accountPage.countryConfirm.getText(),"United States");

        accountPage.signOut.click();
        accountPage.email.sendKeys("vvv@hotmail.com");
        accountPage.password.sendKeys("00000"+Keys.ENTER);

        Assert.assertEquals(accountPage.fullNameOnTop.getText(),"John Harrison");


    }

}
