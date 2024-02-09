Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the below fields
|firstName |soumya|
|lastName  |ranjan|
|telephone |12324567890|
|password  |1234|
And User selects privacy policy
And User clicks Continue button
Then User account should created successfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the below fields
|firstName |soumya|
|lastName  |ranjan|
|telephone |12324567890|
|password  |1234|
And User selects yes for Newsletter
And User selects privacy policy
And User clicks Continue button
Then User account should created successfully

Scenario: User creates an duplicate account
Given User navigates to Register Account page
When User enters the below fields with duplicate emailaddress
|firstName |soumya|
|lastName  |ranjan|
|email     |demoauto@gmail.com|
|telephone |12324567890|
|password  |1234|
And User selects yes for Newsletter
And User selects privacy policy
And User clicks Continue button
Then User account should get propper warning message about duplicate emailaddress

Scenario: User creates an account without providing any details
Given User navigates to Register Account page
When User dont enters any details into fields
And User clicks Continue button
Then User should get propper warning messages for every mandatory field