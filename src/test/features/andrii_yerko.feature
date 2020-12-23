
Feature: Site works!
  I suppose that this file is not pretty good example of feature-rule
  section separation, because in case of real test each of my rules
  should become a feature section in its own .feature file
  with more test cases and its own (business) rules.
  Despite this, I think that grouping like that is okay for this introductory lab.

  # 1, 2, 3
  Rule: Header behavior

    Scenario: User clicks on logo
      Given I am on the main page
      When I click on logo
      Then I should be redirected to the main page

#    Scenario: Using dropdown menus
#      Given header is displayed
#      When I point cursor on the {} section and drop-down menu is available for it
#      Then drop-down menu should appear

# I decide to write another scenario to avoid testing adaptive gui testing which requires
# much more scenarios at all

    Scenario: User searches for contact
      Given header is displayed
      When I click on contact us buttont
      Then I should be redirected to Contact Us page

    Scenario Outline: User changes language or region
      Given Region panel is open
      When I click on <region> region
      Then I should be redirected to the <region_page> region page
      Examples:
        | region  | region_page              |
        | Ukraine | https://careers.epam.ua/ |
        | Global  | https://www.epam.com/    |
        | India   | https://welcome.epam.in/ |
        # ...       ...

  # 4, 5, 6
  Rule: Search behavior

    Background:
      Given search drop-down panel is open

    Scenario: Suggest frequent searches
      Given input is empty
      When cursor is placed in input field
#      Then hint text should display
      And frequent searches menu should be displayed

    Scenario: User writes a search query
      Given cursor is placed in input field
      And input is empty
      When I write something
      Then frequent searches menu should disappear

    Scenario: User removes cursor
      Given frequent searches menu is shown
      When I remove the cursor from the input field
      Then frequent searches menu should disappear

  # 7, 8
  Rule: Cookies notification

    Scenario: Notify the user about cookies
      Given user opens site
      And cookies are not accepted
      When page is loaded
      Then notification about cookies should be displayed

    Scenario: User accepts cookies
      Given notification about cookies is visible
      When I click Accept
      Then notification should disappear