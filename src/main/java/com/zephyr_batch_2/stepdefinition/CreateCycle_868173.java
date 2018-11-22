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

public class CreateCycle_868173 extends LaunchBrowser
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
	boolean[] actual=new boolean[36];
	 SoftAssert soft=new SoftAssert();
	 
	 
	 String fileName="CreateCycle_868173";
	 
	@Given("^user in testrepository page to create phase and add testcases$")
	public void user_in_testrepository_page_to_create_phase_and_add_testcases() throws Throwable 
	{
		try
		   {
			lb=new LaunchBrowser();
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
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Given("^create two phases and add four testcases for each$")
	public void create_two_phases_and_add_four_testcases_for_each() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 60, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 60, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 60, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
		   actual[7]=tr.addTestCase();
		   actual[8]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[9]=tr.cloneTestCase();
		   bp.waitForElement();
		   actual[10]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[11]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   actual[12]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[13]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   actual[14]=tr.doubleClickOnRelease(releaseName);
		   String phaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 60, 2);
			String phaseDesc1=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 60, 3);
			actual[15]=tr.addNode(phaseName1, phaseDesc1);
			//String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[16]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase1[]=new String[1];
			phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 60, 2);
			actual[17]=tr.navigateToNode(releaseName, phase1);
			
		   actual[18]=tr.addTestCase();
		   actual[19]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[20]=tr.cloneTestCase();
		   bp.waitForElement();
		   actual[21]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[22]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   actual[23]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[24]=tr.cloneTestCase();
		   bp.waitForElement(); 
		}
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^launch test planning create cycle and add phase one to cycle$")
	public void launch_test_planning_create_cycle_and_add_phase_one_to_cycle() throws Throwable 
	{
		try
		{
			actual[25]=rp.clickOnTestPlanning();
			//tl.navigateBacktoTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[26]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 50, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[27]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[28]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[29]=tl.saveTestCycle();
			bp.waitForElement();
			
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 50, 0);
			actual[30]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 60, 0);
			actual[31]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[32]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^clone the cycle$")
	public void clone_the_cycle() throws Throwable 
	{
		try
		{
		actual[33]=tl.goBackToCycle();
	    bp.waitForElement();
	    
	    String cyclename1[]=new String[1];
		cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 50, 0);
		actual[34]=tl.navigateToCycle(cyclename1);
		bp.waitForElement();
		tl.options.click();
		bp.waitForElement();
		tl.cloneCycle.click();
		bp.waitForElement();
		tl.saveTestCycle();
		bp.waitForElement();
		}
		 catch (Exception e) 
		{
			 lb.getScreenShot(fileName);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
		
	}

	@Then("^Should able to clone the cycle$")
	public void should_able_to_clone_the_cycle() throws Throwable 
	{
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 50, 0);
			actual[35]=tl.navigateToCycle(cyclename1);
			String no=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0));
		    tl.navigateToClonedCycle(cyclename1, no);
		    
		    for (int k = 0; k <= actual.length - 1; k++) {
				System.out.println(actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
		 }
		   catch (Exception e) 
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}
}
