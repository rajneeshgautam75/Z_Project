
Feature: Requirement Master Feature
@Req

Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE
@Req
Scenario: 1 Create a top level and child level requirement node in release tree
Given User is in requirement module page
When user select the release
And add two parent nodes with name and description
And add three sub nodes under parent each node with name and description for only two sub nodes 
Then sub nodes created successfully under parent node

@Req
Scenario: 2 Add multiple requirements to each level top & child in Current release with minimum required fields like altid,Prioroty,Link,req details

Given User is in requirement module page
When user select the release
And navigate to first parent and child nodes and add two requirements to all the nodes with fields priority,altId,Link and req details 
Then requirements added in all the nodes  
When navigate to second parent and child nodes and add two requirements to all the nodes with fields priority,altId,Link and req details  
Then requirements added in all the second nodes  


@Req
Scenario: 3 Edit requirement details, modify and save the Changes

Given User is in Requirement_Page of normal_Project 
 When  As lead, create a phase and system in RequirementPage 
 And  Add few requirements at different level of node
 Then requirements should be added at different level of node
 When Edit the requirements details by updating Link,priority,atl id details and save
 Then requirements details should be updated 
 When Edit the requirements details by updating Link,priority,atl id details and click on cancel 
 Then requirement details should not be modified

@Req
Scenario: 4 Copy single/multiple requirements using [Clone] button in data grid (Global tree/Release tree)
Given User is in requirement module page
When user select the release
	And add a node with name and description
	And add a single requirement in the created node
	And copy the single requirement using clone option
	Then single requirement should be copied to the node
When user copy the multiple requirement more than four hundered using clone option
Then multiple requirement should be copied to the node

@Req
Scenario: 5 Attempt to copy Single/mutiple selected requirements from one node to another in current release
Given User is in requirement module page
When user select the release
When user add a node and add multiple requirement to the node
Then check the requirement count
When user add another node with name and description
And copy the single requirement from first node to second node using Ctrl+DND
Then requirement should not be copied to the second node
When user select multiple requirement more than hundered
And copy the selected requirement the second node
Then single requirement should not be copied to the second node


@Req
Scenario: 6 Copy requirement from imported node to the node under release
Given User is in requirement module page
When user click on import button and select excel option
And Create a mapping from excel sheet
And Add job and run the job
Then import operation is successfully
When user move the imported folder to global node
Then node should be moved to global node
When user run another job 
And copy the imported node to global node
Then node should be pasted to the global node
When user run another job and copy the imported node to current release
Then imported node should be copied to the local release
When user run another job and move the imported node to current release
Then node should be moved to the current release


@Req
Scenario: 7 Deallocate single/multiple requirements
Given User is in requirement module page
When user select the release
	And add a node in the local release with multiple requirement
	Then multiple requirements added in the node
	And user view the requirement count in global node
	When user select single requirement from local node and deallocate 
	Then requirement should be deleted from local node
	And view the requirement count in global node,requirement should be present in global node
  When user select multiple requirement from local node and deallocate 
	Then requirements should be deleted from local node
	And view the requirement count in global node,requirements should be present in global node

@Req
Scenario: 8 Delete single/multiple requirements
Given User is in requirement module page
When user select the release
	And add a node in the local release with multiple requirements
	Then multiple requirements should be added in the node
	And user view the requirement count in Global node
	When user select single requirement from local node and delete it 
	Then single requirement should be deleted from local node
	And view the requirement count in Global node,requirement should be present in global node
  When user select multiple requirement from local node and delete it 
	Then multiple requirements should be deleted from local node
	And view the requirement count in Global node,requirements should be present in global node
	
	
	
	@Req
	Scenario: 9 Deallocate a requirement node
Given User is in requirement module page
When user select the release
	And add a first phase in local release with requirements
	Then requirement should be added in first node
	When user add a child node to the first phase with requirement 
	Then requirement should be added in child node unde first phase
When user create a second phase and create two child node under second phase
	And Add requirements to all the nodes
	Then requirement should be added in the nodes
	When user create a third phase with no requirements
	And view the requirement count 
	When user select the first phase and deallocate it
	Then first phase with child nodes should be removed from local release
	But first phase with child nodes should be present in Global node
	When user navigate to child node under second phase and deallocate it
	Then child node should be should be removed from local release
	But child node should be should be present in Global node
	When user navigate to the third phase and deallocate it
	Then third phase should be should be removed from local release
	But third phase should be should be present in Global node
	
	
		@Req
	Scenario: 10 Delete requirement node
Given User is in requirement module page
When user select the release
When User add a first phase with requirement
Then requirement should be added in the first phase
When user create a child node under first phase and add requirement in it
Then requirement should be added in the child node
When user add a second phase with two requirements
Then requirement should be added in the second phase	
When user create a child node under second phase and add requirement in it
Then requirement should be added in the child node present under second phase
When user add a third phase with no requirements
And view the requirement count of third phase
When user navigate to first phase under local release and delete it
Then first phase with child node should be deleted from local release
And first phase with child node should be deleted from Global folder
When user navigate to child node of second phase under local release and delete it
Then child node under second phase should be deleted from local release
And child node under second phase should be deleted from Global folder
When user navigate to third phase under local release and delete it
Then third phase should be deleted from local release
And third phase should be deleted from Global folder
	
	
	@Req
Scenario: 13 Copy Single/mutiple selected requirements from one node to another in Global tree
Given User is in requirement module page
When user selct the global folder Node
And add a node with requirements
Then requirements should be added in the node
When user add another node with empty requirements in it
Then no requirement should be present in the node
When user selects multiple requirements from first node
And copy the selected requirement to second node in global tree using ctrl+Dnd
Then requirements should be copied to the second node in global tree


@Req

Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Req
Scenario: 14 Move Single/mutiple Selected requirements from one node to another in Global tree
Given User is in requirement module Page
When user selct the global folder Node
And add a first node with requirements in Global tree
Then requirements should be added in the first node
When user add second node in global tree with empty requirements in it
Then no requirement should be present in the second node
When user selects multiple requirements from first Node present in global tree
And move the selected requirement to second node in global tree using Dnd
Then requirements should be moved to the second node in global tree
	
@Req
Scenario: 15 Allocate Node/Requirements to release
Given User is in requirement module page
When user selct the global folder Node
And add two node in global tree
And add multiple requirements to both the nodes
Then requirements should be added in both the nodes
When user selects the multiple requirements from first node
And click on allocate option button
Then selected requirements with folder structure should be allocated to the current release
When user selects second node from global tree
And choose allocate option from context menu
Then global node should be allocated to current release with requirements in it
When user add a node in local release tree
And navigate to the same node in global tree and add multiple requirement in it
And allocate the node from global tree
Then newly added requirement in global tree should show in current release 
When user allocate a second node which is already in local relase with all requirements
Then allocated successfully message should show up
	
	
	@Req
Scenario: 16 Create requirement with custom fields with Mandatory field
Given Login as manager 
When user click on administration and select custom fields of type requirement
And create all type of custom fields for all projects with one mandatory fields
And logout from the application
And user navigate to requirement module page
And create a node and add requirement in it
And enter the value for all custom fields
And add one more requirement and update the requirement name without entering mandatory custom field
Then requirement name should not be save
@Req
Scenario: 17 Update the custom fields of the requirements
Given User is in requirement module page of normal Project
When user select the release
	And add a requirement node 
	And add requirement and enter all custom fields value, save it
	Then requirement should be added with custom fields value
	When user select the requirement and update custom fields value ,save it
	Then custom fields value should be updated successfully
	When user select the requirement and update custom fields value and cancel the changes
	Then custom fields value should not be updated
  
@Req
Scenario: 18 Attempt to add duplicate value for unique custom fields for requirements
Given User is in requirement module page of normal Project
When user select the release
And add a requirement node with name and description
	And add a requirement to the node
	And enter the unique custom field value and save it
	Then Unique custom field value should be saved
	When user add another requirement and enter same value for Unique custom field
	Then custom field should not allow to enter the same value for Unique custom field
	When user clone the requirement with unique custom field value
	Then requirement should be cloned successfully

	@Req
	Scenario: 29 View the requirements details in detail window and switch between the requirements in detail
Given User is in requirement module page
When user select the release
	And user create a requirement node and add requirements in it
	And enter the requirement detail like alt id,priority,custom fields etc
	Then view the requirement counts
	When user select the first requirement and navigate to detail view using navigator
	Then able to navigate to detail view
	When user change the requirement using symbol(^)
	Then requirements should be changed 
	
		
	@Req
Scenario: 38 Import requirements with unique custom fields value of type Text/Number
Given User is in requirement page of normal Project
When User click on import and choose excel option
And create a map with custom fields rows
Then map should be created sucessfully
When user add a job and run it
Then should be able to import with unique custom field value


@Req

Scenario: 39 Attempt to import requirements with duplicate value for unique custom fields
Given User is in requirement page of normal Project
When User click on import and choose Excel option
And Create a map with custom fields rows
Then map should be Created Sucessfully
When user add a job with duplicate value for unique custom field in Excel and run it
Then should not be able to import with duplicate value for unique custom field
	
	@Req
	  Scenario: 27  switch between the search view and folder view
    Given user is in a page of Requirements
   When user double Clicks on Release node
   And user adds The node 
   And user Adds the Requirements
   Then user is in folder view
   When user navigate to search view
   Then user is successfully switched to search view
   When user move to folder view
   Then user is successfully switched to folder view
 
	@Req
Scenario: 11 Create a top level and child level requirement node in Global tree
Given As manager, Launch Requirement app
When user select Global tree node add a Top level nodes with description
Then top level nodes added successfully
When user will add three sub nodes under each node with desciption for only two sub nodes
Then subnodes added successfully

@Req
Scenario: 12 Add multiple requirements to each level top & child in Global with minimum  required fields like atlid , Prioroty, Link,req details 12
Given user login as manager,launch Requirement app
When user navigate to the top level node under Global tree node 
And user Add requirement to node with detail like atlid,Prioroty,Link
Then user added requirements in top level node with detail
When User navigate to Sub nodes in global tree node under
And  user add Requirements to sub node with detail like atlid,Prioroty,Link.
Then requirment added sucessfully to subnodes
	
	@Req
	Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
