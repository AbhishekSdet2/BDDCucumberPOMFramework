Feature: Verify whether employee details are getting added inside Add Employee tab

Background: User is login with correct credentials
Given User has successfully launched chromes browser
And URL is "https://opensource-demo.orangehrmlive.com/index.php/auth/login" is opened
And Entered username in as "Admin " password as "admin123"
@smoke6
Scenario: Verify new employee is added in Add employee tab
When user click on PIM tab
And user add multiple employee and save
Then user should see all the employees added inside Employee list
