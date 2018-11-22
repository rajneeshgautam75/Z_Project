Feature: search Master

@search
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@search
Scenario: 48 Advance search requirements by using ZQL with available fields
Given User is in a Requirements page
 When User create the phase
 And User add requirements to the node
 When User enter the requirements details along with given custom fields  
 When User search requirements with different zql operators
 Then User should retrieve matching rows
 
@search
  Scenario: 47 Quick search requirements with available fields
    Given user in the requirements page
    When  user add a node and add requirement to the node
    And   enter user enter the requirement name,altId,link,priority
    When  user navigates to search folder
    And   search requirements by id in quick search
    Then  Should be able to retrieve requirements by Id
    When  search requirements by name in quick search 
    Then  Should be able to retrieve requirements by name
    When  search requirements by details in quick search 
    Then  Should be able to retrieve requirements by details
    When  search requirements by AltId in quick search
    Then  Should be able to retrieve requirements by AltId
    When  search requirements by link in quick search
    Then  Should be able to retrieve requirements by link
   
@search
Scenario:  49 Search requirements by using multiple combination of fields in the ZQL query using AND,IN and NOT operators in Advance search requirements 
Given user in the Requirements page
When user adds a node and add requirement to the node
When user enter the requirement name,altId,link,priority and few custom fields
When user Navigates to search view
When search requirements by altid, creator, details, and id, using ZQL
Then should able to retrieve matching rows in requirement
When Search requirements by creator, details and name, using ZQL
Then Should be able to retrieve matching rows in requirement
When Search requirements by details, name and priority, using ZQL
Then Should be able to retrieve matching rows
When Search requirements by name, priority, project and url, using ZQL
Then should be Able to retrieve matching rows
When Search requirements by altid, creator, details, name, priority, project, url, text, long text and picklist,using ZQL
Then should be Able to retrieve the matching rows

@search
Scenario: 50 Export requirements from search results
Given user is in search window of requirement page
When User Uncheck in this release option
And Click on export button in search window
Then user Should export all the search results
When Uncheck in this release and select multiple requirements from search requirements 
And  click on export from search window
Then User should export all the search results

@search
Scenario: 46 Search requirement by Requirement Name in Global tree
Given user is in requirement page
When user create phase and add requirement with name in capital letters
When Uncheck In this release checkbox in search of requirement page 
And Search by requirement name in capital letters
Then view the search results
When user create requirements with name in Alphanumeric and spaces 
And search by requirement name Alphanumeric and spaces 
Then check the detail of searched requirement of alphanumeric and spaces
When Create requirement name in only Numbers
And Search by requirement name in numbers
Then check the detail of searched requirement of numbers
When Create requirement name with special characters
And Search by requirement name in special characters
Then check the detail of searched requirement of special characters
When Create requirements with Long name
And Search by requirement using long name
Then check the detail of searched requirement of long name
When Create requirements with minimum chars in name
And Search by minmum chars 
Then check the detail of searched requirement of minimum chars
When Create requirements name of URL 
And Search by name ofURL
Then check the detail of searched requirement of url
  
@search
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE 