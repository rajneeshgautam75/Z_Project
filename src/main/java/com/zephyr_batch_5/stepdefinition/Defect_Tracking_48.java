package com.zephyr_batch_5.stepdefinition;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_48 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	String fileName="Defect_Tracking_48";
	
	boolean[] actual=new boolean[6];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in defect Tracking page$")
	public void user_is_in_defect_Tracking_page() throws Throwable {
		try
		   {
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 pp=new ProjectPage(driver);
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 dt=new DefectTracking(driver);
			 pp.selectProject(projectName);
			 pp.selectRelease(releaseName);
			 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User search the defects and select multiple defects$")
	public void user_search_the_defects_and_select_multiple_defects() throws Throwable {
		try
		   {
			 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 6,3);
			 String[] fields=new String[4];
			 for(int i=0;i<=3;i++)
			 {
			   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);	 
			 }
			 int[] defectNo1=new int[5];
//			 for(int i=2;i<=4;i++)
//			 {
//			 defectNo1[i]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", i,16);
//			 }
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			 dt=new DefectTracking(driver);
			 actual[1]=dt.defectSearch(projectName, issueType, status, fields[0], fields[1],fields[2],fields[3]);
			 actual[2]=dt.selectSingleOrMultipleDefects(defectNo1);
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

	@When("^click on change multiple defect option$")
	public void click_on_change_multiple_defect_option() throws Throwable {
		try
		   {
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
			 actual[3]=dt.defectsOperation(defectValue);
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

	@When("^change fix version to multiple fix version for the same project$")
	public void change_fix_version_to_multiple_fix_version_for_the_same_project() throws Throwable {
		try
		   {
			 String[] componentValue=new String[2];
			 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] versionValue=new String[2];
			 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] fixVersion=new String[2];
			 fixVersion[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,27);
			 fixVersion[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,27);
			 String[] fields=new String[6];
			 for(int i=0;i<=3;i++)
			 {
				 fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);	 
			 }
			 actual[4]=dt.changeMultipleDefect(componentValue,versionValue, fixVersion, fields[0],fields[1],fields[2],fields[3]);
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

	@Then("^Should be able to change multiple defects from single fix version to multiple fix version$")
	public void should_be_able_to_change_multiple_defects_from_single_fix_version_to_multiple_fix_version() throws Throwable {
		try
		   {
			 String fixVersion=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 7,20);
			 Actions act=new Actions(driver);
			 driver.navigate().refresh();
			 for(int k=0;k<=9;k++)
			 {
			 bp.waitForElement();
			 }

				for(int i=1;i<=7;i++)
				  {
						act.sendKeys(Keys.DOWN).perform();
				  }
			 actual[5]=dt.validateDefectFixVersion(fixVersion);
			 
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
