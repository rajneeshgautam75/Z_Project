package com.zephyr.reusablemethods;




import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
import com.zephyr.pom.TestRepositoryPage_POM;



public class TestRepositoryPage
{
   WebDriver driver=null;
   BasePage bp;
   public Logger log;

   SoftAssert soft=new SoftAssert();
   
	public TestRepositoryPage(WebDriver driver) 
	{
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(LaunchBrowser.driver,this);
		log = Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
//		BasicConfigurator.configure();
	}

	/////////////////////////////POM//////////////////////////
	@FindBy(xpath="//*[@id='tcr-h-resizer-handle']")
	public WebElement dndReleaseArea;
	
//Node Locators
@FindBy(xpath="//div[@class='contextMenuIcon fa fa-ellipsis-v']")
public WebElement options;
	
@FindBy(css="body > ul.vakata-context.jstree-contextmenu.jstree-default-contextmenu > li:nth-child(1) > a")
public WebElement addNode;
	
@FindBy(css="#addNodeName")
public WebElement nodeName;
	
@FindBy(css="#addNodeDescription")
public WebElement nodeDesc;
	
@FindBy(css="#tcrAddNodeModalSave")
public WebElement saveNode;
	

//Test	Case Functionality Locators

@FindBy(xpath="//span[contains(text(),'Detail')]")
public WebElement detail_Tab;

//@FindBy(xpath="//span[contains(.,'                 Detail             ')]")
//public WebElement detail_Tab;		

@FindBy(id="zui-modal-trigger-tcr_1")	
public WebElement add_TestCase;

//@FindBy(id="//*[@id='zui-modal-trigger-tcr_1'][1]")	
//public WebElement addNewTestCase;

@FindBy(xpath="//button[contains(.,'Import')]")	
public WebElement import_TestCase;

//Modified//////
@FindBy(xpath="//*[@id='zui-modal-trigger-tcr_2']")	
public WebElement clone_TestCase;

@FindBy(id="zui-modal-trigger-tcr_4")	
public WebElement delete_TestCase;

@FindBy(xpath="(//button[text()='Delete'])[2]")
public WebElement confirmDeleteTestCaseButton;

@FindBy(id="zui-modal-trigger-tcr_3")	
public WebElement edit_TestCase;

@FindBy(id="zui-export-modal-trigger-tcr_5")
public WebElement export_TestCase;

//@FindBy(id="testcase_select_all")-->previous 01/03/18
@FindBy(id="th-testcase_select_all")//--->new 02/03/18
public WebElement select_all_TestCase;

//@FindBy(id="testcase_select")
//public WebElement select_all_TestCase;

////Modified//
@FindBy(xpath="//span[contains(text(),'List')]")
public WebElement list_Tab;

//@FindBy(xpath="//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/zee-list-detail-view/div/div[2]/a")
//public WebElement list_Tab;

@FindBy(xpath="//span[contains(.,'Search')]")
public WebElement search_Tab;

@FindBy(xpath="//span[contains(.,'Folder')]")
public WebElement folder_Tab;

@FindBy(xpath="//input[@id='tree-view-filter-tcr']")
public WebElement filter_Tab;


//
@FindBy(xpath=".//*[@id='j2_1']/i")
public WebElement exp;

@FindBy(xpath=".//*[@id='j8_1_anchor']/div")
public WebElement option;

@FindAll({@FindBy(xpath="//i[@role='presentation']")})
public List<WebElement> expand;


//@FindBy(xpath=".//*[@id='tcr-grid']//b[3]")
//public WebElement tcCount;


//For selecting Any Node in Release
public String releasename1="//*[@data-name='";
public String releasename2="']";



//for selecting test Case by passing title
public String testcase1="(//div[@title='";
public String testcase2="'])[1]";

public String addNewTestCase="//*[@id='zui-modal-trigger-tcr_1'][1]";




/*	****************************************************
 * Method Name			: findAndAdd()
 * Purpose				: To Click on the ReleaseName of the Project in Zephyr Application
 * Author				: OPAL
 * Date Created			: 27/06/17
 * Date Modified		:
 * Reviewed By			: 
 * ******************************************************
 */
@FindBy(xpath="(//*[text()='Find and Add'])[2]")
public WebElement findAndAdd;

@FindBy(xpath="//*[@id='zql-search-input-tcr-find-add']")
public WebElement advancedSearch;

@FindBy(xpath="//*[text()='Go']")
public WebElement clickOnGo;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/div/div[2]/b[3]")
public WebElement totalNoOfTC;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/div/div[2]/b[2]")
public WebElement pageTc;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/div/div[2]/b[1]")
public WebElement tcLowerCount;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/ul/li[3]/a/span")
public WebElement clickOnNext;

@FindBy(xpath="//*[@id='grid-table-find_add']/div[2]/div[1]/div[1]/div/div/input")
public WebElement clickOnTC;

@FindBy(xpath="(//*[text()='Add'])[2]")
public WebElement clickOnAdd;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement clickAddInDetail;

@FindBy(xpath="//*[@id='find-and-add-modal']/div/div/div[2]/zui-modal-body/grid/div[2]/ul/li[3]/a/span")
public WebElement clickNextInDetail;

//Sorting Locators
@FindBy(xpath="//*[@class='flex-header-item column-chooser-parent dont-sort custom-column-chooser']//i")
public WebElement sortTestCase;



public String moveToNodes="//*[@class='tree-tcr-collapse']";

//public TestRepositoryPage_POM(WebDriver driver)
//{
//		this.driver = driver;
//		PageFactory.initElements(LaunchBrowser.driver,this);
//		
//		
//	}

//Srikant_POM Added

//for selecting page Number
public String pagenumber1="(.//option[text()='";
public String pagenumber2="'])";


//@FindBy(xpath=".//*[@id='tcr-grid']/div/zee-list-detail-view/div/div[1]/a/span")
@FindBy(xpath="//div[@class='zui-tcr-list-detail-view']/div[1]/a/span")
public WebElement clickOnDetailView;

@FindBy(xpath="//span[contains(.,'List')]")
public WebElement clickOnListView;

//@FindBy(xpath=".//*[@id='testcase-fullscreen-resizer']/span")
@FindBy(xpath="//div[@id='testcase-details']/div/div[4]/i")
public WebElement clickOnExpander;

//@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div[1]/div[3]/div/div")
@FindBy(xpath=".//*[@id='grid-table-tcr']/div[2]/div[1]/div[4]/div/div")
public WebElement clickOnTestCase;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li[3]/button")
public WebElement clickOnsystem1;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li/b")
public WebElement clickOnShowBreadCrumbs;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li[2]/button")
public WebElement clickOnPhase;

@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li[1]/button")
public WebElement clickOnRelease;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
public WebElement clickOnPageSize;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']")
public WebElement clickOnOptions;

@FindBy(xpath=".//*[@id='pagination-page-size-tcr']/option[1]")
public WebElement clickOnOption;

@FindBy(xpath=".//*[@id='tcr-grid']//div/zui-tcr-grid/grid/div[2]/ul/li[3]/a/span")
public WebElement clickOnNextButton;

@FindBy(xpath=".//*[@id='tcr-grid']//div/zui-tcr-grid/grid/div[2]/ul/li[2]/a/span")
public WebElement clickOnPrevButton;

@FindBy(xpath=".//*[@id='tcr-grid']//div/zui-tcr-grid/grid/div[2]/ul/span")
public WebElement clickOnPageNumbers;

//@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li")
public String clickOnPages1="//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[";
public String clickOnPages2="]";

@FindBy(xpath="//*[@class='breadcrumb zui-breadcrumb']")
public WebElement breadCrumbs;

//For custom fields in test case
//@FindBy(xpath="//*[text()='Custom Fields']")
@FindBy(xpath="//*[text()='Test Detail']")
public WebElement customFields;

//@FindBy(xpath="//div/zee-custom-fields//strong[contains(@title, 'CustomText')]/following-sibling::span")
@FindBy(xpath="//div/zee-custom-fields//span[contains(@title, 'CustomText')]/following-sibling::span")
protected WebElement custom1;
    

@FindBy(xpath=".//*[@id='1013']/field-input/zephyr-inline-edit/div/div/div/form/div[2]/button[2]")
public WebElement saveCustomField;

//For moving one to another node
@FindBy(xpath="//a[text()='Move']")
protected WebElement moveNode;

@FindBy(xpath="//a[text()='Copy']")
protected WebElement copyNode;


@FindBy(xpath="//a[text()='Paste']")
protected WebElement pasteNode;


//For Advanced search
//@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select")
@FindBy(xpath="//div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select")
public WebElement prevSearchDropDown;

//@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[2]/div[1]/section/div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select/option")
@FindBy(xpath="//div/zui-zephyr-search/div/zui-zql-search/div/div[2]/div/select/option")
public WebElement clickOnPreviousSearch;

///filter subsystem 27-7-2017
@FindBy(xpath="//input[@id='tree-view-filter-tcr']")
public WebElement clickOnFilter;


/***********24/07/17**************/
//For Navigating Pages
@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[2]/a")
public WebElement clickOnPage2;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[3]/a")
public WebElement clickOnPage3;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[4]/a")
public WebElement clickOnPage4;

@FindBy(xpath=".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[5]/a")
public WebElement clickOnPage5;



//For Mapping Requirements
@FindBy(xpath="//*[text()='Mapped Requirements']")
public WebElement clickOnMappedRequirements;

@FindBy(xpath=".//*[@id='mapTest']")
public WebElement clickOnMapReq;

@FindBy(xpath=".//*[@class='jstree-icon jstree-checkbox']")
public WebElement clickOnReleaseNode;

@FindBy(xpath=".//*[@class='jstree-icon jstree-ocl']")
public WebElement nodeExpander;

/*********************27/07/17**************************/
//For Delete in Detail view
@FindBy(xpath=".//*[@id='zui-modal-trigger-tcr_4']")
public WebElement deleteTestcase;

@FindBy(xpath=".//div[@id='zee-delete-modal-tcr_4']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement clicksDelete;



@FindBy(xpath=".//*[@id='zui-modal-trigger-tcr_4']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement deleteMultipleTestCases;

/*********************28/07/17**************************/
//For Deleting Node in Test Repository

@FindBy(xpath="//a[text()='Delete']")
public WebElement deleteNode;

@FindBy(css="#tcrDeleteNodeModalSave")
public WebElement deleteMsg;

@FindBy(xpath=".//*[@id='zee-delete-modal-tcr_4']/div/div/div[3]/zui-modal-footer/button[2]")
public WebElement deleteTestCaseMsg;

//@FindBy(xpath="//a[contains(.,'Rename')]")
//protected WebElement renameNode;

@FindBy(xpath="//input[@name='testcaseNodeName']")
protected WebElement renameNodeText;

@FindBy(xpath="//*[@name='nodeDescription']")
protected WebElement renameNodeDescText;

//@FindBy(xpath="//button[text()='Rename']")
//protected WebElement renameButton;

// for dnd operation


//////06-08-2017
//get testcase name
@FindBy(xpath="//*[@id='zephyr-testcase-panel']/div/div[1]/div/div/zee-panel-content1/div/div/div/zephyr-inline-edit/div/div/span[1]")
public WebElement getTestcaseName;


//Date0-08-17
//Copy from Other Project	
@FindBy(xpath="//a[text()='Copy from Project Releases']")
protected WebElement copyFromProjectReleasesOption;

//14-08-17
@FindBy(xpath=".//*[@class='jstree-icon jstree-checkbox']")
public WebElement clickOnReleaseCheckBox;


@FindBy(xpath="//a[text()='Copy from Project Releases']")
public WebElement copyReleaseOption;


//9-8-2017
@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[1]")
public WebElement releaseArrow;

@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[2]")
public WebElement importArrow;

@FindBy(xpath="//a[@data-name='allFields.xls Aug:29:2017::02:41:01']")
public WebElement selectImportfile;


@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[1]")
public WebElement phaseArrow;

@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[2]")
public WebElement systemArrow;

@FindBy(xpath="(//i[@class='jstree-icon jstree-ocl'])[3]")
public WebElement subSystemArrow;


//////06-08-2017
//get testcase name


//click on phase to drag and drop 5-8-2017
@FindBy(xpath="//*[text()='move' and @data-type='Phase']")
public WebElement clickOnPhaseToDrag;

//click on test case to drag and drop 5-8-2017
@FindBy(xpath="//*[@id='grid-table-tcr']/div[2]/div[2]/div[4]")
public WebElement clickTestcaseToDrag;

@FindBy(xpath="/html/body/ul[2]/li[4]/a")
public WebElement copyImportedFile;

@FindBy(xpath="/html/body/ul[2]/li[2]/a")
public WebElement renameNode;

@FindBy(xpath="//*[@id='testcaseNodeName']")
public WebElement renameField;

@FindBy(xpath="//*[text()='Rename']")
public WebElement renameButton;

@FindBy(xpath="(.//*[@id='1013'])[1]")
protected WebElement textField;

@FindBy(xpath="(.//*[@id='1016'])[1]")
protected WebElement longTextField;

@FindBy(xpath="(.//*[@id='1018'])[1]")
protected WebElement numberField;

// @FindBy(xpath=".//*[@id='1016']/field-textarea/zephyr-inline-edit/div/div/span[1]")
//protected WebElement date;

@FindBy(xpath="//*[@name='zcf_1017']")
protected WebElement pickuplistField;

@FindBy(xpath="//*[@name='zcf_1014']")
protected WebElement checkboxField;

@FindBy(xpath="//*[@id='zee-create-edit-modal-tcr_3']/div/div/div[2]/zui-modal-body/div/div/form/div[3]/button[2]")
 protected WebElement saveInAutoScript;
 
@FindBy(xpath="//*[@id='bulk-confirm-modal']/div/div/div[3]/zui-modal-footer/button[2]")
 protected WebElement confirmSaveInAutoScript;

@FindBy(xpath="//h5[text()='Test Detail']")
public WebElement customFieldButton;


//@FindBy(xpath="//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[2]/notifications/div/a/span")
//public WebElement moveToNotificationElement;
//
//@FindBy(xpath="/html/body/div[2]/div/notification-list/div[3]/button[2]")
//public WebElement applyNotification;

@FindBy(xpath="//div[@title='Notifications']")//new 09/05/18
public WebElement moveToNotificationElement;

@FindBy(xpath="//button[@title='Click to apply notifications']")
public WebElement applyNotification;

@FindBy(xpath="html/body/ul[2]/li[2]/a")
public WebElement deletesNode;

@FindBy(xpath="//span[contains(.,'Folder')]")
public WebElement folder_tab;

/******************25/08/17***************************/
//adding testcase added by srikanth
@FindBy(xpath=".//*[@id='zui-modal-trigger-testcase_1']")
public WebElement addTestCase;

@FindBy(xpath="//*[@id='zui-modal-trigger-tcr_2']")	
public WebElement clone_TestCaseInDetail;



/**********************29/09/17**********************/
//added by srikanth on 29/09/17
@FindBy(xpath="(//*[@id='clone-limit-modal']/div/div/div[3]/zui-modal-footer/button[2])[1]")
public WebElement cloneConfirmation;

/*****************29/09/17 added by srikanth**********************/
public String testcaseID1=".//*[@id='grid-table-tcr']/div[2]/div[";
public String testcaseID2="]/div[3]/div/div";

@FindBy(xpath="//*[@class='page-track']/b[3]")
public WebElement tcCount;



//@FindBy(xpath="/html/body/zui-app/section/zee-test-repository/test-repository-component/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/section/zui-tcr-tree/div/tree-view/div/div[2]/div[2]/ul/li[1]")
//public WebElement releaseExpand;

public String releasename11="(//*[@data-name='";
public String expandNode="/..)";


public String Requirement1=".//*[@id='grid-table-map_req']/div[2]/div[";
public String Requirement2="]/div[1]/div/div/input";


public String req1="//*[@id='grid-table-map_req']/div[2]/div[";
public String req2="]/div[2]/div/div";


public String mapRequirementsToTestCases1="//*[@id='grid-table-map_req']/div[2]/div[";
public String mapRequirementsToTestCases2="]/div[1]/div/div/input";

@FindBy(xpath="//*[@id='mapTest-bulk']")
public WebElement clickOnMap; 

public String valMappedReq1=".//*[@id='grid-table-tcr']/div[2]/div[";
public String valMappedReq2="]/div[10]/div/div/span";



@FindBy(xpath="(//*[text()='100'])[2]")
public WebElement initCount;

@FindBy(xpath="(//*[text()='200'])")
public WebElement finalCount;

//@FindBy(xpath=".//*[@id='ze-main-app']/zee-test-repository/test-repository-component/div[2]/div[1]/div[1]/bread-crumb/div/ul/li/b")
//public WebElement clickOnShowBreadCrumbs;

public String map1=".//*[@id='mapReqDetail']/div/div/div/zee-expander/div[2]/zee-panel-content5/ul/li/div/a";
@FindBy(xpath=".//*[@id='zephyr-testcase-panel']/div/div[1]/div/div/zee-panel-content1/div/div/div[1]/div/zephyr-inline-edit/div/div/span[1]")
public WebElement validateTestCase;
	
/* ****************************************************
 * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
* Purpose    : To dnD the teststeps in Testcase Steps
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/

	public boolean addTestCase() throws Exception
	{
		try
		{
		bp = new BasePage();
		// bp.waitForElement();
		int bcnt = testCaseCount();
		// System.out.println(bcnt);
		// bp.waitForElement();
		Actions a1 = new Actions(driver);
		a1.moveToElement(add_TestCase);
		add_TestCase.click();
		bp.waitForElement();
		a1.sendKeys(Keys.TAB).perform();
		int acnt = testCaseCount();
		// System.out.println(acnt);
		
		
		//if ((bcnt + 1) == acnt) 
		//{
			//Assert.assertEquals(bcnt+1, acnt);
			log.info("Pass-Test Case Successfully Added");
			return true;
		
		} 
		catch(Exception e)
		{
			log.info("Fail-Test Case is not Added");
			e.printStackTrace();
			
			throw e;
			
			
		}
	}

/* ****************************************************
 * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
* Purpose    : To dnD the teststeps in Testcase Steps
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/

	public boolean clickDetailButton() throws Exception 
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		String expmsg = "Detail";
		detail_Tab.click();
		String page = detail_Tab.getText();

		if (page.equalsIgnoreCase(expmsg)) 
		{
			log.info("Pass-User is on Test Case Detail Page");

		}

		else 
		{
			log.info("Fail-You are not in Test Case Detail Page");

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

   public void importTestCase()
   {
	  
	import_TestCase.click();
	
    }

//Newly Edited
    public boolean deleteTestCase() throws Exception
   {
    	try
    	{
    	bp=new BasePage();
    	bp.waitForElement();	
	   delete_TestCase.click();
	
	  bp.waitForElement();
	  confirmDeleteTestCaseButton.click();
	  System.out.println("testcase deleted");
	return true;
    	}
    	catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
    }

  //Newly Created
//   public boolean verifydeleteTestCase() throws InterruptedException
//    {
//	int pastTestCase=verifyPastTestCase();
//	System.out.println(pastTestCase);
//	int presentTestCase=verifyPresentTestCase();
//	System.out.println(presentTestCase);
//	if((pastTestCase-1)==presentTestCase)
//	{
//		log.info("Test Case successfully Deleted");
//	}
//	else
//	{
//		log.info("Test Case is not Deleted");
//	}
//	return true;
//	
//  }
public boolean exportTestCase()
{
	export_TestCase.click();
	return true;
}
public boolean selectallTestCase() throws Exception
{
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	bp.explicitWait(select_all_TestCase);
	select_all_TestCase.click();
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
public boolean editTestCase() throws Exception
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		bp.explicitWait(edit_TestCase);
	edit_TestCase.click();
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}


/* ****************************************************
 * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
* Purpose    : To dnD the teststeps in Testcase Steps
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/

//Newly Edited
public boolean cloneTestCase() throws Exception
{
	try
	{
	BasePage bp=new BasePage();
	bp.waitForElement();
	clone_TestCase.click();
	bp.waitForElement();
	return true; 
	
	}catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
//Newly Created
//public boolean verifyCloneTestCase() throws InterruptedException
//{
//	int pastTestCase=verifyPastTestCase();
//	System.out.println(pastTestCase);
//	int presentTestCase=verifyPresentTestCase();
//	System.out.println(presentTestCase);
//	if((pastTestCase+1)==presentTestCase)
//	{
//		log.info("Test Case successfully Cloned");
//	}
//	else
//	{
//		log.info("Test Case is not Cloned");
//	}
//	return true;
//}

//Newly Created
public boolean verifyPastTestCase() throws Exception
{
	try
	{

	bp=new BasePage();
	//bp.waitForElement();
	int bcnt=testCaseCount();
	log.info("Test Case Count before operation- "+bcnt);
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}

	

}
//Newly Created
public boolean verifyPresentTestCase() throws Exception
{
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	int acnt=testCaseCount();
	log.info("Test Case Count After Operation- "+acnt);
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}

}

public boolean clickOnDetails() throws Exception
{
	try
	{
	bp=new BasePage();
	bp.waitForElement();
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(	detail_Tab));
	detail_Tab.click();
	bp.waitForElement();
	return true;
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
public boolean clickOnList() throws Exception
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(	list_Tab));
		list_Tab.click();
		bp.waitForElement();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
public boolean clickOnSearch()
{
search_Tab.click();
return true;
}
//public void clickOnFolder()
//{
// folder_Tab.click();	
//}

 public void moveToOption()
{
	WebElement eleop=driver.findElement(By.xpath(".//*[@id='j2_1_anchor']/div"));
	
	bp.moveToElementAndClick(eleop);
	
}



public String verifyTestRepTitle()
{
	String testreptitle=driver.getTitle();
	return testreptitle;
}


/* ****************************************************
 * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
* Purpose    : To dnD the teststeps in Testcase Steps
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
public int testCaseCount() throws Exception
{
	try
	{
	bp=new BasePage();
	//bp.waitForElement();
	int count=0;
	boolean sp=tcCount.isEnabled();
	
	if(sp==true)
	{
	 String testCaseCount=tcCount.getText();
	  count= Integer.parseInt(testCaseCount);
	  bp.waitForElement();
	 //Thread.sleep(3000);
	}
	return count;
	}
    
	catch(Exception e)
	{
		log.info("Currently No Test Case Present in the Node");
	    return 0;
		//throw e;
	}
}

/*	****************************************************
 * Method Name			: addNode(String Name,String Desc)
 * Purpose				: To add nodet in Zephyr Application
 * Author				: OPAL
 * Date Created			: 27/06/17
 * Date Modified		:
 * Reviewed By			: 
 * ******************************************************
 */
public boolean addNode(String Name,String Desc) throws Exception
{
	try
	{
		
		BasePage bp=new BasePage();
//		String releasename3=releasename1+releaseName+releasename2;
//		WebElement ele=driver.findElement(By.xpath(releasename3));
		bp.waitForElement();
//		Actions a2=new Actions(driver);
//		a2.contextClick().perform();
		options.click();
		System.out.println("Pass-Clicked on Options");
		bp.waitForElement();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(addNode));
		addNode.click();
		log.info("Pass - Clicked on Add Button");
		bp.waitForElement();
		nodeName.click();
		nodeName.sendKeys(Name);
		nodeDesc.click();
		nodeDesc.sendKeys(Desc);
		bp.waitForElement();
		saveNode.click();
		log.info("Pass - Clicked on Save Button");
		bp.waitForElement();
		//log.info("Pass - phase created with name and description");
		log.info("Pass - created with name and description");
		bp.waitForElement();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

/*	****************************************************
 * Method Name			: navigateToNode(String releaseName,String phaseName,String systemName)
 * Purpose				: To Click on the ReleaseName of the Project in Zephyr Application
 * Author				: OPAL
 * Date Created			: 27/06/17
 * Date Modified		:
 * Reviewed By			: 
 * ******************************************************
 */
   
/*public boolean navigateToNode(String releaseName,String[] navigation) throws Exception
{
	try
	{
		BasePage bp=new BasePage();
		String releasename4;
		bp.waitForElement();
		String releasename3=releasename1+releaseName+releasename2;
		WebElement ele=driver.findElement(By.xpath(releasename3));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		bp.waitForElement();
		log.info("Pass - Double click on'"+releaseName+"' Successfull");
		Thread.sleep(3000);
		//bp.waitForElement();
		
		for(int i=0;i<=navigation.length-1;i++)
		{
			
			releasename4=releasename1+navigation[i]+releasename2;
			
			WebElement nodeElement=driver.findElement(By.xpath(releasename4));
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			String Nodename=driver.findElement(By.xpath(releasename4)).getText();
			log.info(Nodename);
			log.info("Pass - Double click on'"+navigation[i]+"' Successfull");
			//act.moveToElement(nodeElement).click().perform();
			bp.waitForElement();
		}
		
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}	
}*/

/*	****************************************************
 * Method Name			: clickOnRelease(String rlsName)
 * Purpose				: To Click on the ReleaseName of the Project in Zephyr Application
 * Author				: OPAL
 * Date Created			: 27/06/17
 * Date Modified		:
 * Reviewed By			: 
 * ******************************************************
 */

public boolean clickOnRelease(String releaseName) throws Exception
{
	try
	{
	    bp=new BasePage();
		String releasename3=releasename1+releaseName+releasename2;
		driver.findElement(By.xpath(releasename3)).click();
		bp.waitForElement();
		log.info("Pass - click on'"+releaseName+"' Successfull");
		
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}


/* ****************************************************
 * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
* Purpose    : To dnD the teststeps in Testcase Steps
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
//chaanged///////////////////////////////////////////////
    public boolean selectTestCase(String[] names) throws Exception
	{
    	try
    	{
//    		
//    		String pageNum=clickOnPageNumbers.getText();
//    		String[] p1=pageNum.split(" ");
//    		int lastpagenum=Integer.parseInt(p1[p1.length-1]);
    	
    	bp=new BasePage();
    	
    	//for(int l=1;l<=lastpagenum-1;l++)
    	//{
    	for(int i=0;i<=names.length-1;i++)
    	{
    	bp.waitForElement();
		String s3=testcase1+names[i]+testcase2;
		driver.findElement(By.xpath(s3)).click();
		bp.waitForElement();
		
    	}
    	//clickOnNextButton.click();
    	//}
    	
    	return true;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		throw e;
    	}
    	
	}


    /* ****************************************************
     * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
    * Purpose    : To dnD the teststeps in Testcase Steps
    * Author    : OPAL1
    * Date Created   : 27/07/17
    * Date Modified  :
    * Reviewed By   : Opal4
    * ******************************************************
    */
/*public boolean doubleClickOnRelease(String releaseName) throws Exception 
{
	try
	{
		bp=new BasePage();
		bp.waitForElement();
	String releasename3=releasename1+releaseName+releasename2;
	WebElement ele=driver.findElement(By.xpath(releasename3));
	WebDriverWait wait=new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	//bp.waitForElement();
	Actions act=new Actions(driver);
	//WebElement ele=driver.findElement(By.xpath(releasename3));
	act.moveToElement(ele).doubleClick().perform();
	bp.waitForElement();
	//bp.waitForElement();
	log.info("Pass - double click on'"+releaseName+"' Successfull");
	bp.waitForElement();
	
	
	//
//	 Actions notification=new Actions(driver);
//	 notification.moveToElement(moveToNotificationElement).perform();
//	 Thread.sleep(1400);
//	 
//	 
//	 boolean status=applyNotification.isDisplayed();
//	 boolean status1=applyNotification.isEnabled();
//	 
//	 System.out.println(status);
//	 System.out.println(status1);
//	 if(status==true)
//	 {
//	  notification.moveToElement(applyNotification).click().perform();
//	  bp.waitForElement();
//	  bp.waitForElement();
//	  
//	  log.info("Pass - Updates are applied for the Application");
//	  notification.moveToElement(ele).doubleClick().perform();
//	 }
//	 else
//	 {
//	  log.info("Pass - No updates are available");
//	 }
//	
//	
//	 bp.waitForElement();
//	 driver.findElement(By.xpath(releasename3)).click();
	 
	return true;
	}	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}*/

/* ****************************************************
 * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
* Purpose    : To dnD the teststeps in Testcase Steps
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
public boolean addNewTestCaseInDetilview() throws Exception
{
	try
	{

	bp=new BasePage();
	bp.waitForElement();
	int bcnt=testCaseCount();
	
	int size_1=driver.findElements(By.xpath(addNewTestCase)).size();
    driver.findElements(By.xpath(addNewTestCase)).get(size_1-1).click();
	bp.waitForElement();

	int acnt=testCaseCount();
	
	if((bcnt+1)==acnt)
	{
		log.info("Pass-Test Case Successfully Added");
		
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
 * Method Name   : dnDForTestStepsDetails(int fromStepNum,int toStepNum) 
* Purpose    : To dnD the teststeps in Testcase Steps
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
public boolean moveToNodesInDetail() throws Exception
{
	try
	{

	String moveToNodes="//*[@class='tree-view']";
	WebElement ele=driver.findElement(By.xpath(moveToNodes));
	
	Actions a2=new Actions(driver);
	a2.moveToElement(ele).perform();
	bp=new BasePage();
	bp.waitForElement();

	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
}

/*	****************************************************
 * Method Name			: findAndAdd()
 * Purpose				: POM of the findAndAdd Method Project in Zephyr Application
 * Author				: OPAL
 * Date Created			: 03/07/17
 * Date Modified		:
 * Reviewed By			: 
 * ******************************************************
 */

public boolean findAndAdd(String[] operator,String[] symbol, String[] value, String colName, int colNum,String role,String selectCount)
{
	try
	{
		BasePage bp=new BasePage();
		 
		String Z1="\"";
		String Z2="\"";
		String ZQL=operator[0]+symbol[0]+Z1+value[0]+Z2;
		int l=operator.length-1;
		if( l>0)
		{
			for(int k=1;k<=operator.length-1;k++)
		
		{
		
		    String ZQL2=operator[k]+symbol[k]+Z1+value[k]+Z2;
			 ZQL=ZQL+"and"+ZQL2;
		    
		}
		}
		options.click();
		bp.waitForElement();
		findAndAdd.click();
		bp.waitForElement();
		//System.out.println("Pass - findAndAdd option is selected");
		log.info("Pass - findAndAdd option is selected");
	
		advancedSearch.sendKeys(ZQL);
		bp.waitForElement();
		clickOnGo.click();
		bp.waitForElement();
		//System.out.println("Pass - ZQL quarry Enterd Successfully");
		log.info("Pass - ZQL quarry Enterd Successfully");
		
		String a="//*[@id='grid-table-find_add']/div[2]/div[";
		String b="]/div[";
		String d="]/div/div";
		String e=b+colNum+d;
		
		String ttc=totalNoOfTC.getText();
		String ptc=pageTc.getText();

		int count=Integer.parseInt(ttc);
		int pageCount;
		int count1=Integer.parseInt(ptc);
		int reminder=count%count1;
		if(reminder == 0)
		{
			pageCount = (count/count1);
		}
		else
		{
			pageCount = (count/count1)+1;
		}	
		if(selectCount== "Single")
		{
			pageCount=1;
		}
		log.info(count);
		log.info(count1);
		log.info(pageCount);
		log.info(reminder);
		//log.info(ttc);
		//log.info(ptc);
		
		clickOnTC.click();
		bp.waitForElement();
//		boolean stat1=clickNextInDetail.isDisplayed();
//		if(stat1==true)
//		{
//			clickNextInDetail.click();
//		}
		//clickOnNext.click();
		bp.waitForElement();
		//clickOnTC.click();
//		for(int j=1;j<=pageCount;j++)
//		{
//			if(j==pageCount && j != 1)
//			{
//			 count1 = reminder;	
//			}
//			
//			for(int i=1;i<=count1;i++)
//			{
//				String c=a+i+e;
//				String c1=driver.findElement(By.xpath(c)).getText();
//				Boolean z=driver.findElement(By.xpath(c)).isDisplayed();
////				System.out.println(c);
////				System.out.println(c1);
////				System.out.println(z);
//				log.info(c);
//				log.info(c1);
//				log.info(z);
//				if(i==count1)
//				{
//					//clickOnTC.click();
//					if((j<(pageCount)))
//					{
//						clickOnNext.click();
//						bp.waitForElement();
//						clickOnTC.click();
//						bp.waitForElement();
//					}
//									
//				}
//			}
//			//clickOnAdd.click();
//			
//		}	
		bp.waitForElement();
		boolean stat=clickAddInDetail.isDisplayed();
		if(stat==true)
		{
			clickAddInDetail.click();
			bp.waitForElement();
		}
		bp.waitForElement();
        clickOnAdd.click();
        bp.waitForElement();
		//System.out.println("Pass - testCase is added successfully");
		log.info("Pass - testCase is added successfully");
	
	return true;
	}
	catch(Exception e)
	{
		//e.printStackTrace();
		//clickOnTC.click();
		//clickOnAdd.click();
		return false;
	}
}



/* ****************************************************
 * Method Name   : renameNode(String name,String desc)
* Purpose    : To rename Node 
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
//NewlyAdded
public boolean renameNode(String name,String desc) throws Exception
{
	try
	{
	BasePage bp=new BasePage();
	options.click();
	log.info("Options clicked");
	bp.waitForElement();
	
	//driver.findElement(By.xpath("//a[contains(.,'Rename')]")).click();
	renameNode.click();
	bp.waitForElement();
	renameNodeText.clear();
	renameNodeText.sendKeys(name);
	bp.waitForElement();
	renameNodeDescText.click();
	renameNodeDescText.clear();
	renameNodeDescText.sendKeys(desc);
    renameButton.click();
	log.info("Pass - Clicked on Rename Button");
	log.info("Node Succesfully Renamed");
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
 * Method Name   : sortingTestCase(String[] sort) 
* Purpose    : To sorting Test Cases
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
/// Newly Created  Uncomplete

public boolean sortingTestCase(String[] sort) throws Exception
{
	try
	{

	String sorting1="//label[text()='";
	String sorting2="']/../input";
	bp=new BasePage();
    bp.waitForElement();
    sortTestCase.click();
    
   
   for(int i=0;i<=sort.length-1;i++)
   {
	      bp.waitForElement();
	      WebElement ele=driver.findElement(By.xpath(sorting1+sort[i]+sorting2));
	      String data=ele.getText();
	      boolean res= ele.isSelected();
	      System.out.println(res);
	   
	  if(res==false)
	  {
		  BasePage bp=new BasePage();
		  bp.waitForElement();
		  bp.moveToElementAndClick(ele);
	  }
   
   
   }
   bp.waitForElement();
   bp.moveToElementAndClick(sortTestCase);
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}


/* ****************************************************
 * Method Name   : selectTestCasesPerPage(String pageNumber)
* Purpose    : To select Test Cases Per Page
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
//Srikant Added
public boolean selectTestCasesPerPage(String pageNumber) throws Exception 
{
	try
	{
	BasePage bp=new BasePage();
	
	String releasename3=pagenumber1+pageNumber+pagenumber2;
	
	clickOnOptions.click();
	bp.waitForElement();
	String testCaseNo=driver.findElement(By.xpath(releasename3)).getText();
	WebElement ele=driver.findElement(By.xpath("//*[@id='pagination-page-size-tcr']"));
	Select s1=new Select(ele);
	

	
	if(pageNumber.equals(testCaseNo))
	{
	   s1.selectByVisibleText(pageNumber);
	}
	
	
//	//System.out.println(ele.getText());
//	Actions act=new Actions(driver);
//	act.click(ele).perform();
	log.info("Pass - click on'"+pageNumber+"' Successfull");
	
	bp.waitForElement();
//	boolean res=ele.isEnabled();
//	System.out.println(res);
	 String res1=(s1.getFirstSelectedOption()).getText();
   // String res1=driver.findElement(By.xpath(".//*[@id='tcr-grid']/div/zui-tcr-grid/grid/div[2]/ul/span/li[1]")).getText();
    System.out.println(res1);
    
    return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
    
}	

/* ****************************************************
 * Method Name   : verifySelectingPageNumbers(String pageNumber)
* Purpose    : To verify Selecting Page Numbers
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
public boolean verifySelectingPageNumbers(String pageNumber) throws Exception
{
	try
	{
	String releasename3=pagenumber1+pageNumber+pagenumber2;
	Actions act=new Actions(driver);
	WebElement ele=driver.findElement(By.xpath(releasename3));//
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
	/*act.moveToElement(ele).click().perform();
	log.info("Pass - click on'"+pageNumber+"' Successfull");
	BasePage bp=new BasePage();
	bp.waitForElement();
	boolean res=ele.isEnabled();
	System.out.println(res);*/
}	

public boolean SwitchView() throws Exception
{
	try
	{
	clickOnDetailView.click();
	bp.waitForElement();
	clickOnListView.click();
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean ExpandMode() throws Exception
{
	try
	{
	clickOnTestCase.click();
	bp.waitForElement();
	clickOnExpander.click();
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
	
}

/* ****************************************************
 * Method Name   : click On NextAndPrev()
* Purpose    : To click On Next And Prev
* Author    : OPAL1
* Date Created   : 27/07/17
* Date Modified  :
* Reviewed By   : Opal4
* ******************************************************
*/
public boolean clickOnNextAndPrev() throws Exception
{

	try
	{


	//bp.waitForElement();
	//clickOnOptions.click();
	//driver.findElement(ep1+test+ep2).c
	//clickOnOption.click();
	//String releaseName3 = Excel_Lib.getData(INPUT_PATH_3,"TestCases",5,1);
	//bp.waitForElement();
	String pages=clickOnPageNumbers.getText();
	String[] p=pages.split(" ");
	int lastpage=Integer.parseInt(p[p.length-1]);
	//clickOnNextButton.click();
	
	for(int i=1;i<=lastpage-1;i++)
	{
		bp.waitForElement();
		clickOnNextButton.click();
		
	}
	for(int k=lastpage-1;k>=1;k--)
	{
		bp.waitForElement();
		clickOnPrevButton.click();
	}
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
	
 public boolean navigateToPages(String[] pageNo) throws Exception
	{
	 try
	 {
	 
	String pageNum=clickOnPageNumbers.getText();
	String[] p1=pageNum.split(" ");
	int lastpagenum=Integer.parseInt(p1[p1.length-1]);
	for(int j=0;j<=pageNo.length-1;j++)
	{
	for(int i=0;i<=lastpagenum;i++)
	 {
		WebElement ele=driver.findElement(By.xpath(clickOnPages1+p1[i]+clickOnPages2));
		String text=ele.getText();
		if(pageNo[j].equals(text))
		{
		   bp.waitForElement();
		   ele.click();
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

	public boolean BreadCrumbs() throws Exception
	{
		try
		{
		//breadCrumbs.click();
		String str=driver.findElement(By.xpath("//*[@class='breadcrumb zui-breadcrumb']")).getText();
		System.out.println(str);
		
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

	public boolean chooseCustomFields(String custom) throws Exception
		{
		try
		{
			bp=new BasePage();
			detail_Tab.click();
			bp.waitForElement();
			customFields.click();
		
			bp.waitForElement();
			Actions a1=new Actions(driver);
			CreateTestCasePage ctc=new CreateTestCasePage(driver);
			a1.moveToElement(ctc.customText).click().perform();
			a1.sendKeys(custom).sendKeys(Keys.TAB).perform();
			//custom1.click();
			//bp.waitForElement();
			//custom1.sendKeys(custom);
//			bp.waitForElement();
//			saveCustomField.click();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
			
			
		}

	/* ****************************************************
	 * Method Name   : moveNode()
	* Purpose    : To  move Node 
	* Author    : OPAL1
	* Date Created   : 27/07/17
	* Date Modified  :
	* Reviewed By   : Opal4
	* ******************************************************
	*/
	public boolean moveNode() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		options.click();
		log.info("Node option is clicked");
		bp.waitForElement();
		moveNode.click();
		log.info("Node successfully moved");
		//driver.findElement(By.xpath("//a[contains(.,' Move')]")).click();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	/* ****************************************************
	 * Method Name   : copyNode()
	* Purpose    : To  copy Node 
	* Author    : OPAL1
	* Date Created   : 27/07/17
	* Date Modified  :
	* Reviewed By   : Opal4
	* ******************************************************
	*/
	public boolean copyNode() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		options.click();
		log.info("Node option is clicked");
		bp.waitForElement();
		copyNode.click();
		log.info("Node copied Successfully");
		//driver.findElement(By.xpath("//a[contains(.,' Move')]")).click();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/* ****************************************************
	 * Method Name   : pasteNode()
	* Purpose    : To  paste  Node 
	* Author    : OPAL1
	* Date Created   : 27/07/17
	* Date Modified  :
	* Reviewed By   : Opal4
	* ******************************************************
	*/
	public boolean pasteNode() throws Exception
	{
		try
		{
		bp=new BasePage();
		bp.waitForElement();
		options.click();
		log.info("Node option is clicked");
		bp.waitForElement();
		pasteNode.click();
		log.info("Node pasted successfully");
		//driver.findElement(By.xpath("//a[contains(.,' Paste')]")).click();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/*	****************************************************
	 * Method Name			: enterFilterValue(String fvalue)
	 * Purpose				: To Click on the filter in the repository page
	 * Author				: OPAL4
	 * Date Created			: 27/07/17
	 * Date Modified		:
	 * Reviewed By			: OPAL2
	 * ******************************************************
	 */

		public boolean enterFilterValue(String fvalue) throws Exception
		{
			try
			{
			clickOnFilter.sendKeys(fvalue);
			
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		public boolean verifyFilteredNode(String nodeName) throws Exception
		{
			try
			{
			WebElement node=driver.findElement(By.xpath(releasename1+nodeName+releasename2));
			String text=node.getText();
			if(nodeName.equals(text))
			{
				log.info("Filtered node is present");
			}
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		
	
		//////////////////////////hhhh//////////
		
		public boolean previousSearchDropDown() throws Exception
		{
			try
			{
			bp=new BasePage();
			bp.waitForElement();
			prevSearchDropDown.click();
			bp.waitForElement();
			clickOnPreviousSearch.click();
			
			return true;
			}catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
///////
		public void requirementMapping() throws Exception
		{
			try
			{
			clickOnMappedRequirements.click();
			clickOnMapReq.click();
			bp.waitForElement();
			clickOnReleaseNode.click();
			//bp.waitForElement();
			//nodeExpander.click();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}
		
		public boolean navigatingPageNumbers() throws Exception
		{
			try
			{
			clickOnPage2.click();
			clickOnPage3.click();
			clickOnPage4.click();
			clickOnPage5.click();
			
			return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
		}
		
		/*	****************************************************
		* Method Name			: deleteNode(String releaseName,String phaseName,String systemName) Test Repository
		* Purpose				: To delete a node
		* Author				: OPAL
		* Date Created			: 28/07/17
		* Date Modified			: 28/07/17
		* Reviewed By			: 
		* ******************************************************
		*/
				public boolean deleteNode() throws Exception
				{
					try
					{
//					Actions act=new Actions(driver);
//					act.contextClick().perform();
						bp=new BasePage();
						bp.waitForElement();
					options.click();
					log.info("Node options is clicked");
					bp=new BasePage();
					bp.waitForElement();
					deleteNode.click();
					log.info("delete node option is clicked");
					bp.waitForElement();
					deleteMsg.click();
					
					return true;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						throw e;
					}
				}
                
				public boolean selectPhase(String phaseName) throws Exception
				{
					try
				{
				bp=new BasePage();
						bp.waitForElement();
				 String s1="//*[@data-name='";
				 String s2="']";
				 String Phase=s1+phaseName+s2;
				 driver.findElement(By.xpath(Phase)).click();
				 log.info(phaseName+" is selected successfully");
				 bp.waitForElement();
				 return true;
				
				 
				
				}	
					catch(Exception e)
					{
						e.printStackTrace();
						throw e;
					}
				}
				
				/*	****************************************************
				 * Method Name			: naviagateNode()
				 * Purpose				: for Drag and Drop Node
				 * Author				: OPAL
				 * Date Created			: 01/08/17
				 * Date Modified		:
				 * Reviewed By			: 
				 * ******************************************************
				 */
				public boolean navigateNode(String[] node) throws Exception
				{
					try
					{
					Actions act=new Actions(driver);
					
					for(int i=0;i<=node.length-1;i++)
					{
						
						String releasename4=releasename1+node[i]+releasename2;
						
						WebElement nodeElement=driver.findElement(By.xpath(releasename4));
						act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
						
						log.info("Pass - Double click on'"+node[i]+"' Successfull");
						//act.moveToElement(nodeElement).click().perform();
						Thread.sleep(3000);
						
						
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
				   * Method Name   : dragAndDropNode(String srcNode,String destNode) 
				  * Purpose    : To drag And Drop Node
				  * Author    : OPAL1
				  * Date Created   : 27/07/17
				  * Date Modified  :
				  * Reviewed By   : Opal4
				  * ******************************************************
				  */
				public boolean dragAndDropNode(String srcNode,String destNode) throws Exception
				{
					try
					{
						
					
					Actions a1=new Actions(driver);
					
					WebElement src=driver.findElement(By.xpath(releasename1+srcNode+releasename2));
					WebElement dest=driver.findElement(By.xpath(releasename1+destNode+releasename2));
					a1.dragAndDrop(src, dest).perform();
					log.info(srcNode+" node is succesfully moved to the "+destNode+"node");
					return true;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						throw e;
					}
					
				}
				/* ****************************************************
				   * Method Name   : dragAndDropTestCase(WebElement srcNode,String destNode)
				  * Purpose    : To drag And Drop Test Case to node
				  * Author    : OPAL1
				  * Date Created   : 27/07/17
				  * Date Modified  :
				  * Reviewed By   : Opal4
				  * ******************************************************
				  */
				
				public boolean dragAndDropTestCase(WebElement srcNode,String destNode) throws Exception
				{
					try
					{
					Actions a1=new Actions(driver);
					
					//WebElement src=driver.findElement(By.xpath(releasename1+srcNode+releasename2));
					WebElement dest=driver.findElement(By.xpath(releasename1+destNode+releasename2));
					a1.dragAndDrop(srcNode, dest).perform();
					log.info("Test case successfully moved to the "+destNode+" node" );
					return true;
					}
                 catch(Exception e)
					{
                	 e.printStackTrace();
                	 throw e;
					}
				}
				
				/* ****************************************************
				   * Method Name   : selectTestCaseById(String id)  
				  * Purpose    : To select Test Case By Id
				  * Author    : OPAL1
				  * Date Created   : 27/07/17
				  * Date Modified  :
				  * Reviewed By   : Opal4
				  * ******************************************************
				  */
				
   public boolean selectTestCaseById(String id) throws Exception
	     {
	   try
	   {
		bp=new BasePage();
		bp.waitForElement();
	   String testCase=testcase1+id+testcase2;
	   driver.findElement(By.xpath(testCase)).click();
	   log.info("ID-"+id+"- Test Case Selected ");
	   return true;
	   
	   }
	   catch(Exception e)
		{
   	    e.printStackTrace();
   	     throw e;
		}
	   
}
   
   /* ****************************************************
	   * Method Name   : selectTestCaseById(String id)  
	  * Purpose    : To select Test Case By Id
	  * Author    : OPAL1
	  * Date Created   : 27/07/17
	  * Date Modified  :
	  * Reviewed By   : Opal4
	  * ******************************************************
	  */
   public boolean clickOnCopyFromProjects() throws Exception
   {
	   try
	   {
		   bp=new BasePage();
		   bp.waitForElement();
	   options.click();
	   copyFromProjectReleasesOption.click();
	   log.info("Copy from project release option is clicked");
	   bp.waitForElement();
	   return true;
	   }
	   catch(Exception e)
		{
  	    e.printStackTrace();
  	     throw e;
		}
	   
   }
   
   public boolean copyTestCase(WebElement srcNode,String destNode) throws Exception
	{
		try
		{
			bp=new BasePage();
			bp.waitForElement();
		WebElement dest=driver.findElement(By.xpath(releasename1+destNode+releasename2));
		Actions a1=new Actions(driver);
		
		//WebElement src=driver.findElement(By.xpath(releasename1+srcNode+releasename2));
		
		a1.sendKeys(Keys.CONTROL).dragAndDrop(srcNode, dest).perform();
		log.info("Test case sucessfully copied to the "+destNode+" node");
		return true;
		}
    catch(Exception e)
		{
   	 e.printStackTrace();
   	 throw e;
		}
	}
   
   
   public boolean clickOnFolder() throws Exception
   {
    try
    {
     folder_Tab.click();
     return true;
    }
    catch(Exception e)
    {
     e.printStackTrace();
     throw e;
    }
   }
   
   //14-08-17
   public boolean navigationToImport() throws Exception
   {
    try
    {
     releaseArrow.click();
     bp=new BasePage();
     bp.waitForElement();
     importArrow.click();
     bp.waitForElement();
     selectImportfile.click();
     bp.waitForElement();
     //phasearrows
     phaseArrow.click();
     bp.waitForElement();
     systemArrow.click();
     bp.waitForElement();
     subSystemArrow.click();
     
     return true;
    }catch(Exception e) 
    {
     e.printStackTrace();
     throw e;
         
 }
   }
   
   public boolean enterCustomFields(String text,String longText,String number,String checkBox,String pickupList, String date) throws Exception 
   {
   try
   {
    if(text!="")
    {
     textField.click();
     textField.sendKeys(text);
    }
    if(longText!="")
    {
     longTextField.clear();
     longTextField.sendKeys(longText);
    }
    if(number!="")
    {
       numberField.sendKeys(number);
    }
    if(checkBox!="")
    {
     checkboxField.click();
    }
    if(pickupList!="")
    {
     Select s1=new Select(pickuplistField);
     s1.selectByVisibleText(pickupList);
     
     //pickuplistField.sendKeys(pickupList);
    }

    bp.waitForElement();
    saveInAutoScript.click();
    confirmSaveInAutoScript.click();
    return true;
   }
   catch(Exception e)
   {
    e.printStackTrace();
    throw e;
   }
   }
   
   public boolean clickOnCustomField() throws Exception
   {
	   try
	   {
		   customFieldButton.click();
		   return true;
	   }
	   catch(Exception e)
	   {
	    e.printStackTrace();
	    throw e;
	   }
	   
   }
   
   public boolean deleteImportedNode() throws Exception
   {
    try
    {
    
    options.click();
    log.info("Node options is clicked");
    bp=new BasePage();
    bp.waitForElement();
    deletesNode.click();
    log.info("delete node option is clicked");
    bp.waitForElement();
    deleteMsg.click();
    
    return true;
    }
    catch(Exception e)
    {
     e.printStackTrace();
     throw e;
    }
   }
   
   public boolean clickedOnFolder()
   {
   folder_tab.click();
   return true;
   }
   
   public boolean navigationToImport1(String fileName) throws Exception
   {
    try
    {
     releaseArrow.click();
     bp=new BasePage();
     bp.waitForElement();
     importArrow.click();
     bp.waitForElement();
     bp=new BasePage();
  TestRepositoryPage tr=new TestRepositoryPage(driver);
  String A="//*[starts-with(@data-desc,'FileName : ";
  String B="')]";
  String ImportedFile=A+fileName+B;
  //Actions act=new Actions(driver);
  //act.doubleClick(Imported).perform();
  bp.waitForElement();
  driver.findElement(By.xpath(ImportedFile)).click();
  bp.waitForElement();
  for(int i=0;i<8;i++)
  {
   tr.addTestCase();
  }
    // selectImportfile.click();
     bp.waitForElement();
     //phasearrows
     phaseArrow.click();
     bp.waitForElement();
     systemArrow.click();
     bp.waitForElement();
     subSystemArrow.click();
     
     return true;
    }catch(Exception e) 
    {
     e.printStackTrace();
     throw e;
         
 }
   }
   
   /****************************29/09/17****************************/
   //added by srikanth
   public boolean confirmCloneOperation() throws Exception
   {
	   try
	   {
	   bp.waitForElement();
	   cloneConfirmation.click();
	   return true;
	   }
	   catch(Exception e) 
	    {
	     e.printStackTrace();
	     throw e;
	    }
   }
  
   public boolean addTestCase2(WebDriver driver2) throws Exception
	{
		try
		{
			this.driver=driver2;
		bp = new BasePage();
		 bp.waitForElement();
		WebElement ele=driver.findElement(By.id("zui-modal-trigger-tcr_1"));
		Actions a1 = new Actions(driver);
		a1.moveToElement(ele);
		driver.findElement(By.id("zui-modal-trigger-tcr_1")).click();
		//add_TestCase.click();
		bp.waitForElement();	
			log.info("Pass-Test Case Successfully Added");
			return true;
		
		} 
		catch(Exception e)
		{
			log.info("Fail-Test Case is not Added");
			e.printStackTrace();
			
			throw e;
			
			
		}
	}

public boolean cloneTestCase2(WebDriver driver2) throws Exception
{
	try
	{
	BasePage bp=new BasePage();
	bp.waitForElement();
	driver.findElement(By.xpath("//*[@id='zui-modal-trigger-tcr_2']")).click();
	//clone_TestCase.click();
	return true; 
	
	}catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean addNode2(String Name,String Desc,WebDriver driver2) throws Exception
{
	try
	{
		this.driver=driver2;
		BasePage bp=new BasePage();
		bp.waitForElement();
		Actions a2=new Actions(driver);
		a2.contextClick().perform();
		//options.click();
		log.info("Pass - Clicked on Options");
		bp.waitForElement();
		bp.waitForElement();
		driver.findElement(By.cssSelector("body > ul.vakata-context.jstree-contextmenu.jstree-default-contextmenu > li:nth-child(1) > a")).click();
		//addNode.click();
		log.info("Pass - Clicked on Add Button");
		bp.waitForElement();
		driver.findElement(By.cssSelector("#addNodeName")).click();
		driver.findElement(By.cssSelector("#addNodeName")).sendKeys(Name);
		driver.findElement(By.cssSelector("#addNodeDescription")).click();
		driver.findElement(By.cssSelector("#addNodeDescription")).sendKeys(Desc);
		bp.waitForElement();
		driver.findElement(By.cssSelector("#tcrAddNodeModalSave")).click();
		//saveNode.click();
		log.info("Pass - Clicked on Save Button");
		bp.waitForElement();
		//log.info("Pass - phase created with name and description");
		log.info("Pass - created with name and description");
		bp.waitForElement();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean navigateToNode2(String releaseName,String[] navigation,WebDriver driver2) throws Exception
{
	try
	{
		this.driver=driver2;
		BasePage bp=new BasePage();
		String releasename4;
		bp.waitForElement();
		String releasename3=releasename1+releaseName+releasename2;
		WebElement ele=driver.findElement(By.xpath(releasename3));
		Actions act=new Actions(driver);
		act.doubleClick(ele).build().perform();
		bp.waitForElement();
		log.info("Pass - Double click on'"+releaseName+"' Successfull");
		Thread.sleep(3000);
		//bp.waitForElement();
		
		for(int i=0;i<=navigation.length-1;i++)
		{
			
			releasename4=releasename1+navigation[i]+releasename2;
			
			WebElement nodeElement=driver.findElement(By.xpath(releasename4));
			act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
			String Nodename=driver.findElement(By.xpath(releasename4)).getText();
			log.info(Nodename);
			log.info("Pass - Double click on'"+navigation[i]+"' Successfull");
			//act.moveToElement(nodeElement).click().perform();
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

public boolean clickOnRelease2(String releaseName,WebDriver driver2) throws Exception
{
	try
	{
		BasePage bp=new BasePage();
		String releasename1="//*[@data-name='";
		String releasename2="']";
		String releasename3=releasename1+releaseName+releasename2;
		driver.findElement(By.xpath(releasename3)).click();
		bp.waitForElement();
		log.info("Pass - click on'"+releaseName+"' Successfull");
		
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean doubleClickOnRelease2(String releaseName,WebDriver driver2) throws Exception 
{
	try
	{
		this.driver=driver2;
		bp=new BasePage();
		bp.waitForElement();
	String releasename3=releasename1+releaseName+releasename2;
	WebElement ele=driver.findElement(By.xpath(releasename3));
	WebDriverWait wait=new WebDriverWait(driver, 100);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	//bp.waitForElement();
	Actions act=new Actions(driver);
	//WebElement ele=driver.findElement(By.xpath(releasename3));
	act.moveToElement(ele).doubleClick().perform();
	bp.waitForElement();
	//bp.waitForElement();
	log.info("Pass - double click on'"+releaseName+"' Successfull");
	bp.waitForElement();
	
	
	//
//	 Actions notification=new Actions(driver);
//	 notification.moveToElement(moveToNotificationElement).perform();
//	 Thread.sleep(1400);
//	 
//	 
//	 boolean status=applyNotification.isDisplayed();
//	 boolean status1=applyNotification.isEnabled();
//	 
//	 System.out.println(status);
//	 System.out.println(status1);
//	 if(status==true)
//	 {
//	  notification.moveToElement(applyNotification).click().perform();
//	  bp.waitForElement();
//	  bp.waitForElement();
//	  
//	  log.info("Pass - Updates are applied for the Application");
//	  notification.moveToElement(ele).doubleClick().perform();
//	 }
//	 else
//	 {
//	  log.info("Pass - No updates are available");
//	 }
//	
//	
//	 bp.waitForElement();
//	 driver.findElement(By.xpath(releasename3)).click();
	 
	return true;
	}	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean applyNotification2(String releaseName,WebDriver driver2) throws Exception 
{
	try
	{
		bp=new BasePage();
		this.driver=driver2;
		WebElement ele=driver.findElement(By.xpath("//*[@id='ze-main-app']/testcase-execution/div/div/section/div/notifications/div/a/span"));
		Actions notification=new Actions(driver);
		notification.moveToElement(ele).perform();
		Thread.sleep(1400);
		
		WebElement ele1=driver.findElement(By.xpath("//*[text()='Apply']"));
		boolean status=ele1.isDisplayed();
		boolean status1=ele1.isEnabled();
		if(status==true)
			 {
			  notification.moveToElement(ele1).click().perform();
			  bp.waitForElement();
			  bp.waitForElement();
			  
			  log.info("Pass - Updates are applied for the Application");
			  notification.moveToElement(ele1).doubleClick().perform();
			 }
			 else
			 {
			  log.info("Pass - No updates are available");
			 }
	return true;
	}	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean discardNotification2(String releaseName,WebDriver driver2) throws Exception 
{
	try
	{
		bp=new BasePage();
		this.driver=driver2;
		WebElement ele=driver.findElement(By.xpath("//*[@id='ze-main-app']/testcase-execution/div/div/section/div/notifications/div/a/span"));
		Actions notification=new Actions(driver);
		notification.moveToElement(ele).perform();
		Thread.sleep(1400);
		
		WebElement ele1=driver.findElement(By.xpath("//*[text()='Discard']"));
		boolean status=ele1.isDisplayed();
		boolean status1=ele1.isEnabled();
		if(status==true)
			 {
			  notification.moveToElement(ele1).click().perform();
			  bp.waitForElement();
			  bp.waitForElement();
			  
			  log.info("Pass - Updates are discarded for the Application");
			  notification.moveToElement(ele1).doubleClick().perform();
			 }
			 else
			 {
			  log.info("Pass - No updates are available");
			 }
	return true;
	}	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean renameNode2(String name,String desc,WebDriver driver2) throws Exception
{
	try
	{
		this.driver=driver2;
	BasePage bp=new BasePage();
	driver.findElement(By.xpath("//div[@class='contextMenuIcon fa fa-ellipsis-v']")).click();
	//options.click();
	log.info("Options clicked");
	bp.waitForElement();
	
	driver.findElement(By.xpath("/html/body/ul[2]/li[2]/a")).click();
	//renameNode.click();
	
	bp.waitForElement();
	driver.findElement(By.xpath("//input[@name='testcaseNodeName']")).clear();
	//renameNodeText.clear();
	
	driver.findElement(By.xpath("//input[@name='testcaseNodeName']")).sendKeys(name);
	//renameNodeText.sendKeys(name);
	bp.waitForElement();
	driver.findElement(By.xpath("//*[@name='nodeDescription']")).click();
	//renameNodeDescText.click();
	
	driver.findElement(By.xpath("//*[@name='nodeDescription']")).clear();
	//renameNodeDescText.clear();
	
	driver.findElement(By.xpath("//*[@name='nodeDescription']")).sendKeys(desc);
	//renameNodeDescText.sendKeys(desc);
	
	driver.findElement(By.xpath("//*[text()='Rename']")).click();
    //renameButton.click();
    
	log.info("Pass - Clicked on Rename Button");
	log.info("Node Succesfully Renamed");
	bp.waitForElement();
	
	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean selectPhase2(String phaseName,WebDriver driver2) throws Exception
{
	try
{
		this.driver=driver2;
 String s1="//*[@data-name='";
 String s2="']";
 String Phase=s1+phaseName+s2;
 driver.findElement(By.xpath(Phase)).click();
 log.info(phaseName+" is selected successfully");
 return true;
}	
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean navigateNode2(String[] node,WebDriver driver2) throws Exception
{
	try
	{
		this.driver=driver2;
	Actions act=new Actions(driver);
	
	for(int i=0;i<=node.length-1;i++)
	{
		
		String releasename4=releasename1+node[i]+releasename2;
		
		WebElement nodeElement=driver.findElement(By.xpath(releasename4));
		act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
		
		log.info("Pass - Double click on'"+node[i]+"' Successfull");
		//act.moveToElement(nodeElement).click().perform();
		Thread.sleep(3000);
		
		
	}

	return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

public boolean clickOnCopyFromProjects2(WebDriver driver2) throws Exception
{
	   try
	   {
		   this.driver=driver2;
		   driver.findElement(By.xpath("//div[@class='contextMenuIcon fa fa-ellipsis-v']")).click();
	   //options.click();
		   driver.findElement(By.xpath("//a[text()='Copy from Project Releases']")).click();
	   //copyFromProjectReleasesOption.click();
	   log.info("Copy from project release option is clicked");
	   return true;
	   }
	   catch(Exception e)
		{
	    e.printStackTrace();
	     throw e;
		}
	   
}

public boolean driverClose(WebDriver driver2) throws Exception
{
	try
	{
		this.driver=driver2;
		driver.close();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}

   public boolean doubleClickOnRelease(String releaseName) throws Exception {
	  try 
	  {
	   bp = new BasePage();
	   bp.waitForElement();
	   String releasename3 = releasename1 + releaseName + releasename2;
	   WebElement ele = driver.findElement(By.xpath(releasename3));
	   WebElement releaseExpand= driver.findElement(By.xpath(releasename11+releaseName+releasename2+expandNode));
	   String text=releaseExpand.getAttribute("aria-expanded");
	   
	   System.out.println(text);
	   if(text.equals("false"))
	   {
	   Actions act = new Actions(driver);
	   act.moveToElement(ele).doubleClick().perform();
	   bp.waitForElement();
	   System.out.println("Pass - double click on'" + releaseName + "' Successfull");
	   bp.waitForElement();}
	   else
	   {
	    bp=new BasePage();
	    //String releasename3 = releasename1 + releaseName + releasename2;
	     driver.findElement(By.xpath(releasename3)).click();
	    System.out.println("Release already in Expanded mode");
	    bp.waitForElement();

	   
	  }
	   return true;  }
	   catch (Exception e)
	  {
	  e.printStackTrace();
	  throw e;
	   
	  }
	
	 }




	public boolean navigateToNode(String releaseName, String[] navigation) throws Exception {
	  try {
	   bp = new BasePage();
	   String releasename4;
	   bp.waitForElement();
	   String releasename3 = releasename1 + releaseName + releasename2;
	   WebElement ele = driver.findElement(By.xpath(releasename3));
	   Actions act = new Actions(driver);
	   WebElement releaseExpand= driver.findElement(By.xpath(releasename11+releaseName+releasename2+expandNode));
	   String text=releaseExpand.getAttribute("aria-expanded");
	   
	   while(text.equals("false"))
	  // if(text.equals("false"))
	   {
	  
	    System.out.println(text);
//	   if(text.equals("false"))
//	   {
	   
	    
	   act.doubleClick(ele).build().perform();
	   bp.waitForElement();
	   System.out.println("Pass - Double click on'" + releaseName + "' Successfull");
	   Thread.sleep(3000);
	   text=releaseExpand.getAttribute("aria-expanded");
	   }
	   
	  
	   

	   for (int i = 0; i <= navigation.length - 1; i++) 
	   {

	    releasename4 = releasename1 + navigation[i] + releasename2;

	    WebElement nodeElement = driver.findElement(By.xpath(releasename4));
	    
	    if(navigation.length>1 && i<navigation.length-1)
	    {
	    String nodeExpandCheck= releasename11+navigation[i]+releasename2+expandNode;
	    System.out.println(nodeExpandCheck);
	    WebElement nodeExp=driver.findElement(By.xpath(nodeExpandCheck));
	    boolean ww=nodeExp.isDisplayed();
	    System.out.println(ww);
	    bp.waitForElement();
	    String check=driver.findElement(By.xpath(nodeExpandCheck)).getAttribute("aria-expanded");
	      System.out.println(check);
	    	if(check.equals("false"))
	    	{
	   
	    act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
	    
	    String Nodename = driver.findElement(By.xpath(releasename4)).getText();
	    System.out.println(Nodename);
	    System.out.println("Pass - Double click on'" + navigation[i] + "' Successfull");
	    bp.waitForElement();
	    	}
	    }
	    	else
	    	{
	    		
	    		act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
	    	
		    
		    String Nodename = driver.findElement(By.xpath(releasename4)).getText();
		    System.out.println(Nodename);
		    bp.waitForElement();
		    //System.out.println("Pass - Double click on'" + navigation[i] + "' Successfull");
	    		
	    	}
	    	
	   }

	   return true;
	  } 
	   catch (Exception e) 
	   {
	   e.printStackTrace();
	   throw e;
	  }
	 }
	
	
	
	public boolean navigateToNodes(String releaseName,String[] navigation) throws Exception
	{
		try
		{
			BasePage bp=new BasePage();
			String releasename4;
			bp.waitForElement();
			String releasename3=releasename1+releaseName+releasename2;
			WebElement ele=driver.findElement(By.xpath(releasename3));
			Actions act=new Actions(driver);
			act.doubleClick(ele).build().perform();
			bp.waitForElement();
			log.info("Pass - Double click on'"+releaseName+"' Successfull");
			Thread.sleep(3000);
			//bp.waitForElement();
			
			for(int i=0;i<=navigation.length-1;i++)
			{
				
				releasename4=releasename1+navigation[i]+releasename2;
				
				WebElement nodeElement=driver.findElement(By.xpath(releasename4));
				act.moveToElement(nodeElement).doubleClick(nodeElement).perform();
				String Nodename=driver.findElement(By.xpath(releasename4)).getText();
				log.info(Nodename);
				log.info("Pass - Double click on'"+navigation[i]+"' Successfull");
				//act.moveToElement(nodeElement).click().perform();
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
	
	
	public boolean selectRequirementFromGrids(String[] testCaseNo) throws InterruptedException
	{
	 BasePage bp=new BasePage();
	 bp.waitForElement();
	 for(int i=0;i<=testCaseNo.length-1;i++)
	 {
	 WebElement ele=driver.findElement(By.xpath(Requirement1+testCaseNo[i]+Requirement2));
	 Actions a1=new Actions(driver);
	 a1.moveToElement(ele).click().perform();
	 }
	 
	 return true;
	}  

	
	
	public String mappingRequirementID(String [] testCaseNo) throws Exception
	{
		try
		{
		String Result=null;
		for(int i=0;i<=testCaseNo.length-1;i++)
		{
		 WebElement ele=driver.findElement(By.xpath(req1+testCaseNo[i]+req2));
		 String value=ele.getText();
		 Result=value;
		 
		}
		System.out.println(Result);
		return String.valueOf(Result);
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		throw e;
		}
	}
	
	public boolean selectMultipleRequirementFromGrid(String[] requirementNo) throws Exception
	{
		try
		{
		BasePage bp=new BasePage();
		bp.waitForElement();
		for(int i=0;i<=requirementNo.length-1;i++)
		{
			bp.waitForElement();
		WebElement ele=driver.findElement(By.xpath(mapRequirementsToTestCases1+requirementNo[i]+mapRequirementsToTestCases2));
		Actions a1=new Actions(driver);
		a1.moveToElement(ele).click().perform();
		}
		System.out.println(requirementNo.length+" Requirement Selected");
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public boolean clickOnMap() throws Exception
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,AutomationConstants.EXPLICIT);
			wait.until(ExpectedConditions.elementToBeClickable(	clickOnMap));
			clickOnMap.click();
			bp.waitForElement();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}

}
	public boolean validateMappedRequirementInList(int testcaseNo,int requirement) throws Exception
	{
		try
		{
		 bp=new BasePage();
		
		 WebElement ele=driver.findElement(By.xpath(valMappedReq1+testcaseNo+valMappedReq2));
			Actions a1=new Actions(driver);
			a1.moveToElement(ele).perform();
			String mapReq=ele.getText();
			String[] reqCount=mapReq.split(" ");
			int totalMappedReq=Integer.parseInt(reqCount[0]);
			if(totalMappedReq==requirement)
			{
		
		      System.out.println(requirement +"Requirement Mapaped to testcases succcessfully");
			}
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean validateTestRepositoryPage() throws Exception
	{
		try
		{
	
	String validate_TestRepository=driver.getTitle();
	System.out.println(validate_TestRepository);
    String expmsg="Test Repository";
    if(validate_TestRepository.equals(expmsg))
   {
    	System.out.println("Successfully Landed on Test Repository Page");
//    
	}
    return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	

	public boolean validateRequirement() throws Exception
	{
		try
		{
			 try
			  {
		     bp=new BasePage();
		     bp.waitForElement();
		     //bp.explicitWait(mapRequirement);
		     //mapRequirement.click();
			 WebElement map=driver.findElement(By.xpath(map1));
			 String Map=map.getText();
			 System.out.println(Map);
			  }
			  catch(NoSuchElementException e)
			  {
				  System.out.println("requirement is not mapped to testcase");
				  throw e;
				  
			  }	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return true;
	}
	

	   public int validateMappedRequirement()
	   {
		   driver.findElement(By.xpath("(//*[@id='mapReqDetail']//a)[1]")).click();
			int count=Integer.parseInt(driver.findElement(By.xpath(".//*[@id='tcr-grid']//b[3]")).getText());
			
			return count;
	   }
	   
	   
	   public boolean  validateTestCaseInSearch(String testCaseName) throws Exception
		{
		try
		{
		 bp=new BasePage();
		 String testCase=validateTestCase.getText();
		 if(testCaseName.equals(testCase))
		 {
			System.out.println(" Successfully retrieved " + testCase +  " TestCase in Search Grid "); 
		 }
		 else
		 {
			 System.out.println("Fail to retrieve " + testCase +  " TestCase in Search Grid ");  	 
		 }
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		 throw e;
		}
		return true;	
		}

	
	

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
}

//    
    