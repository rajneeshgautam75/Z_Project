Feature: Search_Master

@search_Master
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@search_Master
Scenario: 1 868184 Search for testcase by testcase contents when test step details/data/expected result contains different characters and add it to free form phase
Given User is in a page of an testRepository
 When User creates a phase and creates a testcase under the phase
	And User creates a testcases with different characters in testcase contents
 When User launches testPlanning and creates an cycle 
	And User clicks on a cycle context menu and creates a new phase and save
 When User clicks on Add testcase window and search a testcase by testcase content contains only lowercase characters
 When User search a testcase by testcase content contains only capital characters
 When User search a testcase by testcase content contains only numbers
	And User search a testcase by testcase content contains only alphanumeric characters and spaces 
 When User search a testcase by testcase content contains only international characters
  And User search a testcase by testcase content contains only long name
 Then User successfully search and add testcases with testcase contents have different characters

@search_Master
Scenario: 2 868185 Search for testcase by testcase altid contains different characters and add it to free form phase
Given User is in testRepository page
	And User creates a phase and creates a testcase under a phase
 When User creates a testcases with different characters in testcase altId 	
 When User Launches testPlanning and creates a cycle
	And User selects the cycle context menu and creates a new phase and save 
 When User clicks on Add Testcase window and search a testcase by testcase altid containing only lowercase characters
 When User search a testcase by testcase altid containing only capital characters 
 When User search a testcase by testcase altid containing only numbers
 When User search a testcase by testcase altid containing only alphanumeric characters and spaces
  And User search a testcase by testcase altid containing only international characters
  And User search a testcase by testcase altid containing only long name
 Then User successfully search and add testcases with testcase atlId have different characters 

@search_Master
Scenario: 3 868186 Search for testcase by testcase tag contains different characters and add it to free form phase
Given User is in a page of testRepository
	And User creates a phase and creates a testcase under phase
	And User creates a testcases with different characters in testcase tag
When User Launches TestPlanning and creates a cycle
	And User selects the Cycle context menu and creates a new phase and save
 When User clicks on Add TestCase window and search a testcase by testcase tag containing only lowercase characters
 When User search a testcase by testcase tag containing only capital characters
 When User search a testcase by testcase tag containing only numbers
 When User search a testcase by testcase tag containing only alphanumeric characters and spaces
 When User search a testcase by testcase tag containing only international characters
 When User search a testcase by testcase tag containing only long name
 Then User successfully search and add testcases with testcase tag have different characters

@search_Master 
Scenario: 4 868187 Search for testcase by testcase comments contains different characters and add it to free form phase
Given User is in a page of an testrepository
	And User creates a phase and creates a testcase under The phase
 And User creates a testcases with different characters in testcase comments
 When User Launches a testPlanning and creates a cyCle
	And User selects the cycle context menu and creates an new phase
 When User clicks on Add TestCase and search a testcase by testcase comment containing only lowercase characters
 When User search a testcase by testcase comment containing only capital characters
 When User search a testcase by testcase comment containing only numbers
 When User search a testcase by testcase comment containing only alphanumeric characters and spaces
 When User search a testcase by testcase comment containing only international characters
 When User search a testcase by testcase comment containing only long name
 Then User successfully search and add a testcases with testcase comments have different characters 

@search_Master
Scenario: 5 868190 Sort by all available fileds in the table after getting the results for query search
Given User Launches TestRepository
When User creates Phase and Add testcase to the phase with all the available fields
When User Launches TestPlanning and Creates a cycle 
 And User creates a new free form phase and save
 And User clicks on Add testcase window,launch search window and search testcase with available fields and adds
When User sort the testcase with the available fields in table
Then User successfully sort the testcases by available field columns

@search_Master
Scenario: 6 868191 Add testcases from a deep nested node to the free form phase
Given User Launches testRepository
 When User creates a phase and creates a testcase with the available fields under phase 
 When User creates a system under thE phase and Adds testcase
	And User creates a phases upto 8th deep level and Adds testcases at all levels 
 When User launches testpLanning and creates a cycle
 When User clicks on context menu across cycle and creates a new free form phase and save
	And User clicks on Add testCase window and launches a search operation
 When User launches Browse window and expands release upto 8th level
  And User selects all the testcases by checking select all checkbox at phase level
 Then User successfully adds testcases to the free form phase from any level

#assertion failed
@search_Master
Scenario: 7 868189 As Lead, Search for test cases by modified value in test case name/Steps/Priority/Alt. ID/tags/comments/ etc
Given User is in a page of TestRepositoRy
 When User creates a phasE and creates a testcase with the available fields
 When User Launches TestPlaNning and creates a cycle
	And User clicks on cycle context menu and creates a FrEeform phase and save
 When User clicks on Add testCase window and selects quick search radio button
 When User search a testcase with the available fields
 When User Launches a testRepository and edit the available values for a testcase
  And User Launch a testPlanning and selects the freeform phase created
 When User launches assign window and search for the modified values,selects the testcases and save 
 Then User successfully search a testcase with newly modified values
 
@search_Master
Scenario: 8 868212 Search Testcases by 'priority' using ZQL with different operators
Given User is in a page of an testrepOsitory
When User creates a phase and creates a testcases with available priorities
When User Launches a TEstPlanning and creates a cycle
 And User clicks on cycle context menu and creates a freeform phase 
When User Launches a Add Testcase window 
 And User selects advanced search
When User search a testcases with supported operators
Then User successfully search a testcase with priority and add testcases to freeform phase

@search_Master
Scenario: 9 868214 Search Testcases by 'tag' using ZQL with different operators and different characters
Given User is in a page testreposItory
When User creates a phase and Creates testcases with tag containing different characters
When User Launches TestPlanning and creaTes a cycle
 And User creates a freeform phase across cycle context menu
When User launches a Add Testcase window and selects advanced search
When User search a testcase tag with different operators and different characters
Then User Should be able to search Testcases by 'name' using ZQL with different operators and different characters and add it to free form phase
 
 # not done as not able to find the custom fields with those xpaths.
 @search_Master 
 Scenario: 10 868220 search for testcases with all supported fileds after editing the values in testcase and add to free form phase
Given User is in a paGe TestRepository
When User creates a phaSe and creates testcases with the available fields
 And User clones the testcases upto thousand five hundred 
When User Launch a TestPlanning and creates a cyCle
 And User clicks on cycle context menu and creates a Freeform phase
When User launch a Add Testcase window and selects advanced search
 And User search a testcase with available fields
When User Launch TestRepository and modifies the values in previously created phase with testcases
When User Launch a testPlanning and selects the Freeform phase created and launches assign window
 And User search a testcases with the modified values and add it freeform phase
Then User successfully search a testcases with edited values 

#Pass
@search_Master
Scenario: 11 868222 Search Testcases by 'id' using ZQL with different operators
Given User is in a pAge TestRepository
When User creates a phase with testcases
When User Launches tEstPlanning and creates a cycle
 And User clicks on cycle context menu and creates a new freeform phase
When User clicks on Add testcase and selects advanced search
When User search a testcase with id using operator '='
When User search a testcase with id using '!=' operator
When User search a testcase with id using operator 'in'
Then User successfully search a testcases by id with different operators 

#Fail - no custom field xpath found
@search_Master
Scenario: 12 868223 Attempt to search for testcases with all supported fields after deleting the testcase containing the field value
Given User Is in a page TestRepository
 When User creates a phase and creates a testcase with available fields
  And User clones the testcases upto ten
 When User Launch a tesTplanning and creates a cycle
 When User clicks on cycle context menu and creates a freeForm phase
  And User clicks on Add Testcase and selects advanced search
 When User search a testcase with the available fields and add it to freeform phase
 When User Launches TestRepository and selects the testcases in phase and performs delete
 When User Launch TestPlanning and selects the freeform phase created
  And User Launches a assign window and attempt to search for modified values
 Then User should not be able to search for values of fields when the testcase is deleted
 
@search_Master
Scenario: 13 868221 Attempt to search for testcases with all supported fields after deleting the field values in test repository and add to free form phase
Given User is iN a page TestRepository
 When User creates a phase and creates a testcase with an available fields
 And User clones the testcases upto the thousand five hundred 
When User Launches a TestPlanning and creates a cycle
 And User clicks on cycle context menu and creates an freeform phase
When User search a testcases with available fields and add it to freeform phase
When User Launch TestRepository and remove/deletes the values of an testcases
When User Launches a TestPlanning and selects the created freeform phase
When User search a testcases with deleted available field values
Then User should not be able to search for values of fields which are deleted/removed from test repository
 
@search_Master
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE
 
@search_Master
Scenario: 14 868192 Add testcases to free form phase when selected and added from release level 
Given User is in a page of tHe TestRepository
 When User creates a phase with all available fields
  And User creates a phase p1 and create system and subsystem and add testcases in system and subsystem
 When User Launch TestPlanning and creates a first cycle
 When User clicks on cycle context menu and creates a freefoRm phase
 When User clicks on Add testcase window and Launches a Browse window
  And User expands release node upto subsystem and select checkbox at phase level and save
 When User Launch TestRepository and creates a phase
  And User creates a multiple systems and add testcases at all levels
 When User Launch TestPlanning and creates a second cycle
 When User clicks on cycle context menu and creates a fReeform phase
  And User clicks on Add testcase window and Launch Browse window
 When User expands release node upto all the system levels and selects the checkbox at phase level and save
 When User Launch TestRepository and creates a phase,system and multiple subsystems and add testcases at all levels
 When User Launch TestPlanning and creates a third cycle
 When User clicks on cycle context menu and creates a frEeform phase
  And User clicks on Add testcase window and Launch Browse window option
 When User expands release node upto subsystem levels and selects the checkbox at phase level and save
 When User Launch TestRepository and creates multiple phases and add testcases at all levels
 When User Launch TestPlanning and creates a fourth cycle
 When User clicks on cycle context menu and creates a freeforM phase
  And User clicks on the Add testcase window and Launch Browse window
 When User expands release node upto all phases and selects the checkbox at phase level and save
 Then All the testcases should be added to the free form phase

@search_Master
Scenario: 15 868205 Search Testcases using ZQL and test ascending and descending order for different columns in search results
Given User is in A page TestRepository
 When User creates a phase with testcases with all the availble fields
 When User Launch TestPlanning and creates a cycle
	And User clicks on cycle context menu and creates the freeform phase
 When User Launch Add testcase window and selects the advanced search
 When User search testcases and performs sort operation for all the available parameters
 Then User should be able to sort by columns successfully in ZQL search results
 
@search_Master 
Scenario: 16 868206 Search Testcases using ZQL and test enable/disable column visibility
Given User is in a page TestRepositorY
 When User creates a phase with few testcases with all the available fields
 When User Launches TestPlanning and cReates a cycle
	And User clicks on cycle context mEnu and creates a freeform phase
 When User Launches Add testcase window and selects the advanced search
 When User search testcase and performs sort operation
 Then User should be able to enable/disable column visibility in ZQL testcase search results 

#Pass
@search_Master
Scenario: 17 868207 Search Testcases by 'altid' using ZQL with different operators and different characters
Given User in Repository page to add phaseand add testCases 
	And create a phase and add test cases 
When select testcases and provide different alt IDs
	And launch test planning create cycle and add freeform
	And click on add testcase click on advance search
Then search testcases by altid with different charecters and add to free form
	And Should be able to search Testcases of different characters and add it to free form phase
	
#Pass	
@search_Master
Scenario: 18 868208 Search Testcases by comments using ZQL with different operators and different characters
Given user in repository page to create phase and add testcases with comments
	And create phase and add testcases to phase
When select testcases and provide different comments
	And Launch testplanning create cycle add free form
	And select freeform and click on add testcase and click on advance search
And search testcases by comments with different charecters and add to free form
	Then Should be able to search Testcases by different comments and add it to free form phase
	
#Pass	
@search_Master
Scenario: 19 868210 Search Testcases by contents using ZQL with different operators  and different characters
Given user in repository page to Create Phase
	And create Phase and Add testcases to phase
When select testcases and provide different contents for each testcases
	And launch testplanning create cycle and create free form
	And click on add testcases and click on advance button
And search testcases by different contents and add to free form
	Then Should be able to search Testcases by contents different characters and add it to free form phase

#need to change code
@search_Master
Scenario: 20 868211 Search Testcases by name using ZQL with different operators and different characters
Given user in repository Page to Craete phase
	And create a phase and add testcases to phase to provide different names
When select testcases and provide different names for each testcases
	And launch test planning create cycle and create Freeform
	And select freeform click on add testcase and advance search button
And search testcases by different names and add to free form
	Then Should be able to search Testcases by name with different characters and add it to free form phase
	
#custom field	
@search_Master
Scenario: 21 868215 Search Testcases by custom field of type 'Text' using ZQL with different operators and different characters
Given User in repository page to create phase
	And create phase with testcases and add custom field of type text with different charecters
When launch test planning create cycle and create Free form
	And select freeform click on add testcase folder and Avance search
	And search testcases by custom field of type different text and add to freeform
Then Should be able to search Testcases by Text with different characters and add it to free form phase

#custom field
@search_Master
Scenario: 22 868216 Search Testcases by custom field of type Long Text with different operators and different characters
Given user in Repository page to create phase
	And create phase with testcases and add custom field of type long text with different charecters
When launch test planning Create Cycle and create Free form
	And select freeform Click on add Testcase Folder and Avance search
	And search testcases by custom field of type different long text and add to freeform
Then Should be able to search Testcases by Long Text different characters and add it to free form phase

@search_Master
Scenario: 23 868217 Search Testcases by custom field of type Picklist using ZQL with different operators and different characters
Given User in Repository Page to create phase
	And create phase with testcases and add custom field of type Picklist with different charecters
When launch test planning Create Cycle and Create Free Form
	And Select Freeform Click on add Testcase Folder and Avance search
	And Search testcases By custom field of type different Picklist and add to freeform
Then Should be able to search Testcases by Picklist different characters and add it to free form phase

@search_Master
Scenario: 24 868219 Search Testcases with the custom field of type Numbers using ZQL having multiple Testcases with the same Number values
Given User In Repository Page to Create phase
	And create phase with multiple testcases and add custom field of type numbers with same number
When launch Test planning Create cycle and Create Free Form
	And Select Freeform Click on Add Testcase Folder and Avance search
	And Search testcases By custom field of type number and add to freeform
Then Should be able to search Testcases by numbers and add it to free form phase

@search_Master
Scenario: 25 868218 Search Testcases by custom field of type Checkbox using ZQL with different operators and different characters
Given user In Repository Page to create phase and testcases
	And create phase with multiple testcases and add custom field of type checkbox with possible values 
When Launch Test planning Create Cycle and Create Free Form
	And select freeform Click on Add Testcase Folder and Avance search
	And Search testcases By custom field of type checkbox and add to freeform
Then Should be able to search Testcases by checkbox and add it to free form phase

@search_Master
Scenario: 26 868204 Search Testcases using ZQL by selecting search term and operator from suggestion pop-up
Given user in repository page to create phase and add testcases to search
	And create phase add testcases to phase with all custom fields
When create phase add testcases to phase with all available fields
	And Launch Test planning Create Cycle and Create Free Form and select freeform
	And Click on Add Testcase Folder and Avance search
And Search testcases By all available fields and add to freeform
	Then Suggestion popup should be automatically popup with values for fields and operators
	
@search_Master
Scenario: 27 868188 Search testcase by customized priority values
Given user in repository page to create a testcases with priority values
	And create a phase and add testcases with priority
When launch test planning create cycle and navigate to cycle and create freeform
	And navigate to freeform phase and launch add testcase window
	And launch search window and click on quick search
And search by all priorities and add to freeform
	Then Should be able to search testcase with all priority values

@search_Master
Scenario: 28 868209 Search  Testcases by creator using ZQL with different operators  and different characters
Given user in repository page to create phase and add testcases with different charecters
	And create a phase and add Testcases to Phase to provide different names
When select testcases and Provide Different names for each testcases
	And Launch test planning create cycle and Create Freeform
	And Select freeform click on add Testcase and advance search button
Then search Testcases by Different names and add to free form
	And Should be able to search Testcases by creator using ZQL with different operators and add it to free form phase

@search_Master
Scenario: 29 868213 Search Testcases by Release using ZQL with different operators and different characters 
Given user select the project and click on manage release
	And add different releases with name containing different characters
When launch all the releses and create phase and add test cases
	And Launch Testplanning Create cycle add Free Form Phase
	And select Freeform and click on add testcase and Click on Advance search
Then search Testcases by releases with different charecters and add to free form
	And Should be able to search Testcases by different Releases and add it to free form phase
   
@search_Master
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
