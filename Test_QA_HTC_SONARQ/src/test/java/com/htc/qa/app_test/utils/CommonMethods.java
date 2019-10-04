package com.htc.qa.app_test.utils;

import com.htc.qa.app_test.utils.driver.Driver;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonMethods {

    WebDriver driver = Driver.webDriver;
    public static int MAX_TIME_WAIT = Integer.parseInt(System.getenv("MAX_TIME_WAIT"));

    protected String getTextElemnt(By by) {
        return driver.findElement(by).getText();
    }

    protected void executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void waitSecond(int second) {
        int time = second*1000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void waitElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, MAX_TIME_WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void sendText(By by, String text){
        click(by);
        driver.findElement(by).sendKeys(text);
    }

    protected int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }

    protected void scroll(int n){
        executeScript("window.scrollBy(0,"+n+")");
    }

}