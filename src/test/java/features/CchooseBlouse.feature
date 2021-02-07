Feature: test choose Blouse functionality
  Scenario: After login user can move to women category and choose blouse subcategory
    Given  user in account page
    When  choose women category and sub category blouse
    Then  blouse page open successfully

