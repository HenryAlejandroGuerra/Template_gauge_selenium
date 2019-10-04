package com.htc.qa.app_test.pages.home_page;

import com.htc.qa.app_test.utils.CommonMethods;
import org.openqa.selenium.By;

public class HomePage extends CommonMethods {

    private static final By DROPDOWN = By.id("navbarDropdown");
    private static final By LOGOUT = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li.show > div > a");
    private static final By TUTORIALS_TAB = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li:nth-child(2) > a");
    private static final By BIO_TAB = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li:nth-child(3) > a");

    public HomePage(){
    }

    public void logout(){
        click(DROPDOWN);
        click(LOGOUT);
    }

    public TutorialsManualsTab tutorialsManualsTab(){
        waitElement(TUTORIALS_TAB);
        click(TUTORIALS_TAB);
        return new TutorialsManualsTab();
    }

    public BioTab bioTab(){
        waitElement(BIO_TAB);
        click(BIO_TAB);
        return new BioTab();
    }

    public HomePage displaySeconds(){
        waitSecond(10);
        return this;
    }

}