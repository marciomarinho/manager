Feature: Sprints

  Scenario: Add a new sprint
    Given I visit the projects list
    When I click view "Project1"
    And I click "Add new Sprint"
    When I enter the fields :
      | Name       | Sprint 1   |
      | Start Date | 01/05/2015 |
      | End Date   | 03/09/2015 |
    And I submit the form
    Then I should see "Sprint 1" in the sprints list

  Scenario: Remove a sprint
    Given I visit the projects list
    When I click view "Project1"
    And I click delete "Sprint1"
    Then I should not see "Sprint1" in the sprints list