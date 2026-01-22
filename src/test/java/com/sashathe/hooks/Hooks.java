package com.sashathe.hooks;

import com.sashathe.config.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

public class Hooks {

    public static AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        driver = DriverFactory.getDriver();
        System.out.println("✅ Appium session started/reused.");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed() && driver != null) {
            // 1) Screenshot (PNG)
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "🧨 Screenshot on Failure",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png"
                );

                System.out.println("📸 Screenshot attached to Allure report.");
            } catch (Exception e) {
                System.out.println("⚠️ Could not capture screenshot: " + e.getMessage());
            }

            // 2) Page Source (optional but very useful)
            try {
                String source = driver.getPageSource();
                Allure.addAttachment(
                        "📄 Page Source on Failure",
                        "text/xml",
                        new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8)),
                        ".xml"
                );
                System.out.println("📄 Page source attached to Allure report.");
            } catch (Exception e) {
                System.out.println("⚠️ Could not capture page source: " + e.getMessage());
            }
        }
    }

    @AfterAll
    public static void closeSession() {
        DriverFactory.quitDriver();
        System.out.println("🧹 Appium session closed.");
    }
}

