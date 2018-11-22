Feature: FreeForm_Master

@Free_Form_Master
Scenario: Login

Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Free_Form_Master
Scenario: 1 868180_As Lead, Create a FF Phase (Free Form) in test planning with different character sets in phase name
Given Select the Project for the TestPlanning
When Click on the rElease in release summary
And Launch TestPlanning, create Execution Cycle
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'single/two characters', Save it
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Special characters', Save it
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Alphanumeric characters and Space', Save it
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'only Numbers', Save it
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Long name characters', Save it
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Only Capital Letters', Save it
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Duplicate Phase name', Save it
Then Phases with all the above mentioned Specifications are Created Successfully

@Free_Form_Master
Scenario: 2 868181_Edit the free form phase 
Given Select the Project1 For the TestPlanning
When Click on rElease in release summary
And Launch TestRepository, Create Phase with Name and Description
And Launch TestPlanning, Create Execution Cycle
And ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase, Save it
And Navigate to Created Phase in 'Assign Testcase to Execute' page, ContextClick and Edit the Phase name
Then Free Form Phase Name should be Edited Successfully 


@Free_Form_Master
Scenario: 3 868182_launch "Add Test cases" window and search for testcases from test repository and add it to free form phase
Given User Selects the Project For the TestPlanning
When User Click on a rElease in release summary
And User Launch testRepository, Create Phase with Name and Description
Then User Navigate to Created Phase, Add Testcase with all the Fields
When User Launch TestPlanning, Create an Execution Cycle
And User performs ContextClick and selects 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase, Save it
And User Navigate to Created Phase and Adds testcase and Click On Search Icon, Select 'Quick' Search
When User search testcase by testcase name and selects the testcase and save
When User search testcase by testcase contents and selects the testcase and save
When User search testcase by testcase priority and selects the testcase and save
When User search testcase by testcase alt id and selects the testcase and save
When User search testcase by testcase tag and selects the testcase and save
When User search testcase by testcase comments and selects the testcase ans save
When User search testcase by testcase creator first time and selects the testcase and save
When User search testcase by testcase creator last time and selects the testcase and save
When User search testcase by testcase release name and selects the testcase and save
And User performs search operation by clicking on Go
Then User successfully search testcases and add it to a free form phase  

@Free_Form_Master
Scenario: 4 868183_Search for testcase by testcase name when testcase name contains different characters and add it to free form phase
Given User is in a page testRepository
And User creates a phase with all the given fields
And User creates a testcases with different characters in testcase name
When User launches testPlanning and creates a cycle
And User creates a phase by selecting context menu create new option and save
When User navigates to created phase and click on add testcases
When User search testcase with testcase name containing only lowercase characters
When User search testcase with testcase name contains only capital characters 
#And User search testcase with testcase name contains only special characters
And User search testcase with testcase name contains only numbers
When User search testcase with testcase name contains only alphanumeric and special characters
And User search testcase with testcase name contains only international characters
And User search testcase with testcase name containing long name
Then User successfully search testcase name with different characters

@Free_Form_Master
Scenario: 5 868224 Add system and sub system to free form phase
Given User is in a page Testplanning
 When User creates a cycLe
 When User creates a free form phase under cycle
 When User creates a system under phase
	And User creates a subsystem under a system
 Then User successfully added system and subsystem to free form phase

@Free_Form_Master
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
