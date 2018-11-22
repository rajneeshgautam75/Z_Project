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

public class Set_Reset_868175 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tl;
	ExecutionPage epp;
	String fileName="Set_Reset_868175";
	boolean[] actual=new boolean[68];
	SoftAssert soft=new SoftAssert();
	@Given("^launch test repository to Create phase and Add testcases$")
	public void launch_test_repository_to_Create_phase_and_Add_testcases() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   //String projectName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			   actual[0]=pp.selectProject(projectName);
			   bp=new BasePage();
			   bp.waitForElement();
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp= new ReleasePage(driver);
			   actual[2]=rp.clickOnTestRep();
			   bp.waitForElement();
			   tr=new TestRepositoryPage(driver);
			   actual[3]=tr.doubleClickOnRelease(releaseName);
			   bp.waitForElement(); 
		   }
		   catch (Exception e) 
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

	@Given("^create phases and add testcases$")
	public void create_phases_and_add_testcases() throws Throwable 
	{
		try
		{
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			String nodeDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 1);
			actual[4]=tr.addNode(nodeName, nodeDesc);
			 bp.waitForElement();
			 String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			 actual[5]=tr.doubleClickOnRelease(releaseName);
			   String[] phase=new String[1];
			   phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 58, 0);
			   actual[6]=tr.navigateToNode(releaseName, phase);
			   bp.waitForElement();
			   actual[7]=tr.addTestCase();
			   actual[7]=tr.addTestCase();
			   actual[7]=tr.addTestCase();
			   actual[7]=tr.addTestCase();
		  }
		   catch (Exception e) 
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

	@When("^launch test planning and create a cycle$")
	public void launch_test_planning_and_create_a_cycle() throws Throwable 
	{
		try
		{
			bp.waitForElement();
			actual[35]=rp.clickOnTestPlanning();
		    bp.waitForElement();
//		    rp.clickOnTestPlanning();
//		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[36]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[37]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[38]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[39]=tl.saveTestCycle();
			bp.waitForElement();
			
		 
		 }
		   catch (Exception e) 
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

	@When("^navigate to cycle and add phase ONE to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_ONE_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
//		   rp.clickOnTestPlanning();
		   tl.goBackToCycle();
//		   bp.waitForElement();
		}
		catch (Exception e) 
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

	@When("^navigate to cycle and add phase TWO to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_TWO_to_cycle_and_assign_to_Anyone() throws Throwable 
	{	    
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   //rp.clickOnTestPlanning();
		   tl.goBackToCycle();
		   bp.waitForElement();
	}
		catch (Exception e) 
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

	@When("^navigate to cycle and add phase THREE to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_THREE_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		 try
		{
		String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   //rp.clickOnTestPlanning();
		   tl.goBackToCycle();
		   bp.waitForElement();
		}
		 catch (Exception e) 
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

	@When("^navigate to cycle and add phase FOUR to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_FOUR_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		 try
		{
		String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   //rp.clickOnTestPlanning();
		   tl.goBackToCycle();
		   bp.waitForElement();
		}
		 catch (Exception e) 
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

	@When("^navigate to cycle and add phase FIVE to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_FIVE_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		 try
		{
		String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   //rp.clickOnTestPlanning();
		   tl.goBackToCycle();
		   bp.waitForElement();
		}
		 catch (Exception e) 
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

	@When("^navigate to cycle and add phase SIX to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_SIX_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		 try
		{
		String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   //rp.clickOnTestPlanning();
		   tl.goBackToCycle();
		   bp.waitForElement();
		}
		 catch (Exception e) 
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

	@When("^navigate to cycle and add phase SEVEN to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_SEVEN_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		 try
		{
		String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   //rp.clickOnTestPlanning();
		   tl.goBackToCycle();
		   bp.waitForElement();
		}
		 catch (Exception e) 
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

	@When("^navigate to cycle and add phase EIGHT to cycle and assign to Anyone$")
	public void navigate_to_cycle_and_add_phase_EIGHT_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
		String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 48, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 58, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   //rp.clickOnTestPlanning();
		   tl.goBackToCycle();
		   bp.waitForElement();
		}
		catch (Exception e) 
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

	@Then("^navigate to cycle and export testcases should be able to export all the phases with testcases$")
	public void navigate_to_cycle_and_export_testcases_should_be_able_to_export_all_the_phases_with_testcases() throws Throwable 
	{
	   // tl.exportDownload();
	    bp.waitForElement();
	}
}
