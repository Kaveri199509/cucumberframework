 @Desktop
 Feature: Login functionality of Employee Portal
   @Login
Scenario: Validation of login into EmployeePortal
     When the user click on Microsoft Login button.
     When the user login as "Admin"
     And the user click next button
     When the user entered password
     And the user click SignIn button
     And the user Checked in stay sign In checkbox
     When the user clicked on no button
     Then Profile name "Rushikesh Shiledar" should be displayed on dashboard
