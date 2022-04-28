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
    Then I can create board details with board name "<boardName>"

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