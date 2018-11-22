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

public class DT_Jira_186 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[36];
	SoftAssert soft=new SoftAssert();
    String fileName="DT_Jira_186";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User is IN a TestRepository$")
	public void user_is_IN_a_TestRepository() throws Throwable {
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
	@When("^user creates a new Phase and adds Testcase with steps with Test Steps$")
	public void user_creates_a_new_Phase_and_adds_Testcase_with_steps_with_Test_Steps() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			ep=new ExecutionPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 17, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 17, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 17, 0);
			bp.waitForElement();
			actual[3]=tr.clickOnRelease(release);
			actual[4]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[5]=tr.navigateToNode(release, navigation);
			actual[6]=tr.addTestCase();	
			bp.waitForElement();
			actual[7]=tr.verifyPresentTestCase();
			bp.waitForElement();
			actual[8]=tr.clickDetailButton();
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


@Then("^To  be able to create a TestCase with steps$")
public void to_be_able_to_create_a_TestCase_with_steps() throws Throwable {
		try
	    {
	    	String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 6, 2);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 6, 3);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 6, 4);
	    	bp.waitForElement();
	    	actual[9]=ctc.enterTestCaseStepDetail(stepDetails);
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

	@When("^user launches testplanning$")
	public void user_launches_testplanning() throws Throwable {
	    try
	    {
	    	bp.waitForElement();
	    	bp.waitForElement();
	    	actual[10]=tr.clickOnList();
			bp.waitForElement();
			actual[11]=rp.clickOnTestPlanning();
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

	@When("^creates a New Cycle, Add phase to cycle and Assign testcases to users$")
	public void creates_a_New_Cycle_Add_phase_to_cycle_and_Assign_testcases_to_users() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 7, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 9, 5));
			String phase_1[]=new String[1];
		    phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 17,0);
		    int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		    String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 7, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 17,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			actual[12]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[13]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[14]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[15]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[16]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[17]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[18]=tp.bulkAssignment(bulk_type);
			actual[19]=tp.navigateToCycle(phase_1);
			bp.waitForElement();
			actual[20]=tp.selectSingleMultipleTestcase(testcase);
		    actual[21]=tp.assignAllSelected(assignee);
			
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

	@Then("^should be Able To assign Testcases to User$")
	public void should_be_Able_To_assign_Testcases_to_User() throws Throwable {
		try
		   {
		    	int testcase[]=new int[1];
		    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
		    	actual[22]=tp.validateAllAssigned(testcase, assignee);
		    	bp.waitForElement();
		    	actual[23]=tp.goBackToCycle();
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

	@When("^user launches test execution$")
	public void user_launches_test_execution() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[24]=rp.clickOnTestExecution();
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

	@When("^Executes testcase with the steps partially and Clicks on D button$")
	public void executes_testcase_with_the_steps_partially_and_Clicks_on_D_button() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",7,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",17,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			bp.waitForElement();
			actual[25]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[26]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[27]=ep.changeMultiSelectedStatus(status);
			actual[28]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Defect window to be launched$")
	public void defect_window_to_be_launched() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			bp.waitForElement();
			actual[29]=ep.validateLinkDefectWindow();
			
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
	@When("^while filling defect,In description Field copy steps as wikimark up$")
	public void while_filling_defect_In_description_Field_copy_steps_as_wikimark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 12);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 6, 13);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 14);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 28, 5);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 14);
			
			String zeRadioField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 21, 12));
			String zeCheckboxField=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 21, 13));
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
			
			actual[30]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
	        actual[31]=ep.fileNewDefect(summary, components,descType,desc,fixVersion, priority, assignee, labels, labels, labels, labels, affectsVersion, labels);
		    bp.waitForElement();
		    dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_Url_Field, ze_Url_Field, ze_Multi_User_Picker, ze_Text_Field);
		    actual[32]=dt.saveDefect();
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

	@Then("^Desc field should include table of teststeps In JIRA$")
	public void desc_field_should_include_table_of_teststeps_In_JIRA() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[33]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[34]=dt.updateDefect();
			bp.waitForElement();
			actual[35]=ep.closeLinkedDefectWindow();
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
