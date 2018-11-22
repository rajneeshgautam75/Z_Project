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

public class Free_Form_868180 extends LaunchBrowser {

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
	String fileName="Free_Form_868180";
	
	boolean[] actual=new boolean[27];
	 SoftAssert soft=new SoftAssert();

	
	@Given("^Select the Project for the TestPlanning$")
	public void select_the_Project_for_the_TestPlanning() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		   //String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   actual[0]=pp.selectProject(projectName);
		   //actual[1]=pp.selectRelease(releaseName);
		   
		   
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

	@When("^Click on the rElease in release summary$")
	public void click_on_the_rElease_in_release_summary() throws Throwable {
		try
	    {
	    	 String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
	    	 bp.waitForElement();
	    	 actual[1]=pp.selectRelease(releaseName);
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

	@When("^Launch TestPlanning, create Execution Cycle$")
	public void launch_TestPlanning_create_Execution_Cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			rp=new ReleasePage(driver);
			  actual[2]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'single/two characters', Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_name_with_single_two_characters_Save_it() throws Throwable {
		try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
			bp.waitForElement();
			actual[7]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 1);
			actual[8]=tp.createFreeFormPhase(phaseName);
			bp.waitForElement();
			tp.goBackToCycle();
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Special characters', Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_name_with_Special_characters_Save_it() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[9]=rp.clickOnTestPlanning();
			bp.waitForElement();
		 
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
			bp.waitForElement();
			actual[10]=tp.navigateToCycle(cycle);
			
			String phaseName=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 2, 1);
			bp.waitForElement();
			actual[11]=tp.createFreeFormPhase(phaseName);
			bp.waitForElement();
			tp.goBackToCycle();
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Alphanumeric characters and Space', Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_name_with_Alphanumeric_characters_and_Space_Save_it() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[12]=rp.clickOnTestPlanning();
			bp.waitForElement();
			//tp.navigateBacktoTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
			bp.waitForElement();
			actual[13]=tp.navigateToCycle(cycle);
			
			String phaseName=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 3, 1);
			actual[14]=tp.createFreeFormPhase(phaseName);
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'only Numbers', Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_name_with_only_Numbers_Save_it() throws Throwable {
		try
	    {
			tp.goBackToCycle();
			bp.waitForElement();
			actual[15]=rp.clickOnTestPlanning();
			bp.waitForElement();
		//	tp.navigateBacktoTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
			bp.waitForElement();
			actual[16]=tp.navigateToCycle(cycle);
			
			String phaseName=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "FreeForm_868180", 4, 1));
			bp.waitForElement();
			actual[17]=tp.createFreeFormPhase(phaseName);
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Long name characters', Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_name_with_Long_name_characters_Save_it() throws Throwable {
		try
	    {
			tp.goBackToCycle();
			bp.waitForElement();
			actual[18]=rp.clickOnTestPlanning();
			bp.waitForElement();
		//	tp.navigateBacktoTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
			bp.waitForElement();
			actual[19]=tp.navigateToCycle(cycle);
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 5, 1);
			bp.waitForElement();
			actual[20]=tp.createFreeFormPhase(phaseName);
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Only Capital Letters', Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_name_with_Only_Capital_Letters_Save_it() throws Throwable {
		try
	    {
			tp.goBackToCycle();
			bp.waitForElement();
			actual[21]=rp.clickOnTestPlanning();
			bp.waitForElement();
		//	tp.navigateBacktoTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
			bp.waitForElement();
			actual[22]=tp.navigateToCycle(cycle);
			bp.waitForElement();
			
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 6, 1);
			actual[23]=tp.createFreeFormPhase(phaseName);
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase name with 'Duplicate Phase name', Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_name_with_Duplicate_Phase_name_Save_it() throws Throwable {
		try
	    {
			tp.goBackToCycle();
			bp.waitForElement();
			actual[24]=rp.clickOnTestPlanning();
			bp.waitForElement();
		//	tp.navigateBacktoTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 1, 0);
			bp.waitForElement();
			actual[25]=tp.navigateToCycle(cycle);
			
			String phaseName=Excel_Lib.getData(INPUT_PATH_3, "FreeForm_868180", 7, 1);
			bp.waitForElement();
			actual[26]=tp.createFreeFormPhase(phaseName);
			
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

	@Then("^Phases with all the above mentioned Specifications are Created Successfully$")
	public void phases_with_all_the_above_mentioned_Specifications_are_Created_Successfully() throws Throwable {
		try
		{
			tp.goBackToCycle();
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("Phases with all the above mentioned Specifications are Created Successfully");
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
