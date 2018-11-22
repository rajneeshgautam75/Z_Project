Feature: Retrieve Master
@Retrieve
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Retrieve
Scenario: 1 868193 Retrieve testcases from another cycle with free form phase(s) having more than 100 testcases, no filter
Given user in repository page to create phase and add testcases
	And create phase and add hundred testcases
When launch TestPlanning create cycle and add phase to cycle
	And select phase and select all testcases and assign to Anyone
	And create free form and click on assign window launch add testcase window
And launch other cycles window select cycle and phase
	Then Should be able to retrieve testcases from another cycle with free form phase

@Retrieve
Scenario: 2 868194 Retrieve testcases from another cycle with other phases with partially/completely assigned testcases
Given User in repository Page to create phase and add testcases
	And Create Phase and add hundred testcases
When launch testplanning create cycle add phase to cycle and assign to Anyone assign few Testcases to Manager/lead/Tester
	And launch testplanning Add phase again donot assign to creator of testcases
Then launch test execution execute few testcases in that two phases
	When launch testplanning create new cycle and create Freeform and save
	And click on Add testcase window launch other cycles
	And search for cycle which all testcases are assigned to Anyone and Save
	And search for cycle which few testcases are assigned and Save
	Then Should retrieve testcases from another cycle, if same phase was scheduled multiple times in same cycle

@Retrieve
Scenario: 3 868195 Switch between cycles having duplicate names and retrieve testcases from each cycle with combination of both normal and free form phase
Given user launched test Repository page
	And create phase add testcases to phase
When launch test planning create cycle C one add phase to cycle assign to Anyone
	And launch test planning create cycle as same as previously created C one add phase to cycle assign to Anyone
	And navigate to cycle which previously created create freeform 
Then launch testcase window search for testcases save and assign to Anyone
	And create cycle two add freeform phase select freeform phase
	And launch add testcase window launch other cycles select first created cycle select phase select all testcases and save
	And select second created cycle select normal phase select all testcases and save
	And select free formphase select all testcases and save
	Then Should be able to switch the cycle and add both normal and free form phases in the cycle to free form phase

@Retrieve
Scenario: 4 868196 Retrieve testcases from another cycle if some phases/nodes/testcases no longer exist in TCC
Given user in repository page to create phase and system
Given Launch test repository create a phase add testcases to phase create system to phase add testcases to phase
	And launch testplanning create cycle assign phase to cycle and assign to Anyone
When launch test repository delete system and delete some testcases from phase
	And navigate to cycle add freeform phase select freefoem phase
	And launch add testcase button launch other cycles 
And select cycle select phase and searh and add to freeform phase 
	Then Should retrieve testcases from another cycle if some phases/nodes/testcases no longer exist in test repository
	
	@Retrieve
	Scenario: 5 868197 Retrieve testcases from another cycle by execution status when testcases are executed to different status
Given user in repository page to create phase
	And Launch test repository create phase add hundred testcases to phase
	And launch test planning create a cycle C One add phase assign to anyone 
Then Launch test execution execute test cases to different status
	And Launch test planning create a free form phase Launch Add testcase and launch Other cycles 
And search for cycle/phase filter by status pass search select testcases add to free form phase
And search for cycle/phase filter by status fail search select testcases add to free form phase
And search for cycle/phase filter by status wip search select testcases add to free form phase
And search for cycle/phase filter by status blocked search select testcases add to free form phase
And search for cycle/phase filter by status custom status  search select testcases add to free form phase
And search for cycle/phase filter by status Not executed  search select testcases add to free form phase
Then Should be able to filter by execution status and add testcases to free form phase
	
	@Retrieve
Scenario: 6 868198 Retrieve testcases from another cycle by execution status when testcases are linked with defects and add it to free form phase
Given user in Repository page to create phase and add testcases
	And launch test repository create a phase add testcases to phase 
When launch testplanning create cycle add phase to cycle and assign to anyone 
	And launch test execution execute the testcases file/link defect across testcases
	And Launch test planning create a free form Phase Launch Add Testcase and launch Other cycles 
And Search for Cycle/phase filter by status pass search select testcases add to free form phase
And Search for Cycle/phase filter by status fail search select testcases add to free form phase
And Search for Cycle/phase filter by status wip search select testcases add to free form phase
And Search for Cycle/phase filter by status blocked search select testcases add to free form phase
And Search for Cycle/phase filter by status custom status  search select testcases add to free form phase
And Search for Cycle/phase filter by status Not executed  search select testcases add to free form phase
	Then Should be able to add testcases associated to defects to free form phase from Other cycles

@Retrieve
Scenario: 7 868199 Add testcases to a free form phase which already has testcases added and executed
Given user in Repository page to create Phase
	And Launch test repository create a phase add Testcases to phase 
When Launch testplanning create cycle add phase to Cycle and assign to anyone 
	And Launch test execution execute the testcases file/link defect across testcases
	When Launch test Planning Create a free form phase Launch Add testcase and launch Other cycles 
And Search for Cycle/phase filter By status pass search select testcases add to free form phase
And Search for Cycle/phase filter By status fail search Select testcases add to free form phase
And Search for Cycle/phase filter By status wip search Select testcases add to free form phase
And Search for Cycle/phase filter By status blocked search select testcases add to free form phase
And Search for Cycle/phase filter By status custom status  search select testcases add to free form phase
And Search for Cycle/phase filter By status Not executed  search select testcases add to free form phase
And Launch test repository Create a Phase add Testcases to Phase 
When Launch Testplanning Create cycle Two Add phase to Cycle and assign to Anyone 
	And Launch test Execution Execute the Testcases file/link defect Across testcases
And select previously created freeform phase launch add testcase window launch Other cycles
And select cycle Two select phase search for testcases choose maintain assignments of original schedule select testcases add to free form phase
Then Should be able to add testcases to free form phase where testcases are already present and executed in the free form phase

@Retrieve
Scenario: 8 868202 Add testcases to freeform phase from other cycles without selecting phase and status
Given to create a phase and add testcases user in repository page
	And create a phase and add test cases to phase
When launch testplanning create cycle add freeform one phase to cycle
	And navigate to freeform One browse testcases select one testcase and save and assign to Anyone
	When launch testplanning navigate to cycle add freeform two phase to cycle
	And navigate to freeform two browse testcases select same testcase and save and assign to Anyone
	When launch testplanning navigate to cycle add freeform three phase to cycle
	And navigate to freeform three browse select add testcases option launch other cycles
Then select cycle and freeform phase one  and  deselect status and add to freeform phase
And launch addtestcases option launch other cycles 
And select cycle and freeform phase two and add to freeform phase
	Then Testcase testcase one should be added only once

@Retrieve
Scenario: 9 8687203 Filter testcases by execution status from other cycles and add testcases to free form phase when status has different characters
Given user in Repository page to Create phase and add testcases
	And launch test repository add phase add hundred testcases
When launch testplannning create cycle add phase to cycle and assign to Anyone
	And launch test execution execute all the status available
	And launch test planning add freeform phase three  click on add testcase launch other cycles
And search for cycle/phase filter by Status pass Search select testcases add to free form phase
And search for cycle/phase Filter by status fail search Select testcases add to free form phase
And search for cycle/phase Filter by status WIP search select testcases add to free form phase
And search for cycle/phase filter by status Blocked search select testcases add to free form phase
And search for cycle/phase filter by Status Not Executed  search select testcases add to free form phase
And select cycle select phase filter by cuctom status and add to free form phase
	Then Should be able to filter by custom/default status and add the testcases to free form phase

@Retrieve
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE