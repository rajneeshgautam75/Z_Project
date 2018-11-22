package com.zephyr.reusablemethods;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.ExecutionPage_POM;

public class ExecutionPage
{
	 WebDriver driver=null;
	   BasePage bp;
	   public Logger log;
	   SoftAssert soft=new SoftAssert();
	public ExecutionPage(WebDriver driver) 
	{
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver,this);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		BasicConfigurator.configure();
		// TODO Auto-generated constructor stub
	}
	
	
	////////////////////////POM//////////////////////////////
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
	
	public boolean verifySearchedDefectCount() throws InterruptedException
	{
		try
		{
		int count=0;
		boolean sp=searchCount.isEnabled();
		
		if(sp==true)
		{
		 String defectsCount=searchCount.getText();
		  count= Integer.parseInt(defectsCount);
		  bp.waitForElement();
		  System.out.println("Total Searched Defects-"+count);
		 //Thread.sleep(3000);
		}
		
		}
	    catch(Exception e)
	    {
	    	 System.out.println("No results Found");
			//return false;
	    }
		return true;
	}
	
	public boolean executeStatus(int tcNo,String statusType) throws Exception
	  {
	   try
	      {
	      bp=new BasePage();
	      bp.waitForElement();
	      WebElement ele=driver.findElement(By.xpath(testcase1+tcNo+testcase2));
			Actions act=new Actions(driver);
			act.moveToElement(ele).click().pause(1500).sendKeys(statusType).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
			bp.waitForElement();
			String expected=driver.findElement(By.xpath(testcase1+tcNo+testcase2)).getText();
			if(expected.equals(statusType))
				 {
					 System.out.println("Pass-Status changed to " + expected +" Sucessfully");
				 }
			else
			{
				System.out.println("Status has not changed");
			}
		

	    return true;
	      }
	      catch(Exception e)
	      {
	       e.printStackTrace();
	       throw e;
	      }
	   
	  }

	
	
	public boolean validateAssignedTestCase(int[] testcase,String assignee) throws Exception
	{
	try
	    {
		  bp=new BasePage();
		  for(int i=0;i<=testcase.length-1;i++)
		  {
			 String expected= driver.findElement(By.xpath(validate1+testcase[i]+validate2)).getText();
			 System.out.println(expected);
			 if(expected.equals(assignee))
			 {
				 System.out.println("Assigned to "+ expected +" Successfully");
				 bp.waitForElement();
			 }
			 else
			 {
				 System.out.println("Assigned Failed");
			 }
		  }
			
	  }
	  catch(Exception e) 
	   {
	    e.printStackTrace();
	    throw e;
	   }
	return true;
}
	
	
	
	
	//Added 
	public boolean sort(String[] sortName) throws Exception
	   {
		try
		{
	      bp=new BasePage();
          sort.click();
          System.out.println("Pass-Sort Icon Clicked Successfully");
        	  
        	  for(int i=0;i<=sortName.length-1;i++)
        	   {
        		      bp.waitForElement();
        		      if(sortName[i].equals("M/A")||sortName[i].equals("Notes")||sortName[i].equals("Status")||sortName[i].equals("Attachment"))
        		      {
        		      WebElement ele=driver.findElement(By.xpath(sortElement1+sortName[i]+sortElement2+sortElement3));
        		      String data=ele.getText();
        		      boolean res= ele.isSelected();
        		      System.out.println(res);
        		      if(res==false && sortName[i].equals(data))
            		  {
            			  bp=new BasePage();
            			  bp.waitForElement();
            			  ele.click();
            		  }
        		      }
        		     
        		      else
        		      {
        		      WebElement ele1=driver.findElement(By.xpath(sortElement1+sortName[i]+sortElement2));
        		      String data1=ele1.getText();
        		      boolean res1= ele1.isSelected();
        		      System.out.println(res1);
        		   
        		   if(res1==false && sortName[i].equals(data1))
        		    {
        			  bp=new BasePage();
        			  bp.waitForElement();
        			  ele1.click();
        			  bp.waitForElement();
        		    }
        		      }
        		      
        		      Actions a1=new Actions(driver);
        		      a1.moveToElement(ID).click().perform();
        		      bp.waitForElement();
        	   
        	   }
        		
        		return true;
        		}
        		catch(Exception e)
        		{
        			e.printStackTrace();
        			throw e;
        		}
     
     
	 }
	
	
	
	public boolean enterNotes(String note) throws Exception
	{
		try
		{
		Actions a1=new Actions(driver);
		a1.moveToElement(notes).click().sendKeys(note).perform();
		//notes.clear();
		
		System.out.println("Pass-Notes Entered Successfuuly");
		
		a1.pause(1000).sendKeys(Keys.TAB).perform();
		
		
		return true;
		}
	
	
	  catch(Exception e) 
	   {
	    e.printStackTrace();
	    throw e;
	   }
}
	
	
	
	
	
	
//	public boolean actualTime(String day,String hr,String mn) throws Exception
//	{
//		try
//		{
//			bp=new BasePage();
//			bp.waitForElement();
//	     actualTimeField.click();
//		WebElement days=driver.findElement(By.xpath(days_1));
//		days.clear();
//		Actions a1=new Actions(driver);
//		a1.sendKeys(day).perform();
//		
//		WebElement hour=driver.findElement(By.xpath(hour_1));
//		hour.clear();
//		a1.sendKeys(hr).perform();
//		
//		WebElement min=driver.findElement(By.xpath(minute));
//		min.clear();
//		a1.sendKeys(mn).perform();
//		
//		a1.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
//		
//		System.out.println("Pass- Actual Time Successfully Added");
//		bp.waitForElement();
//		
//		return true;
//		}	
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//			//return false;
//		
//		}	
//		
//	}
//	
//	
	public boolean validateActualTime(String day,String hr,String mn) throws Exception
	{
		
		try
		{
		
				String validate_time=day+":"+hr+":"+mn;
				//System.out.println(validate_time);

				String time=actualTime.getText();
				System.out.println(time);
			
				if(validate_time.equals(time))
				{
				System.out.println("Pass- Actual Time Successfully Validated");
				}
				else 
				{
					System.out.println("Actual Time not modified");
				}
	
	        return true;
		}
		catch(Exception e)
		{
			System.out.println("Actual time is not matched");
			e.printStackTrace();
			
			throw e;
			//return false;
		
		}	
		
	
	}
	public boolean actualTime(String day,String hr,String mn) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
	     actualTimeField.click();
		WebElement days=driver.findElement(By.xpath(days_1));
		days.clear();
		Actions a1=new Actions(driver);
		a1.sendKeys(day).perform();
	
		a1.sendKeys(Keys.TAB).perform();
		a1.sendKeys(hr).perform();
		a1.sendKeys(Keys.TAB).perform();
		System.out.println("hr");
		a1.sendKeys(mn).perform();
		System.out.println("mn");
		
		a1.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		
		System.out.println("Pass- Actual Time Successfully Added");
		bp.waitForElement();
		
		return true;
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			//return false;
		
		}	
		
	}
	
		public boolean uploadAttachement(String[] filePath) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				
				Actions a3=new Actions(driver);
				for(int i=1;i<=2;i++)
				  {
						a3.sendKeys(Keys.DOWN).perform();
				  }
			bp.waitForElement();
			for(int i=0;i<=filePath.length-1;i++)
			{
			
			browse.click();
			
			bp.waitForElement();
			Runtime.getRuntime().exec(filePath[i]);
			bp.waitForElement();
			}
			
			System.out.println("File Uploaded Successfully");
			
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				log.info("File is not Uploaded");
				throw e;
				
			}
		}
		public boolean sortAnyHeaderListings(String headerName) throws Exception
		{
			try
			{
				String header_1="//div[@title='";
				String header_2="']";
				String header_3="']/../i";
				
				WebElement columnName=driver.findElement(By.xpath(header_1+headerName+header_2));
			Actions act=new Actions(driver);
			act.moveToElement(columnName).perform();
			
			
			WebElement columnSortIcon=driver.findElement(By.xpath(header_1+headerName+header_3));
			String sortType=columnSortIcon.getAttribute("data-sort");
			if(sortType.equals("asc"))
			{
				act.moveToElement(columnSortIcon).click();
				System.out.println(headerName+"- Column sorted in descending order");
			}
			else if(sortType.equals("desc"))
			{
				act.moveToElement(columnSortIcon).click();
				System.out.println(headerName+"- Column sorted in ascending order");
			}
			
			
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				log.info("Defect button is not clicked");
				throw e;
				
			}
		}
			public boolean validateAttachement(String fileName) throws Exception
			{
				try
				{
				bp=new BasePage();
				bp.waitForElement();
				
				
				
			    WebElement Ele=driver.findElement(By.xpath(attachFile1+fileName+attachFile2));
				String validateFile=Ele.getText();
				//Assert.assertEquals(fileName, validateFile);
				Actions a1=new Actions(driver);
				a1.moveToElement(Ele).perform();
				
				if(fileName.equals(validateFile))
				{
				System.out.println("Attached file validated successfully");
				
				}
			
				return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}
		

		
		
		public boolean deleteAttachement(String[] attachement_file) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				//FcTab.click();
				
				System.out.println("Pass-Clicked on Execution Status Tab");
			bp.waitForElement();
			for(int i=0;i<=attachement_file.length-1;i++)
			{
			WebElement Ele=driver.findElement(By.xpath(attachFile1+attachement_file[i]+attachFile2));
			Actions a1=new Actions(driver);
			a1.moveToElement(Ele).perform();
			a1.moveToElement(deleteAttachement).click().perform();
			System.out.println("Pass-Clicked On delete Attachment Button");
			bp.waitForElement();
			a1.moveToElement(confirmDeleteAttachBtn).click().perform();
			log.info("Attachement successfully deleted");
			}
			
			return true;
			}
			
			catch(Exception e)
			{
				log.info("Attachement File not present");
				throw e;
				//return false;
			}
		}
		
		
		public boolean downloadAttachement(String attachement_file) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				//executionStatusTab.click();
			    
			WebElement Ele=driver.findElement(By.xpath(attachFile1+attachement_file+attachFile2));
			Actions a1=new Actions(driver);
			a1.moveToElement(Ele).click().perform();
			
			System.out.println("Attachement successfully Downloaded");
			
			
			return true;
			}
			
			catch(Exception e)
			{
				log.info("Attachement File not present");
				throw e;
				//return false;
			}
		}
		
		
		public boolean changeStatusOfTestCases(int[] testcase,String status) throws Exception
		{
			try
			{
				bp=new BasePage();
				for(int i=0;i<=testcase.length-1;i++)
				{
					bp.waitForElement();
				
					WebElement ele=driver.findElement(By.xpath(testcase1+testcase[i]+testcase2));
					Actions act=new Actions(driver);
					act.moveToElement(ele).click().pause(1500).sendKeys(status).sendKeys(Keys.ENTER).perform();
					bp.waitForElement();
					bp.waitForElement();
					String expected=driver.findElement(By.xpath(testcase1+testcase[i]+testcase2)).getText();
					if(expected.equals(status))
						 {
							 System.out.println("Pass-Status changed to" + expected +" Sucessfully");
						 }
					else
					{
						System.out.println("Status has not changed");
					}
				}
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
			
			
		}
		
		
		public boolean ValidateStatusOfTestCases(int[] testcase,String status) throws Exception
		{
			try
			{
				bp=new BasePage();
				for(int i=0;i<=testcase.length-1;i++)
				{
					bp.waitForElement();
				
					WebElement ele=driver.findElement(By.xpath(testcase1+testcase[i]+testcase2));
					String expected=ele.getText();
		
					if(expected.equals(status))
						 {
							 System.out.println("Pass-Validated changed Status to"  +  expected  +  "Sucessfully");
						 }
					
				
			    }
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
			
			
		}
		
		public boolean viewTooltip(int testCase) throws Exception
		{
			try
			{
			WebElement ele=driver.findElement(By.xpath(toolTipTestcase1+testCase+toolTipTestcase2));
			Actions a1=new Actions(driver);
			a1.moveToElement(ele).perform();
			//Alert a2=driver.switchTo().alert();
			String text=ele.getText();
			System.out.println(text);
			
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		
//			
			
//		
		
		
		
		public boolean clickOnDefectButton(int testcase) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				Actions a1=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath(defectButton1+testcase+defectButton2));
			boolean res=ele.isDisplayed();
			if(res==true)
			{
				
				//ele.click();
				a1.moveToElement(ele).pause(1800).click().perform();
				System.out.println("Defect button clicked successfully");
			}
			bp.waitForElement();
			try
			{
			
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='External DTS Login']")));
			
			 bp.waitForElement();
		    	bp.eraseText(dtsUsername);
		    	//username.click();
		    	bp.waitForElement();
		    	dtsUsername.sendKeys("automation");
		    	dtsPassword.click();
		    	bp.waitForElement();
		    	dtsPassword.sendKeys("password");
		    	bp.waitForElement();
		    	//reEnterPassword.click();
		    	bp.waitForElement();
		    	reEnterPass.sendKeys("password");
		    	bp.waitForElement();
		    	dtsSaveButton.click();
		    	
		    	bp.waitForElement();
		    	//updateStatus1.click();
			}
		    	
		    	catch(TimeoutException e)
		    	{
		    		System.out.println("Already DTS Updated" );
		    	}
			
			
			
			
			
			
		
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Defect Button is not visible");
				e.printStackTrace();
				throw e;
			}
			
			
		}
		
		
		//MOve to DefectTracking Page
//		public boolean createDefect(String project,String issuetype) throws Exception
//		{
//		try
//		{
//			bp=new BasePage();
//			bp.waitForElement();
//			bp.explicitWait(createDefectButton);
//			createDefectButton.click();
//			bp.waitForElement();
//			bp.explicitWait(selectProject);
//			//selectProject.click();
//			Actions a1=new Actions(driver);
//			a1.moveToElement(selectProject).click().pause(1800).sendKeys(project).sendKeys(Keys.ENTER).perform();
//			bp.waitForElement();
//			a1.moveToElement(issueType).click().pause(1800).sendKeys(issuetype).sendKeys(Keys.ENTER).perform();
//			bp.explicitWait(next);
//			next.click();
//			return true;
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//		}
//		
//		
//}
		

		public boolean loginToDTS(String username,String password) throws Exception
		
		{
			try
	    	{
		
			   boolean res=resetUser.isDisplayed();
			  if(res==true)
			   {
	    	   bp=new BasePage();
		       bp.waitForElement();
	    	   resetUser.click();
			   }
	    	bp.waitForElement();
	    	bp.eraseText(dtsUsername);
	    	//username.click();
	    	bp.waitForElement();
	    	dtsUsername.sendKeys(username);
	    	dtsPassword.click();
	    	bp.waitForElement();
	    	dtsPassword.sendKeys(password);
	    	bp.waitForElement();
	    	//reEnterPassword.click();
	    	bp.waitForElement();
	    	reEnterPass.sendKeys(password);
	    	bp.waitForElement();
	    	dtsUpdateButton.click();
	    	
	    	bp.waitForElement();
	    	//updateStatus1.click();
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    
		}
		
		
		public boolean changeStepDetailStatus(int[] stepNo,String[] status) throws Exception
	    {
	     try
	     {
	    	 bp=new BasePage();
	    	 int lastStep=stepNo.length;
	    	   bp.waitForElement();
//		        stepDetailButton.click();
		        bp.waitForElement();
	    	 for(int i=0;i<=stepNo.length-1;i++)
	    	 {
	         
	        
	         WebElement ele=driver.findElement(By.xpath(stepStatus1+stepNo[i]+stepStatus2));
	        Actions a1=new Actions(driver);
	        a1.moveToElement(ele).click().pause(1200).sendKeys(status[i]).sendKeys(Keys.ENTER).perform();
	        bp.waitForElement();
	      
	      if(stepNo[i]==lastStep)
	     {	
	    WebDriverWait wait1=new WebDriverWait(driver,30);
	    wait1.until(ExpectedConditions.elementToBeClickable(confirmStepStatus));
	    confirmStepStatus.click();
	    bp.waitForElement();
	      
	      }
	     
	      }
	    	 return true;
		        
	     }
	     catch(Exception e)
	     {
	      e.printStackTrace();
	      throw e;
	     }
		}
		
		public boolean validateStepDetailStatus(int[] stepNo,String[] status) throws Exception
		{
			try
			{
				bp=new BasePage();
			
				for(int i=0;i<=stepNo.length-1;i++)
		    	 {
		         
		        
		         WebElement ele=driver.findElement(By.xpath(stepStatus1+stepNo[i]+stepStatus2));
				
				 String expected=ele.getText();
				
				if(expected.equals(status[i]))
				 {
					 System.out.println("Pass-Validated changed Step Status to" + expected +" Sucessfully");
				 }
		    	 }
				return true;
			   
			  }
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		
		public boolean selectMultipleTestCaseFromExecutionGrid(String[] testCaseNo) throws Exception
		{
			try
			{
				
				 bp=new BasePage();
				bp.waitForElement();
				//int length=testCaseNo.length-1;
//				String s3=testcase1+testCaseName+testcase2;
//				driver.findElement(By.xpath(s3)).click();
				for(int i=0;i<=testCaseNo.length-1;i++)
				{
					bp.waitForElement();
				WebElement ele=driver.findElement(By.xpath(testCaseCheckbox1+testCaseNo[i]+testCaseCheckbox2));
				Actions a1=new Actions(driver);
				a1.moveToElement(ele).click().perform();
                
				}
				log.info(testCaseNo.length+" Test Case Selected");
				return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
	}
		
		
		public boolean selectAndDeselectAllTestCase() throws Exception
		{
			try
			{
				bp=new BasePage();
			    bp.waitForElement();
				boolean res=selectAllTestCases.isSelected();
				if(res==false)
				{
				Actions a1=new Actions(driver);
				a1.moveToElement(selectAllTestCases).click().perform();
				
				
				System.out.println("Pass-All test cases Selected Successfully");
				}
				 
				if(res==true)
				{
				Actions a2=new Actions(driver);
				a2.moveToElement(selectAllTestCases).click().perform();
				
				
				System.out.println("Pass-All test cases Deselected Successfully");
				}
				return true;
			   
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		
		
		public boolean changeMultiSelectedStatus(String status) throws Exception
		{
			try
			{
				bp=new BasePage();
//				select_Assignee.click();
//				bp.waitForElement();
				Actions act=new Actions(driver);
				act.moveToElement(multiStatus).click().pause(1500).sendKeys(status).sendKeys(Keys.ENTER).perform();
				bp.waitForElement();
//				clickonOK.click();
//				bp.waitForElement();
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Fail-fail to select status ");
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean ValidateDeletedAttachement() throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				
			String text=validateDeleteAttachement.getText();
			System.out.println("Attachement count-"+text);
			
			
			
			return true;
			}
			
			catch(Exception e)
			{
				log.info("Attachement File not present");
				e.printStackTrace();
				throw e;
				//return false;
			}
		}

		
		
		
		public boolean checkVersionInList(int[] testcase,String version) throws Exception
		{
			try
			{
				for(int i=0;i<testcase.length-1;i++)
				{
			     WebElement ele=driver.findElement(By.xpath(validateVersion1+testcase[i]+validateVersion2));
			     String text=ele.getText();
			     System.out.println(text);
			
			      if(text.contains(version))
			      {
			      System.out.println("Version- "+text);
			      }
			
			     else
			     {
				   System.out.println("Version is not displayed");
			      }
				}
			return true;
			
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				throw e;
			}
		}
		
		
		public boolean linkDefect() throws Exception
		{
			try
			{
				bp=new BasePage();

			bp.waitForElement();
			Actions a=new Actions(driver);
			boolean res=linkDefects.isDisplayed();
			if(res==true)	
			{
			//bp.explicitWait(linkDefects);
			linkDefects.click();
			bp.waitForElement();
			System.out.println("Defect linked with test cases"); 
			}
			bp.waitForElement();
			a.moveToElement(cancelDefect).perform();
			cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			
			}
			catch(NoSuchElementException el)
			{
				System.out.println("Issue Does Not Exist");
			}
			
			catch(Exception e)
			{
				
				e.printStackTrace();
				throw e;
			}
			
			return true;
		}
		
		
		public boolean validateLinkedDefect(int testcase,String defectID) throws Exception
		{
			
			try
			{
				bp=new BasePage();
			WebElement ele=driver.findElement(By.xpath(validateDefectTestCase1+testcase+validateDefectTestCase2));
			
			String text =ele.getText();
			System.out.println(text);
			if(text.contains(defectID))
			{
				Actions a1 = new Actions(driver);
		        a1.moveToElement(ele).perform();
		     // String toolTipText = ele.getAttribute("popoverContent");
		      String toolTipText=popupContent.getText();
		    //System.out.println("Tooltip value is-"+toolTipText);
		    System.out.println("Tooltip value is-"+toolTipText);
		    
		    a1.moveToElement(project).perform();
		    }
			
			else
			{
				System.out.println("Defect is not matched");
			}
			
			
			bp.waitForElement();
			return true;
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean validateNotes(String note) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				String valNote=notes.getText();
				if(note.equals(valNote))
				{
					System.out.println("Notes Successfully saved");
				}
				
				else
				{
					System.out.println("Notes not Saved");
				}
			    bp.waitForElement();
				return true;
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				throw e;
			}
		
}  
		
		
		public boolean validateSort(String[] sortName) throws Exception
		{
			try
			{
				for(int i=0;i<=sortName.length-1;i++)
				{
		    	WebElement ele=driver.findElement(By.xpath(valSort1+sortName[i]+valSort2));
			   String text=ele.getText();
			    System.out.println(text+"-Column Successfully sorted");
				}
			return true;
			}
			
			catch(Exception e)
			{
				
				e.printStackTrace();
				throw e;
			}
		}
		  public boolean deleteDefect(int[] testcase) throws Exception {
         try {
				bp=new BasePage();
				for(int i=0;i<=testcase.length-1;i++)
				{
				WebElement ele=driver.findElement(By.xpath(option1+testcase[i]+option2));
				
				boolean res=ele.isSelected();
				if(res==false)
				{
				Actions al=new Actions(driver);
				al.moveToElement(ele).click().perform(); 
				 bp.waitForElement();
				}
				//al.moveToElement(ele).click().perform(); 
				}
				Delete.click();
			    bp.waitForElement();
			    confirmDelete.click();
			    bp.waitForElement();
			    System.out.println("Defect deleted succesfully");
//			    bp.explicitWait(cancelDefect);
//			    cancelDefect.click();
//				 bp.waitForElement();
				
			  return true;
			  }
			  catch (Exception e)
			  {
				  e.printStackTrace();
				  throw e;
			  }
		  }
				
			public boolean uploadAttachementInList(int tcNo,String filePath) throws Exception
			  {
			   try
			   {
			    bp=new BasePage();
			    bp.waitForElement();
			    WebElement ele1=driver.findElement(By.xpath(attachment1+tcNo+attachment2));
			       ele1.click();
			    bp.waitForElement();
			    try
			    {
			    boolean res4=addAttachment.isDisplayed();
			    //System.out.println("d-"+res3);
			    System.out.println(res4);
			    if(res4=true)
			    {
			    	bp.waitForElement();
			     addAttachment.click();
			     System.out.println("Add button clicked successfully");
			    }
			    }
			    catch(NoSuchElementException ele)
			    {
			     System.out.println("Add button not required");
			    }
			    chooseFileYourComputer.click();
			    bp.waitForElement();
			   
			   
			   bp.waitForElement();
			   Runtime.getRuntime().exec(filePath);
			   bp.waitForElement();
			   
			   System.out.println("File Uploaded Successfully");
			   bp.waitForElement();
			   closeAttachment.click();
			   return true;
			   }
			   catch(Exception e)
			   {
			    e.printStackTrace();
			    log.info("File is not Uploaded");
			    throw e;
			    
			   }
			  }	
			
			
			
			public boolean validateExecutions(String[] nodes) throws Exception {
				String cycle4;
				try {
					bp = new BasePage();
					for (int i = 0; i <= nodes.length - 1; i++) {
						bp.waitForElement();
						cycle4 = cycle1 + nodes[i] + cycle2;
						WebElement nodeElement = driver.findElement(By.xpath(cycle4));
						Actions act = new Actions(driver);
						act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
						System.out.println("Pass - Double click on'" + nodes[i] + "' Successfull");
						bp.waitForElement();
					}
					return true;
				} catch (NoSuchElementException e) {
					System.out.println("Node(Executions) is not visible for User");
					return true;
				}

				catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
			

			/* ****************************************************
			   * Method Name   : reportType(String report_Type) 
			  * Purpose    : To select report type in export page
			  * Author    : OPAL1
			  * Date Created   : 19/10/17
			  * Date Modified  :
			  * Reviewed By   : Opal4
			  * ******************************************************
			  */
			public boolean reportType(String report_Type) throws Exception 
			{
				try
				{
					bp=new BasePage();
				for(int l=48;l<=50;l++)//changed /////////////////////
				{
				//WebElement rType=driver.findElement(By.xpath("//*[text()='report_Type']");
				WebElement rType=driver.findElement(By.xpath(reportType1+l+reportType2));
				//System.out.println(rType);
				String report=rType.getText();
				System.out.println(report);
				System.out.println(report_Type);
				if(report_Type.equalsIgnoreCase(report))
				{
					bp.waitForElement();
					rType.click();
					//System.out.println(report_Type);
					log.info("Report Type Selected- "+report_Type);
				}	
			 }
				
				
				return true;
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			}
			
			
			public boolean clickOnNodeExport() throws Exception
			{
				try
				{
				bp=new BasePage();
			   options.click();
			   bp.waitForElement();
			   System.out.println("Pass-successfully clicked on option");
			   Actions a1=new Actions(driver);
			   a1.moveToElement(exportOption).click().perform();
			   //ele.click();
			   bp.waitForElement();
			   System.out.println("Pass-successfully clicked on Export option");
			   
			   //Verification Page
			  
			   String verifyexportPage=exportPage.getText();
			  //System.out.println(verifyexportPage);
			  //System.out.println(exportPageTitle);
			 
			     Assert.assertEquals(exportPageTitle,verifyexportPage); 
			     log.info("Successfully landed on Export page");
				return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					log.info("You are not navigated to Export Page");
					throw e;
				}
			}

			
				
			
	/********************23/10/17********************/ //added by srikanth
			public boolean filterByPriority(String[] Priority) throws Exception
			{
				try
				{
				bp=new BasePage();
				if(Priority[0]!=(""))
				 priorityInExportPage.click();
					bp.waitForElement();
				    //Thread.sleep(2000);
					driver.findElement(By.xpath(priorityFilterField)).click();
					
					
					for(int k=0;k<=Priority.length-1;k++)
					{
						Actions a1=new Actions(driver);
						System.out.println(Priority[k]);
						a1.sendKeys(Priority[k]).sendKeys(Keys.ENTER).perform();
						
						bp.waitForElement();
					}
					Actions a2=new Actions(driver);
					a2.sendKeys(Keys.ENTER).perform();
					a2.sendKeys(Keys.ENTER).perform();
					
			return true;
			}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
			}
			 public boolean uploadStepAttachement(String[] filePath) throws Exception
				{
					try
					{
						bp=new BasePage();
						bp.waitForElement();
					for(int i=0;i<=filePath.length-1;i++)
					{
					
					NoAttachment.click();
					bp.waitForElement();
					bp.waitForElement();
					chooseFile.click();
					bp.waitForElement();
					Runtime.getRuntime().exec(filePath[i]);
					bp.waitForElement();
					bp.waitForElement();
					bp.waitForElement();
					close.click();
					bp.waitForElement();
					
					
					System.out.println("File Uploaded Successfully");
					}
					return true;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						log.info("File is not Uploaded");
						throw e;
						
					}
				}
			 
			 public boolean validateStepAttachment() throws Exception
			 {
				 try 
				 {
					 bp=new BasePage();
					 bp.waitForElement();
					boolean Validate= NoAttachment.isDisplayed();
					// Actions act=new Actions(driver);
					 //act.moveToElement(ele).perform();
					// bp.waitForElement();
					 if(Validate==true)
					 {
						System.out.println("Attached file validated successfully"); 
					 }
					 else
					 {
						 System.out.println("Attached file validated unsuccessfully");
					 }
					 return true; }
				 catch(Exception e)
				 {
					 System.out.println("File is not Attached");
					 throw e;
					 
				 }
				
			 }
			 
			 public boolean stepAttachmentDownload(int [] attachmentNo ) throws Exception
			 {
				 try
				 {
					 bp=new BasePage();
					 bp.waitForElement();
					 stepDetailButton.click();
					 bp.waitForElement();
					 for(int i=0;i<=attachmentNo.length-1;i++)
					 {
					 WebElement ele=driver.findElement(By.xpath(stepAttach1+attachmentNo[i]+stepAttach2));
					 Actions act=new Actions(driver);
					 act.moveToElement(ele).click().perform();
					 bp.waitForElement();
					 bp.waitForElement();
					 Download.click();
					 bp.waitForElement();
					System.out.println("Attached File is successfully Downloaded"); 
					close.click();
					bp.waitForElement();
				 }}
				 catch(Exception e)
				 {
					 System.out.println("File is not attached to Download");
				 }
				 return true; }			
						
			 public boolean stepSort(String [] sortName) throws Exception
				{
				 try{
					 bp=new BasePage();
					 stepDetailButton.click();
					 bp.waitForElement();
					 boolean attach=NoAttachment.isDisplayed();
					 bp.waitForElement();
					 System.out.println(attach);
					 if(attach==false)
					 {
					 stepSort.click();
					 
					 bp.waitForElement();
					 for(int i=0;i<=sortName.length-1;i++)
					 {
						 if(sortName[i].equals("Attachment"))
						 {
							 WebElement ele=driver.findElement(By.xpath(sortElement1+sortName[i]+sortElement2+sortElement3));
							 String data=ele.getText();
							 System.out.println(data);
							 bp.waitForElement();
							 boolean res=ele.isSelected();
							 System.out.println(res);
						 
							 if(res==false && sortName[i].equals(data))
							 {   bp=new BasePage();
								 bp.waitForElement();
								 ele.click();
								 bp.waitForElement();
							 }}
							 else
							 {
								 System.out.println("is visible");
							 }}
							 
						 Actions a1=new Actions(driver);
					     a1.moveToElement(stepStatus).click().perform();
					     bp.waitForElement(); 
					
					}}
				 
				 catch(Exception e)
				 {
					e.printStackTrace();
					
				 }
				 return true;
				
				}
			 
			 
			 
			 //Paste IN External Jira
			 				
			 
					
		
		
		public boolean syncDefects() throws Exception
		{
			try
			{
			bp=new BasePage();
			options.click();
			System.out.println("Pass-Successfully clicked on Option");
			bp.waitForElement();
			syncOption.click();
			System.out.println("Pass-Successfully clicked on Sync Option");
			bp.waitForElement();
			syncPopUp.click();
			System.out.println("Pass-Successfully clicked on Sync Confirmation PopUp");
			String expected= driver.findElement(By.xpath(syncProgressCompletion)).getText();
			System.out.println(expected);
			bp.waitForElement();
			closeSyncPopUp.click();
			System.out.println("Pass-Successfully closed the Sync PopUp window");
			bp.waitForElement();
			
			return true;
			}
			 catch(Exception e)
			{
			 e.printStackTrace();
			 throw e;
			}
			
		}

		public boolean selectAllExecutions() throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			allExecutions.click();
			bp.waitForElement();
			
			return true;
		}
		
		catch(Exception e)
		   {
		    e.printStackTrace();
		    throw e;
		   }
		   
	}
		
		
		//Paste In External Jira
		
		
		
		public boolean uploadDefectAttachement(String[] filePath) throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			
			Actions a3=new Actions(driver);
			for(int i=1;i<=2;i++)
			  {
					a3.sendKeys(Keys.DOWN).perform();
			  }
		bp.waitForElement();
		for(int i=0;i<=filePath.length-1;i++)
		{
		
		browseInExternalJira.click();
		
		bp.waitForElement();
		Runtime.getRuntime().exec(filePath[i]);
		bp.waitForElement();
		}
		
		System.out.println("File Uploaded Successfully");
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("File is not Uploaded");
			throw e;
			
		}
}
		
		
		
//		public boolean updateDefect() throws Exception
//		{
//			try
//			{
//				bp=new BasePage();
//				bp.waitForElement();
//				
//			updateDefect.click();
//			bp.waitForElement();
//			
//			return true;
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				log.info("Defect button is not clicked");
//				throw e;
//				
//			}
//		}
		
		
		
		
		
		
		
				

		public boolean searchDefect(String defectId) throws Exception {
			try {
				bp = new BasePage();
				bp.waitForElement();
				JavascriptExecutor js=((JavascriptExecutor)driver);
				js.executeScript("arguments[0].scrollIntoView(true);",searchDefectID );
				bp.waitForElement();
				searchDefectID.clear();
				bp.waitForElement();
				searchDefectID.sendKeys(defectId);
				defectSearchButton.click();
				System.out.println("Defect search button clicked successfully");
				bp.waitForElement();
				bp.waitForElement();

				String value = driver.findElement(By.xpath("//*[@id='grid-table-DEFECTS_LINK_SEARCH']//span/a")).getText();

				if (value.equalsIgnoreCase(defectId)) {
					System.out.println("Defect is present");
					return true;
				}
				else
				{
					System.out.println("Defect is not present");
					return false;
				}

				
			} catch (NoSuchElementException e) {
				System.out.println("Defct is not exist");
				return false;
			}

			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		//Paste In CreateCustomFieldPage
		
		
		public boolean clickOnSubTask() throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.explicitWait(clickOnSubTask);
				clickOnSubTask.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				log.info("Defect button is not clicked");
				throw e;
				
			}
		}
		
		
		
		
		public boolean defectSearch(String selectSearch,String value) throws Exception
		{
			try 
			{
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			if(selectSearch!="")
			{			
			Actions v1=new Actions(driver);
			List<WebElement> vle1=driver.findElements(By.xpath("//span[@id='select2-searchChoice-container']"));
			v1.pause(1500).moveToElement(vle1.get(vle1.size()-1)).click().perform();
			bp.waitForElement();
			WebElement vle2 = driver.findElement(By.xpath(selectSearch1+selectSearch+selectSearch2));
			vle2.click();
			System.out.println("sucessfully selected" +selectSearch );
			bp.waitForElement();
			bp.waitForElement();
			
			if(selectSearch.equals("Defect Id"))
			{
				searchDefectID.clear();
				bp.waitForElement();
				searchDefectID.sendKeys(value);
				bp.waitForElement();
				
//				defectSearchButton.click();
//				System.out.println("Defect search button clicked successfully");
//				bp.waitForElement();
			}
			
			else if(selectSearch.equals("JQL"))
			{
				//searchDefectID.clear();//previous
				bp.waitForElement();
				searchJqlID.sendKeys(value);
				bp.waitForElement();
				
//				defectSearchButton.click();
//				System.out.println("Defect search button clicked successfully");
//				bp.waitForElement();
			}
			else if(selectSearch.equals("My Filters"))
			{
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				Actions a=new Actions(driver);
				a.moveToElement(searchMyFilterID).click().perform();
				//searchMyFilterID.clear();
				bp.waitForElement();
				a.sendKeys(value).sendKeys(Keys.ENTER).build().perform();
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				
//				defectSearchButton.click();
//				System.out.println("Defect search button clicked successfully");
//				bp.waitForElement();
			}
			}
			
			
			defectSearchButton.click();
			System.out.println("Defect search button clicked successfully");
			bp.waitForElement();
				return true;
		    }
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}
		
		
		public boolean validateDefectDescription() throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				String text=enterDescription.getText();
				System.out.println(text);
				System.out.println("Defect Description is:" +text);
				bp.waitForElement();
				bp.waitForElement();
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		//move To Defect Tracking Page
		
//		public boolean saveDefect() throws Exception
//		{
//			try
//			{
//				bp=new BasePage();
//				bp.waitForElement();
//				createButtonSave.click();
//				System.out.println("Pass-Defect is created and saved");
//				bp.waitForElement();
//			
//			   return true;
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				log.info("Defect button is not clicked");
//				throw e;
//				
//			}
//		}
//		public boolean updateDefect() throws Exception
//		{
//			try
//			{
//				bp=new BasePage();
//				bp.waitForElement();
//				bp.waitForElement();
//			   updateDefect.click();
//			   System.out.println("Pass-Defect is updated successfully");
//			   bp.waitForElement();
//			   bp.waitForElement();
//			   return true;
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//				log.info("Defect button is not clicked");
//				throw e;
//				
//			}
//		}
//		
		
		public boolean applyNotification() throws Exception
		{
			try
			{
				bp=new BasePage();
				Actions notification=new Actions(driver);
				notification.moveToElement(moveToNotificationElement).perform();
				bp.waitForElement();
				 
				 boolean status=applyNotification.isDisplayed();
				 System.out.println(status);
				 if(status==true)
				 {
				  notification.moveToElement(applyNotification).click().perform();
				  bp.waitForElement();
				 }
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

		public boolean clickOnDefectIDButton(int testcase) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath(defectButton3+testcase+defectButton4));
			boolean res=ele.isDisplayed();
			if(res==true)
			{
				ele.click();
				System.out.println("Defect-ID button clicked successfully");
			}
			else
			{
				System.out.println("Defect-ID button not there");
			}
			bp.waitForElement();
			return true;
			}
			
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean advancedSearch2(String selectSearch, String name) throws Exception
		{
			try 
			{
			bp=new BasePage();
//			bp.waitForElement();
//			boolean res=Advance.isDisplayed();
//			if(res==true)
//			{
//			//bp.explicitWait(Advance);
//			Advance.click();
//			bp.waitForElement();
//			System.out.println("Sucessfully clicked on Advanced Button");
//			bp.waitForElement();
//			}
//			bp.waitForElement();
			bp.waitForElement();
					
			Actions v1=new Actions(driver);
			List<WebElement> vle1=driver.findElements(By.xpath("//span[@id='select2-searchChoice-container']"));
			v1.pause(1500).moveToElement(vle1.get(vle1.size()-1)).click().perform();
			bp.waitForElement();
			WebElement vle2 = driver.findElement(By.xpath(selectSearch1+selectSearch+selectSearch2));
			String searchType=vle2.getText();
	    	vle2.click();
			System.out.println("sucessfully selected" +selectSearch );
			
			bp.waitForElement();
			 if(searchType.equals("JQL"))
			 {
			SearchDefect.click();
			bp.waitForElement();
			SearchDefect.clear();
			SearchDefect.sendKeys(name);
			Search.click();
			bp.waitForElement();
			}
				return true;
		    }
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}
		public boolean clickOnSubtask() throws Exception
		  {
		   try
		   {
		    bp=new BasePage();
		    bp.waitForElement();
		    createSubtask.click();
		    System.out.println("Pass-Subtask Icon is clicked successfully");
		    bp.waitForElement();
		    return true;
		   }
		   catch (Exception e) {
		    e.printStackTrace();
		    throw e;
		   }
		  }
		
		
		public boolean fileNewDefect(String summary,String components,String descType,String desc,String fixVersion,String priority,String assigneeValue,String labels,String sprintValue,String env,String epic_Link,String affects_Version,String linkedIssue) throws Exception
	    {
	     try
	     {
	      bp=new BasePage();
	              //Summary
	      
	     defectSummary.sendKeys(summary);
	     bp.waitForElement();
	     //Components
	     //driver.findElement(By.xpath("//*[@id='multiComponents-field-wrap-file-new']")).click();
	     if(components!="")
	     {
	     defectComponent.click();
	     driver.findElement(By.xpath(statusType1+components+statusType2)).click();;
	     }
	     bp.waitForElement();
	     //Description
	     if(descType!="" )
	     {
	    	 Select s1=new Select(defectDescriptionselection);
		     s1.selectByVisibleText(descType);
		    
	     }
	     bp.waitForElement();
	     if(desc!="")
	     {
	    	 enterDescription.sendKeys(desc);
	   
	     }  
	     
	     bp.waitForElement();
	    
//	     Select s2=new Select(fixVersionField);
	     if(fixVersion!="")
	     {
	     fixVersionField.click();
	     bp.waitForElement();
	     driver.findElement(By.xpath(value1+fixVersion+value2)).click();
	     }
//	     s2.selectByVisibleText(fixVersion);
	     bp.waitForElement();
	     
//	     Select s3=new Select(priorityField);
//	     s3.selectByVisibleText(priority);
	     if(priority!="")
	     {
	     priorityField.click();
	     bp.waitForElement();
	     
	     driver.findElement(By.xpath(value1+priority+value2)).click();
	     }
	     bp.waitForElement();
	     if(assigneeValue!="")
	     {
	     Actions a1=new Actions(driver);
	     a1.moveToElement(assignee).click().sendKeys(assigneeValue).pause(1200).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).perform();
	     }
	     if(labels!="")
	     {
	     bp.waitForElement();
	     labelField.sendKeys(labels);
	     }
	     bp.waitForElement();
	     if(sprintValue!="")
	     {
	     sprint.sendKeys(sprintValue);
	     bp.waitForElement();
	     }
	     if(env!="")
	     {
	     environment.sendKeys(env);
	     bp.waitForElement();
	     }
	     if(epic_Link!="")
	     {
	     epicLink.sendKeys(epic_Link);
	     bp.waitForElement();
	     }
//	     affectsVersion.sendKeys(AffectsVersion);
//	     bp.waitForElement();
	     if(affects_Version!="")
	     {
	     Actions a2=new Actions(driver);
	     a2.moveToElement(affectsVersion).click().sendKeys(affects_Version).sendKeys(Keys.ENTER).build().perform();
	     bp.waitForElement();
	     }
//	     linkedIssues.sendKeys(linkedIssue);
//	     bp.waitForElement();
	     if(linkedIssue!="")
	     {
	     linkedIssues.sendKeys(linkedIssue);
	     bp.waitForElement();
	     }
	     
	     bp.waitForElement();    
	     return true;
	     }
	     
	     catch(Exception e)
	     {
	      e.printStackTrace();
	      throw e;
	     }
	    }
		
		
		
		public boolean verifyExecutionPage() throws UserDefinedException, Exception
		{
			try
			{
				String pageTitle=driver.getTitle();
				if(pageTitle.equals("Test Execution - Zephyr Enterprise 6.1"))
				{
					System.out.println("Successfully navigated to test Execution Page");
				}
				else
				{
					throw new UserDefinedException("Not navigated to test execution Page");
				}
				
			
			
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		}
		
		
		public boolean validateCurrentlylinkedDefect() throws Exception
		{
			  try
			   {
			    bp=new BasePage();
			    bp.waitForElement();
			    WebElement ele=driver.findElement(By.xpath("//*[@id='grid-table-CURRENTLY_LINKED_DEFECTS']/div[2]//span"));
			    boolean res=ele.isDisplayed();
			    
			    if(res==true)
			    {
			    	
			    String id=ele.getText();
			    System.out.println("Defect Id="+id);
			    System.out.println("Defect detail is not viewed");
			    //System.out.println("Defect detail is viewed in Currently linked defects grid");
			    }
//			    else
//			    {
//			    System.out.println("Defect detail is not viewed");
//			    }
			  //  cancelDefect.click();
			    return true;
			   }
			  catch (NoSuchElementException e) {
			        System.out.println("No defect Link to the testcase");
			        return true;
			       } 
			   catch (Exception e) {
			    e.printStackTrace();
			    throw e;
			   }		
		}

		
		public boolean clickOnDefectButton(String testcase) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath(defectButton1+testcase+defectButton2));
			boolean res=ele.isDisplayed();
			if(res==true)
			{
				ele.click();
				System.out.println("Defect button clicked successfully");
			}
			bp.waitForElement();
			try
			{
			
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='External DTS Login']")));
			
			 bp.waitForElement();
		    	bp.eraseText(dtsUsername);
		    	//username.click();
		    	bp.waitForElement();
		    	dtsUsername.sendKeys("automation");
		    	dtsPassword.click();
		    	bp.waitForElement();
		    	dtsPassword.sendKeys("password");
		    	bp.waitForElement();
		    	//reEnterPassword.click();
		    	bp.waitForElement();
		    	reEnterPass.sendKeys("password");
		    	bp.waitForElement();
		    	dtsSaveButton.click();
		    	
		    	bp.waitForElement();
		    	//updateStatus1.click();
			    }
		    	catch(TimeoutException e)
		    	{
		    		System.out.println("Already DTS Updated" );
		    	}
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Defect Button is not visible");
				e.printStackTrace();
				throw e;
			}
		}
		public boolean createDefect(String project,String issuetype) throws Exception
		  {
		  try
		  {
		   bp=new BasePage();
		   bp.waitForElement();
		   bp.explicitWait(createDefectButton);
		   createDefectButton.click();
		   bp.waitForElement();
		   bp.explicitWait(selectProject);
		   Actions a1=new Actions(driver);
		   a1.moveToElement(selectProject).click().pause(1200).sendKeys(project).perform();
		   bp.waitForElement();
		   driver.findElement(By.xpath(statusType1+project+statusType2)).click();
			bp.waitForElement();
		   a1.moveToElement(issueType).click().pause(1200).sendKeys(issuetype).sendKeys(Keys.ENTER).perform();
		   bp.explicitWait(next);
		   next.click();
		   return true;
		   
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		  }
		  
		
	public boolean validateSearchedDefect(String defectId) throws Exception, UserDefinedException
	{
		
		try
		{
			String value = driver.findElement(By.xpath("//*[@id='grid-table-DEFECTS_LINK_SEARCH']//span/a")).getText();

			if (value.equalsIgnoreCase(defectId)) {
				System.out.println("Defect is serached successfully ");
				return true;
			}
			
			else
			{
				throw new UserDefinedException("Defect is not searched Suuccessfully");
			}
		}
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	}
	
	
	public boolean validateSearchedDefect(String defectType,String defectValue) throws Exception{
	     
	    try
	    {
	     bp=new BasePage();
	     String lastResult=searchCount.getText();
	     
	     int remainder=(Integer.parseInt(lastResult))%50;
	     int lastPage=0;
	     if(remainder>0)
	     {
	      lastPage=(Integer.parseInt(lastResult))/50+1;
	     }
	     else
	     {
	     lastPage=(Integer.parseInt(lastResult))/50; 
	     }
	     int no=0;
	     //3-IssueType,4-summary,5-priority,6-Status,7-TestCycles,8-Testcases,9-components,10-version,11-fix version,12-Assignee,13-filed By
	     String t1="//*[@id='grid-table-DEFECTS_LINK_SEARCH']/div[2]/div[";
	     String t2="]/div[";
	     String t3="]/div/div";
	     
	     if(defectType.equals("Issue Type"))
	     {
	      no=2;
	     }
	     else if(defectType.equals("Status"))
	     {
	      no=3;
	     }
	     else if(defectType.equals("Summary"))
	     {
	      no=4;
	     }
	     else if(defectType.equals("Assigned To"))
	     {
	      no=6;
	     }
	     else if(defectType.equals("Priority"))
	     {
	      no=7;
	     }
	     
	     for(int i=1;i<=lastPage;i++)
	     {
	      
	     if(i<lastPage)
	     {
	        for(int j=1;j<=50;j++)  
	        {
	       WebElement defect_Value=driver.findElement(By.xpath(t1+j+t2+no+t3));  
	       String text=defect_Value.getText();
	       if(!defectType.equals("Version")||!defectType.equals("Component"))
	       {
	       
	              if(text.equals(defectValue))
	              {
	              System.out.println("Pass-Defect Value successfully validated");
	              }
	       }
	          else
	          {    
	         if(text.contains(defectValue))
	        {
	           System.out.println("Pass-Defect Value successfully validated");
	          }
	     }
	     }
	        
	        nextButton.click();
	      for(int k=1;k<10;k++)
	      {
	      bp.waitForElement();
	      }
	     } 
	      else if(i==lastPage)
	     {
	        for(int j=1;j<=remainder;j++)  
	         {
	       WebElement defect_Value=driver.findElement(By.xpath(t1+j+t2+no+t3));  
	       String text=defect_Value.getText();
	           if(!defectType.equals("Version")||!defectType.equals("Component"))
	          {
	       
	                 if(text.equals(defectValue))
	                  {
	                    System.out.println("Pass-Defect Value successfully validated");
	                   }
	          }
	             else
	                {    
	               if(text.contains(defectValue))
	               {
	                 System.out.println("Pass-Defect Value successfully validated");
	               }
	           }
	     }
	     
	     
	        }
	     }
	     
	  return true;
	     
	    }
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	  }
	
	
//	public boolean validateSearchedDefect(String defectType,String defectValue) throws Exception{
//	    
//		  try
//		  {
//		   bp=new BasePage();
//		   String lastResult=searchCount.getText();
//		   
//		   int remainder=(Integer.parseInt(lastResult))%50;
//		   int lastPage=0;
//		   if(remainder>0)
//		   {
//		    lastPage=(Integer.parseInt(lastResult))/50+1;
//		   }
//		   else
//		   {
//		   lastPage=(Integer.parseInt(lastResult))/50; 
//		   }
//		   int no=0;
//		   //3-IssueType,4-summary,5-priority,6-Status,7-TestCycles,8-Testcases,9-components,10-version,11-fix version,12-Assignee,13-filed By
//		   String t1="//*[@id='grid-table-DEFECTS_LINK_SEARCH']/div[2]/div[";
//		   String t2="]/div[";
//		   String t3="]/div/div";
//		   
//		   if(defectType.equals("Issue Type"))
//		   {
//		    no=2;
//		   }
//		   else if(defectType.equals("Status"))
//		   {
//		    no=3;
//		   }
//		   else if(defectType.equals("Summary"))
//		   {
//		    no=4;
//		   }
//		   else if(defectType.equals("Assigned To"))
//		   {
//		    no=6;
//		   }
//		   else if(defectType.equals("Priority"))
//		   {
//		    no=7;
//		   }
//		   
//		   for(int i=1;i<=lastPage;i++)
//		   {
//		    
//		   if(i<lastPage)
//		   {
//		      for(int j=1;j<=50;j++)  
//		      {
//		     WebElement defect_Value=driver.findElement(By.xpath(t1+j+t2+no+t3));  
//		     String text=defect_Value.getText();
//		     if(!defectType.equals("Version")||!defectType.equals("Component"))
//		     {
//		     
//		            if(text.equals(defectValue))
//		            {
//		            System.out.println("Pass-Defect Value successfully validated");
//		            }
//		     }
//		        else
//		        {    
//		       if(text.contains(defectValue))
//		      {
//		         System.out.println("Pass-Defect Value successfully validated");
//		        }
//		   }
//		   }
//		      
//		      nextButton.click();
//		    for(int k=1;k<10;k++)
//		    {
//		    bp.waitForElement();
//		    }
//		   } 
//		    else if(i==lastPage)
//		   {
//		      for(int j=1;j<=remainder;j++)  
//		       {
//		     WebElement defect_Value=driver.findElement(By.xpath(t1+j+t2+no+t3));  
//		     String text=defect_Value.getText();
//		         if(!defectType.equals("Version")||!defectType.equals("Component"))
//		        {
//		     
//		               if(text.equals(defectValue))
//		                {
//		                  System.out.println("Pass-Defect Value successfully validated");
//		                 }
//		        }
//		           else
//		              {    
//		             if(text.contains(defectValue))
//		             {
//		               System.out.println("Pass-Defect Value successfully validated");
//		             }
//		         }
//		   }
//		   
//		   
//		      }
//		   }
//		   
//		return true;
//		   
//		  }
//		 catch(Exception e)
//		 {
//		  e.printStackTrace();
//		  throw e;
//		 }
//		}
//	
	
	public boolean multipleDefectSearch(String selectSearch,String value[]) throws Exception
	{
		try 
		{
		bp=new BasePage();
		bp.waitForElement();
		Actions a=new Actions(driver);
		for(int i=0;i<=value.length-1;i++)
		{
		if(selectSearch!="")
		{			
		Actions v1=new Actions(driver);
		List<WebElement> vle1=driver.findElements(By.xpath("//span[@id='select2-searchChoice-container']"));
		v1.pause(1500).moveToElement(vle1.get(vle1.size()-1)).click().perform();
		bp.waitForElement();
		WebElement vle2 = driver.findElement(By.xpath(selectSearch1+selectSearch+selectSearch2));
		vle2.click();
		System.out.println("sucessfully selected" +selectSearch );
		bp.waitForElement();
		
		
		if(selectSearch.equals("Defect Id"))
		{
			searchDefectID.clear();
			searchDefectID.sendKeys(value[i]);
			bp.waitForElement();
			
			defectSearchButton.click();
			System.out.println("Defect search button clicked successfully");
			bp.waitForElement();
			linkDefects.click();
			System.out.println("Linked sucessfully");
			bp.waitForElement();
		}
		
		else if(selectSearch.equals("JQL"))
		{
			searchDefectID.clear();
			searchJqlID.sendKeys(value[i]);
			bp.waitForElement();
			
			defectSearchButton.click();
			System.out.println("Defect search button clicked successfully");
			bp.waitForElement();
			linkDefects.click();
			System.out.println("Linked sucessfully");
			bp.waitForElement();
		}
		else if(selectSearch.equals("My Filters"))
		{
			searchDefectID.clear();
			searchMyFilterID.click();
			bp.waitForElement();
			searchMyFilterID.sendKeys(value[i]);
			
			defectSearchButton.click();
			System.out.println("Defect search button clicked successfully");
			bp.waitForElement();
			linkDefects.click();
			System.out.println("Linked sucessfully");
			bp.waitForElement();
		}
		}
		}
		bp.waitForElement();
		a.moveToElement(cancelDefect).click().perform();
		
			return true;
	    }
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	public boolean validateTestSearchedDefect(String defectname) throws Exception{
		 try
		 {
			 
		 bp=new BasePage();
		 String lastResult=searchtestdefectCount.getText();
		 int page=(Integer.parseInt(lastResult))/50;
		 
		 
		 for(int i=0;i<=page;i++)
		 {
			 
			for(int j=0;j<=(Integer.parseInt(lastResult));j++)
					
			{
		 WebElement ele=driver.findElement(By.xpath(dvalue1+defectname+dvalue2));
		 String text=ele.getText();
		 if(text.equals(defectname))
		 {
		 System.out.println("Pass-DefectName successfully validated");
		 }
		 
			
			}
			
			
	
		 }
		 
		 return true;	
		 }
		 catch(Exception e)
		 {
		 e.printStackTrace();
		 throw e;
		 }
		}
	
	
	public String retrieveTestCaseId(String testCaseNo) throws Exception
    {
  try
  {
	bp=new BasePage();
	bp.waitForElement();
  String testCase=testcase1+testCaseNo+testcaseId;
  String testCaseId=driver.findElement(By.xpath(testCase)).getText();
  //log.info("ID-"+id+"- Test Case Selected ");
  return testCaseId;
  
  }
  catch(Exception e)
	{
	    e.printStackTrace();
	     throw e;
	}
    }
	public String retrieveDefectId() throws Exception
    {
    	try
    	{
    		bp=new BasePage();
    		bp.waitForElement();
    	String defectId=defect_ID.getText();
    	 String[] defectVal=defectId.split(": ");
   for(int i=0;i<=defectVal.length-1;i++)
   {
    	 System.out.println(defectVal[i]);
   }
  	    String defectValue_2=defectVal[1];
    	return defectValue_2;
        }
      catch(Exception e)
      {
      e.printStackTrace();
      throw e;	
    }
   }
	
	 public boolean validateLinkedDefectInLinkedDefectPage(String defectId) throws Exception
	  {
		  try
		  {
			  WebElement link=driver.findElement(By.xpath(link1+defectId+link2));
			  String linkDefect=link.getText();
			  
			  if(linkDefect.equalsIgnoreCase(defectId))
			  {
				  System.out.println("link is validated Sucessfully");
			  }
			  
			  return true;
		  }
		  catch(Exception e)
			{
			    e.printStackTrace();
			     throw e;
			}
	  }


	 public boolean viewDeletedDefectStatus(int testCase) throws Exception
		{
			try
			{
			WebElement ele=driver.findElement(By.xpath(toolTipTestcase1+testCase+toolTipTestcase2));
			Actions a1=new Actions(driver);
			a1.moveToElement(ele).perform();
			//Alert a2=driver.switchTo().alert();
			String text=ele.getText();
			
			String[] status=text.split("/n");
			for(int i=0;i<=status.length-1;i++)
			{
				System.out.println("view deleted-"+status[i]);
			}
			
//			if(status[1].equals("deleted"))
//			{
//				System.out.println("Defect status change to deleted");
//			}
//			
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
			
			
			public boolean validateLinkDefectWindow() throws Exception 
			{
				try
				{
				String  validate=linkDefectWindow.getText();
				if(validate.equals("Link Defect"))
				{
				 System.out.println("Link Defect Window Successfully Launched");	
				}
				
				return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
				
			}
			
			
			
			public boolean closeLinkedDefectWindow() throws Exception
			{
				try
				{
				bp=new BasePage();
				bp.waitForElement();
				bp.explicitWait(closeDefectWindow);
				
				bp.moveToElementAndClick(closeDefectWindow);
				return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			}

	 
	 public boolean clickOnDefectSearchButton() throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.explicitWait(defectSearchButton);
				defectSearchButton.click();
				System.out.println("Pass-Defect Search button is clicked successfully");
				bp.waitForElement();
				return true;
			}
			catch(Exception e)
			 {
			  e.printStackTrace();
			  throw e;
			 }
		}
	 
	
	 public boolean clickOnCancelDefectWindow() throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
				JavascriptExecutor js =((JavascriptExecutor) driver);
			    js.executeScript("arguments[0].scrollIntoView(true);", cancelDefect);
				bp.explicitWait(cancelDefect);
				cancelDefect.click();
				System.out.println("Pass-Cancel defect button is clicked successfully");
				bp.waitForElement();
				return true;
			}
			catch(Exception e)
			 {
			  e.printStackTrace();
			  throw e;
			 }
		}
	 
	 public boolean downloadDefectAttachment(String fileName) throws Exception
	 {
	  try
	  {
	   WebElement browseIcon=driver.findElement(By.xpath(browse1));
	   JavascriptExecutor js=((JavascriptExecutor)driver);
	   js.executeScript("arguments[0].scrollIntoView(true);",browseIcon );
	   bp.waitForElement();
	   WebElement ele=driver.findElement(By.xpath(attachFile1+fileName+attachFile2));
	   Actions act=new Actions(driver);
	   act.moveToElement(ele).click().perform();
       bp.waitForElement();
//	   bp.explicitWait(clickOnTestDownload);
//	   act.moveToElement(clickOnTestDownload).click();
//	   bp.waitForElement();
	  
	   return true;
	    }
	    catch(Exception e)
	    {
	    e.printStackTrace();
	    throw e;
	    }
	 }


	 public boolean viewDefectLinkMsg() throws Exception
	   {
	    try
	    {
	    bp=new BasePage(); 
	    bp.explicitWait(defectLinkMsg); 
	    Actions act=new Actions(driver);
	    act.moveToElement(defectLinkMsg).perform();
	    String text=defectLinkMsg.getText();
	    
	    //System.out.println(text);
	    if(text.equals("Info"))
	    {
	     System.out.println("Defect linking is validated successfully");
	    }	   
	     return true; 
	    }
	     catch(Exception e)
	     {
	     e.printStackTrace();
	     throw e;
	     }
	   }

	 
	 public boolean linkDefect(String defectId) throws Exception
		{
			try
			{
				bp=new BasePage();
			searchDefectID.sendKeys(defectId);
			bp.waitForElement();
			
			defectSearchButton.click();
			System.out.println("Defect search button clicked successfully");
			bp.waitForElement();
			bp.waitForElement();
			bp.explicitWait(linkDefects);
			linkDefects.click();
			System.out.println("Defect linked with test cases"); 
			bp.waitForElement();
			bp.waitTillElementIsVisible(cancelDefect);
			cancelDefect.click();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			return true;
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				throw e;
			}
			
		}
		
		
	 
//	 public boolean stepDownload(int [] attachmentNo ) throws Exception
//	 {
//		 try
//		 {
//			 bp=new BasePage();
//			 bp.waitForElement();
//			 stepDetailButton.click();
//			 bp.waitForElement();
//			 for(int i=0;i<=attachmentNo.length-1;i++)
//			 {
//			 WebElement ele=driver.findElement(By.xpath(stepAttach1+attachmentNo[i]+stepAttach2));
//			 Actions act=new Actions(driver);
//			 act.moveToElement(ele).click().perform();
//			 bp.waitForElement();
//			 bp.waitForElement();
//			 Download.click();
//			 bp.waitForElement();
//			System.out.println("Attached File is successfully Downloaded"); 
//			close.click();
//			bp.waitForElement();
//		 }}
//		 catch(Exception e)
//		 {
//			 System.out.println("File is not attached to Download");
//		 }
//		 return true; }			
	
	 
	 
	 public boolean clickOnCancelFileNewDefectButton() throws Exception
     {
      try
      {
       bp=new BasePage();
       bp.waitForElement();
       cancelFileNewDefectWindow.click();
       System.out.println("Pass-Defect Cancel button is clicked successfully");
       bp.waitForElement();
        return true;
         }
       catch(Exception e)
       {
       e.printStackTrace();
       throw e; 
     }
    }
  
	 

	 
	 public boolean dtsLoginDetail(String Username,String Password,String ReenterPassword) throws Exception
	    {
	    	try
	    	{
	    	bp=new BasePage();
		    bp.explicitWait(clickOnResetUser);
	    	clickOnResetUser.click();
	    	 bp.waitForElement();
	    	bp.eraseText(username);
	    	//username.click();
	    	bp.waitForElement();
	    	username.sendKeys(Username);
	    	bp.explicitWait(password);
	    	password.click();
	    	bp.waitForElement();
	    	password.sendKeys(Password);
	    	bp.waitForElement();
	    	//reEnterPassword.click();
	    	bp.waitForElement();
	    	reEnterPassword.sendKeys(ReenterPassword);
	    	bp.waitForElement();
	    	bp.explicitWait(update);
	    	update.click();
	    	bp.waitForElement();
	    	//updateUser.click();
////	    	boolean res=updateUser.isDisplayed();
//	    	if(res==true)
//	    	{
//	    		bp.explicitWait(updateUser);
//	    		updateUser.click();
//	    	}
	    	//bp.waitForElement();
	    	return true;
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		throw e;
	    	}
	    }
	
	 public boolean saveAndCancel() throws Exception
	 {
	 	 try
	 	  {
	 	   bp=new BasePage();
	 	   bp.waitForElement();
	 	   createButtonSave.click();
	 	   bp.waitForElement();
	 	   bp.waitForElement();
	 	    bp.explicitWait(newDefectCancelButton);
	 	   newDefectCancelButton.click();
	 	   bp.waitForElement();
	 	   return true;
	 	  }
	 	  catch(Exception e)
	 	  {
	 	   e.printStackTrace();
	 	   throw e;
	 	  }
	 	 
	  }
	 
	 
}


		
		
		
		
		