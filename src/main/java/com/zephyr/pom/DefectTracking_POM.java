package com.zephyr.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;

public class DefectTracking_POM {


	WebDriver driver=null;
	WebDriver driver2;
	BasePage bp;
	public Logger log;
	
	public DefectTracking_POM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		
	}
	
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


}
