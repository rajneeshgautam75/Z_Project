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

public class DT_JIRA_188 extends LaunchBrowser {
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
	boolean[] actual=new boolean[34];
	SoftAssert soft=new SoftAssert();
    String fileName="DT_JIRA_188";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^user launches Test repository$")
	public void user_launches_Test_repository() throws Throwable {
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

	@When("^user creates a Phase adds testcase with steps with special chars$")
	public void user_creates_a_Phase_adds_testcase_with_steps_with_special_chars() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			ep=new ExecutionPage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 19, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 19, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 19, 0);
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
	@Then("^should be able to Create a TestCase$")
	public void should_be_able_to_Create_a_TestCase() throws Throwable {
		try
		{
			String stepDetails[]=new String[3];
			stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 2);
			stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 3);
			stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 4);
			tr.verifyPresentTestCase();
			bp.waitForElement();
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


	@When("^user is in a test Planning page$")
	public void user_is_in_a_test_Planning_page() throws Throwable {
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

	@When("^user Creates a cycle,Adds phase to cycle and Assign Testcase to users$")
	public void user_Creates_a_cycle_Adds_phase_to_cycle_and_Assign_Testcase_to_users() throws Throwable {
		try
		{
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 9, 3);
			String build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 1);
			String environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 10, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 5, 5));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 11, 1);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 6, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 9, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 19,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
		    phase_1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 19,0);
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
		    actual[18]=tp.navigateToCycle(phase_1);
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

	@Then("^user To Be able to assign testcase to user$")
	public void user_To_Be_able_to_assign_testcase_to_user() throws Throwable {
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

	@When("^user launch Test Execution Page$")
	public void user_launch_Test_Execution_Page() throws Throwable {
		
		try{
			
			bp.waitForElement();
			actual[22]=rp.clickOnTestExecution();
			
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

	@When("^Executes testcase With the steps and Clicks on D button$")
	public void executes_testcase_With_the_steps_and_Clicks_on_D_button() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",9,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",19,0 );
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			bp.waitForElement();
			actual[23]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[24]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[25]=ep.changeMultiSelectedStatus(status);
			actual[26]=ep.clickOnDefectButton(testcase1);
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

	@Then("^Link Defect Window should be Launched$")
	public void link_Defect_Window_should_be_Launched() throws Throwable {
		try
		{
			   dt=new DefectTracking(driver);
		       bp.waitForElement();
		       actual[27]=ep.validateLinkDefectWindow();
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

	@When("^While Filing defect in desc field Copy steps as As Wikimark Up$")
	public void while_Filing_defect_in_desc_field_Copy_steps_as_As_Wikimark_Up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 9, 3);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String Assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String Sprint=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String env=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String EpicLink=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String AffectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String linkedIssue=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			actual[28]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
	        actual[29]=ep.fileNewDefect(summary, components,descType,desc,fixVersion, priority, Assignee, labels, Sprint, env, EpicLink, AffectsVersion, linkedIssue);
		    bp.waitForElement();
		    actual[30]=dt.saveDefect();
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

	@Then("^In JIRA Desc Field Should include Table of teststeps$")
	public void in_JIRA_Desc_Field_Should_include_Table_of_teststeps() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[31]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[32]=dt.updateDefect();
			bp.waitForElement();
			actual[33]=ep.closeLinkedDefectWindow();
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
