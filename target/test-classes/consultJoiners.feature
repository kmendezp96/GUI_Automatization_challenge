Feature: Consult Joiners
  As an Onboarding manager
  I want to see the joiners list
  So that It can see all created joiner

  Background:
    Given I am already logged with email: "admin@endava.com" and password "admin"
    And i am on the Joiner Manager interface
    And there are joiners created


  Scenario Outline: Filter joiner
    When I enter "<characters>" in the search field
    Then I should see a list of the joiners that include those specific "<characters>" in their names
    Examples:
    | characters  |
    | Fab         |
    #| Fab         |
    #| andres algo |

  Scenario Outline: Access to view a Joiners’ details
    When I choose the joiners "<name>"
    Then I should see the interface with the Joiners’ information
    Examples:
      | name          |
      | Fabi          |
     # | Luis 2        |

  Scenario: Remove Filter joiner
    And a filter of Joiners using "andre"  was made
    When I choose clear option
    Then I should see the list of all existing Joiners included "Maria"
