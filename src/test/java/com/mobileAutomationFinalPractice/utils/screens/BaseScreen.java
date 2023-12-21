package com.mobileAutomationFinalPractice.utils.screens;

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
    AndroidDriver driver;

    HomeScreen homeScreen;
    WebviewScreen webviewScreen;
    LoginScreen loginScreen;
    FormsScreen formsScreen;
    SwipeScreen swipeScreen;
    DragScreen dragScreen;
    protected SoftAssert softAssert = new SoftAssert();

    List<MenuItem> menuItems;

    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void initializeScreens() {
        this.homeScreen = new HomeScreen(driver);
        this.webviewScreen = new WebviewScreen(driver);
        this.loginScreen = new LoginScreen(driver);
        this.formsScreen = new FormsScreen(driver);
        this.swipeScreen = new SwipeScreen(driver);
        this.dragScreen = new DragScreen(driver);
        this.menuItems =  Arrays.asList(
                new MenuItem(btnHome,homeScreen),
                new MenuItem(btnWebview,webviewScreen),
                new MenuItem(btnLogin,loginScreen),
                new MenuItem(btnForms,formsScreen),
                new MenuItem(btnSwipe,swipeScreen),
                new MenuItem(btnDrag,dragScreen)
        );
    }

    public void exploreItemMenu(){
        for (MenuItem menuItem : menuItems){
            menuItem.btn.click();
            softAssert.assertTrue(menuItem.page.verifyScreen());
        }
        softAssert.assertAll();
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

    public void swipe(int x, int y){
        Dimension size = driver.manage().window().getSize();
        int startX = x;
        int endX = x-400;
        int centerY = y;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),startX,centerY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),PointerInput.Origin.viewport(),endX,centerY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    protected Boolean verifyScreen() {
        return false;
    }
}
