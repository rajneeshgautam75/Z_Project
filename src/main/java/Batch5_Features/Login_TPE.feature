@Login
Feature: Login into the Zephyr Application

#Scenario: Login
#Given User Selects the Browser, Launches it and Maximises it_TPE
#When User Navigates to the URL provided_TPE
#	And User Enters Username, Password and clicks on login_TPE
#Then User should be Logged in into Zephyr Successfully_TPE

#Given Login as manager Role
#Given Login as manager Credential
#When Custom user edit the project status gadget by selecting another uassigned project
@Ab
Scenario: As a Test Manager create new projects
Given Login as a Test manager
 And navigate to Manage Projects page
 When Create eleven normal project
 Then Projects should be created successfully
 
 
 @Ab
Scenario: User assignment
Given Login as manager
When User click on admin and manage user
And select the first lead user and assign the projects
#And select the second lead user and assign the projects
#And select the third lead user and assign the projects
#And select the fourth lead user and assign the projects
#And select the fifth lead user and assign the projects
#And select the sixth lead user and assign the projects
#
And select the first tester user and assign the projects
#And select the second tester user and assign the projects
#And select the third tester user and assign the projects
#And select the fourth tester user and assign the projects
Then projects successfully assigned to the users

 

@Ab
Scenario Outline: create different releases for the projects
Given User select the projects
When User creates different release <Releasese> for all the projects
Then release is created for all projects
Examples:
|Releases|
|1      |
|2      |
|3      |
|4      |
|5      |


 