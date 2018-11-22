package com.zephyr.reusablemethods;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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

import com.zephyr.common.AutomationConstants;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.ExternalJiraPage_POM;

public class ExternalJiraPage{


	WebDriver driver;
	BasePage bp;
	public Logger log;
	
	public ExternalJiraPage(WebDriver driver)
	{
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);

		
	}
	
	//////////////////////POM//////////////////////////
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
	
	public boolean createFilter(String searchTextValue,String filterNameValue) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.explicitWait(viewAllIssuesAndFilters);
			viewAllIssuesAndFilters.click();
			
			
			 bp.eraseText(searchText);
		     searchText.sendKeys(searchTextValue);
		     
		     bp.explicitWait(saveAs);
		     saveAs.click();
		     
		     bp.explicitWait(filterName);
		     filterName.sendKeys(filterNameValue);
		     submitFilter.click();
			
		     //validation
		     
		     String validateFilterName=validateFilter.getText();
		    if(filterNameValue.equals(validateFilterName))
		    {
		    	System.out.println("New Filter Created sucessfully");
		    }
		     return true;
		     
		}
		     catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Filter is not created");
					throw e;
				}
			
			
	}
		
		public boolean editRequirementDetailInJira(String summaryValue,String labelValue,String priority,String linkedIssueValue,String commentValue) throws Exception
		{
			try
			{
				editOption.click();
				
				bp.eraseText(summaryText);
				summaryText.sendKeys(summaryValue);
				
				bp.eraseText(labelText);
				labelText.sendKeys(labelValue);
				
				priorityField.click();
				
				
				Select sel=new Select(linkedIssue);
				sel.selectByVisibleText(linkedIssueValue);
				
				bp.eraseText(commentField);
				commentField.sendKeys(commentValue);
				
				update.click();
				
			     return true;
			     
			}
			     catch(Exception e)
					{
						e.printStackTrace();
						log.info("Filter is not created");
						throw e;
					}
				
				
			
	
		
		
	}
		
		
		
		public boolean validateLinkInExternalJira(String testCaseNo) throws Exception
		{
			try
			{
				bp=new BasePage();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,10000)");
				
				try
				{
			 	if (moreLinks.isDisplayed())
			 	{
			 		moreLinks.click();
			 	}
				}
				catch(NoSuchElementException e)
				{
					System.out.println("More link defect option is not required");
				}
				
			
			try
			{
			String heading=linkIssueHeading.getText();
			}
			catch(NoSuchElementException e)
			{
				//e.printStackTrace();
				log.info("No Link Issue present for requirement");
				//throw e;
			}
		

			
			int s=linkSize.size();
			System.out.println(s);
			
			  for(int i=0;i<=allLinkIssue.size()-1;i++)
			    {
			    	if(testCaseNo.equals(allLinkIssue.get(i).getText()))
			    	{
			    		System.out.println(allLinkIssue.get(i).getText());
			    		
			    		System.out.println("Link is present in external Jira");
			    	}
		
		          }
			  
			  return true;
			}

	        catch(NoSuchElementException e)
			{
				e.printStackTrace();
				log.info("No Link present for In Jira");
				throw e;
			}
		
}
		
		
//**************************************Abilash**********************************************		
		public boolean DeleteDefectInJira() throws Exception	
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			WebDriverWait wait=new 	WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(More));
			bp.waitForElement();
			More.click();
			bp.waitForElement();
			Actions act=new Actions(driver);
			act.moveToElement(delete1).click().build().perform();
			//bp.waitForElement();
			//wait.until(ExpectedConditions.visibilityOf(delete1));
			//delete1.click();
			bp.waitForElement();
			//wait.until(ExpectedConditions.elementToBeClickable(delete2));
			delete2.click();
			System.out.println("Defect successfully deleted in JIRA");
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
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			return true;
		}
		
		
        public boolean MoveDefectToOtherProject(String newProject) throws Exception	{
        	try
        	{
        		bp=new BasePage();
        		bp.waitForElement();
    			WebDriverWait wait=new 	WebDriverWait(driver,20);
    			wait.until(ExpectedConditions.elementToBeClickable(More));
    			bp.waitForElement();
    			More.click();
    			wait.until(ExpectedConditions.elementToBeClickable(Move));
    			bp.waitForElement();
    			Move.click();
    			wait.until(ExpectedConditions.elementToBeClickable(Icon));
    			bp.waitForElement();
    			Icon.click();
    			bp.waitForElement();
    			Icon.clear();
    			bp.waitForElement();
    			Icon.sendKeys(newProject,Keys.ENTER);
    			bp.waitForElement();
    			wait.until(ExpectedConditions.elementToBeClickable(Next));
    			Next.click();
    			bp.waitForElement();
    			Next.click();
    			bp.waitForElement();
    			wait.until(ExpectedConditions.elementToBeClickable(NextF));
    			NextF.click();
    			for(int i=1;i<=4;i++)
    			{
    				bp.waitForElement();
    			}
    			
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        		throw e;
        	}
			return true;
        	
        }
        
        
      public boolean ValidateMoveDefectToOtherProject(String newProject) throws Exception 
      {
    	  try
    	  {
    		WebElement project=driver.findElement(By.xpath(project1+newProject+project2));
  			String Project=project.getText();
  			if(Project.equals(newProject))
  			{
  			System.out.println("Defect moved to"+ newProject +"Succesfully");	
  			}
  			else
  			{
  				System.out.println("Defect moved to"+ newProject +"Unsuccessfull");	
  			}  
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  e.printStackTrace();
    		  throw e;
    	  }
    	return true;  
      }
     
      
      
      
public boolean editJiraSummaryDetails(String summary,String[] labels,String[] priority,String[] linkedIssue,String[] LinkedIssuesArea,String[] jiraAssignee,String editJiraContent) throws Exception
      {
       try
       {
       bp=new BasePage();
       bp.waitForElement();
       editJira.click();
       System.out.println("Pass-Successfully clicked on Edit Field");
       if(summary!="")
    {
      bp.eraseText(enterJiraSummary);
      Actions a1=new Actions(driver);
         a1.sendKeys(summary).sendKeys(Keys.TAB).perform();
    }
     bp.waitForElement();
    if(labels[0]!="")
    {
     bp.eraseText(enterJiraLabels); 
     Actions a1=new Actions(driver);
      a1.sendKeys(labels).sendKeys(Keys.TAB).perform();
      //a1.moveToElement(enterJiraLabels).click().pause(2000).sendKeys(labels).sendKeys(Keys.TAB).perform();
    }
    bp.waitForElement();
    if(priority[0]!="")
    {
     bp.eraseText(enterJiraPriority); 
     Actions a1=new Actions(driver);
     a1.sendKeys(priority).sendKeys(Keys.TAB).perform();
     //a1.moveToElement(enterJiraPriority).click().pause(2000).sendKeys(priority).sendKeys(Keys.TAB).perform();
    }
    bp.waitForElement();
    if(linkedIssue[0]!="")
    {
      Actions a1=new Actions(driver);
      a1.moveToElement(enterJiraLinkedIssues).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
    }
    bp.waitForElement();
    if(LinkedIssuesArea[0]!="")
    {
     bp.eraseText(enterJiraLinkedIssuesArea);
      Actions a1=new Actions(driver);
      //a1.moveToElement(enterJiraLinkedIssuesArea).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
         a1.sendKeys(LinkedIssuesArea).sendKeys(Keys.TAB).perform();
    }
    bp.waitForElement();
    if(jiraAssignee[0]!="")
    {
     bp.eraseText(enterJiraAssignee);
      Actions a1=new Actions(driver);
      //a1.moveToElement(enterJiraAssignee).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
         a1.sendKeys(jiraAssignee).sendKeys(Keys.TAB).perform();
    }
    bp.waitForElement();
    if(editJiraContent!="")
    {
     bp.eraseText(enterJiraEditContent);
      Actions a1=new Actions(driver);
      //a1.moveToElement(enterJiraEditContent).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
         a1.sendKeys(editJiraContent).sendKeys(Keys.TAB).perform();
    }
    driver.findElement(By.xpath(enterJiraEditUpdate)).click();
    bp.waitForElement();
    
    
    //validation
    bp.waitForElement();
    String summaryVal=summaryValue.getText();
    String priorityVal=priorityValue.getText();
    String labelsVal=labelsValue.getText();
    
    if((summaryVal.equals(summary))||(priorityVal.equals(priority))|| (labelsVal.equals(labels)))
    {
     System.out.println("Pass- Summary Value and Priority Value and Labels Value is Added Succssfully");
    }
    else
    {
    	System.out.println("Summary Value  or Priority Value or Labels Value is not Added"); 
    }
   
       return true;
       }
       catch(Exception e)
    {
     e.printStackTrace();
     throw e;
    }
      }   
      
      
public boolean logOutFromExternal_JIRA() throws Exception
{
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
	bp.waitForElement();
//	bp.waitForElement();
//	bp.waitForElement();
//	bp.waitForElement();
//	bp.waitForElement();
//	bp.waitForElement();
  WebDriverWait wait=new WebDriverWait(driver,20);	
  wait.until(ExpectedConditions.elementToBeClickable(logOutOption));
  logOutOption.click();
  bp.waitForElement();
  wait.until(ExpectedConditions.elementToBeClickable(LogOut));
  LogOut.click();
  
	return true;
	}
	 catch(Exception e)
	{
	e.printStackTrace();
	throw e;
	}
	
	
}

public boolean ClickOnLogIn()
{
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(LogIn));
	LogIn.click();
	return true;
}

public boolean editJiraSummaryDetails(String summary,String [] labels,String priority,String linkedIssue,String LinkedIssuesArea,String jiraAssignee,String editJiraContent) throws Exception
{
 try
 {
 bp=new BasePage();
 bp.waitForElement();
 editJira.click();
 System.out.println("Pass-Successfully clicked on Edit Field");
 if(summary!="")
{
bp.eraseText(enterJiraSummary);
Actions a1=new Actions(driver);
   a1.sendKeys(summary).sendKeys(Keys.TAB).perform();
}
bp.waitForElement();
if(labels[0]!="")
{
bp.eraseText(enterJiraLabels); 
Actions a1=new Actions(driver);
a1.sendKeys(labels).sendKeys(Keys.TAB).perform();
//a1.moveToElement(enterJiraLabels).click().pause(2000).sendKeys(labels).sendKeys(Keys.TAB).perform();
}
bp.waitForElement();
if(priority!="")
{
bp.explicitWait(enterJiraPriority)	;
enterJiraPriority.click();
bp.waitForElement();
enterJiraPriority.clear();
bp.waitForElement();
Actions a1=new Actions(driver);
a1.sendKeys(priority).sendKeys(Keys.TAB).perform();
//a1.moveToElement(enterJiraPriority).click().pause(2000).sendKeys(priority).sendKeys(Keys.TAB).perform();
}
bp.waitForElement();
if(linkedIssue!="")
{
Actions a1=new Actions(driver);
a1.moveToElement(enterJiraLinkedIssues).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
}
bp.waitForElement();
if(LinkedIssuesArea!="")
{
bp.eraseText(enterJiraLinkedIssuesArea);
Actions a1=new Actions(driver);
//a1.moveToElement(enterJiraLinkedIssuesArea).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
   a1.sendKeys(LinkedIssuesArea).sendKeys(Keys.TAB).perform();
}
bp.waitForElement();
if(jiraAssignee!="")
{
bp.eraseText(enterJiraAssignee);
Actions a1=new Actions(driver);
//a1.moveToElement(enterJiraAssignee).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
   a1.sendKeys(jiraAssignee).sendKeys(Keys.TAB).perform();
}
bp.waitForElement();
if(editJiraContent!="")
{
bp.eraseText(enterJiraEditContent);
Actions a1=new Actions(driver);
//a1.moveToElement(enterJiraEditContent).click().pause(2000).sendKeys(linkedIssue).sendKeys(Keys.TAB).perform();
   a1.sendKeys(editJiraContent).sendKeys(Keys.TAB).perform();
}
bp.waitForElement();
driver.findElement(By.xpath(enterJiraEditUpdate)).click();
bp.waitForElement();


//validation
bp.waitForElement();
String summaryVal=summaryValue.getText();
String priorityVal=priorityValue.getText();
String labelsVal=labelsValue.getText();

if((summaryVal.equals(summary))||(priorityVal.equals(priority))|| (labelsVal.equals(labels)))
{
System.out.println("Pass- Summary Value and Priority Value and Labels Value is Added Succssfully");
}
else
{
	System.out.println("Summary Value  or Priority Value or Labels Value is not Added"); 
}

 return true;
 }
 catch(Exception e)
{
e.printStackTrace();
throw e;
}
}
 
public boolean clickOnTestCaseIdInJira(String testCaseId) throws Exception
{
	try
	{
	bp=new BasePage();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
//	int s=linkSize.size();
//	System.out.println(s);
	  bp.waitForElement();
	   bp.waitForElement();
	  	driver.navigate().refresh();
	  	 bp.waitForElement();
	
	js.executeScript("window.scrollBy(0,500)");
	try
	{
	if (moreLinks.isDisplayed())
	{
		moreLinks.click();
	}
	}
	catch(NoSuchElementException e)
	{
		System.out.println("More link defect option is not required");
	}
	
	
	
		int s=linkSize.size();
		System.out.println(s);
		
		 bp.waitForElement();
   bp.waitForElement(); 
	
  // Actions v=new Actions(driver);
   
   
	  for(int i=0;i<=allLinkIssueId.size()-1;i++)
	    {
		  String id=allLinkIssueId.get(i).getText();
		  
	    	if(testCaseId.equals(id))
	    	{
	    		System.out.println("tescsase id"+id);
	    	//	v.moveToElement(allLinkIssueId.get(i)).contextClick().sendKeys(Keys.SHIFT,"t").build().perform();
	    		//v.sendKeys(Keys.SHIFT,"t").perform();
	    		allLinkIssueId.get(i).click();
	    		bp.waitForElement();
	    		System.out.println("Link is present in external Jira");
	    	}
         }

	System.out.println("Testcase successfully clicked in External_JIRA");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	return true;
	
}
		

public boolean clickOnTestcaseExecutionJira(String testCaseId) throws Exception
{
	try
	{
	bp=new BasePage();
   JavascriptExecutor js = (JavascriptExecutor) driver;
//	int s=linkSize.size();
//	System.out.println(s);
   bp.waitForElement();
   bp.waitForElement();
  	driver.navigate().refresh();
  	 bp.waitForElement();
	js.executeScript("window.scrollBy(0,5000)");
	try
	{
	if (moreLinks.isDisplayed())
	{
		moreLinks.click();
	}
	}
	catch(NoSuchElementException e)
	{
		System.out.println("More link defect option is not required");
	}
	
	
	int s=linkSize.size();
	System.out.println(s);
	
	 bp.waitForElement();
	 //bp.waitForElement();
	  for(int i=0;i<=allLinkIssueId.size()-1;i++)
	    {
		  String id=allLinkIssueId.get(i).getText();
		  System.out.println("All-"+id);
		  
	    	if(testCaseId.equals(id))
	    	{
	    		System.out.println("tescsase id"+id);
	    	//	v.moveToElement(allLinkIssueId.get(i)).contextClick().perform();
	    	//	v.sendKeys(Keys.SHIFT+"t").perform();
	    		allLinkIssueExe.get(i).click();
	    		bp.waitForElement();
	    		System.out.println("Link is present in external Jira");
	    	}
         }

	System.out.println("Testcase successfully clicked in External_JIRA");
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	return true;
	
}



public boolean verifySearchedExecutionJira(String id) throws Exception
{
try
{
 
      String validateId= driver.findElement(By.xpath("//*[@id='grid-table-tce_search']/div[2]/div/div[2]/div/div")).getText();
       

       if(id.equals(validateId))
       {
        
      System.out.println("Successfully matched the serached result");  
 

       }

return true;
}
catch(Exception e)
{
 e.printStackTrace();
 throw e;
}
}

public boolean verifyWebhooks(String url) throws Exception
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		WebDriverWait wait=new WebDriverWait(driver,60);
		//WebElement ele=driver.findElement(By.xpath(addGadget1+gadgetName+addGadget2));
		wait.until(ExpectedConditions.visibilityOf(webhook));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",webhook );
//		bp.waitForElement();
		webhook.click();
		bp.waitForElement();
	String webhookText=webhookUrl.getText();
	
	if(url.equals(webhookText))
	{
		System.out.println("Webhook verified Successfully");
	}
	
	return true;
	}
	catch(Exception e)
 	{
 		e.printStackTrace();
 		throw e;
 	}
 	
 	
}



public boolean jiraAdministration(String name) throws Exception
{
	try
	{
		bp=new BasePage();
	    bp.explicitWait(adminstration);
		bp.waitForElement();
		
		if(name!="")
		{
			Actions v1=new Actions(driver);
			v1.pause(1500).moveToElement(adminstration).click().perform();
			bp.waitForElement();
			WebElement sel1=driver.findElement(By.xpath(admin1+name+admin2));
			String dataa=sel1.getText();
			sel1.click();
			bp.waitForElement();
			
			if(name.equals(dataa))
			{
				System.out.println("sucessfully clicked on " +name);
			}
			else
			{
				System.out.println("not clicked on" +name);
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



//********Balraj*******//
public boolean navigateToCustomfields() throws Exception
{
	try
	{
		bp=new BasePage();
		bp.explicitWait(clickoncustomfields);
		clickoncustomfields.click();
		System.out.println("Clicked On Custom Fieds Successfully");
//		bp.explicitWait(addcustomfields);
//		addcustomfields.click();
//		System.out.println("clicked on add custom field successfully");
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}



//********Balraj*******//
	public boolean addCustomFields(String fieldType,String field,String customName,String customDescription,String fieldValue[]) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		driver.findElement(By.xpath(fieldType1+fieldType+fieldType2)).click();
		System.out.println("Pass Clicked on"+fieldType+"Successfully");
		bp.waitForElement();	
		WebElement ele=driver.findElement(By.xpath(field1+field+field2));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",ele );
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		System.out.println("Custom field"+field+"clicked successfully");
		bp.waitForElement();
		clickonNext.click();
		bp.waitForElement();
		bp.explicitWait(customfiledName);
		Actions name=new Actions(driver);
		name.moveToElement(customfiledName).click().sendKeys(customName).pause(1200).sendKeys(Keys.ENTER).build().perform();
		System.out.println("Custom field"+customName+"Entered Successfully");
		Actions desc=new Actions(driver);
		desc.moveToElement(customfiledDescription).click().sendKeys(customDescription).pause(1200).sendKeys(Keys.ENTER).build().perform();
		System.out.println("Custom field description"+customDescription+"Entered Successfully");
		if(field.equals("Checkboxes")||field.equals("Radio Buttons")||field.equals("Select List (multiple choices)")||field.equals("Select List (single choice)"))
		{
			customfiledoption.click();
			System.out.println("Pass clicked on option successfully");
			bp.waitForElement();
			int k=fieldValue.length;
			for(int i=0;i<=k-1;i++)
			{
			customfiledoption.sendKeys(fieldValue[i]);
			System.out.println("Custom Field Option Value"+fieldValue[i]+"Passed Successfully");
			bp.waitForElement();
			addcustomfiledOption.click();
			System.out.println("Custom Field Option Value"+fieldValue[i]+"Entered Successfully");
			bp.waitForElement();
			log.info("Custom Field Options Added Successfully");
			}

		}
		bp.waitForElement();
		clickOnCreate.click();
		System.out.println("Custom field created successfully");
			
//		bp.explicitWait(clickonpassword);
//		Actions act1=new Actions(driver);
//		act1.moveToElement(clickonpassword).click().sendKeys("password").pause(1200).sendKeys(Keys.ENTER).build().perform();
//		clickonsubmit.click();
	return true;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	
	}
}

	//********Balraj*******//
	public boolean updateCreatedCustomField(String screen) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(screen1+screen+screen2));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",ele );
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		System.out.println("Clicked on"+screen+"Successfully");
		WebElement ele1=driver.findElement(By.xpath("//*[@id='update_submit']"));
		js.executeScript("arguments[0].scrollIntoView(true);",ele1 );
		WebDriverWait wait1=new WebDriverWait(driver,60);
		wait1.until(ExpectedConditions.visibilityOf(ele1));
		ele1.click();
		System.out.println("Clicked on Update Successfully");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public boolean clickOnAddCustomFieldSymbol() throws Exception{
		try
		{
		bp=new BasePage();
		customfield.click();
		System.out.println("Pass - Successfully clicked on Customfield option");
		bp.waitForElement();
		addcustomfield.click();
		System.out.println("Pass - Successfully clicked on AddCustomField option");
		return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		throw e;
		}
		
	}
	
	
	public boolean addScreen(String screenName,String screenDesc) throws Exception{
		 try
		 {
			bp=new BasePage();
			bp.waitForElement();
			screen.click();
			System.out.println("Pass-Successfully clicked on Screen option");
			bp.waitForElement();
			addScreen.click();
			System.out.println("Pass-Successfully clicked on AddScreen option");
			name.clear();
			name.sendKeys(screenName);
			description.clear();
			description.sendKeys(screenDesc);
			clickAdd.click();
			System.out.println("Pass-ScreenName and Description are entered successfully");
			return true;
		 }	
		 catch(Exception e)
		 {
			e.printStackTrace();
			throw e;
		 }
		}
		
		
		public boolean defectProjectPermission(String projectValue1,String projectValue2,String projectPermission) throws Exception
		{
			try
			{
			    bp=new BasePage();
			    bp.waitForElement();
			    WebDriverWait wait=new WebDriverWait(driver,60);
				driver.findElement(By.xpath("//a[@data-tooltip='Project settings']")).click();
				bp.waitForElement();
				WebElement ele=driver.findElement(By.xpath("//a[@title='Default scheme for Software projects.']"));
				wait.until(ExpectedConditions.visibilityOf(ele));
				JavascriptExecutor js=((JavascriptExecutor)driver);
				js.executeScript("arguments[0].scrollIntoView(true);",ele );
				ele.click();
				bp.explicitWait(actionIcon);
				actionIcon.click();
				bp.waitForElement();
		        wait.until(ExpectedConditions.elementToBeClickable(editIcon));
		        WebElement ele1=driver.findElement(By.xpath(projPermission1+projectValue1+projPermission2+projectValue2+projPermission3));
		        ele1.click();
		        bp.waitForElement();
		        boolean res=removeProjPermission.isDisplayed();
		        if(res==true)
		        {
		        	removeProjPermission.click();
		        	bp.waitForElement();
		        }
		        WebElement ele2=driver.findElement(By.xpath(grantPermission1+projectPermission+grantPermission1));
		        ele2.click();
		        bp.waitForElement();
		        boolean res1=grantPermission.isDisplayed();
		        if(res1==true)
		        {
		        	grantPermission.click();
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


		
		
		public void dragAndDropOptionList(int source,int destination)
		{
			try
			{
				Actions act=new Actions(driver);
				String src1="//*[@id='custom-field-options-list']/li[";
				String src2="]/div[1]";
						
				String dest1="//*[@id='custom-field-options-list']/li[";
				String dest2="]/div[1]";
				WebElement srcElement=driver.findElement(By.xpath(src1+source+src2));
				WebElement destElement=driver.findElement(By.xpath(dest1+destination+dest2));
	           
	            
	            
				act.dragAndDrop(srcElement, destElement).perform();
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		//Paste IN External Jira
		 public boolean selectProject(String projectName) throws Exception 
			{
				try
				{
				BasePage bp=new BasePage();
				bp.waitForElement();
			
				
				project11.isEnabled();
				project11.isDisplayed();
				bp.waitForElement();
				bp.waitForElement();
				WebDriverWait wait2=new WebDriverWait(driver, 100);
				wait2.until(ExpectedConditions.elementToBeClickable(project11));
				project11.click();
				bp.waitForElement();
				String validate_Project=driver.findElement(By.xpath(extJiraProject1+projectName+extJiraProject2)).getText();
				 
				if(projectName.equals(validate_Project))
				{

					driver.findElement(By.xpath(project1+projectName+project2)).click();
					//log.info("Pass - "+projectName+"Project Is Selected");
					log.info("Pass - '"+projectName+"' Project Is Selected");
					log.info("Pass - You are in '"+projectName+"' now");
				}
				
				else
				{
					log.info("Fail -Project-'"+projectName+"' is not Available");
					
			    }
				  return true;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					throw e;
				}
				
			}
			
		 
		 //Paste In external Jira
	public boolean loginToExternalJira(String username,String password) throws Exception
			
			{
				try
		    	{
			
		    	   bp=new BasePage();
		    	 //bp.waitForElement();
		    	//bp.eraseText(externalJiraUname);
		    	//username.click();
		    	bp.waitForElement();
		    	externalJiraUname.sendKeys(username);
		    	bp.waitForElement();
		    	externalJiraPwd.click();
		    	bp.waitForElement();
		    	externalJiraPwd.sendKeys(password);
		    	bp.waitForElement();
		    	externalJiraLogin.click();
		    	return true;
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    		throw e;
		    	}
		    
			}

	
	
	public boolean enterPriority(String[] priority) throws Exception
	{
	 try
	 {
	 Actions a1=new Actions(driver);
	 bp=new BasePage();
	 bp.waitForElement();
	 priorityInJira.click();
	 //bp.eraseText(priorityInJira);
	// priorityInJira.click();
	 bp.waitForElement();
	 for(int i=0;i<=priority.length-1;i++)
	 {
	      a1.sendKeys(priority[i]).build().perform();
	  // a1.sendKeys(Keys.ENTER).build().perform();
	   
	 }

	 a1.sendKeys(Keys.ENTER).sendKeys(Keys.TAB).build().perform();
	  
	 for (int j=0;j<=5;j++)
 	{
	       bp.waitForElement();
     }
     driver.navigate().refresh();
     bp.waitForElement();
     
     Alert c=driver.switchTo().alert();
     c.accept();
     bp.waitForElement();
  
	 
	 return true;
	   }

	  catch(Exception e)
	{
	 e.printStackTrace();
	 throw e;
	}
	}

	
	
	//Paste In external Jira
	public boolean changeDefectStatusInExternalJira(String statusType) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			
			
		WebElement ele=driver.findElement(By.xpath(statusInExternalJira1+statusType+statusInExternalJira2));
		ele.click();
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
			log.info("Defect button is not clicked");
			throw e;
			
		}
	}
	
	public boolean verifySearchedId(String id) throws Exception
	{
	try
	{
	 
	      String validateId= driver.findElement(By.xpath("//*[@id='grid-table-tcr']/div[2]/div[1]/div[3]/div/div")).getText();
	       

	       if(id.equals(validateId))
	       {
	        
	      System.out.println("Successfully matched the serached result");  
	 

	       }




	return true;
	}
	catch(Exception e)
	{
	 e.printStackTrace();
	 throw e;
	}
	}
	
	
	/* ****************************************************
	   * Method Name   : clickOnManageIssues() 
	  * Purpose    : To perform administration functions
	  * Author     : Srikanth
	  * Date Created   : 04/06/18
	  * Date Modified  :
	  * Reviewed By   : Rajneesh
	  * ******************************************************
	  */
	public boolean clickOnManageIssues() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
	    WebDriverWait wait=new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.elementToBeClickable(jiraIssue));
	    Actions act=new Actions(driver);
	    act.moveToElement(jiraIssue).click().perform();
	    bp.waitForElement();
	    wait.until(ExpectedConditions.elementToBeClickable(searchForIssues));
	    searchForIssues.click();
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
	
	/* ****************************************************
	   * Method Name   : checkAvailableFilters() 
	  * Purpose    : To check the filter
	  * Author     : Srikanth
	  * Date Created   : 04/06/18
	  * Date Modified  :
	  * Reviewed By   : Rajneesh
	  * ******************************************************
	  */
	public boolean checkAvailableFilters(String filterNameValue) throws Exception
	{
	 	
	  try
	  {
	  bp=new BasePage();
	  //WebDriverWait wait=new WebDriverWait(driver,30);
	  try
	  {
	  
	  WebElement ele=driver.findElement(By.xpath(filterName1+filterNameValue+filterName2));
	  boolean res=ele.isDisplayed();
	  if(res==true)
	  {
	  //wait.until(ExpectedConditions.elementToBeClickable(ele));
	  System.out.println("Filter Name" +filterNameValue+ "is present");
	  }
	  bp.waitForElement();
	  return true;
	  }

	  catch(NoSuchElementException el)
	  {
		  System.out.println("Filter Name" +filterNameValue+ "is not present");
		  return false;
	  }
	  }
	  
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	  
	}
	
	/* ****************************************************
	   * Method Name   : editFilter() 
	  * Purpose    : To edit the filter
	  * Author     : Srikanth
	  * Date Created   : 04/06/18
	  * Date Modified  :
	  * Reviewed By   : Rajneesh
	  * ******************************************************
	  */
	public boolean editFilter(String filterNameValue,String filterValue,String newFilterNameValue) throws Exception
	{
	  try
	  {
	  bp=new BasePage();
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  WebElement ele=driver.findElement(By.xpath(filterName1+filterNameValue+filterName2));
	  wait.until(ExpectedConditions.elementToBeClickable(ele));
	  ele.click();
	  bp.waitForElement();
	  System.out.println("Pass -Filter Name" +ele+ " is selected successfully");
	  WebElement ele1=driver.findElement(By.xpath(filterName1+filterNameValue+filterOption));
	  wait.until(ExpectedConditions.elementToBeClickable(ele1));
	  ele1.click();
	  System.out.println("Pass - Clicked on Options");
	  WebElement filterOption=driver.findElement(By.xpath(filterValue1+filterValue+filterValue2));
	  wait.until(ExpectedConditions.elementToBeClickable(filterOption));
	  filterOption.click();
	  System.out.println("Pass -Filter Option" +filterOption+ " is clicked successfully");
	  bp.waitForElement();
	  bp.explicitWait(filterName);
    filterName.sendKeys(newFilterNameValue);
    submitFilter.click();
	  return true;
	  }
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	}
	
	
	/* ****************************************************
	   * Method Name   : launchJiraAdministration() 
	  * Purpose    : To launch Administration
	  * Author     : Srikanth
	  * Date Created   : 04/06/18
	  * Date Modified  :
	  * Reviewed By   : Rajneesh
	  * ******************************************************
	  */
	public boolean launchJiraAdministration(String issueType) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   bp.explicitWait(adminstration);
	   bp.waitForElement();
	   
	   if(issueType!="")
	   {
	    Actions v1=new Actions(driver);
	    v1.pause(1500).moveToElement(adminstration).click().perform();
	    bp.waitForElement();
	    WebElement sel1=driver.findElement(By.xpath(admin1+issueType+admin2));
	    String dataa=sel1.getText();
	    
	    bp.waitForElement();
	   
	    if(issueType.equals(dataa))
	    {
	    	sel1.click();
	     System.out.println("sucessfully clicked on " +issueType);
	    }
	    else
	    {
	     System.out.println("not clicked on" +issueType);
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
	
	
	
	public boolean editComponentValue(String oldValue,String optionValue,String value) throws Exception 
	{
		try
		{ 
			
			bp=new BasePage();
			bp.explicitWait(componentTab);
			componentTab.click();
			bp.waitForElement();
			
			WebElement fieldOption=driver.findElement(By.xpath(option1+oldValue+option2));
			JavascriptExecutor js =((JavascriptExecutor) driver);
		    js.executeScript("arguments[0].scrollIntoView(true);", fieldOption);
		    bp.waitForElement();
		    fieldOption.click();
		    bp.waitForElement();
			WebElement sel1=driver.findElement(By.xpath(configuration1+optionValue+configuration2));
		     sel1.click();
		     bp.waitForElement();
		     
			componentField.sendKeys(value);
			bp.waitForElement();
			versionSave.click();
			bp.waitForElement();
		
			
			return true;
		  }
		  
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }  
	}
	
	
	public boolean editIssueTypeValue(String oldName,String option,String newName) throws Exception 
	{
		try
		{ 
			
			//img[@alt='New Feature_11']/../..//td[@class='cell-type-collapsed']//a[text()='Edit']
			bp=new BasePage();
			
			
			WebElement ele=driver.findElement(By.xpath(editIssue1+oldName+editIssue2+option+editIssue3));
			JavascriptExecutor js =((JavascriptExecutor) driver);
		    js.executeScript("arguments[0].scrollIntoView(true);", ele);
			bp.waitForElement();
			bp.explicitWait(ele);
			ele.click();
			
			bp.waitForElement();
						
			priorityName.sendKeys(newName);
			bp.waitForElement();
			prioritySubmit.click();
			bp.waitForElement();
			
			return true;
		  }
		  
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }  
	}
	
	
	
	
	public boolean editPriorityValue(String oldValue,String optionValue,String newValue) throws Exception 
	{
		try
		{ 
			
			
			bp=new BasePage();
			bp.explicitWait(priorityTab);
			priorityTab.click();
			
			bp.waitForElement();

		    
			WebElement priority_Value=driver.findElement(By.xpath(priority1+oldValue+priority2+optionValue+priority3));
			JavascriptExecutor js =((JavascriptExecutor) driver);
		    js.executeScript("arguments[0].scrollIntoView(true);", priority_Value);
			bp.waitForElement();
			
			priority_Value.click();
			bp.waitForElement();
//			String pwd=Property_Lib.getPropertyValue(AutomationConstants.CONFIG_PATH+AutomationConstants.CONFIG_FILE_TPE, "JIRA_Password");
//			
//			driver.findElement(By.xpath("//*[@id='login-form-authenticatePassword']")).sendKeys(pwd);
		
			
			bp.explicitWait(priorityName);
			priorityName.sendKeys(newValue);
			bp.waitForElement();
			prioritySubmit.click();
			bp.waitForElement();
				
			
			return true;
		  }
		  
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }  
	}
	
	
	public boolean editVersionValue(String oldValue,String optionValue,String newValue) throws Exception 
	{
		try
		{ 
			bp=new BasePage();
			bp.explicitWait(versionTab);
			versionTab.click();
			
			bp.waitForElement();
			
			driver.findElement(By.xpath(option1+oldValue+option2)).click();
			bp.waitForElement();
			
			WebElement sel1=driver.findElement(By.xpath(configuration1+optionValue+configuration2));
		     sel1.click();
		     bp.waitForElement();
//			versionEdit.click();
//			bp.waitForElement();
			
			versionName.sendKeys(newValue);
			bp.waitForElement();
			versionSave.click();
			bp.waitForElement();
			return true;
		  }
		  
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }  
	}
	
	
	
	public boolean editCustomFields(String customFieldName,String configuration) throws Exception
	  {
	   try
	   {
	    bp=new BasePage();
	    WebElement ele=driver.findElement(By.xpath(settings1+customFieldName+settings2));
	    bp.explicitWait(ele);
	    JavascriptExecutor js =((JavascriptExecutor) driver);
	    js.executeScript("arguments[0].scrollIntoView(true);", ele);
		bp.waitForElement();
	    
	    Actions v1=new Actions(driver);
	    v1.pause(1500).moveToElement(ele).click().perform();
	    if(configuration!="")
	    {

	     bp.waitForElement();
	     WebElement sel1=driver.findElement(By.xpath(configuration1+configuration+configuration2));
	     String data=sel1.getText();
	     sel1.click();
	     bp.waitForElement();
	     
	     if(configuration.equals(data))
	     {
	      System.out.println("sucessfully clicked on " +configuration);
	     }
	     else
	     {
	      System.out.println("not clicked on" +configuration);
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
	
	public boolean editCustomValue(String oldValue,String optionValue,String newValue) throws Exception 
	{
		try
		{ 
			bp=new BasePage();

			bp.waitForElement();
			editOptions.click();
			
			bp.waitForElement();
			WebElement fieldOptionValue=driver.findElement(By.xpath(priority1+oldValue+priority2+optionValue+priority3));
			fieldOptionValue.click();
			bp.waitForElement();
			custom_Value_Name.sendKeys(newValue);
			bp.waitForElement();
			customSubmit.click();
			bp.waitForElement();
			
				
			
			return true;
		  }
		  
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }  
	}
	

	public boolean defectProjectSettings(String projectName) throws Exception
	{
		try
		{
		    bp=new BasePage();
		    bp.waitForElement();
		    WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
			bp.waitForElement();
			bp.explicitWait(projectDropDown);
			projectDropDown.click();
			bp.waitForElement();
			WebElement projName=driver.findElement(By.xpath(projectValue1+projectName+projectValue2));
			wait.until(ExpectedConditions.elementToBeClickable(projName));
			projName.click();
			System.out.println("Pass-projectName" +projectName+ "is selected successfully");
			bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath("//a[@data-tooltip='Project settings']"));;
			wait.until(ExpectedConditions.visibilityOf(ele));
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scrollIntoView(true);",ele );
			ele.click();
			System.out.println("Pass-" +ele+ "is clicked successfully");
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

	
	public boolean validateEditedDefectValue(String defectValue) throws Exception
	{
	try
	{
	    bp=new BasePage();
		Actions a1=new Actions(driver);
		bp.waitForElement();
		bp.waitForElement();
		WebElement value=driver.findElement(By.xpath(projectValue1+defectValue+projectValue2));
		a1.moveToElement(value).pause(1200).perform();
	    String text=value.getText();
	    if(text.equals(defectValue))
	    {
	    	System.out.println("Pass-Edited DefectValue" +defectValue+ " is validated Successfully" );
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
	
	
	public boolean enterAdministratorAccessPassword(String Pwd) throws Exception
	{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		ExternalJiraPage ejp=new ExternalJiraPage(driver);
		Actions a1=new Actions(driver);
		a1.moveToElement(ejp.authenticationJiraPwd).sendKeys(Pwd).sendKeys(Keys.ENTER).perform();
	    bp.waitForElement();	
	    return true;	
	}
	catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }  
	}
	
	
	
	public boolean editCustomFieldValue(String customFieldName,String configuration) throws Exception
	  {
	   try
	   {
	    bp=new BasePage();
	    WebElement ele=driver.findElement(By.xpath(customSettings1+customFieldName+customSettings2));
	    bp.explicitWait(ele);
	    JavascriptExecutor js =((JavascriptExecutor) driver);
	    js.executeScript("arguments[0].scrollIntoView(true);", ele);
		bp.waitForElement();
	    
	    Actions v1=new Actions(driver);
	    v1.pause(1500).moveToElement(ele).click().perform();
	    if(configuration!="")
	    {

	     bp.waitForElement();
	     
	     WebElement sel1=driver.findElement(By.xpath(configuration1+configuration+configuration2));
	     String data=sel1.getText();
	     sel1.click();
	     bp.waitForElement();
	     //String data=sel1.getText();//
	     bp.waitForElement();
	     if(configuration.equals(data))
	     {
	      System.out.println("sucessfully clicked on " +configuration);
	     }
	     else
	     {
	      System.out.println("not clicked on" +configuration);
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
	 
	 public boolean checkAvailableCustomFields(String customFieldName) throws Exception
	 {
	  try
	  {
	  try
	  {
		  WebElement ele=driver.findElement(By.xpath(customFieldValue1+customFieldName+customFieldValue2));
		  String customValue=ele.getText();
	   if(customValue.equals(customFieldName))
	    {
		  System.out.println(customFieldName+"- already present in project");
	    }
	  
	    }
	   
	    catch(NoSuchElementException e)
		{
			System.out.println(customFieldName+" is not present");
			return false;
		}
	  
	  return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	 
	 public boolean editCustomFieldName(String newName) throws Exception
	 {
	  
	  try
	  {
	   bp=new BasePage();
	   bp.explicitWait(customValueName);
	   customValueName.sendKeys(newName);
	   bp.waitForElement();
	   bp.explicitWait(prioritySubmit);
	   prioritySubmit.click();
	   bp.waitForElement();
	   
	  return true;
	   }
	   
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }  
	 }
	 
	 
	 public void  verifyCustomFieldInFileNewDefectPage(String customFieldName) throws Exception, UserDefinedException
	 {
	  try
	  {

	  
	  WebElement ele=driver.findElement(By.xpath(customField1+customFieldName+customField2));
	  bp.explicitWait(ele);
	  boolean res=ele.isDisplayed();
	  if(res==true)
	  {
	   throw new UserDefinedException("Custom field is present in File new Defect Page");
	  }
	   
	  }
	  catch(NoSuchElementException e)
	  {
	   System.out.println("Custom field is not present");
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	 
	 
	 public void verifyPresentCustomFieldInFileNewDefectPage(String customFieldName) throws Exception
	  
	 {
	  try
	  {
	  
	  
	  WebElement ele=driver.findElement(By.xpath(customField1+customFieldName+customField2));
	  bp.explicitWait(ele);
	  boolean res=ele.isDisplayed();
	  if(res==true)
	  {
	        System.out.println("Custom field is present in File New Defect Page");   
	  }
	   
	  }
	  
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	
	 
	 public boolean selectExternalJiraProject(String projectName) throws Exception
		{
			try
			{
			    bp=new BasePage();
			    bp.waitForElement();
			    WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
				bp.waitForElement();
				bp.explicitWait(projectDropDown);
				projectDropDown.click();
				bp.waitForElement();
				WebElement projName=driver.findElement(By.xpath(projectValue1+projectName+projectValue2));
				wait.until(ExpectedConditions.elementToBeClickable(projName));
				projName.click();
				System.out.println("Pass-projectName" +projectName+ "is selected successfully");
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
	
	 
	 public boolean searchExternalJiraProject(String projectName) throws Exception 
	 {
	  try
	  {
	   bp=new BasePage();
	   WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
	   bp.waitForElement();
	   bp.eraseText(projectSearchField);
	   projectSearchField.click();
	   System.out.println("Pass-Successfully clicked on search area");
	   bp.waitForElement();
	   projectSearchField.sendKeys(projectName);
	   System.out.println("Pass-External Jira projectName" +projectName+ "is entered successfully");
	   bp.waitForElement();
	   selectJiraProject.click();
	   bp.waitForElement();
	   //WebElement ele=driver.findElement(By.xpath("//a[@data-tooltip='Project settings']"));
	   //projectSettings.click();
	   wait.until(ExpectedConditions.visibilityOf(projectSettings));
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",projectSettings );
		projectSettings.click();
		System.out.println("Pass-Successfully clicked on project settings");
		bp.waitForElement();
	  return true;
	   }
	   
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }  
	 }
	 
	 public boolean editProjectDetails(String name) throws Exception 
	 {
	  try
	  {
	   bp=new BasePage();
	   bp.waitForElement();
	   bp.explicitWait(detailTab);
	   detailTab.click();
	   bp.waitForElement();
	   bp.eraseText(customValueName);
	   bp.explicitWait(customValueName);
	   customValueName.sendKeys(name);
	   bp.waitForElement();
	   detailSubmit.click();
	   bp.waitForElement();
	   
	  return true;
	   }
	   
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }  
	 }
	 
	 public boolean validateEditedProjectValue(String projectValue) throws Exception
		{
		try
		{
		    bp=new BasePage();
			Actions a1=new Actions(driver);
			bp.waitForElement();
			a1.moveToElement(customValueName).pause(1200).perform();
		    String text=customValueName.getAttribute("value");
		    if(text.equals(projectValue))
		    {
		    	System.out.println("Pass-Edited Defect ProjectValue " + projectValue + " is validated Successfully" );
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
			
	 
	 
	 
	 public boolean closeNotificationMsg() throws Exception
	 {
		 try
		 {
		 bp=new BasePage();
		String result=driver.findElement(By.xpath("//div[@class='aui-flag']")) .getAttribute("aria-hidden");
		
		if(result.equals("false"))
		{
			
			WebElement ele=driver.findElement(By.xpath("//span[@class='aui-icon icon-close']"));
			bp.moveToElementAndClick(ele);
			bp.waitForElement();
		}
		
		return true;
	 }
	  
		  catch(NoSuchElementException e)
		    {
		    System.out.println("Notification is not present");
		    return true;
		    }  
		 
	    catch(Exception e)
	    {
	     e.printStackTrace();
	     throw e;
	    }  
		}
	 
	 public boolean confirmDeleteCustomField() throws Exception
	 {
	  try
	  {
	  bp=new BasePage();
	  bp.explicitWait(confirmDelete);
	  confirmDelete.click();
	  System.out.println("Pass-Successfully clicked on Delete button");
	  bp.waitForElement();
	  return true;
	   }
	   
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	 }
	 
	 public boolean viewActivityStream() throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	   //WebDriverWait wait1=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
	   bp.waitForElement();
	   dashBoard.click();
	   //driver.findElement(By.xpath("//*[@id='home_link']")).click();
	   bp.waitForElement();
	   viewSystemDashboard.click();
	   WebElement ele=driver.findElement(By.xpath("//*[@class='gadget-iframe']"));
	   bp.switchToFrame(ele);
	 //  bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   bp.waitForElement();
	   //wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='activity-item-summary'])[1]")));
	   Actions a1=new Actions(driver);
	  List<WebElement> eleElement=driver.findElements(By.xpath("(//div[@class='activity-item-summary'])"));
	  a1.moveToElement(eleElement.get(0)).perform();
	  String webhookText=(eleElement.get(0)).getText();
	  System.out.println(webhookText);

	 return true;
	 }
	 catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	  
	 }
	 
	 
	 public boolean addOptionInCustomField(String optionValue) throws Exception
	 {
	 	try
	 	{
	 	bp=new BasePage();
	     bp.waitForElement();
	     
	     addCustomValue.sendKeys(optionValue);
	     System.out.println("New Custom Field Option Name entered Successfully-"+optionValue);
	     bp.waitForElement();
	     
	     addCustomSubmitButton.click();
	     bp.waitForElement();
	 	
	 	return true;
	 }

	 catch(Exception e)
	 {
	  e.printStackTrace();
	  throw e;
	 }  
	 }
	 
	 
	 public boolean checkAvailableCustomFieldOptions(String optionValue) throws Exception
	 {
	  try
	  {
	  bp=new BasePage();
	     bp.waitForElement();
	    WebElement ele=driver.findElement(By.xpath(parentValue1+optionValue+parentValue2));
	  System.out.println("Custom Field Option-"+optionValue+" is present");
	    
	     bp.waitForElement();
	  //ele.click();
	  
	  return true;
	  
	     }
	  catch(NoSuchElementException e)
	  {
	   System.out.println("Custom Field Option is not present");
	   return false;
	  }  
	 catch(Exception e)
	 {
	  e.printStackTrace();
	  throw e;
	 }  
	 }
	 public boolean validatePriority(String priority) throws Exception
		{
			try
			{
				String priorityVal=priorityValue.getText();
				if(priorityVal.equals(priority))
				{
					System.out.println("Priority validated successfully");
			}
			return true;
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		 throw e;
		}
		}
	 
	 
	 public boolean addFieldToScreen(String[] name) throws Exception
	 {
	  try
	  {
	   bp=new BasePage();
	  String screenName1="//td[text()='";
	  String screenName2="']/..//input[@name='associatedScreens']";
	  for(int i=0;i<=name.length-1;i++)
	  {
	   
	  bp.waitForElement();
	  
	  
	  
	  WebElement ele=driver.findElement(By.xpath(screenName1+name[i]+screenName2));
	  boolean res=ele.isSelected();
	  if(res==false)
	  {
	   ele.click();
	  }
	  
	 }
	  
	  JavascriptExecutor js=((JavascriptExecutor)driver);
	  js.executeScript("arguments[0].scrollIntoView(true);",prioritySubmit);
	  bp.waitForElement();
	  bp.explicitWait(prioritySubmit);
	  prioritySubmit.click();
	  bp.waitForElement();
	  return true;
	   }
	   
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	 }

	 
	
	 
	 
	 public boolean createJiraProject(String project_Type,String project_Name,String leadName) throws Exception
	 {
		
		 try
		 {
		bp=new BasePage();
		bp.waitForElement();
		bp.explicitWait(projectHeader);
		projectHeader.click();
		bp.explicitWait(createProjectOption);
		createProjectOption.click();
		
		WebElement ele=driver.findElement(By.xpath(projectType1+project_Type+projectType2));
		bp.explicitWait(ele);
		
		ele.click();
		
		nextButton.click();
		bp.explicitWait(selectButton);
		selectButton.click();
		bp.explicitWait(projectName);
		projectName.sendKeys(project_Name);
		Actions a1=new Actions(driver);
		leadSelection.sendKeys(leadName);
		a1.sendKeys(Keys.ENTER).perform();
		bp.waitForElement();
		submitButton.click();
		
		return true;
		   }
		   
		   catch(Exception e)
		   {
		    e.printStackTrace();
		    throw e;
		   }

		
	 }

	 
	 public boolean selectProjectAdministration(String project) throws Exception
	 {
	  try
	  {
	  WebElement ele=driver.findElement(By.xpath(filterValue1+project+filterValue2));
	  JavascriptExecutor js=((JavascriptExecutor)driver);
	  js.executeScript("arguments[0].scrollIntoView(true);",ele );
	  
	  ele.click();
	  
	  return true;
	 }

	 catch(Exception e)
	 {
	  e.printStackTrace();
	  throw e;
	 }  
	  
	 }
	 

	 public boolean changeDefectPermission(String permissionValue,String defectPermissionType) throws Exception 
		{
			try
			{ 
				
				bp=new BasePage();
				JavascriptExecutor js =((JavascriptExecutor) driver);
			    js.executeScript("arguments[0].scrollIntoView(true);", projectConfigPermission);
			    bp.waitForElement();
			    projectConfigPermission.click();
			    System.out.println("Pass-Successfuly clicked on Project Config Permission");
			    bp.waitForElement();
			    bp.explicitWait(configActionsIcon);
			    configActionsIcon.click();
			    System.out.println("Pass-Actions Icon is clicked Successfully");
			    bp.waitForElement();
				WebElement sel1=driver.findElement(By.xpath(projectValue1+permissionValue+projectValue2));
			    sel1.click();
			    System.out.println("Pass-" + permissionValue + " is clicked Successfully");
			    bp.waitForElement();
			    enterAdministratorAccessPassword("password");
			    bp.waitForElement();
			    Select sel=new Select(defectPermissionDropdown);
			    bp.waitForElement();
			    sel.selectByVisibleText(defectPermissionType);
				bp.waitForElement();
			    defectSubmit.click();
			    System.out.println("Pass-Successfully clicked on Associate button");
				bp.waitForElement();
				return true;
			  }
			  
			  catch(Exception e)
			  {
			   e.printStackTrace();
			   throw e;
			  }  
		}
	
	 
	 public boolean deleteCustomFieldValue(String customFieldValue) throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			WebElement ele=driver.findElement(By.xpath(customFieldValueDelete1+customFieldValue+customFieldValueDelete2));
			ele.click();
			System.out.println(" Custom field value is deleted " +customFieldValue + "Successfully");
			bp.waitForElement();
			ClickonDeleteCustomValue.click();
			bp.waitTillElementIsVisible(clickOnCancelPopUnWindow);
			clickOnCancelPopUnWindow.click();
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
	 
	 
	 
	 
	 public boolean navigateToCustomFieldsConfiguration() throws Exception
	 {
	 	try
	 	{
	 		bp=new BasePage();
	 		bp.explicitWait(fieldsConfiguration);
	 		fieldsConfiguration.click();
	 		System.out.println("Pass-Clicked On Fieds Configuration Successfully");
	 		bp.explicitWait(defaultFieldConfiguration);
	 		defaultFieldConfiguration.click();
	 		System.out.println("Pass-clicked on Default Field Configuration successfully");
	 		bp.waitForElement();
	 		return true;
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 		throw e;
	 	}
	 }
	 
	 public boolean dragAndDrop(String valueName,int whichElementToShift) throws Exception
	 {
	  try
	  {
	  bp=new BasePage();
	  bp.waitForElement();
	  String a=Integer.toString(whichElementToShift);
	  WebElement ele=driver.findElement(By.xpath(elementMove1+valueName+elementMove2));
	  ele.click();
	  bp.waitForElement();
	  ele.clear();
	  ele.sendKeys(a);
	  bp.waitForElement();
	  clickOnMove.click();
	  return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }


	 
	 public boolean deleteCustomFieldsOption(String customFieldOption,String optionValue) throws Exception 
	 {
			try
			{ 
				bp=new BasePage();
				WebElement customField_Value=driver.findElement(By.xpath(priority1+customFieldOption+priority2+optionValue+priority3));
				JavascriptExecutor js =((JavascriptExecutor) driver);
			    js.executeScript("arguments[0].scrollIntoView(true);", customField_Value);
				bp.waitForElement();
				bp.explicitWait(customField_Value);
				customField_Value.click();
				bp.waitForElement();
				deleteOptionValue.click();
				bp.waitForElement();
				close.click();
				System.out.println("Pass-Custom Field Option" + customFieldOption + " is deleted successfully");
				bp.waitForElement();
				return true;
			  }
			  
			  catch(Exception e)
			  {
			   e.printStackTrace();
			   throw e;
			  }  
		}
	
	
	 
	 public boolean changeCustomFieldsToMandatoryOrNonMandatory(String customFieldName,String optionValue) throws Exception 
	 {
			try
			{ 
				bp=new BasePage();
				WebElement customField_Value=driver.findElement(By.xpath(priority1+customFieldName+priority2+optionValue+priority3));
				JavascriptExecutor js =((JavascriptExecutor) driver);
			    js.executeScript("arguments[0].scrollIntoView(true);", customField_Value);
				bp.waitForElement();
				bp.explicitWait(customField_Value);
				customField_Value.click();
				bp.waitForElement();
				System.out.println("Pass-Successfully Changed the Custom Field Name" + customFieldName + "to the" + optionValue + "Field");
				bp.waitForElement();
				return true;
			  }
			  
			  catch(Exception e)
			  {
			   e.printStackTrace();
			   throw e;
			  }  
		}
	 
	 
	 

	 /////////////////////13/07/18//////////////////////
	 public boolean editUser(String uName,String fullName,String emailId) throws Exception
	 {

	  try
	  {
	   bp=new BasePage();
	   bp.explicitWait(userEditButton);
	   userEditButton.click();
	   
	   bp.waitForElement();
	   bp.explicitWait(editUname);
	   editUname.clear();
	   editUname.sendKeys(uName);
	   
	   bp.explicitWait(editFullName);
	   editFullName.clear();
	   editFullName.sendKeys(fullName);
	   
	   bp.explicitWait(editEmail);
	   editEmail.clear();
	   editEmail.sendKeys(emailId);
	   
	   updateButton.click();
	   bp.waitForElement();
	   
	  return true;
	  }

	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }  
	 }
	 
	 
	 public boolean filterUser(String uName) throws Exception
	 {
	  
	  try
	  {
	  
	   bp=new BasePage();
	   bp.explicitWait(searchUser);
	   searchUser.sendKeys(uName);
	   bp.waitForElement();
	   bp.explicitWait(filterButton);
	   filterButton.click();
	   bp.waitForElement();
	   
	   
	  return true;
	 }

	 catch(Exception e)
	 {
	  e.printStackTrace();
	  throw e;
	 }  

	 }
	 
	
	 

	 public boolean validateEditedIssueTypeValue(String issueTypeValue) throws Exception
		{
		try
		{
		    bp=new BasePage();
			Actions a1=new Actions(driver);
			bp.waitForElement();
			bp.waitForElement();
			WebElement value=driver.findElement(By.xpath(editIssue1+issueTypeValue+projectValue2));
			a1.moveToElement(value).pause(1200).perform();
		    String text=value.getText();
		    if(text.equals(issueTypeValue))
		    {
		    	System.out.println("Pass-Edited IssueType Value" +issueTypeValue+ " is validated Successfully" );
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
	
	 public boolean validateEditedCustomFieldValue(String customValue) throws Exception
		{
		try
		{
		    bp=new BasePage();
			Actions a1=new Actions(driver);
			bp.waitForElement();
			bp.waitForElement();
			WebElement value=driver.findElement(By.xpath(priority1+customValue+projectValue2));
			a1.moveToElement(value).pause(1200).perform();
		    String text=value.getText();
		    if(text.equals(customValue))
		    {
		    	System.out.println("Pass-Edited IssueType Value" +customValue+ " is validated Successfully" );
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
	 
	 public boolean navigateToIssues() throws Exception
	 {
	 	try
	 	{
	 		bp=new BasePage();
	 		bp.explicitWait(clickOnIssues);
	 		clickOnIssues.click();
	 		System.out.println("Clicked On Issues Successfully");
	 		bp.waitForElement();
	 		return true;
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 		throw e;
	 	}
	 }
	
	 public boolean validateUsername(String uName) throws Exception
	 {
	  
	  try
	  {
	   
	   bp=new BasePage();
	   bp.waitForElement();
	   bp.explicitWait(validateUser);
	   String validateUname=validateUser.getText();
	   
	   if(validateUname.equals(uName))
	   {
	   System.out.println("Username is successfully validated"); 
	   }
	   
	   else
	   {
	    new UserDefinedException("Username is not validated");
	   }
	   
	  return true;
	  }

	  catch(TimeoutException e)
	  {
	   System.out.println(uName+"-User is not present in application");
	   return false;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 }

	   


	   public boolean assignUserToJiraAdministratorRole(String actionType,String jiraUserSearch) throws Exception
		 {

		  try
		  {
		   bp=new BasePage();
		   Actions a1=new Actions(driver);
		   bp.explicitWait(userActionButton);
		   userActionButton.click();
		   System.out.println("Pass-Action button is clicked successfully ");
		   bp.waitForElement();
		   //WebElement sel1=driver.findElement(By.xpath(projectValue1+actionType+projectValue2));
		    //sel1.click();
		   bp.explicitWait(editUserGroups);
		   editUserGroups.click();
		   System.out.println("Pass-Successfully clicked on Edit User Groups Successfully");
		    bp.waitForElement();
		   a1.moveToElement(groupsToJoinArea).sendKeys(jiraUserSearch).sendKeys(Keys.ENTER).pause(2000).sendKeys(Keys.TAB).perform();
		   bp.waitForElement();
		   bp.explicitWait(joinAdministratorsGroup);
		   joinAdministratorsGroup.click();
		   System.out.println("Pass-Successfully selected the Join Selected groups");
		   bp.waitForElement();
		   bp.explicitWait(cancelUserGroupsButton);
		   cancelUserGroupsButton.click();
		   System.out.println("Pass-Successfully clicked on cancel group button");
		   bp.waitForElement();
		  return true;
		 }

		 catch(Exception e)
		 {
		  e.printStackTrace();
		  throw e;
		 }  

		 }
	 
	   public boolean createComponent(String name,String description,String assignee) throws Exception
	   {
	    try
	    {
	     bp=new BasePage();
	     bp.explicitWait(version_Name);
	     version_Name.sendKeys(name);
	     
	     version_Desc.sendKeys(description);
	     bp.waitForElement();
	     Actions a1=new Actions(driver);
	     a1.moveToElement(assigneeVersion).click().sendKeys(assignee).pause(1800).sendKeys(Keys.TAB).perform();
	     //assigneeVersion
	     addButton.click();
	     bp.waitForElement();
	      return true;
	   }


	    catch(Exception e)
	    {
	     e.printStackTrace();
	     throw e;
	    }  
	   }

	   public boolean createVersion(String name,String description) throws Exception
	   {
	    try
	    {
	     bp=new BasePage();
	     bp.explicitWait(version_Name);
	     version_Name.sendKeys(name);
	     
	     version_Desc.sendKeys(description);
	     
	     addButton.click();
	     bp.waitForElement();
	      return true;
	   }


	    catch(Exception e)
	    {
	     e.printStackTrace();
	     throw e;
	    }  
	   }


	   public boolean navigateToComponents() throws Exception
	   {
	   	try
	   	{
	   		bp=new BasePage();
	   		bp.explicitWait(componentTab);
	   		componentTab.click();
	   		System.out.println("Pass-Clicked On Component Tab Successfully");
	   		bp.waitForElement();
	   		return true;
	   	}
	   	catch(Exception e)
	   	{
	   		e.printStackTrace();
	   		throw e;
	   	}
	   }
	   
	   public boolean checkAvailableComponentOrVersion(String name) throws Exception
	   {
	    try
	    {
	     
	     bp=new BasePage();
	     bp.waitForElement();
	    WebElement ele=(new WebDriverWait(driver,10))
	       .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkVersion1+name+checkVersion2)));
	      
	    return true;
	   }

	   catch(TimeoutException e)
	   {
	    System.out.println(name+"-Version/Component is not present");
	    return false;
	   }  

	    catch(Exception e)
	    {
	     e.printStackTrace();
	     throw e;
	    }
	   }
	   
	   public boolean createJiraUser(String email_Id,String fullName,String username,String password,String jiraSoftwareStatus) throws Exception
		  {
		   try
		   {
		  bp=new BasePage();
		  bp.waitForElement();
		  bp.explicitWait(jiraCreateUserButton);
		  jiraCreateUserButton.click();
		  bp.waitForElement();
		  bp.explicitWait(jiraCreateEmail);
		  jiraCreateEmail.sendKeys(email_Id);
		  jiraCreateFullName.sendKeys(fullName);
		  jiraCreateUser.sendKeys(username);
		  jiraCreatePassword.sendKeys(password);
		  
		  boolean status=jiraSoftwareCheckbox.isSelected();
		  if(jiraSoftwareStatus.equals("inactive") && status==true)
		  {
		   jiraSoftwareCheckbox.click(); 
		  }
		  bp.explicitWait(CreateUserSubmitButton);
		  CreateUserSubmitButton.click();
		  bp.waitForElement();
		  return true;
		     }
		     
		     catch(Exception e)
		     {
		      e.printStackTrace();
		      throw e;
		     }

		  
		  }
		 
		 public boolean checkAvailableJiraProject(String projectName) throws Exception
		 {
		  try
		  {
		   
		   bp=new BasePage();
		   bp.waitForElement();
		  WebElement ele=(new WebDriverWait(driver,10))
		     .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterValue1+projectName+filterValue2)));
		    
		  return true;
		 }

		 catch(TimeoutException e)
		 {
		  System.out.println("Project is not present");
		  return false;
		 }  

		  catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }  
		 }

		
		 public boolean navigateToVersionsPage() throws Exception 
			{
				try
				{ 
					
					bp=new BasePage();
				    bp.waitForElement();
				    bp.explicitWait(versionTab);
				    versionTab.click();
				    System.out.println("Pass-Suceessfully clicked on version fields Successfully");
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
