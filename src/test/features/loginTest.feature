Feature: Login Feature
  As a user
  I login and use

  @loginWithValid
  Scenario: Verify user login with valid credentials
    Given I'm on home page in browser "http://www.next.co.uk"
    When I click on MyAccount Link
    When I enter username "rosm3130@yahoo.co.in"
    When I enter password "rose1234"
    When I click on SignIn button
    Then I should login successfully with re-direction to profile page