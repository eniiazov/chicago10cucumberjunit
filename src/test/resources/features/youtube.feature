@youtube
Feature: Youtube search feature

  Background: User is on the homepage and is able to see searchbox and search button
    Given User is on the youtube homepage
    And User is able to see the search box
    And User is able to see the search button



  Scenario: Testing youtube search

    When User searches for FUNNY CAT VIDEOS
    Then User should see results related to funny cat videos


  Scenario: Testing youtube search

    When User searches for FUNNY DOG VIDEOS
    Then User should see results related to funny dog videos


  Scenario: Testing youtube search

    When User searches for FUNNY PET VIDEOS
    Then User should see results related to funny pet videos