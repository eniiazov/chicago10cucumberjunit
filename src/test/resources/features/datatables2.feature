@datatables2
Feature: Testing datatables website

  Scenario: Testing adding new employee to the table

    Given User is on the datatables homepage
    And User clicks to New Button
    Then User should see Create New Entry Box
    And User should enter firstname "JOE"
    And User should enter lastname "Doe"
    And User should enter position "Retired"
    And User should enter office "London"
    And User should enter extension "341"
    And User should enter start date "2019-01-12"
    And User should enter salary "124000"
    Then User should click to create button
    And User enters first name "JOE" to search box
    Then User should see first name "JOE" is inserted in the table

