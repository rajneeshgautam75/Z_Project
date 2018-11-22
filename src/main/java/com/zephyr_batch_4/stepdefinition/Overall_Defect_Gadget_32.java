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
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Overall_Defect_Gadget_32 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	ExternalJiraPage ejp;
	String fileName="Overall_Defect_Gadget_32";
	
	boolean[] actual=new boolean[40];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Manager is in a login page$")
	public void manager_is_in_a_login_page() throws Throwable {
		try
	    {
			bp=new BasePage();
			pp=new ProjectPage(driver);
			pp.clickOnLogout();
			lp=new LoginPage(driver);
		 	 
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     actual[0]=lp.enterUname(Uname);
		     actual[1]=lp.enterPass(Pass);
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

	@Then("^Manager logged in to the application successfully$")
	public void manager_logged_in_to_the_application_successfully() throws Throwable {
		try
		   {
			   actual[2]=lp.clickOnLogin();
			   lp.verifyLoginTitle();
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

	@When("^Launch the Administration page$")
	public void launch_the_Administration_page() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[3]=pp.launchAdministration();
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

	@When("^navigate to defect tracking to set the DTS$")
	public void navigate_to_defect_tracking_to_set_the_DTS() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[4]=pp.clickOnDefectTracking();
			   
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

	@Then("^successfully set the Jira$")
	public void successfully_set_the_Jira() throws Throwable {
		try
		   {
			 String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
			 String url=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 26);
			 String username=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 24);
			 String password=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 25);
			 actual[5]=pp.setDTS(DTS, url, username, password);
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

	@When("^As Lead,add testcases in testRepository$")
	public void as_Lead_add_testcases_in_testRepository() throws Throwable {
		try
		   {
			 bp=new BasePage();
			 pp=new ProjectPage(driver);
			 pp.clickOnLogout();
			 pp.closeBrowser();
			 lb=new LaunchBrowser();
		 	 lb.preCond();
		 	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"URL");
		 	 lb.getUrl(url);
		 	 lp=new LoginPage(driver);
		 	 pp=new ProjectPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
		     rp=new ReleasePage(driver);
		     
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);
		     bp.waitForElement();
		     rp.clickOnTestRep();
			 
			 tr=new TestRepositoryPage(driver);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 28);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 29);
				
				actual[6]=tr.clickOnRelease(releaseName);
				 bp.waitForElement();
				actual[7]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				actual[8]=tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[9]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
			 
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

	@When("^Launch TestPlanning to create the cycle$")
	public void launch_TestPlanning_to_create_the_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[10]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 30);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[11]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[12]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[14]=tp.saveTestCycle();
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

	@When("^Add phase to a cycle by choosing an existing phase and assign testcases to anyone$")
	public void add_phase_to_a_cycle_by_choosing_an_existing_phase_and_assign_testcases_to_anyone() throws Throwable {
		try
	    {	
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 30);
			actual[15]=tp.navigateToCycle(cycle);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2, 28);
			actual[16]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[17]=tp.bulkAssignment(Bulk_Type);
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

	@When("^Launch TestExecution to the execute testcases$")
	public void launch_TestExecution_to_the_execute_testcases() throws Throwable {
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
			   actual[18]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2 ,30 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2 ,28 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
				actual[19]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[20]=exep.executeStatus(tcNo1[0], statusType1);
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

	@Then("^able to link the defects$")
	public void able_to_link_the_defects() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
			   actual[21]=exep.clickOnDefectButton(testcase1);
			   bp.waitForElement();
			   String defectId1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",11 ,32 );
			   actual[22]=exep.linkDefect(defectId1);	
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

	@When("^launch DashBoard page$")
	public void launch_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[23]=dbp.clickOnManageDashboards();
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

	@Then("^dashboard window launches$")
	public void dashboard_window_launches() throws Throwable {
		try
		{
			actual[24]=dbp.validateDashboards();
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

	@When("^add a dashboard by clicking on the plus symbol$")
	public void add_a_dashboard_by_clicking_on_the_plus_symbol() throws Throwable {
		try
		{
		actual[25]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15,16);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[26]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^select the added dashboard$")
	public void select_the_added_dashboard() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15,16);
			   actual[27]=dbp.selectDashboard(dashboardName);
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
			}    	}

	@When("^add overall defect gadget by clicking on plus button$")
	public void add_overall_defect_gadget_by_clicking_on_plus_button() throws Throwable {
		try
	    {
	    	actual[28]=dbp.clickOnAddGadgetSymbol();
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

	@Then("^gadget added successFully$")
	public void gadget_added_successFully() throws Throwable {
		try
		{
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,6); 
			 actual[29]=dbp.addGadget(gadgetName);
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

	@When("^Configure the gadget by entering the details$")
	public void configure_the_gadget_by_entering_the_details() throws Throwable {
		try
		{
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[30]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^shown defect count should be one$")
	public void shown_defect_count_should_be_one() throws Throwable {
		try
		{
			 dbp.linkCountInGadgetPage();
			 String defectStatusName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,30);
			 actual[31]=dbp.defectStatusCount(defectStatusName);
			 
			 pp.backToProjectPage();
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

	@When("^navigate to Defect Tracking to change status$")
	public void navigate_to_Defect_Tracking_to_change_status() throws Throwable {
		try
		{
			 pp=new ProjectPage(driver);
		     dbp=new DashBoardPage(driver);
		     exep=new ExecutionPage(driver);
		     ejp=new ExternalJiraPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_5");
			 String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_6");
		     pp.selectProject(projectName1);
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);
			 actual[32]=pp.clickOnDefectTracking();
			 
			 String defectID=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,32);
			 actual[33]=dbp.searchAndSelectDefect(defectID);
//			 exep.searchDefect(defectID);
//			 exep.searchedDefect.click();
			   
			   bp=new BasePage();
			   bp.switchWindowTab(1);
			   String username=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,24);
			   System.out.println(username);
			   String password=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,25);
			   System.out.println(password);
			   actual[34]=ejp.loginToExternalJira(username,password);
			 
//			 String username=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,24);
//			 System.out.println(username);
//			 String password=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,25);
//			 System.out.println(password);
//			 actual[33]=exep.loginToExternalJira(username, password);
			 
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

	@Then("^status changed successfully$")
	public void status_changed_successfully() throws Throwable {
		try
		{
			String statusType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,30);  
			actual[35]=ejp.changeDefectStatusInExternalJira(statusType);
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			bp.waitForElement();
			ejp=new ExternalJiraPage(driver);
			ejp.logOutFromExternal_JIRA();
			driver.close();
			//bp.switchWindowTab(0);
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

	@When("^navigate to dashBoard view overall defect gadget$")
	public void navigate_to_dashBoard_view_overall_defect_gadget() throws Throwable {
		try
	    {

			bp=new BasePage();
			bp.switchWindowTab(0);
			actual[36]=dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 15,16);
			actual[37]=dbp.searchDashboard(dashboardName);
			actual[38]=dbp.selectDashboard(dashboardName);
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

	@Then("^display the defect count and inprogress count$")
	public void display_the_defect_count_and_inprogress_count() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			dbp.linkCountInGadgetPage();
			String defectStatusName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 12,30);
			actual[39]=dbp.defectStatusCount(defectStatusName);
		
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				soft.assertEquals(actual[k], true);
			}
			soft.assertAll();
			pp.backToProjectPage();
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
