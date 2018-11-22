package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_166 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exep;
	String fileName="Defect_Tracking_Search_166";
	
	boolean[] actual=new boolean[26];
	SoftAssert soft=new SoftAssert();
	
	@Given("^Manager is in a Administration page$")
	public void manager_is_in_a_Administration_page() throws Throwable {
	try
    {
		bp=new BasePage();
		lp=new LoginPage(driver);
		pp=new ProjectPage(driver);
		dt=new DefectTracking(driver);
		rp=new ReleasePage(driver);
		pp.clickOnLogout();
	 	 
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     actual[0]=pp.launchAdministration();
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

	@When("^set to DTS to JIRA$")
	public void set_to_DTS_to_JIRA() throws Throwable {
	try
    {
	  String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	  String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	  String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	  String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");	
	  actual[1]=pp.clickOnDefectTracking();
	  actual[2]=pp.setDTS(DTS, jira_Url, Uname, Pwd);
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

	@Then("^Should be able to Set DTS$")
	public void should_be_able_to_Set_DTS() throws Throwable {
	try
    {
	  actual[3]=pp.validateSetDTS();
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

	@When("^User is in Test_Repository page to create testcase$")
	public void user_is_in_Test_Repository_page_to_create_testcase() throws Throwable {
	try
	   {
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(Uname);
	     lp.enterPass(Pass);
	     lp.clickOnLogin();
	     
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
	     bp.waitForElement();
	     actual[4]=rp.clickOnTestRep();
	     bp.waitForElement();
	     tr=new TestRepositoryPage(driver);
		 String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 18, 12);
		 String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		actual[5]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[6]=tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[7]=tr.navigateToNode(releaseName, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
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

	@When("^launch Test Planning to create cycle and add phase to the cycle$")
	public void launch_Test_Planning_to_create_cycle_and_add_phase_to_the_cycle() throws Throwable {
	try
	   {
		  bp.waitForElement();
		  actual[8]=rp.clickOnTestPlanning();
		  
		    tp=new TestPlanningPage(driver);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",18,13);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[9]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[10]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[11]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[12]=tp.saveTestCycle();
			bp.waitForElement();
			
	    	String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",18,13);
			actual[13]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",18,12);
			actual[14]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			String bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[15]=tp.bulkAssignment(bulk_Type);
			actual[16]=tp.goBackToCycle();
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

	@When("^launch the Test Execution$")
	public void launch_the_Test_Execution() throws Throwable {
	try
	   {
		     /*pp=new ProjectPage(driver);//
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);// */
		   
		   bp.waitForElement();
		   actual[17]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		    
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

	@Then("^Should launch Test Execution$")
	public void should_launch_Test_Execution() throws Throwable {
	try
	   {
		  exep=new ExecutionPage(driver);
		  actual[18]=exep.verifyExecutionPage();  
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

	@When("^execute the testcase$")
	public void execute_the_testcase() throws Throwable {
	try
	   {
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",18,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",18,12 );
		    
		    bp.waitForElement();
			actual[19]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[20]=exep.executeStatus(tcNo1[0], statusType1);
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

	@Then("^Should execute testcase$")
	public void should_execute_testcase() throws Throwable {
	try
	   {	
			int[] testcase=new int[1];
			testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String status=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[21]=exep.ValidateStatusOfTestCases(testcase, status);
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

	@When("^click on D button$")
	public void click_on_D_button() throws Throwable {
	try
	   {
		   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16 );
		   actual[22]=exep.clickOnDefectButton(testcase1);
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

	@Then("^Should launch link defect window$")
	public void should_launch_link_defect_window() throws Throwable {
	try
	   {
		 actual[23]=exep.validateLinkDefectWindow();
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

	@When("^search more than fifty defects and link to execution$")
	public void search_more_than_fifty_defects_and_link_to_execution() throws Throwable {
	try
	   {
		for(int i=1;i<=50;i++)
		{
		String defectId=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",i,11);
		exep.searchDefect(defectId);
		bp.waitForElement();
		exep.linkDefects.click();
		bp.waitForElement();
		}
		actual[24]=exep.clickOnCancelDefectWindow();
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

	@Then("^Should be able to link fifty defects to execution$")
	public void should_be_able_to_link_fifty_defects_to_execution() throws Throwable {
	try
	   {
		   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16 );
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   actual[25]=exep.viewTooltip(testcase1);
		   tp.doubleClickOnCycle(releaseName);
		   
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
