@Desktop
Feature: Login functionality

  Background: Validation of login into tata
    When I entered "jsnow" and "Tata@123"
    Then I checked in the remember me check box.
    Then I click on Sign In button.

  @login
  Scenario: Validation of login logo
    Then I check Tata logo is present in login page "tata-login.PNG"
    Then Title of tata home page "Tata Communications Ltd."


  @dashboard1
  Scenario: Validation of total number of devices
    When I get the total number of devices from dashboard
    Then Total number of devices should be "197"

  @dashboard2
  Scenario: Validation of total number of SNMP devices
    When I get the total number of devices SNMP from dashboard
    Then Total number of devices should be "197"

  @dashboard3
  Scenario: Validation of total number of flow devices
    When I get the total number of flow devices from dashboard
    Then Total number of devices should be "195"

  @dashboard4
  Scenario: Validation of NetFLow, SNPM and Total
    When I get the total number of Netflow
    Then Total number of devices should be "2"
    When I get the SNMP
    Then Total number of SNMP should be "1".
    When I get the Total
    Then Total number should be "3/10"
