package com.zephyr.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zephyr.common.LaunchBrowser;

public class CreateCustomFieldsPage_POM {
	WebDriver driver;

	public CreateCustomFieldsPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
	}

	/*
	 * **************************************************** Method Name :
	 * Purpose : CreateCustomField() method Author : OPAL Date Created :
	 * 10/07/17 Date Modified : Reviewed By :
	 * ******************************************************
	 */
	
	 public String customFieldValue1="//td//strong[text()='";
	    public String customFieldValue2="']";

	@FindBy(xpath = "//*[@class='misc-image setting-image']")
	public WebElement adminSetting;

	@FindBy(xpath = "//*[text()='Administration']")
	public WebElement administration;

	@FindBy(xpath = "//span[text()='Customizations']")
	public WebElement customizations;

	@FindBy(xpath = "(//button[text()='Fields'])[3]")
	public WebElement testcaseFields;

	@FindBy(xpath = "//button[text()='Lock Zephyr access']")
	public WebElement lockZephyrAccess;

	@FindBy(xpath = "(//button[text()='Yes'])[5]")
	public WebElement confirmLockZephyrAccess;

	@FindBy(xpath = "//*[@title='Add New Field']")
	public WebElement addNewCustomField;

	@FindBy(xpath = "//*[@id='displayName']")
	public WebElement customFieldName;

	@FindBy(xpath = "//*[@id='description']")
	public WebElement customFieldDescription;

	@FindBy(xpath = "//*[@id='dataType']")
	public WebElement datatypeDropDown;
	
	@FindBy(xpath="//*[@class='picklist-input clearfix']//input")
	//@FindBy(xpath="//*[@id='fields-modal']/div/div/div[2]/zui-modal-body/div[4]/form/div/div[2]/div/div/div[2]/input")
	public WebElement picklistValues;

	@FindBy(xpath = "//*[@class='cursor-pointer' and text()='Add ']")
	public WebElement addPicklistValues;

	@FindBy(xpath = "//*[@id='select2-projects-container']")
	public WebElement projectAssociation;

	@FindBy(xpath = "//*[@id='projectCheck']")
	public WebElement checkAllProject;

	@FindBy(xpath = "//*[@id='searchableCheckbox']")
	public WebElement searchable;
	
	@FindBy(xpath="//*[@id='fields-modal']/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement saveCustomField;

	@FindBy(xpath = "//*[@id='enable-zephyr-access']")
	public WebElement enableZephyrAccess;

	@FindBy(xpath = "//*[@id='fields-modal']/div/div/div[1]/div[2]/button")
	public WebElement closeCustomFieldWindow;

	/*
	 * **************************************************** Method Name :
	 * CreateCustomUser() Purpose : CreateCustomUser() method Author : OPAL Date
	 * Created : 10/08/17 Date Modified : Reviewed By :
	 * ******************************************************
	 */
	// ***6.1 X-Path***//
	@FindBy(xpath = "//a[@title='User Setup']")
	public WebElement manageUsers;

	// **6.0 Xpath**//
	// @FindBy(xpath="//*[@id='sidr']/ul/li[2]/ul/li/a/span")
	// public WebElement manageUsers;

	// **6.0 Xpath**//
	// @FindBy(xpath="//*[@id='ze-main-app']/resource-management/resource-management-details/div/section/div[2]/button")
	// public WebElement addNewUser;

	// ***6.1 X-Path***//
	@FindBy(xpath = "//button[@title='Add Resource']")
	public WebElement addNewUser;

	@FindBy(xpath = "//*[@id='resource-firstname']")
	public WebElement FirstName;

	@FindBy(xpath = "//*[@id='resource-lastname']")
	public WebElement LastName;

	@FindBy(xpath = "//*[@id='resource-type']")
	public WebElement Type;

	@FindBy(xpath = "//*[@id='resource-roles']")
	public WebElement Role;

	@FindBy(xpath = "//*[@id='resource-email']")
	public WebElement Email;

	@FindBy(xpath = "//*[@id='resource-title']")
	public WebElement Title;

	@FindBy(xpath = "//*[@id='resource-location']")
	public WebElement Location;
	
	@FindBy(xpath="//*[@id='resource-credentialsExpired']")
	public WebElement expireCredential;

	// *********6.0 X Path******//
	// @FindBy(xpath="//*[@id='ze-main-app']/resource-management/resource-management-details/div/div/div[2]/div/div/resource-form/div/form/div[3]/button[2]")
	// public WebElement saveNewUser;

	// *********6.1 X Path******//
	@FindBy(xpath = "//div[@class='subform resource-form']//div[3]//button[2]")
	public WebElement saveNewUser;

	public String customField1 = "//div[text()='";
	public String customField2 = "']";

	@FindBy(xpath = "//button[text()='Execution Status']")
	public WebElement executionButton;
	@FindBy(xpath = "//button[text()='Step Execution Status']")
	public WebElement executionStepButton;

	@FindBy(xpath = "//*[@id='mandotryCheckbox']")
	public WebElement mandatoryChk;

	@FindBy(xpath = "//input[@id='uniqueCheckbox']")
	public WebElement uniqueCheckBox;

	@FindBy(xpath = "//*[@id='fields-modal']/div/div/div[3]/zui-modal-footer/button[2]")
	public WebElement saveCustomFields;

	@FindBy(xpath = "//*[@id='fields-modal']/div/div/div[1]/div[2]/button")
	public WebElement cancelCustomFields;

	@FindBy(xpath = "//button[text()='Roles']")
	public WebElement clickonRole;

	@FindBy(xpath = "//*[@id='role-name']")
	public WebElement addRoleName;

	@FindBy(xpath = "//*[@placeholder='Enter description']")
	public WebElement addRoleDesc;

	@FindBy(xpath = "//span[@title='Add New Role']")
	public WebElement addNewRole;

	public String administrationApps1 = "//label[text()='";
	public String administrationApps2 = "']";

	@FindBy(xpath = "//button[contains(.,'Add')]")
	public WebElement clickonAdd;

	public String active1 = "//b[text()='";
	public String active2 = "']";

	public String name1 = "//div[@title='";
	public String name2 = "']";
	
	 public String validation1="//div[@title='";
     public String validation2="']/../../../div[2]/div/div";

	public String categories1 = "//li[text()='";
	public String categories2 = "']";

	@FindBy(xpath = "//*[@placeholder='Enter Name']")
	public WebElement enterPreferenceName;

	@FindBy(xpath = "//*[@id='preference-value']")
	public WebElement enterPreferenceValue;

	@FindBy(xpath = "(//button[contains(.,'Save')])[1]")
	public WebElement savePreference;

	@FindBy(xpath = "(//button[contains(.,'Save')])[2]")
	public WebElement clickOnSavePreference;
	
	public String jiraLink1="//*[@title='";
	   public String jiraLink2="']";
	   
	   @FindBy(xpath="//*[@placeholder='Enter Value']")
		 public WebElement Value;

		 @FindBy(xpath="//*[@id='grid-table-defects_admin']/div[2]/div[1]/div[3]/div/div/div/input")
		 public WebElement checkbox;


		 @FindBy(xpath="//*[@id='preference']/div[3]/preference-form/div/form/div[2]/button[2]")
		 public WebElement Save;	 
		 
		 @FindBy(xpath="//*[@id='confirmation-modal']/div/div/div[3]/zui-modal-footer/button[2]")
		 public WebElement Save1;
		 
		 public String Checkbox="//*[@id='preference-active']";
			
			public String customValue1="(//*[text()='";
			public String customValue2="']/../../..//div[1])[1]";	
			
			@FindBy(xpath="//span[text()='Defect Admin']")
			public WebElement defectAdmin;
			 
			@FindBy(xpath="//span[text()='Preferences']")
			public WebElement preferences;

			public String selectCategory1="//li[text()='";
			public String selectCategory2="']";

			@FindBy(xpath="//span[text()='JIRA Custom Fields Management']")
			public WebElement jiraCustomFieldsManagement;

			@FindBy(xpath="//b[text()='Clear All']")
			public WebElement clearAll;

			@FindBy(xpath="//button[text()='Clear Cache']")
			public WebElement clearCache;

			@FindBy(xpath="//div[@id='clearCache-modal']//div[@class='modal-body']")
			public WebElement cacheMsg;

			@FindBy(xpath="//*[@id='clearCache-modal']//button[text()='Yes']")
			public WebElement cacheYes;
			
			
			
			//Added
			
			
			 public String statusEnableDisabel1="//div[@title='";
			 public String statusEnableDisabel2="']/following::label";
			 
			 @FindBy(xpath="//*[@value='EXECUTION_STATUS_UPDATE']")
			 public WebElement updateStatus;
			 
			 @FindBy(xpath="(//*[@id='execution-status-modal']//button)[1]")
			 public WebElement closeExecutionStatusPage;
			 
			 @FindBy(xpath="//*[@for='desktop_url']/..//div/div/span[1]")
			 public WebElement desktopURL;
			 
			 @FindBy(xpath="//*[@for='dashboard_url']/..//div/div/span[1]")
			 public WebElement dashboardUrl;
			 
			 
			 //
//			 @FindBy(xpath="//*[@id='defect-system-select2']")
//			 public WebElement dashboardUrl;
//			 @FindBy(xpath="//input[@placeholder='Enter JIRA connection name']")
//			 public WebElement dashboardUrl;
//			 @FindBy(xpath="//input[@placeholder='Enter JIRA connection name']")
//			 public WebElement dashboardUrl;
//			 @FindBy(xpath="//input[@placeholder='Enter JIRA connection URL']")
//			 public WebElement dashboardUrl;
			
			 
			
			

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
			 
			 public String customName1=".//*[@title='";
		      public String customName2="']";
		      
		  	@FindBy(xpath="//button[@id='constant_requirement']")
			public WebElement reqFields;
		  	
		    public String jiraLinkCheckbox1="(//*[@class='flex-bar'])[";
		      public String jiraLinkCheckbox2="]//input";
		      
		      public String name3 = "(//*[text()='";
		  	public String name4 = "']/../../div[1]/div)[1]";
		 
			
			@FindBy(xpath = "//button[@title='Add a preference']")
		  	public WebElement addPreference;
			
			 @FindBy(xpath="//*[@id='defect-system-select2']")
			    public WebElement dtsType;
			    @FindBy(xpath="//input[@placeholder='Enter JIRA connection name']")
			    public WebElement dtsName;
			    @FindBy(xpath="//input[@placeholder='Enter JIRA connection URL']")
			    public WebElement dtsUrl;
			    @FindBy(xpath="//input[@placeholder='Enter Username']")
			    public WebElement dtsUname;
			   
			    @FindBy(xpath="//input[@placeholder='Enter Password']")
			    public WebElement dtsPass;
			   
			    
			    @FindBy(xpath="//i[@title='Save']")
			    public WebElement saveDTS;
			   
			    
			    @FindBy(xpath="(//button[text()='Yes'])[1]")
			    public WebElement confirmSave;
			   
			    @FindBy(xpath="//i[@title='Edit']")
			    public WebElement editDTS;
			    
			    public String validateCheckBox1="//div[@title='";
			    public String validateCheckBox2="']/../../../div[3]/div/div/div/input";
				
			    @FindBy(xpath = "(//div[@class='clearfix form-footer']/button)[1]")
			  	public WebElement clickOnCancelPreference;
			    
				@FindBy(xpath = "(//*[@id='confirmation-modal']/div/div/div[3]/zui-modal-footer/button)[1]")
			  	public WebElement clickOnCancelPreferencePopWindow;
				
				 @FindBy(xpath = "//a[@id='edit-advanced-properties']")
					public WebElement clickOnAdvanceSettingsInJira;
				 
				 public String validateClearCasheOfOnlineProject1="//h4[text()='";
				    public String validateClearCasheOfOnlineProject2="']";
				    
				    public String clearselected1="//span/b[text()='";
				    public String clearselected2="']";
				    
				    public String keyValue1="//td//strong[text()='";
				    public String keyValue2="']/../../td[2]/span";
				    
				    public String deleteproperty1="//div[@title='";
				    public String deleteproperty2="']/../../../div[4]/div[1]";
				    
				    @FindBy(xpath="//*[@id='confirmation-modal']//div[3]/zui-modal-footer/button[2]")
				 	 public WebElement deleteYesIcon;
				    
				    public String validateJiraCustomFieldsManagement1="//span[text()='";
				    public String validateJiraCustomFieldsManagement2="']";
				   
				    
				    @FindBy(xpath = "//input[@class='aui-button']")
				  	public WebElement clickOnUpdate;
				    
				    public String customRole1 = "//div[@title='";
					public String customRole2 = "']";
					
					 @FindBy(xpath="//h4[text()='Customize Roles']/../../div[2]/button")
					 public WebElement closeCustomizationTab;
					 
					 @FindBy(xpath = "(//*[@id='defect-update-user-modal']//button)[1]")
						public WebElement closeExternalIcon;
					
				    






}
