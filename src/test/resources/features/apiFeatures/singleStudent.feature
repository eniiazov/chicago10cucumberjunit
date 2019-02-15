  Feature: Single Student API Automation
    @singleStudent @smoke1
    Scenario: Single Student Attribute validation
      When user hits single student API with "http://cybertekchicago.com/student/88"
      Then user tests for required attributes