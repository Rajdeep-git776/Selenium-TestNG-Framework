package com.ecom.qa.tests;

import com.ecom.qa.base.TestBase;
import com.ecom.qa.pages.LoginPage;
import com.ecom.qa.pages.MyAccount;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static com.ecom.qa.util.TestUtil.testData;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    MyAccount myAccount;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        initialization();
        loginPage = new LoginPage();
    }


    @Test(priority = 1)
    public void loginPageTitleTest(){
        String actualTitle=loginPage.validateLoginPageTitle();
        Assert.assertEquals(actualTitle,"Customer Login");
    }

    @Test (priority = 2)
    public void lumaLogoImageTest(){
        boolean flag =loginPage.validateLogo();
        Assert.assertTrue(flag);
    }

    @Test (priority = 3, dataProvider = "LoginTestData")
    public  void loginTestWithDifferentInputs(String username, String password) throws InterruptedException {

        loginPage.login(username,password);

    }

    @Test (priority = 4)
    public  void loginTest() throws InterruptedException {
        myAccount = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

    }



    // Data Provider for Login Test
    @DataProvider(name = "LoginTestData")
    public  Object[][] getData(){
        Object[][] data = testData("/src/main/java/com/ecom/qa/testdata/loginData.xlsx","Login");
        return data;


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
