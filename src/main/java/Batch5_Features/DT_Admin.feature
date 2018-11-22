
Feature: Defect Admin Scenario
@DT_Admin
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@DT_Admin
Scenario:295 As custom role user( with access), launch Defects Admin
Given User Logins to Zephyr as Manager
When  User Goes to administration and clicks on Customization
And   adds role with defect admin permission 
And   user goes to User setup and adds a user with above created role
Then  should be able to add created role to user  
When  user logins as as custom user to Zephyr
And   goes to administration and views Defect Admin
Then  Should be able to launch Defects Admin app


@DT_Admin
 Scenario:296 As Manager, edit and modify system defined property value for General Configuration category
Given user logins as Manager Credentials to Zephyr
When  user goes to adminstration and Clicks on defect admin
And   User goes to preferences and edits and Change the Value for defects.timeout and Saves
Then  Should be Able to Modify General Configuration property Value 

@DT_Admin
Scenario:297 As Manager, edit and modify system default property value for Chart Options category
Given user logins as Manager Credentials to zephyr
When  user goes to Adminstration and Clicks on defect admin
And   User goes to preferences and Edits and changes the value for dts.trendchart.t8.defectSeries1.status and save
Then  Should be able to modify  Chart Option property value
When  user logins as manager to zephyr
And   user clicks on adminstration and clicks on defect admin 
And   user navigates to preferences,Edits and changes the value for dts.trendchart.t8.defectSeries2.status and save
Then  To be able to Modify Chart Option property value   

#Moved to defectView#
#@DT_Admin
#Scenario:298 View pre-defined custom field properties in Defects Admin
#Given user Logins to zephyr as Manager Credentials 
#When  user goes to Adminstration
#And   User clicks on Defects admin and prefrences
#Then  Should be able to see the pre defined dts.customfield.jira.date_format customfield property
#Then  Should be able to see the pre defined jira.customfield.createmeta.allproject.online customfield property
#Then  Should be able to see the pre defined jira.customfield.field.maxlength customfield property
#Then  Should be able to see the pre defined jira.customfield.socket.timeout customfield property
#Then  Should be able to see the pre defined jira.customfield.zephyr.field.mapping customfield property
#
#@DT_Admin
#Scenario:299 View pre-defined General Configuration properties in Defects Admin
#Given Login as Manager to Zephyr
#When  user clicks on Administration 
#And   User clicks on Defects Admin and Prefrences and further clicks on General Configuration
#Then  Should be able to see the pre defined defect.timeout General Configuration property
#Then  Should be able to see the pre defined defect.user.lookup_size General Configuration property
#Then  Should be able to see the pre defined jira.activitystream.enabled General Configuration property
#Then  Should be able to see the pre defined jira.remote.link.additional.link.req-defect.enabled General Configuration property
#Then  Should be able to see the pre defined jira.remote.link.additional.link.req-defect.relation General Configuration property
#Then  Should be able to see the pre defined jira.remote.link.additional.link.req-tc.enabled General Configuration property
#Then  Should be able to see the pre defined jira.remote.link.enabled General Configuration property
#Then  Should be able to see the pre defined jira.rest.api.activity.url_fragment General Configuration property
#
#@DT_Admin
#Scenario:300 View pre-defined chart options properties in Defect Admin
#Given user loginas manager to zephyr
#When  user clicks on aministration
#And   user clicks on defects admin and preferences and further clicks on custom fields
#And   changes the value for dts.trendchart.t8.defectseries1.status as new,assigned,reopened
#Then  Should be able to see the pre defined Chart options property
#When  user changes the value for dts.trendchart.t8.defectseries2.status as resolved,verified,closed
#Then  Should be able to See the pre defined Chart options property

#@DT_Admin
#Scenario: 301 As Manager, edit and modify the system defined  property value for Custom Fields category
#Given logins as Manager to zephyr by User
#When  user Goes to adminstation and clicks on defect admin and preferences
#And   user navigates to Custom Fields and edits the value for jira.customfield.field.maxlength 
#Then  should able to modify the value
#When  Edits the value for dts.customfield.jira.date_format
#Then  To be able to modify custom field property value
#When  user edits the value for jira.customfield.createmeta.allproject.online
#Then  should be able to modify the customfield property value
#When  User edit the value for jira.customfield.socket.timeout
#Then  should be able to modify the cutom field property value
#When  user edits custom field property value for jira.customfield.zephyr.field.mapping
#Then  should be able to Modify the Cutom field property value
#
#
#
#@DT_Admin
#Scenario: 302 As Manager, disable(uncheck) the system default properties for chart option and General Configuration
#Given user logins as Manager to zephyr App 
#When  clicks ON administration 
#And   further clicks On Defect Admin and Preferences
#And   In Custom fields Disable the system default Enabled Property and save
#Then  should be able to disable the Property
#When  Enable the disabled Property and Cancel
#Then  warning message will popup
#When  Enable the disabled Property and Save
#Then  should be enabled the property
#
#
#@DT_Admin
#Scenario: 303 As Manager, enable(check) the system default  properties  for custom fields
#Given user logins as Manager Credentials to Zephyr application
#When  clicks on Administration Page
#And   Further Clicks on Defect admin and Preferences
#And   Enable the disabled property and save
#Then  should be able to enable the property
#When  Disable the enabled property and cancel
#Then  Warning Message will Pop Up
#When  disable the enabled property and save
#Then  To be able to disable the property
#
@DT_Admin
Scenario:304 As Manager,disable(uncheck)  for new property
Given user logins as Manager Credentials To Zephyr 
When  clicks on Administration
And   Further clicks on Defect admin and Preferences
And   Adds a new property
Then  New property should be added
When  disable the Enabled property and cancel
Then  Warning message will be popuped
When  disable the Enabled property and save
Then  should be able To Disable property
When  enable the disabled Property and save
Then  Should be able to enable the Property

@DT_Admin
Scenario: 305 As Manager,delete user defined property
Given user logged in to zephyr as Manager 
When  user navigates to Administration
And   further navigates on Defect admin and Preferences
And   user Adds few property
Then  few property should be added
When  user Deletes one property
Then  should delete one property
When  user Deletes two property
Then  should be able To delete two property
When  user Deletes all property
Then  Should delete all the Property

@DT_Admin
Scenario: 306 As Manager,disable(uncheck) /Enable(Check) the  properties
Given user Logged as Manager to zephyr
When  user navigates to Administration page
And   user navigates to Defect admin and Preferences 
When  Disable the system default enabled property for chart option and save
Then  Should be able to disable the property for chart option
When  Enable the disabled property and cancel for chart option
Then  Warning message will popup in for chart option
When  Enable a disabled property for chart option and save
Then  should be enabled the property for chart option
When  Disable the system default enabled property for General Configuration and save
Then  Should be able to disable the property for General Configuration
When  Enable the disabled property and cancel for General Configuration
Then  Warning message will popup in General Configuration
When  Enable a disabled property for General Configuration and save
Then  should be enabled the property for General Configuration
When  user adds new property
Then  new property should be added
When  Disable added new property the enabled property and cancel 
Then  warning message popuped
When  disable the added enable property and save
Then  should be disable the property
When  Enable the disabled added new property and save
Then  to be enabled the new property

@DT_Admin
Scenario:307 As Manager, Add property name for General Configuration Chart Options Custom Fields  category 
Given user Logged as Manager credentials to zephyr
When  user Navigates to Administration page
And   User navigates to Defect Admin and Preferences
And   user Enters property name with upper case in General Configuration 
Then  Property name should be saved with upper case in General Configuration
When  user Enters property name with lower case in General Configuration 
Then  Property name should be saved with lower case in General Configuration
When  user Enter property name with both upper case and lower case in General Configuration 
Then  Property name should be saved with both upper case and lower case in General Configuration
When  user Enters property name with numbers only in General Configuration 
Then  Property name should be saved with numbers only in General Configuration
When  user Enters property name with Alphanumeric characters in General Configuration 
Then  Property name should be saved with Alphanumeric characters in General Configuration
When  user Enters property name with Special characters in General Configuration 
Then  Property name should be saved with Special characters in General Configuration
When  user Enters property name with International characters in General Configuration 
Then  Property name should be saved with International characters in General Configuration
When  user Enters property name with leading space in General Configuration 
Then  Property name should be saved with leading space in General Configuration
When  user Enters property name with trailing space in General Configuration 
Then  Property name should be saved with trailing space in General Configuration
When  user Enters property name with Uppercase in Chart Options 
Then  Property name should be saved with Upper Case in Chart Options
When  user Enters property name with lower case in Chart Options 
Then  Property name should be saved with lower case Chart Options
When  user Enter property name with both Upper case and lower case in Chart Options 
Then  Property name should be saved with both Upper case and lower case in Chart Options
When  user Enters property name with Numbers only in Chart Options 
Then  Property name should be saved with Numbers only in Chart Options
When  user Enters property name with Alphanumeric characters in Chart Options
Then  Property name should be saved with Alphanumeric characters in Chart Options
When  user Enters property name with Special Characters in Chart Options 
Then  Property name should be saved with Special Characters in Chart Options
When  user Enters property name with International characters in Chart Options 
Then  Property name should be saved with international characters in Chart Options
When  user Enters property name with Leading space in Chart Options 
Then  Property name should be saved with Leading space in Chart Options
When  user Enters property name with Trailing space in Chart Options 
Then  Property name should be saved with Trailing space in Chart Options
When  User Enters property name with upper case in Custom Fields 
Then  property name should be saved with upper case in Custom Fields
When  User Enters property name with lower case in Custom Fields 
Then  Property Name should be saved with lower case in Custom Fields
When  User Enter property name with both upper case and lower case in Custom Fields 
Then  Property name Should be saved with both upper case and lower case in Custom Fields
When  User Enters property name with numbers only in Custom Fields 
Then  Property name should Be saved with numbers only in Custom Fields
When  user Enters property name with alphanumeric characters in Custom Fields 
Then  Property name should be saved with alphanumeric characters in Custom Fields
When  user Enters property name with special characters in Custom Fields 
Then  Property name should be saved with special characters in Custom Fields
When  user Enters property name with international characters in Custom Fields
Then  Property name should be saved with International Characters in Custom Fields
When  user Enters property name with leading Space in Custom Fields 
Then  Property name should be saved with leading Space in Custom Fields
When  user Enters property name with trailing Space in Custom Fields 
Then  Property name should be saved with trailing space in Custom Fields

@DT_Admin
Scenario: 308 Save property name with Min/Maxcharacter
Given User Logged as Manager credentials to Zephyr application
When  User Navigates to Administration 
And   User Launches Defects Admin app and
And   Selects the General Configuration Category,click on Add button and Enters single character in name field and save
Then  Property name should be saved with single character for General Configuration category
When  Selects the Chart Options Category,click on Add button and Enters single character in Name field and save
Then  Property name should be saved with single character for Chart Options category
When  Selects the Custom Fields Category,click on Add button and Enters single character in name field and save
Then  Property name should be saved with single character for Custom Fields category
When  selects the General Configuration Category,click on Add button and Enters Maximum two fifty five characters in name field and save
Then  property name should be saved with Maximum two fifty five characters for General Configuration category
When  Selects the chart Options Category,click on Add button and Enters Maximum two fifty five characters in Name field and save
Then  Property name should be saved with Maximum Two fifty five characters for Chart Options category
When  Selects the custom Fields Category,click on Add button and Enters Maximum two fifty five characters in name field and save
Then  Property name should be saved with Maximum Two Fifty Five characters for Custom Fields category

@DT_Admin
Scenario: 309 As Manager,Add property value for General Configuration Chart Options Custom Fields category 
Given user Logged to zephyr as Manager credentials 
When  user clicks on the Administration page
And   User further clicks to Defect Admin and Preferences
And   user Enters value for existing property with upper case in General Configuration 
Then  Property value should be saved with upper case in General Configuration
When  user Enters value for existing property with lower case in General Configuration 
Then  Property value should be saved with lower case in General Configuration
When  user Enters value for existing property with upper case and lower case in General Configuration 
Then  Property value should be saved with both upper case and lower case in General Configuration
When  user Enters value for existing property with numbers in General Configuration 
Then  Property value should be saved with numbers only in General Configuration
When  user Enters value for existing property with alphanumeric characters in General Configuration 
Then  Property value should be saved with Alphanumeric characters in General Configuration
When  user Enters  value for existing property with special characters in General Configuration 
Then  Property value should be saved with Special characters in General Configuration
When  user Enters value for existing property with international characters in General Configuration 
Then  Property value should be saved with International characters in General Configuration
When  user Enters property value with leading space in General Configuration 
Then  Property value should be saved with leading space in General Configuration
When  user Enters property value with trailing space in General Configuration 
Then  Property value should be saved with trailing space in General Configuration
When  user Enters value for existing property with upper case in Chart Options  
Then  Property value should be saved with upper case in Chart Options 
When  user Enters value for existing property with lower case in Chart Options  
Then  Property value should be saved with lower case in Chart Options 
When  user Enters value for existing property with upper case and lower case in Chart Options  
Then  Property value should be saved with both upper case and lower case in Chart Options 
When  user Enters value for existing property with numbers in Chart Options  
Then  Property value should be saved with numbers only in Chart Options 
When  user Enters value for existing property with alphanumeric characters in Chart Options  
Then  Property value should be saved with Alphanumeric characters in Chart Options 
When  user Enters  value for existing property with special characters in Chart Options  
Then  Property value should be saved with Special characters in Chart Options 
When  user Enters value for existing property with international characters in Chart Options  
Then  Property value should be saved with International characters in Chart Options 
When  user Enters property value with leading space in Chart Options  
Then  Property value should be saved with leading space in Chart Options 
When  user Enters property value with trailing space in Chart Options  
Then  Property value should be saved with trailing space in Chart Options  
When  user Enters value for existing property with upper case in Custom Fields  
Then  Property value should be saved with upper case in Custom Fields 
When  user Enters value for existing property with lower case in Custom Fields  
Then  Property value should be saved with lower case in Custom Fields 
When  user Enters value for existing property with upper case and lower case in Custom Fields  
Then  Property value should be saved with both upper case and lower case in Custom Fields 
When  user Enters value for existing property with numbers in Custom Fields  
Then  Property value should be saved with numbers only in Custom Fields 
When  user Enters value for existing property with alphanumeric characters in Custom Fields  
Then  Property value should be saved with Alphanumeric characters in Custom Fields 
When  user Enters  value for existing property with special characters in Custom Fields  
Then  Property value should be saved with Special characters in Custom Fields 
When  user Enters value for existing property with international characters in Custom Fields  
Then  Property value should be saved with International characters in Custom Fields 
When  user Enters property value with leading space in Custom Fields  
Then  Property value should be saved with leading space in Custom Fields 
When  user Enters property value with trailing space in Custom Fields  
Then  Property value should be saved with trailing space in Custom Fields 

@DT_Admin
Scenario: 310 Save property value with min/max/Duplicate/Empty Char
Given user Logged as Manager to Zephyr application
When  User navigates to  Administration app
And   user Launches defects Admin app and preferences
And   Selects the General Configuration Category,click on Add button and enter value for existing property with single character and save
Then  Property value should be saved with single character for General Configuration category
When  Selects the Chart Options Category,click on Add button and Enters value for existing property with single character and save
Then  Property value should be saved with single character for Chart Options category
When  Selects the Custom Fields Category,click on Add button and enter value for existing property with single character and save
Then  Property value should be saved with single character for Custom Fields category
When  selects the General Configuration Category,click on Add button and Enters Maximum more than five thousand characters and save 
Then  Property value should be saved with more than five thousand characters for General Configuration category
When  Selects the chart Options Category,click on Add button and Enters Maximum more than five thousand characters and save in value field 
Then  Property value should be saved with more than five thousand characters for Chart Options category
When  Selects the custom Fields Category,click on Add button and Enters Maximum more than five thousand characters and save in value field
Then  Property value should be saved with more than five thousand characters for Custom Fields category
When  Selects the General Configuration Category,click on Add button,Enters empty value for existing property and save
Then  Should  be able to save property without value field for General Configuration
When  Selects the Chart Options Category,click on Add button,Enters empty value for existing property and save
Then  Should  be able to save property without value field for Chart Options category 
When  Selects the Custom Fields Category,click on Add button,Enters empty value for existing property and save
Then  Should  be able to save property without value field for Custom Fields category 


@DT_Admin
Scenario: 311 As a manager,Launch Defect Admin and view the JIRA Custom Fields Management tab  and all the sections 
Given user will login as manager credential to zephyr
When  user go to administration page
And   clicks on Defect admin app
And   view the tab of Jira custom Field Management
Then  should able to view the label of Clear cache of online JIRA custom fields
Then  should able to view the label of Clear Selected
Then  should able to view the label of Clear All


@DT_Admin
Scenario: 289 As Manager,create a defect/Subtask when custom field property  is defined as uppercase  in Defects Admin
Given user Logged To Zephyr as Manager Credentials 
When  Clicks on the Administration
And   Further clicks on Defect Admin and Preferences
And   user defines a property UpperCase in custom fields
Then  Uppercase Property should be defined
When  user Goes to defect tracking,clicks on create defect
And   Creates a defect of type Multi Checkboxes,free Multi Select,free Radio button,user,Multi user and single version picker
Then  should be able to create a defect with custom fields
When  user is in a test repository page,creates a phase 
And   launches test planning,creates a cycle Adds phase to cycle
And   Launches Test Execution,executes testcase with any status and clicks on d button
Then  Defect window should be launched in test execution page
When  user clicks on create defect in Test Execution
And   creates a defect with Multi checkbox,free multi select,free radio button,user,multi user and single version picker   
Then  should be able to file a defect when customfield property of any type is defined as uppercase

@DT_Admin
Scenario: 290 As Manager, create a defect/Subtask when custom field property  is defined as Lowercase  in Defects Admin
Given user will login To Zephyr as Manager Credentials 
When  Clicks on the Administration application
And   Further Clicks on Defect Admin and preferences
And   user defines a property lowercase in custom fields
Then  lowercase Property should be defined
When  user clicks to defect tracking and clicks on create defect
And   Creates a Defect of type Multi Checkboxes,Free Multi Select,Free Radio button,user,Multi user and single version picker
Then  should be created a defect with custom fields
When  user is in a Test Repository page,creates a phase 
And   Launches test planning,creates a cycle Adds phase to cycle
And   Launches Test Execution,Executes Testcase with any status and clicks on d button
Then  Defect window should be launched in Test execution page
When  user clicks on Create defect in Test Execution
And   creates a defect with Multi checkbox,Free multi select,Free radio button,user,multi user and single version picker   
Then  should be able to file a Defect when customfield property of any type is defined as lowercase



@DT_Admin
Scenario: 291 As Manager,create a defect/Subtask when custom field property in Defects Admin is defined as uppercase and lowercase 
Given user Logins To Zephyr as Manager Credentials 
When  User is in the Administration page
And   user Clicks on defect Admin and preferences
And   user defines a property Uppercase and lowercase in custom fields
Then  Uppercase and lowercase Property should be defined
When  user clicks on defect tracking and clicks on create defect
And   Creates a Defect of Type MultiCheckboxes,Free MultiSelect,Free Radiobutton,user,Multi user and single version picker
Then  should create a defect with custom fields
When  user is in the Test Repository page,creates a phase 
And   Launches Test planning,creates a cycle Adds phase to cycle
And   user Launches Test Execution,Executes Testcase with Any status and clicks on d button
Then  Link Defect window should be launched in Test execution page
When  user clicks on Create defect in TestExecution Page
And   creates a defect with Multicheckbox,Free multiselect,Free radiobutton,user,multi user and single version picker   
Then  should be able to file a Defect when customfield property of any type is defined as uppercase and lowercase 

@DT_Admin
Scenario: 292 Create a defect/subtask/Subtask when dts.multivalue.fieldseperator configured to other than $
Given user Logins As Manager Credentials To ZEPHYR 
When  User clicks On THE Administration Page
And   Further Clicks ON Defect admin and Preferences
And   In custom fields,user defines property Name and value and saves 
Then  should be able to add property in custom fields 
When  user goes to defect tracking and clicks on create defect
And   Create a defect with custom fileds containing multiple values and text containg special charaters in Free text field
Then  should able to create a defect in Defect Tracking with multiple values
When  user Creates a new phase in Test Repository
And   launches test planning,Creates new Cycle and adds phase to cycle
And   launch test execution app and execute  testcase with any status and clicks on D button
Then  window of LINK Defect to be launched
When  user clicks on Create defect and creates a defect with custom fileds and Text containg special charaters in Freetext 
Then  To be able allow allow multiple values in custom field when multiple value seperator is configured to other than $

@DT_Admin
Scenario: 293 Create a defect/Subatsk when dts.multivalue.fieldseperator is configured  with more than one character
Given user Logins to Zephyr As Manager
When  User clicks ON Administration
And   Again clicks On Defect admin and preferences
And   user adds Property name and Value and saves in custom fields
Then  To be able to Add property in Custom fields 
When  User goes to Defect tracking and clicks on create defect
And   Creates Defect with custom fileds containing Multiple values and Text containing Special charaters in Freetext field
Then  defect should be created in Defect Tracking with multiple values
When  Launch test execution app and execute  Testcase with Any status and clicks on D button
Then  window of LINK Defect Should be launched
When  User clicks on Create Defect and creates defect with custom fileds and Text containing special charaters in Freetext 
Then  To be able multiple values in custom field when multiple value seperator is configured more than one character

@DT_Admin
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE
