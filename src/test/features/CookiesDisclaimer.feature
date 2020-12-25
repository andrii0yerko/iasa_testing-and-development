Feature: Cookies notification

  @1
  Scenario: Notify the user about cookies
    Given user opens site for the first time
    When page is loaded
    Then notification about cookies should be displayed

  Scenario: User accepts cookies
    Given notification about cookies is visible
    When I click Accept
    Then notification should disappear