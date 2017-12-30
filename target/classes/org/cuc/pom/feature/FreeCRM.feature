Feature: Logging into the FreeCRM page.

@SystemTesting
Scenario: Log from login page to home page

Given user navigates to FreeCRM webpage
Then user logs into the application
Then user enters homepage
Then user validates the homepage username
And user closes the browser

@RegressionTesting
Scenario Outline: Adding two new Deals

Given user navigates to FreeCRM webpage
Then user logs into the application
Then user enters homepage
Then user clicks on New Deals link
Then user enters "<title>" and "<deadline>" and "<status>" details
And user closes the browser

Examples:
|title|deadline|status|
|Task1|26-12-2017 06:14|Open|
|Task2|28-12-2017 07:20|Complete|


@SystemTesting @RegressionTesting
Scenario: Adding two new Deals

Given user navigates to FreeCRM webpage
Then user logs into the application
Then user enters homepage
Then user clicks on Calendar link
|hansolo|version 1.0|testing the list|
|darth vader|version 2.0|Second Row|
Then user enters event details
|Title|FromDate|ToDate|AssignedTo|Reminder|Contact|
|Event 1|29-12-2017 05:30|29-12-2017 07:30|bhargav sai|30 Minutes|test a|
|Event Bhargav|31-12-2017 05:30|31-12-2017 08:30|bhargav sai|45 Minutes|test b|
|Event Han Solo|28-12-2017 05:30|28-12-2017 09:30|bhargav sai|4 Hours|bruce|
And user closes the browser



