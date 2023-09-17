Feature: login

  Scenario: login should be working
    Given I launch chrome browser
    When I open login page
    Then I enter username and password
    And sucessfully login
#    Examples:
#      | username | password |
#      | superadmin     | superadmin     |

#
#    Examples:
#      | username  | password   |
#      | superadmin | superadmin |
