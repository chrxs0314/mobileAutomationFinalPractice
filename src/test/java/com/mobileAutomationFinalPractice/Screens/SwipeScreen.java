package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class SwipeScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Swipe-screen\")")
    WebElement swipeScreenView;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    WebElement swipeScreenTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Swipe-screen\")")
    WebElement swipeScreenSubtitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\")")
    WebElement swipeScreenScrollView;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(0)))")
    WebElement swipeScreenScrollViewCard1;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement swipeScreenScrollViewCard2;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement swipeScreenScrollViewCard3;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement swipeScreenScrollViewCard4;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement swipeScreenScrollViewCard5;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.HorizontalScrollView\").childSelector(new UiSelector().index(0).childSelector(new UiSelector().index(1)))")
    WebElement swipeScreenScrollViewCard6;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9))")
    WebElement swipeScreenIndicatorItem;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(0)))")
    WebElement swipeScreenIndicatorItem1;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(1)))")
    WebElement swipeScreenIndicatorItem2;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(2)))")
    WebElement swipeScreenIndicatorItem3;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(3)))")
    WebElement swipeScreenIndicatorItem4;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(4)))")
    WebElement swipeScreenIndicatorItem5;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Carousel\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").instance(9).childSelector(new UiSelector().index(5)))")
    WebElement swipeScreenIndicatorItem6;

    List<WebElement> elements = Arrays.asList(
            swipeScreenView,
            swipeScreenTitle,
            swipeScreenSubtitle,
            swipeScreenScrollView,
            swipeScreenScrollViewCard1,
            swipeScreenScrollViewCard2,
            swipeScreenScrollViewCard3,
            swipeScreenScrollViewCard4,
            swipeScreenScrollViewCard5,
            swipeScreenScrollViewCard6,
            swipeScreenIndicatorItem,
            swipeScreenIndicatorItem1,
            swipeScreenIndicatorItem2,
            swipeScreenIndicatorItem3,
            swipeScreenIndicatorItem4,
            swipeScreenIndicatorItem5,
            swipeScreenIndicatorItem6

    );
    List<WebElement> elementsToSwipe = Arrays.asList(
            swipeScreenScrollViewCard1,
            swipeScreenScrollViewCard2,
            swipeScreenScrollViewCard3,
            swipeScreenScrollViewCard4,
            swipeScreenScrollViewCard5
    );

    @Override
    protected Boolean verifyScreen() {
        for(WebElement el : elements){
            softAssert.assertTrue(
                    isElementDisplayed(el)
            );
            for (WebElement elemtToSwipe : elementsToSwipe){
                if (el == elemtToSwipe){
                    swipe(536,1500, 75);
                }
            }
        }
        try {
            softAssert.assertAll();
            System.out.println("Se comprobo todos los elementos de Swipe");
            return true;
        }catch (AssertionError e){
            System.out.println("No se pudo comprobar los elementos");
            return false;
        }
    }
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
}
