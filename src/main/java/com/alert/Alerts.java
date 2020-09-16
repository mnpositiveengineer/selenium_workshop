package com.alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Alerts {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:/selenium-drivers/Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        //HANDLING ALERTS
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.name("cusid")).sendKeys("someUser");
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.quit();
        //-------------------------------------------------------------------------
        //HANDLING POP UP WINDOWS
        WebDriver driver1 = new FirefoxDriver();
        driver1.get("http://demo.guru99.com/popup.php");

        for(int i = 0; i < 4; i++) {
            driver1.findElement(By.xpath("//*[text()=\"Click Here\"]")).click();
        }
        driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Set<String> allWindows = driver1.getWindowHandles();
        List<String> listOfWindows = new ArrayList<>();
        for(String handle : allWindows) {
            listOfWindows.add(handle);
        }
        driver1.switchTo().window(listOfWindows.get(0));
        //ITERATE FOR EACH PAGE AND POPULATE EMAIL ADRESS FIELD

        for(int i = 1; i < listOfWindows.size(); i++) {
            driver1.switchTo().window(listOfWindows.get(i));
            driver1.findElement(By.name("emailid")).sendKeys(i + "@email.com");
            driver1.findElement(By.name("btnLogin")).click();
            String id = driver1.findElement(By.xpath("//table/tbody/tr[4]/td[2]")).getText();
            String password = driver1.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
            System.out.println(i + ". UserID: " + id + ", " + "Password: " + password);
        }
    }
}
