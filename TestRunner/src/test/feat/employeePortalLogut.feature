@Desktop
Feature:Logout functionality of Employee Portal
  Background: Validation of login into EmployeePortal
    When the user click on Microsoft Login button.
    When the user login as "Admin"
    And the user click next button
    When the user entered password
    And the user click SignIn button
    And the user Checked in stay sign In checkbox
    When the user clicked on no button

  Scenario: Validation of dropdown view in EmployeePortal
    When the user click on Profile the dropdown appears
    When user click outside the profile
    Then user should see dropdown is closed


  Scenario: Validation of Logout into EmployeePortal
    When the user click on Profile
    When the user clicks the Logout button
    Then the user should be redirected to the login page

  Scenario: Validation of profile button into EmployeePortal
    When the user click on Profile
    When the user click on Profile button
    Then the user should see the profile page

