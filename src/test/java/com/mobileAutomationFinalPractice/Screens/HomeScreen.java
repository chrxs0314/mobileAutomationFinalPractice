package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\")")
    WebElement homeScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\"))")
    WebElement homeElements;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(0)))")
    WebElement robotImg;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(2)))")
    WebElement webDriverImg;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"WEBDRIVER\")))")
    WebElement webDriverTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Demo app for the appium-boilerplate\")))")
    WebElement webDriverSubtitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(4)))")
    WebElement appleLogoImg;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().index(5)))")
    WebElement androidLogoImg;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().text(\"Support\")))")
    WebElement supportText;

    List<WebElement> elements = Arrays.asList(
            homeScreen,
            homeElements,
            robotImg,
            webDriverImg,
            webDriverTitle,
            webDriverSubtitle,
            appleLogoImg,
            androidLogoImg,
            supportText
    );

    @Override
    protected Boolean verifyScreen() {

        for(WebElement el : elements){
            softAssert.assertTrue(
                    isElementDisplayed(el)
            );
        }
        try {
            softAssert.assertAll();
            System.out.println("Se comprobo todos los elementos de Home");
            return true;
        }catch (AssertionError e){
            System.out.println("No se pudo comprobar los elementos");
            return false;
        }
    }

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
}
