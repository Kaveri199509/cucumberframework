@Desktop
Feature: Policies validation
  Background: Validation of login into EmployeePortal
    When the user click on Microsoft Login button.
    When the user login as "Admin"
    And the user click next button
    When the user entered password
    And the user click SignIn button
    And the user Checked in stay sign In checkbox
    When the user clicked on no button
    And the user Clicked on the Policies Component

  @NewPolicy
  Scenario: Adding new policies
    When user click on the Add policy button
    And  user chose the file "C:\\Users\\lenovo\\Downloads\\Coding Excercses.pdf" to add as policy
    When user enter "Test" as new policy name
    And  user click on the Add policy button on the popPup
    Then policy "Test" should be added


  Scenario: validation of Edit Policy
    When user click on the Edit Policy icon
    And  user chose the file "C:\\Users\\lenovo\\Downloads\\Relay_Schema.pdf" to edit as policy
    When user enter "Relay Schema" as edited policy name
    And  user click on the edit policy button on the popPup
    Then policy "Relay Schema" should be added

  Scenario: validation of total added policies
    Then Validate the total added role in policies dashboard

  Scenario: Check for "view" and "edit" SVG elements in all tables
    Then user inspect all Svg icon in each row of the table policies dashboard

