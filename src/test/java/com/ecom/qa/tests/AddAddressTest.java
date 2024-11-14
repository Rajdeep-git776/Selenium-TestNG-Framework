package com.ecom.qa.tests;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.AddAddressPage;
import com.ecom.qa.pages.LoginPage;
import com.ecom.qa.pages.MyAccount;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AddAddressTest extends TestBase {
    LoginPage loginPage;
    MyAccount myAccount;
    AddAddressPage addAddressPage;

    public AddAddressTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        myAccount = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        addAddressPage = myAccount.clickOnAddressBook();
    }

    @Test
    public void clickAddressBookandEnterCompanyDetails(){

        String AddressPageTitle=addAddressPage.validatePageTitle();
        Assert.assertEquals(AddressPageTitle,"Add New Address");
        String CompanyfieldValue =addAddressPage.enterCompanyName();
        Assert.assertEquals(CompanyfieldValue,"TestCompany","The company did not match");


    }

    @Test
    public void clickAddressBookandEnterPhoneDetails(){

        String phoneFieldValue=addAddressPage.enterPhoneNumber();
        Assert.assertEquals(phoneFieldValue,"9999999999","The phone did not match");
    }

    @Test
    public void clickAddressBookAndEnterStreetDetails(){

        String streetNameFieldValue=addAddressPage.enterStreetName();
        Assert.assertEquals(streetNameFieldValue,"California - strret 2", "The Street name did not match");

    }

    @Test
    public void clickAddressBookAndEnterCityName(){
        String cityFieldValue=addAddressPage.enterCityName();
        Assert.assertEquals(cityFieldValue,"New York", "The City Name did not match");
    }

    @Test
    public void AddStateProvince(){
        addAddressPage.stateProvince();
    }

    @Test
    public void enterZipCode(){
        String zipCodeFieldValue=addAddressPage.enterZipCode();
        Assert.assertEquals(zipCodeFieldValue,"327765");
    }

    @Test
    public void enterAddressDetailsAndClickSave(){
        String AddressPageTitle=addAddressPage.validatePageTitle();
        Assert.assertEquals(AddressPageTitle,"Add New Address");
        String CompanyfieldValue =addAddressPage.enterCompanyName();
        Assert.assertEquals(CompanyfieldValue,"TestCompany","The company did not match");
        String phoneFieldValue=addAddressPage.enterPhoneNumber();
        Assert.assertEquals(phoneFieldValue,"9999999999","The phone did not match");
        String streetNameFieldValue=addAddressPage.enterStreetName();
        Assert.assertEquals(streetNameFieldValue,"California - strret 2", "The Street name did not match");
        String cityFieldValue=addAddressPage.enterCityName();
        Assert.assertEquals(cityFieldValue,"New York", "The City Name did not match");
        addAddressPage.stateProvince();
        String zipCodeFieldValue=addAddressPage.enterZipCode();
        Assert.assertEquals(zipCodeFieldValue,"327765");
        addAddressPage.clickOnSaveAddressBtn();


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
