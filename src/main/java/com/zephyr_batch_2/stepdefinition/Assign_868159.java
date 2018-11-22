package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Assign_868159 extends LaunchBrowser
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
	boolean[] actual=new boolean[33];
	 SoftAssert soft=new SoftAssert();
	 String filename="Assign_868159";
	@Given("^user inrepository page to create phase and add testcases$")
	public void user_inrepository_page_to_create_phase_and_add_testcases() throws Throwable 
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
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Given("^create phase add test cases and clone$")
	public void create_phase_add_test_cases_and_clone() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			 bp.waitForElement();
			actual[7]=tr.addTestCase();
			 ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 22, 0);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_4, "TcNameAndDes", 22, 1);
			   tr.clickOnDetails();
			   actual[8]=ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
			   tr.clickOnList();
			   actual[9]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[10]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[11]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[12]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[13]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[14]=tr.cloneTestCase();
			   bp.waitForElement();
			   actual[15]=tr.selectallTestCase();
			   bp.waitForElement();
			   actual[16]=tr.cloneTestCase();
			   bp.waitForElement();
		   }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Given("^launch testplanning create cycle and hide and save$")
	public void launch_testplanning_create_cycle_and_hide_and_save() throws Throwable 
	{
		try
		{
			actual[17]=rp.clickOnTestPlanning();
			bp.waitForElement();
			tl=new TestPlanningPage(driver);
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 2, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 3);
			tl.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[18]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			tl.saveTestCycle();
			bp.waitForElement();
			
	//		String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 0);
	//		actual[11]=tl.addPhaseToCycle(nodeName);
	//	   bp.waitForElement();
	//	   bp.waitForElement();
	//	   actual[12]=tl.cancelBulkAssign();
	//	   bp.waitForElement();
	//	   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
	//	   actual[12]=tl.bulkAssignment(Bulk_type);
	//	   bp.waitForElement();
		  }
		   catch (Exception e) 
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Given("^click on contestmenu un-hide and save$")
	public void click_on_contestmenu_un_hide_and_save() throws Throwable 
	{
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 0);
			actual[19]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String cyclename=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 117, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 112, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 112, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 3);
			tl.editCycle(cyclename, Build, Environment, hide);
			bp.waitForElement();
			tl.saveTestCycle();
			bp.waitForElement();
	  }
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
	}

	@Given("^Edit the cycle and save$")
	public void edit_the_cycle_and_save() throws Throwable 
	{
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 0);
			actual[20]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 4);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 5);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 6);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1227, 333);
			tl.editCycle(cyclename, Build, Environment, hide);
			bp.waitForElement();
			
			tl.saveTestCycle();
			bp.waitForElement();
	  }
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
	}

	@Given("^navigate to cycle choose existing phase and assign to Anyone$")
	public void navigate_to_cycle_choose_existing_phase_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 4);
			actual[21]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 0);
			actual[22]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 1, 0);
		   actual[23]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
	  }
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
	}

	@Given("^navigate to phase select all testcases and assign to Manager/Lead/Tester$")
	public void navigate_to_phase_select_all_testcases_and_assign_to_Manager_Lead_Tester() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 0);
			actual[24]=tl.navigateToCycle(phase);
			bp.waitForElement();
			
			actual[25]=tl.selectallTestCase();
			bp.waitForElement();
			String manager=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User1");
			actual[26]=tl.assignAllSelected(manager);
			
			actual[27]=tl.selectallTestCase();
			bp.waitForElement();
			String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
			actual[28]=tl.assignAllSelected(lead);
			
			actual[29]=tl.selectallTestCase();
			bp.waitForElement();
			String tester=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
			actual[30]=tl.assignAllSelected(tester);
	  }
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
	}

	@Given("^sync in test planning$")
	public void sync_in_test_planning() throws Throwable 
	{
		try
		{
			String check=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 117, 3);
		    tl.sync(check);
		    bp.waitForElement();
	  }
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
	}

	@Given("^select the test cases and set/reset the flag$")
	public void select_the_test_cases_and_set_reset_the_flag() throws Throwable 
	{
		try
		{
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 0);
			actual[31]=tl.navigateToCycle(phase);
			bp.waitForElement();
			
			actual[32]=tl.selectallTestCase();
			bp.waitForElement();
			
			tl.setFlags();
			bp.waitForElement();
			
			bp.waitForElement();
			tl.setFlags();
			bp.waitForElement();
			 tl.goBackToCycle();
	  }
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
	}

	@Then("^navigate to phase and delete$")
	public void navigate_to_phase_and_delete() throws Throwable 
	{
		try
		{
			rp.clickOnTestPlanning();
			bp.waitForElement();
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 4);
			tl.doubleClickOnCycle(cyclename);
			String cyclename1[]=new String[2];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 4);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 27, 0);
			tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			tl.deleteNode();
			bp.waitForElement();
	  }
	   catch (Exception e) 
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		} 
	}

	@Then("^Should be able to delete the hidden cycle$")
	public void should_be_able_to_delete_the_hidden_cycle() throws Throwable 
	{
		try
		   {
				String cyclename[]=new String[1];
				cyclename[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 17, 4);
				bp.waitForElement();
				bp.waitForElement();
				//tl.deleteNode();
				bp.waitForElement();
				
				 //tl.goBackToCycle();
				bp.waitForElement();
				
			   for(int k=0;k<=actual.length-1;k++)
			     {
			      soft.assertEquals(actual[k], true);
			     }
			    soft.assertAll();
		   }
		   catch (Exception e) 
			{
			   	lb=new LaunchBrowser();
			   	lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}
}
