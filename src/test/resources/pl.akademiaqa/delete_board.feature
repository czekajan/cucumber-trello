Feature: Delete existing board

  Scenario: I can delete existing board
    Given I am authenticated to Trello
    And The board already exist
    When I delete existing board
    Then I should not see this board any more