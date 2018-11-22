package com.zephyr_batch_4.stepdefinition;


import org.testng.asserts.SoftAssert;
import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_48 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	boolean[] actual=new boolean[30];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_48";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
   	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	@Given("^User installs five point zero version$")
	public void user_installs_five_point_zero_version() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			lp=new LoginPage(driver);
			dp=new DashBoardPage(driver);
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			
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

	@When("^user Launchs TestRepository, Adds Testcases, Launchs Test Planning and assign Phase to Cycle$")
	public void user_Launchs_TestRepository_Adds_Testcases_Launchs_Test_Planning_and_assign_Phase_to_Cycle() throws Throwable {
		try
		{
		ep=new ExecutionPage(driver);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 0);
		String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 1);
		String [] navigation=new String [1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 0);
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 12, 0);
		String Build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 1);
		String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 2);
		String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
		String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 3, 1);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 2));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
		String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 1, 4);
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 5));
		String [] cycle1 =new String[1];
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 12, 0);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 8,0);
		String Bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
		bp.waitForElement();
		actual[2]=rp.clickOnTestRep();
		actual[3]=tr.clickOnRelease(release);
		actual[4]=tr.addNode(name, desc);
		bp.waitForElement();
		actual[5]=tr.navigateToNode(release, navigation);
		actual[6]=tr.addTestCase();
		bp.waitForElement();
		actual[7]=rp.clickOnTestPlanning();
		tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[8]=tp.CreateCycle(cycle, Build, Environment, hide);
		bp.waitForElement();
		actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[10]=tp.saveTestCycle(); 
		bp.waitForElement(); 
		actual[11]=tp.navigateToCycle(cycle1);
		bp.waitForElement();
		actual[12]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		actual[13]=tp.bulkAssignment(Bulk_type);
		tp.goBackToCycle();
		String[] cycleName=new String[2];          
		cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",12,0 );
		cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",8,0 );
		actual[14]=rp.clickOnTestExecution();
		actual[15]=bp.waitForElement();
		actual[16]=tr.navigateToNode(release, cycleName);
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

	@When("^User goes to test execution, Execute a testcases with any status$")
	public void user_goes_to_test_execution_Execute_a_testcases_with_any_status() throws Throwable {
		try
		{
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			actual[17]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[18]=ep.changeMultiSelectedStatus(status);
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

	@When("^Manage Dashboard page is opened by user$")
	public void manage_Dashboard_page_is_opened_by_user() throws Throwable {
		try
		{
		  bp.waitForElement();
		  actual[19]=dp.clickOnManageDashboards();		
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

	@When("^adds new Dashboard$")
	public void adds_new_Dashboard() throws Throwable {
		try
		{
			   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 49, 1);
			   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
			   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
			   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
			   bp.waitForElement();
			   actual[20]=dp.clickOnAddDashBoardSymbol();
			   actual[21]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^New Dashboard should be added by USER$")
	public void new_Dashboard_should_be_added_by_USER() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 49, 1);
			actual[22]=dp.validateDashBoard(name);
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

	@When("^User adds execution backlog gadget for added new dashboard$")
	public void user_adds_execution_backlog_gadget_for_added_new_dashboard() throws Throwable {
		try
		{
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 49, 1);
	    	String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
	    	actual[23]=dp.selectDashboard(name);
	    	actual[24]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[25]=dp.addGadget(gadget);	
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

	@Then("^execution backlog gadget should be Added By User$")
	public void execution_backlog_gadget_should_be_Added_By_User() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
			actual[26]=dp.validateGadget(gadget);
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

	@When("^user selects project and release for execution backlog gadget$")
	public void user_selects_project_and_release_for_execution_backlog_gadget() throws Throwable {
		try
		{
			String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
		    String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 11, 2);
	    	String values[]=new String[1];
	    	values[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 8, 0);
	    	actual[27]=dp.configureTraceabilityGadget(project, release, refreshrate);
			bp.waitForElement();
			bp.waitForElement();
			actual[28]=dp.filterBy(filterByName, values);
			
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

	@When("^user Views the execution backlog details$")
	public void user_Views_the_execution_backlog_details() throws Throwable {
		try
		{
			bp.waitForElement();
			dp.saveTraceabilityGadget();
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

	@Then("^should show data in Execution Backlog gadget$")
	public void should_show_data_in_Execution_Backlog_gadget() throws Throwable {
		try
		{
			String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 11, 2);
			bp.waitForElement();
			actual[29]=dp.viewMsg(filterByName);
			bp.waitForElement();
			pp.navigateToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
	        {
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
