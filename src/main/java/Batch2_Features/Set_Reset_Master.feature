Feature: Set_Reset_Master

@Set_Reset_Master
Scenario: Login

Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


@Set_Reset_Master
Scenario: 1 868128 Execute a testcase in test planning and view the flag in test planning
Given User is in a page TestRepository
	And User creates a Phase
When User creates a testcase
	And User performs edit operation on the testcase created
	And User selects a created testcase and clicks clone button 
Then User is in a page TestPlanning
	And User creates clicks on the plus symbol and enters the available fields
	When User creates a phase under the test cycle
Then User assigns the testcase to Anyone
Then User selectes all testcases and clicks on the set flag icon
Then User is in a page TestExecution
When User executes testcases and selects status by pass or fail or wip or blocked
And User is a page of TestPlanning and selects a phase and clicks assign
Then User views the flags across testcases successfully 

@Set_Reset_Master
Scenario: 2 868125 As lad/manager set/unset dirty flag across testcase in test planning
Given User is in a page of TestRepository
	And User creates a phase under cycle
When User creates a testcase under a phase
	And User performs the edit operation on the created testcase
	And User selects created testcase and clicks on clone button 
Then User is in a page of TestPlanning
	And User clicks on the plus symbol and enters the available fields
When User creates a phase under an test cycle
When User sets a flag for a testcase when it is not assigned
When User unsets a flag for a testcase when it is not assigned
Then User selects a single testcase and assigns to a testlead
Then User sets a flag for the same testcase
When User selects a same previous testcase and unset the dirty flag
When User is in a page of TestExecution
Then User executes the previous assigned testcase by selecting the status drop down
When User is in a page of TestPlanning page
Then User navigates to a phase in cycle tree and chooses assign
When User selects a executed testcase by clicking on it and sets the flag
Then User selects a same executed testcase and unsets the dirty flag
When User selects a each testcase and assign each testcase to different user by choosing assign drop down
Then User selects all testcases by clicking on All Select check box and sets the flag
Then User selects all testcases by clicking on All Select check box and unsets the flag
Then User successfully performs the flags operation    


@Set_Reset_Master
Scenario: 3 868127 Set/reset flags at nodes having huge number of testcases
Given User is in a page of the TestRepository
When User creates a testcase under a Phase
	And User performs the editing operation on the created testcase
	And User selects a created testcase and clicks on clone button
Then User creates a system node s1 under a phase node
	And User creates a testcase under a system node s1
Then User performs edit operation on a created testcase
Then User selects a newly created testcase under a system node s1 and clicks on clone button
When User creates a new system node s2 under a system node s1
Then User creates a testcase under a newly created system node s2
Then User performs the edit operation on a testcase of a newly created system node s2
When User selects a testcase under a newly created system node s2 and clicks clone button
Then User creates a system node s3 under system node s2
Then User creates a testcase under a system node s3
Then User performs edit operation on the created testcase
Then User selects a newly created testcase under a system node s3 and clicks clone button
When User is in a page TestPlanning page
And User clicks on plus button and enter all the available fields
And User creates a phase under a test cycle
And User assigns the testcase to a Anyone
Then User selects the phase node and sets the toggle flag
Then User again selects the phase node and resets the toggle flag
Then User successfully set/reset the flags successfully   


@Set_Reset_Master
Scenario: 4 868126 Set/reset flags dirty at different levels of nodes
Given User is in a page of TestRepository page
	And User creates a phase
When User creates a testcase under the phase
	And User performs the edit operation on a created testcase
	And User selects a created testcase and clicks a clone button
Then User is in a page of an TestPlanning
	And User clicks on plus symbol and enters the available fields
When User creates a phase p17 under a cycle
Then User assigns the testcase to an Anyone
When User selects all testcases and clicks on the set flag icon
When User is in a page of a TestRepository
When User creates a node s1 under an phase
When User creates a testcase on an newly created node
When User performs the Edit operation on a created testcase
When User selects a created testcase and clicks on a clone button
When User is in a page of a TestPlanning
Then User selects a phase and chooses assign option
When User clicks on sync button
Then User selects a testcases in node s1 and sets the flag by clicking on a star icon
When User selects a testcases in node s1 and resets the flag by clicking on a star icon
Then User is in a page of an TestRepository
When User expands a phase node and selects a phase node s1
Then User creates a node s2 under a node s1
When User selects a testcase created and performs clone operation of a testcase
When User is in a page of an TestPlanning and navigates to phase p17 and chooses assign and then click sync button
Then User selects the testcase in node s2 and sets the flag
Then User again selects the testcase in node s2 and resets the flag
When User is in a page of TestRepository and creates a node s3 after navigates node s1
Then User selects the testcase and performs clone operation
When User in a page of a TestPlanning and selects a phase p17 in a cycle and chooses assign and then click on sync button
When User selects a testcases in node s3 and sets the dirty flag
Then User selects a testcases in node s3 and resets the dirty flag
Then User set/resets the flags successfully 

@Set_Reset_Master
Scenario: 5 868163 Sort estimated/actual time at any level in cycle phase
Given user in Repository Page to create p/s/ss
	And create p/s/ss and add testcases and add estimated time
When launch test planning create cycle add phase to cycle
	And navigate to phase assign to different users
	And navigate to system and assign to diiferent users
When navigate to susbsystem unassign the testcases
	And launch test repository navigate to phase and sort the actual time
Then Should be able to sort estimated time in descending or ascending order

@Set_Reset_Master
Scenario: 6 868175 Export a cycle in test planning with phases and tescases assigned to a Phase
Given launch test repository to Create phase and Add testcases 
	And create phases and add testcases
When launch test planning and create a cycle 
	And navigate to cycle and add phase ONE to cycle and assign to Anyone
	And navigate to cycle and add phase TWO to cycle and assign to Anyone
	And navigate to cycle and add phase THREE to cycle and assign to Anyone
	And navigate to cycle and add phase FOUR to cycle and assign to Anyone
	And navigate to cycle and add phase FIVE to cycle and assign to Anyone
	And navigate to cycle and add phase SIX to cycle and assign to Anyone
	And navigate to cycle and add phase SEVEN to cycle and assign to Anyone
	And navigate to cycle and add phase EIGHT to cycle and assign to Anyone
	Then navigate to cycle and export testcases should be able to export all the phases with testcases

@Set_Reset_Master
Scenario: 7 868176 View phases are in sorted order in choose existing phase drop down while adding phase to cycle
Given user in repository phase to create phases
	And create four phases
When launch test planning crete cycle and add phase to cycle
	And search for phases which are in asending order
Then All phases should be sorted in choose existing phase drop down while adding phase to cycle 

@Set_Reset_Master
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
