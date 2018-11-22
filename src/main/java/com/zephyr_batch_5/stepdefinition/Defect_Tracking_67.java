package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_67 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DashBoardPage dp;
	ExportPage ep;
	ExecutionPage exep;
	ExternalJiraPage ejp;
	DefectTracking dt;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_67";
	
	boolean[] actual=new boolean[45];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^User launch Requirements page$")
	public void user_launch_Requirements_page() throws Throwable {
	  try
	  {
		  pp=new ProjectPage(driver);
		  rp= new ReleasePage(driver);
		  bp=new BasePage();
		  dp=new DashBoardPage(driver);
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		  String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1"); 
		  pp.selectProject(projectName);
		   actual[0]=pp.selectRelease(releaseName);
		   bp.waitForElement();
		   actual[1]=rp.clickOnRequirements();
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

	@When("^User add a node with requirements$")
	public void user_add_a_node_with_requirements() throws Throwable {
		try
		   {
			   req=new RequirementsPage(driver);
			   tr=new TestRepositoryPage(driver);
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 8, 12);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
				
				actual[2]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[3]=req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			    actual[4]=tr.navigateToNode(releaseName, str);
			    for(int i=1;i<=4;i++)
			    {
			    req.addRequirement();
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

	@When("^User launch testRepository to create testcase$")
	public void user_launch_testRepository_to_create_testcase() throws Throwable {
		try
		   {
//		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
//			 actual[0]=pp.selectProject(projectName);
//		     actual[1]=pp.selectRelease(releaseName);
		     bp.waitForElement();
		     actual[5]=rp.clickOnTestRep();
		     tr=new TestRepositoryPage(driver);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 7, 12);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
			
			actual[6]=tr.clickOnRelease(releaseName);
			bp.waitForElement();
			actual[7]=tr.addNode(p_Name1,p_Desc1);  
			tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			bp.waitForElement();
			actual[8]=tr.navigateToNode(releaseName, phase);
			for(int i=1;i<=4;i++)
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

	@When("^map testcase to requirement$")
	public void map_testcase_to_requirement() throws Throwable {
		try
		   {
			String[] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16));
			String[] node=new String[1];
			node[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 8,12);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[9]=tr.clickOnDetails();
			bp.waitForElement();
			ep=new ExportPage(driver);
			actual[10]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
			bp.waitForElement();
			actual[11]=req.MapRequirements();
			actual[12]=req.ExpandRelease(releaseName);
			actual[13]=tr.navigateNode(node);
			String[] requirementNum1=new String[2];
			 requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1, 16));
			 requirementNum1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2, 16));
			 actual[14]=tr.selectMultipleRequirementFromGrid(requirementNum1);
			 actual[15]=req.saveJiraRequirement();
	         bp.waitForElement();
			 actual[16]=tr.clickOnList();
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

	@When("^User launch testPlanning to create cycle and add phase to the cycle$")
	public void user_launch_testPlanning_to_create_cycle_and_add_phase_to_the_cycle() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  actual[17]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 7, 13);
				String build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[18]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[19]=tp.CreateCycle(cycle, build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[20]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[21]=tp.saveTestCycle();
				bp.waitForElement();
				
				bp.waitForElement();
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 7, 13);
				actual[22]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 7, 12);
				actual[23]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[24]=tp.bulkAssignment(Bulk_Type);
				
				actual[25]=tp.goBackToCycle();
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

	@When("^User Launch testExecution page to execute testcase$")
	public void user_Launch_testExecution_page_to_execute_testcase() throws Throwable {
		try
		   {
			     /*pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 dt=new DefectTracking(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   actual[26]=rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7 ,13 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7 ,12 );
			    
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
				actual[27]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[28]=exep.executeStatus(tcNo1[0], statusType1);
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

	@Then("^Should be able to execute the testcase$")
	public void should_be_able_to_execute_the_testcase() throws Throwable {
		try
		   {	
				int[] testcase=new int[1];
				testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
			    String status=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[29]=exep.ValidateStatusOfTestCases(testcase, status);
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

	@When("^click on D button to search and link a defect$")
	public void click_on_D_button_to_search_and_link_a_defect() throws Throwable {
		try
		   {
			   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16 );
			   String defectID1=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,7 );
			   String defectID2=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,7 );
			   String defectID3=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",5,7 );
			   actual[30]=exep.clickOnDefectButton(testcase1);
			   bp.waitForElement();
			   exep.searchDefect(defectID1);
			   actual[31]=exep.linkDefect();	
			   bp.waitForElement();
			   exep.clickOnDefectButton(testcase1);
			   exep.searchDefect(defectID2);
			   actual[32]=exep.linkDefect();
			   bp.waitForElement();
			   exep.clickOnDefectButton(testcase1);
			   exep.searchDefect(defectID3);
			   actual[33]=exep.linkDefect();
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

	@Then("^Should be able to link defect to executions$")
	public void should_be_able_to_link_defect_to_executions() throws Throwable {
		try
		   {	
				int testCase=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[34]=exep.viewTooltip(testCase);
			    bp.waitForElement();
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
				tp.doubleClickOnCycle(releaseName);
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

	@When("^User Launch DashBoard$")
	public void user_Launch_DashBoard() throws Throwable {
		try
	    {
	    	dp=new DashBoardPage(driver);
			bp=new BasePage();
			pp=new ProjectPage(driver);
			actual[35]=dp.clickOnManageDashboards();
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

	@When("^Create a Dashboard by the required fields$")
	public void create_a_Dashboard_by_the_required_fields() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,49);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[36]=dp.clickOnAddDashBoardSymbol();
			actual[37]=dp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^Should be able to create dashboard$")
	public void should_be_able_to_create_dashboard() throws Throwable {
		try
		{
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,49);
			actual[38]=dp.validateDashBoard(dashboardName);
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

	@When("^Add open defect gadget$")
	public void add_open_defect_gadget() throws Throwable {
		try
	    {
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,49);
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,6); 
			actual[39]=dp.selectDashboard(dashboardName);
			actual[40]=dp.clickOnAddGadgetSymbol();
			actual[41]=dp.addGadget(gadgetName);
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

	@Then("^Should be able to add open defect gadget$")
	public void should_be_able_to_add_open_defect_gadget() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8);
			 actual[42]=dp.configureTestAutomationStatusGadget(projectName, release, refreshRate);	 
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

	@When("^View the total defect count and count by priority$")
	public void view_the_total_defect_count_and_count_by_priority() throws Throwable {
		try
	    {
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1"); 
			 actual[43]=dp.validateSavedGadget(projectName, releaseName);
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

	@Then("^Should be able to show proper count by priority$")
	public void should_be_able_to_show_proper_count_by_priority() throws Throwable {
		try
	    {
			String defectStatusName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,50);
			actual[44]=dp.validateOpenDefect(defectStatusName);
			bp.waitForElement();
			pp.backToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
			{
				System.out.println("Actual["+k+"]="+actual[k]);
				//soft.assertEquals(actual[k], true);
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
