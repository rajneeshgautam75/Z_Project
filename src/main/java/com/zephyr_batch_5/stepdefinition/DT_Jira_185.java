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

public class DT_Jira_185 extends LaunchBrowser {
	
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
    String fileName="DT_Jira_185";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User launches Test Repository page$")
	public void user_launches_Test_Repository_page() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			rp=new ReleasePage(driver);
			bp=new BasePage();
			ep=new ExecutionPage(driver);
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

	@When("^user creates a phase add testcase with steps with test steps$")
	public void user_creates_a_phase_add_testcase_with_steps_with_test_steps() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 0);
			bp.waitForElement();
			String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 5, 2);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 5, 3);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 5, 4);
			actual[3]=tr.clickOnRelease(release);
			actual[4]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[5]=tr.navigateToNode(release, navigation);
			actual[6]=tr.addTestCase();	
			bp.waitForElement();
			actual[7]=tr.clickDetailButton();
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

	@When("^Launches test planning$")
	public void launches_test_planning() throws Throwable {
		try
		{
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tr.clickOnList();
			bp.waitForElement();
			actual[10]=rp.clickOnTestPlanning();
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

	@When("^user creates New cycle,Add phase to cycle and Assign testcases to users$")
	public void user_creates_New_cycle_Add_phase_to_cycle_and_Assign_testcases_to_users() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 6, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 6, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
		    phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16,0);
		    int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		    String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
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
		    actual[19]=tp.selectSingleMultipleTestcase(testcase);
		    bp.waitForElement();
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
	@Then("^testcase should be assigned to user$")
	public void testcase_should_be_assigned_to_user() throws Throwable {
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

	@When("^user launches Test execution,Executes testcase with the steps to any status and add notes,Click on D button$")
	public void user_launches_Test_execution_Executes_testcase_with_the_steps_to_any_status_and_add_notes_Click_on_D_button() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",6,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",16,0 );
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
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

	@Then("^Defect window should be Launched$")
	public void defect_window_should_be_Launched() throws Throwable {
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

	@When("^while filling defect,In desc field Copy steps as As wiki mark up$")
	public void while_filling_defect_In_desc_field_Copy_steps_as_As_wiki_mark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 12);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 6);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 13);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 14);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 27, 5);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 14);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 13);
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
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 9);
			
			actual[29]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
	        actual[30]=ep.fileNewDefect(summary, components,descType,desc,fixVersion, priority, assignee, linkedIssue, linkedIssue, linkedIssue, linkedIssue, affectsVersion, linkedIssue);
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

	@Then("^Description field should include table of teststeps$")
	public void description_field_should_include_table_of_teststeps() throws Throwable {
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
