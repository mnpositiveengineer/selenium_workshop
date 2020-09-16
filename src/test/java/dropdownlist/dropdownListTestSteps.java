package dropdownlist;

import io.cucumber.java8.En;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class dropdownListTestSteps implements En {

    WebDriver driver;

    public dropdownListTestSteps() {

        Given("user enter facebook web page", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("https://www.facebook.com/");
        });

        Given("dropdown list with months should be visible", () -> {
            // Write code here that turns the phrase above into concrete actions
            try {
                WebElement dropdownList = driver.findElement(By.xpath("//select[@name='birthday_month']"));
                Assert.assertTrue(dropdownList.isDisplayed());
            } catch (Exception e) {
                driver.navigate().refresh();
                WebElement dropdownList = driver.findElement(By.xpath("//select[@name='birthday_month']"));
                Assert.assertTrue(dropdownList.isDisplayed());
            }
        });

        When("selecting dropdown list", () -> {
            // Write code here that turns the phrase above into concrete actions
            Select dropdownList = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
        });

        Then("month such as {string} should be visible", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            Select dropdownList = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
            List<WebElement> listOfOptions =  dropdownList.getOptions();
            List<String> listOfStrings = listOfOptions
                    .stream().map(u -> u.getText())
                    .collect(Collectors.toList());
            System.out.println(listOfStrings);
            Assert.assertTrue(listOfStrings.contains(string));
        });

        Then("user should be able to choose {string} without any issue", (String string) -> {
            // Write code here that turns the phrase above into concrete actions
            Select dropdownList = new Select(driver.findElement(By.xpath("//select[@name='birthday_month']")));
            dropdownList.selectByVisibleText(string);
            String selectedMonth = dropdownList.getFirstSelectedOption().getText();
            Assert.assertEquals(string, selectedMonth);
        });

        Then("quit the browser successfully", () -> {
            // Write code here that turns the phrase above into concrete actions
            driver.quit();
        });
    }

}
