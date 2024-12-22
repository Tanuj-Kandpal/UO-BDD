package Helpers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverManager() {
    }

    // Getter for WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is not initialized. Please initialize the WebDriver before use.");
        }
        return driver;
    }

    // Setter for WebDriver
    public static void setDriver(WebDriver webDriver) {
        if (driver != null) {
            throw new IllegalStateException("WebDriver instance is already set. Resetting WebDriver is not allowed.");
        }
        driver = webDriver;
    }

    // Method to quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

