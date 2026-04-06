package com.tracker.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTestUI {

    @Test
    public void testHomePage() {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:6060");

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        assertNotNull(title);

        driver.quit();
    }
}