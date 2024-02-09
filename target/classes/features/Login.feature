Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User has enter valid email address <username> into the email field
And User has enter valid password <password> into the password field
And User clicks on login button
Then User should get successfully logged in
Examples: 
|username               |password|
|amotooricap1@gmail.com |12345   |
|amotooricap2@gmail.com |12345   |
|amotooricap3@gmail.com |12345   |


Scenario: Login with invalid credentials
Given User navigates to login page
When User has enter invalid email address into the email field
And User has enter invalid password "123" into the password field
And User clicks on login button
Then User should get propper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User has enter valid email address "demoauto@gmail.com" into the email field
And User has enter invalid password "123" into the password field
And User clicks on login button
Then User should get propper warning message about credentials mismatch

Scenario: Login with valid invalidemail and valid password
Given User navigates to login page
When User has enter invalid email address into the email field
And User has enter valid password "soumya123" into the password field
And User clicks on login button
Then User should get propper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into eamil field
And User dont enter password into password field
And User clicks on login button
Then User should get propper warning message about credentials mismatch