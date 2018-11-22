package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Defect_Tracking_190 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	DefectTracking dt;
	CreateCustomFieldsPage ccf;
	boolean[] actual=new boolean[44];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_190";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User logins as Manager to Zephyr$")
	public void user_logins_as_Manager_to_Zephyr() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
			actual[0]=pp.clickOnLogout();
			bp.waitForElement();
			actual[1]=lp.enterUname(uname);
			actual[2]=lp.enterPass(password);      
			actual[3]=lp.clickOnLogin();  
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

	@When("^user sets dts to jira$")
	public void user_sets_dts_to_jira() throws Throwable {
		try
		{
			actual[4]=pp.launchAdministration();
			bp.waitForElement();
			actual[5]=pp.clickOnDefectTracking();	
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

	@Then("^dts to jira should be set$")
	public void dts_to_jira_should_be_set() throws Throwable {
		try
		{
			String dts=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 10);
			String url=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 4, 10);
	    	String username=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 10);
			String password=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 10);
			bp.waitForElement();
	    	actual[6]=pp.setDTS(dts, url, username, password);
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

	@When("^user customizes the test case status ex:PassA,FailB,$")
	public void user_customizes_the_test_case_status_ex_PassA_FailB() throws Throwable {
		try
		{
			//String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 5);
			//String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 3);
			String colour=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", 1, 4);
			ccf=new CreateCustomFieldsPage(driver);
			bp.waitForElement();
			actual[7]=ccf.navigatingToCustomizationStatusTab();
			bp.waitForElement();
			actual[8]=ccf.clickOnExecutionStatusTab();
			bp.waitForElement();
			for(int i=1;i<=2;i++)
			{
			String name=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", i, 5);
			String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", i, 3);
			boolean res=ccf.checkAvailableCustomFields(value);
			if(res==false)
			{
			bp.waitForElement();
			actual[9]=ccf.editCustomStaus(name, value, colour);
			}
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

	@Then("^Should be able to customize the status$")
	public void should_be_able_to_customize_the_status() throws Throwable {
	    
		try
		{
			for(int i=1;i<=2;i++)
			{
			String value=Excel_Lib.getData(INPUT_PATH_7,"CustomValues", i, 3);
			actual[10]=ccf.checkAvailableCustomFields(value);
			}
			bp.waitForElement();
			ccf.closeExecutionStatusPage.click();
			
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

	@When("^user Launch Test Repository Page$")
	public void user_Launch_Test_Repository_Page() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[11]=pp.clickOnLogout();
			bp.waitForElement();
			actual[12]=lp.enterUname(uname);
			actual[13]=lp.enterPass(password);      
			actual[14]=lp.clickOnLogin(); 
			bp.waitForElement();
			actual[15]=pp.selectProject(project);
			actual[16]=pp.selectRelease(release);
			bp.waitForElement();
			actual[17]=rp.clickOnTestRep();
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
	@When("^user creates a phase and adds testcase$")
	public void user_creates_a_phase_and_adds_testcase() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 13, 3);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13, 2);
			actual[18]=tr.clickOnRelease(release);
			actual[19]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[20]=tr.navigateToNode(release, navigation);
			actual[21]=tr.addTestCase();	
			
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

	@Then("^should be able to create a testcase$")
	public void should_be_able_to_create_a_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[22]=tr.verifyPresentTestCase();
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

	@When("^user is In a Page Of Test Planning$")
	public void user_is_In_a_Page_Of_Test_Planning() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[23]=rp.clickOnTestPlanning();
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

	@When("^creates a cycle,adds Phase to cycle and assigns TestCases To User$")
	public void creates_a_cycle_adds_Phase_to_cycle_and_assigns_TestCases_To_User() throws Throwable {
		 
		try
		{
	    	String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 11, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 12, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 2));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 11, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13,2);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
	    	phase_1[0]=phase;
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
			bp.waitForElement();
			bp.waitForElement();
			actual[24]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[25]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[26]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[27]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[28]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[29]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[30]=tp.bulkAssignment(bulk_type);
			actual[31]=tp.navigateToCycle(phase_1);
			actual[32]=tp.selectSingleMultipleTestcase(testcase);
			bp.waitForElement();
	    	actual[33]=tp.assignAllSelected(assignee);
	    	
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

	@Then("^TestCases should be assigned to User$")
	public void testcases_should_be_assigned_to_User() throws Throwable {
		try
	    {
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
	    	actual[34]=tp.validateAllAssigned(testcase, assignee);
	    	bp.waitForElement();
	    	tp.goBackToCycle();
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

	@When("^USER Launches TestExecution Page$")
	public void user_Launches_TestExecution_Page() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			bp.waitForElement();
			actual[35]=rp.clickOnTestExecution();		
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

	@When("^Executes a Testcase and clicks on d icon$")
	public void executes_a_Testcase_and_clicks_on_d_icon() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",11,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",13,2 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[36]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[37]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[38]=ep.changeMultiSelectedStatus(status);
			actual[39]=ep.clickOnDefectButton(testcase1);
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

	@Then("^link Defect Window To be Launched$")
	public void link_Defect_Window_To_be_Launched() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[40]=ep.validateLinkDefectWindow();
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

	@When("^user searches defect and Links It$")
	public void user_searches_defect_and_Links_It() throws Throwable {
		try
		{
		 String defectId=Excel_Lib.getData(INPUT_PATH_7, "Defects",15,2 ); 
		 bp.waitForElement();
		 actual[41]=ep.searchDefect(defectId);
		 actual[42]=ep.linkDefect();
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

	@Then("^should Be Able to link defect to executions$")
	public void should_Be_Able_to_link_defect_to_executions() throws Throwable {
		try
		{
		 int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		 String defectId=Excel_Lib.getData(INPUT_PATH_7, "Phase",13,2 );
		 actual[43]=ep.validateLinkedDefect(testcase1, defectId);
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
