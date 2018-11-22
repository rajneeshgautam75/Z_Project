
Feature: Project Status Testcases



@ProjectStatus
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

 @ProjectStatus
 Scenario: 1  Add Project Status Gadget by plus button in new dashboard
     Given User is in Dashboard page
      When User add a dashBoard by clicking on plus button
      Then Should be able to add a new dashboard
      When Click on plus button to add a new gadget
      Then plus button should be clickable and gadget page should be opened
      When select Project and save the gadget
      Then Project status gadget should get added
      When Add Project status Gadget on Default dashboard layout
      Then Should be able to add Project status Gadget on default dashboard layout

@ProjectStatus
Scenario: 2 Changing gadget default layout
    #Given user is in dashboard page
    Given user is in the Dashboard page
    When  user adds a new dashboard by clicking on the layout 
    And   user selects the created dashboard
    When  user adds a project Status gadget by clicking on the gadget plus button
    Then  project Status gadget should be added

 @ProjectStatus
  Scenario:3  Attempt to save Project Status Gadget wihtout selecting any  Project
    Given User is in a DashBoardWindow
    When  user creates a new DashBoard and selects it
    And   user adds Project status Gadget for selected dashboard
    And   user attempts to save Project Status Gadget wihtout selecting any  Project
    Then  user Should not be able to save the gadget without selecting project
    When  user attempts to save Project Status Gadget by de-selecting already selected project 
    Then  user should not be able to save the gadget for already selected project
    When  user attempts to save the changes by editing Project Status Gadget and click on Cancel
    Then  user should not be able to Save the changes if user click on cancel

@ProjectStatus
Scenario:4  Add and save Project Status Gadget for Normal/Isolated/Restricted Project
Given  user is in DashBoard
When   user adds new dashboard and selects added new DashBoard
And    user adds project status gadget for Normal Project and Saves It
Then   user should be able to add and save Project Status Gadget for Normal Project
When   user adds and save Project Status Gadget for Isolated project
Then   user should able to save for Isolated project
When   user adds project status gadget for Restricted project
Then   user shold able to add and save for Restricted project

@ProjectStatus
Scenario:5 Selects another project from the project dropdown and save
Given Tester is in a DashBoard Page
When  tester creates new dashboard and selects it
And   adds project status gadget 
Then  project status gadget should be added
When  tester selects another project from drop-down and save
Then  should be able to select and save gadget by selecting another project from the project dropdown


@ProjectStatus
Scenario:6 Edit and select different project and save Project Status Gadget
Given Tester is in DashBoard window
When  Tester adds new Dashboard and selects it
And   Adds project status gadget
Then  Project Status Gadget Should add
When  tester Edits and selects different project and save Project Status Gadget
Then  To be able to edit and select different project and save project status gadget

@ProjectStatus
Scenario:7 Minimize/maximize the saved Project Status Gadget
Given Tester/lead is in a DashBoard 
When  tester/lead creates a dashboard and selects
And   tester/lead adds project status gadget
Then  project status gadget should be validated
When  tester/lead Minimizes the saved Project Status Gadget
Then  Should be able to minimize saved Project Status Gadget
When  tester maximizes the minimized saved Project Status Gadget
Then  Should be able to maximize the minimized saved Project Status Gadget
When  tester Minimizes the unsaved Project Status Gadget
Then  tester should be able to minimize the unsaved Project Status Gadget
When  tester Maximizes the minimized unsaved Project Status Gadget
Then  tester Should be able to maximize the minimized unsaved Project Status Gadget
When  tester Minimizes and attempt to configure/edit saved Project Status Gadget
Then  Should be able to minimize and configure/edit saved project status Gadget

@ProjectStatus
Scenario: 8 Delete 'Project Status Gadget' and verify the gadget deleted from dashboard.
Given As a Lead,Launch DashBoard page
 When create the dashBoard by clicking the add DashBoard symbol
  And create the DashBoard
 When add a project status gadget by click on gadget plus symbol
 Then should be able add project status gadget
 When delete the project status gadget
 Then should view delete project status gadget message
 
@ProjectStatus 
Scenario: 9 Attempt to delete 'Project Status Gadget' on click cancel button
 Given login as Lead,Launch DashBoard page
  When create a DashBoard by clicking on dashBoard plus symbol
   And add the DashBoard with its required fields
  When add a Project Status gadget by clicking on a add gadget plus symbol
  When delete the gadget by an attempt to click on close button
  Then should not able to delete project status gadget
  
  
@ProjectStatus  
Scenario: 10 Close 'Add Gadget' window list by clicking on 'X' button
Given Log in As Lead,Launch the DashBoard page
 When create a DashBoard by click on the add DashBoard plus symbol
  And add the new DashBoard with details
 When add the Project status gadget by clicking on add gadget plus symbol
 Then Should be able to close 'Add Gadget' window list by clicking on 'X' button
 

@ProjectStatus
Scenario: 11 Close 'Delete Gadget' window list by clicking on 'X' button
Given As Lead,Launch the Dashboard page
 When Add the DashBoard by click on dashboard add symbol
  And Add the DashBoard with given fields
 When Add the Project Status gadget by clicking on the add gadget plus symbol
 When attempt to delete the project status gadget
 Then Should be able close 'Delete Gadget' window list by clicking on 'X' button

@ProjectStatus
Scenario: 12 View and verify the fields like Release,InProgress,Testcases,Executions,Members is alligned
Given As an Lead,Launch DashBoard window
 When create a DashBoard by clicking on dashboard add symbol
  And Add DashBoard with given fields
 When Add Project Status Gadget by clicking on plus add gadget plus symbol
 Then Should be able validate the project status gadget
 When click on project status gadget 
 Then project status gadget icon is not clickable
 When view and verify,project status gadget name and description
 Then name and description of project status gadget should be proper

@ProjectStatus
Scenario: 13 As Mgr/lead/Tester/Custom user, Attempt to add Project Status Gadget  for the un-assigned project 
Given Login as manager role
When manager click on dashboard
Then dashboard Page Should be displayed
When manager creates a new dashboard
Then dashboard successfully created
When manager add Project Status Gadget
And attempt to select unassigned project 
Then should not be able to add unassigned project to Project Status Gadget
When lead navigates to dashboard page
Then dashboard Page should be displayed
When lead creates a new Dashboard
Then dashboard should be added succesfully
When lead add Project Status Gadget
And attempt to select unassigned project to Project Status Gadget
Then Should not be able to add unassigned project to Project Status Gadget
When tester navigates to dashboard page
Then Dashboard Page should be displayed
When tester creates a new dashboard
Then dashborad created successfully
When tester add Project Status Gadget
And attempt to add unassigned project to Project Status Gadget
Then should not be able to Add unassigned project to Project Status Gadget
When custom user navigates to dashboard page
Then dashboard Page Should be Displayed
When custom user add new dashboard
Then new dashboard should be added succesfully
When custom user add Project Status Gadget
And attempt to Select unassigned project to Project Status Gadget
Then should not be able to add unassigned project to Project Status gadget   




@ProjectStatus
Scenario: 14 As Mgr/Lead/Tester/Custom user, Add Project Status Gadget  for the assigned project
Given Login as Manager role
When Manager click on dashboard
Then Dashboard Page Should be displayed
When Manager creates a new dashboard
Then dashboard Should be created successfully
When Manager add Project Status Gadget
And attempt to select assigned project 
Then should be able to add Assigned project to Project Status Gadget
When Lead navigates to dashboard page
Then Dashboard Page should be Displayed
When Lead creates a new Dashboard
Then dashboard should be Added succesfully
When Lead add Project Status Gadget
And attempt to select assigned project to Project Status Gadget
Then Should be able to add assigned project to Project Status Gadget
When Tester navigates to dashboard page
Then dashboard page Should be Displayed
When Tester creates a new dashboard
Then dashborad should be created successfully
When Tester add Project Status Gadget
And attempt to add assigned project to Project Status Gadget
Then should be able to Add assigned project to Project Status Gadget
When Custom user navigates to dashboard page
Then dashboard page Should be_displayed
When custom user Add new dashboard
Then new dashboard should be added Succesfully
When custom user Add Project Status Gadget
And attempt to Select assigned project to Project Status Gadget
Then should be able to add assigned project to Project Status gadget  

@ProjectStatus
Scenario: 15 As Mgr/Lead/Tester/Custom user,Edit and update Project Status Gadget by selecting another assigned project
Given Login as Manager Role
When Manager Click on dashboard
Then dashboard Page Should be_displayed
When manager creates a new Dashboard
Then dashboard should be Created successfully
When manager add project status gadget and save it
Then project status gadget should be saved
When manager edit the project status gadget by selecting another assigned project
Then should be able to Update the project status gadget
When Lead navigates to Dashboard page
Then Dashboard page should be Displayed
When lead creates a new dashboard
Then dashboard should be added Succesfully
When lead add project status gadget and save it
Then Project Status Gadget should be Saved
When lead edit the project status gadget by selecting another assigned project
Then Should be able to Update the project status gadget
When Tester navigates to Dashboard page
Then dashboard Page should be Displayed
When tester creates a new Dashboard
Then dashboard should be Added Succesfully
When tester add project status gadget and save it
Then Project status gadget should be Saved
When tester edit the project status gadget by selecting another assigned project
Then should be able to update the Project status gadget
When custom user navigates to Dashboard page
Then dash_board Page should be Displayed
When custom user creates a new Dashboard
Then dashboard Should be Added Succesfully
When custom user add project status gadget and save it
Then Project Status Gadget Should be Saved
When custom user edit the project status gadget by selecting another assigned project
Then Should be able to Update the Project Status gadget

@ProjectStatus
Scenario: 16 As Mgr/Lead/Tester/Custom-user,Attempt to edit and  update Project Status Gadget for the unassigned project
Given login as Manager Role
When manager clicks on dashboard
Then Dashboard Page Should be_displayed
When Manager creates a new Dashboard
Then Dashboard should be Created successfully
When Manager add project status gadget and save it
Then Project status gadget should be saved
When manager edit the project status gadget by selecting another unassigned project
Then should not be able to edit the project status gadget
When Lead navigates to dashboard Page
Then Dashboard page Should be displayed
When Lead creates a new dashboard
Then Dashboard should be Added Succesfully
When Lead add project status gadget and save it
Then project status Gadget should be Saved
When lead edit the project status gadget by selecting another unassigned project
Then Should not be able to Update the project status gadget
When tester navigates to Dashboard page
Then Dashboard page should_be Displayed
When tester create a new Dashboard
Then dashboard should be added success_fully
When tester add project status Gadget and save it
Then Project status Gadget should be Saved
When tester edit the project status gadget by selecting another unassigned project
Then should not be able to update the Project status gadget
When Custom User navigates to Dashboard page
Then dashboard Page should be_Displayed
When Custom user creates a new Dashboard
Then dashboard Should be Added Successfully
When Custom user add project status gadget and save it
Then Project Status gadget Should be Saved
When Custom user edit the project status gadget by selecting another uassigned project
Then Should not be able to Update the Project Status gadget

@ProjectStatus
Scenario: 17 As Mgr, delete 'Project Status Gadget' when manager is assigned/Not assigned to any project
Given Manager is in DashBoard page
 When Add a DashBoard with details
  And Add a project status gadgets by clicking on add gadget plus symbol
 Then should be able to delete project status gadget
 When Manager is not assigned to any project
 Then should be able to delete the project status gadget
 
 @ProjectStatus
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE 
 
 
 @ProjectStatus
Scenario: 18 As Lead, delete 'Project Status Gadget' when Lead is assigned/Not assigned to any project
Given As a Lead,Launch the DashBoard page
 When Add a DashBoard with required fields
  And Add a project status gadget by clicking on add gadget plus button
 Then Should be able to delete the gadget
 When Login as another lead,Launch Dashboard page
 Then Should not able to delete the gadget
  
 @ProjectStatus
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE 
 
  
@ProjectStatus
Scenario: 19 As Tester, delete 'Project Status Gadget' when Lead is assigned/Not assigned to any project 
Given As a Tester,Launch DashBoard page
 When Add a DashBoard by clicking on dashboard plus symbol
  And dashBoard is created
 When Add a project status gadget by click on the add gadget plus symbol
 Then Should be able to delete the project status gadget
 When Login as Lead,Launch DashBoard page
 Then Should not be able to delete project status gadget
 
@ProjectStatus
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE 

@ProjectStatus
Scenario:20 As Custom role user, delete Project Status Gadget when user has delete permission and is assigned/Not assigned to any project
Given Custom role user is in a DashBoard Page
When  custom role user adds a new dashboard and selects
And   adds Project status gadget for added DashBoard
Then  Project status gadget to be added
When  Delete Project Status Gadget when user has delete permission and is assigned to any project
Then  To be able to Delete Project status Gadget
When  user Attempts to delete Project Status Gadget when user has delete permission and is not assigned to any project
Then  Should Not Be Able to Delete Project Status Gadget

@ProjectStatus
Scenario:21 As Custom role user,Attempt to delete Project Status Gadget when user does not have delete permission and is assigned/Not assigned to any project
Given Custom role user is Dash Board
When  Custom role user adds the New dashboard and Selects Added Dashboard
And   Project Status Gadget Should be added by custom role user
Then  project Status gadget should be Validated
When  custom user Attempts to delete Project Status Gadget when user does not have delete permission and is assigned any project
Then  project status gadget should not be able to delete
When  custom user try to delete Project Status Gadget when user does not have delete permission and is not assigned to any project
Then  Project status gadget should not delete


#Scenario: 20 Attempt to view gadgets with data if release is hidden/deleted
#
#Given Create a release as a lead and add new dashboard, gadget for that release
 #When Hide the release and check to gadget added for particular release
 #Then Should show that Configured release is hidden
 #When Delete that Release and check for gadget added
 #Then Should display message The Configured release is either deleted or you dnt have permission
  #

@ProjectStatus
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE


