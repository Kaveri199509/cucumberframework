@Desktop
Feature:  Role management validation
  Background: Validation of login into EmployeePortal
    When the user click on Microsoft Login button.
    When the user login as "Admin"
    And the user click next button
    When the user entered password
    And the user click SignIn button
    And the user Checked in stay sign In checkbox
    When the user clicked on no button
    And the user Clicked on the Role Management Component
    And the user Clicked on the  add Role button
    @NewRole
    Scenario: Adding New role validation
      When user enter role name "Manager"
      And  user sets the following module permissions:
        | Module                                  | Permissions |
        | Employee Management                     | View        |
        | Regularization Management               | Add         |
        | Role Management                         | Update      |
        | Attendance                              | Download    |
        | Timesheet                               |  Upload     |
        | Leave Management                        |  Upload     |
        | Report                                  | View, Download |
        | Holiday                                 | View, Add, Update, Download |
        | Policy                                  | View, Add, Update |
        | FAQ                                     | View, Add, Update, Download, Upload |
      And user click on Submit Form Button
      When user search the role name "Manager"
      When user select the role Manager
      Then manager have the following permissions:
        | Module                                  | Permissions |
        | Employee Management                     | View        |
        | Regularization Management               | Add         |
        | Role Management                         | Update      |
        | Attendance                              | Download    |
        | Timesheet                               |  Upload     |
        | Leave Management                        |  Upload     |
        | Report                                  | View, Download |
        | Holiday                                 | View, Add, Update, Download |
        | Policy                                  | View, Add, Update |
        | FAQ                                     | View, Add, Update, Download, Upload |

  @Failed
  Scenario: Adding New role without giving any permissions
    When user enter role name "Director"
    And  user doesn't provide any module permissions:
    Then Submit Form Button should be disabled

