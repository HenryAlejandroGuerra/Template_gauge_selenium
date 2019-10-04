package com.htc.qa.app_test.pages;

import com.htc.qa.app_test.pages.LoginPage;
import com.htc.qa.app_test.pages.RegisterPage;
import com.htc.qa.app_test.utils.CommonMethods;
import org.openqa.selenium.By;

public class QAPage extends CommonMethods {

    private static final By LOGIN_TAB = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li:nth-child(3) > a");
    private static final By REGISTER_TAB = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li:nth-child(4) > a");

    public QAPage(){
    }

    public LoginPage loginTab(){
        waitElement(LOGIN_TAB);
        click(LOGIN_TAB);
        return new LoginPage();
    }

    public RegisterPage registerTab(){
        waitElement(REGISTER_TAB);
        click(REGISTER_TAB);
        return new RegisterPage();
    }

}