package com.zephyr_batch_1.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Import_SingleFile_MultiTC_803008 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	BasePage bp;
	String fileName="Import_SingleFile_MultiTC_803008";
	boolean[] actual=new boolean[9];
	  SoftAssert soft=new SoftAssert();
	@Given("^User is in TestrepositoryPage$")
	public void user_is_in_TestrepositoryPage() throws Throwable 
	{
		try
		{
//		lb=new LaunchBrowser();
//		   lb.preCond();
//		   lp=new LoginPage(driver);
//		   String Uname=Excel_Lib.getData(INPUT_PATH,"Login",2,0);
//		   String Pass=Excel_Lib.getData(INPUT_PATH,"Login",2,1);
//		   lp.enterUname(Uname);
//		   lp.enterPass(Pass);
//		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"Normal_Project_1");
		   String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		   actual[0]=pp.selectProject(projectName);
		   actual[1]=pp.selectRelease(releaseName);
		   
		   rp= new ReleasePage(driver);
		   actual[2]= rp.clickOnTestRep();
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
				lb.getScreenShot(fileName);	
			   driver.close();
				Relogin rl=new Relogin();
				rl.reLogin();
				throw e;
			}
	}

	@When("^User Moves to the Release$")
	public void user_Moves_to_the_Release() throws Throwable 
	{
		try
		{
		tr=new TestRepositoryPage(driver);
		 String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		 actual[3]=tr.doubleClickOnRelease(releaseName);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Clicks on ImportIcon$")
	public void user_Clicks_on_ImportIcon() throws Throwable 
	{
		try
		{
		 ip= new ImportPage(driver);
		 bp=new BasePage();
		 actual[4]=ip.clickOnImport();
		 bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Import a file with Testcase$")
	public void user_Import_a_file_with_Testcase() throws Throwable 
	{
		try
		{
		bp=new BasePage();
		String mapname1=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 0);
		int rownum1=Excel_Lib.getNumberData(INPUT_PATH, "Create_Map", 1, 1);
		String descrimi1=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 2);
		String desc1=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 3);
		String name1=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 4);
		String testSteps1=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 5);
		String expResults1=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 6);
		String extrID1=Excel_Lib.getData(INPUT_PATH, "Create_Map", 1, 7);
		ImportPage ip= new ImportPage(driver);
		actual[5]=ip.createMap(mapname1, rownum1, descrimi1, desc1, name1, testSteps1, expResults1, extrID1);
	    bp.waitForElement();
	    
	    ip.backToMap.click();
	    bp.waitForElement();
	    String mapname2=Excel_Lib.getData(INPUT_PATH, "Create_Map", 12, 0);
		actual[6]=ip.createMap(mapname2, rownum1, descrimi1, desc1, name1, testSteps1, expResults1, extrID1);
	    bp.waitForElement();
	    
	   String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 0);
	   String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 1);
	   String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 1, 2);
	   actual[7]=ip.importTestCase(jobname, mapName, path);
	   
	   ip.runJob();
	   ip.ClickOKonStatusReport();
	   
	   bp.waitForElement();
	   
		String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
		String file_Name=Excel_Lib.getData(INPUT_PATH,"Import_Job",1,3);
		ip.validateImport(file_Name, releaseName);
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@When("^User Import Same file with another Testcase$")
	public void user_Import_Same_file_with_another_Testcase() throws Throwable 
	{
		try
		{
			ip.clickOnImport();
			//ip.NextForMap.click();
			bp.waitForElement();
			ip.nextForImport.click();
			bp.waitForElement();

		bp=new BasePage();
		String jobname=Excel_Lib.getData(INPUT_PATH, "Import_Job", 5, 0);
		String mapName=Excel_Lib.getData(INPUT_PATH, "Import_Job", 5, 1);
		String path=Excel_Lib.getData(INPUT_PATH, "Import_Job", 5, 2);
		actual[8]=ip.importTestCase(jobname, mapName, path);
		bp.waitForElement();
		ip.runJob();
		ip.ClickOKonStatusReport();
	    //ip.closeInstruction.click();
	    bp.waitForElement();
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}

	@Then("^Single file should be Imported by Multiple Testcases Successfully$")
	public void single_file_should_be_Imported_by_Multiple_Testcases_Successfully() throws Throwable
	{
		try
		{
			String releaseName=Excel_Lib.getData(INPUT_PATH,"Releases",1,0);
			String file_Name=Excel_Lib.getData(INPUT_PATH,"Import_Job",1,3);
			ip.validateImport(file_Name, releaseName);
			for(int k=0;k<=actual.length-1;k++)
		       {
		        soft.assertEquals(actual[k], true);
		       }
		       soft.assertAll();
	    log.info("Pass - Single file is Imported by Multiple Testcases Successfully");
		}
		catch(Exception e)
		{
			lb=new LaunchBrowser();
			lb.getScreenShot(fileName);	
			driver.close();
			Relogin rl=new Relogin();
			rl.reLogin();
			throw e;
		}
	}
}
