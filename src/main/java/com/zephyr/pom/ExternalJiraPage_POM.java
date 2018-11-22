package com.zephyr.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.zephyr.common.LaunchBrowser;



public class ExternalJiraPage_POM {

	WebDriver driver = null;
	WebDriver driver2;
	
	public Logger log;

	public ExternalJiraPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);

	}

	 @FindBy(xpath="//*[@title='Sort options alphabetically']")
	  public WebElement sort_Jira;
	 
	@FindBy(xpath = "//a[text()='View all issues and filters']")
	public WebElement viewAllIssuesAndFilters;

	@FindBy(xpath = "//textarea[@id='advanced-search']")
	public WebElement searchText;

	@FindBy(xpath = "//button[text()='Save as']")
	public WebElement saveAs;

	//@FindBy(id = "filterName")//previous 03/06/18
      @FindBy(xpath ="//input[@name='name']")//updated 04/06/18 by srikanth
	  public WebElement filterName;

	@FindBy(xpath = "//*[@value='Submit']")
	public WebElement submitFilter;

	@FindBy(xpath = "//*[@id='search-header-view']/div/h1")
	public WebElement validateFilter;

	@FindBy(xpath = "//span[text()='Edit']")
	public WebElement editOption;

	@FindBy(id = "summary")
	public WebElement summaryText;

	@FindBy(id = "labels-textarea")
	public WebElement labelText;

	@FindBy(id = "priority-field")
	public WebElement priorityField;

	@FindBy(id = "issuelinks-linktype")
	public WebElement linkedIssue;

	@FindBy(xpath = "//*[@id='qf-field-comment']//*[@id='comment']")
	public WebElement commentField;

	@FindBy(xpath = "//input[@value='Update']")
	public WebElement update;

	@FindBy(xpath = "//span[text()='Issues']")
	public WebElement linkIssue;

	@FindBy(xpath = "//div[@id='linkingmodule_heading']")
	public WebElement linkIssueHeading;

	@FindBy(xpath = "//button[text()='Go']")
	public WebElement goLinkButton;

	@FindAll({ @FindBy(xpath = "//*[@class='links-list ']//dd//p") })
	public List<WebElement> linkSize;
	
	@FindBy(xpath="//*[@id='show-more-links-link']")
	public WebElement moreLinks;
	
	@FindBy(xpath="(//*[@title='Zephyr testcase']//..//dd//a)[2]")
	public WebElement allLinkIssueId1;

	@FindAll({ @FindBy(xpath = "//*[@title='Zephyr testcase']//..//dd") })
	public List<WebElement> allLinkIssue;

	// button[text()='Save as']
	@FindAll({ @FindBy(xpath = "(//*[@title='Zephyr testcase']//..//dd//span/a)")})
	public List<WebElement> allLinkIssueId;
	
	@FindBy(xpath="(//*[@title='Zephyr testcase']//..//dd//li/a)")
	public List<WebElement> allLinkIssueExe;

	@FindBy(xpath = "//span[text()='More']")
	public WebElement More;

	@FindBy(xpath = "//span[text()='Delete']")
	public WebElement delete1;

	@FindBy(xpath = "//input[@id='delete-issue-submit']")
	public WebElement delete2;

	@FindBy(xpath = "//span[text()='Move']")
	public WebElement Move;

	@FindBy(xpath = "//input[@class='text aui-ss-field ajs-dirty-warning-exempt']")
	public WebElement Icon;

	@FindBy(xpath = "//input[@id='next_submit']")
	public WebElement Next;

	@FindBy(xpath = "//input[@id='move_submit']")
	public WebElement NextF;

	public String project1 = "(//a[text()='";
	public String project2 = "'])[2]";

	@FindBy(xpath = ".//*[text()='Edit']")
	public WebElement editJira;

	@FindBy(xpath = "//input[@name='summary']")
	public WebElement enterJiraSummary;

	@FindBy(xpath = "//*[@id='labels-textarea']")
	public WebElement enterJiraLabels;

	@FindBy(xpath = "//*[@id='priority-field']")
	public WebElement enterJiraPriority;

	@FindBy(xpath = "//*[@name='issuelinks-linktype']")
	public WebElement enterJiraLinkedIssues;

	@FindBy(xpath = "//*[@id='issuelinks-issues-textarea']")
	public WebElement enterJiraLinkedIssuesArea;

	@FindBy(xpath = "//*[@id='assignee-field']")
	public WebElement enterJiraAssignee;

	@FindBy(xpath = "(//*[@class='wiki-edit-content'])[4]")
	public WebElement enterJiraEditContent;

	// @FindBy(xpath=".//*[@name='Edit']")
	public String enterJiraEditUpdate = ".//*[@name='Edit']";

	@FindBy(id = "summary-val")
	public WebElement summaryValue;

	@FindBy(id = "priority-val")
	public WebElement priorityValue;

	@FindBy(xpath = "//*[@class='labels-wrap value editable-field inactive']")
	public WebElement labelsValue;

	//@FindBy(xpath = "//img[@alt='User profile for automation']")//previous xpath
	  @FindBy(xpath = "//a[@id='header-details-user-fullname']")//updated on 11/07/18
	  public WebElement logOutOption;

	@FindBy(xpath = "//a[text()='Log Out']")
	public WebElement LogOut;

	@FindBy(xpath = "//a[text()='Log In']")
	public WebElement LogIn;

	public String Id1 = "(//a[@class='link-title'])[";
	public String Id2 = "]";

	@FindBy(xpath = "//*[text()='Administration']")
	public WebElement adminstration;

	public String admin1 = "//*[@class='aui-list-truncate']//a[text()='";
	public String admin2 = "']";

	@FindBy(xpath = "//a[text()='Custom fields']")
	public WebElement clickoncustomfields;

	@FindBy(xpath = "//a[@id='add_custom_fields']")
	public WebElement addcustomfields;

	public String fieldType1 = "//button[text()='";
	public String fieldType2 = "']";

	public String field1 = "//h3[text()='";
	public String field2 = "']";

	@FindBy(xpath = "//*[@id='custom-field-name']")
	public WebElement customfiledName;

	@FindBy(xpath = "//*[@id='custom-field-description']")
	public WebElement customfiledDescription;

	@FindBy(xpath = "//*[@id='custom-field-options-add']")
	public WebElement addcustomfiledOption;

	@FindBy(xpath = "//*[@id='custom-field-options-input']")
	public WebElement customfiledoption;

	//@FindBy(xpath = "//input[@id='issuetype-field']")
	@FindBy(xpath = "//button[text()='Create']")
	public WebElement clickOnCreate;

	@FindBy(xpath = "//button[contains(.,'Next')]")
	public WebElement clickonNext;

	public String screen1 = "//td[text()='";
	public String screen2 = "']//following::input[2]";

	@FindBy(xpath = "//*[@id='view_custom_fields']")
	public WebElement customfield;

	@FindBy(xpath = "//*[@id='add_custom_fields']")
	public WebElement addcustomfield;

	@FindBy(xpath = "//*[@id='field_screens']")
	public WebElement screen;

	@FindBy(xpath = "//*[@id='add-field-screen']")
	public WebElement addScreen;

	@FindBy(xpath = "//*[@name='fieldScreenName']")
	public WebElement name;

	@FindBy(xpath = "//*[@name='fieldScreenDescription']")
	public WebElement description;

	@FindBy(xpath = "//*[@name='Add']")
	public WebElement clickAdd;

	@FindBy(xpath = "//button[@id='project-config-tab-actions']")
	public WebElement actionIcon;

	@FindBy(xpath = "//a[text()='Edit permissions']")
	public WebElement editIcon;

	public String projPermission1 = "//*[text()='";
	public String projPermission2 = "']/../..//*[text()='";
	public String projPermission3 = "']";

	@FindBy(xpath = "//button[@class='aui-button aui-button-primary']/..//button[text()='Remove']")
	public WebElement removeProjPermission;

	public String grantPermission1 = "//label[text()='";
	public String grantPermission2 = "']";

	@FindBy(xpath = "//button[text()='Grant']")
	public WebElement grantPermission;

	@FindBy(xpath = "//*[@id='home_link']")
	public WebElement dashBoard;

	@FindBy(xpath = "//*[@id='dash_lnk_system_lnk']")
	public WebElement viewSystemDashboard;

	@FindBy(xpath = "//*[@id='webhooks-admin']")
	public WebElement webhook;

	@FindBy(xpath = "//*[@id='webhook-url-display']")
	public WebElement webhookUrl;
	
	
	
	
	
//	Added
	 @FindBy(xpath="//*[@name='os_username']")
	  public WebElement externalJiraUname;
	 
	 @FindBy(xpath="//*[@name='os_password']")
	  public WebElement externalJiraPwd;
	 
	 @FindBy(xpath="//*[@name='login']")
	  public WebElement externalJiraLogin;
	 
	 @FindBy(xpath="//*[@id='browse_link']")
	  public WebElement project11;
	 
	//For Selecting Project
	 protected String extJiraProject1="(//*[text()='";
	 protected String extJiraProject2="'])[1]";
	 
	 @FindBy(id="priority-val")
	  public WebElement priorityInJira;
	 public String statusInExternalJira1="//a//span[text()='";
	 public String statusInExternalJira2="']";
	 
	 
///////////04/06/18////////////by srikanth
public String filterName1="//a[@title='";
public String filterName2="']";

public String filterOption="']/..//a[@class='filter-actions']";


public String filterValue1="//a[text()='";
public String filterValue2="']";

@FindBy(xpath = "//a[@title='Search for issues and view recent issues']")
public WebElement jiraIssue;

@FindBy(xpath = "//a[text()='Search for issues']")
public WebElement searchForIssues;
	 
@FindBy(xpath="//*[@name='webSudoPassword']")
public WebElement authenticationJiraPwd;	

//Option VersionValue,component
protected String option1="//a[contains(.,'";
protected String option2="')]/../../..//td[@class='dynamic-table__actions']/div/a";

//ComponentEdit
@FindBy(xpath="//span[@title='Components']")
public WebElement componentTab;	

//@FindBy(xpath="//div[@aria-hidden='false']//*[@class='component-edit-dialog editcomponent_link']")
//public WebElement edit_Option;

@FindBy(xpath="//input[@id='component-name']")
public WebElement componentField;

//@FindBy(xpath="//input[@id='component-name']")
//public WebElement componentSave;

//priorityEdit
@FindBy(xpath="//a[@id='priorities']")
public WebElement priorityTab;

@FindBy(xpath="//input[@name='name']")
public WebElement priorityName;

@FindBy(xpath="//input[@id='update_submit']")
public WebElement prioritySubmit;


//Version Edit

@FindBy(xpath="//a[@id='administer_project_versions']")
public WebElement versionTab;

//@FindBy(xpath="//div[@aria-hidden='false']//*[@class='version-edit-dialog']")
//public WebElement versionEdit;

@FindBy(xpath="//input[@id='version-name']")
public WebElement versionName;

@FindBy(xpath="//input[@value='Save']")
public WebElement versionSave;


//public String customOption1="//strong[contains(.,'";
//public String customOption2="')]/../../td[@class='cell-type-actions']/button";
//
//public String customOptionValue1="//div[@aria-hidden='false']//a[text()=";
//public String customOptionValue2="']";


//customFieldedit
public String settings1 = "//strong[text()='";
public String settings2 = "']/../..//span[@class='aui-icon aui-icon-small aui-iconfont-configure']";

//clickOnEdit-CustomField,Version,component
public String configuration1 = "//*[@aria-hidden='false']//a[text()='";
public String configuration2 = "']";

@FindBy(xpath="//a[@id='view_custom_fields']")
public WebElement customFieldTab;


@FindBy(xpath="//a[@title='Edit Options']")
public WebElement editOptions;

public String priority1="//b[contains(.,'";
public String priority2="')]/../..//ul/li/a[text()='";
public String priority3="']";

@FindBy(xpath="//input[@name='name']")
public WebElement customValueName;
@FindBy(xpath="//input[@name='value']")
public WebElement custom_Value_Name;



@FindBy(xpath="//input[@id='Update']")
public WebElement customSubmit;


@FindBy(xpath="//a[@title='View recent projects and browse a list of projects']")
public WebElement projectDropDown;

//public String projectValue1="//*[text()='";
//public String projectValue2="']";

public String projectValue1="//a[contains(.,'";//updated 14/08/18
public String projectValue2="')]";

public String editIssue1 = "//strong[contains(.,'";
public String editIssue2="')]/../..//ul/li/a[text()='";
public String editIssue3="']";


//customFieldedit
	 public String customSettings1 = "//strong[contains(.,'";
	 public String customSettings2 = "')]/../..//span[@class='aui-icon aui-icon-small aui-iconfont-configure']";
	 
	 public String customFieldValue1="//strong[text()='";
	 public String customFieldValue2="']";
	 
	 public String customField1="//label[@title='";
	 public String customField2="']";
	 
	 //////created on 15/06/18//////by srikanth
	 @FindBy(xpath="//input[@placeholder='Contains text...']")
	 public WebElement projectSearchField;
	 
	 @FindBy(xpath="//span[@class='aui-avatar aui-avatar-small aui-avatar-project jira-system-avatar']")
	 public WebElement selectJiraProject;
	 
	 @FindBy(xpath="//a[@data-tooltip='Project settings']")
	 public WebElement projectSettings;
	 
	 @FindBy(xpath="//a[@id='edit_project']")
	 public WebElement detailTab;

	 @FindBy(xpath="//input[@id='project-edit-submit']")
	 public WebElement detailSubmit;
	 
	 @FindBy(xpath="//input[@name='Delete']")
	 public WebElement confirmDelete;
	 
	 @FindBy(xpath="//input[@name='addValue']")
	 public WebElement addCustomValue;
	 
	 @FindBy(xpath="//input[@id='add_submit']")
	 public WebElement addCustomSubmitButton;
	 
	 
	 public String parentValue1="//b[text()='";
	 public String parentValue2="']";
	 
	 //Jira User Creation
	 @FindBy(id="user-create-email")
	 public WebElement jiraCreateEmail;
	 
	 @FindBy(id="user-create-fullname")
	 public WebElement jiraCreateFullName;
	 
	 @FindBy(id="user-create-username")
	 public WebElement jiraCreateUser;
	 
	 @FindBy(id="password")
	 public WebElement jiraCreatePassword;
	 
	 @FindBy(xpath="//input[@value='jira-software']")
	 public WebElement jiraSoftwareCheckbox;
	 
	 @FindBy(id="user-create-submit")
	 public WebElement CreateUserButton;
	 
	 
	 //Create Project
	 @FindBy(id="browse_link")
	 public WebElement projectHeader;
	
	 @FindBy(id="project_template_create_link_lnk")
	 public WebElement createProjectOption;
	 
	 protected String projectType1="//div[@title='";
	 protected String projectType2="']";
	 
 
	 @FindBy(xpath ="//button[text()='Next']")
	public WebElement nextButton;
	 @FindBy(xpath ="//button[text()='Select']")
	public WebElement selectButton;
	 
	 @FindBy(xpath ="//input[@name='name']")
		public WebElement projectName;
	 
	 @FindBy(xpath ="//input[@id='lead-field']")
		public WebElement leadSelection;
	 @FindBy(xpath ="//button[text()='Submit']")
		public WebElement submitButton;
	
	 
	 
	 @FindBy(xpath="//a[@id='project-config-permissions']")
	  public WebElement projectConfigPermission;
	  
	  @FindBy(xpath="//span[@class='aui-icon aui-icon-small aui-iconfont-configure icon-default']")
	  public WebElement configActionsIcon;
	  
	  @FindBy(xpath="//*[@id='schemeIds_select']")
	  public WebElement defectPermissionDropdown;
	  
	  @FindBy(xpath="//input[@name='Associate']")
	  public WebElement defectSubmit;
	  
	  public String customFieldValueDelete1="//tr/td[2]//b[text()='";
		 public String customFieldValueDelete2="']/../..//ul[@class='operations-list']/..//li/a[text()='Delete']";

			@FindBy(xpath="//input[@id='delete_submit']")
			public WebElement ClickonDeleteCustomValue;
			
			@FindBy(xpath="//span[@class='aui-icon icon-close']")
			public WebElement clickOnCancelPopUnWindow;
			
			 @FindBy(xpath = "//a[text()='Field configurations']")
				public WebElement fieldsConfiguration;
				
				@FindBy(xpath = "//a[text()='Default Field Configuration']")
				public WebElement defaultFieldConfiguration;
				
				  public String elementMove1="//td//b[text()='";
			        public String elementMove2="']/../../td[4]/input";
			        
			        @FindBy(xpath = "//input[@name='moveOptionsToPosition']")
				     public WebElement clickOnMove;
				     
			        @FindBy(xpath="//*[@id='delete_submit']")
					 public WebElement deleteOptionValue;

			        @FindBy(xpath="//span[@class='aui-icon icon-close']")
				   	 public WebElement close;
			        
			        @FindBy(xpath="//td/a[contains(.,'Edit')]")
			  	  public WebElement userEditButton;
			  	  
			  	  @FindBy(xpath="//input[@id='user-edit-username']")
			  	  public WebElement editUname;
			  	  
			  	  @FindBy(xpath="//input[@id='user-edit-fullName']")
			  	  public WebElement editFullName;
			  	  
			  	  @FindBy(xpath="//input[@id='user-edit-email']")
			  	  public WebElement editEmail;
			  	  
			  	  @FindBy(xpath="//input[@id='user-edit-active']")
			  	  public WebElement userActiveOption;
			  	  
			  	  @FindBy(xpath="//input[@name='Update']")
			  	  public WebElement updateButton;
			  	  
			  	
			  	 @FindBy(xpath="//input[@id='user-filter-userSearchFilter']")
				  public WebElement searchUser;
				  
				  @FindBy(xpath="//input[@id='user-filter-submit']")
				  public WebElement filterButton;
				  
				  @FindBy(xpath="//*[@id='user_browser_table']/tbody/tr[1]/td[2]/div/span")
				  public WebElement validateUser;
				  
				  
				  @FindBy(xpath = "//span[text()='Issues']")
					public WebElement clickOnIssues;
				
	 
				//Jira User Creation
				  @FindBy(id="create_user")
				  public WebElement jiraCreateUserButton;
				 
				  
				  @FindBy(id="user-create-submit")
				  public WebElement CreateUserSubmitButton;
				  
				  
				  //Join Users to Administrators group
				  @FindBy(xpath="//td/a[contains(.,'Actions')]")
				  public WebElement userActionButton;
				  
				  @FindBy(xpath="//a[@class='trigger-dialog editgroups_link']")
				  public WebElement editUserGroups;
				  
				  @FindBy(xpath="//*[@id='groupsToJoin-textarea']")
				  public WebElement groupsToJoinArea;
				  
				  @FindBy(xpath="//input[@name='join']")
				  public WebElement joinAdministratorsGroup;
				
				  @FindBy(xpath="//a[@id='user-edit-groups-cancel']")
				  public WebElement cancelUserGroupsButton;
				  
				//Creating version and Component
				  public String checkVersion1="//a[text()='";
				  public String checkVersion2="']";
				  
				  @FindBy(xpath="//input[@name='name']")
				  public WebElement version_Name;
				  
				  @FindBy(xpath="//input[@name='description']")
				  public WebElement version_Desc;
				 
				  @FindBy(xpath="//button[text()='Add']")
				  public WebElement addButton;
				  
				  
				  
				  @FindBy(xpath="//a[text()='Add a version']")
				  public WebElement projectVersionConfig;
				  
				  @FindBy(id="assigneeType-field")
				  public WebElement assigneeVersion;

}
