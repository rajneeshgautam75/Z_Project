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

public class Overall_Defect_Gadget_19 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	boolean[] actual=new boolean[36];
	SoftAssert soft=new SoftAssert();
    String fileName="Overall_Defect_Gadget_19";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
   	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	@Given("^user Login as Manager$")
	public void user_Login_as_Manager() throws Throwable {
		
		try
			{
				pp=new ProjectPage(driver);
				bp=new BasePage();
				lb=new LaunchBrowser();
				lp=new LoginPage(driver);
				dp=new DashBoardPage(driver);
			    bp.waitForElement();
			    pp.clickOnLogout();
				bp.waitForElement();
				String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
				String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
				bp.waitForElement();
				actual[0]=lp.enterUname(uname);
				actual[1]=lp.enterPass(password);
				System.out.println("UserName is"+uname);
				System.out.println("Password is"+password);
				actual[2]=lp.clickOnLogin();
				
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

	
	@When("^launch TestRepository, Add testcase, Launch Test Planning and assign phase to Cycle$")
	public void launch_TestRepository_Add_testcase_Launch_Test_Planning_and_assign_phase_to_Cycle() throws Throwable {
		try
		{
		tp=new TestPlanningPage(driver);
		rp=new ReleasePage(driver);
		tr=new TestRepositoryPage(driver);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 0);
		String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 1);
		actual[3]=pp.selectProject(project);
		actual[4]=pp.selectRelease(release);
		String [] navigation=new String [1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 1, 0);
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 21, 0);
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
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 21, 0);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 1,0);
		String Bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 1, 0);
		bp.waitForElement();
		actual[5]=rp.clickOnTestRep();
		actual[6]=tr.clickOnRelease(release);
		actual[7]=tr.addNode(name, desc);
		bp.waitForElement();
		actual[8]=tr.navigateToNode(release, navigation);
		actual[9]=tr.addTestCase();
		bp.waitForElement();
		actual[10]=rp.clickOnTestPlanning();
		tp.clickOnAddTestCycleSymbol();
		bp.waitForElement();
		actual[11]=tp.CreateCycle(cycle, Build, Environment, hide);
		bp.waitForElement();
		actual[12]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		bp.waitForElement();
		actual[13]=tp.saveTestCycle(); 
		bp.waitForElement(); 
		actual[14]=tp.navigateToCycle(cycle1);
		bp.waitForElement();
		actual[15]=tp.addPhaseToCycle(Phase);
		bp.waitForElement();
		actual[16]=tp.bulkAssignment(Bulk_type);
		bp.waitForElement();
	    tp.goBackToCycle(); 
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
	    
	

	@When("^Go to test execution, Execute a testcases and link defect with status/closed$")
	public void go_to_test_execution_Execute_a_testcases_and_link_defect_with_status_closed() throws Throwable {
		try
		{
		ep=new ExecutionPage(driver);
		String[] cycleName=new String[2];          
		cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",21,0 );
		cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",1,0 );
		String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
		int testcase[]=new int[1];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		String defectId=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 4, 6);
		actual[17]=rp.clickOnTestExecution();
		actual[18]=bp.waitForElement();
		actual[19]=tr.navigateToNode(release, cycleName);
		bp.waitForElement();
		actual[20]=ep.selectAndDeselectAllTestCase();
		bp.waitForElement();
		actual[21]=ep.changeMultiSelectedStatus(status);
		actual[22]=ep.clickOnDefectButton(testcase1);
    	bp.waitForElement();
    	actual[23]=ep.linkDefect(defectId);
    	bp.waitForElement();
	   }
	 catch(Exception e)
     {
	e.printStackTrace();
	lb.getScreenShot(fileName);
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
     }	

	    
	}

	@Then("^defect should link with status/closed$")
	public void defect_should_link_with_status_closed() throws Throwable {
	try
	{
		int testcase=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		String defectId=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 4, 6);
		actual[24]=ep.validateLinkedDefect(testcase, defectId);
	}
	catch(Exception e)
    {
	e.printStackTrace();
	lb.getScreenShot(fileName);
	driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
    }	
	}

	@When("^user is In a DashBoardPage$")
	public void user_is_In_a_DashBoardPage() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[25]=dp.clickOnManageDashboards();
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

	@Then("^DashBoard Window Should be Launched$")
	public void dashboard_Window_Should_be_Launched() throws Throwable {
		try
		{
			actual[26]=dp.validateDashboards();
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
	@When("^A new DashBoard is added By user$")
	public void a_new_DashBoard_is_added_By_user() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 32, 1);
		   String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		   String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		   String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		   bp.waitForElement();
		   actual[27]=dp.clickOnAddDashBoardSymbol();
		   actual[28]=dp.enterDashBoardDetails(name, description, layout, shareType);
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

	@Then("^New DashBoard Should be added by user$")
	public void new_DashBoard_Should_be_added_by_user() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 32, 1);
			actual[29]=dp.validateDashBoard(name);
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

	@When("^user clicks On DashBoard which Added$")
	public void user_clicks_On_DashBoard_which_Added() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 32, 1);
			actual[30]=dp.validateDashBoard(name);
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

	@Then("^User should select Added DashBoard$")
	
	public void user_should_select_Added_DashBoard() throws Throwable {
		try
		{
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 32, 1);
		actual[31]=dp.selectDashboard(name);
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

	@When("^user adds overall defect gadget$")
	public void user_adds_overall_defect_gadget() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
		bp.waitForElement();
		actual[32]=dp.clickOnAddGadgetSymbol();
		bp.waitForElement();
		actual[33]=dp.addGadget(gadgetName);
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

	@Then("^overall defects gadget to be added$")
	public void overall_defects_gadget_to_be_added() throws Throwable {
		try
		{
			String gadgetName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 5, 6);
			actual[34]=dp.validateGadget(gadgetName);
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

	@When("^user select the project,release and refresh rate,saves it$")
	public void user_select_the_project_release_and_refresh_rate_saves_it() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	    	String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
			String refreshRate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 3, 7);
			actual[35]=dp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^should be shown defect count$")
	public void should_be_shown_defect_count() throws Throwable {
		try
	    {
			dp.linkCountInGadgetPage();	
			bp.waitForElement();
			pp.backToProjectPage();
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
