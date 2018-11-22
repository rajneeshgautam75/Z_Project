package com.zephyr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;

public class ExecutionPage_POM 
{
	public ExecutionPage_POM(WebDriver driver)
	{
			this.driver = driver;
			PageFactory.initElements(LaunchBrowser.driver,this);	
	}
	WebDriver driver=null;
	
	BasePage bp;
	/****************for selecting status dropdown*****************/
	 //added by srikanth on 02/09/17
	 //selecting status accessType
	 @FindBy(xpath="html/body/span/span/span[1]/input")
	 public WebElement statusDropDown;
	 
	 public String statusDropDown1=".//*[@id='grid-table-tce']/div[2]/div[";
	//public String statusDropDown2="]/div[8]/zephyr-inline-edit/div/div";
	 public String statusDropDown2="]";
	 
	 @FindBy(xpath="(//*[@class='create-issue-form']/div/div/div/div/div/h4)[1]")
	 public WebElement defect_ID;
	 
	 
	 public String statusType1=".//li[text()='";
	 public String statusType2="']";
	 
	 public String validate1="//*[@id='grid-table-tce']/div[2]/div[";
	 public String validate2="]/div[6]/div/div";
	 
	 
	 //23-09-2017
	 //for Sorting
	 @FindBy(xpath="(//*[@class='grid-column-chooser']//a/i)[1]")
	 public WebElement sort;
	 public String sortElement1="(//*[@class='zui-checkbox2']//*[text()='";
	 public String sortElement2="'])";
	 public String sortElement3="[2]";
	 
	 
	//for entering actual time
	 @FindBy(xpath="//span[@id='testcase-actual-time']")
	 public WebElement actualTimeField;
	 public String days_1="//input[@id='dayText']";
	 public String hour_1="//input[@id='hourText']";
	 public String minute="//input[@id='minuteText']";
	 
	 
	 //For Attaching Attachement
	 @FindBy(xpath="//h5[text()='Execution Status']")
	 public WebElement executionStatusTab;
	 @FindBy(xpath="//span[text()='Browse']")
	 public WebElement browse;
	
	 
	 //for deleting Attachement
	 protected String attachFile1="(//span[@title='";
	 protected String attachFile2="'])[1]";
	@FindBy(xpath="//span[@title='Click to delete this file']")
	 public WebElement deleteAttachement;
	 @FindBy(xpath="//button[@value='DELETE']")
	 protected WebElement confirmDeleteAttachBtn;
	 
	 
	 
	 //For changing test Step status
	 @FindBy(xpath="//*[@id='grid-table-testcase']//div[5]//span")
	 public WebElement testStepStatus;
	 public String status1="//li[text()='";
	 public String status2="']";
	 @FindBy(xpath="//button[text()='Execute']")
	 public WebElement confirmStepStatus;
	 
	 
	 //For Changing testcase status
	 public String testcase1="//*[@id='grid-table-tce']/div[2]/div[";           
	 public String testcase2="]/div[10]/zephyr-inline-edit/div/div";
	 
	 
	
	 //For enterig notes
	 @FindBy(xpath="//span[@placeholder='Enter notes']")
	 public WebElement notes;
	 
	 @FindBy(xpath=".//*[@id='type-val']/zephyr-inline-edit/div/div/div/form/div[2]/button[2]")
	 public WebElement notesSave;
	 
	 @FindBy(xpath=".//*[@id='type-val']/zephyr-inline-edit/div/div/div/form/div[2]/button[1]")
	 public WebElement notesCancel;
	 
	 @FindBy(xpath="//*[@class='grid_link_select_click popover-indication defect-detail-popover']")
	 public WebElement tooltipView;
	 
	 
	 //Creating status
	 @FindBy(xpath="//button[text()='Execution Status']")
	 public WebElement executionButton;
	 
	 @FindBy(xpath="//span[@title='Add New Status']")
	 public WebElement addStatusButton;
	 
	 @FindBy(xpath="//input[@id='execution-status-value']")
	 public WebElement statusValue;
	 
	 @FindBy(xpath="//*[@id='colorPicker']/a/div")
	 public WebElement StatusColour;
	 
	 @FindBy(xpath="//*[@id='colorPicker']/div")
	 public WebElement StatusColourPicker;
	
	 
	 @FindBy(xpath="(//button[text()='Save'])[4]")
	 public WebElement StatusSaveButton;
	
	 @FindBy(xpath="//button[@value='EXECUTION_STATUS_FORM_SUBBMIT']")
	 public WebElement statusConfirmSave;
	 
	 //For creating defect
	 
	 public String defectButton1="//*[@id='grid-table-tce']/div[2]/div[";
	 public String defectButton2="]/div[11]/div/div/span";
	 
	 @FindBy(xpath="//*[text()='Create Defect']")
	 public WebElement createDefectButton;
	 
	 @FindBy(id="fileNewDefectProject-wrap-")
	 public WebElement selectProject;
	 @FindBy(xpath="//*[@id='issueType-wrap-']")
	 public WebElement issueType;
	 
	 @FindBy(xpath="//button[text()='Next']")
	 public WebElement next;
	 
	 @FindBy(xpath="(//*[@id='create-defects-fields-form']//input)[1]")
	  public WebElement defectSummary;
	 
	 @FindBy(xpath="//*[@id='multiComponents-field-wrap-file-new']")
     public WebElement defectComponent;
	 
	  @FindBy(xpath="//select[@id='copySteps']")
	  public WebElement defectDescriptionselection;
	  
	  @FindBy(xpath="//*[@id='create-defects-fields-form']//textarea")
	  public WebElement enterDescription;
	 
	  @FindBy(xpath="//i[@class='fa fa-tasks grid-icon']")
		 public WebElement clickOnSubTask;
	
	  @FindBy(id="fixVersions-field-wrap-file-new")
	  public WebElement fixVersionField;
	 
	  @FindBy(id="priority-field-wrap-file-new")
	  public WebElement priorityField;
	  
	  @FindBy(id="assigned_to-field-wrap-file-new")
	  public WebElement assignee;
	  
	  @FindBy(xpath="//*[@id='labels-field']")
	  public WebElement labelField;
	  
	 
	  @FindBy(xpath="//*[@id='customfield_10215-field']")
	  public WebElement sprint;
	  
	 
	  
	 
	  @FindBy(xpath="//*[text()='Environment']/../../../..//input")
	  public WebElement environment;
	  @FindBy(xpath="//*[text()='Epic Link']/../../../..//input")
	  public WebElement epicLink;
	  
	  
	  @FindBy(id="multiVersions-field-wrap-file-new")
	  public WebElement affectsVersion;
	  
	  
	  @FindBy(xpath="//*[@id='issuelinks-field']")
	  public WebElement linkedIssues;
	 
	 
	 @FindBy(xpath="//button[text()='Create']")
	 public WebElement createButton;
	 
	 @FindBy(xpath="//button[text()='Update' and @type='button']")
	 public WebElement updateButton;
	 
	
	 
	 //For Creating Defect
	
	 public String testCase1="//*[@id='grid-table-tce']/div[2]/div[";
	 public String testCase2="]/div[8]/div/div/input";
	
	 
	 
	 @FindBy(xpath="//*[@style='background-color: rgb(255, 0, 153);']")
	 public WebElement colourChoose;
	 
	//*[@style='background-color: rgb(255, 0, 153);']
	
	 //For DTS Login
	 
//	 @FindBy(xpath="//*[@id='defect-link-modal']/div/div/div[1]/div[1]/h4")
//	 public WebElement dtsLoginPage;
//	
//	 @FindBy(xpath="//*[@id='zee-import-modal-requirement-jira']/div/div/div[1]/div[2]/zui-modal-header-buttons/div/button")
//	 public WebElement resetUser;
//	
//	 
//	 @FindBy(xpath="//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body[2]/zee-update-defect-user/div/form/div[1]/span[2]/input")
//	 public WebElement dtsUsername;
//	 
//	 @FindBy(xpath="(//input[@class='form-control update-user-password ng-untouched ng-pristine ng-invalid'])[1]")
//	 public WebElement dtsPassword;
	 
//	 @FindBy(xpath="//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body[2]/zee-update-defect-user/div/form/div[3]/span[2]/input")
//	 public WebElement reEnterPass;
//	 @FindBy(xpath="(//*[text()='Update'])[3]")
//	 public WebElement dtsUpdateButton;
//	 
//	 @FindBy(xpath="(//*[text()='Save'])[3]")
//	 public WebElement updateStatus1;
//	 
	 
	 @FindBy(xpath="//*[@id='testcase-actual-time']//zui-estimated-time/div")
	 public WebElement actualTime;
	 
	 
	 //for changing stepStatus
	 
	 @FindBy(xpath="(//h5[text()='Test Step'])[1]")
	 public WebElement stepDetailButton;
	 
	 
	 public String stepStatus1="//*[@id='grid-table-testcase']/div[2]/div[";
	 public String stepStatus2="]/div[5]/zephyr-inline-edit/div/div/span[1]/span";
//	 @FindBy(xpath="(//span[@placeholder='Enter value'])[3]")
//	 public WebElement stepStatus;
	 
	
	 
	 public String testCaseCheckbox1= "//*[@id='grid-table-tce']/div[2]/div[";
	public String testCaseCheckbox2="]/div[1]/div/div/input";
	 
	//*[@id="testcase-actual-time"]//zui-estimated-time/div
	@FindBy(xpath="//input[@id='testcase_select']")
	 public WebElement selectAllTestCases;
	
	@FindBy(xpath="//span[text()='Change Bulk Status']")
	 public WebElement multiStatus;
	

	@FindBy(xpath="//*[@id='grid-table-tce']/div[2]/div/div[13]/div/div/a")
	 public WebElement validateDeleteAttachement;
	

	 
	 public String validateVersion1="//*[@id='grid-table-tce']/div[2]/div[";
	 public String validateVersion2="]/div[16]";
	 
	 
	 @FindBy(xpath="(//*[@id='th-testcase_id']/div)[1]")
	 public WebElement ID;
	 
	 @FindBy(xpath="//*[@class='zui-btn zui-btn-primary' and text()='Create']")
	 public WebElement createButtonSave;
	 
	 
	 //For Link a defect
	 @FindBy(xpath="//*[@id='defectId']")
	 public WebElement searchDefectID;
	 
	 @FindBy(xpath="//button[text()='Search']")
	 public WebElement defectSearchButton;
	 
	 @FindBy(xpath="//*[@id='grid-table-DEFECTS_LINK_SEARCH']/div[2]/div[1]/div[8]/div/div/span/i")
	 public WebElement linkDefects;
	 
	 @FindBy(xpath="//*[@class='defect-link-modal-buttons']/button")
	 public WebElement cancelDefect;
	 
//	 @FindBy(xpath="//*[@id="grid-table-tce"]/div[2]/div/div[8]//span[2]")
//	 public WebElement validateDefect;
//	 
	 public String validateDefectTestCase1="//*[@id='grid-table-tce']/div[2]/div[";
	  public String validateDefectTestCase2="]/div[11]";
	 
	 @FindBy(id="popoverContent")
	 public WebElement popupContent;
	 
	 @FindBy(xpath="//*[@id='projectDropDown']")
	 public WebElement project;
	 
	 public String validateDefect1="(//span[text()='";
	 public String validateDefect2=" '])[1]";
	  public String option1="//*[@id='grid-table-CURRENTLY_LINKED_DEFECTS']/div[2]/div/div[";
	  public String option2="]/div/div/input";
 @FindBy (xpath="//button[text()='Delete']")
	 public WebElement Delete;
	 
	 @FindBy (xpath="(//button[text()='Delete'])[2]")
	 public WebElement confirmDelete;
	 
	 public String valSort1="(//*[@id='header-parent-tce']//*[text()='";
	 public String valSort2="'])[1]";
	 
	 public String attachment1= "//*[@id='grid-table-tce']/div[2]/div[";
	  public String attachment2="]/div[13]/div/div/a";
	  
	  @FindBy(xpath="//*[text()='Add']")
	  public WebElement addAttachment;
	  
	  @FindBy(xpath="//*[text()='Choose file from your computer']")
	  public WebElement chooseFileYourComputer;
	  
	  @FindBy(xpath=".//*[@id='attachment-modal']//div[2]/button")
	  public WebElement closeAttachment;
	  
	  public String cycle1 = "//*[@data-name='";
		public String cycle2 = "']";
		
		
		//added by srikanth on 16/10/17
		/***********************13/10/17*********************/
		 //pagination
		 
		 
		//LinkJira
		   public String jiraLink1="(//*[@class='flex-bar'])[";
		   public String jiraLink2="]//div";
		   
	      public String jiraLinkCheckbox1="(//*[@class='flex-bar'])[";
	      public String jiraLinkCheckbox2="]//input";
	      
	      @FindBy(xpath=".//*[text()='Defect Admin']")
	 	 public WebElement defectsAdmin;
	      
	      
	      
	      @FindBy(xpath="//span[text()='Preferences']")
	  	 public WebElement preferences;
	      
	      @FindBy(xpath="//*[text()='General Configuration']")
	  	 public WebElement generalConfiguration;
		 
	      
	      /***********************19/10/17*********************/ //added by srikanth
	      /********************18/10/17*****************/ //added by srikanth
	  	 @FindBy(xpath="//a[text()='Export']")
	  	 public WebElement exportOption;
	  	 
	  	@FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
	 	public WebElement options;
	  	
	  	@FindBy(xpath="//h4[contains(.,'Customize and Export Reports')]")
	 	protected WebElement exportPage;
	  	
	  	//For Export Page Verification
	  		protected String exportPageTitle="Customize and Export Reports";
	  		
	  		public String reportType1="(//*[@class='zui-export-label control-label'])[";
	        public String reportType2="]";
	        
	        public String customName1=".//*[@title='";
	   	 public String customName2="']";
	   	 
	   	 
	   	/*******************23/10/17**********************/ //added by srikanth
		 @FindBy(xpath="(//*[text()='Export'])[1]")
		  public WebElement exportOptionInGrid;
		 
		 @FindBy(xpath="(//*[text()='Priority'])[2]")
		  public WebElement priorityInExportPage;
		 
		 public String priorityFilterField="//input[@placeholder='Select Filter Priority']";
		 
		 /**************26/10/17******************/ //added by srikanth
		 @FindBy(xpath="(//*[@id='th-tce_name']/div/i)[2]")
		  public WebElement sortName;
		 
		 
    //****************************27/10/2017********************//created by Abilash
		  @FindBy (xpath="//*[@id='attachment-modal']/div/div/div[1]/div[2]/button")
		  public WebElement close;
		  
		  
		  protected String stepAttach1="//*[@id='grid-table-testcase']/div[";   
		  protected String stepAttach2="]/div/div[7]/div/div/a";
		  
		  
		  @FindBy(xpath="(//span[@class='cursor-pointer download-image'])[3]")
		   public  WebElement Download;
		  
		  
		  @FindBy(xpath="//a[@class='zui-link grid_link_click attachment_count_step']")
		   public WebElement NoAttachment;
		  
		 @FindBy(xpath="//button[text()='Choose file from your computer']")
		   public WebElement chooseFile; 
		 
		 @FindBy(xpath="//*[@id='header-parent-testcase']/div[8]/div/div/a")
		 public WebElement stepSort;
		 
		 @FindBy(xpath="//*[@id='th-testcase_status']/div")
		 public WebElement stepStatus;
		 
		 
		 public String toolTipTestcase1="//*[@id='grid-table-tce']/div[2]/div[";
		 public String toolTipTestcase2="]/div[11]/div/div";//9-->11
		   
	//**********************************************************************************************//	 
   /************************13/11/17***************************/ //added by srikanth
		   //public WebElement syncProgressCompletion;*/
			public String syncProgressCompletion="//*[@id='job-status-modal-execution']//p[4]";
			 
			 @FindBy(xpath="//*[text()='Sync']")
			  public WebElement syncOption;
			 
			 @FindBy(xpath="//button[@value='SYNC']")
			  public WebElement syncPopUp;
			 
			 @FindBy(xpath="(//button[text()='×'])[15]")
			  public WebElement closeSyncPopUp;
			 
			 
			
			
			 
			 @FindBy(xpath="//*[text()='Edit']")
			  public WebElement editOption;
			 
			
			//For Selecting Priority
				 public String priority1="//*[text()='";
				 public String priority2="']";
				 
				 @FindBy(xpath="//a[@id='header-details-user-fullname']")
				 public WebElement externaljira_user_option;
				 
				 @FindBy(xpath="//a[contains(.,'Log Out')]")
				 public WebElement externaljira_logout;
			 
			 @FindBy(xpath="//*[@id='edit-issue-submit']")
			  public WebElement updateInJira;
			 
			 @FindBy(xpath="(//*[@id='edit-issue-dialog']//div/a)[60]")
			  public WebElement cancelInJira;
			 
			 @FindBy(xpath="//*[@href='#allExecutions']")
			   public WebElement allExecutions;
			 
			 
			 @FindBy(xpath="(//span[text()=' Browse '])[2]")
			   public WebElement browseInExternalJira;
			 
			 @FindBy(xpath="//*[@type='button' and text()='Update']")
			   public WebElement updateDefect;
			 
			 public String statusInExternalJira1="//a//span[text()='";
			 public String statusInExternalJira2="']";
			 
			 public String value1="//li[text()='";
			 public String value2="']";
			 
			 @FindBy(xpath="//*[@id='grid-table-DEFECTS_LINK_SEARCH']//span/a")
			  public WebElement searchedDefect;
			 
			 @FindBy(xpath="//i[@class='fa fa-refresh zui-dt-reset-user-icon']")
			 public WebElement resetUser;
			 
			 @FindBy(xpath="(//input[@name='username'])[1]")
			 public WebElement dtsUsername;
			 
			 //@FindBy(xpath="//zee-update-defect-user/div/form/div[2]/span[2]/input")
			 @FindBy(xpath="(//input[@name='password'])[1]")
			 public WebElement dtsPassword;
//			 
			 //@FindBy(xpath="//zee-update-defect-user/div/form/div[3]/span[2]/input")
			 @FindBy(xpath="(//input[@name='reEnterPassword'])[1]")
			 public WebElement reEnterPass;
			 
			 @FindBy(xpath="(//*[text()='Update'])[3]")//updated //[3]prev
			 public WebElement dtsUpdateButton;
			 
			 @FindBy(xpath="//*[@id='defect-link-modal']/div/div/div[3]/zui-modal-footer/div/div/button[2]")
			 public WebElement dtsSaveButton;
			 @FindBy(xpath="(//*[text()='Save'])[3]")
			 public WebElement updateStatus1;
			 
			 //////////////////////////////////////
//			 @FindBy(xpath="(//*[text()='Update'])[3]")
//			 public WebElement dtsUpdateButton;
			
			 public String selectSearch1= "//li[text()='";
			 public String selectSearch2= "']";
			 
			 @FindBy(xpath="//input[@id='searchDefectsJQL']")
			  public WebElement SearchDefect;
				
				@FindBy(xpath="(//button[text()='Search'])")
				public WebElement Search;
				
				 @FindBy(xpath="//*[@id='searchDefectsJQL']")
				 
				 public WebElement searchJqlID;
				 
				 @FindBy(xpath="//*[@id='select2-defectFiltersDropdown-container']")
				 public WebElement searchMyFilterID;
				 
//				 @FindBy(xpath="//span[@placeholder='Enter Summary']")
//				 public WebElement enterDefectSummary;
//				 
//				 @FindBy(xpath="//span[@placeholder='Enter Components']")
//				 public WebElement enterDefectComponent;
//				 
//				 @FindBy(xpath="//span[@placeholder='Enter Version']")
//				 public WebElement enterDefectVersion;
//				 
//				 @FindBy(xpath="//span[@placeholder='Enter Fix Versions']")
//				 public WebElement enterDefectFixVersions;
//				 
//				 @FindBy(xpath="//span[@placeholder='Enter Comment']")
//				 public WebElement enterDefectComment;
//				 
//				 @FindBy(xpath="//span[@placeholder='Select Assignee']")
//				 public WebElement enterDefectAssignee;
//				 
//				 @FindBy(xpath="//span[@placeholder='Select Environment']")
//				 public WebElement enterDefectEnvironment;
//				 
//				 @FindBy(xpath="//a[@class='zui-link grid_link_click update-status-resolution-link']")
//				 public WebElement defectUpdate;
//				 
//				 @FindBy(xpath="//span[@placeholder='Select Environment']")
//				 public WebElement enterDefectStatus;
				 
				  @FindBy(xpath="//div[@title='Notifications']")//new 09/05/18
				    public WebElement moveToNotificationElement;
				    
				    @FindBy(xpath="//button[@title='Click to apply notifications']")
				    public WebElement applyNotification;
				    
				    @FindBy(xpath="//*[@class='fa fa-tasks grid-icon']")
					 public WebElement subtask;

				   @FindBy(xpath="//*[@id=\"defect-link-modal\"]/div/div/div[3]/zui-modal-footer/div/div/div[2]/button[1]")
				   public WebElement CancelButton1;
				   
				   
				   public String defectButton3="//*[@id='grid-table-tce']/div[2]/div[";
					 public String defectButton4="]/div[11]/div/div/span[2]";

					 @FindBy(xpath="//span[@title='Create sub task']")
				        public WebElement createSubtask;
					 

					 @FindBy(xpath="//*[@id='grid-table-CURRENTLY_LINKED_DEFECTS']/div[2]//span")
					 public WebElement currentlyLinkedDefect;
					
					 @FindBy(xpath="(//*[@id='grid-table-DEFECTS_LINK_SEARCH']/div[2]//span)[1]")
					 public WebElement clickOnLinkDefectID;
					
					    @FindBy(id="fileNewDefectProject-wrap-")
						  public WebElement selectDefectProject;
					    
					    
			            //////////////29/05/18 by srikanth////////////////
						 @FindBy(xpath="(//*[@class='page-track']/b[3])[2]")
						    public WebElement searchCount;

					    @FindBy(xpath="//li[@class='next-page']//span")
					    public WebElement nextButton;
					    
					    
					    @FindBy(xpath="(//*[@class='page-track']/b[3])[2]")
					      public WebElement searchtestdefectCount;

						 public String dvalue1="//*[@id='grid-table-DEFECTS_LINK_SEARCH']/div[2]//div[@title='";
						 public String dvalue2="']";
						 
						 public String testcaseId="]/div[3]/div/div";


						 public String link1="//*[@id='grid-table-CURRENTLY_LINKED_DEFECTS']//*[text()='";
						 public String link2="']";
						 
						  @FindBy(xpath="//h4[text()='Link Defect']")
						    public WebElement linkDefectWindow;
					 
						  public String browse1="//span[contains(.,'Browse')]";
			
						  @FindBy(xpath="//span[@class='cursor-pointer download-image']")
							 public WebElement clickOnTestDownload;
						  
						  @FindBy(xpath="//*[@class='toast-title']")
						    public WebElement defectLinkMsg;
						  
						  @FindBy(xpath="//*[@id='defect-link-modal']/div/div/div[1]/div[2]/button")
							 public WebElement closeDefectWindow;
						  
						  @FindBy(xpath="(//*[@class='create-defect-action-buttons']//*[contains(.,'Cancel')])[2]")
							 public WebElement cancelFileNewDefectWindow;
						  
						  @FindBy(xpath="//*[@id=\"defect-link-modal\"]//zui-modal-footer/div/div/div[2]/button[1]")
						   public WebElement CancelUpdateButton;
						  
						  @FindBy(xpath="//span[text()='Reset User']")
							public WebElement clickOnResetUser;
						    
						  //@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body/zee-update-defect-user/div/form/div[1]/span[2]/input")
							@FindBy(xpath="(//input[@name='username'])")
							public WebElement username;
							
							//@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body[2]/zee-update-defect-user/div/form/div[2]/span[2]/input")
							@FindBy(xpath="(//input[@name='password'])")
							public WebElement password;
							
							//@FindBy(xpath=".//*[@id='zee-import-modal-requirement-jira']/div/div/div[2]/zui-modal-body[2]/zee-update-defect-user/div/form/div[3]/span[2]/input")
							@FindBy(xpath="(//input[@name='reEnterPassword'])")
							public WebElement reEnterPassword;
							
							@FindBy(xpath="(.//button[text()='Update'])[3]")//updated previous[3]
							public WebElement update;
							
							@FindBy(xpath="//h5[text()='Execution Attachment']")//updated previous[3]
							public WebElement executionAttachementTab;
							
							
							@FindBy(xpath="(//*[@class='create-defect-action-buttons']//*[text()='Cancel'])")
							 public WebElement newDefectCancelButton;		 
							 
							  @FindBy(xpath="(//*[@class='create-issue-form']//*[text()='Cancel'])[3]")
							  public WebElement updateCancelButton;
							
						
						 
						  
						  
}
