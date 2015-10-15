Feature: Projects

  Scenario: Add a new project
    Given I visit the add projects page
    When I enter the fields :
      | Name        | BDD Master                                                            |
      | Description | BDD Application using Spring Boot, MVC, Data, Thymeleaf and AngularJS |
    And I submit the form
    Then I should see "BDD Master" in the projects list