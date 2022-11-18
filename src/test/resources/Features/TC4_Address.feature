@Address
Feature: Address Module API Automation

  Scenario Outline: Verify add user address to the application through api
    Given User add header and bearer authorization for accessing addUserAddress endpoint
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>" and "<zipcode>","<address>","<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the status code is 200
    And User verify should the addUserAddress response message matches "Address added successfully" and get the addressId

    Examples: 
      | first_name     | last_name | mobile     | apartment | state   | city   | country | zipcode | address | address_type |
      | SANTHOSH KUMAR | S         | 9489689561 | MS        | stateId | cityId |     103 |  621211 | TRICHY  | Home         |

  Scenario Outline: Verify update user address to the application through api
    Given User add header and bearer authorization  for accessing  updateUserAddress endpoint
    When User add request body for update existing address "<address_id>","<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User should verify the status code is 200
    And User verify should the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | address_id | first_name | last_name | mobile     | apartment | state   | city   | country | zipcode | address | address_type |
      | address_id | SANDY      | S         | 9489689561 | MS        | stateId | cityId |     103 |  621211 | TRICHY  | Home         |

  Scenario Outline: Verify get user address to the application through api
    Given User add header and bearer authorization for accessing getUserAddress endpoint
    When User send "GET" request for getUserAddress endpoint
    Then User should verify the status code is 200
    And User verify should the getUserAddress response message matches "OK"

  Scenario Outline: Verify delete user address to the application through api
    Given User add header and bearer authorization  for accessing deleteAddress endpoint
    When User add request body for delete user address "<address_id>"
    And User send "DELETE" request for deleteAddress endpoint
    Then User should verify the status code is 200
    And User verify should the deleteAddress response message matches "Address deleted successfully"

    Examples: 
      | address_id |
      | address_id |
