Feature: Delete_Master

#All Pass
@Delete
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


@Delete
Scenario: 1 868149 As Manager,Delete testcase from test planning with attachment attached at execution level
Given User is in a test TestRepository to crate phase and add testcase
 When User creates a phase and creates a testcase and performs the edit operation on the testcase
  And User expand step details and enters the step details
 When User performs the clone operation of the testcase
 When User Launches TestPlanning and creates a cycle,creates a phase by choosing existing phase and assign individually and save
 When User Launches TestExecution and executes the testcases to pass/fail/wip/blocked by choosing status drop down
	And User selects the testcase and click on no attachment link in the attachment column and choose file from your computer
  And User clicks on the no attachment link and choose file from your computer 
 When User Launch TestPlanning and click on phase,selects assign
  And User selects the testcase for which attachment was added and choose unassign option in the assign drop down
 When User select select the testcase with attachment and clicks on delete button in action column across testcase
 Then User successfully verify that testcase execution attachment is deleted from zephyrdata including the releaseTestSchedule_id folder
 
 
 @Delete
 Scenario: 2 868150 Delete a phase having executed testcase with attachment at execution level
Given User is in a page TestReposiTory
 When User creates a phase and creates a testcase and performs edit operation on testcase
 When User expands step details and enters the step details
  And User performs the clone operation of an testcase
 When User Launches TestPlanning and creates a cycle,create a phase by choosing an existing phase and assign individually and save
 When User Launches TestExecution and executes the testcases to pass/fail/wip/blocked by choosing status from status drop down
 When User selects the testcase and click on no attachment link in attachment column and choose file from your computer
 When User selects the testcase and click on no attachment link and choose file from your computer
 When User Launches TestPlanning and click on phase context menu and click on assign and select the testcase for which attachment was added and 
 And User Launch TestPlanning and selects the phase and perorms delete operation of a phase
Then Verify that testcase execution attachment is deleted
 
 @Delete
 Scenario: 3 868151 Delete a cycle having executed testcase with attachment at execution level
Given User is in repository page to create phase and add testcases and to clone
 When creates a phase and creates a testcase and performs the edit operation on a testcase
  And expand the step details and enters the step details
  And performs the clone operation on a testcase 
 When Launch TestPlanning and create a cycle,create a phase by Choosing an existing phase and assign individually
	And Launch TestExecution and execute the testcases to pass/fail/wip/blocked by choosing an status from status drop down
 When click on no attachment link in attachment column across testcase and choose file from your computer  
	And click on no attachment link in attachment column and choose file from your computer
 When Launche TestPlanning and click on phase context menu and click on assign
  And select the testcase and click on unassign from assign drop down
 And Launch TestPlanning and select the cycle and delete the cycle 
Then Verify that Testcase execution Attachment is deleted 
 
 @Delete
Scenario: 4 868152 Delete testcase in TCC with TCE attachments at testcase level then sync phase/system/sub-system with "Remove deleted nodes/testcase" option selected
Given User is in test repository to create phase and clone
 When User creates a phase and creates testcase in phase
  And Edit the testcase and expand step details and perform clone
 When Launche TestPlanning and create a cycle
	And create a phase by choosing an existing phase and assign individually 
 When Launch TestExecution and executes the testcases to pass/fail/wip/blocked by choosing status drop down 
  And select the testcase and click on no attachment link in attachment column and choose file from your computer
 When select the testcase and click on no attachment link in attachment column choose file from your computer
 When Launch Testrepository and navigate to phase and delete the testcases which has attachments
 When Launch TestPlanning and click on phase context menu and click on assign
 Then click on sync choose option remove deleted nodes should able to display removed deleted nodes
 
  @Delete
 Scenario: 5 868201 Delete a cycle with single/multiple free form phases with assigned/unassigned partially executed testcases
Given launch test repository to create phase and add testcases
	And create phase and add testcases
When launch test planning create cycle and add phase to cycle and assign to Anyone
	And launch test execution and execute testcases
	And link the defect across the testcases
When launch test planning navigate to cycle create freeform and navigate to freeform
	And launch add testcases and launch other cycles 
	And search for cycle/phase filter by status PASS search select testcases add to free form phase
And search for cycle/phase filter by status FAIL search select testcases add to free form phase
And search for cycle/phase filter by status WIP search select testcases add to free form phase
And search for cycle/phase filter by status BLOCKED search select testcases add to free form phase
And search for cycle/phase filter by status CUSTOM status  search select testcases add to free form phase
And search for cycle/phase filter by status NOT Executed  search select testcases add to free form phase 
When launch testplanning navigate to cycle create freeform search and add test cases to freeform
And launch testplanning navigate to cycle and delete cycle
Then Should be able to delete a cycle with multiple free form phases
 
 @Delete
 Scenario: 6 868177 Confirmation PopUp should be displayed when user tries to delete the test case from assignment grid
Given user in repository page to create phase and add testcases and clone
 When User creates a phase and creates testcases
 When User Launches TestPLanning and creates a cycle
	And User creates a phase by choosing an existing phase and assigns the testcases to creator
 Then User selects the phase and deletes the assigned testcases
 
 @Delete
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE