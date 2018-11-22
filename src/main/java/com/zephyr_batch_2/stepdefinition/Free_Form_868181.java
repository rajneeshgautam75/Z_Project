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

public class Free_Form_868181 extends LaunchBrowser {

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
	String fileName="Free_Form_868181";
	
	boolean[] actual=new boolean[19];
	 SoftAssert soft=new SoftAssert();

	@Given("^Select the Project(\\d+) For the TestPlanning$")
	public void select_the_Project_For_the_TestPlanning(int arg1) throws Throwable {
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

	@When("^Click on rElease in release summary$")
	public void click_on_rElease_in_release_summary() throws Throwable {
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

	@When("^Launch TestRepository, Create Phase with Name and Description$")
	public void launch_TestRepository_Create_Phase_with_Name_and_Description() throws Throwable {
		try
		{
			rp= new ReleasePage(driver);
			bp.waitForElement();
		   actual[2]=rp.clickOnTestRep(); 
		   
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			  String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 12);
			  String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 15);
			  
			  tr=new TestRepositoryPage(driver);
			  bp=new BasePage();
			  bp.waitForElement();
			  actual[3]=tr.doubleClickOnRelease(releaseName);
			 // bp.waitForElement();
			  bp.waitForElement();
			 actual[4]= tr.addNode(p_Name1,p_Desc1);
			 bp.waitForElement();
			 tr.doubleClickOnRelease(releaseName);
			 String[] phase=new String[1];
			 phase[0]=p_Name1;
			 tr.navigateToNode(releaseName, phase);
			 bp.waitForElement();
				actual[5]=tr.addTestCase();

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

	@When("^Launch TestPlanning, Create Execution Cycle$")
	public void launch_TestPlanning_Create_Execution_Cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  rp.clickOnTestPlanning();
			  bp.waitForElement();

			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 11);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				bp.waitForElement();
				actual[6]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[7]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[8]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[9]=tp.saveTestCycle();
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

	@When("^ContextClick and select 'Add Phase', Select 'Create new' in the Add new phase window and Create Phase, Save it$")
	public void contextclick_and_select_Add_Phase_Select_Create_new_in_the_Add_new_phase_window_and_Create_Phase_Save_it() throws Throwable {
		try
	    {
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 11);
			bp.waitForElement();
			actual[10]=tp.navigateToCycle(cycle);
			
			
			String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 12);
			bp.waitForElement();
			actual[11]=tp.addPhaseToCycle(phase);
			
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[12]=tp.bulkAssignment(Bulk_Type);
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

	@When("^Navigate to Created Phase in 'Assign Testcase to Execute' page, ContextClick and Edit the Phase name$")
	public void navigate_to_Created_Phase_in_Assign_Testcase_to_Execute_page_ContextClick_and_Edit_the_Phase_name() throws Throwable {
		try
	    {
			   String[] phaseName=new String[1];
			   phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",25 ,12 );
			     bp.waitForElement();
			     actual[13]=tp.navigateToCycle(phaseName);
			     
			     int[] TestCaseNo=new int[1];
					TestCaseNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8);
					String Assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,9 );
					bp.waitForElement();
					actual[14]=tp.individualAssinTo(TestCaseNo, Assignee);
					
					tp.goBackToCycle();
					bp.waitForElement();
					  actual[15]=rp.clickOnTestPlanning();
					//  tp.navigateBacktoTestPlanning();
					  
					  String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 11);
					  bp.waitForElement();
					  actual[16]=tp.doubleClickOnCycle(cycleName);
					  
					  String[] cycle=new String[2];
						cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 11);
						cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 25, 12);
						bp.waitForElement();
						actual[17]=tp.navigateToCycle(cycle);
						
						bp.waitForElement();
						tp.options.click();
						bp.waitForElement();
						tp.edit.click();
						
						String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
						String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
						String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
						String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
						String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
						String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 24));
						bp.waitForElement();
						bp.waitForElement();
						actual[18]=tp.editStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
						bp.waitForElement();
						tp.saveTestCycle();
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

	@Then("^Free Form Phase Name should be Edited Successfully$")
	public void free_Form_Phase_Name_should_be_Edited_Successfully() throws Throwable {
		try
		{
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("Free Form Phase should be Edited Successfully");
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
