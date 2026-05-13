package com.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    File Name   : LoginLogoutTest.java
    Author      : Jakkula Vinay
    Created On  : 11-May-2026
    Description : Selenium automation test for Login and Logout flow
*/

public class LoginLogoutTest {

    public static void main(String[] args) {

        // 1️⃣ Set ChromeDriver path
        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\selenium\\chromedriver.exe"   // ✅ change if needed
        );

        WebDriver driver = new ChromeDriver();

        try {
            // 2️⃣ Open Login Page
            driver.get("http://localhost:8080/your-app/login.html");
            driver.manage().window().maximize();

            // 3️⃣ Locate Username Field
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("vinay");

            // 4️⃣ Locate Password Field
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("password123");

            // 5️⃣ Click Login Button
            WebElement loginBtn = driver.findElement(By.className("login-btn"));
            loginBtn.click();

            // ⏳ Small wait (simple approach)
            Thread.sleep(2000);

            // 6️⃣ Validate Dashboard Page
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("dashboard")) {
                System.out.println("✅ Login Successful");
            } else {
                System.out.println("❌ Login Failed");
                driver.quit();
                return;
            }

            // 7️⃣ Click Logout Button
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();

            Thread.sleep(2000);

            // 8️⃣ Validate Logout Page
            if (driver.getCurrentUrl().contains("logout.html")) {
                System.out.println("✅ Logout Successful");
            } else {
                System.out.println("❌ Logout Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 9️⃣ Close Browser
            driver.quit();
        }
    }
}
