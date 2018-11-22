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

public class OverAllDefect_2 extends LaunchBrowser{
	
	LaunchBrowser lb=new LaunchBrowser(); 
	String fileName="OverAllDefect_2";
	
	BasePage bp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	DashBoardPage dp;
	ExecutionPage ep;
	LoginPage lp;
	
	boolean actual[]=new boolean[46];
	SoftAssert soft=new SoftAssert();
	
	private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
	
	
	@Given("^Test Manager is in Defect Tracking page$")
	public void test_Manager_is_in_Defect_Tracking_page() throws Throwable {
	     try
	      {
	       lp=new LoginPage(driver);
	       bp=new BasePage();
	       pp=new ProjectPage(driver);
	       ep=new ExecutionPage(driver);
	       actual[0]=pp.clickOnLogout();
	       actual[1]=bp.waitForElement();
	       String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		   actual[2]=lp.enterUname(userName);
		   String Password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		   actual[3]=lp.enterPass(Password);
		   bp.waitForElement();
		   actual[4]=lp.clickOnLogin();
		   bp.waitForElement();
		   actual[5]=pp.launchAdministration();
		   bp.waitForElement();
		   actual[6]=pp.clickOnDefectTracking();  
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

	@When("^Set DTS to JIRA$")
	public void set_DTS_to_JIRA() throws Throwable {
		 try
		   {
			String DTS=Excel_Lib.getData(INPUT_PATH_5, "Url", 3, 0);
			String url=Excel_Lib.getData(INPUT_PATH_5, "Url", 1, 0);
			String username=Excel_Lib.getData(INPUT_PATH_5, "Url", 2, 0);
			String password=Excel_Lib.getData(INPUT_PATH_5, "Url", 2, 0);
			actual[7]=pp.setDTS(DTS, url, username, password);
			bp.waitForElement();
			actual[8]=pp.clickOnLogout();
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

	@When("^Launch TestRepository, add testcase, Launch Test Planning and assign phase to cycle$")
	public void launch_TestRepository_add_testcase_Launch_Test_Planning_and_assign_phase_to_cycle() throws Throwable {
		 try
		   {
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			tp=new TestPlanningPage(driver);
			String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
			actual[9]=lp.enterUname(userName);
			String Password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
			actual[10]=lp.enterPass(Password);
			bp.waitForElement();
			actual[11]=lp.clickOnLogin();
			bp.waitForElement();   
			actual[12]=pp.selectProject(project);
			actual[13]=pp.selectRelease(release);
			bp.waitForElement();
     		actual[14]=rp.clickOnTestRep();
			bp.waitForElement();
			actual[15]=tr.clickOnRelease(release);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 49, 0);
			String Desc=Excel_Lib.getData(INPUT_PATH_5, "Phase", 1, 1);
			actual[16]=tr.addNode(name, Desc);
			bp.waitForElement();
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 49, 0);
			actual[17]=tr.navigateToNode(release, navigation);
			actual[18]=tr.addTestCase();
			bp.waitForElement();  
			actual[19]=rp.clickOnTestPlanning();
			actual[20]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 23, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 100, 100);
			actual[21]=tp.CreateCycle(cycle, Build, Environment, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_5, "Cycle Date", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_5, "Cycle Date", 1, 5));
			actual[22]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			actual[23]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle", 23, 0);
			actual[24]=tp.navigateToCycle(cycle1);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase", 49,0);
			actual[25]=tp.addPhaseToCycle(Phase);
			actual[26]=bp.waitForElement();
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_5,"BulkAssignment", 1, 0);
			actual[27]=tp.bulkAssignment(Bulk_type);
			bp.waitForElement();
			tp.goBackToCycle();
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

	@When("^Go to test execution, Execute a testcase and Link one defect$")
	public void go_to_test_execution_Execute_a_testcase_and_Link_one_defect() throws Throwable {
		 try
		   {
			ep=new ExecutionPage(driver);
			actual[28]=rp.clickOnTestExecution();
			actual[29]=bp.waitForElement();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Create cycle",23,0 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "Phase",49,0 );
			actual[30]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[31]=ep.selectAndDeselectAllTestCase();
			String status12=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 2);
			actual[32]=ep.changeMultiSelectedStatus(status12);
			bp.waitForElement();
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
			actual[33]=ep.clickOnDefectButton(testcase1);
			bp.waitForElement();
			String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
			actual[34]=ep.linkDefect(defectId);
			bp.waitForElement();
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

	@Then("^Defect should be linked to testcase$")
	public void defect_should_be_linked_to_testcase() throws Throwable {
		 try
		   {
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_5, "Execution", 1, 0);
		    String defectId=Excel_Lib.getData(INPUT_PATH_5, "Execution", 1, 6);
		    actual[35]=ep.validateLinkedDefect(testcase1, defectId);
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

	@When("^Launch Dashboard window$")
	public void launch_Dashboard_window() throws Throwable {
		 try
		   {
			dp=new DashBoardPage(driver);
			actual[36]=dp.clickOnManageDashboards();
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
	
	

@Then("^Should launch dashboard Window$")
public void should_launch_dashboard_Window() throws Throwable {
	 try
	   {
		actual[37]=dp.validateDashboards();
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


	

	@When("^Add dashboard by clicking on add button$")
	public void add_dashboard_by_clicking_on_add_button() throws Throwable {
		 try
		   {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 1);
			String layout=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 2);
			String shareType=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 2, 3);
			actual[38]=dp.clickOnAddDashBoardSymbol();
			bp.waitForElement();
			actual[39]=dp.enterDashBoardDetails(name, desc, layout, shareType);
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
	
	
	@Then("^Should be able to Add new Dashboard$")
	public void should_be_able_to_Add_new_Dashboard() throws Throwable {
		 try
		   {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 0);
			actual[40]=dp.validateDashBoard(name);
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


	
	@When("^Click on added dashboard$")
	public void click_on_added_dashboard() throws Throwable {
		 try
		   {
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 0);
			actual[41]=dp.searchDashboard(name);
			bp.waitForElement();
			dp.selectDashboard(name);
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

	@When("^Add Overall Defects Gadget by clicking on add button$")
	public void add_Overall_Defects_Gadget_by_clicking_on_add_button() throws Throwable {
		 try
		   {
			actual[42]=dp.clickOnAddGadgetSymbol();
		    bp.waitForElement();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
			actual[43]=dp.addGadget(gadgetName);
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


@Then("^Should be able to add Overall defect Gadget$")
public void should_be_able_to_add_Overall_defect_Gadget() throws Throwable {
	 try
	   {
		
		String gadget=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 4);
	    actual[44]=dp.validateGadget(gadget);
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
	
	
	@When("^Select created project,Release, refresh rate and click on save\\.$")
	public void select_created_project_Release_refresh_rate_and_click_on_save() throws Throwable {
		 try
		   {
		   String refreshRate=Excel_Lib.getData(INPUT_PATH_5, "DashBoards", 1, 5);
		   actual[45]=dp.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Should show execution linked defect count by status$")
	public void should_show_execution_linked_defect_count_by_status() throws Throwable {
		 try
		   {
			int defectCount=dp.linkCountInGadgetPage();
			pp.backToProjectPage();
			System.out.println(defectCount);
			for(int k=0;k<=actual.length-1;k++)
			{
			System.out.println("Actual["+k+"]=" + actual[k]);
			soft.assertEquals(actual[k], true);
			}
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

}
