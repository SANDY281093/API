@ProfilePic
Feature: ChangeProfilePic Module API Automation

  Scenario: Verify  profile picture change  to the application through api
    Given User add header and bearer authorization accessing for changeProfilePic endpoint
    When User add form data for change profile picture
    And User send "POST" request for changeProfilePic endpoint
    Then User should verify the status code is 200
    And User verify should the changeProfilePic response message matches "Profile updated Successfully"
