package com.Artless.ChromeSuite;

import com.Artless.WebElementsLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestingMandatoryEmailTest {

    private String baseUrl = "https://artlessdesign.pl/";
    private WebDriver driver;
    private WebElementsLocation wel;

    @BeforeTest
    public void setBaseUrl() {
        System.setProperty("webdriver.chrome.driver", "C:/selenium-drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        wel = new WebElementsLocation();
        driver.get(baseUrl);
//        Dimension d = new Dimension(360,740);
//        driver.manage().window().setSize(d);
    }

    @Test
    public void isEmailMandatory() {
        driver.findElement(By.xpath(wel.getCityPath())).sendKeys("Test");
        driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("50");
        driver.findElement(By.xpath(wel.getSubmitPath())).submit();

        assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/");
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }


}