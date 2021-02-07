Feature: Test product process
  Scenario: add product to cart
    Given After user choose product
    When  select size and color
    And   click add product to cart
    Then  product add successfully to cart

Scenario: complete process of payment
  Given  product in cart
  When choose payment type and confirm process
  Then  product sucessfully checkout