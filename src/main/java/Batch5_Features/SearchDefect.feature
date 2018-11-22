
Feature: Search Scenrio

@Search_Defect1
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


@Search_Defect
 Scenario: 1 Login as Manager and set the DTS to JIRA, Verify Webhook id in Defect Tracking System database table.

    Given Login as admin user
    When admin navigate to System Configuration of administration Page
    And save zephyr URL to desktop URL
    Then desktop url should be saved successfully
    When user navigate to defect Tracking System Page
    Then user successfully navigated to DTS Page
    When set the Defect Tracking System to Jira
    
    Then able to set the DTS to Jira
    When user open the external Jira Page
    And navigate to Webhooks page of Jira administration
    Then verify the new webhook will be created with ZEE ip
    When switch back to ZEE application and refresh the page
    And navigate to Defect Tracking Page and enter valid credentials and save it




@Search_Defect
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


@Search_Defect
Scenario: 8 Search defect/subtask by basic/advance search
Given User is in Defect Tracking page
 When User search a defect by entering project name
 Then Should be able to search the defect
 When User search a defect by entering project name and issue type
 Then Should be able to Search defect
 When User search a defect by entering project name,issue type and status
 Then Should be able to search a defect
 When User search a defect by project name and version
 Then Should Be able to search
 When User search a defect by selecting assignee from dropdown
 Then Should be Able to search the defect
 When User search a defect by project name and priority
 Then Shoulb be aBle to search
 When User search a defect by the filed by
 Then Should be abLe to search
 When User search a defect by project name/issue type/status/version/assignee/priority/filed by
 Then Should be ablE to search
 When User search a defect by jira id
 Then Should be able To search
 When User attempt search a defect by jira id which is non existing
 Then Should not be able to search
 When User search a defect by its id using advanced search
 Then Should be able tO search
 When User search a defect by using JQL
 Then Should be able to Search
 When search a defect by filter using advanced search
 Then Should be able to sEarch
 When search a non existing defect by using advanced search
 Then Should Not be able to search

@Search_Defect
Scenario: 9 Search defect/subtask by ID
Given User is in TestRepository page
 When User create a phase
  And Create testcases
  And Create a cycle in TestPlanning
  And Add the phase by choosing phase
  And Launch TestExecution and execute a testcase with status pass
  And click on defect button and select JQL
  Then Should be able to search
  Then Should be able to link a defect
 When click on D button and select my filter and select filter from dropdown
 Then Should be able to search and Link a defect
 When click on defect and select non existing defect id and attempt search for defect
 Then ShOuld not be able to search


#@Search_Defect
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
#@Search_Defect
#Scenario: 76 Search defect, If user doesn't have create defect permission
#Given As a manager,Launch administration page
 #When launch the defect tracking system
  #And Set the DTS To JIRA
 #Then Should be able to set DTS To JIRA
 #When launch external jira page
  #And change create defect permission to the defect user
 #When As a Lead,launch defect tracking page
 #Then Should be able to launch Defect tracking page
 #When reset the external DTS login detail
 #When search a defect by ID defect tracking app
 #Then Should able to search the defect
 #When search a defect by JQL in DT app
 #Then Should able to search defect
 #When search a defect by filter in DT app
 #Then Should able to search Defect
 #When launch the test execution page
  #And search a defect by ID test execution app
 #Then Should able to Search the defect in test execution
 #When search a defect by JQL in test execution app
 #Then Should able to search defect in test execution
 #When search a defect by filter in test execution app
 #Then Should able to Search Defect in test execution 
#

 @Search_Defect 
      Scenario: 82 Search defect which is linked to execution and view cycle and test case in search grid in defect tracking app
      Given user will be in a test Repository app
      When user creates a phase ,node and subnode 
      And user adds testcase to all three levels of nodes
      Then testcase is successfully added to all three levels of nodes
      When user navigates to Test Planning app
      And user creates a cycle by entering all details
      Then cycle created is validated successfullys
      When user clicks on test cycle and assign the phase 
      And user will assign bulk assignment to user
      Then assign testcase to user is successfully validated of all three level nodes
      When user naviagtes to test Execution page
      And user selects all three level nodes and changes the status 
      Then status changes of all three nodes must be validated successfully
      When user clicks on D icon button and will search the defect and links all three level nodes testcases
      Then linked testcase of all three level node must be validated successfully
      When user navigates to DT page
      And user searches for the defectID and clicked on seacrched button
      Then user Search linked defect at phase,node,subnode and also must view cycle and testcase in search grid in defect tracking app
      

 @Search_Defect
Scenario: 83 <DT> Click on testcase ID in defect tracking search grid
Given User is in Project page
 When User is In TestRepository page
 Then Should be able to launch testrepository
 When User create a phase with testcases
 Then Should be able to create testcases in a phase node
 When User create a node with testcases for phase
 Then Should be able to create testcases in a node
 When User create a subnode with testcases for node
 Then Should be able to create testcases in a subnode
 When User launch testPlanning
 Then Should be able to launch testplanning
 When create a cycle and add phase to cycle and assign testcases
 Then Should be able to assign testcases in phase node
 When navigate to the system node and assign testcases
 Then Should be able to assign testcases in system node
 When navigate to the subsystem node and assign testcases
 Then Should be able to assign testcases in subsystem node
 When launch Test execution page
 Then Should be able to launch test execution page
 When navigate to the phase and execute testcase
  And click on D button and link a defect to execution
 Then Should be able to link defect to the executed testcase in phase node
 When navigate to the system and execute testcase
 Then Should be able to link defect to the executed testcase in system node
 When navigate to the subsystem and execute testcase
 Then Should be able to link defect to the executed testcase in subsystem node
 When launch Defect tracking page
  And search a defect which is linked at phase
 Then Should be able to view cycle and testcase in search grid in DT app for phase level
 When search a defect which is linked at system node
 Then Should be able to view cycle and testcase in search grid in DT app for system level
 When search a defect which is linked at subsystem node
 Then Should be able to view cycle and testcase in search grid in DT app for subsystem level
 


@Search_Defect
Scenario: 145 <DT> Search issues with "OR" operator in JQL
Given User is in The defect Tracking page
 When User search a issue with OR operator
 Then Should be search issues with OR operator
 When User Launch requirements page and search a issue with OR operator
 Then Should be able to search issue with OR operator
 When User Launch Test Execution to Search a Issue
  And search a issue with OR operator
 Then Should be able to search a issue OR operator
 
    
@Search_Defect
Scenario: 146 <DT> Search issues with "IN" operator in JQL
Given User is in the page defectTracking
 When User search a issue with IN operator
 Then Should be able to search issues with IN operator
 When User Launch requirements and search a issues with IN operator
 Then Should be able to search issues with IN Operator
 When User Launch Test Execution to Search a issues
  And search a issues with IN operator 
 Then Should be able to search a issues with IN operator

@Search_Defect1
Scenario: 147 <DT> Search issues with "NOT IN" operator in JQL
Given User is in the page DefectTracking
 When User search a issue with NOT IN operator
 Then Should be search issues with NOT IN operator
 When User Launch requirements and search a issue with NOT IN operator
 Then Should be able to search issue with NOT IN operator
 When User Launch TestExecution to Search a Issue
  And search a issue with NOT IN operator
 Then Should be able to search a issue with NOT IN operator

@Search_Defect
Scenario: 148 <DT> Search issues with "IS" operator in JQL
Given User is in the page defect Tracking
 When User search a issue with IS operator using JQL
 Then Should be search issues with IS operator using JQL
 When User launch the page requirements and search a issue with IS operator using JQL
 Then Should be able to search issue with IS operator using JQL
 When User Launch TestExecution to Search a issue
  And search a issue with IS operator using JQL
 Then Should be able to search a issue with IS operator JQL
 
@Search_Defect
Scenario: 150 <DT> Search issues with "IS NOT" operator in JQL
Given User is in the page of Defect Tracking
 When User search a issue with IS NOT operator using JQL
 Then Should be search issues with IS NOT operator using JQL
 When User launch requirements and search a issue with IS NOT operator using JQL
 Then Should be able to Search issue with IS NOT operator using JQL
 When User launch TestExecution to search a issue
  And search a issue with IS NOT operator using JQL
 Then Should be able to search a issue with IS NOT operator using JQL

@Search_Defect
Scenario: 151 <DT> Search issues with "=" operator in JQL
Given User is in The defect Tracking
 When User search a issue with equals operator using JQL
 Then Should be search issues with equals operator using JQL
 When User launch requirements and search a issues with equals operator using JQL
 Then Should be able to Search issues with equals operator using JQL
 When User launch TestExecution to search the issue
  And search a issues with equals operator using JQL
 Then Should be able to search a issue equals operator using JQL

@Search_Defect
Scenario: 152 <DT> Search issues with "!=" operator in JQL
Given User is in The Defect Tracking
 When User search a issue with not equals operator using JQL
 Then Should be able to search issues with equals operator using JQL
 When User launch requirements and search a issue with equals operator using JQL
 Then Should be able to Search issue not equals operator using JQL
 When User Launch Test Execution to search a issue
  And search a issue with equals operator using JQL
 Then Should be able to search a issue not equals operator using JQL
 
@Search_Defect
Scenario: 153 <DT> Search issues with "ORDER BY" operator in JQL
Given User is in The Page defect Tracking
 When User search a issues with ORDER BY operator using JQL
 Then Should be search issues with ORDER BY operator using JQL
 When User launch requirements and search a issues with ORDER BY operator
 Then Should be able to Search issue ORDER BY operator
 When User Launch TestExecution to search the issues
  And search a issues with ORDER BY operator using JQL
 Then Should be able to search a issue ORDER BY operator using JQL
 
@Search_Defect
Scenario: 154 <DT> Search issues with "ASC" operator in JQL
Given User is in the Defect Tracking page
 When User search a issue with ASC operator using JQL
 Then Should be search issues with ASC operator using JQL
 When User launch requirements and search issues with ASC operator using JQL
 Then Should be able to Search issue ASC operator using JQL
 When User Launch the TestExecution to search The issues
  And search a issues with ASC operator using JQL
 Then Should be able to search a issue ASC operator using JQL
 
@Search_Defect
Scenario: 155 <DT> Search issues with "DESC" operator in JQL
Given User is In the DefectTracking page
 When User search a issues with DESC operator using JQL
 Then Should be search issues with DESC operator using JQL
 When User launch requirements and search a issues with DESC operator using JQL
 Then Should be able to Search issues with DESC operator using JQL
 When User launch TestExecution to search The Issues
  And search the issues with DESC operator
 Then Should be able to search issues with DESC operator 

@Search_Defect
Scenario: 156 <DT> search defects by filter, If filter name contains upper case letters
Given User is in the DefectTracking Page
 Then Should be able to launch defect tracking
 When User click on advance link
 Then Should be able to go to advance search page
 When User select the filter option
 Then Should be able to select filter
  And User select the uppercase filter
 Then Should be able to select uppercase filter
 When User click on search button
 Then Should be able to search defects

@Search_Defect  
Scenario: 157 <DT> search defects by filter, If filter name contains number
Given User is in the Defect_Tracking Page
 Then Should be able to Launch defect tracking
 When User click on the advance link
 Then Should be able to go to Advance search page
 When User select the filter option as myfilter
 Then Should be able to select the filter
  And User select the number filter
 Then Should be able to select number filter
 When User click on a search button
 Then Should be able to Search defects

@Search_Defect
Scenario: 158 <DT> search defects by filter, If filter name contains special chars
Given User is in the page of Defect_Tracking
 Then Should be able to Launch DefectTracking
 When User Click on the advance link
 Then Should be able to go to the Advance search page
 When User Select the filter option as myfilter
 Then Should be able to select the myFilter
  And User select the filter name contains special character
 Then Should be able to select special character filter
 When User Click on a search button
 Then Should be able to search defects for special character filter

@Search_Defect
Scenario: 159 <DT> search defects by filter, If filter name contains alpha numeric chars
Given User is in the page of a Defect_Tracking
 Then Should be able to Launch Defect_Tracking
 When User Click on the Advance link
 Then Should be able to go to the Advance Search page
 When User Select the filter option as myFilters
 Then Should be able to select the MyFilters
  And User select the filter name contains alpha numeric character
 Then Should be able to select alpha numeric character filter
 When User Click on a Search button
 Then Should be able to search defects for alpha numeric character filter         
 
@Search_Defect
Scenario: 160 <DT> search defects by filter, If filter name contains international chars
Given User is in the page of an Defect_Tracking
 Then Should be able to Launch the Defect_Tracking
 When User Click on the Advance Link
 Then Should Be able to go to the Advance Search page
 When User Select The filter option as myFilters
 Then Should Be able to select the MyFilters
  And User select the filter name contains international character
 Then Should be able to select international character filter
 When User Click on the Search button
 Then Should be able to search defects for international character filter
 
@Search_Defect            
Scenario: 161 <DT> Search defect by new added filter
Given User is in the page of the Defect_Tracking
 Then Should be able to Launch the defect_Tracking
 When User click on the Advance Link
 Then Should be Able to go to the Advance Search page
 When User Select the Filter option as myFilters
 Then Should be able to select MyFilters
  And User select the added filter
 Then Should be able to select the added filter
 When User click On the Search button
 Then Should be able to search defects for added filter
 
@Search_Defect
Scenario: 162 <DT> Search defect by edited filter
Given User is in the External Jira page
 When User create the filter
  And User edit the filter name
 When User launch the Defect_Tracking
 Then Should be able to Launch the Defect_Tracking page
 When User click on the Advance Link button
 Then Should be Able to navigate to the Advance Search page
 When User Select the Filter option as MyFilters
 Then Should be able to Select MyFilters
 When User select the edited filter
 Then Should be able to select the edited filter
 When User click On the Search Button
 Then Should be able to search defects for the edited filter
 
@Search_Defect
Scenario: 163 HTML/DT Jira>Search defect by  wrong defect ID in Test Execution and Defect Tracking
Given User is in the test execution page
 When User navigate to the search page
  And search the defect by wrong defect id
 Then should get Issue does not exist
 When User launch the defect tracking page
  And search the wrong defect id
 Then Should get the message Issue does not exist
 
@Search_Defect
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
 
@Search_Defect
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

@Search_Defect
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

@Search_Defect 
Scenario: 169 <Search> Filter creators by partial text using single character
Given User is in the Project_page
 When User navigate to the Defect Tracking
  And search a creators by partial username using single character
 Then Dropdown menu should populate the matching users with partial username
 When User filter a creators by partial first name
 Then Dropdown menu should populate the matching users with partial first name 
 When filter a creators by partial middle name using single character
 Then Dropdown menu should populate the matching users with partial middle name
 When filter a creators by partial last name using single character
 Then Dropdown menu should populate the matching users with partial last name
 When filter a creator by partial email using single character
 Then Dropdown menu should populate the matching users with partial email
 
@Search_Defect
Scenario: 170 <Search>Filter creators by partial text using UPPERCASE if actual result is in lowercase
Given User is in the project page
 When User navigate to the DefectTracking
  And Filter creators by partial username using UPPERCASE
 Then Dropdown menu should populate the matching users with partial username by lowercase
 When User filter a creators by partial first name using UPPERCASE
 Then Dropdown menu should populate the matching users with partial first name by lowercase 
 When filter a creators by partial middle name using UPPERCASE
 Then Dropdown menu should populate the matching users with partial middle name by lowercase
 When filter a creators by partial last name using UPPERCASE
 Then Dropdown menu should populate the matching users with partial last name by lowercase
 When filter a creator by partial email using UPPERCASE
 Then Dropdown menu should populate the matching users with partial email by lowercase
 
@Search_Defect 
Scenario: 171 <Search>Filter creators by partial text using lowercase if actual result is in UPPERCASE
Given User is in a project page
 When User launch the DefectTracking
  And Filter creators by partial username using lowercase
 Then Dropdown menu should populate the matching users with partial username by UPPERCASE
 When User filter a creators by partial first name using lowercase
 Then Dropdown menu should populate the matching users with partial first name by UPPERCASE 
 When filter a creators by partial middle name using lowercase
 Then Dropdown menu should populate the matching users with partial middle name by UPPERCASE
 When filter a creators by partial last name using lowercase
 Then Dropdown menu should populate the matching users with partial last name by UPPERCASE
 When filter a creator by partial email using lowercase
 Then Dropdown menu should populate the matching users with partial email by UPPERCASE 

@Search_Defect
Scenario: 172 <Search> Filter creators by partial text using special characters
Given User is in a Project Page
 When User Launch the DefectTracking
  And Filter creators by partial username using special characters
 Then Dropdown menu should populate the matching users with partial username by special characters
 When User filter a creators by partial first name using special characters
 Then Dropdown menu should populate the matching users with partial first name by special characters 
 When filter a creators by partial middle name using special characters
 Then Dropdown menu should populate the matching users with partial middle name by special characters
 When filter a creators by partial last name using special characters
 Then Dropdown menu should populate the matching users with partial last name by special characters
 When filter a creator by partial email using special characters
 Then Dropdown menu should populate the matching users with partial email by special characters
 
 @Search_Defect
Scenario: 173 <Search> Filter creators by partial text using international characters
Given User is in a Project page
 When User Launch the Defect_Tracking
  And Filter creators by partial username using international characters
 Then Dropdown menu should populate the matching users with partial username by international characters
 When User filter a creators by partial first name using international characters
 Then Dropdown menu should populate the matching users with partial first name by international characters 
 When filter a creators by partial middle name using international characters
 Then Dropdown menu should populate the matching users with partial middle name by international characters
 When filter a creators by partial last name using international characters
 Then Dropdown menu should populate the matching users with partial last name by international characters
 When filter a creator by partial email using international characters
 Then Dropdown menu should populate the matching users with partial email by international characters 

@Search_Defect
Scenario: 174 <Search> Filter creators by partial text using alphanumeric characters and spaces
Given User is in a project_page
 When User Launch the Defect_Tracking page
  And Filter creators by partial username using alphanumeric characters and spaces
 Then Dropdown menu should populate the matching users with partial username by alphanumeric characters and spaces
 When User filter a creators by partial first name using alphanumeric characters and spaces
 Then Dropdown menu should populate the matching users with partial first name by alphanumeric characters and spaces 
 When filter a creators by partial middle name using alphanumeric characters and spaces
 Then Dropdown menu should populate the matching users with partial middle name by alphanumeric characters and spaces
 When filter a creators by partial last name using alphanumeric characters and spaces
 Then Dropdown menu should populate the matching users with partial last name by alphanumeric characters and spaces
 When filter a creator by partial email using alphanumeric characters and spaces
 Then Dropdown menu should populate the matching users with partial email by alphanumeric characters and spaces 
  
@Search_Defect
Scenario: 175 Filter assignees by full text as username
Given User is in the Project selection page
 When User launch the defectTracking page
  And filter assignee by full text as username
 Then dropdown menu should populate the matching users with assignees using username
 When User launch the Test Execution page to filter the assignee by full text as username
 Then dropdown menu should populate matching users with assignees using username
 When User search a defect assignee in defect details window
 Then dropdown menu should populate the matching users with assignee in defect detail window
 When User search a assignee in change multiple window
 Then dropdown menu should populate the matching users in change multiple window
 
 @Search_Defect
Scenario: 176 Filter assignees by full first name
Given User is in the Project Selection page
 When User launch the defect_Tracking Page
  And filter assignees by full first name
 Then dropdown menu should populate the matching users with assignees using first name  
 When User launch the Test Execution page to filter the assignee by full first name
 Then dropdown menu should populate matching users with assignees using first name
 When User search a defect assignee by full first name in defect details window
 Then dropdown menu should populate the matching users with assignee by full first name in defect detail window
 When User search a assignee by full first name in change multiple window
 Then dropdown menu should populate the matching users with assignee by full first name in change multiple window  

@Search_Defect
Scenario: 177 Filter assignees by full middle name
Given User is in the page of Project Selection
 When User Launch the defectTracking page
  And filter assignees by full middle name
 Then dropdown menu should populate the matching users with assignees using middle name  
 When User launch the Test Execution page to filter the assignee by full middle name
 Then dropdown menu should populate matching users with assignees using middle name
 When User search a defect assignee by full middle name in defect details window
 Then dropdown menu should populate the matching users with assignee by full middle name in defect detail window
 When User search a assignee by full middle name in change multiple window
 Then dropdown menu should populate the matching users with assignee by full middle name in change multiple window 
 
@Search_Defect
Scenario: 178 Filter assignees by full last name
Given User is in the page of a Project Selection
 When User Launch The defectTracking Page
  And filter assignees by full last name
 Then dropdown menu should populate the matching users with assignees using last name  
 When User launch the Test Execution page to filter the assignee by full last name
 Then dropdown menu should populate matching users with assignees using last name
 When User search a defect assignee by full last name in defect details window
 Then dropdown menu should populate the matching users with assignee by full last name in defect detail window
 When User search a assignee by full last name in change multiple window
 Then dropdown menu should populate the matching users with assignee by full last name in change multiple window 
 
@Search_Defect
Scenario: 179 Filter assignees by full email
Given User is in the page of an Project selection
 When User launch The defect_Tracking page
  And filter assignees by the full email
 Then dropdown menu should populate the matching users with assignees using full email  
 When User launch the Test Execution page to filter the assignee by full email
 Then dropdown menu should populate matching users with assignees using full email
 When User search a defect assignee by full email in defect details window
 Then dropdown menu should populate the matching users with assignee by full email in defect detail window
 When User search a assignee by full email in change multiple window
 Then dropdown menu should populate the matching users with assignee by full email in change multiple window      






@Search_Defect1
 Scenario: Precondition -194 to 199 testcass
Given Users is in the project Page 
 When user navigate to test Repsitory and create a node
 And add multiple testcases to the node
 Then testcases successfully added in the node
 When user navigate to test planning page and create a Cycle
 And add created phase to the cycle and assign it to anyone
 Then testcases should successfully assigned to anyone 
 When user navigate to Test Execution page
 And change the Status of testcase to pass
 Then status of testcases successfully changed to Pass


 
 @Search_Defect1
  Scenario: 194 Link multiple defects to multiple testcases with various priorities and statuses and then hover the cursor on D button in Test Execution
 Given User is in Test Execution page
 When User launch Test Execution
 Then Should be able to launch Test Execution 
 When User open linked defects modal dialog using D button of first testcase
 Then Should launch link Defect window
 When User Search defect with first priority by JQL
 Then Should be able to search defects by JQL
 When User link the searched defect
  And User Search defect with different priority by JQL
 Then Should be able to Search defects by JQL
 When User link defect with different priority
 Then Should be able to link defect to execution with different priorities
 When User open linked defects modal dialog using D button of second testcase
 Then Should launch Link defect window
 When User Search defect with first status by JQL
 Then Should be able to Search Defects by JQL
 When User Link searched defect
  And User serach defect with different status by JQL
 Then Should be Able to Search defects by JQL
 When User link defect with different status 
 Then Should be able to link defect to execution with different status 
 When User hover the cursor on defectid in execution grid
 Then defect details should show properly for all linked defects

 @Search_Defect1
 Scenario: 195 Attempt to link the same defect multiple times to a testcase
 Given user is in TestExecution page
 When user launch TestExection
 Then should be able To launch TestExecution
 When user open linked defects modal dialog using D button on a testcase
 Then should launch link defect window
 When user search for a defect by ID
 Then should be able to search defects by ID
 When user add the defect to the testcase
 Then should be able to link defect to execution
 When user search for the same defect again using the defect ID
 Then should be able to search defect again
 When user again try to link defect
 Then should get message as defect is already linked
   
@Search_Defect
Scenario: 196 Link the defect with no priority to execution
Given User is in text execution page
When User launch text execution
Then Should be able to launch text execution
When User open linked defect modal dialog using D button on a testcase
Then Should be able to Launch Link defect window
When User search a defect by ID which is having empty priority
Then Should be able to search defect with empty priority
When User click on link button
Then Should be able to link defect to execution with empty priority

@Search_Defect
Scenario: 197 Search a defect has special characters in name and link to the testcase in Test Execution
Given User is in textexecution page
When User launch Textexecution
Then Should be able to launch Textexecution
When User open linked defects modal dialog using D button on a Testcase
Then Should be able to launch Link defect window
When User search a defect by ID which is having special chars in name
Then Should be able to search defect which is having special chars in name
When User click on Link button
Then Should be able to link defect which is having special chars in name

@Search_Defect
Scenario: 198 Search for defect has international characters and link to the testcase in Test Execution
Given user in textexecution page
When user launch Textexecution
Then should be able to launch Textexecution
When user open linked defects modal Dialog using D button on a testcase
Then should be able to launch link defect Window
When user search for a defect by ID which is having international chars in name
Then should be able to search defects which is having international chars in name
When user click on link button
Then should be able to link defect which is having international chars in name


@Search_Defect
Scenario: 199 Link multiple defects with a long name to a testcase in Test Execution
Given user in Textexecution Page
When User launch textexecution
Then Should be able to Launch textexecution
When User Open linked defects modal dialog using D button on a testcase
Then Should be able to launch Link Defect Window
When User search for first defect by ID which is having long name of 255 chars
Then Should be able to search first defect with long name
When User Click on Link button on first defect
Then Should be able to link first defect with long name
When User search for second defect by ID which is having long name of 255 chars
Then Should be able to search second defect with long name
When User Click on Link button on second defect
Then Should be able to link second defect with long name





@Search_Defect1
Scenario:207 Search defects using JQL by Issue Type Bug
Given Test repository page launched by User
When  user creates a new phase and adds testcase
Then  should be Added Testcase
When  user launch test planning page, creates new cycle and assign phase to cycle
And   launch Test execution page,Executes Testcase with any status 
And   click on D ICON
Then  window of link defect to be launched
When  Search defects using JQL by Issue Type Bug in test execution
Then  should be able to Search defects
When  search defect using JQL in defect tracking page
Then  should be able to search defects
When  user searches the defects using JQL by Issue Type Bug in requirements page
Then  The defects using JQL by Issue Type Bug should search

@Search_Defect1
Scenario:208 Search defects using JQL by Issue Type Epic
Given  user is in a Page of execution
When   user search the defects using jql by Issue Type Epic
Then   should able to search defects
When   user Searches defects using JQL by Issue Type Epic in Defect Tracking
Then   In Defect Tracking,should be able to search defects
When    user search the defects using JQL by Issue Type Epic In requirements
Then    should search the defects in requirements

@Search_Defect1
Scenario:209 Search defects using JQL by Issue Type Improvement
Given  Test execution Page is Launched By user
When   user  searches the defects using Jql by issue type Improvement
Then   issue type Improvement defects should search
When   user searches the defects using jql by issue type Improvement in defect tracking
Then   should search the defects using jQL by issue type Improvement 
When    search defects using JQL by Issue Type Improvement in Requirements
Then    should search defects using Jql by issue type Improvement

@Search_Defect1
Scenario:210 Search defects using JQL by Issue Type Story
Given  TestExecution page is Launched by user
When   user Searches defects using JQL by Issue Type Story
Then   Defects should search
When   In defect tracking,user searches Defects using JQL by issuetype Story
Then   should search the defects in defect tracking
When    search defects Using Jql by IssueType Story In requirements page
Then    should search defects Using Jql by IssueType Story In requirements page

@Search_Defect1
Scenario:211 Search defects using JQL by Issue Type Task
Given User Launch Test execution page 
When  Search defects using JQL by Issue Type Task
Then  should search defects using JQL by Issue Type Task
When  Search defects using JQL by Issue Type Task in defect tracking
Then   should search Defects using JQL by Issue Type Task
When  Search defects using JQL by Issue Type Task in requirements page
Then  should be able to search defects using JQL by Issue Type Task

@Search_Defect1
Scenario:212 Search defects using JQL by Issue Type New Feature
Given user is in the testexecution page
When  user Search defects using JQL by Issue Type New Feature in test execution page
Then  should search the defects using JQL by Issue Type New Feature
When  Search defects using JQL by Issue Type New Feature in defect tracking
Then  In defect tracking,should search the Defects 
When  In requirements page,search the defects using JQL by Issue Type New Feature
Then  In requirement page should search the defects using JQL by Issue Type New Feature 

@Search_Defect1
Scenario:213 Search defects using JQL by Issue Type Sub-Task
Given TestExecution page is Launched by User
When  Searches defects using JQL by Issue Type Sub-Task
Then  should search defects using JQL by issue type Sub-Task
When  User searches the defects using jql by issue type sub-task in Defect tracking
Then  Should search the defects using jql by issue type sub-task
When  user searches The defects using Jql By issue type sub-task in Requirements
Then  should search the defects  using Jql By issue type sub-task in requirements

@Search_Defect1
Scenario:214 Search defects using JQL by custom Issue Type
Given user is in test execution PAGE
When  user searches defects using JQL by custom Issue Type
Then  should search the defects using JQL by custom Issue Type
When  user searches defects using JQL by custom Issue Type in defect tracking
Then  In defect tracking,should search the defects using JQL by custom Issue Type
When  In requirements, Search defects using JQL by custom Issue Type
Then  should search defects using JQL by custom Issue Type In requirements

@Search_Defect1
Scenario:201 Search defects using valid JQL written in Lowercase
Given Test execution Page is Launched by User
When  user Searches defects using valid JQL written in Lowercase
Then  should be able to Search Defects 
When  Search defects using valid JQL written in Lowercase In Defect Tracking 
Then  in defect tracking,defects should search
When  user searches the defects using valid JQL written in Lowercase in Requirements
Then  should search defects using valid JQL written in Lowercase in Requirements

@Search_Defect1
Scenario:202 Search defects using valid JQL written in Uppercase
Given Test execution page is Launched by user
When  user Searches defects using valid JQL written in Uppercase
Then  defects should search in test execution
When  In defect tracking,user searches the defects using valid JQL written in Uppercase
Then  In defect tracking,defects should search
When  user searches the defects using valid JQL written in Uppercase in requirements
Then  In requirements,defects should search 

@Search_Defect
Scenario:200 Attempt to search defects using invalid JQL
Given Testexecution app is launched by user
When  user Attempts to search defects using invalid JQL
Then  should get a proper message
When  user attempts to search defects using invalid JQL in defect tracking page
Then   should get the proper message

@Search_Defect1
Scenario:203 Search defects without entering query
Given  Launched test execution page by user
When  user searches defects without entering query
Then  should be able to search the defects
When  User searches defects without entering query in defct tracking page
Then  should search defects
When  user serach defects without entering any query in requirements
Then  In requirements should search defects

@Search_Defect1
Scenario:204 Attempt to get search results using JQL if there is no defect match to entered query
Given  Test execution page is launched by User
When   user searches defects using JQL if there is no defect match to entered query
Then   Should get message that No records found or you do not have access.Try modifying your search criteria
When   user searches defects using JQL if there is no defect match to entered query in defect tracking
Then   should get message No records found or you do not have access
When   user search defects using JQL if There is no defect match to entered query in requirements
Then   In requirements should show message that No records found or you do not have access

@Search_Defect1
Scenario:205 Search defects using JQL having one or more matching defects, verify count of defects displayed is correct
Given  user is in the page OF TestExecution
When   user search defects using JQL having one or more matching defects and verifies count of defects 
Then   should show the proper search count
When   In defect tracking,Search defects using JQL having one or more matching defects and verify count of defects 
Then   should display proper search count
When   In requirements,Search defects using JQL having one or more matching defects and verifies count of defects 
Then   should Show Proper search Count

@Search_Defect1
Scenario:215 Search defects by issue type ID using JQL
Given  TESTExecution page is launched by User
When   Search defects by issue type ID using JQL
Then   should be able to search defect by ID
When   user searches defects by issuetype ID using Jql in Defect Tracking
Then   should be Able to search Defects by issuetype ID in defect tracking
When   In requirements,user searches the defects by issue Type ID using JQL
Then   should search the defects by issue Type ID using JQL

@Search_Defect
Scenario:206 Search defects by project with project name using JQL
Given  User is in a Page Of DefectTracking
When   user search defects by project with long project name using JQL
Then   should search defects by project with long project name using JQL
When   user searches defects by project with project name having numbers using JQL 
Then   should search defects by project with project name having numbers using JQL
When   user searches defects by project with project name having special chars using JQL
Then   should able to search defects by project with project name having special chars
When   user searches defects by project with project name having apha numeric chars using JQL
Then   should search defects by project with project name having apha numeric chars
When   user search defects by project with project name having international chars using JQL
Then   should able to search defects by project with project name having international chars

@Search_Defect
Scenario:216 Search defects using JQL by component with all operator
Given  user is in DefectTracking page
When   Search defects using JQL by component with = operator
Then   defects should search using Jql
When   user searches defects using JQL by component with = operator in test execution
Then   In test execution,should search defects using jql by component with = operator
When   Search defects using JQL by component with != operator in defect tracking
Then   in defect tracking,should search the defects 
When   In test execution,search defects using JQL by component with != operator
Then   defects should be searched in test execution
When   user Search defects using JQL by component with AND operator in defect tracking
Then   Defects should be searched by using AND operator
When   Search defects using JQL by component with AND operator in test execution page
Then   In test execution defects should search using jql by component with AND operator
When   user search defects using JQL by component with OR operator in defect tracking
Then   defects should be searched using jql by component with OR operator
When   In test execution,search defects using JQL by component with OR operator
Then    Defects should search using jql by component with OR operator in test execution page
When   In defect tracking,Search defects using JQL by component with IN operator
Then   Defects should be searched in defect tracking
When   In test execution,search defects using JQL by component with IN operator
Then   defects should be searched in test execution using JQL by component with IN operator
When   In defect tracking,user search defects using JQL by component with NOT IN operator
Then   In defect tracking,should be able search defects using JQL by component with NOT IN operator
When   In test execution,user search defects using JQL by component with NOT IN operator
Then   defects should be able to search in Test execution
When   Search defects using JQL by component with IS operator in defect tracking
Then   defects should search using JQL by component with IS operator
When   user Search defects using JQL by component with IS operator in test execution
Then   should be able to search defects using JQL by component with IS operator
When   user Search defects using JQL by component with IS NOT operator in defect tracking
Then   should be able to search defects using jql by component with IS NOT operator
When   In test execution search defects using JQL by component with IS NOT operator
Then   should be able to search defects using JQL by component with IS NOT operator in test execution

@Search_Defect
Scenario:217 Search defects using JQL by Affected version with all operator
Given  Defect tracking page is launched by user
When   user searches defects using JQL by Affected version with = operator 
Then   should able to search defects using JQL by affected version
When   In test execution,user Searches defects using JQL by Affected version with = operator
Then   in test execution should able to search defects using JQL by affected version
When   In defect tracking, user searches defects using JQL by Affected version with != operator
Then   defects should be searched using jql by affected version
When   in test execution,search the defects using JQL by Affected version with != operator
Then   defects should search in test Execution page
When   Search defects using JQL by Affected version with AND operator in Defect tracking
Then   should be able to search defects using JQL by Affected version
When   In test execution,search Defects using JQL by Affected version with AND operator
Then   should able to search defects using JQL by Affected version with AND operator
When   In defect tracking page,user searches defects using JQL by Affected version with OR operator
Then   defects should search using JQL by Affected version with OR operator
When   In test execution,searches defects using JQL by Affected version with OR operator
Then   In test execution, defects should search using JQL by Affected version
When   user Searches defects using JQL by Affected version with IN operator in defect tracking
Then   Defects should search using JQL by Affected version with IN operator
When   In test execution page user searches Defects using JQL by Affected version with IN operator
Then   in test execution page Defects should search using JQL by Affected version
When   user search defects using JQL by Affected version with NOT IN operator in defect tracking
Then   Defects should search using JQL by Affected version with NOT IN Operator
When   In test execution page user Searches Defects Using jql by Affected version with NOT IN operator
Then   in test execution page, Defects to be able to search using JQL by Affected version 
When   In defect tracking page,user searches defects Using JQL By Affected Version with IS operator
Then   defects should be searched using JQL by Affected version with IS Operator
When   In test execution,searches defects using JQL by Affected version with IS operator
Then   In test execution page, defects should search using JQL by Affected version with IS operator
When   In defect tracking page,user will search defects using JQL by Affected Version With IS NOT operator
Then   defects should Be searched using JQL by Affected version with IS NOT operator
When   In test execution,searches defects using JQL by Affected version with IS NOT operator
Then   In test execution, defects should search using JQL by Affected version with IS NOT operator

@Search_Defect1
Scenario:218 Search defects using JQL by Fix version with all operator
Given  User is in page OF DefectTracking
When   user will search defects using JQL by Fix Version with = operator 
Then   should be searched defects using JQL by Fix Version
When   In Test execution,user searches defects using JQL by Fix Version with = operator
Then   in Test execution page should able to search defects using JQL by Fix Version
When   In defect tracking,user searches defects using JQL by Fix Version with != operator
Then   defects should be able to search using jql by Fix Version
When   in Test execution page,Search the defects using JQL by Fix Version with != operator
Then   Defects should be searched in test Execution page
When   search Defects using JQL by Fix Version with AND operator in Defect tracking
Then   should be able to search Defects Using JQL by Fix Version
When   In Test execution,search Defects using jql by Fix Version with AND operator
Then   should able to search defects using jql by Fix Version with AND operator
When   In defect tracking page,user Searches defects using JQL by Fix version with OR operator
Then   defects should search using jql by Fix version with OR operator
When   In Test execution,searches Defects using JQL by Fix Version with OR operator
Then   In Test execution,Defects Should search using JQL by Fix Version
When   user Searches defects using JQL By Fix Version with IN operator in defect tracking
Then   Defects should search using JQL By Fix Version with IN operator
When   In Test execution page user searches Defects using JQL by Fix Version with IN operator
Then   in Test execution page Defects should search using JQL by Fix Version
When   user search defects using JQL by Fix Version with NOT IN operator in defect tracking
Then   Defects should search using JQL by Fix Version with NOT IN Operator
When   In Test execution page user Searches Defects Using jql by Fix Version with NOT IN operator
Then   in Test execution page, Defects to be able to search using JQL by Fix Version 
When   In defect tracking page,user searches defects Using JQL By Fix Version with IS operator
Then   defects should be searched using JQL by Fix Version with IS Operator
When   In Test execution,searches defects using JQL by Fix Version with IS operator
Then   In Test execution page, defects should search using JQL by Fix Version with IS operator
When   In defect tracking page,user will search defects using JQL by Fix Version With IS NOT operator
Then   defects should Be searched using JQL by Fix Version with IS NOT operator
When   In Test execution,searches defects using JQL by Fix Version with IS NOT operator
Then   In Test execution,Defects should Search using jql by Fix Version with IS NOT Operator

@Search_Defect
Scenario:219 Search defects by priority using JQL with all operator
Given  user will launch defect Tracking Page
When   user searches Defects Using JQL by priority with = operator 
Then   should Able to search defects using JQL by priority
When   In Test Execution,user searches the Defects using JQL by priority with = Operator
Then   in Test Execution page,should able to search Defects using JQL by priority
When   In defect tracking,User searches defects using JQL by priority with != operator
Then   Defects should be searched Using jql by Priority
When   in test execution,search the defects using JQL by priority with != operator
Then   defects should search using JQL by priority with != operator in Test Execution page
When   Search defects using JQL by priority with AND operator in Defect tracking page
Then   should be able to search defects using JQL by priority in Defect tracking page
When   In Test Execution,search Defects using JQL by priority with AND operator
Then   should Able to Search defects using JQL by priority with AND operator
When   In defect tracking page,user Searches defects using JQL by priority with OR operator
Then   defects should search Using JQL by priority With OR Operator
When   In Test Execution,searches defects using JQL by priority with OR operator
Then   In test execution, defects should search using JQL by priority
When   User searches defects using jql by fix version with IN operator in defect tracking
Then   Defects should search using jql by fix version with IN operator
When   In test execution page,User searches Defects using jql by fix version with IN Operator
Then   in test execution page Defects should be searched using JQL by fix version
When   user search defects using jql by fix version With NOT IN operator in Defect tracking Page
Then   Defects should be searched using JQL by fix version with NOT IN Operator
When   in Test execution page User searches Defects Using jql by fix version with NOT IN operator
Then   In test execution page, Defects to be able to search using jql by fix version 
When   In defect tracking user searches defects Using jql by fix version with IS operator
Then   defects should be searched using JQL By fix version with IS Operator
When   In Test execution,searches defects using JQL by fix version with IS operator
Then   In Test execution Page, defects should search using JQL by fix version with IS Operator
When   In defect tracking Page,user will search defects using JQL by fix version With IS NOT Operator
Then   defects should Be searched using JQL by fix version with IS NOT Operator
When   In test execution,searches defects using JQL by fix version with IS NOT operator
Then   In test execution,defects should Search Using JQL by fix version with IS NOT Operator

@Search_Defect1
Scenario:220  Search defects by priority using JQL
Given  user Is in the Defect tracking App
When   Search defects by priority Blocker using JQL 
Then   should search the defects by priority Blocker using JQL 
When   In test execution user searches the defects by priority blocker using jql
Then   In test execution page should search the defects by priority blocker
When   user Search defects by priority Critical using JQL in defect tracking
Then   should able to search defects by priority Critical using JQL
When   In Test execution page,Search defects by priority Critical using JQL
Then   Defects should search by priority Critical
When   user Search defects by priority Major using JQL in defect tracking
Then   should able to search defects by priority Major using JQL
When   In Test execution page,Search defects by priority Major using JQL
Then   Defects should search by priority Major
When   user Search defects by priority Minor using JQL in defect tracking
Then   should able to search defects by priority Minor using JQL
When   In Test execution page,Search defects by priority Minor using JQL
Then   Defects should search by priority Minor
When   user Search defects by priority Trivial using JQL in defect tracking
Then   should able to search defects by priority Trivial using JQL
When   In Test execution page,Search defects by priority Trivial using JQL
Then   Defects should search by priority Trivial
When   user Search defects by custom priority using JQL in defect tracking
Then   should able to search defects by custom priority using JQL
When   In Test execution page,Search defects by custom priority using JQL
Then   Defects should search by custom priority
When   user Search defects by custom priority contain long name in defect tracking
Then   should able to search defects by custom priority contain long name
When   In Test execution page,Search defects by custom priority contain long name
Then   Defects should search by custom priority contain long name
When   user Search defects by  custom priority contain number in defect tracking
Then   should able to search defects by  custom priority contain number
When   In Test execution page,Search defects by  custom priority contain number
Then   Defects should search defects by custom priority contain number
When   user Search defects by custom priority contain special chars in defect tracking
Then   should able to search defects by custom priority contain special chars
When   In Test execution page,Search defects by custom priority contain special chars
Then   Defects should search by Custom priority contain special chars
When   user Search defects by Custom priority contain white spaces in defect tracking
Then   should able to search defects by custom priority contain white spaces
When   In Test execution page,Search defects by  custom priority contain white spaces
Then   Defects should search by custom priority contain white spaces
When   user Search defects by Custom priority contain alpha numeric chars in defect tracking
Then   should able to search defects by custom priority contain alpha numeric chars
When   In Test Execution page,Search defects by custom priority contain alpha numeric chars
Then   Defects should search by custom priority contain alpha numeric chars
When   user Search defects by custom priority contain international chars in defect tracking
Then   should able to search defects by custom priority contain international chars
When   In Test Execution page,Search defects by custom priority Contain international chars
Then   Defects should search by custom priority Contain international chars


@Search_Defect1
Scenario:221 Search defects by status using JQL with all operator
Given  User is in a Page OF DEFECT TRACKING
When   Search defects using JQL by status with = Operator
Then   should able to search defects using JQL by status with = Operator
When   user searches the defects using JQL by status with = Operator in TestExecution page
Then   Defects should search using JQL by status with = Operator
When   Search defects using JQL by status with != operator In Defect Tracking Page
Then   Should able to search defects using JQL by status with != operator
When   In testexecution,user searches defects using JQL by status with != operator 
Then   To able to search defects using JQL by status with != operator In Test Execution Page
When   Search defects using JQL by status with AND operator In Defect Tracking Page
Then   Should Able to search defects using JQL by status with AND operator
When   In testexecution,user searches defects using JQL by status with AND operator 
Then   should search defects using JQL by status with AND operator In Test Execution Page
When   user search defects using JQL by status with OR operator In Defect Tracking Page
Then   To be able to search defects using JQL by status with OR operator
When   In testexecution,user searches defects using JQL by status with OR operator 
Then   should able to search defects using JQL by status with OR operator In Test Execution Page
When   Search defects using JQL by status with IN operator In Defect Tracking Page
Then   Should able To search defects using JQL by status with IN operator
When   In testexecution,user searches defects using JQL by status with IN operator 
Then   should be searched defects using JQL by status with IN operator In Test Execution Page
When   User search Defects using JQL by status with NOT IN operator In Defect Tracking Page
Then   Should able to search Defects using JQL by status with NOT IN operator
When   In testexecution,user searches defects using JQL by status with NOT IN Operator 
Then   should able to search defects using JQL by status with NOT IN operator In Test Execution Page
When   user Searches defects using JQL by status with IS operator In Defect Tracking Page
Then   should be able to search defects using JQL by status with IS operator
When   In Testexecution,user searches defects using JQL by status with IS operator 
Then   should search defects using JQL by status with IS operator In Test Execution Page
When   search Defects using JQL by status with IS NOT operator In Defect Tracking Page
Then   Should able to search defects using JQL by status with IS NOT operator
When   In Testexecution page,user searches defects using JQL by status with IS NOT operator 
Then   should Be able to search defects using JQL by status with IS NOT operator In Test Execution Page


@Search_Defect
Scenario:225 Search defects by project using JQL
Given  Defect Tracking App is Launched By a User
When   user searches defects by custom project contain long name
Then   To be able to search defects
When   In TestExecution page,user searches defects by Custom project contains Long name
Then   defects should be searched in a TestExecution page
When   user searches defects by custom project consists Number In a DefectTracking
Then   By custom project defects should search
When   In TestExecution page,user searches Defects By custom project contains Number
Then   Defects should be searched In TestExecution
When   user searches defects by custom project contains special chars In Defect tracking page
Then   To be able to search defects by custom project contains special chars
When   In TestExecution page,user searches defects by Custom project contain special chars
Then   defects should be searched by Custom project consists special chars in a TestExecution page
When   In Defect tracking,user searches defects by custom project contain white spaces
Then   To be able to search Defects by custom project contain white spaces
When   In TestExecution page,user searches defects by Custom project consists white spaces
Then   Defects should search in a TestExecution page by Custom project consists white spaces
When   user Search defects By custom project consists alpha numeric chars In defect tracking Page
Then   Should search defects By custom project consists alpha numeric chars
When   In TestExecution page,user searches defects by Custom project contains Alpha Numeric chars
Then   defects should be searched In a TestExecution page by Custom project contains Alpha Numeric chars
When   In Defect Tracking,user searches defects by custom project contains international chars
Then   To be Able to search defects by custom project
When   In TestExecution page,user searches defects by Custom project consists International chars
Then   defects should be searched in a TestExecution page by Custom project consists international chars


@Search_Defect1
Scenario:226 Search defects by component using JQL
Given  DEFECTTRACKING Page is Launched BY User
When   user Searches defects by component Contains long name
Then   Should able to search defects by Component contains long name
When   User Searches defects by component contain Long name in TestExecution Page
Then   In Test Execution Page,Defects should search by Component
When   user Searches defects by component contains number In Defect Tracking
Then   Should able to search defects by Component contains number
When   User Searches defects by component contain number in TestExecution Page
Then   In Test Execution Page,Defects should search by component contains number
When   user Searches defects by component contain special chars In defectTracking page
Then   Should able to search defects by Component contains special chars
When   User Searches defects by component contain special chars in TestExecution Page
Then   In Test Execution Page,Defects should search by component consists special chars
When   user Searches defects by component contain  white spaces in defect tracking
Then   Should able to search defects by Component contains  white spaces
When   User Searches defects by component contain  white spaces in TestExecution Page
Then   In Test Execution Page,Defects should search by component contains  white spaces
When   In Defect Tracking page,user Searches defects by component contain alpha numeric chars
Then   Should able to search defects by Component contains alpha numeric chars
When   User Searches defects by component contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by component consists Alpha numeric chars
When   user Searches defects by component contain international chars in Defect Tracking Page
Then   should able to search defects by Component contains International chars
When   User Searches defects by component contain international chars in TestExecution Page


@Search_Defect
Scenario:223 Search defects by Assignee using JQL with all operator
Given  USer Launch Defect TRACKING page
When   Searches defects using JQL by Assignee  with = operator
Then   Should Able to Search Defects using JQL by Assignee  with = operator
When   user searches Defects using JQL by Assignee  with = operator In Test Execution Page
Then   In Test Execution Page,should search defects using JQL by assignee
When   User Searches defects using JQL by Assignee  with != operator In Defect Tracking
Then   Should Able to Search Defects using JQL by assignee with != operator
When   user searches Defects using JQL by assignee With != operator In Test Execution Page
Then   In Test Execution Page,should search defects using JQL by Assignee With != operator
When   Searches defects using JQL by Assignee  with AND operator In Defect tracking page
Then   should Able to Search Defects using JQL by Assignee  with AND operator
When   user searches Defects using JQL by Assignee with AND operator In Test Execution Page
Then   In Test Execution Page,should search defects using JQL by assignee with AND operator
When   Searches defects using JQL by Assignee  with OR operator
Then   Should able to search defects using JQL by Assignee  with OR operator
When   user searches Defects using JQL by Assignee  with OR operator In Test Execution Page
Then   In Test Execution Page,should search defects using JQL by assignee with OR operator
When   user Searches Defects using JQL by Assignee  with IN operator in defect tracking
Then   user should Able to Search Defects using JQL by Assignee  with IN operator
When   user searches Defects using JQL by Assignee  with IN operator In test Execution Page
Then   In Test Execution Page,should search defects using JQL by Assignee  with IN operator
When   user search defects using JQL by Assignee  with NOT IN Operator In Defect Tracking
Then   Should be able to Search defects using JQL by Assignee  with NOT IN operator in defect tracking
When   user searches Defects using JQL by Assignee  with NOT IN operator In Test execution Page
Then   In Test Execution Page,should search defects using JQL by Assignee with NOT IN operator
When   In defect tracking page,user Searches defects using JQL by Assignee  with IS operator
Then   Should be Searched Defects using JQL by Assignee  with IS operator
When   user searches Defects using JQL by Assignee  with IS operator In Test Execution Page
Then   In Test Execution Page,Should search Defects using JQL by  Assignee  with IS operator
When   Searches defects using JQL by Assignee with IS NOT Operator in defect tracking page
Then   Should Able to Search Defects using JQL by Assignee  with IS NOT operator
When   user searches Defects using JQL by Assignee  with IS NOT operator In Test Execution Page
Then   In Test Execution Page,should search defects using JQL by Assignee With IS NOT operator

@Search_Defect1
Scenario:224 Search defects by Reporter using JQL with all operator
Given  USer Launches DefectTRACKING page
When   Searches defects using jql by Reporter with = operator
Then   should Able to Search Defects using JQL by Reporter with = operator
When   user searches Defects using jql by Reporter with = Operator In Test Execution Page
Then   In Test Execution Page,should search defects using jql by Reporter
When   user Searches defects using JQL by Reporter With != operator In Defect Tracking
Then   To be able to Search Defects using JQL by Reporter with != Operator
When   User searches Defects using JQL by Reporter with != operator In Test Execution Page
Then   In Test Execution Page,should search defects using JQL by Reporter with != Operator
When   Searches defects using JQL by Reporter With AND operator In Defect tracking page
Then   should Able to Search Defects using JQL by Reporter With AND Operator
When   user searches Defects using JQL by Reporter With AND Operator In Test Execution Page
Then   In Test Execution Page,Should search defects using JQL by Reporter with AND operator
When   Searches defects using JQL by Reporter with OR operator in defect tracking
Then   To Be able to search defects using JQL by Reporter with OR operator
When   user searches Defects using JQL By Reporter with OR operator In Test Execution Page
Then   In Test Execution Page,should search Defects using JQL by Reporter with OR operator
When   user Searches Defects using JQL by Reporter with IN operator in defect tracking
Then   user should Able to Search Defects using JQL by Reporter with IN operator
When   user searches Defects using JQL by Reporter with IN operator In test Execution Page
Then   In Test Execution Page,should search Defects using JQL by Reporter with IN Operator
When   user search defects using jql by Reporter with NOT IN Operator In Defect Tracking
Then   Should be Searched defects using JQL by Reporter with NOT IN operator in Defect tracking Page
When   user searches Defects using JQL by Reporter With NOT IN operator In Test execution Page
Then   In Test Execution Page,should search defects using JQL By Reporter with NOT IN operator
When   In defect tracking page,user Searches defects using JQL By Reporter With IS operator
Then   Should be Searched Defects using jql By Reporter with IS operator
When   user searches Defects using jql By Reporter With IS operator In Test Execution Page
Then   In Test Execution Page,Should search Defects using JQL by Reporter with IS Operator
When   Searches defects using JQL By Reporter with IS NOT Operator in defect tracking page
Then   To be Able to Search Defects using JQL by Reporter with IS NOT operator
When   user searches Defects using jql by Reporter with IS NOT operator In Test Execution Page
Then   In Test Execution Page,Should search Defects using JQL by Reporter With IS NOT operator

@Search_Defect
Scenario:227 Search defects by Affected version using JQL
Given  DEFECTTRACKING is Launched by User
When   user Searches defects by Affected version Contains long name
Then   should able to search defects by Affected version consists long name
When   User Searches defects by Affected version contains Long Name in TestExecution Page
Then   In Test Execution Page,Defects should search by Affected version consists long name
When   user Searches defects by Affected version contains number In Defect tracking
Then   Should able To search defects by Affected version contains Number
When   User Searches defects by Affected version Contains number in TestExecution Page
Then   In Test Execution Page,Defects should search by Affected version contains Number
When   user Searches defects by Affected version contains special chars In defectTracking page
Then   Should able to search defects by Affected version contains special characters
When   User Searches defects by Affected version contain special chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Affected version consists special chars
When   user searches defects by Affected version contain  white spaces in defect tracking
Then   To be able to search defects by Affected version contains  white spaces
When   User Searches defects by Affected version contain  white spaces in TestExecution Page
Then   in Test Execution Page,Defects should search by Affected version contains  white spaces
When   In defect Tracking page,user Searches defects by Affected version contain alpha numeric chars
Then   should able to search defects by Affected version contains alpha numeric chars
When   user Searches defects by Affected version contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by affected version consists Alpha numeric chars
When   user Searches defects by Affected version contain international chars in Defect Tracking Page
Then   should able to search defects by Affected version Contains International chars
When   User Searches Defects by Affected version contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Affected version Consists International chars

@Search_Defect
Scenario:228 Search defects by Fix version using JQL
Given  DEFECT TRACKING page is Launched BY User
When   user Searches defects by Fix version Contains long Name
Then   Should Able to search Defects by Fix version contains Long Name
When   User searches defects By Fix Version contain Long name in TestExecution Page
Then   In Test Execution Page,Defects should Search by Fix version
When   user Searches defects By Fix version contains Number In Defect Tracking
Then   To be able to search defects by Fix version contains Number
When   User Searches defects by Fix version contains Number in TestExecution Page
Then   In Test Execution Page,Defects should search by Fix version consists number
When   user Searches defects by Fix Version contain special chars In defectTracking page
Then   To be able to search defects by Fix version contains special chars
When   User Searches Defects by Fix version contain Special chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Fix version consists Special chars
When   user Searches defects by Fix version contain White spaces in defect tracking
Then   Should able to search defects by Fix version Contains White spaces
When   User Searches Defects by Fix version contain  white spaces in Test Execution Page
Then   In Test Execution Page,Defects should be searched by Fix version contains  white spaces
When   In Defect Tracking page,user Searches defects by Fix version contain Alpha numeric chars
Then   Should able to search defects by Fix version contains Alpha numeric chars
When   User Searches defects by Fix version contains alpha numeric Chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Fix version consists Alpha Numeric chars
When   user searches defects by Fix version contain international chars in Defect Tracking Page
Then   should able to search Defects by Fix version contains International chars
When   User Searches defects By Fix version contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Fix version contains International chars

@Search_Defect
Scenario:229 Search defects by text custom field using JQL
Given  DEFECT TRACKING Page is launched BY User
When   user Searches defects by Text custom field Contains long Name
Then   to be able to search defects by text custom field contains long name
When   User Searches Defects by text custom field contain Long name in TestExecution Page
Then   In Test ExecutionPage,Defects should search by Text custom field
When   user Searches defects by text custom field contains number In Defect Tracking
Then   should able to search defects by text Custom field contains number
When   User Searches Defects by text custom field contain number in TestExecution Page
Then   In TestExecution Page,Defects should search by text custom field contains number
When   user Searches defects by text custom field contain special chars In defectTracking page
Then   to be able to search defects by text custom field contains special chars
When   user searches defects by text custom field contain special chars in TestExecution Page
Then   In Test Execution Page,Defects should search by text custom field consists special chars
When   user Searches defects by text custom field contain  white spaces in defect tracking
Then   Should able to search defects by text custom field contains  white spaces
When   User Searches defects by text custom field contain  white spaces in TestExecution Page
Then   in Test Execution Page,Defects should search by text custom field contains  white spaces
When   In defect Tracking page,user Searches defects by text custom field contain alpha numeric chars
Then   Should able to search defects by text custom field contains alpha numeric chars
When   User Searches defects by text custom field contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,defects should search by text custom field consists Alpha numeric chars
When   user Searches defects by Text custom field contain international chars in Defect Tracking Page
Then   should be searched Defects by Text custom field contains International chars
When   User Searches defects by text custom field contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by text custom field Consists International chars

@Search_Defect
Scenario:230 Search defects by Free text custom field using JQL
Given  DEFECTTRACKING Page is Launched By the User
When   user Searches defects by Free text which Contains long name
Then   Should able to search defects by Free text contains Long name
When   User Searches defects by Free text contain Long name in TestExecutionPage
Then   in Test Execution Page,Defects should search by Free Text
When   user Searches Defects by Free text contains number In Defect Tracking
Then   Should be searched defects by Free text contains number
When   User Searches defects By Free text contain number in TestExecution Page
Then   In TestExecution Page,Defects should be searched by Free text contains number
When   user Searches Defects by Free text contain special chars In defectTracking page
Then   Should able to search defects by Free text contains special chars
When   User Searches defects by Free text contain special chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Free text consists special chars
When   user searches defects by Free text contain  white spaces in defect tracking
Then   should able to search defects by Free text contains  white spaces
When   User Searches defects by Free text contain  white spaces in TestExecution Page
Then   In Test Execution Page,Defects should search by Free text contains  white spaces
When   In Defect Tracking page,user Searches defects by Free text contain alpha numeric chars
Then   Should able to search defects by Free text contains alpha numeric chars
When   User Searches defects by Free text contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Free text consists Alpha numeric chars
When   user Searches defects by Free text contain international chars in Defect Tracking Page
Then   should able to search defects by Free text contains International chars
When   User Searches defects by Free text contain international chars in TestExecution Page
Then   In TestExecution page,Defects should search By Free text Consists International chars

@Search_Defect
Scenario:231 Search defects by checkbox custom field using JQL
Given  User Navigates to defect Tracking app
When   User searches Defects By checkbox custom field  Contains long name
Then   To be able to Search defects by checkbox custom field contains long name
When   User Searches Defects by checkbox custom field contain Long name in TestExecution Page
Then   In TestExecution page,Defects should Search by checkbox custom field
When   user searches Defects by checkbox custom field contains number In Defect Tracking
Then   Should be searched defects by checkbox custom field contains Number
When   User Searches defects By checkbox custom field contain number in TestExecution Page
Then   In Test Execution Page,Defects should be searched by checkbox custom field contains Number
When   user Searches defects by Checkbox custom field contain special chars In defectTracking page
Then   Should be able to search defects by checkbox custom field contains special chars
When   User Searches defects by checkbox custom field contain special chars in TestExecution Page
Then   In testExecution Page,Defects should search by checkbox custom field consists special chars
When   user Searches defects by checkbox custom field contain  white spaces in Defect Tracking
Then   should able to search defects by checkbox custom field contains  white spaces
When   User Searches defects bycheckbox custom field contain  white spaces in TestExecution Page
Then   In Test Execution page,Defects should search by checkbox custom field contains White spaces
When   In Defect Tracking page,user Searches defects by checkbox custom field contain alpha numeric chars
Then   Should able to search defects by checkbox custom field contains Alpha numeric chars
When   User Searches defects by checkbox custom field contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by checkbox custom field consists Alpha numeric chars
When   user Searches defects by checkbox custom field contain international chars in Defect Tracking Page
Then   should able to search defects by checkbox custom field contains International chars
When   User Searches defects by checkbox custom field contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by checkbox custom field contains International Chars

@Search_Defect
Scenario:232 Search defects by Radio custom field using JQL
Given  User navigates to Defect Tracking app
When   User searches Defects By Radio custom field Contains Long name
Then   To be Able to Search defects by Radio custom field contains long name
When   User Searches Defects by Radio custom field contain Long name in TestExecution Page
Then   In Test Execution Page,Defects should Search by Radio custom field
When   user searches Defects by Radio custom field contains number In Defect Tracking
Then   Should be searched defects by Radio custom field contains Number
When   User Searches Defects By Radio custom field contain number in TestExecution Page
Then   In Test Execution page,Defects should be searched by Radio custom field contains Number
When   user Searches defects by Radio custom field contain special chars In defectTracking page
Then   Should be able to search defects by Radio custom field contains special chars
When   User Searches defects by Radio custom field contain special chars in TestExecution Page
Then   In test Execution Page,Defects should search by Radio custom field consists special chars
When   user Searches Defects by Radio custom field contain  white spaces in Defect Tracking
Then   should able to search defects by Radio custom field contains  white spaces
When   User Searches defects by Radio custom field contain  white spaces in TestExecution Page
Then   In Test Execution page,Defects should search by Radio custom field contains White spaces
When   In Defect Tracking page,user Searches defects by Radio custom field contain alpha numeric chars
Then   Should able to search defects by Radio custom field contains Alpha numeric chars
When   User Searches defects by Radio custom field contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Radio custom field consists Alpha numeric chars
When   user Searches defects by Radio custom field contain international chars in Defect Tracking Page
Then   should able to search defects by Radio custom field contains International chars
When   User Searches defects by Radio custom field contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Radio custom field contains International Chars

@Search_Defect
Scenario:233 Search defects by single select custom field using JQL
Given  DEFECT TRACKING Page is Launched By The User
When   user Searches defects by Single select custom field which Contains long name
Then   should be able to search defects by single select custom field contains Long name
When   User Searches defects by single select custom field contain Long name in TestExecutionPage
Then   in Test Execution Page,Defects should search by single select custom field
When   user Searches Defects By single select custom field contains number In Defect Tracking
Then   Should be searched Defects By single select custom field contains Number
When   User Searches defects By single select custom field contain number in TestExecution Page
Then   In TestExecution Page,Defects should be searched by single select custom field contains number
When   user Searches Defects by single select custom field contain special chars In DefectTracking page
Then   Should able to search defects by single select custom field contains special chars
When   User Searches defects by single select custom field contain special chars in TestExecution Page
Then   In Test Execution Page,Defects should search by single select custom field consists special chars
When   user searches defects by single select custom field contain  white spaces in Defect tracking
Then   should able to search defects by single select custom field contains  white spaces
When   User Searches defects by single select custom field contain  white spaces in TestExecution Page
Then   In Test Execution Page,Defects should search by single select custom field contains  white spaces
When   In Defect Tracking page,user Searches defects by single select custom field contain alpha numeric Chars
Then   Should able to search defects by single select custom field contains alpha Numeric chars
When   User Searches defects by single select custom field contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by single select custom field consists Alpha numeric chars
When   user Searches defects by single select custom field contain international chars in Defect Tracking Page
Then   should able to search defects by single select custom field contains International chars
When   User Searches defects by single select custom field contain international chars in TestExecution Page
Then   In TestExecution page,Defects should search By single select custom field Consists International chars

@Search_Defect
Scenario:234 Search defects by multi select custom field using JQL
Given  DEFECT Tracking Page is Launched BY the User
When   user Searches Defects by Multi select custom field Contains long name
Then   Should able to Search defects by multi select custom field contains long name
When   User Searches defects By multi select custom field contain Long name in TestExecution Page
Then   In Test Execution page,Defects should search by multi select custom field
When   user Searches Defects by multi select custom field contains number In Defect Tracking
Then   Should be able to search defects by multi select custom field contains number
When   User Searches defects By multi select custom field contain number in TestExecution Page
Then   In Test Execution Page,Defects should search by multi select custom field contains number
When   user Searches defects by multi select Custom field contain special chars In defectTracking page
Then   To be able to search defects by multi select custom field contains special chars
When   User Searches defects by multi select custom field contain special chars in TestExecution Page
Then   In TestExecution Page,Defects should search by multi select custom field consists special chars
When   user Searches defects by multi Select custom field contain  white spaces in Defect Tracking
Then   Should able to search defects by multi select custom field contains  white spaces
When   User Searches defects by multi select custom field contain  white spaces in TestExecution Page
Then   In Test Execution Page,Defects should search by multi select custom field contains White spaces
When   In Defect Tracking page,user Searches defects by multi select custom field contain alpha numeric chars
Then   Should able to search defects by multi select custom field contains Alpha numeric chars
When   User Searches defects by multi select custom field contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by multi select custom field consists Alpha numeric chars
When   user Searches defects by multi select custom field contain international chars in Defect Tracking Page
Then   should able to search defects by multi select custom field contains International chars
When   User Searches defects by multi select custom field contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Multi select custom field contains International chars

@Search_Defect
Scenario:235 Search defects by single version picker custom field using JQL
Given  DEFECT TRACKING Page is Launched BY USER
When   user Searches defects by single version picker custom field Contains long name
Then   Should able to search defects by single version picker custom field contains long name
When   User Searches defects by single version picker custom field contain Long name in TestExecution Page
Then   In Test Execution Page,Defects should search by single version picker custom field
When   user Searches defects by single version picker custom field contains number In Defect Tracking
Then   Should able to search defects by single version picker custom field contains number
When   User Searches defects by single version picker custom field contain number in TestExecution Page
Then   In Test Execution Page,Defects should search by single version picker custom field contains number
When   user Searches defects by single version picker custom field contain special chars In defectTracking page
Then   Should able to search defects by single version picker custom field contains special chars
When   User Searches defects by single version picker custom field contain special chars in TestExecution Page
Then   In Test Execution Page,Defects should search by single version picker custom field consists special chars
When   user Searches defects by single version picker custom field contain  white spaces in defect tracking
Then   Should able to search defects by single version picker custom field contains  white spaces
When   User Searches defects by single version picker custom field contain  white spaces in TestExecution Page
Then   In Test Execution Page,Defects should search by single version picker custom field contains  white spaces
When   In Defect Tracking page,user Searches defects by single version picker custom field contain alpha numeric chars
Then   Should able to search defects by single version picker custom field contains alpha numeric chars
When   User Searches defects by single version picker custom field contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by single version picker custom field consists Alpha numeric chars
When   user Searches defects by single version picker custom field contain international chars in Defect Tracking Page
Then   should able to search defects by single version picker custom field contains International chars
When   User Searches defects by single version picker custom field contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by single version picker custom field Consists International chars

@Search_Defect
Scenario:236  Search defects by multi version picker custom field using JQL
Given  User Navigates To defect Tracking Page
When   User searches Defects By Multi version picker Custom field  Contains long name
Then   To be able to Search defects by Multi version picker Custom field contains long name
When   User Searches Defects by Multi version picker Custom field contain Long name in TestExecution Page
Then   In TestExecution page,Defects should Search by Multi version picker Custom field
When   user searches Defects by Multi version picker Custom field contains number In Defect Tracking
Then   Should be searched defects by Multi version picker Custom field contains Number
When   User Searches defects By Multi version picker Custom field contain number in TestExecution Page
Then   In Test Execution Page,Defects should be searched by Multi version picker Custom field contains Number
When   user Searches defects by Multi version picker Custom field contain special chars In defectTracking page
Then   Should be able to search defects by Multi version picker Custom field contains special chars
When   User Searches defects by Multi version picker Custom field contain special chars in TestExecution Page
Then   In testExecution Page,Defects should search by Multi version picker Custom field consists special chars
When   user Searches defects by Multi version picker Custom field contain  white spaces in Defect Tracking
Then   should able to search defects by Multi version picker Custom field contains  white spaces
When   User Searches defects by Multi version picker Custom field contain  white spaces in TestExecution Page
Then   In Test Execution page,Defects should search by Multi version picker Custom field contains White spaces
When   In Defect Tracking page,user Searches defects by Multi version picker Custom field contain alpha numeric chars
Then   Should able to search defects by Multi version picker Custom field contains Alpha numeric chars
When   User Searches defects by Multi version picker Custom field contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Multi version picker Custom field consists Alpha numeric chars
When   user Searches defects by Multi version picker Custom field contain international chars in Defect Tracking Page
Then   should able to search defects by Multi version picker Custom field contains International chars
When   User Searches defects by Multi version picker Custom field contain international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Multi version picker Custom field contains International Chars




@Search_Defect1
Scenario:237  Search defects by Summary using JQL
Given  User navigates To defect Tracking Page
When   User Searches Defects By Summary Contains long name
Then   To be able to Search defects by Summary contains long name
When   User Searches Defects By Summary Contain Long name in TestExecution Page
Then   In TestExecution page,defects should Search by Summary
When   user searches Defects by Summary Contains Number In Defect Tracking
Then   Should be searched defects by Summary which contains Number
When   User Searches defects By Summary contain number in TestExecution Page
Then   In Test Execution Page,Defects should be searched by Summary contains Number
When   user Searches defects by Summary Contain special chars In defectTracking page
Then   Should be able to search defects by Summary contains special chars
When   User Searches defects by Summary contain special chars in TestExecution Page
Then   In testExecution Page,Defects should search by Summary consists special chars
When   user Searches defects by Summary contain  white spaces in Defect Tracking
Then   should able to search defects by Summary contains  white spaces
When   User Searches defects by Summary contain  white spaces in TestExecution Page
Then   In Test Execution page,Defects should search by Summary contains White spaces
When   In Defect Tracking page,user Searches defects by Summary contain alpha numeric chars
Then   Should able to search defects by Summary contains Alpha numeric chars
When   User Searches defects by Summary contain alpha numeric chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Summary consists Alpha numeric chars
When   user Searches defects by Summary contain international chars in Defect Tracking Page
Then   should able to search defects by Summary contains International chars
When   User Searches defects by Summary contain international chars in TestExecution Page
Then   In TestExecution Page,Defects should search by Summary contains International Chars

@Search_Defect
Scenario:238 Search defects by Description using JQL
Given  User navigates to DefectTracking Page
When   User Searches Defects By Description Contains Long Name
Then   To Be able to Search defects by Description contains long Name
When   User Searches Defects By Description Contain long Name in TestExecution Page
Then   In TestExecution page,defects should Search By Description
When   user searches defects by Description Contains Number In Defect Tracking
Then   Should be searched defects by Description which should contains Number
When   User searches defects By Description contain number in TestExecution Page
Then   In Test Execution Page,Defects to be searched by Description contains Number
When   user Searches defects by Description Contain Special chars In defectTracking page
Then   Should be able to search defects By Description contains special chars
When   User Searches defects by Description contain special chars In TestExecution Page
Then   In TestExecution Page,Defects should search by Description consists special chars
When   user Searches defects by Description contains  white spaces in Defect Tracking
Then   should able To search defects by Description contains  white spaces
When   user Searches defects by Description contain  white spaces in TestExecution Page
Then   In TestExecution page,Defects should search by Description contains White spaces
When   In defect Tracking page,user Searches defects by Description contain alpha numeric chars
Then   should able to search defects by Description contains Alpha numeric chars
When   User searches defects by Description contain alpha numeric chars in TestExecution Page
Then   In Test execution Page,Defects should search by Description consists Alpha numeric chars
When   user Searches defects by Description contain international chars in Defect tracking Page
Then   should able to search defects by Description contains international chars
When   User Searches defects by Description contains international chars in TestExecution Page
Then   In Test Execution Page,Defects should search by Description contains International Chars

@Search_Defect1
Scenario:222  Search defects by status using JQL
Given  user Navigates To Defect Tracking Page
When   User searches Defects By Search open defects by status open
Then   To be able to Search defects by status open
When   User Searches Defects by status open in TestExecution Page
Then   In TestExecution page,Defects should Search by status open
When   user searches Defects by status In Progress In Defect Tracking page
Then   Should be searched Defects by status In Progress In Defect Tracking page
When   User Searches defects by status In Progress in TestExecution Page 
Then   In Test Execution Page,Defects should be searched by status In Progress
When   user Searches defects by status Resolved In Defect Tracking page
Then   Should be able to search defects by status Resolved In Defect Tracking page
When   User Searches defects by status Resolved in TestExecution Page
Then   In testExecution Page,Defects should search by status Resolved
When   user Searches defects by status Closed in Defect Tracking
Then   should able to search defects by status Closed in Defect Tracking
When   User Searches defects by status Closed in TestExecution Page
Then   In Test Execution page,Defects should search by status Closed
When   user searches Defects by status Reopened In Defect Tracking page
Then   Should be searched Defects by status Reopened In Defect Tracking page
When   User Searches defects by status Reopened in TestExecution Page 
Then   In Test Execution Page,Defects should be searched by status Reopened
When   user Searches defects by custom status In Defect Tracking page
Then   Should be able to search defects by custom status In Defect Tracking page
When   User Searches defects by custom status in TestExecution Page
Then   In testExecution Page,Defects should search by custom status
When   user Searches defects by status Resolved and resolution Fixed in Defect Tracking
Then   should able to search defects by status Resolved and resolution Fixed in Defect Tracking
When   User Searches defects by status Resolved and resolution Fixed in TestExecution Page
Then   In Test Execution page,Defects should search by status Resolved and resolution Fixed
When   user Searches defects by status Resolved and resolution Wont Fix in Defect Tracking
Then   should able to search defects by status Resolved and resolution Wont Fix in Defect Tracking
When   User Searches defects by status Resolved and resolution Wont Fix in TestExecution Page
Then   In Test Execution page,Defects should search by status Resolved and resolution Wont Fix
When   user Searches defects by status Resolved and resolution cannot reproduce in Defect Tracking
Then   should able to search defects by status Resolved and resolution cannot reproduce in Defect Tracking
When   User Searches defects by status Resolved and resolution cannot reproduce in TestExecution Page
Then   In Test Execution page,Defects should search by status Resolved and resolution cannot reproduce
When   user Searches defects by status Resolved and resolution Incomplete in Defect Tracking
Then   should able to search defects by status Resolved and resolution Incomplete in Defect Tracking
When   User Searches defects by status Resolved and resolution Incomplete in TestExecution Page
Then   In Test Execution page,Defects should search by status Resolved and resolution Incomplete
When   user Searches defects by status Resolved and resolution Duplicate in Defect Tracking
Then   should able to search defects by status Resolved and resolution Duplicate in Defect Tracking
When   User Searches defects by status Resolved and resolution Duplicate in TestExecution Page
Then   In Test Execution page,Defects should search by status Resolved and resolution Duplicate



@Search_Defect
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE