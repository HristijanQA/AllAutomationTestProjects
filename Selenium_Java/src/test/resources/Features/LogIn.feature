@Reg
Feature: Feature to test login functionality

  @Reg1
  Scenario Outline: Create account
    Given User is on the home page
    And click on the Log in button
    When enters <name> and <email> in the New User Signup
    And clicks on Sigup button
    When user is on account information
    And populates <Title>
    And populatesP <Password>
    And populatesD <Day>
    And populatesM <Month>
    And populatesY <Year>
    And populatesF <FirstName>
    And populatesL <LastName>
    And populatesA <Address>
    And populatesC <Contry>
    And populatesS <State>
    And populatesCi <City>
    And populatesZ <Zipcode>
    And populatesMob <Mobile>
    And click on create account
    Then user account should be created

    Examples: 
      | name        | email              | Title | Password | Day | Month | Year | FirstName | LastName | Address | Contry | State | City | Zipcode | Mobile |
      | TesterProba | Testing21@test.com | Male  | Testing1 |   5 | A     | 1995 | Testing12 | Tester12 | Domasna | Canada | Kinaa | Bito | 7000000 | 080416 |

  @Reg2
  Scenario Outline: Create Order Test
    Given User is on the homepage
    Then the user clicks on the LogIn option
    And enters <email> and <Password> in the LogIn section
    Then the user should be login
    And add to cart <product1> and <product2> and <product3>
    When items in card <product1> and <product2> and <product3>
    Then user continues to check out
    And addess information
    And user completes the order
    And user enters <CardName> <CardNumber> <CardCVC> <CardM> <CardY>
    Then order is completed

    Examples: 
      | email              | Password | product1 | product2         | product3         | CardName | CardNumber | CardCVC | CardM | CardY |
      | Testing17@test.com | Testing1 | Blue Top | Sleeveless Dress | Summer White Top | 13413452 | Testing123 |     123 |    12 |  2025 |
