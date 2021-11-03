Feature: Adding item in cart

  @testcase1
  Scenario: Adding item in cart and verifing it
    Given I add four differnt products to my wish list
    When I view my wish list table
    Then I find total four selected items in my Wishlist
    When I search for lowest price product
    And I am able to add the lowest price item to my cart
    Then I am able to verify the item in my cart
    
  