package com.htc.qa.app_test.pages.home_page;

import com.htc.qa.app_test.utils.CommonMethods;
import org.openqa.selenium.By;

public class BioTab extends CommonMethods {

    private static final By DROPDOWN = By.id("navbarDropdown");
    private static final By LOGOUT = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li.show > div > a");
    private static final By HOME_TAB = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li:nth-child(1) > a");
    private static final By TUTORIALS_TAB = By.cssSelector("body > div.flex-center.position-ref.full-height > div.top-right.links > ul > li:nth-child(2) > a");

    public BioTab(){
    }

    public void logout(){
        click(DROPDOWN);
        click(LOGOUT);
    }

    public HomePage homeTab(){
        waitElement(HOME_TAB);
        click(HOME_TAB);
        return new HomePage();
    }

    public BioTab bioTab(){
        waitElement(TUTORIALS_TAB);
        click(TUTORIALS_TAB);
        return new BioTab();
    }

    public BioTab displaySeconds(){
        waitSecond(10);
        return this;
    }

}