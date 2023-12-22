package com.mobileAutomationFinalPractice.Tests;

import com.mobileAutomationFinalPractice.Screens.SwipeScreen;
import com.mobileAutomationFinalPractice.utils.tests.BaseTest;
import org.testng.annotations.Test;


public class SwipeCardsTest extends BaseTest {
    SwipeScreen swipeScreen;
    @Test
    public void swipeCardsTest(){
        swipeScreen = getSwipeScreen();
        swipeScreen.goToSwipeScreen();
        swipeScreen.swipeCards();
    }
}
