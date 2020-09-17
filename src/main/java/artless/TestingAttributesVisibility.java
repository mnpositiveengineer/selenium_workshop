package artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class TestingAttributesVisibility {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String baseUrl = "https://artlessdesign.pl/";

        // TESTING IF ALL ATTRIBUTES IN CONTACT FORM ARE DISPLAYED

        try {
            driver.get(baseUrl);
        } catch (WebDriverException e) {
            System.out.println("Webdriver Exception occured.");
        }

        Boolean contactFormIsOk = true;

        WebElementsLocation wel = new WebElementsLocation();

        if (!driver.findElement(By.xpath(wel.getEmailPath())).isDisplayed())
        {
            contactFormIsOk = false;
            System.out.println("Attribute email is not displayed.");
        };
        if (!driver.findElement(By.xpath(wel.getProjectPatch())).isDisplayed())
        {
            contactFormIsOk = false;
            System.out.println("Attribute selectProject is not displayed.");
        };
        if (!driver.findElement(By.xpath(wel.getCityPath())).isDisplayed())
        {
            contactFormIsOk = false;
            System.out.println("Attribute city is not displayed.");
        };
        if (!driver.findElement(By.xpath(wel.getAreaPath())).isDisplayed())
        {
            contactFormIsOk = false;
            System.out.println("Attribute area is not displayed.");
        };
        if (!driver.findElement(By.xpath(wel.getDeadlinePath())).isDisplayed())
        {
            contactFormIsOk = false;
            System.out.println("Attribute deadline is not displayed.");
        };
        if (!driver.findElement(By.xpath(wel.getMessagePath())).isDisplayed())
        {
            contactFormIsOk = false;
            System.out.println("Attribute message is not displayed.");
        };
        if (!driver.findElement(By.xpath(wel.getSubmitPath())).isDisplayed())
        {
            contactFormIsOk = false;
            System.out.println("Submit button is not displayed.");
        };

        if (contactFormIsOk == true) {
            System.out.println("Test passed. All attributes are displayed!");
        } else {
            System.out.println("Test failed.");
        }

        driver.close();

    }
}
