package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_JiraPermission_76 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exep;
	CreateCustomFieldsPage ccfp;
	RequirementsPage req;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_JiraPermission_76";
	
	boolean[] actual=new boolean[37];
	SoftAssert soft=new SoftAssert();
	
	@Given("^As a manager,Launch administration page$")
	public void as_a_manager_Launch_administration_page() throws Throwable {
	try
    {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dt=new DefectTracking(driver);
		 ccfp=new CreateCustomFieldsPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 tp=new TestPlanningPage(driver);
		 req=new RequirementsPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 exep=new ExecutionPage(driver);
		 pp.clickOnLogout();
		 lp=new LoginPage(driver);
	 	 
	     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     actual[0]=lp.enterUname(Uname);
	     actual[1]=lp.enterPass(Pass);
	     actual[2]=lp.clickOnLogin();
	     actual[3]=pp.launchAdministration();
    }
	catch(Exception e)
	{
	   lb=new LaunchBrowser();
	   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
      	Relogin_TPE rl=new Relogin_TPE();
      	rl.reLogin();
      	throw e;
	}  
	}

	@When("^launch the defect tracking system$")
	public void launch_the_defect_tracking_system() throws Throwable {
	try
	   {
		 actual[4]=pp.clickOnDefectTracking();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}            
	}

	@When("^Set the DTS To JIRA$")
	public void set_the_DTS_To_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
		 actual[5]=pp.clickOnDefectTracking();
		 actual[6]=ccfp.editDTS(DTS,jira_Url,jiraUname,jiraPwd);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}           
	}

	@Then("^Should be able to set DTS To JIRA$")
	public void should_be_able_to_set_DTS_To_JIRA() throws Throwable {
	try
	   {
		 actual[7]=pp.validateSetDTS();
		 bp.waitForElement();
		 bp.waitForElement();
		 pp.clickOnLogout();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}             
	}

	@When("^launch external jira page$")
	public void launch_external_jira_page() throws Throwable {
	try
	   {
		 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_3");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_3");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[8]=ejp.loginToExternalJira(jiraUname,jiraPwd);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}    
	}

	@When("^change create defect permission to the defect user$")
	public void change_create_defect_permission_to_the_defect_user() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,67);
		 //actual[9]=ejp.defectProjectSettings(projectName);
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,40);
		 ejp.closeNotificationMsg();
		 ejp.launchJiraAdministration(issueType);
		 actual[9]=ejp.selectProjectAdministration(projectName);
		 actual[10]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 driver.navigate().refresh();
		 ejp.closeNotificationMsg();
		 actual[11]=ejp.logOutFromExternal_JIRA();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}     
	}

	@When("^As a Lead,launch defect tracking page$")
	public void as_a_Lead_launch_defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     lp.enterUname(Uname);
	     actual[12]=lp.enterPass(Pass);
	     actual[13]=lp.clickOnLogin();
		 actual[14]=pp.selectProject(projectName);
		 actual[15]=pp.selectRelease(releaseName);
		 actual[16]=rp.clickOnDefectTracking();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                                     	   
	}

	@Then("^Should be able to launch Defect tracking page$")
	public void should_be_able_to_launch_Defect_tracking_page() throws Throwable {
	try
	   {
		 actual[17]=dt.validateDefectTrackingPage();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                
	}

	@When("^reset the external DTS login details$")
	public void reset_the_external_DTS_login_detail() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username_4");
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password_4");
		 actual[22]=req.dtsLoginDetail(Uname,Pwd,Pwd);
		 for(int i=0;i<=3;i++)
		 {
			 bp.waitForElement();
		 }
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}     
	}
	
	@When("^search a defect by ID defect tracking app$")
	public void search_a_defect_by_ID_defect_tracking_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 bp.waitForElement();
		 actual[18]=dt.searchDefect(defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                          
	}

	@Then("^Should able to search the defect$")
	public void should_able_to_search_the_defect() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 actual[19]=dt.validateDefect(defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                          
   
	}

	@When("^search a defect by JQL in DT app$")
	public void search_a_defect_by_JQL_in_DT_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,10);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,9);
		 actual[20]=dt.clickOnDefectAdvancedSearchButton();
		 for(int i=0;i<=5;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[21]=dt.defectAdvancedSearch(selectSearch,defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                            
	}

	@Then("^Should able to search defect$")
	public void should_able_to_search_defect() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 actual[22]=dt.validateDefect(defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                          
	}

	@When("^search a defect by filter in DT app$")
	public void search_a_defect_by_filter_in_DT_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",9,38);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 bp.waitForElement();
		 actual[23]=dt.defectAdvancedSearch(selectSearch,defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                        
	}

	@Then("^Should able to search Defect$")
	public void should_able_to_search_Defect() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 actual[24]=dt.validateSearchedDefect(defectType, defectValue);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}               
	}

	@When("^launch the test execution page$")
	public void launch_the_test_execution_page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[25]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    bp.waitForElement();
			actual[26]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
		 int[] tcNo1=new int[1];
		 tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
	     String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	     bp.waitForElement();
	     exep=new ExecutionPage(driver);
	     actual[27]=exep.executeStatus(tcNo1[0], statusType1);
	     actual[28]=exep.clickOnDefectButton(tcNo1[0]);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                        
	}

	@When("^search a defect by ID test execution app$")
	public void search_a_defect_by_ID_test_execution_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		 bp.waitForElement();
		 actual[29]=exep.defectSearch(selectSearch,defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                           
	}

	@Then("^Should able to Search the defect in test execution$")
	public void should_able_to_Search_the_defect_in_test_execution() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 actual[30]=dt.validateDefect(defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                        
	}

	@When("^search a defect by JQL in test execution app$")
	public void search_a_defect_by_JQL_in_test_execution_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,10);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,9);
		 bp.waitForElement();
		 actual[31]=exep.defectSearch(selectSearch,defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                               
	}

	@Then("^Should able to search defect in test execution$")
	public void should_able_to_search_defect_in_test_execution() throws Throwable {
	try
	   {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,7);
		 actual[32]=dt.validateDefect(defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                       
	}

	@When("^search a defect by filter in test execution app$")
	public void search_a_defect_by_filter_in_test_execution_app() throws Throwable {
	try
	   {
	     String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",9,38);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 bp.waitForElement();
		 actual[33]=exep.defectSearch(selectSearch,defectID);
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                              
	}

	@Then("^Should able to Search Defect in test execution$")
	public void should_able_to_Search_Defect_in_test_execution() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[34]=exep.validateSearchedDefect(defectType, defectValue);
		 for(int i=1;i<=4;i++){
		 bp.waitForElement();}
		 actual[35]=exep.clickOnCancelDefectWindow();
		 actual[36]=tp.doubleClickOnCycle(releaseName);
		 for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
	   }
	   catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}                
	}
}
