@MongoDB
Feature: Perform all the crud operation in mongo db
    Scenario: Insert operation
      When I want to insert data from employee.csv file
      Then I verify all the data inserted in backend

    Scenario: Read Operation
      When I want to read all the documents from employee.csv file
      Then I verify all the data selected from backend

  Scenario: Update Operation
    When I want to update the empSalary for empId "2"
    |empSalary | deptId |
    | 100.00 | 3 |
    Then I want to verify the data updated

  Scenario: Delete operation
    When  I want to delete the documents
    |empName| empId |
    | Sarah Adams  | 33 |
    | Ryan Anderson | 44 |
    Then I want to verfiy if the delete is deleted from backend
