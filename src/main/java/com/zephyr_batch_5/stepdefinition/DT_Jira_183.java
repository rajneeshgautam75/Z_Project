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

public class DT_Jira_183 extends LaunchBrowser {
	
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
    String fileName="DT_Jira_183";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User launches TestRepository$")
	public void user_launches_TestRepository() throws Throwable {
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

	@When("^User creates a Phase and adds test case with steps$")
	public void user_creates_a_Phase_and_adds_test_case_with_steps() throws Throwable {
		try
		{
			
			tp=new TestPlanningPage(driver);
			
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 14, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 14, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 14, 0);
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
	@Then("^should be able to create a test case$")
	public void should_be_able_to_create_a_test_case() throws Throwable {
	    try
	    {
	    	String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 3, 2);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 3, 3);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 3, 4);
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

	@When("^user launches Test planning,creates cycle adds phase to cycle AND assign TestCase to user$")
	public void user_launches_Test_planning_creates_cycle_adds_phase_to_cycle_AND_assign_TestCase_to_user() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 5, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 6, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 4, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 14,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
		    phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 14,0);
		    int testcase[]=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		    String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
		    bp.waitForElement();
			actual[10]=tr.clickOnList();
			bp.waitForElement();
			actual[11]=rp.clickOnTestPlanning();
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
	@Then("^To be able to assign TestCase to user$")
	public void to_be_able_to_assign_TestCase_to_user() throws Throwable {
	   try
	   {
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
	    	actual[22]=tp.validateAllAssigned(testcase, assignee);
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

	@When("^user launch Test execution,Executes testcase with the steps to custom steps$")
	public void user_launch_Test_execution_Executes_testcase_with_the_steps_to_custom_steps() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",4,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",14,0 );
			bp.waitForElement();
			actual[23]=tp.goBackToCycle();
			bp.waitForElement();
			actual[24]=rp.clickOnTestExecution();
			actual[25]=tr.navigateToNode(release, cycleName);
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

	@When("^user Clicks On D button$")
	public void user_Clicks_On_D_button() throws Throwable {
		try
		{
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
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

	@Then("^Defect Window should launch$")
	public void defect_Window_should_launch() throws Throwable {
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

	@When("^user while Filling a defect,In desc Field copy steps as As Wikimark up$")
	public void user_while_Filling_a_defect_In_desc_Field_copy_steps_as_As_Wikimark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 12);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 22, 6);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 5, 13);
			String fixVersion=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 4, 14));
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 5);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 14);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 25, 13);
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
			String ze_Version_Field=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 22, 9));
			
			actual[30]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[31]=ep.fileNewDefect(summary, components,descType, desc,fixVersion, priority, assignee, linkedIssue, linkedIssue, linkedIssue, linkedIssue, affectsVersion, linkedIssue);
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

	@Then("^Desc Field should include table of teststeps$")
	public void desc_Field_should_include_table_of_teststeps() throws Throwable {
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
