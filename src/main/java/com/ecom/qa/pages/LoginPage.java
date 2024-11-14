package com.ecom.qa.pages;

import com.ecom.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends TestBase {

    @FindBy(name = "login[username]")
    WebElement username;

    @FindBy(name = "login[password]")
    WebElement password;


    @FindBy(xpath = "//button[@class='action login primary']")
    @CacheLookup // stores the locator in a seperate cache memory so that it does not have to ask browser and wait for it. Instead it will pick from cache memory and it will improve script execution time.
    WebElement loginbBtn;


    @FindBy(xpath = "//a[@class='action create primary']")
    WebElement signUpBtn;

    @FindBy(xpath = "//a[@class='logo']")
    WebElement logo;


    // initialize page objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }


    public String validateLoginPageTitle(){

        return driver.getTitle();

    }

    public boolean validateLogo(){
       return logo.isDisplayed();
    }

    public MyAccount login(String un, String pwd) throws InterruptedException {
        username.sendKeys(un);
        password.sendKeys(pwd);
        Thread.sleep(5000);
        loginbBtn.click();

        return new MyAccount();
    }







}
