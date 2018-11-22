package com.zephyr.reusablemethods;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

import com.zephyr.common.LaunchBrowser;
import com.zephyr.pom.CreateCustomFieldsPage_POM;
import com.zephyr.pom.ExecutionPage_POM;

public class CreateCustomFieldsPage{
	WebDriver driver = null;
	public Logger log;
	BasePage bp;
	TestRepositoryPage tr;

	public CreateCustomFieldsPage(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver, this);
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}

////////////////////POM///////////////////
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
//***6.1 X-Path***//
@FindBy(xpath = "//a[@title='User Setup']")
public WebElement manageUsers;

//**6.0 Xpath**//
//@FindBy(xpath="//*[@id='sidr']/ul/li[2]/ul/li/a/span")
//public WebElement manageUsers;

//**6.0 Xpath**//
//@FindBy(xpath="//*[@id='ze-main-app']/resource-management/resource-management-details/div/section/div[2]/button")
//public WebElement addNewUser;

//***6.1 X-Path***//
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

//*********6.0 X Path******//
//@FindBy(xpath="//*[@id='ze-main-app']/resource-management/resource-management-details/div/div/div[2]/div/div/resource-form/div/form/div[3]/button[2]")
//public WebElement saveNewUser;

//*********6.1 X Path******//
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
//@FindBy(xpath="//*[@id='defect-system-select2']")
//public WebElement dashboardUrl;
//@FindBy(xpath="//input[@placeholder='Enter JIRA connection name']")
//public WebElement dashboardUrl;
//@FindBy(xpath="//input[@placeholder='Enter JIRA connection name']")
//public WebElement dashboardUrl;
//@FindBy(xpath="//input[@placeholder='Enter JIRA connection URL']")
//public WebElement dashboardUrl;





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

	
	/*
	 * **************************************************** Method Name :
	 * moveToCustomFields() Purpose : move to the Custom Fields Author : OPAL
	 * Date Created : 10/08/17 Date Modified : Reviewed By :
	 * ******************************************************
	 */

	
	public boolean editCustomStaus(String name,String value,String colour) throws Exception
	   {
	    try
	    {
	     WebElement ele=driver.findElement(By.xpath(customName1+name+customName2));
	     ele.click();
	     
	    if(value!="")
	    {
	   bp.waitForElement();
	   bp.eraseText(statusValue);
	   statusValue.sendKeys(value);
	   System.out.println("Pass - Execution Status Value Entered Successfully");
	    }
	     
	   if(colour!="")
	     {
	      StatusColour.click();
	   bp.waitForElement();
	   
	   if(colour.equalsIgnoreCase("Blue"))
	   {
	   Actions a1=new Actions(driver);
	   a1.moveToElement(StatusColourPicker).sendKeys(Keys.DOWN).pause(1200).click().perform();
	   }
	   else
	   {
	    Actions a1=new Actions(driver);
	    a1.moveToElement(StatusColourPicker).sendKeys(Keys.DOWN).pause(1200).perform();
	    a1.sendKeys(Keys.DOWN).pause(1200).click().perform();
	    
	   }
	   }
	   //epm.colourChoose.click();
	   bp.waitForElement();
	   
	   
	   bp.waitForElement();
	   StatusSaveButton.click();
	   bp.waitForElement();
	   statusConfirmSave.click();
	   System.out.println("Pass - Custom Status Edited Successfully");
	   bp.waitForElement();
//	   closeExecutionStatusPage.click();
//	   bp.waitForElement();
	   return true;
	   }
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	   
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean moveToCustomFields() throws Exception {
		try {
			bp = new BasePage();
			
			bp.waitForElement();
			administration.click();
			log.info("Pass - Clicked On Administartion Successfully");
			bp.waitForElement();
			customizations.click();
			log.info("Pass - Clicked On Customizations Option Successfully");
			bp.waitForElement();
			testcaseFields.click();
			log.info("Pass - Clicked On Fields Option in Testcases Division Successfully");
			bp.waitForElement();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	public boolean validateCategories(String name,String value) throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		String expectedName=driver.findElement(By.xpath(name1+name+name2)).getText();
		String result=driver.findElement(By.xpath(validation1+name+validation2)).getText();
		if(name.equals(expectedName) && value.equals(result))
		{
			System.out.println("categories"+name+"is successfully validated");
			System.out.println("Categories"+value+"is successfully validated");
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	
	
	
	
	
	/*
	 * **************************************************** Method Name :
	 * lockZephyr() Purpose : Locks the zephyr application stop access for other
	 * users Author : OPAL Date Created : 10/08/17 Date Modified : Reviewed By :
	 * ******************************************************
	 */
	public boolean lockZephyrAccess() throws Exception {
		try {
			bp = new BasePage();
			lockZephyrAccess.click();
			bp.waitForElement();
			confirmLockZephyrAccess.click();
			bp.waitForElement();
			log.info("Pass - Manager locked the Zephyr Access for other users Successfully");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/*
	 * **************************************************** Method Name :
	 * createCustomFields() Purpose : Creates new custom fields for the Testcase
	 * Author : OPAL Date Created : 11/08/17 Date Modified : Reviewed By :
	 * ******************************************************
	 */

	public boolean createCustomFields(String customfieldName, String customfieldDescription, String dataType,
			String piclistValues[], String allProject, String projectName, String searchableCheck, String unique,
			String mandatory) throws Exception {
		try {
			bp = new BasePage();
			addNewCustomField.click();
			bp.waitForElement();
			log.info("Pass - Clicked on Add new Custom Field");

			customFieldName.click();
			bp.waitForElement();
			customFieldName.sendKeys(customfieldName);
			bp.waitForElement();
			log.info("Pass - New CustomField Name entered Successfully");

			customFieldDescription.click();
			bp.waitForElement();
			customFieldDescription.sendKeys(customfieldDescription);
			bp.waitForElement();
			log.info("Pass - New CustomField Description is entered Successfully");

			Select sel = new Select(datatypeDropDown);
			sel.selectByVisibleText(dataType);
			if (dataType.equals("Picklist")) {
				picklistValues.click();
				bp.waitForElement();
				log.info("Pass - Picklist datatype is checked Successfully");
				int k = piclistValues.length;
				for (int i = 0; i <= k - 1; i++) {
					picklistValues.sendKeys(piclistValues[i]);
					bp.waitForElement();
					addPicklistValues.click();
					bp.waitForElement();
					log.info("Pass - Picklist Values are added Successfully");
				}
			}
			bp.waitForElement();
			log.info("Pass - Data type '" + dataType + "' Selected Successfully");

			if (allProject.equals("allProject")) {
				checkAllProject.click();
				bp.waitForElement();
				log.info("Pass - Checkbox is checked for '" + allProject + "' in Custom Fields");
			} else {
				projectAssociation.click();
				bp.waitForElement();
				Actions a1 = new Actions(driver);
				a1.sendKeys(projectName).sendKeys(Keys.ENTER).build().perform();
				// projectAssociation.sendKeys(projectName);
				log.info("Pass - Selected the '" + projectName + "' in Project Association");
			}

			if (searchableCheck.equals("searchable")) {
				searchable.click();
				bp.waitForElement();
				log.info("Pass - Checkbox is checked for '" + searchableCheck + "' in Custom Fields");
			} else {
				log.info("Pass - 'Searchable' cant be Applicable for Number Datatype");
			}

			if (unique.equals("Unique")) {
				uniqueCheckBox.click();
				bp.waitForElement();
				log.info("Pass - Unique is checked for '" + customfieldName + "' in Custom Fields");
			}

			if (mandatory.equals("Mandatory")) {
				mandatoryChk.click();
				bp.waitForElement();
				log.info("Pass - Mandatory is checked for '" + customfieldName + "' in Custom Fields");
			}
			bp.waitForElement();
			saveCustomField.click();
			bp.waitForElement();
			bp.waitForElement();
			log.info("Pass - Custom Field is Created with '" + dataType + "' Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * **************************************************** Method Name :
	 * moveTocreateCustomUser() Purpose : Creates new custom fields for the
	 * Testcase Author : OPAL Date Created : 11/08/17 Date Modified : Reviewed
	 * By : ******************************************************
	 */

	public boolean moveToCreateCustomUser() throws Exception {
		try {
			bp = new BasePage();
			
			administration.click();
			bp.waitForElement();
			log.info("Pass - Clicked On Administartion Successfully");
			manageUsers.click();
			bp.waitForElement();
			log.info("Pass - Clicked On manage Users Successfully");

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * **************************************************** Method Name :
	 * createCustomUser() Purpose : Creates new custom fields for the Testcase
	 * Author : OPAL Date Created : 11/08/17 Date Modified : Reviewed By :
	 * ******************************************************
	 */

	public boolean createCustomUser(String firstName, String lasTName, String type, String role, String email,
			String title, String location) throws Exception {
		try {
			bp = new BasePage();
			addNewUser.click();
			bp.waitForElement();
			log.info("Pass - Clicked On Add new User Successfully");
			FirstName.sendKeys(firstName);
			bp.waitForElement();
			log.info("Pass - Entered FirstName Successfully");
			LastName.sendKeys(lasTName);
			bp.waitForElement();
			log.info("Pass - Entered LastNmae Successfully");
			Select TYPE = new Select(Type);
			TYPE.selectByVisibleText(type);
			bp.waitForElement();
			log.info("Pass - Selected Type Successfully");
			Select ROLE = new Select(Role);
			ROLE.selectByVisibleText(role);
			bp.waitForElement();
			log.info("Pass - Selected Role Successfully");
			Email.sendKeys(email);
			bp.waitForElement();
			log.info("Pass - Entered Email Successfully");
			Title.sendKeys(title);
			bp.waitForElement();
			log.info("Pass - Entered Title Successfully");
			Location.sendKeys(location);
			bp.waitForElement();
			log.info("Pass - Entered Location Successfully");
			saveNewUser.click();
			bp.waitForElement();
			log.info("Pass - New User is Created Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean checkAvailableCustomFields(String customFields) throws Exception {
		try {
			try {
				WebElement customFieldName = (new WebDriverWait(driver, 05))
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customField1 + customFields + customField2)));

				boolean res = customFieldName.isDisplayed();

				String customFieldText = customFieldName.getText();

				if (customFields.equals(customFieldText)) {
					System.out.println("Custom Field/Status-" + customFields + "- already present in project");
				}

			}

			catch (TimeoutException e) {
				System.out.println("Custom Field/Status-" + customFields + " is not present");
				return false;

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public boolean clickOnExecutionStatusTab() throws Exception {
		try {
			bp = new BasePage();
			executionButton.click();
			System.out.println("Pass - Clicked On Execution Status Tab Successfully");
			bp.waitForElement();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public boolean clickOnStepExecutionStatusTab() throws Exception {
		try {
			bp = new BasePage();
			executionStepButton.click();
			System.out.println("Pass - Clicked On Execution Status Tab Successfully");
			bp.waitForElement();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public boolean enterPicklistValues(String customName, String[] piclistValues) throws Exception {
		try {

			WebElement customFieldName = driver.findElement(By.xpath(customField1 + customName + customField2));
			customFieldName.click();
			picklistValues.click();
			bp.waitForElement();
			log.info("Pass - Picklist datatype is checked Successfully");
			int k = piclistValues.length;
			for (int i = 0; i <= k - 1; i++) {
				picklistValues.sendKeys(piclistValues[i]);
				bp.waitForElement();
				addPicklistValues.click();
				bp.waitForElement();
				log.info("Pass - Picklist Values are added Successfully");
			}

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean saveCustomFeilds() throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(saveCustomFields));
			saveCustomFields.click();
			bp.waitForElement();
		} catch (Exception e) {
			bp.waitForElement();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(saveCustomFields));
			cancelCustomFields.click();
			bp.waitForElement();
			System.out.println("Clicked on Cancel button successfully");
		}
		return true;
	}

	
	public boolean addCustomRole(String name, String Description, String administrationApps, String projectApps)
			throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();
			
			//clickonRole.click();
			log.info("Pass-Clicked on Role successfully");
			bp.waitForElement();
			addNewRole.click();
			System.out.println("Pass-Clicked on Add New Role Successfully");
			bp.waitForElement();
			if (name != "") {
				bp.explicitWait(addRoleName);
				addRoleName.click();
				addRoleName.clear();
				addRoleName.sendKeys(name);
				System.out.println("Pass-Role Name entered successfully");
			}
			if (Description != "") {

				bp.explicitWait(addRoleDesc);
				addRoleDesc.click();
				addRoleDesc.clear();
				addRoleDesc.sendKeys(Description);
				System.out.println("Pass-Role Description entered successfully");
			}
			driver.findElement(By.xpath(administrationApps1 + administrationApps + administrationApps2)).click();
			System.out.println("Pass-clicked On" + administrationApps + "Successfully");
			bp.waitForElement();
			if(projectApps!="")
			{
			driver.findElement(By.xpath(administrationApps1 + projectApps + administrationApps2)).click();
			System.out.println("Pass-clicked" + projectApps + "Successfully");
			}
			bp.waitForElement();
			clickonAdd.click();
			System.out.println("Pass-Clicked Successfully Added New Role");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean editCategories(String category, String name, String value, String active) throws Exception {
		try {
			bp = new BasePage();
			bp.waitForElement();
			if(category!="")
			{
			driver.findElement(By.xpath(categories1 + category + categories2)).click();
			System.out.println("Clicked on" + category + "Successfully");
			}
			if(name!="")
			{
			driver.findElement(By.xpath(name1 + name + name2)).click();
			System.out.println("Pass-Clicked on" + name + "Successfully");
			}
			bp.waitForElement();
			if (value != "") {
				bp.explicitWait(enterPreferenceValue);
				// WebElement
				// ele=driver.findElement(By.xpath("//*[@id='preference-value']"));
				// JavascriptExecutor js=((JavascriptExecutor)driver);
				// js.executeScript("arguments[0].scrollIntoView(true);",ele );
				// WebDriverWait wait=new WebDriverWait(driver,60);
				// wait.until(ExpectedConditions.visibilityOf(ele));
				// ele.click();
				enterPreferenceValue.click();
				System.out.println("Clicked on" + value + "Successfully");
				enterPreferenceValue.clear();
				enterPreferenceValue.sendKeys(value);
				System.out.println("Successfully-Passed" + value);
			}
			bp.waitForElement();
			
			if(active!="")
			{
			driver.findElement(By.xpath(active1 + active + active2)).click();
			System.out.println("Selected" + active + "Successfylly");
			}
			savePreference.click();
			System.out.println("Clicked On Save Button");
			bp.waitForElement();
			clickOnSavePreference.click();
			System.out.println("Successfully Saved Preference");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	
	public boolean enableCustomFields(String linkType) throws Exception
	   {
	    
	    try
	    {
	    WebElement ele=driver.findElement(By.xpath(jiraLink1+linkType+jiraLink2));
	    WebDriverWait wait=new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(ele));
	    ele.click();
	    bp.waitForElement();
	    String text=ele.getText();
//	    //System.out.println(text);
	    	
	    	
	    if(text.equals(linkType))
	    {
	    		WebElement data=driver.findElement(By.xpath(customValue1+linkType+customValue2));
	            String display=data.getText();
	            System.out.println(display);
	            
	            if(display.equals("true"))
	            {
	            	WebElement ele1=driver.findElement(By.xpath(Checkbox));
	            	//WebElement ele1=driver.findElement(By.xpath(jiraLinkCheckbox1+i+jiraLinkCheckbox2));
	            	//WebDriverWait wait1=new WebDriverWait(driver, 30);
	            	 //wait1.until(ExpectedConditions.elementToBeClickable(ele1));
	            	Actions act=new Actions(driver);
	            	bp.waitForElement();
	            	
	            	boolean res=ele1.isSelected();
			    	 if(res==false)
				    {
			    		
			    		act.moveToElement(ele1).click().build().perform();
				    System.out.println(linkType+"- Enabled");
				   } 
			    	 else
	 			    	{
	 			    	System.out.println("Already in Enabled Mode");
	 			    	}  	
	            }
	            	
	 			    else
	 			    {
	 			    	
	 			    	WebElement ele1=driver.findElement(By.xpath(Checkbox));
	 			    	bp.waitForElement();
	 			    	Actions act=new Actions(driver);
	 			    	act.moveToElement(ele1).click().build().perform();
		            	bp.waitForElement();
		            	wait.until(ExpectedConditions.elementToBeClickable(Value));
					    Value.click();
					    Value.clear();
					    System.out.println(Value);
				    	Value.sendKeys("true");
				    	bp.waitForElement();
				    	ele1.click();
				    	wait.until(ExpectedConditions.elementToBeClickable(Save));
				    	Save.click();
				    	wait.until(ExpectedConditions.elementToBeClickable(Save1));
				    	Save1.click();
				    	System.out.println(Value+"Succesfully Entered");
		 			    boolean res1=ele1.isSelected();
		 			    if(res1==true)
		 			    {
		 			    	act.moveToElement(ele1).click().build().perform();
		 			    System.out.println(linkType+"- Enabled"); 
	 			          }
		 			    else
		 			    	{
		 			    	System.out.println("Already in Enabled Mode");
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

	public boolean disableCustomFields(String linkType) throws Exception
	   {
	    
	    try
	    {
	    WebElement ele=driver.findElement(By.xpath(jiraLink1+linkType+jiraLink2));
	    WebDriverWait wait=new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(ele));
	    ele.click();
	    bp.waitForElement();
	    String text=ele.getText();
//	    //System.out.println(text);
	    	
	    	
	    if(text.equals(linkType))
	    {
	    		WebElement data=driver.findElement(By.xpath(customValue1+linkType+customValue2));
	            String display=data.getText();
	            System.out.println(display);
	            
	            if(display.equals("false"))
	            {
	            	WebElement ele1=driver.findElement(By.xpath(Checkbox));
	            	//WebElement ele1=driver.findElement(By.xpath(jiraLinkCheckbox1+i+jiraLinkCheckbox2));
	            	//WebDriverWait wait1=new WebDriverWait(driver, 30);
//	            	 wait1.until(ExpectedConditions.elementToBeClickable(ele1));
	            	Actions act=new Actions(driver);
	            	bp.waitForElement();
	            	
	            	boolean res=ele1.isSelected();
			    	 if(res==true)
				    {
			    		
			    		act.moveToElement(ele1).click().build().perform();
				    System.out.println(linkType+"- Disabled");
				   } 
			    	 else
	 			    	{
	 			    	System.out.println("Already in Disabled Mode");
	 			    	}  	
	            }
	            	
	 			    else
	 			    {
	 			    	
	 			    	WebElement ele1=driver.findElement(By.xpath(Checkbox));
	 			    	bp.waitForElement();
	 			    	Actions act=new Actions(driver);
	 			    	act.moveToElement(ele1).click().build().perform();
		            	bp.waitForElement();
		            	wait.until(ExpectedConditions.elementToBeClickable(Value));
					    Value.click();
					    Value.clear();
					    System.out.println(Value);
				    	Value.sendKeys("false");
				    	bp.waitForElement();
				    	ele1.click();
				    	wait.until(ExpectedConditions.elementToBeClickable(Save));
				    	Save.click();
				    	wait.until(ExpectedConditions.elementToBeClickable(Save1));
				    	Save1.click();
				    	System.out.println(Value+"Succesfully Entered");
		 			    boolean res1=ele1.isSelected();
		 			    if(res1==true)
		 			    {
		 			    	act.moveToElement(ele1).click().build().perform();
		 			    System.out.println(linkType+"- Disabled"); 
	 			          }
		 			    else
		 			    	{
		 			    	System.out.println("Already in Disabled Mode");
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
	
	public boolean editCustomFields(String linkType,String linkValue) throws Exception
	{
		try
		{
		bp=new BasePage();
		WebElement ele=driver.findElement(By.xpath(jiraLink1+linkType+jiraLink2));
	    WebDriverWait wait=new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.elementToBeClickable(ele));
	    ele.click();
	    bp.waitForElement();
	    String text=ele.getText();
	    if(text.equals(linkType))
	    {
	    	Value.click();
		    Value.clear();
		    System.out.println(Value);
	    	Value.sendKeys(linkValue);
	    	bp.waitForElement();
	    	wait.until(ExpectedConditions.elementToBeClickable(Save));
	    	Save.click();
	    	wait.until(ExpectedConditions.elementToBeClickable(Save1));
	    	Save1.click();
	    	System.out.println(Value+"Succesfully Entered");	
	    	bp.waitForElement();
	    	System.out.println("Pass-Custom Field value'"+linkValue+"' is edited successfully");
	    }
		return true;	
		}
		 catch(Exception e)
		   {
		    e.printStackTrace();
		      throw e;
		   }
		
	}
	
	public boolean selectCategory(String categoryName) throws Exception
	{
	 try
	 {
	 bp=new BasePage();
	 WebDriverWait wait=new WebDriverWait(driver,60);
	 wait.until(ExpectedConditions.elementToBeClickable(defectAdmin));
	 defectAdmin.click();
	 System.out.println("Pass - Clicked On Defect Admin Successfully");
	 bp.waitForElement();
	 preferences.click();
	 System.out.println("Pass - Clicked On Preferences Option Successfully");
	 bp.waitForElement();
	 WebElement ele=driver.findElement(By.xpath(selectCategory1+categoryName+selectCategory2));
	 wait.until(ExpectedConditions.elementToBeClickable(ele));
	 ele.click();
	 System.out.println("Pass - Clicked On '"+categoryName+"' Category Option Successfully");
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
	 bp.waitForElement();
	 return true; 
	 }
	 catch(Exception e)
	  {
	   e.printStackTrace();
	   throw e;
	  }
	}
	
	
	public boolean enterAcessURl(String desktop_URL,String dasboard_URL) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			Actions a1=new Actions(driver);
			bp.eraseText(desktopURL);
			a1.sendKeys(desktop_URL).perform();
			bp.waitForElement();
			bp.eraseText(dashboardUrl);
			a1.sendKeys(dasboard_URL).sendKeys(Keys.TAB).build().perform();

		return true; 
		}
		 catch(Exception e)
		  {
		   e.printStackTrace();
		   throw e;
		  }
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
	 if(!value.equals(DTS))
	 {
	 s1.selectByVisibleText(DTS);
	 
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
	
	
	public boolean Enable_disabledStatus(String status) throws Exception
	{
		try
		{
		bp=new BasePage();
		driver.findElement(By.xpath(statusEnableDisabel1+status+statusEnableDisabel2)).click();
		
		bp.waitForElement();
		updateStatus.click();
		
		System.out.println("Execution Status "+status+" Enabled/disabled sucessfully");
		bp.waitForElement();
		bp.waitForElement();
		closeExecutionStatusPage.click();
		bp.waitForElement();
		return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			throw e;
		}
	}
	



/*****************************13/10/17 Jira Requirement******************************/
public boolean DisableJiraLinkIssue(String linkType) throws Exception
   {
    
    try
    {
    for(int i=17;i<=20;i++)
    {
    WebElement ele=driver.findElement(By.xpath(jiraLink1+i+jiraLink2));
    
    String text=ele.getText();
    
    if(text.equals(linkType))
    {
    WebElement ele1=driver.findElement(By.xpath(jiraLinkCheckbox1+i+jiraLinkCheckbox2));
    boolean res=ele1.isSelected();
    if(res==true)
    {
    ele1.click();
    System.out.println(linkType+"- Disabled");
    
     
    }
    
   /* else
    {
     ele1.click();
     System.out.println(linkType+"- Enabled");
    }*/
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


//public boolean EnableJiraLinkIssue(String linkType) throws Exception
//   {
//    
//    try
//    {
//    for(int i=17;i<=20;i++)
//    {
//    WebElement ele=driver.findElement(By.xpath(jiraLink1+i+jiraLink2));
//    
//    String text=ele.getText();
//    
//    if(text.equals(linkType))
//    {
//    WebElement ele1=driver.findElement(By.xpath(jiraLinkCheckbox1+i+jiraLinkCheckbox2));
//    boolean res=ele1.isSelected();
//    if(res==false)
//    {
//    ele1.click();
//    System.out.println(linkType+"- Enabled");
//    
//    }
//
//    }
//   }
//      
//   return true;
//   } 
//   catch(Exception e)
//   {
//    e.printStackTrace();
//      throw e;
//   }
//}
public boolean EnableJiraLinkIssue(String linkType) throws Exception
{
 
 try
 {
 WebElement ele=driver.findElement(By.xpath(jiraLink1+linkType+jiraLink2));
 WebDriverWait wait=new WebDriverWait(driver, 20);
 wait.until(ExpectedConditions.elementToBeClickable(ele));
 ele.click();
 bp.waitForElement();
 String text=ele.getText();
// //System.out.println(text);
 	
 	
 if(text.equals(linkType))
 {
 		WebElement data=driver.findElement(By.xpath(customValue1+linkType+customValue2));
         String display=data.getText();
         System.out.println(display);
         
         if(display.equals("true"))
         {
         	WebElement ele1=driver.findElement(By.xpath(Checkbox));
         	//WebElement ele1=driver.findElement(By.xpath(jiraLinkCheckbox1+i+jiraLinkCheckbox2));
         	//WebDriverWait wait1=new WebDriverWait(driver, 30);
         	 //wait1.until(ExpectedConditions.elementToBeClickable(ele1));
         	Actions act=new Actions(driver);
         	bp.waitForElement();
         	
         	boolean res=ele1.isSelected();
		    	 if(res==false)
			    {
		    		
		    		act.moveToElement(ele1).click().build().perform();
			    System.out.println(linkType+"- Enabled");
			   } 
		    	 else
			    	{
			    	System.out.println("Already in Enabled Mode");
			    	}  	
         }
         	
			    else
			    {
			    	
			    	WebElement ele1=driver.findElement(By.xpath(Checkbox));
			    	bp.waitForElement();
			    	Actions act=new Actions(driver);
			    	act.moveToElement(ele1).click().build().perform();
	            	bp.waitForElement();
	            	wait.until(ExpectedConditions.elementToBeClickable(Value));
				    Value.click();
				    Value.clear();
				    System.out.println(Value);
			    	Value.sendKeys("true");
			    	bp.waitForElement();
			    	ele1.click();
			    	wait.until(ExpectedConditions.elementToBeClickable(Save));
			    	Save.click();
			    	wait.until(ExpectedConditions.elementToBeClickable(Save1));
			    	Save1.click();
			    	System.out.println(Value+"Succesfully Entered");
	 			    boolean res1=ele1.isSelected();
	 			    if(res1==true)
	 			    {
	 			    	act.moveToElement(ele1).click().build().perform();
	 			    System.out.println(linkType+"- Enabled"); 
			          }
	 			    else
	 			    	{
	 			    	System.out.println("Already in Enabled Mode");
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


public boolean navigatingToGeneralConfigurationTab() throws Exception
{
	try
	{
		bp=new BasePage();
		ExecutionPage_POM epm=new ExecutionPage_POM(driver);
	CreateCustomFieldsPage_POM cpm =new CreateCustomFieldsPage_POM(driver);
	
//	cpm.adminSetting.click();
//	System.out.println("Pass - Clicked On Administartion Setting Successfully");
	bp.waitForElement();
	cpm.administration.click();
	System.out.println("Pass - Clicked On Administartion Successfully");
	bp.waitForElement();
	epm.defectsAdmin.click();
	System.out.println("Pass - Clicked On Defect Admin Option Successfully");
	bp.waitForElement();

	preferences.click();
	System.out.println("Pass - Clicked On Preferences Option Successfully");
	bp.waitForElement();
	epm.generalConfiguration.click();
	System.out.println("Pass - Clicked On General Configuration Option Successfully");
	bp.waitForElement();
	
	/*executionButton.click();
	System.out.println("Pass - Clicked On Execution Status Tab Successfully");
	bp.waitForElement();*/
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}



public boolean disabledStatus(String status) throws Exception
{
	try
	{
	bp=new BasePage();
	driver.findElement(By.xpath(statusEnableDisabel1+status+statusEnableDisabel2)).click();
	bp.waitForElement();
	updateStatus.click();
	System.out.println("Execution Status "+status+" disabled sucessfully");
	bp.waitForElement();
	bp.explicitWait(closeExecutionStatusPage);
	closeExecutionStatusPage.click();
	System.out.println("Execution Status Page closed sucessfully");
	bp.waitForElement();
	return true;
	}
	catch(Exception e)
	{
		
		throw e;
		//return false;
	}
}

public boolean createCustomStaus(String value,String colour) throws Exception
{
	try
	{
	bp=new BasePage();
    addStatusButton.click();

System.out.println("Pass - Clicked On Add Execution Status Button Successfully");
bp.waitForElement();
statusValue.sendKeys(value);
System.out.println("Pass - Execution Status Value Entered Successfully");
StatusColour.click();
bp.waitForElement();

if(colour.equalsIgnoreCase("Blue"))
{
Actions a1=new Actions(driver);
a1.moveToElement(StatusColourPicker).sendKeys(Keys.DOWN).pause(1200).click().perform();
}
else
{
	Actions a1=new Actions(driver);
	a1.moveToElement(StatusColourPicker).sendKeys(Keys.DOWN).pause(1200).perform();
	a1.sendKeys(Keys.DOWN).pause(1200).click().perform();
	
	
}
//epm.colourChoose.click();
bp.waitForElement();


bp.waitForElement();
StatusSaveButton.click();
bp.waitForElement();
statusConfirmSave.click();
System.out.println("Pass - Custom Status-"+value+" Created Successfully");
bp.waitForElement();
return true;
}
catch(Exception e)
{
	e.printStackTrace();
	throw e;
}

}

public boolean navigatingToCustomizationStatusTab() throws Exception
{
	try
	{
		bp=new BasePage();
	CreateCustomFieldsPage_POM cpm =new CreateCustomFieldsPage_POM(driver);
	
//	cpm.adminSetting.click();
//	System.out.println("Pass - Clicked On Administartion Setting Successfully");
	bp.waitForElement();
	cpm.administration.click();
	System.out.println("Pass - Clicked On Administartion Successfully");
	bp.waitForElement();
	cpm.customizations.click();
	System.out.println("Pass - Clicked On Customizations Option Successfully");
	bp.waitForElement();
	
	
	
//	executionButton.click();
//	System.out.println("Pass - Clicked On Execution Status Tab Successfully");
//	bp.waitForElement();
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
//
public boolean moveToPreferences() throws Exception
{
 try
 {
 bp=new BasePage();
 WebDriverWait wait=new WebDriverWait(driver,60);
 wait.until(ExpectedConditions.elementToBeClickable(defectAdmin));
 defectAdmin.click();
 System.out.println("Pass - Clicked On Defect Admin Successfully");
 bp.waitForElement();
 preferences.click();
 System.out.println("Pass - Clicked On Preferences Option Successfully");
 bp.waitForElement();
// WebElement ele=driver.findElement(By.xpath(selectCategory1+categoryName+selectCategory2));
// wait.until(ExpectedConditions.elementToBeClickable(ele));
// ele.click();
// System.out.println("Pass - Clicked On '"+categoryName+"' Category Option Successfully");
// bp.waitForElement();
 return true; 
 }
 catch(Exception e)
  {
   e.printStackTrace();
   throw e;
  }
 
}

public boolean createUser(String firstName,String lasTName,String type,String role,String email,String title,String location) throws Exception
{
 try
 {
  bp=new BasePage();
  addNewUser.click();
  bp.waitForElement();
  log.info("Pass - Clicked On Add new User Successfully");
  FirstName.sendKeys(firstName);
  bp.waitForElement();
  log.info("Pass - Entered FirstName Successfully");
  LastName.sendKeys(lasTName);
  bp.waitForElement();
  log.info("Pass - Entered LastName Successfully");
  Select TYPE=new Select(Type);
  TYPE.selectByVisibleText(type);
  bp.waitForElement();
  log.info("Pass - Selected Type Successfully");
  Select ROLE=new Select(Role);
  ROLE.selectByVisibleText(role);
  bp.waitForElement();
  log.info("Pass - Selected Role Successfully");
  Email.sendKeys(email);
  bp.waitForElement();
  log.info("Pass - Entered Email Successfully");
  Title.sendKeys(title);
  bp.waitForElement();
  log.info("Pass - Entered Title Successfully");
  Location.sendKeys(location);
  bp.waitForElement();
  log.info("Pass - Entered Location Successfully");
  boolean val=expireCredential.isSelected();
  if(val==true)
  {
   expireCredential.click();
   System.out.println("Pass-Expire credential un selected");
  }
  else
  {
   System.out.println("Expire credential in selected mode");
  }
  saveNewUser.click();
  bp.waitForElement();
  log.info("Pass - New User is Created Successfully");
  
  return true; 
 }
 catch(Exception e)
 {
  e.printStackTrace();
  throw e;
 }
}


public boolean moveToCustomFieldsOfRequirement() throws Exception
{
	try
	{
		bp=new BasePage();
//		adminSetting.click();
//		log.info("Pass - Clicked On Administartion Setting Successfully");
		bp.waitForElement();
		bp.explicitWait(administration);
		administration.click();
		log.info("Pass - Clicked On Administartion Successfully");
		bp.waitForElement();
		bp.explicitWait(customizations);
		customizations.click();
		log.info("Pass - Clicked On Customizations Option Successfully");
		bp.waitForElement();
		bp.explicitWait(reqFields);
		reqFields.click();
		log.info("Pass - Clicked On Fields Option in Testcases Division Successfully");
		bp.waitForElement();
		
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean checkAvailablePropertyName(String category,String name) throws Exception
{
	try
	{
	try
	{
    bp=new BasePage();
    bp.waitForElement();
    if(category!="")
    {
	driver.findElement(By.xpath(categories1+category+categories2)).click();
    }
    if(name!="")
    {
	bp.waitForElement();
	WebElement ele=driver.findElement(By.xpath(name3+name+name4));
	ele.isDisplayed();
	String preferenceName=ele.getText();
	
	if(name.equals(preferenceName))
	{
		System.out.println("PropertyName " +name+  " already Present");
	}
    }
	}
	
	catch(NoSuchElementException e)
	{
		System.out.println("PropertyName is not present");
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

public boolean addNewProperty(String category,String name,String value) throws Exception
{
	try
	{
	    bp=new BasePage();
	    bp.waitForElement();
	    if(category!="")
	    {	
		driver.findElement(By.xpath(categories1+category+categories2)).click();
		System.out.println("Clicked on " +category+ " Successfully");
		bp.waitForElement();
		addPreference.click();
		System.out.println("Successfully-clicked on add preference");
	    }
	    
	    if(name!="")
	    {
		bp.waitForElement();
		Actions act=new Actions(driver);
		act.moveToElement(enterPreferenceName).click().sendKeys(name).perform();
		System.out.println("Added a property " +name+ "Successfully");
	    }
		if(value!="")
		{
		bp.waitForElement();
		Actions act=new Actions(driver);
		act.moveToElement(enterPreferenceValue).click().sendKeys(value).perform();
		System.out.println("Successfully-Passed " +value);
		}
		savePreference.click();
		System.out.println("Clicked On Save Button");
		bp.waitForElement();
		clickOnSavePreference.click();
		System.out.println("Successfully Saved Preference");
	   return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}


public boolean validatePropertyName(String propertyName) throws Exception
{
	try
	{
    bp=new BasePage();
    bp.waitForElement();
   
    	String expectedName=driver.findElement(By.xpath(name3+propertyName+name4)).getText();
    	if(expectedName.equals(propertyName))
    	{
    		System.out.println("Property Name is already present");
    	}
    	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean editCategoriesOperation(String category,String name,String value,String active) throws Exception
{
	
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		if(category!="")
		{
		driver.findElement(By.xpath(categories1+category+categories2)).click();
		System.out.println("Clicked on"+category+"Successfully");
		}
		if(name!="")
		{
		driver.findElement(By.xpath(name1+name+name2)).click();
		System.out.println("Pass-Clicked on"+name+"Successfully");
		}
		if(value!="")
		{
		bp.explicitWait(enterPreferenceValue);
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
		}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}		
}


public boolean checkAvailableCustomFieldsInJira(String customField) throws Exception
{
	{
		try
		{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
			String availableCustomField=driver.findElement(By.xpath(customFieldValue1+customField+customFieldValue2)).getText();
			if(customField.equals(availableCustomField))
			{
				System.out.println(customField+ " is already present ");
			}
		}
			catch (NoSuchElementException e) {
				System.out.println(customField + " is not Found ");
				return false;

			}
			return true;
		  } 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		}
}


public boolean editDTS(String DTS,String url,String username,String password) throws Exception
{
 
  try
  {
   bp=new BasePage();
  WebElement ele=dtsType;
  Select s1=new Select(ele);
  String value=s1.getFirstSelectedOption().getText();
     System.out.println(value);
  if(!value.equals(DTS))
  {
  s1.selectByVisibleText(DTS);
  
  }
  
  editDTS.click();
 
  dtsName.clear();
  dtsName.sendKeys("JIRA");
  
  dtsUrl.clear();
     dtsUrl.sendKeys(url);
    
  dtsUname.clear();
  dtsUname.sendKeys(username);
    
  dtsPass.clear();
  dtsPass.sendKeys(password);
 
  bp.waitForElement();
  saveDTS.click();
  bp.waitForElement();
  confirmSave.click();
  bp.waitForElement();
  

  System.out.println("DTS data successfully edited");
 
  return true;
  }

  catch (Exception e) 
  {
   e.printStackTrace();
   throw e;
  }

}

public boolean validateCheckBoxEnabledOrDisabled(String propertyName) throws Exception
{
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	WebElement ele=driver.findElement(By.xpath(validateCheckBox1+propertyName+validateCheckBox2));
	boolean res=ele.isSelected();
	if(res==true)
	{
		System.out.println("Property is Enabled " +res);
	}
	else
	{
		System.out.println("Property is Disabled Successfully");
	}
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}


public boolean clickOnAdvanceSettings() throws Exception
{
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	clickOnAdvanceSettingsInJira.click();
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
public boolean validateClearCacheOfOnlineJIRACustomFields(String name) throws Exception
{
	try
	{
	bp=new BasePage();	
	bp.waitForElement();
	String validation=driver.findElement(By.xpath(validateClearCasheOfOnlineProject1+name+validateClearCasheOfOnlineProject2)).getText();
	if(name.equals(validation))
	{
	System.out.println(validation + " Is Viewed Successfully");
	}
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean validateClearSelectedOrClearAll(String optionName) throws Exception
{
	try
	{
	bp=new BasePage();	
	bp.waitForElement();
	String validation=driver.findElement(By.xpath(clearselected1+optionName+clearselected2)).getText();
	System.out.println(validation + " Is Viewed Successfully");
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}



public boolean checkAvailableKeysValueInJira(String key,String keyValue) throws Exception
{
try
{
try
{
	bp=new BasePage();
	bp.waitForElement();
	String availableKeyValue=driver.findElement(By.xpath(keyValue1+key+keyValue2)).getText();
	if(keyValue.equals(availableKeyValue))
	{
		System.out.println("Key value is already present");
	}
}
	catch (NoSuchElementException e) {
		System.out.println("Key value is not Found");
		return false;

	}
	return true;
  } 
catch (Exception e) {
	e.printStackTrace();
	throw e;
}
}

public boolean changeKeyValues(String key,String keyValue) throws Exception
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(keyValue1+key+keyValue2));
		ele.click();
		ele.clear();
		ele.sendKeys(keyValue);
		bp.waitForElement();
		clickOnUpdate.click();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
		
	}
}


public boolean checkAvailableCategories(String category,String name,String value) throws Exception
{
	try
	{
	try
	{
    bp=new BasePage();
    bp.waitForElement();
    if(category!="")
    {
	driver.findElement(By.xpath(categories1+category+categories2)).click();
    }
    if(name!="" && value!="")
    {
	bp.waitForElement();
	WebElement ele=driver.findElement(By.xpath(name3+name+name4));
	ele.isDisplayed();
	String preferenceName=ele.getText();
	WebElement ele1=driver.findElement(By.xpath(validation1+name+validation2));
	ele1.isDisplayed();
	String preferencevalue=ele1.getText();
	if(name.equals(preferenceName) && value.equals(preferencevalue) )
	{
		System.out.println("Preference " +name+ " and " +value+ " already Present");
	}
    }
	}
	
	catch(NoSuchElementException e)
	{
		System.out.println("Preference is not present");
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


public boolean validateJIRACustomFieldsManagement(String name) throws Exception
{
	try
	{
	bp=new BasePage();	
	bp.waitForElement();
	String validation=driver.findElement(By.xpath(validateJiraCustomFieldsManagement1+name+validateJiraCustomFieldsManagement2)).getText();
	if(name.equals(validation))
	{
	System.out.println(validation + " Is Viewed Successfully ");
	}
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}


public boolean deleteProperty(String category,String propertyName) throws Exception
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		if(category!="")
		{
			driver.findElement(By.xpath(categories1+category+categories2)).click();
			System.out.println("Clicked on " +category+ " Successfully");
		}
		if(propertyName!="")
		{
		WebElement ele=driver.findElement(By.xpath(deleteproperty1+propertyName+deleteproperty2));
		bp.waitForElement();
		ele.click();
		bp.waitForElement();
		deleteYesIcon.click();
		System.out.println(propertyName + "Deleted Successfully");
		}
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
}

public boolean checkAvailableCustomRole(String customRole) throws Exception
{
	try
	{
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	WebElement ele=driver.findElement(By.xpath(customRole1+customRole+customRole2));
	String ele1=ele.getText();
	if(customRole.equals(ele1)) 
	{
		System.out.println("CustomRole"+ele+"is already Present");
	}
	}
	
	catch(NoSuchElementException e)
	{
		System.out.println("CustomRole is not present");
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




		    


}