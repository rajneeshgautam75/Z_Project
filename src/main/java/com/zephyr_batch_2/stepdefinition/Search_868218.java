package com.zephyr_batch_2.stepdefinition;

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

public class Search_868218 extends LaunchBrowser
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
	String fileName="Search_868218";
	boolean[] actual=new boolean[94];
	@Given("^user In Repository Page to create phase and testcases$")
	public void user_In_Repository_Page_to_create_phase_and_testcases() throws Throwable 
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

	@Given("^create phase with multiple testcases and add custom field of type checkbox with possible values$")
	public void create_phase_with_multiple_testcases_and_add_custom_field_of_type_checkbox_with_possible_values() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 37, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 37, 1);
			bp.waitForElement();
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 37, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 1, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo1);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String text1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 200);
			String longText1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 200);
			String number1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 111, 222);
			String checkBox1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 1);
			System.out.println(checkBox1);
			String pickupList1=Excel_Lib.getData(INPUT_PATH_4, "planningtags",229, 222);
			String date=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 200, 200);
			ctc.customFieldOption.click();
			bp.waitForElement();
			ctc.enterCustomFields(text1, longText1, number1, checkBox1, pickupList1, date);
			//ctc.enterCustomFieldInTestCasePage(text, longText, number, checkBox, pickupList, date);
			bp.waitForElement();
			tr.clickOnList();
			
			tr.addTestCase();
			String[] testCaseNo2=new String[1];
			testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 2, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo2);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String checkBox2=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 1);
			ctc.customFieldOption.click();
			bp.waitForElement();
			ctc.enterCustomFields(text1, longText1, number1, checkBox2, pickupList1, date);
			bp.waitForElement();
			tr.clickOnList();
			tr.addTestCase();
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

	@When("^Launch Test planning Create Cycle and Create Free Form$")
	public void launch_Test_planning_Create_Cycle_and_Create_Free_Form() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			bp.waitForElement();
			actual[30]=rp.clickOnTestPlanning();
			 bp.waitForElement();
//			 rp.clickOnTestPlanning();
//			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 27, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 27, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 27, 4);
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

	@When("^select freeform Click on Add Testcase Folder and Avance search$")
	public void select_freeform_Click_on_Add_Testcase_Folder_and_Avance_search() throws Throwable 
	{
		try
		{
			String[] freeform=new String[1];
			freeform[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 27, 4);
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

	@When("^Search testcases By custom field of type checkbox and add to freeform$")
	public void search_testcases_By_custom_field_of_type_checkbox_and_add_to_freeform() throws Throwable 
	{
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_4, "zql", 19, 0);
			String operator=Excel_Lib.getData(INPUT_PATH_4, "zql", 10, 1);
			String value=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 13, 0);
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
		    
		    String value2=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 14, 0);
		    String operator2=Excel_Lib.getData(INPUT_PATH_4, "zql", 11, 1);
		    tl.ZQLSearch1(name, operator2, value2);
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

	@Then("^Should be able to search Testcases by checkbox and add it to free form phase$")
	public void should_be_able_to_search_Testcases_by_checkbox_and_add_it_to_free_form_phase() throws Throwable 
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
