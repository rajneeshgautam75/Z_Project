Feature: Requirement Traceability Master

@ReqTraceability
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


@ReqTraceability
  Scenario: 1 Add Traceability Report Gadget 
    Given   user is in a dashboardpage
    When    user creates a new dashboard
    Then    new dashboard should be created
    When    user selects added dashboard and adds Traceability Report Gadget by clicking plus button
    Then    user to be able to add gadget
    When    user adds Traceability Report Gadget in other Dashboard by clicking on addition symbol
    Then    user should be able to add traceability report gadget
    When    user adds Traceability Report Gadget for Normal Project
    Then    should be able to add for Normal Project
    When    user adds Traceability Report Gadget for Isolated Project
    Then    Should be able to add for isolated project
    When    user adds traceability report gadget for Restricted Project
    Then    To be able to add for Restricted Project 
      
@ReqTraceability
Scenario: 2  Attempt to add 'Traceability Report' Gadget for Project not assinged to current user
Given  user is in a dashboard Window
When   user adds a New DashBoard
Then   New Dashboard should be added
When   user selects added dashboard and adds traceability report gadget by clicking plus button
Then   user should able to add gadget 
When   user adds traceability report gadget Project not assinged to current user
When   user attempts to add Traceability Report Gadget for Project and hidden release
Then   hidden release should not be shown in the dropdown
When   user try to add Traceability Report Gadget for Project the is deleted
Then   Deleted project should not be seen in the dropdown
When   user Attempts to add Traceability Report Gadget for Release having no requirements
Then   Save button should not be enabled without any requirement
When   user attempts to add Traceability Report Gadget for Project and Release if requirements are added only at Global level
Then   Save button should not be enabled without any requirements in local release


 @ReqTraceability
Scenario: 3 Add Traceability Report Gadget By selecting project and release 
 Given user is in a Dash Board Page
 When  user creates a new Dash Board and selects the new Dash board
 And   user adds Traceability report gadget by clicking add symbol
 Then  To be able to Add traceability Report Gadget
 When  user selects a project out of hundred or five hundred projects
 And   user selects release out of fifty or hundred releases
 And   user selects a project which are in special characters
 And   user selects release which are in special characters
 And   user selects project which are in internaltional characters
 And   user selects release which are in internaltional characters
 


 @ReqTraceability
Scenario: 23  Edit Traceability Report Gadget and change the refresh interval time
Given user is in a dashboard page and adds new dashboard
When  user selects added Daashboard and adds traceability report gadget by clicking addition symbol
Then  Traceability Report Gadget should be added by user
When  user Edits Traceability Report Gadget and change the refresh interval from one hour to four hour
Then  Should be able to change the time interval successfully
When  user edits Traceability Report Gadget and change the refresh interval from four hour to eight hour
Then  To be able to change time interval  successfully
When  user edits Traceability Report Gadget and change the refresh interval from eight hour to one day
Then  Should Able to change time interval successfully
When  user Edits Traceability Report Gadget refresh interval and attempt to save without selecting any interval 
Then  Should not be allowed to save without time interval


 @ReqTraceability
 Scenario: 24 User Edits Traceability Report Gadget and save the gadget
Given user is in a DashBoard Window
When  user adds a new dashboard and selects that added dashboard
And   user adds traceability report for added gadget
And   Gadget and select different release or requirements within same project and save the gadget
Then  should able to reconfigure gadget
When  user edits Traceability Report Gadget and attempt to save without selecting release
When  user Edits Traceability Report Gadget and attempt to select the hidden release in same project
Then  Should not be able to view or select hidden release
When  user edits Traceability Report gadget and select different project,release and requirements and save the gadget
Then  To be able to reconfigure gadget
  

@ReqTraceability
Scenario: 25 Add multiple Traceability Report Gadget
Given  User is In DashBoard Page and Adds New Dashboard
When   user selects added new dashboard 
And    Adds multiple 2/4/6/8/10 Traceability Report Gadget and change the Dashboard layouts from 1 to 2
Then   To be able to change dashboard layout from one layout to two layout
When   user Adds multiple 2/4/6/8/10 Traceability Report Gadget and change the Dashboard layouts from Two to One
Then   should able to change dashboard layout from two layout to one layout
When   user Adds multiple 2/4/6/8/10 Traceability Report Gadget with same projects but different releases in same dashabord
Then   user Should be able to add traceability gadget with different release
When   user Adds multiple 1/3/5/7/9 'Traceability Report' Gadget' with same project/release but different refresh intervals
Then   user Should be able to add traceability gadget with different time interval

 @ReqTraceability
Scenario: 28 Add 'Traceability Report' Gadget by searching requirement in quick search
Given User is In a requirements page
When  user adds the node and adds the requirements
And   user enters the requirements Name,altId,link,priority
And   user clicks on ManageDashBoard and Adds a New DashBoard
And   DashBoard is added, user selects added Dashboard and adds Traceability Report Gadget
And   user Searches requirement by name in quick search 
Then  user Should be able to search requirement
When  user Searches requirement by priority in quick search
Then  Should be able to search requirement of priority
When  user searches Requirement by altid in quick search
Then  should be able to search Requirement
    
    
    
@ReqTraceability
Scenario: 14 As Manager/Lead/Tester/CustomRole, Add 'Traceability Report' Gadget, Select Project/Release and search requirement by name
Given As a Lead,Launch Requirement page
 When create a node and add requirement names with different characters
 When Launch the DashBoard page
  And Add a DsahBoard with available fields
 When Click on add gadget symbol and add a Traceability gadget
  And search a requirement name with lowercase character
 Then Should be able to search requirement
 When search a requirement name with uppercase character
 Then shOuld be able to search the requirement
 When search a requirement name with number
 Then shoUld be able to search The requirement
 When search a requirement name with special character
 Then shouLd be able to search tHe requirement
 When search requirement name with international character
 Then shoulD be able to search thE requirement
 When search a requirements created with same name
 Then should be able to Search requirement
 When search a requirement name with long name
 Then Should be able to search Requirement 

@ReqTraceability
Scenario: 26 As Manager/Lead/Tester/CustomRole, Add 'Traceability Report' Gadget in multiple Dashboard 
Given As a Lead,Launch DashBoard Page
 When create a multiple DashBoards
  And create traceability gadgets with same project/release
 Then traceability Gadget is added successfully
 When create traceability gadgets with different project/release
 Then Traceability gadget is added successfully    
 
 
   
@ReqTraceability
Scenario: 27 Verify the data mapped in the 'Traceability Report' Gadget 
Given As a Lead,Launch the Requirements Page
 When create a node and add the requirements
 When launch Test Repository page
  And create a node with testcases
 When map requirement to the testcase 
 When launch TestPlanning,create a cycle
  And add phase to the cycle by choosing an existing phase
 When launch Test Execution to execute the testcases
 When launch the dashBoard page
  And add a dashBoard by clicking on the plus symbol
 When add a traceability gadget by clicking on the add gadget symbol
  And configure the gadget by selecting the project,release and the refresh rate
 Then able to see the project,release,requirement,status,proper mapping with testcase and defect status in the gadget

@ReqTraceability
Scenario: 16 As Manager/Lead/Tester/CustomRole, Add 'Traceability Report' Gadget and customize the gadget
Given As the Lead,Launch Requirements page
 When Add nodes upto tenth level with requirements
 When Launch The DashBoard Page and create a dashBoard
 When add a gadge and configure and save the gadget
  And minimize and maximize the saved report gadget
 Then gadget minimized and maximized successfully
 When minimize and maximize the unsaved report gadget
 Then gadget should be minimized and maximized
 When delete a saved report gadget
 Then should be able to add gadget
 When delete a unsaved report gadget
 Then unsaved report gadget deleted successfully
 When delete a selected requirement from requirement app after saving gadget
 Then gadget should be update and remove the deleted requirement  

@ReqTraceability
Scenario: 4 As Manager/Lead/Tester/CustomRole, Add 'Traceability Report' Gadget by testcase scedule
Given As the Lead,Launch Requirements and add requirements
 When add testcases in Test Repository and map requirements
 When Launch TEstPlanning,create cycle and add a phase
  And Launch Test Execution,execute testcases and link to defect  
 When Launches  DashBoard page
 When add a DashBoard with available fields
  And add a traceability gadget with release contains only unmapped requirements
 Then should be able to add the gadget
 When add a traceability gadget with requirements mapped to testcases not scheduled for executions
 Then should be able to add traceability gadget
 When add a traceability gadget with requirements mapped to testcases scheduled but not assigned
 Then should be able To add traceability gadget
 When add a traceability gadget with requirements mapped to testcases assigned but not executed
 Then should be able to add the traceability gadget
 When add a traceability gadget with requirements mapped to testcases executed but not linked to defect
 Then Should be able to add gadget
 When add a traceability gadget with requirements mapped to testcases executed and linked to defect
 Then Should Be able to add gadget

@ReqTraceability
Scenario: 5 As Manager/Lead/Tester/CustomRole, Add 'Traceability Report' Gadget by requirement mapped
Given As the Lead,Launch Requirements
 When add a requirements with a nodes
 When Launch testRepository,create testcases 
 When Launch testPlanning page,create a cycle
  And choose a phase to the cycle
 When Launch Test Execution and execute testcases,link defects
 When add the DashBoard and add the traceability gadget
 Then should be able to add the Gadget
 When add traceability gadget with hundred requirements mapped to different testcases and executions linked to defect
 Then Should be able to view the mapped data in the gadget
 When add traceability gadget with thousand requirements mapped to different testcases and executions linked to defect
 Then Should be able to view the mapped data and defect in the gadget
 When Add Traceability gadget with one thousand requirements mapped to different testcases and executions linked to defect
 Then Should be able to view the Mapped data and Defect in the gadget 

@ReqTraceability
Scenario:Precondition- As Manager/Lead/Tester/CustomRole,Execute multiple testcases and link defect with  Open ,In progress,Closed,Reopen ,Resoved status
Given User navigate to Test Repository page
When User add a node with name and description
Then node created successfully
When user add multiple testcases to the node
Then testcases should be added successfully
When user create a test cycle and assign phase
Then test case successfully assigned 
When user navigate to test execution 
And change the execution Status to Pass for multiple testcases
Then eecution status successfully changed to Pass
When user link defect with open ,In progress,Closed,Reopen ,Resoved status
Then defect successfully link to the testcases
When user change the execution status to Fail for multiple testcases
Then testcase status successfully changed to Fail
When user link defect with Open ,In progress,Closed,Reopen ,Resoved status
Then Defect successfully link to the testcases
When user change the execution status to WIP for multiple testcases
Then testcase status successfully changed to WIP
When user link defect with Open ,In Progress,Closed,Reopen ,Resoved status
Then Defect Successfully link to the testcases
When user change the execution status to Blocked for multiple testcases
Then testcase status successfully changed to Blocked
When user link defect with Open ,InProgress,Closed,Reopen,Resoved status
Then Defect Successfully Link to the testcases
When user change the execution status to Custom Status for multiple testcases
Then testcase status successfully changed to Custom Status
When user link defects with Open ,In Progress,Closed,Reopen,Resoved status
Then defect successfully link to the test cases

@ReqTraceability
Scenario: 6 As Manager/Lead/Tester/CustomRole, Add Traceability Report Gadget by selecting requirements by open defect
Given User navigate to Requirement page
When User add a phase with name and description
Then phase Should be created successfully
When user add five requirements to the phase
Then requirements successfully added to the phase
When user select the first requirement
And map to testcase executed to status PASS and linked to defect with status Open
Then first requirement successfully mapped to the testcase
When user select the second requirement
And map to testcase executed to status Fail and linked to defect with status Open
Then second requirement successfully mapped to the testcase
When user select the third requirement
And map to testcase executed to status WIP and linked to defect with status Open
Then third requirement successfully mapped to the testcase
When user select the fourth requirement
And map to testcase executed to status Blocked and linked to defect with status Open
Then fourth requirement successfully mapped to the testcase
When user select the fifth requirement
And map to testcase executed to status Custom Status and linked to defect with status Open
Then fifth requirement successfully mapped to the testcase
When navigate to Dashboard page
Then Dashboard page should be displayed
When user add a new dasboard with all details
Then new dashboard should be created successfully
When user add Add Traceability Report Gadget 
Then traceability report gadget added successfully
When user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect with status open defect
Then Should be able to view Pass/Fail/WIP/Blocked/Custom status status with Open defect


@ReqTraceability
Scenario: 7 As Manager/Lead/Tester/CustomRole, Add Traceability Report Gadget by selecting requirements by open defect
Given User navigate to Requirement page
When User add a Phase with name and description
Then phase should be Created successfully
When user Add five requirements to the phase
Then Requirements successfully added to the phase
When user select the first Requirement
And Map to testcase executed to status PASS and linked to defect with status In Progress
Then first requirement successfully Mapped to the testcase
When user select the Second requirement
And map to testcase executed to status Fail and linked to defect with status In Progress
Then Second requirement successfully mapped to the testcase
When user select the third Requirement
And map to testcase executed to status WIP and linked to defect with status In Progress
Then third requirement successfully Mapped to the testcase
When user select the Fourth requirement
And Map to testcase executed to status Blocked and linked to defect with In Progress
Then fourth requirement successfully Mapped to the testcase
When user select the Fifth requirement
And Map to testcase executed to status Custom Status and linked to defect with In Progress
Then fifth requirement successfully Mapped to the testcase
When navigate to Manage Dashboard page
Then Dash_board page should be displayed
When user add a new Dasboard with all details
Then new Dashboard should be created successfully
When user add Add Traceability Report gadget 
Then Traceability report gadget added successfully
When user selects the requirements Map to testcases executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect with status open defect
Then Should be able to view Pass/Fail/WIP/Blocked/Custom status with In Progress defect


@ReqTraceability
Scenario: 8 As Manager/Lead/Tester/CustomRole, Add Traceability Report Gadget by selecting requirements by Closed defect
Given User navigate to Requirement Page
When User Add a phase with name and description
Then phase Should be Created successfully
When user add Five requirements to the phase
Then requirements Successfully added to the phase
When user select the First requirement
And map to testcase executed to status PASS and linked to defect with Closed
Then First requirement successfully mapped to the testcase
When user selects the Second requirement
And map to testcase executed to status Fail and linked to defect with Closed
Then second requirement successfully Mapped to the testcase
Then user Select the third requirement
And map to testcase executed to status WIP and linked to defect with Closed
Then third requirement success_fully mapped to the testcase
When user Select the fourth requirement
And map to testcase executed to status Blocked and linked to defect with Closed
Then fourth requirement success_fully mapped to the testcase
When user Select the fifth requirement
And map to testcase executed to status Custom Status and linked to defect with Closed
Then fifth requirement success_fully mapped to the testcase
When navigate to Dashboard Page
Then Dash_board page should be Displayed
When user add a new dasboard with all Details
Then new dash_board should be created successfully
When user add Traceability Report Gadget 
Then traceability report Gadget added successfully
When user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect with status closed defect
Then Should be able to view Pass/Fail/WIP/Blocked/Custom status status with Closed defect


@ReqTraceability
Scenario: 9 As Manager/Lead/Tester/CustomRole, Add Traceability Report Gadget by selecting requirements by ReOpened defect
Given User navigate to Requirement page
When User add a Phase with Name and description
Then Phase Should be created successfully
When user Add five requirements to the Phase
Then five requirements successfully added to the phase
When user selects the first requirement
And Map to testcase executed to status PASS and linked to defect with status ReOpened
Then First requirement successfully Mapped to the testcase
When user selects the second requirement
And Map to testcase executed to status Fail and linked to defect with status ReOpened
Then Second requirement successfully Mapped to the testcase
When user selects the third requirement
And map to testcase executed to status WIP and linked to defect with status ReOpened
Then Third requirement successfully mapped to the testcase
When user selects the fourth Requirement
And map to testcase executed to status Blocked and linked to defect with status ReOpened
Then Fourth requirement successfully mapped to the testcase
When user selects the fifth Requirement
And map to testcase executed to status Custom Status and linked to defect with status ReOpened
Then Fifth requirement successfully mapped to the testcase
When User click on Dashboard link
Then dashboard page should be Displayed
When user add a Dasboard with all details
Then new dashboard should be Created successfully
When user Add Traceability Report Gadget 
Then Traceability Report gadget Added successfully
When user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect ReOpened status
Then Should be able to view Pass/Fail/WIP/Blocked/Custom status status with ReOpened defect



@ReqTraceability
Scenario: 10 As Manager/Lead/Tester/CustomRole, Add Traceability Report Gadget by selecting requirements by Resolved defect

Given User Navigate to Requirement page
When User add a Phase with Name and Description
Then phase should be Created Successfully
When user Add five requirements in the Phase
Then five requirements successfully Added to the phase
When user selects the First requirement
And Map to testcase executed to status PASS and linked to defect with status Resolved
Then First Requirement successfully Mapped to the testcase
When user selects the second Requirement
And Map to testcase executed to status Fail and linked to defect with status Resolved
Then Second Requirement successfully Mapped to the testcase
When user selects the third Requirement
And map to testcase executed to status WIP and linked to defect with status Resolved
Then Third requirement successfully Mapped to the testcase
When user selects the Fourth requirement
And map to testcase executed to status Blocked and linked to defect with status Resolved
Then fourth Requirement successfully Mapped to the testcase
When user selects the Fifth requirement
And map to testcase executed to status Custom Status and linked to defect with status Resolved
Then Fifth requirement successfully Mapped to the testcase
When User click on Dashboard Page
Then dashboard page Should be displayed
When user adds a new Dasboard with all details
Then new Dashboard should be Created successfully
When user Add a Traceability Report Gadget 
Then Traceability Report gadget Added Successfully
When user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect Resolved status
Then Should be able to view Pass/Fail/WIP/Blocked/Custom status status with Resolved defect

@ReqTraceability
Scenario: 11 As Manager/Lead/Tester/CustomRole, Add Traceability Report Gadget by selecting requirements by Custom status defect
Given User navigate to requirement page
When User adds a Phase with name and description
Then Phase should be created Successfully
When user Add five requirements in the phase
Then five Requirements successfully added to the phase
When user selects the First Requirement
And Map to testcase executed to status PASS and linked to defect with  Custom Status
Then First Requirement successfully mapped to the testcase
When user selects the Second Requirement
And Map to testcase executed to status Fail and linked to defect with Custom Status
Then Second Requirement successfully mapped to the testcase
When user selects the Third Requirement
And map to testcase executed to status WIP and linked to defect with Custom Status
Then third requirement Successfully mapped to the testcase
When user selects the Fourth Requirement
And map to testcase executed to status Blocked and linked to defect with Custom Status
Then fourth Requirement successfully mapped to the testcase
When user selects the Fifth Requirement
And map to testcase executed to status Custom Status and linked to defect with Custom Status
Then Fifth requirement Successfully Mapped to the testcase
When User click on Manage Dashboard Page
Then dash_board page Should be displayed
When user adds a new Dashboard with all details
Then new Dashboard should be Created Successfully
When user Add Traceability Report Gadget to dashboard 
Then Traceability Report Gadget Added Successfully
When user selects the requirements map to testcase executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect Custom Status
Then Should be able to view Pass/Fail/WIP/Blocked/Custom status status with Custom Status defect




@ReqTraceability
Scenario: 12 Add Traceability Report Gadget for Release having jira requirements mapped to testcases
Given Lead is requirement page and adds four requirements
	And launch Test Repository and create four testcases and map to requirement
	And Execute the testcases to Pass/Fail/WIP/Block and linka defect of status Open type
 When Create Dashboard page, add Traceability Gadget for Release having jira requirements mapped to testcases executed to status PASS
 Then Should be able to view status as Pass with Open defect type
 When Add Traceability Gadget for Release having jira requirements mapped to testcases executed to status Fail
 Then Should be able to view status as Fail with Open defect type
 When Add Traceability Gadget for Release having jira requirements mapped to testcases executed to status WIP
 Then Should be able to view status as WIP with Open defect type
 When Add Traceability Gadget for Release having jira requirements mapped to testcases executed to status Block
 Then Should be able to view status as Block with Open defect type
 

@ReqTraceability
Scenario: 13 As Lead Add Traceability Report Gadget for Release having requirements mapped to mutiple testcases
Given Login as a lead, add requirement, create multiple testcases and map the requirement
  And Add a testcase and map requirements to testcase and link a single defect with status Open
 When Add Traceability Gadget for a Release having requirements mapped to multiple testcases
 Then Should be able to add the gadget and view the total count successfully 
 When Add Traceability Gadget for Release with multiple requirements mapped to single testcase
 Then Should be able to add TraceAbility Gadget successfully
 
 
@ReqTraceability
Scenario: 19  Link single/multiple defect of all type to testcase execution that is mapped to requirement in saved Traceability Gadget
Given Launch Test Requirement page and add four requirements
	And Launch Test Repository page and add four testcases and map requirements to testcases
	And Execute testcases and create a Traceability gadget in Dashboards
 When Link defect of type Bug to testcase that is mapped to selected requirement in saved Gadget
 Then Linked defect (Bug) should be reflected in traceability gadget
 When Link defect of type Improvement to testcase that is mapped to selected requirement in saved Gadget
 Then Linked defect (Improvement) should be reflected in traceability gadget
 When Link defect of type NewFeature to testcase that is mapped to selected requirement in saved Gadget
 Then Linked defect (NewFeature) should be reflected in traceability gadget
 When Link defect of type Task to testcase that is mapped to selected requirement in saved Gadget
 Then Linked defect (Task) should be reflected in traceability gadget
 When Link defect of type Story to testcase that is mapped to selected requirement in saved Gadget
 Then Linked defect (Story) should be reflected in traceability gadget
 When Link defect of type Epic to testcase that is mapped to selected requirement in saved Gadget
 Then Linked defect (Epic) should be reflected in traceability gadget
 
 @ReqTraceability
 Scenario: 18 As Manager/Lead, Create new defect of all type and link to testcase execution that is mapped to selected requirement in saved Traceability Report Gadget
Given Lead is in Requirement page and adds requirement
	And Launch Test Repository, add a testcase and map the requirement
	And Execute the testcase and add new Traceability Gadget
 When Link a defect(Bug) to testcase execution that is mapped to requirement in saved Traceability Gadget
 Then Newly created defect(Bug) should be reflected in requirement traceability
 When Link a defect(Improvement) to testcase execution that is mapped to requirement in saved Traceability Gadget
 Then Newly created defect(Improvement) should be reflected in requirement traceability
 When Link a defect(New Feature) to testcase execution that is mapped to requirement in saved Traceability Gadget
 Then Newly created defect(New Feature) should be reflected in requirement traceability
 When Link a defect(Task) to testcase execution that is mapped to requirement in saved Traceability Gadget
 Then Newly created defect(Task) should be reflected in requirement traceability
 When Link a defect(Story) to testcase execution that is mapped to requirement in saved Traceability Gadget
 Then Newly created defect(Story) should be reflected in requirement traceability
 When Link a defect(Epic) to testcase execution that is mapped to requirement in saved Traceability Gadget
 Then Newly created defect(Epic) should be reflected in requirement traceability
	
	@ReqTraceability
	Scenario: 20 As Manager/Lead Change status of defect linked to testcase execution that is mapped to selected requirement in saved Traceability Gadget
Given Lead is in RequirementPage and adds new requirement
	And Launch Test Repository page, add testcase and map to requirement
  And Execute the testcase, link a defect of type Open and add Traceability Gadget 
 When Change status of defect(Open to Inprogress) linked to executed testcase
 Then Should be able to update the gadget with updated details
 When Change status of defect(Inprogress to Closed) linked to executed testcase
 Then Should be able to update the Gadget with updated status
 When Change status of defect(Closed to Reopened) linked to executed testcase
 Then should be able to Update the Gadget with updated status
 
 
 
	@ReqTraceability
 Scenario: 17  Reassign executed testcases that is mapped to selected requirement in saved Traceability Report Gadget
Given As a lead map a requirement to testcase  and execute a testcases 
	And Add a Traceability gadget
 When Reassign executed testcases that is mapped to selected requirement in saved Traceability Report gadget
 Then Should be able to view the saved gadget without any error
 
 

 
 @ReqTraceability
 Scenario: 21 As Manager/Lead/Tester/CustomRole, Change status for a testcase that is mapped to selected requirement in saved Traceability Report Gadget
Given Login as a lead, map a requirement for a testcase, execute testcase and create traceability gadget
	And Lead is in Execution Page
 When Execute testcase from Pass to Fail in execution page 
 Then Validate-Traceability gadget should be update with defect status
 When Execute testcase from Fail to WIP in execution page 
 Then Validate-Traceability gadget should be update with defect Status
 When Execute testcase from WIP to BLOCK in execution page 
 Then Validate-Trace-ability gadget should be update with defect status
 When Execute testcase from BLOCK to Pass in execution page 
 Then Validate-Traceability Gadget should be update with defect status
 
 @ReqTraceability
 Scenario: 22 As Manager/Lead/CustomRole, Change the data in the selected project after saving 'Traceability Report' Gadget
Given As Lead,Launch the Requirements and create requirement
 When Launch testRepository and create testcases
 When Launch Test Planning,create a cycle and add a phase
 When Launch test execution and execute testcase
 When Launch DashBoard page and create DashBoard
 When add traceability gadget by clicking on gadget plus symbol
  And configure the traceability gadget and save 
 Then traceability gadget added successfully
 When delete the selected release from release setup after saving traceability gadget
 Then traceability gadget should update with new data
 #When delete the selected project from project setup after saving traceability gadget
 #Then traceability gadget should update with a new data
 When delete selected requirement from project setup after saving traceability gadget
 Then traceablity gadget should be update with a new data
 When delete a selected testcase from project setup after saving traceability gadget
 Then traceability gadget should update with an new data
 When delete a cycle mapped with selected requirement from project setup after saving traceability gadget
 Then traceability gadget should be update with the new data 
 
 
 @ReqTraceability
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
 
