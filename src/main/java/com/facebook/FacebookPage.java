package com.facebook;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;

@Snap("FacebookPage.png")
public class FacebookPage {

    private WebDriver webDriver;

    public FacebookPage (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void compare() {
        Ocular.snapshot()
                .from(this)
                .sample().using(webDriver)
                .compare();
    }
}
