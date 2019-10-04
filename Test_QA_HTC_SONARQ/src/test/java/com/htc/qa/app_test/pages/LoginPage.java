package com.htc.qa.app_test.pages;

import com.htc.qa.app_test.utils.CommonMethods;
import org.openqa.selenium.By;

public class LoginPage extends CommonMethods {

    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By ACCESS_BTN = By.cssSelector("#app > main > div > div > div > div > div.card-body > form > div.form-group.row.mb-0 > div > button");
    private static final By MENU = By.cssSelector("#app > nav > div > a");

    public LoginPage(){
    }

    public LoginPage loginUser(String email, String pass){
        waitElement(EMAIL_INPUT);
        sendText(EMAIL_INPUT, email);
        sendText(PASSWORD_INPUT, pass);
        click(ACCESS_BTN);
        return this;
    }

    public LoginPage menuInicio(){
        click(MENU);
        return this;
    }

}