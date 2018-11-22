Feature: Assign_Master

  @Assign
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Assign
  Scenario: 1 868102 Assign testcases in node to different users
    Given user in repository to create node
    And create node Add testcase and clone
    When navigate to test planning and create cycle
    And add pahse to cycle and navigate to phase
    And select testcase and assign to different users
    Then select all testcase assign to different users
    And Should be able to assign testcases to different users

  @Assign
  Scenario: 2 868103 Delete testcases from Test planning assignment window
    Given user in repository page to create Node
    And Create a node add testcase and clone Testcases
    When create a cycle and add phase cancel popup
    And select testcase and delete
    And select testcase and assing to manager/lead and delete
    Then delete the remaining testcases
    And Should be able to delete testcases

  @Assign
  Scenario: 3 868104 As lead/manager re-assign or delete testcases after executing in test execution
    Given user in repository Page to create Node
    And create a node add testcase and clone testcses
    When launch testplanning create cycle and add phase
    And launch test execution and execute testcases by status dropdown
    And launch testplanning select phase and assign and view status
    Then select test case assign to lead
    And select test case and delete
    And select two more testcase and delete
    Then select remaining testcases and delete

  @Assign
  Scenario: 4 868105 Assign all Not Executed testcases in Phase node when testcases are at all levels P/S/SS using Bulk Assignment dialog
    Given user in testrepository page to create P/S/SS
    And create P/S/SS add test case and clone
    When launch test planning and add phase
    And select phase/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder
    And select system/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder
    Then select subsystem/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder
    And launch test planning  and choose existing phase
    And select phase/bulk assign/assign all notexecuted/assign to lead/seletect subfolder
    And launch test planning  and choose existing phase
    And select system/bulk assign/assign all notexecuted/assign to lead/seletect subfolder
    And launch test planning  and choose existing phase
    Then select subsystem/bulk assign/assign all notexecuted/assign to lead/seletect subfolder
    And should be assigned to test.lead, phase node should not get assigned

  @Assign
  Scenario: 5 868106 Assign all Not Executed testcases in Phase node when testcases are at deep levels(upto 8th level)  P/S/SS using Bulk Assignment dialog
    Given user in repository page to create P/S/SS 8th Level
    And create a P/S/SS add test case upto 8th level
    When create a cycle and add phase to cycle created
    And select Third system/bulk assign/assign all notexecuted/assign to lead/donot seletect subfolder
    And select Fourth system/bulk assign/assign all notexecuted/assign to lead/seletect subfolder
    Then All the nodes including child nodes testcases should be assigned to test.lead

  @Assign
  Scenario: 6 868107 Assign all Not Executed testcases from one user to another user using Bilk Assign Window
    Given user in repository Page to create P/S/SS
    And Create P/S/SS add test cases and clone
    When launch test planning create cycle and add phase to cycle
    And select testcases and assign to different users
    And select Phase/bulk assign/assign all notexecuted/assign to tester/donot seletect subfolder
    And select System/bulk assign/assign all notexecuted/assign to tester/donot seletect subfolder
    And select SubSystem/bulk assign/assign all notexecuted/assign to tester/donot seletect subfolder
    And Launch test planning and choose existing phase
    And Select Testcases and assign to different users
    And Select phase/bulk assign/assign all notexecuted/assign to lead/seletect subfolder
    And Launch Test planning and choose Existing phase
    And Select Testcases and assign to Different users
    And Select system/bulk Assign/assign all notexecuted/assign to lead/seletect subfolder
    And Launch Test planning choose Existing phase
    And Select Testcases and assign To Different Users
    And Select subsystem/bulk assign/Assign all notexecuted/assign to Lead/seletect subfolder
    Then All the nodes including child nodes testcases should be assigned to tester.one

  @Assign
  Scenario: 7 868108 Assign all Unassigned testcases in Phase node when testcases are at all levels P/S/SS using Bulk Assignment dialog
    Given user in repository page to create P/S/SS add testcases
    And create P/S/SS and add test cases and clone
    When launch testplanning create cycle and add phase to cycle
    And Select phase/bulk assign/assign all Unassigned/assign to lead/Donot seletect subfolder
    And Select system/bulk assign/assign all Unassigned/assign to lead/Donot seletect subfolder
    And Select subsystem/bulk assign/assign all Unassigned/assign to lead/Donot seletect subfolder
    And Launch test planning and choose existing phase and save
    And Select phase/bulk assign/assign all Unassigned/assign to lead/seletect subfolder
    And Launch test Planning and Choose existing phase and save
    And Select system/bulk Assign/assign all Unassigned/assign to lead/seletect subfolder
    And Launch test Planning and Choose existing phase and save
    And Select subsystem/bulk Assign/assign all Unassigned/assign to lead/seletect subfolder
    Then All the nodes including child nodes testcases should be Assigned to test.lead

  @Assign
  Scenario: 8 868109 Assign all Unassigned testcases in Phase node when partially assigned testases are at p/s/ss using bulk assignment dialog
    Given User in repository page to create p/s/ss
    And crate p/s/ss add test case and clone
    When Launch testplanning create Cycle and addd phase
    And Select phase assign testcase to different users
    And select system assin all to Anyone
    And Select Phase/bulk assign/assign all Unassigned/assign to lead/seletect subfolder
    When Launch testplanning add phase existing phase and save
    And Select Phase assign testcase to different users
    And select System Assign all to Anyone
    And Select system/bulk assign/assign all Unassigned/assign to lead/Seletect subfolder
    When Launch testplanning add phase Existing phase and save
    And Select Phase assign testcase to Different users
    And select System Assign All to Anyone
    And Select subsystem/bulk assign/assign all Unassigned/assign to lead/Seletect subfolder
    Then only testcases at subsystem should be assigned to TestLead

  @Assign
  Scenario: 9 868110 Assign all assigned but Not Executed testcases in Phase node when testcases are at all levels P/S/SS using Bulk Assignment dialog
    Given User in repository page to create P/S/SS
    And create P/S/SS add Testcase and clone
    When launch testplanning create cycle and add phase To cycle and save
    And select P/S/SS and select All chekbox assign to Anyone
    And select Phase/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder
    And select system/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder
    And select subsystem/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder
    When Launch testplanning select existing phase and save
    And Select P/S/SS and Select All chekbox assign to Anyone
    And select Phase/bulk assin/assign All notexecuted/assign To Lead/select subfolder
    When Launch testplanning Select existing phase and save
    And Select P/S/SS and Select All Chekbox assign to Anyone
    And select system/bulk assin/assign All Notexecuted/assign To Lead/select subfolder
    When Launch Testplanning Select existing phase and save
    And Select P/S/Ss and Select All Chekbox assign to Anyone
    And select subSystem/bulk assin/assign All Notexecuted/assign To Lead/select subfolder
    Then All the nodes including child nodes testcases should be assigned to testLead

  @Assign
  Scenario: 10 868111 Assign all assigned but Not Executed testcases  when testcases are at all levels P/S/SS using Bulk Assignment dialog from one user to another
    Given user in repository page to create P/S/SS
    And create p/s/ss add testcase and clone
    When launch testplanning create cycle and add phase and save
    And select P/S/SS and select All chekbox assign to Anyone/testmanager
    And Select Phas/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder
    And Select syste/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder
    And Select subsyste/bulk assign/assign All notexecuted/assign To Lead/donot seletect subfolder
    When Launch Testplanning Selec existing phase and save
    And Select P/S/SS and Select All chekbox assign to Anyone/Tester.One
    And Select Phas/bulk assin/assign All notexecute/assign To Lead/select subfolder
    When Launch Testplanning Selec Existing phase and save
    And Select P/S/SS and Select All Chekbox assig to Anyone/Tester.One
    And Select system/bulk assin/assign All notexcuted/assig To Lead/select subfolder
    When Launch Testplanning Selec Existing phas and Save
    And Select P/S/SS and Select all Chekbox assig to Anyone/Tester.One
    And Select subsystem/bulk assin/assign All notexecuted/assig To Lead/select subfolder
    Then All the nodes including child nodes testcases should be asigned to test.lead

  @Assign
  Scenario: 11 868112 Assign all assigned but Not Executed testcases testcases are present at few of the nodes
    Given user in repository page To create P/S/SS
    And create P/S/SS Add Testcases Edit and clone
    When Launch Testplanning Create cycle add phase and save
    And select system select few testcases assign to Testmanager
    And Select syste/bulk assin/assign All notexcuted/assig To Lead/select subfolder
    When Launch Testplanning Select Existing phase and save
    Then select P/S/SS asssign all testcases to TestManager
    When Select Phase/bilk assign/assign All notexecuted/assign To Lead/donot seletect subfolder
    And Select system/bilk assign/assign All notexecuted/assign To manager/donot seletect subfolder
    And Select subsystem/bilk assign/assign All notexecuted/assign To Tester/donot seletect subfolder
    Then Assign testcases and view if total and/ Unassigned count display correctly on selected node include sub-folders

  @Assign
  Scenario: 12 868133 As lead/manager assign testcases to anyone and from anyone to different users
    Given user in repository to create Phase
    And create a phase add testcase and clone upto 500 testcases
    When launch test planning create cycle and add phase save and cancel assign popup
    And select all test cases and assign to Anyone
    And select single testcase Assign to manager
    Then select multiple test case assign to Tester One
    Then select single testcase Assin to manager
    And select single testcase Assin to Test Lead
    And select single testcase Assin to TesterOne
    And select single testcase Assin to unassign
    And Select all test cases Assign to Unassign
    Then all the selected testcases should be assigned to Unassign

  @Assign
  Scenario: 13 868144 As Lead, add a phase to the cycle and [Save] default bulk assignments to "Assign individually"
    Given User is in a page of the TestRepository page
    And User creates a phase under the release
    When User creates a testcase under phase
    And User performs the edit operation on testcase
    And User clones the testcase by clicking on the clone button
    Then User is in a page of a TestPlanning page
    And User clicks on create cycle and enter all available fields
    When User creates a phase under a cycle
    Then User chooses assign option
    Then User selects the testcase and chooses a tester in the assignee drop down
    Then User successfully assigns the testcase

  @Assign
  Scenario: 14 868170 As lead/manager add steps to the testcase which is already assigned in test planning
    Given User is in a page of an TestRepository page
    And User creates a phase under release
    When User creates a testcase under an phase
    And User is in a page of the TestPlanning
    And User creates a cycle
    Then User creates the phase
    And User assigns the testcase to anyone
    When User is in a page of an Test Repository page
    When User creates a test steps to the testcase
    Then User successfully creates test steps to the testcase

  @Assign
  Scenario: 15 868134 As lead/manager assign testcases to anyone in test planing after testcases are executed from other tester
    Given User in a page of TestRepository
    And User creates a phase under a node
    When User creates a testcase under Phase
    And User performs edit operation on the testcase
    And User selects the testcase and performs the clone operation
    Then User is in a page of Testplanning page
    And User creates a cycle with all available fields
    When User Creates phase under the test cycle
    Then User is in a page of TestExecution page
    Then User executes the testcases and selects the status drop down
    And User is in a page of Testplanning
    When User selects a phase and clicks on assign
    When User assigns the testcases to anyone
    Then User successfully assigns the testcases

  @Assign
  Scenario: 16 868136 As lead/manager delete testcases at all levels out of test planning after the testcases are executed when assigned to anyone
    Given User is in a page of the TestRepository Page
    And User Creates a Phase under a node
    When User creates a testcase under Phase node
    And User performs the edit operation on the testcase
    And User selects the testcase and performs the clone operation on it
    When User creates a system under a phase
    Then User creates a testcase under a system
    When User performs the edit operation on testcase created
    Then User selects the testcase and performs the clone operation of a testcase
    When User creates the subsystem under a system
    When User creates a testcase and performs the edit operation
    Then User is in the page of a Testplanning
    And User creates a test cycle and enters all the available fields
    When User creates an phase under an test cycle
    Then User navigates to phase and deletes the selected testcase
    When User navigates to the system node and deletes the selected testcase
    When User navigates to the subsystem node and deletes the selected testcase
    Then User successfully deletes the testcases at all levels

  @Assign
  Scenario: 17 868147 As Manager and Lead Assign testcasses simultaneously using  option "Asign all unassigned"  in Bulk Assignment window
    Given User launches a TCC
    When User creates a Phase,system and subsystem and creates a testcases in all the nodes
    And User launches EAS and creates a cycle
    And User creates a phase under an cycle
    And User clicks on the bulk assign button
    And User selects assign all unassigned testcases and selects user from the list and check apply to sub folder option and save
    And As a Lead selects a subsystem in same phase
    And User click on bulk assign
    When User selects assign all unassigned testcases and selects user from the list
    Then Manager and Lead successfully clicks the confirmation box

 @Assign
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Assign
  Scenario: 18 868139 Assign all "unassigned" testcases to anyone when partially assigned testcases are present at different levels p/s/ss using bulk assignment dialog
    Given User is in a page of the testRepository
    And User creates a phase under release node
    When User creates a testcase under the Phase
    And User performs the edit operation to the testcase
    And User performs clone operation of a testcase
    When User creates a system under the phase
    When User creates a Testcase under phase
    When User performs the edit operation of created testcase
    And User performs the clone operation
    When User creates a subsystem under the system
    And User creates a testcase and performs the edit operation on a testcase
    And User performs the clone operation on testcase
    When User is in the page TestPlanning
    And User creates a cycle and enters all available fields
    And User creates a phase under test cycle
    When User assigns the testcases to different users from assign to drop down
    And User selects the system node and chooses Select All and assigns to test.manager
    When User selects a phase node and clicks bulk assignment button
    And User chooses Assign all unassigned testcases to user Anyone from drop down
    When User navigates back to TestPlanning and chooses a existing phase in cycle and save
    And User assigns the testcases to different users from assign to drop down menu
    When User selects the system node and chooses Select All and assigns to Anyone
    And User selects a system node and clicks bulk assignment button
    And User chooses Assign all unassigned testcases to user Anyone from drop down and save
    When User navigates to TestPlanning and selects existing phase and save
    And User assigns the few testcases to different users from assign drop down
    And User selects all testcase in subsystem using Select All and assign to Anyone
    And User selects subsystem and clicks on bulk assignment button
    And User chooses option Assign All unassigned testcases to Anyone and save
    Then User successfully assigns the testcases to anyone at different levels

  @Assign
  Scenario: 19 868137 Assign all "Not Executed" testcases to anyone when testcases are at all levels P/S/SS using Bulk Assignment dialog
    Given User in Repository page to create P/S/SS
    And create P/S/SS and add testcase and clone
    When launch testplanning and create cycle and add phase to cycle
    And Navigate to phase select bulkassignment assign to Anyone
    And Navigate to system select bulkassignment assign to Anyone
    And Navigate to subsystem select bulkassignment Assign to Anyone
    When launch testplanning Add Existing phase to cycle
    And Navigate to Phase select bulkassignment Assign to Anyone
    When launch Testplanning add Existing phase to cycle
    And Navigate to system select Bulkassignment assign to Anyone
    When launch testplanning add Existing phase to cycle
    And Navigate to subsystem select Bulkassignment assign to Anyone
    Then Should Assign all 'Not Executed' testcases at sub-folders to 'Anyone' user

  @Assign
  Scenario: 20 868138 Assign all "unassigned" testcases to anyone when testcases are at different levels p/s/ss using bulk assignement dialog
    Given To create P/S/SS user in repository page
    And create P/S/SS add testcases and clone the testcases
    When launch testplanning create cycle and ad phase to cycle
    And navigate to phase select bulkassign UnAssigned to Anyone
    And navigate to system select bulkassign UnAssigned to Anyone
    And navigate to subsystem select bulkassign UnAssigned to Anyone
    When launch Testplanning Add phase to cycle
    And navigate to Phase select bulkassign UnAssigned to Anyone
    When Launch testplanning Add phase to cycle
    And navigate to system Select bulkassign UnAssigned to Anyone
    When launch testplanning Add phase To cycle
    And navigate to subsystem select Bulkassign UnAssigned to Anyone
    Then Should assign only Unassigned testcases in Phase node including sub-folders

  @Assign
  Scenario: 21 868140 Assign all assigned but "Not Executed" from "Anyone" user to specific tester
    Given user in repository page to create p/s/ss
    And create p/s/ss add testcases and clone
    When launch test planning create Cycle and Add phase to cycle
    And navigate phase assign select all testcases assign to anyone
    And navigate to system and subsystem select all testcases assign to manager
    And Navigate to p/s/ss bulkassinment select assign all unassigned but not-executed assign to Anyone
    When launch test plannig navigate to cycle add phase choose existing phase and save
    And navigate phase Assign select all Testcases assign to Anyone
    And navigate to system and Subsystem select all testcases Assign to TesterOne
    And Navigate to phase bulkassinment select assign all unassigned but not-executed assign to Anyone
    When launch test Plannig navigate to Cycle add phase choose existing phase and save
    And navigate phase Assign select all Testcases assign to anyone
    And navigate to system and Tubsystem select all Testcases Assign To manager
    And Navigate to system bulkassinment select assign all unassigned but not-executed assign to Anyone
    When launch test Plannig navigate To Cycle Add phase Choose existing phase and save
    And navigate phase Assign select All Testcases Assign to AnyOne
    And navigate to system and Subsystem Select all testcases Assign To TesterOne
    And Navigate to subsystem bulkassinment select assign all unassigned but not-executed assign to Anyone
    Then Should assign only assigned and not executed testcases at all levels from 'Anyone' user pool to a Specific tester

  @Assign
  Scenario: 22 868159 As lead/manager unhide a cycle and add/assign phase within cycle
    Given user inrepository page to create phase and add testcases
    And create phase add test cases and clone
    And launch testplanning create cycle and hide and save
    And click on contestmenu un-hide and save
    And Edit the cycle and save
    And navigate to cycle choose existing phase and assign to Anyone
    And navigate to phase select all testcases and assign to Manager/Lead/Tester
    And sync in test planning
    And select the test cases and set/reset the flag
    Then navigate to phase and delete
    And Should be able to delete the hidden cycle

  @Assign
  Scenario: 23 868179 "Bulk Assign" popup should automatically popup in "Assign" if no testcases are assigned
    Given user in testrepository page to create phase
    And create phase and  add four test cases
    When launch testplanning create cycle and add phase to cycle and save
    And launch test planning create Free form and add test cases
    And Launch Assign window for created freeform phase view the Bulk Assign popup
    Then Bulk Assign popup should automatically popup in "Assign" window for normal/freeform phase if no testcases are assigned

  #@Assign//it is move to Sync
  Scenario: 24 868145 simultaneously using option "Asign all assigned but unexecuted" in Bulk Assignment window
    Given logged in with manager user in repository page to create phase
    And create phase add sixteen testcases
    When launch testplanning create cycle add phase to cycle and cancel bulkassign
    And navigate to phase select all testcases and assign to user and donot save
    When logged in with lead user in repository page to create phase
    And create phase add sixteen Testcases
    When launch testplanning create Cycle add Phase to cycle and cancel bulkassign
    And navigate to phase select All testcases and assign to user and donot save
    And simultaniously click on save button
    Then only one Re-Assignment should be saved The user whose assignments are saved should get the confirmation

  @Assign
  Scenario: 25 868169 As lead/manager add a phase node with more than 10k testcases and assign to user
    Given launch testrepository to create a phase
    And create a phase and add TenK testcases to phase
    When launch test planning create a cycle and add phase to cycle and assign to Anyone
    Then Should be able to add phase with Tenk testcases to cycle

  @Assign
  Scenario: 26 868164 Re-assign executed testcase with any value for actual execution time
    Given launch test repository to create phase
    And Create a phase and add test cases to phase
    When launch test planning create cycle and add Phase to Cycle and assign to Anyone
    And launch execution navigate to phase execute and enter actual time for testcases
    And launch test planning navigate to cycle and phase assign to user
    Then Actual time should retain its value

  @Assign
  Scenario: 27 868166 Unassign single/multi-selected testcase with varying values for actual time
    Given Launch test Repository to create phase
    And Create a Phase and Add test cases to Phase
    When launch Test Planning Create cycle and add Phase to Cycle and assign to Anyone
    And Launch execution navigate to phase Execute and Enter Actual time for testcases
    And Launch test Planning navigate to cycle and phase and un-Assign
    Then Actual time Should Retain its value

  @Assign
  Scenario: Logout
    Given User is in the Zephyr ProjectPage_TPE
    When User Clicks on logout Icon_TPE
    And User clicks on Logout Option_TPE
    Then User should be logged out from Zephyr Application Successfully_TPE
