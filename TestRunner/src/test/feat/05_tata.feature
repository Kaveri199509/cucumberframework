@Tata @Desktop
Feature: 05 functionality

  @05Feature
  Scenario: 05 feature
    When I entered "jsnow" and "Tata@123"
    Then I checked in the remember me check box.
    Then I click on Sign In button.
    When I get the total number of Netflow
    Then Total number of devices should be "2"
    When I get the SNMP
    Then Total number of SNMP should be "1".
    When I get the Total
    Then Total number should be "3/10"