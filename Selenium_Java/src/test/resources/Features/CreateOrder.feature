@Smoke
Feature: Create End order
@Smoke1, @Reg1
  Scenario Outline: Create Order Test
    Given User is on the homepage
    Then the user clicks on the LogIn option
    And enters <email> and <Password> in the LogIn section
    Then the user should be login
    And add to cart <product1> and <product2> and <product3>
    When items in card <product1> and <product2> and <product3>
    Then user continues to check out
    And addess information
    When user enters payment
    Then user completes the order

    Examples: 
      | email              | Password | product1   | product2   | product3         |
      | Testing10@test.com | Testing1 | Men Tshirt | Men Tshirt | Summer White Top |
