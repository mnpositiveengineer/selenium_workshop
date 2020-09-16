package reset;

import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class resetTestSteps implements En {

    WebDriver driver;

    public resetTestSteps() {
        Given("Open the Firefox and launch the application", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("http://demo.guru99.com/v4");
            driver.manage().deleteAllCookies();
        });

        When("Enter the {string} and {string}", (String username, String password) -> {
            // Write code here that turns the phrase above into concrete actions
            driver.findElement(By.xpath("//input[@name=\"uid\"]")).sendKeys(username);
            driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
            Assert.assertEquals(username, driver.findElement(By.xpath("//input[@name=\"uid\"]")).getAttribute("value"));
            Assert.assertEquals(password, driver.findElement(By.xpath("//input[@name=\"password\"]")).getAttribute("value"));
        });

        When("Clicking on Reset button", () -> {
            // Write code here that turns the phrase above into concrete actions
            driver.findElement(By.xpath("//input[@value=\"RESET\"]")).click();
        });

        Then("UserID should be empty", () -> {
            // Write code here that turns the phrase above into concrete actions
            String actualUserID = driver.findElement(By.xpath("//input[@name=\"uid\"]")).getAttribute("value");
            Assert.assertEquals("", actualUserID);
        });

        Then("Password should be empty", () -> {
            // Write code here that turns the phrase above into concrete actions
            String actualPassword = driver.findElement(By.xpath("//input[@name=\"password\"]")).getAttribute("value");
            Assert.assertEquals("", actualPassword);
            driver.quit();
        });

    }
}
