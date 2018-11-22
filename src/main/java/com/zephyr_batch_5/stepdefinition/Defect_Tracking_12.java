package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_12 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExportPage ep;
	ExecutionPage exep;
	DefectTracking dt;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	CreateTestCasePage ctc;
	String fileName="Defect_Tracking_12";
	
	boolean[] actual=new boolean[33];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User Launch TestRepository and create a phase with testcases and add teststeps$")
	public void user_Launch_TestRepository_and_create_a_phase_with_testcases_and_add_teststeps() throws Throwable {
		try
		   {
			 bp=new BasePage();
			 pp=new ProjectPage(driver);
			 rp=new ReleasePage(driver);
			 ep=new ExportPage(driver);
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		     pp.clickOnLogout();
		     bp.waitForElement();
		     lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
		     String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 12);
			 String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		     actual[0]=lp.enterUname(Uname);
		     actual[1]=lp.enterPass(Pass);
		     lp.clickOnLogin();

			 actual[0]=pp.selectProject(projectName);
		     actual[1]=pp.selectRelease(releaseName);
		     bp.waitForElement();
		     actual[2]=rp.clickOnTestRep();
		     tr=new TestRepositoryPage(driver);
				
				actual[3]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);  
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				bp.waitForElement();
				actual[5]=tr.navigateToNode(releaseName, phase);
				for(int i=1;i<=4;i++)
				{
				tr.addTestCase();
				}
				tr.clickOnDetails();
				bp.waitForElement();
				String[] stepDetail=new String[3];
				stepDetail[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 6);
				stepDetail[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 7);
				stepDetail[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1, 8);
				String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16));
				String[] testCaseNo2=new String[1];
				testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16));
				String[] testCaseNo3=new String[1];
				testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16));
				String[] testCaseNo4=new String[1];
				testCaseNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16));
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				ep.selectMultipleTestCaseFromGrid(testCaseNo1);
				//ctc.TestStep.click();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				ep.selectMultipleTestCaseFromGrid(testCaseNo2);
				//ctc.TestStep.click();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				ep.selectMultipleTestCaseFromGrid(testCaseNo3);
				//ctc.TestStep.click();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				ep.selectMultipleTestCaseFromGrid(testCaseNo4);
				//ctc.TestStep.click();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
				tr.clickOnList();
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

	@When("^Launch TestPlanning and create a Cycle and add phase and assign testcase to anyone$")
	public void launch_TestPlanning_and_create_a_Cycle_and_add_phase_and_assign_testcase_to_anyone() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[10]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 13);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[11]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[12]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[14]=tp.saveTestCycle();
				bp.waitForElement();
				
				bp.waitForElement();
				actual[15]=rp.clickOnTestPlanning();
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 13);
				actual[16]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2, 12);
				actual[17]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[18]=tp.bulkAssignment(Bulk_Type);
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

	@When("^Launch TestExecution and execute testcase and click on D button$")
	public void launch_TestExecution_and_execute_testcase_and_click_on_D_button() throws Throwable {
		try
		   {
			    /* pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   actual[15]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,13 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,12 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[16]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[17]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[18]=exep.executeStatus(tcNo2[0], statusType2);
			    
			    int[] tcNo3=new int[1];
			    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[19]=exep.executeStatus(tcNo3[0], statusType3);
			    
			    int[] tcNo4=new int[1];
				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
			    bp.waitForElement();
			    actual[20]=exep.executeStatus(tcNo4[0], statusType4);
			    
			    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
				actual[21]=exep.clickOnDefectButton(testcase1);
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

	@When("^click on create defect and enter details and select copy steps from dropdown and save$")
	public void click_on_create_defect_and_enter_details_and_select_copy_steps_from_dropdown_and_save() throws Throwable {
		try
		   {
			   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,0 );
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,2 );
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,18 );
			   String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,17 );
			   String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,6 );
			   String Assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String env=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String EpicLink=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String AffectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String linkedIssue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   dt=new DefectTracking(driver);
			   bp.waitForElement();
			   actual[22]=dt.createDefect(project, issuetype);
			   actual[23]=dt.fileNewDefect(summary,components,descType,desc,fixVersion, priority, Assignee, labels,sprint, env, EpicLink, AffectsVersion, linkedIssue);
			   actual[24]=dt.saveDefect();
			   
			  
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

	@Then("^Should not be able to show teststeps in description field$")
	public void should_not_be_able_to_show_teststeps_in_description_field() throws Throwable {
		try
		   {
			   actual[25]=exep.validateDefectDescription();
			   actual[26]=dt.updateDefect();
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

	@When("^click on create defect and enter details and select copy steps as plain text and save$")
	public void click_on_create_defect_and_enter_details_and_select_copy_steps_as_plain_text_and_save() throws Throwable {
		try
		   {
			   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,0 );
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,2 );
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,18 );
			   String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,17 );
			   String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,6 );
			   String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String env=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String epicLink=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String linkedIssue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   bp.waitForElement();
			   actual[27]=dt.createDefect(project, issuetype);
			   dt.fileNewDefect(summary, components, descType,desc,fixVersion, priority, assignee, labels,sprint, env, epicLink, affectsVersion, linkedIssue);
			   dt.saveDefect();
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

	@Then("^Should be able to view the test steps,testdata and expected results,status and notes$")
	public void should_be_able_to_view_the_test_steps_testdata_and_expected_results_status_and_notes() throws Throwable {
		try
		   {
			   actual[28]=exep.validateDefectDescription();
			   bp.waitForElement();
			   actual[29]=dt.updateDefect();
			   bp.waitForElement();
			   bp.waitForElement();
				 exep.cancelDefect.click();
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

	@When("^click on create defect and enter details and select copy steps as wiki markup and save$")
	public void click_on_create_defect_and_enter_details_and_select_copy_steps_as_wiki_markup_and_save() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
			   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2 ,0 );
			   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,2 );
			   String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,18 );
			   String components=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String descType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3 ,17 );
			   String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1 ,6 );
			   String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String labels=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String sprint=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String env=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String epicLink=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String affectsVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   String linkedIssue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
			   bp.waitForElement();
			   exep.clickOnDefectButton(testcase1);
			   actual[30]=dt.createDefect(project, issuetype);
			   dt.fileNewDefect(summary, components, descType,desc,fixVersion, priority, assignee, labels, sprint,env, epicLink, affectsVersion, linkedIssue);
			   bp.waitForElement();
			   dt.saveDefect();
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

	@Then("^Should be able to view the Test Steps,testdata and expected results,status and notes$")
	public void should_be_able_to_view_the_Test_Steps_testdata_and_expected_results_status_and_notes() throws Throwable {
		try
		   {
			   actual[31]=exep.validateDefectDescription();
			   bp.waitForElement();
			   actual[32]=dt.updateDefect();
			   bp.waitForElement();
			   bp.waitForElement();
				 exep.cancelDefect.click();
				 bp.waitForElement();
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				 tp.doubleClickOnCycle(releaseName);
				 bp.waitForElement();
			   //pp.backToProjectPage();
			   for(int k=0;k<=actual.length-1;k++)
				{
					System.out.println("Actual["+k+"]="+actual[k]);
					//soft.assertEquals(actual[k], true);
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
