@Tata01 @Desktop
Feature: 01 functionality

  @login
  Scenario:  feature
    When I entered "jsnow" and "Tata@123"
    Then I checked in the remember me check box.
    Then I click on Sign In button.
    Then I check Tata logo is present in login page "tata-login.PNG"
    Then Title of tata home page "Tata Communications Ltd."


#  @dashboard1
#  Scenario: Validation of total number of devices
#    When I get the total number of devices from dashboard
#    Then Total number of devices should be "197"
#
#  Scenario: Validation of total number of SNMP devices
#    When I get the total number of devices SNMP from dashboard
#    Then Total number of devices should be "190"
#
#  Scenario: Validation of total number of flow devices
#    When I get the total number of flow devices from dashboard
#    Then Total number of devices should be "195"
#
#  Scenario: Validation of NetFLow, SNPM and Total
#    When I get the total number of Netflow
#    Then Total number of devices should be "2"
#    When I get the SNMP
#    Then Total number of SNMP should be "1".
#    When I get the Total
#    Then Total number should be "3/10"
#
#
#  @table
# Scenario Outline: Verify the table1 header and row data
#    Given I am on the table number <table number>
#    Then I should see a table <table number>
#    When I check the table section
#    Then I should see table name with date time <table number> "dd/MM/yyyy HH:mm"
#    When I check the table header
#    Then the table header should contain the following columns <table number>:
#      | Device    |
#      | Interface |
#      | Direction |
#      | Today     |
#      |      %    |
#    When I get the total number of row
#    Then the number of row should <table number> be 10
#    When i get the total number of column
#    Then the number of column should <table number> be 40
#    When I check the table row data
#    Then at least one row of data should be present in the table <table number>
#    Examples:
#      | table number|
#        | 1 |
##        | 2 |
##        | 3  |
##        | 4  |

