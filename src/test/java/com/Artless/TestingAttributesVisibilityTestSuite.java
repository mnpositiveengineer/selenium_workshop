package com.Artless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class TestingAttributesVisibilityTestSuite {

    String baseUrl = "https://artlessdesign.pl/";

    @Test
    public void setupBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get(baseUrl);
        } catch (WebDriverException e) {
            System.out.println("Webdriver Exception occured.");
        }
    }
}