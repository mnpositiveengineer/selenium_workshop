package com.Artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class OpeningProjectPageTest {

    private String baseUrl = "https://artlessdesign.pl/";
    private WebDriver driver;
    private WebElementsLocation wel;
    private Actions builder;

    @BeforeTest
    public void setBaseUrl() {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        wel = new WebElementsLocation();
        driver.get(baseUrl);
    }

    @AfterTest
    public void endSession(){
        driver.quit();
    }

    @AfterMethod
    public void navigateToMainPage(){
        driver.navigate().back();
    }
    @BeforeMethod
    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }

    @Test
    public void firstProject() throws InterruptedException {
        driver.findElement(By.xpath(wel.getFirstImagePath())).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/nowojorskie-wn%C4%99trze");
    }

    @Test
    public void secondProject() throws InterruptedException {
        driver.findElement(By.xpath(wel.getSecondImagePath())).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/wn%C4%99trze-kamienicy");
    }

    @Test
    public void thirdProject() throws InterruptedException {
        driver.findElement(By.xpath(wel.getThirdImagePath())).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/wn%C4%99trze-z-biokominkiem");
    }

    @Test
    public void fourthProject() throws InterruptedException {
        driver.findElement(By.xpath(wel.getFourthImagePath())).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/r%C3%B3%C5%BCowa-kuchnia");
    }

    @Test
    public void fifthProject() throws InterruptedException {
        driver.findElement(By.xpath(wel.getFifthImagePath())).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/wn%C4%99trze-dla-faceta");
    }

    @Test
    public void sixthProject() throws InterruptedException {
        driver.findElement(By.xpath(wel.getSixthImagePath())).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://artlessdesign.pl/wn%C4%99trze-z-granatem");
    }
}
