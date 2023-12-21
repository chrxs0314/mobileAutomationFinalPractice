package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    WebElement title;

    @Override
    protected Boolean verifyPage() {
        return isElementDisplayed(title);
    }
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }
}
