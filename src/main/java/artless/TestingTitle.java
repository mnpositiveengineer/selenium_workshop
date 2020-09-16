package artless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingTitle {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://artlessdesign.pl/";
        String expectedTitle = "Artless | Projektowanie wnętrz";
        String actualTitle = "";

        driver.get(baseUrl);
        actualTitle = driver.getTitle();

        driver.close();

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is incorrect. Expected: " + expectedTitle + ", actual: " + actualTitle);
        }


    }
}
