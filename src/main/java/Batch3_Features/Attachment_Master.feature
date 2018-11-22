Feature:Attachment Master

@Attachment
Scenario: Login
Given User Selects the Browser, Launches it and Maximises it_TPE
When User Navigates to the URL provided_TPE
	And User Enters Username, Password and clicks on login_TPE
Then User should be Logged in into Zephyr Successfully_TPE

@Attachment
Scenario: 26 Delete the attachments from requirement
Given User is in the Requirements page
 When User create a phase and add requirements to the phase
 When User add attachment to the requirement
 Then User delete the attached attachment 
  And User re-attach the previously deleted attachment

@Attachment  
Scenario: 28 Change the requirement page size and pagination (10/25/50/100)
Given User is in the Requirements app
 When User create the Phase
  And User add more than hundred requirements to the phase
 Then User able to change default page size of fifty to ten and select page number three
 Then User able to change the page size from ten to twenty five and select page number three 
 Then User able to change the page size from twenty five to hunderd and select page number two   
  
@Attachment
Scenario: 25 Add attachments to the requirements
Given User is in the requirements page
	And User create a phase and add requirements
 Then User add attachment in text format to the requirement
 Then User add attachment in word doc format to the requirement
 Then User add attachment in excel format to the requirement
 Then User add attachment in image format(.jpg/bmp/gif format) to the requirement
 Then User add attachment in wave format(.wmv) to the requirement
 Then User add attachment in pdf format to the requirement
 Then User add attachment in mp3 format to the requirement
 Then User add multiple attachments to the requirement
 Then User preview the attachment in preview window
 Then User download the attachment from preview window  
  
@Attachment
Scenario: Logout
Given User is in the Zephyr ProjectPage_TPE
When User Clicks on logout Icon_TPE
	And User clicks on Logout Option_TPE
Then User should be logged out from Zephyr Application Successfully_TPE 