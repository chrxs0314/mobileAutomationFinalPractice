package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class SignUpScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login\")")
    WebElement btnLogin;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Login-screen\")")
    WebElement SignUpScreenView;
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
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-repeat-password\")")
    WebElement formConfirmPassword;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-SIGN UP\")")
    WebElement formSubmitSignup;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You successfully signed up!\")")
    WebElement signedUpConfirm;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    WebElement okBtn;

    List<WebElement> elements = Arrays.asList(
            SignUpScreenView,
            loginSignUpTitle,
            loginBtn,
            signUpBtn,
            formLoginSignUp,
            formEmail,
            formPassword,
            formConfirmPassword,
            formSubmitSignup
    );

    public void clickLoginForm(){
        softAssert.assertTrue(isElementDisplayed(loginBtn));
        loginBtn.click();
    }

    public void goToLoginSignUpScreen(){
        softAssert.assertTrue(isElementDisplayed(btnLogin));
        btnLogin.click();
    }

    public void clickSignUpForm(){
        softAssert.assertTrue(isElementDisplayed(signUpBtn));
        signUpBtn.click();
    }

    public void userSignUp(String email, String password){
        softAssert.assertTrue(isElementDisplayed(formEmail));
        softAssert.assertTrue(isElementDisplayed(formPassword));
        softAssert.assertTrue(isElementDisplayed(formConfirmPassword));

        formEmail.sendKeys(email);
        formPassword.sendKeys("testPass");
        formConfirmPassword.sendKeys("testPass");
        formSubmitSignup.click();

        softAssert.assertTrue(isElementDisplayed(signedUpConfirm));
        System.out.println("El usuario " + email + " con contraseña testPass se registro con exito");
        okBtn.click();
    }

    @Override
    protected Boolean verifyScreen() {
        clickSignUpForm();
        for(WebElement el : elements){
            softAssert.assertTrue(
                    isElementDisplayed(el)
            );
        }
        try {
            softAssert.assertAll();
            System.out.println("Se comprobo todos los elementos de SignUp");
            return true;
        }catch (AssertionError e){
            System.out.println("No se pudo comprobar los elementos");
            return false;
        }
    }
    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }
}
