Feature: As an Onboarding manager
  I want to select an option on the following auto-populated fields at the creation joiner moment
  So that I am able to enter consistent information in those fields
  Background:
    Given I am already logged using email: "admin@endava.com" and password "admin"
    And i am on the create joiner interface

  Scenario Outline: Populate searching fields according to a selected discipline option
    When I select one "<discipline>"
    Then the fields: "<Line Manager>", "<Career Coach>" and "<Buddy>"have to be auto-populated with the belonged default value
    Examples:
    | discipline         | Line Manager  | Career Coach | Buddy           |
    | Testing            | Andrés Calle  | Gina Acosta  | Andrés Rincón   |
    | PDR                | Felipe Vila   | Raúl Fandino | Germán Valencia |
    | Project management | Luz Fernández | Angy Muñoz   | Víctor Mejía    |