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

public class Search_868207 extends LaunchBrowser
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
	String fileName="Search_868207";
	boolean[] actual=new boolean[94];
	 SoftAssert soft=new SoftAssert();
	@Given("^User in Repository page to add phaseand add testCases$")
	public void user_in_Repository_page_to_add_phaseand_add_testCases() throws Throwable 
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

	@Given("^create a phase and add test cases$")
	public void create_a_phase_and_add_test_cases() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 29, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 29, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 29, 0);
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

	@When("^select testcases and provide different alt IDs$")
	public void select_testcases_and_provide_different_alt_IDs() throws Throwable 
	{
		try
		{
		 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			ep=new ExportPage(driver);
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 29, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			//select  1st testcase
			String[] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 1, 0));
			ep.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			/*String[] tags=new String[1];
			tags[0]=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 1, 2);
			ctc=new CreateTestCasePage(driver);
			//ctc.enterMultipleTags(tags);*/
			ctc=new CreateTestCasePage(driver);
	/*		String[] Details=new String[4];
			Details[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details[1]=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 1, 2);
			Details[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details[3]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			*/
			String AltID2=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 1, 2);
			String Priority2=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			String Comment2=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetails(Priority2, AltID2, Comment2);
			bp.waitForElement();
			
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
		/*	String[] Details2=new String[4];
			Details2[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details2[1]=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 2, 2);
			Details2[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details2[3]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetail(Details2);*/
			String AltID3=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 2, 2);
			String Priority3=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			String Comment3=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetails(Priority3, AltID3, Comment3);
			bp.waitForElement();
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
			/*String[] Details3=new String[4];
			Details3[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details3[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"planningtags", 3, 2));
			Details3[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details3[3]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetail(Details3);*/
			String AltID4=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"planningtags", 3, 2));
			String Priority4=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			String Comment4=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetails(Priority4, AltID4, Comment4);
			bp.waitForElement();
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
		/*	String[] Details4=new String[4];
			Details4[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details4[1]=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 4, 2);
			Details4[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details4[3]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetail(Details4);*/
			String AltID5=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 4, 2);
			String Priority5=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			String Comment5=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetails(Priority5, AltID5, Comment5);
			bp.waitForElement();
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
		/*	String[] Details5=new String[4];
			Details5[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details5[1]=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 5, 2);
			Details5[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details5[3]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetail(Details5);*/
			String AltID6=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 5, 2);
			String Priority6=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			String Comment6=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetails(Priority6, AltID6, Comment6);
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
		/*	String[] Details6=new String[4];
			Details6[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details6[1]=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 6, 2);
			Details6[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details6[3]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetail(Details6);*/
			String AltID7=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 6, 2);
			String Priority7=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			String Comment7=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetails(Priority7, AltID7, Comment7);
			bp.waitForElement();
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
		/*	String[] Details7=new String[4];
			Details7[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details7[1]=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 7, 2);
			Details7[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			Details7[3]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetail(Details7);*/
			String AltID8=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 7, 2);
			String Priority8=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			String Comment8=Excel_Lib.getData(INPUT_PATH_4,"planningtags", 100, 100);
			bp.waitForElement();
			actual[13]=ctc.enterTestCaseDetails(Priority8, AltID8, Comment8);
			bp.waitForElement();
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
	@When("^launch test planning create cycle and add freeform$")
	public void launch_test_planning_create_cycle_and_add_freeform() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			actual[30]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			 //rp.clickOnTestPlanning();
			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 19, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 19, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 19, 4);
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

	@When("^click on add testcase click on advance search$")
	public void click_on_add_testcase_click_on_advance_search() throws Throwable 
	{
		try
		{
			String[] freeform=new String[1];
			freeform[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 19, 4);
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

	@Then("^search testcases by altid with different charecters and add to free form$")
	public void search_testcases_by_altid_with_different_charecters_and_add_to_free_form() throws Throwable 
	{
		try
		{
			String[] zql=new String[2];
			String name=Excel_Lib.getData(INPUT_PATH_4, "zql", 2, 0);
			String operator=Excel_Lib.getData(INPUT_PATH_4, "zql", 2, 1);
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
		    
		    String value7=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 7, 0);
		    String operator7=Excel_Lib.getData(INPUT_PATH_4, "zql", 14, 1);
		    tl.ZQLSearch1(name, operator7, value7);
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

	@Then("^Should be able to search Testcases of different characters and add it to free form phase$")
	public void should_be_able_to_search_Testcases_of_different_characters_and_add_it_to_free_form_phase() throws Throwable 
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
