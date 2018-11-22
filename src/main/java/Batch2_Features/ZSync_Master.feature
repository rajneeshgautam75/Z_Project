Feature: Sync_Master

  @Sync_Master
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Sync_Master
  Scenario: 1 868113_As lead/manager add new testcases to phase and sync in Test planning to view newly added testcases
    Given Select the Project For the TestPlanning
    When Click on relese in release summary
    And Launch TestRepository and Create A phase
    Then Navigate to Created Phase and Add Testcase and Edit the Testcase Nmae and Description
    And Select the Added Testcase and Clone it
    When Launch TestPlanning and Create Exicution Cycle
    And Add a Phase in Created Exicution Cycle, Choose Existing Phase, Save it and View the counts
    When Launch TestRepository and Add new Testcase to the Phase
    And Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    And Click on Sync button and Read the Message
    When Launch TestRepository, Navigate to Created Phase and Add System to Phase
    And Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    And Click on Sync button and View the Message
    When Launch TestRepository,Naviagte to Created System and Add Testcase and Edit the Testcase Name and Description
    And Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    And Click on Sync button and View the Message
    When Launch TestRepository,Naviagte to Created Sub_System and Add Testcase and Edit the Testcase Name and Description
    And Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    Then Click on Sync button and View the Message
    And Newly added testcases are Viewed Successfully

  @Sync_Master
  Scenario: 2 868114_As lead/manager add new testcases to already executed phase and sync in Test planning
    Given Select The Project For the TestPlanning
    When Click on Relese in release summary
    And Launch Testrepository and Create A phase
    Then Navigate to created Phase and Add Testcase and Edit the Testcase Nmae and Description
    And Select the added Testcase and Clone it
    When Launch Testllanning and Create Exicution Cycle
    And Add a Phase in Created Exicution Cycle, Choose Existing Phase, Save it and Choose 'Assign to Anyone'
    And Launch TestExicution and Select a Status in Dropdown
    And Launch TestRepository, Navigate to Created Phase and Edit the Testcase Name and Description
    And Launch Testplanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    Then Click on zync button and View the Message
    And New Testcase is added to already exicuted Phase

  @Sync_Master
  Scenario: 3 868115_As Lead/manager add new testcases by adding from imported nodes and view in Test Planning after sync
    Given Select the project For the TestPlanning
    When Click on relese in Release summary
    And Launch TestRepository and create A phase
    Then Navigate to Created phase and Add Testcase and Edit the Testcase Nmae and Description
    And Select the Added TestCase and Clone it
    When Launch TestPlanning and create Exicution Cycle
    And Add a Phase in created Exicution Cycle, Choose Existing Phase, Save it and Choose 'Assign to Anyone'
    Then Launch TestRepository and Create Map
    And Create a Import Job with Choosing File
    And Run the Import Job and View the Status Report
    When Navigate to Imported Folder Select the Imported File and Copy it
    And Navigate to TestPlanning Release and Paste the Imported file in Created Phase
    Then Launch TestPlanning, naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    And Click on Sync button and view the Message
    And Testcase added from imported node is Viewed Successfully

  @Sync_Master
  Scenario: 4 868116_As Lead/manager add new testcases by adding from different nodes and view in Test Planning after sync
    Given Select the Projectone for the TestPlanning
    And Click on relese in release Summary
    When Launch TestRepository and Create a Phase With Nmae and Description
    And Navigate to Created Phase Add Testcase and Edit the Testcase Name and Description
    And Select the Projecttwo for the TestPlanning
    Then Launch TestRepository and Create a Phase with Nmae and DescriPtion
    And Navigate to Created PhasE Add Testcase and Edit the Testcase Name and Description
    When Launch TestPlanning Craete Exicution Cycle
    And Add a Phase in Created exicution Cycle Choose Existing Phase Save it and Choose 'Assign to Anyone'
    And Launch TestRepository Naviagtate to Craeted Phase and ContextClick Select Copy from Other  Projects
    And Expand the Created Project and Release Select a Phase and Drag it  and Drop in the Selected Project
    Then Launch TestPlanning, Naviagate to Dropped Phase and  ContextClick Choose Assign and Cancel the Popup
    And Click on Sync button and View The Message
    When Select 'SampleProject' Select Created Release and Launch it
    And Launch TestRepository and Create a Phase with Nmae and DescriptiOn
    And NavigatE to Created Phase,Add Testcase and Edit the Testcase Name and Description
    And Select the Projectone in Project dropdown and Select Release and Launch it
    Then Launch TestRepository Naviagtate to Craeted Phase and ContextClick Select Copy from Other Projects
    And Expand the Created Project and Release Select a Phase and Drag it and Drop in the Selected Project
    And Launch TestPlanning Naviagate to Dropped Phase and ContextClick Choose Assign and Cancel the Popup
    And Click on Sync button and View The Message
    And Testcases are Added from different Projects successfully

  @Sync_Master
  Scenario: 5 868117_As lead/manager add new nodes from system/sub system to the phase and sync in test planning
    Given Select the ProjectOne for the TestPlanning
    And Click on relese In release summary
    When Launch TestRepository and Create a Phase with Nmae and Description
    And Navigate to Created Phase ADD Testcase and Edit the Testcase Name and Description
    And Select the Added testcase and Clone it
    Then Launch TestPlanning and Create exicution Cycle
    And Add a Phase in Created Exicution cycle Choose Existing Phase Save it and Choose 'Assign to Anyone'
    When Launch TestRepository and Create new Phase with Name and Description
    And Navigate to Created Phase Create new System with Name and Description
    And Navigate to Created System Add Testcase and Edit the Testcase Name and Description
    And Navigate to Created System ContextClick and Select Copy option
    And Navigate to Firstly Created Phase ContextClick and Select Paste option
    Then Launch TestPlanning Naviagate to created Phase and ContextClick Choose Assign and Cancel the Popup
    And Click On Sync button and View the Message
    And Nodes are added to Phase from System Successfully

  @Sync_Master
  Scenario: 10 868122_As lead/manager delete a node in test repository and sync in test planning
    Given Select the ProjectON For the TestPlanning
    When Click on rElese in release summaryY
    And Launch TestRepository and Create a phaseON
    Then Navigate to Created Phase and Add Testcase and edit the Testcase Nmae and Description
    When Select tHe Added Testcase and CloNe it
    Then Launch TestPlanning and Create exieution Cycle
    And Add a Phase in Created Exicution Cycle Choose Existing PhaSe Save it and Choose 'Assign to Anyone'
    When Launch TestRepository, Navigate to Created Phase, ContextClick and Delete the Phase
    And Launch TestPlanning, Navigate to Phase in Exicution Cycle and ContextClick choose Assign and Cancel the Popup
    Then Click on Sync and Select the 'remove the Deleted Node from this Schedule' option, save it and View the Message in last Popup

  @Sync_Master
  Scenario: 11 868123_As lead/manager delete testcases out of test planning and sync with option "Remove the deleted nodes/testcases from this schedule"
    Given Select the Project1 For the TestPlanning
    When Click on rElese in release summAry
    And Launch TestRepository and Create a phase1
    Then Navigate to Created PhAse and Add Testcase and edit the Testcase Nmae and Description
    When Select tHe Added TestCase and Clone it
    And Launch TestPlanning and Create execution Cycle
    And Add a Phase in Created Exicution Cycle, Choose EXisting Phase Save it and Choose 'Assign to Anyone'
    And Select the Testcase by choosing Checkbox and Delete it
    Then sync it by Selecting the option 'Remove the Deleted node' and View Last popup Message
    When Select the Testcase by choosing Checkbox and Delete it
    Then sync it without Selecting the option 'Remove the Deleted node' and View Last popup Message

  @Sync_Master
  Scenario: 12 868124_As lead/manager delete assigned execute/unexecuted testcases out of test planning and sync with/without choosing "Remove the deleted nodes/testcases from this schedule"
    Given Select the ProjecTone For the TestPlanning
    When Click on rElese in releAse summary
    And Launch TestRepository and Create a phasEone
    Then Navigate to Created Phase and Add Testcase and edit the Testcase NmaE and Description
    When Select tHe Added Testcase and ClonE it
    And Launch TestPlanning and CreatE exicution Cycle
    And Add a Phase in Created Exicution Cycle, Choose Existing Phase, Save it and choose 'Assign to Anyone'
    Then Launch TestExicution, choose option in the status dropdown
    When Launch TestPlanning, Naviagate to Phase in the Exicution Cycle and Choose Assign
    And Select a Testcase as, Assigned to 'anyone' and 'not exicuted' statuS and Delete it
    Then sync it by Selecting the oPtion 'Remove the Deleted node' and View Last popup Message
    When Select a Testcase as, Assigned to 'anyone' and 'not exicuted' status and Delete it
    Then sync it without Selecting the Option 'Remove the Deleted node' and View Last popup Message
    When Select a Testcase as, Assigned to 'anyone' and 'exicuted' statuS and Delete it
    Then sync it by Selecting the optIon 'Remove the Deleted node' and View Last popup Message
    When Select a Testcase as, Assigned to 'anyone' and 'exicuted' status and Delete it
    Then sync it without Selecting the option 'Remove the Deleted node' and View Last popup MessagE

  @Sync_Master
  Scenario: 13 868131_As lead/manager delete nodes from cycle
    Given Select the ProjecTonE For the TestPlanning
    When Click on rElese in release summaryy
    And Launch TestRepositoRy and Create a phaseone
    Then Navigate to Created Phase and Add Testcase and edit the TestCase Nmae and Description
    When Select tHe Added Testcase and Clone It
    And Launch TestPlanninG and Create Exicution Cycle
    And Add a Phase in Created Exicution Cycle, Choose Existing Phase, Save It and Choose 'Assign to Anyone'
    Then Navigate to Created Phase in Exicution Cycle, ContextClick and Delete it
    When Add a Phase in Created Exicution Cycle, Choose Existing Phase, save it and Choose 'Assign to Anyone'
    Then Navigate to CreateD Phase in Exicution Cycle, ContextClick and Delete it
    When Launch TestRepository, Navigate to Created Phase, Add Testcase and Edit its Name and Description
    And Navigate to Phase, ContextClick and Add System with Name and Description
    And Navigate to System, Add Testcase and Edit its Name and Description
    Then Launch TestPlanning, Navigate to Phase in Exicution Cycle, ContextClick and Choose 'Assign', Cancel the popup
    When sync it by Selecting the option 'Remove the Deleted node' and View Last popup MessagE
    Then Launch TestPlanning, Navigate to Created Phase in Exicution Cycle, ContextClick and Delete it

  @Sync_Master
  Scenario: 14 868141_As lead/manager, Schedule a Phase, Copy Import Node that has multiple TestCases to the Phase, Sync and assign all testcases to "Anyone" user
    Given Select the ProjectOne For the TestPlanning
    When Click on rElese in Release summary
    And Launch TestReposiTory and Create a phaseone
    Then Navigate to created Phase and Add Testcase and edit the Testcase Nmae and Description
    When Select tHe Added TestCase and Clone It
    Then Launch TestPlanning and Create the Exicution Cycle
    When Add a Phase in Created Exicution Cycle, Choose Existing Phase, Save it and ChooSe 'Assign to Anyone'
    And Launch TestRepository, Click On Import Icon, Create a Map with 'ID change' in Descriminator
    And Create Import Job By Using the Created map
    And Run the Import Job Created
    Then Navigate to Imported Folder and Select the Imported File, Contextclick and Copy it
    When Navigate to Created phase in the Release, Context Click and Paste it
    And Launch TestPlanning, Navigate to Created phase in the Exicution Cycle, ContextClick and Select 'Assign', Cancel the Popup
    And Click on Sync and View the Message in Last Popup
    Then Select 'All Testcases' in the Bulk and Select 'anyone' in the Assign Dropdown

  @Sync_Master
  Scenario: 15 868142_As lead, Delete 1 or more assigned testcases to "Anyone" user in Test Repository, and Sync w/o choosing the option "Remove the deleted nodes/testcases from this schedule"
    Given Select the Projectone For the TestPlanning
    When click on rElese in release summary
    And Launch TestRepositoRy and Create a phaseOne
    Then Navigate to CreatEd Phase and Add Testcase and edit the Testcase Nmae and Description
    When Select tHe Added TestCase and ClOne it
    And Launch TestPlanning and Create exicution cycle
    And Add a Phase in Created Exicution Cycle, Choose ExiSting Phase, Save it and Choose 'Assign to Anyone'
    And Launch TestExicution, choose option in the status Dropdown
    And Launch TestPlanning, Naviagate to Phase in the execution Cycle and Choose Assign
    And Select a Testcase as, Assigned to 'anyone' and 'not exicuted' status and Delete itt
    Then sync it by Selecting the option 'Remove the Deleted node' and View Last popup Messagee
    When Select a Testcase as, Assigned to 'anyone' and 'not exicuted' status and DeletE it
    Then sync it without Selecting the option 'Remove the Deleted node' and View Last popup Mesage
    When Select a Testcase as, Assigned to 'anyone' and 'exicuted' status and DeLete it
    Then sync it by Selecting the option 'Remove the Deleted node' and View Last Popup Message
    When Select a Testcase as, Assigned to 'anyone' and 'exicuted' staTus and Delete it
    Then sync it without Selecting the option 'Remove the Deleted node' and view Last popup Message

  @Sync_Master
  Scenario: 6 868118_As lead/manager sync in test planning when tester add testcase to the phase
    Given Select the ProjectOnE for the TestPlanning
    And Click on rElese in release summary
    When Launch TestRepositorY and Create a Phase with Nmae and Description
    And Navigate to CreatEd Phase Add Testcase and Edit the Testcase Name and Description
    And Select tHe Added Testcase and Clone it
    Then Launch TestPlanning and Create EXicution Cycle
    And Add a phase in Created Exicution Cycle Choose Existing Phase, Save it and Choose 'Assign to Anyone'
    When Login as Tester and Launch TestRepository Navigate to Created Phase, Add Testcase and Logout
    Then Login as Manager/Lead Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    And Click on Sync button and ViEw the Message
    And Add a Phase in Created Exicution Cycle Choose Existing Phase, Save it and Choose 'Assign to Anyone' and Logout
    When Login as Tester in Different Browser and Launch TestRepository, Navigate to Created Phase, Create a System with Name and Description
    Then Browser where login as manager/lead Click on Sync button and View the Message
    When Browser where login as tester Navigate to Created Phase, Add Testcase and Edit its Name and Description and Save it
    Then Browser where login as manageR/lead Click on Sync button and View the Message
    When Browser where login as tester Navigate to Created Phase, Create System with Nmae and Description
    Then Browser where login as managere/lead Click on Sync button and View the Message
    When Browser where login as tester Navigate to Created System, Add Testcase and Edit its Name and Description and Save it
    Then Browser where login as manaGer/lead Click on Sync button and View the Message
    When Browser where login as tester Navigate to Created System, ContextClick and Rename it
    Then Browser where login as Manager/lead Click on Sync button and View the Message

  @Sync_Master
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Sync_Master
  Scenario: 7 868119_As lead/manager sync in test planning when tester copies nodes from different projects
    Given Select the FirstProject for the TestPlanninG
    When Click on relese in release Summaryy
    And Launch TestRepository and Create a Phase with Nmae and Descriptionn
    And Navigate to Created Phase ADd Testcase and Edit the Testcase Name and Description
    Then Select the FirstProject for the TestPlanning
    And Click on relese in releasE summary
    When Launch TestRepository and Create a Phase with Nmae and Descrption
    And Navigate to Created Phase Add TestCase and Edit the Testcase Name and Description
    Then Launch TestPlanning and Create ExicutIon Cycle
    And Add a Phase in Created Exicution Cycle, Choose Existing phase, Save it and Choose 'Assign to Anyone'
    When Launch another Browser and Login as Tester, Launch TestRepository, Naviagtate to Craeted Phase and ContextClick, Select Copy from Other Projects
    And Expand the Created Project and Release, Select a Phase and Drag it and Drop in the Selected Project
    Then Browser where login as manager/lead, Launch TestPlanning, Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    And Click on Sync button aNd View the Message
    When Launch 'SampleProject' and Select Created Release
    And Launch TestRepositOry and Create a Phase with Name and Description
    And Navigate to Created Phase,Add Testcase and Edit the Testcase Name and Description
    And Launch TestPlanning, Naviagate To Created Phase and ContextClick, Choose Assign and Cancel the Popup
    Then Browser where login as Tester, Launch TestRepository, Naviagtate to Craeted Phase and ContextClick, Select Copy from Other Projects
    And Expand the Created Project and Release, Select a Phase and Drag it and Drop In the Selected Project
    And Browser where login as manager/lead, Click on Sync button and View the Message

  @Sync_Master
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Sync_Master
  Scenario: 8 868120_As lead sync in test planning when manager add testcase to the phase
    Given Select the Project For The TestPlaNning
    When Click on relese in Release suMmary
    And Launch Testrepository and Create a phase
    Then Navigate to Created phase and Add Testcase and Edit the Testcase Nmae and description
    And Select the Added Testcase and clone it
    When Launch TestPlanning and CreAte Exicution Cycle
    And Add a Phase in Created ExIcution Cycle, Choose Existing Phase, Save it and View the counts
    And Launch TestRepository and Add new Testcase to the Phase Save it and Choose 'Assign to Anyone'
    Then Login as Tester Launch TestRepository and Navigate to Created Phase, Add Testcase and Logout
    And Login as Manager Launch TestPlanning and Naviagate to Created Phase and ContextClick, Choose Assign and Cancel the Popup
    When Click on Sync button and VIew the Message
    And Add a Phase in Created Exicution CyclE Choose Existing Phase, Save it and Choose 'Assign to Anyone' and Logout
    And Login as Tester in Different Browser and Launch TestRepository Navigate to Created Phase, Create a System with Name and Description
    Then Browser where Logged in as Lead Click on Sync button and View the Message
    When Browser where Logged in as Manager Navigate to System Created and Add testcase edit Name and Description
    Then Browser where Logged in as Lead Click on Sync button and View the Message
    When Browser where Logged in as Manager Navigate to System Created, ContextClick and Create Sub-System with Name and Description
    Then Browser where Logged in as Lead Click on Sync button and View the Message
    When Browser where Logged in as Manager Navigate to Sub-System Created and Add testcase edit Name and Description
    Then Browser where Logged in as Lead Click on Sync button and View the Message
    When Browser where Logged in as Manager Navigate to Sub-System Created, ContextClick and Rename it
    Then Browser where Logged in as Lead Click on Sync button and View the Message
    Then Sync is Successfull while adding testcase in another Browser

  @Sync_Master
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Sync_Master
  Scenario: 9 868121_As lead sync in test planning when manager add testcase from different nodes/projects
    Given Select the ProjectO For the TestPlanning
    When Click on rElese in relEase summary
    And Launch TestRepository and Create a phaseOne
    Then Navigate to Created PhaseOne and Add Testcase and edit the Testcase Nmae and Description
    When Select the ProjectT For the TestPlanning
    When Click on relese in releAse summary
    And Launch TestRepository and CrEate A phaseTwo
    Then Navigate to Created PhaseTwo and Add Testcase and EDit the Testcase Nmae and Description
    When Launch TestPlanning and Create Exicution cycle
    And Add a PhaseOne in CreatEd Exicution Cycle, Choose Existing Phase, Save it and Choose 'Assign to Anyone'
    And In Other Browser login as Manager Launch TestRepository and Navigate to Created Phase and ConteXtClick Select 'copy from projects'
    And Expand the Created Project and ReleasE Select a Phase and Drag it and Drop in the Selected Project
    Then In first Browser Launch TestPlanning Naviagate to Dropped Phase and ContextClick Choose Assign and Cancel the Popup
    And Click on Sync button and View the message
    When Select 'Sample Project' in project DropDown and select Release in Release Summary
    And Launch TestRepository Create a PhaseThree
    And Navigate to Created phaseThree Add Testcase and Edit its name and Description
    Then Launch TestPlanning Select PhaseOne ContextClick and select Assign
    When In Other Browser login as Manager Launch TestRepository and Navigate to Created Phase and ContextClick, Select 'copy from projects'
    And Expand the Created Project and Release Select a Phase and drag it and Drop in the Selected Project
    Then In first Browser Click on Sync button and View the message
    And Sync is Successfull when other user adds Testcase in other node/projects

  @Sync_Master
  Scenario: Login
    Given User Selects the Browser, Launches it and Maximises it_TPE
    When User Navigates to the URL provided_TPE
    And User Enters Username, Password and clicks on login_TPE
    Then User should be Logged in into Zephyr Successfully_TPE

  @Sync_Master
  Scenario: 16 868145 simultaneously using option "Asign all assigned but unexecuted" in Bulk Assignment window
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

  #@Sync_Master
  #Scenario: Logout
    #Given User is in the Zephyr ProjectPage_TPE
    #When User Clicks on logout Icon_TPE
    #And User clicks on Logout Option_TPE
    #Then User should be logged out from Zephyr Application Successfully_TPE
