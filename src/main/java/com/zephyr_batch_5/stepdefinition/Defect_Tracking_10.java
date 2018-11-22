package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_10 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	CreateTestCasePage ctc;
	String fileName="Defect_Tracking_10";
	
	boolean[] actual=new boolean[14];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a Defect Tracking page$")
	public void user_is_in_a_Defect_Tracking_page() throws Throwable {
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

	@When("^User search a defects and select multiple defect and select change multiple option$")
	public void user_search_a_defects_and_select_multiple_defect_and_select_change_multiple_option() throws Throwable {
		try
		   {
			 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,0);
			 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,3);
			 String filedBy=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String version=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
			 int[] defectNo1=new int[5];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			 dt=new DefectTracking(driver);
			 actual[1]=dt.defectSearch(projectName, issueType, status, filedBy, version, priority, assignee);
			 dt.selectSingleOrMultipleDefects(defectNo1);
			 actual[2]=dt.defectsOperation(defectValue);
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

	@Then("^Should be able to change values of component$")
	public void should_be_able_to_change_values_of_component() throws Throwable {
		try
		   {
			 String[] componentValue=new String[2];
			 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
			 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,19);
			 String[] versionValue=new String[2];
			 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] fixversionvalue=new String[2];
			 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 actual[3]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue,status,resolution,priority,assignee);
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

	@When("^select change multiple to change version value$")
	public void select_change_multiple_to_change_version_value() throws Throwable {
		try
		   {
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
			 int[] defectNo1=new int[5];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			 bp.waitForElement();
			 bp.waitForElement();
//			 WebElement ele=driver.findElement(By.xpath("//div[@title='Summary']"));
//			 Actions act=new Actions(driver);
//			 act.moveToElement(ele).pause(MAX_EXPLICIT).click();
			 dt.selectSingleOrMultipleDefects(defectNo1);
			 actual[4]=dt.defectsOperation(defectValue);
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

	@Then("^Should be able to change values of version$")
	public void should_be_able_to_change_values_of_version() throws Throwable {
		try
		   {
			 String[] componentValue=new String[2];
			 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] versionValue=new String[2];
			 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
			 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,20);
			 String[] fixversionvalue=new String[2];
			 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 actual[5]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue,status,resolution,priority,assignee);
			 bp.waitForElement();
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

	@When("^select change multiple to change status$")
	public void select_change_multiple_to_change_status() throws Throwable {
		try
		   {
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
			 int[] defectNo1=new int[5];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			 bp.waitForElement();
//			 WebElement ele=driver.findElement(By.xpath("//div[@title='Summary']"));
//			 Actions act=new Actions(driver);
//			 act.moveToElement(ele).pause(MAX_EXPLICIT).click();
			 dt.selectSingleOrMultipleDefects(defectNo1);
			 actual[6]=dt.defectsOperation(defectValue);
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

	@Then("^Should be able to change values of status$")
	public void should_be_able_to_change_values_of_status() throws Throwable {
		try
		   {
			 String[] componentValue=new String[2];
			 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] versionValue=new String[2];
			 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] fixversionvalue=new String[2];
			 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,3);
			 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 actual[7]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue,status,resolution,priority,assignee);
			 bp.waitForElement();
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

	@When("^select change multiple to change FixVersion$")
	public void select_change_multiple_to_change_FixVersion() throws Throwable {
		try
		   {
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
			 int[] defectNo1=new int[5];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			 bp.waitForElement();
//			 WebElement ele=driver.findElement(By.xpath("//div[@title='Summary']"));
//			 Actions act=new Actions(driver);
//			 act.moveToElement(ele).pause(MAX_EXPLICIT).click();
			 dt.selectSingleOrMultipleDefects(defectNo1);
			 bp.waitForElement();
			 actual[8]=dt.defectsOperation(defectValue);
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

	@Then("^Should be able to change values of FixVersion$")
	public void should_be_able_to_change_values_of_FixVersion() throws Throwable {
		try
		   {
			 String[] componentValue=new String[2];
			 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] versionValue=new String[2];
			 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] fixversionvalue=new String[2];
			 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
			 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,20);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 actual[9]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue,status,resolution,priority,assignee);
			 bp.waitForElement();
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

	@When("^select change multiple to change Priority$")
	public void select_change_multiple_to_change_Priority() throws Throwable {
		try
		   {
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
			 int[] defectNo1=new int[5];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			 bp.waitForElement();
//			 WebElement ele=driver.findElement(By.xpath("//div[@title='Summary']"));
//			 Actions act=new Actions(driver);
//			 act.moveToElement(ele).pause(MAX_EXPLICIT).click();
			 dt.selectSingleOrMultipleDefects(defectNo1);
			 bp.waitForElement();
			 actual[10]=dt.defectsOperation(defectValue);
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

	@Then("^Should be able to change values of Priority$")
	public void should_be_able_to_change_values_of_Priority() throws Throwable {
		try
		   {
			 String[] componentValue=new String[2];
			 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] versionValue=new String[2];
			 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] fixversionvalue=new String[2];
			 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
			 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,20);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 actual[11]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue,status,resolution,priority,assignee);
			 bp.waitForElement();
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

	@When("^select change multiple to change Assignee$")
	public void select_change_multiple_to_change_Assignee() throws Throwable {
		try
		   {
			 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
			 int[] defectNo1=new int[5];
			 defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			 defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			 defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			 defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			 defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
			 bp.waitForElement();
//			 WebElement ele=driver.findElement(By.xpath("//div[@title='Summary']"));
//			 Actions act=new Actions(driver);
//			 act.moveToElement(ele).pause(MAX_EXPLICIT).click();
			 dt.selectSingleOrMultipleDefects(defectNo1);
			 bp.waitForElement();
			 actual[12]=dt.defectsOperation(defectValue);
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

	@Then("^Should be able to change values of Assignee$")
	public void should_be_able_to_change_values_of_Assignee() throws Throwable {
		try
		   {
			 String[] componentValue=new String[2];
			 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] versionValue=new String[2];
			 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String[] fixversionvalue=new String[2];
			 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,4);
			 actual[13]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue,status,resolution,priority,assignee);
			 bp.waitForElement();
			 bp.waitForElement();
//			 WebElement ele=driver.findElement(By.xpath("//div[@title='Summary']"));
//			 Actions act=new Actions(driver);
//			 act.moveToElement(ele).pause(MAX_EXPLICIT).click();
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
