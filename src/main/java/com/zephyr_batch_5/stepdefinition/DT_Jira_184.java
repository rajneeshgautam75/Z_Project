package com.zephyr_batch_5.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class DT_Jira_184 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	DefectTracking dt;
	CreateTestCasePage ctc;
	boolean[] actual=new boolean[39];
	SoftAssert soft=new SoftAssert();
    String fileName="DT_Jira_184";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User Is In a test Repository$")
	public void user_Is_In_a_test_Repository() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			ep=new ExecutionPage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[0]=pp.clickOnLogout();
			bp.waitForElement();
			actual[1]=lp.enterUname(uname);
			actual[2]=lp.enterPass(password);        
			actual[3]=lp.clickOnLogin();  
			bp.waitForElement(); 
			actual[4]=pp.selectProject(project);
			bp.waitForElement();
			actual[5]=pp.selectRelease(release);
			bp.waitForElement();
			actual[6]=rp.clickOnTestRep();
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

	@When("^user creates a phase and adds testcase with steps with test steps and test data and Expected Result are blank$")
	public void user_creates_a_phase_and_adds_testcase_with_steps_with_test_steps_and_test_data_and_Expected_Result_are_blank() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			ep=new ExecutionPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 15, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 15, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 15, 0);
			bp.waitForElement();
			String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 4, 2);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 4, 3);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 100, 100);
			actual[7]=tr.clickOnRelease(release);
			actual[8]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[9]=tr.navigateToNode(release, navigation);
			actual[10]=tr.addTestCase();	
			bp.waitForElement();
			actual[11]=tr.verifyPresentTestCase();
			actual[12]=tr.clickDetailButton();
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseStepDetail(stepDetails);
				
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

	@When("^user launches TestPlanning,Creates a Cycle,Adds phase to cycle and Assign testcases to users$")
	public void user_launches_TestPlanning_Creates_a_Cycle_Adds_phase_to_cycle_and_Assign_testcases_to_users() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 5, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 5, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 8, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 9, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 10, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 5, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 15,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
		    phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 15,0);
		    int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		    String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
			bp.waitForElement();
			bp.waitForElement();
			actual[14]=tr.clickOnList();
			bp.waitForElement();
			actual[15]=rp.clickOnTestPlanning();
			actual[16]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[17]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[18]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[19]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[20]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[21]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[22]=tp.bulkAssignment(bulk_type);
			actual[23]=tp.navigateToCycle(phase_1);
		    actual[24]=tp.selectSingleMultipleTestcase(testcase);
		    actual[25]=tp.assignAllSelected(assignee);
			
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

	@When("^Launches TestExecution,Executes testcase with the steps to custom steps and Clicks on D button$")
	public void launches_TestExecution_Executes_testcase_with_the_steps_to_custom_steps_and_Clicks_on_D_button() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",5,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",15,0 );
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			actual[26]=tp.goBackToCycle();
			bp.waitForElement();
			actual[27]=rp.clickOnTestExecution();
			actual[28]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[29]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[30]=ep.changeMultiSelectedStatus(status);
			actual[31]=ep.clickOnDefectButton(testcase1);
			
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

	@Then("^defect window to be launch$")
	public void defect_window_to_be_launch() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			bp.waitForElement();
			actual[32]=ep.validateLinkDefectWindow();
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

	@When("^user while creating a defetct,In desc Field copy steps as wikimark up$")
	public void user_while_creating_a_defetct_In_desc_Field_copy_steps_as_wikimark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 12);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 6);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 13);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 14);
			String priority=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 26, 5));
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 14);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 19, 13);
			String ze_Url_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multiple_Select_Field[]=new String[1];
			ze_Multiple_Select_Field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_Version_field[]=new String[6];
			ze_Multi_Version_field[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Single_Select_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Multi_User_Picker[]=new String[1];
			ze_Multi_User_Picker[0]=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Text_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 9);
			
			actual[33]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[34]=ep.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, linkedIssue, linkedIssue, linkedIssue, linkedIssue, affectsVersion, linkedIssue);
			bp.waitForElement();
			dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_Url_Field, ze_Url_Field, ze_Multi_User_Picker, ze_Text_Field);
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

	@Then("^Desc Field should include table of steps$")
	public void desc_Field_should_include_table_of_steps() throws Throwable {
		try
		{
		String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
		String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
		bp.waitForElement();
		actual[36]=dt.validateDefect(projectType, issueType);
		bp.waitForElement();
		actual[37]=dt.updateDefect();
		bp.waitForElement();
		actual[38]=ep.closeLinkedDefectWindow();
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
