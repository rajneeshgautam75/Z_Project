package com.zephyr_batch_2.stepdefinition;

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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878804 extends LaunchBrowser
{
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878804";
	boolean[] actual=new boolean[38];
	 SoftAssert soft=new SoftAssert();
	 
	 String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	@When("^User add a phase and add testcases with test steps to phase$")
	public void user_add_a_phase_and_add_testcases_with_test_steps_to_phase() throws Throwable {
		try
		   {
			bp=new BasePage();
		    ctc=new CreateTestCasePage(driver);
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",23,2);
			String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",23,2);
			tr=new TestRepositoryPage(driver);
			actual[0]=tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			actual[1]=tr.addNode(name, desc);
			bp.waitForElement();
			String Phase[]=new String[1];
			Phase[0]=name;
			tr.navigateToNode(Release, Phase);
			actual[2]=bp.waitForElement();
	        
			actual[3]=tr.addTestCase();
			actual[4]=tr.clickDetailButton();
			   
			   String testCaseName=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 23, 14);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 23, 15);
			   ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
			   bp.waitForElement();
				String[] stepDetail = new String[3];
				int k=0;
				for(int i=19;i<=21;i++)
				{
					stepDetail[k]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
					k++;
				}
				ctc=new CreateTestCasePage(driver);
				actual[5]=ctc.enterTestCaseStepDetail(stepDetail);
				bp.waitForElement();
			   
				actual[6]=tr.clickOnList();
				for(int i=1;i<=2;i++)
				{
				tr.selectallTestCase();
				tr.cloneTestCase();
				}
				bp.waitForElement();
				tr.doubleClickOnRelease(Release);
				bp.waitForElement();
		   }
		   
		   catch (Exception e) 
			{lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^create a new Cycle and add phase to cycle and assign to anyone$")
	public void create_a_new_Cycle_and_add_phase_to_cycle_and_assign_to_anyone() throws Throwable {
		try
		   {
			
			
			
			   rp=new ReleasePage(driver);
			   actual[7]=rp.clickOnTestPlanning();
			   
			   tp=new TestPlanningPage(driver);
				
				String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 23, 5);
				String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 23, 6);
				   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 23, 7);
				   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
				   
				   
				   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 23, 8));
				    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 23, 9);
				    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 23, 10));
				    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",23, 11));
				    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 23, 12);
				    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 23, 13));		
				
				    actual[8]=tp.clickOnAddTestCycleSymbol();
				    
				    actual[9]=tp.CreateCycle(cycleName, build, environment, hide);
				    actual[10]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
				    actual[11]=tp.saveTestCycle();
				    bp.waitForElement();
				    
				    String[] cycle=new String[1];
				    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",23,5);
				    actual[12]=tp.navigateToCycle(cycle);
			       
				    String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",23,2);
				       actual[13]=tp.addPhaseToCycle(phase);
				       
				       
				       String bulkType=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",23,22);
				       actual[14]=tp.bulkAssignment(bulkType);
				       bp.waitForElement();
				      
				       
			      
		   }
		   
		   catch (Exception e) 
			{lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^test cases should be assign to anyone$")
	public void test_cases_should_be_assign_to_anyone() throws Throwable {
	    try
	  {
	    String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",23,2);
		tp.navigateToCycle(cycle1);
		bp.waitForElement();
		int[] testcase=new int[4];
	    
	    for(int i=0;i<=testcase.length-1;i++)
	    {
		testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", i+1, 27);
	    }
			String assignee=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 23, 16);	
			actual[15]=tp.validateAllAssigned(testcase, assignee);
			bp.waitForElement();
			tp.goBackToCycle();
	    }
	    catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^logout from the application$")
	public void logout_from_the_application() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
		actual[16]=pp.clickOnLogout();
		}
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User login as tester$")
	public void user_login_as_tester() throws Throwable {
	  try
	  {
		lp=new LoginPage(driver);
	   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Username_1");
	   String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Password_1");
	   
	   
	   actual[17]=lp.enterUname(Uname);
	   actual[18]=lp.enterPass(password);
	   actual[19]=lp.clickOnLogin();
	  }
	  catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
			   
	}

	@When("^navigate to phase in test execution page$")
	public void navigate_to_phase_in_test_execution_page() throws Throwable {
	  
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		pp.selectProject(projectName);
		actual[20]=pp.selectRelease(releaseName);
	   rp=new ReleasePage(driver);
	  actual[21]=rp.clickOnTestExecution();
	  bp.waitForElement();
	  
	  String[] nodes=new String[3];
	    nodes[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	    nodes[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 23, 5);
	   
	    nodes[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",23,2);		   
	    actual[22]=tp.navigateToCycle(nodes);
		}
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	
	}

	@When("^change the status of first testcase to Pass$")
	public void change_the_status_of_first_testcase_to_Pass() throws Throwable {
	   
		try
		{
			exp=new ExecutionPage(driver);
		int[] testcase=new int[1];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
		
	
		String status=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 1, 17);
		actual[23]=exp.executeStatus(testcase[0], status);
		}
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^click on D button of first testcase and link a defect$")
	public void click_on_D_button_of_first_testcase_and_link_a_defect() throws Throwable {
		try
		{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
		actual[24]=exp.clickOnDefectButton(testcase);
	   String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
	
	   actual[25]=exp.linkDefect(defectId);
		}
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^defect should be link to the first test case$")
	public void defect_should_be_link_to_the_first_test_case() throws Throwable {
		try
		{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
		actual[26]=exp.validateLinkedDefect(testcase, defectId);
		}
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^change the status of second testcase to Fail$")
	public void change_the_status_of_second_testcase_to_Fail() throws Throwable {
		try
		{
		int[] testcase=new int[1];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution",2, 27);
		
	
		String status=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 5, 17);
		actual[27]=exp.executeStatus(testcase[0], status);
		}
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^click on D button of second testcase and link a defect$")
	public void click_on_D_button_of_second_testcase_and_link_a_defect() throws Throwable {
		try
		{
		 int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 2, 27);
		
		  actual[28]=exp.clickOnDefectButton(testcase);
		   String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
		   actual[29]=exp.linkDefect(defectId);
		}
		 catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^defect should be link to the second test case$")
	public void defect_should_be_link_to_the_second_test_case() throws Throwable {
		try
		{
			int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 2, 27);
			String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
		actual[30]=exp.validateLinkedDefect(testcase, defectId);
		} 
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^change the status of third testcase to WIP$")
	public void change_the_status_of_third_testcase_to_WIP() throws Throwable {
		try
		{
		int[] testcase=new int[1];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution",3, 27);
		
	
		String status=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 6, 17);
		actual[31]=exp.executeStatus(testcase[0], status);
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^click on D button of third testcase and link a defect$")
	public void click_on_D_button_of_third_testcase_and_link_a_defect() throws Throwable {
		try
		{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 3, 27);
		actual[32]=exp.clickOnDefectButton(testcase);
		   String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
		   actual[33]=exp.linkDefect(defectId);
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^defect should be link to the third test case$")
	public void defect_should_be_link_to_the_third_test_case() throws Throwable {
		try
		{
		
		
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 3, 27);
		 String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
		actual[34]=exp.validateLinkedDefect(testcase, defectId);
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^change the status of fourth testcase to Custom Status\\(Future Scope\\)$")
	public void change_the_status_of_fourth_testcase_to_Custom_Status_Future_Scope() throws Throwable {
		try
		{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 4, 27);
		
		String status=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 13, 17);
		actual[35]=exp.executeStatus(testcase, status);
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^click on D button of fourth testcase and link a defect$")
	public void click_on_D_button_of_fourth_testcase_and_link_a_defect() throws Throwable {
		try
		{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 4, 27);  
		exp.clickOnDefectButton(testcase);
		   String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
		   actual[36]=exp.linkDefect(defectId);
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^defect should be link to the fourth test case$")
	public void defect_should_be_link_to_the_fourth_test_case() throws Throwable {
		try
		{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 4, 27);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "Defects", 1, 0);
		actual[37]=exp.validateLinkedDefect(testcase, defectId);
		
		bp.waitForElement();
		tp=new TestPlanningPage(driver);
		String [] Release=new String[1];
		Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		tp.navigateToCycle(Release);
		bp.waitForElement();
		
		
		for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println("Actual["+k+"]="+actual[k]);
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
		}
		catch (Exception e) 
		{lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}


	
}
