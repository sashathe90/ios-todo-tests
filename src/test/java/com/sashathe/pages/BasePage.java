package com.sashathe.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;
import java.util.HashMap;
import java.util.Map;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class BasePage {

    protected final AppiumDriver driver;
    protected final WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    // ---------- WAITS ----------
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // ---------- ACTIONS ----------
    public void click(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ---------- SLEEP (debug only) ----------
    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ---------- iOS GESTURE: Swipe Back ----------
    public void swipeBack() {
        Dimension size = driver.manage().window().getSize();

        int startX = 1;
        int endX   = (int) (size.width * 0.90);
        int y      = (int) (size.height * 0.20);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, viewport(), startX, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(80)))
                .addAction(finger.createPointerMove(Duration.ofMillis(450), viewport(), endX, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

    protected void swipeBackEdge() {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "right");
        args.put("velocity", 2500); // можно 1500..5000
        // iOS edge swipe — важно начать почти у левого края
        // если driver поддерживает "region", используем маленькую область слева
        Map<String, Object> region = new HashMap<>();
        region.put("x", 0);
        region.put("y", 200);
        region.put("width", 30);
        region.put("height", 400);
        args.put("region", region);

        ((JavascriptExecutor) driver).executeScript("mobile: swipe", args);
    }

    protected void iosEdgeBackDrag(int fromY) {
        int fromX = 0;
        int toX = 320;

        ((JavascriptExecutor) driver).executeScript(
                "mobile: dragFromToForDuration",
                Map.of(
                        "fromX", fromX,
                        "fromY", fromY,
                        "toX", toX,
                        "toY", fromY,
                        "duration", 0.8
                )
        );
    }

    protected void iosEdgeBackDrag() {
        int height = driver.manage().window().getSize().height;
        int fromY = (int) (height * 0.35);
        iosEdgeBackDrag(fromY);
    }

    protected void dragElementToElement(WebElement from, WebElement to) {
        var fromRect = from.getRect();
        int startX = fromRect.getX() + fromRect.getWidth() / 2;
        int startY = fromRect.getY() + fromRect.getHeight() / 2;

        var toRect = to.getRect();
        int endX = toRect.getX() + toRect.getWidth() / 2;
        int endY = toRect.getY() + toRect.getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(finger, 0);

        drag.addAction(finger.createPointerMove(Duration.ZERO, viewport(), startX, startY));
        drag.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        drag.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(400)));
        drag.addAction(finger.createPointerMove(Duration.ofMillis(800), viewport(), endX, endY));
        drag.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(200)));
        drag.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(drag));
    }


    protected void swipeLeftOnElement(WebElement element) {
        Rectangle r = element.getRect();

        int startX = r.getX() + (int)(r.getWidth() * 0.85);
        int endX   = r.getX() + (int)(r.getWidth() * 0.15);
        int y      = r.getY() + r.getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(300), viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }

}

