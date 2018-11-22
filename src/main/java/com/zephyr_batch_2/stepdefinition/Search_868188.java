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

public class Search_868188 extends LaunchBrowser
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
	String fileName="Search_868188";
	boolean[] actual=new boolean[94];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in repository page to create a testcases with priority values$")
	public void user_in_repository_page_to_create_a_testcases_with_priority_values() throws Throwable 
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

	@Given("^create a phase and add testcases with priority$")
	public void create_a_phase_and_add_testcases_with_priority() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 62, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 62, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 62, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			
			/*tr.addTestCase();
			   actual[5]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[6]=tr.cloneTestCase();
			   bp.waitForElement();
			   tr.selectallTestCase();
			   bp.waitForElement();
			   actual[7]=tr.cloneTestCase();
			   bp.waitForElement();
			   
			   tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();*/
				ep=new ExportPage(driver);
				//String phase[]=new String[1];
				phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 62, 0);
				tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
				
				//select  1st testcase
				tr.addTestCase();
				tr.clickDetailButton();
				/*bp.waitForElement();
				String[] testCaseNo=new String[1];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 1, 0));
				ep.selectMultipleTestCaseFromGrid(testCaseNo);
				bp.waitForElement();
				tr.clickDetailButton();*/
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String priority1[]=new String[1];
				priority1[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 1, 0);
				ctc.enterPriority(priority1);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
//				ep.selectMultipleTestCaseFromGrid(testCaseNo);
				
				//select  2nd testcase
				
				tr.addTestCase();
				tr.clickDetailButton();
				String[] testCaseNo2=new String[1];
				/*testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 2, 0));
				ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				bp.waitForElement();
				tr.clickDetailButton();*/
				bp.waitForElement();
				String priority2[]=new String[1];
				priority2[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 2, 0);
				ctc.enterPriority(priority2);
				//System.out.println(priority2);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
//				ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				
				//select  3rd testcase
				tr.addTestCase();
				tr.clickDetailButton();
				/*String[] testCaseNo3=new String[1];
				testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 3, 0));
				ep.selectMultipleTestCaseFromGrid(testCaseNo3);
				bp.waitForElement();
				tr.clickDetailButton();*/
				bp.waitForElement();
				String priority3[]=new String[1];
				priority3[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 3, 0);
				ctc.enterPriority(priority3);
				//System.out.println(priority3);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
//				ep.selectMultipleTestCaseFromGrid(testCaseNo3);
				
				//select  4th testcase
				tr.addTestCase();
				tr.clickDetailButton();
				/*String[] testCaseNo4=new String[1];
				testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 4, 0));
				ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				bp.waitForElement();
				tr.clickDetailButton();*/
				bp.waitForElement();
				String priority4[]=new String[1];
				priority4[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 4, 0);
				ctc.enterPriority(priority4);
				//System.out.println(priority4);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
//				ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				
				//select  5th testcase
				tr.addTestCase();
				bp.waitForElement();
				tr.clickDetailButton();
				/*String[] testCaseNo5=new String[1];
				testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 5, 0));
				ep.selectMultipleTestCaseFromGrid(testCaseNo5);
				bp.waitForElement();
				tr.clickDetailButton();*/
				bp.waitForElement();
				String priority5[]=new String[1];
				priority5[0]=Excel_Lib.getData(INPUT_PATH_4, "priority", 5, 0);
				ctc.enterPriority(priority5);
				//System.out.println(priority5);
				bp.waitForElement();
				tr.clickOnList();
				bp.waitForElement();
				//ep.selectMultipleTestCaseFromGrid(testCaseNo5);
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

	@When("^launch test planning create cycle and navigate to cycle and create freeform$")
	public void launch_test_planning_create_cycle_and_navigate_to_cycle_and_create_freeform() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			actual[30]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			 //rp.clickOnTestPlanning();
			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 53, 0);
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
			bp.waitForElement();
			actual[33]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[34]=tl.saveTestCycle();
			bp.waitForElement();
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 53, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 53, 4);
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

	@When("^navigate to freeform phase and launch add testcase window$")
	public void navigate_to_freeform_phase_and_launch_add_testcase_window() throws Throwable 
	{
		try
		{
			String[] freeform=new String[1];
			freeform[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 53, 4);
			bp.waitForElement();
			tl.navigateToCycle(freeform);
			bp.waitForElement();
		    tl.clickOnAddTestcasesToFreeForm();
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

	@When("^launch search window and click on quick search$")
	public void launch_search_window_and_click_on_quick_search() throws Throwable 
	{
		try
		{
			 String priority1=Excel_Lib.getData(INPUT_PATH_4, "priority", 1, 0);
		     tl.quiksearch(priority1);
		     tl.validateSearch();
		     actual[23]=tl.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[24]=tl.clickOnSaveAndOk();
		     bp.waitForElement();
		     tl.closeFreeFormPage();
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

	@When("^search by all priorities and add to freeform$")
	public void search_by_all_priorities_and_add_to_freeform() throws Throwable 
	{
		try
		{
		   tl.clickOnAddTestcasesToFreeForm();
		    bp.waitForElement();
		    String priority2=Excel_Lib.getData(INPUT_PATH_4, "priority", 2, 0);
		     tl.quiksearch(priority2);
		     tl.validateSearch();
		     actual[23]=tl.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[24]=tl.clickOnSaveAndOk();
		     bp.waitForElement();
		     tl.closeFreeFormPage();
		     
		     tl.clickOnAddTestcasesToFreeForm();
			 bp.waitForElement();
		     String priority3=Excel_Lib.getData(INPUT_PATH_4, "priority", 3, 0);
		     tl.quiksearch(priority3);
		     tl.validateSearch();
		     actual[23]=tl.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[24]=tl.clickOnSaveAndOk();
		     bp.waitForElement();
		     tl.closeFreeFormPage();
		     
		     tl.clickOnAddTestcasesToFreeForm();
			 bp.waitForElement();
		     String priority4=Excel_Lib.getData(INPUT_PATH_4, "priority", 4, 0);
		     tl.quiksearch(priority4);
		     tl.validateSearch();
		     actual[23]=tl.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[24]=tl.clickOnSaveAndOk();
		     bp.waitForElement();
		     tl.closeFreeFormPage();
		     
		     tl.clickOnAddTestcasesToFreeForm();
			 bp.waitForElement();
		     String priority5=Excel_Lib.getData(INPUT_PATH_4, "priority", 5, 0);
		     tl.quiksearch(priority5);
		     tl.validateSearch();
		     actual[23]=tl.selectAllFreeFormTestCases();
		     bp.waitForElement();
		     bp.waitForElement();
		     actual[24]=tl.clickOnSaveAndOk();
		     bp.waitForElement();
		     tl.closeFreeFormPage();
		     
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

	@Then("^Should be able to search testcase with all priority values$")
	public void should_be_able_to_search_testcase_with_all_priority_values() throws Throwable 
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
