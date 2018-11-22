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

public class Sync_868178 extends LaunchBrowser
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
	boolean[] actual=new boolean[68];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in repository page to create phase and add testcases to it$")
	public void user_in_repository_page_to_create_phase_and_add_testcases_to_it() throws Throwable 
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
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			} 
	}

	@Given("^launch testplanning and Create cycle and add phase to cycle$")
	public void launch_testplanning_and_Create_cycle_and_add_phase_to_cycle() throws Throwable 
	{

		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 61, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 61, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 61, 0);
			actual[6]=tr.navigateToNode(releaseName, phase);
			
		   actual[7]=tr.addTestCase();
		   actual[9]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[10]=tr.cloneTestCase();
		   bp.waitForElement();
		   actual[11]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[12]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   actual[11]=tr.selectallTestCase();
		   bp.waitForElement();
		   actual[12]=tr.cloneTestCase();
		   bp.waitForElement(); 
		   bp.waitForElement(); 
		   
				actual[35]=rp.clickOnTestPlanning();
			    bp.waitForElement();
			    
			    tl=new TestPlanningPage(driver);
			    actual[36]=tl.clickOnAddTestCycleSymbol();
			    bp.waitForElement();
			    //creating cicle 1
				String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 52, 0);
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
						e.printStackTrace();
					    driver.close();
					    Relogin_TPE rl=new Relogin_TPE();
					    rl.reLogin();
					    throw e;
					}
		   
	}

	@Then("^Should be able to add phase to cycle$")
	public void should_be_able_to_add_phase_to_cycle() throws Throwable 
	{
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 52, 0);
			actual[40]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 61, 0);
			actual[41]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[42]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		}
		   catch (Exception e) 
			{
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}
}
