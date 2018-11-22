Feature: Overall Defect Scenario


@Overall
 Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


 @Overall
 Scenario: 1 Add Overall Defects Gadget in emtpy Dashboard by clicking on Add Gadget Button
    Given User Logins as dashboard user
    When  User goes to Dashboards
    Then  Should launch dashboard window
    When  user Adds dashboard by clicking on plus button
    Then  The New Dashboard To be Added
    When  user moves the added DashBoard
    Then  Should be Successfully to Move on Added DashBoard
    When  user Adds Overall Defects Gadget by clicking on plus button 
    Then  overall defect gadget to be added
    When  user Selects project,Release and refresh rate, Saves It
    Then  Should  save Overall Defect Gadget
 
 @Overall   
 Scenario: 4 As Manager, Add Overall Defects Gadget and select a release out of 100 releases
 Given  User Logins as Manager credentials
 When   user Sets DTS to JIRA
 Then   Should be able to set
 When   user Goes to release setup ,Create 100 releases
 Then   should able to create releases
 When   User is In a DashBoard Page 
 Then   Should be Launched DashBoard Window
 When   User Adds New DashBoard
 Then   New DashBoard Should be added
 When   user clicks on added dashboard
 Then   Added Dashboard should be selected
 When   By clicking on "+" button, user adds Overall Defects Gadget
 Then   overall Defect Gadget should be added
 When   user selects one release out of 100 releases
 Then   Should be able to select one release out of 100 releases
 
 @Overall
 Scenario: 5  As Manager, add Overall Defects Gadget with Refresh interval as 1 hour
 Given user Logins as Manager
 Then  should be able to Login successfully
 When  user Goes To Dashboards
 Then  should launch Dashboard Window
 When  user Adds dashboard By clicking on "+" button
 Then  should able to Create a New dashboard
 When  user clicks On added dashboard
 Then  should be able to select added Dashboard
 When  user Adds Overall Defects Gadget by clicking on "+" button
 Then  Should be able to add "Overall Defect Gadget"
 When  user Selects project,Release and refresh rate as 1 hour, Save it
 Then  should be able to save Overall Defect Gadget
 
 
 @Overall
 Scenario: 6 As Manager, Add Overall Defects Gadget with Refresh interval as 4 hours
 Given User Logins As Manager
 Then  should be able to login
 When  User goes to dashboards
 Then  should Launch dashboard Window
 When  user adds a dashboard by clicking on plus button
 Then  Dashboard should be able to create
 When  User clicks on Added DashBoard
 Then  Should be select added dashboard
 When  User Adds Overall Defects Gadget By clicking on plus button
 Then  should be able to add Overall Defect Gadget
 When  User Selects project,Release and refresh rate as 4 hour, Save it
 Then  Should be able to Save Overall Defect Gadget
 
@Overall
 Scenario: 7 As Manager, add Overall Defects Gadget with Refresh interval as 8 hours
 Given User logins as manager Credentials
 Then  user should be able to login
 When  User goes To Dashboards
 Then  Should Launch DashBoard Window
 When  user adds the dashboard by clicking on plus button
 Then   dashboard should be able to create
 When  User Clicks On an Added Dashboard
 Then  should be Able to select dashboard which added
 When  user adds Overall Defects Gadget By clicking On Plus button
 Then  should be able to add an Overall Defect Gadget
 When  User Selects Project,Release and Refresh rate as  8 hour, Save it
 Then  Should be possible to save Overall Defect Gadget
 
@Overall
Scenario: 8 As Manager, Add Overall Defects Gadget with Refresh interval as 1 day
Given User logins as manager credentials
Then  Should be able to Login Successfully
When  User is in DashBoardPage
Then  should be able to launch dashboard window
When  user adds a new dashboard by clicking On Plus Button
Then  DashBoard to be able to Create
When  user selects an added DashBoard
Then  should select added dashboard
When  User Adds overall defects gadget by clicking on plus button
Then  overall defect gadget should be able to add
When  user selects project,release and refresh rate as one day,save it
Then  overall defect gadget should be able to save

 @Overall
Scenario: 9  As Manager, Add Overall Defects Gadget with Refresh interval as 1 week
Given user logins as manager credentials
Then  user should be able to login successfully
When  user is in dashboard page
Then  Should able to Launch dashboard window 
When  user adds a New dashboard by clicking on plus button
Then  Should be able to add new dashboard
When  user clicks On Added DashBoard
Then  user should be able to select added dashboard
When  User Adds overall defects Gadget by clicking on "+" button
Then  overall gadget defect should Able to create
When  user selects project,Release and refresh rate as 1 week, save it
Then  Should be able To Save "Overall Defect Gadget"

 
 
 
 
 
 @Overall
  Scenario: 29  Add dashboard by clicking on plus button at least five dashboards
 Given  user logins as Manager credentials
 When   User Is In a DashBoard Page
 Then   user should be launched the dashboard window
 When   user adds a five new dashboards by clicking on plus button
 Then   dashboards should be created
 When   user clicks on added new dashboard
 When   user adds Overall Defects Gadget By clicking on plus button in all added dashboards
 Then   Should be able to Add Overall Defect Gadget

 
 


@Overall
Scenario: 21 As Manager, Add Overall Defects Gadget for Project and release having defects linked to executions with status PASS/FAIL/WIP/BLOCKED/CUSTOM
Given Login as manager Role
When manager set DTS to Jira
And user launch test repository page
And add a phase with name and description
Then phase should be added successfully
When user add multiple(five) testcases
Then multiple testcases should be added to the phase
When user launch test planning module
And create a test cycle and assign it
Then testcases assigned to the user
When user launch test execution and navigate to phase
And execute the testcases to status Pass/Fail/WIP/Blocked/Custom
Then successfullly executed the testcases to Pass/Fail/WIP/Blocked/Custom status 
When user selects first testcase and link defects with Open
Then defect should be linked with status Open
When user selects second testcase and link defects with Inprogress
Then defect should be linked with status Inprogress
When user selects third testcase and link defects with Done
Then defect should be linked with status Done
When user launch dashboard
Then dashboard page should be displayed
When user Add dashboard by clicking on add symbol button
Then dash_board should be created successfully
When user selects dashboard and add Overall Defects Gadget by clicking on add symbol button
Then Should be able to Add overall Defect Gadget
When user selects project, release and refresh rate,save it
Then Should show total defect count and count by status properly
#
@Overall
Scenario: 22 As Manager, Edit Overall Defects Gadget and change the refresh interval from One-hour to four-hour
Given manager is in project page
When user click on manage dashboard
Then dash_board page should be displayed
When user add dashboard by clicking on add symbol button
Then dashboard should be added successfully
When user add Overall Defects Gadget to the dashboard
Then Overall defects gadget should be added successfully
When user select project,release and refresh rate as One hour,save it
Then overall defect gadget should be saved
When user edit the refresh rate from one hour to four hour
Then should be able to change the refresh rate

@Overall
Scenario: 23  As Manager, Edit Overall Defects Gadget and select different release within same project and save the gadget 
Given manager is in project page
When user click on manage dashboard
Then dash_board page should be displayed
When user add Dashboard by clicking on add symbol button
Then dash_board should be added successfully
When user add Overall defects gadget to the dashboard
Then Overall defect gadget should be added successfully
When user select project,release and refresh rate,save it
Then Overall defect gadget should be saved
When edit the gadget and select other release in same project and save
Then should reflect defect count for latest release

@Overall
Scenario: 24 As Manager, Edit Overall Defects Gadget and select different project and release and save the gadget
Given manager is in project page
When user click on manage dashboard
Then dash_board page should be displayed
When user Add Dashboard by clicking on add symbol button
Then dashboard should be Added successfully
When user add Overall Defects gadget to the dashboard
Then Overall Defects gadget should be added successfully
When user select project,release and refresh rate ,save it
Then Overall defect gadget should be saved successfully
When user edit the gadget and select other project and release, save it
Then Should reflect defect count for latest saved project release

@Overall
Scenario: 26 As Manager, delete saved Overall Defects Gadget
Given manager is in project page
When user click on manage dashboard
Then dash_board page should be displayed
When user add dashboard by clicking on add symbol
Then dashboard should be added Successfully
When user add Overall Defects Gadget by clicking on add symbol button
Then overall defect Gadget added successfully
When user select project,release and refresh rate , save it
Then should be able to Save Overall Defect Gadget
When user delete the saved Overall Defect Gadget
Then should be able to delete the gadget


@Overall
Scenario: 28 As Manager, Add multiple Overall Defects Gadget in single dashboard
Given manager is in project page
When user click on manage dashboard
Then dash_board page should be displayed
When user add Dashboard by clicking on add symbol
Then Dashboard should be added Successfully
When user add first Overall Defects Gadget by clicking on add symbol button
Then first overall defect Gadget added successfully
When User select project,release and refresh rate , save it
Then should be able to save first Overall Defect Gadget
When user add second Overall Defects Gadget by clicking on add symbol button
Then second overall defect Gadget added successfully
When User select project,release and refresh rate , save it
Then should be able to save second Overall defect Gadget
When user add third Overall Defects Gadget by clicking on add symbol button
Then third overall defect Gadget added successfully
When User select project,release and refresh rate , save it
Then should be able to save third Overall defect Gadget
When user add fourth Overall Defects Gadget by clicking on add symbol button
Then fourth overall defect Gadget added successfully
When User select project,release and refresh rate , save it
Then should be able to save fourth Overall defect Gadget
When user add fifth Overall Defects Gadget by clicking on add symbol button
Then fifth overall defect Gadget added successfully
When User select project,release and refresh rate , save it
Then should be able to save fifth Overall defect Gadget
 
 
 @Overall
 Scenario: 35  As Tester,Change the dashboard layout from 1 to 2/2 to 1 after saving multiple 'Overall Defects Gadget'
 Given  user Logins as Tester
 When   user clicks on Dashboard
 Then   Should be launched dashboard window
 When   user adds a new dashboard by clicking on + button
 Then   Dashboard should be added
 When    user selects the added DashBoard
 Then    DashBoard should be selected
 When   user adds Multiple "Overall Defects Gadget" By Clicking on '+' button
 Then   Overall defect gadget should be added
 When   User Changes the layout from 1 to 2
 Then   Should become 2 column layout
 When   user changes layout from 2 to 1
 Then   should become 1 column layout
 
 @Overall
 Scenario: 16 As Manager, Add 'Overall Defects Gadget' for Project and release, Link defect with any status
Given user Logins AS Manager
Then  Login should be successfull
When  user launchs TestRepository, Add Testcase, Launch Test Planning and assign Phase to Cycle
And   user goes to test execution, Execute a testcases and link defect with any status
Then  defect should link with any status which assigned by user
When  User is In a DashBoard Window
Then  user should able to launch dashboard window
When  User adds a New DashBoard by adding plus button
Then  A new DashBoard should be added by User
When  user clicks on a new dashboard which is added 
Then  user should able to select on dashboard which added
When  User Adds Overall Defect gadget by clicking on plus button
Then  overall defect gadget should be added by user
When  user selects Project,Release and refresh rate,saves it
Then  Defect count should show
 
 @Overall
 Scenario: 19 As Manager, Add 'Overall Defects Gadget' for Project and release having defects with status Done/Closed 
  Given user Login as Manager
  When  launch TestRepository, Add testcase, Launch Test Planning and assign phase to Cycle
  And   Go to test execution, Execute a testcases and link defect with status/closed
  Then  defect should link with status/closed
  When  user is In a DashBoardPage
  Then  DashBoard Window Should be Launched
  When  A new DashBoard is added By user
  Then  New DashBoard Should be added by user
  When  user clicks On DashBoard which Added
  Then  User should select Added DashBoard
  When  user adds overall defect gadget
  Then  overall defects gadget to be added
  When  user select the project,release and refresh rate,saves it
  Then  should be shown defect count 
  
  
  @Overall
Scenario: 10 Add 'Overall Defects Gadget' and select a project name, release name containing only Uppercase char
Given Logged in as manager
 Then Manager is logged in successfully
When navigate to defect tracking to set DTS
 Then Jira is set
 When create a project name containing uppercase letters
 Then project is created successfully
 When As a Lead,User select a project name containing uppercase
 Then uppercase release is created
 When User is in dashBoard page
 Then dashBoard window should be launched
 When User create a dashBoard
 Then created dashBoard is selected successfully
 When create a new dashBoard
 Then should be able to select added dashboard
 When Add 'Overall Defects Gadget' by clicking on plus button
 Then should be able to save gadget
 
 @Overall
 Scenario: 11 Add 'Overall Defects Gadget' and select a project name, release name containing only International char
Given Log in as manager
 Then Manager is Logged in successfully
 When launch administration
  And navigate to defectTracking to set DTS
 Then JIRA is set
 When launch manage projects to create a project name containing international char
 Then international character project is created successfully
 When As a Lead,User select a project name containing international char and create international character release
 Then international character release is created
 When User is in DashBoard page
 Then DashBoard window should be launched
 When User Create a dashBoard
 Then Created dashBoard is selected successfully
 When Create a new dashBoard
 Then should be able to select a added dashboard
 When Add 'Overall Defects Gadget' by clicking on the plus button
 Then Should be able to save gadget

@Overall
Scenario: 12 Add 'Overall Defects Gadget' and select a project name, release name containing only Special char
Given Log in as a manager
 Then Manager Logged in successfully
 When Launch administration
  And Navigate to defectTracking to set DTS
 Then JIRA is Set
 When Launch manage projects to create a project name containing Special char
 Then Special character project is created successfully
 When As a Lead,User select a project name containing Special char and create Special character release
 Then special character release is created
 When User is in a DashBoard page
 Then DashBoard Window should be launched
 When User Create A dashBoard
 Then Created DashBoard is selected successfully
 When Create a new DashBoard
 Then should be able to select a added Dashboard
 When Add the 'Overall Defects Gadget' by clicking on the plus button
 Then Should be able to save a gadget

@Overall
Scenario: 2 As Manager, Add Overall Defects Gadget for Normal Project not linked to any Jira Project

  Given Test Manager is in Defect Tracking page
 When  Set DTS to JIRA
  And Launch TestRepository, add testcase, Launch Test Planning and assign phase to cycle
  And Go to test execution, Execute a testcase and Link one defect
 Then Defect should be linked to testcase
 When Launch Dashboard window
 Then Should launch dashboard Window
 When Add dashboard by clicking on add button
 Then Should be able to Add new Dashboard
 When Click on added dashboard
  And  Add Overall Defects Gadget by clicking on add button
 Then Should be able to add Overall defect Gadget
 When Select created project,Release, refresh rate and click on save.
 Then Should show execution linked defect count by status
 
 
 
 @Overall
Scenario: 33 As Manager, Remove link of a defects from execution after saving  Overall Defects Gadget
Given Test Manager is in Test Repository Page 
 When Create a phase and add two testcases, launch Test planning and assign phase to cycle
	And Launch Test Execution, execute testcases and link defects
 Then Defects should be linked to particular testcases 
 When Launch DashBoards Page 
 Then DashBoards window  page should be launched
 When Click on dashboard created
 When Click on add gadget symbol and add Overall Defect gadget
 Then Overall Defect gadget should be added to dashboard
 When Configure gadget with project, release and refresh rate details
 Then should show defects linked
 When Launch test execution and De-link one defect from execution
  And View Overall Defects Gadget after de-linking one defect from executions
 Then Should show total defect count reduced by one
 
 
@Overall
Scenario: 34 As lead, Unassign/Remove execution having a linked defect after saving Overall Defects Gadget
Given Lead is in Test Repository page
 When Create phase, add testcases, launch Test Planning and assign phase to cycle
  And Launch Test Execution, execute testcase and Link defect with any status
 Then Defect should be linked with testcases
 When Launch Dashboards Page 
 Then Dashboards page should be launched
 When Add Dashboard by clicking on add button
 Then New dashboard should be added
 When Click on newly added dashboard
  And Add Overall Defects Gadget by clicking on add button symbol
 Then Overall Defect Gadget should be added
 When Select  project,Release,refresh rate and save it
 Then Should show proper defect count 
 When Go to test planning and unassign the texecution having defect
  And View Overall Defects gadget now after unassigning the executions
 Then Should show defect count decremented by one after removing executions
 
 
@Overall
Scenario: 13 Add 'Overall Defects Gadget' and select a project name, release name containing only numbers
Given Log in as a Manager
 Then Manager Logged into application successfully
 When Launch Administration
  And Navigate to DefectTracking to set DTS
 Then Jira is Set
 When Launch manage projects to create a project name containing only numbers
 Then project name with number is created successfully
 When As a Lead,User select a project name containing only numbers and create only numbers character release
 Then numbers character release is created
 When User is in a DashBoard Page
 Then DashBoard Window Should be launched
 When User Create A DashBoard
 Then Created DashBoard is Selected successfully
 When Create a New DashBoard
 Then Should be able to select a added Dashboard
 When Add the 'Overall Defects Gadget' by clicking on the plus symbol
 Then Should be able to save the gadget

@Overall
Scenario: 14 As Manager, Add 'Overall Defects Gadget' and select a project, release with min  2 char limits
Given Log in as an Manager
 Then Manager Logged into a application successfully
 When Launch the Administration
  And Navigate to the DefectTracking to set DTS
 Then Jira Is Set
 When Launch manage projects to create a project name with min two char limit
 Then project name with min two char limit is created successfully
 When As a Lead,User select a project name containing only numbers and create release with min two char limit
 Then release with min two char is created
 When User is in the DashBoard Page
 Then DashBoard Window should be Launched
 When User CrEate A DashBoard
 Then CreateD DashBoard is Selected successfully
 When Create a New DashBoarD
 Then Should be Able to select a added Dashboard
 When Add the 'Overall Defects Gadget' by clicking on a plus symbol
 Then Should Be able to save the gadget 
 
@Overall
Scenario:  15 As Manager, Add 'Overall Defects Gadget' and select a project, release with max char limits
Given Log in As an Manager
 Then Manager Logged into A application successfully
 When Launch the Administration window
  And Navigate to the Defect Tracking to set DTS
 Then JIRA Is Set
 When Launch manage projects to create a project name with max char limit
 Then project name with max char limit is created successfully
 When As a Lead,User select a project name containing max char limit and create release with max char limit
 Then release with max char limit is created
 When User is in The DashBoard Page
 Then DashBoard Window should Be Launched
 When User CreAte A DashBoard
 Then CreaTed DashBoard is Selected successfully
 When CreaTe a New DashBoarD
 Then Should be Able to select an added Dashboard
 When Add the 'Overall Defects Gadget' by Clicking on a plus symbol
 Then Should Be able to Save the gadget  
 
 @Overall
  Scenario: 25 As Manager, minimize and maximize saved Overall Defects Gadget
Given Test Manager is in DashBoards Page
 When click on add button and create new dashboard
 Then Should be able to add new DashBoard
 When Click on newly created dashboard
	And Add OverAll Defects Gadget by clicking on add button
 Then Should be able to add Overall Gadget to DashBoard
 When Configure gadget with project, Release, refresh rate details and save it
 Then Should be able to save Overall Gadget to DashBoard
 When Click on minimize the gadget
 Then Gadget should be minimized
 When Click on maximize the gadget
 Then Gadget should be maximized
 
 @Overall
 Scenario: 27 As Manager/Lead/CustomRole, delete a selected project/release after saving Overall Defects Gadget
Given Test Manager is in Manage Projects page
 When Create a new project and assign project to test manager
 Then New project should be created
 When Create new release in new project
	And Go to Dashboards page
 Then Should be able to launch dashboards window
 When Click on add button and create new dashboard
 Then Should be able to add new Dashboard
 When Add Overall Defects Gadget by clicking on + button
 Then Should be able to add Overall Defect Gadget to dashboard
 When Configure gadget with project, release, refresh rate details and save it
 Then Gadget should be added 
 When Go to project setup and delete that dashbaord added project
 Then Project should be deleted
 When View added gadget
 Then Should not show any data and proper message should display
 
 
 
  @Overall
 Scenario: 30 As Manager, Add Overall Defects Gadget for project/release having 200 Defects
Given Test Manager is in Test Repository page
 When Create new phase, add a testcase and assign phase to cycle in Test Planning page
 And Launch Test Execution page, execute a testcase and link two hundred defects to testcase
 And Launch dashBoards window page 
 Then Dashboards window page should be launched
 When Click on add button and create new DashBoard
 Then new Dashboard should be created
 When Click on add symbol and add OverAll Defects Gadget
 Then OverAll Defects gadget should be added
 When Configure Gadget with project, release and refresh rate details
 Then Gadget should show total proper defect count
 
  @Overall
 Scenario: 3  As Manager, Add Overall Defects Gadget and select a project out of 100 projects
Given Test Manager is in Dashboards Page
 When Click on add button and create new Dashboard
 Then Dashboard should be created
 When Click on add symbol button and Add OverAll Defects Gadget 
 Then OverAll Defect Gadget should be added
 When Select one project out of created projects	
 Then Should be able to select one project out of created projects

 @Overall
 Scenario: 31 As Manager, Create & link 5 new defects with any status Open after saving  Overall Defects Gadget
Given Manager is in log in page
 Then Manager successfully logged in
 When Launch administration page
  And navigate to defect tracking page to set DTS
 Then JIRA is set successfully
 When As Lead,add testcases in TestRepository
  And Launch TestPlanning to create a cycle
 When Add phase to cycle by choosing an existing phase and assign testcases to anyone
 When Launch TestExecution to execute testcases
 Then link the defects to testcases
 When Launch DashBoard page
 Then should launch dashBoard window
 When add dashboard by clicking on plus button
  And create a dashBoard
 Then added dashBoard selected successfully
 When add overall defect gadget by click on add gadget symbol
 Then Overall Defect gadget added successfully
 When configure the gadget by entering the details
 Then should be able to show the defect count to five
 When launch test execution and link five more defects
 Then should be able to link defect to executions
 When view overall defect gadget after linking the defects
 Then should be able to show the updated defect count to ten
 
 
  @Overall
 Scenario: 20 As Manager, Add Overall Defects Gadget for Project and release having multiple defects linked to same executions with different status open/inprogress/closed and linked to different executions
Given Test Manager is in Test repository page
 When Create a phase, add testcase, launch test planning and assign phase to cycle
	And Launch Test Execution page and navigate to particular phase
	And Execute the testcase and link defects with status open, inprogress and done for single testcase
  And launch Dashboards page window
 Then dashboards page should be launched
 When Create a new dashboard by clicking on add button  
 Then Newly added dashboard should be created
 When Search and select the dashboard created
  And Clicking on add button and add OverAll Defects Gadget
 Then OverAll Defects Gadget should be added to dashboard
 When Configure gadget with project, Release and refresh rate details and save it
 Then Should show total defect count and count by status
 
 
  @Overall
  Scenario: 32 As custom role user, Change status of linked defects from status Open to Inprogress/In-progress to done/done to open after saving 'Overall Defects Gadget'
Given Manager is in a login page
 Then Manager logged in to the application successfully
 When Launch the Administration page
  And navigate to defect tracking to set the DTS
 Then successfully set the Jira
 When As Lead,add testcases in testRepository
  And Launch TestPlanning to create the cycle
 When Add phase to a cycle by choosing an existing phase and assign testcases to anyone
 When Launch TestExecution to the execute testcases
 Then able to link the defects
 When launch DashBoard page
 Then dashboard window launches
 When add a dashboard by clicking on the plus symbol
 Then select the added dashboard
 When add overall defect gadget by clicking on plus button
 Then gadget added successFully
 When Configure the gadget by entering the details
 Then shown defect count should be one
 When navigate to Defect Tracking to change status
 Then status changed successfully
 When navigate to dashBoard view overall defect gadget 
 Then display the defect count and inprogress count
 
  @Overall
 Scenario: 17 As Manager, Add 'Overall Defects Gadget' for Project and release having defects with status open/to do/backlog and linked to executions
Given Manager is in a Login page
 Then Manager logged in successfully
 When navigate to the Defect Tracking to set DTS to Jira
 Then Jira is set successfully
 When As a Lead,create a phase with testcases in testRepository
 When Launch TestPlanning,create a cycle
  And add a phase by choosing an existing phase
 When Launch Test Execution to the execute testcases
 Then defects linked to executions
 When Launch DashBoard Page
 Then DashBoard window is launched
 When add a dashboard by clicking on plus symbol
 Then should be able to select the added dashboard
 When add a overall defect gadget by clicking on plus button
 Then overall defect gadget added sucessfully
 When select project,release,referesh rate and save it
 Then should show open,to do defect count properly  
 
 @Overall
 Scenario: 18 As Manager, Add 'Overall Defects Gadget' for Project and release having defects with status inprogress and linked to executions
Given Manager is in the Login page
 Then Manager logged in to a application successfully
 When Navigate to the Defect Tracking to set DTS to Jira
 Then Jira is Set Successfully
 When As a Lead,create a Phase with testcases in testRepository
 When create a cycle in test Planning
  And Add a phase by choosing an existing phase
 When Launch Test Execution to the Execute testcases
 Then defects linked to the executions
 When Launch the DashBoard Page
 Then DashBoard window is Launched
 When Add a dashboard by clicking on plus symbol
 Then should be able to select the Added dashboard
 When Add a Overall defect gadget by clicking on plus button
 Then Overall defect gadget added sucessfully
 When select project,release and referesh rate,save it
 Then should show In-Progress defect count properly

@Overall
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE






	