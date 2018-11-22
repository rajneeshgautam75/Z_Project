Feature: Test Execution

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 1 878785 Change the execution status if assigned by lead
    Given User is in Test Repository page
    And User creates new phase and add testcases with teststeps to phase
    When User is in Test Planning page
    And Creates new cycle, add phase and assign to lead
    Then User is in Test Execution page
    And View the executions assigned by lead
    When User changes the Execution status from not executed to Pass/Fail/Wip/Block
    And Change the Execution status from Pass to Fail
    Then User successfully changed execution  Status Across Testcases

  @Test_Execution
  Scenario: 2 878786 Create a defect on a test case with status Pass/Fail/WIP/Blocked using [D] button.  View the defect ID next to [D] button in the TCE data grid
    Given Lead Launch TestRepository and create phase and create testcases with teststeps
    When Launch TestPlanning and create a cycle
    And create a phase to cycle and assign testcases to lead
    When Launch TestExecution and view executions assigned by lead
    And change execution status to the given status
    Then defect ID shows up next to the [D] button in the TCE data grid

  @Test_Execution
  Scenario: 3 878787 As Manager/Lead/Tester, add attachment to testcase execution in text format/ Excel format /word format / image format
    Given User launch the test repository module
    When User Creates a phase and add a test case
    And enters the test step detail in test case
    And Launch test planning Module
    And Creates a cycle and add created phase to the cycle and assign to lead
    And Launch test Execution module
    And naviagate to the phase under cycle
    And view the executions assigned
    And change the execution status to pass
    Then execution status should be change to the pass
    When User Add attachment to testcase execution in text format
    And Add attachment to testcase execution in Excel format
    And attachment to testcase execution in word document format
    And Attachment to testcase execution in image format (jpg/bmp/gif)
    Then attachement(text/Excel/word/jpg) should be attached to the testcase execution

  @Test_Execution
  Scenario: 4 878788 As Manager/Lead/Tester, download and view the attachment of a testcase execution in text format/ Excel format /word format / image format
    Given Lead Launch TestRepository and create a phase,system and ten subsystems and add ten testcases with all details
    When Launch TestPlanning and create a cycle,create phase and assign testcases to tester
    When As a Tester,Launch TestExecution and add attachment and download attachment
    And execute testcases to Pass/Fail/Blocked and add attachment to testcase in text format
    And add attachment to testcase in Excel format
    And add attachment to testcase in Word document
    Then Should be able to download and view attachment in text format/Excel format/word format/image format

  @Test_Execution
  Scenario: 5 878789 As Tester, sort grids (by ID/ Name/Status/ Notes/ Alt ID/Prority/Estimated Time/Actual Time)
    Given Lead is in TestRepositorypage of Normal_Project
    When create new phase, add systems and subsystems to upto tenth level of Phase and add ten testcases with all details to each node
    And Launch Testplanning and create new cycle
    And Add phase to cycle and assign testcases to Tester
    And Login as a Tester and Launch Test Execution
    And As Tester Sort Grids
    Then Grids should be sorted based on details

  #Server
  @Test_Execution
  Scenario: 6 878790 Able to customize execution status values from Pass, Fail etc., to some other value
    #Given Login as manager credential
    #When user click on customization and create Execution status(N/A) and save it
    #And create another execution status (Future Scope) and save it
    Given Login as Lead role
    And navigate to test repository page
    And create a phase and add a testcase with test step details
    And launch test planning module and create a new cycle
    And add a created phase to the cycle and assign to the lead
    And launch test execution page
    And view the execution assigned by lead
    And change the execution status to N/A
    Then execution status should be change to N/A
    When user change the execution status to Future Scope status
    Then execution status should be change to Future Scope

  @Test_Execution
  Scenario: 7 878791 Change the execution status of a single test case back to Change Status and Actual time shuould be reset after status changed to Not Executed
    Given User is in test repository page
    When User Creates a Phase and Add testcase to the phase
    And enters the step details
    And Launch test planning module
    And creates a cycle and add phase to cycle and assign to lead
    Then test case should be assign to lead
    When Launch test execution Module
    And navigates to the phase and check the executions assigned by lead
    And change the execution status to Pass
    Then check the actual time
    When user change the status of testcase to Not Executed
    Then actual time should be reset

  @Test_Execution
  Scenario: 8 878792 As Manager/Lead/Tester, change the status of a test step to Pass/Fail/WIP/Blocked/Custom Status
    Given User is in Test Repository Page of Normal Project
    When User creates new Phase and add's testcases with teststeps to Phase
    And User is in test planning page, creates new cycle.
    And User adds existing phase to cycle and assign's to lead
    And User is in  Test Execution Page of project
    And User changes the status of first testcase step to Pass
    Then Status of first testcase step changed to Pass
    When User changes the status of second testcase step to Fail
    Then Status of Second testcase step changed to Fail
    When User changes the status of third testcase step to WIP
    Then Status of third testcase step changed to WIP
    When User changes the status of fourth testcase step to Blocked
    Then Status of fourth testcase step changed to Blocked

  #AM
  @Test_Execution
  Scenario: 9 878793 Should be able to change the execution status of a test case step from Pass/Fail/WIP/Blocked/Custom Status to any status
    Given User is in Test repository page of new release
    When create new phase and add testcases with test steps to phase
    And User launch test Planning page, create new cycle
    And Add existing phase to cycle, assign testcases under phase to lead
    And Launch Test Execution page after assigning to lead
    And User select first testcase and change the status of first testcase step to Pass
    Then First testcase step status changed to Pass
    When User execute same first testcase step status to Blocked
    Then First testcase step status should change to Blocked
    When User select second testcase and change the status of second testcase step to Fail
    Then Second testcase step status changed to Fail
    When User execute same second testcase step status to Blocked
    Then Second testcase step status should change to Blocked
    When User select third testcase and change the status of third testcase step to WIP
    Then Third testcase step status changed to WIP
    When User execute same testcase step status to Blocked
    Then Third testcase step status should change to Blocked
    When User select fourth testcase and change the status of second testcase step to Blocked
    Then Fourth testcase step status changed to Blocked
    When User execute same fourth testcase step status to Pass
    Then Fourth testcase step status should change to Pass

  @Test_Execution
  Scenario: 10 878794 Change execution status of a test case back to "Not Executed" and check execution status of test case steps
    Given User is in Test Repository page of Normal Project
    When User Creates New phase and adds testcases with test steps
    And Launch test planning and creates a new cycle in testplanning
    And Add existing phase to cycle and assign to lead
    And Launch Test Execution page
    And Select a testcase and change the testcase step execution to Pass
    Then Selected testcase step execution status should change to Pass
    When User selects a testcase and change the testcase step status execution to Fail
    Then Selected testcase step execution status should change to Fail
    When User selects a testcase and change the Execution status of testcase to Fail
    Then Selected testcase status execution status should change to Fail
    When User selects the same testcase and change the status from Fail Status to Not Executed status
    Then Selcted testcase with teststeps status Execution should change to Not Executed status

  #P
  @Test_Execution
  Scenario: 11 878795 As Tester,attempt to add test step notes >1024 characters with special/ numeric and space
    Given User is in test repository page
    When User Creates a phase and add testcase to the phase
    And enter the step details
    And Launch test planning module
    And creates a cycle and add phase to cycle and assign to tester
    Then test case should be assign to tester
    When login as lead
    And Launch test execution module
    And change the status of test case step to Pass
    And add long test step notes with special/ numeric and space
    Then step notes should be added to the test case

  @Test_Execution
  Scenario: 12 878796 Test cases should not be displayed in the tester node if re-assigned to another tester by lead.
    Given User is in Test Repository Page
    When User add a phase and add testcases with test step details
    And launch test planning module
    And create a new cycle ,add phase to cycle and assign to lead
    Then test cases should be assign to lead
    When user login as other credential and launch test execution
    Then view executions assigned to lead
    When User launch test planning module
    And assign same phase to tester
    Then check for assignments in test planning

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 13 878797 Delete an attachment on test step
    Given User is in the test repository Module
    When User creates a phase and add testcase with test steps
    And Launch Test Planning module
    And creates a new cycle and add created phase to the cycle and assign to lead
    And Launch test Execution module and view executions assigned by lead
    And Upload attachement to step and save it
    And delete the uploaded attachement
    Then uploaded attachement should be deleted successfully

  #	Server
  @Test_Execution
  Scenario: 14 878798 Able to customize execution status values in test step (from Pass, Fail etc. to some other value).
    #Given Login as manager role
    #When User click on customizations and create three custom status
    #And logout from the application
    Given Login as Lead role credential
    And navigate to the test repository page
    And create a phase and add test case with test step details
    And Launch the test planning module
    And create a new cycle and add phase to the cycle and assign to lead
    And navigate to the phase in test Execution module
    And Change the execution status to N/A
    Then Execution status should be change to N/A
    And change execution status to Future Release
    Then execution status should be change to Future Release

  @Test_Execution
  Scenario: 15 878799 Add Attachment to a test case step that contains special/international characters in the file name
    Given User is in the test repository module
    When User creates a phase and add testcase
    And enters the testcase step details in testcase
    And Launch test planning module
    And create a new cycle and add created phase to the cycle and assign to lead
    And Launch test Execution module
    And navigate to the phase
    And Add Attachment to a test case that contains special characters in the file name
    And Add Attachment to a test case that contains international characters in the file name
    Then Attachements should be attached to the testcase

  @Test_Execution
  Scenario: 16 878800 Download and view an attachment to a test case that contains special/international characters in the file name
    Given Lead is in TestRepositoryPage of Normalproject
    When Add phase and add testcases with teststeps to phase
    And Launch TestPlanning and  Create new cycle
    And add phase to created cycle and assign testcases to Lead
    And Launch TestExecution and Add Attachment to a test case step that contains special characters in the file name
    Then File containing special characters should be attached to a testcase step
    When Add Attachment to a test case step that contains international characters in the file name
    Then File containing international characters should be attached to a testcase step
    When Download file that contains special characters in the file name
    And Download file that contains international characters in the file name

  @Test_Execution
  Scenario: 17 878801 As Tester, View testcases in TCE if lead assigned testcases specific to the tester and also to "Anyone" user
    Given User is in Test Repository page of normal project
    When creates new phase and adds testcases with teststeps
    And Launch TestPlanning Page and create new cycle
    And add phase to created cycle
    And Assign few testcases to Tester and few testcases to Anyone
    Then Few testcases should be assigned to Tester and Anyone in TestPlanning page
    When Login as Tester and Launch Test Execution Page and view testcases
    Then testcases assigned to Tester and Anyone should be visible for Tester

  @Test_Execution
  Scenario: 18 878802 As Tester, attempt to view testcases in TCE if lead neither assigned to Anyone user nor to tester in specific
    Given Lead is in Test Repository page of Normal_Project
    When Add phase and add testcases with teststeps to created phase
    And Launch Test planning and create new cycle
    And Add phase to created cycle and assign testcases to lead
    Then Testcaes should be assigned to lead in TestPlanning page
    When Login as Tester and Launch TestExecution Page and navigate to phase
    Then Check for all testcases assigned to Tester and Anyone

  @Test_Execution
  Scenario: 19 878803 As Tester, Execute a testcase assign to Anyone user and change the status to Pass/Fail/WIP/BLocked/(N/A)/Future Release
    Given User is in TestRepository page of Normal Project
    When Creates new phase and add testcases with teststeps to phase
    And Launch TestPlanning page and create new cycle
    And add phase to cycle and assign testcases to Anyone
    And Login as a Tester and Launch Test Execuion Page and view testcases assigned to Anyone
    And As a Tester change the Execution Status of First testcase to Pass
    Then Execution Status of first testcase should be changed to Pass
    When Change the Execution Status of same testcase to Fail
    Then Execution Status of testcase should be changed to Fail
    When As a Tester change the Execution Status of Second testcase to Fail
    Then Execution Status of Second testcase should be changed to Fail
    When Change the Execution Status of same testcase to Pass
    Then Execution Status of testcase should be changed to Pass
    When As a Tester change the Execution Status of Third testcase to WIP
    Then Execution Status of Third testcase should be changed to WIP
    When Change the Execution Status of same testcase to Blocked
    Then Execution Status of testcase should be changed to Blocked
    When As a Tester change the Execution Status of Fourth testcase to Blocked
    Then Execution Status of first testcase should be changed to Blocked
    When Change the Execution Status of same testcase to WIP
    Then Execution Status of testcase should be changed to WIP

  #P
  @Test_Execution
  Scenario: 20 878804  As Tester,Link a defect on testcase assigned to Anyone user with status Pass/Fail/WIP/Blocked/Custom Status
    Given User is in Test Repository Page
    When User add a phase and add testcases with test steps to phase
    And Launch test planning module
    And create a new Cycle and add phase to cycle and assign to anyone
    Then test cases should be assign to anyone
    And logout from the application
    When User login as tester
    And navigate to phase in test execution page
    And change the status of first testcase to Pass
    And click on D button of first testcase and link a defect
    Then defect should be link to the first test case
    When change the status of second testcase to Fail
    And click on D button of second testcase and link a defect
    Then defect should be link to the second test case
    When change the status of third testcase to WIP
    And click on D button of third testcase and link a defect
    Then defect should be link to the third test case
    When change the status of fourth testcase to Custom Status(Future Scope)
    And click on D button of fourth testcase and link a defect
    Then defect should be link to the fourth test case

  @Test_Execution
  Scenario: 21 878805 As Tester, File a defect on testcase assigned to 'Tester' with status "Pass/Fail/WIP/Blocked/Custom Status"
    Given Lead Launch TestRepository and create a phase and create testcases with teststeps
    When Launch TestPlanning and create a cycle,create a phase and assign to anyone
    When As a Tester,Launch TestExecution and change the status to Pass,search and link a defect
    And execute the testcase status to Fail,search and link a defect
    And execute testcase status to the WIP,search and link a defect
    And execute testcase status to Blocked,search and link a defect
    And execute testcase to a status CustomStatus and search and link a defect

  #P
  @Test_Execution
  Scenario: 22 878806 As Tester, Change the status on multi-selected testcases assigned to Tester/Anyone user
    Given User is in the test repository page
    When User creates a phase and adds multiple testcases
    And enters the test step details
    And Launch Test Planning module
    And creats a cycle and add phase to the cycle
    And assign some testcase to tester and some testcase to Anyone
    Then test cases should be assigned to tester and Anyone
    When User logout from the application
    And login as Tester role
    And change the status of testcase to Pass by using bulk edit
    Then status of test cases should be changed to Pass
    When user change the status of testcase to Fail by using bulk edit
    Then status of test cases should be changed to Fail
    When user change the status of testcase to WIP by using bulk edit
    Then status of test cases should be changed to WIP
    When user change the status of testcase to Blocked by using bulk edit
    Then status of test cases should be changed to Blocked
    When user change the status of testcase to Custom status by using bulk edit
    Then status of test cases should be changed to Changed status

  #p
  @Test_Execution
  Scenario: 23 878807  As Tester, attempt to view testcases assigned to Anyone user, if deleted by lead out of EAS using [Delete] button
    Given User is in test repository page in normal project
    When User creates a phase and add test cases with test steps
    And creates a new cycle and add phase to the cycle
    And assign the test cases to the tester
    Then test case should be assigned to tester
    And user logout from the application
    When Login as tester and launch test execution
    And check for assigned test cases and logout from application
    And Login as lead role and launch test planning
    And edit assignments and delete some testcase assigned to tester
    And lead logout from the application
    And login as tester role and launch test execution
    And navigate to the node
    Then deleted test case should not be present in execution page

  @Test_Execution
  Scenario: 24 878808 As Lead/Tester, double-click on a node name at any level in the local release (Release/P/S/SS), if tree is expanded/collapsed
    Given Lead is in TestRepositoryPage of Normal_Project
    When Add a phase, add ten systems to phase, add two subsystems to each system and add testcases with teststeps to each node
    And Launch Test Planning page and create new cycle
    And Add phase to created cycle and assign to Lead using BulkAssignment
    And Launch TestExecution Page
    Then Expand All nodes By clicking one by one and Verify that only the clicked System/Sub system is Expanded
    And Collapse All nodes By clicking one by one and Verify that only the clicked System/Sub system is Expanded

  #Server
  @Test_Execution
  Scenario: 25 878810 Edit the color of an Existing (default/custom) test case,test step status,view color Change reflected in TCE
    Given Lead is in TestRepository
    When Lead create a phase and create testcases with teststeps and add two systems to phase
    When User Launch TestPlanning and create a Cycle,add phase to cycle and assign testcases to Creator
    When Lead Launch TestExecution and execute teststeps and testcases to pass/fail
    When As a Manager,Launch Administration,click on customization and click on testcase execution and edit default execution status and change color
    When As a Lead,Launch TestExecution and view the changes
    Then edited status value should appear in status drop down list in TestExecution(TCE)

  @Test_Execution
  Scenario: 26 878811 Execute testcases to default/edited default/custom status at both test case and test step level, unassign executed testcases in EAS, attempt to view test cases TCE
    Given User is in test repository page
    When user add a phase and add two system to phase
    And add testcases with test steps to the phase
    And read the test case count
    And Launch test planning module
    And create cycle and add created phase to cycle
    And assign to the creator and read the testcase count
    And Launch test execution and execute teststep of first three test case and change to Pass/Fail/N/A
    And Launch test planning module and edit the phase
    And unassign executed testcase and save it
    And Launch test execution page and navigate to phase
    Then verify unassigned test case should not show

  @Test_Execution
  Scenario: 27 878812  Re-execute testcase from disabled status to any enabled status
    Given User is in test repository page
    When user add phase and add two system under phase
    And add test case with test step to phase
    And launch test planning module
    And create a new cycle and add created phase to the cycle
    And assign testcase to the lead by individual assignment
    And Launch test Execution module
    And execute teststep and testcases and change to custom status(N/A)
    Then status should be change to custom status(N/A)
    When User login as manager
    And navigate to status customization and disable the custom status(N/A)
    And login as lead role and launch test Execution
    And change the status of testcase from N/A to Pass
    Then status should be change from N/A to Pass

  #P
  @Test_Execution
  Scenario: 28 878813 Execute testcases added to TCE after sync to default/edited default status
    Given User is in Test Repository Page
    When user add a phase and two system under phase
    And add test cases with test steps to the phase
    And Launch test planning, create a new cycle
    And add created phase to the cycle and assign testcases to lead
    Then testcases should be assign to lead
    When user launch test repository page
    And create a system to phase and add testcases to the system
    And Launch test planning page
    And edit the added phase,select phase and sync
    And assign testcases to the lead
    And Launch test execution and execute test step and change to custom status(N/A)
    Then Status should be change to custom status(N/A)

  @Test_Execution
  Scenario: 29 878814 Re-execute testcase from one custom status to another, if execution is linked to Jira defect
    Given User is in test repository page
    When add a phase and add two system under phase
    And Add testcases with test steps to phase
    And Launch test planning module
    And create a new cycle, add phase to cycle and assign to lead
    Then testcase should be assign to lead
    When user Launch test execution module
    And execute teststep and testcases and change to custom status
    And link a defect to testcase
    And change the status of testcase to Fail
    Then status should be change to Fail

  @Test_Execution
  Scenario: 30 878815 As Lead, delete cycle having testcases assigned to Lead/Tester/Anyone, in TCE attempt to view cycle
    Given User is in test repository page
    When User add a phase and add two systems to phase
    And add testcases with test steps to phase
    And Launch test planning module
    And create a new cycle and add phase to cycle
    And assign testcases to lead by individual assignments
    Then test cases should be assign to Lead
    When User launch test execution module
    And execute test step and testcase, change to custom status
    Then status should be change to custom status
    When user link a defect to testcase and change status to Fail
    Then defect should be linked with testcase and status change to Fail
    When User launch test planning module and navigate to cycle
    And delete the cycle and launch test execution
    Then check for executions in test execution page

  @Test_Execution
  Scenario: 31 878816  As Lead, assign testcases at any level to different users and as assignees view the testcases in TCE
    Given User is in TestRepository page of normal project
    When User creates new phase and adds two system to phase
    And User adds testcases with teststeps to phase in Test Repository
    And User launch Test planning and creates new cycle
    And User adds phase to created cycle
    And User Assign testcases under phase to lead by individual assignment
    Then Testcases should be assigned to lead by individual assignment

  @Test_Execution
  Scenario: 32 878817 Attempt to view hidden cycle in Test Execution Page
    Given User is in the test repository page
    When User add a phase and add two system in the phase
    And add testcases with test step in the phase
    And Launch Test Planning module
    And create a new cycle and add created phase to the cycle and assign to the lead
    And after assigning hide the cycle
    And Launch test Execution module
    And check for assigned cycle
    Then able to view the assigned hidden cycle

  #Server
  @Test_Execution
  Scenario: 33 878819 Execute the testcase without the teststeps and check the version in TCE
    Given User is in test repository page
    When User add a phase and add two system to phase
    And Add testcases with teststeps and some testcases without teststeps to phase
    And Launch test planning module
    And create a new cycle and add phase to cycle and assign testcases to lead
    And Lauch test case execution page and enable the version in TCE page
    And execute the testcase without the teststeps and check the version in TCE and Check the Version
    Then version will not show for testcases without test steps
    When execute the testcase with teststeps and check the version in TCE and Check the Version
    Then version will reflect for testcase with test steps

  @Test_Execution
  Scenario: 34 878820 Execute testcase after deleting teststep and check the version in TCE
    Given Lead is in TestRepository of normal_Project
    When Add Phase and add two systems to Phase
    And Add few testcases without stepDetails and few testcases with stepDetails to phase
    And Launch TestPlanning and create new Cycle
    And Add phase to created cycle and select Assign individually using BulkAssignment
    And Assign Testcases to Lead by Individual assignment
    And Launch TestExecution and Enable the version to make it visible in the datagrid of the TCE
    Then Verion should be visible in datagrid of TCE
    When Execute the  status of testcases,which has only stepdetails and check the version
    Then Version should be visible across the testcases
    When launch TestRepository and delete stepdeatils of a executed testcase
    And Launch TestExecution and Execute testcase of modified stepdetails and check the version
    Then version should be visible

  @Test_Execution
  Scenario: 35 878821 Execute testcase and check version in TCE after reverting teststep version in TCC using [Make Current] button
    Given Lead is in TestRepository page of Normal_Project
    When Add Phase and add two systems to phase
    And Add few testcases with stepdetails and few testcases without stepdetails to phase
    And Launch TestPlanning and Create new cycle
    And Add phase to cycle and select Assign individually in Bulk Assignment
    And Assign testcases to lead using individual Assignment
    And Launch TestExecution and Enable the version in datagrid
    Then Version should be enabled in datagrid of TestExecution
    And Execute status of testcases and check the version
    Then Version of Executed testcases with stepdetails should be visible

  #		Pass
  @Test_Execution
  Scenario: 36 878823  View Testcase count assigned to Manager at each Phase,System and Subsystem level in a scheduled cycle
    Given User is in the test repository page
    When User Creates a phase and adds two system in the phase
    And create ten testcase to all the node
    And Enters the step details to testcase
    And click on test planning module
    And creates a cycle and add phase to the cycle
    And cancel the bulk assignment popup after adding phase to cycle
    And assign all not executed test case to test manager by bulk assignement window
    Then test cases should be assigned to test manager
    When login as manager
    And click on test execution module and navigate to phase
    Then view the test case count of phase
    When user navigates to the system
    Then view the test case count of system
    When user navigates to the subsystem
    Then view the test case count of subsystem

  @Test_Execution
  Scenario: 37 878824 View Testcase count assigned to Lead at each p/s/ss level in a scheduled cycle
    Given Lead is in Test repository Page of normal project
    When Creates new phase and add two systems to phase
    And Add ten testcases with teststeps to phase and each system
    And Launch TestPlanning and create a new cycle
    And Add phase to created cycle and cancel the BulkAssignment
    And Launch TestPlanning create new cycle
    And Add phase to new cycle and cancel the BulkAssignment
    And Assign testcases to Lead using BulkAssignment window
    And Launch TestExecution and navigate to phase/Systems
    Then Testcases count Assigned to Lead should be visible

  @Test_Execution
  Scenario: 38 878825 View Testcase count assigned to Custom role User at each p/s/ss level in a scheduled cycle
    Given Lead is in Testrepository Page of NormalProject
    When Add phase and two system nodes to phase
    And Add ten testcases with test steps to each node
    And Launch Testplanning and Create new cycle
    And Add phase to created cycle
    And Launch Testplanning and create another cycle
    And Add phase to newly created cycle and assign testcases to creator
    And Launch TestPlanning, Edit Phase and Select one node
    And Assign Testcases using Bulk Assignment window from Lead to Custom user
    Then Testcases of selected node should be assigned to Custom user
    And Launch TestExecution and navigate to node
    Then check for Assigned cycle

  @Test_Execution
  Scenario: 39 878826 View assignments in cloned release.
    Given User is in test repository page of second relese
    When Uesr add a phase and add two system to phase
    And add ten testcases with test steps
    And Launch test Planning module
    And create a new cycle ,add phase to cycle and cancel the bulk assignment popup
    And launch test Planning module
    And create a new cycle,add same phase to cycle and assign to tester using bulk assignment window
    Then testcase should be asssigned to tester
    And select the release and click on manage release and clone
    And select all checkboxes and clone it
    And select the cloned release and launch test execution module
    And check the assignments in cloned release
    Then able to view the assignments in test execution page

  @Test_Execution
  Scenario: 40 878827 De-Link linked defect in Testcase Executions
    Given Lead is in TestRepositoryPage of NormalProject
    When create a new phase and add two systems to a created phase
    And Add ten testcases with teststeps to each node
    And Launch Test Planning Page and create new cycle
    And Add phase to created cycle and assign testcases to creator
    And Launch Test Execution page and navigate to nodes
    And Execute testcases to Pass/Fail
    And click on [D] button, search a defect and link a defect
    Then Defect should be linked to selected testcase
    When Refresh the page and Launch Test Execution
    And Search that testcase which is Linked to defect and De-Link the defect by clicking on Delete button
    Then Selected testcase defect should be De-linked

  #Server
  @Test_Execution
  Scenario: 41 878829 Export According to Priority Executions in any format
    Given Lead Launch TestRepository and create ten testcases with teststeps and add priority p1 for five testcases,priority p2 for three testcases and priority p3 for two testcases
    When Launch TestPlanning and create a cycle and create a phase to cycle and assign testcases to tester
    When As a Tester Launch TestExecution and execute testcases to custom status,click on D button,search a defect and link a defect
    And select multiple testcase executions using multi select and export testcase executions from grid level
    When export testcases to excel format and select priority p1 and save
    When export testcases to excel format and select the priority p2 and save
    When export testcases to excel format and select priority to the p3 and save
    Then able to export executions according to priority

  @Test_Execution
  Scenario: 42 878830 View the sorting in TCE grid
    Given User is in test repository pages
    When User add a phase with name and description
    And add ten testcases with stepdetails and priority
    And add two system to phase
    And add testcases with all details
    And Launch test planning module
    And create a new cycle and add phase to cycle and assign to tester
    Then test cases should be assing to tester
    When User Login as tester role
    And Launch test execution module and navigate to node
    And execute testcases to custom status
    And click on Defect button,search and link a defect
    Then defect should be linked with testcase
    When user sort the testcase grid(ID/Priority/Summary/Custom Field)
    Then Sort column should visible in test case grid

  @Test_Execution
  Scenario: 43 878836 View attachment to test schedule in Supported image formats: png, jpg, jpeg, bmp, gif format
    Given User is in test repository pages
    When User add a phase and add two system under phase
    And add ten testcases with test steps detail to each node
    And Launch test planning module
    And add a cycle, add phase to cycle and assign to tester
    Then test case should be assing to tester
    When user login as tester role
    And launch test execution and navigate to phase
    And select a testcase and execute it to Pass/Fail
    And click on D button,search a defect and link it
    Then testcase should be link with defect
    When user add attachement in differen formats(png,jpg,jpeg,bmp,gif)
    Then attachement should be attached to tescase

  @Test_Execution
  Scenario: 44 878838 Able to View Execute Testcase Popup if all testcases steps changed to same status.
    Given Lead is in Test repository Page
    When Lead add a phase and add System, Subsystem to Phase
    And Add four testcases with four teststeps to each node
    And Lead is in TestPlanning Page and create new cycle
    And Add phase to cycle and assign all testcases to creater
    And Launch TestExecution Expand Release,Expand cycle and Expand Phase
    And Change All Execution status of first testcase steps to Pass
    Then First Testcase status should update to status Pass
    When Change All Execution status of second testcase steps to Fail
    Then Second Testcase status should update to status Fail
    When Change All Execution status of third testcase steps to WIP
    Then Third Testcase status should update to status WIP
    When Change All Execution status of fourth testcase steps to Blocked
    Then Fourth Testcase status should update to status Blocked

  @Test_Execution
  Scenario: 45 878844 As a mgr/lead/tester, attempt to edit the testcase actual execution time by adding text/alphanumeric characters/special chars
    Given Lead is in Test RepositoryPage of Normal Project
    When Create new phase and add a testcase to created phase
    And Launch Test Planning and create new cycle
    And Add phase to cycle and assign testcase to Tester
    Then Testcase should be assigned to Tester in TestPlanning
    When Login as Tester and Launch Test Execution
    And Select a testcase, Execute the status of a testcase and attempt to modify the Actual Execution time by entering text
    Then Selected testcase Actual Execution time should not be modified by entered text
    When Attempt to modify the Actual Execution time of testcase by entering Special characters
    Then Selected testcase Actual Execution time should not be modified by entered Special characters
    When Attempt to modify the Actual Execution time of testcase by entering Alpha Numeric
    Then Selected testcase Actual Execution time should not be modified by entered`Alpha Numeric

  #Passs
  @Test_Execution
  Scenario: 46 878845 Updated Cycle name should reflect in Test Execution Page
    Given User is in the test repository page
    When user add a phase and add a testcase to the phase
    And Launch test planning module
    And create a new test cycle and add created phase to the cycle and assign to the creator
    And Launch test Execution module
    And navigate to the cycle and view the cycle name
    And Launch test planning module
    And edit the cycle name and save it
    And click on test execution page and navigate to cycle
    Then cycle name should reflect in test execution page

  #P
  @Test_Execution
  Scenario: 47 878846 Able to add notes to testcase executions
    Given Lead is in Test Repository Page of Normal Project
    When Add a phase and add testcases to created phase
    And Launch TestPlanning and create new cycle
    And add phase to created cycle and assign testcases to creator
    And Launch TestExecution Expand all nodes
    And Select a testcase and change Execution status, add notes and click on save
    Then selected testcase Execution status should be changed and notes should be added
    When Select another testcase and change Execution status, add notes and click on cancel
    Then Selected testcase Execution status should be changed and notes should not be added

  @Test_Execution
  Scenario: 48 878809 As Tester, execute testcase under free form phase to any status (Pass/Fail/WIP/Blocked) and Chnage Execution  time of an unexecuted testcase
    Given As a Lead,Launch TestRepositOry
    When User creates a phase,create testcases with teststeps to phase and creates two systems under phase
    When User Launch TestPlanning and creates a cycLe
    And User creates a freeform phase and creates two system nodes to phase and creates three subsystem nodes to system and add testcases to freeform phase
    When As a Tester,Launch TestExecution and executes the testcases to pass/fail/wip/blocked
    When User change the actual execution time of a testcase after execution
    Then User successfully executes the testcases

  @Test_Execution
  Scenario: 49 878818 Create multiple phases with deep nested nodes up to 8th level, each node with ~ testcases, add phases multiple times to Cycle assign all testcases to Anyone, browse thru the nodes/testcases in TCE
    Given User is in a paGe TestRepositorY
    When User creates a phase and creates a two systems and ten subsystems and create testcase with teststeps to all nodes
    When User Launch TestPlanning and creates a cYcle
    And User creates a freeform phase to cycle and create two systems to phase and creates three subsystems to system node
    And User add testcases to freeform phase by using browse option and assign it to tester
    When User Launches TestPlanning and creates a Cycle
    And User creates a freeform phase and creates two systems to phase and creates three subsystems to system node
    And User add testcases to freeform phase by using browse option and assign it to the tester
    Then User Launches TestExecution and views the all added assigned testcases to tester

  @Test_Execution
  Scenario: 50 878831 Able to view Added testcases in TCE if Testcases added By using Advance search in EAS
    Given As a Lead,Launch Testrepository
    When User creates a phase and creates a system and creates subsystems upto tenth level and add ten testcases with all fields to each node
    When User Launch TestPlanning and creates a cycle and creates a phase
    And assign testcases to an tester
    Given As a Tester,Launch TestExecution and execute five testcases to different status in each node
    Given As a Lead,Launch TestPlanning and creates a freeform phase to cycle and add a node to freeform phase
    When User adds testcases to freeform phase using advanced search and assign it to tester
    Then User Login as tester,Launches TestExecution and expands release,cycle and selects phase and checks assignments

  #
  #
  @Test_Execution
  Scenario: 51 878832 Able to view Added testcases in TCE if Testcases added From Other Cycle in EAS
    Given As a Lead,Launch TestRepository
    When create a phase and create a system and create subsystem upto tenth level and add ten testcases with all details to each node
    When Launch TestPlanning and create a cycle and create a phase and assign testcases to the tester
    When As a Tester,Launch TestExecution, execute five testcases to different status in each node
    When As a Lead,Launch TestPlanning and create a cycle,create a freeform phase to cycle and add a node to freeform phase
    When add testcases to freeform phase by using other cycles using cycle,phase and different status and assign to tester
    Then As a Tester,Launch TestExecution and select cycle,phase and check assignments

  @Test_Execution
  Scenario: 52 878833 Able to view Added testcases in TCE if Testcases added from Other Cycle in EAS(with Maintain Assignment Of Original Schedule)
    Given Lead is in TestRepository page
    When Lead creates a phase,system and ten subsystems and add ten testcase with all details to each node
    When Lead Launch TestPlanning and create a cycle and create a phase and assign testcases to a tester
    When Tester Launch TestExecution and execute five testcases to different status in each node
    When Lead Launch TestPlanning and create cycle and create freeform phase and create a node to freeform phase
    And add testcases to freeform phase using other cycle and different status values
    And Tester Launch TestExecution and expand release,cycle and navigate to the phase
    Then User check the assignments

  #
  #
  @Test_Execution
  Scenario: 53 878834 Able to view Added testcases in TCE if Testcases added By using From Advance Search in EAS
    Given Lead is in a page TestRepository
    When User create a phase and create system and create subsystem upto tenth level and add ten testcases with all details to each node
    When User Launch TestPlanning and create the cycle and create a freeform phase and add a node to freeform phase
    When User add a testcases to freeform phase using advanced search and assign to an tester
    When Tester Launch TestExecution and expand Release,cycle and navigate to the phase
    Then User check assignments in TCE

  @Test_Execution
  Scenario: 54 878839 As mgr/lead/tester, file a defect from TCE against a testcase that is mapped to Jira requirement and attempt to view issue-to-issue link in Jira, if requirement-defect flag is disabled in Defects Admin
    Given Manager is in administration page and click on general configuration,click on jira remote link
    When Lead Launch TestRepository and creates a phase and create testcases
    When User Launch TestPlanning and create a cycle and create a phase and assign testcases to tester
    When User Launch Requirement and select release and perform import operation
    And User copy the imported defect from imported folder and paste in release node
    When User map jira requirement to testcase
    When User login as Tester,Launch TestExecution and expand release,cycle and select phase
    And User select testcase and execute testcase to pass/fail/blocked and link a defect
    Then testcase jira defect remote link should be created

  #
  @Test_Execution
  Scenario: 55 878840 As mgr/lead/tester, link an existing defect to a testcase that is mapped to Jira requirement and attempt to view issue-to-issue link in Jira, if Jira user has no link issues permission
    Given Lead is in TestRepository page to create phase and testcases
    When User create a phase and create testcases
    When User Launch requirements and perform import operation on the defect
    And User copy the imported defect folder and paste in release node
    When User map Jira requirement to testcase
    When User Launch TestPlanning and create a cycle and create a phase and assign some testcases to tester and some testcases to anyone
    When Tester Launch TestExecution and expand release,cycle and select phase
    And select testcase and execute testcases to pass/fail/Blocked and link a defect

  #
  @Test_Execution
  Scenario: 56 878841 As mgr/lead/tester, file a defect from TCE against a testcase that is mapped to Jira requirement and view issue-to-issue link in Jira, if requirement-tc flag is enabled
    Given Manager Launch defect admin,click on general configuration and click on jira remote link
    When Lead Launch TestRepository and create a phase and create testcases
    When Lead Launch Requirements and perform defect import operation
    And User copy the imported defect folder and paste in the release node
    When User map jira requirement to the testcase
    When User Launch TestPlanning and create cycle,create phase and assign some testcases to tester and some to anyone
    When Tester Launch TestExecution and expand release,cycle and navigate to phase
    And select the testcase and execute testcases to the status pass/fail/Blocked and link a defect

  #
  @Test_Execution 
  Scenario: 57 878842 As mgr/lead/tester, link an existing defect to a testcase that is mapped to Jira requirement and view issue-to-issue link in Jira, if requirement-tc flag is disabled
    Given Manager Launch Defect Admin and click on general configuration and disable requirement-tc flag
    When As a Lead Launch TestRepository and create a phase and create testcases
    When As a Lead Launch Requirements and perform defect import operation
    And User copy the imported defect folder and paste in Release node
    When User map Jira requirement to the testcase
    When User Launch TestPlanning and create a Cycle
    And User create a phase and assign some testcases to tester and some testcases to anyone
    When Tester Launch TestExecution and expand and Release and Cycle and select a phase
    And execute testcases to pass/fail/Blocked and link a defect

  #
  @Test_Execution
  Scenario: 58 878843 As mgr/lead/tester, file a defect from TCE against a testcase that is mapped to Jira requirement and attempt to view issue-to-issue link in Jira, if requirement-defect relationship does not exist in Jira
    Given Manager Launch defect admin and click on general configuration and click on remote link
    When Lead Launch TestRepository and create a Phase and create testcases
    When User Launch Requirements and select release,perform defect import operation
    When User copy the Imported defect folder and paste in the Release node
    When User map Jira Requirement to testcase
    When User Launch Testplanning and create a cycle and add phase to cycle
    And assign some testcases to tester and some testcases to anyone
    When Tester Launch TestExecution and expand release,cycle and select the phase
    When User select and execute testcases to pass/fail/Blocked and link a defect

  @Test_Execution
  Scenario: 59 878828 Export All testcases in any format
    Given User is in test repository pages
    When User add a phase and add two Systems to phase
    And add ten testcase with test step to each node
    And Launch test planning module
    And Create a new cycle,add phase to cycle and assign testcases to tester
    Then testcases should be assign to tester
    When User login as tester role
    And Launch test execution page
    And execute testcases to Pass/Fail
    And click on Defect button and link a defect
    And export testcases execution from release level in Excel format
    Then able to export testcases in Excel format
    When user export testcases execution from release level in Detailed format
    Then able to export testcases in Detailed format
    When user export testcases execution from release level in Summary format
    Then able to export testcases in Summary format

  @Test_Execution
  Scenario: 60 878837 Able to view Added testcases in TCE if Testcases added trough pagination in EAS
    Given Lead is in TestRepository page to create a phase
    When User create a system and subsystems upto tenth level and add thousand testcases with all details to each node
    When User Launch TestPlanning and create a cycle
    And add freeform phase to cycle and add a node to freeform phase
    When User add testcases to freeform phase using advanced search and set page size to twenty five and select pagination to six
    When User add testcases to freeform phase using browse option,expands nodes and set page size to hundred and select pagination to six
    When User add testcases to freeform phase using other cycle,select page size to ten and select pagination to two
    And User select sixth node and select checkbox Maintain assignment of original schedules and assign testcase to tester
    When Tester Launch TestExecution and expand release,cycle and select phase and execute testcases to pass/fail
    And User click on D button and search a defect and link a defect
    Then User able to view added testcases in TCE

  @Test_Execution
  Scenario: 61 878822 View Sync defects job progress & progress bar after Sync defects job progress is successful
    When Lead Launch TestRepository and create a phase with testcases
    When Launch TestExecution and execute few testcases and link defects
    And Launch external Jira and edit priority
    When As a Lead,Launch TestRepository and create a phase with testcases and add teststeps to few testcases and create two systems to phase
    When Launch TestExecution and execute the few testcases and link defects
    And Launch External Jira and edit priority
    When Launch TestExecution and select release node and click on sync
    Then view progress bar window with % of completion

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 62 878847_Assign testcases to indidvidual user, view notificaiton for the user in other desktop opened TCE app if selected same release/cycle/phase tree node and apply changes by using [A]
    Given Lead Login into Zephyr Application
    When Selects the Project, Release
    And Launch the TestRepository
    Then Launch another browser, Login as Manager
    When Select Project and Release
    And Launch TestExicution and Select Release
    And In first Browser, Creates Phase with name and Description
    Then Navigates to Created Phase and Adds the Testcase with Name and Description
    When Launch the Testplanning and Creates the TestExicution Cycle
    And Adds Phase to the Cycle and Assign to Manager
    Then In Second Browser, Apply the Notification for Manager

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 63 878848_Assign testcases to indidvidual user, view notificaiton for the user in other desktop opened TCE app if selected same release/cycle/phase tree nodeand Discard changes by using [D]
    Given Lead Login into Zephyr ApplicatioN
    When Selects the Project, ReleasE
    And Launch the TestRepositorY
    Then Launch another browser, Login as ManageR
    When Select Project and ReleasE
    And Launch TestExicution and Select ReleasE
    And In first Browser, Creates Phase with name and DescriptioN
    Then Navigates to Created Phase and Adds the Testcase with Name and DescriptioN
    When Launch the Testplanning and Creates the TestExicution CyclE
    And Adds Phase to the Cycle and Assign to ManageR
    Then In Second Browser, Discard the Notification for Manager

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 64 878849_Unassign testcases to individual user, view notification for the user in other desktop opened TCE app if selected same release/cycle/phase tree node and apply changes
    Given Lead Login intO Zephyr ApplicatioN
    When Selects the ProjecT, ReleasE
    And Launch the TestRepositOrY
    Then Launch another browser, LogiN as ManageR
    When Select ProjecT and ReleasE
    And Launch TestExicutioN and Select ReleasE
    And In first Browser, Creates PhasE with name and DescriptioN
    Then Navigates to Created PhasE and Adds the Testcase with Name and DescriptioN
    When Launch the Testplanning and CreateS the TestExicution CyclE
    And Adds Phase to the Cycle and AssigN to ManageR
    Then In Second Browser, apply the Notification for Manager
    When In first Browser, UnAssign some Testcases
    Then In Second Browser, Apply the Notifications

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 65 878850_Delete Cycle in EAS, View notification for the user in other opened TCE app if selected same release/cycle/phase tree node and apply changes
    Given Lead Login into Zephyr AppliCation
    When Selects the Project, ReleAse
    And Launch the Testrepository
    Then Launch another browseR, Login as Manager
    When Select Project and release
    And Launch TestExicution and select Release
    And In first Browser, Creates phase with name and Description
    Then Navigates to Created PhAse and Adds the Testcase with Name and Description
    When Launch the TestplaNning and Creates the TestExicution Cycle
    And Adds Phase to the CyclE and Assign to Manager
    Then In Second Browser, ApPly the Notification for Manager
    When In first Browser, Delete Cycle
    Then In Second Browser, Apply Notifications

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 66 878851_Assign a testcase in EAS to Lead only.Attempt to view notification when Manager is opened TCE .
    Given Lead Login Into Zephyr AppliCation
    When Selects the project, ReleAse
    And Launch the TesTrepository
    Then Launch anotheR browseR, Login as Manager
    When Select project and release
    And Launch testExicution and select Release
    And In firsT Browser, Creates phase with name and Description
    Then Navigate to Created PhAse and Adds the Testcase with Name and Description
    When Launch The TestplaNning and Creates the TestExicution Cycle
    And Adds Phase to the CyclE and Assign to Lead
    Then In Second Browser, ApPly the Notification in Manager Window

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 67 878852 Execute a testcases in TCE ,View the notification for the assigned user if selected same release/phase tree node in TCE app and apply the changes_d Login into Zephyr Application
    Given User Selects the Project and Release
    When Launch the TestRepository module
    And Launch another browser, Login as manager
    And Select the Project and Click on Release
    And Launch Test Execution and Select Release
    And In first Browser, Creates Phase with name and Descriptions
    Then Navigates to Created Phase and Adds the TestCase with Name and Description
    When Launch the Test Planning and Creates the Test Execution Cycle
    And Adds Phase to the Cycle and Assign to the Manager
    Then In second browser, apply the notifications for Manager
    When In first Browser, Launch test execution and execute testcase to Pass
    Then In second Browser, check and Apply Notifications in Manager Window

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  #
  @Test_Execution
  Scenario: 68 878853 Add testcase execution notes and attachments , View the notification for the assigned user if selected same release/phase tree node  in TCE app and apply the changes
    Given User Selects the Project and release
    When Launch the TestRepository Module
    And Launch another Browser, Login as Manager
    And Select project and Release
    And Launch Test Execution Module and Select Release
    And In first Browser, Creates Phase with Name and Descriptions
    Then Navigates to the Created Phase and Adds the Testcase with Name and Description
    When Launch the Testplanning and Creates the Test Execution Cycle
    And Adds created Phase to the Cycle and Assign to the Manager
    Then In Second Browser,Apply the Notifications for Manager
    When In first Browser, Launch test execution module and execute testcase to Pass
    And add attachement and notes to testcase
    Then In Second Browser, Apply Notification

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 69 878854 Delete Cycle/Phase in EAS, View notification for the user in other opened TCE app if selected same release/cycle/phase tree node and apply changes
    Given User Selects the Project, Release
    When launch the TestRepository module
    And launch another browser, Login as Manager
    And select Project and Release
    And Launch Test Execution Module and Select release
    And In first Browser, Creates Phase, System and Subsystem with name and Description
    Then Navigates to Created Node and Adds the Testcase with Name and Description
    When Launch the Testplanning and Creates the TestExecution Cycle
    And Adds Phase to the cycle and Assign to the Manager
    Then In Second Browser, Apply the Notifications for Manager
    When In first Browser, Launch test planning and delete phase
    Then In Second Browser, check and Apply Notifications
    When In first Browser, Launch test planning and delete cycle
    Then In Second Browser, Check and Apply Notifications

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 70 878855 Clone a cycle in EAS with Also copy testcase assignments over, view notification in the assigned user desktop opened TCE app if selected same
    Given User Selects the Project and select the Release
    When Launch the Test Repository module
    And launch another browser, Login as manager
    And Select the Project and click on Release
    And Launch Test Execution and select Release
    And In first Browser, Creates Phase,System and Subsysytem with name and description
    Then Navigates to Created Nodes and Adds the TestCase with Name and Description
    When Launch the Test Planning module and Creates the Test Execution Cycle
    And Adds Created Phase to the Cycle and Assign to the Manager
    Then In second browser, apply the notification for Manager
    When In first Browser, Launch test Planning and clone cycle by selecting copy testcase assignments over
    Then In second Browser, check and Apply Notification in Manager Window

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: 71 878856 Re-assigning one user to anyone, View the notification for the assigned user if selected same release/cycle/tree node in TCE app and apply the changes
    Given User Selects the Project and select the release
    When Launch the Test Repository Module
    And launch Another browser, Login as manager
    And Select the Project and Click on release
    And Launch Test Execution module and select Release
    And In first Browser, Creates Phase,System and Subsystem with name and description
    Then Navigates to Created Nodes and Adds the Testcase with Name and Description
    When Launch the Test Planning module and Creates the Test execution Cycle
    And Adds Phase to the created Cycle and Assign to the Manager
    Then In Second browser, apply the notification for Manager
    When In First Browser, Launch test Planning and re-assign testcases from Manager to Anyone
    Then In Second Browser, check and Apply Notification in Manager Window

  @Test_Execution
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Test_Execution
  Scenario: Logout
    Given User is in the Zephyr ProjectPage_TPE
    When User Clicks on logout Icon_TPE
    And User clicks on Logout Option_TPE
    Then User should be logged out from Zephyr Application Successfully_TPE
