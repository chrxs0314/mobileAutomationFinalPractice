package com.mobileAutomationFinalPractice.Tests;

import com.mobileAutomationFinalPractice.Screens.SignUpScreen;
import com.mobileAutomationFinalPractice.utils.providers.DataProviders;
import com.mobileAutomationFinalPractice.utils.screens.NavigationBar;
import com.mobileAutomationFinalPractice.utils.tests.BaseTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
    private SignUpScreen  signUpScreen;

    @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void signUpTest(String email, String password){
        signUpScreen = getSignupScreen();
        signUpScreen.goToLoginSignUpScreen();
        signUpScreen.clickSignUpForm();
        signUpScreen.userSignUp(email,password);
    }
}
