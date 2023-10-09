 @employee
Feature: Employee table operation
  @Create
  Scenario: Insert the data into employee table
    Given I have the data from employee.csv file
    When  I insert the data Into the employee table
    Then  I verify data should be inserted into the table

  @Read
  Scenario: retrieve data from  employee table
    When I retrieve data from the employee table
    Then data should match with employee.csv file

  @Update
  Scenario: Updating data in a database table
    Given I want to update data in the table employee where "deptId" is 2
    When I update the data with the following value
      | empName |  empSalary     |
      |  abcd   |   40000.00     |
    Then Data should be updated

  @Delete
  Scenario: Deleting data from a table
    When I delete the data from the table using column
      | deptId   |
      |   1      |
    Then the data should be deleted successfully




