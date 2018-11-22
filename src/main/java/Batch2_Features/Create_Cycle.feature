Feature: Create Cycle_Master

@Create_Cycle
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


  #Passs
  @Create_Cycle
  Scenario: 1 868095 As Manager/Lead, create a Test Cycle with all fields available
    Given User is in test planning page
    When user click on add test cycle symbol
    Then test cycle page should displayed
    When user enter data in all fields and click on save
    Then test cycle should be created successfully

  #Passs
  @Create_Cycle
  Scenario Outline: 2 868096 As Manager/Lead, create a Test Cycle name with different characters
    Given User is in test planning page
    When user clicks on add test cycle symbol
    Then test cycle page should be displayed
    When user enter test cycle name "<testcycle>" with different data	and save it
    Then test cycle "<testcycle>" should be created with all supported character

    Examples: 
      | testcycle                                                                                                                      |
      | Cycle1                                                                                                                         |
      | @#$%^*!&()                                                                                                                     |
      | adb13443                                                                                                                       |
      |                                                                                                                        1234567 |
      | ABHGFDR                                                                                                                        |
      | AmitabhHarivanshRaiShrivastavaBachchanisanIndianfilmactorHefirstgainedpopularityintheeayformovieslikeZanjeerandDeewaarkudhekfr |

  #Passs
  @Create_Cycle
  Scenario: 3 868097 As Manager/Lead create cycle with multiple start and end date range
    Given User is in test planning page
    When user clicks on add test cycle symbol
    Then test cycle page should be displayed
    When user enter data in all fields
    And enters the start date and end date within release test planning date range
    And click on save
    Then test cycle should be created
    When user clicks on add test cycle symbol
    Then test cycle page should be displayed
    When user enter data in all fields
    And enters the start date and end date within project date range
    And click on save
    Then test cycle should be created
    When user clicks on add test cycle symbol
    Then test cycle page should be displayed
    When user enter data in all fields
    And enters the same start date and end date
    And click on save
    Then test cycle should be created
    When user clicks on add test cycle symbol
    Then test cycle page should be displayed
    When user enter data in all fields
    And enters the same start date and end date with multiple month span
    And click on save
    Then test cycle should be created
    When user clicks on add test cycle symbol
    Then test cycle page should be displayed
    When user enter data in all fields
    And enters the same start date and end date with a difference of few days
    And click on save
    Then test cycle should be created

  #P
  #Passs
  @Create_Cycle
  Scenario: 4 868143 As lead/manager create a cycle with only mandatory fields
    Given User is in test repository page
    When User Add a phase with name and description
    And Add a test case to the phase
    Then test case should be added to the phase
    And edit the test case name from detail view
    And clone the created test case
    Then test case should be cloned
    When user navigate to test planning page
    And click on add test cycle option
    Then Add test cycle page should be displayed
    When user enters the name,start date and end date and save it
    Then new test cycle Should be created

  #Passs
  @Create_Cycle
  Scenario: 5 868098 As Manager/Lead edit the cycle fields
    Given User is in test planning page
    When user clicks on add test cycle symbol
    Then test cycle page should be displayed
    When user enters the values in all fields and save it
    Then new test cycle should be created
    When user click on context menu across cycle and edit the cycle name and save it
    And user click on context menu across cycle and edit the cycle build and save it
    And user click on context menu across cycle and edit the environment and save it
    And click on on context menu across cycle and edit the cycle start date and save it
    And click on on context menu across cycle and edit the cycle end date and save it
    Then test cycle should be edited successfully

  #Passs
  @Create_Cycle
  Scenario: 6 868100  Adding different phases to cycle
    Given User is in project page
    When user selects the release
    And click on test repository
    And click on context menu across release and create a phase with name and description
    And navigate to created phase and add a test case with name and description
    Then test case should be added to the Phase
    When user click on test planning module
    And create a test cycle with all fields and save it
    And navigate to created cycle and Add a phase by choosing existing phase and save it
    #And navigate to created cycle and Add a phase by choosing existing phase and save it
    Then phase should be created under cycle
    When click on test repository
    And click on option across release and create a phase with long name and description
    And navigate to the created long name phase and add a test case with name and description
    Then test case should be added to the Phase
    When user click on test planning module
    And select the created test cycle and Add a phase by choosing existing long name phase and save it
    Then phase with long name should be added to the test cycle
    When click on test repository
    And click on option across release and create a phase with special character and save it
    And navigate to the Created special character phase and add a test case with name and description
    Then test case should be added to the Phase
    When user click on test planning module
    And select the created test cycle and Add a phase by choosing existing special character phase name and save it
    Then special character phase should be added to the test cycle
    When click on test repository
    And click on option across release and create a phase with alphanumeric character and save it
    And navigate to the created alphanumeric phase and Add a test case with name and description
    Then test case should be added to the Phase
    When user click on test planning module
    And select the created test cycle and Add a phase by choosing existing alphanumeric character phase name and save it
    Then alphanumeric phase should be added to the test cycle
    When click on test repository
    And click on option across release and create a phase with numbers character and save it
    And navigate to the created numbers character phase and Add a test case with name and description
    Then test case should be added to the Phase
    When user click on test planning module
    And select the created test cycle and Add a phase by choosing existing numbers character phase name and save it
    Then phase(numbers) should be added to the test cycle
    When click on test repository
    And click on option across release and create a phase with Capital letters and save it
    And navigate to the created capital letters phase and Add a test case with name and description
    Then test case should be added to the Phase
    When user click on test planning module
    And select the created test cycle and Add a phase by choosing existing Capital letters phase name and save it
    Then phase(Capital letters) should be added to the test cycle

  #passs
  @Create_Cycle
  Scenario: 7 868157 As lead/manager clone a visible cycle and hide it
    Given User is in test planning page
    When User click on create test cycle and enters all available fields and check hide option
    And click on test cycle option and clone it and save
    And click on create test cycle symbol and enters all available fields and save it
    And click on test cycle and a phase to the test cycle and choose option assign individually and save it
    And click on context menu across cycle and choose clone option and save it
    And click on context menu across cloned test cycle and check hide option and save it
    Then should be able to hide a cloned cycle

  #Passs
  @Create_Cycle
  Scenario: 8 868101 Add a phase to cycle with multiple nested nodes
    Given user is in project page
    When user selects the release
    And click on test repository
    And click on context menu across release and create a phase with Name and description
    And Add a test case with name to the created first node
    Then test case should be added to the node
    When click on context menu across created phase and create a node with Name and description
    And Add a test case with name to the created second node
    Then test case should be added to the node
    When click on context menu across created second node and create another node with Name and description
    And Add a test case with name to the created third node
    Then test case should be added to the node
    When click on context menu across created third node and create another node with Name and description
    And Add a test case with name to the created fourth node
    Then test case should be added to the node
    When click on context menu across created fourth node and create another node with Name and description
    And Add a test case with name to the created fifth node
    Then test case should be added to the node
    When click on context menu across created fifth node and create another node with Name and description
    And Add a test case with name to the created sixth node
    Then test case should be added to the node
    When click on context menu across created sixth node and create another node with Name and description
    And Add a test case with name to the created seventh node
    Then test case should be added to the node
    When click on context menu across created seventh node and create another node with Name and description
    And Add a test case with name to the created eighth node
    Then test case should be added to the node
    When click on context menu across created eighth node and create another node with Name and description
    And Add a test case with name to the created ninth node
    Then test case should be added to the node
    When user Launch test planning
    And create a new test cycle with all available fields
    And click on context menu across created cycle and add a created nested phase by choosing existing phase and save it
    Then nested phase should be added to the test cycle

  #Passs
  @Create_Cycle
  Scenario: 9 868158 As lead/manager delete a hidden cycle
    Given User selects the project and release
    When User navigates to test planning module
    And click on create new test cycle symbol
    Then create test cycle page should be displayed
    When user enters the data for all fields and check hide option and save it
    And navigate to created cycle and uncheck the hide option and save it
    And navigate to modified cycle and delete it
    Then test cycle should be deleted successfully
    When user launch test repository
    And add a phase to the release and add test case to the phase
    Then test case should be added successfully
    When user navigates to the test planning page
    And creates a new cycle and add created phase to the cycle and choose option assign to anyone and save it
    And click on created cycle and check the hide option,save it and delete it
    Then hidden cycle should be deleted successfully
    When user navigates to the test repository page
    And creates a multiple phase to the release and add test case to each phase
    And launch test planing page
    And creates a new cycle by entering all fields and save it
    And add multiple phase to to the cycle and assign the few testcase
    And navigates to the test planning page and selects the created cycle
    And check the hide option and delete the test cycle
    Then hidden Test cycle should be deleted successfully

  @Create_Cycle
  Scenario: 10 868130 Edit the fields in the "clone cycle" window at the time of cycle clone
    Given User selects the normal project and release
    When User click on test repository page
    And click on context menu across release and creates a phase with Name and description
    And Add a test case with name to the created first node and clone it
    Then test case should be cloned to the node
    When click on context menu across created phase and create a another node with Name and description
    And Add a test case with name to the created second node and clone it
    Then test case should be cloned to the second node
    When click on context menu across created Second node and create another node with Name and description
    And Add a test case with name to the created third node and clone it
    Then test case should be cloned to the third node
    When click on context menu across created Third node and create another node with Name and description
    And Add a test case with name to the created fourth node and clone it
    Then test case should be cloned to the fourth node
    When click on context menu across created Fourth node and create another node with Name and description
    And Add a test case with name to the created fifth node and clone it
    Then test case should be cloned to the fifth node
    When click on context menu across created Fifth node and create another node with Name and description
    And Add a test case with name to the created sixth node and clone it
    Then test case should be cloned to the sixth node
    When click on context menu across created Sixth node and create another node with Name and description
    And Add a test case with name to the created seventh node and clone it
    Then test case should be cloned to the seventh node
    When click on context menu across created Seventh node and create another node with Name and description
    And Add a test case with name to the created eighth node and clone it
    Then test case should be cloned to the eighth node
    When User clicks on test planning module
    And creates a new Cycle(C1) with all available fields and save it
    And navigate to created cycle and add a phase by choosing existing phase and asssign to anyone
    And navigate to the phase and selects all test case and set the flag
    And clicks on test planning module and selects the created cycle
    And clone it and edit the name,build,environment and check the keep duration fixed option
    Then test cycle should be Cloned Successfully
    When user navigates to Cycle(C1) and clone it and edit the start date to one week ahead with duration fixed and save it
    And user navigates to Cycle(C1) and clone it and edit the start date to one week back with duration fixed and save it
    And user navigates to Cycle(C1) and clone it and edit the start date and end date within few days and save it
    Then Test Cycle Should be Cloned Successfully

  #Passs
  @Create_Cycle
  Scenario: 11 868154 As lead/manager edit hidden cycle and make it visible
    Given User select the project and release
    When user launch test planning
    And create a test cycle with all available fields and check the hide option and save it
    And select the test cycle and uncheck the hide option
    Then test cycle should be visible

  @Create_Cycle
  Scenario: 12 868129 Clone a cycle with single or multiple phases with assigned/unassigned testcases
    Given user is in project page
    When User selects the release
    And launch test repository and add a phase with name and description
    And navigate to newly created phase and add a test case with name
    Then test case should be added
    When user selects the test case and clone it
    Then test case should be cloned Sucessfully
    When user click on option across release and add a phase with name and description
    And user click on option across release and add another phase with name and description
    And click on newly created phase and adds a test case with name
    And selects the test case and cloned it
    Then test case should be cloned sucessfully
    When user launch test planning module
    And creates test cycle with all available fields and save it
    And navigate to created cycle and add a phase by choosing existing phase and assign to anyone and save it
    And selects the test cycle and cloned it
    Then test cycle should be created with test case unassigned
    When navigate to test cycle and select clone option and check the testcase assignments over option
    Then test cycle should be created with test case assigned
    When user launch test planning and create a test cycle with all fields
    And user click on option across cycle and add phase by choosing existing phase
    And click on created test cycle and clone it
    Then test cycle should be cloned with empty phase
    When user click on test planning and create a test cycle with all availabe fields
    And click on test cycle and add phase by choosing existing phase and assign to anyone
    And click on test cycle and add a phase by choosing existing phase and save it and cancel the popup
    And select the test cycle and clone it
    Then test cycle should be cloned with same name but test case unassigned
    When user selects the test cycle and clone it and select the copy testcase assignments over option
    Then new cycle created with same name as before but with testcases assigned in parent cycle

  #Passs
  @Create_Cycle
  Scenario: 13 868132 As lead/manager delete cycle
    Given User is in the test repository page of normal project
    When user Add a first phase with name and description
    And navigates to the created first node and add a test case with name
    And selects the test case and clone it
    Then test case should be cloned successfully
    When user creates second node with name and description
    And navigates to the created second node and add a test case with name
    And selects the test case and clone it
    Then Test Case Should be cloned Sucessfully
    When user launch test planning module and create a new cycle with all available fields and save it
    And navigate to the created cycle and add first phase and choose assign to anyone and save it
    And navigate to the created cycle and delete it
    Then test cycle should be deleted sucessfully
    When user launch test planning and creates a second test cycle with all available fields and save it
    And navigate to the created second cycle and add first phase and choose assign to anyone and save it
    And navigate to the created second cycle and add second phase and choose assign to anyone and save it
    And navigate to the created second cycle and add first phase and cancel the assign popup window
    And navigate to the second cycle and delete it
    Then test cycle should be deleted with multiple phases

  #Passs
  @Create_Cycle
  Scenario: 14 868153 As lead/manager create and edit hidden cycle
    Given User is in test planning page
    When user click on create new cycle symbol s
    Then Add new cycle page should be displayed
    When user Creates a new Cycle with all available fields,check the hide option and save it
    Then should be able to create the hidden cycle
    When user creates second Cycle with a difference of two/three days between start date and end date and check the hide option and save it
    Then second cycle should be created successfully
    When user creates third cycle with a diff of two week between start date and end date,check the hide option and save it
    Then third cycle should be created successfully
    When user creates fourth cycle with a diff of six month between start date and end date,check the hide option and save it
    Then fourth cycle should be created successfully
    When user creates fifth cycle  with a diff of two years between start date and end date, check the hide option  and save it
    Then fifth cycle should be created successfully
    When user navigates to the  first cycle and modify the name/build/environment/start date and end date and save it
    Then first cycle should be modified successfully

  #Added
  @Create_Cycle
  Scenario: 15 868156_As lead/manager clone a hidden cycle
    Given User is in a Test planning page
    And User creates a cycle with the available fields and check hide option and save
    When User clicks on cycle context menu and clicks on clone option and save
    When User creates a test cycle with available fields and save
    And User creates a phase by choosing an existing phase and save
    And User chooses assign individually and save
    When User navigates to a cycle and check hide option and save
    And User clicks on clone option and checks Also copy testcase assignments over and save
    When User creates a cycle with available fields and save
    And User creates a phase by choosing an existing phases
    When User navigates to a cycle and check hide button and save
    And User clicks on clone and checks Also copy testcase assignments over and save
    When User clicks on context menu across cycle and click on clone and edit the fields and save
    Then User successfully clone the cycle

  @Create_Cycle
  Scenario: 16  868099 Create multiple cycles across relTest planninges
    Given User selects the first project from project drop down and also chooses first release
    When User launches TestPlanning
    And User creates a cycle and enters all the available fields and save
    And User again creates a cycle and enters same previous available values and save
    When User selects the first project and chooses second release
    And User launches TestPlanning and creates a cycle with the available fields and save
    When User again creates a cycle and provides same previous values and save
    And User switch between releases under the project and view cycles created in different releases
    When User selects the second project and chooses the release
    When User launches TestPlanning and creates a new cycle with all available fields and save
    And User again creates a cycle and provides same previous available values and save
    Then User successfully creates cycles in second project

  @Create_Cycle
  Scenario: 17 868155 As lead/manager edit hidden cycle and make it visible
    Given User is in a page of an test repository
    And User Creates a Phase and creates a testcase under the phase
    And User performs the edit operation for the testcase
    And User enters the step details and save
    And User performs the clone operation of a testcase
    When User creates a cycle in TestPlanning and enters the available fields
    And User creates a phase by choosing an existing Phase and save
    When User individually assigns the testcase to anyone
    And User navigates to testPlanning and selects a cycle and clicks edit and check hide button
    When User creates a phase and creates a testcase and performs the edit operation
    And User performs the clone operation for the testcase
    When User creates a second cycle and enters the available fields and save
    And User creates a phase by choosing an existing phase and click on save
    And User cancels the bulk assignment popup
    And User selects few testcases and assigns to anyone
    When User is in a page TestExecution and execute few testcases by selecting status drop down
    When User navigates to TestPlanning and selects second cycle and select edit and check hide option and save
    When User creates a twenty phases with few testcases each phase
    When User creates a third cycle with all the available fields and save
    And User creates a twenty phases by choosing an existing phases
    When User navigates to TestPlanning and selects third cycle and select edit and check hide
    When User creates a phase within a phase upto 8th leavel
    When User creates a cycle with all the available fields and save
    And User creates a phase by choosing an existing phase with upto 8th level
    And User navigates to TestPlanning and selects a third cycle and select edit and check hide and save
    Then User successfully edit and hidden a cycle

#Pass
   @Create_Cycle
  Scenario: 18 868171 Clone the cycle when Defect is linked the the Execution
    Given user in repository Page to create Phase and add Testcases
    And crate a phase and add testcases to phase
    When launch test planning create cyccle add phase to cycle and assign to Anyone
    And launch test Execution and Execute the Testcses
    And link the defect to the testcases
    And launch testplanning and clone the cycle
    And view the execution in the cloned cycle

  #Update Step
  @Create_Cycle
  Scenario: 19 868200 Clone a cycle with single or multiple free form phases with assigned/unassigned testcases
    Given launch testrepository page to create phase
    And create a phase and add testcases
    When launch test planning create cycle and assign to Anyone
    And launch test execution navigate to phase and execute the testcases
    And link the Defect across the testcases
    When launch testplanning navihate to cycle and add freeform phase
    And navigate to freeform phase launch add tesrcases and launch other cycles
    And select a phase and cycle with different status and add to freeform phase
    When launch testplanning navigate to cycle and add freeform phase
    And navigate to freeform phase launch add testcases launch browse
    And select phase add test cases to freeform phase and assign to Anyone
    When launch test execution navigate to second free form phase execute testcases
    And launch testplanning navigate to cycle and click on edit check the hide option
    When launch testplanning navigate to cycle and click on edit uncheck the hide option
    And launch testplanning navigate to cycle clone cycle
    Then cycle should be cloned along with free form phases

   @Create_Cycle
  Scenario: 20 868173 clone the cycle on client machine if Server and client are in different time-zone.
    Given user in testrepository page to create phase and add testcases
    And create two phases and add four testcases for each
    When launch test planning create cycle and add phase one to cycle
    And clone the cycle
    Then Should able to clone the cycle

   @Create_Cycle
  Scenario: 21 868174 Create cycle with start date same as project start date
    Given user in release page to create project
    And create a project with Start and end date
    When create a cycle with project startdate and End date
    Then should able to create cycle

  @Create_Cycle
  Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE