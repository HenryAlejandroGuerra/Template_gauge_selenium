package com.htc.qa.app_test.pages;

import com.htc.qa.app_test.utils.CommonMethods;
import org.openqa.selenium.By;

public class RegisterPage extends CommonMethods {

    private static final By NAME_INPUT = By.id("name");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By PASSWORD_CONFIRM_INPUT = By.id("password-confirm");
    private static final By REGISTER_BTN = By.cssSelector("#app > main > div > div > div > div > div.card-body > form > div.form-group.row.mb-0 > div > button");

    public RegisterPage(){
    }

    public RegisterPage registerUser(String name, String email, String pass){
        waitElement(NAME_INPUT);
        sendText(NAME_INPUT, name);
        sendText(EMAIL_INPUT, email);
        sendText(PASSWORD_INPUT, pass);
        sendText(PASSWORD_CONFIRM_INPUT, pass);
        click(REGISTER_BTN);
        return this;
    }

}