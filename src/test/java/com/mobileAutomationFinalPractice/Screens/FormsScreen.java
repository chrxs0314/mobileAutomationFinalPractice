package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Form components\")")
    WebElement title;
    @Override
    protected Boolean verifyScreen() {
        return isElementDisplayed(title);
    }
    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }
}
