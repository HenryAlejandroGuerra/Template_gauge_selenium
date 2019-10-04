package com.htc.qa.app_test.utils;

import com.thoughtworks.gauge.Step;
import com.htc.qa.app_test.utils.driver.Driver;

public class AppLauncher {

    public static String APP_URL = System.getenv("APP_URL");

    @Step("Enter Website")
    public void launchTheApplication() {
        Driver.webDriver.get(APP_URL);
    }
    
}