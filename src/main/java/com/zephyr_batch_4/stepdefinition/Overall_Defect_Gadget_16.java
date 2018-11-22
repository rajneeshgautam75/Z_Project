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

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Overall_Defect_Gadget_16 extends LaunchBrowser{
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
    String fileName="Overall_Defect_Gadget_16";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
   	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	@Given("^user Logins AS Manager$")
	public void user_Logins_AS_Manager() throws Throwable {
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
//			System.out.println("UserName is"+uname);
//			System.out.println("Password is"+password);
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

	@Then("^Login should be successfull$")
	public void login_should_be_successfull() throws Throwable {
		try
		{
			lp.verifyLoginTitle();
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

	@When("^user launchs TestRepository, Add Testcase, Launch Test Planning and assign Phase to Cycle$")
	public void user_launchs_TestRepository_Add_Testcase_Launch_Test_Planning_and_assign_Phase_to_Cycle() throws Throwable {
		try
		{
		tp=new TestPlanningPage(driver);
		rp=new ReleasePage(driver);
		tr=new TestRepositoryPage(driver);
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 0);
		String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 1);
		actual[3]=pp.selectProject(project);
		actual[4]=pp.selectRelease(release);
		String [] navigation=new String [1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 2, 0);
		String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 0);
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
		cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 0);
		String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 2,0);
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

	@When("^user goes to test execution, Execute a testcases and link defect with any status$")
	public void user_goes_to_test_execution_Execute_a_testcases_and_link_defect_with_any_status() throws Throwable {
		try
		{
		ep=new ExecutionPage(driver);
		String[] cycleName=new String[2];          
		cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",1,0 );
		cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",2,0 );
		String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
		int testcase[]=new int[1];
		testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
		String defectId=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 5, 6);
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

	@Then("^defect should link with any status which assigned by user$")
	public void defect_should_link_with_any_status_which_assigned_by_user() throws Throwable {
		try
		{
			int testcase=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 5, 6);
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

	@When("^User is In a DashBoard Window$")
	public void user_is_In_a_DashBoard_Window() throws Throwable {
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

	@Then("^user should able to launch dashboard window$")
	public void user_should_able_to_launch_dashboard_window() throws Throwable {
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

	@When("^User adds a New DashBoard by adding plus button$")
	public void user_adds_a_New_DashBoard_by_adding_plus_button() throws Throwable {
		try
		   {
		   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 28, 1);
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

	@Then("^A new DashBoard should be added by User$")
	public void a_new_DashBoard_should_be_added_by_User() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 28, 1);
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

	@When("^user clicks on a new dashboard which is added$")
	public void user_clicks_on_a_new_dashboard_which_is_added() throws Throwable {
		try
		  {
		    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 28, 1);
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

	@Then("^user should able to select on dashboard which added$")
	public void user_should_able_to_select_on_dashboard_which_added() throws Throwable {
		try
		{
		String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 28, 1);
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

	@When("^User Adds Overall Defect gadget by clicking on plus button$")
	public void user_Adds_Overall_Defect_gadget_by_clicking_on_plus_button() throws Throwable {
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

	@Then("^overall defect gadget should be added by user$")
	public void overall_defect_gadget_should_be_added_by_user() throws Throwable {
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

	@When("^user selects Project,Release and refresh rate,saves it$")
	public void user_selects_Project_Release_and_refresh_rate_saves_it() throws Throwable {
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

	@Then("^Defect count should show$")
	public void defect_count_should_show() throws Throwable {
		try
	    {
		
			dp.linkCountInGadgetPage();
			
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
