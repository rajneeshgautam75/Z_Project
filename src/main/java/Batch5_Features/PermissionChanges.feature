
Feature: Defect tracking permission changes
  
  @JiraPermission
  Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

  
  @JiraPermission
 Scenario: Precondition 
Given User is in the project Page 
 When user navigate to test repsitory and create a node
 And add testcases to the node
 Then testcases successfully created in node
 When user navigate to test planning page and create a cycle
 And add created phase to cycle and assign to anyone
 Then testcases successfully assigned to anyone
 When user navigate to Test execution page
 And change the status of testcase to pass
 Then status of testcases successfully changed to pass
   
@JiraPermission
Scenario: 71 <DT> Do JIRA operation after JIRA session time out
Given User is in the Project Page 
 When User launch defect tracking to create defect
  And create a defect in defect tracking app
 Then Should be able to Create the defect
 When create subtask in defect tracking app
 Then Should be able to create subtask in defect tracking app
 When search a defect by ID in defect tracking app
 Then Should be able to search defect in DT
 When search a defect by JQL in defect tracking app
 Then Should be able to search a defect in DT app
 When search a defect by filter in defect tracking app
 Then Should be able to search defect using filter
 When launch Test Execution page
  And create a defect in test execution page
 Then Should be able to Create the defect in Test Execution
 When create subtask in test execution page
 Then Should be able to create subtask in test execution page
 When search a defect by ID in test execution page
 Then Should be able to search defect in test execution page
 When search a defect by JQL in test execution page
 Then Should be able to search a defect in test execution page
 When search a defect by filter in test execution page
 Then Should be able to search defect using filter in Test Execution page
  
  
@JiraPermission
Scenario: 70 <DT>ReLogin to Zephyr when Password/Username is Edited in Jira
Given As a manager,launch project page
 When user in the administration page
  And set the DTS to JIRA
 Then Should be able to Set the DTS
 When User is in the Defect tracking page
 Then Should be able to launch defect tracking page
 When login as defect user and reset DTS
 Then Should be able to login successfully 
 When User is in a external jira page
 When User navigate to the user management page
  And edit the change the user name
 Then Should be able to change the user name
 When relogin to Zephyr page
 Then Should be able to re-login successfully
 When launch defect Tracking page
 Then should get message "Authentication failed for defect user admin. Please refresh the page and try again.If your defect user credentials changed,use Reset User button to enter the new credentials.
 When launch test execution page to execute testcase
  And click on D button of a testcase
 Then Should get message "authentication failed for defect user admin.Please refresh the page and try again. If your defect user credentials changed,use Reset User button to enter the new credentials.
  
  
@JiraPermission
Scenario: 73 Attempt to create defect, If user doesn't have create defect permission
Given As a manager,Launch administration
 When launch defect tracking system
  And Set the DTS to JIRA
 Then Should be able to set DTS to JIRA
 When As a Lead,Launch defect tracking page
 Then Should be able to launch Defect Tracking page
 When set the defect user who doesn't have create defect permission
  And attempt to create defect in defect tracking app
 Then Should get proper message 'user doesn't have permission to create defect'
 When create a subtask in defect tracking app
 Then should get the proper Message 'user doesn't have permission to create defect'
 When launch the Test Execution page
  And attempt to create defect in test execution app
 Then should get the proper message 'user doesn't have permission to create defect'
 When create a subtask in test execution app
 Then should get proper Message 'user doesn't have permission to create defect'



@JiraPermission
Scenario: 74 Attempt search defects, If user doesn't have have browse project permission
Given As a manager,Launch Administration page
 When launch the Defect tracking system
  And Set the DTS tO JIRA
 Then Should be able to set the DTS To JIRA
 When launch the external jira page
  And change permission to project permission
 When As a Lead,Launch Defect tracking page
 Then Should be able to launch Defect Tracking Page
 When reset the external DTS login detail
 When search a defect by ID Defect tracking app
 Then Should get proper message 'user doesn't have browser permission for this project' using ID
 When search a defect by JQL in DT App
 Then Should get proper message 'user doesn't have browser permission for this project' using JQL
 When search a defect by filter in DT App
 Then Should get proper message 'user doesn't have browser permission for this project' using MyFilter
 When launch the test_execution page
  And search a defect by ID using test execution app
 Then Should get proper message 'user doesn't have browser permission for this project' using ID in test execution
 When search a defect by JQL in test execution App
 Then Should get proper message 'user doesn't have browser permission for this project' using JQL in test execution
 When search a defect by filter in test execution App
 Then Should get proper message 'user doesn't have browser permission for this project' using MyFilter in test execution
 
@JiraPermission
Scenario: 75 Create defect, If user doesn't have have browse project permission
Given As a manager,Launch the administration
 When Launch the Defect tracking to set DTS
  And Set DTS to the JIRA
 Then Should be able to Set DTS to JIRA
 When launch the External jira page
  And Change permission to project permission
  And As a Lead,Launch the Defect tracking page
 Then Should be able to Launch Defect Tracking page
 When Set the defect user who doesn't have create defect permission
  And Attempt to create defect in defect tracking app
 Then Should get a proper message 'user doesn't have permission to create defect'
 When Create a subtask in defect tracking app
 Then Should get a proper Message 'user doesn't have permission to create defect'
 When Launch the Test Execution page
  And attempt to Create defect in test execution app
 Then Should get the proper message 'user doesn't have permission to create defect'
 When create a Subtask in test execution app
 Then should get a proper message that'user doesn't have permission to create defect'
 
 
@JiraPermission
Scenario: 76 Search defect, If user doesn't have create defect permission
Given As a manager,Launch administration page
 When launch the defect tracking system
  And Set the DTS To JIRA
 Then Should be able to set DTS To JIRA
 When launch external jira page
  And change create defect permission to the defect user
 When As a Lead,launch defect tracking page
 Then Should be able to launch Defect tracking page
 When reset the external DTS login detail
 When search a defect by ID defect tracking app
 Then Should able to search the defect
 When search a defect by JQL in DT app
 Then Should able to search defect
 When search a defect by filter in DT app
 Then Should able to search Defect
 When launch the test execution page
  And search a defect by ID test execution app
 Then Should able to Search the defect in test execution
 When search a defect by JQL in test execution app
 Then Should able to search defect in test execution
 When search a defect by filter in test execution app
 Then Should able to Search Defect in test execution 


@JiraPermission
Scenario: 77 <DT>Attempt to edit defects/subtasks When User have No Edit Issue Permission
Given User in External jira page
 When Change administrator permission to defect permission
  And As a manager,Launch the Administration page
 When Launch the Defect Tracking to set DTS
  And Set an DTS to the JIRA
 Then Should be able to Set an DTS to JIRA
  And As a Lead,Launch the Defect Tracking page
 Then Should be able to launch the Defect Tracking Page
 When Set the defect user who Don't have permission to editing defect
  And Attempt to edit defect in defect tracking app
 Then Should get a proper message 'Don't have permission to editing defect'
 When attempt to edit a subtask in defect tracking app
 Then Should get a proper Message 'user Don't have permission to editing defect'

 
@JiraPermission
Scenario: 78 <DT> Attempt to assign issues,If user have no assign issue permission
 Given User Is in the External_Jira page
 When Navigate to the Projects page
  And change permission to the No Assign Issue
  And As a Manager,launch the Administration Page
  And launch the Defect Tracking to Set the DTS
  And Set the DTS To the JIRA
 Then Should Be able to Set an DTS to JIRA
 When As a Lead,Launch the Defect_Tracking Page
 Then Should Be Able to Launch Defect_Tracking page
 When Set the defect user who doesn't have assign issue permission
  And attempt to assign issues for defect with assignee in defect tracking app
 Then Should not be able to search users in assignee field
 When attempt to assign issues for subtask with assignee in defect Tracking app
 Then should not be able to search users in assignee field in DT app
 When attempt to assign issues in search defect view
 Then Should not able to search users in assignee field using search defect view
 When attempt to assign issues in change multiple window
 Then Should not able to search users in assignee field using change multiple window
 When Launch the Test_Execution Page
  And attempt to create defect with assignee in Test execution app
 Then should not be able to search users in Assignee field
 When attempt to create a subtask with assignee in Test execution app
 Then should not be able to search users in Assignee Field 
 
 
 
 
@JiraPermission
Scenario: 79 <DT> Create defect/sub-task, If user have no assign issue permission
Given User Is in the External Jira page
 When navigate to the projects page
  And Change permission to No Assign Issue
  And As a Manager,Launch the Administration page
  And launch the Defect Tracking to set the DTS
  And Set a DTS To the JIRA
 Then Should Be able to Set a DTS to JIRA
 When As a Lead,Launch The Defect Tracking Page
 Then Should Be Able to Launch Defect Tracking page
 When Set the Defect user who doesn't have assign issue permission
  And Create a defect in defect tracking app
 Then Should be able to create a Defect
 When Create a Subtask in defect Tracking app
 Then Should be able to Create a defect subtask in DT
 When Launch the TestExecution Page
  And Create defect in Test execution app
 Then Should be Able to create a defect in Execution page
 When Create a Subtask in Test execution app
 Then should be able to create a defect subtask test in execution page 

@JiraPermission
Scenario: 80 <DT>Attempt to add comments to defects/subtasks When User have No Assign Issue Permission
Given User Is in the External Jira Page
 When navigate to the Projects page
  And change permission to No Assign Issue
  And As a Manager,Launch the Administration Page
  And launch the DefectTracking to set the DTS
  And set a DTS To the JIRA
 Then Should be able to Set a DTS to JIRA
 When As a Lead,Launch The DefectTracking Page
 Then Should Be able to Launch Defect Tracking page
 When set the Defect user who doesn't have assign issue permission
  And search a defect in defect tracking app
  And attempt to add comment in search defect view
 Then Should get message 'you do not have the permission to comment on this issue' for defect
 When search a Subtask in defect Tracking app
  And attempt to add comment in search defect view for subtask
 Then Should get message 'you do not have the permission to comment on this issue' for the subtask
 
  
@JiraPermission
Scenario: 81 <DT>Attempt to add attachment in defect/subtask When User have No create attachment  Permission
Given User Is in the External_Jira Page
 When User navigate to the projects page
  And change the permission to No Attachment permission
  And As a manager,launch the Administration page
  And launch Defect Tracking to set the DTS
  And Set DTS To the JIRA
 Then Should be able to set a DTS to JIRA
 When As the Lead,Launch the Defect Tracking Page
 Then Should be able to launch defect Tracking page
 When Set the Defect user who doesn't have no attachment permission
  And aatempt to add attachment to the defect in defect tracking
 Then Should get message 'Don't have permission to add attachment' to the defect
 When attempt to add attachment to a subtask in defect Tracking app
 Then Should get message 'Don't have permission to add attachment' to the subtask
 When launch the TestExecution Page
  And attempt to add attachment to the defect in test execution
 Then Should get message 'Don't have permission to add attachment' to the defect in test execution
 When attempt to add attachment to the subtask in test execution
 Then Should get message 'Don't have permission to add attachment' to the subtask in test execution 
 
 
 @JiraPermission
Scenario: 249 <DT> As Mgr/Lead, change a defect/Subtask with Assigned to field other than the default owner(JIRA project Lead) of the project 
Given User is in the External Jira Page
 When User navigate to the user management and create four users
  And create the users with the available fields and assign users to jira administrator group 
  And create a project in external jira using first created user
  And components and version to the respective project
  And login as manager,set the DTS with first created user and refresh the page
  And navigate to the project setup page and create a project
  And map the external jira project to the above created project
  And as a lead,launch the defect tracking page
  And login to the external dts with other user not with the setted dts user
  And create a defect with all relevant values and assignee field
 Then Should be able to create a defect with other assignee
 When search the created defect to verify the assigned to field
 Then Should be able to validate the assignee
 #
 @JiraPermission
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
  