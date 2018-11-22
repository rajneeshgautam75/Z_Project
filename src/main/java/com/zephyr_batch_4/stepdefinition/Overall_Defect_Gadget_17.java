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
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Overall_Defect_Gadget_17 extends LaunchBrowser{

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
	String fileName="Overall_Defect_Gadget_17";
	
	boolean[] actual=new boolean[38];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Manager is in a Login page$")
	public void manager_is_in_a_Login_page() throws Throwable {
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

	@Then("^Manager logged in successfully$")
	public void manager_logged_in_successfully() throws Throwable {
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

	@When("^navigate to the Defect Tracking to set DTS to Jira$")
	public void navigate_to_the_Defect_Tracking_to_set_DTS_to_Jira() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[3]=pp.launchAdministration();
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

	@Then("^Jira is set successfully$")
	public void jira_is_set_successfully() throws Throwable {
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

	@When("^As a Lead,create a phase with testcases in testRepository$")
	public void as_a_Lead_create_a_phase_with_testcases_in_testRepository() throws Throwable {
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
		     
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 pp.selectProject(projectName);
		     pp.selectRelease(releaseName);
		     bp.waitForElement();
		     rp.clickOnTestRep();
			 
			 tr=new TestRepositoryPage(driver);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3, 28);
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
				for(int i=0;i<=4;i++)
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

	@When("^Launch TestPlanning,create a cycle$")
	public void launch_TestPlanning_create_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[10]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3, 30);
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

	@When("^add a phase by choosing an existing phase$")
	public void add_a_phase_by_choosing_an_existing_phase() throws Throwable {
		try
	    {
			bp.waitForElement();
			actual[15]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3, 30);
			actual[16]=tp.navigateToCycle(cycle);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3, 28);
			actual[17]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
			bp.waitForElement();
			actual[18]=tp.bulkAssignment(Bulk_Type);
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

	@When("^Launch Test Execution to the execute testcases$")
	public void launch_Test_Execution_to_the_execute_testcases() throws Throwable {
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
			   actual[19]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3 ,30 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3 ,28 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[20]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[21]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[22]=exep.executeStatus(tcNo2[0], statusType2);
			    
			    int[] tcNo3=new int[1];
			    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[23]=exep.executeStatus(tcNo3[0], statusType3);
			    
			    int[] tcNo4=new int[1];
				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
			    bp.waitForElement();
			    actual[24]=exep.executeStatus(tcNo4[0], statusType4);
			    
			    int[] tcNo5=new int[1];
				tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
			    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    actual[25]=exep.executeStatus(tcNo5[0], statusType5);
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

	@Then("^defects linked to executions$")
	public void defects_linked_to_executions() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
			   exep.clickOnDefectButton(testcase1);
			   
			   String defectId1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",11 ,32 );////
			   actual[26]=exep.linkDefect(defectId1);
			   bp.waitForElement();
			   
			   int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2,19 );
			   exep.clickOnDefectButton(testcase2);
			   
			   String defectId2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",12 ,31 );
			   actual[27]=exep.linkDefect(defectId2);
			   bp.waitForElement();
			   
			   int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3,19 );
			   exep.clickOnDefectButton(testcase3);
			   
			   String defectId3=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",13,31 );
			   actual[28]=exep.linkDefect(defectId3);
			   bp.waitForElement();
			   
//			   int testcase4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4,19 );
//			   exep.clickOnDefectButton(testcase4);
//			   
//			   String defectId4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",4 ,31 );
//			   actual[29]=exep.linkDefect(defectId4);
//			   
//			   int testcase5=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,19 );
//			   exep.clickOnDefectButton(testcase5);
//			   
//			   String defectId5=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",5 ,31);
//			   actual[30]=exep.linkDefect(defectId5);
			   
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

	@When("^Launch DashBoard Page$")
	public void launch_DashBoard_Page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			actual[29]=dbp.clickOnManageDashboards();
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

	@Then("^DashBoard window is launched$")
	public void dashboard_window_is_launched() throws Throwable {
		try
		{
			actual[30]=dbp.validateDashboards();
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

	@When("^add a dashboard by clicking on plus symbol$")
	public void add_a_dashboard_by_clicking_on_plus_symbol() throws Throwable {
		try
		{
		actual[31]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 16,16);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[32]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^should be able to select the added dashboard$")
	public void should_be_able_to_select_the_added_dashboard() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 16,16);
			   actual[33]=dbp.selectDashboard(dashboardName);
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

	@When("^add a overall defect gadget by clicking on plus button$")
	public void add_a_overall_defect_gadget_by_clicking_on_plus_button() throws Throwable {
		try
	    {
	    	actual[34]=dbp.clickOnAddGadgetSymbol();
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

	@Then("^overall defect gadget added sucessfully$")
	public void overall_defect_gadget_added_sucessfully() throws Throwable {
		try
		{
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,6); 
			 actual[35]=dbp.addGadget(gadgetName);
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

	@When("^select project,release,referesh rate and save it$")
	public void select_project_release_referesh_rate_and_save_it() throws Throwable {
		try
		{
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[36]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^should show open,to do defect count properly$")
	public void should_show_open_to_do_defect_count_properly() throws Throwable {
		try
		{
			String defectStatusName1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,30);  
			actual[37]=dbp.defectStatusCount(defectStatusName1); 
			//String defectStatusName2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 11,30);  
			actual[37]=dbp.defectStatusCount(defectStatusName1); 
			//actual[37]=dbp.defectSummary();
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
