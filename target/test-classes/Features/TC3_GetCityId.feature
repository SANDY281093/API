@CityId
Feature: CityId Module API Automation

  Scenario Outline: Get User cityId from cityList endpoint
    Given User add header for accessing cityList endpoint
    When User add response body for cityList "<state_id>"
    And User send "POST" request for cityList endpoint
    Then User should verify the status code is 200
    Then User should verify the cityList response body name present as "Tirunelveli" and get the cityId of Tirunelveli saved

    Examples: 
      | state_id |
      | stateId  |
