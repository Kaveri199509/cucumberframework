@assured @AllMobile
Feature: rest assured
  @get
  Scenario Outline:  Validation of RevDau about section  to check get response
    When  I send get request for about section with path Url "components-pages-about-about-module-ngfactory.js"
    Then  response should be <status>
    Examples:
            |status|
            | 200  |




#   @post
#    Scenario Outline: : Validation of RevDau  Quote section form submit for post response
#      Given I fill get Quote form for post method <name> and <email> and <mobile> and <message>
#     Examples:
#          | name     | email             | mobile       | message   |
#          |  "test"  | "test@revdau.com" | "1111111111" | "Testing" |
