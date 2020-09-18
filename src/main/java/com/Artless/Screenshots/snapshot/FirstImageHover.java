package com.Artless.Screenshots.snapshot;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;

@Snap("firstImageHover.png")
public class FirstImageHover {

    private final WebDriver driver;

    public FirstImageHover(WebDriver driver) {
        this.driver = driver;
    }

    public OcularResult compare() {
        return Ocular.snapshot().from(this)
                .sample().using(driver)
                .compare();
    }
}

