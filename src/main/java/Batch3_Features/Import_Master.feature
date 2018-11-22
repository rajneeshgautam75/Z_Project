Feature: Import Functionality
@Import
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Import
Scenario:1 30 Create a map with available discriminators
Given User in requiement Page
	And click on import create map with By empty Row 
When create map with By ID Change 
	And create map with By Requirement Name Change
Then Should be able to save a map with all discriminators

@Import
Scenario:2 32 Import requirements with Zephyr fields mapped to 2-character column names in Excel file
Given User in Requirement Page
	When click on import create map select the two charecter Column 
And Import requirement and run the job
	Then Navigate to the imported folder Should be able to import data in Two character column names mapped to requirement fields

@Import
Scenario:3  31 Import requirements using all the available discriminators and import the requirements 
Given User in requirement Page
	And click on import create map with By empty Row Import requirement and run the job
When create map with By ID Change Import requirement and run the job
	And create map with By Requirement Name Change Import requirement and run the job
Then Should be able to save a map with all discriminators and import the requirements

@Import
Scenario:4 33 Import a xls/xlsx file from the client/local machine  directory with special characters in the file name
Given user in the Requirement Page
	When click on Import create map with By empty Row Import requirement special char filename and run the job
Then should be able to import the special char filename
When click on import create map with By empty Row Import requirement international char filename and run the job
	Then should be able to import the international char filename
	When click on import create map with By empty Row Import requirement UPPERCASE char filename and run the job
	Then should be able to import the  UPPERCASE char filename
	When click on import create map with By empty Row Import requirement number char filename and run the job
	Then should be able to import the  number char filename
	When click on import create map with By empty Row Import requirement lowercase char filename and run the job
	Then should be able to import the  lowercase char filename
	When click on import create map with By empty Row Import requirement alphanumeric char filename and run the job
	Then should be able to import the alphanumeric char filename

@Import
Scenario:5 34 Import requirements in multiple excel files located in the same directory
Given User in the Requirement Page
	When click on Import create map Import requirement and run the job
Then should be able to import the file
	And click on import and Import requirement in the same directory and run the job
	And should be able to import the file in the same directory
Then View the Requirements in the Imported Folder

@Import
Scenario:6 35 import requirements from the file having requirements in different character combination
Given user in requrement page to import the Requirements
	When click on Import create map with By empty Row Import Requirement Special char filename and run the job
Then should be able to Import the Special char filename
When click on import create map with By Empty Row Import requirement International char filename and run the job
	Then should be able to import the International char Filename
	When click on import create map with By Empty Row Import Requirement UPPERCASE char filename and run the job
	Then should be able to Import the  UPPERCASE Char filename
	When click on import and Import requirement number char filename and run the job
	Then should be able to Import the  Number char filename
	When click on import and Import requirement lowercase char filename and run the job
	Then should be able to Import the  Lowercase char filename
	When click on import and Import requirement alphanumeric char filename and run the job
	Then should be able to Import the Alphanumeric char filename
	When click on import and Import requirement Long filename and run the job
	Then should be able to Import the Long filename
	When click on import and Import requirement Short filename and run the job
	Then should be able to Import the Short filename

@Import
Scenario:7 36 Copy the imported node to local and global node using ctrl DnD
Given user in the requirement page to oimport the file and copy
When select import select excel and create map import the file
When copy the import file to local area and verify
And copy the imported file to global area and verify
Then should able to display file in the global area

@Import
Scenario:8 37 Move the imported node to local and global node using DnD
Given User in the requirement page to Import and Move the file
When click on Import Select excel and Create map import the file to the folder
When Move the import file to local area to copy the imported node
	And Move the imported file to global area
	Then Should able to Display in the Global area

@Import
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE