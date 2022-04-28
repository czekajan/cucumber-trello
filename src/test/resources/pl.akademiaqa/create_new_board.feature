Feature: Create new board

  @cleanup
  Scenario: I should be able to create new board with valid data
    Given I am authenticated to Trello
    When I create new board
    Then I can read created board details


  @cleanup
  Scenario Outline: : I should be able to create board with special chars as a board name
    Given I am authenticated to Trello
    When I create new board "<boardName>"
    Then I can read board details with board name "<boardName>"

    Examples:
      | boardName |
      | !         |
      | @         |
      | #         |
      | $         |
      | %         |
      | ^         |
      | &         |
      | *         |
      | (         |

 // @authenticated
  Scenario: I should not be able to create new board with empty board name
    Given I am authenticated to Trello
    When I try to create board with empty board name
    Then I should see an error

//  @not_authenticated
  Scenario: I should not be able to create new board when I am not authenticated
    Given I am not authenticated to Trello
    When I try to create new board when I an not authenticated
    Then I should see an error