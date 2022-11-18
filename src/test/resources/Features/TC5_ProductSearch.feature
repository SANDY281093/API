@ProductSearch
Feature: ProductSearch Module API Automation

  Scenario Outline: Get User produts from searchProduct endpoint
    Given User add header for accessing searchProduct endpoint
    When User add request body for searchProduct "<text>"
    And User send "POST" request for searchProduct endpoint
    Then User should verify the status code is 200
    And User verify should the searchProduct response message matches "OK"

    Examples: 
      | text |
      | nuts |
