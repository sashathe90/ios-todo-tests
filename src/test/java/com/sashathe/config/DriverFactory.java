package com.sashathe.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.MalformedURLException;

public class DriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();

            // ✅ W3C
            caps.setCapability("platformName", "iOS");
            caps.setCapability("appium:automationName", "XCUITest");

            // ✅ Device
            caps.setCapability("appium:deviceName", System.getProperty("deviceName", "iPhone 11"));
            caps.setCapability("appium:platformVersion", System.getProperty("platformVersion", "18.3"));
            caps.setCapability("appium:udid", System.getProperty("udid", "00008030-001005CA22C0C02E"));

            // ✅ App under test (у тебя приложение уже установлено на телефоне)
            caps.setCapability("appium:bundleId", System.getProperty("bundleId", "com.sashathe90.ToDoList"));

            // ✅ Stability
            caps.setCapability("appium:noReset", true);
            caps.setCapability("appium:newCommandTimeout", 3600);
            caps.setCapability("appium:showXcodeLog", true);

            // ✅ WDA: используем твой подписанный bundleId (который уже заработал у тебя)
            caps.setCapability("appium:usePrebuiltWDA", true);
            caps.setCapability("appium:updatedWDABundleId", System.getProperty("wdaBundleId", "com.sashathe90.wdaRunner"));

            // (по желанию) удобнее печатать на реальном устройстве
            caps.setCapability("appium:connectHardwareKeyboard", true);

            driver = new IOSDriver(new URL(System.getProperty("appiumServer", "http://127.0.0.1:4723")), caps);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


