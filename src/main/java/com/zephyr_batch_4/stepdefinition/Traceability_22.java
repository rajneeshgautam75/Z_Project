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
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Traceability_22 extends LaunchBrowser{

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
	RequirementsPage req;
	String fileName="Traceability_22";
	
	boolean[] actual=new boolean[76];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^As Lead,Launch the Requirements and create requirement$")
	public void as_Lead_Launch_the_Requirements_and_create_requirement() throws Throwable {
		try
	    {
	    	   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   pp=new ProjectPage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnRequirements();
			   
			   req=new RequirementsPage(driver);
			   tr=new TestRepositoryPage(driver);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 24, 14);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
				
				actual[3]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[4]=req.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			    actual[5]=tr.navigateToNode(releaseName, str);
			    req.addRequirement();
			    req.addRequirement();
			    
			    String[] requirementNum1=new String[1];
			    requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			    tr.clickOnDetails();
			    req.selectMultipleRequirementFromGrids(requirementNum1);
			  
			    String name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"DashBoards",22,34);
		    	String altID=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String link=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String priority=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
		    	String Description=Excel_Lib.getData(INPUT_PATH_3,"DashBoards",100,100);
			    actual[6]=req.enterRequirementDetails(name1, altID, link, priority, Description);
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

	@When("^Launch testRepository and create testcases$")
	public void launch_testRepository_and_create_testcases() throws Throwable {
		try
		   {
			   bp.waitForElement();
			   actual[7]=rp.clickOnTestRep();
			   
			   tr=new TestRepositoryPage(driver);
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 25, 14);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 36);
				
				actual[8]=tr.clickOnRelease(releaseName);
				bp.waitForElement();
				actual[9]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
			    String[] str=new String[1];
			    str[0]=p_Name1;
			    actual[10]=tr.navigateToNode(releaseName, str);
			    tr.addTestCase();
			    tr.addTestCase();
			  
			    ep=new ExportPage(driver);
			    String[] testCaseNo=new String[1];
			    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			    tr.clickOnDetails();
			    actual[11]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
			    req.MapRequirements(); 
				 actual[12]=req.ExpandRelease(releaseName);
				 String[] str1=new String[1];
				 str1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 24, 14);
				 actual[13]=tr.navigateNode(str1);
				 String[] requirementNum1=new String[2];
				 requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
				 requirementNum1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 2, 15));
				 actual[14]=tr.selectMultipleRequirementFromGrid(requirementNum1);
				 actual[15]=req.saveJiraRequirement();
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
	
	@When("^Launch Test Planning,create a cycle and add a phase$")
	public void launch_Test_Planning_create_a_cycle_and_add_a_phase() throws Throwable {
		try
		   {
			  bp.waitForElement();
			  actual[16]=rp.clickOnTestPlanning();
			  
			    tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22, 30);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[17]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[18]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				bp.waitForElement();
				actual[19]=tp.saveTestCycle();
				bp.waitForElement();
				
				bp.waitForElement();
				rp.clickOnTestPlanning();
				
		    	String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22, 30);
				tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 25, 14);
				actual[20]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[21]=tp.bulkAssignment(Bulk_Type);
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

	@When("^Launch test execution and execute testcase$")
	public void launch_test_execution_and_execute_testcase() throws Throwable {
		try
		   {
			    /* pp=new ProjectPage(driver);//
				 bp=new BasePage();
				 rp=new ReleasePage(driver);
				 tr=new TestRepositoryPage(driver);
				 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			     String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
				 pp.selectProject(projectName);
			     pp.selectRelease(releaseName);// */
			   
			   bp.waitForElement();
			   rp.clickOnTestExecution(); 
	           bp.waitForElement();
			   
			   String[] cycleName=new String[2];
			    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",22 ,30 );
			    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards",25 ,14 );
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
				actual[22]=tr.navigateToNode(releaseName, cycleName);
				bp.waitForElement();
			
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[23]=exep.executeStatus(tcNo1[0], statusType1);
			    
			    
			    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1,19 );
				actual[24]=exep.clickOnDefectButton(testcase1);
				   
				  String defectId1=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",1 ,31 );
				  actual[25]=exep.linkDefect(defectId1);
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

	@When("^Launch DashBoard page and create DashBoard$")
	public void launch_DashBoard_page_and_create_DashBoard() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
	    	pp=new ProjectPage(driver);
	    	rp=new ReleasePage(driver);
	    	tp=new TestPlanningPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			actual[26]=dbp.clickOnManageDashboards();
			actual[27]=dbp.clickOnAddDashBoardSymbol();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 23,30);
			String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
			String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
			String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
			actual[28]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
			
			//String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 17,30);
	    	actual[29]=dbp.selectDashboard(dashboardName);
	    	
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

	@When("^add traceability gadget by clicking on gadget plus symbol$")
	public void add_traceability_gadget_by_clicking_on_gadget_plus_symbol() throws Throwable {
	  try
	  {
		  actual[30]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[31]=dbp.addGadget(gadgetName);
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

	@When("^configure the traceability gadget and save$")
	public void configure_the_traceability_gadget_and_save() throws Throwable {
	  try
	  {
		  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[32]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 for(int i=0;i<=3;i++)
			 {
				 bp.waitForElement();
			 }
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
			 actual[33]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 actual[34]=dbp.saveGadget();
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

	@Then("^traceability gadget added successfully$")
	public void traceability_gadget_added_successfully() throws Throwable {
		 try
		  {
			  String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			  actual[35]=dbp.validateGadget(gadgetName);
			  
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

	@When("^delete the selected release from release setup after saving traceability gadget$")
	public void delete_the_selected_release_from_release_setup_after_saving_traceability_gadget() throws Throwable {
		try
		  {
			  String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			  String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_4");
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
			   pp.backToProjectPage();
			   pp.selectProject(projectName1);
			   actual[36]=pp.deleteRelease(projectName, releaseName);
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

	@Then("^traceability gadget should update with new data$")
	public void traceability_gadget_should_update_with_new_data() throws Throwable {
		try
	    {
	    	dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 23,30);
	    	actual[37]=dbp.searchDashboard(dashboardName);
	    	dbp.selectDashboard(dashboardName);
//	    	actual[38]=dbp.clickOnAddGadgetSymbol();
			String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13); 
			actual[38]=dbp.gadgetOperation(value);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[39]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 actual[40]=dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 //String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13); 
		     dbp.gadgetOperation(value);
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22,34);
			 actual[41]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 actual[42]=dbp.saveGadget();
			// pp.clickOnLogout();
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

	@When("^delete the selected project from project setup after saving traceability gadget$")
	public void delete_the_selected_project_from_project_setup_after_saving_traceability_gadget() throws Throwable {
	   try
	   {
		   lp=new LoginPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass); 
		     lp.clickOnLogin();
		     
		     pp.launchAdministration();
		     pp.launchManageprojects();
		     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
		     pp.DeleteProject(projectName);
		    // pp.clickOnLogout();
		     
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

	@Then("^traceability gadget should update with a new data$")
	public void traceability_gadget_should_update_with_a_new_data() throws Throwable {
		try
	    {
//			lp=new LoginPage(driver);
//		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
//		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
//		     lp.enterUname(Uname);
//		     lp.enterPass(Pass);
//		     lp.clickOnLogin();
			
			dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 23,30);
	    	actual[45]=dbp.searchDashboard(dashboardName);
	    	dbp.selectDashboard(dashboardName);
//	    	actual[46]=dbp.clickOnAddGadgetSymbol();
//			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
//			actual[47]=dbp.addGadget(gadgetName);
	    	String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13); 
			dbp.gadgetOperation(value);
	    	
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[48]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.gadgetOperation(value);
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22,34);
			 actual[49]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 actual[50]=dbp.saveGadget();
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

	@When("^delete selected requirement from project setup after saving traceability gadget$")
	public void delete_selected_requirement_from_project_setup_after_saving_traceability_gadget() throws Throwable {
	  try
	  {
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
		   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
		   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
		   pp.backToProjectPage();
		   pp.selectProject(projectName1);
		   actual[43]=pp.selectProject(projectName);
		   actual[44]=pp.selectRelease(releaseName);
		   rp= new ReleasePage(driver);
		   tr=new TestRepositoryPage(driver);
		   bp.waitForElement();
		   actual[45]=rp.clickOnRequirements();
		   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 24, 14);
		   String[] str=new String[1];
		    str[0]=p_Name1;
		   actual[46]=tr.navigateToNode(releaseName, str);
		   String[] requirementNum1=new String[1];
		   requirementNum1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
		   req.selectMultipleRequirementFromGrids(requirementNum1);
		   String type=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4, 13);
		   actual[47]=req.deleteOrDeallocateRequirements(type);;
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

	@Then("^traceablity gadget should be update with a new data$")
	public void traceablity_gadget_should_be_update_with_a_new_data() throws Throwable {
		try
	    {
	    	bp.waitForElement();
			dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 23,30);
	    	actual[48]=dbp.searchDashboard(dashboardName);
	    	actual[49]=dbp.selectDashboard(dashboardName);
	    	bp.waitForElement();
//	    	actual[57]=dbp.clickOnAddGadgetSymbol();
			String value=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,13); 
			actual[50]=dbp.gadgetOperation(value);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[51]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.gadgetOperation(value);
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
//			 String searchOption2=a[0];
			 actual[52]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 actual[53]=dbp.saveGadget();
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

	@When("^delete a selected testcase from project setup after saving traceability gadget$")
	public void delete_a_selected_testcase_from_project_setup_after_saving_traceability_gadget() throws Throwable {
		try
		  {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			   pp.backToProjectPage();
			   pp.selectProject(projectName1);
			   actual[54]=pp.selectProject(projectName);
			   actual[55]=pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[56]=rp.clickOnTestRep();
			   String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 25, 14);
			   String[] str=new String[1];
			    str[0]=p_Name1;
			   actual[57]=tr.navigateToNode(releaseName, str);
			   ep=new ExportPage(driver);
			   String[] testCaseNum=new String[1];
			   testCaseNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 15));
			   actual[58]=ep.selectMultipleTestcasesfromSearch(testCaseNum);
			   actual[59]=tr.deleteTestCase();
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

	@Then("^traceability gadget should update with an new data$")
	public void traceability_gadget_should_update_with_an_new_data() throws Throwable {
		try
	    {
	    	bp.waitForElement();
			dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 23,30);
	    	actual[60]=dbp.searchDashboard(dashboardName);
	    	dbp.selectDashboard(dashboardName);
	    	actual[61]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[62]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[63]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();

			 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
			 actual[64]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 dbp.saveGadget();
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

	@When("^delete a cycle mapped with selected requirement from project setup after saving traceability gadget$")
	public void delete_a_cycle_mapped_with_selected_requirement_from_project_setup_after_saving_traceability_gadget() throws Throwable {
		try
		  {
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
			   String projectName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_3");
			   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_7");
			   actual[65]=pp.backToProjectPage();
			   pp.selectProject(projectName1);
			   actual[66]=pp.selectProject(projectName);
			   actual[67]=pp.selectRelease(releaseName);
			   rp= new ReleasePage(driver);
			   tp=new TestPlanningPage(driver);
			   bp.waitForElement();
			   actual[68]=rp.clickOnTestPlanning();
			   //String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 25, 14);
			   String[] cycleName=new String[1];
			   cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 22, 30);
			   actual[69]=tp.navigateToCycle(cycleName);
			   actual[70]=tp.deleteNode(); 
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

	@Then("^traceability gadget should be update with the new data$")
	public void traceability_gadget_should_be_update_with_the_new_data() throws Throwable {
		try
	    {
	    	bp.waitForElement();
			dbp.clickOnManageDashboards();
			String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 23,30);
	    	actual[71]=dbp.searchDashboard(dashboardName);
	    	dbp.selectDashboard(dashboardName);
	    	actual[72]=dbp.clickOnAddGadgetSymbol();
			String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,6); 
			actual[73]=dbp.addGadget(gadgetName);
			
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_8");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,8); 
			 actual[74]=dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 driver.navigate().refresh();
			 bp.waitForElement();
			 bp.waitForElement();
			 bp.waitForElement();
			 dbp.configureTraceabilityGadget(projectName, release, refreshRate);
			 dbp.manageTraceability();
			 String searchOption=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,34);
//			 String searchOption2=a[0];
			 actual[75]=dbp.traceabilityQuickSearch(searchOption);
			 req=new RequirementsPage(driver);
			 req.selectAllRequirements();
			 dbp.closeTraceabilityTable();
			 dbp.saveGadget();
			 bp.waitForElement();
			 pp.backToProjectPage();
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
