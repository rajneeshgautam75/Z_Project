package com.zephyr.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.reusablemethods.BasePage;

public class ProjectPage_POM {

	WebDriver driver = null;

	@FindBy(xpath = "//*[@id='projectDropDown']")
	public WebElement project;

	@FindAll({ @FindBy(xpath = "(//*[@aria-labelledby='projectDropDown'])/a") })
	public List<WebElement> projectList;

	@FindBy(xpath = "//*[text()='Go to Project']")
	public WebElement goToProject;

	@FindBy(id = "//*[@id='ze-main-app']/zee-projects/zee-project/div/div[1]/div[1]/h3/b")
	public WebElement validateproject;

	// Modified
	@FindBy(xpath = "//a[text()='Release 1.0' or @class='zui-link grid_link_click release_name']")
	public WebElement validateRelease;
	// @FindBy(xpath="//*[@id='ze-main-app']/zee-release/zee-release-wrapper/div/div[1]/div[1]/h3/b")
	// public WebElement validateRelease;

	@FindBy(xpath = "//*[@id='ze-main-app']/top-nav/header/div/ul[1]/li[1]/span")
	public WebElement rolemsg;

	@FindBy(xpath = "//span[contains(.,'Manage Release')]")
	public WebElement manage_Release_Button;

	@FindBy(xpath = "//span[@class='zui-user-name']")
	public WebElement user_option;

	@FindBy(xpath = "//a[contains(.,'Logout')]")
	public WebElement logout;

	// @FindBy(xpath="//b[@role='presentation']")
	// private WebElement selectReleasedd;

	public String role;

	// For Selecting Project
	protected String project1 = "//a[@title='";
	protected String project2 = "']";

	protected String valProject1 = "//span[@id='projectDropDown']//span[text()='"; //previous
	protected String valProject2 = "']";
//	protected String valProject1 = "//div[@id='sidr']//span[text()='"; //modified 15/02/18
//	protected String valProject2 = "']";

	// For Selecting Release
	protected String release1 = "//*[text()='";
	protected String release2 = "' and @class='zui-link grid_link_click release_name']";

	@FindBy(xpath = "//span[text()='Manage Release']") // "//a[@class='zui-icon-btn']"
														// ) //
	public WebElement ManageRelease;

	public String releasei1 = "//div[text()='";
	public String releasei2 = "']";

	public String delete1 = "//div[text()='";
	public String delete2 = "']/../../..//div[6]//div[2]//span[2]";

	@FindBy(xpath = "//button[@value='DELETE_DOUBLE_CONFIRMATION']")
	public WebElement OK;
	
	
	@FindBy(xpath = "//button[@value='DELETE']")
	public WebElement OkReleaseDelete;

	@FindBy(xpath = "//button[text()='Delete']")
	public WebElement Delete;

	public ProjectPage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);

	}
	
	 public String Project1="//div[text()='";
	 public String Project2="']";
	 
	 @FindBy(xpath="//button[text()='+']")
	 public WebElement addProject;

	 @FindBy(xpath="//input[@placeholder='Enter name']")
	 public WebElement projectName;

	 @FindBy(xpath="//input[@placeholder='Enter description']")
	 public WebElement descript;

	 @FindBy(xpath="//label[@for='project-lead']/..//select")
	 public WebElement leadRole;

	 @FindBy(xpath="//button[text()='Add']")
	 public WebElement add;
	 
     //modified xpath for 6.1
	 @FindBy(xpath="(//label[@for='project-externalSystem'])/..//select")
	 public WebElement defectProject;
	 
	// @FindBy(xpath="(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
	// public WebElement defectProject;

	 @FindBy(xpath="//input[@id='sharecheckbox']")
	 public WebElement shareBox;

	 @FindBy(xpath="(//button[text()='Yes'])[2]")
	 public WebElement Yes;

	 @FindBy(xpath="//span[@class='text-info']")
	 public WebElement minYear;

	 @FindBy(xpath="//button[@class='btn btn-default btn-sm pull-left']")
	 public WebElement left;


	 @FindBy(xpath="//button[@class='btn btn-default btn-secondary btn-sm']")
	 public WebElement startDateHeader;


	 @FindBy(xpath="//button[@class='btn btn-default btn-secondary btn-sm']")
	 public WebElement endDateHeader;
	 
	 @FindBy(xpath="(//button[@class='btn btn-default'])[19]")
	 public WebElement maxYear;

	 @FindBy(xpath="//button[@class='btn btn-default btn-sm pull-right']")
	 public WebElement right;


	 @FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	 public WebElement year;

	 public String day1="//span[text()='";
	  public String day2="']";
	  
	  @FindBy(xpath="//a[text()='Normal ']")
	  public WebElement type;
	  
	  public String type1="//span[text()='";
	  public String type2="']";
	  
	  
	  //@FindBy(xpath="//button[text()=' OK ']")
	  //public WebElement typeOk;
	//modified
	  @FindBy(xpath="(//button[text()='OK'])[1]")
	  public WebElement typeOk;
	  
	  
	  //modified
	  @FindBy(xpath="//a[text()='Administration']")
	  public WebElement launchadministration;
	  
	  //@FindBy(xpath="//li[text()='Administration']")
	  //public WebElement launchadministration;
	  
	  //modified
	  @FindBy(xpath="//a[text()='Administration']")
	  public WebElement validateAdmin;
	  
	  //@FindBy(xpath="//span[text()='Administration']")
	  //public WebElement validateAdmin;
	  
	  @FindBy(xpath="//span[text()='Project Setup']")
	  public WebElement launchManageProjects;
     
	  //modified
	 @FindBy(xpath="//span[text()='Project Setup']")
	 public WebElement validatManageprojects;

	  //@FindBy(xpath="//b[text()='Project Setup']")
	  //public WebElement validatManageprojects;

	  public String delete3="(//*[@title='";
	  public String delete4="'])/../../..//div[8]//div[2]";

	public boolean selectProject2(String projectName, WebDriver driver2) throws Exception {
		try {
			this.driver = driver2;
			BasePage bp = new BasePage();
			bp.waitForElement();
			driver.findElement(By.xpath("//*[@id='projectDropDown']")).isEnabled();
			driver.findElement(By.xpath("//*[@id='projectDropDown']")).isDisplayed();
			bp.waitForElement();
			bp.waitForElement();
			WebDriverWait wait2 = new WebDriverWait(driver, 100);
			wait2.until(ExpectedConditions.elementToBeClickable(project));
			driver.findElement(By.xpath("//*[@id='projectDropDown']")).click();
			bp.waitForElement();
			String validate_Project = driver.findElement(By.xpath(project1 + projectName + project2)).getText();

			if (projectName.equals(validate_Project)) {

				driver.findElement(By.xpath(project1 + projectName + project2)).click();
				// log.info("Pass - "+projectName+"Project Is Selected");
				System.out.println("Pass - '" + projectName + "' Project Is Selected");
				System.out.println("Pass - You are in '" + projectName + "' now");
			}

			else {
				System.out.println("Fail -Project-'" + projectName + "' is not Available");

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public boolean selectRelease2(String releaseName, WebDriver driver2) throws Exception {
		try {
			this.driver = driver2;
			BasePage bp = new BasePage();
			bp.waitForElement();
			// String
			// validateRelease=driver.findElement(By.xpath(release1+releaseName+release2)).getText();
			driver.findElement(By.xpath(release1 + releaseName + release2)).click();
			bp.waitForElement();
			String validate_Release = driver
					.findElement(
							By.xpath("//*[@id='ze-main-app']/zee-release/zee-release-wrapper/div/div[1]/div[1]/h3/b"))
					.getText();

			if (releaseName.equalsIgnoreCase(validate_Release)) {

				System.out.println("Pass - You are in the " + releaseName);
				// System.out.println("Pass - You are in the '"+releaseName+"'
				// ");
			} else {
				System.out.println("Fail - You are not in the " + releaseName);
				// System.out.println("Fail - you are not in the
				// '"+releaseName+"' ");

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	
	///////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//a[@title='Defect Tracking']")	
	public WebElement defectTracking;
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////
	
	public String user1="//div[text()='";
	public String user2="']";

	@FindBy(xpath="(//input[@placeholder='Search for...'])[2]")
	public WebElement searchUnassignProject;
    
	@FindBy(xpath="(//span[@class='fa fa-search'])[2]")
	public WebElement searchButton1;

	
	@FindBy(xpath="//input[@id='unselecteedList']")
	public WebElement unSelected;

	@FindBy(xpath="//span[@class='forward-image']")
	public WebElement Forward;

	@FindBy(xpath="//button[text()='Save']")
	public WebElement Save;

	@FindBy(xpath="(//input[@placeholder='Search for...'])[3]")
	public WebElement searchAssignProject;

	@FindBy(xpath="(//span[@class='fa fa-search'])[3]")
	public WebElement searchButton2;

	@FindBy(xpath="//input[@id='selectedList']")
	public WebElement Selected;

	@FindBy(xpath="//span[@class='backward-image']")
	public WebElement Backward;






	@FindBy(xpath="//span[text()='Manage Projects']")
	public WebElement ManageProjects;



	@FindBy(xpath="//span[text()='User Setup']")
	public WebElement manageUser;
	
	public String assignProj1="//div[@class='unselected-list'] //label[text()='";
	public String assignProj2="']";

	public String user_1="//*[@id='grid-table-resource']//*[text()='";
	public String user_2="']";
	

@FindBy(xpath="//button[text()='+']")
public WebElement addNewUser;

@FindBy(xpath="//*[@id='resource-firstname']")
public WebElement FirstName;

@FindBy(xpath="//*[@id='resource-lastname']")
public WebElement LastName;

@FindBy(xpath="//*[@id='resource-type']")
public WebElement Type;

@FindBy(xpath="//*[@id='resource-roles']")
public WebElement Role;

@FindBy(xpath="//*[@id='resource-email']")
public WebElement Email;

@FindBy(xpath="//*[@id='resource-title']")
public WebElement Title;

@FindBy(xpath="//*[@id='resource-location']")
public WebElement Location;

@FindBy(xpath="//button[text()='Save']")
public WebElement saveNewUser;

@FindBy(xpath="//*[@id='resource-credentialsExpired']")
public WebElement expireCredential;

@FindBy(xpath = "//a[@class='zui-icon-btn']")
public WebElement backToProjectPage;

@FindBy(xpath = "//button[@value='DELETE_DOUBLE_CONFIRMATION']")
public WebElement deleteOK;

@FindBy(xpath="//span[text()='User Setup']")
public WebElement launchManageUsers;

@FindBy(xpath="//b[text()='User Setup']")
public WebElement validatManageuser;


////////////////////////////////////////////
@FindBy(xpath="//span[text()='Defect Admin']")
public WebElement defectAdmin;

@FindBy(xpath="//b[text()='Defect Admin']")
public WebElement validateDefectAdmin;
	
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

@FindBy(xpath="//i[@title='Edit']")
public WebElement editDTS;




	
}
