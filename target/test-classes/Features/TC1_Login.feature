@Login
Feature: Login Module API Automation

  Scenario: Get User logtoken from login endpoint
    Given User add header for accessing login endpoint
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200
    Then User should verify the login response body first_name present as "SANTHOSH KUMAR" and get the logtoken saved
