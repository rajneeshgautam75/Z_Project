@Login
Feature: Login into the Zephyr Application

Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

#Given Login as manager Role
#Given Login as manager Credential
#When Custom user edit the project status gadget by selecting another uassigned project



 