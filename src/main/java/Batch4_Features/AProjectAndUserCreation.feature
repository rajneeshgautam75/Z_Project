
Feature: Create Project

 @Ab
Scenario: Change the Automation Execution Count
When user open the file and change the execution count
Then execution count should be changed
 @Ab
Scenario: As a Test Manager create new projects
Given Login as a Test manager
 And navigate to Manage Projects page
 When Create seven normal project
  And Create two isolated projects
	And Create two restricted projects
 Then Projects should be created successfully


 @Ab
 Scenario: create users with details
Given Login as manager credential
When User click on the administration and manage users
When User creates a first lead user
When User creates a second lead user
When User creates a third lead user
When User creates a fourth lead user
When User creates a fifth lead user
 And User creates a first tester user
 And User creates a second tester user
 And User creates a third tester user
Then all the users are created successfully

@Ab
Scenario: User assignment
Given Login as manager
When User click on admin and manage user
And select the first lead user and assign the projects
And select the second lead user and assign the projects
And select the third lead user and assign the projects
And select the fourth lead user and assign the projects
And select the fifth lead user and assign the projects
And select the sixth lead user and assign the projects

And select the first tester user and assign the projects
And select the second tester user and assign the projects
And select the third tester user and assign the projects
And select the fourth tester user and assign the projects
Then projects successfully assigned to the users

@Ab
Scenario Outline: create release 2.0 for all projects
Given User select the project<project>
When User create a release for all the projects
Then release is created for all projects
Examples:
|project|
|1      |
|2      |
|3      |
|4      |
|5      |

@Ab
Scenario: Precondition- As mgr, Create Testcase custom fields of all types
Given Manager Login into Zephyr Application
When Manager Navigates upto Testcase Fields in the Customizations Option
	And Manager Locks the Zephyr Acces for all other Users
	And Manager Adds Custom field with Text
	And Manager Adds Custom field with LongText
	And Manager Adds Custom field with Picklist
	And Manager Adds Custom field with Checkbox
	And Manager Adds Custom field with Number
	And Manager Adds Custom field with Date
Then Custom Fields with Text,LongText,Picklist,Checkbox,Number,Date Should be created Successfully

@Ab
Scenario: As manager, Creating Execution Status
Given User Login as manager credential
When click on administartion and click on customization status
And create custom status <N/A>
Then status should be created sucessfully
When create custom status <Custom Status>
Then status should be created sucessfully
When create custom status <Executed>
Then status should be created sucessfully
When create custom status <Not Executed>
Then status should be created sucessfully
When create custom status <Future Scope>
	Then status should be created sucessfully
	When create custom status <Future Release>
	Then status should be created sucessfully
	When create custom status <Duplicate>
	Then status should be created sucessfully
	When create custom status <Not Reproducable>
	Then status should be created sucessfully
	When create custom status <FutureScopeforjava>
	Then status should be created sucessfully	
	When create custom status <Execution>
	Then status should be created sucessfully
	When create custom status with international character
	Then status should be created Sucessfully
	
#	@Ab
#Scenario: As manager, Create Step custom status
#Given User Login as manager credential
#When click on administartion and click on customization step status
#And create step custom status <N/A>
#Then step status <N/A> should be created sucessfully
#When create step custom status <Future Scope>
#Then step status <Future Scope> should be created sucessfully
#When create step custom status <Custom Status>
#Then step status <Custom Status> should be created sucessfully

@Ab
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE



