package com.sashathe.steps;

import com.sashathe.hooks.Hooks;
import com.sashathe.pages.TodoMainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {

    private final TodoMainPage page = new TodoMainPage(Hooks.driver);

    @Given("the app is launched")
    public void theAppIsLaunched() {
    }

    @Then("the main screen is displayed")
    public void theMainScreenIsDisplayed() {
        page.verifyMainPage();
    }

    @When("^user taps the ADD button$")
    public void user_taps_the_ADD_button() {
        page.tapAddButton();
    }

    @Then("^ADD AN ITEM page is open$")
    public void ADD_AN_ITEM_page_is_open() {
        page.verifyAddItemPage();
    }

    @When("^user taps the BACK button$")
    public void user_taps_the_back_button() {
        page.tapBackButton();
    }

    @When("user swipes back")
    public void user_swipes_back() {
        page.swipeBackToMain();
    }

    @When("^user taps the ADD SOMETHING button$")
    public void user_taps_the_ADD_SOMETHING_button() {
        page.tapAddSomethingButton();
    }

    @When("^user taps the SAVE button with an empty item field$")
    public void user_taps_the_SAVE_button_with_an_empty_item_field() {
        page.tapEmptySaveButton();
    }

    @Then("^info message is displayed$")
    public void info_message_is_displayed() {
        page.verifyInfoMessage();
    }

    @When("^user taps the CANCEL button$")
    public void user_taps_the_CANCEL_button() {
        page.tapCancelButton();
    }

    @When("^user types a first item in the TYPE SOMETHING HERE field$")
    public void user_types_a_first_item_in_the_TYPE_SOMETHING_HERE_field() {
        page.typeFirstItem("First Item");
    }

    @When("^user taps the SAVE button$")
    public void user_taps_the_SAVE_button() {
        page.tapSaveButton();
    }

    @Then("^user sees the added first item$")
    public void user_sees_the_added_first_item() {
        page.verifyAddedFirstItem();
    }

    @When("^user types a second item in the TYPE SOMETHING HERE field$")
    public void user_types_a_second_item_in_the_TYPE_SOMETHING_HERE_field() {
        page.typeSecondItem("Second Item");
    }

    @Then("^user sees the added second item$")
    public void user_sees_the_added_second_item() {
        page.verifyAddedSecondItem();
    }

    @When("^user types a third item in the TYPE SOMETHING HERE field$")
    public void user_types_a_third_item_in_the_TYPE_SOMETHING_HERE_field() {
        page.typeThirdItem("Third Item");
    }

    @Then("^user sees the added third item$")
    public void user_sees_the_added_third_item() {
        page.verifyAddedThirdItem();
    }

    @When("^user selects the first item$")
    public void user_selects_the_first_item() {
        page.selectFirstItem();
    }

    @Then("^first item marked with a check mark as completed$")
    public void first_item_marked_with_a_check_mark_as_completed() {
        page.verifyfirstItemMarkedCompleted();
    }

    @Then("^first item marked with a check mark is removed$")
    public void first_item_marked_with_a_check_mark_is_removed() {
        page.verifyfirstItemMarkedRemoved();
    }


    @When("^user taps the EDIT button$")
    public void user_taps_the_EDIT_button() {
        page.tapEditButton();
    }

    @Then("^EDIT page is open$")
    public void EDIT_page_is_open() {
        page.verifyEditPage();
    }

    @When("^user taps the DONE button$")
    public void user_taps_the_DONE_button() {
        page.tapDoneButton();
    }

    @When("^user taps the first item MINUS CIRCLE button$")
    public void user_taps_the_first_item_MINUS_CIRCLE_button() {
        page.tapMinusCircleButton();
    }

    @When("^user taps the DELETE button$")
    public void user_taps_the_DELETE_button() {
        page.tapDeleteButton();
    }

    @Then("^item with title \"([^\"]*)\" is deleted$")
    public void item_with_title_is_deleted(String title) {
        page.verifyItemIsDeleted(title);
    }

    @When("user moves Second Item below Third Item")
    public void move_second_below_third() {
        page.moveSecondBelowThird();
    }

    @Then("Second Item is below Third Item")
    public void verify_order() {
        page.verifySecondIsBelowThird();
    }

    @When("user moves Third Item below Second Item")
    public void move_third_below_second() {
        page.moveThirdBelowSecond();
    }

    @Then("Third Item is below Second Item")
    public void verify_third_below_second() {
        page.verifyThirdIsBelowSecond();
    }

    @When("user swipes left on item {string}")
    public void user_swipes_left_on_item(String title) {
        page.swipeLeftOnItem(title);
    }

    @Then("element {string} is visible")
    public void element_is_visible(String text) {
        page.verifyTextVisible(text);
    }

}


