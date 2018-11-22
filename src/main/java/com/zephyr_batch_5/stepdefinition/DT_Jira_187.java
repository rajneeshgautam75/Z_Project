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

public class DT_Jira_187 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[35];
	SoftAssert soft=new SoftAssert();
    String fileName="DT_Jira_187";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^user is in a page of Test Repository$")
	public void user_is_in_a_page_of_Test_Repository() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			bp=new BasePage();
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			bp.waitForElement();
			actual[2]=rp.clickOnTestRep();
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

	@When("^user creates a new phase,add testcase with steps with international chars$")
	public void user_creates_a_new_phase_add_testcase_with_steps_with_international_chars() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			ep=new ExecutionPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 18, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 18, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 18, 0);
			bp.waitForElement();
			actual[3]=tr.clickOnRelease(release);
			actual[4]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[5]=tr.navigateToNode(release, navigation);
			actual[6]=tr.addTestCase();	
			
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

	@Then("^should be able to create testcase$")
	public void should_be_able_to_create_testcase() throws Throwable {
		try
		{
			String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 2);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 3);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 7, 4);
			bp.waitForElement();
			actual[7]=tr.clickDetailButton();
			bp.waitForElement();
			bp.waitForElement();
			actual[8]=ctc.enterTestCaseStepDetail(stepDetails);
			
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

	@When("^user launches testplanning,create a cycle Add phase to cycle and Assign testcases to users$")
	public void user_launches_testplanning_create_a_cycle_Add_phase_to_cycle_and_Assign_testcases_to_users() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 8, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 7, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 1);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 8, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 18,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
		    phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 18,0);
		    int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		    String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tr.clickOnList();
			bp.waitForElement();
			actual[10]=rp.clickOnTestPlanning();
			actual[11]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[12]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[14]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[15]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[16]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[17]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
		    actual[18]=tp.navigateToCycle(phase_1);
		    bp.waitForElement();
		    actual[19]=tp.selectSingleMultipleTestcase(testcase);
		    actual[20]=tp.assignAllSelected(assignee);
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

	@Then("^should able to assign testcase to user$")
	public void should_able_to_assign_testcase_to_user() throws Throwable {
		try
		{
			int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
	    	actual[21]=tp.validateAllAssigned(testcase, assignee);
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

	@When("^user launches test execution,executes testcase with the steps and Clicks on D button$")
	public void user_launches_test_execution_executes_testcase_with_the_steps_and_Clicks_on_D_button() throws Throwable {
		    try
	    	{			
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",8,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",18,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[22]=tp.goBackToCycle();
			bp.waitForElement();
			actual[23]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[24]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[25]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[26]=ep.changeMultiSelectedStatus(status);
			actual[27]=ep.clickOnDefectButton(testcase1);
			
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

	@Then("^link defect window should launch$")
	public void link_defect_window_should_launch() throws Throwable {
		try
	    {
	       dt=new DefectTracking(driver);
	       bp.waitForElement();
	       actual[28]=ep.validateLinkDefectWindow();
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

	@When("^filling defect,in desc field copy steps as wikimark up$")
	public void filling_defect_in_desc_field_copy_steps_as_wikimark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 12);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 6);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 13);
			String fixVersion=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 4, 14));
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 29, 5);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 14);
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 13);
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
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 9);
			
			actual[29]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
	        actual[30]=ep.fileNewDefect(summary, components,descType,desc,fixVersion, priority, assignee, labels, labels, labels, labels, affectsVersion, labels);
		    bp.waitForElement();
		    dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_Url_Field, ze_Url_Field, ze_Multi_User_Picker, ze_Text_Field);
		    actual[31]=dt.saveDefect();
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

	@Then("^in jira desc field should include table of teststeps$")
	public void in_jira_desc_field_should_include_table_of_teststeps() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[32]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[33]=dt.updateDefect();
			bp.waitForElement();
			actual[34]=ep.closeLinkedDefectWindow();
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
