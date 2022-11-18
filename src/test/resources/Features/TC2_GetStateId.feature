@StateId
Feature: StateId Module API Automation

  Scenario: Get User stateId of Tamil Nadu from stateList endpoint
    Given User add header for accessing stateList endpoint
    When User send "GET" request for stateList endpoint
    Then User should verify the status code is 200
    Then User should verify the stateList response body name present as "Tamil Nadu" and get the stateId of Tamil Nadu saved
