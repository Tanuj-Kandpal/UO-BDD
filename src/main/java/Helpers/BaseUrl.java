package Helpers;

import org.openqa.selenium.WebDriver;

public class BaseUrl {
    String uoUrl = System.getProperty("url");

    String pageUrl;

    private final WebDriver driver;

    public BaseUrl() {
        this.driver = DriverManager.getDriver();
    }

    public void accountUrl() {
        pageUrl = uoUrl.replace("web/en/us", "account/en/us/account-management/create-account");
        driver.get(pageUrl);
    }

    public String homePageUrl() {
        return uoUrl;
    }


}
