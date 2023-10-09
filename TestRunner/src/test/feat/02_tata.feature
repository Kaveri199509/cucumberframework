@Tata @Desktop
Feature: 02 functionality

  @02Feature
  Scenario: 02 feature
    When I entered "jsnow" and "Tata@123"
    Then I checked in the remember me check box.
    Then I click on Sign In button.
    When I get the total number of devices from dashboard
    Then Total number of devices should be "197"
