package com.ecom.qa.pages;

import com.ecom.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount extends TestBase {

    @FindBy(css = "div[class='panel header'] span[class='logged-in']")
    WebElement userNameLabel;

    @FindBy(xpath = "//li//strong[text()='My Wish List']")
    WebElement myWishListBtn;

    @FindBy(xpath = "//span[text()='You have no items in your wish list.']")
    WebElement emptyWishListLabel;

    @FindBy(xpath = "//span[text()='Edit']")
    WebElement editBtn;

    @FindBy(css = "#lastname")
    WebElement lastNameField;

    @FindBy(xpath = "//div/ul/li/strong[text()='Address Book']")
    WebElement addressBook;

    public  MyAccount(){
        PageFactory.initElements(driver,this);
    }

    public String validateAccountPageTitle(){
        return driver.getTitle();
    }


    public void clickOnMyWishList(){
        myWishListBtn.click();
    }

    public String validateEmptyWishListPageText(){
        return emptyWishListLabel.getText();
    }

    public String validateLoggedInUserName(){
       return userNameLabel.getText();
    }

    public void clickOnEditBtn(){
        editBtn.click();
    }

    public String validateLastName(){
        return lastNameField.getAttribute("value");
    }

    public AddAddressPage clickOnAddressBook(){
        addressBook.click();
        return new AddAddressPage();
    }



}
