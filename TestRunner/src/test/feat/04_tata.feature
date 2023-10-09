@Tata @Desktop
Feature: 04 functionality

  @04Feature
  Scenario: 04 feature
    When I entered "jsnow" and "Tata@123"
    Then I checked in the remember me check box.
    Then I click on Sign In button.
    When I get the total number of flow devices from dashboard
    Then Total number of devices should be "195"