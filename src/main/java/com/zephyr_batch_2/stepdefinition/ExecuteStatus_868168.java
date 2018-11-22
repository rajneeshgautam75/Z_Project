package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExecuteStatus_868168 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ImportPage ip;
	ExportPage ep;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	RequirementsPage req;
	CreateCustomFieldsPage ccf;
	String fileName="ExecuteStatus_868168";
	
	boolean[] actual=new boolean[64];
	SoftAssert soft=new SoftAssert();
	
	@Given("^User is in a page TestREpository$")
	public void user_is_in_a_page_TestREpository() throws Throwable {
		try
		   {
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 bp.waitForElement();
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 bp.waitForElement();
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
		   
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

	@When("^User creates a phase and creates testcases in phase$")
	public void user_creates_a_phase_and_creates_testcases_in_phase() throws Throwable {
		try{
			String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 11, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 11, 4);
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			actual[3]=tr.doubleClickOnRelease(releaseName);
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase);
			for(int i=0;i<=3;i++)
			{
			actual[5]=tr.addTestCase();
			}
			bp.waitForElement();
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

	@When("^User Launch testPlanning and creates a cycle,creates a phase by choosing existing phase and assign to anyone$")
	public void user_Launch_testPlanning_and_creates_a_cycle_creates_a_phase_by_choosing_existing_phase_and_assign_to_anyone() throws Throwable {
		try
		   {
			bp=new BasePage();
			bp.waitForElement();
			rp=new ReleasePage(driver);
			bp.waitForElement();
			bp.waitForElement();
			  actual[6]=rp.clickOnTestPlanning();
			  bp.waitForElement();
			  bp.waitForElement();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 11, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				bp.waitForElement();
				actual[7]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[8]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 11, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[10]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 11, 0);
				bp.waitForElement();
				actual[11]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 11, 1);
				actual[12]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 2, 0);
				bp.waitForElement();
				actual[13]=tp.bulkAssignment(Bulk_Type);
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

	@When("^User Launch TestExecution and execute the testcases by performing edit operation$")
	public void user_Launch_TestExecution_and_execute_the_testcases_by_performing_edit_operation() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[14]=rp.clickOnTestExecution(); 
				   bp.waitForElement();
				   
				   String[] cycleName=new String[3];
				    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
				    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[15]=tp.navigateToCycle(cycleName);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[16]=exep.executeStatus(tcNo1[0], statusType1);
				    bp.waitForElement();
				    
				    int[] tcNo2=new int[1];
					tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[17]=exep.executeStatus(tcNo2[0], statusType2);
				    bp.waitForElement();
				    
				    int[] tcNo3=new int[1];
					tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[18]=exep.executeStatus(tcNo3[0], statusType3);
				    bp.waitForElement();
				    
				    int[] tcNo4=new int[1];
					tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[19]=exep.executeStatus(tcNo4[0], statusType4);
				    bp.waitForElement();
				    
				    String cycleName33=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName33);
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

	@When("^User Launches TestPlanning and selects the phase and click on assign and view executions of testcase$")
	public void user_Launches_TestPlanning_and_selects_the_phase_and_click_on_assign_and_view_executions_of_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[20]=rp.clickOnTestPlanning();
		bp.waitForElement();
		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
		bp.waitForElement();
		actual[21]=tp.doubleClickOnCycle(cycleName1);
		bp.waitForElement();
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
//	    bp.waitForElement();
//	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[22]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
//		bp.waitForElement();
	   actual[23]=tp.assignPhase();
	   bp.waitForElement();
	   
	   String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[24]=tp.navigateToCycle(phaseName);
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

	@When("^User Launches TestExecution and change the execution status of testcases$")
	public void user_Launches_TestExecution_and_change_the_execution_status_of_testcases() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[25]=rp.clickOnTestExecution(); 
				   bp.waitForElement();
				   
				   String[] cycleName=new String[3];
				    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
				    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[26]=tp.navigateToCycle(cycleName);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[27]=exep.executeStatus(tcNo1[0], statusType1);
				    bp.waitForElement();
				    
				    int[] tcNo2=new int[1];
					tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[28]=exep.executeStatus(tcNo2[0], statusType2);
				    bp.waitForElement();
				    
				    int[] tcNo3=new int[1];
					tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[29]=exep.executeStatus(tcNo3[0], statusType3);
				    bp.waitForElement();
				    
				    int[] tcNo4=new int[1];
					tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
				    bp.waitForElement();
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[30]=exep.executeStatus(tcNo4[0], statusType4);
				    bp.waitForElement();
				    
				    String cycleName44=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName44);
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

	@When("^User Launches TestPlanning and select phase,click on assign and view the executions of testcase$")
	public void user_Launches_TestPlanning_and_select_phase_click_on_assign_and_view_the_executions_of_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[31]=rp.clickOnTestPlanning();
		bp.waitForElement();
		bp.waitForElement();
		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
		bp.waitForElement();
		actual[32]=tp.doubleClickOnCycle(cycleName1);
		bp.waitForElement();
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[33]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[34]=tp.assignPhase();
	   bp.waitForElement();
	   
	   String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[35]=tp.navigateToCycle(phaseName);
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

	@When("^User launch testExecution and change the execution status of testcase to not executed$")
	public void user_launch_testExecution_and_change_the_execution_status_of_testcase_to_not_executed() throws Throwable {
		try
		   {
			   bp.waitForElement();
				rp= new ReleasePage(driver);
				bp.waitForElement();
				   actual[36]=rp.clickOnTestExecution(); 
				   bp.waitForElement();
				   
				   String[] cycleName=new String[3];
				    cycleName[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
				    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
				    cycleName[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
				    
				    bp.waitForElement();
				    tp=new TestPlanningPage(driver);
				    bp.waitForElement();
				    bp.waitForElement();
				    bp.waitForElement();
					actual[37]=tp.navigateToCycle(cycleName);
					bp.waitForElement();
				
					int[] tcNo1=new int[1];
					tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[38]=exep.executeStatus(tcNo1[0], statusType1);
				    bp.waitForElement();
				    
				    int[] tcNo2=new int[1];
					tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[39]=exep.executeStatus(tcNo2[0], statusType2);
				    bp.waitForElement();
				    
				    int[] tcNo3=new int[1];
					tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    //bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[40]=exep.executeStatus(tcNo3[0], statusType3);
				    bp.waitForElement();
				    
				    int[] tcNo4=new int[1];
					tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",5 ,18 );
				    bp.waitForElement();
				    //bp.waitForElement();
				    exep=new ExecutionPage(driver);
				    actual[41]=exep.executeStatus(tcNo4[0], statusType4);
				    bp.waitForElement();
				    
				    String cycleName55=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
					tp.doubleClickOnCycle(cycleName55);
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

	@When("^User Launch TestpLanning and select phase,click on assign and view the executions of testcase$")
	public void user_Launch_TestpLanning_and_select_phase_click_on_assign_and_view_the_executions_of_testcase() throws Throwable {
		try
		{
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[42]=rp.clickOnTestPlanning();
		  bp.waitForElement();
		  bp.waitForElement();
		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
		bp.waitForElement();
		actual[43]=tp.doubleClickOnCycle(cycleName1);
		  bp.waitForElement();
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[44]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[45]=tp.assignPhase();
	   bp.waitForElement();
	   
	   String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[46]=tp.navigateToCycle(phaseName);
		bp.waitForElement();
		
		pp.clickOnLogout();
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

	@When("^User Launch administration,clicks on customization and clicks execute status and disable a status$")
	public void user_Launch_administration_clicks_on_customization_and_clicks_execute_status_and_disable_a_status() throws Throwable {
		try
	    {	
			
//			lb=new LaunchBrowser();
//			   lb.preCond();
//			   
//			   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
//			   lb.getUrl(url);
			   lp=new LoginPage(driver);
			   tp=new TestPlanningPage(driver);
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
//			   pp.clickOnLogout();
			   exep=new ExecutionPage(driver);
			   ccf=new CreateCustomFieldsPage(driver);
			
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Password_1");
		   
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();
			
			bp.waitForElement();
	    	actual[47]=ccf.navigatingToCustomizationStatusTab();
	    	CreateCustomFieldsPage ccp=new CreateCustomFieldsPage(driver);
	    	ccp.clickOnExecutionStatusTab();
	    	bp.waitForElement();
	    	String status=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,11 );
		    bp.waitForElement();
		    actual[48]=ccf.disabledStatus(status);
	    	bp.waitForElement();
	    	
	    	bp.waitForElement();
	    	pp.clickOnLogout();
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
	
	
	@When("^User Launches TestPlanning,selects phase,click on assign and view the executions of testcase$")
	public void user_Launches_TestPlanning_selects_phase_click_on_assign_and_view_the_executions_of_testcase() throws Throwable {
		try
		{
//			lb=new LaunchBrowser();
//			   lb.preCond();
//			   
//			   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
//			   lb.getUrl(url);
			   lp=new LoginPage(driver);
			  
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		   
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   bp=new BasePage();
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 pp.selectProject(projectName);
	    	 bp.waitForElement();
	    	 pp.selectRelease(releaseName);
	    	 bp.waitForElement();
			
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[49]=rp.clickOnTestPlanning();
		    bp.waitForElement();
		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
		bp.waitForElement();
		actual[50]=tp.doubleClickOnCycle(cycleName1);
		  bp.waitForElement();
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[51]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[52]=tp.assignPhase();
	   bp.waitForElement();
	   
	   String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[53]=tp.navigateToCycle(phaseName);
		bp.waitForElement();
		pp.clickOnLogout();
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
	
	@When("^User Launches administration and clicks on customization and clicks execute status and edit a status$")
	public void user_Launches_administration_and_clicks_on_customization_and_clicks_execute_status_and_edit_a_status() throws Throwable {
		 try
		    {	
			 /*bp=new BasePage();
				rp=new ReleasePage(driver);
		    	pp=new ProjectPage(driver);
		    	bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	exep=new ExecutionPage(driver);*/
//			 lb=new LaunchBrowser();
//			   lb.preCond();
//			   
//			   String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
//			   lb.getUrl(url);
			   lp=new LoginPage(driver);
			
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Password_1");
		   
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();
			 exep=new ExecutionPage(driver);
			 bp=new BasePage();
			 bp.waitForElement();
		    actual[54]=ccf.navigatingToCustomizationStatusTab();
		    CreateCustomFieldsPage ccp=new CreateCustomFieldsPage(driver);
	    	ccp.clickOnExecutionStatusTab();	
		    bp.waitForElement();
	    	String status=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,11 );
		    bp.waitForElement();
		    actual[55]=ccf.disabledStatus(status);
	    	bp.waitForElement();
		    
		        bp.waitForElement();
		    	bp.waitForElement();
		    	String name=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,10 );
		    	String value=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,10 );
			    String colour=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,12 );
			    bp.waitForElement();
			    exep.executionButton.click();
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[56]=ccf.editCustomStaus(name, value, colour);
		    	bp.waitForElement();
		    	ccf.closeExecutionStatusPage.click();
		    	pp.clickOnLogout();
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


	@Then("^User Launches TestPlanning and re-assign the testcase to other user after testcase executed in testExecution$")
	public void user_Launches_TestPlanning_and_re_assign_the_testcase_to_other_user_after_testcase_executed_in_testExecution() throws Throwable {
		try
		{
			/*bp=new BasePage();
			rp=new ReleasePage(driver);
	    	pp=new ProjectPage(driver);
	    	bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver);*/
			   
			lp=new LoginPage(driver);
		   String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		   
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   bp=new BasePage();
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 pp.selectProject(projectName);
	    	  bp.waitForElement();
	    	 pp.selectRelease(releaseName);
	    	  bp.waitForElement();
			
			bp.waitForElement();
			rp= new ReleasePage(driver);
		   actual[57]=rp.clickOnTestPlanning();
		  bp.waitForElement();
		
		String cycleName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
		bp.waitForElement();
		actual[58]=tp.doubleClickOnCycle(cycleName1);
		  bp.waitForElement();
	   
	   String[] cycleName=new String[2];
	    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,0 );
	    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
		actual[59]=tp.navigateToCycle(cycleName);
		bp.waitForElement();
		bp.waitForElement();
		bp.waitForElement();
	   actual[60]=tp.assignPhase();
	   bp.waitForElement();
	   
	   String[] phaseName=new String[1];
	     phaseName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",11 ,1 );
	     bp.waitForElement();
	     bp.waitForElement();
		actual[61]=tp.navigateToCycle(phaseName);
		bp.waitForElement();
		
		actual[62]=tp.selectallTestCase();
		bp.waitForElement();
		
		String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 7, 9);
		bp.waitForElement();
		actual[63]=tp.assignAllSelected(assignee);
		bp.waitForElement();
		tp.goBackToCycle();
		for(int k=0;k<=actual.length-1;k++)
        {
    		System.out.println(actual[k]);
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
