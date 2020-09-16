import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingGoogleTestSuite {
    @ParameterizedTest
    @CsvFileSource(resources = "/inputStrings.csv", numLinesToSkip = 1)
    public void checkElementsName (String name){
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.pl/");
        System.out.println("For letter: " + name);
        try {
            driver.findElement(By.name(name)).click();
            System.out.println("element was found!");
        } catch (Exception e) {
            System.out.println("no such element!");
        } finally {
            driver.quit();
        }
    }
}
