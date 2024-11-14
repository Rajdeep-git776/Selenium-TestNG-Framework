package com.ecom.qa.pages;

import com.ecom.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage extends TestBase {

    @FindBy(xpath = "//input[@id='company']")
    WebElement companyName;

    @FindBy(xpath = "//input[@id='telephone']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='street_1']")
    WebElement streetName;

    @FindBy(xpath = "//input[@name='city']")
    WebElement cityName;

    @FindBy(xpath = "//select[@title='State/Province']")
    WebElement stateSelectDropDown;

    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postalCode;

    @FindBy(xpath = "//button/span[text()='Save Address']")
    WebElement saveAddressBtn;




    public AddAddressPage(){
        PageFactory.initElements(driver,this);
    }

    public String enterCompanyName(){
        companyName.sendKeys("TestCompany");
        return companyName.getAttribute("value");
    }

    public String enterPhoneNumber(){
        phoneNumber.sendKeys("9999999999");
        return phoneNumber.getAttribute("value");
    }

    public String enterStreetName(){
        streetName.sendKeys("California - strret 2");
        return streetName.getAttribute("value");
    }

    public String enterCityName(){
        cityName.sendKeys("New York");
        return cityName.getAttribute("value");
    }

    public void stateProvince(){
        Select stateDropdown = new Select(stateSelectDropDown);
        stateDropdown.selectByIndex(3);
    }

    public String enterZipCode(){
        postalCode.sendKeys("327765");
        return postalCode.getAttribute("value");
    }

    public void clickOnSaveAddressBtn(){
        saveAddressBtn.click();
    }

    public String validatePageTitle(){
        return driver.getTitle();
    }










}
