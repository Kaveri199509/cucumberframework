@Desktop
Feature:  Role management validation
  Background: Validation of login into EmployeePortal
    When the user click on Microsoft Login button.
    When the user login as "Admin"
    And the user click next button
    When the user entered password
    And the user click SignIn button
    And the user Checked in stay sign In checkbox
    When the user clicked on no button
    And the user Clicked on the Role Management Component

  Scenario: validation of search Api
    When user search the role name "super admin"
    When user select the role Manager
    Then super admin have the given permissions: