package radioButton;

import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class radioButtonSteps implements En {

    WebDriver driver;

    public radioButtonSteps() {
        Given("User enter the page and see three options to choose", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("http://demo.guru99.com/test/radio.html");
            List<WebElement> options = driver.findElements(By.xpath("//input[contains(@value,\"Option\")]"));
            Assert.assertEquals(3, options.size());
        });

        When("User click on option {string}", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            WebElement firstOption = driver.findElement(By.xpath("//input[@value='" + string + "']"));
            firstOption.click();
            Assert.assertTrue(firstOption.isSelected());
        });

        Then("{string} should not be selected", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            WebElement secondOption = driver.findElement(By.xpath("//input[@value='" + string + "']"));
            Assert.assertFalse(secondOption.isSelected());
        });

        Then("{string} should not be selected neither", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            WebElement thirdOption = driver.findElement(By.xpath("//input[@value='" + string + "']"));
            Assert.assertFalse(thirdOption.isSelected());
        });

        Then("User is able to close browser", () -> {
            // Write code here that turns the phrase above into concrete actions
            driver.quit();
        });
    }
}
