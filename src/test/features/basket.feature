Feature: Basket Feature
  As a user
  add items

  @loginWithValid
  Scenario: Add items to basket
    Given I'm on home page in browser "http://www.next.co.uk"
    When I click basket
    Then I should login successfully with re-direction to profile page