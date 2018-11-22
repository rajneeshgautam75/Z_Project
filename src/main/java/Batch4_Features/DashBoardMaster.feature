
Feature: Create DashBoard
  @DashBoard
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


  @DashBoard
  Scenario:1 Creating a dashboard with all fields
    Given user is in Dashboard Page
    When user adds new Dashboard with name,description,2 Gadget layout and private type
    Then user is able to create dashboard
    When User adds new dashboard with name,description,1 Gadget layout and project team
    Then User is able to create new dashboard with all possible fields
    When user adds New dashboard with name ,description,1 Gadget layout and any logged in
    Then user is able to create dashboard with all possible fields

@DashBoard
Scenario: 2  Creating a dashboard with required fields
   Given User is in a Dashboard page
   When  User creates dashboard with long name one twenty eight char
   Then  user should able to create successfully
   When  user Creates dashboard with long desc with two fifty six char
   Then  User Should able to Create successfully
   When  User creates dashboard with name containing only lowercase char
   Then  user should  able to create Successfully
   When  User creates dashboard with name containing only UpperCase char
   Then  user should able to Create successfully
   When  user creates dashboard with name containing only number
   Then  user sholud able to create successfully
   When  user creates a dashboard with name containing only international char
   Then  user Should able to Create Successfully
   
   @DashBoard
Scenario:3 Change the page size of the dashboard
    Given User is In DashBoard Page
    When  user have more than hundred dashboards and change pagination from ten to twenty five
    Then  user able to view the selected page size
    When  user have more than hundred dashboard and changes pagination to fifty
    Then  User Able to view the selected page size 
    When  user have more than hundred dashboards and changes pagination to hundred
    Then  user Able to view the Selected page size 
    When  user have more than hundred DashBoard and Changes pagination to from hundred/fifty/twentyfive to ten
    Then  User able to see the selected page size 
  
   @DashBoard
Scenario:4 Change the paginations
    Given User is In a Dashboard page
    When  user Clicks on any page to change , next , prev when page size set to Ten
    Then  Should be able to change the pagination as selected
    When  User clicks on any page to change , next , prev when page size set to Twenty five
    Then  should be able to change pagination as selected
    When  User clicks On any page to change , next , prev when page size set to Fifty
    Then  Should be able to Change Pagination as Selected
    When  User clicks On any page to change , next , prev when page size set to Hundred
    Then  should be Able to Change pagination as selected
    
    
     @DashBoard
  Scenario: 5 Edit the existing dashboard 
    Given User is In the Dashboard page
    When  user Adds the new DashBoard
    And   user edits the Existing Dashboard name and save
    Then  Should be able to edit the dashboard name 
    When  User Edits the existing dashboard Description and Save
    Then  Should be able to edit the dashboard description  
    When  user edits the existing dashboard Type and Save
    Then  should be able to edit dashboard type
    When  user Edits the existing dashboard layout and save
    Then  should be able to edit dashboard layout
  
  @DashBoard
   Scenario: 7 Deleting the dashboard 
   Given user is in a dashboard Page
   When  User adds a new dashboard
   Then  dashboard  should be added
   When  user select a dashboard and delete the dashboard on having permission to delete
   Then  should be able to delete a dashboard successfully
   When  user adds the new Dashboard
   Then  Dashboard Should be added
   When  user select a dashboard have all type of gadgets in it and delete 
   Then  should be able to delete a dashboard
   When  user add a new Dashboard
   Then  dashboard should be Added
   When  user select a dashboard click on delete icon on confirmation popup click on cancel
   Then  deletion should be canceled
   
      @DashBoard
  Scenario: 6 Search a dashboard which is on any page
    Given User is in a dashboard Page
    When  User Search a dashboard with name in page one
    Then  Should be able to Search dashboard sucessfully
    When  user Search a dashboard which is on any page
    Then  Should be able to Search Dashboard sucessfully
    When  user Search the dashboard name containing special character 
    Then  should be able to search dashboard sucessfully

@DashBoard
Scenario: 8 As Manager/Lead/Tester/CustomRole, Add 'Test Automation status' in emtpy Dashboard 
Given User is in manage dashboard page
When user click on add dashboard symbol and create a dashboard
Then dashboard created successfully
When user add first Test Automation status gadget by clicking + symbol
Then first Test Automation status gadget added successfully
When user add second Test Automation status gadget by clicking add gadget button
Then second Test Automation status gadget added successfully
When user add third Test Automation status gadget and select normal project in configure gadget detail and save
Then third Test Automation status gadget added successfully
When user add fourth Test Automation status gadget and select restricted project in configure gadget detail and save
Then fourth Test Automation status gadget added successfully
When user add fifth Test Automation status gadget and select isolated project in configure gadget detail and save
Then fifth Test Automation status gadget added successfully

@DashBoard
Scenario: 23 As Manager/Lead/Tester/CustomRole, Add 'Test Automation Distribution' Gadget in emtpy Dashboard  
Given User is in manage dashboard page
When user click on add dashboard symbol and create a Dashboard
Then Dashboard created successfully
When user add first Test Automation Distribution gadget by clicking + symbol
Then first Test Automation Distribution gadget added successfully
When user add second Test Automation Distribution gadget by clicking add symbol
Then second Test Automation Distribution gadget added successfully

@DashBoard
Scenario: 24 As Manager/Lead/Tester/CustomRole, Add 'Test Automation Distribution' Gadget by Phase
Given User is in normal project page
When user navigate to test repository page
And create a phase with name and description
Then phase should be created successfully
When user selects restricted project
And navigate to test repository page
And create a Phase with name and description
Then phase should be created successfully in restricted project
When user selects isolated project
And navigate to test repository page
And create a phase with Name and Description
Then phase should be created successfully in isolated project
When user navigate to dashboard page
Then user successfully navigated to dashboard page
When user create a new dashboard
Then dashboard should be created successfully 
When user add Test Automation Distribution Gadget by Phase for normal project
Then Test Automation Distribution Gadget for normal project added successfully
When user add Test Automation Distribution Gadget by Phase for restricted project
Then Test Automation Distribution Gadget for restricted project added successfully
When user add Test Automation Distribution Gadget by Phase for isolated project
Then Test Automation Distribution Gadget for isolated project added successfully


@DashBoard
Scenario: 25 As Manager/Lead/Tester/CustomRole, Add 'Test Automation Distribution' Gadget by tag
Given User is in normal project page
When user navigate to test repository page
And create a Phase with Name and Description
Then Phase should be created successfully
When user add a testcase with tags
Then testcase should be added with tags
When user selects restricted project
And navigate to test repository page
And creates a phase with name and description
Then Phase should be created successfully in restricted project
When user add a testcase with mutiple tags
Then testcase should be added with multiple tags
When user selects isolated project
And navigate to test repository page
And creates a phase with Name and Description
Then Phase should be created successfully in isolated project
When user add a testCase with mutiple tags
Then testCase should be added with multiple tags
When user navigate to dashboard page
Then user successfully navigated to dashboard page
When user creates a new Dashboard
Then Dashboard should be created successfully 
When user add Test Automation Distribution Gadget by tag for normal project
Then Test Automation Distribution Gadget by tag for normal project added successfully
When user add Test Automation Distribution Gadget by tag for restricted project
Then Test Automation Distribution Gadget by tag for restricted project added successfully
When user add Test Automation Distribution Gadget by tag for isolated project
Then Test Automation Distribution Gadget by tag for isolated project added successfully

@DashBoard
Scenario: 27 As Manager/Lead/Tester/CustomRole, Add 'Test Automation Distribution' Gadget by selecting specific Tag
Given User is in normal project page
When user navigate to test repository page
And creates a Phase with Name and Description
Then phase should be created Successfully
When user add a testcase with multiple tags
Then testcase should be Added with multiple tags
When user navigate to dashboard page
Then user successfully navigated to dashboard page
When user creates a new Dash_board
Then dashboard should be created Successfully 
When user add Test Automation Distribution Gadget by selecting one tag 
Then Test Automation Distribution Gadget by tag added successfully
When user add Test Automation Distribution Gadget by selecting ten tag 
Then Test Automation Distribution Gadget by tag Added successfully
When user add Test Automation Distribution Gadget by selecting fifty tag 
Then Test Automation Distribution Gadget by Tag added successfully
When user add Test Automation Distribution Gadget by selecting hundered tag 
Then Test Automation Distribution Gadget by Tag Added successfully

@DashBoard
Scenario: 28 As Manager/Lead/Tester/CustomRole, Add 'Test Automation Distribution' Gadget with Refresh interval
Given User is in manage dashboard page
When user click on Add dashboard symbol and create a dashboard
Then dash_board created successfully
When user Add Test Automation Status Gadget with Refresh interval as one hour
Then Test Automation Status Gadget with Refresh interval as one hour created successfully
When user Add Test Automation Status Gadget with Refresh interval as four hour
Then Test Automation Status Gadget with Refresh interval as four hour created successfully
When user Add Test Automation Status Gadget with Refresh interval as eight hour
Then Test Automation Status Gadget with Refresh interval as eight hour created successfully
When user Add Test Automation Status Gadget with Refresh interval as one day
Then Test Automation Status Gadget with Refresh interval as one day created successfully
When user Add Test Automation Status Gadget with Refresh interval as one week
Then Test Automation Status Gadget with Refresh interval as one week created successfully




#Srikant1
@DashBoard
Scenario: create different releases for the project
Given User select the project
 When User create a releases for the project
 Then releases is created for the project
 When User select the project and first release and add the node
  And User create a nine automated and ninty one manual testcases in testRepository
 When User select the second release and add the node
  And User create a hundred automated and nine hundred manual testcases in test repository
 When User select the third release and add the node
  And User create a thousand automated and thousand manual testcases in test repository
 When User select the fourth release and add a node
  And User create a thousand automated and hundred manual testcases in test repository
 When User select the fifth release and add a node
  And User create only thousand automated testcases in test repository

@DashBoard
Scenario: 11 Add 'Test Automation Status Gadget' with project/release without any testcase
Given User add a release with no testcases
 When User create a dashboard 
  And User add a Test Automation Status gadget with project/release
 Then User sucessfully navigated to the test automation gadget page

@DashBoard
Scenario: 12 Add 'Test Automation Status Gadget' with project/release having only manual testcases
Given User is in the dashBoard page
 When User create a dashboard with available fields 
  And User add a Test Automation Status gadget with project/release contains only manual testcases
 Then User should be navigated to the test automation status gadget page contains manual testcase information

@DashBoard
Scenario: 13 Add 'Test Automation Status Gadget' with project/release having only automated testcases
Given User is in the dashboard page
 When User create a dashboard with the available fields 
  And User add a Test Automation Status gadget with project/release contains only automated testcases
 Then User should be navigated to the test automation status gadget page contains automated testcase information

@DashBoard
Scenario: 14 Add 'Test Automation Status Gadget' with project/release having  automated and manual testcases
Given User is in the Dashboard page
 When User create a dashboArd with the available fields 
  And User add a Test Automation Status gadget with project/release contains nine automated and ninty one manual testcases
 Then gadget added successfully with nine automated and ninty one manual testcase information
 When User add a Test Automation Status gadget with project/release contains hundred automated and nine hundred manual testcases
 Then gadget added successfully with hundred automated and nine hundred manual testcase information
 When User add a Test Automation Status gadget with project/release contains thousand automated and thousand manual testcases
 Then gadget added successfully with thousand automated and thousand manual testcase information
 When User add a Test Automation Status gadget with project/release contains five thousand automated and hundred manual testcases
 Then gadget added successfully with five thousand automated and hundred manual testcase information
 When User add a Test Automation Status gadget with project/release contains only five thousand automated testcases
 Then gadget added successfully with only five thousand automated testcases
 When User add a Test Automation Status gadget with project/release contains ten automated and five thousand manual testcases
 Then gadget added successfully with ten automated and five thousand manual testcase information

 @DashBoard
Scenario: 15 Add 'Test Automation Status Gadget' with project/release having with different refresh intervals
Given User is in the dashbOard page
 When User create a dashbOard with the available fields
  And User add a Test Automation Status gadget with the project/release
 Then User is able to change the refresh rate to different intervals 
 Then User should be navigated to the edited test automation status gadget page 

 @DashBoard
Scenario: 10 Add 'Test Automation Status Gadgets' with project/release having specific intervals 
Given User is in a dashbOard page
 When User create a dashbOard with the Available fields
  And User add a Test Automation Status gadget with the project/release with interval as One Hour
 Then User is able to validate the added Test Automation Status gadget
 When User add a Test Automation Status gadget with the project/release with interval as Four Hour 
 Then User should be able to validate test automation status gadget 
 When User add a Test Automation Status gadget with the project/release with interval as Eight Hour 
 Then should be able to validate the test automation status gadget
 When User add a Test Automation Status gadget with the project/release with interval as One Day 
 Then User should be Able to validate test automation status gadget 
 When User add a Test Automation Status gadget with the project/release with interval as One Week 
 Then Should be able to validate the Test automation status gadget
  
@DashBoard
Scenario: 17 Add 'Test Automation Status Gadgets' with project/release contains any interval 
Given User is in a DashbOard page
 When User Create a dashbOard with the Available fields
 Then dashBoard should be created successfully
 When User Add a Test Automation Status gadget with the project/release with interval and save
 Then gadget added successfully 
 When User minimize/maximize the added Test Automation Status gadget
 When User add a Test Automation Status gadget without entering project/release
 Then gadget should be added successfully 
 When User minimize/maximize test automation status gadget 
 Then User successfully maximize the gadget
 
@DashBoard
Scenario: 16 Edit 'Test Automation Status Gadget' and change the selected project and release 
Given User is in A DashBOard page
 When User Create a dashBOard with the Available fields
 Then DashBoard should be created successfully
 When User Add a Test Automation Status gadget with the project/release and save it
 Then Gadget added reconfigured successfully 
 When User edit a Test Automation Status gadget without release
 Then gadget should not saved
 When User edit a TEst Automation status gadget with project/release
 Then gadget should be reconfigured and edited Successfully
 When USer edit Test Automation Status gadget without project
 Then Gadget should not be saved
 

@DashBoard
Scenario: 9 Add 'Test Automation status' and select a project and release and refresh time and save
#Given Manager is in administration page for creating projects  
Given User create a releases for the projects in testRepository 
 When User is in the DashBoard page 
 When User create a DashBoard
 When User add a Test Automation Status gadget and select project and release
 Then GadgEt added successfully
 When User add a tEst Automation Status gadget and select a project and release name containing only lowercase char
 Then gadget created successfully
 When User add a teSt Automation status gadget and select a project and release name containing only international char
 Then Gadget is added successfully
 When User add a tesT automation status gadget and select a project and release name containing only special char
 Then gAdget is adDed successfully
 When User add a test Automation status gadget and select a project and release name with max char limit
 Then gadGet is addEd successfully
 When User add a test Automation status gadget and select a project and release name with min char limit
 Then gadgeT is addeD successfully
 When User add a test AutoMation status gadget and select project and release name containing uppercase
 Then gadget is created successfully 
 
@DashBoard
 Scenario: 18 Delete Test Automation Status Gadget
Given User in the project page and launch dashboard
	When create dasboard
When select dashboard and add Test Automation Status Gadget
	And save and delete the Test Automation Status Gadget
	And add Test Automation Status Gadget and delete
Then add Test Automation Status Gadget and minimize then delete
	Then add Test Automation Status Gadget and delete maximized gadget
	Then add Test Automation Status Gadget and click on delete and cancel the confirmation
 
 @DashBoard
 Scenario: 19 delete a selected project from Project Setup app after saving Test Automation Status Gadget
Given login with manager and create a project
	When launch Dashboard and create a dashboard 
When add test automation Gadjet with project and release and save
	Then delete the release and project
	
	 @DashBoard
	Scenario: 20 Change the dashboard layout after saving a Test Automation Status Gadget
Given user in the project page and launch the dashboard
	When create a dashboard
When select a created dashboard and add test automation status gadjet
	And change the layout from one to two and two to one
	Then add test automation gadjet and change the layout without saving the gadjet
	
	@DashBoard
	Scenario: 21 Add multiple Test Automation Status Gadget and change the Dashboard layout
Given user in project page and launch dashboard
	When  Add multiple Test Automation Status Gadget and change the Dashboard layouts from one to two
When Add multiple Test Automation Status Gadget with different projects in same dashabord
	And  Add multiple Test Automation Status Gadget with same projects but different releases in same dashabord
	And Add multiple Test Automation Status Gadget with same project release but different refresh intervals
And Add Test Automation Status Gadget in multiple Dashboards atleast five Dashboards with same project and release
	Then Add Test Automation Status Gadget in multiple Dashboards atleast five Dashboards with different project and release
	
	@DashBoard
	Scenario: 22 Edit and update some testcasesafter saving Test Automation Status Gadget
Given user in project page and select the dashboard
	When create dashboard and add automation gadjet and save
When Edit and change some testcases from manual to automated after saving Test Automation Status Gadget 
	Then Should be able to see updated gadget
When  Edit and change some testcases from automated to manual after saving Test Automation Status Gadget
	Then Should be able to see updated Test Automation Status Gadget
	When Add some new manual testcases after saving Test Automation Status Gadget
	Then Should be able to see updated gadget after adding manual testcases
	When Add some new automated testcases after saving Test Automation Status Gadget
	Then Should be able to see updated gadget after adding automated testcases
	When  Delete some manual testcases after saving Test Automation Status Gadget
	Then Should be able to see updated gadget after deleting manual testcases
	When  Delete some automated testcases after saving Test Automation Status Gadget
	Then Should be able to see updated gadget after deleting automated testcases
	
		@DashBoard
	Scenario: 26 Add Test Automation Distribution Gadget by selecting specific Phase
 Given user in the repository page to addphases
	When launch dashboard Add Test Automation Distribution  Gadget by selecting Ten Phase out of fifty
	When Add Test Automation Distribution  Gadget by selecting twenty five Phase out of fifty
	And Add Test Automation Distribution  Gadget by selecting fifty Phase out of fifty
	Then  Add Test Automation Distribution  Gadget by selecting hundred Phases


@DashBoard
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
