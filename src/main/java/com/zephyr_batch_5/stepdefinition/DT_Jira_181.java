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

public class DT_Jira_181 extends LaunchBrowser {
	
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
	boolean[] actual=new boolean[47];
	SoftAssert soft=new SoftAssert();
    String fileName="DT_Jira_181";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	@Given("^User Logins As Manager Credentials to Zephyr$")
	public void user_Logins_As_Manager_Credentials_to_Zephyr() throws Throwable {
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

	@When("^user set DTS TO JIRA$")
	public void user_set_DTS_TO_JIRA() throws Throwable {
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

@Then("^DTS should be set$")
public void dts_should_be_set() throws Throwable {
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

@When("^user is in  Test Repository,Creates a phase and add testcase with steps$")
public void user_is_in_Test_Repository_Creates_a_phase_and_add_testcase_with_steps() throws Throwable {
		try
		{
			rp=new ReleasePage(driver);
			tp=new TestPlanningPage(driver);
			
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 12, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 12, 1);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 12, 0);
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
			bp.waitForElement();
			actual[14]=tr.clickOnRelease(release);
			actual[15]=tr.addNode(name, desc);
			bp.waitForElement();
			actual[16]=tr.navigateToNode(release, navigation);
			actual[17]=tr.addTestCase();	
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
@Then("^should able to create a testcase$")
public void should_able_to_create_a_testcase() throws Throwable {
	try
	{
		tr=new TestRepositoryPage(driver);
		String stepDetails[]=new String[3];
		stepDetails[0]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 2);
		stepDetails[1]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 3);
		stepDetails[2]=Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 4);
		actual[18]=tr.verifyPresentTestCase();
		bp.waitForElement();
		actual[19]=tr.clickDetailButton();
		bp.waitForElement();
		bp.waitForElement();
		actual[20]=ctc.enterTestCaseStepDetail(stepDetails);
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


@When("^user Launches Test planning creates cycle,Add phase to cycle and assign testcases to users$")
public void user_Launches_Test_planning_creates_cycle_Add_phase_to_cycle_and_assign_testcases_to_users() throws Throwable {
	    
		try
		{
	    	String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 3);
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
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 2, 3);
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 12,0);
			String bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 3, 0);
			String phase_1[]=new String[1];
	    	phase_1[0]=phase;
	    	int testcase[]=new int[1];
	    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
	    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
			bp.waitForElement();
			bp.waitForElement();
			actual[21]=tr.clickOnList();
			bp.waitForElement();
			actual[22]=rp.clickOnTestPlanning();
			actual[23]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[24]=tp.CreateCycle(cycle, build, environment, hide);
			bp.waitForElement();
			actual[25]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[26]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[27]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[28]=tp.addPhaseToCycle(phase);
			bp.waitForElement();
			actual[29]=tp.bulkAssignment(bulk_type);
			bp.waitForElement();
			actual[30]=tp.navigateToCycle(phase_1);
			actual[31]=tp.selectSingleMultipleTestcase(testcase);
	    	actual[32]=tp.assignAllSelected(assignee);
	    	
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
@Then("^should be able Assign testcase to users$")
public void should_be_able_Assign_testcase_to_users() throws Throwable {
    try
    {
    	int testcase[]=new int[1];
    	testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
    	String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Lead_1");
    	actual[33]=tp.validateAllAssigned(testcase, assignee);
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

@When("^user Launches test execution exexute testcase not the steps and clicks on D button$")
public void user_Launches_test_execution_exexute_testcase_not_the_steps_and_clicks_on_D_button() throws Throwable {
		try
		{
			ep=new ExecutionPage(driver);
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",2,3 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",12,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			actual[34]=tp.goBackToCycle();
			bp.waitForElement();
			actual[35]=rp.clickOnTestExecution();
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

	@Then("^Link defect window should be launched$")
	public void link_defect_window_should_be_launched() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			ep=new ExecutionPage(driver);
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

	@When("^While filing defect in desc field copy steps as As wikimark up$")
	public void while_filing_defect_in_desc_field_copy_steps_as_As_wikimark_up() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			String summary=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 12);
			String components=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 6);
			String descType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 2);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Defects", 3, 13);
			String fixVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 2, 14);
			String priority=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 5);
			String assignee=Excel_Lib.getData(INPUT_PATH_7, "Defects", 16, 7);
			String labels=Excel_Lib.getData(INPUT_PATH_7, "Defects", 100, 100);
			String affectsVersion=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 14);
			
			String zeRadioField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 12);
			String zeCheckboxField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 23, 13);
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
			String zeFreeTextField=Excel_Lib.getData(INPUT_PATH_7, "Defects", 26, 10);
			String ze_Version_Field=Excel_Lib.getData(INPUT_PATH_7, "Defects", 20, 9);
			
			actual[41]=dt.createDefect(projectType, issueType);
			bp.waitForElement();
			actual[42]=ep.fileNewDefect(summary, components, descType, desc, fixVersion, priority, assignee, labels, labels, labels, labels, affectsVersion, labels);
			bp.waitForElement();
			dt.enterDefectCustomFields(zeFreeTextField, zeRadioField, zeCheckboxField, ze_Url_Field, ze_Multiple_Select_Field, ze_Single_Select_Field, ze_Multi_Version_field, ze_Version_Field, ze_Url_Field, ze_Url_Field, ze_Multi_User_Picker, ze_Text_Field);
			actual[43]=dt.saveDefect();
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

	@Then("^In jira desc field should include table of teststeps$")
	public void in_jira_desc_field_should_include_table_of_teststeps() throws Throwable {
		try
		{
			String projectType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 0);
			String issueType=Excel_Lib.getData(INPUT_PATH_7, "Defects", 1, 1);
			bp.waitForElement();
			actual[44]=dt.validateDefect(projectType, issueType);
			bp.waitForElement();
			actual[45]=dt.updateDefect();
			bp.waitForElement();
			bp.waitForElement();
			actual[46]=ep.clickOnCancelDefectWindow();
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
