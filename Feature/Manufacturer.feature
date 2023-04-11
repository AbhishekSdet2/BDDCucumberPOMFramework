Feature: Validating whether Manufacturer page is working fine

Background: User is login with correct credentials
Given User launch URL "https://admin-demo.nopcommerce.com/login"
And User login using email as "admin@yourstore.com" and password as "admin"
And Click Login button
And Maximize the window

@Smoke1
Scenario Outline: Search the manufacturer and check inside manufacturer table
When user navigates to Manufacturer page
And user searches for "<ManufacturerName>"
Then user should verify "<ManufacturerName>" in the table
Examples:
|ManufacturerName|
|Apple|
|HP   |


