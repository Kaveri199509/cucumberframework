@dashboardQuote @Desktop
Feature: RevDau Quote functionality
  Scenario Outline: Validation get Quote
    When I click on Get_Quote Section
    Then Get_Quote Section Text must be "Estimate For Your Projects."
    Given I entered <name> and <email> and <mobile> and <message>
    Then the output should be <output>
    Examples:
      | name      | email                   | mobile       | message   | output |
      | "test"  | "test@revdau.com" | "1111111111" | "Testing" | "Your message has been sent successfully, we will get back to you shortly." |
#     | "test1"  | "test1@revdau.com"| "2222222222" | "Testing" | "Your message has been sent successfully, we will get back to you shortly." |

