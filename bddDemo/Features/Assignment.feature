Feature:  Amazon Assignment

  Background:
    Given Launch The Browser
    When open amazon website url "https://www.amazon.in/"
    Then clicks on Accounts & Lists
    And Enter the emailId  as "abhikaradi@gmail.com"
    And Click on continue
    Then Enter the password
    And Click on signIn

  Scenario:
    Then Click on Today's deals
    Then Search for "Mobiles"
    And Select first item
    Then Add an item to the cart
    And Verify the cart quantity is  as expected or not

  Scenario:
    Then Click on Today's deals
    Then Search for "123456789$#@ghjk"
    And Verify No results for 123456789$#@ghjk in Today's Deals.

  Scenario:
    Then Click on Today's deals
    Then Search for "@#&"
    And Verify No results for @#& in Deals

  Scenario:
    Then Click on Today's deals
    Then Search for "Mobi@les"
    And Verify results for "Mobi@les"

  Scenario:
    Then Click on Today's deals
    Then Search for "w@tches"
    And Verify Price and other details may vary based on product size and colour.







