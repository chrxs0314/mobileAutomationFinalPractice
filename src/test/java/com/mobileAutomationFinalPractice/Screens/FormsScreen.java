package com.mobileAutomationFinalPractice.Screens;

import com.mobileAutomationFinalPractice.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class FormsScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Forms-screen\")")
    WebElement formsScreen;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Forms-screen\").childSelector(new UiSelector().className(\"android.view.ViewGroup\").childSelector(new UiSelector().className(\"android.view.ViewGroup\")))")
    WebElement formsMainContent;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Input field:\")")
    WebElement formInputTextLabel;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"text-input\")")
    WebElement formInputText;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You have typed:\")")
    WebElement formTypedLabel;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"input-text-result\")")
    WebElement formTextResult;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Switch:\")")
    WebElement formSwitchLabel;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"switch\")")
    WebElement formSwitch;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"switch-text\")")
    WebElement formSwitchStatus;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Dropdown:\")")
    WebElement formDropdownLabel;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Dropdown\")")
    WebElement formDropdown;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"icon_container\")")
    WebElement formDropdownImg;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.wdiodemoapp:id/select_dialog_listview\")")
    WebElement formDropdownItemsBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.wdiodemoapp:id/select_dialog_listview\").childSelector(new UiSelector().text(\"Select an item...\"))")
    WebElement formDropdownItemDefault;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"webdriver.io is awesome\")")
    WebElement formDropdownItem1;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Appium is awesome\")")
    WebElement formDropdownItem2;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"This app is awesome\")")
    WebElement formDropdownItem3;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Buttons\")")
    WebElement formButtonsLabel;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-Active\")")
    WebElement formButtonActive;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"button-Inactive\")")
    WebElement formButtonInactive;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Form components\")")
    WebElement formsTitle;

    List<WebElement> elements = Arrays.asList(
            formsScreen,
            formsMainContent,
            formInputTextLabel,
            formInputText,
            formTypedLabel,
            formTextResult,
            formSwitchLabel,
            formSwitch,
            formSwitchStatus,
            formDropdownLabel,
            formDropdown,
            formDropdownImg,
            formDropdownItemDefault,
            formDropdownItemDefault,
            formDropdownItem1,
            formDropdownItem2,
            formDropdownItem3,
            formButtonsLabel,
            formButtonActive,
            formButtonInactive,
            formsTitle
    );
    @Override
    protected Boolean verifyScreen() {
        for(WebElement el : elements){
            softAssert.assertTrue(
                    isElementDisplayed(el)
            );
            if (el == formDropdownImg) {
                el.click();
            }
            if (el == formDropdownItem3) {
                el.click();
            }
        }
        try {
            softAssert.assertAll();
            System.out.println("Se comprobo todos los elementos de Forms");
            return true;
        }catch (AssertionError e){
            System.out.println("No se pudo comprobar los elementos");
            return false;
        }
    }
    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }
}
