package com.zephyr_batch_2.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878826 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	
	boolean[] actual=new boolean[57];
	SoftAssert soft=new SoftAssert();	
	String fileName="TestExecution_878826";
	
	
	@Given("^User is in test repository page of second relese$")
	public void user_is_in_test_repository_page_of_second_relese() throws Throwable {
		try {
			lb=new LaunchBrowser();
			bp = new BasePage();
			pp = new ProjectPage(driver);

			
			//pp=new ProjectPage(driver);
			actual[0] =pp.clickOnLogout();
		     bp.waitForElement();
		lp=new LoginPage(driver);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		 actual[1] =lp.enterUname(Uname);
		 actual[2] =lp.enterPass(Pass);
		 actual[3] = lp.clickOnLogin();
		 bp.waitForElement();
			String projectName = Property_Lib.getPropertyValue(CONFIG_PATH + CONFIG_FILE_TPE, "Normal_Project_1");
			String releaseName = Excel_Lib.getData(INPUT_PATH_2,"E_878826",1,0);
			actual[4] = pp.selectProject(projectName);
			bp.waitForElement();
			actual[5] = pp.selectRelease(releaseName);
			bp.waitForElement();

			rp = new ReleasePage(driver);
			actual[6] = rp.clickOnTestRep();
		} catch (Exception e) {
			lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl = new Relogin_TPE();
			rl.reLogin();
			throw e;
		}
	}
	@When("^Uesr add a phase and add two system to phase$")
	public void uesr_add_a_phase_and_add_two_system_to_phase() throws Throwable {
	    try
	    {
	    	lb=new LaunchBrowser();
	    
		bp=new BasePage();
		tr=new TestRepositoryPage(driver);
	    String releaseName=Excel_Lib.getData(INPUT_PATH_2,"E_878826",1,0);
	    actual[7]=tr.clickOnRelease(releaseName);
	    String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 1);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "E_878826", 1, 1);
	    actual[8]=tr.addNode(p_Name1, p_Desc1);
	    
	    bp.waitForElement();
	    String[] phase=new String[1];
	    phase[0]=p_Name1;
	    actual[9]=tr.navigateToNode(releaseName, phase);
	    
	    String sname=Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 2);
	    String sdesc=Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 2);
	    actual[10]=tr.addNode(sname, sdesc);
	    bp.waitForElement();
	    actual[11]=tr.navigateToNode(releaseName, phase);
	    
	    String sname2=Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 3);
	    String sdesc2=Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 3);
	    actual[12]=tr.addNode(sname2, sdesc2);
	    bp.waitForElement();
	    }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	    
	}

	@When("^add ten testcases with test steps$")
	public void add_ten_testcases_with_test_steps() throws Throwable {
	    try
	    {
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"E_878826",1,0);
		String[] phase=new String[1];
	    phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 1);
	    //phase[1]=Excel_Lib.getData(INPUT_PATH_2,"E_878826",1,2);
	    actual[13]=tr.navigateToNode(releaseName, phase);
	    
	    actual[14] =tr.addTestCase();
	    bp.waitForElement();
	    actual[15] =tr.clickDetailButton();
	    bp.waitForElement();
	    ctc=new CreateTestCasePage(driver);
	    
	    
	    
	    String[] stepdetail=new String[3];
		   int l=0;
		   for(int i=19;i<=21;i++)
		   {
			   stepdetail[l]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
			   l++;
		   }
		  
		   actual[16]=ctc.enterTestCaseStepDetail(stepdetail);
		   bp.waitForElement();
	    
	    
	    
	    //ctc.enterTestCaseStepDetail(stepDetails);
	    
	    tr.clickOnList();
	    
	    ep=new ExportPage(driver);
	    String[] testcase=new String[1];
	    testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"E_878826",1,14));
	    actual[17] =ep.selectMultipleTestCaseFromGrid(testcase);
	    
	    actual[18] =tr.cloneTestCase();
	    bp.waitForElement();
	    actual[19] =tr.selectallTestCase();
	    bp.waitForElement();
	    actual[20] = tr.cloneTestCase();
	    bp.waitForElement();
	    actual[21] =tr.selectallTestCase();
	    bp.waitForElement();
	    actual[22] =tr.cloneTestCase();
	    bp.waitForElement();
	    String[] testcase2=new String[2];
	    testcase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"E_878826",1,14));
	    testcase2[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"E_878826",2,14));		
	    actual[23] =ep.selectMultipleTestCaseFromGrid(testcase2);
	    
	    tr.cloneTestCase();
	    bp.waitForElement();
	    
	    }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	    
	}

	@When("^Launch test Planning module$")
	public void launch_test_Planning_module1() throws Throwable {
	 try
	 {
		rp=new ReleasePage(driver);
		bp.waitForElement();
		actual[24] =rp.clickOnTestPlanning();
	 }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	}

	@When("^create a new cycle ,add phase to cycle and cancel the bulk assignment popup$")
	public void create_a_new_cycle_add_phase_to_cycle_and_cancel_the_bulk_assignment_popup() throws Throwable {
		try
		{
		tp = new TestPlanningPage(driver);

		String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826",1, 4);
		String build = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 5);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 6);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 99, 7);

		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826", 1, 7));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 8);
		String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826",1, 9));
		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826", 1, 10));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 11);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826", 1, 12));

		actual[25] = tp.clickOnAddTestCycleSymbol();

		actual[26] = tp.CreateCycle(cycleName, build, environment, hide);
		bp.waitForElement();
		actual[27] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
				endDateMonth, endDateDay);
		actual[28] = tp.saveTestCycle();
		bp.waitForElement();

		String[] cycle = new String[1];
		cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826",1,4);
		actual[29] = tp.navigateToCycle(cycle);
		String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 1);
		actual[30] = tp.addPhaseToCycle(phase);
		actual[31] = tp.cancelBulkAssign();
		bp.waitForElement();
		String[] nodes = new String[1];
		nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 1);
		actual[32] = tp.navigateToCycle(nodes);
		bp.waitForElement();
		 }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	}

	@When("^launch test Planning module$")
	public void launch_test_Planning_module() throws Throwable {
	  try
	  {
		  //actual[33] =rp.clickOnTestPlanning();
		  actual[33] =tp.goBackToCycle();
	  }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	}

	@When("^create a new cycle,add same phase to cycle and assign to tester using bulk assignment window$")
	public void create_a_new_cycle_add_same_phase_to_cycle_and_assign_to_tester_using_bulk_assignment_window() throws Throwable {
		try
		{
		tp = new TestPlanningPage(driver);

		String cycleName = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 4);
		String build = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 5);
		String environment = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 6);
		String hide = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 99, 7);

		String startDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826", 2, 7));
		String startDateMonth = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 8);
		String startDateday = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826", 2, 9));
		String endDateYear = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826", 2, 10));
		String endDateMonth = Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 11);
		String endDateDay = Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "E_878826", 2, 12));

		actual[34] = tp.clickOnAddTestCycleSymbol();

		actual[35] = tp.CreateCycle(cycleName, build, environment, hide);
		actual[36] = tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear,
				endDateMonth, endDateDay);
		actual[37] = tp.saveTestCycle();
		bp.waitForElement();

		String[] cycle = new String[1];
		cycle[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 4);
		actual[38] = tp.navigateToCycle(cycle);
		bp.waitForElement();
		String phase = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 1);
		actual[39] = tp.addPhaseToCycle(phase);

		actual[40] = tp.cancelBulkAssign();

		String[] nodes = new String[1];
		nodes[0] = UNIQUE + Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 1);
		actual[41] = tp.navigateToCycle(nodes);
		bp.waitForElement();
		String role=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		String check="";
		actual[42] =tp.bulkAssignTestcasesSelectedFolder();
		bp.waitForElement();
		actual[43] =tp.assignAllNotexecuted(role, check);
		 }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
		//tp.bulkAssignment(role);
	}

	@Then("^testcase should be asssigned to tester$")
	public void testcase_should_be_asssigned_to_tester() throws Throwable {
		try
		{
		String role=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
		int[] testcase2=new int[10];
		
		for(int i=0;i<=9;i++)
		{
		    testcase2[i]=Excel_Lib.getNumberData(INPUT_PATH_2,"E_878826",i+1,14);
		}
		    
		    
		    
		actual[44] =tp.validateAllAssigned(testcase2, role);
		tp.goBackToCycle();
		 }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	}

	@Then("^select the release and click on manage release and clone$")
	public void select_the_release_and_click_on_manage_release_and_clone() throws Throwable {
		try
		{
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			bp=new BasePage();
			
			
			
			pp=new ProjectPage(driver);
			
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"E_878826",1,0);
		 actual[45] =pp.selectProject(projectName);
		 actual[46] = pp.selectRelease(releaseName);
	   
	   exep=new ExecutionPage(driver);
	    pp.clickOnManageRelease();
	   bp.waitForElement();
		 }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	  
	}

	@Then("^select all checkboxes and clone it$")
	public void select_all_checkboxes_and_clone_it() throws Throwable {
		try
		{
		String[] option=new String[11];
		   for(int i=0;i<=10;i++)
		   {
			   option[i]=Excel_Lib.getData(INPUT_PATH_2, "E_878826", i+1, 15);
			   
		   }
			 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"E_878826",1,0);
		   WebElement release=driver.findElement(By.xpath(pp.releasei1+releaseName+pp.releasei2));
		  // option[0]=Excel_Lib.getData(INPUT_PATH_2, "E_878826", 34, 2);
		  Actions a1=new Actions(driver);
		  a1.moveToElement(release).click().perform();
		   //release.click();
		  actual[47] =rp.cloneRelease(option);
		   bp.waitForElement();
		 }
	    catch(Exception e)
			{
	    	    lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	}

	@Then("^select the cloned release and launch test execution module$")
	public void select_the_cloned_release_and_launch_test_execution_module() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"E_878826",2,0);
		 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
		 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
		 
		 actual[48] =pp.clickOnLogout();
		 lp=new LoginPage(driver);
		 actual[49] =lp.enterUname(Uname);
		 actual[50] =lp.enterPass(Pass);
		 actual[51] = lp.clickOnLogin();
		 bp.waitForElement();
		 
		 actual[52] =pp.selectProject(projectName);
		 actual[53] = pp.selectRelease(releaseName);
	   
		 actual[54] =rp.clickOnTestExecution();
	   bp.waitForElement();
	   bp.waitForElement();
		 }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	}

	@Then("^check the assignments in cloned release$")
	public void check_the_assignments_in_cloned_release() throws Throwable {
		try
		{
		String[] nodes = new String[3];
		nodes[0] =Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 0);
		nodes[1] =UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 4);
		nodes[2] =UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "E_878826", 1, 1);
		actual[55] = tp.navigateToCycle(nodes);
		  bp.waitForElement();
		String[] nodes1 = new String[1];
		nodes1[0] =Excel_Lib.getData(INPUT_PATH_2, "E_878826", 2, 0);
		
		actual[56] =tp.navigateToCycle(nodes1);
		 }
	    catch(Exception e)
			{
	    	lb.getScreenShot(fileName);
				driver.close();
				Relogin_TPE rl=new Relogin_TPE();
				rl.reLogin();
				throw e;
			}
	}

	@Then("^able to view the assignments in test execution page$")
	public void able_to_view_the_assignments_in_test_execution_page() throws Throwable {
		try
		{
		for(int k=0;k<=actual.length-1;k++)
	     {
			System.out.println(actual[k]);
	      soft.assertEquals(actual[k], true);
	     }
	     soft.assertAll();
	
	 }
    catch(Exception e)
		{
    	lb.getScreenShot(fileName);
			driver.close();
			Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}

}
}
