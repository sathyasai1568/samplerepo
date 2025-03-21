@Registration
Feature: New User Signup

  @CreateAcc
  Scenario: Successful Signup
    Given user in home page navigates to signup under profile icon
    When the user enters a valid email "saiamara109@gmail.com" and password "Sai@1234"
    And clicks the Sign Up button
    Then the user should be successfully logged in

  @ChangePass
  Scenario: Edit account settings to set a new password
    Given user navigates to profile under profile icon
    And click on the edit button and change password
    When the user enters below details and click on update
      | Name | Number     | Password   |
      | Sai | 5677656578 | ABcd@12345 |
    Then user should get "Account updated" message as success

  @Login
  Scenario Outline: Login with different credentials
    Given user is on the login page after password update
    When the user enters email and password from the map and clicks login
      | email              | password      |
      | wrong@email.com     | wrongpassword |
      | test.user@email.com | wrongpassword |
      | wrong@email.com     | Test@12345    |
      | saiam@gmail.com        | ABcd@12345    |
    And user click on home page element
    Then User should see "<message>"
