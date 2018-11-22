package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.By;

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

public class Search_868204 extends LaunchBrowser
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
	String fileName="Search_868204";
	boolean[] actual=new boolean[94];
	String[] ids=new String[2];
	@Given("^user in repository page to create phase and add testcases to search$")
	public void user_in_repository_page_to_create_phase_and_add_testcases_to_search() throws Throwable 
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

	@Given("^create phase add testcases to phase with all custom fields$")
	public void create_phase_add_testcases_to_phase_with_all_custom_fields() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 38, 1);
			bp.waitForElement();
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 38, 0);
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			//testcase id
			tr.addTestCase();
			int k=0;
			int i=1;
			ids[k]=driver.findElement(By.xpath(tr.testcaseID1+i+tr.testcaseID2)).getText();
			System.out.println(ids[k]);
			//for custom fields
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String text=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 0);
			String longText=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 1);
			String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "planningtags", 19, 2));
			String checkBox=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 3);
			String pickupList=Excel_Lib.getData(INPUT_PATH_4, "planningtags",19, 4);
			String date=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 200, 200);
			ctc.customFieldOption.click();
			bp.waitForElement();
			ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
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

	@When("^create phase add testcases to phase with all available fields$")
	public void create_phase_add_testcases_to_phase_with_all_available_fields() throws Throwable 
	{
		try
		{
			//for priority altid,comment
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 38, 0);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
			tr.addTestCase();
			bp.waitForElement();
			tr.clickDetailButton();
			String Priority=Excel_Lib.getData(INPUT_PATH_4, "priority", 1, 0);
			String AltID=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 5);
			String Comment=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 6);
			ctc.enterTestCaseDetails(Priority, AltID, Comment);
			tr.clickOnList();
			
			//for tags
			tr.addTestCase();
			bp.waitForElement();
			tr.clickDetailButton();
			String[] tags=new String[1];
			tags[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 7);
			ctc.enterMultipleTags(tags);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			//for name
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			String testCaseName=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 24, 0);
			String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 24, 1);
			ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			bp.waitForElement();
			tr.clickOnList();
			
			//stepdetails
			tr.addTestCase();
			tr.clickDetailButton();
			bp.waitForElement();
			ctc=new CreateTestCasePage(driver);
			String[] stepDetails1=new String[3];
			stepDetails1[0]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 8);
			stepDetails1[1]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 8);
			stepDetails1[2]=Excel_Lib.getData(INPUT_PATH_4, "planningtags", 19, 8);
			ctc.enterTestCaseStepDetail(stepDetails1);
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

	@When("^Launch Test planning Create Cycle and Create Free Form and select freeform$")
	public void launch_Test_planning_Create_Cycle_and_Create_Free_Form_and_select_freeform() throws Throwable 
	{
		try
		{
			tl=new TestPlanningPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			bp.waitForElement();
			actual[30]=rp.clickOnTestPlanning();
			 //rp.clickOnTestPlanning();
			 bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 28, 0);
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
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 28, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String freeFormName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 28, 4);
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

	@When("^Click on Add Testcase Folder and Avance search$")
	public void click_on_Add_Testcase_Folder_and_Avance_search() throws Throwable 
	{
		try
		{
			String[] freeform=new String[1];
			freeform[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 28, 4);
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

	@When("^Search testcases By all available fields and add to freeform$")
	public void search_testcases_By_all_available_fields_and_add_to_freeform() throws Throwable 
	{
		try
		{/*
		////id
		String name=Excel_Lib.getData(INPUT_PATH_4, "zql", 11, 0);
		String operator=Excel_Lib.getData(INPUT_PATH_4, "zql", 11, 1);
		String value1=ids[0];
	    tl.ZQLSearch1(name, operator, value1);
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
	    bp.waitForElement();*/
	    
	    //customfields text
	    String name2=Excel_Lib.getData(INPUT_PATH_4, "zql", 15, 0);
	    String operator2=Excel_Lib.getData(INPUT_PATH_4, "zql", 6, 1);
	    String text=Excel_Lib.getData(INPUT_PATH_4, "zql", 6, 2);
	    tl.ZQLSearch1(name2, operator2, text);
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
	    
	  //customfields long text
	    String name3=Excel_Lib.getData(INPUT_PATH_4, "zql", 16, 0);
	    String operator3=Excel_Lib.getData(INPUT_PATH_4, "zql", 7, 1);
	    String longText=Excel_Lib.getData(INPUT_PATH_4, "zql", 7, 2);
	    tl.ZQLSearch1(name3, operator3, longText);
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
	  //customfields number
	    String name4=Excel_Lib.getData(INPUT_PATH_4, "zql", 18, 0);
	    String operator4=Excel_Lib.getData(INPUT_PATH_4, "zql", 9, 1);
	    String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "zql", 9, 2));
	    tl.ZQLSearch1(name4, operator4, number);
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
	    
		  //customfields checkbox
	    String name5=Excel_Lib.getData(INPUT_PATH_4, "zql", 19, 0);
	    String operator5=Excel_Lib.getData(INPUT_PATH_4, "zql", 10, 1);
	    String checkbox=Excel_Lib.getData(INPUT_PATH_4, "zql", 10, 2);
	    tl.ZQLSearch1(name5, operator5, checkbox);
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
	    
	    //customfields  picklist
	    String name6=Excel_Lib.getData(INPUT_PATH_4, "zql", 17, 0);
	    String operator6=Excel_Lib.getData(INPUT_PATH_4, "zql", 8, 1);
	    String picklist=Excel_Lib.getData(INPUT_PATH_4, "zql", 8, 2);
	    tl.ZQLSearch1(name6, operator6, picklist);
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
	    
	  // priority
	    String name7=Excel_Lib.getData(INPUT_PATH_4, "zql", 12, 0);
	    String operator7=Excel_Lib.getData(INPUT_PATH_4, "zql", 12, 1);
	    String priority=Excel_Lib.getData(INPUT_PATH_4, "zql", 12, 2);
	    tl.ZQLSearch1(name7, operator7, priority);
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
	    
	    // altid
	    String name8=Excel_Lib.getData(INPUT_PATH_4, "zql", 2, 0);
	    String operator8=Excel_Lib.getData(INPUT_PATH_4, "zql", 2, 1);
	    String altid=Excel_Lib.getData(INPUT_PATH_4, "zql", 2, 2);
	    tl.ZQLSearch1(name8, operator8, altid);
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
	    
	    // comment
	    String name9=Excel_Lib.getData(INPUT_PATH_4, "zql", 3, 0);
	    String operator9=Excel_Lib.getData(INPUT_PATH_4, "zql", 3, 1);
	    String comment=Excel_Lib.getData(INPUT_PATH_4, "zql", 3, 2);
	    tl.ZQLSearch1(name9, operator9, comment);
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
	    
	    // tags
	    String name10=Excel_Lib.getData(INPUT_PATH_4, "zql", 1, 0);
	    String operator10=Excel_Lib.getData(INPUT_PATH_4, "zql", 1, 1);
	    String tags=Excel_Lib.getData(INPUT_PATH_4, "zql", 1, 2);
	    tl.ZQLSearch1(name10, operator10, tags);
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
	    
	    // names
	    String name11=Excel_Lib.getData(INPUT_PATH_4, "zql", 5, 0);
	    String operator11=Excel_Lib.getData(INPUT_PATH_4, "zql", 5, 1);
	    String names=Excel_Lib.getData(INPUT_PATH_4, "zql", 5, 2);
	    tl.ZQLSearch1(name11, operator11, names);
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
	    
	    //contents
	    String name12=Excel_Lib.getData(INPUT_PATH_4, "zql", 4, 0);
	    String operator12=Excel_Lib.getData(INPUT_PATH_4, "zql", 4, 1);
	    String contents=Excel_Lib.getData(INPUT_PATH_4, "zql", 4, 2);
	    tl.ZQLSearch1(name12, operator12, contents);
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

	@Then("^Suggestion popup should be automatically popup with values for fields and operators$")
	public void suggestion_popup_should_be_automatically_popup_with_values_for_fields_and_operators() throws Throwable 
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
