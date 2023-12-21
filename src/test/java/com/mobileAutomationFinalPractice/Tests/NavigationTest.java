package com.mobileAutomationFinalPractice.Tests;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import com.mobileAutomationFinalPractice.utils.tests.BaseTest;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    private BaseScreen mainScreen;
    @Test
    public void navigationTest(){
        mainScreen = getBaseScreen();
        mainScreen.initializeScreens();
        mainScreen.exploreItemMenu();
    }
}
