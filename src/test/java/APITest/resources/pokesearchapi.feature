Feature: To test pokesearch apis

  Scenario Outline: Test search api with valid input = <input>
    Given I am an authorized user
    When I search with "<input>"
    Then I should get 200 response code
    And I should get the list of related suggestions

    Examples:
    | input      |
    | tengela    |
    | pid        |

  Scenario Outline: Test search api with invalid input = <input>
    Given I am an authorized user
    When I search with "<input>"
    Then I should get 200 response code
    And I should get empty response array

    Examples:
      | input |
      | 2     |
      | $xo   |

  Scenario Outline: Test lookup api with valid item name = <item>
    Given I am an authorized user
    When I request for "<item>"
    Then I should get 200 response code
    And I should see the requested "<item>" is returned

    Examples:
      | item    |
      | tangela |
      | paras   |
