package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_Gadget_39 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dp;
	String fileName="Execution_Backlog_Gadget_39";
	
	boolean[] actual=new boolean[37];
	 SoftAssert soft=new SoftAssert();

@Given("^As a Lead,Launch Test Repository page$")
public void as_a_Lead_Launch_Test_Repository_page() throws Throwable {
  try
  {
	    pp=new ProjectPage(driver);
	    bp=new BasePage();
	    rp=new ReleasePage(driver);
	    tr=new TestRepositoryPage(driver);
	    tp=new TestPlanningPage(driver);
	    exep=new ExecutionPage(driver);
	    String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
	     //pp.backToProjectPage();
		 actual[0]=pp.selectProject(projectName);
	     actual[1]=pp.selectRelease(releaseName);
	     bp.waitForElement();
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

@When("^Add a node with testcases$")
public void add_a_node_with_testcases() throws Throwable {
  try
  {
	    String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
		String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 2);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
		String[] phase=new String[1];
		phase[0]=p_Name1;
		bp=new BasePage();
		actual[3]=tr.clickOnRelease(releaseName);
		bp.waitForElement();
		actual[4]=tr.addNode(p_Name1,p_Desc1);
		
		bp.waitForElement();
		actual[5]=tr.navigateToNode(releaseName, phase);
		for(int i=0;i<=1;i++)
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

@When("^Launch TestPlanning and create a cycle$")
public void launch_TestPlanning_and_create_a_cycle() throws Throwable {
	try
	   {
		    bp.waitForElement();
		    actual[6]=rp.clickOnTestPlanning();
		  
		    tp=new TestPlanningPage(driver);
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 26, 30);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			
			actual[7]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[8]=tp.CreateCycle(cycle, Build, environ, hide);
			
			bp.waitForElement();
			actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[10]=tp.saveTestCycle();
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

@When("^Add the existing phase to the cycle$")
public void add_the_existing_phase_to_the_cycle() throws Throwable {
	try
    {	
    	String[] cycle=new String[1];
		cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 26, 30);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 34);
		String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
		actual[11]=tp.navigateToCycle(cycle);
		
		bp.waitForElement();
		actual[12]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
	
		actual[13]=tp.bulkAssignment(Bulk_Type);
		
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

@When("^Launch Test Execution page and execute the testcase$")
public void launch_Test_Execution_page_and_execute_the_testcase() throws Throwable {
	try
	   {
		     /*pp=new ProjectPage(driver);//
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);// */
		   
		   bp.waitForElement();
		   actual[14]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    int[] tcNo1=new int[1];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",26 ,30 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,34 );
		    tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
			actual[15]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();

		    bp.waitForElement();
		    actual[16]=exep.executeStatus(tcNo1[0], statusType1);
		    tp.doubleClickOnCycle(releaseName);
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

@When("^Launch dashBoard page$")
public void launch_dashBoard_page() throws Throwable {
	try
    {
    	dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[17]=dp.clickOnManageDashboards();
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

@When("^Add the dashboard by clicking on dashboard plus symbol$")
public void add_the_dashboard_by_clicking_on_dashboard_plus_symbol() throws Throwable {
	try
	{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,39);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[18]=dp.clickOnAddDashBoardSymbol();
		actual[19]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
		actual[20]=dp.validateDashBoard(dashboardName);	
		actual[21]=dp.selectDashboard(dashboardName);
	
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

@When("^Add the execution backlog gadget by clicking on add gadget plus symbol$")
public void add_the_execution_backlog_gadget_by_clicking_on_add_gadget_plus_symbol() throws Throwable {
	try
    {
		String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
		actual[22]=dp.clickOnAddGadgetSymbol();
		actual[23]=dp.addGadget(gadgetName);
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

@When("^configure the execution backlog gadget and save$")
public void configure_the_execution_backlog_gadget_and_save() throws Throwable {
	try
    {
		String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
		String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5"); 
		String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
		String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
		String[] value=new String[1];
		value[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
		actual[24]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
		actual[25]=dp.filterBy(filterByName, value);
		bp.waitForElement();
		actual[26]=dp.saveGadget();
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

@Then("^Execution backlog gadget is validated successfully$")
public void execution_backlog_gadget_is_validated_successfully() throws Throwable {
	try
    {
		String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
		actual[27]=dp.validateGadget(gadgetName);
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

@When("^navigate to the test execution page and change the execution status to Unexecuted$")
public void navigate_to_the_test_execution_page_and_change_the_execution_status_to_Unexecuted() throws Throwable {
	try
	   {
		     /*pp=new ProjectPage(driver);//
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);// */
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
		   pp.backToProjectPage();
		   pp.selectProject(projectName1);
		   pp.selectProject(projectName);
		   pp.selectRelease(releaseName);
		   bp.waitForElement();
		   actual[28]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    int[] tcNo1=new int[1];
		    //String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",26 ,30 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,34 );
		    tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
		    bp.waitForElement();
			actual[29]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();

		    bp.waitForElement();
		    actual[30]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[31]=tp.doubleClickOnCycle(releaseName);
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

@When("^Launch the dashBoard page$")
public void launch_the_dashBoard_page() throws Throwable {
	try
    {
    	dp=new DashBoardPage(driver);
		bp=new BasePage();
		actual[32]=dp.clickOnManageDashboards();
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

@Then("^selected gadget should be able to change execution status to unexecuted$")
public void selected_gadget_should_be_able_to_change_execution_status_to_unexecuted() throws Throwable {
	try
	{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,39);
		String filterName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
		actual[33]=dp.searchDashboard(dashboardName);
		actual[34]=dp.validateDashBoard(dashboardName);	
		actual[35]=dp.selectDashboard(dashboardName);
		actual[36]=dp.viewMsg(filterName);
		
		pp.backToProjectPage();
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
