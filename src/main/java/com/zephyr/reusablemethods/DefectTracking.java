package com.zephyr.reusablemethods;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.AutomationConstants;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.DefectTracking_POM;

public class DefectTracking{

	   WebDriver driver=null;
	   BasePage bp;
	   public Logger log;
	   SoftAssert soft=new SoftAssert();
	public DefectTracking(WebDriver driver) 
	{
		  //super(driver);
		 this.driver =driver;
		 PageFactory.initElements(LaunchBrowser.driver, this);
		 log=Logger.getLogger(this.getClass());
		    Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		
	}
	
	////////////////////////POM/////////////////////////
	public String active1="//b[text()='";
    public String active2="']";
    
    @FindBy(xpath = "//div[@class='toast-message']")
	public WebElement popupMessage;
    
    @FindBy(xpath =" //button[@type='cancel']")
    public WebElement cancelComment;

    @FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	public WebElement savePreference;
	
	@FindBy(xpath = "(//button[contains(.,'Save')])[2]")
	public WebElement clickOnSavePreference;
 
public String categories1="//li[text()='";
public String categories2="']";

public String name1="//div[@title='";
public String name2="']";

@FindBy(xpath = "//button[@title='Add a preference']")
public WebElement clickonAddPreferences;

@FindBy(xpath = "//*[@placeholder='Enter Name']")
public WebElement enterPreferenceName;

@FindBy(xpath = "//*[@id='preference-value']")
public WebElement enterPreferenceValue;

	
	 @FindBy(xpath="//input[@class='grid_checkbox_all']")
	 public WebElement selectDefects;
    
    public String defectSel1="//*[@id='grid-table-DEFECT_DETAILS']/div[2]/div[";
    public String defectSel2="]/div[1]/div/div/input";
    public String outputType="]";
    
    public String defectValue1="//div[@class='defect-details-buttons']//*[text()='";
    public String defectValue2="']";
    
    
    public String defectSearch1="//*[@class='select2-selection__placeholder']/..//span[text()='";
    public String defectSearch2="']";
  
    
    public String defectSearchValue1=".//li[text()='";
//    @FindBy(xpath="//input[@placeholder='Select Component']")
//	 public WebElement enterComponents;
    public String defectSearchValue2="']";
    //*[@class='select2-selection__placeholder']/..//span[text()='Assignee']
    @FindBy(xpath="(//button[text()='Search'])[1]")
	 public WebElement defectSearch;
    
    @FindBy(xpath="(//button[text()='Save'])[1]")
	 public WebElement defectSave;
    
    @FindBy(xpath="//button[text()='Create Sub-task']")
	 public WebElement clickOnSubTask;
    
    public String multipleDefectValue1="//input[@placeholder='";
    public String multipleDefectValue2="']";
    
    @FindBy(xpath="//input[@placeholder='Select Component']")
	 public WebElement enterComponents;
    
    @FindBy(xpath="//input[@placeholder='Select Version']")
	 public WebElement enterVersions;
    
    @FindBy(xpath="//input[@placeholder='Select FixVersion']")
	 public WebElement enterFixVersions;
    
    @FindBy(xpath="//*[@id='select2-defect-bulk-edit-status-container']")
	 public WebElement enterStatus;
    
    @FindBy(xpath="//*[@id='select2-defect-bulk-edit-resolution-container']")
	 public WebElement enterResolution;
    
    @FindBy(xpath="//*[@id='select2-defect-bulk-edit-priority-container']")
	 public WebElement enterPriority;
   
   @FindBy(xpath="//*[@id='select2-defect-bulk-edit-assignee-container']")
	 public WebElement enterAssignee;
    
   // @FindBy(xpath="//span[@placeholder='Enter Comment']")
    public String defectComment="//span[@placeholder='Enter Comment']";
	 //public WebElement defectComment;
    
    //@FindBy(xpath="//*[@id='ze-main-app']/testcase-execution/div/div/section/div[2]/notifications")//previous
//    @FindBy(xpath="//div[@title='Notifications']")//new 09/05/18
//    public WebElement moveToNotificationElement;
//    
//    @FindBy(xpath="//button[@title='Click to apply notifications']")
//    public WebElement applyNotification;
    
    @FindBy(xpath="//*[text()='Create Defect']")
	    public WebElement createDefectButton;
 
    @FindBy(id="select2-fileNewDefectProject-container")
	   public WebElement selectDefectProject;
    
    @FindBy(xpath="//h4[text()='File New Defect']/../../div[2]/button")
	 public WebElement closeFileNewDefectPopUp;
    
	 @FindBy(xpath="//*[@id='issueType-wrap-']")
	 public WebElement issueType;
	 
	 @FindBy(xpath="//button[text()='Next']")
	 public WebElement next;
	 
	 @FindBy(xpath="(//*[@id='create-defects-fields-form']//input)[1]")
	  public WebElement defectSummary;
	 
	 
	@FindBy(xpath="//select[@id='copySteps']")
    public WebElement defectDescriptionselection;
  
  @FindBy(xpath="//*[@id='create-defects-fields-form']//textarea")
  public WebElement enterDescription;
 

 ///////////22/05/18/////////////////by srikanth 
//@FindBy(id="fixVersions-field-wrap-file-new")//previous
  @FindBy(xpath="//*[text()='Fix Version/s']/../../../..//span[@class='select2-selection select2-selection--multiple']")//updated
  public WebElement fixVersionField;
  
    //@FindBy(xpath="//*[@id='multiComponents-field-wrap-file-new']")//previous
    @FindBy(xpath="//*[text()='Component/s']/../../../..//span[@class='select2-selection select2-selection--multiple']")//updated
    public WebElement defectComponent;
 
  //@FindBy(id="multiVersions-field-wrap-file-new")//previous
  @FindBy(xpath="//*[text()='Affects Version/s']/../../../..//span[@class='select2-selection select2-selection--multiple']")//updated
  public WebElement affectsVersion;
  
  //@FindBy(id="priority-field-wrap-file-new")//previous
  @FindBy(xpath="//*[text()='Priority']/../../../..//span[@id='select2-priority-field-container']")
  public WebElement priorityField;
  
  //@FindBy(id="assigned_to-field-wrap-file-new")//previous
  @FindBy(xpath="//*[text()='Assignee']/../../../..//span[@id='select2-assigned_to-field-container']")//updated
  public WebElement assignee;
  
  public String value1="//li[text()='";
	 public String value2="']";
  
 
  
  @FindBy(xpath="//*[@id='labels-field']")
  public WebElement labelField;
  
 
  @FindBy(xpath="//*[@id='customfield_10215-field']")
  public WebElement sprint;
  
 
  
 
  @FindBy(xpath="//*[text()='Environment']/../../../..//input")
  public WebElement environment;
  @FindBy(xpath="//*[text()='Epic Link']/../../../..//input")
  public WebElement epicLink;
  
  
  
  
  @FindBy(xpath="//*[@id='issuelinks-field']")
  public WebElement linkedIssues;
  
     @FindBy(xpath="//*[@class='zui-btn zui-btn-primary' and text()='Create']")
	 public WebElement createButtonSave;
  
     public String statusType1=".//li[text()='";
	 public String statusType2="']";
	 
	 @FindBy(xpath="//*[@type='button' and text()='Update']")
	 public WebElement updateDefect1;
	 
	 @FindBy(xpath="(//*[@type='button' and text()='Update'])[1]")
	 public WebElement updateDefect3;
	 
	 @FindBy(xpath="(//*[@type='button' and text()='Update'])[2]")
	 public WebElement updateDefect2;
	 
	 @FindBy(xpath="(//*[@class='create-defect-action-buttons']//*[text()='Cancel'])")
	 public WebElement createCancelButton;
	 
	 
//	 
	 @FindBy(xpath="(//h4[@class='modal-title'])[17]")
	 public WebElement retrieveID;
	 ///////////////////////////////////////////////////////////////////////
//	 @FindBy(xpath="//*[@id='field_screens']")
//		public WebElement screen;
//		
//		@FindBy(xpath="//*[@id='add-field-screen']")
//		public WebElement addScreen;
//		
//		@FindBy(xpath="//*[@id='view_custom_fields']")
//		public WebElement customfield;
//		
//		@FindBy(xpath="//*[@id='add_custom_fields']")
//		public WebElement addcustomfield;
//		
//		@FindBy(xpath="//*[@name='fieldScreenName']")
//		public WebElement name;
//		
//		@FindBy(xpath="//*[@name='fieldScreenDescription']")
//		public WebElement description ;
//		
//		@FindBy(xpath="//*[@name='Add']")
//		public WebElement clickAdd;
//		
		public String dvalue1="//*[text()='";
		public String dvalue2="']";

		
		@FindBy(xpath="//a[text()='Advanced']")
			public WebElement advance;
		
		public String selectSearch1= "//li[text()='";
		public String selectSearch2= "']";
		
		@FindBy(xpath="//input[@id='searchDefectsJQL']")
		public WebElement SearchDefect;
		
		@FindBy(xpath="(//button[text()='Search'])[2]")
		public WebElement Search;
		
		@FindBy(xpath="//i[@class='fa fa-ellipsis-v']")
		public WebElement sortOption;

	    public String selectSort1= "//*[@class='zui-checkbox2']//*[text()='";
	    public String selectSort2= "']";

	    public String valSort1= "//*[@class='grid-header']//*[text()='";
	    public String valSort2= "']";
	    
	    
	    @FindBy(xpath="//div[@title='ID']")
	    public WebElement defectID;
	    
	    @FindBy(xpath="//*[text()='Administration']")
	    public WebElement Adminstration;
	    
	    public String admin1="//*[@class='aui-list-truncate']//a[text()='";
	    public String admin2="']";
	 
	 
//	 public String validateVal1="(//*[text()='";
//	 public String validateVal2="'])[1]";
	    //custom fields

		//LinkJira
		  
	      public String jiraLinkCheckbox1="(//*[@class='flex-bar'])[";
	      public String jiraLinkCheckbox2="]//input";
	      
	    

			 @FindBy(xpath="//*[@id='grid-table-defects_admin']/div[2]/div[1]/div[3]/div/div/div/input")
			 public WebElement checkbox;


			
			
			// public String value1="(//div[text()='false'])[";
			// public String value2="]";
			 
			 public String data1="//*[@id='grid-table-defects_admin']/div[2]/div[19]/div[2]/div/div";
			 
			
				
	      
	      //@FindBy(xpath=".//*[text()='Defects Admin']")//previous
	      @FindBy(xpath=".//span[text()='Defect Admin']")//updated 6.1
	 	 public WebElement defectsAdmin;
	      
	      
	      
	      @FindBy(xpath="//span[text()='Preferences']")
	  	 public WebElement preferences;
	      
	      @FindBy(xpath="//*[text()='General Configuration']")
	  	 public WebElement generalConfiguration;
	      
	      @FindBy(xpath="//*[text()='Custom Fields']")
		  public WebElement customFields;
	      
//	      @FindBy(xpath="//a[@data-tooltip='Project settings']")
//		  public WebElement projectSettings;
//	      
//	      @FindBy(xpath="//button[@id='project-config-tab-actions']")
//		  public WebElement actionIcon;
//	      
//	      @FindBy(xpath="//a[text()='Edit permissions']")
//		  public WebElement editIcon;
//	      
//	      public String projPermission1="//*[text()='";
//	      public String projPermission2="']/../..//*[text()='";
//	      public String projPermission3="']";
	      
	      @FindBy(xpath="//button[@class='aui-button aui-button-primary']/..//button[text()='Remove']")
		  public WebElement removeProjPermission;
	      
	      public String grantPermission1="//label[text()='";
	      public String grantPermission2="']";
	      
	      @FindBy(xpath="//button[text()='Grant']")
		  public WebElement grantPermission;
	      
	      
	      @FindBy(xpath ="//input[@placeholder='Search by Defect ID']")
			public WebElement searchDefectField;
		    
		    @FindBy(xpath ="//span[@class='fa fa-search']")
		   	public WebElement searchDefect;
		    
		    @FindBy(xpath =" //*[@id='defect-project-wrap-']")
		   	public WebElement selectProject;
		    
		    @FindBy(xpath =" //*[@id='select2-defect-issuetype-container']")
		   	public WebElement selectIssueType;
		    
		    @FindBy(xpath =" //*[@id='select2-defect-issuestatus-container']")
		   	public WebElement selectStatus;
		    
		    @FindBy(xpath =" //*[@id='select2-defect-defect_user-container']")
		   	public WebElement selectFiledBy;
		    
		    @FindBy(xpath ="  //*[@id='select2-defect-version-container']")
		   	public WebElement selectVersion;
		    
		    @FindBy(xpath ="  //*[@id='select2-defect-priority-container']")
		   	public WebElement selectPriority;
		    
		    @FindBy(xpath ="  //*[@id='select2-defect-assignee-container']")
		   	public WebElement selectAssignee;
		    
		    public String assignee1="//*[@value='";
		    public String assignee2="']";
		    
		    
		    @FindBy(xpath="//*[@class='page-track']/b[3]")
		    public WebElement searchCount;

		    @FindBy(xpath="//li[@class='next-page']//span")
		    public WebElement nextButton;
		    
		    @FindBy(xpath="//li[@class='showing']")
		    public WebElement advancedSearchCount;
		    
		    @FindBy(xpath="//h4[text()='Link Defect']")
		    public WebElement linkDefectWindow;
		    
//		    @FindBy(xpath="//*[@id='defect-link-modal']/div/div/div[1]/div[2]/button")
//			 public WebElement closeDefectWindow;
//		    
		    ////////////////////////////////////////////////
		    @FindBy(xpath="//span[@placeholder='Enter Summary']")
			 public WebElement enterDefectSummary;
			 
			 @FindBy(xpath="//span[@placeholder='Enter Components']")
			 public WebElement enterDefectComponent;
			 
			 @FindBy(xpath="//i[@class='fa fa-check']")
			 public WebElement saveIcon;
			 
			 @FindBy(xpath="//span[@placeholder='Enter Priority']")
			 public WebElement enterDefectPriority;
			 
			 @FindBy(xpath="//span[@placeholder='Enter Version']")
			 public WebElement enterDefectVersion;
			 
			 @FindBy(xpath="//span[@placeholder='Enter Fix Versions']")
			 public WebElement enterDefectFixVersions;
			 
			 @FindBy(xpath="//span[@placeholder='Enter Comment']")
			 public WebElement enterDefectComment;
			 
			 @FindBy(xpath="//span[@placeholder='Select Assignee']")
			 public WebElement enterDefectAssignee;
			 
			 @FindBy(xpath="//span[@placeholder='Select Environment']")
			 public WebElement enterDefectEnvironment;
			 
			 @FindBy(xpath="//a[@class='zui-link grid_link_click update-status-resolution-link']")
			 public WebElement defectUpdate;
			 
			 @FindBy(xpath="//*[@id='select2-defect-status-detail-view-container']")
			 public WebElement enterDefectStatus;
			 
			 @FindBy(xpath="//*[@id='select2-defect-resolution-detail-view-container']")
			 public WebElement enterDefectResolution;
			 
			 @FindBy(xpath="//*[@id='zee-defect-update-status-resolution']//button[text()='Update']")
			 public WebElement defectStatusUpdate;
			 
			 @FindBy(xpath="(//span[@class='zee-column-value'])[9]")
			 public WebElement defectResolution;
			 
			 @FindBy(xpath="//b[text()='Status']/../..//span/span")
			 public WebElement defectStatus;
			 
		    ////////////********Custom Fields*********///////////
			 @FindBy(xpath="//label[@title='ZE_FreeText_Field']/../../../..//span/textarea")
			 public WebElement customZE_FreeText_Field;
			 
			 public String customZE_Radio_Field1="//*[text()='ZE_Radio_Field']/../../../..//span/div//b[text()='";
			 public String customZE_Radio_Field2="']";
			 
			 public String customZE_Checkbox_Field1="//*[text()='ZE_Checkbox_Field']/../../../..//span/div//b[text()='";
			 public String customZE_Checkbox_Field2="']";
			 
			 @FindBy(xpath="//*[text()='ZE_Url_Field']/../../../..//div/span/input")
			 public WebElement customZE_Url_Field;
	
			 public String customZE_Date_PickerHeader="//*[text()='ZE_Date_Picker']/../../../..//div[@class='input-group date-group']";
			 //public WebElement customZE_Date_PickerHeader;
			 
			 public String ze_Date_Pickerday1="//table//span[text()='";
			 public String ze_Date_Pickerday2="']";
			 
			 public String ze_Date_Pickermonth1="//span[text()='";
			 public String ze_Date_Pickermonth2="']";
			 
			 public String ze_Date_PickerYear1="//span[text()='";
			 public String ze_Date_PickerYear2="']";
			 
			 @FindBy(xpath="//span[@class='text-info']")
	    	 public WebElement minYear;
	    		
	    		@FindBy(xpath="//button[@class='btn btn-default btn-sm pull-left']")
	    		public WebElement left;
			 
			 @FindBy(xpath="//*[text()='ZE_Multiple_Select_Field']/../../../..//span[@class='select2-selection select2-selection--multiple']")
			 public WebElement customZE_Multiple_Select_Field;
			 
			 @FindBy(xpath="//*[text()='ZE_Single_Select_Field']/../../../..//span[@class='select2-selection select2-selection--single']")
			 public WebElement customZE_Single_Select_Field;
			 
			//@FindBy(xpath="//*[text()='ZE_Mult_Version_field']/../../../..//input[@placeholder='Please select a value']")//previous
			 @FindBy(xpath="//*[text()='ZE_Mult_Version_Field']/../../../..//span[@class='select2-selection select2-selection--multiple']")//updated
			 public WebElement customZE_Mult_Version_field;
			 
			 @FindBy(xpath="//*[text()='ZE_Version_Field']/../../../..//span[@class='select2-selection select2-selection--single']")
			 public WebElement customZE_Version_Field;
			 
			 @FindBy(xpath="//*[text()='ZE_User_Picker']/../../../..//span[@class='select2-selection__rendered']")
			 public WebElement customZE_User_Picker;
			 
			 @FindBy(xpath="//*[text()='ZE_Label_Field']/../../../..//div/span/input")
			 public WebElement customZE_Label_Field;
			 
			 @FindBy(xpath="//*[text()='ZE_Multi_User_Picker']/../../../..//span[@class='select2-selection select2-selection--multiple']")
			 public WebElement customZE_Multi_User_Picker;
			 
			 @FindBy(xpath="//*[text()='ZE_Text_Field']/../../../..//div/span/input")
			 public WebElement customZE_Text_Field;
			 
			 @FindBy(xpath="//b[text()='Project']/../../../../div/span/label[@class='bold']")
			 public WebElement validateDefectProject;
			 
			 @FindBy(xpath="//b[text()='Issue Type']/../../../../div/span/label[@class='bold']")
			 public WebElement validateDefectIssueType;
			 
			 @FindBy(xpath="//span[@class='select2-results']")
			 public WebElement validateProjects;
			 
			 @FindAll({@FindBy(xpath="//*[@type='button' and text()='Update']")})
			  public List<WebElement> updateDefect;
			 
			 
			 @FindBy(xpath="//*[@id=\"file-new-defect-modal\"]/div/div/div[3]/zui-modal-footer/div/div/button[1]")
			 public WebElement CancelButton;
			 
			 @FindBy(xpath="//div[@class='input-group date-group']")
			 public WebElement customZE_Date_PickerOption;
			 
			 public String ze_Date_PickerHeader="//button[@class='btn btn-default btn-secondary btn-sm']/strong";
			 
			 public String ze_Date_PickerHeader1="//button[@class='btn btn-default btn-sm']/strong";
			 
			 
			 @FindBy(xpath="(//*[@class='create-issue-form']//h4)[2]")
			 public WebElement checkDefectCreation;
			 
			 ///////////////////////////////22/05/18//////////////////////////
			 @FindBy(xpath="//span[text()='Edit']")
			 public WebElement defectEditButton;
			 
			 @FindBy(xpath="(//*[@type='button' and text()='Update'])[2]")
			 public WebElement updateEditDefect;
			 
@FindBy(xpath="//*[text()='ZE_SingleSelectListCascading']/../../../..//span[@id='parent-customfield_11395']")
public WebElement customZE_SingleSelectListCascading1;

@FindBy(xpath="//*[text()='ZE_SingleSelectListCascading']/../../../..//span[@id='child-customfield_11395']")
public WebElement customZE_SingleSelectListCascading2;

@FindBy(xpath="//*[text()='ZE_MultiSelectListCascading']/../../../..//span[@id='parent-customfield_11393']")
public WebElement customZE_MultiSelectListCascading1;

@FindBy(xpath="//*[text()='ZE_MultiSelectListCascading']/../../../..//span[@id='child-customfield_11393']")
public WebElement customZE_MultiSelectListCascading2;

@FindBy(xpath="//button[text()='Export']")
public WebElement defectExport ;
			 
@FindBy(xpath="//button[text()='Download']")
public WebElement downloadExport ;
			
@FindBy(xpath="(//*[@class='create-issue-form']//*[text()='Cancel'])[2]")
public WebElement updateCancelButton;
			 
@FindBy(xpath="//b[text()='Parent Issue']/../../../../div/span/label[@class='bold']")
public WebElement validateSubtaskParentId;

////////////////////25/05/18//////////////////////by srikanth
@FindBy(xpath="//*[text()='Assignee']/../../../..//span[@class='select2-selection__clear']")//updated
public WebElement clearAssigneeField;

@FindBy(xpath="//*[text()='ZE_Single_Select_Field']/../../../..//span[@class='select2-selection__clear']")//updated
public WebElement clearCustomZE_Single_Select_Field;

@FindBy(xpath="//*[text()='ZE_Version_Field']/../../../..//span[@class='select2-selection__clear']")//updated///////
public WebElement clearCustomZE_Version_Field;

@FindBy(xpath="//*[text()='ZE_User_Picker']/../../../..//span[@class='select2-selection__clear']")//updated///////
public WebElement clearCustomZE_User_Picker_Field;

@FindBy(xpath="//*[text()='ZE_Multi_User_Picker']/../../../..//span[@class='select2-selection__clear']")//updated///////
public WebElement clearCustomZE_Multi_User_PickerField;

@FindBy(xpath="(//button[@type='button' and text()='Cancel'])[9]")
public WebElement cancelUpdateDefect;

@FindBy(xpath="//a[text()='Basic']")
public WebElement basicButton;

@FindBy(xpath="//*[@id='select2-defectFiltersDropdown-container']")
public WebElement searchMyFilterID;

@FindBy(xpath="//*[@id='searchDefectsJQL']")
public WebElement searchJqlID;

@FindBy(xpath="//*[@id='defectId']")
public WebElement searchDefectID;

@FindBy(xpath="(//button[text()='Cancel'])[17]")
public WebElement jiraCancelButton;

@FindBy(xpath="(//*[@class='create-issue-form']/div/div/div/div/div/h4)[2]")
public WebElement defect_ID;

@FindBy(xpath="//span[text()='Edit']")
public WebElement Edit;

@FindBy(xpath="//*[@class='toast-title']")
public WebElement notificationMsg;


@FindBy(xpath="//*[@class='toast-close-button']")
public WebElement updateClose;

@FindBy(xpath="(//*[@class='modal-header-buttons-container']//button[@class='close'])[8]")
public WebElement defect_Updateclose;

@FindBy(xpath="(//*[@type='button' and text()='Update'])[2]")
public WebElement updatesubtask_Defect;


//@FindBy(xpath="//defect-tracking-search//h5")//previous 31/05/18
//public WebElement verifyDefectTrackingPage;

@FindBy(xpath="//h5[text()='Defects Linked to Execution']")//updated 01/06/18 by srikanth
public WebElement verifyDefectTrackingPage;

@FindBy(xpath="//span[@class='search-link-title']/a")
public WebElement searchLinkTitle;

@FindBy(xpath="//span[@id='select2-searchChoice-container']")
public WebElement filterTitle;

@FindBy(xpath="//span[@id='select2-defectFiltersDropdown-container']")
public WebElement filterName;

@FindBy(xpath="(//button[text()='Search'])[2]")
public WebElement defectSearchButton;

@FindBy(xpath="//a[text()='Advanced']")
public WebElement Advance;

@FindBy(xpath="//*[@id=\"grid-table-DEFECT_DETAILS\"]/div[2]/div/div[2]/div/div/span/a")
public WebElement clickOnDefectId;

@FindBy(xpath="//*[@class='toast-message']")
public WebElement issueNotificationMsg;

@FindBy(xpath="//*[@class='toast-close-button']")
public WebElement closePopUpMsg;

@FindBy(xpath="//p[text()='Do you wish to continue?']")
public WebElement exportMsg;

@FindAll({@FindBy(xpath="//*[@class='grid-content']//div[8]//a")})
public List<WebElement> testCaseNo;

@FindBy(xpath="//*[text()='Test Case ID']/../following-sibling::span/a")
public WebElement validateTestcaseNo;

@FindBy(xpath="//span[text()='Defects Filed']/preceding-sibling::span")
public WebElement dTcount;

@FindBy(xpath="//span[text()='Defects Linked to Execution']/preceding-sibling::span")
public WebElement dTcount1;

@FindBy(xpath="//*[@id='type-val']//*[@class='grid_link_select_click popover-indication defect-detail-popover']")
public WebElement detailDefectID;

protected String attachFile1="(//span[@title='";
protected String attachFile2="'])[1]/../..";

@FindBy(xpath="//*[@id=\"attachments-preview-modal\"]/div/div/div[1]/div[2]/zui-modal-header-buttons/div/a/span")
public WebElement clickOnDownload;

public String browse="//span[contains(.,'Browse')]";

@FindBy(xpath="//*[@id=\"attachments-preview-modal\"]/div/div/div[1]/div[2]/button")
public WebElement closeDownload;

@FindBy(xpath="(//div[@class='modal-header modal-draggable-handle']//*[@class='close'])[10]")
public WebElement closeUpdateDownload;

@FindAll({@FindBy(xpath="//*[@class='grid-content']//div[7]//span")})
public List<WebElement> testCaseCycle;

@FindBy(xpath="(//button[text()='×'])[6]")
public WebElement cancelChangeMultipleWindow;

///added by srikanth//////on 13/06/18
@FindBy(xpath="//*[@class='toast-close-button']")
public WebElement closeNotificationMsg;

@FindBy(xpath="//span[@placeholder='Enter Comment']")
public WebElement comment_Value;


@FindBy(xpath="(//*[@class='create-defect-action-buttons']//*[contains(.,'Cancel')])[2]")
public WebElement cancelFileNewDefectWindow;


protected String attribute1="(//span[text()='";
protected String attribute2="'])[1]";

@FindAll({@FindBy(xpath="//*[text()='ZE_Multiple_Select_Field']/../../../..//span[@class='select2-selection__choice__remove']")})
public List<WebElement> clearZE_Multiple_Select_Field;

//@FindBy(xpath="(//*[@class='create-issue-form']//*[text()='Cancel'])")
//public WebElement newDefectCancelButton;		 

@FindBy(xpath="(//*[@class='create-defect-action-buttons']//*[text()='Cancel'])")
public WebElement newDefectCancelButton;	

//select/unselect checkbox
public String checkBox1="//b[text()='";
public String checkBox2="']/../../input";

@FindBy(xpath="//*[text()='ZE_Number_Field']/../../../..//div/span/input")
public WebElement customZE_Number_Field;

@FindAll({@FindBy(xpath="//ul[@class='select2-results__options']/li")})
public List<WebElement> allOptions;



@FindAll({@FindBy(xpath="//*[@class='jiraformbody']//b")})
public List<WebElement> allvalues;


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

@FindBy(xpath="(//*[text()='Update'])[2]")//updated //[3]prev
public WebElement dtsUpdateButton;


@FindBy(xpath="//*[@id='defect-update-user-modal']/div/div/div[1]/div[1]/h4")
public WebElement dtsPoup;

	
	public boolean selectAllDefects() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		//bp.explicitWait(selectDefects);
		bp.moveToElementAndClick(selectDefects);
//		bp.explicitWait(selectDefects);
//		selectDefects.click();
		System.out.println("Successfully select the all defects");
		bp.waitForElement();
		return true;	
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public boolean updateDefectDetailsInSearchViewComment(String comment) throws Exception
	{
		try
		{
		 bp=new BasePage();	
		 Actions act=new Actions(driver);
		 WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
		 for(int i=1;i<=7;i++)
		  {
				act.sendKeys(Keys.DOWN).perform();
		  }
				if(comment!="")
				  {
					  wait.until(ExpectedConditions.elementToBeClickable(enterDefectComment));
					  enterDefectComment.click();
					  act.pause(1800).sendKeys(comment).sendKeys(Keys.ENTER).build().perform();
				  }
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
 
	public boolean verifyProjects1() throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   bp.waitForElement(); 
	   bp.explicitWait(selectDefectProject);
	   selectDefectProject.click();
	   bp.waitForElement(); 
	   String projects=validateProjects.getText();
	   System.out.println(projects);
	   bp.waitForElement();
	   selectDefectProject.click();
	   bp.waitForElement();
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	


	public boolean selectSingleOrMultipleDefects(int[] defectNo) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		
		for(int i=0;i<=defectNo.length-1;i++)
		{
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(defectSel1+defectNo[i]+defectSel2));
		Actions a1=new Actions(driver);
		
		a1.moveToElement(ele).click().perform();

		bp.waitForElement();
		}
		log.info(defectNo.length+" Test Case Selected");
		return true;	
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public boolean defectsOperation(String defectValue) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(defectValue1+defectValue+defectValue2));
		bp.explicitWait(ele);
		ele.click();
		bp.waitForElement();
		System.out.println("Pass -  Defect Value'" + defectValue + "' is selected Successfully");
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
		return true;	
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}





	public boolean changeMultipleDefect(String[] componentValue,String[] versionValue,String[] fixversionvalue,String status,String resolution,String priority,String assignee) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		Actions act=new Actions(driver);
		  WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
		//WebElement ele=driver.findElement(By.xpath(multipleDefectValue1+))
		bp.waitForElement();
		act.moveToElement(enterComponents).click().perform();
		
		for(int i=0;i<=componentValue.length-1;i++)
		{
			    bp.waitForElement();
			    act.sendKeys(componentValue[i]).pause(3000).build().perform();
			    act.sendKeys(Keys.ENTER).build().perform();
				
		}
		bp.waitForElement();
		act.pause(1200).sendKeys(Keys.ENTER).build().perform();
		
		bp.waitForElement();
		act.moveToElement(enterVersions).click().perform();
		
		for(int i=0;i<=versionValue.length-1;i++)
		{
			    bp.waitForElement();
			    act.sendKeys(versionValue[i]).pause(3000).build().perform();
			    act.sendKeys(Keys.ENTER).build().perform();
				
		}
		bp.waitForElement();
		act.pause(1200).sendKeys(Keys.ENTER).build().perform();
		
		bp.waitForElement();
		act.moveToElement(enterFixVersions).click().perform();
		
		for(int i=0;i<=fixversionvalue.length-1;i++)
		{
			    bp.waitForElement();
			    act.sendKeys(fixversionvalue[i]).pause(3000).build().perform();
			    act.sendKeys(Keys.ENTER).build().perform();
				
		}
		bp.waitForElement();
		act.pause(1200).sendKeys(Keys.ENTER).build().perform();
		  if(status!="")
		  {
		 
		  wait.until(ExpectedConditions.elementToBeClickable(enterStatus));
		  enterStatus.click();
		 
		  act.sendKeys(status).sendKeys(Keys.ENTER).build().perform();
		  }
		  bp.waitForElement();
		  if(resolution!="")
		  {
		  wait.until(ExpectedConditions.elementToBeClickable(enterResolution));
		  enterResolution.click();
		  act.sendKeys(resolution).sendKeys(Keys.ENTER).build().perform();
		  }
		  bp.waitForElement();
		  if(priority!="")
		  {
		  wait.until(ExpectedConditions.elementToBeClickable(enterPriority));	  
		  enterPriority.click();
		  act.sendKeys(priority).sendKeys(Keys.ENTER).build().perform();
		  }
		  bp.waitForElement();
		  if(assignee!="")
		  {
		  wait.until(ExpectedConditions.elementToBeClickable(enterAssignee));	  
		  enterAssignee.click();
		  act.sendKeys(assignee).perform();
		  bp.waitForElement();
		  bp.waitForElement();
		  WebElement ele=driver.findElement(By.xpath("//*[@class='select2-results']//li"));
		  bp.waitForElement();
		  ele.click();
		  }
		bp.waitForElement();
		//wait.until(ExpectedConditions.elementToBeClickable(defectSave));
		defectSave.click();
		System.out.println("Pass-Save button is clicked Successfully");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//button[text()='Save'])[1]")));
		bp.waitForElement();
		System.out.println("Pass-Successfully Enters the Defect Details");
		return true;
		}
		catch (Exception e) {
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
		bp.waitForElement();
		bp.waitForElement();
		bp.explicitWait(selectDefectProject);
		//selectProject.click();
		Actions a1=new Actions(driver);
		a1.moveToElement(selectDefectProject).click().pause(1200).sendKeys(project).perform();
		bp.waitForElement();
		driver.findElement(By.xpath(categories1+project+categories2)).click();
		bp.waitForElement();
		bp.waitForElement();
		a1.moveToElement(issueType).click().pause(1200).sendKeys(issuetype).sendKeys(Keys.ENTER).perform();
		bp.waitForElement();
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





	public boolean createDefectSubtask(String issuetype) throws Exception
	{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		bp.waitForElement();
		Actions a1=new Actions(driver);
		bp.waitForElement();
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
	
	public boolean defectAdvancedSearch(String selectSearch,String value) throws Exception
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
			searchDefectID.sendKeys(value);
			bp.waitForElement();
			
			//defectSearchButton.click();
			//System.out.println("Defect search button clicked successfully");
			bp.waitForElement();
		}
		
		else if(selectSearch.equals("JQL"))
		{
			searchJqlID.sendKeys(value);
			bp.waitForElement();
			//defectSearchButton.click();
			//System.out.println("Defect search button clicked successfully");
			bp.waitForElement();
		}
		else if(selectSearch.equals("My Filters"))
		{
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.explicitWait(searchMyFilterID);
			bp.waitForElement();
			searchMyFilterID.click();
			bp.waitForElement();
			Actions act=new Actions(driver);
			act.sendKeys(value).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
		}
		Search.click();
		System.out.println("Defect search button clicked successfully");
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

	
	public boolean defectSort(String[] name) throws Exception
	{
		try 
		{
			bp=new BasePage();
			sortOption.click();
			
			for(int i=0;i<=name.length-1;i++)
			{
			    WebElement v2=driver.findElement(By.xpath(selectSort1+name[i]+selectSort2));
			    boolean vele=v2.isSelected();
			    System.out.println(vele);
			    bp.waitForElement();
			
			if( vele==false )
			{
				v2.click();
				System.out.println("sucessfully clicked on " +name[i] );
			}	
			}
		   
			Actions a1=new Actions(driver);
			a1.moveToElement(defectID).click().perform();
			bp.waitForElement();
		   
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}	
	}
	
	
	public boolean validateDefectSort(String[] name) throws Exception
	{
		try
		{
			bp =new BasePage();
			for(int j=0;j<=name.length-1;j++)
			{
				WebElement val=driver.findElement(By.xpath(valSort1+name[j]+valSort2));
				String data= val.getText();
				bp.waitForElement();
				
				if(data.equals(name[j]))
				{
					System.out.println("Valiated Sucessfully" +name[j]);
				}
				else
				{
					System.out.println("Not Valiated Sucessdully" +name[j]);
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


	
	
	
	
	//Commment
	public boolean validateDefect(String defectname) throws Exception{
		 try
		 {
		 bp=new BasePage();
		 bp.waitForElement();
		 WebElement ele=driver.findElement(By.xpath(dvalue1+defectname+dvalue2));
		 String text=ele.getText();
		 if(text.equals(defectname))
		 {
		 System.out.println("Pass-DefectName successfully validated");
		 }
		 else
		 {
		 System.out.println("Pass-DefectName not validated");
		 }
		 return true;	
		 }
		 catch(Exception e)
		 {
		 e.printStackTrace();
		 throw e;
		 }
		}


		
		//Paste in external Jira()
//		public boolean addCustomField() throws Exception{
//			try
//			{
//			bp=new BasePage();
//			customfield.click();
//			System.out.println("Pass - Successfully clicked on Customfield option");
//			bp.waitForElement();
//			addcustomfield.click();
//			System.out.println("Pass - Successfully clicked on AddCustomField option");
//			return true;
//			}
//			catch(Exception e)
//			{
//			e.printStackTrace();
//			throw e;
//			}
//			
//		}
//		

		
		
		//Paste In External Jira Page
		
		
		public boolean searchDefect(String defectID) throws Exception
		{
			try
			{
				bp=new BasePage();
				bp.waitForElement();
//				JavascriptExecutor js=((JavascriptExecutor)driver);
//				js.executeScript("arguments[0].scrollIntoView(true);",searchDefectField);
				bp.explicitWait(searchDefectField);
				searchDefectField.clear();
				searchDefectField.sendKeys(defectID);
				System.out.println("Pass - defectID'"+ defectID +"' is entered Successfully");
				searchDefect.click();
				System.out.println("Pass-Successfully clicked on defect search button");
				bp.waitForElement();
				return true;
			}
			catch(Exception e)
		    {
		     e.printStackTrace();
		     throw e;
		    } 
		}
		public boolean clickOnCreateSubTask() throws Exception
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
				throw e;
				
			}
			
		}
		
		public boolean defectSearch(String project,String issueType,String status,String filedBy,String version,String priority,String assignee) throws Exception
		{
			try
			{
				bp=new BasePage();
				TestRepositoryPage tr=new TestRepositoryPage(driver);
				 Actions act=new Actions(driver);
				  WebDriverWait wait=new WebDriverWait(driver,20);
				  if(project!="")
				  {
				  bp.waitForElement();
				  wait.until(ExpectedConditions.elementToBeClickable(selectProject));
				  selectProject.click();
				 
				  act.sendKeys(project).sendKeys(Keys.ENTER).build().perform();
				  }
				  bp.waitForElement();
				  bp.waitForElement();
				  if(issueType!="")
				  {
				  wait.until(ExpectedConditions.elementToBeClickable(selectIssueType));
				  selectIssueType.click();
				  act.sendKeys(issueType).sendKeys(Keys.ENTER).build().perform();
				  }
				  bp.waitForElement();
				  if(status!="")
				  {
				  wait.until(ExpectedConditions.elementToBeClickable(selectStatus));	  
				  selectStatus.click();
				  act.sendKeys(status).sendKeys(Keys.ENTER).build().perform();
				  //wait.until(ExpectedConditions.elementToBeClickable(save));
				  }
				  if(filedBy!="")
				  {
				  wait.until(ExpectedConditions.elementToBeClickable(selectFiledBy));
				  selectFiledBy.click();
				  //act.sendKeys(filedBy).sendKeys(Keys.ENTER).pause(1800).sendKeys(Keys.ENTER).build().perform();
				  act.sendKeys(filedBy).perform();
				  bp.waitForElement();
				  bp.waitForElement();
				  WebElement ele=driver.findElement(By.xpath("//*[@class='select2-results']//li"));
				  bp.waitForElement();
				  ele.click();
				  }
				  bp.waitForElement();
				  if(version!="")
				  {
				  wait.until(ExpectedConditions.elementToBeClickable(selectVersion));	  
				  selectVersion.click();
				  act.sendKeys(version).sendKeys(Keys.ENTER).build().perform();
				  }
				  if(priority!="")
				  {
				  wait.until(ExpectedConditions.elementToBeClickable(selectPriority));
				  selectPriority.click();
				  act.sendKeys(priority).sendKeys(Keys.ENTER).build().perform();
				  }
				  bp.waitForElement();
				  if(assignee!="")
				  {
				  wait.until(ExpectedConditions.elementToBeClickable(selectAssignee));	  
				  selectAssignee.click();//
				 // act.sendKeys(assignee).sendKeys(Keys.ENTER).pause(1800).sendKeys(Keys.ENTER).build().perform();
				  act.sendKeys(assignee).perform();//
//				  bp.waitForElement();
				  bp.waitForElement();
				  bp.waitForElement();
				  WebElement ele=driver.findElement(By.xpath("//*[@class='select2-results']//li"));
				  
//				  WebElement ele=driver.findElement(By.id("defect-assignee"));
				  
				  
//				  Select sel=new Select(ele);
//				  sel.selectByValue(assignee);
				  bp.waitForElement();
				  ele.click();
				  //wait.until(ExpectedConditions.elementToBeClickable(save));
				  }
				  bp.waitForElement();
				  bp.waitForElement();
			      defectSearch.click();
			      System.out.println("Pass-Search button is clicked successfully");
			      bp.waitForElement();
			      
			      tr=new TestRepositoryPage(driver);
			      WebDriverWait wait1=new WebDriverWait(driver, 300);
			      
			      wait1.until(ExpectedConditions.visibilityOf(tr.tcCount));
			      return true;	
			}
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		

		//comment
//		public boolean validateSearchedDefect(String defectname) throws Exception{
//			 try
//			 {
//				 
//			 bp=new BasePage();
//			 String lastResult=searchCount.getText();
//			 int page=(Integer.parseInt(lastResult))/50;
//			 
//			 
//			 for(int i=1;i<=page;i++)
//			 {
//				 
//				for(int j=0;j<=(Integer.parseInt(lastResult));j++)
//						
//				{
//			 WebElement ele=driver.findElement(By.xpath(dvalue1+defectname+dvalue2));
//			 String text=ele.getText();
//			 if(text.equals(defectname))
//			 {
//			 System.out.println("Pass-DefectName successfully validated");
//			 }
//			 
//				
//				}
//				
//				
//				nextButton.click();
//			// driver.findElement(By.xpath("//li[@class='next-page']//span")).click();
//			 }
//			 
//			 return true;	
//			 }
//			 catch(Exception e)
//			 {
//			 e.printStackTrace();
//			 throw e;
//			 }
//			}
//		
//		
		
		public boolean clickOnBasicSearch() throws Exception
		{
			try 
		{
		bp=new BasePage();
		bp.waitForElement();
		boolean res=basicButton.isDisplayed();
		if(res==true)
		{
		//bp.explicitWait(Advance);
		basicButton.click();
		bp.waitForElement();
		System.out.println("Sucessfully clicked on Advanced Button");
		bp.waitForElement();
		}
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

		
		public boolean advancedSearch(String selectSearch, String name) throws Exception
		{
			try 
			{
			bp=new BasePage();
			bp.waitForElement();
			boolean res=advance.isDisplayed();
			if(res==true)
			{
			advance.click();
			bp.waitForElement();
			System.out.println("Sucessfully clicked on Advanced Button");
			bp.waitForElement();
			}
			bp.waitForElement();
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
			if(selectSearch.equals("JQL"))
			{
				searchJqlID.click();
				searchJqlID.clear();
				searchJqlID.sendKeys(name);
				bp.waitForElement();
			}
			else if(selectSearch.equals("My Filters"))
			{
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				bp.waitForElement();
				Actions a=new Actions(driver);
				a.moveToElement(searchMyFilterID).click().sendKeys(name).sendKeys(Keys.ENTER).build().perform();
			    bp.waitForElement();
			}
			 
			
			 Search.click();
			 bp.waitForElement();
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
		
		public boolean validateComment(String commentValue) throws Exception
		   {
		    try
		    {
		    	bp=new BasePage();
		    	bp.waitForElement();
		    
		     String verify=comment_Value.getText();
		     
		     if(verify.equals(commentValue))
		     {
		      System.out.println("Comment value verified successfully");
		     }
		    
		    return true;
		      }
		   catch(Exception e)
		   {
		    e.printStackTrace();
		    throw e;
		   }
		   }
		public boolean viewDefectIssueMsgForNoRecords(String filterValue) throws Exception
		  {
		   try
		   {
		   bp=new BasePage(); 
		   bp.explicitWait(issueNotificationMsg); 
		   Actions act=new Actions(driver);
		   act.moveToElement(issueNotificationMsg).perform();
		   String text=issueNotificationMsg.getText();
		
		   if((text).equals(filterValue))
		   {
		    
		    System.out.println(" Pop up message" +filterValue +"is validated successfully");
		   }
		   
		   
		   bp.waitForElement();
		   closePopUpMsg.click();
		  
		    return true; 
		   }
		    catch(Exception e)
		    {
		    e.printStackTrace();
		    throw e;
		    }
		  }

 public boolean validateAdvancedSearch(String defectValue) throws Exception
 {
	 try
	 {
		bp=new BasePage();
		WebElement ele=driver.findElement(By.xpath(dvalue1+defectValue+dvalue2));
		String text=ele.getText();
		System.out.println(text);
		bp.waitForElement();
		if(text.equals(defectValue))
		{
			System.out.println("Pass-defectValue-'"+defectValue+"' is validated successfully");
		}
		else
		{
			System.out.println("Pass-defectValue-'"+defectValue+"' is not validated successfully");	
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
 
 
 public boolean updateDefectDetailsInSearchView(String summary,String component,String priority,String version,String fixversion,String comment,String assignedTo,String environment,String status,String resolution) throws Exception
	{
		try
		{
		 bp=new BasePage();	
		 Actions act=new Actions(driver);
		 WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
		 for(int i=1;i<=7;i++)
		  {
				act.sendKeys(Keys.DOWN).perform();
		  }
		 if(summary!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectSummary));
			  bp.eraseText(enterDefectSummary);
			  bp.waitForElement();
			  //enterDefectSummary.clear();
			  act.pause(1800).sendKeys(summary).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(component!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectComponent));
			  enterDefectComponent.click();
			  act.pause(1800).sendKeys(component).sendKeys(Keys.ENTER).build().perform();
			  saveIcon.click();
			  bp.waitForElement();
			}
		 bp.waitForElement();
		 if(priority!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectPriority));
			  enterDefectPriority.click();
			  act.pause(1800).sendKeys(priority).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(comment!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectComment));
			  enterDefectComment.click();
			  act.pause(1800).sendKeys(comment).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).build().perform();
			}
		 bp.waitForElement();
		 if(version!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectVersion));
			  enterDefectVersion.click();
			  act.pause(1800).sendKeys(version).sendKeys(Keys.ENTER).build().perform();
			  saveIcon.click();
			  bp.waitForElement();
			}
		 bp.waitForElement();
		 if(fixversion!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectFixVersions));
			  enterDefectFixVersions.click();
			  act.pause(1800).sendKeys(fixversion).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).build().perform();
			  saveIcon.click();
			  bp.waitForElement();
			}
		 bp.waitForElement();
		 if(assignedTo!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectAssignee));
			  enterDefectAssignee.click();
			  //act.sendKeys(assignedTo).sendKeys(Keys.ENTER).build().perform();
			  act.sendKeys(assignedTo).perform();
			  bp.waitForElement();
			  bp.waitForElement();
			  WebElement ele1=driver.findElement(By.xpath("//*[@class='select2-results']//li"));
			  bp.waitForElement();
			  ele1.click();
			}
		 bp.waitForElement();
		 if(environment!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(enterDefectEnvironment));
			  //enterDefectEnvironment.click();
			  bp.eraseText(enterDefectEnvironment);
			  act.pause(1800).sendKeys(environment).sendKeys(Keys.ENTER).build().perform();
			  saveIcon.click();
			  bp.waitForElement();
			}
		 bp.waitForElement();

		// bp.explicitWait(popupMessage);
//		 WebDriverWait wait1=new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
//		 wait1.until(ExpectedConditions.visibilityOf(popupMessage));
		 
		 WebElement Id=driver.findElement(By.xpath("//div[@title='ID']"));
		 act.moveToElement(Id).clickAndHold();
		 bp.waitForElement();

		 return true;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
 
 
 public boolean updateDefectStatusAndResolution(String status,String resolution) throws Exception
 {
	 try
	 {
		bp=new BasePage();
		WebDriverWait wait=new WebDriverWait(driver,60);
		Actions act=new Actions(driver);
		bp.waitForElement();
		wait.until(ExpectedConditions.elementToBeClickable(defectUpdate));
		 defectUpdate.click();
		 bp.waitForElement();
		 if(status!="")
		 {
			 wait.until(ExpectedConditions.elementToBeClickable(enterDefectStatus));
			 enterDefectStatus.click();
			 act.sendKeys(status).sendKeys(Keys.ENTER).build().perform();
		 }
		 bp.waitForElement();
		 if(resolution!="")
		 {
			 wait.until(ExpectedConditions.elementToBeClickable(enterDefectResolution));
			 enterDefectResolution.click();
			 act.sendKeys(resolution).sendKeys(Keys.ENTER).build().perform();
		 }
		 bp.waitForElement();
		 wait.until(ExpectedConditions.elementToBeClickable(defectStatusUpdate));
		 defectStatusUpdate.click();
		 bp.waitForElement();
		 bp.waitForElement();
		 bp.waitForElement();
		 bp.waitForElement();
		 bp.waitForElement();
		 bp.waitForElement();
		 bp.waitForElement();
		 bp.waitForElement();
		 bp.waitForElement();
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
 
	
	public boolean validateDefectSummary(String summary) throws Exception
	{
		try
		{
			bp=new BasePage();
			String Summary=enterDefectSummary.getText();
			if(Summary.equals(summary))
			{
				System.out.println("Pass-defectSummary '"+summary+"' is validated successfully");
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
 
	public boolean validateDefectComponent(String component) throws Exception
	{
		try
		{
			bp=new BasePage();
			String Component=enterDefectComment.getText();
			if(Component.equals(component))
			{
				System.out.println("Pass-defectComponent '"+component+"' is validated successfully");
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
	
	public boolean validateDefectVersions(String versions) throws Exception
	{
		try
		{
			bp=new BasePage();
			String Versions=enterDefectVersion.getText();
			if(Versions.equals(versions))
			{
				System.out.println("Pass-defectVersions '"+versions+"' is validated successfully");
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
	
	public boolean validateDefectPriority(String priority) throws Exception
	{
		try
		{
			bp=new BasePage();
			String Priority=enterDefectPriority.getText();
			if(Priority.equals(priority))
			{
				System.out.println("Pass-defectPriority '"+priority+"' is validated successfully");
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
	
	public boolean validateDefectFixVersion(String fixVersion) throws Exception
	{
		try
		{
			bp=new BasePage();
			String FixVersion=enterDefectFixVersions.getText();
			if(FixVersion.equals(fixVersion))
			{
				System.out.println("Pass-defectFixVersion '"+fixVersion+"' is validated successfully");
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
	
	public boolean validateDefectEnvironment(String environment) throws Exception
	{
		try
		{
			bp=new BasePage();
			String Environment=enterDefectEnvironment.getText();
			if(Environment.equals(environment))
			{
				System.out.println("Pass-defectEnvironment '"+environment+"' is validated successfully");
			}
			bp.waitForElement();
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
	
	
	public boolean validateDefectAssignee(String aasignedTo) throws Exception
	{
		try
		{
			bp=new BasePage();
			String Assignee=enterDefectAssignee.getText();
			if(Assignee.equals(aasignedTo))
			{
				System.out.println("Pass-defectAssignee '"+aasignedTo+"' is validated successfully");
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
	
	public boolean validateDefectStatus(String status) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			String Status=defectStatus.getText();
			if(Status.equals(status))
			{
				System.out.println("Pass-defectStatus '"+status+"' is validated successfully");
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
	
	public boolean validateDefectResolution(String resolution) throws Exception
	{
		try
		{
			bp=new BasePage();
			String Resolution=defectResolution.getText();
			if(Resolution.equals(resolution))
			{
				System.out.println("Pass-defectResolution '"+resolution+"' is validated successfully");
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
	
	public boolean enterDefectCustomFields(String zeFreeTextField,String zeRadioField,String zeCheckboxField,String ze_Url_Field,String[] ze_Multiple_Select_Field,String ze_Single_Select_Field,String[] ze_Multi_Version_field,String ze_Version_Field,String ze_User_Picker,String ze_Label_Field,String[] ze_Multi_User_Picker,String ze_Text_Field) throws Exception
	{
		try
		{
		bp=new BasePage();
		Actions a1=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,60);
		if(zeFreeTextField!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_FreeText_Field));
			  bp.eraseText(customZE_FreeText_Field);
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(zeFreeTextField).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(zeRadioField!="")
		  {
			  
			  WebElement ele=driver.findElement(By.xpath(customZE_Radio_Field1+zeRadioField+customZE_Radio_Field2));
			  wait.until(ExpectedConditions.elementToBeClickable(ele));
			  ele.click();
			  bp.waitForElement();
			}
		 bp.waitForElement();
		 if(zeCheckboxField!="")
		  {
			  WebElement ele=driver.findElement(By.xpath(customZE_Checkbox_Field1+zeCheckboxField+customZE_Checkbox_Field2));
			  wait.until(ExpectedConditions.elementToBeClickable(ele));
			  ele.click();
			  bp.waitForElement();
			}
		 bp.waitForElement();
		 if(ze_Url_Field!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_Url_Field));
			  customZE_Url_Field.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_Url_Field).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_Multiple_Select_Field[0]!="")
		  {
			  customZE_Multiple_Select_Field.click();
			  bp.waitForElement();
			  for(int i=0;i<=ze_Multiple_Select_Field.length-1;i++)
			  {
			    a1.pause(1800).sendKeys(ze_Multiple_Select_Field[i]).pause(3000).build().perform();
			    a1.sendKeys(Keys.ENTER).build().perform();
			    
			  }
			 
			  //a1.sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_Single_Select_Field!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_Single_Select_Field));
			  customZE_Single_Select_Field.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_Single_Select_Field).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_Multi_Version_field[0]!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_Mult_Version_field));
			  customZE_Mult_Version_field.click();
			  bp.waitForElement();
			  for(int i=0;i<=ze_Multi_Version_field.length-1;i++)
			  {
			    a1.pause(1800).sendKeys(ze_Multi_Version_field[i]).pause(3000).build().perform();
			    a1.sendKeys(Keys.ENTER).build().perform();
			    
			  }
			 
			  //a1.sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_Version_Field!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_Version_Field));
			  customZE_Version_Field.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_Version_Field).pause(1800).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_User_Picker!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_User_Picker));
			  customZE_User_Picker.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_User_Picker).pause(3000).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_Label_Field!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_Label_Field));
			  customZE_Label_Field.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_Label_Field).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_Multi_User_Picker[0]!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_Multi_User_Picker));
			  customZE_Multi_User_Picker.click();
			  bp.waitForElement();
			  for(int i=0;i<=ze_Multi_User_Picker.length-1;i++)
			  {
			    a1.pause(1800).sendKeys(ze_Multi_User_Picker[i]).pause(3000).build().perform();
			    a1.sendKeys(Keys.ENTER).build().perform();
			    
			  }
			 
			  //a1.sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_Text_Field!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_Text_Field));
			  bp.eraseText(customZE_Text_Field);
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_Text_Field).sendKeys(Keys.ENTER).build().perform();
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
	
	
//	public boolean customDatePicker(String syear,String smonth,String sday) throws Exception
//	 {
//		try
//		{
//	  bp=new BasePage();
//	  bp.waitForElement();
//	  WebElement ele=driver.findElement(By.xpath(customZE_Date_PickerHeader));
//	  Actions a2=new Actions(driver);
//	  a2.moveToElement(ele).doubleClick().perform();
//	  driver.findElement(By.xpath(customZE_Date_PickerHeader)).click();
//	  bp.waitForElement();
//	  String []  startDate =new String[1];
//	  String startYear=minYear.getText();
//	  int Syear=Integer.parseInt(startYear);
//	  int [] start=new int[1];
//	  startDate[0]=syear;
//	  start[0]=Integer.parseInt(startDate[0]);
//		
//		if(start[0] < Syear)
//		{
//			left.click();
//			bp.waitForElement();
//			
//		}
//	  
//	  driver.findElement(By.xpath(ze_Date_PickerYear1+syear+ze_Date_PickerYear2)).click();
//	  bp.waitForElement();
//	  bp.waitForElement();
//	  driver.findElement(By.xpath(ze_Date_Pickermonth1+smonth+ze_Date_Pickermonth2)).click();
//	  bp.waitForElement();
//	  driver.findElement(By.xpath(ze_Date_Pickerday1+sday+ze_Date_Pickerday2)).click();
//	  bp.waitForElement();
//	  
//	  return true;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//		}
//	 }
		
	
	public boolean customDatePicker(String syear,String smonth,String sday) throws Exception
	 {
		try
		{
	  bp=new BasePage();
	  bp.waitForElement();
	  customZE_Date_PickerOption.click();
	  bp.waitForElement();
	  WebElement ele=driver.findElement(By.xpath(ze_Date_PickerHeader));
	  Actions a2=new Actions(driver);
	  a2.pause(1800).moveToElement(ele).click().perform();
	  bp.waitForElement();
	  driver.findElement(By.xpath(ze_Date_PickerHeader1)).click();
	  bp.waitForElement();
	  String []  startDate =new String[1];
	  String startYear=minYear.getText();
	  int Syear=Integer.parseInt(startYear);
	  int [] start=new int[1];
	  startDate[0]=syear;
	  start[0]=Integer.parseInt(startDate[0]);
		
		if(start[0] < Syear)
		{
			left.click();
			bp.waitForElement();
			
		}
	  
	  driver.findElement(By.xpath(ze_Date_PickerYear1+syear+ze_Date_PickerYear2)).click();
	  bp.waitForElement();
	  bp.waitForElement();
	  driver.findElement(By.xpath(ze_Date_Pickermonth1+smonth+ze_Date_Pickermonth2)).click();
	  bp.waitForElement();
	  driver.findElement(By.xpath(ze_Date_Pickerday1+sday+ze_Date_Pickerday2)).click();
	  bp.waitForElement();
	  
	  return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	 }
	
	public boolean fileNewDefect(String summary,String components,String descType,String desc,String fixVersion,String priority,String Assignee,String labels,String Sprint,String env,String EpicLink,String AffectsVersion,String linkedIssue) throws Exception
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
     if(descType!="")
	 {
     Select s1=new Select(defectDescriptionselection);
      s1.selectByVisibleText(descType);
	 }
     //Description
     if(desc!="" )
     {
    	 
    	 
     bp.waitForElement();
     
     enterDescription.sendKeys(desc);
     }
     bp.waitForElement();
    
     if(fixVersion!="")
     {
	 Actions a1=new Actions(driver); 	 
     //fixVersionField.click();
     bp.waitForElement();
     //driver.findElement(By.xpath(value1+fixVersion+value2)).click();
     a1.moveToElement(fixVersionField).click().sendKeys(fixVersion).pause(1800).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).perform();
     }

     bp.waitForElement();
          
     if(priority!="")
     {
     priorityField.click();
     bp.waitForElement();
     
     driver.findElement(By.xpath(value1+priority+value2)).click();
     }
     bp.waitForElement();
     if(Assignee!="")
     {
     Actions a1=new Actions(driver);
     a1.moveToElement(assignee).click().sendKeys(Assignee).pause(1200).sendKeys(Keys.ENTER).sendKeys(Keys.TAB).perform();
     }
     if(labels!="")
     {
     bp.waitForElement();
     labelField.sendKeys(labels);
     }
     bp.waitForElement();
     if(Sprint!="")
     {
     sprint.sendKeys(Sprint);
     bp.waitForElement();
     }
     if(env!="")
     {
     environment.sendKeys(env);
     bp.waitForElement();
     }
     if(EpicLink!="")
     {
     epicLink.sendKeys(EpicLink);
     bp.waitForElement();
     }
//     affectsVersion.sendKeys(AffectsVersion);
//     bp.waitForElement();
     if(AffectsVersion!="")
     {
     Actions a2=new Actions(driver);
     a2.moveToElement(affectsVersion).click().sendKeys(AffectsVersion).sendKeys(Keys.ENTER).build().perform();
     bp.waitForElement();
     }
//     linkedIssues.sendKeys(linkedIssue);
//     bp.waitForElement();
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

	public boolean saveDefect() throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			String createButtonStatus=createButtonSave.getAttribute("class");
			
			if(createButtonStatus.equalsIgnoreCase("zui-btn zui-btn-primary disabled"))
			{
			   	System.out.println("Create button is in disable mode,Not able to create efect");
			   	
			}
			
			else
			{
			createButtonSave.click();
			System.out.println("Pass-Defect is created and saved");
			bp.waitForElement();
			bp.waitForElement();
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
	
	
	public boolean updateDefect() throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
	   bp.waitForElement();
//	   WebElement updateButton= updateDefect.get(updateDefect.size()-1);
//	   bp.explicitWait(updateButton);
	   wait.until(ExpectedConditions.elementToBeClickable(updateDefect.get(updateDefect.size()-1)));
		//updateDefect.click();
		 updateDefect.get(updateDefect.size()-1).click();
	     System.out.println("Pass-Defect is updated successfully");
	     bp.waitForElement();
	  
	     return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   log.info("Defect button is not clicked");
	   throw e;
	   
	  }
	 }
	
	
	public boolean validateDefect(String project,String issuetype) throws Exception
	{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		String projectName=validateDefectProject.getText();
		String issueType=validateDefectIssueType.getText();
		if(projectName.equals(project) && issueType.equals(issuetype))
		{
			System.out.println("Pass-Defect is validated Successfully");
		}
		else
		{
			System.out.println("Fail-Defect is not validated");
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
	
	
	
//
//	public boolean validateSearchedDefect(String defectType,String defectValue) throws Exception{
//		  
//		try
//		{
//		 bp=new BasePage();
//		 String lastResult=searchCount.getText();
//		 int page=(Integer.parseInt(lastResult))/50;
//		 int no=0;
//		 //3-IssueType,4-summary,5-priority,6-Status,7-TestCycles,8-Testcases,9-components,10-version,11-fix version,12-Assignee,13-filed By
//		 String t1="//*[@id='grid-table-DEFECT_DETAILS']/div[";
//		 String t2="]/div[";
//		 String t3="]/div[3]/div/div";
//		 
//		 if(defectType.equals("IssueType"))
//		 {
//			 no=3;
//		 }
//		 else if(defectType.equals("Summary"))
//		 {
//			 no=4;
//		 }
//		 else if(defectType.equals("Priority"))
//		 {
//			 no=5;
//		 }
//		 else if(defectType.equals("Status"))
//		 {
//			 no=6;
//		 }
//		 else if(defectType.equals("Component"))
//		 {
//			 no=9;
//		 }
//		 else if(defectType.equals("Version"))
//		 {
//			 no=10;
//		 }
//		 else if(defectType.equals("Fix Version"))
//		 {
//			 no=11;
//		 }
//		 else if(defectType.equals("Assignee"))
//		 {
//			 no=12;
//		 }
//		 
//		 else if(defectType.equals("Filed By"))
//		 {
//			 no=13;
//		 }
//		 
//		 
//		 for(int i=0;i<=page;i++)
//		 {
//			 
//			for(int j=0;j<=(Integer.parseInt(lastResult));j++)
//					
//			{
//				 WebElement defect_Value=driver.findElement(By.xpath(t1+no+t2+i+t3));		
//				 String text=defect_Value.getText();
//			  if(!defectType.equals("Version")||!defectType.equals("Component"))
//				 {
//					
//		          if(text.equals(defectValue))
//		          {
//		          System.out.println("Pass-Defect Value successfully validated");
//		          }
//				 }
//		      else
//		      {    
//			    if(text.contains(defectValue))
//			   {
//			      System.out.println("Pass-Defect Value successfully validated");
//			     }
//			}
//			}
//			
//			nextButton.click();
//		
//		 }
//		 
//		 
//		return true;
//		 
//		}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//		throw e;
//	}
//}
	
//	public boolean closeDefectWinodow() throws Exception
//	{
//		try
//		{
//		bp=new BasePage();
//		bp.explicitWait(closeDefectWindow);
//		closeDefectWindow.click();
//		return true;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			throw e;
//		}
//	}
	
	
	
	
	public boolean validateDefectCreationMsg() throws UserDefinedException,Exception
	 {
	   try
	    {
	     bp=new BasePage();
	     bp.waitForElement();
	     //Actions a1=new Actions(driver);
	     
	     try
	     {
	    //WebElement checkDefectCreation= driver.findElement(By.xpath("(//*[@class='create-issue-form']//h4)[2]"));
	    bp.explicitWait(checkDefectCreation);
	     
	    String text=checkDefectCreation.getText();
	    
	   
	     if(text.contains("Update Defect"))
	     {
	    	 throw new UserDefinedException("Defect is able to create");
	     }
	     
	     }
	     catch(TimeoutException e)
	     {
	    	 
	    	 System.out.println("Defect is not able to create");
	     }
	     
	     
	     return true;
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
		 bp.explicitWait(searchCount);
		 String lastResult=searchCount.getText();
		 
		 int remainder=(Integer.parseInt(lastResult))%50;
		 System.out.println("Rem="+remainder);
		 int lastPage=0;
		 if(remainder>0)
		 {
		  lastPage=(Integer.parseInt(lastResult))/50+1;
		  
		  System.out.println("lastpage="+lastPage);
		 }
		 else
		 {
		 lastPage=(Integer.parseInt(lastResult))/50; 
		 System.out.println("else lastpage="+lastPage);
		 }
		 int no=0;
		 //3-IssueType,4-summary,5-priority,6-Status,7-TestCycles,8-Testcases,9-components,10-version,11-fix version,12-Assignee,13-filed By
//		 String t1="//*[@id='grid-table-DEFECT_DETAILS']/div[";
//		 String t2="]/div[";
//		 String t3="]/div[3]/div/div";
		 String t1="//*[@id='grid-table-DEFECT_DETAILS']/div[2]/div[";
		 String t2="]/div[";
		 String t3="]/div/div";
		 
		 if(defectType.equals("Issue Type"))
		 {
			 no=3;
		 }
		 else if(defectType.equals("Summary"))
		 {
			 no=4;
		 }
		 else if(defectType.equals("Priority"))
		 {
			 no=5;
		 }
		 else if(defectType.equals("Status"))
		 {
			 no=6;
		 }
		 else if(defectType.equals("Component"))
		 {
			 no=9;
		 }
		 else if(defectType.equals("Version"))
		 {
			 no=10;
		 }
		 else if(defectType.equals("Fix Version"))
		 {
			 no=11;
		 }
		 else if(defectType.equals("Assignee"))
		 {
			 no=12;
		 }
		 
		 else if(defectType.equals("Filed By"))
		 {
			 no=13;
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

	public boolean editCategories(String category,String name,String value,String active) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		driver.findElement(By.xpath(categories1+category+categories2)).click();
		System.out.println("Clicked on"+category+"Successfully");
		driver.findElement(By.xpath(name1+name+name2)).click();
		System.out.println("Pass-Clicked on"+name+"Successfully");
		if(value!="")
		{
		bp.explicitWait(enterPreferenceValue);
//		WebElement ele=driver.findElement(By.xpath("//*[@id='preference-value']"));
//		JavascriptExecutor js=((JavascriptExecutor)driver);
//		js.executeScript("arguments[0].scrollIntoView(true);",ele );
//		WebDriverWait wait=new WebDriverWait(driver,60);
//		wait.until(ExpectedConditions.visibilityOf(ele));
//		ele.click();
		enterPreferenceValue.click();
		System.out.println("Clicked on"+value+"Successfully");
		enterPreferenceValue.clear();
		enterPreferenceValue.sendKeys(value);
		System.out.println("Successfully-Passed"+value);
		}
		if(active!="")
		{
        bp.waitForElement();
		driver.findElement(By.xpath(active1+active+active2)).click();
		System.out.println("Selected"+active+"Successfylly");
		savePreference.click();
		System.out.println("Clicked On Save Button");
		bp.waitForElement();
		clickOnSavePreference.click();
		System.out.println("Successfully Saved Preference");
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	

	public boolean validateMultiEditDefect(String[] defectNo,String defectType,String defectValue) throws Exception, UserDefinedException
	{
		try
		{
			int no=0;
		int lastDefectNo=defectNo.length;
		 //3-IssueType,4-summary,5-priority,6-Status,7-TestCycles,8-Testcases,9-components,10-version,11-fix version,12-Assignee,13-filed By
		 String t1="//*[@id='grid-table-DEFECT_DETAILS']/div[";
		 String t2="]/div[";
		 String t3="]/div[3]/div/div";
		 
		  if(defectType.equals("Priority"))
		 {
			 no=5;
		 }
		 else if(defectType.equals("Status"))
		 {
			 no=6;
		 }
		 else if(defectType.equals("Component"))
		 {
			 no=9;
		 }
		 else if(defectType.equals("Version"))
		 {
			 no=10;
		 }
		 else if(defectType.equals("Fix Version"))
		 {
			 no=11;
		 }
		 else if(defectType.equals("Assignee"))
		 {
			 no=12;
		 }
		 
		  
		 for(int j=1;j<=lastDefectNo;j++)
				
			{
				 WebElement defect_Value=driver.findElement(By.xpath(t1+no+t2+j+t3));		
				 String text=defect_Value.getText();
			  if(!defectType.equals("Version")||!defectType.equals("Component")||!defectType.equals("Fix Version"))
				 {
					
		          if(text.equals(defectValue))
		          {
		          System.out.println("Pass-Defect Value successfully validated");
		          }
		          else
		          {
		        	 throw new UserDefinedException("Search value is not matching");
		          }
		          
				 }
		      else
		      {    
			    if(text.contains(defectValue))
			   {
			      System.out.println("Pass-Defect Value successfully validated");
			     }
			    else
		          {
		        	 throw new UserDefinedException("Search value is not matching");
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
		
	public boolean saveAndUpdateDefect() throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   bp.waitForElement();
	   createButtonSave.click();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	     updateDefect1.click();
	    bp.waitForElement();
	  
	     return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   log.info("Defect button is not clicked");
	   throw e;
	  }
	 }
	
	
	public boolean updateEditDefectWindow() throws Exception
	{
		try
		{
			bp=new BasePage();
		   bp.waitForElement();
		   bp.explicitWait(updateEditDefect);
		    updateEditDefect.click();
		   System.out.println("Pass-Defect is updated successfully");
		   bp.waitForElement();
		   WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//*[@type='button' and text()='Update'])[2]")));
		   return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info("Update button is not clicked");
			throw e;
			
		}
	}
	
	public boolean enterDefectCascadingDetails(String ze_MultiSelectListCascadingValue1,String ze_MultiSelectListCascadingValue2,String ze_SingleSelectListCascadingValue1,String ze_SingleSelectListCascadingValue2) throws Exception
	{
		try
		{
		 bp=new BasePage();
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 Actions a1=new Actions(driver);
		 bp.waitForElement();
		 if(ze_MultiSelectListCascadingValue1!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_MultiSelectListCascading1));
			  customZE_MultiSelectListCascading1.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_MultiSelectListCascadingValue1).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_MultiSelectListCascadingValue2!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_MultiSelectListCascading2));
			  customZE_MultiSelectListCascading2.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_MultiSelectListCascadingValue2).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_SingleSelectListCascadingValue1!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_SingleSelectListCascading1));
			  customZE_SingleSelectListCascading1.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_SingleSelectListCascadingValue1).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 if(ze_SingleSelectListCascadingValue2!="")
		  {
			  wait.until(ExpectedConditions.elementToBeClickable(customZE_SingleSelectListCascading2));
			  customZE_SingleSelectListCascading2.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(ze_SingleSelectListCascadingValue2).sendKeys(Keys.ENTER).build().perform();
			}
		 bp.waitForElement();
		 System.out.println("Pass-Defect Cascading values are entered successfully");
		 bp.waitForElement();
		 return true;	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean downloadExportFile() throws Exception
	 {
	   try
	    {
	     bp=new BasePage();
//	     bp.waitForElement();
//	     defectExport.click();
	     bp.waitForElement();
	    // bp.explicitWait(exportMsg);
	     WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
	     wait.until(ExpectedConditions.visibilityOf(exportMsg));
	     Actions act=new Actions(driver);
	     act.moveToElement(exportMsg).perform();
	     String text=exportMsg.getText();
	     System.out.println(text);
	     wait.until(ExpectedConditions.elementToBeClickable(downloadExport));
	     downloadExport.click();
	     System.out.println("Pass-Export Download button is clicked successfully");
	     bp.waitForElement();
	     return true;
	    }
	    catch(Exception e)
	    {
	     e.printStackTrace();
	     throw e;
	    }
	 
	 
	}
	
	public boolean clickONAdvanceSearchIcon() throws Exception
	{
		try
		{
			 bp=new BasePage();
			  bp.waitForElement();
		advance.click();
		bp.waitForElement();
		System.out.println("Sucessfully clicked on Advanced Button");
		bp.waitForElement();
		
		 return true;
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
	}
	
	
	
//	public boolean validateSearchedDefect(String defectname) throws Exception{
//		 try
//		 {
//			 
//		 bp=new BasePage();
//		 String lastResult=searchCount.getText();
//		 
//		 int remainder=(Integer.parseInt(lastResult))%50;
//		 int lastPage=0;
//		 if(remainder>0)
//		 {
//		  lastPage=(Integer.parseInt(lastResult))/50+1;
//		 }
//		 else
//		 {
//		 lastPage=(Integer.parseInt(lastResult))/50; 
//		 }
//		 
////		 String lastResult=searchCount.getText();
////		 int page=(Integer.parseInt(lastResult))/50;
//		 
//		 
//		 for(int i=0;i<=lastPage;i++)
//		 {
//			 
//			for(int j=0;j<=(Integer.parseInt(lastResult));j++)
//					
//			{
//		 WebElement ele=driver.findElement(By.xpath(dvalue1+defectname+dvalue2));
//		 bp.waitForElement();
//		 String text=ele.getText();
//		 if(text.equals(defectname))
//		 {
//		 System.out.println("Pass-DefectName successfully validated");
//		 }
//		 
//			
//			}
//			
//			
//			nextButton.click();
//			bp.waitForElement();
//		// driver.findElement(By.xpath("//li[@class='next-page']//span")).click();
//		 }
//		 
//		 return true;	
//		 }
//		 catch(Exception e)
//		 {
//		 e.printStackTrace();
//		 throw e;
//		 }
//		}
//
	
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
	 
	 public boolean validateAttachmentSuccessMsg() throws UserDefinedException,Exception
	  {
	    try
	     {
	      bp=new BasePage();
	      WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.MAX_EXPLICIT);
	      
	      Actions a1=new Actions(driver);
	      //WebElement ele=driver.findElement(By.xpath("//*[@class='toast-title']"));
	      wait.until(ExpectedConditions.visibilityOf(notificationMsg));
	      a1.moveToElement(notificationMsg).perform();
	      String value=notificationMsg.getText();
	      if(value.equals("Success"))
	      {
	      System.out.println("Attachment uploaded successfully");
	      }
	      
	      else
	      {
	       throw new UserDefinedException("Attachment is not uplaoded");
	      }
	      
	      return true;
	      }
	      catch(Exception e)
	      {
	      e.printStackTrace();
	      throw e;
	      }
	  }
	    
	 public boolean validateDefectTrackingPage() throws Exception
		{
			try
			{
			String valDefectTracking="Defects Linked to Execution";
			
			String verifyPage=verifyDefectTrackingPage.getText();
			//defect-tracking-search//h5
			if(valDefectTracking.equals(verifyPage))
			{
				
				System.out.println("Defect Tracking page successfully launched");
				
			 
			}
			 return true;	
			}
			 catch(Exception e)
			 {
			 e.printStackTrace();
			 throw e;
			 }
		}
		
		public boolean validateAdvanceSearchPage() throws Exception
		{
			try
			{
			//String searchTitle="Basic";
			
			String verifyPage=searchLinkTitle.getText();
			//defect-tracking-search//h5
			if(verifyPage.equals("Basic"))
			{
				
				System.out.println("Successfully naviagated to advance search page");
				
			 
			}
			 return true;	
			}
			 catch(Exception e)
			 {
			 e.printStackTrace();
			 throw e;
			 }
		}
		
		
		public boolean validateFilter(String filterName) throws Exception
		{
			try
			{
			String verifyFilter=filterTitle.getText();
			//defect-tracking my filter
			if(verifyFilter.equals(filterName))
			{
				
				System.out.println("Sucessfully selected the filter:" +filterName);
			}
			 return true;	
			}
			 catch(Exception e)
			 {
			 e.printStackTrace();
			 throw e;
			 }
		}
		
		public boolean validateSelectedFilter(String filterValue) throws Exception
		{
			try
			{
			String verifyFilter=filterName.getText();
			//defect-tracking filterName
			if(verifyFilter.equals(filterValue))
			{
				
				System.out.println("Filter Name:" +filterValue +"is validated successfully");
			}
			 return true;	
			}
			 catch(Exception e)
			 {
			 e.printStackTrace();
			 throw e;
			 }
		}
	 
		public boolean validateDefectProject(String project) throws Exception
		{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			String projectName=selectDefectProject.getText();
			System.out.println("App-"+projectName);
			
			if(projectName.equals(project) )
			{
				System.out.println("Pass-Defect Project is validated Successfully");
			}
			else
			{
				System.out.println("Fail-Defect Project is not validated");
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
		
		public boolean viewDefectIssueMsg(String filterValue) throws Exception
		  {
		   try
		   {
		   bp=new BasePage();
		   //bp.waitForElement();
		   bp.explicitWait(issueNotificationMsg); 
		   Actions act=new Actions(driver);
		   act.moveToElement(issueNotificationMsg).perform();
		   String text=issueNotificationMsg.getText();
		   
		   //System.out.println(text);
		   String[] defectVal=text.split(",");
		   String defectValue=defectVal[1];
		   //System.out.println("App-"+defectValue);
		   
		   
		   //view-Msg
		   if((defectValue).equals(filterValue))
		   {
		    
		    System.out.println(" Pop up message" +filterValue +"is validated successfully");
		   }
		  boolean res=closePopUpMsg.isEnabled();
		  if(res==true)
		  {
		   bp.waitForElement();
		   closePopUpMsg.click();
		  }
		    return true; 
		   }
		    catch(Exception e)
		    {
		    e.printStackTrace();
		    throw e;
		    }
		  }
		 
		 
		 public boolean clickOnTestcaseID(String testcaseNo) throws Exception
			{
				try
				{
					
				bp=new BasePage();
				bp.waitForElement();
				
				for(int i=0;i<=testCaseNo.size()-1;i++)
				{
					String id=testCaseNo.get(i).getText();
					
					if(testcaseNo.equals(id))
					{
						System.out.println("testCaseNo"+id);
						testCaseNo.get(i).click();
						System.out.println("testCaseNo ="+id+"has clicked sucessfully");		
					}
				}
				System.out.println("testcase="+testcaseNo+ "id not there");
		
				return true;
				}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			}
				
			

			
			public boolean validateClickOnTestcaseID(String testcaseNo) throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					String tc=validateTestcaseNo.getText();
					System.out.println(tc);
					if(tc.equals(testcaseNo))
					{
						System.out.println("Testcase"+ testcaseNo+"is validated Sucessfully");
					}
					else
					{
						System.out.println("testCaseNo ="+testcaseNo+"is not validated sucessfully");	
					}
					return true;
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
			}
		 
			public boolean filterCreatorValues() throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					List<WebElement> creatorSize=driver.findElements(By.xpath("//*[@class='select2-results']//li/option"));
					//int creatorSize=eleSize.size();
					for(int i=0;i<=creatorSize.size()-1;i++)
					{
						String presentFilter=(creatorSize.get(i)).getAttribute("value");
				        System.out.println("Matched Creators are="+presentFilter);
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
		  
		  public boolean filterDefectCreator(String creator) throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					bp.waitForElement();
					Actions act=new Actions(driver);
					WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
					if(creator!="")
					  {
					  bp.waitForElement();	
					  wait.until(ExpectedConditions.elementToBeClickable(selectFiledBy));	  
					  selectFiledBy.click();//
					  act.sendKeys(creator).perform();//
					  bp.waitForElement();
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
//		  public boolean downloadDefectAttachment(String fileName) throws Exception
//			 {
//			  try
//			  {
//			   WebElement browseIcon=driver.findElement(By.xpath(browse));
//			   JavascriptExecutor js=((JavascriptExecutor)driver);
//			   js.executeScript("arguments[0].scrollIntoView(true);",browseIcon );
//			   bp.waitForElement();
//			   WebElement ele=driver.findElement(By.xpath(attachFile1+fileName+attachFile2));
//			   Actions act=new Actions(driver);
//			   act.moveToElement(ele).click().perform();
//		       bp.waitForElement();
////			   bp.explicitWait(clickOnDownload);
////			   act.moveToElement(clickOnDownload).click();
////			   bp.waitForElement();
////			  
//			   return true;
//			    }
//			    catch(Exception e)
//			    {
//			    e.printStackTrace();
//			    throw e;
//			    }
//			 }
		  
		  
		  public boolean downloadDefectAttachment(String fileName) throws Exception
			 {
			  try
			  {
			   WebElement browseIcon=driver.findElement(By.xpath(browse));
			   JavascriptExecutor js=((JavascriptExecutor)driver);
			   js.executeScript("arguments[0].scrollIntoView(true);",browseIcon );
			   bp.waitForElement();
			   WebElement ele=driver.findElement(By.xpath(attachFile1+fileName+attachFile2));
			   Actions act=new Actions(driver);
			   act.moveToElement(ele).click().perform();
		       bp.waitForElement();
		       if(fileName.contains(".jpg"))
		       {
		    	   System.out.println(fileName);	   
			   bp.explicitWait(clickOnDownload);
			   act.moveToElement(clickOnDownload).click().perform();
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

		  public boolean validateDownloadAttachment(String fileName) throws Exception
			{
			try
			{
			String title=driver.getTitle();
			System.out.println(title);
			String[] downloadFile_Name=title.split("\\.");
			if(fileName.contains(downloadFile_Name[0]))
			{
			System.out.println("File downloaded successfully");
			}
			else
			{
			System.out.println("File is not downloded");
			}
		    return true;
			}
		  catch(Exception e)
			  {
			   e.printStackTrace();
			   throw e;
			  }
	}
		  
		  public boolean vlaidateTestCaseCycle(String testCycle) throws Exception
			{
				try
				{
					
				bp=new BasePage();
				bp.waitForElement();
				
				for(int i=0;i<=testCaseCycle.size()-1;i++)
				{
					String id=testCaseCycle.get(i).getText();
					
					if(testCycle.equals(id))
					{
						System.out.println("testCycle"+id);
						testCaseCycle.get(i).click();
						System.out.println("testCycle ="+id+"has validated sucessfully");		
					}
				}
				System.out.println("testcaseCycle="+testCycle+ "id not there");
		
				return true;
				}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			}
		  
		  public boolean clickOnDefectAdvancedSearchButton() throws Exception
			 {
			   try
			    {
			     bp=new BasePage();
			     bp.waitForElement();
			     bp.waitForElement();
			     bp.explicitWait(advance);
			     advance.click();
			     System.out.println("Pass-Advanced Search button is clicked successfully");
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
			
		  
		  public boolean filterDefectAssignee(String assignee) throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					bp.waitForElement();
					Actions act=new Actions(driver);
					WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
					if(assignee!="")
					  {
					  bp.waitForElement();	
					  wait.until(ExpectedConditions.elementToBeClickable(selectAssignee));	  
					  selectAssignee.click();//
					  act.sendKeys(assignee).perform();//
					  bp.waitForElement();
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
		  
		  public boolean filterDefectAssigneeInChangeMultiple(String assignee) throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					bp.waitForElement();
					Actions act=new Actions(driver);
					WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
					if(assignee!="")
					  {
					  bp.waitForElement();	
					  wait.until(ExpectedConditions.elementToBeClickable(enterAssignee));	  
					  enterAssignee.click();//
					  act.sendKeys(assignee).perform();//
					  bp.waitForElement();
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
		  
		  
		  public boolean filterDefectAssigneeInSearchGridView(String assignee) throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.waitForElement();
					bp.waitForElement();
					Actions act=new Actions(driver);
					WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
					if(assignee!="")
					  {
					  bp.waitForElement();	
					  wait.until(ExpectedConditions.elementToBeClickable(enterDefectAssignee));	  
					  enterDefectAssignee.click();//
					  act.sendKeys(assignee).perform();//
					  bp.waitForElement();
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
		  
		  public boolean clickOnCancelChangeMultipleWindow() throws Exception
			{
				try
				{
					bp=new BasePage();
					bp.explicitWait(cancelChangeMultipleWindow);
					bp.waitForElement();
					cancelChangeMultipleWindow.click();
					bp.waitForElement();
					return true;
				}
				catch(Exception e)
				 {
				  e.printStackTrace();
				  throw e;
				 }
			}
		  
		  public boolean validateSuccessMsg() throws UserDefinedException,Exception
		  {
		    try
		     {
		      bp=new BasePage();
		      WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
		      
		      Actions a1=new Actions(driver);
		      //WebElement ele=driver.findElement(By.xpath("//*[@class='toast-title']"));
		      wait.until(ExpectedConditions.visibilityOf(notificationMsg));
		      a1.moveToElement(notificationMsg).perform();
		      String value=notificationMsg.getText();
		      if(value.equals("Success"))
		      {
		      System.out.println("Success message displayed successfully");
		      }
		      bp.waitForElement();
		      bp.explicitWait(closeNotificationMsg);
		      closeNotificationMsg.click();
		      
		      return true;
		      }
		      catch(Exception e)
		      {
		      e.printStackTrace();
		      throw e;
		      }
		  }
		  
		  
		  public boolean clickOnEditDefectButton() throws Exception
		     {
		      try
		      {
		       bp=new BasePage();
		       bp.waitForElement();
		       defectEditButton.click();
		       System.out.println("Pass-Defect Edit button is clicked successfully");
		       bp.waitForElement();
		        return true;
		         }
		       catch(Exception e)
		       {
		       e.printStackTrace();
		       throw e; 
		     }
		    }
		  
		  
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
		  
		  
		  public boolean viewDropdownFields(String fieldName,String fieldValue) throws Exception
		  {
		   
		   try
		   {
		    bp=new BasePage();
		    bp.waitForElement();
		   WebElement field_Name=driver.findElement(By.xpath(attribute1+fieldName+attribute2));
		   
		   field_Name.click();
		    bp.waitForElement();
		   String field_Value=driver.findElement(By.xpath(selectSearch1+fieldValue+selectSearch2)).getText();
		      if(field_Value.equals(fieldValue))
		      {
		       System.out.println("Dropdown field value- "+field_Value+" validated successfully");
		      }
		      
		   return true;
		     }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
		   
		  }
		  
		  public boolean verifySearchRequirementCount() throws InterruptedException
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
		  
		

public boolean saveAndCancel() throws Exception
{
	 try
	  {
	   bp=new BasePage();
	   bp.waitForElement();
	   createButtonSave.click();
	   bp.waitForElement();
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



public boolean validateErrorMsg() throws UserDefinedException,Exception
{
  try
   {
    bp=new BasePage();
    WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
    
    Actions a1=new Actions(driver);
    //WebElement ele=driver.findElement(By.xpath("//*[@class='toast-title']"));
    wait.until(ExpectedConditions.visibilityOf(notificationMsg));
    a1.moveToElement(notificationMsg).perform();
    String value=notificationMsg.getText();
    if(value.equals("Error"))
    {
    System.out.println("Error message displayed successfully");
    }
    bp.waitForElement();
    bp.explicitWait(closeNotificationMsg);
    closeNotificationMsg.click();
    return true;
    }
    catch(Exception e)
    {
    e.printStackTrace();
    throw e;
    }
}


public boolean updateDefectEditWindow() throws Exception
{
	try
	{
		bp=new BasePage();
	   bp.waitForElement();
	   bp.explicitWait(updateEditDefect);
	   updateEditDefect.click();
	   System.out.println("Pass-Defect is updated successfully");
	   //bp.waitForElement();
	   return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		log.info("Update button is not clicked");
		throw e;
		
	}
}


public boolean viewDefectPermissionMsg(String permissionValue) throws Exception
{
	try
	{
	bp=new BasePage();	
	bp.explicitWait(issueNotificationMsg);	
	Actions act=new Actions(driver);
	act.moveToElement(issueNotificationMsg).perform();
	String text=issueNotificationMsg.getText();
	String defectValue;
	System.out.println(text);
	String[] defectVal=text.split(", ");
	defectValue=defectVal[1];
	System.out.println(defectValue);
	//view-Msg
	if(defectValue.equals(permissionValue))
	{
		
		System.out.println("Defect Value:" +permissionValue +"is validated successfully");
	}
	else
	{
	System.out.println("Defect Value:" +permissionValue +"is not validated successfully");
	}
	 return true;	
	}
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 throw e;
	 }
}



public boolean updateDefectCommentInSearchView(String comment) throws Exception
{
	try
	{
	 bp=new BasePage();	
	 Actions act=new Actions(driver);
	 WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
	 for(int i=1;i<=7;i++)
	  {
			act.sendKeys(Keys.DOWN).perform();
	  }
	 bp.waitForElement();
	 if(comment!="")
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(enterDefectComment));
		  enterDefectComment.click();
		  act.pause(1800).sendKeys(comment).sendKeys(Keys.ENTER).build().perform();
		  saveIcon.click();
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


public boolean enterNumberCustomField(String ze_Number_Field) throws Exception
{
	try
	{
		bp=new BasePage();
		Actions a1=new Actions(driver);
		 if(ze_Number_Field!="")
		  {
			 bp.explicitWait(customZE_Number_Field);
			 customZE_Number_Field.click();
			  bp.waitForElement();
			  a1.pause(1800).sendKeys(customZE_Number_Field).pause(3000).sendKeys(Keys.ENTER).build().perform();
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


public boolean loginToDTS(String username,String password) throws Exception

{
	try
	{

		bp=new BasePage();
		bp.waitForElement();
		try
		{
		bp.waitTillElementIsVisible(dtsPoup);
		}
		catch(TimeoutException e)
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

public boolean defectSaveAndUpdateDefect() throws Exception
{
 try
 {
   bp=new BasePage();
   bp.waitForElement();
   createButtonSave.click();
   bp.waitForElement();
   bp.waitForElement();
   bp.waitForElement();
   bp.waitForElement();
   bp.waitForElement();
   updateDefect3.click();
   bp.waitForElement();
 
    return true;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  log.info("Defect button is not clicked");
  throw e;
 }
}

public boolean subtaskSaveAndUpdateDefect() throws Exception
{
 try
 {
  bp=new BasePage();
  bp.waitForElement();
  createButtonSave.click();
  bp.waitForElement();
  bp.waitForElement();
  bp.waitForElement();
  bp.waitForElement();
  bp.waitForElement();
   updateDefect2.click();
   bp.waitForElement();
 
    return true;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  log.info("Defect button is not clicked");
  throw e;
 }
}
}

	
