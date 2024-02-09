Feature: Search functionality

Scenario: User searches for valid product
When User opens the aappliction
When User enters valid product "HP" into Search box field
And User clicks on Search button
Then User should get valid product displyed in search results

Scenario: User searches for invalid product
When User opens the aappliction
When User enters invalid product "HONDA" into Search box field
And User clicks on Search button
Then User should get message about no product matching

Scenario: User searches without any product
When User opens the aappliction
When User enters any product name into Search box field
And User clicks on Search button
Then User should get message about no product matching