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
//import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_22 extends LaunchBrowser{
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	DashBoardPage dp;
	ExecutionPage ep;
	LaunchBrowser lb;
	LoginPage lp;
	DefectTracking dt;
    boolean[] actual=new boolean[16];
	SoftAssert soft=new SoftAssert();
	String fileName="DefectTracking_22";
   
	@Given("^User Is In defectTracking Page$")
	public void user_Is_In_defectTracking_Page() throws Throwable {
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
	@When("^User create defect with corresponding project and issuetype then click on cancel$")
	public void user_create_defect_with_corresponding_project_and_issuetype_then_click_on_cancel() throws Throwable {
		 try
		   {
			dt=new DefectTracking(driver); 
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		   	bp.waitForElement();
			actual[3]=bp.explicitWait(dt.createDefectButton);
			dt.createDefectButton.click();
			bp.waitForElement();
			actual[4]=bp.explicitWait(dt.selectDefectProject);
			Actions a1=new Actions(driver);
			a1.moveToElement(dt.selectDefectProject).click().pause(1200).sendKeys(project).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
			a1.moveToElement(dt.issueType).click().pause(1200).sendKeys(issuetype).sendKeys(Keys.ENTER).perform();
		    dt.CancelButton.click();
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

	@When("^Search defect and create subtask with corresponding project and issuetype then click on cancel$")
	public void search_defect_and_create_subtask_with_corresponding_project_and_issuetype_then_click_on_cancel() throws Throwable {
		try
		   {
		   dp=new DashBoardPage(driver);
		   ep=new ExecutionPage(driver);
		   String defectValue=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 31);
		   String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   int[] defectNo=new int[1];
		   defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 1, 30);
		   actual[5]=dt.searchDefect(defectID);	
		   bp.waitForElement();
		   actual[6]=dt.selectSingleOrMultipleDefects(defectNo);
		   bp.waitForElement();
		   actual[7]=dt.defectsOperation(defectValue);
		   bp.waitForElement();
		   Actions a1=new Actions(driver);
		   a1.moveToElement(dt.issueType).click().pause(1200).sendKeys(issuetype_1).sendKeys(Keys.ENTER).perform();
		   bp.waitForElement();
		   dt.CancelButton.click();
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

	@When("^user click on TextExecution and execute testcases with any status$")
	public void user_click_on_TextExecution_and_execute_testcases_with_any_status() throws Throwable {
		try
		   {
	       tr=new TestRepositoryPage(driver);
	       rp=new ReleasePage(driver);
	       ep=new ExecutionPage(driver); 
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 19);
		   String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 17);
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		   String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 25);
		   String cyclename[]=new String[1];
		   cyclename[0]=cycle;
		   String phase1[]=new String[1];
		   phase1[0]=name;
		   String[] str=new String[2];
		   str[0]=cycle;
		   str[1]=phase;
		   actual[8]=rp.clickOnTestExecution();
		   bp.waitForElement();
		   actual[9]=tr.navigateToNode(releaseName, str);
		   bp.waitForElement();
		   ep.selectAndDeselectAllTestCase();
		   bp.waitForElement();
		   actual[10]=ep.changeMultiSelectedStatus(status);
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

	@When("^User click on D and create defect with corresponding project and issuetype and click on cancel$")
	public void user_click_on_D_and_create_defect_with_corresponding_project_and_issuetype_and_click_on_cancel() throws Throwable {
		try
		   {	
		    String project=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 0);
		    String issuetype=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 1);
		    int testcase=Excel_Lib.getNumberData(INPUT_PATH_6,"DefectTracking", 2, 26);
		    actual[11]=ep.clickOnDefectButton(testcase);
		    bp.waitForElement();
		    actual[12]=bp.explicitWait(ep.createDefectButton);
			ep.createDefectButton.click();
			bp.waitForElement();
			actual[13]=bp.explicitWait(ep.selectDefectProject);
			Actions a1=new Actions(driver);
			a1.moveToElement(ep.selectDefectProject).click().pause(1200).sendKeys(project).sendKeys(Keys.ENTER).perform();
			bp.waitForElement();
			a1.moveToElement(ep.issueType).click().pause(1200).sendKeys(issuetype).sendKeys(Keys.ENTER).perform();
		    bp.waitForElement();
		    ep.CancelButton1.click();
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

	@When("^user click on D and create subtask with corresponding project and issuetype then click on cancel$")
	public void user_click_on_D_and_create_subtask_with_corresponding_project_and_issuetype_then_click_on_cancel() throws Throwable {
		try
		   {
	       String issuetype_1=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 32);
		   String defectID=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 16);
		   String selectSearch=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 1, 27);
		   actual[14]=ep.defectSearch(selectSearch, defectID);
		   bp.waitForElement();
		   actual[15]=ep.clickOnSubtask();
		   bp.waitForElement();
		   Actions a1=new Actions(driver);
		   a1.moveToElement(dt.issueType).click().pause(1200).sendKeys(issuetype_1).sendKeys(Keys.ENTER).perform();
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
