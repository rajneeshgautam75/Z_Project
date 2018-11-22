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

public class TestExecution_878810 extends LaunchBrowser{

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
	CreateCustomFieldsPage ccp;
	String fileName="TestExecution_878810";
	
	boolean[] actual=new boolean[52];
	SoftAssert soft=new SoftAssert();
	
	@Given("^Lead is in TestRepository$")
	public void lead_is_in_TestRepository() throws Throwable {
		try
		   {
			lb=new LaunchBrowser();
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
		   
		   }
		   catch(Exception e)
			{
			   lb.getScreenShot(fileName);
			   e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}
	}

	@When("^Lead create a phase and create testcases with teststeps and add two systems to phase$")
	public void lead_create_a_phase_and_create_testcases_with_teststeps_and_add_two_systems_to_phase() throws Throwable {
		try
	    {
					tr=new TestRepositoryPage(driver);
				String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 4);
				
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[5]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				bp.waitForElement();
				actual[6]=tr.clickDetailButton();
				bp.waitForElement();
				String[] stepDetail1=new String[3];
				stepDetail1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail1[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 7);
				stepDetail1[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 10);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[7]=ctc.enterTestCaseStepDetail(stepDetail1);
				bp.waitForElement();
				
				bp.waitForElement();
				actual[8]=tr.clickOnList();
				bp.waitForElement();
				
				ep=new ExportPage(driver);
				String[] testcase=new String[1];
				testcase[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 ));
				actual[9]=ep.selectMultipleTestCaseFromGrid(testcase);
				
				actual[9]=tr.selectallTestCase();
				actual[10]=tr.cloneTestCase();
				bp.waitForElement();
				actual[11]=tr.selectallTestCase();
				actual[12]=tr.cloneTestCase();
				bp.waitForElement();
				actual[13]=tr.selectallTestCase();
				actual[14]=tr.cloneTestCase();
				bp.waitForElement();
				String[] testCaseNo=new String[2];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
				testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
				ep=new ExportPage(driver);
				bp.waitForElement();
				actual[15]=ep.selectMultipleTestCaseFromGrid(testCaseNo);
				bp.waitForElement();
				actual[16]=tr.cloneTestCase();
				bp.waitForElement();
				
				bp.waitForElement();
				actual[17]=tr.doubleClickOnRelease(releaseName);
				String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 2);
				String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 5);
				bp.waitForElement();
				actual[18]=tr.selectPhase(p_Name1);
				bp.waitForElement();
				actual[19]=tr.addNode(s_Name1, s_Desc1);
				
				bp.waitForElement();
				actual[20]=tr.doubleClickOnRelease(releaseName);
				String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 56, 2);
				String s_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 5);
				bp.waitForElement();
				
				String[] sys=new String[2];
				sys[0]=p_Name1;
				sys[1]=s_Name1;
				 bp.waitForElement();
				actual[21]=tr.navigateToNode(releaseName, sys);
				
				actual[22]=tr.selectPhase(s_Name1);
				bp.waitForElement();
				actual[23]=tr.addNode(s_Name2, s_Desc2);
				bp.waitForElement();
	    }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}
	}

	@When("^User Launch TestPlanning and create a Cycle,add phase to cycle and assign testcases to Creator$")
	public void user_Launch_TestPlanning_and_create_a_Cycle_add_phase_to_cycle_and_assign_testcases_to_Creator() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[24]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[25]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[26]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[27]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[28]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 0);
				actual[29]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 55, 1);
				actual[30]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[31]=tp.bulkAssignment(Bulk_Type);
				bp.waitForElement();

		   }
		   catch(Exception e)
			{
			   lb.getScreenShot(fileName);
				e.printStackTrace();
				driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e;
			}     
	}

	@When("^Lead Launch TestExecution and execute teststeps and testcases to pass/fail$")
	public void lead_Launch_TestExecution_and_execute_teststeps_and_testcases_to_pass_fail() throws Throwable {
		try
		{
		actual[32]=bp.waitForElement();
		rp= new ReleasePage(driver);
		actual[33]=bp.waitForElement();
		   actual[34]=rp.clickOnTestExecution(); 
		   actual[35]=bp.waitForElement();
		   
		   String[] cycleName1=new String[2];
		   String release=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",55 ,0 );
		    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",55 ,1 );
		    bp.waitForElement();
		    bp.waitForElement();
			actual[36]=tr.navigateToNode(release,cycleName1);
			bp.waitForElement();
			
			bp.waitForElement();
			tr.clickDetailButton(); 
			int[] stepNo1=new int[1];
		    stepNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
//			actual[40]=exep.selectMultipleTestCaseFromExecutionGrid(stepNo1);
			bp.waitForElement();
			String[] statusType1=new String[1];
		    statusType1[0]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    
		    String[] tcNo1=new String[1];
			tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 ));
			exep.selectMultipleTestCaseFromExecutionGrid(tcNo1);
			bp.waitForElement();
			
			bp.waitForElement();
			//exep.stepDetailButton.click();
			bp.waitForElement();
		    actual[37]=exep.changeStepDetailStatus(stepNo1, statusType1);
		    bp.waitForElement();
	        String[] tcNo2=new String[1];
		    tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 ));
		    actual[38]=exep.selectMultipleTestCaseFromExecutionGrid(tcNo2);
		    bp.waitForElement();
		    int[] stepNo2=new int[1];
	        stepNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String[] statusType2=new String[1];
	        statusType2[0]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
	        bp.waitForElement();
	       // exep.stepDetailButton.click();
			bp.waitForElement();
	        actual[39]=exep.changeStepDetailStatus(stepNo2, statusType2);
	        bp.waitForElement();
	        bp.waitForElement();
	        String[] tcNo3=new String[1];
		    tcNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 ));
		    actual[40]=exep.selectMultipleTestCaseFromExecutionGrid(tcNo3);
		    bp.waitForElement();
	        int[] stepNo3=new int[1];
	        stepNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    bp.waitForElement();
		    String[] statusType3=new String[1];
	        statusType3[0]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
	        bp.waitForElement();
	       // exep.stepDetailButton.click();
			bp.waitForElement();
	        actual[41]=exep.changeStepDetailStatus(stepNo3, statusType3);
	        bp.waitForElement();
	    
	    
	    String[] tcNo4=new String[1];
		tcNo4[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 ));
		actual[42]=exep.selectMultipleTestCaseFromExecutionGrid(tcNo4);
		bp.waitForElement();
		int[] stepNo4=new int[1];
	    stepNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		bp.waitForElement();
		String[] statusType4=new String[1];
	    statusType4[0]=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	    bp.waitForElement();
	   // exep.stepDetailButton.click();
		bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[43]=exep.changeStepDetailStatus(stepNo4, statusType4);
	    bp.waitForElement();
	    
	    tr.clickOnList();
	    bp.waitForElement();
	    actual[44]=pp.clickOnLogout();
	    bp.waitForElement();
   }
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		e.printStackTrace();
		driver.close();
		Relogin_TPE rl=new Relogin_TPE();
			rl.reLogin();
			throw e;
		}     
	}

	@When("^As a Manager,Launch Administration,click on customization and click on testcase execution and edit default execution status and change color$")
	public void as_a_Manager_Launch_Administration_click_on_customization_and_click_on_testcase_execution_and_edit_default_execution_status_and_change_color() throws Throwable {
		try
		{
			lp=new LoginPage(driver);
			ccp=new CreateCustomFieldsPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
				 
				 bp.waitForElement();
			    actual[45]=ccp.navigatingToCustomizationStatusTab();
			    bp.waitForElement();
			    ccp=new CreateCustomFieldsPage(driver);
		    	ccp.clickOnExecutionStatusTab();
			    	
			    	bp.waitForElement();
			    	String name=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,29 );
			    	String value=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,29 );
				    String colour=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,12 );
				    bp.waitForElement();
				    actual[46]=ccp.editCustomStaus(name, value, colour);
			    	bp.waitForElement();
			    	ccp.closeExecutionStatusPage.click();
			    	actual[47]=pp.clickOnLogout();
					bp.waitForElement();
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
			e.printStackTrace();
			driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}     
	}

	@When("^As a Lead,Launch TestExecution and view the changes$")
	public void as_a_Lead_Launch_TestExecution_and_view_the_changes() throws Throwable {
		try
		{
			lp=new LoginPage(driver);
		bp=new BasePage();
		String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
		   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
		   
		   lp.enterUname(Uname);
		   lp.enterPass(Pass);
		   lp.clickOnLogin();
		   
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 pp.selectProject(projectName);
	    	 pp.selectRelease(releaseName);
			
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[48]=rp.clickOnTestExecution();
		
		String[] cycleName1=new String[2];
	    String release=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",55 ,0 );
	    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",55 ,1 );
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[49]=tr.navigateToNode(release, cycleName1);
		bp.waitForElement();
		
		int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,29 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[50]=exep.executeStatus(tcNo1[0], statusType1);
	    bp.waitForElement();
	    
	    int[] tcNo2=new int[1];
		tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
	    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm",1 ,29 );
	    bp.waitForElement();
	    actual[51]=exep.executeStatus(tcNo2[0], statusType2);
	    bp.waitForElement();
	    bp.waitForElement();
	    
	    
	    
		}
		catch(Exception e)
		{
			lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}     
	}

	@Then("^edited status value should appear in status drop down list in TestExecution\\(TCE\\)$")
	public void edited_status_value_should_appear_in_status_drop_down_list_in_TestExecution_TCE() throws Throwable {
	   try
	   {
		   String release=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		   tp.doubleClickOnCycle(release);
		   
		   log.info("Edited status value should appear in status drop down list in TestExecution");
		   for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
	   }
	   catch(Exception e)
		{
		   lb.getScreenShot(fileName);
		   e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e;
		}     
	}
}
