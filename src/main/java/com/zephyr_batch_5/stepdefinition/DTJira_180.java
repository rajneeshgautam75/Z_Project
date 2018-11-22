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

public class DTJira_180 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	boolean[] actual=new boolean[44];
	SoftAssert soft=new SoftAssert();
    String fileName="DTJira_180";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User Logins as Manager to Zephyr$")
	public void user_Logins_as_Manager_to_Zephyr() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			rp=new ReleasePage(driver);
			ep=new ExecutionPage(driver);
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

	@When("^User set DTS to JIRA$")
	public void user_set_DTS_to_JIRA() throws Throwable {
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

	@Then("^Should be able to Set$")
	public void should_be_able_to_Set() throws Throwable {

		try
		{
			String dts=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "DTS_Type");
			String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "JIRA_URL");
	    	String username=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Jira_Username");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Jira_Password");
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

	@When("^User launch test repository$")
	public void user_launch_test_repository() throws Throwable {
		try
		{
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[7]=pp.clickOnLogout();
			bp.waitForElement();
			actual[8]=lp.enterUname(uname);
			actual[9]=lp.enterPass(password);      
			actual[10]=lp.clickOnLogin(); 
			bp.waitForElement();
			actual[11]=pp.selectProject(project);
			actual[12]=pp.selectRelease(release);
			bp.waitForElement();
			actual[13]=rp.clickOnTestRep();
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

	@When("^user creates a phase and adds testcase without steps$")
	public void user_creates_a_phase_and_adds_testcase_without_steps() throws Throwable {
		try
		{
			tp=new TestPlanningPage(driver);
			tr=new TestRepositoryPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 11, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 11, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 11, 0);
			bp.waitForElement();
			actual[14]=tr.clickOnRelease(release);
			actual[15]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[16]=tr.navigateToNode(release, navigation);
			actual[17]=tr.addTestCase();	     
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
	@Then("^user should be able to create TestCase$")
	public void user_should_be_able_to_create_TestCase() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
	    	actual[18]=tr.verifyPresentTestCase();
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

	@When("^User is In a TestPlanning,Creates a cycle and Add phase to cycle and Assign testcases to users$")
	public void user_is_In_a_TestPlanning_Creates_a_cycle_and_Add_phase_to_cycle_and_Assign_testcases_to_users() throws Throwable {
	    try
	    {
	    	String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 4, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 11,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
	    	phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 11, 0);
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
			bp.waitForElement();
			actual[19]=rp.clickOnTestPlanning();
			bp.waitForElement();
			actual[20]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[21]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[22]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[23]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[24]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[25]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[26]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			actual[27]=tp.navigateToCycle(phase_1);
			bp.waitForElement();
			actual[28]=tp.selectSingleMultipleTestcase(testcase);
	    	actual[29]=tp.assignAllSelected(assignee);	
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
	@Then("^user should be able to assign TestCases to user$")
	public void user_should_be_able_to_assign_TestCases_to_user() throws Throwable {
	    try
	    {
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
	    	actual[30]=tp.validateAllAssigned(testcase, assignee);
	    	actual[31]=tp.goBackToCycle();
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

	@When("^User Launches TestExecution$")
	public void user_Launches_TestExecution() throws Throwable {
		try
		{
			
			
			bp.waitForElement();
			actual[32]=rp.clickOnTestExecution();
			
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
	@When("^User Execute a testcase and Clicks on D button$")
	public void user_Execute_a_testcase_and_Clicks_on_D_button() throws Throwable {
		try
		{
			
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",1,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",11,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[33]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[34]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[35]=ep.changeMultiSelectedStatus(status);
			actual[36]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Link defect window should launch$")
	public void link_defect_window_should_launch() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			bp.waitForElement();
			actual[37]=ep.validateLinkDefectWindow();
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

	@When("^user While filing defect,In desc field copy steps as wikimark up$")
	public void user_While_filing_defect_In_desc_field_copy_steps_as_wikimark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 2, 12));
			String components=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 19,6));
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 2, 13));
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 14);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 5);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 14);

			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 13);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[6];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 11);
			ze_Multiple_Select_Field[1]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 11);
			ze_Multiple_Select_Field[2]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 11);
			ze_Multiple_Select_Field[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 22, 11));
			ze_Multiple_Select_Field[4]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 11);
			ze_Multiple_Select_Field[5]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 11);
			String ze_Multi_Version_field[]=new String[7];
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 9);
			ze_Multi_Version_field[1]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 9);
			ze_Multi_Version_field[2]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 9);
			ze_Multi_Version_field[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 22, 9));
			ze_Multi_Version_field[4]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 9);
			ze_Multi_Version_field[5]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 9);
			ze_Multi_Version_field[6]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 9);
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 26, 10);
			String ze_Multi_User_Picker[]=new String[1];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 26, 10);
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 26, 0);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 9);
			actual[38]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[39]=ep.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, labels, labels, labels, affectsVersion, labels);
			bp.waitForElement();
			dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_Url_Field, ze_Url_Field, ze_Multi_User_Picker, ze_Text_Field);
			bp.waitForElement();
			actual[40]=dt.saveDefect();
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

	@Then("^In JIRA desc field should include table of teststeps$")
	public void in_JIRA_desc_field_should_include_table_of_teststeps() throws Throwable {
	    try
	    {
	    	String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[41]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[42]=dt.updateDefect();
			bp.waitForElement();
			bp.waitForElement();
			actual[43]=ep.clickOnCancelDefectWindow();
	    	
	    	 for(int k=0;k<=actual.length-1;k++)
				{
					
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
