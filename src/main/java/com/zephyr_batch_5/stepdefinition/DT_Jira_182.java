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

public class DT_Jira_182 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[40];
	SoftAssert soft=new SoftAssert();
    String fileName="DT_Jira_182";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
    
	@Given("^User is in a TestRepository$")
	public void user_is_in_a_TestRepository() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			actual[0]=pp.clickOnLogout();
			bp.waitForElement();
			actual[1]=lp.enterUname(uname);
			actual[2]=lp.enterPass(password);        
			actual[3]=lp.clickOnLogin();  
			bp.waitForElement(); 
			actual[4]=pp.selectProject(project);
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

	@When("^user creates a phase and add testcase with steps$")
	public void user_creates_a_phase_and_add_testcase_with_steps() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			ep=new ExecutionPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 13, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13, 0);
			bp.waitForElement();
			actual[7]=tr.clickOnRelease(release);
			actual[8]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[9]=tr.navigateToNode(release, navigation);
			actual[10]=tr.addTestCase();	
			bp.waitForElement();
			actual[11]=tr.verifyPresentTestCase();
			bp.waitForElement();
			actual[12]=tr.clickDetailButton();
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
	@Then("^should be able to create a testcase with steps$")
	public void should_be_able_to_create_a_testcase_with_steps() throws Throwable {
		try
		{
			String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 2);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 3);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 4);
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

	@When("^user Launch Test planning creates a Cycle,adds phase to cycle and assign Testcases To user$")
	public void user_Launch_Test_planning_creates_a_Cycle_adds_phase_to_cycle_and_assign_Testcases_To_user() throws Throwable {
	    try
	    {
	    	String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 2, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 4, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 6, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 8, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 3, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
			phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13,0);
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
			bp.waitForElement();
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
	@Then("^should be Able to assign Testcase to User$")
	public void should_be_Able_to_assign_Testcase_to_User() throws Throwable {
	    try
	    {
	    	String phase[]=new String[1];
	    	phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 13,0);
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
	    	actual[26]=tp.validateAllAssigned(testcase, assignee);
	    	
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

	@When("^user launches test execution execute testcase with steps and clicks on D button$")
	public void user_launches_test_execution_execute_testcase_with_steps_and_clicks_on_D_button() throws Throwable {
	    try
	    {
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",3,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",13,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[27]=tp.goBackToCycle();
			bp.waitForElement();
			actual[28]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[29]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[30]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[31]=ep.changeMultiSelectedStatus(status);
			actual[32]=ep.clickOnDefectButton(testcase1);
	    	
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
	

	@Then("^link Defect Window Should launch$")
	public void link_Defect_Window_Should_launch() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			bp.waitForElement();
			actual[33]=ep.validateLinkDefectWindow();
			
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

	@When("^While filing defect,In desc field copy Steps as  As wikimark up$")
	public void while_filing_defect_In_desc_field_copy_Steps_as_As_wikimark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 12);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 6);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 4, 13);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 14);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 5);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 17, 7);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "Defects", 4, 14));
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 24, 13);
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
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 21, 9);
			
			actual[34]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[35]=ep.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, labels, labels, labels, affectsVersion, labels);
			bp.waitForElement();
			dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_Url_Field, ze_Url_Field, ze_Multi_User_Picker, ze_Text_Field);
			actual[36]=dt.saveDefect();
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

	@Then("^desc field should include table of teststeps in JIRA$")
	public void desc_field_should_include_table_of_teststeps_in_JIRA() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[37]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[38]=dt.updateDefect();
			bp.waitForElement();
			bp.waitForElement();
			actual[39]=ep.closeLinkedDefectWindow();
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
