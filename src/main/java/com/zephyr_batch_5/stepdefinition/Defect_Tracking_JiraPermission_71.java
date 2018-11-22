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

public class Defect_Tracking_JiraPermission_71 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	ExecutionPage exep;
	CreateCustomFieldsPage ccfp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_JiraPermission_71";
	
	boolean[] actual=new boolean[46];
	SoftAssert soft=new SoftAssert();
	
	private String[] fields=new String[12];
	{
	   for(int i=0;i<=11;i++)
	   {
	   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	}
	 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,0);
	 String defectIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
     String defectSubtaskIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
	 String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	 String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
	 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	 public String defectID1;
	 public String defectID2;
	
	@Given("^User is in the Project Page$")
	public void user_is_in_the_Project_Page() throws Throwable {
	try
    {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dt=new DefectTracking(driver);
		 tp=new TestPlanningPage(driver);
		 req=new RequirementsPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 exep=new ExecutionPage(driver);
		 actual[0]=pp.selectProject(projectName);
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

	@When("^User launch defect tracking to create defect$")
	public void user_launch_defect_tracking_to_create_defect() throws Throwable {
	try
	   {
		 actual[1]=pp.selectRelease(releaseName);
		 actual[2]=rp.clickOnDefectTracking();
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

	@When("^create a defect in defect tracking app$")
	public void create_a_defect_in_defect_tracking_app() throws Throwable {
	try
	   {
			actual[3]=dt.createDefect(project,defectIssueType);
			actual[4]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[5]=dt.saveDefect();
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

	@Then("^Should be able to Create the defect$")
	public void should_be_able_to_Create_the_defect() throws Throwable {
	try
	  {
		 defectID1=dt.retrieveDefectId();
		 actual[6]=dt.validateDefect(project,defectIssueType);
		 bp.waitForElement();
		 actual[7]=dt.updateDefect();
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

	@When("^create subtask in defect tracking app$")
	public void create_subtask_in_defect_tracking_app() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
		 actual[8]=dt.searchDefect(defectID1);
		 actual[9]=dt.selectAllDefects();
		 actual[10]=dt.defectsOperation(defectValue);
		 actual[11]=dt.createDefectSubtask(defectSubtaskIssueType);
		 actual[12]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		 actual[13]=dt.saveDefect();
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

	@Then("^Should be able to create subtask in defect tracking app$")
	public void should_be_able_to_create_subtask_in_defect_tracking_app() throws Throwable {
	try
	  {
		 actual[14]=dt.validateDefect(project,defectSubtaskIssueType);
		 bp.waitForElement();
		 actual[15]=dt.updateDefect();
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

	@When("^search a defect by ID in defect tracking app$")
	public void search_a_defect_by_ID_in_defect_tracking_app() throws Throwable {
	try
	   {
		 actual[16]=dt.searchDefect(defectID1);
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

	@Then("^Should be able to search defect in DT$")
	public void should_be_able_to_search_defect_in_DT() throws Throwable {
	try
	   {
		 actual[17]=dt.validateDefect(defectID1);
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

	@When("^search a defect by JQL in defect tracking app$")
	public void search_a_defect_by_JQL_in_defect_tracking_app() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,9);
		 String operator=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,29);
		 String filterName=operator+defectID1;
		 dt.clickOnDefectAdvancedSearchButton();
	     actual[18]=dt.defectAdvancedSearch(selectSearch,filterName);
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

	@Then("^Should be able to search a defect in DT app$")
	public void should_be_able_to_search_a_defect_in_DT_app() throws Throwable {
	try
	   {
		 actual[19]=dt.validateDefect(defectID1);
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

	@When("^search a defect by filter in defect tracking app$")
	public void search_a_defect_by_filter_in_defect_tracking_app() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,38);
	     actual[20]=dt.defectAdvancedSearch(selectSearch,filterName);
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

	@Then("^Should be able to search defect using filter$")
	public void should_be_able_to_search_defect_using_filter() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 actual[21]=dt.validateSearchedDefect(defectType, defectValue);
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

	@When("^launch Test Execution page$")
	public void launch_Test_Execution_page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[22]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    
		    bp.waitForElement();
			actual[23]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[24]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[25]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^create a defect in test execution page$")
	public void create_a_defect_in_test_execution_page() throws Throwable {
	try
	   {
			actual[26]=dt.createDefect(project,defectIssueType);
			actual[27]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[28]=dt.saveDefect();
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

	@Then("^Should be able to Create the defect in Test Execution$")
	public void should_be_able_to_Create_the_defect_in_Test_Execution() throws Throwable {
	try
	  {
		 defectID2=exep.retrieveDefectId();
		 actual[29]=dt.validateDefect(project,defectIssueType);
		 bp.waitForElement();
		 actual[30]=dt.updateDefect();
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

	@When("^create subtask in test execution page$")
	public void create_subtask_in_test_execution_page() throws Throwable {
	try
	  {
		actual[31]=exep.searchDefect(defectID2);
		actual[32]=exep.clickOnSubtask();
		actual[33]=dt.createDefectSubtask(defectSubtaskIssueType);
		actual[34]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
	    actual[35]=dt.saveDefect();
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

	@Then("^Should be able to create subtask in test execution page$")
	public void should_be_able_to_create_subtask_in_test_execution_page() throws Throwable {
	try
	  {
		 actual[36]=dt.validateDefect(project,defectSubtaskIssueType);
		 actual[37]=dt.updateDefect();
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

	@When("^search a defect by ID in test execution page$")
	public void search_a_defect_by_ID_in_test_execution_page() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,9);
		 //String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,38);
	     actual[38]=exep.defectSearch(selectSearch,defectID2);
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

	@Then("^Should be able to search defect in test execution page$")
	public void should_be_able_to_search_defect_in_test_execution_page() throws Throwable {
	try
	   {
		 actual[39]=dt.validateDefect(defectID2);
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

	@When("^search a defect by JQL in test execution page$")
	public void search_a_defect_by_JQL_in_test_execution_page() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,9);
		 String operator=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,29);
		 String filterName=operator+defectID2;
	     actual[40]=exep.defectSearch(selectSearch,filterName);
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

	@Then("^Should be able to search a defect in test execution page$")
	public void should_be_able_to_search_a_defect_in_test_execution_page() throws Throwable {
	try
	   {
		 actual[41]=dt.validateDefect(defectID2);
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

	@When("^search a defect by filter in test execution page$")
	public void search_a_defect_by_filter_in_test_execution_page() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,9);
		 String filterName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,38);
	     actual[42]=exep.defectSearch(selectSearch,filterName);
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

	@Then("^Should be able to search defect using filter in Test Execution page$")
	public void should_be_able_to_search_defect_using_filter_in_Test_Execution_page() throws Throwable {
	try
	  {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,2);
		 actual[43]=exep.validateSearchedDefect(defectType, defectValue);
		 bp.waitForElement();
		 actual[44]=exep.clickOnCancelDefectWindow();
		 actual[45]=tp.doubleClickOnCycle(releaseName);
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
