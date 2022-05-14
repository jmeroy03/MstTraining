Feature: Guru99 Demo Site Registration

  Scenario: Go to Guru99
    Given I redirect to guru page
    Then I should see Demo Site is displayed
    And Registration link is displayed

  Scenario: Register successfully
    Given I go to Guru99 page
    When I Click Register button
    And I Fill All fields
      | First Name       | First2              |
      | Last Name        | Last2                |
      | Phone            | 09122223322         |
      | Email            | testguru@gmail.com  |
      | Address          | Mindanao            |
      | City             | Sur City            |
      | State            | Agsur               |
      | Postal Code      | 8501                |
      | Country          | ALBANIA             |
      | Username         | username            |
      | Password         | pass123456          |
      | Confirm Password | pass123456          |
    And I click Submit button
    Then I see Sing Off link button