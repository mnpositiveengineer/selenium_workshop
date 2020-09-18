package artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestingListsOfValuesForProject {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://artlessdesign.pl/";

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElementsLocation wel = new WebElementsLocation();

        try {
            driver.get(baseUrl);
        } catch (WebDriverException e) {
            System.out.println("Webdriver Exception occured.");
        }

        Boolean contactFormIsOk = true;

        String expectedFirstOption = "kompletny projekt";
        String expectedSecondOption = "koncepcja";
        String expectedThirdOption = "zmiany deweloperskie";

        try {
            Select selectProject = new Select(driver.findElement(By.xpath(wel.getProjectPatch())));
            List<WebElement> listOfValues = selectProject.getOptions();
            String actualFirstOption = listOfValues.get(0).getText();
            String actualSecondOption = listOfValues.get(1).getText();
            String actualThirdOption = listOfValues.get(2).getText();

            if (!actualFirstOption.equals(expectedFirstOption)) {
                contactFormIsOk = false;
                System.out.println("Expected: " + expectedFirstOption +", actual: " + actualFirstOption);
            }
            if (!actualSecondOption.equals(expectedSecondOption)) {
                contactFormIsOk = false;
                System.out.println("Expected: " + expectedSecondOption +", actual: " + actualSecondOption);
            }
            if (!actualThirdOption.equals(expectedThirdOption)) {
                contactFormIsOk = false;
                System.out.println("Expected: " + expectedThirdOption +", actual: " + actualThirdOption);
            }

            if (contactFormIsOk == true) {
                System.out.println("Test passed. List of values is correct.");
            } else {
                System.out.println("Test failed.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No such element. Browser closed.");
        } finally {
            driver.close();
        }
    }
}
