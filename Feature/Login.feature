Feature: Login into the application

Background: User is login with correct credentials
Given User launch Chrome successfully
And User opens URL "https://admin-demo.nopcommerce.com/login"


@Smoke3
Scenario: Successful login with Valid Credentials
And User enter email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Page title should be "Dashboard / nopCommerce administration"
And Close browser

@Smoke3
Scenario: Unsuccessful login with invalid credentials
And User enter email as "mvos@yourstore.com" and password as "admin"
And Click on Login
Then Error message should be displayed as "Login was unsuccessful. Please correct the errors and try againss"
And Close browser
 




