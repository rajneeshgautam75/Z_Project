package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
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

public class Free_Form_868224 extends LaunchBrowser {

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	String fileName="Free_Form_868224";
	
	boolean[] actual=new boolean[14];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page Testplanning$")
	public void user_is_in_a_page_Testplanning() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestPlanning();
		   
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

	@When("^User creates a cycLe$")
	public void user_creates_a_cycLe() throws Throwable {
		try
		   {
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[3]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[4]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[5]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[6]=tp.saveTestCycle();
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

	@When("^User creates a free form phase under cycle$")
	public void user_creates_a_free_form_phase_under_cycle() throws Throwable {
	    try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 0);
			actual[7]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 1);
			actual[8]=tp.createFreeFormPhase(phaseName);
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

	@When("^User creates a system under phase$")
	public void user_creates_a_system_under_phase() throws Throwable {
		try
		{
		String[] cycle=new String[1];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 1);
		actual[9]=tp.navigateToCycle(cycle);
		
		String systemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 2);
		String systemDesc=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 5);
		//tr=new TestRepositoryPage(driver);
		actual[10]=tp.addNode(systemName, systemDesc);
		//tr.doubleClickOnRelease(releaseName);
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

	@When("^User creates a subsystem under a system$")
	public void user_creates_a_subsystem_under_a_system() throws Throwable {
		try
		{
		String[] cycle=new String[2];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 1);
		cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 2);
		actual[11]=tp.navigateToCycle(cycle);
		
		String SubsystemName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 3);
		String SubsystemDesc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 6);
		//tr=new TestRepositoryPage(driver);
		actual[12]=tp.addNode(SubsystemName, SubsystemDesc);
		
		String[] cycleName=new String[2];
		cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 2);
		cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 6, 3);
		actual[13]=tp.navigateToCycle(cycleName);
		
		
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

	@Then("^User successfully added system and subsystem to free form phase$")
	public void user_successfully_added_system_and_subsystem_to_free_form_phase() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("User successfully search and add testcases with testcase contents have different characters");
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
