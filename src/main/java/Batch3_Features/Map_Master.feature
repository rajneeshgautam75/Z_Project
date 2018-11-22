Feature: Map Master
@Map
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Map
Scenario:1 19 Map testcase to a Requiremnt
Given user in Repository Page to create Node and add test cases upto Eighth Level
	And create node and add testcases upto Eighth Level
When Launch requirments create node and Add requirements
	And Select a single requirement from a node click on Map testcase Select one testcase from tree node and save
	And Select another requirement from a node click on Map testcase Select Node from tree and save
Then Select another requirement from a node click on Map testcase Select Release and save
	And Select another requirement from a node click on Map testcase Select Eighth Level node and save
	Then Able to map requirement to the testcase which is deep nested upto Eighth level

@Map
Scenario:2 20 View the testcase coverage for the requirements
Given User is in TestRepository page 
 When User creates a phase and create testcases
 When User is in Requirements page and create a phase with requirements
 Then User map the single testcase and view the requirement coverage detail
 Then User map the multiple testcases and view the requirement coverage details
 Then User map the complete release level testcases and view all the details of testcases

@Map
Scenario:3 21 Unmap the testcase from requirements
Given user in Repository Page to create Node and add test cases
	And create node and add testcases for phase and system
When Launch Requirments Create node and Add Requirements
	And Select a One requirement from a Phase click on Map Testcase Select One testcase from tree Phase and save
	And Select One more requirement from a Phase click on Map testcase Select Complete Node from tree and save
Then select the same requirement and uncheck the checked testcases and check
	And Select another single requirement from a node click on Map testcase Select Complete sub Node from tree and save
	And Select same requirement from a Phase click on Map testcase uncheck sub Node from tree and save
Then Requirement to testcase had been unmapped

@Map
Scenario:4 22 Update the requirement as different user
Given As a Manager create a node in requirements page
	And create few requirements under the created node and logout the from application
 When As a Lead,navigate to the manager created node and update the requirement details
 Then able to edit the other user created requirements

@Map
Scenario:5 23 Customize the requirement grid
Given User in Requirement page
	And Customize the requirement grid by selecting more colomn chooser resize the column name
When Switch to other application and return back to requirements
	And Now as lead logout from the Zee and relogin
	And Click on Reset button under grid
Then Grid should retain to back original grid, and grid reset message should be shown

@Map
Scenario:6 24 Login as another user and attempt to view other users grid changes
Given user in requirements page
	When add phase and add requoirement and resize the Grid
When select Release2 and get the size
	Then should retain the same value
	And select the project2 and get the size
Then should not reflect the size
	And logout and login with user2
	Then should not reflect the user size
	
	#@Map
#Scenario:7 36 Copy the imported node to local and global node using ctrl DnD
#Given user in the requirement page to oimport the file
	#And click on import select excel and create map import the file
#When copy the import file to local area
	#And copy the imported file to global area
	#Then should able to display in the global area

@Map
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE