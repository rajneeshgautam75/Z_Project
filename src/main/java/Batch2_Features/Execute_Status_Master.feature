Feature: ExecuteStatus_Master

@ExecuteStatus
Scenario: Login

Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

#Pass
@ExecuteStatus
Scenario: 1 868148 Unassign an executed testcase with attachment at testcase level
Given User is in a page teStRepository
 When User creates a phase and creates a testcase in phase
 When User performs the edit operation on the created Testcase and enter step details
	And User performs the clone operation by selecting the testcase
 When User Launch TestPlanning and creates A cycle
 When User clicks on cycle context menu and creates a phase by choosing an existing phase
  And User choose assign individually and save
 When User Launch TestExecution and execute testcases to pass/fail/wip/blocked by choosing the status in status drop down 
  And User selects the testcase and clicks on no attachment link in the attachment column across testcase and chooses file from computer
 When User clicks on the no attachment link and choose file from your computer and choose file and save
 When User Launch TestPlanning and click on the previously created existing phase and chooses assign
  And User selects the testcase for which attachment was added and choose unassign in the assign drop down
 
 @ExecuteStatus
 Scenario: 2 868160 In TCE, execute testcases with varying values for estimated time and view the actual time in EAS
Given User is in a page TestRepositOry
 When User creates a phase and add testcase with estimated time
 When User Launches TestPlanning and creates a phase by choosing an existing phase
	And User assigns the testcases to Anyone and Launches TestExecution and executes testcase
 When User creates a phase in TestRepository and add testcase with estimated time 
 When User Launches TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to creator
 When User Launch TestExecution and executes the testcase 
 When User creates a phase in the TestRepository and add testcase with estimated time
 When User Launches TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to individual
 When User Launches TestExecution and Executes the testcase
 When User creates a phase in Testrepository and add testcase with Estimated time
 When User Launches a TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to Anyone
 When User Launches TestExecution and executes the Testcase
 When User creates a phase in the TestRepository and add testcase with an estimated time
 When User Launches TestPlanning and creates a phase by choosing an existing phase and assigns the testcase to the creator
 Then User Launches the TestExecution and executes the testcase 
 
 @ExecuteStatus
 Scenario: 3 868161 In TCE, unexecute testcase and view the actual time in EAS
Given User is in a page TestReposItory
 When User creates a phase and create testcases with different estimated time 
 When User Launches TestPlanning,creates a cycle and creates a phase by choosing an existing phase
 When User Launches testExecution and executes the testcases 
  And User unexecutes the testcases
 Then User Launches TestPlanning and view the actual time
 
 @ExecuteStatus
 Scenario: 4 868162 In TCE, edit the actual time of an unexecuted testcase and view in EAS
Given User is In a page TestRepository
	And User creates a phase and creates testcases with different estimated time
 When User Launches TestPlanning and creates a cycle,creates a phase by choosing an existing phase
 When User Launches TestExecution and executes the testcases,unexecutes testcases again
 When User edits the actual time of an unexecuted testcases
 Then User Launches TestPlanning and view the edited values of an actual time
 
 @ExecuteStatus
 Scenario: 5 868165 Bulk re-assign phase/system/subsystem if testcases are partially/fully executed to any status with different values for actual execution time
Given User is in a page Of TestRepository
 When User creates a phase and creates a testcases with different estimated time
 When User Launches TestPlanning and creates a cycle and creates a phase by choosing an existing phase
 When User Launches TestExecution and executes the testcases
 When User Launches TestPlanning and selects the phase,click on the option assign
 When User selects the phase contains testcases and performs the bulk re-assign operation
 Then User successfully checks actual time should stay the same as before the bulk change in UI
 
 @ExecuteStatus
 Scenario: 6 868167 Bulk unassign phase/system/subsystem if testcases are partially/fully executed to any status with different values for actual execution status
Given User is in a Page TestRepository
 When User creates a phase and creates testcases with unique estimated time
 When User Launches TestPlanning and creates a cycle and creates a phase by choosing the existing phase
	And User Launches TestExecution and executes testcases in a phase
 When User Launches TestPlanning and selects the phase,chooses the option assign
  And User selects the phase which contains testcases and performs the bulk unassign operation 
 Then User successfully checks the actual time should be reset to zero
 
 @ExecuteStatus
 Scenario: 7 868168 As lead/manager execute testcases in test execution and view the status in test planning
Given User is in a page TestREpository
 When User creates a phase and creates testcases in phase
 When User Launch testPlanning and creates a cycle,creates a phase by choosing existing phase and assign to anyone 
 When User Launch TestExecution and execute the testcases by performing edit operation
	And User Launches TestPlanning and selects the phase and click on assign and view executions of testcase
 When User Launches TestExecution and change the execution status of testcases
 When User Launches TestPlanning and select phase,click on assign and view the executions of testcase
 When User launch testExecution and change the execution status of testcase to not executed
 When User Launch TestpLanning and select phase,click on assign and view the executions of testcase
 When User Launch administration,clicks on customization and clicks execute status and disable a status
 When User Launches TestPlanning,selects phase,click on assign and view the executions of testcase
 When User Launches administration and clicks on customization and clicks execute status and edit a status
 Then User Launches TestPlanning and re-assign the testcase to other user after testcase executed in testExecution

@ExecuteStatus
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE