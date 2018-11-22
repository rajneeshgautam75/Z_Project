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

public class Search_868216 extends LaunchBrowser
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
	String fileName="Search_868216";
	boolean[] actual=new boolean[94];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in Repository page to create phase$")
	public void user_in_Repository_page_to_create_phase() throws Throwable 
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

	@Given("^create phase with testcases and add custom field of type long text with different charecters$")
	public void create_phase_with_testcases_and_add_custom_field_of_type_long_text_with_different_charecters() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 34, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 34, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 34, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			
			tr.addTestCase();
			//select  1st testcase
			String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 1, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo1);
			bp.waitForElement();
			tr.clickDetailButton();
			ctc=new CreateTestCasePage(driver);
			String text1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 100, 200);
			String longText1=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 1, 2);
			String number=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 200, 200);
			String checkBox=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 200, 200);
			String pickupList=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 200, 200);
			String date=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 200, 200);
			ctc.customFieldOption.click();
			ctc.enterCustomFields(text1, longText1, number, checkBox, pickupList, date);
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
			String longText2=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 2, 2);
			ctc.customFieldOption.click();
			ctc.enterCustomFields(text1, longText2, number, checkBox, pickupList, date);
			tr.clickOnList();
			
			tr.addTestCase();
			String[] testCaseNo3=new String[1];
			testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 3, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo3);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String longText3=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "planningtags", 3, 2));
			ctc.customFieldOption.click();
			ctc.enterCustomFields(text1, longText3, number, checkBox, pickupList, date);
			tr.clickOnList();
			
			tr.addTestCase();
			String[] testCaseNo4=new String[1];
			testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 4, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo4);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String longText4=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 4, 2);
			ctc.customFieldOption.click();
			bp.waitForElement();
			ctc.enterCustomFields(text1, longText4, number, checkBox, pickupList, date);
			
			tr.clickOnList();
			
			tr.addTestCase();
			String[] testCaseNo5=new String[1];
			testCaseNo5[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 5, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo5);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String longText5=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 5, 2);
			ctc.customFieldOption.click();
			bp.waitForElement();
			ctc.enterCustomFields(text1, longText5, number, checkBox, pickupList, date);
			tr.clickOnList();
			
			tr.addTestCase();
			String[] testCaseNo6=new String[1];
			testCaseNo6[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 6, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo6);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String longText6=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 6, 2);
			ctc.customFieldOption.click();
			bp.waitForElement();
			ctc.enterCustomFields(text1, longText6, number, checkBox, pickupList, date);
			tr.clickOnList();
			
			tr.addTestCase();
			String[] testCaseNo7=new String[1];
			testCaseNo7[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4,"tcno", 7, 0));
			ep=new ExportPage(driver);
			ep.selectMultipleTestCaseFromGrid(testCaseNo7);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			String longText8=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 8, 2);
			ctc.customFieldOption.click();
			bp.waitForElement();
			ctc.enterCustomFields(text1, longText8, number, checkBox, pickupList, date);
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

	@When("^launch test planning Create Cycle and create Free form$")
	public void launch_test_planning_Create_Cycle_and_create_Free_form() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			actual[30]=rp.clickOnTestPlanning();
			 bp.waitForElement();
//			 rp.clickOnTestPlanning();
//			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 24, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 24, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 24, 4);
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

	@When("^select freeform Click on add Testcase Folder and Avance search$")
	public void select_freeform_Click_on_add_Testcase_Folder_and_Avance_search() throws Throwable 
	{
		try
		{
			String[] freeform=new String[1];
			freeform[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 24, 4);
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

	@When("^search testcases by custom field of type different long text and add to freeform$")
	public void search_testcases_by_custom_field_of_type_different_long_text_and_add_to_freeform() throws Throwable 
	{
		try
		{
			String name=Excel_Lib.getData(INPUT_PATH_4, "zql", 16, 0);
			String operator=Excel_Lib.getData(INPUT_PATH_4, "zql", 7, 1);
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

	@Then("^Should be able to search Testcases by Long Text different characters and add it to free form phase$")
	public void should_be_able_to_search_Testcases_by_Long_Text_different_characters_and_add_it_to_free_form_phase() throws Throwable 
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
