@smoke1
Feature: Title verification for students
    @studentTitle
    Scenario: Student title verification
      When user hits list of students api with "http://cybertekchicago.com/student/all"
      Then user verifies each students title to be at least two letters

    @studentEmail
    Scenario: Student email verification
      When user hits list of students api with "http://cybertekchicago.com/student/all"
      Then user verifies each students email address to be valid