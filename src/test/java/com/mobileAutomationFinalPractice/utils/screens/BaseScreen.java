package com.mobileAutomationFinalPractice.utils.screens;

import com.google.common.collect.ImmutableList;
import com.mobileAutomationFinalPractice.Screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BaseScreen {

    AndroidDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected Boolean isElementDisplayed(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void swipe(double startXPercentage, double endXPercentage, double cenerYPercentage){
        Dimension size = driver.manage().window().getSize();
        int startX = (int)(size.width * startXPercentage);
        int endX = (int)(size.width * endXPercentage);
        int centerY = (int) (size.height * cenerYPercentage);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),startX,centerY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600),PointerInput.Origin.viewport(),endX,centerY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(ImmutableList.of(swipe));
    }

    protected Boolean verifyScreen() {
        return false;
    }
}
