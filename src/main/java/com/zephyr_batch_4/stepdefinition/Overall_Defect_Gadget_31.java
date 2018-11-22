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

public class Overall_Defect_Gadget_31 extends LaunchBrowser{

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
	String fileName="Overall_Defect_Gadget_31";
	
	boolean[] actual=new boolean[50];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Manager is in log in page$")
	public void manager_is_in_log_in_page() throws Throwable {
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

	@Then("^Manager successfully logged in$")
	public void manager_successfully_logged_in() throws Throwable {
		try
		   {
			   actual[2]=lp.clickOnLogin();
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

	@When("^Launch administration page$")
	public void launch_administration_page() throws Throwable {
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

	@When("^navigate to defect tracking page to set DTS$")
	public void navigate_to_defect_tracking_page_to_set_DTS() throws Throwable {
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

	@Then("^JIRA is set successfully$")
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

	@When("^As Lead,add testcases in TestRepository$")
	public void as_Lead_add_testcases_in_TestRepository() throws Throwable {
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
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 28);
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

	@When("^Launch TestPlanning to create a cycle$")
	public void launch_TestPlanning_to_create_a_cycle() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[10]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 30);
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

	@When("^Add phase to cycle by choosing an existing phase and assign testcases to anyone$")
	public void add_phase_to_cycle_by_choosing_an_existing_phase_and_assign_testcases_to_anyone() throws Throwable {
		try
	    {
			actual[15]=bp.waitForElement();
			//actual[15]=rp.clickOnTestPlanning();
			
	    	String[] cycle=new String[1];
			cycle[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 30);
			actual[16]=tp.navigateToCycle(cycle);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 28);
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

	@When("^Launch TestExecution to execute testcases$")
	public void launch_TestExecution_to_execute_testcases() throws Throwable {
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
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,30 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,28 );
		    
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

	@Then("^link the defects to testcases$")
	public void link_the_defects_to_testcases() throws Throwable {
	   try
	   {
		   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
		   exep.clickOnDefectButton(testcase1);
		   
		   String defectId1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,31 );
		   actual[26]=exep.linkDefect(defectId1);
		   
		   int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2,19 );
		   exep.clickOnDefectButton(testcase2);
		   
		   String defectId2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2 ,31 );
		   actual[27]=exep.linkDefect(defectId2);
		   
		   int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3,19 );
		   exep.clickOnDefectButton(testcase3);
		   
		   String defectId3=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",3,31 );
		   actual[28]=exep.linkDefect(defectId3);
		   
		   int testcase4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4,19 );
		   exep.clickOnDefectButton(testcase4);
		   
		   String defectId4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",4 ,31 );
		   actual[29]=exep.linkDefect(defectId4);
		   
		   int testcase5=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,19 );
		   exep.clickOnDefectButton(testcase5);
		   
		   String defectId5=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",5 ,31);
		   actual[30]=exep.linkDefect(defectId5);
		   
		  
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

	@When("^Launch DashBoard page$")
	public void launch_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[31]=dbp.clickOnManageDashboards();
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

	@Then("^should launch dashBoard window$")
	public void should_launch_dashBoard_window() throws Throwable {
		try
		{
			actual[32]=dbp.validateDashboards();
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

	@When("^add dashboard by clicking on plus button$")
	public void add_dashboard_by_clicking_on_plus_button() throws Throwable {
		try
		{
		actual[33]=dbp.clickOnAddDashBoardSymbol();
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

	@When("^create a dashBoard$")
	public void create_a_dashBoard() throws Throwable {
		try
		{
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,16);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[34]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^added dashBoard selected successfully$")
	public void added_dashBoard_selected_successfully() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,16);
			   actual[35]=dbp.selectDashboard(dashboardName);
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

	@When("^add overall defect gadget by click on add gadget symbol$")
	public void add_overall_defect_gadget_by_click_on_add_gadget_symbol() throws Throwable {
		try
	    {
	    	actual[36]=dbp.clickOnAddGadgetSymbol();
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

	@Then("^Overall Defect gadget added successfully$")
	public void overall_Defect_gadget_added_successfully() throws Throwable {
		try
		{
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,6); 
			 actual[37]=dbp.addGadget(gadgetName);
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

	@When("^configure the gadget by entering the details$")
	public void configure_the_gadget_by_entering_the_details() throws Throwable {
		try
		{
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[38]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
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

	@Then("^should be able to show the defect count to five$")
	public void should_be_able_to_show_the_defect_count_to_five() throws Throwable {
		try
		{
//			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,6); 
//			 actual[40]=dbp.addGadget(gadgetName);
			 dbp.linkCountInGadgetPage();
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

	@When("^launch test execution and link five more defects$")
	public void launch_test_execution_and_link_five_more_defects() throws Throwable {
		 try
		   {
			 pp=new ProjectPage(driver);
			 bp=new BasePage();
			 rp=new ReleasePage(driver);
			 tr=new TestRepositoryPage(driver);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			 String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
		     pp.backToProjectPage();
		     pp.selectProject(projectName1);
			 actual[39]=pp.selectProject(projectName);
		     pp.selectRelease(releaseName);
			 
			   bp.waitForElement();
			   actual[40]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    //cycleName[0]=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,30 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,28 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
				actual[41]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
//				int[] tcNo1=new int[1];
//				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
//			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
//			    bp.waitForElement();
//			    exep=new ExecutionPage(driver);
//			    actual[21]=exep.executeStatus(tcNo1[0], statusType1);
//			    
//			    int[] tcNo2=new int[1];
//				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
//			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
//			    bp.waitForElement();
//			    exep=new ExecutionPage(driver);
//			    actual[22]=exep.executeStatus(tcNo2[0], statusType2);
//			    
//			    int[] tcNo3=new int[1];
//			    tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
//			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
//			    bp.waitForElement();
//			    exep=new ExecutionPage(driver);
//			    actual[23]=exep.executeStatus(tcNo3[0], statusType3);
//			    
//			    int[] tcNo4=new int[1];
//				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
//			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
//			    bp.waitForElement();
//			    actual[24]=exep.executeStatus(tcNo4[0], statusType4);
//			    
//			    int[] tcNo5=new int[1];
//				tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
//			    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
//			    bp.waitForElement();
//			    actual[25]=exep.executeStatus(tcNo5[0], statusType5);
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

	@Then("^should be able to link defect to executions$")
	public void should_be_able_to_link_defect_to_executions() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
			   exep=new ExecutionPage(driver);
			   exep.clickOnDefectButton(testcase1);
			   
			   String defectId1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",6 ,31 );
			   actual[42]=exep.linkDefect(defectId1);
			   
			   int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2,19 );
			   exep.clickOnDefectButton(testcase2);
			   
			   String defectId2=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",7 ,31 );
			   actual[43]=exep.linkDefect(defectId2);
			   
			   int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3,19 );
			   exep.clickOnDefectButton(testcase3);
			   
			   String defectId3=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",8,31 );
			   actual[44]=exep.linkDefect(defectId3);
			   
			   int testcase4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4,19 );
			   exep.clickOnDefectButton(testcase4);
			   
			   String defectId4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",9 ,31 );
			   actual[45]=exep.linkDefect(defectId4);
			   
			   int testcase5=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5,19 );
			   exep.clickOnDefectButton(testcase5);
			   
			   String defectId5=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",10 ,31);
			   actual[46]=exep.linkDefect(defectId5);
			  
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

	@When("^view overall defect gadget after linking the defects$")
	public void view_overall_defect_gadget_after_linking_the_defects() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[47]=dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 14,16);
			actual[48]=dbp.searchDashboard(dashboardName);
			actual[49]=dbp.selectDashboard(dashboardName);
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

	@Then("^should be able to show the updated defect count to ten$")
	public void should_be_able_to_show_the_updated_defect_count_to_ten() throws Throwable {
		try
	    {
			dbp.linkCountInGadgetPage();
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
