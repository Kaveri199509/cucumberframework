@Tata @IPad
Feature: 03 functionality

  @03Feature
  Scenario: 03 feature
    When I entered "jsnow" and "Tata@123"
    Then I checked in the remember me check box.
    Then I click on Sign In button.
    When I get the total number of devices SNMP from dashboard
    Then Total number of devices should be "197"