
Feature: Creating defect with different status
@Defect
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE
@Defect
Scenario: Creating multiple defect with different status
Given Login as manager Credential
When User navigate to test repository page
And add a node with name and description
Then node succesfully created 
When user add multiple testcase to the node
Then testcases should be added 
When user navigate to test planning page
And create a new cycle,add phase to the cycle and assign to the user
Then testcases successfully assigned to the the user
When user navigate to test execution page
And navigate to the assigned phase
And select first testcase and change the execution status to Pass
Then execution status successfully chaged to Pass
When user click on defect button and update the login credential
And create a new defect 
Then defect should be created
When create seven more defect and read the Defect Id
And select the first defect in externa Jira and change status to Open
And select the second defect in externa Jira and change status to Open
And select the third defect in externa Jira and change status to Open
And select the fourth defect in externa Jira and change status to In Progress
And select the fifth defect in externa Jira and change status to In Progress
And select the sixth defect in externa Jira and change status to In Progress
And select the seventh defect in externa Jira and change status to Done
And select the eighth defect in externa Jira and change status to Done

@Defect
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE