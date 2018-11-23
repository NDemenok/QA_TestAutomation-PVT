Feature: Test main page

  Scenario: Test positive search hotels
    Given I am on main application page
    When I input city
    And I choose date
    And Input information about guests
    And I click search button
    Then I see order with hotel offers
    When I push field filter by feedbacks
    And I go by first link
    Then I check hotel rating more than 9
    