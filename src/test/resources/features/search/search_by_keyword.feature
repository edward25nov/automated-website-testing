#@driver:firefox
Feature: Search by keyword

  Scenario: Searching for a term
    Given Sergey is on the DuckDuckGo home page
    When he search for "Cucumber"
    Then all the result titles should contain the word "Cucumber"