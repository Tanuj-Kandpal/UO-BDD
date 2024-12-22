package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;


public class DriverHelper {

    private WebDriver driver;
    String url, browserName;

    public WebDriver setup() throws IOException {
        browserName = System.getProperty("browser", "chrome");
        url = System.getProperty("url");
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL is not set. Please provide a valid URL using -Durl=<URL>.");
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Please provide the correct browserName");
        }
        getUrl(url);
        driver.manage().window().maximize();
        return driver;
    }

    public void tearDown (){
      driver.quit();
    }

    public void getUrl(String actualUrl){
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        driver.get(actualUrl);
    }


    public void findElement(String locator) {
        driver.findElement(By.xpath(locator));
    }

    public WebElement findWebElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public void sendKeys(String locator, String text) {
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void close() {
        driver.quit();
    }

    public void click(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void waitElementToBeClickable(String locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

    }

    public void waitForPageToLoad(int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForElementToBeVisible(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeInVisible(String locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf((driver.findElement(By.xpath(locator)))));

    }

    public void titleToContain(String title, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(title));
        waitForPageToLoad(time);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchToNewWindow() {
        String parentWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        waitForPageToLoad(10);
    }

    public void getText(String locator) {
        driver.findElement(By.xpath(locator)).getText();
    }

    public String getTextValue(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }

    public boolean isDisplayed(String locator){
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public String printText(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }
}
