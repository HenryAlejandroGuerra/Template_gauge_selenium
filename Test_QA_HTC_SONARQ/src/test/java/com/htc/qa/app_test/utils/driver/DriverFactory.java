package com.htc.qa.app_test.utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverFactory {

    static String app_URL = System.getenv("APP_URL");

    public static WebDriver getDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.requireWindowFocus();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        ieOptions.ignoreZoomSettings();
        ieOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, app_URL);

        String browser = System.getenv("BROWSER");
        System.out.println("Navegador: "+browser);
        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(chromeOptions);
        }
        switch (browser){
            case "IE":
                WebDriverManager.iedriver().version("3.141").setup();
                return new InternetExplorerDriver(ieOptions);
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
        }
    }
}
