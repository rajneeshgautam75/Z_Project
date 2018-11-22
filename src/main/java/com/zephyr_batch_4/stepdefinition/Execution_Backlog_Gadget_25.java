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

public class Execution_Backlog_Gadget_25 extends LaunchBrowser{

	LaunchBrowser lb;
	DashBoardPage dp;
	ProjectPage pp;
	ReleasePage rp;
	LoginPage lp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage exep;
	BasePage bp;
	String fileName="Execution_Backlog_Gadget_25";
	
	boolean[] actual=new boolean[39];
	SoftAssert soft=new SoftAssert();
	
	@Given("^As a second lead,Launch testRepository and add testcases$")
	public void as_a_second_lead_Launch_testRepository_and_add_testcases() throws Throwable {
		try
	    {
	    	tr=new TestRepositoryPage(driver);
	    	pp=new ProjectPage(driver);
	    	rp=new ReleasePage(driver);
			bp=new BasePage();
			pp.clickOnLogout();
			
			 lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_2");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_2");
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
		     String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
		     String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,43);
			 String p_Desc1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
			 String[] phase=new String[1];
			 phase[0]=p_Name1;
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
		     pp.selectProject(projectName1);
		     actual[0]=pp.selectProject(projectName);
		     actual[1]=pp.selectRelease(releaseName);
		     actual[2]=rp.clickOnTestRep();
		     actual[3]=tr.clickOnRelease(releaseName);
		     actual[4]=tr.addNode(p_Name1, p_Desc1);
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

	@When("^Add a cycle and phase by launching test planning$")
	public void add_a_cycle_and_phase_by_launching_test_planning() throws Throwable {
		try
		{	  
			    tp=new TestPlanningPage(driver);
		
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 43);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				
				bp.waitForElement();
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,43);
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 43);
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				
				bp.waitForElement();
				actual[6]=rp.clickOnTestPlanning();
				bp.waitForElement();
				actual[7]=tp.clickOnAddTestCycleSymbol();
				actual[8]=tp.CreateCycle(cycle, Build, environ, hide);
				actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				actual[10]=tp.saveTestCycle();
				bp.waitForElement();
				actual[11]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				
				actual[12]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				actual[13]=tp.bulkAssignment(Bulk_Type);
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

	@When("^launch test execution page,to execute testcases$")
	public void launch_test_execution_page_to_execute_testcases() throws Throwable {
		try
		   {
			     /*pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			    tp=new TestPlanningPage(driver);
			    String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2 ,43 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,43 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );   
		
			   bp.waitForElement();
			   actual[14]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			    
			    bp.waitForElement();
				actual[15]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[16]=exep.selectAndDeselectAllTestCase();
			    bp.waitForElement();
			    actual[17]=exep.changeMultiSelectedStatus(statusType1);
			    tp.doubleClickOnCycle(releaseName);
			    pp.clickOnLogout();
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

	@When("^As the lead,launch dashboard page$")
	public void as_the_lead_launch_dashboard_page() throws Throwable {
		try
	    {
	    	dp=new DashBoardPage(driver);
			bp=new BasePage();
			lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
			actual[18]=dp.clickOnManageDashboards();
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
	
	@When("^Add the dashBoard with fields$")
	public void add_the_dashBoard_with_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,39);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[19]=dp.clickOnAddDashBoardSymbol();
			actual[20]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			actual[21]=dp.validateDashBoard(dashboardName);
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

	@When("^Add the execution backlog gadget with detail and save$")
	public void add_the_execution_backlog_gadget_with_detail_and_save() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,39);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 5,6); 
			actual[22]=dp.selectDashboard(dashboardName);
			actual[23]=dp.clickOnAddGadgetSymbol();
			actual[24]=dp.addGadget(gadgetName);
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
	
	@When("^modify last name after saving execution backlog gadget$")
	public void modify_last_name_after_saving_execution_backlog_gadget() throws Throwable {
		try
		{
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1"); 
			String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			String filterByName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,40);
			String[] user=new String[2];
			user[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_1");
			user[1]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_2");
			actual[25]=dp.configureTraceabilityGadget(projectName, release, refreshRate);
			actual[26]=dp.filterBy(filterByName, user);
			bp.waitForElement();
			actual[27]=dp.saveGadget();
			pp=new ProjectPage(driver);
			bp=new BasePage();
			dp=new DashBoardPage(driver);
			pp.clickOnLogout();
			
			 lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_2");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
		     actual[28]=pp.launchAdministration();
		     bp.waitForElement();
			 actual[29]=pp.launchManageUsers();
			 actual[30]=pp.selectUser(userName);
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
	
	@Then("^Should be able to modify last name of a user$")
	public void should_be_able_to_modify_last_name_of_a_user() throws Throwable {
		try
	    {
			String lastName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead2_2");
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,39);
			String lastName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead2_22");
			pp.LastName.clear();
			pp.LastName.sendKeys(lastName);
			bp.waitForElement();
			pp.Save.click();
			bp.waitForElement();
			actual[31]=pp.checkAvailableUser(lastName1);
			pp.clickOnLogout();
			
			lp=new LoginPage(driver);
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		    String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		    String gadgetValue=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,13);
		    lp.enterUname(Uname);
		    lp.enterPass(Pass);
		    lp.clickOnLogin();
		    bp.waitForElement();
			actual[32]=dp.clickOnManageDashboards();
			actual[33]=dp.searchDashboard(dashboardName);
			actual[34]=dp.selectDashboard(dashboardName);
			dp.gadgetOperation(gadgetValue);
			bp.waitForElement();
			actual[35]=pp.clickOnLogout();
			
		     String MUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String MPass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     String userName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead1_2");
		     lp.enterUname(MUname);
		     lp.enterPass(MPass);
		     lp.clickOnLogin();
		     actual[36]=pp.launchAdministration();
		     bp.waitForElement();
			 actual[37]=pp.launchManageUsers();
			 actual[38]=pp.selectUser(lastName1);
			 bp.waitForElement();
		    pp.LastName.clear();
			pp.LastName.sendKeys(userName);
			bp.waitForElement();
			pp.Save.click();
			bp.waitForElement();
			pp.clickOnLogout();
			bp.waitForElement();
			pp.closeBrowser();
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
