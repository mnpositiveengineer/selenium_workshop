package com.Artless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidateEmail {
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

        try {
            driver.findElement(By.xpath(wel.getCityPath())).sendKeys("Test");
            driver.findElement(By.xpath(wel.getAreaPath())).sendKeys("50");

            Boolean contactFormIsOk = true;

            Set<String> listOfIncorrectEmails =
                    Stream.of("123", "abc", "abc.@gmail.com", "abc@.gmail.com", "abc..123@gmail.com",
                            "abc@gmail", "abc@gmail", "abc@gmail.com.pl")
                    .collect(Collectors.toSet());

            for (String attempt : listOfIncorrectEmails) {

                driver.findElement(By.xpath(wel.getEmailPath())).sendKeys(attempt);
                driver.findElement(By.xpath(wel.getSubmitPath())).submit();

                Thread.sleep(2000);

                if (driver.findElement(By.xpath(wel.getThanksText())).isDisplayed()){
                    contactFormIsOk = false;
                }

                driver.findElement(By.xpath(wel.getEmailPath())).clear();
            }

            if (contactFormIsOk == true) {
                System.out.println("Test passed. Email is validated correctly.");
            } else {
                System.out.println("Test failed.");
            }


        } catch (NoSuchElementException | InterruptedException e ){

        }
    }
}
