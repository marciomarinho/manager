Feature: Projects

  Scenario: Add a new project
    Given I visit the add projects page
    When I enter the fields :
      | Name        | BDD Master                                                            |
      | Description | BDD Application using Spring Boot, MVC, Data, Thymeleaf and AngularJS |
    And I submit the form
    Then I should see "BDD Master" in the projects list

  Scenario: Remove a project
    Given I visit the projects list
    When I click delete "Project4"
    Then I should not see "Project4" in the projects list

  Scenario: Edit a project
    Given I visit the projects list
    When I click edit "Project2"
    And I enter the fields :
      | Name        | Project 22                         |
      | Description | Changed to a project with steroids |
    And I submit the form
    Then I should see "Changed to a project with steroids" in the projects list