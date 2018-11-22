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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878807 extends LaunchBrowser
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
	String filename="TestExecution_878807";
	
	boolean[] actual=new boolean[61];
	SoftAssert soft=new SoftAssert();
	
	String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	
	@Given("^User is in test repository page in normal project$")
	public void user_is_in_test_repository_page_in_normal_project() throws Throwable {
		try
		{
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		
		pp=new ProjectPage(driver);
		bp=new BasePage();
		
		pp=new ProjectPage(driver);
	     pp.clickOnLogout();
	     bp.waitForElement();
	lp=new LoginPage(driver);
	 String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
	 String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
	 lp.enterUname(Uname);
	 lp.enterPass(Pass);
	 lp.clickOnLogin();
	 bp.waitForElement();
		actual[0]=pp.selectProject(projectName);
		actual[1]=pp.selectRelease(releaseName);
	    rp=new ReleasePage(driver);
	    actual[2]=rp.clickOnTestRep();
	}
	 catch (Exception e) 
		{ lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^User creates a phase and add test cases with test steps$")
	public void user_creates_a_phase_and_add_test_cases_with_test_steps() throws Throwable {
	try
	{
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
		tr=new TestRepositoryPage(driver);
		actual[3]=tr.doubleClickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]=tr.addNode(name, desc);
	    bp.waitForElement();
	    String[] phase=new String[1];
		phase[0]=name;
		bp.waitForElement();
	    tr.navigateToNode(releaseName, phase);
		bp.waitForElement();
	   actual[5]=tr.addTestCase();
	   actual[6]=tr.clickDetailButton();
	   bp.waitForElement();
	   
	   
	   ctc=new CreateTestCasePage(driver);
	   String testCaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,14);
	   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,15);
	   actual[7]= ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
	   
	   String[] stepdetail=new String[3];
	   int l=0;
	   for(int i=19;i<=21;i++)
	   {
		   stepdetail[l]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
		   l++;
	   }
	  
	   actual[8]=ctc.enterTestCaseStepDetail(stepdetail);
	   bp.waitForElement();
	   
	   actual[9]=tr.clickOnList();
	   
	   actual[10]=tr.selectallTestCase();
	   actual[11]=tr.cloneTestCase();
	   bp.waitForElement();
	   actual[12]=tr.selectallTestCase();
	   actual[13]=tr.cloneTestCase();
	   bp.waitForElement();
	   
	   actual[14]=tr.selectallTestCase();
	   actual[15]=tr.cloneTestCase();
	   
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

	@When("^creates a new cycle and add phase to the cycle$")
	public void creates_a_new_cycle_and_add_phase_to_the_cycle() throws Throwable {
	    
	    try
	    {
	    	actual[16]=rp.clickOnTestPlanning();
		tp=new TestPlanningPage(driver);
	    
	    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 14, 5);
		String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 14, 6);
		  String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 14, 7);
		   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
		   
		   
		   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 14, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 14, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 14, 10));
		    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",14, 11));
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14, 12);
		    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 14, 13));		
		
		    actual[17]=tp.clickOnAddTestCycleSymbol();
		    
		    actual[18]=tp.CreateCycle(cycleName, build, environment, hide);
		    actual[19]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[20]=tp.saveTestCycle();
		    bp.waitForElement();
		    
		    
		    
		    String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,5);
		    actual[21]=tp.navigateToCycle(cycle);
	       
	       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
	       actual[22]=tp.addPhaseToCycle(phase);
	       actual[23]=tp.cancelBulkAssign();
	       
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

	@When("^assign the test cases to the tester$")
	public void assign_the_test_cases_to_the_tester() throws Throwable {
		try
		{  
	    String[] cycle=new String[1];
	    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
	    actual[24]=tp.navigateToCycle(cycle);
	    
	    actual[25]=tr.verifyPresentTestCase();
	    actual[26]=tp.selectallTestCase();
	   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User3");
	   actual[27]=tp.assignAllSelected(assignee);
	   bp.waitForElement();}
	   
	   catch (Exception e) 
		{ lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@Then("^test case should be assigned to tester$")
	public void test_case_should_be_assigned_to_tester() throws Throwable {
		try
		{  
		
		int[] testcase=new int[8];
		for(int i=0;i<=7;i++)
		{
		testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",i+1,27);
		}
		
		String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User3");
		
		actual[28]=tp.validateAllAssigned(testcase, assignee);
		
		bp.waitForElement();
		tp.goBackToCycle();
		bp.waitForElement();
		}
		 catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^user logout from the application$")
	public void user_logout_from_the_application() throws Throwable {
		try
		{actual[29]=pp.clickOnLogout();
		}
		 catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^Login as tester and launch test execution$")
	public void login_as_tester_and_launch_test_execution() throws Throwable {
		try
		{ String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Username_1");
	    String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Password_1");
	    lp=new LoginPage(driver);		
		lp.enterUname(Uname);
		actual[30]=lp.enterPass(pass);
		actual[31]=lp.clickOnLogin();
	   
	   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		actual[32]=pp.selectProject(projectName);
		actual[33]=pp.selectRelease(releaseName);
		actual[34]=rp.clickOnTestExecution();
		bp.waitForElement();
		}
		 catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@When("^check for assigned test cases and logout from application$")
	public void check_for_assigned_test_cases_and_logout_from_application() throws Throwable {
		
		try
		{
			String[] cycle=new String[3];
		    cycle[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		    cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,5);
		    cycle[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
		    actual[35]=tp.navigateToCycle(cycle);
		    
		    exp=new ExecutionPage(driver);
		    
		    int[] testcase=new int[8];
			for(int i=0;i<=7;i++)
			{
			testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",i+1,27);
			}
			
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User3");
			actual[36]=exp.validateAssignedTestCase(testcase, assignee);
		    
			actual[37]=pp.clickOnLogout();
		}
			 catch (Exception e) 
				{ lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
		    
	}
		    

	@When("^Login as lead role and launch test planning$")
	public void login_as_lead_role_and_launch_test_planning() throws Throwable {
		try
		{ 
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Lead_Username_1");
		    String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Lead_Password_1");
		    		
		    actual[38]=lp.enterUname(Uname);
		    actual[39]=lp.enterPass(pass);
		    actual[40]=lp.clickOnLogin();
		   
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			actual[41]=pp.selectProject(projectName);
			actual[42]=pp.selectRelease(releaseName);
			actual[43]=rp.clickOnTestPlanning();
			bp.waitForElement();
		     }
			
			 catch (Exception e) 
				{ lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}

	@When("^edit assignments and delete some testcase assigned to tester$")
	public void edit_assignments_and_delete_some_testcase_assigned_to_tester() throws Throwable {
		try
		{
			String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,5);
		    actual[44]=tp.navigateToCycle(cycle);
		    
		    String cycleName=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 5);
			String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 15, 6);
			  String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 15, 7);
			   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
			   actual[45]=tp.editCycle(cycleName, build, environment, hide);
			   actual[46]=tp.saveTestCycle();
		        bp.waitForElement();
		    
		    tp.doubleClickOnCycle(cycle[0]);
		    String[] cycle1=new String[2];
		    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,5);
		    cycle1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
		    actual[47]=tp.navigateToCycle(cycle1);
		    
		    actual[48]=tp.assignPhase();
		    
		    String[] cycle2=new String[1];
		   
		    cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
		    actual[49]=tp.navigateToCycle(cycle2);
		    
		    int[] testcase=new int[3];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",2,27);
		    testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",3,27);
		    actual[50]=tp.selectSingleMultipleTestcase(testcase);
		    actual[51]=tp.deleteAllSelectedTestCases();
		    
		    tp.goBackToCycle();
		}
		    catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	
	@When("^lead logout from the application$")
	public void lead_logout_from_the_application() throws Throwable {
		try
		{	actual[52]=pp.clickOnLogout();
		}
		 catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}



	@When("^login as tester role and launch test execution$")
	public void login_as_tester_role_and_launch_test_execution() throws Throwable {
		try
		{ String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Username_1");
		    String pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "Tester_Password_1");
		    		
		    actual[53]=lp.enterUname(Uname);
		    actual[54]=lp.enterPass(pass);
		    actual[55]=lp.clickOnLogin();
	   
	    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		actual[56]=pp.selectProject(projectName);
		actual[57]=pp.selectRelease(releaseName);
	   bp.waitForElement();
	   rp=new ReleasePage(driver);
	   actual[58]=rp.clickOnTestExecution();
		}
	   catch (Exception e) 
		{ lb.getScreenShot(filename);
			e.printStackTrace();
		    driver.close();
		    Relogin_TPE rl=new Relogin_TPE();
		    rl.reLogin();
		    throw e;
		}
	}

	@When("^navigate to the node$")
	public void navigate_to_the_node() throws Throwable {
		try
		{ String[] cycle1=new String[3];
		   cycle1[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		    cycle1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,5);
		    cycle1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",14,2);
		    actual[59]=tp.navigateToCycle(cycle1);
		}
		    catch (Exception e) 
			{ lb.getScreenShot(filename);
				e.printStackTrace();
			    driver.close();
			    Relogin_TPE rl=new Relogin_TPE();
			    rl.reLogin();
			    throw e;
			}
	}

	@Then("^deleted test case should not be present in execution page$")
	public void deleted_test_case_should_not_be_present_in_execution_page() throws Throwable {
		try
		{	actual[60]=tr.verifyPresentTestCase();
		
		bp.waitForElement();
		tp=new TestPlanningPage(driver);
		String [] Release=new String[1];
		Release[0]=Excel_Lib.getData(INPUT_PATH_5, "Releases", 1, 0);
		tp.navigateToCycle(Release);
		bp.waitForElement();
		
//		 pp.clickOnLogout();
//		 bp.waitForElement();
//		 pp.closeBrowser();
	      
	      for(int k=0;k<=actual.length-1;k++)
		    {
		    	System.out.println(actual[k]);
		    	soft.assertEquals(actual[k], true);
		    }
			soft.assertAll();
		}
			 catch (Exception e) 
				{ lb.getScreenShot(filename);
					e.printStackTrace();
				    driver.close();
				    Relogin_TPE rl=new Relogin_TPE();
				    rl.reLogin();
				    throw e;
				}
	}
}
