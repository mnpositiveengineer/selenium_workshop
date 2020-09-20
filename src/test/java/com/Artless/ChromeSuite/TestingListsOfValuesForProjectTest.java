package com.Artless.ChromeSuite;

import com.Artless.WebElementsLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestingListsOfValuesForProjectTest {

    private String baseUrl = "https://artlessdesign.pl/";
    private WebDriver driver;
    private WebElementsLocation wel;

    @BeforeTest
    public void setBaseUrl() {
        System.setProperty("webdriver.chrome.driver", "C:/selenium-drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        wel = new WebElementsLocation();
        driver.get(baseUrl);
        Dimension d = new Dimension(360,740);
        driver.manage().window().setSize(d);
    }

    @Test
    public void ProjectListOfValuesIsCorrect() {
        Select selectProject = new Select(driver.findElement(By.xpath(wel.getProjectPatch())));
        List<WebElement> listOfValues = selectProject.getOptions();

        assertEquals(listOfValues.get(0).getText(), "kompletny projekt");
        assertEquals(listOfValues.get(1).getText(), "koncepcja");
        assertEquals(listOfValues.get(2).getText(), "zmiany deweloperskie");
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }

}