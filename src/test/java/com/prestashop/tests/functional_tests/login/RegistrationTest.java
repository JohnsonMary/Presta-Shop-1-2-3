package com.prestashop.tests.functional_tests.login;

import com.prestashop.Pages.AccountPage;
import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
1. Open	browser
2. Go	to	http://automationpractice.com/index.php
3. Click	Sign	in link
4. Enter	new valid email	to	the	email	field
5. Click	on	Create	Account
6. Verify	that	that	email	link	displays	current email
7. Fill	out	all	the	required	steps
8. Click	on	Register
9. Verify	that	correct	first	and	last	name	is displayed correctly	on	top	right
10. Click	on	My	personal	information
11. Verify	that	personal	information	is	displayed correctly
12. Click on	Back	to	your	account
13. Click	on	My	addresses	verify	that	address information	is	displayed
correctly
14. Click	on sign	out link
15. Login	using	the	email	and	password	if	the	current	user
16. Verify	that	correct	first	and	last	name	is displayed correctly	on	top	right
 */
public class RegistrationTest extends TestBase {

    AccountPage accountPage = new AccountPage();


    @Test
    public void test1() throws InterruptedException {

       /* System.out.println("Driver: "+driver);
        System.out.println(ConfigurationReader.getProperty("url"));
        System.out.println(ConfigurationReader.getProperty("browser"));
        System.out.println(ConfigurationReader.getProperty("email"));
        System.out.println(ConfigurationReader.getProperty("firstName"));*/
        driver.get(ConfigurationReader.getProperty("url"));
        accountPage.signIn.click();


        accountPage.emailCreate.sendKeys("llsg@hotmail.com");
        accountPage.createAccountButton.click();

      //  Assert.assertTrue(accountPage.actualEmail.getAttribute("value").contains(email));

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