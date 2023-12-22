package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.providers.Emailprovider;
import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class LoginScreen extends BaseScreen {
    private String nameScreen = "Login";
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login-screen\")")
    WebElement loginScreenView;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    WebElement loginSignUpTitle;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-login-container\")")
    WebElement loginBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-sign-up-container\")")
    WebElement signUpBtn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().className(\"android.view.ViewGroup\")).childSelector(new UiSelector().index(3)))")
    WebElement formLoginSignUp;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-email\")")
    WebElement formEmail;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-password\")")
    WebElement formPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"When the device has Touch/FaceID (iOS) or FingerPrint enabled a biometrics button will be shown to use and test the login.\")")
    WebElement formText;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-LOGIN\")")
    WebElement formSubmitLogin;

    List<WebElement> elements = Arrays.asList(
            loginScreenView,
            loginSignUpTitle,
            loginBtn,
            signUpBtn,
            formLoginSignUp,
            formEmail,
            formPassword,
            formText,
            formSubmitLogin
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
            System.out.println("Se comprobo todos los elementos de Login");
            return true;
        }catch (AssertionError e){
            System.out.println("No se pudo comprobar los elementos");
            return false;
        }
    }
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
}
