package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class WebviewScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus\")")
    WebElement webView;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus\").childSelector(new UiSelector().className(\"android.view.View\"))")
    WebElement ukraineMassage;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus\").childSelector(new UiSelector().text(\"Main\"))")
    WebElement barMenu;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\"android.view.View\"))")
    WebElement mainContentWebview;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\"android.view.View\")).childSelector(new UiSelector().index(0))")
    WebElement imgRobot;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\"android.view.View\")).childSelector(new UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\"))")
    WebElement textWebviewContent;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"__docusaurus\").childSelector(new UiSelector().resourceId(\"ms-floating-button\"))")
    WebElement floatingButton;

    List<WebElement> elements = Arrays.asList(
            webView,
            ukraineMassage,
            barMenu,
            mainContentWebview,
            imgRobot,
            textWebviewContent,
            floatingButton
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
            System.out.println("Se comprobo todos los elementos de Webview");
            return true;
        }catch (AssertionError e){
            System.out.println("No se pudo comprobar los elementos");
            return false;
        }
    }
    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }
}
