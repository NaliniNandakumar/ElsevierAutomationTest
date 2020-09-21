Feature: Add summer dress to the cart
  As a customer I want to add the dress to cart
  and able to Sign in to the website

  @Test

  Scenario: Verify the process of adding summer dress to the cart
    Given I am on the home page
    And I navigate to the summer dresses page
    When I select a summer dress and add to cart
    And I see the summer dress in cart
    And I click proceed to checkout
    Then I should be on the authentication sigIn page

