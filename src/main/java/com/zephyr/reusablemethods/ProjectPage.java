package com.zephyr.reusablemethods;


import java.util.List;

import org.apache.log4j.Logger;
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
import com.zephyr.pom.ProjectPage_POM;
import com.zephyr.pom.TestPlanning_POM;

public class ProjectPage
{
	WebDriver driver;
	public Logger log;
	BasePage bp;
	TestPlanning_POM tp;
	boolean res;
	
	public ProjectPage(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log=Logger.getLogger(this.getClass());
	    Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//		BasicConfigurator.configure();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	///////////////////////////POM///////////////////////////
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

//	public ProjectPage_POM(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(LaunchBrowser.driver, this);
//
//	}
	
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

	
	public boolean clickOnManageRelease() throws Exception
	{
		try
		{
			bp=new BasePage();
		manage_Release_Button.click();
		bp.waitForElement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return true;
	}


	public String fetchRoleMsg()
	{
	
	  role=rolemsg.getText();
	  log.info("Role= "+role);
	   
	   return role;
	}
	
	
	
public boolean verifyProjecttitle()
{
	String proTitle=driver.getTitle();
	log.info("Project Tiltle-"+proTitle);
	return true;
}
//main

/* ****************************************************
   * Method Name   : selectProject(String projectName) 
  * Purpose    : To select Project 
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */


public boolean selectProject(String projectName) throws Exception 
{
 try
 {
 BasePage bp=new BasePage();
 bp.waitForElement();
 project.isEnabled();
 project.isDisplayed();
 //bp.waitForElement();
 
 WebDriverWait wait2=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
 wait2.until(ExpectedConditions.elementToBeClickable(project));
 bp.moveToElementAndClick(project);
 bp.waitForElement();
 
 
 List<WebElement> allp=projectList;
 boolean res=false;
// System.out.println(allp.size());
 for(int i=0;i<allp.size();i++)
 {
  String  pp=allp.get(i).getAttribute("title");
 
 if(pp.equals(projectName))
 {
  res=true;
  bp.waitForElement();
  driver.findElement(By.xpath(project1+projectName+project2)).click();
  break;
 }
 }
 if(res==false)
 {
	
    goToProject.click();
  bp.waitForElement();
 // bp.waitForElement();
 // bp.waitForElement();
 // WebElement lastprojects=driver.findElement(By.xpath("//li[text()='"+projectName+"']"));
  Actions a1=new Actions(driver);
  a1.sendKeys(projectName).pause(1400).sendKeys(Keys.ENTER).perform();
  
 }
 
 bp.waitForElement();
 
  String validate_Project=driver.findElement(By.xpath(valProject1+projectName+valProject2)).getText();

 if(projectName.equals(validate_Project))
 {

  log.info("Pass - '"+projectName+"' Project Is Selected");
  log.info("Pass - You are in '"+projectName+"' now");
 }
 
 
   return true;
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
 }
 
}
//public boolean selectProject(String projectName) throws Exception 
//{
//	try
//	{
//	BasePage bp=new BasePage();
//	bp.waitForElement();
//	project.isEnabled();
//	project.isDisplayed();
//	bp.waitForElement();
//	bp.waitForElement();
//	WebDriverWait wait2=new WebDriverWait(driver, 100);
//	wait2.until(ExpectedConditions.elementToBeClickable(project));
//	project.click();
//	bp.waitForElement();
//	String validate_Project=driver.findElement(By.xpath(project1+projectName+project2)).getText();
//	 
//	if(projectName.equals(validate_Project))
//	{
//
//		driver.findElement(By.xpath(project1+projectName+project2)).click();
//		//log.info("Pass - "+projectName+"Project Is Selected");
//		log.info("Pass - '"+projectName+"' Project Is Selected");
//		log.info("Pass - You are in '"+projectName+"' now");
//	}
//	
//	else
//	{
//		log.info("Fail -Project-'"+projectName+"' is not Available");
//		
//    }
//	  return true;
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//		throw e;
//	}
//	
//}


/* ****************************************************
   * Method Name   : selectRelease(String releaseName) 
  * Purpose    : To select Release
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */
public boolean selectRelease(String releaseName) throws Exception 
{
	try
	{
	BasePage bp=new BasePage();
	bp.waitForElement();
	WebElement valRelease=driver.findElement(By.xpath(release1+releaseName+release2));
	bp.explicitWait(valRelease);
	String validateRelease=valRelease.getText();
	driver.findElement(By.xpath(release1+releaseName+release2)).click();
	bp.waitForElement();
	//String validate_Release=validateRelease.getText();
	
	if(releaseName.equalsIgnoreCase(validateRelease))
	   {
		 
			log.info("Pass - You are in the "+releaseName);
			//System.out.println("Pass - You are in the '"+releaseName+"' ");
		}
		else
		{
			log.info("Fail - You are not in the "+releaseName);
			//System.out.println("Fail - you are not in the '"+releaseName+"' ");

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
   * Method Name   : clickOnLogout()
  * Purpose    : clickOnLogout()
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */
public boolean clickOnLogout() throws Exception
{
	try
	{
	bp=new BasePage();
		
	bp.waitForElement();
	bp.explicitWait(user_option);
	user_option.click();
	bp.waitForElement();
	logout.click();
	//driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
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
   * Method Name   : closeBrowser()
  * Purpose    : For closing the browser
  * Author    : OPAL1
  * Date Created   : 27/07/17
  * Date Modified  :
  * Reviewed By   : Opal4
  * ******************************************************
  */
public boolean closeBrowser() throws Exception
{
	try
	{
	driver.quit();
   log.info("Finalising Frmework");
   
   return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
}
//public boolean selectProject2(String projectName,WebDriver driver2) throws Exception 
//{
//	try
//	{
//		
//		
//		
//		this.driver=driver2;
//	BasePage bp=new BasePage();
//	bp.waitForElement();
//	driver.findElement(By.xpath("//*[@id='projectDropDown']")).isEnabled();
//	driver.findElement(By.xpath("//*[@id='projectDropDown']")).isDisplayed();
//	bp.waitForElement();
//	bp.waitForElement();
//	WebDriverWait wait2=new WebDriverWait(driver, 100);
//	wait2.until(ExpectedConditions.elementToBeClickable(project));
//	driver.findElement(By.xpath("//*[@id='projectDropDown']")).click();
//	bp.waitForElement();
//	
//	
//	
//	 List<WebElement> allp=driver.findElements(By.xpath("(//*[@aria-labelledby='projectDropDown'])/a"));
//	 boolean res=false;
//	// System.out.println(allp.size());
//	 for(int i=0;i<allp.size();i++)
//	 {
//	  String  pp=allp.get(i).getAttribute("title");
//	 
//	 if(pp.equals(projectName))
//	 {
//	  res=true;
//	  bp.waitForElement();
//	  driver.findElement(By.xpath(project1+projectName+project2)).click();
//	  break;
//	 }
//	 }
//	 if(res==false)
//	 {
//		
//		 driver.findElement(By.xpath("//*[text()='Go to Project']")).click();
//	   // goToProject.click();
//	  bp.waitForElement();
//	 // bp.waitForElement();
//	 // bp.waitForElement();
//	 // WebElement lastprojects=driver.findElement(By.xpath("//li[text()='"+projectName+"']"));
//	  Actions a1=new Actions(driver);
//	  a1.sendKeys(projectName).pause(1400).sendKeys(Keys.ENTER).perform();
//	  
//	 }
//	 
//	 bp.waitForElement();
//	 
//	  String validate_Project=driver.findElement(By.xpath(valProject1+projectName+valProject2)).getText();
//
//	 if(projectName.equals(validate_Project))
//	 {
//
//	  log.info("Pass - '"+projectName+"' Project Is Selected");
//	  log.info("Pass - You are in '"+projectName+"' now");
//	 }
//	 
//	  return true;
//}
//catch(Exception e)
//{
// e.printStackTrace();
// throw e;
//}
//
//	
//		
//}
//
//public boolean selectRelease2(String releaseName,WebDriver driver2) throws Exception 
//{
//	try
//	{
//		this.driver=driver2;
//	BasePage bp=new BasePage();
//	bp.waitForElement();
//	String validateRelease=driver.findElement(By.xpath(release1+releaseName+release2)).getText();
//	driver.findElement(By.xpath(release1+releaseName+release2)).click();
//	bp.waitForElement();
//	//String validate_Release=driver.findElement(By.xpath(validateRelease)).getText();
//	
//	if(releaseName.equalsIgnoreCase(validateRelease))
//	   {
//		 
//			log.info("Pass - You are in the "+releaseName);
//			//System.out.println("Pass - You are in the '"+releaseName+"' ");
//		}
//		else
//		{
//			log.info("Fail - You are not in the "+releaseName);
//			//System.out.println("Fail - you are not in the '"+releaseName+"' ");
//
//		}
//	return true;
//}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//		throw e;
//	}
//
//	
//	
//}
//
//public boolean clickOnLogout(WebDriver driver2) throws Exception {
//	  try {
//	   this.driver=driver2;
//	   BasePage bp=new BasePage();
//	   bp.waitForElement();
//
//	   driver.findElement(By.xpath("//span[@class='zui-user-name']")).click();
//	   
//	   bp.waitForElement();
//	   driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
//	   
//	   System.out.println("Successfully logout from the application");
//	   bp.waitForElement();
//	   driver.close();
//	   return true;
//	  }
//	  catch(Exception e)
//	  {
//	   e.printStackTrace();
//	   throw e;
//	  }
//	 
//
//
//	 }



public boolean deleteRelease(String Project,String Release) throws Exception
{
	try
	{
		bp=new BasePage();
		ProjectPage pp=new ProjectPage(driver);
		pp.selectProject(Project);
		bp.waitForElement();
	   WebDriverWait wait=new WebDriverWait(driver, 20);
	   wait.until(ExpectedConditions.elementToBeClickable(ManageRelease));
	   Actions act=new Actions(driver);
	   act.moveToElement(ManageRelease).click().build().perform();
	    bp.waitForElement();
	   WebElement release=driver.findElement(By.xpath(releasei1+Release+releasei2));
	   String releaseName=release.getText();
	   System.out.println(releaseName);
	   if(releaseName.equals(Release))
	   {
		   bp.waitForElement();
		   release.click();
		   WebElement delete=driver.findElement(By.xpath(delete1+Release+delete2));
		   wait.until(ExpectedConditions.elementToBeClickable(delete));
		   delete.click();
		   bp.waitForElement();
		   wait.until(ExpectedConditions.elementToBeClickable(OkReleaseDelete));
		   OkReleaseDelete.click();
		 //  wait.until(ExpectedConditions.elementToBeClickable(Delete)); 
//		   bp.waitForElement();
//		   Delete.click();
		   System.out.println("Release " + Release + " deleted successfully");
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



public boolean validateProject(String project)
{
try
{
WebElement  Project=(new WebDriverWait(driver, 10))
.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Project1+project+Project2)));
String data=Project.getText();
System.out.println("Project- " + data + " already present");
return true;
}
catch(TimeoutException e)
{
 System.out.println("Project- " + project + " not present");
return false;
}
}
public boolean createProject(String project,String description,String typeName,String lead,String mapDefectProject, String [] startDate , String  [] endDate ,String shareCheckbox) throws Exception
{
try
{
bp=new BasePage();
tp=new TestPlanning_POM(driver);
bp.waitForElement();
WebDriverWait wait=new  WebDriverWait(driver,60);
Actions act=new Actions(driver);
wait.until(ExpectedConditions.elementToBeClickable(addProject));
addProject.click();
bp.waitForElement();
wait.until(ExpectedConditions.elementToBeClickable(projectName));
act.moveToElement(projectName).click().sendKeys(project,Keys.ENTER).build().perform();
System.out.println("Project name entered successfully-"+project);
wait.until(ExpectedConditions.elementToBeClickable(descript));
act.moveToElement(descript).click().sendKeys(description,Keys.ENTER).build().perform();
Select sel=new Select(leadRole);
sel.selectByVisibleText(lead);
System.out.println("Project assigned to -"+ lead +" successfully");
bp.waitForElement();

if(!mapDefectProject.equals(""))
{
   Select sel2=new Select(defectProject);
   sel2.selectByVisibleText(mapDefectProject);
   bp.waitForElement();
}

tp.startDateOption.click();
bp.waitForElement();
Actions a2=new Actions(driver);
a2.moveToElement(startDateHeader).doubleClick().perform();
bp.waitForElement();
year.click();         
bp.waitForElement();
String startYear=minYear.getText();
int syear=Integer.parseInt(startYear);
int [] start=new int[1];
start[0]=Integer.parseInt(startDate[0]);

if(start[0] < syear)
{
 left.click();
 bp.waitForElement();
 
}
driver.findElement(By.xpath(tp.year1+startDate[0]+tp.year2)).click();
bp.waitForElement();
bp.waitForElement();
driver.findElement(By.xpath(tp.month1+startDate[1]+tp.month2)).click();
bp.waitForElement();
driver.findElement(By.xpath(day1+startDate[2]+day2)).click();
bp.waitForElement();
System.out.println("Start date entered successfully"); 

if(endDate[0]!="")
{
tp.endDateOption.click();
bp.waitForElement(); 
Actions a3=new Actions(driver);
a3.moveToElement(endDateHeader).doubleClick().perform();
bp.waitForElement();
year.click();  
bp.waitForElement();
String endMin=minYear.getText();
String endMax=maxYear.getText();
int eMin=Integer.parseInt(endMin);
int eMax=Integer.parseInt(endMax);
int [] end=new int[1];
end[0]=Integer.parseInt(endDate[0]);

if(end[0] < eMin)
{
 left.click();
 bp.waitForElement();
}
else if(end[0] > eMax) 
{
 right.click();
    bp.waitForElement();

}

driver.findElement(By.xpath(tp.year1+endDate[0]+tp.year2)).click();
bp.waitForElement();
driver.findElement(By.xpath(tp.month1+endDate[1]+tp.month2)).click();
bp.waitForElement();
driver.findElement(By.xpath(day1+endDate[2]+day2)).click();
bp.waitForElement();
System.out.println("End date entered successfully");
}
String name=type.getText();
//System.out.println(name);
if(!name.equals(typeName))
{
 wait.until(ExpectedConditions.elementToBeClickable(type));
 type.click();
 bp.waitForElement();
 WebElement ele=driver.findElement(By.xpath(type1+typeName+type2));
 wait.until(ExpectedConditions.visibilityOf(ele));
 ele.click();
 System.out.println("Project Type selected-"+typeName);
 wait.until(ExpectedConditions.elementToBeClickable(typeOk));
 typeOk.click();
 
 bp.waitForElement(); 
}
 
if(!shareCheckbox.equals(""))
  {
     shareBox.click();
     bp.waitForElement();
     wait.until(ExpectedConditions.visibilityOf(Yes));
     Yes.click();
     bp.waitForElement();
     System.out.println("Check box selected successfully ");
  }
bp.waitForElement();
bp.waitForElement();
wait.until(ExpectedConditions.elementToBeClickable(add));
add.click();
System.out.println("Project -" + project + " created successfully ");
bp.waitForElement();
}
catch(Exception e)
  {
e.printStackTrace();
throw e;
  }
return true;
}

public boolean navigateToProjectPage() throws Exception
{
 try
 {
   bp=new BasePage();
   backToProjectPage.click();
   System.out.println("Pass-Successfully navigated to the project page");
   bp.waitForElement();
   return true; 
 }
 catch (Exception e) {
  e.printStackTrace();
  throw e;
 }
}



//public boolean launchAdministration() throws Exception
//{
// 
// try
// {
//	//b[text()='System Configuration']
//	 bp=new BasePage();
//	 boolean val=launchadministration.isEnabled();
//	 String expected="Administration";
//	 if(val==true)
//	 {
//		 launchadministration.click();
//		 System.out.println("Pass clicked on administration");
//		 try
//		 {
//		 String actual=validateAdmin.getText();
//		 
//		 
//		 if(actual.equals(expected))
//		 {
//			 System.out.println("User in Administration page");
//		 }
//		 else
//		 {
//			 System.out.println("user is not in Admin Page");
//		 }
//		 
//		 }catch(Exception e)
//		 {
//			 driver.navigate().refresh();
//			 bp.waitForElement();
//			 bp.waitForElement();
//			 System.out.println("Inside Catch block");
//			 launchadministration.click();
//			 System.out.println("Pass clicked on administration");
//		 }
//	 }
//	 bp.waitForElement();
//	
// }
// catch(Exception e)
// {
//	 e.printStackTrace();
//	 throw e;
// }
// return true;
// 
//}

public boolean launchAdministration() throws Exception
{
 
 try
 {
	 bp=new BasePage();
	 //driver.navigate().refresh();
	 bp.waitForElement();
	 bp.waitForElement();
	 boolean val=launchadministration.isEnabled();
	 String expected="Administration";
	 bp.waitForElement();
	 WebDriverWait wait=new WebDriverWait(driver,30);
	 wait.until(ExpectedConditions.elementToBeClickable(launchadministration));
	 launchadministration.click();
	 if(val==true)
	 {
		
		 System.out.println("Pass clicked on administration");
		
		 String actual=validateAdmin.getText();
		 
		 
		 if(actual.equals(expected))
		 {
			 System.out.println("User in Administration page");
		 }
		 else
		 {
			 System.out.println("user is not in Admin Page");
		 }
	} 
		 
	 bp.waitForElement();	
	
 }
 catch(Exception e)
 {
	 e.printStackTrace();
	 throw e;
 }
 return true;
 
}


public boolean launchManageprojects() throws Exception
{

try
{
	bp=new BasePage();
 boolean val=launchManageProjects.isEnabled();
 String expected="Project Setup";
 if(val==true)
 {
	 launchManageProjects.click();
	 System.out.println("Pass clicked on manage projects");
	 bp.waitForElement();
	 String actual=launchManageProjects.getText();
	 if(actual.equals(expected))
	 {
		 System.out.println("User in Manage projects page");
	 }
	 else
	 {
		 System.out.println("user is not in Manage projects Page");
	 }
 }
 
 bp.waitForElement();

}
catch(Exception e)
{
 e.printStackTrace();
 throw e;
}
return true;

}

public boolean DeleteProject(String Project) throws Exception {
 try {
  bp=new BasePage();
  WebElement project = driver.findElement(By.xpath(Project1 + Project + Project2));
  System.out.println(project);
  String data = project.getText();
  WebDriverWait wait=new WebDriverWait(driver,30);
  System.out.println(data);
  if (data.equals(Project)) {
   bp.waitForElement();
   wait.until(ExpectedConditions.elementToBeClickable(project));
   project.click();
   bp.waitForElement();
   WebElement delete = driver.findElement(By.xpath(delete3 + Project + delete4));
   wait.until(ExpectedConditions.elementToBeClickable(delete));
   delete.click();
   bp.waitForElement();
   wait.until(ExpectedConditions.elementToBeClickable(OK));
   OK.click();
   wait.until(ExpectedConditions.elementToBeClickable(Delete));
   bp.waitForElement();
   Delete.click();
   System.out.println("Project " + Project + " deleted successfully");
   bp.waitForElement();
  }

 }

 catch (Exception e) {
  e.printStackTrace();
  throw e;
 }
 return true;
}
public boolean deleteRelease(String Release) throws Exception
{
	try
	{
		bp=new BasePage();
		//ProjectPage pp=new ProjectPage(driver);
		//pp.selectProject(Project);
		bp.waitForElement();
	   WebDriverWait wait=new WebDriverWait(driver, 20);
	   //wait.until(ExpectedConditions.elementToBeClickable(ManageRelease));
	   //Actions act=new Actions(driver);
	   //act.moveToElement(ManageRelease).click().build().perform();
	    bp.waitForElement();
	   WebElement release=driver.findElement(By.xpath(releasei1+Release+releasei2));
	   String releaseName=release.getText();
	   System.out.println(releaseName);
	   if(releaseName.equals(Release))
	   {
		   bp.waitForElement();
		   release.click();
		   WebElement delete=driver.findElement(By.xpath(delete1+Release+delete2));
		   wait.until(ExpectedConditions.elementToBeClickable(delete));
		   delete.click();
		   wait.until(ExpectedConditions.elementToBeClickable(OkReleaseDelete));
		   OkReleaseDelete.click();
		   System.out.println("Release " + Release + " deleted successfully");
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







public boolean clickOnDefectTracking() throws Exception
{
  try
	{
	bp=new BasePage();
	bp.waitForElement();
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(defectTracking));
	defectTracking.click();
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



////////////////////////////Abilash ///////////////////////////////

public boolean selectUser(String userName) throws Exception
{
 
 try
 {
   bp=new BasePage();
   String user=user1+userName+user2;
   WebElement ele=driver.findElement(By.xpath(user));
   WebDriverWait wait=new WebDriverWait(driver,30);
   wait.until(ExpectedConditions.elementToBeClickable(ele));
   ele.click();
   System.out.println(userName + " user selected successfully ");
   bp.waitForElement(); 
 }
 catch(Exception e)
 {
   System.out.println(" User " +userName + " is not created  "); 
   throw e;
 }
 return true;
 
}


public boolean assignProject(String [] projectName) throws Exception
{
  try
 {
    bp=new BasePage();
   
    //System.out.println(res);
    JavascriptExecutor js = ((JavascriptExecutor) driver);
    js.executeScript("arguments[0].scrollIntoView(true);", Save);
    bp.waitForElement();
	
    for(int i=0;i<=projectName.length-1;i++)
     {
             
    try
    { 
    String project=assignProj1+projectName[i]+assignProj2;
    WebDriverWait wait1 =new WebDriverWait(driver,10);
    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(project)));
    WebElement ele=driver.findElement(By.xpath(project));
    Actions act=new Actions(driver);
    act.moveToElement(ele).click().perform();
    System.out.println("Project-" + projectName[i] + " selected successfully ");
  
    res=true;
    System.out.println(res);
    }
   
    catch(TimeoutException e)
    {
   System.out.println("Project- " + projectName[i] + " already assigned to user ");  
   
    }    
//    catch(NoSuchElementException e)
//     {
//    System.out.println("Project- " + projectName[i] + " already assigned to user ");  
//    
//     }    
     }                     
     
     bp.waitForElement();
     if(res==true)
     {
    Forward.click();
    bp.waitForElement();

    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.elementToBeClickable(Save));
    Save.click();
    System.out.println("Project assigned to user successfully ");
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


public boolean unAssignProject(String projectName)
{
 try
    {
   bp=new BasePage();
   JavascriptExecutor js = ((JavascriptExecutor) driver);
   js.executeScript("arguments[0].scrollIntoView(true);", Save);
   bp.waitForElement();
   WebDriverWait wait=new WebDriverWait(driver,60);
   Actions act=new Actions(driver);
   act.moveToElement(searchAssignProject).click().sendKeys(projectName).build().perform();
   searchButton2.click();
   boolean check=Selected.isSelected();
   if(check==false)
  {
   Selected.click();
   Backward.click();
   wait.until(ExpectedConditions.elementToBeClickable(Save));
   Save.click();
   bp.waitForElement();
   System.out.println("Project " + projectName + " unassigned to user successfully ");
   }
   else
    {
   System.out.println("Project " + projectName + " already selected ");
   Backward.click();
   wait.until(ExpectedConditions.elementToBeClickable(Save));
   Save.click();
   bp.waitForElement();
   System.out.println("Project " + projectName + " unassigned to user successfully ");  
     } 
    }
 catch(Exception e)
 {
  System.out.println("Project " + projectName + "doesnt exist" );
 }
 return true; 
  }



public boolean deleteProject(String projectName) throws Exception
{
 try
 {
  bp=new BasePage();
  WebElement project=driver.findElement(By.xpath(Project1+projectName+Project2));
  System.out.println(projectName);
  WebDriverWait wait=new WebDriverWait(driver,60);
  String data=project.getText();
  System.out.println(data);
  if(data.equals(projectName))
  {
   bp.waitForElement();
   JavascriptExecutor js=((JavascriptExecutor)driver);
   js.executeScript("arguments[0].scrollIntoView(true);",project );
   project.click();
   bp.waitForElement();
   WebElement delete1=driver.findElement(By.xpath(delete3+projectName+delete4));
   wait.until(ExpectedConditions.elementToBeClickable(delete1));
   delete1.click();
   bp.waitForElement();
   wait.until(ExpectedConditions.visibilityOf(deleteOK));
   deleteOK.click();
   wait.until(ExpectedConditions.visibilityOf(Delete)); 
   Delete.click();
   bp.waitForElement();
   System.out.println("Project " + projectName +  " deleted successfully");
  }
  }
 catch(Exception e)
   {
  e.printStackTrace();
  throw e;
    }
 return true;
}


//public boolean manageUsers() throws Exception
//{
//	try
//	{
//		bp=new BasePage();
//		WebDriverWait wait=new WebDriverWait(driver,60);
//		wait.until(ExpectedConditions.elementToBeClickable(manageUser));
//		manageUser.click();
//		bp.waitForElement();
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//		throw e;
//		
//	}
//	return true;
//}



public boolean checkAvailableUser(String user) throws Exception
{
	try
	{
		
	WebElement ele=(new WebDriverWait(driver, 05))
	.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_1+user+user_2)));
	Actions a1=new Actions(driver);
	a1.moveToElement(ele).click().perform();
	System.out.println(user+"-User is present");
	
	return true;
	}
	catch(TimeoutException e)
	{
		System.out.println(user+"-User is not present");
		return false;
	}
	
		
		
	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
	
}



//
//public boolean createUser(String firstName,String lasTName,String type,String role,String email,String title,String location) throws Exception
//{
// try
// {
//  bp=new BasePage();
//  addNewUser.click();
//  bp.waitForElement();
//  log.info("Pass - Clicked On Add new User Successfully");
//  FirstName.sendKeys(firstName);
//  bp.waitForElement();
//  log.info("Pass - Entered FirstName Successfully");
//  LastName.sendKeys(lasTName);
//  bp.waitForElement();
//  log.info("Pass - Entered LastName Successfully");
//  Select TYPE=new Select(Type);
//  TYPE.selectByVisibleText(type);
//  bp.waitForElement();
//  log.info("Pass - Selected Type Successfully");
//  Select ROLE=new Select(Role);
//  ROLE.selectByVisibleText(role);
//  bp.waitForElement();
//  log.info("Pass - Selected Role Successfully");
//  Email.sendKeys(email);
//  bp.waitForElement();
//  log.info("Pass - Entered Email Successfully");
//  Title.sendKeys(title);
//  bp.waitForElement();
//  log.info("Pass - Entered Title Successfully");
//  Location.sendKeys(location);
//  bp.waitForElement();
//  log.info("Pass - Entered Location Successfully");
//  boolean val=expireCredential.isSelected();
//  if(val==true)
//  {
//   expireCredential.click();
//   System.out.println("Pass-Expire credential un selected");
//  }
//  else
//  {
//   System.out.println("Expire credential in selected mode");
//  }
//  saveNewUser.click();
//  bp.waitForElement();
//  log.info("Pass - New User is Created Successfully");
//  
//  return true; 
// }
// catch(Exception e)
// {
//  e.printStackTrace();
//  throw e;
// }
//}


public boolean assignProject(String projectName) throws Exception
{
 try
 {
    bp=new BasePage();
    JavascriptExecutor js =((JavascriptExecutor) driver);
    js.executeScript("arguments[0].scrollIntoView(true);", Save);
    bp.waitForElement();
    WebDriverWait wait=new WebDriverWait(driver,60);
    Actions act=new Actions(driver);
    act.moveToElement(searchUnassignProject).click().sendKeys(projectName).build().perform();
    searchButton1.click();
    boolean check=unSelected.isSelected();
    if(check==false)
      {
    unSelected.click();
    Forward.click();
    wait.until(ExpectedConditions.elementToBeClickable(Save));
    Save.click();
    bp.waitForElement();
    System.out.println("Project " + projectName + " assigned to user successfully ");
      }
   else
     {
   System.out.println("Project " + projectName + " already selected ");
   Forward.click();
   wait.until(ExpectedConditions.elementToBeClickable(Save));
   Save.click();
   bp.waitForElement();
   System.out.println("Project " + projectName + " assigned to user successfully ");  
     }
  }
 catch(Exception e) 
   {
   System.out.println("Project " + projectName + " doesnt exist");
    }
 return true; 
    }


public boolean backToProjectPage() throws Exception
{
 try
 {
   bp=new BasePage();
   bp.explicitWait(backToProjectPage);
   backToProjectPage.click();
   System.out.println("Pass-Successfully navigated to the project page");
   bp.waitForElement();
   return true; 
 }
 catch (Exception e) {
  e.printStackTrace();
  throw e;
 }
}


public boolean launchManageUsers()
{
 
 try
 {
	 bp=new BasePage();
	 boolean val=launchManageUsers.isEnabled();
	 String expected="User Setup";
	 if(val==true)
	 {
		 launchManageUsers.click();
		 bp.waitForElement();
		 System.out.println("Pass clicked on manage user");
		 bp.waitForElement();
		 String actual=validatManageuser.getText();
		 if(actual.equals(expected))
		 {
			 System.out.println("User in Manage users page");
		 }
		 else
		 {
			 System.out.println("user is not in Manage users Page");
		 }
	 }
	
 }
 catch(Exception e)
 {
	 e.printStackTrace();
 }
 return true;
 
}


public boolean setDTS(String DTS,String url,String username,String password) throws Exception
{
 try
 {
	 bp=new BasePage();
 WebElement ele=driver.findElement(By.xpath("//*[@id='defect-system-select2']"));
 
 Select s1=new Select(ele);
 String value=s1.getFirstSelectedOption().getText();
    System.out.println(value);

 s1.selectByVisibleText(DTS);
 bp.waitForElement();
//*[@colid='username' and @role='gridcell']
 String name=driver.findElement(By.xpath("//*[@colid='username' and @role='gridcell']")).getText();
 if(!name.equals(username))
 {
	
	 editDTS.click();
	 bp.waitForElement();

	 
 driver.findElement(By.xpath("//input[@placeholder='Enter JIRA connection name']")).clear();
 
 driver.findElement(By.xpath("//input[@placeholder='Enter JIRA connection name']")).sendKeys("JIRA");
 
 driver.findElement(By.xpath("//input[@placeholder='Enter JIRA connection URL']")).clear();

 //driver.findElement(By.xpath("//*[@id='dt-url']")).sendKeys(url);
 driver.findElement(By.xpath("//input[@placeholder='Enter JIRA connection URL']")).sendKeys(url);
 //driver.findElement(By.xpath("//*[@id='sampleUsername']")).sendKeys(username);
 driver.findElement(By.xpath("//input[@placeholder='Enter Username']")).clear();
 driver.findElement(By.xpath("//input[@placeholder='Enter Username']")).sendKeys(username);
 //driver.findElement(By.xpath("//*[@id='samplePassword']")).sendKeys(password);
 driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).clear();
 driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(password);
 //driver.findElement(By.xpath("//*[@id='ze-main-app']//zui-admin-defect-tracking/div/div[2]/form/div[3]/div/div[2]/button[2]")).click();
 bp.waitForElement();
 driver.findElement(By.xpath("//i[@title='Save']")).click();
 bp.waitForElement();
 driver.findElement(By.xpath(" (//button[text()='Yes'])[1]")).click();
 bp.waitForElement();
 bp.waitForElement();
 }
 
 
 else
 {
   System.out.println("Already Defect tracking is set to JIRA");
 }
 return true;
 }

 catch (Exception e) 
 {
  e.printStackTrace();
  throw e;
 }

}

public boolean launchDefectAdmin() throws Exception
{
 
 try
 {
	 bp=new BasePage();
	 boolean val=defectAdmin.isEnabled();
	 String expected="Defect Admin";
	 bp.waitForElement();
	 WebDriverWait wait=new WebDriverWait(driver,30);
	 wait.until(ExpectedConditions.elementToBeClickable(defectAdmin));
	 defectAdmin.click();
	 if(val==true)
	 {
		
		 System.out.println("Pass clicked on defect admin");
		 try
		 {
		 String actual=validateDefectAdmin.getText();
		 
		 
		 if(actual.equals(expected))
		 {
			 System.out.println("User in Defect Admini page");
		 }
		 else
		 {
			 System.out.println("user is not in Defect Admin Page");
		 }
		 
		 }catch(Exception e)
		 {
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 System.out.println("Inside Catch block");
			 defectAdmin.click();
			 System.out.println("Pass clicked on defect admin");
		 }
	 }
	 bp.waitForElement();
	
 }
 catch(Exception e)
 {
	 e.printStackTrace();
	 throw e;
 }
 return true;
 
}



public boolean selectProjectInProjectSetup(String projectName) throws Exception
{
  try
 {
    bp=new BasePage();
   
   
    String project=Project1+projectName+Project2;
//    WebDriverWait wait1 =new WebDriverWait(driver,20);
//    wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(project)));
    WebElement ele=driver.findElement(By.xpath(project));
    Actions act=new Actions(driver);
    act.moveToElement(ele).click().perform();
    System.out.println("Project-" + projectName + " selected successfully ");
   return true;
    }
   
    catch(Exception e)
     {
    System.out.println("Project- " + projectName + " is not present ");  
    throw e;
     }    
                          
     


}


//public boolean validateSetDTS() throws Exception
//{
//	try
//	{
//	  bp=new BasePage();
//	  String dtsValue="JIRA";
//	  WebElement ele=driver.findElement(By.xpath("//strong[text()='JIRA']"));
//	  String text=ele.getText();
//	  if(text.equals(dtsValue))
//	  {
//		  System.out.println("Pass-DTS value is validated successfully");
//	  }
//	  return true;	
//	}
//	catch(Exception e)
//	 {
//		 e.printStackTrace();
//		 throw e;
//	 }
//}

public boolean validateSetDTS() throws Exception
{
 try
 {
   bp=new BasePage();
   String dtsValue="JIRA";
   WebElement ele=driver.findElement(By.xpath("//*[@id='defect-system-select2']"));
   Select s1=new Select(ele);
   String text=s1.getFirstSelectedOption().getText();
   //String text=ele.getText();
   if(text.equals(dtsValue))
   {
    System.out.println("Pass-DTS value is validated successfully");
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


//public boolean mapJiraProject(String jiraProjectName) throws Exception
//{
//	try
//	{
//	 Select sel2=new Select(defectProject);
//	   sel2.selectByVisibleText(jiraProjectName);
//	   bp.waitForElement();
//	   bp.explicitWait(Save);
//	   Save.click();
//	   bp.waitForElement();
//	   return true; 
//	 }
//	 catch(Exception e)
//	  {
//	   e.printStackTrace();
//	   throw e;
//	  }
//
//}
public boolean mapJiraProject(String jiraProjectName) throws Exception
{
	try
	{
		bp=new BasePage();
		Select sel2=new Select(defectProject);
		 
		 bp.waitForElement();
		String mappedJiraProjectName=(sel2.getFirstSelectedOption()).getText();
		
		if(!mappedJiraProjectName.equals(jiraProjectName))
		{
	  
	   sel2.selectByVisibleText(jiraProjectName);
	   bp.waitForElement();
	   bp.explicitWait(Save);
	   Save.click();
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



public boolean validateDefectAdmin() throws Exception
{
 try
 {
	 bp=new BasePage();
	 String expected="Defect Admin";
	 bp.waitForElement();
	 String actual=validateDefectAdmin.getText();
		 
		 
		 if(actual.equals(expected))
		 {
			 System.out.println("User in Defect Admini page");
		 }
		 else
		 {
			 System.out.println("user is not in Defect Admin Page");
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

public boolean clearCache() throws Exception
{
	try
	{
	bp=new BasePage();
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.elementToBeClickable(jiraCustomFieldsManagement));
	jiraCustomFieldsManagement.click();
	bp.waitForElement();
	wait.until(ExpectedConditions.elementToBeClickable(clearAll));
	clearAll.click();
	bp.waitForElement();
	wait.until(ExpectedConditions.elementToBeClickable(clearCache));
	clearCache.click();
	bp.waitForElement();
	String text=cacheMsg.getText();
	System.out.println("Cache confirmation message:" +text);
	wait.until(ExpectedConditions.elementToBeClickable(cacheYes));
	cacheYes.click();
	//bp.waitForElement();
	return true;	
	}
	catch(Exception e)
	 {
		 e.printStackTrace();
		 throw e;
	 }
}

public boolean unsetDTS(String dtsType) throws Exception
{
	try
	 {
		 bp=new BasePage();
	 WebElement ele=driver.findElement(By.xpath("//*[@id='defect-system-select2']"));
	 
	 Select s1=new Select(ele);
	 String value=s1.getFirstSelectedOption().getText();
	    //System.out.println(value);
	 if(!value.equals(dtsType))
	 {
	 s1.selectByVisibleText(dtsType);
	 System.out.println(dtsType+ "DTS type selected");
	 }
	 bp.waitForElement();
	 driver.findElement(By.xpath("//button[text()='Save']")).click();
	 bp.waitForElement();
	 driver.findElement(By.xpath(" (//button[text()='Yes'])[3]")).click();
	 bp.waitForElement();
		return true;
      }
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	
}


public boolean selectProject2(String projectName,WebDriver driver2) throws Exception 
{
	try
	{
		
		
		
		this.driver=driver2;
	BasePage bp=new BasePage();
	bp.waitForElement();
	driver.findElement(By.xpath("//*[@id='projectDropDown']")).isEnabled();
	driver.findElement(By.xpath("//*[@id='projectDropDown']")).isDisplayed();
	bp.waitForElement();
	bp.waitForElement();
	WebDriverWait wait2=new WebDriverWait(driver, 100);
	wait2.until(ExpectedConditions.elementToBeClickable(project));
	driver.findElement(By.xpath("//*[@id='projectDropDown']")).click();
	bp.waitForElement();
	
	
	
	 List<WebElement> allp=driver.findElements(By.xpath("(//*[@aria-labelledby='projectDropDown'])/a"));
	 boolean res=false;
	// System.out.println(allp.size());
	 for(int i=0;i<allp.size();i++)
	 {
	  String  pp=allp.get(i).getAttribute("title");
	 
	 if(pp.equals(projectName))
	 {
	  res=true;
	  bp.waitForElement();
	  driver.findElement(By.xpath(project1+projectName+project2)).click();
	  break;
	 }
	 }
	 if(res==false)
	 {
		
		 driver.findElement(By.xpath("//*[text()='Go to Project']")).click();
	   // goToProject.click();
	  bp.waitForElement();
	 // bp.waitForElement();
	 // bp.waitForElement();
	 // WebElement lastprojects=driver.findElement(By.xpath("//li[text()='"+projectName+"']"));
	  Actions a1=new Actions(driver);
	  a1.sendKeys(projectName).pause(1400).sendKeys(Keys.ENTER).perform();
	  
	 }
	 
	 bp.waitForElement();
	 
	  String validate_Project=driver.findElement(By.xpath(valProject1+projectName+valProject2)).getText();

	 if(projectName.equals(validate_Project))
	 {

	  log.info("Pass - '"+projectName+"' Project Is Selected");
	  log.info("Pass - You are in '"+projectName+"' now");
	 }
	 
	  return true;
}
catch(Exception e)
{
 e.printStackTrace();
 throw e;
}

	
		
}

public boolean selectRelease2(String releaseName,WebDriver driver2) throws Exception 
{
	try
	{
		this.driver=driver2;
	BasePage bp=new BasePage();
	bp.waitForElement();
	String validateRelease=driver.findElement(By.xpath(release1+releaseName+release2)).getText();
	driver.findElement(By.xpath(release1+releaseName+release2)).click();
	bp.waitForElement();
	//String validate_Release=driver.findElement(By.xpath(validateRelease)).getText();
	
	if(releaseName.equalsIgnoreCase(validateRelease))
	   {
		 
			log.info("Pass - You are in the "+releaseName);
			//System.out.println("Pass - You are in the '"+releaseName+"' ");
		}
		else
		{
			log.info("Fail - You are not in the "+releaseName);
			//System.out.println("Fail - you are not in the '"+releaseName+"' ");

		}
	return true;
}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}

	
	
}

public boolean clickOnLogout(WebDriver driver2) throws Exception {
	  try {
	   this.driver=driver2;
	   BasePage bp=new BasePage();
	   bp.waitForElement();

	   driver.findElement(By.xpath("//span[@class='zui-user-name']")).click();
	   
	   bp.waitForElement();
	   driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
	   
	   System.out.println("Successfully logout from the application");
	   bp.waitForElement();
	   driver.close();
	   return true;
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	 


	 }


}