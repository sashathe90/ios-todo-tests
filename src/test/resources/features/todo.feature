Feature: Manage To-Do tasks

  Background:
    Given the app is launched

  @Smoke
  Scenario: User sees main screen
    Then the main screen is displayed

  @AddItem
  Scenario: User adds a new item
    When user taps the ADD button
    Then ADD AN ITEM page is open
    When user taps the BACK button
    Then the main screen is displayed
    When user taps the ADD button
    Then ADD AN ITEM page is open
    When user swipes back
    Then the main screen is displayed
    When user taps the ADD SOMETHING button
    Then ADD AN ITEM page is open
    When user taps the SAVE button with an empty item field
    Then info message is displayed
    When user taps the CANCEL button
    Then ADD AN ITEM page is open
    When user types a first item in the TYPE SOMETHING HERE field
    And user taps the SAVE button
    Then the main screen is displayed
    And user sees the added first item
    When user taps the ADD button
    Then ADD AN ITEM page is open
    When user types a second item in the TYPE SOMETHING HERE field
    And user taps the SAVE button
    Then the main screen is displayed
    And user sees the added second item
    When user taps the ADD button
    Then ADD AN ITEM page is open
    When user types a third item in the TYPE SOMETHING HERE field
    And user taps the SAVE button
    Then the main screen is displayed
    And user sees the added third item

  @EditItem
  Scenario: User edit an items
    When user selects the first item
    Then first item marked with a check mark as completed
    When user selects the first item
    Then first item marked with a check mark is removed
    When user taps the EDIT button
    Then EDIT page is open
    When user taps the DONE button
    Then the main screen is displayed
    When user taps the EDIT button
    Then EDIT page is open
    When user taps the first item MINUS CIRCLE button
    And user taps the DELETE button
    Then item with title "First Item" is deleted
    When user moves Second Item below Third Item
    Then Second Item is below Third Item
    When user taps the DONE button
    Then the main screen is displayed
    When user moves Third Item below Second Item
    Then Third Item is below Second Item
    When user swipes left on item "Second Item"
    And user taps the DELETE button
    Then item with title "Second Item" is deleted
    When user swipes left on item "Third Item"
    And user taps the DELETE button
    Then item with title "Third Item" is deleted
    And the main screen is displayed

  @DemoFail
  Scenario: Demo failed test for Allure
    Then element "This screen does not exist" is visible






