package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search_868209 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	String fileName="Search_868209";
	boolean[] actual=new boolean[94];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in repository page to create phase and add testcases with different charecters$")
	public void user_in_repository_page_to_create_phase_and_add_testcases_with_different_charecters() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement();
		   }
		   catch (Exception e) 
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

	@Given("^create a phase and add Testcases to Phase to provide different names$")
	public void create_a_phase_and_add_Testcases_to_Phase_to_provide_different_names() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 63, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 63, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 63, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String testCaseName1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 1, 2);
			String testCaseDesc1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 1, 2);
			ctc.enterTestCaseNameAndDesc(testCaseName1, testCaseDesc1);
			bp.waitForElement();
			tr.clickOnList();
			
			tr.addTestCase();
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String testCaseName2=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 2);
			String testCaseDesc2=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 2);
			ctc.enterTestCaseNameAndDesc(testCaseName2, testCaseDesc2);
			bp.waitForElement();
			tr.clickOnList();
			
			tr.addTestCase();
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String testCaseName3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "planningtags", 3, 2));
			String testCaseDesc3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "planningtags", 3, 2));
			ctc.enterTestCaseNameAndDesc(testCaseName3, testCaseDesc3);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
		 }
		   catch (Exception e) 
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

	@When("^select testcases and Provide Different names for each testcases$")
	public void select_testcases_and_Provide_Different_names_for_each_testcases() throws Throwable 
	{
		try
		{
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			String testCaseName7=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 4, 2);
			String testCaseDesc7=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 4, 2);
			ctc.enterTestCaseNameAndDesc(testCaseName7, testCaseDesc7);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			String testCaseName4=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 5, 2);
			String testCaseDesc4=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 5, 2);
			ctc.enterTestCaseNameAndDesc(testCaseName4, testCaseDesc4);
			tr.clickOnList();
			bp.waitForElement();
			
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			String testCaseName5=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 6, 2);
			String testCaseDesc5=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 6, 2);
			ctc.enterTestCaseNameAndDesc(testCaseName5, testCaseDesc5);
			tr.clickOnList();
			bp.waitForElement();
			
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			String testCaseName8=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 8, 2);
			String testCaseDesc8=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 8, 2);
			ctc.enterTestCaseNameAndDesc(testCaseName8, testCaseDesc8);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@When("^Launch test planning create cycle and Create Freeform$")
	public void launch_test_planning_create_cycle_and_Create_Freeform() throws Throwable
	{
		try
		{
			tl=new TestPlanningPage(driver);
			actual[30]=rp.clickOnTestPlanning();
			 //bp.waitForElement();
			 //rp.clickOnTestPlanning();
			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 54, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 6, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[31]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[32]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[33]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[34]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 54, 0);
			bp.waitForElement();
			actual[35]=tl.navigateToCycle(cyclename1);
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 54, 4);
			bp.waitForElement();
			tl.createFreeFormPhase(freeFormName);
			bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@When("^Select freeform click on add Testcase and advance search button$")
	public void select_freeform_click_on_add_Testcase_and_advance_search_button() throws Throwable 
	{
		try
		{
			String[] freeform=new String[1];
			freeform[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 54, 4);
			bp.waitForElement();
			tl.navigateToCycle(freeform);
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
		    bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@Then("^search Testcases by Different names and add to free form$")
	public void search_Testcases_by_Different_names_and_add_to_free_form() throws Throwable 
	{
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_4, "zql", 5, 0);
			String operator=Excel_Lib.getData(INPUT_PATH_4, "zql", 5, 1);
			String value=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 1, 0);
		    tl.ZQLSearch1(name, operator, value);
		    bp.waitForElement();
		    tl.validateSearch();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
		    bp.waitForElement();
		    
		    String value2=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 0);
		    tl.ZQLSearch1(name, operator, value2);
		    bp.waitForElement();
		    tl.validateSearch();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
		    bp.waitForElement();

		    String value3=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 3, 0);
		    tl.ZQLSearch1(name, operator, value3);
		    bp.waitForElement();
		    tl.validateSearch();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
		    bp.waitForElement();
		    
		    String value4=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 4, 0);
		    tl.ZQLSearch1(name, operator, value4);
		    bp.waitForElement();
		    tl.validateSearch();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		  
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
		    bp.waitForElement();
		  
		    String value5=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 5, 0);
		    tl.ZQLSearch1(name, operator, value5);
		    bp.waitForElement();
		    tl.validateSearch();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
		    bp.waitForElement();
		    
		    String value6=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 6, 0);
		    tl.ZQLSearch1(name, operator, value6);
		    bp.waitForElement();
		    tl.validateSearch();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    tl.clickOnAdvanceSearch();
		    bp.waitForElement();
		    
		    String value7=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 8, 0);
		    tl.ZQLSearch1(name, operator, value7);
		    bp.waitForElement();
		    tl.validateSearch();
		    bp.waitForElement();
		    tl.selectAllFreeFormTestCases();
		    bp.waitForElement();
		    tl.clickOnSaveAndOk();
		    bp.waitForElement();
		    tl.closeFreeFormPage();
		    bp.waitForElement();
		    
		    bp.waitForElement();
		 	tl.selectallTestCase();
		 	bp.waitForElement();
		 	String assignee=Excel_Lib.getData(INPUT_PATH_4, "Assignee",5 ,0 );
		 	tl.assignAllSelected(assignee);
		 	bp.waitForElement();
    	    bp.waitForElement();
		 }
		   catch (Exception e) 
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

	@Then("^Should be able to search Testcases by creator using ZQL with different operators and add it to free form phase$")
	public void should_be_able_to_search_Testcases_by_creator_using_ZQL_with_different_operators_and_add_it_to_free_form_phase() throws Throwable 
	{
		try
		   {
			   tl.validateAddtestcaesToFreeForm();
			   tl.goBackToCycle();
		   }
		   catch (Exception e) 
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
