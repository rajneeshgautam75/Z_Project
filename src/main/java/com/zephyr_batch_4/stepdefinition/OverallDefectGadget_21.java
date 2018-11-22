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

public class OverallDefectGadget_21 extends LaunchBrowser 
{
	LaunchBrowser lb;
    ProjectPage pp;
    LoginPage lp;
   ReleasePage rp;
   TestRepositoryPage tr;
   TestPlanningPage tp;
   ExecutionPage exe;
   DashBoardPage db;
   BasePage bp;
	
   boolean[] actual=new boolean[48];
	SoftAssert soft=new SoftAssert();
   String fileName="OverallDefectGadget_21";
   
   
   @Given("^Login as manager Role$")
   public void login_as_manager_Role() throws Throwable {
		try
		{
			bp=new BasePage();
		pp=new ProjectPage(driver);
		lp=new LoginPage(driver);
		
		String uName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");	
		
		bp.waitForElement();
		actual[0]=pp.clickOnLogout();
		actual[1]=lp.enterUnameAndPassword(uName, passWord);
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



	@When("^manager set DTS to Jira$")
	public void manager_set_DTS_to_Jira() throws Throwable {
	 try
	 {
//		String dtsType=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 1);
//	  
//	  
//	  String url=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 2);
//	  String userName=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 3);
//	  String password=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 4);
//		
//	  pp.launchAdministration();
//	  bp.waitForElement();
//	  pp.clickOnDefectTracking();
//	  bp.waitForElement();
//	  
//	  pp.setDTS(dtsType, url, userName, password);
	  
	  
	   
	 // pp.setDTS(dtsType, url, userName, password);
	  String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
	  actual[2]=pp.selectProject(project);
	  actual[3]=pp.selectRelease(release);
	  
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

	@When("^user launch test repository page$")
	public void user_launch_test_repository_page() throws Throwable {
	  
		try
		{
		rp=new ReleasePage(driver);
		actual[4]=rp.clickOnTestRep();
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

	@When("^add a phase with name and description$")
	public void add_a_phase_with_name_and_description() throws Throwable {
	  
		try
		{
			  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
		tr=new TestRepositoryPage(driver);
		String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 5);
		String phaseDesc=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 6);
		actual[5]=tr.clickOnRelease(release);
		actual[6]=tr.addNode(phaseName, phaseDesc);
	
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

	@Then("^phase should be added successfully$")
	public void phase_should_be_added_successfully() throws Throwable {
		try
		{
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
		String[] phase=new String[1];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 5);
		
		actual[7]=tr.navigateToNode(releaseName, phase);
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

	@When("^user add multiple\\(five\\) testcases$")
	public void user_add_multiple_five_testcases() throws Throwable {
	 try
	 {
		for(int i=0;i<=4;i++)
	  {
			actual[8]=tr.addTestCase();
		
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

	@Then("^multiple testcases should be added to the phase$")
	public void multiple_testcases_should_be_added_to_the_phase() throws Throwable {
	  
		try
		{
			actual[9]=tr.verifyPresentTestCase();
		
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

	@When("^user launch test planning module$")
	public void user_launch_test_planning_module() throws Throwable {
	  
		try
		{
		
			actual[10]=rp.clickOnTestPlanning();
		
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

	@When("^create a test cycle and assign it$")
	public void create_a_test_cycle_and_assign_it() throws Throwable {
	  
		try
		{
			tp=new TestPlanningPage(driver);
		String cycleName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 7);
		String build=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 8);
		String environment=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 9);
		
		String hide=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 10);
		String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 11));
		String smonth=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 12);
		String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 13));
		String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 14));
		String emonth=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 15);
		
		String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 16));
		
		String phaseName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 5);
		String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_1");
		actual[11]=tp.clickOnAddTestCycleSymbol();
		actual[12]=tp.CreateCycle(cycleName, build, environment, hide);
		actual[13]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
		actual[14]=tp.saveTestCycle();
		
		actual[15]=tp.doubleClickOnCycle(cycleName);
		actual[16]=tp.addPhaseToCycle(phaseName);
		actual[17]=tp.cancelBulkAssign();
		actual[18]=tp.doubleClickOnCycle(phaseName);
		actual[19]=tp.selectallTestCase();
		actual[20]=tp.assignAllSelected(assignee);
		
		//rp.clickOnTestPlanning();
		
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

	@Then("^testcases assigned to the user$")
	public void testcases_assigned_to_the_user() throws Throwable {
	   
		try
		{
		int[] testcase=new int[5];
		String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_1");
		for(int i=0;i<=testcase.length-1;i++)
		{
			testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", i+1, 17);	
		}
		
		
		
		actual[21]=tp.validateAllAssigned(testcase, assignee);
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

	@When("^user launch test execution and navigate to phase$")
	public void user_launch_test_execution_and_navigate_to_phase() throws Throwable {
	 
		try
		{
		exe=new ExecutionPage(driver);
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_2");
		String[] phase=new String[2];
		phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 7);
		phase[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 5);
		
		actual[22]=rp.clickOnTestExecution();
		
		actual[23]=tr.navigateToNode(releaseName, phase);
		
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

	@When("^execute the testcases to status Pass/Fail/WIP/Blocked/Custom$")
	public void execute_the_testcases_to_status_Pass_Fail_WIP_Blocked_Custom() throws Throwable {
	   
		try
		{
		int[] testcase=new int[5];
		
		for(int i=0;i<=testcase.length-1;i++)
		{
			testcase[i]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", i+1,17);	
			String statusType=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", i+1, 18);	
			actual[24]=exe.executeStatus(testcase[i], statusType);
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

	@Then("^successfullly executed the testcases to Pass/Fail/WIP/Blocked/Custom status$")
	public void successfullly_executed_the_testcases_to_Pass_Fail_WIP_Blocked_Custom_status() throws Throwable {
		
		try
		{
		int[] testcase1=new int[1];
		testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 17);
		String[] statusType=new String[5];
		
		for(int i=0;i<=statusType.length-1;i++)
		{
				
		 statusType[i]=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", i+1, 18);
			
	    
		}
		
		actual[25]= exe.ValidateStatusOfTestCases(testcase1, statusType[0]);
		 int[] testcase2=new int[1];
			testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 2, 17);
			actual[26]=exe.ValidateStatusOfTestCases(testcase2, statusType[1]);
		 
		 int[] testcase3=new int[1];
			testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 3, 17);
			actual[27]=exe.ValidateStatusOfTestCases(testcase3, statusType[2]);
		 
		 int[] testcase4=new int[1];
			testcase4[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 4, 17);
			actual[28]=exe.ValidateStatusOfTestCases(testcase4, statusType[3]);
		 
		 int[] testcase5=new int[1];
			testcase5[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 5, 17);
			actual[29]= exe.ValidateStatusOfTestCases(testcase5, statusType[4]);
		 
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

	@When("^user selects first testcase and link defects with Open$")
	public void user_selects_first_testcase_and_link_defects_with_Open() throws Throwable {
		try
		{
		int [] testcase1=new int[1];
		testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 17);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 20);
		
		actual[30]=exe.clickOnDefectButton(testcase1[0]);
		actual[31]=exe.linkDefect(defectId);
		
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

	@Then("^defect should be linked with status Open$")
	public void defect_should_be_linked_with_status_Open() throws Throwable {
		try
		{
		int [] testcase1=new int[1];
		testcase1[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 1, 17);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 1, 20);
		actual[32]=exe.validateLinkedDefect(testcase1[0], defectId);
		
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

	@When("^user selects second testcase and link defects with Inprogress$")
	public void user_selects_second_testcase_and_link_defects_with_Inprogress() throws Throwable {
		try
		{
		int [] testcase2=new int[1];
		testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 2, 17);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 4, 20);
		
		actual[33]=exe.clickOnDefectButton(testcase2[0]);
		actual[34]=exe.linkDefect(defectId);
		
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

	@Then("^defect should be linked with status Inprogress$")
	public void defect_should_be_linked_with_status_Inprogress() throws Throwable {
		try
		{
		int [] testcase2=new int[1];
		testcase2[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 2, 17);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 4, 20);
		actual[35]=exe.validateLinkedDefect(testcase2[0], defectId);
		
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

	@When("^user selects third testcase and link defects with Done$")
	public void user_selects_third_testcase_and_link_defects_with_Done() throws Throwable {
		try
		{
		int [] testcase3=new int[1];
		testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 3, 17);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 7, 20);
		
		actual[36]=exe.clickOnDefectButton(testcase3[0]);
		actual[37]=exe.linkDefect(defectId);
		
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

	@Then("^defect should be linked with status Done$")
	public void defect_should_be_linked_with_status_Done() throws Throwable {
	    
		try
		{
		int [] testcase3=new int[1];
		testcase3[0]=Excel_Lib.getNumberData(INPUT_PATH_2, "OverallDefect", 3, 17);
		String defectId=Excel_Lib.getData(INPUT_PATH_2, "OverallDefect", 7, 20);
		actual[38]=exe.validateLinkedDefect(testcase3[0], defectId);
		
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

	@When("^user launch dashboard$")
	public void user_launch_dashboard() throws Throwable {
	   
		try
		{
		db=new DashBoardPage(driver);
		actual[39]=db.clickOnManageDashboards();
		
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

	@Then("^dashboard page should be displayed$")
	public void dashboard_page_should_be_displayed() throws Throwable {

		try
		{
			actual[40]= db.validateDashboards();
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

	@When("^user Add dashboard by clicking on add symbol button$")
	public void user_Add_dashboard_by_clicking_on_add_symbol_button() throws Throwable {
		try
		{
		String dashName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 2);
		String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 3);
		String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 4);
		actual[41]=db.clickOnAddDashBoardSymbol();
		actual[42]=db.enterDashBoardDetails(dashName, desc, layout, shareType);
		
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

	@Then("^dash_board should be created successfully$")
	public void dash_board_should_be_created_successfully() throws Throwable {
		try
		{
		String dashName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 1);
		actual[43]=db.validateDashBoard(dashName);
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

	@When("^user selects dashboard and add Overall Defects Gadget by clicking on add symbol button$")
	public void user_selects_dashboard_and_add_Overall_Defects_Gadget_by_clicking_on_add_symbol_button() throws Throwable {
	    try
	    {
	    	
	    	String dashName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 1);
	    	
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 5);
		db.selectDashboard(dashName);
		actual[44]=db.clickOnAddGadgetSymbol();
		actual[45]=db.addGadget(gadgetName);
		
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

	
	
	
	@Then("^Should be able to Add overall Defect Gadget$")
	public void should_be_able_to_Add_overall_Defect_Gadget() throws Throwable {
		try
		{
		String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 15, 5);
		actual[46]=db.validateGadget(gadgetName);
		
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

	

	@When("^user selects project, release and refresh rate,save it$")
	public void user_selects_project_release_and_refresh_rate_save_it() throws Throwable {
		
		try
		{
		 String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
		  String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_2");
		  String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard",15 , 6);
		  actual[47]=db.configureTestAutomationStatusGadget(project, release, refreshRate);
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

	@Then("^Should show total defect count and count by status properly$")
	public void should_show_total_defect_count_and_count_by_status_properly() throws Throwable {
	   try
	   {
		 db.linkCountInGadgetPage();
		 
		 pp.backToProjectPage();
		 for(int k=0;k<=actual.length-1;k++)
			{
				//System.out.println("Actual["+k+"]="+actual[k]);
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
