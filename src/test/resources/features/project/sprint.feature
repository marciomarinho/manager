Feature: Sprints

  Scenario: Remove a sprint
    Given I visit the projects list
    When I click view "Project1"
    And I click delete "Sprint1"
    Then I should not see "Sprint1" in the sprints list