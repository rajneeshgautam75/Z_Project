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

public class TestExecution_878811 extends LaunchBrowser
{
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LoginPage lp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878811";
	
	boolean[] actual=new boolean[47];
	 SoftAssert soft=new SoftAssert();
	 
	 
	 String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);

	@When("^user add a phase and add two system to phase$")
	public void user_add_a_phase_and_add_two_system_to_phase() throws Throwable {
	    
		try
	    {
	    	
	    	bp=new BasePage();
			String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
			String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
			tr=new TestRepositoryPage(driver);
			actual[0]=tr.doubleClickOnRelease(releaseName);
			actual[1]=tr.addNode(name, desc);
			 bp.waitForElement();
			    String[] phase=new String[1];
				phase[0]=name;
				bp.waitForElement();
			    actual[2]=tr.navigateToNode(releaseName, phase);
				bp.waitForElement();
		    
		    String sysName1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,3);
		    String sysDesc1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,3);
		    actual[3]=tr.addNode(sysName1, sysDesc1);
		    
		    bp.waitForElement();
		    actual[4]=tr.selectPhase(name);
		    String sysName2=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,4);
		    String sysDesc2=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,4);
		    actual[5]=tr.addNode(sysName2, sysDesc2);
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

	@When("^add testcases with test steps to the phase$")
	public void add_testcases_with_test_steps_to_the_phase() throws Throwable {
		try
	    {
			    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
			    actual[6]=tr.selectPhase(name);
				actual[7]=tr.addTestCase();
				bp.waitForElement();
				actual[8]=tr.clickDetailButton();
				bp.waitForElement();
				ctc=new CreateTestCasePage(driver);
				String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,14);
				String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,15);
				actual[9]= ctc.enterTestCaseNameAndDesc(testCaseName, testCaseDesc);
				String[] stepdetail=new String[3];
				   int l=0;
				   for(int i=19;i<=21;i++)
				   {
					   stepdetail[l]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,i);
					   l++;
				   }
				  
				   actual[10]=ctc.enterTestCaseStepDetail(stepdetail);
				   bp.waitForElement();
				   actual[11]=tr.clickOnList();
			       for(int i=1;i<=2;i++)
			       {
			    	   actual[12]=tr.selectallTestCase();
			       bp.waitForElement();
			       actual[13]=tr.cloneTestCase();
			       }
			      
			       for(int i=1;i<=2;i++)
			       {
			    	   actual[14]=tr.addTestCase();
			       }
			       
			
			
	    
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

	@When("^read the test case count$")
	public void read_the_test_case_count() throws Throwable {
		try
	    {
			
			
			actual[15]=tr.verifyPresentTestCase();
			
			rp=new ReleasePage(driver);
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

	@When("^create cycle and add created phase to cycle$")
	public void create_cycle_and_add_created_phase_to_cycle() throws Throwable {
		try
	    {
			
			tp=new TestPlanningPage(driver);
			 
		    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 19, 5);
			String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 19, 6);
			   String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 19, 7);
			   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
			   
			   
			   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 19, 8));
			    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 19, 9);
			    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 19, 10));
			    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",19, 11));
			    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 19, 12);
			    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 19, 13));		
			
			    actual[16]=tp.clickOnAddTestCycleSymbol();
			    
			    actual[17]=tp.CreateCycle(cycleName, build, environment, hide);
			    actual[18]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
			    actual[19]=tp.saveTestCycle();
			    bp.waitForElement();
				
				
				
				
			    String[] cycle=new String[1];
			    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,5);
			    actual[20]=tp.navigateToCycle(cycle);
		       
		       String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
		       actual[21]=tp.addPhaseToCycle(phase);
		       
			
	    
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

	@When("^assign to the creator and read the testcase count$")
	public void assign_to_the_creator_and_read_the_testcase_count() throws Throwable {
		try
	    {
			    String bulkType=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,22);
		        actual[22]=tp.bulkAssignment(bulkType);
		        String[] cycle=new String[1];
			    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
			    actual[23]=tp.navigateToCycle(cycle);
		        bp.waitForElement();
		        actual[24]=tp.goBackToCycle();
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
	
	
	@When("^Launch test execution and execute teststep of first three test case and change to Pass/Fail/N/A$")
	public void launch_test_execution_and_execute_teststep_of_first_three_test_case_and_change_to_Pass_Fail_N_A() throws Throwable {
		try
		{
			   pp=new ProjectPage(driver);
			   rp=new ReleasePage(driver);
			   tr=new TestRepositoryPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
			   String releaseName=Excel_Lib.getData(INPUT_PATH_5,"Releases",1,0);
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
		       bp.waitForElement();
			   exp=new ExecutionPage(driver);
			   actual[25]=rp.clickOnTestExecution();
		       bp.waitForElement();
		       String[] cycle=new String[2];
		       String release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		       cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,5);
		       cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
		       actual[26]=tr.navigateToNode(release, cycle);
		       bp.waitForElement();
		       String[] testcase1=new String[1];
		       testcase1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27));
		       actual[27]=exp.selectMultipleTestCaseFromExecutionGrid(testcase1);
		       bp.waitForElement();
		       tr.clickDetailButton();
		       bp.waitForElement();
		      // exp.stepDetailButton.click();
		       bp.waitForElement();
		       int[] testcase=new int[1];
		       testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		       String[] status1= new String[1];
		       status1[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,17);
		       actual[28]=exp.changeStepDetailStatus(testcase, status1);
		  
		    
		       String[] testcase2=new String[1];
		       testcase2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",2,27));
		       actual[29]=exp.selectMultipleTestCaseFromExecutionGrid(testcase2);
		       bp.waitForElement();
		       //exp.stepDetailButton.click();
		       bp.waitForElement();
		       String[] status2= new String[1];
		       status2[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",5,17);
		       actual[30]=exp.changeStepDetailStatus(testcase, status2);
		    
		       String[] testcase3=new String[1];
		       testcase3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",3,27));
		       actual[31]=exp.selectMultipleTestCaseFromExecutionGrid(testcase3);
		       bp.waitForElement();
		     //  exp.stepDetailButton.click();
		       bp.waitForElement();
		    String[] status3= new String[1];
		    status3[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",16,17);
		    actual[32]=exp.changeStepDetailStatus(testcase, status3);
		    
		    bp.waitForElement();
		    tr.clickOnList();
		    bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			tp.navigateToCycle(Release);
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

	

	@When("^Launch test planning module and edit the phase$")
	public void launch_test_planning_module_and_edit_the_phase() throws Throwable {
		try
	    {
			actual[33]=rp.clickOnTestPlanning();
			bp.waitForElement();
			
			
			String[] cycle=new String[2];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,5);
		    cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
		    
		    actual[34]=tp.doubleClickOnCycle(cycle[0]);
		    bp.waitForElement();
		    actual[35]=tp.navigateToCycle(cycle);
		    
		    tp.options.click();
		    bp.waitForElement();
		    tp.edit.click();
		    bp.waitForElement();
		    String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 20, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 20, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 20, 10));
		    String endDateYear=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",99, 12);
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",99, 12);
		    String endDateDay=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",99, 12);		
		    
		    actual[36]=tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[37]=tp.saveTestCycle();
		    
		    actual[38]=tp.doubleClickOnCycle(cycle[0]);
		    bp.waitForElement();
		    
		    String[] cycle1=new String[2];
		    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,5);
		    cycle1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
		    actual[39]=tp.navigateToCycle(cycle1);
			
			
			
			
	    
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

	@When("^unassign executed testcase and save it$")
	public void unassign_executed_testcase_and_save_it() throws Throwable {
		try
	    {
			actual[40]=tp.assignPhase();
			  bp.waitForElement();
			
			   String[] cycle1=new String[1];
			    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
			    
			    actual[41]=tp.navigateToCycle(cycle1);
				
			bp.waitForElement();
			int[] testcase=new int[3];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",2,27);
		    testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",3,27);
		    actual[42]=tp.selectSingleMultipleTestcase(testcase);
			
			String assignee=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",20,16);
			actual[43]=tp.assignAllSelected(assignee);
			
			bp.waitForElement();
			rp=new ReleasePage(driver);
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

	@When("^Launch test execution page and navigate to phase$")
	public void launch_test_execution_page_and_navigate_to_phase() throws Throwable {
		try
	    {
			
			actual[44]=rp.clickOnTestExecution();
			bp.waitForElement();
			String[] cycle=new String[2];
		  String release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,5);
		    cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",19,2);
		    actual[45]=tr.navigateToNode(release, cycle);
			
			
	    
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

	@Then("^verify unassigned test case should not show$")
	public void verify_unassigned_test_case_should_not_show() throws Throwable {
		try
	    {
			
			
			actual[46]=tr.verifyPresentTestCase();
			
			bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			tp.navigateToCycle(Release);
			bp.waitForElement();
			
			 for(int k=0;k<=actual.length-1;k++)
		     {
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
