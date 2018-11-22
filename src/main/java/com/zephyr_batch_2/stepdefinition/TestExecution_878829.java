package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
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

public class TestExecution_878829 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[66];
	SoftAssert soft=new SoftAssert();	
	
	String fileName="TestExecution_878829";

	@Given("^Lead Launch TestRepository and create ten testcases with teststeps and add priority p(\\d+) for five testcases,priority p(\\d+) for three testcases and priority p(\\d+) for two testcases$")
	public void lead_Launch_TestRepository_and_create_ten_testcases_with_teststeps_and_add_priority_p_for_five_testcases_priority_p_for_three_testcases_and_priority_p_for_two_testcases(int arg1, int arg2, int arg3) throws Throwable {
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
			   
			   //String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 62, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 62, 4);
				tr=new TestRepositoryPage(driver);
				bp=new BasePage();
				actual[3]=tr.doubleClickOnRelease(releaseName);
				actual[4]=tr.addNode(p_Name1,p_Desc1);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				tr.doubleClickOnRelease(releaseName);
				bp.waitForElement();
				tr.navigateToNode(releaseName, phase);
		   
				actual[5]=tr.addTestCase();
				bp.waitForElement();
				actual[6]=tr.clickDetailButton();
				String[] Priority1=new String[1];
				Priority1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[7]=ctc.enterPriority(Priority1);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[8]=tr.addTestCase();
				bp.waitForElement();
				actual[9]=tr.clickDetailButton();
				String[] Priority2=new String[1];
				Priority2[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[10]=ctc.enterPriority(Priority2);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[11]=tr.addTestCase();
				bp.waitForElement();
				actual[12]=tr.clickDetailButton();
				String[] Priority3=new String[1];
				Priority3[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[13]=ctc.enterPriority(Priority3);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[14]=tr.addTestCase();
				bp.waitForElement();
				actual[15]=tr.clickDetailButton();
				String[] Priority4=new String[1];
				Priority4[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[16]=ctc.enterPriority(Priority4);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[17]=tr.addTestCase();
				actual[18]=tr.clickDetailButton();
				String[] Priority5=new String[1];
				Priority5[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[19]=ctc.enterPriority(Priority5);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[20]=tr.addTestCase();
				actual[21]=tr.clickDetailButton();
				String[] Priority6=new String[1];
				Priority6[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[22]=ctc.enterPriority(Priority6);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[23]=tr.addTestCase();
				bp.waitForElement();
				actual[24]=tr.clickDetailButton();
				String[] Priority7=new String[1];
				Priority7[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[25]=ctc.enterPriority(Priority7);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[26]=tr.addTestCase();
				bp.waitForElement();
				actual[27]=tr.clickDetailButton();
				String[] Priority8=new String[1];
				Priority8[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 2, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[28]=ctc.enterPriority(Priority8);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
				
				actual[29]=tr.addTestCase();
				bp.waitForElement();
				actual[30]=tr.clickDetailButton();
				String[] Priority9=new String[1];
				Priority9[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 3, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[31]=ctc.enterPriority(Priority9);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
																																																																																																																																																																																																																																																																																																																												
				actual[32]=tr.addTestCase();
				bp.waitForElement();
				actual[33]=tr.clickDetailButton();
				String[] Priority10=new String[1];
				Priority10[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 3, 20);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[34]=ctc.enterPriority(Priority10);
				bp.waitForElement();
				bp.waitForElement();
				tr.clickOnList();
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

	@When("^Launch TestPlanning and create a cycle and create a phase to cycle and assign testcases to tester$")
	public void launch_TestPlanning_and_create_a_cycle_and_create_a_phase_to_cycle_and_assign_testcases_to_tester() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[35]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 62, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[36]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[37]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[38]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[39]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 62, 0);
				bp.waitForElement();
				actual[40]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 62, 1);
				actual[41]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[42]=tp.bulkAssignment(Bulk_Type);
				bp.waitForElement();
				
				//actual[31]=pp.clickOnLogout();
				String[] cycle2=new String[1];
				cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 62, 1);
				actual[43]=tp.navigateToCycle(cycle2);
				bp.waitForElement();
				
				actual[44]=tp.selectallTestCase();
				bp.waitForElement();
				
				String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
				bp.waitForElement();
				actual[45]=tp.assignAllSelected(assignee);
				bp.waitForElement();
				
				actual[46]=pp.clickOnLogout();
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

	@When("^As a Tester Launch TestExecution and execute testcases to custom status,click on D button,search a defect and link a defect$")
	public void as_a_Tester_Launch_TestExecution_and_execute_testcases_to_custom_status_click_on_D_button_search_a_defect_and_link_a_defect() throws Throwable {
		try
		{
			/*bp=new BasePage();
			   pp=new ProjectPage(driver);
			   bp.waitForElement();
		    	pp.clickOnLogout();
		    	bp.waitForElement();
		    	tp=new TestPlanningPage(driver);
		    	exep=new ExecutionPage(driver);*/
			
			lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			   pp=new ProjectPage(driver);
			   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
		    	 bp.waitForElement();
		    	 pp.selectProject(projectName);
		    	 pp.selectRelease(releaseName);	
			
		        actual[47]=bp.waitForElement();
		        rp=new ReleasePage(driver);
		        actual[48]=bp.waitForElement();
		        actual[49]=rp.clickOnTestExecution(); 
		        bp.waitForElement();
		   
		    String[] cycleName1=new String[3];
		    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",62 ,0 );
		    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",62 ,1 );
		    
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[50]=tp.navigateToCycle(cycleName1);
			bp.waitForElement();
			
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[51]=exep.executeStatus(tcNo1[0], statusType1);
		    bp.waitForElement();
		    
		    int[] tcNo2=new int[1];
			tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
		    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[52]=exep.executeStatus(tcNo2[0], statusType2);
		    bp.waitForElement();
		    
		    int[] tcNo3=new int[1];
			tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
		    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[53]=exep.executeStatus(tcNo3[0], statusType3);
		    bp.waitForElement();
		    
		    int[] tcNo4=new int[1];
			tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
		    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",9 ,18 );
		    bp.waitForElement();
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[54]=exep.executeStatus(tcNo4[0], statusType4);
		    bp.waitForElement();
	    
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
	    bp.waitForElement();
	    actual[55]=exep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    
	    bp.waitForElement();
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    actual[56]=exep.linkDefect(defectId);
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

	@When("^select multiple testcase executions using multi select and export testcase executions from grid level$")
	public void select_multiple_testcase_executions_using_multi_select_and_export_testcase_executions_from_grid_level() throws Throwable {
	   try
	   {
		   String[] tcNo1=new String[5];
		   tcNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 ));
		   tcNo1[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 ));
		   tcNo1[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 ));
		   tcNo1[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,8 ));
		   tcNo1[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,8 ));
		   actual[57]=exep.selectMultipleTestCaseFromExecutionGrid(tcNo1);
		   bp.waitForElement();
		   bp.waitForElement();
		   
		   exep.exportOptionInGrid.click();
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

	@When("^export testcases to excel format and select priority p(\\d+) and save$")
	public void export_testcases_to_excel_format_and_select_priority_p_and_save(int arg1) throws Throwable {
		 try
		   {
			  
			   bp.waitForElement();
			   ep=new ExportPage(driver);
			   String[] priority1=new String[1];
			   priority1[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,25 );
			   actual[58]=exep.filterByPriority(priority1);
			   bp.waitForElement();
			   
			   actual[59]=ep.saveAndDownload();
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
	
	@When("^export testcases to excel format and select the priority p(\\d+) and save$")
	public void export_testcases_to_excel_format_and_select_the_priority_p_and_save(int arg1) throws Throwable {
		 try
		   {
			   String[] tcNo2=new String[3];
			   tcNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",6 ,8 ));
			   tcNo2[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",7 ,8 ));
			   tcNo2[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",8 ,8 ));
			   actual[60]=exep.selectMultipleTestCaseFromExecutionGrid(tcNo2);
			   bp.waitForElement(); 
			   
			   exep.exportOptionInGrid.click();
			   bp.waitForElement();
			   
			   ep=new ExportPage(driver);
			   String[] priority1=new String[1];
			   priority1[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,25 );
			   actual[61]=exep.filterByPriority(priority1);
			   bp.waitForElement();
			   
			   actual[62]=ep.saveAndDownload();
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

	@When("^export testcases to excel format and select priority to the p(\\d+) and save$")
	public void export_testcases_to_excel_format_and_select_priority_to_the_p_and_save(int arg1) throws Throwable {
		 try
		   {
			   String[] tcNo3=new String[2];
			   tcNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",9 ,8 ));
			   tcNo3[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",10 ,8 ));
			   actual[63]=exep.selectMultipleTestCaseFromExecutionGrid(tcNo3);
			   bp.waitForElement();  
			   
			   exep.exportOptionInGrid.click();
			   bp.waitForElement();
			   
			   ep=new ExportPage(driver);
			   String[] priority1=new String[1];
			   priority1[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",3 ,25 );
			   actual[64]=exep.filterByPriority(priority1);
			   bp.waitForElement();
			   
			   actual[65]=ep.saveAndDownload();
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


	@Then("^able to export executions according to priority$")
	public void able_to_export_executions_according_to_priority() throws Throwable {
		try
		{
			
			pp=new ProjectPage(driver);
//			pp.clickOnLogout();
//			pp.closeBrowser();
			for(int k=0;k<=actual.length-1;k++)
		     {
				System.out.println(actual[k]);
		      soft.assertEquals(actual[k], true);
		     }
		     soft.assertAll();
		log.info("able to export file");
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
