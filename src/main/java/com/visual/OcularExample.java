package com.visual;

import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

public class OcularExample {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/selenium-drivers/Chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //konfiguracja bibliotek Ocular
        Ocular.config()
                // ścieżki do zapisywania screenów
                .resultPath(Paths.get("C:\\Users\\mnpos\\OneDrive\\Pulpit\\kodilla Selenium\\Selenium + Ocular\\results"))
                .snapshotPath(Paths.get("C:\\Users\\mnpos\\OneDrive\\Pulpit\\kodilla Selenium\\Selenium + Ocular\\snapshots"))
                //dokładność porównywania obrazów na 95%,
                .globalSimilarity(95)
                //informuje Ocular, aby stworzył automatycznie punkt odniesienia, jeśli on nie istnieje
                .saveSnapshot(true);

        WorldTimePage page = new WorldTimePage(driver);
        page.open();
        Thread.sleep(5000);
        page.compare();
        page.close();
    }
}
