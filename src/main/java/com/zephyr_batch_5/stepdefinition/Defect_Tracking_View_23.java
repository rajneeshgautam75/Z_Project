package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_View_23 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	LaunchBrowser lb;
	LoginPage lp;
	ExportPage ex;
	RequirementsPage req;
	DefectTracking dt;
    boolean[] actual=new boolean[29];
	SoftAssert soft=new SoftAssert();
	String fileName="Defect_Tracking_View_23";


	@Given("^User is in Defecttracking page$")
	public void user_is_in_Defecttracking_page() throws Throwable {
     	try
	       {
		   bp=new BasePage();
		   rp=new ReleasePage(driver);
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   actual[2]=pp.clickOnDefectTracking();
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

	@When("^user create defect and select project and verify the all respective project name in dropdown$")
	public void user_create_defect_and_select_project_and_verify_the_all_respective_project_name_in_dropdown() throws Throwable {
		try
		   {
		   dt=new DefectTracking(driver);	
		   String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 100);
		   bp.waitForElement();
		   actual[3]=bp.explicitWait(dt.createDefectButton);
		   dt.createDefectButton.click();
		   bp.waitForElement();
		   actual[4]=bp.explicitWait(dt.selectDefectProject);
		   Actions a1=new Actions(driver);
		   a1.moveToElement(dt.selectDefectProject).click().pause(1200).sendKeys(project).sendKeys(Keys.ENTER).perform();
		   bp.waitForElement();
		   a1.moveToElement(dt.issueType).click().pause(1200).sendKeys(issuetype).sendKeys(Keys.ENTER).perform();
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

	@Then("^Should be able to view dropdown fields in DefectTracking$")
	public void should_be_able_to_view_dropdown_fields_in_DefectTracking() throws Throwable {
     	try
		   {
			dt=new DefectTracking(driver);
			actual[5]=dt.verifyProjects1();
			bp.waitForElement();
			dt.CancelButton.click();
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

	@When("^user click on TextExecution and create defect and select project and verify the all respective project name in dropdown$")
	public void user_click_on_TextExecution_and_create_defect_and_select_project_and_verify_the_all_respective_project_name_in_dropdown() throws Throwable {
		try
		   {
	       tr=new TestRepositoryPage(driver);
	       rp=new ReleasePage(driver);
	       tp=new TestPlanningPage(driver);
	       ep=new ExecutionPage(driver); 
	       String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
    	   String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 100, 100);
	       String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String desc=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 18);
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String build=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 20);
		   String environ=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 21);
		   String hide=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 22);
		   String bulk_type_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 23);
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
		   String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
		   String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
		   String sdate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
		   String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
		   String emonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
		   String edate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));  
		   int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 26);
		   String cyclename[]=new String[1];
		   cyclename[0]=cycle;
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   actual[6]=rp.clickOnTestRep();
		   bp.waitForElement();
		   actual[7]=tr.clickOnRelease(releaseName);
		   bp.waitForElement();
		   actual[8]=tr.addNode(name, desc);
		   bp.waitForElement();
		   actual[9]=tr.doubleClickOnRelease(releaseName);
		   bp.waitForElement();
		   actual[10]=tr.navigateToNode(releaseName,phase1);
		   bp.waitForElement();
		   actual[11]=tr.addTestCase();
		   actual[12]=tr.addTestCase();
		   bp.waitForElement();
		   actual[13]=rp.clickOnTestPlanning();
		   bp.waitForElement();
		   actual[14]=tp.clickOnAddTestCycleSymbol();
		   bp.waitForElement();
		   actual[15]=tp.CreateCycle(cycle, build, environ, hide);
		   bp.waitForElement();
		   actual[16]=tp.enterStartDatAndEndDate(syear, smonth, sdate, eyear, emonth, edate);
		   bp.waitForElement();
		   actual[17]=tp.saveTestCycle();
		   bp.waitForElement();
		   actual[18]=tp.navigateToCycle(cyclename);
		   bp.waitForElement();
		   actual[19]=tp.addPhaseToCycle(name);
		   bp.waitForElement();
		   actual[20]=tp.bulkAssignment(bulk_type_1);
		   tp.goBackToCycle();
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[21]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[22]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   actual[23]=ep.selectAndDeselectAllTestCase();
		   //tr.select_all_TestCase.click();
		   bp.waitForElement();
		   actual[24]=ep.changeMultiSelectedStatus(status);
		   bp.waitForElement();		   
		   actual[25]=ep.clickOnDefectButton(testcase);
		   bp.waitForElement();
	       bp.waitForElement();
		   actual[26]=bp.explicitWait(dt.createDefectButton);
		   dt.createDefectButton.click();
		   bp.waitForElement();
		   actual[27]=bp.explicitWait(dt.selectDefectProject);
		   Actions a1=new Actions(driver);
		   a1.moveToElement(dt.selectDefectProject).click().pause(1200).sendKeys(project).sendKeys(Keys.ENTER).perform();
		   bp.waitForElement();
		   a1.moveToElement(dt.issueType).click().pause(1200).sendKeys(issuetype).sendKeys(Keys.ENTER).perform();
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


@Then("^should be able to view dropdown fields in TextExecution$")
public void should_be_able_to_view_dropdown_fields_in_TextExecution() throws Throwable {
	    try
		   {
		   dt=new DefectTracking(driver);	
		   actual[28]=dt.verifyProjects1();
		   bp.waitForElement();
		   ep.CancelButton1.click();
		   bp.waitForElement();
		   ep.cancelDefect.click();
		   for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
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

