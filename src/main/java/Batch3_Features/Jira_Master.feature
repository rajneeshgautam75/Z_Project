Feature: Jira_Master

@Jira
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Jira
Scenario: 51 Import Selected requirement from JIRA by JQL
Given User is in Requirements App
 When User click on Import button and User select Jira Option  
 When User performs JQL operation and select single/multiple defect requirements
 Then should be able to import selected requirement
 
 @Jira
 Scenario: 52 Import Selected requirement from JIRA by filter
Given User is in a Requirements App
 When User click on the Import button and User select Jira Option 
 When User search requirement by filter operation and select single/multiple defect requirements
 Then should be able to import the selected requirement
 
@Jira
Scenario: 53 Import all searched requirement from JIRA by JQL
Given User is in a Requirements App page
 When User click on the Import button and chooses the import type as Jira
 When User search requirement by JQL operation and select all searched defect requirements
 Then should be able to import all the searched requirement

@Jira
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE

@Jira
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Jira
Scenario: 54 Import all searched requirement from JIRA by filter
Given User is in Requirements App page
 When User click on the Import button and chooses import type as Jira  
 When User search requirement by filter operation and select all searched defect requirements
 Then Should be able to import all the searched requirement
 
@Jira
Scenario: 55 Import all searched requirement from JIRA by sub-folder priority
Given User is in the Requirements App page
 When User click on the Import button and choose import type as an Jira 
 When User search requirement by JQL operation and select sub-folder as priority
 And User select the all searched requirements and perform import all operation
 Then Should be able to view the orderly arranged priority subfolder requirement


@Jira
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Jira
Scenario: 56 Import all searched requirement from JIRA by sub-folder component
Given User is in an Requirements App page
 When User click on the Import option button and chooses the import type as Jira 
 When User search requirement by JQL operation and select sub-folder as component
  And User select the all searched requirements and perform the import all operation
 Then Should be able to view the orderly arranged component subfolder folder requirement

@Jira
Scenario: 57 Import all searched requirement from JIRA by sub-folder environment
Given User is in an Requirements app page
 When User click on the Import option button and choose the import type as Jira  
 When User search requirement by JQL operation and select sub-folder as environment
  And User select the All searched requirements and perform the import all operation
 Then Should be able to view the orderly arranged environment subfolder folder requirement

@Jira
Scenario: 58 Import all searched requirement from JIRA by sub-folder FixVersion
Given User is in Requirements app page
 When User click on the Import select button and choose the import type as Jira 
 When User search requirement by JQL operation and select sub-folder as FixVersion
  And User select the All searched requirements and perform import all operation
 Then Should be able to view the orderly arranged FixVersion subfolder folder requirement

@Jira
Scenario: 59 Import all searched requirement from JIRA by sub-folder AffectedVersion
Given User is in the Requirements app page
 When User click on the Import select button and choose the import type as the Jira 
 When User search requirement by JQL operation and select sub-folder as AffectedVersion
  And User select the All searched requirements and perform an import all operation
 Then Should be able to view the orderly arranged AffectedVersion subfolder folder requirement

@Jira
Scenario: 60 Import all searched requirement from JIRA by sub-folder IssueType
Given User is in the requirements app page
 When User click On the Import select button and choose the import type as the Jira
 When User search requirement by JQL operation and select sub-folder as IssueType
  And User Select the All searched requirements and perform an import all operation
 Then Should be able to view the orderly arranged IssueType subfolder folder requirement


@Jira
 Scenario: 61 Import all searched requirement from JIRA by  sub-folder Status
   Given user launch the requirement app
    When user clicks on import button
    And select a jira option
    When user import all requirements
    Then user checks the sub folder under the imported node 

@Jira
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Jira    
Scenario: 63 Copy and paste imported requirement to Local tree
   Given user is in the page of requirements
    When user chooses import type as Jira
     And user perform jql operation
    When import jira requirements
    Then Should be able to copy and paste imported Jira requirement folder to local tree     
     

@Jira
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE
 
 @Jira
 Scenario: 62 Import all searched requirement from JIRA by sub-folder project
Given user is on requirement app 
When  user click on Import button and Select JIRA option
And user search requirement by JQL/filter select sub-folder as Status click on Import all button
Then Check the sub_folders under imported node

@Jira
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Jira
Scenario: 64 drag and drop the requriments from import and local 
Given user must in requriment page
When user has to click on import and click on jira
And user search for poject using JQL and click on import all
Then Check the imported node
When user drag and drop the requirment
Then imported node successfully copied to local node

 
@Jira
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE