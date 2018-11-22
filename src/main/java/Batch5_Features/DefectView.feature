
Feature: View Scenarios

@DT_View
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE


    
  @DT_View
  Scenario: 5 Create a release when Zephyr project is mapped/not mapped to Jira project.
   Given Login as manager role credential
     When user navigate to project setup page
      And map the external defect project to zephyr project and save it
    Then external defect project should be mapped to zephyr project
    When user launch release setup page
     And create a new release when zephyr project is mapped to jira project
    Then Should be able to view activity stream in posted in jira
    When Create a release when zephyr project is not mapped to jira project
    Then Should not be able to view activity stream in posted in jira
    
    
      
@DT_View
Scenario: 11 As Mgr, Launch the "Defects Admin" app icon when Defect Tracking is set to_External System
Given User is in Administration page
 When User set the DTS
  And User refresh the page
 When User select the project and release and launch defect tracking and enter valid login credential and save it
 Then Should be able to launch defect admin when DTS is set
    
    
   @DT_View
   Scenario: 23 View drop down fields populated data with Project Selected
    Given User is in Defecttracking page
    When user create defect and select project and verify the all respective project name in dropdown
    Then Should be able to view dropdown fields in DefectTracking
    When user click on TextExecution and create defect and select project and verify the all respective project name in dropdown
    Then should be able to view dropdown fields in TextExecution
  
   @DT_View 
      Scenario: 32 View the DETAILS Info of a Defect in details of SEARCH view
      Given user will be in a testRepository page
      When user clicks on the release and creates a node
      And user will add three testcase
      Then three testcase will be successfully added
      When user will comes to testplanning page
      And user will creates a testcycle
      Then testcycle must be created successfully
      When user comes to testExecution page
      And selects the first testcase and change the status
      Then first testcase status changes successfully 
      When user clicks on the first testcase D button
      And user will search for the defect-Id and links the testcase
      Then testcase must linked successfully and show the name of the defectID
      When DefectTracking button is clicked by user
      Then user will navigate to defectTracking page
      When user enter the defectId and clicks on search button
      Then defectID will be successfully searched
      When user selects the defectID in grid
      Then user Should be able to View the DETAILS Info of a Defect in details of SEARCH view 
     

       @DT_View 
       Scenario: 72 View Mapped project selected by default while filing defect/sub-task
     Given Manager will be in projectSetUp Page
     When Manager map the jira project to ZE application
     And manager will logout from manager credentials 
     And User will enter ZE application with lead credentails
     And user clicks on the DefectTracking button 
     Then user must come to defect Tracking page successfully
     When user clicks on the CreateDefect button
     Then user must view mapped project selected by default in create defect window 
     
     
@DT_View
Scenario: 126 <Daily pulse gadget> View defect count daily pulse gadget, If ZE project mapped to JIRA project
Given User is in the uppercase project page
  And User create a dashBoard and add daily pulse gadget for uppercase project
 Then Should show defect count properly for uppercase project
 When User select the special character project and execute testcase in test execution
  And User create a dashBoard and add daily pulse gadget for special character project
 Then Should show defect count properly for special character project
 When User select the number character project and execute testcase in test execution
  And User create a dashBoard and add daily pulse gadget for number character project
 Then Should show defect count properly for number character project
 When User select the alpha numberic character project and execute testcase in test execution
  And User create a dashBoard and add daily pulse gadget for alpha numberic character project
 Then Should show defect count properly for alpha numberic character project
 When User select the international character project and execute testcase in test execution
  And User create a dashBoard and add daily pulse gadget for international character project
 Then Should show defect count properly for international character project
     
     
     @DT_View
Scenario: 127 HTML/DT Jira/Search>Verify the selection of drop-down attributes(Issue type/Status/Version/Priority)
Given User is in the projectPage
 When User select the release to launch defect tracking
  And User navigate to the defect tracking page
 Then Should be able to launch DT app
 When check the dropdown attributes of Issuetype/priority/status/version without selecting the project
 Then Should show all these dropdown should be empty if project is not selected

@DT_View
Scenario: 128 HTML/DT Jira/Search>Verify the selection of drop-down attributes(Issue type/Version/Priority)
Given User is in the Projectpage
 When User select the release in the project page
  And User navigate to the DT page
 Then Should be able to launch DT Page
 When check the dropdown attributes of Issue type/Version/Priority after selecting the project
 Then all these dropdowns should show values after project and issuetype selection

@DT_View
Scenario: 129 HTML/DT Jira/Search>Verify the selection of drop-down attributes(status)
Given User is in the project selection page
 When User select the release in a project page
  And User navigate to the DefectTracking page
 Then Should be able to launch DefectTracking
 When check the dropdown attributes of status after selecting the project and issuetype
 Then status dropdown should show values after project and issue type selection
 
 
 
 @DT_View
 Scenario: 285 View dropdown menu options for custom field of type Select List if LOVs are not sorted in Jira
 Given User is in external jira page
  When User add value into selectlist type of customfield
  Then Should be able to add value into selectlist type of customfield 
  When User login to Zephyr as testmanager
   And User view the LOVs in selectlist customfield dropdown while creating defect in defecttrackinng
  Then Should be able to view dropdown menu options for customfield of type selectlist in defecttracking
  When User view the LOVs in selectlist customfield dropdown while creating defect in testexecution
  Then Should be able to view dropdown menu options for customfield of type selectlist in testexecution
 
 @DT_View
 Scenario: 284 View dropdown menu options for customfield of type Select List if LOVs are sorted in Jira
 Given user is in external Jira Page
  When user sort the values present in selectlist type of customfield 
  Then should be able to sort the values present in selectlist type of customfield
  When user login to zephyr as testmanager
   And user view the LOVs in selectlist customfield dropdown while creating defect in Defecttrackinng
  Then should be able to view dropdown menu options for customfield of type selectlist in Defecttracking
  When user view the LOVs in selectlist customfield dropdown while creating defect in Testexecution
  Then should be able to view dropdown menu options for customfield of type selectlist in Testexecution

 @DT_View
 Scenario: 286 Edit field setup for custom field of type Select List in Jira rearrange sequence of LOVs and view the changes reflected in Zephyr
 Given User is in External Jira Page
  When User rearrange the values present in selectlist type of customfield 
  Then Should be able to rearrange the values present in selectlist type of customfield
  When User login to zephyr as Testmanager
   And User view the LOVs in selectlist customfield dropdown while creating defect in DefectTrackinng
  Then Should be able to view dropdown menu options for customfield of type selectlist in DefectTracking
  When User view the LOVs in selectlist customfield dropdown while creating defect in TestExecution
  Then Should be able to view dropdown menu options for customfield of type selectlist in TestExecution
  
  
@DT_View
Scenario:298 View pre-defined custom field properties in Defects Admin
Given user Logins to zephyr as Manager Credentials 
When  user goes to Adminstration
And   User clicks on Defects admin and prefrences
Then  Should be able to see the pre defined dts.customfield.jira.date_format customfield property
Then  Should be able to see the pre defined jira.customfield.createmeta.allproject.online customfield property
Then  Should be able to see the pre defined jira.customfield.field.maxlength customfield property
Then  Should be able to see the pre defined jira.customfield.socket.timeout customfield property
Then  Should be able to see the pre defined jira.customfield.zephyr.field.mapping customfield property


@DT_View
Scenario:299 View pre-defined General Configuration properties in Defects Admin
Given Login as Manager to Zephyr
When  user clicks on Administration 
And   User clicks on Defects Admin and Prefrences and further clicks on General Configuration
Then  Should be able to see the pre defined defect.timeout General Configuration property
Then  Should be able to see the pre defined defect.user.lookup_size General Configuration property
Then  Should be able to see the pre defined jira.activitystream.enabled General Configuration property
Then  Should be able to see the pre defined jira.remote.link.additional.link.req-defect.enabled General Configuration property
Then  Should be able to see the pre defined jira.remote.link.additional.link.req-defect.relation General Configuration property
Then  Should be able to see the pre defined jira.remote.link.additional.link.req-tc.enabled General Configuration property
Then  Should be able to see the pre defined jira.remote.link.enabled General Configuration property
Then  Should be able to see the pre defined jira.rest.api.activity.url_fragment General Configuration property
 
 
@DT_View
Scenario:300 View pre-defined chart options properties in Defect Admin
Given user loginas manager to zephyr
When  user clicks on aministration
And   user clicks on defects admin and preferences and further clicks on custom fields
And   changes the value for dts.trendchart.t8.defectseries1.status as new,assigned,reopened
Then  Should be able to see the pre defined Chart options property
When  user changes the value for dts.trendchart.t8.defectseries2.status as resolved,verified,closed
Then  Should be able to See the pre defined Chart options property
 
@DT_View
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
    
  