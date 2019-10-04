package com.htc.qa.app_test.utils;

import com.htc.qa.app_test.utils.driver.Driver;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CustomScreenGrabber implements ICustomScreenshotGrabber{

    public byte[] takeScreenshot() {
        try {
            return (((TakesScreenshot) Driver.webDriver).getScreenshotAs(OutputType.BYTES));       
        } catch (Exception e) {
            System.out.println("Error take Screenshot: "+e);
            return null;
        }
        
    }

}