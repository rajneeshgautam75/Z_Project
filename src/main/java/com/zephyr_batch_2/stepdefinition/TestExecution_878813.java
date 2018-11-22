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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878813 extends LaunchBrowser
{

	
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exp;
	LaunchBrowser lb=new LaunchBrowser();
	String filename="TestExecution_878813";
	boolean[] actual=new boolean[40];
	 SoftAssert soft=new SoftAssert();
	 
	 String Release=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
	 
@When("^user add a phase and two system under phase$")
public void user_add_a_phase_and_two_system_under_phase() throws Throwable {
    try
    {
    	
    	bp=new BasePage();
		String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		String desc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		tr=new TestRepositoryPage(driver);
		actual[0]=tr.doubleClickOnRelease(releaseName);
		actual[1]=tr.addNode(name, desc);
		bp.waitForElement();
		    String[] phase=new String[1];
			phase[0]=name;
			bp.waitForElement();
		    tr.navigateToNode(releaseName, phase);
			bp.waitForElement();
	    
	    actual[2]=tr.selectPhase(name);
	    
	    String sysName1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,3);
	    String sysDesc1=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,3);
	    actual[3]=tr.addNode(sysName1, sysDesc1);
	    
	    bp.waitForElement();
	    actual[4]=tr.selectPhase(name);
	    String sysName2=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,4);
	    String sysDesc2=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,4);
	    actual[5]=tr.addNode(sysName2, sysDesc2);
	    
    	
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

@When("^add test cases with test steps to the phase$")
public void add_test_cases_with_test_steps_to_the_phase() throws Throwable {
	 try
	    {
	    	
		 String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		 actual[6]=tr.selectPhase(name);
			
			actual[7]=tr.addTestCase();
			
			  
			   actual[8]=tr.clickDetailButton();
			   
			   
			   ctc=new CreateTestCasePage(driver);
			   String testCaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,14);
			   String testCaseDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,15);
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
			   
			   tr.clickOnList();
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

@When("^Launch test planning, create a new cycle$")
public void launch_test_planning_create_a_new_cycle() throws Throwable {
	 try
	    {
		 rp=new ReleasePage(driver);
		 actual[11]=rp.clickOnTestPlanning();
			tp=new TestPlanningPage(driver);
		    
		    String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 17, 5);
			String build=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 17, 6);
			  String environment=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 17, 7);
			   String hide=Excel_Lib.getData(INPUT_PATH_2, "TestExecution", 99, 7);
			   
			   
			   String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 17, 8));
			    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 17, 9);
			    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 17, 10));
			    String endDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",17, 11));
			    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17, 12);
			    String endDateDay=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 17, 13));		
			
			    actual[12]=tp.clickOnAddTestCycleSymbol();
			    
			    actual[13]=tp.CreateCycle(cycleName, build, environment, hide);
			    actual[14]=tp.enterStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
			    actual[15]=tp.saveTestCycle();
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

@When("^add created phase to the cycle and assign testcases to lead$")
public void add_created_phase_to_the_cycle_and_assign_testcases_to_lead() throws Throwable {
	 try
	    {
		 String[] cycle=new String[1];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,5);
		    actual[16]=tp.navigateToCycle(cycle);
		    
		 String phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
	       actual[17]=tp.addPhaseToCycle(phase);
	       actual[18]=tp.cancelBulkAssign();
	       
	       
	       bp.waitForElement();
	       
	       String[] cycle1=new String[1];
		    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		    actual[19]=tp.navigateToCycle(cycle1);
	       
		    int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		   bp.waitForElement();
		   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
		   actual[20]=tp.individualAssinTo(testcase, assignee);
	    	
	    	
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

@Then("^testcases should be assign to lead$")
public void testcases_should_be_assign_to_lead() throws Throwable {
	 try
	    {
		 int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    bp.waitForElement();
		   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
	
		   actual[21]=tp.validateAllAssigned(testcase, assignee);
	    	
		   bp.waitForElement();
		   tp.goBackToCycle();
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

@When("^user launch test repository page$")
public void user_launch_test_repository_page() throws Throwable {
	 try
	    {
		 rp=new ReleasePage(driver);
		 actual[22]=rp.clickOnTestRep();
	    	
	    	
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

@When("^create a system to phase and add testcases to the system$")
public void create_a_system_to_phase_and_add_testcases_to_the_system() throws Throwable {
	 try
	    {
		 String releaseName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
		 String[] phase=new String[1];
		 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		 actual[23]=tr.navigateToNode(releaseName, phase);
	    	String systemName=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",18,3);
	    	String systemDesc=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",18,3);
	    	actual[24]=tr.addNode(systemName, systemDesc);
	    	
	    	 String[] navigation=new String[2];
	    	 navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
	    	 navigation[1]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",18,3);
	    	 actual[25]=tr.doubleClickOnRelease(releaseName);
	    	bp.waitForElement();
	    	actual[26]=tr.navigateToNode(releaseName, navigation);
	    	
	    	actual[27]=tr.addTestCase();
	    	
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

@When("^Launch test planning page$")
public void launch_test_planning_page() throws Throwable {
	 try
	    {
	    	
		 actual[28]=rp.clickOnTestPlanning();
		 
	    	
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

@When("^edit the added phase,select phase and sync$")
public void edit_the_added_phase_select_phase_and_sync() throws Throwable {
	 try
	    {
		 
		   String[] cycle=new String[2];
		    cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,5);
		    cycle[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		    tp.doubleClickOnCycle(cycle[0]);
		    bp.waitForElement();
		    actual[29]=tp.navigateToCycle(cycle);
		    tp.options.click();
		    bp.waitForElement();
		    tp.edit.click();
		    bp.waitForElement();
		    String startDateYear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 18, 8));
		    String startDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution", 18, 9);
		    String startDateday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution", 18, 10));
		    String endDateYear=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",99, 12);
		    String endDateMonth=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",99, 12);
		    String endDateDay=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",99, 12);		
		    
		    actual[30]=tp.editStartDatAndEndDate(startDateYear, startDateMonth, startDateday, endDateYear, endDateMonth, endDateDay);
		    actual[31]=tp.saveTestCycle();
		    
		    tp.doubleClickOnCycle(cycle[0]);
		    bp.waitForElement();
		    
		    actual[32]=tp.navigateToCycle(cycle);
		    
		    actual[33]=tp.assignPhase();
		    
		    String[] cycle2=new String[1];
		    cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		   
		    tp.navigateToCycle(cycle2);
		    String check=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",99,2);
		    
		    actual[34]=tp.sync(check);
		    
	    	
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

@When("^assign testcases to the lead$")
public void assign_testcases_to_the_lead() throws Throwable {
	 try
	    {
	    	
		 String[] cycle1=new String[1];
		    cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
		    actual[35]=tp.navigateToCycle(cycle1);
	        bp.waitForElement();
		    int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    bp.waitForElement();
		   String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE, "User2");
		   actual[36]=tp.individualAssinTo(testcase, assignee);
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

@When("^Launch test execution and execute test step and change to custom status\\(N/A\\)$")
public void launch_test_execution_and_execute_test_step_and_change_to_custom_status_N_A() throws Throwable {
	 try
	    {
		 
	    	rp.clickOnTestExecution();
	    	bp.waitForElement();
	    	 String[] cycle1=new String[3];
			    cycle1[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			    cycle1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,5);
			    cycle1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,2);
			    
			    actual[37]=tp.navigateToCycle(cycle1);
		        bp.waitForElement();
		        
		        exp=new ExecutionPage(driver);
		        
		        bp.waitForElement();
			    String[] testCase=new String[1];
				   testCase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "TestExecution", 1, 27));
				   exp.selectMultipleTestCaseFromExecutionGrid(testCase);
				   bp.waitForElement();
				   tr.clickDetailButton();
				   bp.waitForElement();
		        
		        int[] testcase=new int[1];
			    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
			    
			    
			    String[] status= new String[1];
			    status[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,17);
			   // exp.stepDetailButton.click();
		       
		        actual[38]=exp.changeStepDetailStatus(testcase, status);
	    	
	    	
	    	
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

@Then("^Status should be change to custom status\\(N/A\\)$")
public void status_should_be_change_to_custom_status_N_A() throws Throwable {
	 try
	    {
	    
		 int[] testcase=new int[1];
		    testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_2,"TestExecution",1,27);
		    String[] status= new String[1];
		    status[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",17,17);
		 
		   
		    actual[39]=exp.validateStepDetailStatus(testcase,status);
		    bp.waitForElement();
		    tr.clickOnList();
		    bp.waitForElement();
			tp=new TestPlanningPage(driver);
			String [] Release=new String[1];
			Release[0]=Excel_Lib.getData(INPUT_PATH_2,"TestExecution",1,1);
			tp.navigateToCycle(Release);
			bp.waitForElement();
		    for(int k=0;k<=actual.length-1;k++)
		    {
		    	System.out.println(actual[k]);
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
