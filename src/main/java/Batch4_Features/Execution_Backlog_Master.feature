
Feature: Execution BackLog TestCases


 @Execution_Backlog
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

 @Execution_Backlog
 Scenario: 14  As Manager/Lead/Tester/CustomRole, Add Executions Backlog Gadget in empty Dashboard
   Given Tester,Manager or Lead is In a DashBoard
    When  Tester or Lead Adds Executions Backlog Gadget in empty Dashboard by clicking on plus ICON
    Then  Executions Backlog Gadget should be added by Tester or Lead
    When  Lead or Tester Attempts to select multiple projects or releases in Executions Backlog Gadget
    Then  Lead or Tester,Should not be able to select multiple projects or releases in Executions Backlog Gadget

 @Execution_Backlog
   Scenario: 33 Add another Executions Backlog Gadget without saving the existing Executions Backlog Gadget
   Given Test Lead Or Tester is in a DashBoard Window
   When  Lead or Tester adds New Dashboard and selects It
   And   execution backlog gadget should be added by lead or tester
   Then  execution backlog gadget should be added successfully
   When  Lead adds another execution backlog gadget without saving existing gadget
   Then  Should be able to Add another Executions Backlog Gadget without saving the existing Executions Backlog Gadget
  
   @Execution_Backlog
  Scenario: 34  Add multiple 2/4/6/8/10 Executions Backlog Gadget and change the Dashboard layouts from one  to two
   Given DashBoard page is opened by the User
   When  User Creates a new Dash Board and Selects a Created new DashBoard
   And   User will Add multiple two or more Executions Backlog Gadget and will change the Dashboard layouts from one to two and Two to three
   Then  User should be able to Add multiple Executions Backlog Gadget and Should be able to change the Dashboard layouts 
   
   @Execution_Backlog
    Scenario: 35  Add multiple 2/4/6/8/10 Executions Backlog Gadget with different projects in same dashboard
   Given CustomRoler is in DashBoard Window
   When  CustomRoler adds a dashboard by clicking on plus icon and selects added dashboard
   Then  DashBOard should be validated successfully
   When  CustomRoler Adds ten Executions Backlog Gadget with different projects in same dashboard
   Then  Should be able to Add multiple ten Executions Backlog Gadget with different projects in same dashabord
   
  @Execution_Backlog
   Scenario: 36  Add multiple 2/4/6/8/10 Executions Backlog Gadget with same project but different releases in same dashabord
   Given DashBoard Page is opened by User
   When  user will add a new dashboard and selects
   And   user adds multiple two or four or eight Executions Backlog Gadget with same project but different releases in same dashabord
   Then  To be Able to add Multiple executions backlog Gadget with Same project but different releases in same DashBoard
   
   @Execution_Backlog
   Scenario: 37 Add multiple 1/3/5/7/9 Executions Backlog Gadget with same project/release but different filters selected 
   Given DashBoard Window is opened by User
   When  Creates New DashBoard with Mandatory fields and selects
   And   user Adds multiple one or three or seven Executions Backlog Gadget with same project or user but different refresh intervals
   Then  Should be able to add one or three Executions Backlog Gadget with same project but different refresh intervals
   
 @Execution_Backlog
   Scenario: 44 custom field should display properly in Execution backlog gadget
   Given  user logins as  TEST Managaer credentials
   When  user is in test fields and creates custom field picklist type and assign it to sample project
   And   User create few Testcases and schedules and assign it to anyone 
   And   create Dashboard and add Execution backlog gadget and configure  
   Then  should display customfields Properly
   
   @Execution_Backlog
   Scenario: 45 Execution backlog gadget with custom fields application should display properly
   Given user logged as test manager Credentials
   When  User is in Testcase custom field and lock the zephyr access
   And   creates picklist data type customfield with all mandatory fields
   And   create few Test cases and add the field value and schedule and assign it
   And   create dashboard and add execution backlog gadget
   Then  Execution backlog gadget should validate successfully
   When  user configures picklist and check
   Then  Gadget should be displayed properly
   
   
  @Execution_Backlog
   Scenario: 46 CustomFields should reflect in Execution Backlog gadget
  Given Test Manager credentials is logged by user
  When  User is in custom field and lock the zephyr access
  And   user creates a custom field Text or Long text or Number with all the mandatory fileds and enable unique feature
  And   user creates few Testcase with values for custom fields
  And   In Testplanning schedule and assign to anyone
 And   Create dashboard and add execution backlog gadget
  Then  execution backlog gadget should be added
  When  Configure filter by custom fields click on manage and search
  Then  should show custom fields properly
   
    @Execution_Backlog
   Scenario: 48 Add execution backlog gadget and view the data 
   Given User installs five point zero version
   When  user Launchs TestRepository, Adds Testcases, Launchs Test Planning and assign Phase to Cycle
   And   User goes to test execution, Execute a testcases with any status
   And   Manage Dashboard page is opened by user
   And   adds new Dashboard
   Then  New Dashboard should be added by USER
   When  User adds execution backlog gadget for added new dashboard
   Then  execution backlog gadget should be Added By User
   When  user selects project and release for execution backlog gadget  
   And   user Views the execution backlog details
   Then  should show data in Execution Backlog gadget      
   
@Execution_Backlog
Scenario: 30 As a Lead,Click on Cancel button in Confirmation popup while deleting 'Executions Backlog Gadget'
Given As the Lead,Launch dashBoard page
 When Add the dashBoard with required fields
  And Add the Execution Backlog gadget by selecting the dashboard
 When execution backlog gadget is added 
 When delete the added Execution backlog
 Then Should be able to click on Cancel button in confirmation popup while deleting 'Executions Backlog Gadget'
 
 
@Execution_Backlog 
Scenario: 39 As a Lead,Change execution status to Unexecuted after saving 'Executions Backlog Gadget' 
Given As a Lead,Launch Test Repository page  
 When Add a node with testcases
  And Launch TestPlanning and create a cycle
 When Add the existing phase to the cycle
 When Launch Test Execution page and execute the testcase
 When Launch dashBoard page
  And Add the dashboard by clicking on dashboard plus symbol
 When Add the execution backlog gadget by clicking on add gadget plus symbol
 When configure the execution backlog gadget and save
 Then Execution backlog gadget is validated successfully
 When navigate to the test execution page and change the execution status to Unexecuted
 When Launch the dashBoard page
 Then selected gadget should be able to change execution status to unexecuted
 
 
 
  @Execution_Backlog
   Scenario: 1 Add Executions Backlog Gadget in empty Dashboard
    Given User Is In DashBoard Page
    When User Add Empty Dashboard by Clicking on Plus Button
    Then Should be Able to Add New Dashboard
    When Click on Add Gadget Button and Add the Execution Backlog Gadget
    Then Execution backlog Gadget should be Added Successfully
    When Select Project and Release and Filter by and Refresh Rate Click on Save button
    Then Execution backlog gadget should be saved Successfully
    When Click on plus Button and add the Execution Backlog gadget
    Then should be able to add Execution Backlog gadget successfully
    When Configure the Gadget with required data and click on save Button
    Then Should be able to Save Execution Backlog Gadget successfully
   
       
 @Execution_Backlog
  Scenario: 2 Add Executions Backlog Gadget for all projects
      Given User currently in Dashboard page
       When User add a dashboard by clicking on plus button
       Then Should be Able to Add a Dashboard
       When Click on Plus Button and add Execution backlog gadget
       Then Should be able to add the Execution backlog gadget 
       When Select Normal project and Release and FilterBy and Refresh rate and click on save button 
       Then Should be able to add Execution backlog gadget for Normal project
       When click on Plus Button to add Execution backlog Gadget
       Then should be able to Add Execution backlog Gadget
       When Select Isolated project and Release and FilterBy and Refresh rate and click on save button 
       Then Should be able to Add Execution Backlog Gadget for Isolated project
       When Click on Plus Button And Add Execution Backlog Gadget
       Then Should be Able to Add Execution Backlog Gadget
       When Select Restricted project and Release and FilterBy and Refresh rate and click on save button 
       Then Should be able to Add Execution Backlog Gadget for Restricted project
       
 @Execution_Backlog    
    Scenario: 3 Attempt to  Add Executions Backlog Gadget for Project not assigned to current user
        Given User Is In Dashboard Page
         When User Add a Dashboard by clicking on plus button
         Then Should be Able to Add Dashboard
         When Click On Plus Button and Add Execution Backlog gadget
         Then Should be Able to add Execution Backlog gadget successfully
         When Configure the Gadget with Required data and click on save button
         Then Should not be able to add Execution backlog gadget       
         
   @Execution_Backlog     
   Scenario: 15 Attempt to save Executions Backlog Gadget without selecting any options or filters in the gadget
       Given user Is In Dashboard Page
        When user Add the Dashboard by clicking on Plus Button
        Then should be Able to Add the Dashboard
        When Click On Plus button and Add Execution Backlog Gadget
        Then Should be Able to add the Execution Backlog Gadget Successfully
        When User try to save Executions Backlog Gadget without selecting any Project
        Then Should not be Able to Save Executions Backlog Gadget without selecting any project
        When click On Plus Button and Add Execution Backlog Gadget
        Then should be Able to Add the Execution Backlog Gadget Successfully
        When User try to save Executions Backlog Gadget without selecting any Release
        Then Should not be Able to Save Executions Backlog Gadget without selecting any Release
        When Click On Plus button and Add execution Backlog gadget
        Then Should be Able to Add the Execution Backlog Gadget  
        When User try to save Executions Backlog Gadget without selecting any FilterBy Option
        Then Should not be Able to save Executions Backlog Gadget without selecting any FilterBy Option
        When Click on plus Button and Add execution Backlog Gadget
        Then should be Able to Add the Execution Backlog Gadget successfully 
        When User try to save Executions Backlog Gadget without selecting Refresh interval
        Then Should not be able to save Executions Backlog Gadget without selecting Refresh interval
        
 
@Execution_Backlog
Scenario:  17 As a Lead,Edit 'Executions Backlog Gadget' and select different release within same/different project and save the gadget
Given Lead Launch the DashBoard page
 When Create a DashBoard with required fields
 When DashBoard should be created
  And Add Execution Backlog gadget by click on add gadget plus symbol
 When configure the Execution Backlog gadget and save
 When Edit the Execution Backlog gadget
 Then Should be able edit execution backlog and select different release within same project
 
@Execution_Backlog 
Scenario: 18 As a Lead,Edit 'Executions Backlog Gadget' and attempt to save without selecting the release/project
 Given As Lead,Launch DashBoard
  When Create the DashBoard with required fields
  When dashBoard should be created
   And Add Execution Backlog gadget by click on a add gadget plus symbol
  When Enter execution backlog details and save
  When Edit the Execution Backlog Gadget
  Then Should attempt to save gadget without entering the project/release
 
@Execution_Backlog
Scenario: 19  As a Lead,Edit 'Executions Backlog Gadget' and attempt to select the hidden release in same project 
 Given As Lead,Launches Dashboard
  When Create the DashBoard with available fields
   And Add execution backlog gadget by selecting the dashboard
  When Add the execution backlog details for the gadget and save
  When Edit the Execution Backlog by selecting the hidden release
  Then should not be able to Edit 'Executions Backlog Gadget' and select the hidden release in same project

@Execution_Backlog
Scenario: 16 As a Lead,Edit 'Executions Backlog Gadget' and change the refresh interval from hours/days/week and attempt to save it without selecting any interval
Given Lead,Launch the DashBoard
 When Create the Dashboard with available fields
  And Add the execution backlog by selecting the dashBoard
 When Add the Execution backlog details for the gadget
 When Edit the execution backlog and change the refresh interval
 Then Should an attempt to save the execution backlog gadget
 When Add the execution backlog gadget without selecting any interval
 Then Should attempt to save execution backlog gadget without selecting any interval
 
@Execution_Backlog
Scenario: 27 As Lead, modify and delete any one priority after saving 'Executions Backlog Gadget' 
Given As a Lead,Launch TestRepository and add testcases
 When Launch TestPlanning and add a phase to cycle
 When Launch TestExecution and execute testcases
 When launch dashboard page
 When add the dashboard with the available fields
  And add the execution backlog gadget
 When configure the execution backlog gadget
 Then Should be able to modify gadget with any one priority 
 When edit the execution backlog gadget to delete any one priority
 Then Should be able to delete any one priority
 
@Execution_Backlog
Scenario: 28 As Lead, modify and delete any one custom field after saving 'Executions Backlog Gadget'
Given as the lead,launch dashboard page
 When add the dashboard with the Available fields
  And Add the execution backlog gadget by clicking on gadget plus symbol
 When configure the execution backlog gadget with custom field
 Then Should be able to modify gadget with any one custom field
 When edit the execution backlog gadget to delete any custom field
 Then Should be able to delete any one custom field
 
 @Execution_Backlog
Scenario: 20 As Lead, Edit 'Executions Backlog Gadget' and add/remove user/tag/priority from the selected list 
Given As the Lead,Launch DashBoard page
 When Create the DashBoard with the available fields
  And Add the Execution Backlog gadget
 When enter the execution Backlog detail by choosing the User option
 Then Should be able to edit execution backlog gadget and add one more user from selected list
 When edit and remove one user from execution backlog gadget
 Then Should be able to remove one user from execution backlog gadget user list
 When edit execution backlog gadget by entering the tag 
 Then Should be able to add one more tag from selected tag list
 When edit and remove one tag from execution backlog gadget
 Then Should be able to remove one tag from execution backlog gadget tag list
 When edit execution backlog gadget to enter the priority
 Then Should be able to add one more priority from selected priority list
 When edit and remove one priority from execution gadget
 Then Should be able to remove one priority from selected priority list
 
@Execution_Backlog
Scenario: 24 As Lead, unassign any one user from project after saving 'Executions Backlog Gadget'
Given As a Lead,launch DashBoard page
 When Create the dashBoard with available fields
  And Add Executon backlog gadget with detail
 When unassign any one user from project after saving gadget
 Then Should be able to unassign any one user from project
 
@Execution_Backlog 
Scenario: 21 As a Lead,minimize and maximize saved/unsaved 'Executions Backlog Gadget'
Given Lead,Launch the DashBoard page
 When Add the DashBoard with available fields
  And Add the Execution Backlog by selecting the dashBoard
 When Add the Execution Backlog details for the gadget and save
 When minimize the saved execution backlog gadget
 Then Backlog gadget should be minimized
 When maximize the saved execution backlog gadget
 Then Backlog gadget should be maximized
 When Add the Execution gadget and minimize
 Then Backlog Gadget should be minimized
 When maximize the unsaved execution backlog
 Then Should be able to maximize the gadget

  @Execution_Backlog 
  Scenario: 4 Attempt to add hidden release to Executions Backlog gadget
  Given User is in the Project Page
  When  User creates a new Hidden Release by clicking on Manage Release button
  And   User goes to dashboard page and adds new dashboard and selects created DashBoard
  And   user adds Executions Backlog Gadget for selected Dashboard
  And   User attempts to add the Hidden Release to a gadget
  Then  Should not be able to add Executions Backlog Gadget for Project and hidden release
  
   @Execution_Backlog  
  Scenario: 10  Add Executions Backlog Gadget with  different Refresh intervals
  Given User is in the DashBoard Page of the selected project
  When  User adds a DashBoard with necessary details
  And   User selects the DashBoard which he has created
  When  User clicks on plus button to add Executions Backlog Gadget
  And   User selects project,Release and Refresh interval by one hour
  And   User selects project,Release and Refresh interval by four hour
  And   User selects project,Release and Refresh interval by eight hour
  And   User selects project,Release and Refresh interval by one day
  And   User selects project,Release and Refresh interval by one week
  Then  User should be able to add Executions Backlog Gadget with Refresh interval as one hr,four hr,eight hr,one day,one week
  
  @Execution_Backlog 
  Scenario: 31  Change the dashboard layout from two to one after saving a Executions Backlog Gadget
    Given User in the Dashboard page of the Related project
    When  User clicks on the add dahboard button to add a new dashboard
    And   User will select layout dashboard as two cloumn and fill other details to add a new dashboard
    When  User clicks on the add gadget button to add a new gadget
    And   User adds Executions Backlog gadget
    When  User fills the details to save the Executions Backlog gadget
    And   User clicks on the one column layout to change the dashboard
    Then  Should be able to Change the dashboard layout from two to one after saving a Executions Backlog Gadget
    
  @Execution_Backlog 
  Scenario: 32 Change the dashboard layout with unsaved Executions Backlog Gadget
    Given User is in the DashBoard Page with selected Project
    When  User will create new dashboard by clicking on the add dashBoard button
    And   User adds the DashBoard with all necessary Details
    When  User will clicks on plus button and add Executions Backlog Gadget
    And   User will change the dashboard layout without saving
    Then  Should be able to Change the dashboard layout with unsaved Executions Backlog Gadget
    
    
    
  @Execution_Backlog
 Scenario: 5 As Manager/Lead/Tester/CustomRole, Add Executions Backlog Gadget by all Filters
Given Lead is in Test Repository page, creates new phase and add testcases with priority, tag and custom field
	And Launch Test planning, add phase to cycle and execute those testcases in Test Execution page
	And Launch dashBoards page and create new dashboard
 When Add Executions Backlog Gadget by selecting filterBy User checkbox
 Then Execution Backlog Gadget should be added sucessfully with filterBy user checkbox 
 When Add Executions Backlog Gadget by selecting filterBy priority checkbox
 Then Execution Backlog Gadget should be added sucessfully with filterBy priority checkbox
 When Add Executions Backlog Gadget by selecting filterBy Tag checkbox
 Then Execution Backlog Gadget should be added sucessfully with filterBy Tag checkbox
 When Add Executions Backlog Gadget by selecting filterBy custom field checkbox
 Then Execution Backlog Gadget should be added sucessfully with filterBy custom field checkbox 
 
  @Execution_Backlog  
 Scenario: 7 As Manager/Lead/Tester/CustomRole, Add Executions Backlog Gadget and select By Filter User
Given launch Test Repository page, add phase and add testcase
 And Launch Test planning,add a phase to cycle and launch Test Execution, execute the testcase to PASS
 And Launch dashboards page and create new dashboard
 When Add Execution Backlog Gadget and select By User checkbox if user has execution status as only PASS
	Then Execution Backlog Gadget should be add successfully with status pass
 When Launch test Execution page and Execute the testcase to Fail
 When Add Execution Backlog Gadget and select By User checkbox if user has execution status as only Fail
 Then Execution Backlog Gadget should be add successfully with status fail
 When Launch test Execution page and Execute the testcase to WIP
 When Add Execution Backlog Gadget and select By User checkbox if user has execution status as only WIP
 Then Execution Backlog Gadget should be add successfully with status WIP
 When Launch test Execution page and Execute the testcase to Block
 When Add Execution Backlog Gadget and select By User checkbox if user has execution status as only Block
 Then Execution Backlog Gadget should be add successfully with status Block
 When Launch test Execution page and Execute the testcase to custom status
 When Add Execution Backlog Gadget and select By User checkbox if user has execution status as only custom
 Then Execution Backlog Gadget should be add successfully with status custom
 
  @Execution_Backlog 
 Scenario: 8 Add Executions Backlog Gadget and select By User checkbox if testcases are assigned from one user to other
Given As a lead, launch Test Repository, add testcases and assign testcases to another User
	And launch Manage DashBoard page and create new DashBoard
 When Add Executions Backlog Gadget and select filterBy User checkbox if testcases are assigned from one user to other
 Then Execution Backlog Gadget should be added successfully

 @Execution_Backlog  
Scenario: 9 Add Executions Backlog Gadget and select By User checkbox if testcases are deleted.
Given Lead is Test Repository Page, navigate to node and delete the testcase
  And Launch DashBoards Page and create a new Dashbaord
 When Add new Execution Backlog Gadget and select By User checkbox if testcases are deleted
 Then Execution Backlog should be added successfully
 
 
  @Execution_Backlog  
 Scenario: 12 Add Executions Backlog Gadget and select a project, release and priority if there is no priority added in testcases
Given Lead is in Manage DashBoards page
 When Create new dashBoard 
 Then New Dashboard should be created successfully
 When Add Execution Backlog Gadget and configure gadget with priority
 Then execution Backlog Gadget should be added successfully
 
 
 @Execution_Backlog  
Scenario: 49 Should be able to search 
Given Login as Lead into Zephyr Application
 When Navigate to Test repository and Create phase and Add a test cases to phase
	And Navigate to test planning, create three cycles and add phase to created cycles
	And launch DashBoard Page and create new Dashboard
 Then Dashboard should be created successfully for particular User
 When Add a Execution Backlog Gadget to created DashBoard
  And Configure Execution Backlog Gadget with  details and In search field enter cycle name and click on search
 Then Execution Backlog gadget should be added successfully
 
 
 
  @Execution_Backlog  
 Scenario: 50 Able to view Phase name clearly if phase name having more then twenty five character in execution backlog gadget 
Given Lead is in ProjectPage
 When Launch Test Repository page, add one phase, one system and add testcases to each node
	And Launch Test planning, add a cycle, add a phase and assign to user
	And Launch Test Execution and execute some testcases
 Then Test cases should be Executed
 When Launch Dashboards page and add a dashboard
  And Add an Execution backlog gadget by selecting project, release and phase
 Then Execution Backlog gadget should be added successfully for particular DashBoard
 
 
  @Execution_Backlog  
 Scenario: 51 Able to view Phase name clearly if phase name having more then twenty five character in execution backlog gadget 
Given User is in Normal project Page
 When launch Test Repository page, add one phase, one system and add testcases to each node
	And launch Test planning, add a cycle, add a phase and assign to user
	And launch Test Execution and execute some testcases
 Then test cases should be executed successfully
 When Launch Dashboards page and add new Dashboard
  And Add an Execution Backlog Gadget by selecting User
 Then Execution Backlog Gadget should be added successfully for particular user filterBy


@Execution_Backlog
Scenario Outline: 22 As Manager/Lead/Tester/CustomRole, delete saved/unsaved Executions Backlog Gadget
Given Login as different credential "<Role>"
When user click on Dashboard
Then dashboard page should be visible
When user "<Role>" add new dashboards with fields
Then dashboards "<Role>" should be created successfuly
When user add Execution backolg gadget
Then execution backlog gadget should be addded successfully
When user delete the added gadget
Then gadget should be successfully deleted
When user add one more execution backlog gadget and save it
Then execution backlog gadget should be saved
When user delete saved execution backlog gadget
Then saved gadget should be successfully deleted

Examples:
|Role|
|Manager|
|Lead|
|Tester|
|CustomRole|
#
#
#
#
#
@Execution_Backlog
Scenario Outline: 23 As Manager/Lead/Tester/CustomRole, delete a minimized 'Executions Backlog Gadget'
Given Login as different user credential "<Role>"
When user click on manage Dashboard
Then Manage dashboard page should be visible
When user "<Role>" add new dashboards with Fields
Then dashboard "<Role>" should be created successfuly
When user Add Execution backolg gadget and minimize it
Then Execution backlog gadget should be addded successfully
When user delete the minimized Added gadget
Then Gadget should be successfully deleted

Examples: 
|Role|
|Manager|
|Lead |
|Tester|
|CustomRole|
#
@Execution_Backlog
Scenario: 29 As Lead, delete a selected release from Release Setup set up app after saving Executions Backlog Gadget
Given Login as Lead credential
When user navigate to release setup page
And create a new release
And navigate to test repository Page
And create a node with name and desc
Then node should be successfully created
When user add a testcase to the node
Then testcase should be added successfully
When user navigate to test Planning page
And create a new cycle and add phase to cycle and assign testcases to user
Then testcases successfully assigned to user
When user navigate to test execution Page
And execute the testcase to Pass
Then testacase executed to Pass status
When user click on dashboard page
Then Dashboard page should be visible
When user add a new Dashboard with details
Then dashboad should be created successfully
When user add Executions Backlog Gadget and save it
Then Executions Backlog Gadget should be added successfully
When user navigate to release Setup page
And delete the current release 
Then should be able to delete the release

@Execution_Backlog
Scenario: 40 As Manager/Lead/CustomRole, Unassign executed testcases after saving Executions Backlog Gadget
Given Login as Lead credential Role
When user navigate to test Repository page
And create a node with name and description
Then Node should be successfully created
When user add multiple testcases to the phase
Then testcases should be added Successfully
When user navigate to Test Planning page
And create a new cycle and add phase to cycle,assign it
Then testcases successfully assign to the user
When user navigate to Test execution Page
And execute the testcases to Status Pass
Then testcases successfully executed to Pass status
When user navigate to manage dashboard page
Then Dash_board Page should be displayed
When user add a new dashboard with details
Then dashboard should_be created successfully
When user add execution backlog gadget and save it
Then execution Backlog gadget should be added successfully
When user navigate to Test Planning Page
And Unassign the executed testcases from the node
Then testcases should be Unassign successfully

#P
@Execution_Backlog
Scenario: 41 As Lead/CustomRole, Re-assign executed testcases from one user to other after saving Executions Backlog Gadget
Given Login as lead credential Role
When User navigate to test Repository page
And create a node with Name and description
Then phase should be successfully created
When user Add multiple testcases to the phase
Then testcases Should be added Successfully
When User navigate to Test Planning Page
And create a new Cycle and add phase to cycle,assign it
Then testcases successfully assign to user
When User navigate to Test execution Page
And execute all testcases to Status Pass
Then testcases successfully executed to Pass Status
When user navigate to Manage dashboard page
Then dash_board Page Should be displayed
When User add a new dashboard with details
Then dashboard should_be created Successfully
When User add execution backlog gadget and save it
Then execution backlog gadget should be Added successfully
When user Navigate to Test Planning Page
And Re-assign the executed testcases from one user to other
Then testcases should be Re-assign successfully

#P
@Execution_Backlog
Scenario: 42 Display execution status in Executions Backlog gadget evenly spaced
Given Login as Manager credential
When User navigate to test Repository Page
And Create a node with Name and description
Then Phase Should be created Successfully
When user add twelve testcases to the node
Then testcases successfully added to the node
When user navigate to Test_Planning Page
And create a new cycle and add phase to cycle,assign to manager
Then testcases should be assign to manager 
When user navigate to Test Execution Page
And execute testcases to Pass,Fail,Blocked and WIP status
Then testcases should be executed to Pass,Fail,Blocked and WIP
When user navigate to Dashboard page
Then Dash_Board page should be displayed
When user create a new dashboard with fields
Then dashborad should be created Successfully
When user add execution backlog gadget,configure and save it
Then execution backlog gadget should be saved successfully
And user view the space between the execution status bullets displayed
When User navigate to Test Execution Page
And change the execution from WIP status to Custom status
Then execution status should be changed successfully

#P
@Execution_Backlog
Scenario: 47 Create a Executions backlog gadget, later delete any of the available phase of cycle in EAS, and again come to dashboard to view created gadget
Given Login as lead credential Role
Given user is in project Page
When User navigate to test Repository module
And Create a node With Name and description
Then phase Should be created Successfully
When user add five test cases in the node
Then testcases should be added in the node
When user clicks on test plannig page
And create a cycle,add phase to cycle and assign it
Then testcases should be assign to the user
When user execute all testcases to Status Pass
Then testcases executed to status Pass successfully
When user Navigate to manage dashboard page
Then dashboard page should be displayed successfully
When user create a new dashboard with details
Then Dashboard should be Created Successfully
When user add Execution backlog Gadget to the dashboard
Then Gadget should be added successfully
When user navigate to test planning module
And delete the added phase to the cycle
And clicks on dashboard page
Then dash_board page should be Displayed
When user navigate to the created dashboard page
And check the added gadget in dashboard 
 
@Execution_Backlog
Scenario: 25 As Lead,modify username/first name/last name of a user after saving 'Executions Backlog Gadget'
Given As a second lead,Launch testRepository and add testcases
 When Add a cycle and phase by launching test planning
  And launch test execution page,to execute testcases
 When As the lead,launch dashboard page
 When Add the dashBoard with fields
  And Add the execution backlog gadget with detail and save
 When modify last name after saving execution backlog gadget
 Then Should be able to modify last name of a user
 
 @Execution_Backlog
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE
 
 
 @Execution_Backlog
 Scenario: 6 As Manager/Lead/Tester/CustomRole, Add Executions Backlog Gadget and select By Filter User
Given Lead is dashBoards page and creates new dashboard
 When Add Execution Backlog Gadget by selecting filterBy User checkbox
 Then Execution Backlog Gadget should be added sucessfully
 When Creates new phase and add testcases in Test Repository Page
	And launch Test planning, add phase to cycle, Launch dashBoards page and navigate to created Dashbord
 When Add Execution Backlog Gadget by selecting filterBy user checkbox
 Then Execution Backlog gadget should be added sucessfully
 When Execute testcases in Test Execution page, Launch dashBoards page and create new dashboard
 When Add Execution Backlog Gadget by selecting FilterBy User checkbox
 Then Execution Backlog Gadget should be added sucessfully in Dashboard 
 
 @Execution_Backlog
 Scenario: 13 Add Executions Backlog Gadget and select a project, release and with all priorities
Given Launch Test Repository, add phase and add testcases with priorities to all testcases
	And Launch Test Planning, add cycle to phase and execute testcases in Test Execution page
	And Launch Manage Dashboard and create new Dashboard
 When Add Executions Backlog Gadget and select a project, release and priority if there is only priority P one added in testcases
 Then Execution backlog Gadget should be created for priority P one
 When Add Executions Backlog Gadget and select a project, release and priority if there is only priority P two added in testcases
 Then Execution backlog Gadget should be created for priority P two
 When Add Executions Backlog Gadget and select a project, release and priority if there is only priority P three added in testcases
 Then Execution backlog Gadget should be created for priority P three
 When Add Executions Backlog Gadget and select a project, release and priority if there is only priority P four added in testcases
 Then Execution backlog Gadget should be created for priority P four
 When Add Executions Backlog Gadget and select a project, release and priority if there is only priority P five added in testcases
 Then Execution backlog Gadget should be created for priority P five
 
 
  @Execution_Backlog
 Scenario: 38 Add Executions Backlog Gadget in multiple Dashboards with same project/release and by All filters
Given Launch Test Repository page, add testcase to a node
	And launch Test planning, add a cycle, add phase and launch Test Execution and execute the testcase
 When Add Executions Backlog Gadget in multiple Dashboards with same project/release/cycles
 Then Execution Backlog Gadgets should be added successfully
 When Add Executions Backlog Gadget in multiple Dashboards with same project/release and filter By Priority
 Then Execution Backlog Gadgets should be added Successfully
 When Add Executions Backlog Gadget in multiple Dashboards with same project/release and filter By Tag
 Then Execution Backlog gadgets should be added Successfully
 When Add Executions Backlog Gadget in multiple Dashboards with same project/release and filter By Custom Feild
 Then Execution Backlog gadgets should be Added Successfully
 When Add Executions Backlog Gadget in multiple Dashboards with different project/release/cyles
 Then Execution backlog gadgets should be added Successfully
 
 
  @Execution_Backlog
  Scenario: 43 All execution status should display on legend of Execution Backlog gadget
Given Login as Manager and launch Administration 
 When Create different custom execution status 
	And Launch EAS and create cycle and assign more than ten testcases
	And Launch TCE and execute ten or more testcases with all ten available execution status
	And Create a dashboard and add Execution Backlog Gadget
	And Select Project/Release/Phase/RefreshInterval and save the gadget  
 Then Execution Backlog Gadget should be saved successfully
 
 
	 @Execution_Backlog
 Scenario: 11 Add Executions Backlog Gadget and select a project, release and user name/tag name /custom field/priority for all limits and characters
Given Login as a manager and create user of international character, max char limits, captial letters, alpha numberic and special characters and assign to normal project one
  And add Custom picklist of international character, max char limits, captial letters, alpha numberic and special characters
  And Login as a lead add testcases with tag and custom picklist names and assign one testcses to each lead
 When Login as International character lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with international char
 Then Execution Backlog Gadget should be added for user with international char
 When Add Executions Backlog Gadget and select a project, release and tag name with international char
 Then Execution Backlog Gadget should be added for tag with international char
 When Add Executions Backlog Gadget and select a project, release and custom name with international char
 Then Execution Backlog Gadget should be added for custom name with international char 
 When Login as max char limits lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with max char limits
 Then Execution Backlog Gadget should be added for user with max char limits
 When Add Executions Backlog Gadget and select a project, release and tag name with max char limits
 Then Execution Backlog Gadget should be added for tag with max char limits
 When Add Executions Backlog Gadget and select a project, release and custom name with max char limits
 Then Execution Backlog Gadget should be added for custom name with max char limits 
 When Login as captial letters lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with captial letters
 Then Execution Backlog Gadget should be added for user with captial letters
 When Add Executions Backlog Gadget and select a project, release and tag name with captial letters
 Then Execution Backlog Gadget should be added for tag with captial letters
 When Add Executions Backlog Gadget and select a project, release and custom name with captial letters
 Then Execution Backlog Gadget should be added for custom name with captial letters
 When Login as alpha numberic lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with alpha numberic
 Then Execution Backlog Gadget should be added for user with alpha numberic
 When Add Executions Backlog Gadget and select a project, release and tag name with alpha numberic
 Then Execution Backlog Gadget should be added for tag with alpha numberic
 When Add Executions Backlog Gadget and select a project, release and custom name with alpha numberic
 Then Execution Backlog Gadget should be added for custom name with alpha numberic
 When Login as special characters lead, add dashboard, add Executions Backlog Gadget and select a project, release and custom field name with special characters
 Then Execution Backlog Gadget should be added for user with special characters
 When Add Executions Backlog Gadget and select a project, release and tag name with special characters
 Then Execution Backlog Gadget should be added for tag with special characters
 When Add Executions Backlog Gadget and select a project, release and custom name with special characters
 Then Execution Backlog Gadget should be added for custom name with special characters
	
	
 
           
  @Execution_Backlog
   Scenario: Logout
   Given User is in the Zephyr ProjectPage_TPE
   When User Clicks on logout Icon_TPE
	 And User clicks on Logout Option_TPE
   Then User should be logged out from Zephyr Application Successfully_TPE
  