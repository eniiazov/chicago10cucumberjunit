@datatables3
Feature: Testing datatables website

  Scenario Outline: Testing adding new employee to the table

    Given User is on the datatables homepage
    And User clicks to New Button
    Then User should see Create New Entry Box
    And User should enter firstname "<firstname>"
    And User should enter lastname "<lastname>"
    And User should enter position "<position>"
    And User should enter office "<office>"
    And User should enter extension "<extension>"
    And User should enter start date "<date>"
    And User should enter salary "<salary>"
    Then User should click to create button
    And User enters first name "<firstname>" to search box
    Then User should see first name "<firstname>" is inserted in the table

    Examples: Test data for datatables

    |firstname|lastname|position|office |extension|date      |salary|
    |john     |doe     |retired |london |314      |2019-12-12|125000|
    |joe      |wong    |working |chicago|312      |2019-11-01|150000|
    |adam     |sandler |actor   |cali   |310      |2019-10-10|250000|
    |jen      |sandler |actor   |cali   |310      |2019-10-10|250000|
    |daughter |sandler |actor   |cali   |310      |2019-10-10|250000|









