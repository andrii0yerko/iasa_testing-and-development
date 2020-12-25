Feature: Search behavior

  Background:
    Given search drop-down panel is open

  Scenario: Suggest frequent searches
    Given input is empty
    When cursor is placed in input field
    Then frequent searches menu should be displayed

  Scenario: User writes a search query
    Given input is empty
    And cursor is placed in input field
    When I write something
    Then frequent searches menu should disappear

  Scenario: User removes cursor
    Given frequent searches menu is shown
    When I remove the cursor from the input field
    Then frequent searches menu should disappear