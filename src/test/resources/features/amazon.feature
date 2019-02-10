@amazon1 @regression @smoke
Feature: Amazon search

  Background: User is on the amazon homepage
    Given User is on the amazon homepage

    @account
  Scenario: Amazon search test

    When User enters headphones keyword
    And User clicks to amazon search button
    Then User should see headphones in results

  Scenario: Amazon search test1

    When User enters headphones keyword
    And User clicks to amazon search button
    Then User should see headphones in results

  Scenario: Amazon search test1

    When User enters headphones keyword
    And User clicks to amazon search button
    Then User should see headphones in results

    @p
  Scenario: Amazon search test1

    When User enters "<product>" keyword
    And User clicks to amazon search button
    Then User should see headphones in results
      | product  |
      | mouse    |
      | keyboard |



























