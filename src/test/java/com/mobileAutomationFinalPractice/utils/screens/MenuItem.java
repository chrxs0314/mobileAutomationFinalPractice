package com.mobileAutomationFinalPractice.utils.screens;

import org.openqa.selenium.WebElement;

public class MenuItem {
    WebElement btn;
    BaseScreen page;

    MenuItem(WebElement btn, BaseScreen page){
        this.btn = btn;
        this.page = page;
    }
}
