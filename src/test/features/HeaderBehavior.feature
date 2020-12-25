Feature: Header behavior

  Scenario: User clicks on logo
    Given I am on the Contact Us page
    When I click on logo
    Then I should be redirected to the Main page

#  Scenario: Using dropdown menus
#    Given header is displayed
#    When I point cursor on the {} section and drop-down menu is available for it
#    Then drop-down menu should appear

# I decide to write another scenario to avoid testing adaptive gui testing which requires
# much more scenarios at all

  Scenario: User searches for contact
    Given I am on the Main page
    When I click on contact us button
    Then I should be redirected to the Contact Us page

  Scenario Outline: User changes language or region
    Given Region panel is open
    When I click on <region> location
    Then I should be redirected to the <region_page> page
    Examples:
      | region  | region_page              |
      | Ukraine | https://careers.epam.ua/ |
      | Global  | https://www.epam.com/    |
      | India   | https://welcome.epam.in/ |
      # ...       ...
