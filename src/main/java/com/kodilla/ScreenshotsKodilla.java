package com.kodilla;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;

@Snap("Screen.png")
public class ScreenshotsKodilla {

    private WebDriver webDriver;

    public ScreenshotsKodilla (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void compare() {
        Ocular.snapshot()
                .from(this)
                .sample().using(webDriver)
                .compare();
    }
}
