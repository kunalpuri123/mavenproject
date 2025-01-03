package com.example.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

public class LoginAutomationTest {
    @Test
    public void testLogin() {
        // Set the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the web application
            driver.get("http://localhost:3000/");

            // Wait for the page to load by waiting for a key element (like the body)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement pageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); // Wait for body tag

            // Now, wait for the username field to become visible
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":r1:")));
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":r3:")));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));

            // Enter login credentials and click login button
            usernameField.sendKeys("testUser");
            passwordField.sendKeys("testPassword");
            loginButton.click();

            // Wait for the page to load and verify if the user is redirected to the Dashboard
            WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard"))); // Check for a dashboard element after login

            // Assert that the title of the page is "Dashboard"
            String expectedTitle = "Dashboard";
            String actualTitle = driver.getTitle();
            assertEquals(expectedTitle, actualTitle);
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
