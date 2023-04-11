Feature: Verify whether configration page is working correctly

Background: User is login with correct credentials
Given User has successfully launched chromes
And URL "https://admin-demo.nopcommerce.com/login" is opened

@smoke5
Scenario: Verify whether user can add multiple mail ids and register
When enter email value as "admin@yourstore.com" and password as "admin"
And Click on Login button
And Navigate to Email accounts inside configration tab
And Click on Add new button
And enter email details
|Ab@test.com|Abhi|10.65.43.12|6789|Abhi1245|Ram@123|7891|
|Abc@abcd.com|Abhis|10.65.43.77|6799|Abhi7653|Ram@456|7899|
And Click on save button




