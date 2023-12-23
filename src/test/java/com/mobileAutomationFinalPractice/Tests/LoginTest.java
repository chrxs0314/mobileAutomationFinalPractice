package com.mobileAutomationFinalPractice.Tests;

import com.mobileAutomationFinalPractice.Screens.LoginScreen;
import com.mobileAutomationFinalPractice.Screens.SignUpScreen;
import com.mobileAutomationFinalPractice.utils.providers.DataProviders;
import com.mobileAutomationFinalPractice.utils.tests.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginScreen loginScreen;
    private SignUpScreen signUpScreen;
    @BeforeMethod
    public void goToLoginScreen(){
        this.signUpScreen = getSignupScreen();
        signUpScreen.goToLoginSignUpScreen();
    }
    @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void logInTest(String email, String password){
        this.loginScreen = getLoginScreen();
        signUpScreen.clickSignUpForm();
        signUpScreen.userSignUp(email, password);
        signUpScreen.clickLoginForm();
        loginScreen.userLogIn(email,password);
    }
}
