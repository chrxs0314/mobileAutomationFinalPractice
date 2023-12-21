package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.providers.Emailprovider;
import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    WebElement title;

    @Override
    protected Boolean verifyScreen() {
        return isElementDisplayed(title);
    }
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
}
