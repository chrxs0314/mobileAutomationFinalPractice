package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class DragScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Drag-drop-screen\")")
    WebElement dragScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    WebElement dragScreenTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    WebElement dragScreenDropsContainer;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-l1\")")
    WebElement dragScreenDrop1;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-c1\")")
    WebElement dragScreenDrop2;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-r1\")")
    WebElement dragScreenDrop3;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-l2\")")
    WebElement dragScreenDrop4;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-c2\")")
    WebElement dragScreenDrop5;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-r2\")")
    WebElement dragScreenDrop6;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-l3\")")
    WebElement dragScreenDrop7;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-c3\")")
    WebElement dragScreenDrop8;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drop-r3\")")
    WebElement dragScreenDrop9;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"renew\")")
    WebElement dragScreenRenewBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-l2\")")
    WebElement dragScreenDrag1;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-r3\")")
    WebElement dragScreenDrag2;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-r1\")")
    WebElement dragScreenDrag3;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-c1\")")
    WebElement dragScreenDrag4;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-c3\")")
    WebElement dragScreenDrag5;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-r2\")")
    WebElement dragScreenDrag6;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-c2\")")
    WebElement dragScreenDrag7;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-l1\")")
    WebElement dragScreenDrag8;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"drag-l3\")")
    WebElement dragScreenDrag9;

    List<WebElement> elements = Arrays.asList(
            dragScreen,
            dragScreenTitle,
            dragScreenDropsContainer,
            dragScreenDrop1,
            dragScreenDrop2,
            dragScreenDrop3,
            dragScreenDrop4,
            dragScreenDrop5,
            dragScreenDrop6,
            dragScreenDrop7,
            dragScreenDrop8,
            dragScreenDrop9,
            dragScreenRenewBtn,
            dragScreenDrag1,
            dragScreenDrag2,
            dragScreenDrag3,
            dragScreenDrag4,
            dragScreenDrag5,
            dragScreenDrag6,
            dragScreenDrag7,
            dragScreenDrag8,
            dragScreenDrag9

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
            System.out.println("Se comprobo todos los elementos de Drag");
            return true;
        }catch (AssertionError e){
            System.out.println("No se pudo comprobar los elementos");
            return false;
        }
    }
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }
}
