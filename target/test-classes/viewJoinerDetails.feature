Feature: Consult Joiners
  As an Onboarding manager
  I want to view the details of a specific joiner
  So that It can confirm the joiner was created properly

  Background:
    Given I am logged with email: "admin@endava.com" and password "admin"
    And the joiner "Fabian" is created
    And i am on the view joiner details interface of "Fabian"



  Scenario: Go back to joiner manager interface
    When I select the Close option
    Then I should see the Joiner Manager interface

  Scenario: No tasks
    When the Joiner does not have any assigned task
    Then I should see the message "There are no tasks assigned yet" instead of accordion task
    And It does not appear the accordion´s tasks

