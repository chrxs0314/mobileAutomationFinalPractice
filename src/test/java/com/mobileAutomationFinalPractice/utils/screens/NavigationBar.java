package com.mobileAutomationFinalPractice.utils.screens;

import com.mobileAutomationFinalPractice.Screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class NavigationBar extends BaseScreen{
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home\")")
    WebElement btnHome;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Webview\")")
    WebElement btnWebview;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login\")")
    WebElement btnLogin;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Forms\")")
    WebElement btnForms;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Swipe\")")
    WebElement btnSwipe;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Drag\")")

    WebElement btnDrag;
    HomeScreen homeScreen = new HomeScreen(driver);
    WebviewScreen webviewScreen = new WebviewScreen(driver);
    LoginScreen loginScreen = new LoginScreen(driver);
    FormsScreen formsScreen = new FormsScreen(driver);
    SwipeScreen swipeScreen = new SwipeScreen(driver);
    DragScreen dragScreen = new DragScreen(driver);

    List<MenuItem> menuItems =  Arrays.asList(
            new MenuItem(btnHome,homeScreen),
            new MenuItem(btnWebview,webviewScreen),
            new MenuItem(btnLogin,loginScreen),
            new MenuItem(btnForms,formsScreen),
            new MenuItem(btnSwipe,swipeScreen),
            new MenuItem(btnDrag,dragScreen)
    );

    public void exploreItemMenu(){
        for (MenuItem menuItem : menuItems){
            menuItem.btn.click();
            softAssert.assertTrue(menuItem.page.verifyScreen());
        }
        softAssert.assertAll();
    }

    public NavigationBar(AndroidDriver driver) {
        super(driver);
    }
}
