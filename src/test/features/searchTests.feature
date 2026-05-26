Feature: Login Feature Test []
  As a user
  I should get authenticated and use the application.

  Background: Pre- Condition
    Given I'm on home page "http://www.next.co.uk"

  @search @smoke @reg @searchByValid
  Scenario Outline: Verify search with product name

    When I enter searchTerm "<searchTerm>"
    And I click the searchButton
    Then I should get re-directed to search result page with relevant results and title  as "<searchResultHeading>"
    And I should see relevant products listed with name contains "<searchTerm>"

    Examples:
      | searchTerm | searchResultHeading |
      | Jeans      | Jeans               |
      | Nike       | Nike                |


  @search @reg @searchByInvalid
  Scenario: Verify search with product name

    When I enter searchTerm "Yogurt"
    And I click the searchButton
    Then I should get re-directed to search result page with message as "No results found"

