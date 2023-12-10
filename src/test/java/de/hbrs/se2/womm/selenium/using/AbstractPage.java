package de.hbrs.se2.womm.selenium.using;

public abstract class AbstractPage {
    protected String websiteTitle;
    protected String websiteUrl;
    protected AbstractPage(String websiteTitle, String websiteUrl) {
        this.websiteTitle = websiteTitle;
        this.websiteUrl = websiteUrl;
    }
    public String getWebsiteTitle() {
        return websiteTitle;
    }
    public String getWebsiteUrl() {
        return websiteUrl;
    }

}
