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

public class Assign_868179 extends LaunchBrowser
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
	boolean[] actual=new boolean[35];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868179";
	@Given("^user in testrepository page to create phase$")
	public void user_in_testrepository_page_to_create_phase() throws Throwable 
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
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Given("^create phase and  add four test cases$")
	public void create_phase_and_add_four_test_cases() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 28, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 28, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 28, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			 bp.waitForElement();
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 23, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 23, 1);
			   tr.clickOnDetails();
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[11]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[12]=tr.cloneTestCase();
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@When("^launch testplanning create cycle and add phase to cycle and save$")
	public void launch_testplanning_create_cycle_and_add_phase_to_cycle_and_save() throws Throwable 
	{
		try
		{
			actual[13]=rp.clickOnTestPlanning();
			bp.waitForElement();
			tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[14]=tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[15]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[16]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[17]=tl.saveTestCycle();
			bp.waitForElement();
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 0);
			actual[18]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 28, 0);
			actual[19]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   bp.waitForElement();
		   actual[20]=tl.cancelBulkAssign();
		   bp.waitForElement();
		   tl.goBackToCycle();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch test planning create Free form and add test cases$")
	public void launch_test_planning_create_Free_form_and_add_test_cases() throws Throwable 
	{
		try
		{
			actual[21]=rp.clickOnTestPlanning();
			bp.waitForElement();
			
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 0);
			actual[22]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String formName=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 4);
			actual[23]=tl.createFreeFormPhase(formName);
			bp.waitForElement();
			
			String formName1[]=new String[1];
			formName1[0]=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 4);
			actual[24]=tl.navigateToCycle(formName1);
			
			actual[25]=tl.clickOnAddTestcasesToFreeForm();
			bp.waitForElement();
			
			String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 23, 0);
			actual[26]=tl.quiksearch(testCaseName);
			bp.waitForElement();
			
			actual[27]=tl.selectAllFreeFormTestCases();
			bp.waitForElement();
			
			actual[28]=tl.clickOnSaveAndOk();
			bp.waitForElement();
			
			actual[29]=tl.closeFreeFormPage();
			bp.waitForElement();
			 tl.goBackToCycle();
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^Launch Assign window for created freeform phase view the Bulk Assign popup$")
	public void launch_Assign_window_for_created_freeform_phase_view_the_Bulk_Assign_popup() throws Throwable 
	{
		try
		{
			actual[30]=rp.clickOnTestPlanning();
			bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 0);
			actual[31]=tl.doubleClickOnCycle(cyclename);
			bp.waitForElement();
			String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 0);
			cyclename1[1]=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 18, 4);
			actual[32]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			actual[33]=tl.assignPhase();
			bp.waitForElement();
			
		   bp.waitForElement();
		   actual[34]=tl.cancelBulkAssign();
		   bp.waitForElement();
		   
		  
		  
		}
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^Bulk Assign popup should automatically popup in \"([^\"]*)\" window for normal/freeform phase if no testcases are assigned$")
	public void bulk_Assign_popup_should_automatically_popup_in_window_for_normal_freeform_phase_if_no_testcases_are_assigned(String arg1) throws Throwable 
	{
		try
		   {
			tl.goBackToCycle();
			   for(int k=0;k<=actual.length-1;k++)
			     {
			      soft.assertEquals(actual[k], true);
			     }
			    soft.assertAll();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}
}
