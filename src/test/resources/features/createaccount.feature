Feature: Create Account for UO Website

  As a user I want to navigate to Create account for the UO website
  I want to fill required details
  So that I can verify the login account functionality

  Background:
    Given I am able to navigate to create account page

  @account @Ignore
  Scenario: Successful login with valid credentials
    Given Fill all the required details
    When I click on create account button
    Then I should able to create an account successfully

  @account @Run
  Scenario Outline: Verify user is unable to create account with invalid input
    Given I fill in the registration form with "<firstName>", "<lastName>", "<email>", "<password>"
    When I click on create account button
    Then I should see validation errors and not be allowed to create account
    @id(01)
    Examples:
      | firstName | lastName | email  | password |
      | 123       | 672      | 97341@ | 873      |