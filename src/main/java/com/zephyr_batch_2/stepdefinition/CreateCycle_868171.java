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
import cucumber.api.java.en.When;

public class CreateCycle_868171 extends LaunchBrowser
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
	boolean[] actual=new boolean[26];
	 SoftAssert soft=new SoftAssert();
	 
	 String fileName="CreateCycle_868171";
	 
	@Given("^user in repository Page to create Phase and add Testcases$")
	public void user_in_repository_Page_to_create_Phase_and_add_Testcases() throws Throwable 
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

	@Given("^crate a phase and add testcases to phase$")
	public void crate_a_phase_and_add_testcases_to_phase() throws Throwable 
	{
		try
		{
			String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 53, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 53, 1);
			actual[4]=tr.addNode(phaseName, phaseDesc);
			String releaseName=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			actual[5]=tr.doubleClickOnRelease(releaseName);
			//navigate to phase//
			String phase[]=new String[1];
			phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 53, 0);
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

	@When("^launch test planning create cyccle add phase to cycle and assign to Anyone$")
	public void launch_test_planning_create_cyccle_add_phase_to_cycle_and_assign_to_Anyone() throws Throwable 
	{
		try
		{
			actual[14]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		    
		    tl=new TestPlanningPage(driver);
		    actual[15]=tl.clickOnAddTestCycleSymbol();
		    bp.waitForElement();
		    //creating cicle 1
			String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 43, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 4, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 1, 11);
			actual[16]=tl.CreateCycle(cyclename, Build, Environment,hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_4, "StartAndEndDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "StartAndEndDate", 1, 5));
			actual[17]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			
			actual[18]=tl.saveTestCycle();
			bp.waitForElement();
			
		   String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 43, 0);
			actual[19]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
			
			String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 53, 0);
			actual[20]=tl.addPhaseToCycle(nodeName);
		   bp.waitForElement();
		   
		   String Bulk_type=Excel_Lib.getData(INPUT_PATH_4,"BulkAssignment", 2, 0);
		   actual[21]=tl.bulkAssignment(Bulk_type);
		   bp.waitForElement();
		   tl.goBackToCycle();
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

	@When("^launch test Execution and Execute the Testcses$")
	public void launch_test_Execution_and_Execute_the_Testcses() throws Throwable 
	{
		try
		{
		    rp.clickOnTestExecution();
		    bp.waitForElement();
		    
		    String cyclename1[]=new String[3];
		    cyclename1[0]=Excel_Lib.getData(INPUT_PATH_4,"Projects1",5,1);
			cyclename1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 43, 0);
			cyclename1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 53, 0);
			actual[22]=tl.navigateToCycle(cyclename1);
			bp.waitForElement();
		    epp=new ExecutionPage(driver);
		    
		   
		    int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_4, "status", 1, 0);
		    epp.executeStatus(tcNo, statusType);
		    bp.waitForElement();
		    
		    String statusType2=Excel_Lib.getData(INPUT_PATH_4, "status", 3, 0);
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.executeStatus(tcNo2, statusType2);  
		    bp.waitForElement();
		    
		    
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    String statusType3=Excel_Lib.getData(INPUT_PATH_4, "status", 4, 0);
		    epp.executeStatus(tcNo3, statusType3);
		    bp.waitForElement();
		    String statusType4=Excel_Lib.getData(INPUT_PATH_4, "status", 5, 0);
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.executeStatus(tcNo4, statusType4);
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

	@When("^link the defect to the testcases$")
	public void link_the_defect_to_the_testcases() throws Throwable 
	{
		try
		{
		    //link defect
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 1, 0);
		    epp.clickOnDefectButton(tcNo);
		    bp.waitForElement();
		    String defectId=Excel_Lib.getData(INPUT_PATH_4, "defect", 1, 0);
		    epp.linkDefect(defectId);
		    
		    //link defect
		    int tcNo2=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 2, 0);
		    epp.clickOnDefectButton(tcNo2);
		    bp.waitForElement();
		    epp.linkDefect(defectId);
		    
		    //link defect
		    int tcNo3=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 3, 0);
		    epp.clickOnDefectButton(tcNo3);
		    bp.waitForElement();
		    epp.linkDefect(defectId);
		    
		    //link defect
		    int tcNo4=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames", 4, 0);
		    epp.clickOnDefectButton(tcNo4);
		    bp.waitForElement();
		    epp.linkDefect(defectId);
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

	@When("^launch testplanning and clone the cycle$")
	public void launch_testplanning_and_clone_the_cycle() throws Throwable 
	{
		try
		{
			actual[23]=rp.clickOnTestPlanning();
					
		    bp.waitForElement();
			//tl.navigateBacktoTestPlanning();
		    String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 43, 0);
			actual[24]=tl.navigateToCycle(cyclename1);
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

	@When("^view the execution in the cloned cycle$")
	public void view_the_execution_in_the_cloned_cycle() throws Throwable 
	{
		try
		{
			String cyclename1[]=new String[1];
			cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Create cycle", 43, 0);
			actual[25]=tl.navigateToCycle(cyclename1);
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
