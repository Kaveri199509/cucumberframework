 @department
Feature: Employee table operation
  @Create
  Scenario: Insert the data into department table
    Given I have the data from department.csv file
    When  I insert the data Into the department table
    Then  I verify Data should be inserted into the table

  @Read
  Scenario: retrieve data from  department table
    When I retrieve data from the department table
    Then data should match with department.csv file

  @Update
  Scenario: Updating data in a database table
    Given I want to update data in the table department where "deptId" is 2
    When I update the Data with the following value
        | deptName |
       |  Administration   |
    Then data should be updated

  @Delete
  Scenario: Deleting data from a table
    When I delete the Data from the table using column
      | deptId   |
      |   1    |
    Then data should be deleted successfully




