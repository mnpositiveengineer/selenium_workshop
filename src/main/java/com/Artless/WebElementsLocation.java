package com.Artless;


public class WebElementsLocation {

    private String emailPath = "//input[@id = 'email']";
    private String projectPatch = "//select[@id = 'projekt']";
    private String cityPath = "//input[@id = 'miasto']";
    private String areaPath = "//input[@id = 'metraz']";
    private String deadlinePath = "//select[@id = 'termin']";
    private String messagePath = "//textarea[@id = 'wiadomosc']";
    private String submitPath = "//input[@type = 'submit']";
    private String thanksText = "//div[@id='thanks']//b";
    private String firstImagePath = "//div[@class='link']//p[contains(text(),'w nowojorskim stylu')]";
    private String secondImagePath = "//div[@class='link']//p[contains(text(),'w zrekonstruowanej kamienicy')]";
    private String thirdImagePath = "//div[@class='link']//p[contains(text(),'z biokominkiem w roli')]";
    private String fourthImagePath = "//div[@class='link']//p[contains(text(),'otym akcentem')]";
    private String fifthImagePath = "//div[@class='link']//p[contains(text(),'po ciemnej stronie mocy')]";
    private String sixthImagePath = "//div[@class='link']//p[contains(text(),'z granatem w tle')]";

    public WebElementsLocation() {
    }

    public String getEmailPath() {
        return emailPath;
    }

    public String getProjectPatch() {
        return projectPatch;
    }

    public String getCityPath() {
        return cityPath;
    }

    public String getDeadlinePath() {
        return deadlinePath;
    }

    public String getMessagePath() {
        return messagePath;
    }

    public String getAreaPath() {
        return areaPath;
    }

    public String getSubmitPath() {
        return submitPath;
    }

    public String getThanksText() {
        return thanksText;
    }

    public String getFirstImagePath() {
        return firstImagePath;
    }

    public String getSecondImagePath() {
        return secondImagePath;
    }

    public String getThirdImagePath() {
        return thirdImagePath;
    }

    public String getFourthImagePath() {
        return fourthImagePath;
    }

    public String getFifthImagePath() {
        return fifthImagePath;
    }

    public String getSixthImagePath() {
        return sixthImagePath;
    }
}
