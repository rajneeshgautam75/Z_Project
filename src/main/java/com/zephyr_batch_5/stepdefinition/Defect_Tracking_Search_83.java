package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_83 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	LoginPage lp;
	DefectTracking dt;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_Search_83";
	
	boolean[] actual=new boolean[58];
	SoftAssert soft=new SoftAssert();
	String sampleProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	String assignee=Excel_Lib.getData(INPUT_PATH_3,"TestPlanning",6,9);
	
	int[] testcaNo=new int[2];
	{
	 for(int i=0;i<=testcaNo.length-1;i++)
	 {
		 testcaNo[i]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",i+1,16); 
	 }
	}
	String[] phase=new String[3];
	{
	phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12);
	}
	@Given("^User is in Project page$")
	public void user_is_in_Project_page() throws Throwable {
	try
    {	 
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 exep=new ExecutionPage(driver);
		 dt=new DefectTracking(driver);
		 bp=new BasePage();
		 actual[1]=pp.selectProject(sampleProject);
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

	@When("^User is In TestRepository page$")
	public void user_is_In_TestRepository_page() throws Throwable {
	try
	   {
		 actual[1]=pp.selectRelease(releaseName);
		 actual[2]=rp.clickOnTestRep();
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
	
	@Then("^Should be able to launch testrepository$")
	public void should_be_able_to_launch_testrepository() throws Throwable {
	try
	   {
		 tr.validateTestRepositoryPage();
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

	@When("^User create a phase with testcases$")
	public void user_create_a_phase_with_testcases() throws Throwable {
	try
	   {
	    tr=new TestRepositoryPage(driver);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		bp.waitForElement();
		actual[10]=rp.clickOnTestRep();
		bp.waitForElement();
		actual[11]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[12]=tr.addNode(p_Name1,p_Desc1);  
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp.waitForElement();
		actual[13]=tr.navigateToNode(releaseName, phase);
		for(int i=1;i<=2;i++)
		{
		tr.addTestCase();
		}
		tr.clickOnRelease(releaseName);
		tr.selectPhase(p_Name1);
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

	@Then("^Should be able to create testcases in a phase node$")
	public void should_be_able_to_create_testcases_in_a_phase_node() throws Throwable {
	try
	   {
		 tr.verifyPresentTestCase();
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

	@When("^User create a node with testcases for phase$")
	public void user_create_a_node_with_testcases_for_phase() throws Throwable {
	try
	   {
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		bp.waitForElement();
		tr.clickOnRelease(releaseName);
		tr.selectPhase(p_Name1);
		actual[12]=tr.addNode(s_Name1,p_Desc1);  
		String[] system=new String[2];
		system[0]=p_Name1;
		system[1]=s_Name1;
		bp.waitForElement();
		actual[13]=tr.navigateToNode(releaseName,system);
		for(int i=1;i<=2;i++)
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

	@Then("^Should be able to create testcases in a node$")
	public void should_be_able_to_create_testcases_in_a_node() throws Throwable {
	try
	   {
		 tr.verifyPresentTestCase();
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

	@When("^User create a subnode with testcases for node$")
	public void user_create_a_subnode_with_testcases_for_node() throws Throwable {
	try
	   {
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13);
		String ss_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,14);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		bp.waitForElement();
		tr.clickOnRelease(releaseName);
		tr.selectPhase(s_Name1);
		actual[12]=tr.addNode(ss_Name1,p_Desc1);  
		String[] subsystem=new String[3];
		subsystem[0]=p_Name1;
		subsystem[1]=s_Name1;
		subsystem[2]=ss_Name1;
		bp.waitForElement();
		actual[13]=tr.navigateToNode(releaseName,subsystem);
		for(int i=1;i<=2;i++)
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

	@Then("^Should be able to create testcases in a subnode$")
	public void should_be_able_to_create_testcases_in_a_subnode() throws Throwable {
	try
	   {
		 tr.verifyPresentTestCase();
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

	@When("^User launch testPlanning$")
	public void user_launch_testPlanning() throws Throwable {
	try
	   {
		 actual[2]=rp.clickOnTestPlanning();
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

	@Then("^Should be able to launch testplanning$")
	public void should_be_able_to_launch_testplanning() throws Throwable {
	try
	   {
		 tp.validateTestPlanningPage();
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
	
	@When("^create a cycle and add phase to cycle and assign testcases$")
	public void create_a_cycle_and_add_phase_to_cycle_and_assign_testcases() throws Throwable {
	try
	   {
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13);
		String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
		String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
		String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
		actual[15]=tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[16]=tp.CreateCycle(cycle, build, environ, hide);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
		String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
		String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
		actual[17]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[18]=tp.saveTestCycle();
		bp.waitForElement();
		
    	String[] cycle1=new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 16, 13);
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12);
		actual[19]=tp.navigateToCycle(cycle1);
		
		bp.waitForElement();
		actual[20]=tp.addPhaseToCycle(phase[0]);
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3,"BulkAssignment",2,0);
		actual[21]=tp.bulkAssignment(bulk_Type);
		//actual[22]=tp.goBackToCycle();
		tp.navigateToCycle(phase);
		tp.selectallTestCase();
		tp.assignAllSelected(assignee);
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

	@Then("^Should be able to assign testcases in phase node$")
	public void should_be_able_to_assign_testcases_in_phase_node() throws Throwable {
	try
	   {
//		 int[] testcaNo=new int[2];
//		 for(int i=1;i<=2;i++)
//		 {
//			 testcaNo[i]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",i,12); 
//		 }
		 tp.validateAllAssigned(testcaNo, assignee);
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

	@When("^navigate to the system node and assign testcases$")
	public void navigate_to_the_system_node_and_assign_testcases() throws Throwable {
	try
	   {
		String[] system=new String[1];
		system[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13);
		
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3,"BulkAssignment",2,0);
		actual[21]=tp.bulkAssignment(bulk_Type);
		//actual[22]=tp.goBackToCycle();
		tp.navigateToCycle(system);
		tp.selectallTestCase();
		tp.assignAllSelected(assignee);
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

	@Then("^Should be able to assign testcases in system node$")
	public void should_be_able_to_assign_testcases_in_system_node() throws Throwable {
	try
	   {
		 tp.validateAllAssigned(testcaNo, assignee);
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

	@When("^navigate to the subsystem node and assign testcases$")
	public void navigate_to_the_subsystem_node_and_assign_testcases() throws Throwable {
	try
	   {
		String[] subsystem=new String[1];
		subsystem[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,14);
		
		String bulk_Type=Excel_Lib.getData(INPUT_PATH_3,"BulkAssignment",2,0);
		actual[21]=tp.bulkAssignment(bulk_Type);
		tp.navigateToCycle(subsystem);
		tp.selectallTestCase();
		tp.assignAllSelected(assignee);
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

	@Then("^Should be able to assign testcases in subsystem node$")
	public void should_be_able_to_assign_testcases_in_subsystem_node() throws Throwable {
	try
	   {
		 tp.validateAllAssigned(testcaNo, assignee);
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

	@When("^launch Test execution page$")
	public void launch_Test_execution_page() throws Throwable {
	try
	   {
		 actual[2]=rp.clickOnTestExecution();
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

	@Then("^Should be able to launch test execution page$")
	public void should_be_able_to_launch_test_execution_page() throws Throwable {
	try
	   {
		 actual[2]=exep.verifyExecutionPage();
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

	@When("^navigate to the phase and execute testcase$")
	public void navigate_to_the_phase_and_execute_testcase() throws Throwable {
	    
	}

	@When("^click on D button and link a defect to execution$")
	public void click_on_D_button_and_link_a_defect_to_execution() throws Throwable {
	   
	}

	
	@Then("^Should be able to link defect to the executed testcase in phase node$")
	public void should_be_able_to_link_defect_to_the_executed_testcase_in_phase_node() throws Throwable {
	    
	}

	@When("^navigate to the system and execute testcase$")
	public void navigate_to_the_system_and_execute_testcase() throws Throwable {
	    
	}

	@Then("^Should be able to link defect to the executed testcase in system node$")
	public void should_be_able_to_link_defect_to_the_executed_testcase_in_system_node() throws Throwable {
	    
	}

	@When("^navigate to the subsystem and execute testcase$")
	public void navigate_to_the_subsystem_and_execute_testcase() throws Throwable {
	   
	}

	@Then("^Should be able to link defect to the executed testcase in subsystem node$")
	public void should_be_able_to_link_defect_to_the_executed_testcase_in_subsystem_node() throws Throwable {
	    
	}

	@When("^launch Defect tracking page$")
	public void launch_Defect_tracking_page() throws Throwable {
	try
	   {
		 actual[2]=rp.clickOnDefectTracking();
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

	@When("^search a defect which is linked at phase$")
	public void search_a_defect_which_is_linked_at_phase() throws Throwable {
	try
	  {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[15]=dt.searchDefect(defectID);
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

	@Then("^Should be able to view cycle and testcase in search grid in DT app for phase level$")
	public void should_be_able_to_view_cycle_and_testcase_in_search_grid_in_DT_app_for_phase_level() throws Throwable {
	    
	}

	@When("^search a defect which is linked at system node$")
	public void search_a_defect_which_is_linked_at_system_node() throws Throwable {
	try
	  {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[15]=dt.searchDefect(defectID);
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

	@Then("^Should be able to view cycle and testcase in search grid in DT app for system level$")
	public void should_be_able_to_view_cycle_and_testcase_in_search_grid_in_DT_app_for_system_level() throws Throwable {
	    
	}

	@When("^search a defect which is linked at subsystem node$")
	public void search_a_defect_which_is_linked_at_subsystem_node() throws Throwable {
	try
	  {
		 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[15]=dt.searchDefect(defectID);
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

	@Then("^Should be able to view cycle and testcase in search grid in DT app for subsystem level$")
	public void should_be_able_to_view_cycle_and_testcase_in_search_grid_in_DT_app_for_subsystem_level() throws Throwable {
	    
	}
}
