package com.ecom.qa.tests;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.LoginPage;
import com.ecom.qa.pages.MyAccount;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MyAccountTest extends TestBase {
    LoginPage loginPage;
    MyAccount myAccount;

    public MyAccountTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        myAccount = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test(priority = 1)
    public void validateMyAccountPageTitle(){
        String myAccountPageTitle =myAccount.validateAccountPageTitle();
        Assert.assertEquals(myAccountPageTitle,"My Account","Page title did not match");
    }

    @Test(priority = 2)
    public void validateUsernameAfterLogin(){
        String loggedUserName = myAccount.validateLoggedInUserName();
        Assert.assertEquals(loggedUserName,"Welcome, Rajdeep Roy!", "logged user name did not match");
    }

    @Test(priority = 4)
    public void validateEmptyWishListPageText(){
        myAccount.clickOnMyWishList();
        String wishListPageText = myAccount.validateEmptyWishListPageText();
        Assert.assertEquals(wishListPageText,"You have no items in your wish list.");
    }

    @Test(priority = 3)
    public void validateAccountLastNameFromEditPage(){
        myAccount.clickOnEditBtn();
        String lastName =myAccount.validateLastName();
        Assert.assertEquals(lastName,"Roy");
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
