Feature:test register functionality
  Scenario:register with valid data
    Given  user in home page
    When  user enter "email" and click on create an account
    And   enter "firstname" and "lastname" and "email" and "password" and "address" and "city" and "state" and "zipcode" and "country" and "mobile" and "alias" and click on register button
    Then  user register successfully





