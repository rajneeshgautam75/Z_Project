package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Precond_194_199 extends LaunchBrowser {

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Precond_194_199";
	
	 boolean[] actual=new boolean[20];
	 SoftAssert soft=new SoftAssert();

@Given("^Users is in the project Page$")
public void users_is_in_the_project_Page() throws Throwable {
	 try
	  {
		  pp=new ProjectPage(driver);
		  rp= new ReleasePage(driver);
		  bp=new BasePage();
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		  actual[0]=pp.selectProject(projectName);
	  }
	  catch(Exception e)
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

@When("^user navigate to test Repsitory and create a node$")
public void user_navigate_to_test_Repsitory_and_create_a_node() throws Throwable {
	try
	   {
	     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[1]=pp.selectRelease(releaseName);
	     bp.waitForElement();
	     actual[2]=rp.clickOnTestRep();
	     tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "DefectTracking",2, 17);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_6, "DefectTracking", 2,18);
		
		actual[3]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]=tr.addNode(p_Name1,p_Desc1);  
	   }
	catch(Exception e)
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

@When("^add multiple testcases to the node$")
public void add_multiple_testcases_to_the_node() throws Throwable {
	try
	   {
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	    String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "DefectTracking",2, 17);
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[5]=tr.navigateToNode(releaseName, phase);
		for(int i=1;i<=4;i++)
		{
		tr.addTestCase();
		}
		
	   }
	catch(Exception e)
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

@Then("^testcases successfully added in the node$")
public void testcases_successfully_added_in_the_node() throws Throwable {
	try
	   {
	    actual[6]=tr.verifyPresentTestCase();
	   }
	catch(Exception e)
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

@When("^user navigate to test planning page and create a Cycle$")
public void user_navigate_to_test_planning_page_and_create_a_Cycle() throws Throwable {
	try
	   {
		  bp.waitForElement();
		  actual[7]=rp.clickOnTestPlanning();
		  
		   tp=new TestPlanningPage(driver);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "DefectTracking",2,19);
			String build=Excel_Lib.getData(INPUT_PATH_6, "DefectTracking", 1, 20);
			String environ=Excel_Lib.getData(INPUT_PATH_6, "DefectTracking", 1, 21);
			String hide=Excel_Lib.getData(INPUT_PATH_6, "DefectTracking", 100, 100);
			actual[8]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[9]=tp.CreateCycle(cycle, build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 0));
			   String smonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 1);
			   String sdate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 2));
			   String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 3));
			   String emonth=Excel_Lib.getData(INPUT_PATH_6,"TestCycle", 1, 4);
			   String edate=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_6,"TestCycle", 1, 5));  
			   bp.waitForElement();
			actual[10]=tp.enterStartDatAndEndDate(syear, smonth, sdate, eyear, emonth, edate);
			bp.waitForElement();
			//bp.waitForElement();
			actual[11]=tp.saveTestCycle();
			bp.waitForElement();
	   }
	   catch(Exception e)
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

@When("^add created phase to the cycle and assign it to anyone$")
public void add_created_phase_to_the_cycle_and_assign_it_to_anyone() throws Throwable {
	try
	   {
			bp.waitForElement();
	    	String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "DefectTracking", 2, 19);
			actual[12]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "DefectTracking", 2, 17);
			actual[13]=tp.addPhaseToCycle(Phase);
	   }
	   catch(Exception e)
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

@Then("^testcases should successfully assigned to anyone$")
public void testcases_should_successfully_assigned_to_anyone() throws Throwable {
	try
	   {
		  
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_6, "DefectTracking", 1, 23);
			bp.waitForElement();
			actual[14]=tp.bulkAssignment(Bulk_Type);
			
			actual[15]=tp.goBackToCycle();
	   }
	   catch(Exception e)
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

@When("^user navigate to Test Execution page$")
public void user_navigate_to_Test_Execution_page() throws Throwable {
	try
	   {
		     
		   
		   bp.waitForElement();
		   actual[16]=rp.clickOnTestExecution(); 
        bp.waitForElement();
	   }
	   catch(Exception e)
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

@When("^change the Status of testcase to pass$")
public void change_the_Status_of_testcase_to_pass() throws Throwable {
	try
	   {   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "DefectTracking",2,19 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_6, "DefectTracking",2,17 );
		    
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    exep=new ExecutionPage(driver);
			actual[17]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
			 String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 25);
			 bp.waitForElement();
			 exep.selectAllTestCases.click();
//			   tr.select_all_TestCase.click();
			   bp.waitForElement();
			   actual[18]=exep.changeMultiSelectedStatus(status);
			
			
	   }
	   catch(Exception e)
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

@Then("^status of testcases successfully changed to Pass$")
public void status_of_testcases_successfully_changed_to_Pass() throws Throwable {
	try
	   {	
		int[] testcase=new int[4];
		 String status=Excel_Lib.getData(INPUT_PATH_6,"DefectTracking", 2, 25);
		for(int i=0;i<=3;i++)
		{
			
			testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",i+1 ,16 );
		   
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[19]=exep.ValidateStatusOfTestCases(testcase, status);
		}
		
		 for(int k=0;k<=actual.length-1;k++)
		   {
		   System.out.println("Actual["+k+"]="+actual[k]);
		   soft.assertEquals(actual[k], true);
	       }
		   soft.assertAll();	 
	      
	   }
	   catch(Exception e)
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
	
	
}
