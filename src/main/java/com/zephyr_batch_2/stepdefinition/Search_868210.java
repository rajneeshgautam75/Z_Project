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

public class Search_868210 extends LaunchBrowser
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
	String fileName="Search_868210";
	boolean[] actual=new boolean[94];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in repository page to Create Phase$")
	public void user_in_repository_page_to_Create_Phase() throws Throwable 
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

	@Given("^create Phase and Add testcases to phase$")
	public void create_Phase_and_Add_testcases_to_phase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 31, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 31, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 31, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			tr.addTestCase();
			   actual[5]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[6]=tr.cloneTestCase();
			   bp.waitForElement();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[7]=tr.cloneTestCase();
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

	@When("^select testcases and provide different contents for each testcases$")
	public void select_testcases_and_provide_different_contents_for_each_testcases() throws Throwable 
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			ep=new ExportPage(driver);
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 31, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			//select  1st testcase
			String[] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 1, 0));
			
			ep.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String[] stepDetails1=new String[3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 1, 2);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 1, 2);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 1, 2);
			bp.waitForElement();
			ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
			//select  2nd testcase
			String[] testCaseNo2=new String[1];
			testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 2, 0));
			ep.selectMultipleTestCaseFromGrid(testCaseNo2);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetails2=new String[3];
			stepDetails2[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 2);
			stepDetails2[1]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 2);
			stepDetails2[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 2);
			bp.waitForElement();
			ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
			//select  3rd testcase
			String[] testCaseNo3=new String[1];
			testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 3, 0));
			ep.selectMultipleTestCaseFromGrid(testCaseNo3);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetails3=new String[3];
			stepDetails3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "planningtags", 3, 2));
			stepDetails3[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "planningtags", 3, 2));
			stepDetails3[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "planningtags", 3, 2));
			bp.waitForElement();
			ctc.enterTestCaseStepDetail(stepDetails3);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
			//select  4th testcase
			String[] testCaseNo4=new String[1];
			testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 4, 0));
			ep.selectMultipleTestCaseFromGrid(testCaseNo4);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetails4=new String[3];
			stepDetails4[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 4, 2);
			stepDetails4[1]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 4, 2);
			stepDetails4[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 4, 2);
			bp.waitForElement();
			ctc.enterTestCaseStepDetail(stepDetails4);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
			//select  5th testcase
			String[] testCaseNo5=new String[1];
			testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 5, 0));
			ep.selectMultipleTestCaseFromGrid(testCaseNo5);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetails5=new String[3];
			stepDetails5[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 5, 2);
			stepDetails5[1]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 5, 2);
			stepDetails5[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 5, 2);
			bp.waitForElement();
			ctc.enterTestCaseStepDetail(stepDetails5);
			bp.waitForElement();
			
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
			//select  6th testcase
			String[] testCaseNo6=new String[1];
			testCaseNo6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 6, 0));
			ep.selectMultipleTestCaseFromGrid(testCaseNo6);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetails6=new String[3];
			stepDetails6[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 6, 2);
			stepDetails6[1]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 6, 2);
			stepDetails6[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 6, 2);
			bp.waitForElement();
			ctc.enterTestCaseStepDetail(stepDetails6);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			
			//select  7th testcase
			String[] testCaseNo7=new String[1];
			testCaseNo7[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 7, 0));
			ep.selectMultipleTestCaseFromGrid(testCaseNo7);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String[] stepDetails7=new String[3];
			stepDetails7[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 8, 2);
			stepDetails7[1]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 8, 2);
			stepDetails7[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 8, 2);
			bp.waitForElement();
			ctc.enterTestCaseStepDetail(stepDetails7);
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

	@When("^launch testplanning create cycle and create free form$")
	public void launch_testplanning_create_cycle_and_create_free_form() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			actual[30]=rp.clickOnTestPlanning();
//			 bp.waitForElement();
//			 rp.clickOnTestPlanning();
			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 21, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 21, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 21, 4);
			tl.createFreeFormPhase(freeFormName);
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

	@When("^click on add testcases and click on advance button$")
	public void click_on_add_testcases_and_click_on_advance_button() throws Throwable 
	{
		try
		{
			String[] freeform=new String[1];
			freeform[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 21, 4);
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

	@When("^search testcases by different contents and add to free form$")
	public void search_testcases_by_different_contents_and_add_to_free_form() throws Throwable 
	{
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_4, "zql", 4, 0);
			String operator=Excel_Lib.getData(INPUT_PATH_4, "zql", 4, 1);
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

	@Then("^Should be able to search Testcases by contents different characters and add it to free form phase$")
	public void should_be_able_to_search_Testcases_by_contents_different_characters_and_add_it_to_free_form_phase() throws Throwable 
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
