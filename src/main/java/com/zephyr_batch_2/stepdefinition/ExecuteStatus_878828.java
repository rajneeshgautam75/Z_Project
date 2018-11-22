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

public class ExecuteStatus_878828 extends LaunchBrowser{


	 
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
	
	boolean[] actual=new boolean[83];
	SoftAssert soft=new SoftAssert();	
	LaunchBrowser lb=new LaunchBrowser();

	String fileName="ExecuteStatus_878828";
	
@Given("^Lead Launch TestRepository and create a phase and add ten testcases with teststeps$")
public void lead_Launch_TestRepository_and_create_a_phase_and_add_ten_testcases_with_teststeps() throws Throwable {
	try
	   {
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
		   
		   tr=new TestRepositoryPage(driver);
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 4);
			
			bp=new BasePage();
			actual[3]=tr.doubleClickOnRelease(releaseName);
			 bp.waitForElement();
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			actual[5]=tr.doubleClickOnRelease(releaseName);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			 bp.waitForElement();
			actual[6]=tr.navigateToNode(releaseName, phase);
			tr.addTestCase();
			bp.waitForElement();
			actual[7]=tr.clickDetailButton();
			
			String[] stepDetail=new String[3];
			stepDetail[0]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 0);
			stepDetail[1]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 1);
			stepDetail[2]=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 1, 2);	
			ctc=new CreateTestCasePage(driver);
			bp.waitForElement();
			actual[8]=ctc.enterTestCaseStepDetail(stepDetail);
			bp.waitForElement();

			bp.waitForElement();
			actual[9]=tr.clickOnList();
			bp.waitForElement();
			actual[10]=tr.selectallTestCase();
			actual[11]=tr.cloneTestCase();
			bp.waitForElement();
			actual[12]=tr.selectallTestCase();
			actual[13]=tr.cloneTestCase();
			bp.waitForElement();
			actual[14]=tr.selectallTestCase();
			actual[15]=tr.cloneTestCase();
			bp.waitForElement();
			String[] testCaseNo2=new String[2];
			testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
			testCaseNo2[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
			ep=new ExportPage(driver);
			bp.waitForElement();
			actual[16]=ep.selectMultipleTestCaseFromGrid(testCaseNo2);
			bp.waitForElement();
			actual[17]=tr.cloneTestCase();
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

@Given("^create two systems to the phase and add ten testcases with teststeps to each system$")
public void create_two_systems_to_the_phase_and_add_ten_testcases_with_teststeps_to_each_system() throws Throwable {
    try
    {
    	//bp.waitForElement();
    	//actual[18]=tr.clickOnList();
    	actual[18]=bp.waitForElement();
    	String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
		String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 1);
		actual[19]=tr.clickOnRelease(releaseName);
		String s_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 2);
		String s_Desc1=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 5);
		bp.waitForElement();
		actual[20]=tr.selectPhase(p_Name1);
		//bp.waitForElement();
		actual[21]=tr.addNode(s_Name1, s_Desc1);
		actual[22]=tr.selectPhase(s_Name1);
		tr.addTestCase();
		bp.waitForElement();
		actual[23]=tr.clickDetailButton();
		
		String[] stepDetail2=new String[3];
		stepDetail2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
		stepDetail2[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		stepDetail2[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
		ctc=new CreateTestCasePage(driver);
		bp.waitForElement();
		actual[24]=ctc.enterTestCaseStepDetail(stepDetail2);
		bp.waitForElement();
		
		bp.waitForElement();
		actual[25]=tr.clickOnList();
		bp.waitForElement();
		actual[26]=tr.selectallTestCase();
		actual[27]=tr.cloneTestCase();
		bp.waitForElement();
		actual[28]=tr.selectallTestCase();
		actual[29]=tr.cloneTestCase();
		bp.waitForElement();
		actual[30]=tr.selectallTestCase();
		actual[31]=tr.cloneTestCase();
		bp.waitForElement();
		String[] testCaseNo2=new String[2];
		testCaseNo2[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
		testCaseNo2[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
		ep=new ExportPage(driver);
		bp.waitForElement();
		actual[32]=ep.selectMultipleTestCaseFromGrid(testCaseNo2);
		bp.waitForElement();
		actual[33]=tr.cloneTestCase();
		bp.waitForElement();

    	  bp.waitForElement();
    	  actual[34]=tr.clickOnRelease(releaseName);
  String s_Name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 60, 2);
  String s_Desc2=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 5);
  actual[35]=tr.selectPhase(s_Name1);
  bp.waitForElement();
  actual[36]=tr.addNode(s_Name2, s_Desc2);
  actual[37]=tr.selectPhase(s_Name2);
  tr.addTestCase();
	bp.waitForElement();
	actual[38]=tr.clickDetailButton();

	
	String[] stepDetail3=new String[3];
	stepDetail3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
	stepDetail3[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
	stepDetail3[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
	ctc=new CreateTestCasePage(driver);
	bp.waitForElement();
	actual[39]=ctc.enterTestCaseStepDetail(stepDetail3);
	bp.waitForElement();
	
	bp.waitForElement();
	actual[40]=tr.clickOnList();
	bp.waitForElement();
	actual[41]=tr.selectallTestCase();
	actual[42]=tr.cloneTestCase();
	bp.waitForElement();
	actual[43]=tr.selectallTestCase();
	actual[44]=tr.cloneTestCase();
	bp.waitForElement();
	actual[45]=tr.selectallTestCase();
	actual[46]=tr.cloneTestCase();
	bp.waitForElement();
	String[] testCaseNo3=new String[2];
	testCaseNo3[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
	testCaseNo3[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 8));
	ep=new ExportPage(driver);
	bp.waitForElement();
	actual[47]=ep.selectMultipleTestCaseFromGrid(testCaseNo3);
	bp.waitForElement();
	actual[48]=tr.cloneTestCase();
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

@When("^Lead Launch TestPlanning and create a cycle and create phase to cycle and assign testcases to tester$")
public void lead_Launch_TestPlanning_and_create_a_cycle_and_create_phase_to_cycle_and_assign_testcases_to_tester() throws Throwable {
	try
	   {
		bp.waitForElement();
		  actual[49]=rp.clickOnTestPlanning();
		  
		  tp=new TestPlanningPage(driver);
			//String[] str=new String[4];
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
			String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
			String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
			actual[50]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			bp.waitForElement();
			actual[51]=tp.CreateCycle(cycle, Build, environ, hide);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
			String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
			String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
			bp.waitForElement();
			actual[52]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[53]=tp.saveTestCycle();
			
			String[] cycle1=new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 0);
			bp.waitForElement();
			actual[54]=tp.navigateToCycle(cycle1);
			
			bp.waitForElement();
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 1);
			actual[55]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			
			bp.waitForElement();
			String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
			bp.waitForElement();
			actual[56]=tp.bulkAssignment(Bulk_Type);
			bp.waitForElement();
			
			//actual[31]=pp.clickOnLogout();
			String[] cycle2=new String[1];
			cycle2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 59, 1);
			actual[57]=tp.navigateToCycle(cycle2);
			bp.waitForElement();
			
			actual[58]=tp.selectallTestCase();
			bp.waitForElement();
			
			String assignee=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 4, 9);
			bp.waitForElement();
			actual[59]=tp.assignAllSelected(assignee);
			bp.waitForElement();
			
			actual[60]=pp.clickOnLogout();
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

@When("^Tester Launch TestExecution and execute testcases to pass/fail and click on D button and search and link a defect$")
public void tester_Launch_TestExecution_and_execute_testcases_to_pass_fail_and_click_on_D_button_and_search_and_link_a_defect() throws Throwable {
	try
	{
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
		
	        actual[61]=bp.waitForElement();
	        rp=new ReleasePage(driver);
	        actual[62]=bp.waitForElement();
	        actual[63]=rp.clickOnTestExecution(); 
	        bp.waitForElement();
	   
	    String[] cycleName1=new String[3];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",59 ,0 );
	    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "FreeForm",59 ,1 );
	    
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[64]=tp.navigateToCycle(cycleName1);
		bp.waitForElement();
		
		int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[65]=exep.executeStatus(tcNo1[0], statusType1);
	    bp.waitForElement();
	    
	    int[] tcNo2=new int[1];
		tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
	    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[66]=exep.executeStatus(tcNo2[0], statusType2);
	    bp.waitForElement();
	    
	    int[] tcNo3=new int[1];
		tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
	    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",3 ,18 );
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[67]=exep.executeStatus(tcNo3[0], statusType3);
	    bp.waitForElement();
	    
	    int[] tcNo4=new int[1];
		tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
	    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[68]=exep.executeStatus(tcNo4[0], statusType4);
	    bp.waitForElement();
    
    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
    bp.waitForElement();
    actual[69]=exep.clickOnDefectButton(testcase);
    bp.waitForElement();
    
    bp.waitForElement();
    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
    actual[70]=exep.linkDefect(defectId);
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

@When("^export testcases execution from release level and export testcases to excel format and save$")
public void export_testcases_execution_from_release_level_and_export_testcases_to_excel_format_and_save() throws Throwable {
    try
    {
    	/*bp=new BasePage();
		   pp=new ProjectPage(driver);
		   bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver);
    	
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
		
	        actual[61]=bp.waitForElement();
	        rp=new ReleasePage(driver);
	        actual[62]=bp.waitForElement();
	        actual[63]=rp.clickOnTestExecution(); 
	        bp.waitForElement();*/
    	
    	driver.navigate().refresh();
    	bp.waitForElement();
    	bp.waitForElement();
    	
    	String[] cycleName1=new String[1];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[71]=tp.navigateToCycle(cycleName1);
	    bp.waitForElement();
    	
    	bp.waitForElement();
    	actual[72]=exep.clickOnNodeExport();
    	bp.waitForElement();
    	
    	String report_Type=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",3 ,23 );
    	actual[73]=exep.reportType(report_Type);
    	bp.waitForElement();
    	
    	ep=new ExportPage(driver);
    	actual[74]=ep.saveAndDownload();
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

@When("^export testcases execution from release level and export testcases to detailed format and save$")
public void export_testcases_execution_from_release_level_and_export_testcases_to_detailed_format_and_save() throws Throwable {
	try
    {
		String[] cycleName1=new String[1];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[75]=tp.navigateToCycle(cycleName1);
	    bp.waitForElement();
		
    	bp.waitForElement();
    	actual[76]=exep.clickOnNodeExport();
    	bp.waitForElement();
    	
    	String report_Type=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,23 );
    	actual[77]=exep.reportType(report_Type);
    	bp.waitForElement();
    	
    	ep=new ExportPage(driver);
    	actual[78]=ep.saveAndDownload();
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

@When("^export testcases execution from release level and export testcases to summary format and save$")
public void export_testcases_execution_from_release_level_and_export_testcases_to_summary_format_and_save() throws Throwable {
	try
    {
		String[] cycleName1=new String[1];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[79]=tp.navigateToCycle(cycleName1);
	    bp.waitForElement();
		
    	bp.waitForElement();
    	actual[80]=exep.clickOnNodeExport();
    	bp.waitForElement();
    	
    	String report_Type=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,23 );
    	actual[81]=exep.reportType(report_Type);
    	bp.waitForElement();
    	
    	ep=new ExportPage(driver);
    	actual[82]=ep.saveAndDownload();
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

@Then("^able to export file$")
public void able_to_export_file() throws Throwable {
	try
	{
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
