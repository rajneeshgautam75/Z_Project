Feature: Creating Custom Field and Custom Status

#AllPass
  @Ab
  Scenario: Change the Automation Execution Count
    When user open the file and change the execution count
    Then execution count should be changed
    
    

  @Ab
  Scenario: Precondition- 809199_As mgr, Create Testcase custom fields of all types
    Given Manager Login into Zephyr Application
    When Manager Navigates upto Testcase Fields in the Customizations Option
    And Manager Locks the Zephyr Acces for all other Users
    And Manager Adds Custom field with Text
    And Manager Adds Custom field with LongText
    And Manager Adds Custom field with Picklist
    And Manager Adds Custom field with Checkbox
    And Manager Adds Custom field with Number
    And Manager Adds Custom field with Date
    Then Custom Fields with Text,LongText,Picklist,Checkbox,Number,Date Should be created Successfully

  @Ab
  Scenario: As manager, Creating Execution Status
    #Given User Login as manager credential
    Given click on administartion and click on customization status
    And create custom status <N/A>
    Then status should be created sucessfully
    When create custom status <Custom Status>
    Then status should be created sucessfully
    When create custom status <Executed>
    Then status should be created sucessfully
    When create custom status <Not Executed>
    Then status should be created sucessfully
    When create custom status <Future Scope>
    Then status should be created sucessfully
    When create custom status <Future Release>
    Then status should be created sucessfully
    When create custom status <Duplicate>
    Then status should be created sucessfully
    When create custom status <Not Reproducable>
    Then status should be created sucessfully
    When create custom status <FutureScopeforjava>
    Then status should be created sucessfully
    When create custom status <Execution>
    Then status should be created sucessfully
    When create custom status with international character
    Then status should be created Sucessfully

  @Ab
  Scenario: As manager, Create Step custom status
    #Given User Login as manager credential
    Given click on administartion and click on customization step status
    And create step custom status <N/A>
    Then step status <N/A> should be created sucessfully
    When create step custom status <Future Scope>
    Then step status <Future Scope> should be created sucessfully
    When create step custom status <Custom Status>
    Then step status <Custom Status> should be created sucessfully

  @Ab
  Scenario: Logout

    Given User Clicks on logout Icon_TPE
    And User clicks on Logout Option_TPE
    Then User should be logged out from Zephyr Application Successfully_TPE
