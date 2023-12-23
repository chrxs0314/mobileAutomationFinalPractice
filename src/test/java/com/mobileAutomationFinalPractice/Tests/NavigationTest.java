package com.mobileAutomationFinalPractice.Tests;

import com.mobileAutomationFinalPractice.utils.screens.NavigationBar;
import com.mobileAutomationFinalPractice.utils.tests.BaseTest;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    private NavigationBar navBar;
    @Test
    public void navigationTest(){
        navBar = getNavigationBar();
        navBar.exploreItemMenu();
    }
}
