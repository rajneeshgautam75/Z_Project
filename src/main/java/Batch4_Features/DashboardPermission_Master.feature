
Feature: DashBoard Permission Scenarios

@DashPermission
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@DashPermission
  Scenario: 1 Able to view Components for adding Dashboard after Clicking on plus button on Dashboard
  Given user opens the DashBoard 
  Then  user Able to Launch Dashboard page
  When  user clicks on plus button
  Then  able to view Components like Name,Description,Layout and Access Type in DashBoard
  
  @DashPermission  
 Scenario: 2  Able to view 3 type of Sharing options in dropdown while creating dashboard
 Given user opens DashBoard Window
 When  User clicks on plus icon 
 And   user Able to view three Type of Sharing options in dropdown while creating dashboard
 Then  user Able to view three types of access type
 
  @DashPermission
 Scenario: 3 Able to add a Dahsboard with all Access Type
 Given custom user launches DashBoard Window
 When  custom user creates new DashBoard of  Access type Project Team
 Then  custom user Should able to add a Dahsboard Access type Project Team
 When  custom user adds a Dahsboard Access type Any Logged in User
 Then  custom user to able to add a Dahsboard Access type Any Logged in User
 When  custom user creates a dashboard with access type Private
 Then  should be able to create a dashboard with access type Private
 
  @DashPermission
 Scenario: 4  Attempt to view Private DashBoard other then creator
 Given  Test User is In A DashBoard Page
 When   Test user Create a Dashboard whose access type is type Private
 Then   Should not show to Otheruser if dashboard is Private type
 
  @DashPermission
Scenario: 5  Attempt to Create dashboard without selecting Mandatory fields
Given customer is in DashBoard
When  customer Attempts to Create dashboard without selecting Mandatory fields 
Then  should not Allow to create without Selecting mandatory fileds



@DashPermission
Scenario: 6 Action tab and grid actions should be visible to dashboard creator
Given User is in project page
When user clicks on manage dashboard
Then manage dashboard page should be displayed
When user add a new dashboard
Then Dashboard Should be created successfully
And user view the action column options in grid

@DashPermission
Scenario: 7 Able to view all dashboards created by different users if all dashboards having Share type Any Logged in user

Given Login as manager_Credential
When manager clicks on Manage dashboard
Then Manage dashboard page should be displayed
When manager add a new Dashboard with share type any logged in user
Then first dashboard Should be created successfully
When login as lead user
When lead clicks on Manage dashboard
Then manage dashboard page should be Displayed
When lead add a new Dashboard with share type any logged in user
Then second dashboard Should be created successfully
When login as tester user
When tester clicks on Manage dashboard
Then manage dashboard Page should be Displayed
When Tester add a new Dashboard with share type any logged in user
Then third dashboard Should be created successfully
When login as another lead credential
And naviagte to dashboard page
And search and view all dashboard created by different users
Then able to view the all dashboards created by different users


@DashPermission
Scenario: 8 Attempt to Edit dashboards of Share type Any Logged in user other then creator. 

Given Login as lead credential
When lead clicks on Manage_dashboard
Then Manage_dashboard page should be displayed
When lead add one Dashboard with share Type any logged in user
Then First dashboard Should be created successfully
When lead add second Dashboard with share Type any logged in user
Then second Dashboard Should be created successfully
When lead add third Dashboard with share Type any logged in user
Then third Dashboard Should be created successfully
When login as other lead credential
And try to edit the dashboard
Then should not allow to edit the dashboard

@DashPermission
Scenario: 9 DashBoard having Share type Project Team should show only to those who having project access in all added gadgets. 

Given Login as lead Credential
When lead navigate to test repository page
And Add a node with name and description
Then node sucessfully created
When user add multiple(five) testcases in node
Then testcases successfully added in node
When lead navigate to test planning page
And create a cycle and add phase to cycle and assign to lead
Then testcases successfully assign to lead
When lead navigate to test exexution page
And execute all testcases to Pass
Then testcases successfully executed to Pass
When lead navigate to dashboard page
Then manage Dashboard page should be displayed
When lead create a dashboard with share type as Project Team
Then dashboard should be successfully created 
When lead add a gadget and save it
Then gadget should be successfully saved
When login as other lead Credential
And navigate to dashboard page
Then dashboard page should be_displayed
When second user attempt to view the dashboard if user dont have acess to project
Then should not show the dashboard 


@DashPermission
Scenario: 10 Attempt to Edit dashboard's of Share type Project Team other then creator.
Given Lead is in DashBoard Page
 When Add a DashBoard by click on the dashBoard plus symbol
  And Add a DashBoard of share type 'project team' with other details
 When Login with another lead
 When select the added DashBoard for editing
 Then Should not allow to edit other than creator

@DashPermission
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@DashPermission 
Scenario: 11 Creator/Manager should be able to delete any access type of dashboard. 
Given Lead is in the DashBoard page
 When Add a DashBoard by click on the DashBoard plus symbol
  And Add a DashBoards with different share types
 When DashBoard is added added
 When select the added DashBoard
 Then should be able to delete the DashBoard
 When As a Manager,Launch DashBoard page
  When select the Added DashBoard
 Then Should be able to delete the Dashboard

@DashPermission
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@DashPermission
Scenario: 12 Attempt to Delete dashboard's of different Share type other then creator and 'TestManager'.
Given Lead Launch DashBoard page
 When Add a DashBoards with different share types by clicking add dashboard plus symbol
  And DashBoards is created successfully
 When As a another Lead,Launch DashBoard page
 Then Attempt to Delete dashboard's of share type Any logged in User other then creator and 'TestManager'
 When select the dashBoard's of share type 'project team' and attempt to delete the dashboard
 Then Should not allow to Delete dashboard's of share type Project other then creator and 'TestManager'
 
@DashPermission
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE 
 
 @DashPermission
Scenario: 13 Change Share type of dashboard from one access type to another and user's should able to view dashboard accordingly 
Given As a Lead,Launch the DashBoard Page
 When Add the DashBoard with share type with private
  And change the share type from private to Any Logged in User by clicking on edit dashboard
 Then Dashboard should be visible to all users
 When Add the DashBoard with share type Any Logged in User
 Then Should be able to create dasboard
 When Select the added DashBoard and Add test automation status gadget
 When change the dashBoard share type to private and save by selecting the edit dashBoard
 Then Should be able to save the DashBoard
 When login as other user and Launch DashBoard
 When attempt to view the DashBoard
 Then Should not show dashBoard as this dashboard sharing is changed to private
 
@DashPermission
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@DashPermission
Scenario: 14 Change Share type of dashboard from Private to Project Team
Given test user is In a Dashboard page
When  test user Creates some data and add a dashboard of Share type Private with 1/2 gadget
Then  test user Able to Change from Private to Project
When  test user Changes the dashboard Share type to project
Then  test user Able to change From Private to Project
When  Change the Share type of Dashboard from Private to Project Team and Other users should able to view dashboard
Then  user Able to view dashboard if all the projects referenced in the gadgets of the dashboard are accessible to the user

 
@DashPermission
Scenario: 15 Change Share type of dashboard from Any Logged in user to Project Team and Other user's should able to view dashboard if  all the projects referenced in the gadgets of the dashboard are accessible to the user. 
Given As Lead,Launch Test Repository to create testcases
 When launch the DashBoard Page
  And Add DashBoard by clicking on plus symbol
 When Add the DashBoard with shareType Any Logged in user
 Then Should be able to add DashBoard
 When Select the added DashBoard
 When add project status gadget by clicking on gadget plus symbol
 Then Should be able to Save the gadget
 When Change shareType from any logged in user to project team by clicking edit dashboard symbol
 Then Able to change from any logged in user to project team
 When Login as second lead,Launch DashBoard
 When search the edited dashboard
 Then Should not allow to view dashboard
 When Login as manager,Launch DashBoard
 When search the dashboard
 Then Should be able to view as managers
 
 
 @DashPermission
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE 
 
 @DashPermission
 Scenario: 16 Able to Search dashboard having different Share type  by Logged in user.
Given Login as a lead, create dashborads of different sharetypes
 When Search for a DashBoard of sharetype 'Private'
 Then Should be able to search dashboard of sharetype 'Private'
 When Search for a DashBoard of sharetype 'Any Logged in User'
 Then Should be able to search dashboard of sharetype 'Any Logged in User'

@DashPermission
Scenario: 17  Able to Search dashboard having Share  type Project Team by Creator+Manager+User
Given Create a Dashboard of Sharetype Project Team
When  Login as Test manager and search for DashBoard, which is created for a project assigned
Then  Should be able to search Dashboard for project assigned and logout
When  Login as Lead and search for DashBoard, which is created for a project assigned
Then  Should be able to search Dashboard for project assigned

@DashPermission
Scenario: 18 Able to Launch Dashboardurl and view gadgets if user have permissions.
Given Login as Test Manager and navigate to Manage Projects page
 When Select a project and assign the project to Lead, Tester and logout
  And Login as Lead, add dashboard, add gadget and save
 Then Dashboard and Gadget should be added successfully
 When Login as Tester and hit the DashBoard 'URL' 
 Then Able to Lauch dashboard and view gadgets

@DashPermission
Scenario: 19 Dashboardurl should navigate to dashboard if user dont have access to the dashboard.
Given Login as a Test Manager and launch administration
 When click on Manage users, assign one project to lead, another project to tester and Logout
	And Login as a Lead, create a dashboard with access type Project Team, save and Logout
 Then DashBoard should be added successfully 
 When Login as Tester, launch dashboards page and hit the URL
 Then Should navigate to dashboard page
 
 @DashPermission
 Scenario: 20 Attempt to view gadgets with data if release is hidden/deleted
Given Create a release as a lead and add new dashboard, gadget for that release
 When Hide the release and check to gadget added for particular release
 Then Should show that Configured release is hidden
 When Delete that Release and check for gadget added
 Then Should display message The Configured release is either deleted or you dnt have permission
 
 @DashPermission
 Scenario: 21 All Gadget info should show when user doesnt have access to that project and Dashboard is having zephyr access type
Given Login as Manager and navigate to manage projects page
 When Create two new projects 
	And assign all users for first project and assign all users except lead for second project
	And Now as Manager create a dashboard with sharetype any logged in user
 Then Should be able to create Dashboard successfully and logout
 When Now login as lead and check the gadget
  And Add two project status gadget with both projects and one requirement status gadget with second project
 
 @DashPermission
 Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
