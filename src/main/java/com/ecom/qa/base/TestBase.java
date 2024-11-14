package com.ecom.qa.base;

import com.ecom.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
         prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ecom/qa/config/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initialization() throws MalformedURLException {
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            // Remote webdriver for selenium grid
//            driver = new RemoteWebDriver(new URL("http://192.168.29.18:4444"),options);
            driver = new ChromeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));


    }












}
