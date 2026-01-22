package com.sashathe.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class TodoMainPage extends BasePage {

    public TodoMainPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'ToDo List 📝'")
    private WebElement pageTitle;

    public TodoMainPage verifyMainPage() {
        waitForVisibility(pageTitle);
        assertTrue(pageTitle.isDisplayed(), "Main page is not open!");
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Add' AND label == 'Add'")
    private WebElement addButton;

    public TodoMainPage tapAddButton() {
        click(addButton);
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Add an Item \uD83D\uDD8B\uFE0F'")
    private WebElement addItemTitleField;

    public TodoMainPage verifyAddItemPage() {
        waitForVisibility(addItemTitleField);
        assertTrue(addItemTitleField.isDisplayed(), "Add An Item page is not open!");
        return this;
    }

    @iOSXCUITFindBy(accessibility = "ToDo List \uD83D\uDCDD")
    private WebElement backButton;

    public TodoMainPage tapBackButton() {
        click(backButton);
        return this;
    }

    public TodoMainPage swipeBackToMain() {
        iosEdgeBackDrag();
        return this;
    }

    @iOSXCUITFindBy(accessibility = "Add Something \uD83E\uDD73")
    private WebElement addSomethingButton;

    public TodoMainPage tapAddSomethingButton() {
        click(addSomethingButton);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "SAVE")
    private WebElement emptySaveButton;

    public TodoMainPage tapEmptySaveButton() {
        click(emptySaveButton);
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Your new todo item must be at least 3 characters long!'")
    private WebElement infoMessage;

    public TodoMainPage verifyInfoMessage() {
        waitForVisibility(infoMessage);
        assertTrue(infoMessage.isDisplayed(), "Info message not displayed!");
        return this;
    }

    @iOSXCUITFindBy(accessibility = "Cancel")
    private WebElement cancelButton;

    public TodoMainPage tapCancelButton() {
        click(cancelButton);
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Type something here...'")
    private WebElement titleFieldFirst;

    public TodoMainPage typeFirstItem(String title) {
        titleFieldFirst.clear();
        titleFieldFirst.sendKeys(title);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "SAVE")
    private WebElement saveButton;

    public TodoMainPage tapSaveButton() {
        click(saveButton);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "First Item")
    private WebElement addedFirstItem;

    public TodoMainPage verifyAddedFirstItem() {
        waitForVisibility(addedFirstItem);
        assertTrue(addedFirstItem.isDisplayed(), "Item is not added!");
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Type something here...'")
    private WebElement titleFieldSecond;

    public TodoMainPage typeSecondItem(String title) {
        titleFieldSecond.clear();
        titleFieldSecond.sendKeys(title);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "Second Item")
    private WebElement addedSecondItem;

    public TodoMainPage verifyAddedSecondItem() {
        waitForVisibility(addedSecondItem);
        assertTrue(addedSecondItem.isDisplayed(), "Item is not added!");
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Type something here...'")
    private WebElement titleFieldThird;

    public TodoMainPage typeThirdItem(String title) {
        titleFieldThird.clear();
        titleFieldThird.sendKeys(title);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "Third Item")
    private WebElement addedThirdItem;

    public TodoMainPage verifyAddedThirdItem() {
        waitForVisibility(addedThirdItem);
        assertTrue(addedThirdItem.isDisplayed(), "Item is not added!");
        return this;
    }

    @iOSXCUITFindBy(accessibility = "First Item")
    private WebElement firstItemSelect;

    public TodoMainPage selectFirstItem() {
        click(firstItemSelect);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "checkmark.circle")
    private WebElement firstItemMarkedCompleted;

    public TodoMainPage verifyfirstItemMarkedCompleted() {
        waitForVisibility(firstItemMarkedCompleted);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "circle")
    private WebElement firstItemMarkedRemoved;

    public TodoMainPage verifyfirstItemMarkedRemoved() {
        waitForVisibility(firstItemMarkedRemoved);
        return this;
    }


    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Edit' AND label == 'Edit'")
    private WebElement editButton;

    public TodoMainPage tapEditButton() {
        click(editButton);
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Done' AND label == 'Done'")
    private WebElement EditTitleField;

    public TodoMainPage verifyEditPage() {
        waitForVisibility(EditTitleField);
        return this;
    }

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Done' AND label == 'Done'")
    private WebElement doneButton;

    public TodoMainPage tapDoneButton() {
        click(doneButton);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "minus.circle.fill")
    private WebElement minusCircleButton;

    public TodoMainPage tapMinusCircleButton() {
        click(minusCircleButton);
        return this;
    }

    @iOSXCUITFindBy(accessibility = "Delete")
    private WebElement deleteButton;

    public TodoMainPage tapDeleteButton() {
        click(deleteButton);
        return this;
    }

    private By itemByTitle(String title) {
        return AppiumBy.iOSNsPredicateString(
                "type == 'XCUIElementTypeStaticText' AND name == '" + title + "'"
        );
    }

    public TodoMainPage verifyItemIsDeleted(String title) {
        boolean isAbsent = driver.findElements(itemByTitle(title)).isEmpty();

        assertTrue(
                isAbsent,
                "Item with title '" + title + "' is still present on screen!"
        );
        return this;
    }

    //

    // ---------- helpers ----------

    // Cell по тексту айтема
    private WebElement cellByTitle(String title) {
        return driver.findElement(
                AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"" + title + "\"]/ancestor::XCUIElementTypeCell[1]")
        );
    }

    // Drag-handle (твоя кнопка) внутри конкретной cell:
    // XCUIElementTypeImage name="line.horizontal.3" label="drag"
    private WebElement dragHandleInCell(String title) {
        WebElement cell = cellByTitle(title);

        // Вариант 1 (точно по твоему элементу):
        return cell.findElement(
                AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeImage' AND name == 'line.horizontal.3' AND label == 'drag'")
        );

        // Если вдруг label иногда меняется — можно ослабить:
        // return cell.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeImage' AND name == 'line.horizontal.3'"));
    }

    private List<String> getVisibleItemTitles() {
        List<WebElement> cells = driver.findElements(AppiumBy.className("XCUIElementTypeCell"));
        List<String> titles = new ArrayList<>();

        for (WebElement cell : cells) {
            List<WebElement> texts = cell.findElements(AppiumBy.className("XCUIElementTypeStaticText"));
            if (!texts.isEmpty()) {
                String t = texts.get(0).getAttribute("name");
                if (t != null && !t.isBlank()) titles.add(t);
            }
        }
        return titles;
    }

    // ---------- actions ----------

    public TodoMainPage moveSecondBelowThird() {
        return moveItemBelow("Second Item", "Third Item");
    }

    public TodoMainPage moveItemBelow(String movingTitle, String targetTitle) {
        WebElement handle = dragHandleInCell(movingTitle);
        WebElement targetCell = cellByTitle(targetTitle);

        // тянем handle к target cell
        dragElementToElement(handle, targetCell);

        return this;
    }

    // ---------- asserts ----------

    public TodoMainPage verifySecondIsBelowThird() {
        return verifyItemIsBelow("Second Item", "Third Item");
    }

    public TodoMainPage verifyItemIsBelow(String belowTitle, String aboveTitle) {
        List<String> titles = getVisibleItemTitles();

        int belowIndex = titles.indexOf(belowTitle);
        int aboveIndex = titles.indexOf(aboveTitle);

        assertTrue(aboveIndex >= 0, "Item not found: " + aboveTitle + " | titles=" + titles);
        assertTrue(belowIndex >= 0, "Item not found: " + belowTitle + " | titles=" + titles);

        assertTrue(belowIndex > aboveIndex,
                "Expected '" + belowTitle + "' to be below '" + aboveTitle + "', but order is: " + titles);

        return this;
    }


    // ===== LOCATORS =====

    private WebElement secondItem() {
        return driver.findElement(AppiumBy.accessibilityId("Second Item"));
    }

    private WebElement thirdItem() {
        return driver.findElement(AppiumBy.accessibilityId("Third Item"));
    }

    // ===== ACTIONS =====

    public TodoMainPage moveThirdBelowSecond() {
        dragElementToElement(thirdItem(), secondItem());
        return this;
    }

    // ===== VERIFICATIONS =====

    public TodoMainPage verifyThirdIsBelowSecond() {
        int thirdY  = thirdItem().getRect().getY();
        int secondY = secondItem().getRect().getY();

        assertTrue(
                thirdY > secondY,
                "Expected 'Third Item' to be BELOW 'Second Item' " +
                        "(thirdY=" + thirdY + ", secondY=" + secondY + ")"
        );

        return this;
    }

    private By itemTitleBy(String title) {
        return AppiumBy.accessibilityId(title);
    }

    private WebElement itemTitle(String title) {
        WebElement el = driver.findElement(itemTitleBy(title));
        waitForVisibility(el);
        return el;
    }

    public TodoMainPage swipeLeftOnItem(String title) {
        swipeLeftOnElement(itemTitle(title));
        return this;
    }

    public TodoMainPage verifyTextVisible(String text) {
        By locator = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name == '" + text + "'");
        boolean present = !driver.findElements(locator).isEmpty();
        org.testng.Assert.assertTrue(present, "Expected text to be visible, but it is not: " + text);
        return this;
    }

}
