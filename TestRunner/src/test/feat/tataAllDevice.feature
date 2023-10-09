@AllDevice @Desktop
Feature: Dashboard functionality

  Background: Validation of login into tata
    When I entered "jsnow" and "Tata@123"
    Then I checked in the remember me check box.
    Then I click on Sign In button.

  Scenario Outline: Validation of all device dashboard page
    Given I click on the total device div
    Then I got redirected to the total device dashboard page
    When I selected the <Values> from show entries dropdown
    Then the total number rows should be <row-size>
    Then I check the table header name :
      | Device name    |
      | Custom name    |
      | IP Address     |
      | FLOW Service   |
      | SNMP Service   |
      | Actions        |
    Then I check if the columns of table contains data
    When I search for "<keyword>"
    Then I should see search results for "<keyword>"
    When I click on download pdf
    Then I can see excel file got downloaded.
    Examples:
      | Values |  row-size |keyword|
      | 10    | 10 | 101 |
      | 25    | 25 | Dis |
      |  50   | 50 | EAS |
      |  100  | 100 | TAZ|
