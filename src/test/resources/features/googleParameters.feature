@googleParameters
Feature: Google search functionality

  Scenario: Testing google search
    Given User is on the homepage of google
    When User enters "flowers"
    Then User should see "flowers" in the title

  Scenario: Testing google search
    Given User is on the homepage of google
    When User enters "cars"
    Then User should see "cars" in the title

  Scenario: Testing google search
    Given User is on the homepage of google
    When User enters "trucks"
    Then User should see "trucks" in the title