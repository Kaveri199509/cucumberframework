@Dashboard @Desktop
Feature: Dashboard Navigation and Content

  Background: Validation of login into EmployeePortal
    When the user click on Microsoft Login button.
    When the user login as "Admin"
    And the user click next button
    When the user entered password
    And the user click SignIn button
    And the user Checked in stay sign In checkbox
    When the user clicked on no button

  Scenario Outline: Navbar Elements
    Then I should see the company logo in the navbar
    Then I should see the title of the application in the navbar
    Then I should see my profile image in the navbar
    Then I should see the "<component>" in the side drawer
    Examples:
      | component        |
      | Dashboard        |
      | Attendance       |
      | Timesheet        |
      | Leave Management |
      | Holiday Calendar |
      | Policies         |
      | FAQ              |

  Scenario Outline: Check if dashboard components are clickable
    When I click on the "<component>"
    Then I should check if the component are clickable
    Examples:
      | component        |
      | Dashboard        |
      | Attendance       |
      | Timesheet        |
      | Leave Management |
      | Holiday Calendar |
      | Policies         |
      | FAQ              |

  Scenario Outline: Check if icons are present for dashboard components
    Then I should see an icon for the "<component>" component
    Examples:
      | component        |
      | Dashboard        |
      | Attendance       |
      | Timesheet        |
      | Leave Management |
      | Holiday Calendar |
      | Policies         |
      | FAQ              |





