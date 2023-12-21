package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Swipe\")")
    WebElement swipePageBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    WebElement title;


    @Override
    protected Boolean verifyPage() {
        return isElementDisplayed(title);
    }
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
}
