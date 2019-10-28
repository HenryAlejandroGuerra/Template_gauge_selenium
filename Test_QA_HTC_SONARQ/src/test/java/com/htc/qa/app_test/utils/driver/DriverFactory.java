package com.htc.qa.app_test.utils.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverFactory {

    static String app_URL = System.getenv("APP_URL");
    static boolean headless = Boolean.valueOf(System.getenv("HEADLESS"));

    public static WebDriver getDriver() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.requireWindowFocus();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        ieOptions.ignoreZoomSettings();
        ieOptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, app_URL);

        String browser = System.getenv("BROWSER");
        System.out.println("Navegador: "+browser);
        System.out.println("Headless-Mode: "+headless);

        if (browser == null) {
            if(headless){
                chromeOptions.addArguments("--headless", "window-size=1200,600");
                chromeOptions.addArguments("--lang=en_US");
                chromeOptions.addArguments("no-sandbox");
                chromeOptions.addArguments("disable-setuid-sandbox");
            }
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(chromeOptions);
        }

        switch (browser){
            case "IE":
                WebDriverManager.iedriver().version("3.141").setup();
                return new InternetExplorerDriver(ieOptions);
            case "FIREFOX":
                if(headless){
                    firefoxOptions.addArguments("headless", "window-size=1200,600");
					firefoxOptions.addArguments("no-sandbox");
					firefoxOptions.addArguments("disable-setuid-sandbox");
                }
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(firefoxOptions);
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                if(headless){
                    chromeOptions.addArguments("--headless", "window-size=1200,600");
                    chromeOptions.addArguments("--lang=en_US");
                    chromeOptions.addArguments("no-sandbox");
                    chromeOptions.addArguments("disable-setuid-sandbox");
                }
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(chromeOptions);
        }
    }
}
