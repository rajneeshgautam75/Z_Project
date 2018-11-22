Feature: Defect Tracking

@Defect_Tracking
Scenario: 0 Login Scenario
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Defect_Tracking1
   Scenario: 4 As mgr/lead/Tester, Map zephyr project to Jira Project . View drop down fields populated data with Project Selected
     Given Login as manager role Credential
    When admin navigate to project setup page
    And map external defect project to zephyr project and save it
    Then extenal defect project should be mapped to zephyr project
    When user launch defect tracking page
    And click on create defect symbol icon
    Then view mapped project is pre-selected when filing a new defect
    When user launch test Repository page
    And create a phase ,add few testcases to the phase
    Then testcases successfully added to the phase
    When user launch test planning page
    And create a cycle, add phase to cycle and assign to manager
    Then testcases successfully assigned to manager
    When user navigate to test Execution page
    And change the status of testcases and click on Defect button
    Then Link defect window should be launced
    When user click on create defect button
    Then view Mapped Project is pre-selected


 @Defect_Tracking1
 Scenario: 10 As Mgr, Change Multiple attributes of a Defect in Defect Tracking & Save Changes_External System
 Given User is in a Defect Tracking page
  When User search a defects and select multiple defect and select change multiple option
  Then Should be able to change values of component
  When select change multiple to change version value
  Then Should be able to change values of version
  When select change multiple to change status
  Then Should be able to change values of status
  When select change multiple to change FixVersion
  Then Should be able to change values of FixVersion
  When select change multiple to change Priority
  Then Should be able to change values of Priority
  When select change multiple to change Assignee
  Then Should be able to change values of Assignee
  
@Defect_Tracking1
Scenario: 12 Create a defect/subtask from Test Execution with/without copying steps
Given User Launch TestRepository and create a phase with testcases and add teststeps
 When Launch TestPlanning and create a Cycle and add phase and assign testcase to anyone
  And Launch TestExecution and execute testcase and click on D button
  And click on create defect and enter details and select copy steps from dropdown and save
 Then Should not be able to show teststeps in description field
 When click on create defect and enter details and select copy steps as plain text and save
 Then Should be able to view the test steps,testdata and expected results,status and notes
 When click on create defect and enter details and select copy steps as wiki markup and save
 Then Should be able to view the Test Steps,testdata and expected results,status and notes
 
 
 @Defect_Tracking1 
Scenario: 19 Update a defect/subtask in search view
Given User is in defect tracking page
 When User search a defect and update the summary of the defect
 Then Should be able to update summary
 When User search a defect and update the priority of the defect
 Then Should be able to update priority
 When User search a defect and update the component of the defect
 Then Should be able to update component
 When User search a defect and update the version of the defect
 Then Should be able to update version
 When User search a defect and update the fixversion of the defect
 Then Should be able to update fixversion
 When User search a defect and update the environment of the defect
 Then Should be able to update environment
 When User search a defect and update the status and resolution of the defect
 Then Should be able to update status and resolution

 
@Defect_Tracking1
Scenario: 56 Link defect to execution and delete linked defect from external JIRA
Given User launch testRepository and create phase with testcase
 When User Launch TestPlanning to create cycle,add a phase to the cycle
  And User Launch testExecution
 Then Should be able to launch testExecution page
 When User navigate to the phase to execute testcase
 Then Should be able to execute testcases
 When User click on D button to link testcase
  And search the defect and link defect to execution
 Then Should be able to link defect to execution
 When User search a linked defect in Defect Tracking page
 Then Should be able to to delete the linked defect
 When User launch testExecution to check notification
 Then Should be able to get notification
 When User navigate to the notification
 Then Should be able to apply notification
 
@Defect_Tracking1   
Scenario: 67 View linked open defects count by priority "Open defect" gadget
Given User launch Requirements page
 When User add a node with requirements
  And User launch testRepository to create testcase
  And map testcase to requirement
  And User launch testPlanning to create cycle and add phase to the cycle
  And User Launch testExecution page to execute testcase
 Then Should be able to execute the testcase
 When click on D button to search and link a defect
 Then Should be able to link defect to executions
 When User Launch DashBoard
  And Create a Dashboard by the required fields
 Then Should be able to create dashboard
 When Add open defect gadget
 Then Should be able to add open defect gadget
 When View the total defect count and count by priority
 Then Should be able to show proper count by priority
 
 
 
@Defect_Tracking1 
Scenario: 7 Create a defect/sub-task with all types of custom fields.
Given User is in Defect Tracking Page
 When User click on create defect and enter the external Jira project and issue type
  And User enter all types of custom fields
 Then Should be able to create defect
 When User launch TCC page to create a phase with testcases
  And launch test planning to create the cycle and add the phase to cycle
  And User launch Test Execution page to execute testcase and click on D button
  And click on create defect and enters the external Jira project and issue type
  And enter the all the custom fields
 Then Should be Able to create Defect
 
@Defect_Tracking1
Scenario: 13 Create a defect/subtask with newly added values for fields.
Given User is in Defect tracking page
 When User click on create defect button and enter the external Jira project and issue type
  And enter the the available fields
  And enter the all types of custom fields
 Then Should be able to create defect with available values
 When User search a defect and select the defect to create a subtask
  And enter the issue type
  And enter all the available fields with values
 Then Should be able to create a defect subtask with available fields
 
@Defect_Tracking1
Scenario: 14 Create a defect/subtask with newly added values for fields.
Given User is in TestRepositorY page
 When create a phase with testcases
  And launch test planning to create a cycle and add phase to cycle
  And launch test Execution to execute testcase
  And click on D button and click on create defect button and enter the external Jira project and issue type
  And enter the available fields with values
 Then Should be able to create a defect with available fields
 When search a defect and click on subtask to create subtask
  And enter the IssueType and click on next button
  And enter all the available fields along with custom fields
 Then Should be able to create defect subtask
 
 @Defect_Tracking1
Scenario: 15 Create a defect/sub-task if the fields are mandatory in jira
Given User is in DefectTracking page
 When User click on create defect button and enter external Jira project and issue type
  And enter all the available fields which are mandatory
 Then Should be able to Create Defect
 When search a defect and select the defect
  And click on create subtask and enter the issue type
  And enter all the mandatory fields
 Then Should be able to create defect subtask with available fields
 
@Defect_Tracking1
Scenario: 16 Create a defect/sub-task if the fields are mandatory in jira
Given User is in The TestRepository page
 When Create a phase with testcases
  And Launch test planning to create a cycle and add phase to cycle
  And Launch test Execution to execute testcase
  And Click on D button and click on create defect button and enter the external Jira project and issue type
  And Enter the available fields with values and save
 Then Should Be able to create defect with available fields
 When Search a defect and click on subtask to create subtask
  And Enter all the available fields along with custom fields and save
 Then Should be Able to create defect subtask with the available fields

  
  @Defect_Tracking1
  Scenario: 52 link the defect to execution and change linked defect status In external jira
  Given User is in the main page
  When User will click on the respository button and right click on release
  And user will add the test node
  Then user test node addded successfully
  When User will add  testcases
  Then testcases added successfully
  When user clicks on test Planning page and click on add test cycle
  And create a cycle and add the created phase to the cycle and assign to everyone
  Then testcases should be assigned to everyone
  When user will click on testexecution button and navigate to related node
  And user will execute the testcase to pass status
  Then status should be changed to pass
  When tester will click on the D button and search the defect by id
  Then defect should be successfully searched
  When user linked the searched defect
  Then should be able to link defect to execution successfully
  When User click on defect Tracking page
  And search for that defect ID
  Then searched defect will be shown in search page
  When user click on that defect Id
  Then Jira page will open
  When user fill up the jira credential and click on login
  And user will change the status of that defect in jira
  And user will open test execution and search for that defect id
  Then the status of that defect has been changed to new Updated status
  
  @Defect_Tracking1
  Scenario: 53 link the defect to execution and change linked defect priority In external jira
    Given User will be in main page
    When user will go to execution page and navigate to the node
    And user will change the status of the testcase
    Then status successfully changed
    When user will search defect and link sucessfully
    Then should be able to link defect to Execution successfully
    When user will go to defect Tracking page search for the defect Id and click on it
    Then new tab Jira will open the page and fill the Credentials
    When user will change the priority and switch back to application
    And user will check for the notification in testexecution page
    Then the Priority of that defect has been changed
    
  @Defect_Tracking1
  Scenario: 54 Link defect to execution and change linked defect Summary In external JIRA
    Given User is in the home page
    When user will goes to textexeution page and navigate to the node
    And user changes the Status of the TestCase
    Then status changed sucessfully
    When user will click on D button and search the defect and link it
    Then should be able to link defect to execution Successfully
    When user will go to defect tracking page and search the defect and click on it
    Then a new JIRA page will appear
    When user change the summary of the issue
    And user will switch back to the application page
    And user will goes to testexecution page and apply notification
    Then user will View the updated Summary in execution grid.
    
    @Defect_Tracking1
    Scenario: 55 Link defect to execution and move linked defect from one project to another project in external JIRA
    Given User in the Home_Page
    When user will clicks on TextExecution page and navigated to the selected node
    And user changes the status of the related Testcase
    Then Status should be changed sucessfully
    When user click on the D button 
    And user will search for the defect and link that defect
    Then defect must linked to Execution sucessfully
    When user goes to DefectTracking page 
    And user search the Defect and clicks on it
    Then Jira will open the page
    When user fills the Credentials
    And will moved the linked defect to another project 
    Then defect must move Sucessfully to another project
    When user comes back to Application page
    And user will clicks on the textExecution button 
    And user clicks on the Apply Notification button and selects apply 
    Then user would be able to view new Defect-ID on execution grid 
    
    
    
    @Defect_Tracking1
    Scenario: 57 Click on linked defect ID in test execution grid
    Given user will be in a homePage
    When user clicks the execution button and will navigates to the node
    And user will select the test case and change the status 
    Then status of that testcase is changed sucessfully
    When user clicks on the D button and search for the defect by id
    And user will link to the execution testcase
    Then sucessfully a new defect is linked in test execution grid
    When user clicks on that new defect id in testExecution grid
    Then Should navigate to DefectTracking page and search for that defect by id 
    
    @Defect_Tracking1
    Scenario: 58  Click on linked defect ID in Link defect window
    Given user will be in a mainPage
    When user goes to testexecution page and navigates to the related node
    And user will goes to the selected testcase and will change the status of the testcase
    Then Status of the selected testcase must be changed sucessfully
    When user clicks on the D button of that testcase
    And user will search for the defect id and link that defect to execution testcase
    Then testcase must be linked sucessfully
    When user will click on the defect id in currently linked defects top column on the same page
    Then Should navigate to DT page and search for that defect by id
    
    @Defect_Tracking1
    Scenario: 59 Link defect to to execution and view remote link in jira
    Given User shall be in Main_Page
    When user clicks testExceution button and goes to testExecution page 
    And user will search for the related node
    And user will select the TestCase and change the status 
    Then status of the testcase has been sucessfully Changed
    When user clicks on the Deffect D button of the related testcase
    And user search for the Defect ID and links that id to test execution
    Then Defect Id must linked sucessfully
    When user will click on links defect id
    Then A new JIRA page will open 
    When user will fill the credentials and login 
    Then should view remote link in jira 
    
    @Defect_Tracking1
    Scenario: 60 Click on testcase ID in execution remote link in JIRA
    Given User will be in a testExecution page
    When user will navigate to the node
    And user will select the testcase and change the status 
    Then the selected status must be sucessfully changed
    When user will clicks on the changed status D button
    And user searches for the defectId and link the id to testcase
    And user will click on the defectID in linksdefect grid
    Then jira page will open 
    When user will fill the credentials in jira page and click on login button
    And user will click on the testcase ID 
    Then Should navigate to ZE test repository search window and search for that testcase
    
    @Defect_Tracking1
    Scenario: 61  Click on testcase execution status in execution remote link in JIRA
    Given User shall be in testExecution page 
    When  user will navigates to related phase
    And user will change the status by selecting the testcase
    Then selected testcase status is changed
    When user clicks on the D button which the status has been changed
    And user will search the defectID and links it to the testcase
    Then defect must be sucessfully linked
    When user will clicks on the ID in linksdefect grid
    Then a jira page will appear
    When user will enter correct username and password and click on login 
    And user will click on the testcase Execution Status icon button 
    Then Should navigate to ZE test execution search window and search for that testcase
    
     @Defect_Tracking1
    Scenario: 62 De-link the linked defect from execution and view the execution remote link in external JIRA
    Given user is in testExecution page
    When user naviagtes to node
    And user will change the status 
    Then sucessfully status changed of the testcase 
    When user clicks on D icon and naviagtes to linkwindow page
    And user will search for the defectId and link it to testcase
    Then defect must be sucessfully linked to testcase
    When user will click on the defectID in grid
    Then jira will open and user will switch to that window
    When user will enter the username and password 
    Then user will validate the link of the testcase
    When user clicks on logout button 
    Then user will comes to ZE application page
    When user selects the DefectId and clicks on Delete button
    And user again Search for the defectId and clicks on that ID
    Then jira page will appear in new tab
    When user enters correct valid username and password and click on login button
    Then Execution remote link should be removed from external JIRA after de-linking the defect
    
     @Defect_Tracking1
    Scenario: 63 Hover on defect ID in test execution grid
    Given User will comes to TestExecution page
    When user will selects the related node to start execute testcase
    And user will select the testcase and change the status of that testcase 
    Then status must be changed sucessfully
    When user will click on D icon button Sucessfully
    And user will search a defectID and link it to the testcase sucessfully
    Then Should be linked to testcase sucessfully in testgrid  
    When user will mouse Hover on the linked testcase testcase 
    Then Should be able to defect details Defect ID,summary,status and priority in testExecition grid
    
    @Defect_Tracking1
    Scenario: 64 View linked defects count by status in defect tracking app
     Given User is in a TestExecution Page 
     When user will navigate and selects the node
     And user will change the status to fail of the selected testcase 
     Then selected testcase is changed sucessfully
     When user will clicks on the D icon button in the grid
     And user searches the mutiple defect and links to the same testcase
     Then multiple defect to that testcase is linked sucessfully
     When user launches the defectTracking page
     Then user will view total linked defect and by status count
     
      @Defect_Tracking1
     Scenario: 65 View linked defects count by status in Release summary page
     Given User arrives to TestExecution page
     When user selects the related node and phase
     And user will select the testcase and change the status of that testcase by fail 
     Then the selected testcase has changed to fail status sucessfully 
     When user will click on the D icon button of the tescase which status has been changed
     And user will search for different defectid and links it to testcase 
     Then the multiple defect must link to testcase Sucessfully
     When user will now selects the project and goes to release page
     Then should view the total linkeddefect count by status 
     
    
    
      @Defect_Tracking1
      Scenario: 66 View linked defects count by status Overall defect gadget
     Given Users Comes into TestExecution Page
     When user will goes to the selected node by navigating 
     And user selects the testcase and change the status of the selected testcase 
     Then testcase status must be changed sucessfully
     When user clicks on the D icon 
     And user will search multiple defect and links it to testcase
     Then user must sucessfully linked all multiple defect to that testcase
     When user clicks on the dashboard button
     Then user must sucessfully comes to dashboard page 
     When user will click on AddDashboard Symbol
     And user will enters all the details and click on save
     Then dashboard must be sucessfully saved
     When user clicks on dashboard which is created
     And user will click on the plus button to add the overall defects gadget
     Then sucessfully gadget must be added
     When user selects the project name and release and refreshrate and save the gadget
     Then gadget must be sucessfully saved and View the total defect count and count by status
     
      @Defect_Tracking1
     Scenario: 68 View linked defects count by status Traceability gadget
     Given User is in Requirement page
     When user will create a node and add requirements
     Then requirement added successfully
     And user clicks on the resporitory page 
     And user will click on release and create a node
     And user will add testcases
     Then testcases must be added successfully
     When user will map the testcase to requirement node
     Then testcase should be sucessfully mapped
     When user clicks on testplanning page 
     And user will click on add symbol to create cycle
     And user will fill all the details 
     Then test planning cycle is created successfully
     When user will navigate and add phase to the cycle
     And user will assign testcase to user 
     Then testcase successfully assigned to user     
     When user clicks on testExecution page 
     And user will be change the status of the testcase 
     Then Status should be able to change successfully
     When user will click on D button and search for the mutiple defect and link it
     Then multiple defect must be linked successfully
     When user will click on the dashboard button
     Then Dashboard page must be validate sucessfully
     When user clicks on add dashboard button 
     And users enters the fields to create dashboard
     Then dashboard must created successfully
     When user adds the Traceability gadget 
     Then gadget must be able to added successfully
     When user will selects project,release and refreshrate
     And user will clicks on manage button and search for the mapped requirement
     And user will click on save button
     Then gadget must be added sucessfully and view the total open defect count and count by priority
     
     @Defect_Tracking1 
     Scenario: 69 View defect count in Daily pulse gadget
     Given Manager is in a administration page
     When manager clicks on Project SetUp button
     And map the jira project to ZE
     And manager will logout from application 
     And User will login with lead credentails 
     And user will click on dashboard button
     Then user must comes to dashboard page successfully
     When user clicks on add dashboard button and fill the details
     Then dashboard created successfully 
     When user cliks on add gadget symbol 
     And adds Daily pulse gadget 
     Then Daily pulse gadget must be added successfully
     When user will fill all the details and click on save button
     Then user must view the total defect count in mapped JIRA project
     
     
     @Defect_Tracking1
     Scenario: 31 Navigate by Click on the Testcase ID of a Defect/subtask in SEARCH view
     Given User will be in Test Repository page 
     When user clicks on relase and create a node
     And user will add four testcase
     Then testcase must be added successfully
     When user clicks on testplanning button and clicks on add cycle button
     And user will fill the details 
     Then test cycle has been created successfully
     When user selects the cycle and adds the phase
     And user will select the bulk assignment and assign to everyone
     And user will click on testExecution button
     And  user will selects a single testcase and changes the status
     Then status have been sucessfully changed of the testcase
     When user will clicks the D icon button 
     And searches for the defect id and links the testcase 
     Then testcase must be linked successfully
      When user clicks on DefectTracking button
      Then user will comes to Defecttracking page
      When user searches for the defectId 
      Then defectid is validated successfully
      When user clicks on the testcaseID of the defectID linked grid
      Then Should be able to navigate to the testExecution search page with same TestcaseID
      
      
   @Defect_Tracking1   
  Scenario: 180 file defect/subtask from Test Execution, Copy test Steps as As wiki markup  if there are no test steps 
   Given User Logins as Manager to Zephyr
   When  User set DTS to JIRA
   Then  Should be able to Set
   When  User launch test repository 
   And   user creates a phase and adds testcase without steps
   Then  user should be able to create TestCase
   When  User is In a TestPlanning,Creates a cycle and Add phase to cycle and Assign testcases to users
   Then  user should be able to assign TestCases to user
   When  User Launches TestExecution 
   And   User Execute a testcase and Clicks on D button
   Then  Link defect window should launch
   When  user While filing defect,In desc field copy steps as wikimark up
   Then  In JIRA desc field should include table of teststeps
 
@Defect_Tracking1
Scenario: 181 Copy test Steps as 'As wiki markup' if no test step is executed
  Given User Logins As Manager Credentials to Zephyr
  When  user set DTS TO JIRA
  Then  DTS should be set
  When   user is in  Test Repository,Creates a phase and add testcase with steps
  Then   should able to create a testcase
  When   user Launches Test planning creates cycle,Add phase to cycle and assign testcases to users
  Then   should be able Assign testcase to users
  When   user Launches test execution exexute testcase not the steps and clicks on D button
  Then   Link defect window should be launched
  When  While filing defect in desc field copy steps as As wikimark up
  Then  In jira desc field should include table of teststeps
  

@Defect_Tracking1
Scenario: 182 file defect/subtask from Test Execution ,Copy test Steps as As wiki markup if the test steps are executed
Given User is in a TestRepository
When  user creates a phase and add testcase with steps
Then   should be able to create a testcase with steps
When   user Launch Test planning creates a Cycle,adds phase to cycle and assign Testcases To user
Then   should be Able to assign Testcase to User
When   user launches test execution execute testcase with steps and clicks on D button
Then  link Defect Window Should launch
When  While filing defect,In desc field copy Steps as  As wikimark up
Then  desc field should include table of teststeps in JIRA

@Defect_Tracking1 
Scenario: 183 Copy test Steps as As wiki markup if the test steps have custom execution status
Given User launches TestRepository
When  User creates a Phase and adds test case with steps
Then   should be able to create a test case
When   user launches Test planning,creates cycle adds phase to cycle AND assign TestCase to user
Then   To be able to assign TestCase to user
When   user launch Test execution,Executes testcase with the steps to custom steps 
And   user Clicks On D button
Then  Defect Window should launch
When  user while Filling a defect,In desc Field copy steps as As Wikimark up
Then  Desc Field should include table of teststeps

@Defect_Tracking1  
Scenario: 184 Copy test Steps as As wiki markup, if  test steps + test data + Expected Result are blank
Given User Is In a test Repository
When  user creates a phase and adds testcase with steps with test steps and test data and Expected Result are blank
And   user launches TestPlanning,Creates a Cycle,Adds phase to cycle and Assign testcases to users
And   Launches TestExecution,Executes testcase with the steps to custom steps and Clicks on D button
Then  defect window to be launch
When  user while creating a defetct,In desc Field copy steps as wikimark up
Then  Desc Field should include table of steps

@Defect_Tracking1 
Scenario:185 file defect/subtask from Test Execution,copy test steps as wiki markup if test steps are executed to any status with notes
Given User launches Test Repository page
When  user creates a phase add testcase with steps with test steps 
And   Launches test planning
And   user creates New cycle,Add phase to cycle and Assign testcases to users
Then  testcase should be assigned to user
When  user launches Test execution,Executes testcase with the steps to any status and add notes,Click on D button
Then  Defect window should be Launched
When  while filling defect,In desc field Copy steps as As wiki mark up
Then  Description field should include table of teststeps

@Defect_Tracking1
Scenario:186 file defect/subtask from Test Execution for a testcase, copy test steps as wiki markup if  teststeps are partially executed
Given User is IN a TestRepository
When  user creates a new Phase and adds Testcase with steps with Test Steps
Then  To  be able to create a TestCase with steps
When  user launches testplanning
And   creates a New Cycle, Add phase to cycle and Assign testcases to users
Then  should be Able To assign Testcases to User
When  user launches test execution 
And   Executes testcase with the steps partially and Clicks on D button
Then  Defect window to be launched
When  while filling defect,In description Field copy steps as wikimark up
Then  Desc field should include table of teststeps In JIRA 

 

@Defect_Tracking1
Scenario:187 file defect/subtask from Test Execution,Copy test Steps as wiki markup if the test steps contain international characters
Given user is in a page of Test Repository
When  user creates a new phase,add testcase with steps with international chars
Then  should be able to create testcase
When  user launches testplanning,create a cycle Add phase to cycle and Assign testcases to users
Then  should able to assign testcase to user
When  user launches test execution,executes testcase with the steps and Clicks on D button
Then  link defect window should launch
When  filling defect,in desc field copy steps as wikimark up
Then  in jira desc field should include table of teststeps

@Defect_Tracking1
Scenario:188 Copy teststeps as wiki markup if the test steps contain special characters, whitespaces, and new linecharacters
Given user launches Test repository
When  user creates a Phase adds testcase with steps with special chars
Then  should be able to Create a TestCase
When  user is in a test Planning page
And   user Creates a cycle,Adds phase to cycle and Assign Testcase to users
Then  user To Be able to assign testcase to user
When  user launch Test Execution Page
And   Executes testcase With the steps and Clicks on D button
Then  Link Defect Window should be Launched
When  While Filing defect in desc field Copy steps as As Wikimark Up
Then  In JIRA Desc Field Should include Table of teststeps


@Defect_Tracking1 
Scenario: 45 Update the Defect/Subtask with comment
    Given User Launches Defect Tracking App
    When  user Searches defect by any attribute Project,Issue type,Priority,Status,Assignee,ID,Advance_JQL
    When  After search result,Select a defect,sub-task in  grid -> Update the defect/subtask with comment 
    Then  Should be able to Update the Defect,Subtask with comment
 
@Defect_Tracking1    
Scenario: 46  Update the Defect/Subtask with comment  and cancel
Given User Is IN A DefectTracking App
When  user Searches defect by any attribute Project,issueType,Pripority,status,assignee
When  after search result,select a defect,sub-task in grid,Enter the  comment  Cancel the X button
Then  Should be able to  Update the Defect,subtask with comment  and cancel

@Defect_Tracking1
Scenario:40 Submit a defect with < > tag [special character] in the Description field
Given In zephyr  login as a manager
When  user launches Administration set DTS to Jira
Then  should be Set DTS to JIRA
When  user Launches Defects Admin app  and configured  dts.customfield.jira.date_format = yyyy-MM-dd
Then  To be able to configure 
When  user launches Defect Tracking app and clicks on create defect
And   Create a defect with special characters
Then  should create a defect with special characters
When  In zephyr as a manager launch Administration and set DTS to Jira
Then  should set dts to jira
When  user launches TestExecution app,Execute a testcase with any status 
And   user Clicks on D and  Clicks on Create Defect
And   user Create a defect with special characters 
Then  Should be able to Submit a defect with < > tag in the Description field


@Defect_Tracking1 
Scenario:41 Submit a sub task with < > tag [special character] in the Description field
Given Login as Manager to Zephyr application
When  user launches administration app and set DTS to Jira
Then  Should be able to set Dts
When  user Launches Defect Admin app  and configured  dts.customfield.jira.date_format = yyyy-MM-dd
Then  to Be able to configure
When  user Launches Defect Tracking app,clicks on create defect
And   create a Sub task with Special characters
Then  should be able To Create
When  in zephyr as Manager launch Administration app and set DTS to Jira
Then  should be able To set dts to JIRA
When  user launch Test execution,executes a Testcase with any status
And   user clicks on D button and clicks on create defect
And   user creates the subtask with special characters 
Then  To be able to Submit a subtask with special character in the Description field 

@Defect_Tracking1
Scenario:42 Submit a defect with International character in the Description field
	Given Login as Manager credential to zephyr
	When  user launches administration App and set Dts to Jira
	Then  should be set DTS to JIRA
	When  Launch Defects admin app and Configured dts.customfield.jira.date_format = yyyy-MM-dd
	Then  should be possible to configure
	When  user launch Defect tracking application and Clicks on Create Defect
	And   Create a defect with international characters in description
	Then  should be able to create Defect
	When  In zephyr as a manager,launch Administration and set DTS to Jira
	Then  To be set Dts to JIRA
	When  user Launch Defects Admin app and Configured dts.customfield.jira.date_format = yyyy-MM-dd
	Then  should be configured
	When   launch TestExecution application Executes a testcase with any status 
	And   user Clicks on D and Clicks on Create Defect
	And   create a defect with International characters in Description
	Then  Should be able to create a defect with international characters  
	
@Defect_Tracking1	
Scenario:43 Submit a sub task with International character in the Description field
Given login as Manager To Zephyr
When  launch Administration and set DTS to Jira
Then  DTS to Jira should be set
When  launch Defects admin app and Configured dts.customfield.jira.date_format = yyyy-MM-dd
Then  should be configure
When  user Launch Defect Tracking app,Click on Create Defect
And   Creates a sub task with International character in description
Then  should be able to create
When  In zephyr as a manager,launch Administration and set dts to Jira
Then  should be set dts to jira
When  user Launches Defects Admin app and configures dts.customfield.jira.date_format = yyyy-MM-dd
Then  dts.customfield.jira.date_format = yyyy-MM-dd should configure
When  user launches test execution,executes a testcase with status
And   clicks on D and clicks on create defect
And   create a sub task with international character in description
Then  should be able to create a defect

@Defect_Tracking1
Scenario:44 Perform Sort on any column header of Defect Listings 
Given User is in a Page of Defect Tracking
When  User searches Defect by any Attribute
And   after search,Sort on Any Column Header of Defects
When  User launches Defect tracking app and search by Jql
And   after search,sort any column Header of Defect listings
Then  Should be sorted Defects
When  user launches defect tracking app and searches by MyFilter
And   sorts any column Header of Defect Listings
Then  Defect listings should be sorted
When  user is in test execution page,executes testcase with any status and clicks on D button
And   user search by MyFilter and Sorts  on any column header of Defect Listings
And   Launch Test Execution,Execute testcase with any status and Click on D 
And   Search by JQL,Sort on any Column Header of Defect Listings
Then  Should be able to Perform Sort on any column header of Defect Listings

@Defect_Tracking1
Scenario: 33 Create  a defect/Subtask with custom field of type Text Field
Given User is in a Defect Tracking Page and clicks on create defect
When  user Creates a defect with only numbers in custom field of type Text Field
Then  should be able to create a defect with only numbers
When  User Creates a defect with custom field of type Text Field in UPPERCASE
Then  should create a defect with custom field of type Text Field in UPPERCASE 
When  user Creates a defect with custom field of type Text Field in lowercase
Then  Defect should be created with custom Field of type TextField
When  Creates a defect with custom field of type Text Field containing alphanumeric characters and spaces
Then  should be able to create a defect with custom field containing alphanumeric characters
When  user Creates a defect with custom field of type Text Field containing special characters
Then  should be created a defect with custom field of Type  Text field
When  Create a defect with custom field of type Text Field containing international characters
Then  Defect should be created with custom field of type Text Field containing international characters
When  user launches defect tracking app,searches a defect and selects it and clicks on Create Sub-task 
And   creates a subtask only numbers in custom field of type Text Field
Then  should create a subtask only numbers in custom field of type text Field
When  user creates a subtask with custom field of type Text Field in lowercase
Then  lowercase of subtask should be created
When  user creates a subtask of type Text Field containing alphanumeric characters and spaces
Then  subtask should be created of type Text Field containing alphanumeric characters
When  user Creates a subtask with custom field of type Text Field containing special characters
Then  should be created a subtask with custom field of type Text field consists of special characters
When  user creates a sub task the text field containing international characters
Then  should be created a defect which containing international characters of text field
When  user launches test repository page, creates a Phase 
And   adds a few testcases, and goes to Test Planning Creates a cycle and assigns testcases to Anyone
And   User launches Test execution,selects test cases and executes with any status and clicks on D
Then  Defect window to be Launched
When  User clicks on create defect and creates a defect with only numbers in text field
Then  defect should create only numbers in text field
When  Create a defect of type Text Field in UPPERCASE
Then  defect should be created of type text field in Upper case
When  create a defect of type text field in lower case
Then  defect should create of type text field in lower case
When  user will Create a defect  of type Text Field containing alphanumeric characters and spaces
And   user will create a defect of type Text Field containing special characters
And   user will create a defect of type Text Field containing international characters
Then  should be able to create a defects of Type text field
When  user launch test repository page and creates a phase and adds few testcases
And   user launch test planning page,create a cycle and assign phase to cycle,assigns testcases to anyone
And   user goes to test execution,executes testcases with ANY Status,clicks on D button
Then  defect window should be opened
When  user clicks on create defect button
And   searches a defect and creates subtask
And   Create subtask with custom field of type Text Field in Uppercase
And   Create SubTask with Custom field of type text field in Lowercase
Then  should be created a sub task with custom field of type text fields
When  create a subtask with custom field of type Text Field Containing alphanumeric Characters
And   Create a subtask with custom field of Type text Fields containing Special Characters
And   Creates the subtask with custom field of type text field Containing International characters
Then  should be able to create a subtask with custom field of type text field consists international characters

@Defect_Tracking1
Scenario: 34 Create  a defect/Subtask with custom field of type Free Text
Given user is in a page of defect tracking and clicks on create defect
When  user creates a defect with only numbers in custom field of type Free Text
Then  should able to create a defect with only numbers in custom field of type free Text
When  Create the Defect with custom field of type Free Text in UPPERCASE characters
Then  Uppercase character defect should be created
When  Create Defect With custom field of type Free text in lowercase
And   user Creates defect with Custom field of Type Free Text containing alphanumeric characters and spaces
And   create Defect with custom field of type Free Text containing Special characters
And   create a defect with custom field of type free text containing international characters
Then  to be able to create the defect
When  Create a defect with custom field of type Free Text containing new line characters 
And   Create defect With custom field of type Free Text by Copy/Paste pre-formatted text containing new line characters from clipboard
Then  should create the defect
When  Create a defect with custom field of type Free Text greater than two thousand fourty eight characters
And   Create a defect with custom field of type Free Text with very long text as defined in  Defects Admin
Then  defect should create as very long text as defined in  Defects Admin
When  Defect with custom field of type free text longer than configured maxlength using old property DTS.CUSTOMFIELD.customfield_xx.MAXLENGTH
Then  should create defect with custom field of type free text
When  user launches defect Tracking app,search defect and selects it
And   clicks on Create Sub-task
And   Create subtask with Only Numbers in Custom field of type Free Text
Then  should be able to create a subtask with only numbers in custom field of type free text
When  create subtask with custom field of type Free text in UPPERCASE
And   create Subtask with custom field of type Free Text in lowercase
And   Create subtask with custom field of type Free Text containing alphanumeric characters and spaces
Then  to be able to create the subtask with custom field of type Free Text consists of alphanumeric
When  Create Subtask with custom field of type free text Containing Special characters
And   Create a subtask with Custom field of Type Free Text containing international characters
And   Create a Sub task with custom field of type free text containing new line characters
Then  should create a sub task with custom field of type free text consists of new line characters
When  Create Subtask with custom field of type Free Text with very long text as defined in Defects Admin
Then  should able to create a subtask with very long text
When  Create a Sub task with custom field of type Free Text longer than the configured maxlength using the old property
Then  subtask should be created with custom field of type Free Text longer than the configured maxlength
When  Launch test repository,create a phase and add few test cases
And   go to test planning,create a cycle and assign phase to cycle and assign testcase to anyone
And   go to test execution,select testcases and execute with any status
And   user clicks on D button
Then  link defect Window Should be Launched
When  user clicks on create defect and creates defect with only Numbers in custom field of Type free Text
And   Create defect with custom field of Type Free Text in uppercase
And   create Defect with custom field of type Free Text in lowercase
Then  Defect with custom field of type Free Text in lowercase should be created
When  user Creates the defect with custom field of type Free Text containing alphanumeric characters and spaces
And   Create Defect with custom field of type Free Text containing special characters 
And   create Defect with custom field of type Free Text containing international characters
Then  Defect with custom field of type Free Text consists international characters should be created
When  Create a defect With custom field of type Free Text Containing New line characters
And   create defect with custom field of type Free Text by copy/paste pre-formatted text consists new line characters
And   create a defect with custom field of type Free Text more than two thousand fourty eight characters  
Then  should be able to create a defect with custom field of type Free Text
When  create Sub task with custom field of Type Free Text with very long text as defined in defects admin
And   create a defect with custom field of type Free Text longer than the configured maxlength
Then  defect with custom field of type Free Text to be created
When  launch test repository Page,create a phase and add testcases
And   launch tesplanning,create new cycle and assign phase to cycle and assign testcases to anyone
And   launch test execution,execute TestCases with Any status
And   select testcase and clicks on D button
Then  link defect window should be opened
When  user search defect,and selects it
And   clicks on Create subtask
And   Create Subtask with only numbers in custom field of type Free Text
Then  Subtask with only numbers in custom field of type Free Text should be created
When  create Subtask with custom field of type Free Text in UPPER CASE characters
And   Create the subtask with custom field of type Free Text in lowercase
And   Create The subtask with custom field Of Type Free Text consists alphanumeric characters and spaces
Then  should be able to create a subtask
When  user creates subtask with custom field of type Free Text Containing special characters
And   Create a subtask with custom field of type Free Text containing international characters
And   create Sub task with custom field of type Free Text containing new line characters 
Then  should be able to create a subTask
When  Create subtask with custom field of type Free Text by Copy/Paste pre-formatted text containing new line characters
And   Create a Sub task with custom field of type Free Text more than two thousand fourty eight characters
And   create a Sub task with custom field of type Free Text with very long text as defined in  Defects Admin
And   create the Subtask with custom field of type Free Text longer than the configured maxlength
Then  Subtask with custom field of type Free Text should be created


@Defect_Tracking1
Scenario:35 Create  a defect/Subtask with custom field of type Select List
Given User is in a Page Of Defect Tracking and clicks on Create Defect
When  user creates a defect with select list of values containing only numbers
And   user creates a defect with Select List of values in UPPERCASE
And   create a defct with select list of values in lower case
Then  should be able to create defect with Select LOV in lowercase
When  user Creates a defect with Select List of values containing alphanumeric characters and spaces
And   Create a defect with Select List of values containing special characters
And   Create a defect with Select List of values containing international characters
Then  should be able to create a defect with select LOV
When  User is in page of defect tracking,and searches defect
And   selects defect and clicks on create subtask
And   Create the subtask with Select LOV containing only numbers
Then  subtask with Select LOV containing only numbers should be created
When  Create the subtask with Select List of values in UPPERCASE
And   Create subtask with Select List Of Values in lowercase
And   Create a subtask with Select List LOV containing alphanumeric characters and spaces
Then  subtask with Select List LOV containing alphanumeric characters to be created
When  Create a subtask with select List of values containing special characters
And   create the sub task with select list of values containg International characters
Then  should be able to create the sub task with select list of values
When  user Is in a Page of Test repository,creates a phase and adds few Testcases
And   user Is in a Page of test planning,creates a cycle and assign phase to cycle and assign testcases to anyone
And   user Launches Test Execution,selects testcases and executes with any status and clicks on d button
Then  Link defect window to be Launched
When  user clicks on Create Defect
And   creates the defect with select list of Values containing Only Numbers
And   creates The Defect With select lov consists Uppercase characters
Then  Defect With select lov consists Uppercase characters to be created
When  create a defect with Select LOV consists  lowercase characters
And   Create a defect with Select List LOV consists Alphanumeric characters and spaces
Then  defect with Select List LOV consists Alphanumeric should be created
When  User creates defect with select LOV consists special characters
And   user create The Defect With Select lov containing international characters
Then  Defect With Select lov containing international characters should be created
When  User Launch test repository page,creates a phase and Adds Few TestCases
And   User Launch TestPlanning page,create a cycle and assign Phase to cycle
And   Launches TestExecution,selects testcases and executes with any status
And   user click on d button
Then  defect window to be opened
When  User create the subtask with select Lov consists containing only numbers
And   create the sub task with select list in UPPERCASE characters
Then  sub task with lov in uppercase should be created
When  create a subtask with select LOV in lowercase characters
Then  The sub task with Select list of values in lowercase to be able to create 
When  create the sub task with select LOV containing Alpha Numeric characters and Spaces
And   create the SubTask with select list of values containing special characters
And   create the subTask with select LOV consists International characters
Then  subTask with select LOV consists International characters should be able to create  

@Defect_Tracking1
Scenario:38 Create  a defect/Subtask with custom field of type Date Picker
Given User Launches Defect Tracking app and clicks on a create defect
When  user Creates a defect or subtask with custom field of type Date Picker as current date
Then  should be able to create a defect with custom field of type Date Picker as current date
When  user creates a defect with custom field of type Date Picker as date in the past
Then  should be able to create a defect with custom field of type Date Picker as date in the past
When  user Creates a defect with custom field of type Date Picker as date in the future
Then  should be able to create defect with custom field of type Date Picker as date in the future
When  user Launches defect tracking,Search defect and Select it and Clicks on Create Sub-task
And   Create a subtask with custom field of type Date Picker as current date
Then  should be able to create a subtask with custom field of type Date Picker as current date
When  user Creates subtask with custom field of type Date Picker as date in the past
Then  should be able to create a subtask with custom field of type Date Picker as date in the past
When  user Create a subtask with custom field of type Date Picker as date in the future
Then  should be able create subtask with custom field of type Date Picker as date in the future
When  user is in a test repository page,creates a phase P1 and adds Few TestCases
And   user goes to Test Planning Creates a cycle C1 and adds Phase P1 and assign testcases to anyone
Then  testcases should be assigned to anyone
When  user is in a test execution,select testcase and execute with any status
And   user clicks on D button and Clicks on Create defect
And   Creates a defect of custom field type Date Picker as current date
Then  should be create defect of custom field DatePicker
When  user creates a defect with custom Field type Date Picker as date in past date
Then  successfully should create a defect 
When  create a defect with custom fields of DatePicker as type as in the future date
Then  successfully should create a defect of Date Picker Type 
When  user launches test repository, creates a phase P2 and adds few TestCases
And   user is in a TestPlanning, Creates a Cycle C2 and adds Phase P2,assigns TestCase to anyone
And   user goes to TestExecution,executes testcase with any status and clicks on D button
Then  Defect window should be launched
When  user clicks on Create Defect,and search for a defect and create a subTask
And   creates subtask Date Picker as current date
Then  subtask of Date Picker should be created
When  creates subtask type Date Picker past date
Then  past date should be created and Updated
When  creates subtask type Date Picker future Date
Then  successfully should create a defect of Date Picker as in the future Date

@Defect_Tracking1
Scenario:190 link an existing defect/subtask to a test in test planning, if testcase execution status is customized
Given User logins as Manager to Zephyr
When  user sets dts to jira
Then  dts to jira should be set
When  user customizes the test case status ex:PassA,FailB,
Then  Should be able to customize the status
When  user Launch Test Repository Page
And   user creates a phase and adds testcase
Then  should be able to create a testcase
When  user is In a Page Of Test Planning
And   creates a cycle,adds Phase to cycle and assigns TestCases To User
Then  TestCases should be assigned to User
When  USER Launches TestExecution Page 
And   Executes a Testcase and clicks on d icon
Then  link Defect Window To be Launched
When  user searches defect and Links It
Then  should Be Able to link defect to executions

@Defect_Tracking1
Scenario:191 file defect/subtask from Test Execution, if testcase execution status is customized
Given User is in a page  of Test repository
When  creates a phase and adds testcase
Then  should be able to add Testcase
When  launches Test planning page
And   create a new Cycle,add phase To Cycle and assign testcases to User
Then  TestCases to User Should be Assigned
When  user launch test execution app
And   select and execute testcase and Clicks On d Icon
Then  window of Link defect Should be able to launch
When  File defect on execution
Then  To be able to link Defect to executions

@Defect_Tracking1
Scenario:36 Edit field setup for custom field of type Select List in Jira, add new LOV and Attempt to view the change reflected in Zephyr 
Given user logins to Jira
When  user goes to administration and clicks on Issues
And   goes to custom fields,Already added a custom field of type Select List adds new list of values  
Then  should be able to add
When  user is in a defect tracking Page,clicks On Create Defect
And   Without  Cache timeout,try to  view new added LOV of type select List 
Then  user needs to relogin to see the new sets of values
When  user Is In a Page of TestRepository
And   creates a phase and adds few TestCases
And   user launch test planning page to create a cycle and assigns phase to cycle,assigns testcases to anyone
And   user goes to Test Execution page,selects testcases and executes with any status and clicks on D button
Then  window of link defect should be launched
When  user clicks on Create Defect and create defect
And   user Tries to view new added LOV of type select List 
Then  Should not be able to view new added LOV of type select List 

@Defect_Tracking1
Scenario:37 Edit field setup for custom field of type Select List in Jira, add new LOV and  view the change reflected in Zephyr after cache timeout
Given user Logins to Jira
When  user Goes to administration and clicks on Issues
And   Goes to custom fields,Already added a custom field of type Select List adds new list of values  
Then  should be able to add new list of values
When  user logins to zephyr as Manager credential
And   goes to administration
And   clicks on Defect Admin and clear the cashe timeout
When  user Launches defect tracking Page,clicks On Create Defect
And   Tries to view new added LOV of type select List 
Then  should be able to see the new set of values
When  user Launches Test Execution page,selects testcases and executes with any status and clicks on D button
Then  defect window should be launched
When  user clicks on Create Defect in test execution
And   User Tries to view New added LOV of type select List 
Then  Should be able to view new added LOV of type select List  

@Defect_Tracking1
Scenario: 39 Create  a defect/Subtask with custom field of type Select List
Given user Logins To Jira as admin
When  User clicks ON Administration and clicks on system
And   clicks on Advance Settings
And   Changes the format jira date picker javaformat to yyyy-MM-dd
And   Create a custom field in Jira of type date picker  
Then  custom field should be created
When  user Logins as Manager Credentials to zephyr and clicks on Administration
And   set DTS to JIRA by user
And   Launch Defects Admin app  and configured  dts customfield jira date_format = yyyy-MM-dd
Then  should be configuered jira date format
When  user Launches Defect Tracking app and clicks on Create Defect
And   creates a defect with customfield of type date Picker
Then  should be able to create a defect with custom field of type Date Picker  
When  user Launches Defect Tracking,searches a defect and selects it
And   creates a subtask with Custom Field of type Date Picker
Then  should be able to create a defect with Customfield of Type Date Picker
When  user Launches Test Repository and creates a phase and adds Few Testcases
And   Launches TestPlanning and creates a new Cycle and adds phase to cycle
And   assign Testcases to Anyone
And   Launches TestExecution,executes testcase with any status and clicks on D button
Then  Link defect window should be launched by user
When  user clicks on create defect and creates a defect with Customfield of Type Date Picker
Then  defect should be created of type date picker
When  user Launches TestRepository Page and creates a New phase and adds Few Testcases
And   Launches TestPlanning Page and creates a new Cycle and adds created phase to cycle,and assign testcases to anyone
And   Launches Test Execution,Executes testcase with Any status and Clicks on D button
Then  Link Defect Window should be launched by user
When  user clicks on Create Defect and creates a defect with custom field of Type Date Picker
Then  defect should be created with custom field of type date picker


#
@Defect_Tracking1
  Scenario: 21  Attempt To Create a Defect and Subtask
   Given User In Defect Tracking Page
  When User try to create a defect with summary of 255 characters
  Then Should not be able to create a Defect
  When User try to create a defect with Description of 2048 characters
  Then Should not be Able to Create a Defect
  When user Search a defect and select it and try to create a subtask Without Summary and With Description
  Then Should not be able To Create a Subtask Without Summary
  When User Search a defect and select it and Try to create a subtask With Summary and Without Description
  Then Should not be able to Create a subtask without Description
  When User Search a defect and Select it and try to create a Subtask with Summary of 255 characters
  Then should not be able To Create Subtask with Summary of 255 characters
  When user Search a defect and Select It and Try to create Subtask with Description of 2048 characters
  Then Should Not Be Able To Create Subtask with Description of 2048 characters
  When user click on TCC Create phase and Add testcase then go to Test planning and Create cycle then Add phase and execute testcase with any status
  When user click on Test Execution and Click on D and Try to create defect with summary of 255 chars
  Then Should not be able To Create Defect with summary of 255 chars
  When user Try to create a defect With Description of 2048 chars
  Then Should not be able to Create Defect With Description of 2048 chars
  When user  Click ON D and Select It and Try to create a subtask Without Summary and With Description
  Then Should NOT be able to Create SubTask Without Summary
  When user click D AND Search defect AnDselect it and Try to create subtask With Summary and Without Description
  Then ShoUld not Be Able to creatE subTask Without Description
  When User Click on D and Search a Defect and select it and try to create Subtask with Summary of 255 chars
  Then Should not Be Able to create SubTask
  When user click on D and Search defect and select it And Try to create Subtask with Description of 2048 chars
  Then should not be Able To Create Subtask
  




  @Defect_Tracking1
  Scenario: 22 Cancel a New Defect Prior to Submit
    Given User Is In defectTracking Page
     When User create defect with corresponding project and issuetype then click on cancel
      And Search defect and create subtask with corresponding project and issuetype then click on cancel
     When user click on TextExecution and execute testcases with any status
      And User click on D and create defect with corresponding project and issuetype and click on cancel
      And user click on D and create subtask with corresponding project and issuetype then click on cancel
  
    
   @Defect_Tracking1
  Scenario: 27 Attempt to edit and modify the Defect after Submission in Test Execution
    Given user is in Testrepository page
    When User click on Textexecution and create testcases and execute with any status and create defect
    And User try to modify defect project in created defect
    Then Should not be able to edit and modify the Defect
    When User search the defect and try to modify subtask project after submission in TestExecution
    Then Should not be able to edit and modify the subtask
    When User search the defect and try to modify subtask parentsID after submission in TestExecution
    Then Should not be able to modify the subtask
    
    
    @Defect_Tracking1
  Scenario: 28 View the details of a defect associated to a Testcase from Test Execution in Test Execution
   Given user is in TestRepository page
   When user click on TextExecution and create testcases and execute with any status and create defect
   #And user try to link the created defect with testcase and view the details of defect in currently inked defect grid
   Then should not be able to View the details of a defect
   When user try to create subtask and link with testcase and view the details of subtask in currently linked defect grid
   Then sholud not be able to view the details of defect
    
  @Defect_Tracking1
  Scenario: 29 Search by a specific Subtask number using Jira KeyID
  Given user is in Defecttracking page
  When user serach the subtask by JiraID in advance serach
  Then Should be able to search by a specific Subtask number
  When user click on Textexecution and execute testcases and create defect and search it
  Then should be able to search by a specific subtask number
  #
  #
  @Defect_Tracking1
 Scenario: 30 Export the Defects in Excel format
 Given User is in defectTracking page
 When User click on basic and serach by jiraId and select single defect and export defect into excel format
 Then Should be able to export the single defect into Excel format
 When User serach by jiraId and select multiple defect and export defects into excel format
 Then Should be able to export the multiple defects into Excel format
 When User select project and issuetype and select single defect and export into excel format
 Then Should be able to export the single defect into excel format
 When User select project and issuetype and select multiple defects and export into excel format
 Then Should be able to export the multiple defects into excel format
 When User select project and issuetype and status and serch single defect and export into excel format
 Then Should be able to export the single Defect into excel format 
 When User select project and issuetype and status and select multiple defects and export into excel format
 Then Should be able to export the multiple Defects into excel format
 When User select assignee and select single defect and export into excel format
 Then Should be able to export single defecct into excel format
 When User select assignee and select multiple defects and export into excel format
 Then Should be able to export multiple defects into Excel format
 When User select Filedby and select single defect and export into excel format
 Then Should be able to export single defect into excel format in filedby
 When User select Filedby and select multiple defects and export into excel format
 Then Should be able to export multiple defect into excel format in filedby
 When User click on Advance and select single defect and export into excel format
 Then Should be able to export single defect and export into excel format in advance search
 When User select multiple defects and export into excel format
 Then Should be able to export multiple defects and export into excel format in advance search
 When User select JQL and select single defect and export into excel format
 Then Should be able to export single defect into excel format while selecting JQL
 When User select JQL and select multiple defects and export into excel format
 Then Should be able to export multiple defects into excel format while selecting JQL
 When User select Filters and select single defect and export into excel format
 Then Should be able to export single defect into excel format while selecting filters
 When User select Filters and select multiple defect and export into excel format
 Then Should be able to export multiple defect into excel format while selecting filters
  
   @Defect_Tracking1
  Scenario: 24 Update a defect with attachment
  Given User Is in DefectTracking Page
   When User create defect and search it and update an attachment in  text format
   Then Should be able to update a defect with attachment in text format
   When User update an attachment in excel format
   Then Should be able to update a defect with attachment in excel format
   When User update an attachment in word format
   Then Should be able to update a defect with attachment in word format
   When User update an attachment in image format
   Then Should be able to update a defect with attachment in image format
   When User update an attachment in any other format 
   Then Should be able to update a defect with attachment in other format
   When User update multiple attachments in different format
   Then Should be able to update a defect with multiple attachments in different formats
   When User attempt to update file of size TenMB 
   Then Should be able to update a defect with attachment of size TenMB 
   When User create a file with special characters and try to upload that file
   Then Should be able to update a defect with attachment of special char file
   When User search the defect and create subtask and update an attachment in  text format
   Then Should be able to update subtask with attachment in text format
   When User try to update an attachment in excel format
   Then Should be able to update subtask with attachment in excel format
   When User try to update an attachment in word format
   Then Should be able to update subtask with attachment in word format
   When User try to update an attachment in image format
   Then Should be able to update subtask with attachment in image format
   When User try to update an attachment in any other format 
   Then Should be able to update subtask with attachment in other format
   When User try to update multiple attachments in different format
   Then Should be able to update subtask with multiple attachments in different formats
   When User try to attempt to update file of size TenMB 
   Then Should be able to update subtask with attachment of size TenMB 
   When User create a file with special characters and try to upload it
   Then Should be able to update subtask with attachment of special char file
   When User launch TextExecution and execute testcases with any status and create defect 
    And User update an attachment in text format in TE 
   Then Should be able to update a defect with attachment in text format in TE
   When User update an attachment in excel format in TE
   Then Should be able to update a defect with attachment in excel format in TE
   When User update an attachment in word format in TE
   Then Should be able to update a defect with attachment in word format in TE
   When User update an attachment in image format in TE
   Then Should be able to update a defect with attachment in image format in TE
   When User update an attachment in any other format in TE 
   Then Should be able to update a defect with attachment in other format in TE
   When User update multiple attachments in different format in TE
   Then Should be able to update a defect with multiple attachments in different formats in TE
   When User attempt to update file of size TenMB in TE
   Then Should be able to update a defect with attachment of size TenMB in TE
   When User create a file with special characters and try to upload that fiel in TE
   Then Should be able to update a defect with attachment of special char file in TE
   When User launch TextExecution and execute testcases with any status and click on D and create subtask
   And  User try to update an attachment in  text format in TE
   Then Should be able to update subtask with attachment in text format in TE
   When User try to update an attachment in excel format in TE
   Then Should be able to update subtask with attachment in excel format in TE
   When User try to update an attachment in word forma in TEt
   Then Should be able to update subtask with attachment in word format in TE
   When User try to update an attachment in image format in TE
   Then Should be able to update subtask with attachment in image format in TE
   When User try to update an attachment in any other format in TE 
   Then Should be able to update subtask with attachment in other format in TE
   When User try to update multiple attachments in different format in TE
   Then Should be able to update subtask with multiple attachments in different formats in TE
   When User search the defect and create subtask and attempt to update file of size TenMB  in TE
   Then Should be able to update subtask with attachment of size TenMB in TE 
   When User try to create a file with special characters and try to upload it in TE
   Then Should be able to update subtask with attachment of special char file in TE
   
   @Defect_Tracking1
  Scenario: 25 View the attachment of Defect in different format
  Given User is in defecttracking page
  When User search the defect and attach the text format and try to view the attachment
  Then Should be able to view the attachment of defect in text format
  When User search the defect and attach the excel format and try to view the attachment
  Then Should be able to view the attachment of defect in excel format
  When User search the defect and attach the word format and try to view the attachment
  Then Should be able to view the attachment of defect in word format
  When User search the defect and attach the image format and try to view the attachment
  Then Should be able to view the attachment of defect in image format
  When User click on testexecution and execute testcases in any status and create defect
   And User create subtask and attach the text format and try to view the attachment
  Then Should be able to view the attachment of subtask in text format
  When User create subtask and attach the excel format and try to view the attachment
  Then Should be able to view the attachment of subtask in excel format
  When User create subtask and attach the word format and try to view the attachment
  Then Should be able to view the attachment of subtask in word format
  When User create subtask and attach the image format and try to view the attachment
  Then Should be able to view the attachment of subtask in image format
  
 


 @Defect_Tracking1
  Scenario: 26 Download attachment of Defect in any format
  Given User is in DefectTracking Page
  When User serach the defect and attach any format file and save it then view and download the attachment
  Then Should be able to Download attachment
  When User click on TestExecution and execute testcases with any status and create defect
  And User search thd defect and create subtask and attach any format file and save it and view it then download the attachment
  Then should be able to download attachment
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  
 
 
 
    @Defect_Tracking1
   Scenario: 239 Change the status of linked defect from open to Inprogress and view count in Overall gadget
    Given User is in administration page
    When User set the DTS to JIRA
    Then Should be able to set the DTS to JIRA
    When User launch the testexecution
    Then Should be able to launch testexecution
    When User link one defect with status open to execution
    Then Should be able to link the defect
    When User create the dashboards
    Then Should be able to add dashboards
    When User launch the gadget
    Then Should be able to launch the gadget
    When User add overall gadget
    Then Should be able to add overall gadget
    When User search that linked defect in DefectTracking
    Then Should be able to search that linked defect
    When User change the status from open to inprogress
    Then Should be able to change the status
    When User refresh the added overall gadget
    Then Should be able to refresh the overall gadget
    When view the defect count by status
    Then defect count show updated count with status


   @Defect_Tracking1
  Scenario: 240 <DT/Gadget> Change the status of linked defect from "In-progress" to "Done" and view count in "Overall gadget"
    Given User Is In administration page
    When User set the dts to JIRA
    Then Should be able to set the dts to JIRA
    When User launch the TestExecution
    Then Should Be able to launch TestExecution
    When User link one defect with status inprogress to execution
    Then Should be able to link the defect with status inprogress
    When User create the Dashboard
    Then Should be able to add Dashboard
    When User launch the Gadget
    Then Should be able to launch the Gadget
    When User add Overall Gadget
    Then Should be able to add Overall Gadget
    When User search the linked defect in DefectTracking
    Then Should be able to search the linked defect
    When User change the status from inprogress to done
    Then Should be able to change the status from inprogress to done
    When User Refresh the added overall gadget
    Then Should be able to refresh the Overall Gadget
    When view the defect count by status of done
    Then defect count show updated count with status of done
  
   @Defect_Tracking1
 Scenario: 241 <DT/Gadget> Change the status of linked defect from "DONE" to "TO DO" and view count in "Overall gadget"
    Given User is in Administration Page
    When User set the dts to jira
    Then Should be able to set the dts to jira
    When User launch the TestExecution and click on D  
    Then Should be Able to launch TestExecution
    When User link one defect with status Done to execution
    Then Should be able to link the defect with status Done
    When User Create the Dashboard
    Then Should be able to Add Dashboard
    When User Launch the Gadget
    Then Should be able to launch Gadget
    When User Add Overall Gadget 
    Then Should be able to Add Overall Gadget
    When User Search the linked defect in DefectTracking
    Then Should be able to search the linked Defect
    When User change the status from Done to TO DO
    Then Should be able to change the status from Done to TO DO 
    When User Refresh the added Overall Gadget
    Then Should be able to Refresh Overall Gadget
    When view the defect count by status of TO Do
    Then defect count show updated count with status of TO DO
    
   @Defect_Tracking1
 Scenario: 1969 <DT/Gadget> Delete linked defect and view count in "Overall gadget"
 Given user is in administration page
 When user set DTS to jira
 Then should be able to set dts to jira
 When user launch the textexecution
 Then should be able to launch the textexecution 
 When user link one defect to execution 
 Then should be able to link the defect to execution
 When user create the dashboard 
 Then should be able to create dashboard
 When user launch the gadget page
 Then should be able to launch the gadget page
 When user add the overall gadget
 Then should be able to add overall gadget
 When user search the linked defect in jira
 Then should be able to search the linked defect in jira
 When user delete the linked defect
 Then should be able to delete the linked defect
 When user refresh the added overall gadget
 Then should be able to refresh the added overall gadget
 When user view the Defect count by status 
 Then Defect count show updated count with status
 
   @Defect_Tracking1
 Scenario: 242 <DT/Gadget> Change the priority of linked defect, View count in "Open gadget"
 Given user is in Administration Page
 When user set the dts to jira
 Then should be able to set the dts to jira
 When user Launch the testexecution
 Then should be able to Launch the testexecution
 When user link one defect with status open to execution
 Then should be able to link defect with status open to execution
 When user create Dashboard
 Then should be able to create Dashboard
 When user launch the Gadget Page
 Then should be able to launch the Gadget Page
 When user add the open gadget
 Then should be able to add open gadget
 When user search that linked defect in JIRA
 Then should be able to search the linked defecct in JIRA
 When user change the priority of linked defect
 Then should be able to change priority of linked defect
 When user refresh the added open gadget
 Then should be able to refresh the open gadget
 When user view the defect count by priority
 Then defect count show updated count with priority
 
 
   @Defect_Tracking1
 Scenario: 243 Delete linked defect and view count in "open defect" gadget
 Given user Is In Administration Page
 When user set dts to the jira
 Then should be able to set dts to the jira
 When user launch the TestExecution
 Then should be able to launch the TestExecution 
 When user link one defect to the execution 
 Then should be able to link the defect to the execution
 When user create the DashBoard 
 Then should be able to create DashBoard
 When user launch the gadget Page
 Then should be able to launch the gadget Page
 When user add the open defects gadget
 Then should be able to add open defects gadget
 When user search the linked defect in JIRA
 Then should be able to search the linked defect in JIRA
 When user delete the linked defect in jira
 Then should be able to change priority
 When user refresh the added open defect gadget
 Then should be able to refresh the added open defects gadget
 When User view the Defect count by status 
 Then Defect count show updated count with priority
    
   @Defect_Tracking1
 Scenario: 244 <DT/Gadget> Change the status of linked defect from "open" to "Inprogress" and view count in "Traceability gadget"
 Given User Is in administration page
 When user set dts to Jira
 Then should be able to set
 When user click on Requiremetns 
 Then should be able to launch Requirements
 When user create a node and add Requirements
 Then should be able to add Requirements
 When user launch the Test repository
 Then should be able to launch the Test repository
 When user create phase and add the testcases
 Then should be able to add testcases
 When user map testcases to requiremetns
 Then should be able to map
 When user launch Test planning
 Then should be able to launch Test planning
 When user create cycle and assign phase to users
 Then should be able to assign testcases to users
 When user launch Test execution
 Then should be able to launch Test execution
 When user link One defect with status Open to execution
 Then should be able to link defect with status Open to execution
 When user create dashBoards
 Then should be able to create dashBoards
 When user launch the Gadaget page
 Then should be Able to launch the Gadget Page
 When user add Traceability gadget
 Then should be able to add Traceability gadget
 When user search that linked defect in DT app
 Then should be able to search that linked defect in DT app
 When user change status from Open to Inprogress
 Then should be able to change status from Open to Inprogress
 When user refresh the added Traceability gadget
 Then should be able to refresh the added Traceability gadget
 When user view the total and open defect count
 Then defect count show updated count with status in added Traceability gadget
 
  @Defect_Tracking1
 Scenario: 245 <DT/Gadget> Change the status of linked defect from "Inprogress" to "Done" and view count in "Traceability gadget"
 Given User Is In administration Page
 When User set dts to Jira
 Then Should be able to set
 When user launch the Test execution
 Then should be able to launch the Test execution
 When user link One defect with status Inprogress to execution
 Then should be able to link defect with status Inprogress to execution
 When user create the dashBoards
 Then should be able to create the dashBoards
 When user launch the Gadaget Page
 Then should Be able to launch the Gadget Page
 When user add Traceability Gadget
 Then should be able to add Traceability Gadget
 When user search that linked defect in defecttracking
 Then should be able to search that linked defect in defecttracking
 When user change status from Inprogress to Done
 Then should be able to change status from Inprogress to Done
 When user refresh the added Traceability Gadget
 Then should be able to refresh the added Traceability Gadget
 When user view the total and Open defect count
 Then defect count show updated count with status in added Traceability Gadget
 
  @Defect_Tracking
 Scenario: 246 <DT/Gadget> Change the status of linked defect from "Done" to "Open" and view count in "Traceability gadget"
 Given user Is In administration page
 When User set Dts to Jira
 Then Should be Able to Set
 When user launch TestExecution
 Then should be able to launch TestExecution
 When user link One defect with status Done to execution
 Then should be able to link defect with status Done to execution
 When user create the DashBoards
 Then should be able to create the DashBoards
 When user launch the gadaget Page
 Then should be Able to launch the gadget Page
 When user add traceability gadget
 Then should be able to add traceability gadget
 When user search that linked defect in Defecttracking
 Then should be able to search that linked defect in Defecttracking
 When user change status from Done to Open 
 Then should be able to change status from Done to Open 
 When user refresh the added traceability gadget
 Then should be able to refresh the added traceability gadget
 When user view the Total and open defect count
 Then Defect count show updated count with status in added Traceability gadget
    
   @Defect_Tracking
 Scenario: 247 <DT/Gadget> Delete linked defect and view count in "Traceability gadget"
 Given User Is In Administration Page
 When User set DTS to Jira
 Then Should be able to Set DTS to Jira
 When User launch TestExecution
 Then Should be able to launch TestExecution
 When User link One defect with status ToDo to execution
 Then should be able to link defect with status ToDo to execution
 When User create the DashBoards
 Then Should be able to create the DashBoards
 When User launch the gadaget Page
 Then Should be Able to launch the gadget Page
 When User add traceability gadget
 Then Should be able to add traceability gadget
 When User search that defect in JIRA and Delete it
 Then Should search that defect and delete 
 When User refresh the added traceability gadget
 Then Should be able to refresh the added traceability gadget
 When User view the Total and open defect count
 Then Defect count show updated count with status in Traceability gadget
 
 @Defect_Tracking
 Scenario: 2073 After creating defect in mapped jira project run  ETL and view defect count in "Daily pulse gadget"
 Given User is In Administration Page
 When User Set Dts to Jira
 Then Should be able to set Dts to jira
 When User launch project setup
  And User map ZE project to jira project
 Then Should be able to map ZE project to jira project
 When User launch the dashboard
 Then Should be able to launch the dashboard
 When User add the dashboard
 Then Should be able to add dashboard
 When User add the dailypulse gadget
 Then Should be able to add dailypulse gadget
 When User view the defect count
 Then Should show proper defect count
 When User create one more defect in mapped project
 Then Should be able to create defect in mapped project
 When User view defect count after creating defect in mapped project
 Then should show proper defect count after creating defect in mapped Project
 
@Defect_Tracking
 Scenario: 248 After deleting defect in mapped jira project run  ETL and view defect count in "Daily pulse gadget"
 Given User in administration page
 When User set Dts to JIRA
 Then Should be able to set Dts to JIRA
 When User launch Project setup
  And User map ZE project to JIRA project
 Then Should be able to map ZE project to JIRA project
 When User launch dashboard
 Then Should be able to launch dashboard
 When User Add one dashboards
 Then Should be able to Add dashboards
 When User Add dailypulse gadget
 Then Should be able to add Dailypulse gadget
 When User view the defect count after adding dailypulse gadget
 Then Should show proper defect count after adding dailypulse gadget
 When User delete defect in mapped jira project
 Then Should be able to delete defect
 When User view proper defect count after deleting defect 
 Then Should be able to view proper defect count after deleting defect
 
 
#
#@Defect_Tracking
#Scenario: 266 Create a defect with custom field of type MultiSelect
#Given User isin defectTracking Page
#When User create defect with customfield of type multiselect if option value is in number
#Then Should be able to create defect if option value is in number
#When User create defect if option value is in uppercase
#Then Should be able to create defect if option value is in uppercase
#When User create defect if option value is in lowercase
#Then Should be able to create defect if option value is in lowercase  
#When User create defect if option value is in alphanumeric characters
#Then Should be able to create defect if option value is in alphanumeric characters
#When User create defect if option value is in special character
#Then Should be able to create defect if option value is in special character
#When User create defect if option value is in international characters
#Then Should be able to create defect if option value is in international characters
#When User create defect if option value is very long
#Then Should be able to create defect if option value is very long
#When User Launch the Testexecution
#Then Should be able to Launch the Testexecution
#When User create defect with customfield of type multiselect if option value is in Number
#Then Should be able to create defect if option value is in Number
#When User create defect if option value is in Uppercase
#Then Should be able to create defect if option value is in Uppercase
#When User create defect if option value is in Lowercase
#Then Should be able to create defect if option value is in Lowercase  
#When User create defect if option value is in Alphanumeric characters
#Then Should be able to create defect if option value is in Alphanumeric characters
#When User create defect if option value is in Special character
#Then Should be able to create defect if option value is in Special character
#When User create defect if option value is in International characters
#Then Should be able to create defect if option value is in International characters
#When User create defect if option value is Very long
#Then Should be able to create defect if option value is Very long
#
 #
 #@Defect_Tracking
 #Scenario: 288 Search for a defect with custom field value any type by attribute
 #Given user is In defectTracking page
 #When User create defect with any types of customfield values
 #Then Should be able to create defect with any types of customfield values
 #When User create defect with any types of customfield values in testexecution
 #Then Should be able to create defect with any types of customfield values in testexecution
 #When User search for a defect with customfield value any type using attributes in defecttracking
 #Then Should be able to search the defect in defecttracking with customfield value any type using attributes
 #When User search for a defect with customfield value any type using attributes in testexecution
 #Then Should be able to search the defect in testexecution with customfield value any type using attributes  
  

   
@Defect_Tracking
Scenario: 47 Change Multiple Defects/Subtask from single Component to multiple Components for the same Project 
Given User is in the Defect_Tracking page
 When User search the defects and select the multiple defects to change single component to multiple component
  And Click on Change multiple defect option
  And Change single component to multiple multiple component for the same project
 Then Should be able to change multiple defects from single component to multiple component   
   
@Defect_Tracking
Scenario: 48 Change Multiple Defects/Subtask from single fix version to multiple fix versions for the same Project 
Given User is in defect Tracking page
 When User search the defects and select multiple defects
  And click on change multiple defect option
  And change fix version to multiple fix version for the same project
 Then Should be able to change multiple defects from single fix version to multiple fix version
 
@Defect_Tracking
Scenario: 49 Change Multiple Defects/Subtask from single affected version to multiple affected versions for the same Project 
Given User is in the DefectTracking page
 When User search the defects and select the multiple defects
  And Click on change multiple defect option
  And change single affected version to multiple affected version for the same project
 Then Should be able to change multiple defects from single affected version to multiple affected version
 
@Defect_Tracking
Scenario: 17 Update a defect/sub task in “update defect” window
Given User is in the defect tracking page
 When User search the defect and select the defect
  And click on edit and update the defect summary
 Then Should be able to update the defect summary
 When User search the the defect and click on edit
  And enter the description field of a defect
 Then Should be able to update the defect description
 When search the defect and enter the priority
 Then Should be able to update the defect priority
 When search the defect and update the component
 Then Should be able to update the defect component
 When search the defect and update the version
 Then Should be able to update the defect version
 When search the defect and update the fixversion
 Then Should be able to update the defect fixversion
 When search the defect and update the label
 Then Should be able to update the defect label
 When search the defect and update the assignee
 Then Should be able to update the defect assignee
 When search the defect and update the environment
 Then Should be able to update the defect environment
 When search the defect and update the custom field text
 Then Should be able to update the defect custom field text
 When search the defect and update the custom field free text
 Then Should be able to update the defect custom field free text
 When search the defect and update the custom field text
 Then Should be able to update the defect custom field text
 When search the defect and update the custom field checkbox
 Then Should be able to update the defect custom field checkbox
 When search the defect and update the custom field radio button
 Then Should be able to update the defect custom field radio button
 When search the defect and update the custom field Date picker
 Then Should be able to update the defect custom field Date picker
 When search the defect and update the custom field URL
 Then Should be able to update the defect custom field URL
 When search the defect and update the custom field single select
 Then Should be able to update the defect custom field single select
 When search the defect and update the custom field multi select
 Then Should be able to update the defect custom field multi select
 When search the defect and update the custom field version picker
 Then Should be able to update the defect custom field version picker
 When search the defect and update the custom field multiple version picker
 Then Should be able to update the defect custom field multiple version picker
 When search the defect and update the custom field single user picker
 Then Should be able to update the defect custom field single user picker
 When search the defect and update the custom field multiple user picker
 Then Should be able to update the defect custom field multiple user picker
 When search the defect and update the custom field label
 Then Should be able to update the defect custom field label
 When search the defect and update custom field single select list cascading parent/child
 Then Should be able to update the defect custom field single select list cascading parent/child
 When search the defect and update custom field multiple select list cascading parent/child
 Then Should be able to update the defect custom field multiple select list cascading parent/child
 When search the defect subtask and enter the summary
 Then Should be able to update the defect subtask summary
 When search the defect subtask and enter the description
 Then Should be able to update the defect subtask description
 When search the defect subtask and enter the priority
 Then Should be able to update the defect subtask priority
 When search the defect subtask and update the component
 Then Should be able to update the defect subtask component
 When search the defect  subtask and update the version
 Then Should be able to update the defect subtask version
 When search the defect subtask and update the fixversion
 Then Should be able to update the defect subtask fixversion
 When search the defect subtask and update the label
 Then Should be able to update the defect subtask label
 When search the defect subtask and update the assignee
 Then Should be able to update the defect subtask assignee
 When search the defect subtask and update the environment
 Then Should be able to update the defect subtask environment
 When search the defect subtask and update the custom field text
 Then Should be able to update the defect subtask custom field text
 When search the defect subtask and update the custom field free text
 Then Should be able to update the defect subtask custom field free text
 When search the defect subtask and update the custom field text
 Then Should be able to update the defect subtask custom field text
 When search the defect subtask and update the custom field checkbox
 Then Should be able to update the defect subtask custom field checkbox
 When search the defect subtask and update the custom field radio button
 Then Should be able to update the defect subtask custom field radio button
 When search the defect subtask and update the custom field Date picker
 Then Should be able to update the defect subtask custom field Date picker
 When search the defect subtask and update the custom field URL
 Then Should be able to update the defect subtask custom field URL
 When search the defect subtask and update the custom field URL
 Then Should be able to update the defect subtask custom field URL
 When search the defect subtask and update the custom field single select
 Then Should be able to update the defect subtask custom field single select
 When search the defect subtask and update the custom field multi select
 Then Should be able to update the defect subtask custom field multi select
 When search the defect subtask and update the custom field version picker
 Then Should be able to update the defect subtask custom field version picker
 When search the defect subtask and update the custom field multiple version picker
 Then Should be able to update the defect subtask custom field multiple version picker
 When search the defect subtask and update the custom field single user picker
 Then Should be able to update the defect subtask custom field single user picker
 When search the defect subtask and update the custom field multiple user picker
 Then Should be able to update the defect subtask custom field multiple user picker
 When search the defect subtask and update the custom field label
 Then Should be able to update the defect subtask custom field label
 When search the defect subtask and update custom field single select list cascading parent/child
 Then Should be able to update the defect subtask custom field single select list cascading parent/child
 When search the defect subtask and update custom field multiple select list cascading parent/child
 Then Should be able to update the defect subtask custom field multiple select list cascading parent/child
 
@Defect_Tracking
Scenario: 18 Update a defect/sub task in “update defect” window
Given User is in Test Repository page
 When User create a phase with testcase
  And User launch TestPlanning to create a cycle and add phase to cycle
  And User launch TestExecution execute testcase  
  And User click on Create Defect button and enter the projectName and issueType
  And enter the summary and description and save the Defect
  And update all the available fields for the defect 
 Then should be able to update the defect
 When User search the defect in TestExecution page
  And Click on create Subtask button
  And enter the defect subtask issue type
  And enter the Summary and Description of Subtask and save the defect
  And Update all the available fields for defect subtask
 Then Should be able to Update the defect subtask  
 
 
@Defect_Tracking
Scenario: 6 As Mgr/lead/tester, Create a Defect/subtask in Defect Tracking_External System
Given User is in the defectTracking page
 When User click on create defect button and enter the projectName and issueType
  And enter the minimum required fields and save
 Then Should be able to Create defect 
 When search a defect and select the defect in defect tracking page
  And Click on Create Subtask button and enter the issueType
  And enter the minimum required fields and save the Subtask
 Then Should be able to create defect Subtask
 When Click on create defect button and enter the projectName and issueType
  And enter the mandatory fields and optional fields and save
 Then Should be able to create defect with mandatory and optional fields
 When Search a defect and select the defect in DefectTracking page
  And Click on Create Subtask button and enter the IssueType
  And enter the mandatory and optional fields
 Then Should be able to create subtask with minimum required and optional fields
 When launch TestRepository and create a phase with testcase
  And launch TestPlanning to create a cycle and add phase to cycle
  And launch TestExecution to execute testcases
  And click on D button and click on create defect button and enter the projectName and issueType
  And enter the minimum required fields to create a defect
 Then Should be able to create a defect with minimum required fields in TestExecution
 When search a defect and click on Subtask icon
  And enter the issuetype and minimum required fields
 Then Should be able to create defect Subtask with minimim required fields
 When Click on D button to create the defect
  And click on create defect and enter the mandatory and optional fields
 Then Should be create a defect with mandatory and optional fields
 When search a defect in test execution
  And click on Create Subtask icon and enter the issueType
  And enter the mandatory and optional fields to create a defect
 Then Should be able to create a defect subtask with mandatory and optional fields
 
 
 @Defect_Tracking
Scenario: 20 <DT/Test Execution> Remove the non-mandatory field values
Given User is in a DefectTracking page
 When User click on create defect and enter the projectName and issuetType
  And enter all the fields and save
 Then Should be able to create a defect
 When search a defect and click on edit
  And remove the non-mandatory Fields
 Then Should be able to remove the non-mandatory fields
 When User launch test repository to create a phase with testcases
  And Launch test planning to create a cycle and add phase to the cycle
  And launch test execution to execute testcase 
  And click on D button and click on create defect button and enter projectName and issueType
  And Enter all the Fields and save
  And Remove The non-mandatory fields
 Then should be able to remove the non-mandatory Fields
 
@Defect_Tracking
Scenario: 144 <DT> Search issues with "AND" operator in JQL
Given User is in the defect Tracking
 When User search a issue with AND operator
 Then Should be search issues with AND operator
 When User launch requirements
  And search a issue with AND operator
 Then Should be able to search issue with AND operator
 When User launch Test Execution to search Issue
  And Search a issue with AND Operator
 Then Should be able to search a issue with AND operator
 #
@Defect_Tracking
Scenario: 164 <DT> Attempt to export more than 500 defects from DT search grid
Given User logged in as manager
 When Manager is in Administration page
  And set the DTS to Jira
 Then Should be able to set DTS 
 When User is in the Defect Tracking Page
 Then should be able to launch defect tracking
 When User search the defects by selecting the project
 Then Should search more than five hunderd defects
 When select all the searched defects
 Then Should select more than five hunderd defects
 When click on export button
 Then Should get proper message
 
@Defect_Tracking
Scenario: 165 <DT> Attempt to create a sub_task for a sub_task
Given Manager is in the project page
 When launch administration to set DTS
  And set DTS to JIRA
 Then Should be able to set the DTS
 When User is in Defect_Tracking page
 Then Should be able to launch defect_tracking
 When User search the defect subtask in defect tracking
 Then Should search subtask
 When select the defect and click on create subtask
 Then create subtask button should be disabled if searched defect is of type subtask

@Defect_Tracking
Scenario: 166 <DT> Link 50 defect to test executions
Given Manager is in a Administration page
 When set to DTS to JIRA
 Then Should be able to Set DTS 
 When User is in Test_Repository page to create testcase
  And launch Test Planning to create cycle and add phase to the cycle
 When launch the Test Execution
 Then Should launch Test Execution 
 When execute the testcase
 Then Should execute testcase
 When click on D button
 Then Should launch link defect window
 When search more than fifty defects and link to execution
 Then Should be able to link fifty defects to execution
#
#
@Defect_Tracking 
Scenario: 135 <DT> Create a defect/subtask with edited component value
Given User is in the project age
 When User navigate to the External Jira page
  And User navigate to the component page and edit the component value
 Then Should be able to edit the component value
 When Manager Launch the Defect Admin page
 Then Should be able to Launch Defect Admin
 When clear the cache of online project  
 Then Should be able to clear the cache
 When launch DefectTracking Page
 Then Should be able to Launch DT page
 When create a defect with edited component value
 Then Should be able to create defect with edited component value

@Defect_Tracking
Scenario: 133 <DT> Create a defect/subtask with in edited Issue type
Given User is in the Project page to select project
 When User navigate to the External jira page
  And navigate to the issues and edit the issueType
 Then Should be able to edit the existing issueType
 When As a Manager,launch defect admin page
 Then Should be able to launch defect admin page
 When clear the cache of an Online Project
 Then Should be able to Clear the Cache
 When Launch the defect tracking page
 Then Should be able to Launch Defect tracking pagess
 When create a defect with edited issueType
 Then Should be able to create a defect with edited issueType
 
 @Defect_Tracking
Scenario: 134 <DT> Create a defect/subtask with edited priority
Given User is in the project_page
 When User navigate to an External Jira page
  And User navigate to the priority page
 Then Should be able to edit the priority value
 When Manager launch the Defect Admin page
 Then Should be able to launch Defect Admin
 When clear the cache of a online project  
 Then Should clear the cache
 When launch DefectTracking page
 Then Should be able to launch DT page
 When create a defect with edited priority value
 Then Should be able to create defect with edited priority value 

@Defect_Tracking
Scenario: 136<DT> Create a defect/subtask with edited affected version value
Given User is in the project page selection
 When User navigate to an External_Jira page
  And User navigate to the affected version
 Then Should be able to edit the affected version value
 When Manager launch the Defect Admin Page
 Then Should be able to launch Defect Admin page
 When Clear the cache of a online project  
 Then Should Clear the cache
 When Launch DefectTracking page
 Then Should be able to launch DefectTracking page
 When create a defect with edited affected version value
 Then Should be able to create defect with edited affected version value

@Defect_Tracking
Scenario: 137<DT> Create a defect/subtask with edited fix version value
Given User is in the Project page selection
 When User Navigate to an External_Jira page
  And User navigate to the fix version
 Then Should be able to edit the fix version value
 When Manager Launch the Defect Admin Page
 Then Should be able to launch Defect Admin Page
 When Clear the Cache of a online project  
 Then Should Clear the Cache
 When Launch the DefectTracking page
 Then Should Be able to launch DefectTracking page
 When create a defect with edited fix version value
 Then Should be able to create defect with edited fix version value
 
@Defect_Tracking
Scenario: 138 <DT> Create the defect/subtask with edited custom field checkbox value
Given User is in the Project page Selection
 When User Navigate To an External_jira page
  And User navigate to the custom fields page to edit custom field checkbox value
 Then Should be able to edit the custom field checkbox value
 When As a Manager Launch the Defect Admin Page
 Then Should Be able to launch Defect Admin Page
 When Clear the Cache of a Online project  
 Then Should Clear The Cache
 When Lead Launch the DefectTracking page
 Then Should Be able to Launch DefectTracking page
 When create a defect with edited custom field checkbox value
 Then Should be able to create defect with edited custom field checkbox value 

@Defect_Tracking
Scenario: 139 <DT> Create the defect/subtask with edited custom field single select list value
Given User is in the Project_page Selection
 When User Navigate To an external_Jira page
  And User navigate to the Custom fields page to edit custom field single select list value
 Then Should be able to edit the custom field single select list value
 When As a Manager Launch the Defect Admin page
 Then Should Be able to launch Defect Admin page
 When clear the Cache of a Online project  
 Then Should clear The Cache
 When As a Lead Launch the DefectTracking page
 Then Should Be able To Launch DefectTracking page
 When create a defect with edited custom field single select list value
 Then Should be able to create defect with edited custom field single select list value 
 
@Defect_Tracking
Scenario: 140 <DT> Create the defect/subtask with edited custom field multi select list value
Given User is in Project page Selection
 When User Navigate To the external_Jira page
  And User navigate to the Custom Fields page to edit custom field multi select list value
 Then Should be able to edit the custom field multi select list value
 When As a Manager Launch the defect Admin page
 Then Should Be able to launch defect Admin Page
 When Clear the Cache of an Online project  
 Then should clear The Cache
 When As a Lead,Launch the DefectTracking page
 Then Should be Able to Launch DefectTracking page
 When create a defect with edited custom field multi select list value
 Then Should be able to create defect with edited custom field multi select list value  

@Defect_Tracking
Scenario: 141 <DT> Create the defect/subtask with edited custom field radio button value
Given User is in project page Selection
 When User navigate To the external_Jira page
  And User navigate to the Custom Fields page to edit the custom field radio button value 
 Then Should be able to edit the custom field radio button value
 When As a Manager,Launch the defect admin page
 Then Should Be able to launch defect admin Page
 When clear the Cache of an Online project  
 Then should clear the CaChe
 When As a Lead,Launch the defectTracking page
 Then Should Be Able to Launch DefectTracking page
 When create a defect with edited custom field radio button value
 Then Should be able to create defect with edited custom field radio button value   
 
@Defect_Tracking
Scenario: 142 <DT> Create the defect/subtask with edited custom field single version picker
Given User is in project_page Selection
 When User navigate to the external_Jira page
  And User navigate to the version fields Page
 Then Should be able to edit the custom field single version picker 
 When As a Manager,launch the defect admin page
 Then Should Be able to Launch defect admin Page
 When clear the Cache of an Online Project  
 Then should be able to Clear the Cache
 When As a Lead,Launch the defectTracking Page
 Then Should Be Able to Launch DefectTracking Page
 When create a defect with edited custom field single version picker value
 Then Should be able to create defect with edited custom field single version picker value 

@Defect_Tracking
Scenario: 250 <Test Execution/DT> Create a defect/Subtask with custom field of type URL
Given User is in the External JIra page 
 When User create a custom field of type URL
  And User navigate to the defectTracking page
  And create a defect defect with only numbers in custom field of type URL
 Then Should be able to create a defect with only numbers in custom field of type URL
 When create a defect with UPPERCASE in custom field of type URL
 Then Should be able to create a defect with UPPERCASE in custom field of type URL
 When create a defect with lowercase in custom field of type URL
 Then Should be able to create a defect with lowercase in custom field of type URL 
 When create a defect with alphanumeric characters in custom field of type URL
 Then Should be able to create a defect with alphanumeric characters in custom field of type URL  
 When create a defect with special characters in custom field of type URL
 Then Should be able to create a defect with special characters in custom field of type URL
 When create a defect with international characters in custom field of type URL
 Then Should be able to create a defect with international characters in custom field of type URL 
 When create a defect with very long atleast five hundred and twelve characters in custom field of type URL
 Then Should be able to create a defect with very long atleast five hundred and twelve characters in custom field
 When create a defect with supported protocol in custom field of type URL
 Then Should be able to create a defect with supported protocol in custom field of type URL  of type URL
 When User navigate to the Test Execution to execute testcase
  And create a defect defect with only numbers in custom field of type URL in TestExecution
 Then Should be able to create a defect with only numbers in custom field of type URL in TestExecution
 When create a defect with UPPERCASE in custom field of type URL in TestExecution
 Then Should be able to create a defect with UPPERCASE in custom field of type URL in TestExecution
 When create a defect with lowercase in custom field of type URL in TestExecution
 Then Should be able to create a defect with lowercase in custom field of type URL in TestExecution 
 When create a defect with alphanumeric characters in custom field of type URL in TestExecution
 Then Should be able to create a defect with alphanumeric characters in custom field of type URL in TestExecution  
 When create a defect with special characters in custom field of type URL in TestExecution
 Then Should be able to create a defect with special characters in custom field of type URL in TestExecution
 When create a defect with international characters in custom field of type URL in TestExecution
 Then Should be able to create a defect with international characters in custom field of type URL in TestExecution 
 When create a defect with very long atleast five hundred and twelve characters in custom field of type URL in TestExecution
 Then Should be able to create a defect with very long atleast five hundred and twelve characters in custom field in TestExecution
 When create a defect with supported protocol in custom field of type URL in TestExecution
 Then Should be able to create a defect with supported protocol in custom field of type URL  of type URL in TestExecution  

@Defect_Tracking  
Scenario: 251 <Test Execution/DT> Edit a defect/Subtask change the value for custom field of type URL
Given User is in the ExternalJira page
 When User create the custom field of type URL
  And User launch defectTracking
  And create a defect with only number in URL field
 Then Should be able to create a defect with number in URL field
 When User search a defect in defect tracking and click on edit button
  And update the custom field URL value
 Then Should be able to edit a defect and change the value for custom field of type URL
 When launch test execution page
  And create a defect with minimum required fields and save
 Then Should update the custom field URL for the defect

@Defect_Tracking  
Scenario: 252 <DT/ Test Execution> Edit a defect/Subtask remove the value for custom field of type URL if set as non-mandatory  
Given User is In the ExternalJira page
 When User create the customField of type URL
  And User launch DefectTracking page
  And create a defect with required fields and custom url field
 Then Should be able to create a defect with URL field
 When User search a Defect in defect tracking and click on edit button
  And remove the custom field URL value
 Then Should be able to remove the value of custom field of type URL
 When Launch test execution page
  And create a efect with minimum required fields and save
 Then Should remove the custom field URL for the defect
 
@Defect_Tracking
Scenario: 253 <Test Execution/DT> Create a defect/Subtask with custom field of type checkbox (single)
Given User is In the ExternalJira Page
 When User Create the customField of type checkbox
  And create the list of values number,uppercase,lowercase,specialchar,international char and very long characters to the checkbox
  And User Launch DefectTracking page
  And create a defect with custom field of type checkbox option contains number
 Then Should be able to create a defect with custom field of type checkbox option contains number
 When create a defect with custom field of type checkbox option contains Uppercase
 Then Should be able to create a defect with custom field of type checkbox option contains Uppercase
 When create a defect with custom field of type checkbox option contains lowercase
 Then Should be able to create a defect with custom field of type checkbox option contains lowercase
 When create a defect with custom field of type checkbox option contains alphanumeric character
 Then Should be able to create a defect with custom field of type checkbox option contains alphanumeric character
 When create a defect with custom field of type checkbox option contains special character
 Then Should be able to create a defect with custom field of type checkbox option contains special character
 When create a defect with custom field of type checkbox option contains international character
 Then Should be able to create a defect with custom field of type checkbox option contains international character
 When create a defect with custom field of type checkbox option contains very long character
 Then Should be able to create a defect with custom field of type checkbox option contains very long character
 When Launch Test Execution page to create defect
  And create a defect with custom field of type checkbox option contains number in TestExecution
 Then Should be able to create a defect with custom field of type checkbox option contains number in TestExecution
 When create a defect with custom field of type checkbox option contains Uppercase in TestExecution
 Then Should be able to create a defect with custom field of type checkbox option contains Uppercase in TestExecution
 When create a defect with custom field of type checkbox option contains lowercase in TestExecution
 Then Should be able to create a defect with custom field of type checkbox option contains lowercase in TestExecution
 When create a defect with custom field of type checkbox option contains alphanumeric character in TestExecution
 Then Should be able to create a defect with custom field of type checkbox option contains alphanumeric character in TestExecution
 When create a defect with custom field of type checkbox option contains special character in TestExecution
 Then Should be able to create a defect with custom field of type checkbox option contains special character in TestExecution
 When create a defect with custom field of type checkbox option contains international character in TestExecution
 Then Should be able to create a defect with custom field of type checkbox option contains international character in TestExecution
 When create a defect with custom field of type checkbox option contains very long character in TestExecution
 Then Should be able to create a defect with custom field of type checkbox option contains very long character in TestExecution

@Defect_Tracking 
Scenario: 254 <Test Execution/DT> Create a defect/Subtask with custom field of type checkboxes(multiple)
Given User is the page External Jira
 When User Create the customField of type Checkbox
  And create the List of values number,uppercase,lowercase,specialchar,international char and very long characters to the checkbox
  And User Launch DefectTracking Page
  And Create a defect with custom field of type checkbox option contains number
 Then Should be able to create a defect with custom field of type Checkbox option contains number
 When Create a defect with custom field of type checkbox option contains Uppercase
 Then Should be able to create a defect with custom field of type Checkbox option contains Uppercase
 When Create a defect with custom field of type checkbox option contains lowercase
 Then Should be able to create a defect with custom field of type Checkbox option contains lowercase
 When Create a defect with custom field of type checkbox option contains alphanumeric character
 Then Should be able to create a defect with custom field of type Checkbox option contains alphanumeric character
 When Create a defect with custom field of type checkbox option contains special character
 Then Should be able to create a defect with custom field of type Checkbox option contains special character
 When Create a defect with custom field of type checkbox option contains international character
 Then Should be able to create a defect with custom field of type Checkbox option contains international character
 When Create a defect with custom field of type checkbox option contains very long character
 Then Should be able to create a defect with custom field of type Checkbox option contains very long character
 When Launch Test Execution page to create Defect
  And Create a defect with custom field of type checkbox option contains number in TestExecution
 Then Should be able to create a defect with custom field of type Checkbox option contains number in TestExecution
 When Create a defect with custom field of type checkbox option contains Uppercase in TestExecution
 Then Should be able to create a defect with custom field of type Checkbox option contains Uppercase in TestExecution
 When Create a defect with custom field of type checkbox option contains lowercase in TestExecution
 Then Should be able to create a defect with custom field of type Checkbox option contains lowercase in TestExecution
 When Create a defect with custom field of type checkbox option contains alphanumeric character in TestExecution
 Then Should be able to create a defect with custom field of type Checkbox option contains alphanumeric character in TestExecution
 When Create a defect with custom field of type checkbox option contains special character in TestExecution
 Then Should be able to create a defect with custom field of type Checkbox option contains special character in TestExecution
 When Create a defect with custom field of type checkbox option contains international character in TestExecution
 Then Should be able to create a defect with custom field of type Checkbox option contains international character in TestExecution
 When Create a defect with custom field of type checkbox option contains very long character in TestExecution
 Then Should be able to create a defect with custom field of type Checkbox option contains very long character in TestExecution
 
@Defect_Tracking
Scenario: 255 <Test Execution/DT> Edit a defect/Subtask check one/multiple checkboxes for custom field of type Checkboxes
Given User is in the External_Jira page
 When User navigate to the custom fields page
  And User create a custom field of type Checkbox
  And Add a list of values number,Uppercase,lowercase,alphanumeric,special char,international char and very long character 
  And launch Defect Tracking page
  And create a defect with custom field of type Checkbox
 Then Should be able to create defect with checkbox
 When Search the created defect id and click on edit button
  And enter the multiple checkbox options
 Then Should be able to create defect with edited checkbox values 
 When User launch TestExecution to execute testcase and click on D button
  And Create a defect with required fields and save
 Then Should be able to update checkbox values in a edit defect window

@Defect_Tracking  
Scenario: 256 <Test Execution/DT> Edit a defect/Subtask disable checkbox/checkboxes (ALL) for custom field of type Checkboxes, if set as non-mandatory
Given User is In the External_Jira page
 When User navigate to the Custom fields page
  And User Create a custom field of type Checkbox
  And Add a list of values number,Uppercase,lowercase,alphanumeric char,special char,international char and very long character 
  And Launch Defect Tracking Page
  And Create a defect with custom field of type Checkbox
 Then Should be able to create defect with checkbox value
 When Search the created defect Id and click on edit button
  And unselect selected checkbox value
 Then Should be able to Unselect checkbox value in edit defect window
 When User Launch TestExecution to execute testcase and click on D button
  And create a defect with custom checkbox value and save
 Then Should be able to unselect checkbox value in a edit defect window 
 
@Defect_Tracking 
Scenario: 257 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox/Multiple select/Label in Jira, add new checkbox and Attempt to view the change reflected in Zephyr before cache timeout 
Given User is in External Jira page
 When User navigate to the Custom Fields page
  And edit the custom field of type text
  And create a custom field of type checkbox
  And Launch Defect Tracking page
  And create a defect with minimum required fields
  And search the created defect id and edit the defect
 Then Should not be able to view the changes reflected in zephyr
 When User launch Test Execution and execute the testcase
  And click on D button and create a defect
 Then Should not able to view the changes reflected in zephyr 

@Defect_Tracking
Scenario: 143 <DT> Create the defect/subtask with edited custom field multi version picker
Given User is in Project_page Selection
 When User navigate to the External_Jira page
  And User Navigate to the Version Fields Page
 Then Should be able to edit the custom field multi version picker value
 When As a manager,launch the defect admin page
 Then Should be able to Launch defect admin Page
 When clear the cache of an Online project  
 Then should be able to clear the Cache
 When As a Lead,Launch the Defect_Tracking page
 Then Should Be able to launch defectTracking page
 When create a defect with edited custom field multi version picker value
 Then Should be able to create defect with edited custom field multi version picker value 

@Defect_Tracking
Scenario: 132 <DT> Create a defect/subtask in edited project
Given User is in the Project page
 When User navigate to the external jira page
  And navigate to the project page and edit the project Name
 Then Should be able to edit the existing projectName
 When As a Manager,Launch defect admin page
 Then Should be able to launch defect admin
 When clear the cache of an online project
 Then Should be able to clear the Cache
 When launch the defect tracking page
 Then Should be able to Launch Defect tracking page
 When create a defect with edited projectName
 Then Should be able to create a defect with edited projectName 

@Defect_Tracking
Scenario: 258 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox/Multiple select/Label in Jira, add new checkbox and Attempt to view the change reflected in Zephyr after cache timeout 
Given User is in a External Jira page
 When User navigate to the CustomFields page
  And edit the Custom field of type text
  And add a custom field of type checkbox
  And Launch the Defect Tracking page
  And Create a defect with minimum required fields
  And As a Manager,clear the cache
  And As a Lead,search the created defect id and edit the defect
 Then Should be able to view the changes reflected in zephyr
 When User Launch Test Execution and execute the testcase
  And Click on D button and create a defect
 Then Should able to view the changes reflected in Zephyr 

@Defect_Tracking
Scenario: 259 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox/Multiple select/Label in Jira, add new checkbox and view the change reflected in Zephyr after manually clearing cache 
Given User is in a ExternalJira page
 When User navigate to the customFields page
  And edit the customField of type text
  And Add a custom field of type checkbox
  And Launch the Defect Tracking Page
  And Create a Defect with minimum required fields
  And As a Manager,Clear the cache
  And As a Lead,Search the created defect id and edit the defect
 Then Should be able to View the changes reflected in zephyr
 When User Launch Test Execution and Execute the testcase
  And Click on the D button and create a defect
 Then Should able to View the changes reflected in Zephyr  

@Defect_Tracking
Scenario: 260 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox/Multiple select/Label in Jira,add new checkbox and view the change reflected in Zephyr after manually clearing cache 
Given User is in a ExternalJira Page
 When User Navigate to the customFields page
  And Edit the Custom field of type text
  And Launch the DefectTracking Page
  And Create a defect with Minimum required fields
  And Search the created defect id and edit the defect
 Then Should not be able to View the changes reflected in Zephyr
 When User Launch TestExecution and execute the testcase
  And Click On D button and create a defect
 Then Should not able to view the Changes reflected in Zephyr

@Defect_Tracking
Scenario: 261 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox/Multiple select/Label in Jira,add new checkbox and view the change reflected in Zephyr after automatically clearing cache 
Given User is in the ExternalJira Page
 When User Navigate to a customFields page
  And Edit the Custom Field of type text
  And As a manager,clear the cache and logout
  And As a Lead,Launch the DefectTracking Page
  And Create a Defect with minimum required Fields
  And Search the Created defect id and edit the defect
 Then Should be able to View the changes reflected in Zephyr
 When User Launch TestExecution and Execute the testcase
  And Click On D button and Create a defect
 Then Should able to view the Changes reflected in Zephyr 

@Defect_Tracking
Scenario: 262 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox/Multiple select/Label in Jira,edit custom fields and Attempt to view the change reflected in Zephyr before cache timeout
Given User is In a ExternalJira Page
 When User navigate to the customFields Page
  And Edit the CustomField of type text
  And Launch the Defect_Tracking page
  And create a Defect with minimum required fields
  And As a Manager,clear the Cache
  And As a Lead,search the Created defect id and edit the defect
 Then Should be able to view the Changes reflected in zephyr
 When User Launch the TestExecution and Execute the testcase
  And Click on D button and Create a defect
 Then should able to view the changes reflected in Zephyr
 
@Defect_Tracking  
Scenario: 263 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox /Multiple select /Label in Jira, Delete custom fields and Attempt to view the change reflected in Zephyr before cache timeout
Given User is In a External Jira Page
 When User Navigate to the customFields Page
  And delete the Custom Field of type Checkbox
  And Launch the defectTracking page
  And Create a Defect with minimum Required fields
  And As a Lead,search the Created defect Id and edit the defect
 Then Should not be able to view the Changes Reflected in zephyr
 When User Launch the TestExecution and Execute the Testcase
  And Click on D button and Create a Defect
 Then should not be able to view the changes Reflected in zephyr
 
@Defect_Tracking
Scenario: 264 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox /Multiple select /Label in Jira, Delete custom fields and Attempt to view the change reflected in Zephyr before cache timeout
Given User Is In a External Jira Page
 When User Navigate to the CustomFields Page
  And delete the CustomField of type Checkbox
  And Launch the defect_Tracking page
  And Create a defect with minimum Required fields
  And As an Manager,Clear the Cache
  And As a Lead,search the Created defect ID and edit the defect
 Then Should able to view the Changes Reflected in Zephyr
 When User Launch the TestExecution and Execute the TestCase
  And Click on D Button and Create a Defect
 Then should be able to view the changes Reflected in Zephyr

@Defect_Tracking
Scenario: 265 <Test Execution/DT> Edit field setup for custom field of type Text/Free-text/Select-list/URL/Checkbox/Multiple checkbox/Multiple select/Label in Jira, Delete custom fields and Attempt to view the change reflected in Zephyr before cache timeout
Given User is in the page External Jira
 When User navigate to the custom field page
  And delete the custom field of type checkbox
  And launch defect tracking page
  And create a defect With minimum required fields  
  And as a manager,clear the cache
  And as a lead,search the created defect ID and edit the defect
 Then Should be able to view the changes reflected in Zephyr
 When User launch the test execution and execute the testcase
  And click on D button and create the defect
 Then should be able to view the changes reflected in zephyr
   


@Defect_Tracking 
Scenario: 130 <DT> Search defects by JQL and update multiple defects 
 Given User is in a Defect_Tracking page
  When User search the defects by JQL
   And select the multiple defects and click on change multiple
  Then Should be able to change values of Component
  When select change multiple to change Version value
  Then Should be able to change values of Version
  When select change multiple to change Status
  Then Should be able to change values of Status
  When select change multiple to change the FixVersion
  Then Should be able to change values of the FixVersion
  When select change multiple to change the Priority
  Then Should be able to change values of the Priority
  When select change multiple to change Assignee value
  Then Should be able to change values of the Assignee
   
 #
@Defect_Tracking  
Scenario: 84 <DT> Create defect/sub_task and check the JIRA activity stream
Given user is in the project page 
 When user is in the DefectTracking page
  And user create a defect with minimum required fields
 Then Should be able to create the defect
 When user navigate to the external jira page
 Then Should be able to view activity stream
 When create a subtask in defect tracking page
  And navigate to the external jira page
 Then Should be able to view the activity stream 
 
 @Defect_Tracking
Scenario: 85 <Test execution> Link defect to execution and check JIRA activity stream
Given User in TestExecution page
 When User click on D button to create a defect
  And Create a defect With minimum required fields
 Then Should be able to create a defect in test execution
 When User navigate to the ExternalJira page
 Then Should be able to view activity stream in JIRA
 When User navigate to the execution page to create a subtask in test execution
  And search the created defect and create a subtask
  And navigate to the external_jira page
 Then Should be able to view a activity stream  in JIRA
 
@Defect_Tracking
Scenario: 131 <DT> Search defects by filter and update multiple defects 
 Given User is in a Defect_Tracking Page
  When User search the defects by filter
   And select the multiple defects and click on change multiple button
  Then Should be able to Change values of Component
  When select change multiple to Change Version value
  Then Should be able to Change values of Version
  When select Change multiple to change Status
  Then Should be able to Change values of Status
  When select Change multiple to change the FixVersion
  Then Should be able to Change values of the FixVersion
  When select Change multiple to change the Priority
  Then Should be able to Change values of the Priority
  When select Change multiple to change Assignee value
  Then Should be able to Change values of the Assignee 

@Defect_Tracking
Scenario: 123 <project setup> Map ZE project JIRA project
Given Manager is in the Project Page
 When manager create a different types of project by different specification
  And map the projectName containing uppercase to Jira project
 Then Should get activity stream for map projectName containing uppercase to Jira project
 When map the projectName containing specialChars to Jira project
 Then Should get activity stream for map projectName containing specialChars to Jira project
 When map the projectName containing numbers to Jira project  
 Then Should get activity stream for map projectName containing numbers to Jira project
 When map the projectName containing alpha numberic to Jira project  
 Then Should get activity stream for map projectName containing alpha numberic to Jira project
 When map the projectName containing international chars to Jira project  
 Then Should get activity stream for map projectName containing international chars to Jira project

@Defect_Tracking
Scenario: 124<project setup> Map ZE Release JIRA project
Given Manager is in a project page
 When create a different types of releases for the projects
  And map the releaseName containing uppercase to Jira project
 Then Should get activity stream for map releaseName containing uppercase to Jira project
 When map the releaseName containing lowercase to Jira project
 Then Should get activity stream for map releaseName containing lowercase to Jira project
 When map the releaseName containing numbers to Jira project  
 Then Should get activity stream for map releaseName containing numbers to Jira project
 When map the releaseName containing alpha numberic to Jira project  
 Then Should get activity stream for map releaseName containing alpha numberic to Jira project
 When map the releaseName containing international chars to Jira project  
 Then Should get activity stream for map releaseName containing international chars to Jira project  

@Defect_Tracking
Scenario: 193 Delete the defect/subtask linked to a testcase in Test Execution and link it again
Given User is in Project Page 
 When User launch the Test Execution page 
 Then Should launch Test Execution page
 When User execute the testcase
  And User click on D button to launch link defect window
 Then Should be able to launch the Link Defect window 
 When search a defect by ID
 Then Should be able to search defect
 When link the searched defect to the testcase
 Then Should be able to link defect to Execution
 When select the linked defect in currently linked defect window and delete it
 Then Should be able to delete the defect on execution
 When User search the same defect ID to link to the testcase
 Then Should be able to link defect to the execution
 

 @Defect_Tracking
Scenario: 192 Send activity to JIRA when a new release is created in a Zephyr Project which is mapped to JIRA project
Given manager is in the project page
 When User creates a new release with special character
  And map special character release created in sample project to JIRA project
  And User launch external jira page to view activity stream
 Then Should be able to view JIRA activity stream for special character release
 When select the sample project to create a new release with alphanumeric characters
  And map alphanumeric character release created in sample project to JIRA project
 Then Should be able to view JIRA Activity stream for the alphanumeric character release
 When select the sample project to create a new release with only number characters
  And map number character release created in sample project to JIRA project
 Then Should be able to view JIRA Activity stream for the number character release
 When select the sample project to create a new release with capital characters
  And map capital character release created in sample project to JIRA project
 Then Should be able to view JIRA Activity stream for the capital character release
 When select the sample project to create a new release with international characters
  And map international character release created in sample project to JIRA project
 Then Should be able to view JIRA Activity stream for the international character release
 When select the sample project to create a new release with minimum characters
  And map minimum character release created in sample project to JIRA project
 Then Should be able to view JIRA Activity stream for the minimum character release
 When select the sample project to create a new release with maximum characters
  And map maximum character release created in sample project to JIRA project
 Then Should be able to view JIRA Activity stream for the maximum character release
 When select the sample project to create a new release with duplicate name
  And map duplicate name release created in sample project to JIRA project
 Then Should be able to view JIRA Activity stream for the duplicate name release 

#@Defect_Tracking
#Scenario: 70 <DT>ReLogin to Zephyr when Password/Username is Edited in Jira
#Given As a manager,launch project page
 #When user in the administration page
  #And set the DTS to JIRA
 #Then Should be able to Set the DTS
 #When User is in the Defect tracking page
 #Then Should be able to launch defect tracking page
 #When login as defect user and reset DTS
 #Then Should be able to login successfully 
 #When User is in a external jira page
 #When User navigate to the user management page
  #And edit the change the user name
 #Then Should be able to change the user name
 #When relogin to Zephyr page
 #Then Should be able to re-login successfully
 #When launch defect Tracking page
 #Then should get message "Authentication failed for defect user admin. Please refresh the page and try again.If your defect user credentials changed,use Reset User button to enter the new credentials.
 #When launch test execution page to execute testcase
  #And click on D button of a testcase
 #Then Should get message "authentication failed for defect user admin.Please refresh the page and try again. If your defect user credentials changed,use Reset User button to enter the new credentials.
#
#@Defect_Tracking
#Scenario: 73 Attempt to create defect, If user doesn't have create defect permission
#Given As a manager,Launch administration
 #When launch defect tracking system
  #And Set the DTS to JIRA
 #Then Should be able to set DTS to JIRA
 #When As a Lead,Launch defect tracking page
 #Then Should be able to launch Defect Tracking page
 #When set the defect user who doesn't have create defect permimssion
  #And attempt to create defect in defect tracking app
 #Then Should get proper message 'user doesn't have permission to create defect'
 #When create a subtask in defect tracking app
 #Then should get the proper Message 'user doesn't have permission to create defect'
 #When launch the Test Execution page
  #And attempt to create defect in test execution app
 #Then should get the proper message 'user doesn't have permission to create defect'
 #When create a subtask in test execution app
 #Then should get proper Message 'user doesn't have permission to create defect'
#
#@Defect_Tracking
#Scenario: 75 Create defect, If user doesn't have have browse project permission
#Given As a manager,Launch the administration
 #When Launch the Defect tracking to set DTS
  #And Set DTS to the JIRA
 #Then Should be able to Set DTS to JIRA
 #When launch the External jira page
  #And Change permission to project permission
  #And As a Lead,Launch the Defect tracking page
 #Then Should be able to Launch Defect Tracking page
 #When Set the defect user who doesn't have create defect permission
  #And Attempt to create defect in defect tracking app
 #Then Should get a proper message 'user doesn't have permission to create defect'
 #When Create a subtask in defect tracking app
 #Then Should get a proper Message 'user doesn't have permission to create defect'
 #When Launch the Test Execution page
  #And attempt to Create defect in test execution app
 #Then Should get the proper message 'user doesn't have permission to create defect'
 #When create a Subtask in test execution app
 #Then should get a proper message that'user doesn't have permission to create defect'
 #
 #
 #@Defect_Tracking
#Scenario: 79 <DT> Create defect/sub-task, If user have no assign issue permission
#Given User Is in the External Jira page
 #When navigate to the projects page
  #And Change permission to No Assign Issue
  #And As a Manager,Launch the Administration page
  #And launch the Defect Tracking to set the DTS
  #And Set a DTS To the JIRA
 #Then Should Be able to Set a DTS to JIRA
 #When As a Lead,Launch The Defect Tracking Page
 #Then Should Be Able to Launch Defect Tracking page
 #When Set the Defect user who doesn't have assign issue permission
  #And Create a defect in defect tracking app
 #Then Should be able to create a Defect
 #When Create a Subtask in defect Tracking app
 #Then Should be able to Create a defect subtask in DT
 #When Launch the TestExecution Page
  #And Create defect in Test execution app
 #Then Should be Able to create a defect in Execution page
 #When Create a Subtask in Test execution app
 #Then should be able to create a defect subtask test in execution page 
#
#@Defect_Tracking
#Scenario: 80 <DT>Attempt to add comments to defects/subtasks When User have No Assign Issue Permission
#Given User Is in the External Jira Page
 #When navigate to the Projects page
  #And change permission to No Assign Issue
  #And As a Manager,Launch the Administration Page
  #And launch the DefectTracking to set the DTS
  #And set a DTS To the JIRA
 #Then Should be able to Set a DTS to JIRA
 #When As a Lead,Launch The DefectTracking Page
 #Then Should Be able to Launch Defect Tracking page
 #When set the Defect user who doesn't have assign issue permission
  #And search a defect in defect tracking app
  #And attempt to add comment in search defect view
 #Then Should get message 'you do not have the permission to comment on this issue' for defect
 #When search a Subtask in defect Tracking app
  #And attempt to add comment in search defect view for subtask
 #Then Should get message 'you do not have the permission to comment on this issue' for the subtask
 #
 #
#@Defect_Tracking
#Scenario: 77 <DT>Attempt to edit defects/subtasks When User have No Edit Issue Permission
#Given User in External jira page
 #When Change administrator permission to defect permission
  #And As a manager,Launch the Administration page
 #When Launch the Defect Tracking to set DTS
  #And Set an DTS to the JIRA
 #Then Should be able to Set an DTS to JIRA
  #And As a Lead,Launch the Defect Tracking page
 #Then Should be able to launch the Defect Tracking Page
 #When Set the defect user who Don't have permission to editing defect
  #And Attempt to edit defect in defect tracking app
 #Then Should get a proper message 'Don't have permission to editing defect'
 #When attempt to edit a subtask in defect tracking app
 #Then Should get a proper Message 'user Don't have permission to editing defect'
 #When Launch the Test Execution Page
  #And attempt to edit defect in test execution app
 #Then Should get the proper message 'user Don't have permission to editing defect'
 #When attempt to edit a Subtask in test execution app
 #Then should get a proper message that'user Don't have permission to editing defect' 
 #
#@Defect_Trackin1
#Scenario: 78 <DT> Attempt to assign issues,If user have no assign issue permission
 #Given User Is in the External_Jira page
 #When Navigate to the Projects page
  #And change permission to the No Assign Issue
  #And As a Manager,launch the Administration Page
  #And launch the Defect Tracking to Set the DTS
  #And Set the DTS To the JIRA
 #Then Should Be able to Set an DTS to JIRA
 #When As a Lead,Launch the Defect_Tracking Page
 #Then Should Be Able to Launch Defect_Tracking page
 #When Set the defect user who doesn't have assign issue permission
  #And attempt to assign issues for defect with assignee in defect tracking app
 #Then Should not be able to search users in assignee field
 #When attempt to assign issues for subtask with assignee in defect Tracking app
 #Then should not be able to search users in assignee field in DT app
 #When attempt to assign issues in search defect view
 #Then Should not able to search users in assignee field using search defect view
 #When attempt to assign issues in change multiple window
 #Then Should not able to search users in assignee field using change multiple window
 #When Launch the Test_Execution Page
  #And attempt to create defect with assignee in Test execution app
 #Then should not be able to search users in Assignee field
 #When attempt to create a subtask with assignee in Test execution app
 #Then should not be able to search users in Assignee Field 
 #
#@Defect_Tracking
#Scenario: 81 <DT>Attempt to add attachment in defect/subtask When User have No create attachment  Permission
#Given User Is in the External_Jira Page
 #When User navigate to the projects page
  #And change the permission to No Attachment permission
  #And As a manager,launch the Administration page
  #And launch Defect Tracking to set the DTS
  #And Set DTS To the JIRA
 #Then Should be able to set a DTS to JIRA
 #When As the Lead,Launch the Defect Tracking Page
 #Then Should be able to launch defect Tracking page
 #When Set the Defect user who doesn't have no attachment permission
  #And aatempt to add attachment to the defect in defect tracking
 #Then Should get message 'Don't have permission to add attachment' to the defect
 #When attempt to add attachment to a subtask in defect Tracking app
 #Then Should get message 'Don't have permission to add attachment' to the subtask
 #When launch the TestExecution Page
  #And attempt to add attachment to the defect in test execution
 #Then Should get message 'Don't have permission to add attachment' to the defect in test execution
 #When attempt to add attachment to the subtask in test execution
 #Then Should get message 'Don't have permission to add attachment' to the subtask in test execution 
#
#@Defect_Tracking
#Scenario: 71 <DT> Do JIRA operation after JIRA session time out
#Given User is in the Project Page 
 #When User launch defect tracking to create defect
  #And create a defect in defect tracking app
 #Then Should be able to Create the defect
 #When create subtask in defect tracking app
 #Then Should be able to create subtask in defect tracking app
 #When search a defect by ID in defect tracking app
 #Then Should be able to search defect in DT
 #When search a defect by JQL in defect tracking app
 #Then Should be able to search a defect in DT app
 #When search a defect by filter in defect tracking app
 #Then Should be able to search defect using filter
 #When launch Test Execution page
  #And create a defect in test execution page
 #Then Should be able to Create the defect in Test Execution
 #When create subtask in test execution page
 #Then Should be able to create subtask in test execution page
 #When search a defect by ID in test execution page
 #Then Should be able to search defect in test execution page
 #When search a defect by JQL in test execution page
 #Then Should be able to search a defect in test execution page
 #When search a defect by filter in test execution page
 #Then Should be able to search defect using filter in Test Execution page
 
 
 
 
 
 
@Defect_Tracking
Scenario: 266 Create a defect with custom field of type MultiSelect
Given User isin defectTracking Page
When User create defect with customfield of type multiselect if option value is in number
Then Should be able to create defect if option value is in number
When User create defect if option value is in uppercase
Then Should be able to create defect if option value is in uppercase
When User create defect if option value is in lowercase
Then Should be able to create defect if option value is in lowercase  
When User create defect if option value is in alphanumeric characters
Then Should be able to create defect if option value is in alphanumeric characters
When User create defect if option value is in special character
Then Should be able to create defect if option value is in special character
When User create defect if option value is in international characters
Then Should be able to create defect if option value is in international characters
When User create defect if option value is very long
Then Should be able to create defect if option value is very long
When User Launch the Testexecution
Then Should be able to Launch the Testexecution
When User create defect with customfield of type multiselect if option value is in Number
Then Should be able to create defect if option value is in Number
When User create defect if option value is in Uppercase
Then Should be able to create defect if option value is in Uppercase
When User create defect if option value is in Lowercase
Then Should be able to create defect if option value is in Lowercase  
When User create defect if option value is in Alphanumeric characters
Then Should be able to create defect if option value is in Alphanumeric characters
When User create defect if option value is in Special character
Then Should be able to create defect if option value is in Special character
When User create defect if option value is in International characters
Then Should be able to create defect if option value is in International characters
When User create defect if option value is Very long
Then Should be able to create defect if option value is Very long

@Defect_Tracking
Scenario: 267 Edit a defect MultiSelect for custom field of type MultiSelect if set as nonmandatory
Given User is in defectTraccking Page
When User create defect with customfield of type multiselect if option value in number
Then Should be able to create defect if option value in number 
When User search the created defect and remove the multiselect customfield value and save it
Then Should be able to save the defect after modification in Defecttracking
When User create defect with customfield of type multiselect in Testexecution
Then Should be able to create defect with customfield of type multiselect in Testexecution
When User remove the option value save the defect 
Then Should be able to remove the option value in testexecution



@Defect_Tracking
Scenario: 268 Create a defect with custom field of type RadioButton
Given User in Defecttracking Page
When User create a defect with custom field of type RadioButton if option values in numbers
Then Should be able to create defect if option values in numbers
When User create defect if option values in uppercase
Then Should be able to create defect if option values in uppercase
When User create defect if option values in  lowercase
Then Should be able to create defect if option values in lowercase
When User create defect if option values contains alphanumeric characters and spaces
Then Should be able to create defect if option values contains alphanumeric characters and spaces
When User create defect if option values in special character
Then Should be able to create defect if option values in special character
When User create defect if option values contains international characters  
Then Should be able to create defect if option values contains international characters
When User create defect if option values is very long
Then Should be able to create defect if option values is very long
When User launch the Testexecution
Then Should be able to launch the Testexecution
When User create a defect with custom field of type radiobutton if option values in numbers
Then Should be able to create defect if option values is in numbers
When User create defect if option values is in uppercase
Then Should be able to create defect if option values is in uppercase
When User create defect if option values is in lowercase
Then Should be able to create defect if option values is in lowercase
When User create defect if option values contains alphanumeric characters
Then Should be able to create defect if option values contains alphanumeric characters
When User create defect if option values is in special character
Then Should be able to create defect if option values is in special character
When User create defect if option values is in international characters  
Then Should be able to create defect if option values is in international characters
When User create defect if option values is Very long
Then Should be able to create defect if option values is Very long


@Defect_Tracking
Scenario: 269 Edit a defect and change the value of custom field of type Radio Button
Given User is in DefectTrcking page
When User create a defect with custom field of type radio button
Then Should be able to create defect with custom field of type radio button
When User search the created defect and click on edit and change the value and save it
Then Should be able to save the defect after modification
When User create a defect with custom field of radio button in testexecution
Then Should be able to create defect in testexecution
When User search the created defect and select click on edit and change the value and save it
Then Should be able to save the defect after Modification  

@Defect_Tracking
Scenario: 270 Edit a defect remove the value for customfield of type RadioButton if set as nonmandatory
Given User is In defecttracking Page
When User create a defect with only numbers in customfield of type radiobutton
Then Should be able to create defect with only number in customfield of type radiobutton
When User search the created defect and remove the radio button custom field value and save it
Then Should be able to save the defect after modification in defecttracking
When User create the defect with only numbers in customfield of type radiobutton in Testexecution 
Then Should be able to create defect in Testexecution
When User remove the radio button custom field value and Save it
Then Should be able to save the defect after modification in Textexecution

@Defect_Tracking
Scenario: 271 Create a defect with customfield of type Readonly text field
Given User is In DefectTracking Page
When User create defect with readonly type of customfield in defecttracking 
Then Should be able to create defect with readonly type of customfield in defecttracking
When User create defect with readonly type of customfield in testexecution
Then Should be able to create defect with readonly type of customfield in testexecution 
  
  @Defect_Tracking
Scenario: 272 Create  a defect with custom field of type User Picker
Given User is in Defecttracking Page
When User create defect with userpicker type of customfield in defecttracking
Then Should be able to create defect with userpicker type of customfield in defecttracking
When User create defect with userpicker type of customfield in testexecution
Then Should be able to create defect with userpicker type of customfield in testexecution   

@Defect_Tracking
Scenario: 273 Create a defect with custom field of type MultiUser Picker
Given User is in defecttracking Page
When User create defect with multiuser picker type customfield in defecttracking
Then Should be able to create defect with multiuser picker type of customfield in defecttracking
When User create defect with multiuser picker type of customfield in testexecution
Then Should be able to create defect with multiuser type of customfield in testexecution

@Defect_Tracking
Scenario: 274 Create a defect with custom field of type Single Version Picker
Given User is in defectTracking Page
When User create defect with SingleVersion Picker type of customfield in defecttracking
Then Should be able to create defect with SingleVersion Picker type of customfield in defecttracking
When User create defect with SingleVersion Picker type of customfield in testexecution
Then Should be able to create defect with SingleVersion Picker type of customfield in testexecution  

@Defect_Tracking
Scenario: 276 Create a defect with custom field of any type if default screen is not configured in Jira
Given User Is In external jira page 
When User create any type of customfield and associate to the resolve screen
Then Should be able to associate to the resolve screen
When User create the defect and view the created customfield in defecttracking
Then Should be able to create the defect and view the created customfield in defecttracking
When User create the defect and view the created customfield in testexecution
Then Should be able to create the defect and view the created customfield in testexecution


@Defect_Tracking
Scenario: 275 Create a defect with custom field of type MultiVersion Picker
Given User Is in Defecttracking Page
When User create defect with MultiVersion Picker type of customfield in defecttracking
Then Should be able to create defect with MultiVersion Picker type of customfield in defecttrackinng
When User create defect with MultiVersion Picker type of customfield in testexecution
Then Should be able to create defect with MultiVersion Picker type of customfield in testexecution

@Defect_Tracking
Scenario: 279 Create a defect with >1 custom fields
Given user Is in defectTracking Page
When user create defect with multiple type of customfields
Then should be able to create Defect with multiple type of customfields
When user create defect with multiple type of customfields in testexecution
Then should be able to create Defect with multiple type of customfields in testexecution 


@Defect_Tracking
 Scenario: 280 Create defect with Issue Type New Feature
 Given User is In DefectTracking page
 When User create defect with issue type new feature
 Then Should be able to create defect with issue type new feature
 When User create defect with issue type new feature in testexecution
 Then Should be able to create defect with issue type new feature in testexecution
 
  @Defect_Tracking
  Scenario: 281 Create defect with Issue Type Task
 Given user Is In DefectTracking Page
 When user create defect with issue type Task
 Then should be able to create defect with issue type Task
 When user create defect with issue type Task in testexecution
 Then should be able to create defect with issue type Task in testexecution
 
 @Defect_Tracking
 Scenario: 282 Create a defect with Issue Type Improvement
 Given user Is in DefectTracking Page
 When user create defect with issue type Improvement
 Then should be able to create defect with issue type Improvement
 When user create defect with issue type Improvement in testexecution
 Then should be abble to create defect with issue type Improvement in testexecution
 
 @Defect_Tracking
 Scenario: 283 Create a defect with custom field of any type if custom field flag online is set to true in Jira Latest version
 Given User In Administration Page
 When User click on defect admin and set the preferences
  And User create defect with customfield of type Textfield in Defecttracking
 Then Should be able to create defect with customfield of type Textfield in Defecttracking
 When User create defect with customfield of type Textfield in Testexecution
 Then Should be able to create defect with customfield of type Textfield in Testexecution
 When User create defect with customfield of type Freetext in Defecttracking
 Then Should be able to create defect with customfield of type Freetext in Defecttracking
 When User create defect with customfield of type Freetext in Testexecution
 Then Should be able to create defect with customfield of type Freetext in Testexecution
 When User create defect with customfield of type Select List in Defecttracking
 Then Should be able to create defect with customfield of type Select List in Defecttracking
 When User create defect with customfield of type Select List in Testexecution
 Then Should be able to create defect with customfield of type Select List in Testexecution
 When User create defect with customfield of type Date Picker in Defecttracking
 Then Should be able to create defect with customfield of type Date Picker in Defecttracking
 When User create defect with customfield of type Date Picker in Testexecution
 Then Should be able to create defect with customfield of type Date Picker in Testexecution
 When User create defect with customfield of type Number in Defecttracking
 Then Should be able to create defect with customfield of type Number in Defecttracking
 When User create defect with customfield of type Number in Testexecution
 Then Should be able to create defect with customfield of type Number in Testexecution
 When User create defect with customfield of type URL in Defecttracking
 Then Should be able to create defect with customfield of type URL in Defecttracking
 When User create defect with customfield of type URL in Testexecution
 Then Should be able to create defect with customfield of type URL in Testexecution
 When User create defect with customfield of type Checkbox in Defecttracking
 Then Should be able to create defect with customfield of type Checkbox in Defecttracking
 When User create defect with customfield of type Checkbox in Testexecution
 Then Should be able to create defect with customfield of type Checkbox in Testexecution
 When User create defect with customfield of type Multi Checkboxes in Defecttracking
 Then Should be able to create defect with customfield of type Multi Checkboxes in Defecttracking
 When User create defect with customfield of type Multi Checkboxes in Testexecution
 Then Should be able to create defect with customfield of type Multi Checkboxes in Testexecution
 When User create defect with customfield of type MultiSelect in Defecttracking
 Then Should be able to create defect with customfield of type MultiSelect in Defecttracking
 When User create defect with customfield of type MultiSelect in Testexecution
 Then Should be able to create defect with customfield of type MultiSelect in Testexecution
 When User create defect with customfield of type RadioButton in Defecttracking
 Then Should be able to create defect with customfield of type RadioButton in Defecttracking
 When User create defect with customfield of type RadioButton in Testexecution
 Then Should be able to create defect with customfield of type RadioButton in Testexecution 
 When User create defect with customfield of type User Picker in Defecttracking
 Then Should be able to create defect with customfield of type User Picker in Defecttracking
 When User create defect with customfield of type User Picker in Testexecution
 Then Should be able to create defect with customfield of type User Picker in Testexecution
 When User create defect with customfield of type Multi User Picker in Defecttracking
 Then Should be able to create defect with customfield of type Multi User Picker in Defecttracking
 When User create defect with customfield of type Multi User Picker in Testexecution
 Then Should be able to create defect with customfield of type Multi User Picker in Testexecution
 When User create defect with customfield of type Single Version Picker in Defecttracking
 Then Should be able to create defect with customfield of type Single Version Picker in Defecttracking
 When User create defect with customfield of type Single Version Picker in Testexecution
 Then Should be able to create defect with customfield of type Single Version Picker in Testexecution
 


 @Defect_Tracking
 Scenario: 287 Create  a defect with custom field of type Date Picker
 Given user is in defectTracking Page
 When User create a defect with customfield of type Date Picker as date in the past in DT
 Then Should be able to create a defect with date in the past in defecttracking
 When User create a defect with customfield of type date picker as date in the past in testexecution
 Then Should be able to create a defect with date in the past in testexecution
  When User create a defect with customfield of type Date Picker as date in the future in DT
 Then Should be able to create a defect with date in the future in defecttracking
 When User create a defect with customfield of type date picker as date in the future in testexecution
 Then Should be able to create a defect with date in the future in testexecution
 
 @Defect_Tracking
 Scenario: 288 Search for a defect with custom field value any type by attribute
 Given user is In defectTracking page
 When User create defect with any types of customfield values
 Then Should be able to create defect with any types of customfield values
 When User create defect with any types of customfield values in testexecution
 Then Should be able to create defect with any types of customfield values in testexecution
 When User search for a defect with customfield value any type using attributes in defecttracking
 Then Should be able to search the defect in defecttracking with customfield value any type using attributes
 When User search for a defect with customfield value any type using attributes in testexecution
 Then Should be able to search the defect in testexecution with customfield value any type using attributes  
  
 

@Defect_Tracking
Scenario: 278<Test Execution/DT> Edit custom field configuration in Jira from non-mandatory to mandatory and attempt to create a defect/subtask in Zephyr without value for the mandatory custom field
Given defect user is in the external jira Page
 When navigate to the issues page
  And change custom fields from non mandatory to mandatoty 
  And As the Manager,Launch the administration page
  And launch the defect admin to clear the cache
  And As the Lead,Launch the defect tracking page
  And attempt to create a defect without text field
 Then should not be able to create defect for without text field
 When attempt to create a defect without free text field
 Then should not be able to create defect for without free text field
 When attempt to create a defect without single select field
 Then should not be able to create defect for without single select field
 When attempt to create a defect without date picker field
 Then should not be able to create defect for without date picker field
 When attempt to create a defect without number field
 Then should not be able to create defect for without number field
 When attempt to create a defect without url field
 Then should not be able to create defect for without url field
 When attempt to create a defect without checkbox field
 Then should not be able to create defect for without checkbox field
 When attempt to create a defect without multi select field
 Then should not be able to create defect for without multi select field
 When attempt to create a defect without radio button field
 Then should not be able to create defect for without radio button field
 When attempt to create a defect without user picker field
 Then should not be able to create defect for without user picker field
 When attempt to create a defect without multi user picker field
 Then should not be able to create defect for without multi user picker field
 When attempt to create a defect without single version picker field
 Then should not be able to create defect for without single version picker field
 When launch the test execution page to execute the testcase
  And attempt to create a defect without text field in execution page
 Then should not be able to create defect for without text field in execution page
 When attempt to create a defect without free text field in execution page
 Then should not be able to create defect for without free text field in execution page
 When attempt to create a defect without single select field in execution page
 Then should not be able to create defect for without single select field in execution page
 When attempt to create a defect without date picker field in execution page
 Then should not be able to create defect for without date picker field in execution page
 When attempt to create a defect without number field in execution page
 Then should not be able to create defect for without number field in execution page
 When attempt to create a defect without url field in execution page
 Then should not be able to create defect for without url field in execution page
 When attempt to create a defect without checkbox field in execution page
 Then should not be able to create defect for without checkbox field in execution page
 When attempt to create a defect without multi select field in execution page
 Then should not be able to create defect for without multi select field in execution page
 When attempt to create a defect without radio button field in execution page
 Then should not be able to create defect for without radio button field in execution page
 When attempt to create a defect without user picker field in execution page
 Then should not be able to create defect for without user picker field in execution page
 When attempt to create a defect without multi user picker field in execution page
 Then should not be able to create defect for without multi user picker field in execution page
 When attempt to create a defect without single version picker field in execution page
 Then should not be able to create defect for without single version picker field in execution page

@Defect_Tracking
Scenario: 277<Test Execution/DT> Edit custom field configuration in Jira from mandatory to non-mandatory and create a defect/subtask in Zephyr withou optional custom field
Given defect user is in the external Jira Page
 When navigate to the Issues page
  And change custom fields from mandatory to non mandatoty 
  And As the Manager,Launch the Administration page
  And launch the defect admin to clear the Cache
  And As the Lead,launch the defect tracking page
  And create a defect with text field
 Then should be able to create defect with text field
 When create a defect with free text field
 Then should be able to create defect with free text field
 When create a defect with single select field
 Then should be able to create defect with single select field
 When create a defect with date picker field
 Then should be able to create defect with date picker field
 When create a defect with number field
 Then should be able to create defect with number field
 When create a defect with url field
 Then should be able to create defect with url field
 When create a defect with checkbox field
 Then should be able to create defect with checkbox field
 When create a defect with multi select field
 Then should be able to create defect with multi select field
 When create a defect with radio button field
 Then should be able to create defect with radio button field
 When create a defect with user picker field
 Then should be able to create defect with user picker field
 When create a defect with multi user picker field
 Then should be able to create defect with multi user picker field
 When create a defect with single version picker field
 Then should be able to create defect with single version picker field
 When launch the testExecution page to execute the testcase
  And create a defect with text field in execution page
 Then should be able to create defect with text field in execution page
 When create a defect with free text field in execution page
 Then should be able to create defect with free text field in execution page
 When create a defect with single select field in execution page
 Then should be able to create defect with single select field in execution page
 When create a defect with date picker field in execution page
 Then should be able to create defect with date picker field in execution page
 When create a defect with number field in execution page
 Then should be able to create defect with number field in execution page
 When create a defect with url field in execution page
 Then should be able to create defect with url field in execution page
 When create a defect with checkbox field in execution page
 Then should be able to create defect with checkbox field in execution page
 When create a defect with multi select field in execution page
 Then should be able to create defect with multi select field in execution page
 When create a defect with radio button field in execution page
 Then should be able to create defect with radio button field in execution page
 When create a defect with user picker field in execution page
 Then should be able to create defect with user picker field in execution page
 When create a defect with multi user picker field in execution page
 Then should be able to create defect with multi user picker field in execution page
 When create a defect with single version picker field in execution page
 Then should be able to create defect with single version picker field in execution page



#@Defect_Tracking
#Scenario: 74 Attempt search defects, If user doesn't have have browse project permission
#Given As a manager,Launch Administration page
 #When launch the Defect tracking system
  #And Set the DTS tO JIRA
 #Then Should be able to set the DTS To JIRA
 #When launch the external jira page
  #And change permission to project permission
 #When As a Lead,Launch Defect tracking page
 #Then Should be able to launch Defect Tracking Page
 #When reset the external DTS login detail
 #When search a defect by ID Defect tracking app
 #Then Should get proper message 'user doesn't have browser permission for this project' using ID
 #When search a defect by JQL in DT App
 #Then Should get proper message 'user doesn't have browser permission for this project' using JQL
 #When search a defect by filter in DT App
 #Then Should get proper message 'user doesn't have browser permission for this project' using MyFilter
 #When launch the test_execution page
  #And search a defect by ID using test execution app
 #Then Should get proper message 'user doesn't have browser permission for this project' using ID in test execution
 #When search a defect by JQL in test execution App
 #Then Should get proper message 'user doesn't have browser permission for this project' using JQL in test execution
 #When search a defect by filter in test execution App
 #Then Should get proper message 'user doesn't have browser permission for this project' using MyFilter in test execution
  #
 
@Defect_Tracking
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE