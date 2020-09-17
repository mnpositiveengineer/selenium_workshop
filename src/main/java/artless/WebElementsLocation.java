package artless;


public class WebElementsLocation {

    private String emailPath = "//input[@id = 'email']";
    private String projectPatch = "//select[@id = 'projekt']";
    private String cityPath = "//input[@id = 'miasto']";
    private String areaPath = "//input[@id = 'metraz']";
    private String deadlinePath = "//select[@id = 'termin']";
    private String messagePath = "//textarea[@id = 'wiadomosc']";
    private String submitPath = "//input[@type = 'submit']";
    private String thanksText = "//div[@id='thanks']//b";

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
}
