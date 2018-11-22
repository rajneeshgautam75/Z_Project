Feature: External_JIRA Master

@ZExternal_JIRA
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@ZExternal_JIRA
Scenario: Creat two nodes and add multiple test cases 
Given User is in test repository Page
When User add a first node and add testcases
Then test cases added successfully
When user add a second node and add testcases
Then test cases should be added successfully

@ZExternal_JIRA
Scenario:1 65 Modify the imported requirement summary in External JIRA

Given user is in requirement Page
When  User import JIRA requirement
Then  imported JIRA requirement should be present in Imported Tree
When  Drag and drop imported Jira requirement folder to local tree
Then  Requirement Folder should be moved to local tree
When  login into external JIRA
And   In JIRA modify the imported requirement summary
And   Apply notification in Zephyr Application
Then  Check the updated summary
 
 @ZExternal_JIRA
 Scenario:2 66 Modify the imported requirement priority in External JIRA

Given User is in Requirement_Page
When  user import JIRA requirement
Then  Imported JIRA requirement Should be present in Imported Tree
When  Drag and drop Imported Jira requirement folder to local tree
Then  requirement Folder should be moved to local tree
When  Login into external_JIRA
And   In JIRA modify the imported requirement priority
And   Apply notification in Zephyr application
Then  Check the updated priority
 
 @ZExternal_JIRA
 Scenario:3 67 Modify the imported requirement priority in External JIRA

Given user is in Requirement_Page
When  User Import JIRA requirement
Then  Imported JIRA requirement should be present in imported Tree
When  drag and drop Imported Jira requirement folder to local tree
Then  requirement folder should be moved to local tree
When  Login into External_JIRA
And   In JIRA move that requirement to other project
And   Apply Notification in Zephyr application
Then  Check the updated ALT-ID in grid

 @ZExternal_JIRA
Scenario:4 68 Delete imported requirement in JIRA

Given User is in RequirementPage of normal_PRoject
When import JIRA requirement
Then Should import JIRA requirement
When Drag and Drop imported Jira requirement folder to local tree
Then Folder should be moved to local tree
When Login to External_JIRA 
And  Delete imported requirement in JIRA
And  Apply Notification in Zephyr Application
Then After applying notification deleted requirement becomes italic format in ZE
 
@ZExternal_JIRA
Scenario:5 69 Map Imported JIRA req to single/multiple testcase
Given User is in Requirement Page
When User clicks on Import option, chooses JIRA, search JIRA requirements and clicks ImportSelected
Then Imported JIRA Requirements should be present in Imported tree
When Drag and Drop the Imported JIRA node to local tree
Then Imported JIRA Requirements should be present in local tree
When Login as Manager and enable req-tc flag and logout
And Login as lead, navigate to RequirementPage and navigate to Requirement node
And Select requirement, click on Map button and Map a single/multiple testcase  
Then Testcase should be mapped to selected requirement
When Login into External JIRA 
Then check the req-testcase mapping remote link

@ZExternal_JIRA
Scenario:6 70 Unmap Imported JIRA req to single/multiple testcase
Given User is in RequirementPage
When user Import JIRA requirement
Then Imported JIRA requirement should be present in Imported tree
When user Drag and Drops the requirement folder to local tree
Then requirement folder should be present in local tree
When Login as manager and enable the req-tc flag in defect admin app and Logout
And  Login as Lead, navigate to Requirement Page and navigate to requirement folder
And  Select requirement, Click on Map button and Map a single/multiple testcase
Then Testcase should be mapped to Requirement
When Login into external JIRA
Then In JIRA check the req-testcase mapping remote link
When Navigate to Zephyr application and unmap testcase from Requirement
Then In JIRa check the req-testcase mapping remote link

@ZExternal_JIRA
Scenario:7 71 Click on testcase ID on mapped req-testcase remote link

Given User is in Requirement_Page of Normal_Project
When  User clicks on Import option and Import JIRA requirement
Then  imported JIRA requirement should be present in Imported tree
When  Drag and drop imported Jira requirement folder to Local tree
Then  Folder will be moved to local tree
When  Login as manager and enable the req-tc flag in defect admin and Logout
And   Login as Lead , navigate to Requirement Page and requirement
And   Select requirement, click on Map button and map to single/multiple testcase
Then  Testcase Should be mapped to Requirement
When  login into external_JIRA
And   check the req-testcase mapping remote link in External_JIRA
And   Click on testcase ID on that remote link
Then  Should navigate to test repository search window and search for that testcase

@ZExternal_JIRA
Scenario:8 72   Delete JIRA requirement which is mapped to testcases

Given User is in requirementPage
When Import JIRA Requirements
Then Imported JIRA Requiremnts should be present in Imported Tree
When User Drag and drops the Requirement folder to local Tree
Then Requirement folder Should be present in local tree
When Login as Manager, enable req-tc flag and Logout
And  Login as Lead, navigate to RequirementPage and navigate to Requirement folder
And  Select requirement, click on Map testcase and map single/multiple testcases
Then Testcases should be mapped to Requirement
When Login into External JIRa
Then Check req-testcase mapping remote link
When Delete the Requirement in Zephyr application
Then Remote link should be deleted from JIRA

@ZExternal_JIRA
Scenario:9 73   Deallocate JIRA requirement which is mapped to testcases

Given User is in Requirementpage
When User Import's JIRA Requirements
Then Imported JIRA Requiremnt should be present in Imported Tree
When User Drag and drop the Requirement folder to local Tree
Then requirement folder Should be present in local tree
When Login as Manager, enable req-tc flag and Logout from application
And  Login as Lead, navigate to requirementPage and navigate to Requirement folder
And  Select requirement, click on Map testcase and map single/multiple testcase
Then Testcases should be mapped to requirement
When Login into external JIRa
Then check req-testcase mapping remote link
When De-allocate that requirement in ZE
Then Remote link should be deleted from External_JIRA




@ZExternal_JIRA
Scenario:10 74 Delete JIRA requirement node which is mapped to testcases

Given user is in requirementPage
When Import JIRA Requirement
Then Imported JIRA Requirement should be present in Imported Tree
When user Drag and drops the Requirement folder to local Tree
Then Requirement folder should be present in local tree
When Login as manager, enable req-tc flag and Logout
And  Login as Lead, navigate to RequirementPage and navigate to requirement folder
And  Select requirement, click on Map testcase and map single/multiple Testcases
Then testcases should be mapped to Requirement
When Login into external JiRa
Then Check req-testcase mapping Remote link
When Delete the req node which is having req mapped to testcases
Then remote link should be deleted from JIRA

@ZExternal_JIRA
Scenario:11 75 Deallocate JIRA requirement node which is mapped to testcases

Given User is in requirementpage
When Import JIRA requirement
Then Imported JIRA requirement should be present in Imported Tree
When user drag and drops the Requirement folder to local Tree
Then requirement Folder should be present in local tree
When Login as manager, enable req-tc flag and logout
And  Login as lead, navigate to RequirementPage and navigate to requirement folder
And  select requirement, click on Map testcase and map single/multiple Testcases
Then testcases should be mapped to requirement
When login into external JiRa
Then check req-testcase mapping Remote link
When Deallocate the req node which is having req mapped to testcases
Then Remote link should be deleted from jIRA

@ZExternal_JIRA
Scenario:12 76 Delete testcase which is mapped to JIRA requirements


Given User is in Requirement page
When Import JIRa requirement
Then Imported JIRa Requirement should be present in Imported Tree
When User drag and drops the Requirement folder to local Tree
Then Requirement Folder should be present in local tree
When login as manager, enable req-tc flag and Logout
And  login as Lead, navigate to TestRepository and navigate to phase 
And  Select testcase and map to JIRA Requirement
Then testcase should be mapped to Requirement
When login into external JIRa
Then check req-testcase mapping Remote Link
When Navigate to TestRepository and Delete the testcase which is mapped to JIRA requirement
Then Remote link should be Deleted from JIRA


@ZExternal_JIRA
Scenario:13 77 Delete testcase node which is mapped to JIRA requirements

Given User is in requirement Page
When Import JIra requirement
Then Imported JIra Requirement should be present in Imported Tree
When User drag and drops the requirement folder to local Tree
Then Requirement Folder Should be present in local tree
When Login as Manager, enable req-tc flag and logout
And  login as lead, navigate to RequirementPage and navigate to requirement folder
And  select requirement, click on map testcase and map single/multiple Testcases
Then Testcase should be mapped to requirement
When login into external JIra
Then Check req-testcase mapping remote Link
When Navigate to TestRepository and delete the testcase node mapped to JIRA requirement
Then remote link should be Deleted from JIRA



@ZExternal_JIRA
Scenario:14 78 Delete Release which is having testcase mapped to JIRA requirements

Given user is in Requirementpage
When Import jira requirement
Then Imported jira Requirement should be present in Imported Tree
When user drag and drops the requirement folder to local Tree
Then requirement Folder Should be present in local tree
When Login as Manager, Enable req-tc flag and logout
And  login as lead, navigate to requirementPage and navigate to requirement folder
And  Select requirement, click on map testcase and map single/multiple Testcases
Then testcase should be mapped to requirement
When Login into external JIra
Then check req-testcase mapping remote Link
When Delete the release
Then remote Link should be Deleted from JIRA

@ZExternal_JIRA
Scenario:15 79  Delete project which is having testcase mapped to JIRA requirements 
Given user is in requirementpage
When import jira requirement
Then imported jira Requirement should be present in Imported Tree
When User drag and drops the requirement Folder to local Tree
Then requirement Folder should be present in Local tree
When login as Manager, Enable req-tc flag and logout
And  Login as lead, navigate to requirementPage and navigate to requirement folder
And  select Requirement, click on map testcase and map single/multiple Testcases
Then Testcase should be Mapped to requirement
When login into external jira
Then check req-testcase Mapping remote Link
When Delete the Project
Then Remote Link should be Deleted from JIRA


@ZExternal_JIRA
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE