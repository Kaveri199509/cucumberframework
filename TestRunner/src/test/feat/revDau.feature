@Dashboard @Desktop
Feature: RevDau dashboard functionality

  @Home1
  Scenario: Validation of RevDau title
    Then I check the title "RevDau - Accelerating Digital Transformation"

  @Home2
   Scenario: Checking the logo of RevDau
    Then I check RevDau logo is present in home page

  @about_Us1
   Scenario: validation of RevDau About section
     When I click on about section
     Then I check the title "RevDau - Accelerating Digital Transformation | About Us"

   @about_us2
    Scenario: Validation of RevDau section text
      When I click on about section
     Then Validating the Why RevDau section text- "How we partner in your digital journey."