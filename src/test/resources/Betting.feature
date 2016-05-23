Feature: Betting

  Scenario Outline: Betting Validation
    Given I am on http://sports.williamhill.com/sr-admin-set-white-list-cookie.html page
    When I navigate to <competition> football event
    And I select match <match>
    And I place a <stake> bet on <winner> to win
    Then odds in bet are the same as selected
    And estimated returns equal <stake> times odds plus stake

    Examples:
      | competition               | match               | stake        | winner    |
      | Euro 2016 & International | Slovakia vs England | 0.05         | Slovakia  |

## other examples on which I ran tests to validate my solution
#      | Double Chance             | Hull vs Sheff Wed   | 0.05         | Sheff Wed |
#      | Euro 2016 & International | Slovakia vs England | 10000        | England   |
#      | Euro 2016 & International | Belgium vs Italy    | 0.01         | Italy     |
#      | Euro 2016 & International | Russia vs Slovakia  | 99999999999  | Russia    |
#      | Euro 2016 & International | Slovakia vs England | 100000000000 | Slovakia  |