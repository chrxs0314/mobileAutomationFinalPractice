package com.mobileAutomationFinalPractice.utils.tests;

import com.mobileAutomationFinalPractice.Screens.LoginScreen;
import com.mobileAutomationFinalPractice.Screens.SignUpScreen;
import com.mobileAutomationFinalPractice.Screens.SwipeScreen;
import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import com.mobileAutomationFinalPractice.utils.screens.NavigationBar;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();

    public static AndroidDriver driver;


    @BeforeTest
    public void environmentSetUp(){
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try{
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        }catch(MalformedURLException e){
            System.out.println(e.getMessage());
        }
    }

    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    public NavigationBar getNavigationBar(){
        return new NavigationBar(driver);
    }
    public SignUpScreen getSignupScreen(){return new SignUpScreen(driver);}
    public SwipeScreen getSwipeScreen(){return new SwipeScreen(driver);}
    public LoginScreen getLoginScreen(){return new LoginScreen(driver);}

    public void loadProperties(){
        try{
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }catch (IOException e){
            throw new RuntimeException("Error loading the poroperties file " + PROPERTIES_FILE);
        }
    }

    public static void setUpCapabilities(UiAutomator2Options capabilities){
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setApp(Paths.get(getCapability("app")).toAbsolutePath().toString());
        capabilities.setAppActivity(getCapability("appActivity"));
        capabilities.setAutomationName(getCapability("automationName"));
    }

    public static String getCapability(String capabilityName){
        return properties.getProperty(capabilityName);
    }

}
