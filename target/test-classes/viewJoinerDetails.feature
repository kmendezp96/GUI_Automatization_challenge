Feature: Consult Joiners
  As an Onboarding manager
  I want to view the details of a specific joiner
  So that It can confirm the joiner was created properly

  Background:
    Given I am already logged with email: "admin@endava.com" and password "admin"
    And the joiner "Luis 2" is created
    And i am on the view joiner details interface of "Luis 2"



  Scenario: Go back to joiner manager interface
    When I select the Close option
    Then I should see the Joiner Manager interface

