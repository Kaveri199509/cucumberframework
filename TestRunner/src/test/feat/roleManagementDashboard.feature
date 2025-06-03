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

    Scenario: Total roles validation on Role Management Dashboard
    Then the user should see the total Roles on role Management dashboard

  @failed1
  Scenario: Edit role button should be disable
    Then edit role button should be disable
