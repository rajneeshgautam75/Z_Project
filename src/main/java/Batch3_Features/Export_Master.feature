Feature: Export_Master

@ExportTC
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@ExportTC
Scenario: In TCE,execute testcases
Given User is in a page of the testrepository
 When User create a phase with testcases
 When User Launch TestPlanning and creates a cycle,creates a phase by choosing an existing phase
 Then User Launch TestExecution and execute the testcases
 When User Launch Requirements and create a node
  And User create a requirements with different priority values
  Then User map testcases to the requirement

@ExportTC
Scenario: 42 Export tree node with requirements at any level
Given User is in the Requirements App
 When User click on Export Requirements button  
 Then User perform export operation on partially executed to any status and execute data report to excel file
 When User perform export operation based on partially executed to any status and execute summary report to any format
 Then should be able to export requirement
 
@ExportTC
Scenario: 43 Export tree node with requirements at any level
Given User is In the Requirements App
 When User select the Export Requirements button  
 Then User perform export operation on the partially executed to any status and execute data report to excel file and export
 When User perform export operation based on the partially executed to any status and execute summary report to any format
 Then should be able to export the requirement
 
@ExportTC
Scenario: 44 Filter Requirements by specific creator,certain Priority,and a specific date range with coverage, and export Requirement Only
Given User is In the Requirements App page
 When User click on release and select the Export Requirements Option
 Then User perform export operation by filtering creator,priority and specific date with coverage with summary report to any format and export
 Then User perform export operation by filtering creator,priority and specific date with coverage with detailed report to any format and export
 Then User perform export operation by filtering creator,priority and specific date with coverage with data(excel) report to any format and export

@ExportTC
 Scenario: 45 Export tree node with requirements at any level
Given User is in the Requirements page App
 When User click on the Export Requirements button  
 Then User perform export operation using filter by coverage irrespective of status and execute report in summary view to any format
 When User perform export operation using filter by coverage irrespective of status and execute report to data excel
 Then should be Able to export the requirement

@ExportTC
Scenario: 40 Export tree node with requirements any level
Given user is in the Requirements app page
 When user click on release and select the Export Requirements Option
 Then user perform export operation and execute data report to excel format and export
 Then User perform export operation and execute data report to summary format and export
 Then User perform export operation and execute data report to detailed and export 

@ExportTC
Scenario: 41 Export tree node with requirements any level
Given user is in the requirements app page
 When User allocates the nodes created in global node in different releases
 When user click on the release and select the Export Requirements Option
 Then user perform export operation and execute the excel report to any format
 Then User perform export operation and execute the summary report to any format
 Then User perform export operation and execute the detailed report to any format
 
@ExportTC
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE