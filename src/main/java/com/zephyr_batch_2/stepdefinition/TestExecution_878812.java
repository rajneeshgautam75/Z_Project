package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878812 extends LaunchBrowser
{
	
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	
	CreateCustomFieldsPage ccp;
	
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878812";
	boolean[] actual=new boolean[36];
	SoftAssert soft=new SoftAssert();
	
	String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	@When("^user add phase and add two system under phase$")
	public void user_add_phase_and_add_two_system_under_phase() throws Throwable {
		try
		{
			bp=new BasePage();
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,2);
			String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,2);
			tr=new TestRepositoryPage(driver);
			actual[0]=tr.doubleClickOnRelease(releaseName);
			actual[1]=tr.addNode(name, desc);
		    bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=name;
			bp.waitForElement();
		    tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
		    actual[2]=tr.selectPhase(name);
		    
		    String sysName1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,3);
		    String sysDesc1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,3);
		    actual[3]=tr.addNode(sysName1, sysDesc1);
		    
		    bp.waitForElement();
		    actual[4]=tr.selectPhase(name);
		    bp.waitForElement();
		    String sysName2=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,4);
		    String sysDesc2=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,4);
		    actual[5]=tr.addNode(sysName2, sysDesc2);
		    
		    
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
		  
	}

	@When("^add test case with test step to phase$")
	public void add_test_case_with_test_step_to_phase() throws Throwable {
	   
		try
		{
			   ctc=new CreateTestCasePage(driver);
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,2);
			   actual[6]=tr.selectPhase(name);
			   actual[7]=tr.addTestCase();
			   actual[8]=tr.clickDetailButton();
			   bp.waitForElement();
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,14);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,15);
			   actual[9]= ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   
			   String[] stepdetail=new String[3];
			   int l=0;
			   for(int i=19;i<=21;i++)
			   {
				   stepdetail[l]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
				   l++;
			   }
			  
			   actual[10]=ctc.enterTestCaseStepDetail(stepdetail);
			   bp.waitForElement();
			   tr.clickOnList();
			   bp.waitForElement();
			   tr.doubleClickOnRelease(Release);
			   bp.waitForElement();
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^launch test planning module$")
	public void launch_test_planning_module() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			actual[11]=rp.clickOnTestPlanning();
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^create a new cycle and add created phase to the cycle$")
	public void create_a_new_cycle_and_add_created_phase_to_the_cycle() throws Throwable {
		try
		{
			tp=new TestPlanningPage(driver);
		    
		    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 16, 5);
			String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 16, 6);
			  String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 16, 7);
			   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
			   
			   
			   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 16, 8));
			    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 16, 9);
			    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 16, 10));
			    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",16, 11));
			    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16, 12);
			    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 16, 13));		
			
			    actual[12]=tp.clickOnAddTestCycleSymbol();
			    
			    actual[13]=tp.CreateCycle(cycleName, build, environment, hide);
			    actual[14]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
			    actual[15]=tp.saveTestCycle();
			    bp.waitForElement();
			    
			    
			    
			    String[] cycle=new String[1];
			    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,5);
			    actual[16]=tp.navigateToCycle(cycle);
		       
		       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,2);
		       actual[17]=tp.addPhaseToCycle(phase);
		       actual[18]=tp.cancelBulkAssign();
		       
		       bp.waitForElement();
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^assign testcase to the lead by individual assignment$")
	public void assign_testcase_to_the_lead_by_individual_assignment() throws Throwable {
		try
		{
			 String[] cycle1=new String[1];
			    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,2);
			    actual[19]=tp.navigateToCycle(cycle1);
		        bp.waitForElement();
			    int[] testcase=new int[1];
			    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
			    actual[20]=bp.waitForElement();
			   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
			   actual[21]=tp.individualAssinTo(testcase, assignee);
			   
			   rp=new ReleasePage(driver);
			   bp.waitForElement();
			   tp.goBackToCycle();
			   bp.waitForElement();
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^execute teststep and testcases and change to custom status\\(N/A\\)$")
	public void execute_teststep_and_testcases_and_change_to_custom_status_N_A() throws Throwable {
		try
		{
			
			
			String[] cycle1=new String[2];
			String release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,5);
		    cycle1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,2);
		    actual[22]=tr.navigateToNode(release, cycle1);
		    
		    int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    String[] status= new String[1];
		    status[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,17);
		    
		   
		    exp=new ExecutionPage(driver);
		    bp.waitForElement();
		    tr.clickDetailButton();
		    bp.waitForElement();
		    String[] testCase=new String[1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			exp.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			//exp.stepDetailButton.click();
			bp.waitForElement();
		    actual[23]=exp.changeStepDetailStatus(testcase, status);
		   
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^status should be change to custom status\\(N/A\\)$")
	public void status_should_be_change_to_custom_status_N_A() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			
			int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    String[] status= new String[1];
		    status[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,17);
		    
			
			actual[24]=exp.validateStepDetailStatus(testcase,status);
			
			bp.waitForElement();
			
			actual[25]=pp.clickOnLogout();
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User login as manager$")
	public void user_login_as_manager() throws Throwable {
		try
		{
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Manager_Username_1");
			
			String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Manager_Password_1");
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);

			actual[26]=lp.enterUnameAndPassword(Uname, pwd);
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to status customization and disable the custom status\\(N/A\\)$")
	public void navigate_to_status_customization_and_disable_the_custom_status_N_A() throws Throwable {
		try
		{
			ccp=new CreateCustomFieldsPage(driver);
			actual[27]=ccp.navigatingToCustomizationStatusTab();
			ccp=new CreateCustomFieldsPage(driver);
		    ccp.clickOnExecutionStatusTab();
		    bp.waitForElement();
			String status=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,17);
			actual[28]=ccp.Enable_disabledStatus(status);
			
			
			bp.waitForElement();
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^login as lead role and launch test Execution$")
	public void login_as_lead_role_and_launch_test_Execution() throws Throwable {
		try
		{
            String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Lead_Username_1");
			
			String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Lead_Password_1");
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			actual[29]=pp.clickOnLogout();
			bp.waitForElement();
			lp.enterUname(Uname);
			lp.enterPass(pwd);
			lp.clickOnLogin();
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		    actual[30]=pp.selectProject(projectName);
			actual[31]=pp.selectRelease(releaseName);
			bp.waitForElement();
			actual[32]=rp.clickOnTestExecution();
			bp.waitForElement();
			
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^change the status of testcase from N/A to Pass$")
	public void change_the_status_of_testcase_from_N_A_to_Pass() throws Throwable {
		try
		{
			String[] cycle1=new String[3];
			cycle1[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			cycle1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,5);
		    cycle1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,2);
		    actual[33]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			String[] testCase=new String[1];
			testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
			exp.selectMultipleTestCaseFromExecutionGrid(testCase);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			//exp.stepDetailButton.click();
			
		    int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    String[] status= new String[1];
			status[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,17);
			actual[34]=exp.changeStepDetailStatus(testcase, status);
			bp.waitForElement();
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^status should be change from N/A to Pass$")
	public void status_should_be_change_from_N_A_to_Pass() throws Throwable {
		try
		{
			int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    String[] status= new String[1];
		    status[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,17);
			actual[35]=exp.validateStepDetailStatus(testcase,status);
			pp.clickOnLogout();
			bp.waitForElement();
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Manager_Username_1");
			String pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Manager_Password_1");
		    pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			actual[26]=lp.enterUnameAndPassword(Uname, pwd);
			bp.waitForElement();
		    actual[27]=ccp.navigatingToCustomizationStatusTab();
			ccp=new CreateCustomFieldsPage(driver);
			ccp.clickOnExecutionStatusTab();	
			String status1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,17);
			actual[28]=ccp.Enable_disabledStatus(status1);
			bp.waitForElement();
			bp.waitForElement();
		    pp.clickOnLogout();
            String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Lead_Password_1");
		    lp.enterUnameAndPassword(name, password);
		    bp.waitForElement();
			for(int k=0;k<=actual.length-1;k++)
		     {
			  System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		      soft.assertAll();
		
		
		
           
		
		
		
		}
		
		
		
		
		
		
		
		
		
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
		
		
		
		
	}


	
}
