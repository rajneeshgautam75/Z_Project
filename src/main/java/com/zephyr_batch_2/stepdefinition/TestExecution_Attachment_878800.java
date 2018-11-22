package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_Attachment_878800 extends LaunchBrowser{
	LaunchBrowser lb=new LaunchBrowser();	
BasePage bp;
ProjectPage pp;
ReleasePage rp;
TestRepositoryPage tr;
TestPlanningPage tp;
ExecutionPage ep;
CreateTestCasePage ctc;
ExportPage epp;
String filename="TestExecution_Attachment_878800";
boolean [] actual=new boolean[34];
SoftAssert soft=new SoftAssert();

String Project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Normal_Project_1");
String Release=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Phase", 47, 0);
String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 47, 1);
String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 21, 0);
	
	@Given("^Lead is in TestRepositoryPage of Normalproject$")
	public void lead_is_in_TestRepositoryPage_of_Normalproject() throws Throwable {
	 try 
	 {
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 actual[0]=pp.selectProject(Project);
		 actual[1]=pp.selectRelease(Release);
		 bp.waitForElement();
		 actual[2]=rp.clickOnTestRep();
		 bp.waitForElement();
		 
	   }
	 catch(Exception e)
	  { lb.getScreenShot(filename);
		 e.printStackTrace();
		 driver.close();
		 Relogin_TPE rl=new Relogin_TPE();
		 rl.reLogin();
		 throw e; 
	   }
	       }

	@When("^Add phase and add testcases with teststeps to phase$")
	public void add_phase_and_add_testcases_with_teststeps_to_phase() throws Throwable {
		try 
		 {
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			epp=new ExportPage(driver);
			actual[3]=tr.doubleClickOnRelease(Release);
			bp.waitForElement();
			actual[4]=tr.addNode(Phase, Desc);
			bp.waitForElement();
			String Phase1[]=new String[1];
			Phase1[0]=Phase;
			actual[5]=tr.navigateToNode(Release, Phase1);
			bp.waitForElement();
			actual[6]=tr.addTestCase();
			bp.waitForElement();
			actual[7]=tr.clickOnDetails();
			bp.waitForElement();
			String[]stepDetails1=new String[3];
			for (int i=0;i<=stepDetails1.length-1;i++)
			{
				stepDetails1[i]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 1, i);
				
			}
			actual[8]=ctc.enterTestCaseStepDetail(stepDetails1);
			bp.waitForElement();
			actual[9]=tr.clickOnList();
			bp.waitForElement();
			actual[10]=tr.selectPhase(Phase);
			bp.waitForElement();
			actual[11]=tr.addTestCase();
			bp.waitForElement();
			String [] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
			epp.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			actual[12]=tr.clickOnDetails();
			bp.waitForElement();
			String[]stepDetails2=new String[3];
			for (int i=0;i<=stepDetails2.length-1;i++)
			{
				stepDetails2[i]=Excel_Lib.getData(INPUT_PATH_5, "StepDetails", 2, i);
				
			}
			actual[13]=ctc.enterTestCaseStepDetail(stepDetails2);
			bp.waitForElement(); 
			tr.clickOnList();
			bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }
	@When("^Launch TestPlanning and  Create new cycle$")
	public void launch_TestPlanning_and_Create_new_cycle() throws Throwable {
		try 
		 {
		 tp=new TestPlanningPage(driver);
		 actual[14]=rp.clickOnTestPlanning();
		 bp.waitForElement();
		 actual[15]=tp.clickOnAddTestCycleSymbol();
		 bp.waitForElement();
		 String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle",1, 1);
		 String environ=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
		 String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
		 actual[16]=tp.CreateCycle(cycle, Build, environ, hide);
		 bp.waitForElement();
		 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
		 String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
		 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
		 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
		 String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
		 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1,5 ));
		 actual[17]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		 bp.waitForElement();
		 actual[18]=tp.saveTestCycle();
		 bp.waitForElement();
		 bp.waitForElement();
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }

	@When("^add phase to created cycle and assign testcases to Lead$")
	public void add_phase_to_created_cycle_and_assign_testcases_to_Lead() throws Throwable {
		try 
		 {
			actual[19]=tr.selectPhase(cycle);
			bp.waitForElement();
			actual[20]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5, "BulkAssignment", 1, 0);
			actual[21]=tp.bulkAssignment(Bulk_type);
			bp.waitForElement();
			 tp.goBackToCycle();
			bp.waitForElement();
			 
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }

	@When("^Launch TestExecution and Add Attachment to a test case step that contains special characters in the file name$")
	public void launch_TestExecution_and_Add_Attachment_to_a_test_case_step_that_contains_special_characters_in_the_file_name() throws Throwable {
		try 
		 {
			 
			tr=new TestRepositoryPage(driver);
			ctc=new CreateTestCasePage(driver);
			epp=new ExportPage(driver);
			 tp=new TestPlanningPage(driver);
			 
			 
			
			 
			ep=new ExecutionPage(driver);
			actual[22]=rp.clickOnTestExecution();
			bp.waitForElement();
			String [] cycle=new String[3];
			cycle[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 21, 0);
			cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5,"Phase", 47, 0);
			actual[23]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			String[] testcase11=new String[1];
			testcase11[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			ep.selectMultipleTestCaseFromExecutionGrid(testcase11);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			bp.waitForElement();
			String sortName[]=new String [1];
			sortName[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 0,13);
			
//			WebElement eleLeftIcon=driver.findElement(By.xpath("//*[@class='fa fa-chevron-left']"));
//			
//			
			Actions a1=new Actions(driver);
			a1.moveToElement(ep.stepDetailButton).click().perform();
			bp.waitForElement();
			bp.waitForElement();
			//bp.waitForElement();
			
			actual[23]=ep.stepSort(sortName);
			bp.waitForElement();
			bp.waitForElement();
			
//			WebElement eleRightIcon=driver.findElement(By.xpath("//*[@class='fa fa-chevron-right']"));
//			//Actions a1=new Actions(driver);
//			a1.moveToElement(eleRightIcon).click().perform();
//			bp.waitForElement();
//			bp.waitForElement();
			
			
			String[] filepath=new String[1];
			filepath[0]=Excel_Lib.getData(INPUT_PATH_5,"Execution", 2, 9);
			actual[23]=ep.uploadStepAttachement(filepath);
			bp.waitForElement();
			
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }

	@Then("^File containing special characters should be attached to a testcase step$")
	public void file_containing_special_characters_should_be_attached_to_a_testcase_step() throws Throwable {
		try 
		 {
			actual[24]=ep.validateStepAttachment();
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			 
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }

	@When("^Add Attachment to a test case step that contains international characters in the file name$")
	public void add_Attachment_to_a_test_case_step_that_contains_international_characters_in_the_file_name() throws Throwable {
		try 
		 {
			actual[24]=tr.selectPhase(Phase);
			bp.waitForElement();
			String [] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
			actual[25]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			Actions a1=new Actions(driver);
			a1.moveToElement(ep.stepDetailButton).click().perform();
			bp.waitForElement();
			bp.waitForElement();
			String sortName[]=new String [1];
			sortName[0]=Excel_Lib.getData(INPUT_PATH_5, "Execution", 0,13);
			actual[26]=ep.stepSort(sortName);
			bp.waitForElement();
			String[] filepath=new String[1];
			filepath[0]=Excel_Lib.getData(INPUT_PATH_5,"Execution", 1, 9);
			actual[27]=ep.uploadStepAttachement(filepath);
			bp.waitForElement();
			
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }

	@Then("^File containing international characters should be attached to a testcase step$")
	public void file_containing_international_characters_should_be_attached_to_a_testcase_step() throws Throwable {
		try 
		 {
			
			actual[28]=ep.validateStepAttachment();
			actual[29]=bp.waitForElement();
			 
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }
	@When("^Download file that contains special characters in the file name$")
	public void download_file_that_contains_special_characters_in_the_file_name() throws Throwable {
		try 
		 {
			int []attachmentNo =new int[1];
			attachmentNo[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			bp.waitForElement();
			String [] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0));
			ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			Actions a1=new Actions(driver);
			a1.moveToElement(ep.stepDetailButton).click().perform();
			bp.waitForElement();
			actual[30]=ep.stepAttachmentDownload(attachmentNo);
			bp.waitForElement();
			
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }

	@When("^Download file that contains international characters in the file name$")
	public void download_file_that_contains_international_characters_in_the_file_name() throws Throwable {
		try 
		 {
			actual[31]=bp.waitForElement();
			String [] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0));
			actual[32]=ep.selectMultipleTestCaseFromExecutionGrid(testCaseNo);
			bp.waitForElement();
			Actions a1=new Actions(driver);
			a1.moveToElement(ep.stepDetailButton).click().perform();
			bp.waitForElement();
			bp.waitForElement();
			int []attachmentNo =new int[1];
			attachmentNo[0]=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 2, 0);
			actual[33]=ep.stepAttachmentDownload(attachmentNo);
			bp.waitForElement();
			tr.clickOnList();
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll(); 
		   }
		 catch(Exception e)
		  {lb.getScreenShot(filename);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e; 
		   }
		       }	
	
	
	
	
	
	

}
