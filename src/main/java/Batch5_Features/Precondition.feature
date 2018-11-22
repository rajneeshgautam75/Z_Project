
Feature: Defect Tracking Scenario precondition
@Ab
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


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
	
	@Ab
	Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE