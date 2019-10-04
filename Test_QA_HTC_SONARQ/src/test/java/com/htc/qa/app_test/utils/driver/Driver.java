package com.htc.qa.app_test.utils.driver;

import com.htc.qa.app_test.utils.CustomScreenGrabber;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver webDriver;
    CustomScreenGrabber customScreenGrabber = new CustomScreenGrabber();

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    public void initializeDriver(){
        webDriver = DriverFactory.getDriver();
    }

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver(){
        customScreenGrabber.takeScreenshot();
        webDriver.quit();
    }

}
