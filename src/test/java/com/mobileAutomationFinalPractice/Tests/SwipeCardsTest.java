package com.mobileAutomationFinalPractice.Tests;

import com.mobileAutomationFinalPractice.Screens.SwipeScreen;
import com.mobileAutomationFinalPractice.utils.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SwipeCardsTest extends BaseTest {
    SwipeScreen swipeScreen;
    @BeforeMethod
    public void goToSwipeScreen(){
        this.swipeScreen = getSwipeScreen();
        swipeScreen.goToSwipeScreen();
    }
    @Test
    public void swipeCardsTest(){
        swipeScreen.swipeCards();
    }
}
