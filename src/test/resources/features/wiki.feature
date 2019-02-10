@wiki
Feature: Wikipedia search feature

  Scenario: Wikipedia search test
    Given User is on the Wikipedia homepage
    When User enters steve jobs to search bar and clicks enter
    Then User should see the first header is displaying steve jobs

