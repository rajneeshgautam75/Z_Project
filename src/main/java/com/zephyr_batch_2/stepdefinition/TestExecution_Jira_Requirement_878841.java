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
import cucumber.api.java.en.When;

public class TestExecution_Jira_Requirement_878841 extends LaunchBrowser{


     
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
	
	boolean[] actual=new boolean[56];
	SoftAssert soft=new SoftAssert();
	 LaunchBrowser lb=new LaunchBrowser();
	 String fileName="TestExecution_Jira_Requirement_878841";
	 
	@Given("^Manager Launch defect admin,click on general configuration and click on jira remote link$")
	public void manager_Launch_defect_admin_click_on_general_configuration_and_click_on_jira_remote_link() throws Throwable {
		try
	    {
			
			bp=new BasePage();
	    	pp=new ProjectPage(driver);
	    	bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver);
			
			bp=new BasePage();
			   pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			
	    	exep=new ExecutionPage(driver);
	    	ccp=new CreateCustomFieldsPage(driver);
	    	bp.waitForElement();
	    	actual[0]=ccp.navigatingToGeneralConfigurationTab();
	    	bp.waitForElement();
	    	String linkType=Excel_Lib.getData(INPUT_PATH_3,"Map_Jira_Requirement",2,3);
	    	actual[1]=ccp.EnableJiraLinkIssue(linkType);
	    	bp.waitForElement();
	    	actual[2]=pp.clickOnLogout();
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

	@When("^Lead Launch TestRepository and create a phase and create testcases$")
	public void lead_Launch_TestRepository_and_create_a_phase_and_create_testcases() throws Throwable {
		try
		   {
			lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			   
			
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[3]=pp.selectProject(projectName);
	    	 actual[4]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[5]=rp.clickOnTestRep(); 
			   
			   tr=new TestRepositoryPage(driver);
				//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 3, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 3, 2);
				
				bp=new BasePage();
				actual[6]=tr.doubleClickOnRelease(releaseName);
				 bp.waitForElement();
				actual[7]=tr.addNode(p_Name1,p_Desc1);
				bp.waitForElement();
				tr.doubleClickOnRelease(releaseName);
				String[] phase=new String[1];
				phase[0]=p_Name1;
				 bp.waitForElement();
				actual[8]=tr.navigateToNode(releaseName, phase);
				tr.addTestCase();
				
				/*actual[9]=tr.clickDetailButton();
				
				ctc=new CreateTestCasePage(driver);
				String tcName1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 17);
				String tcDesc1=Excel_Lib.getData(INPUT_PATH_3,"testcaseDetails" , 2, 3);
				bp.waitForElement();
				actual[10]=ctc.enterTestCaseNameAndDesc(tcName1, tcDesc1);
				bp.waitForElement();
				
				String[] stepDetail1=new String[3];
				stepDetail1[0]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 1, 6);
				stepDetail1[1]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				stepDetail1[2]=Excel_Lib.getData(INPUT_PATH_3, "FreeForm", 100, 100);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterTestCaseStepDetail(stepDetail1);
				bp.waitForElement();
				String Priority1=Excel_Lib.getData(INPUT_PATH_3, "testcaseDetails", 100, 100);
				String AltID1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 15);
				String Comment1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 14);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[12]=ctc.enterTestCaseDetails(Priority1, AltID1, Comment1);
				bp.waitForElement();
				
				bp.waitForElement();
				ctc.customFieldOption.click();
				
				String text1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 16);
				String longText1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 100, 100);
				String number1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 100, 100);
				String checkBox1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String pickupList1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				String date1=Excel_Lib.getData(INPUT_PATH_3, "StepDetails", 100, 100);
				bp.waitForElement();
				actual[10]=ctc.enterCustomFields(text1, longText1, number1, checkBox1, pickupList1, date1);
				bp.waitForElement();
				
				bp.waitForElement();
				String[] tags1=new String[1];
				tags1[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus", 1, 18);
				ctc=new CreateTestCasePage(driver);
				bp.waitForElement();
				actual[11]=ctc.enterMultipletags(tags1);
				bp.waitForElement();*/
				//bp.waitForElement();
				
				//actual[12]=tr.clickOnList();
				bp.waitForElement();
				
				ep=new ExportPage(driver);
				String[] testcase11=new String[1];
				testcase11[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
				actual[9]=ep.selectMultipleTestcasesfromSearch(testcase11);
				bp.waitForElement();
				
				//actual[9]=tr.selectallTestCase();
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
				actual[15]=ep.selectMultipleTestcasesfromSearch(testCaseNo);
				bp.waitForElement();
				actual[16]=tr.cloneTestCase();
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

	@When("^Lead Launch Requirements and perform defect import operation$")
	public void lead_Launch_Requirements_and_perform_defect_import_operation() throws Throwable {
		try
	    {
	    	rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[17]=rp.clickOnRequirements();
			   
			   req=new RequirementsPage(driver);
		    	req.import_Requirement.click();
			String importType=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,5 );
			actual[18]=req.chooseImportType(importType);
			
			bp.waitForElement();
			String username=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,3 );
			String password=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,2 );
			bp.waitForElement();
			actual[19]=exep.loginToDTS(username, password);
			bp.waitForElement();
			
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",2 ,6 );
			actual[20]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
	     String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",2 ,9 );
	     actual[21]=req.selectAccessTypeAndFolderName(accessType, folderName);
	     req.clickjiraSearchButton.click();
	     
	     	bp.waitForElement();
			String[] testCaseNo=new String[6];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    testCaseNo[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",4 ,4 ));
		    testCaseNo[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",5 ,4 ));
		    testCaseNo[5]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",6 ,4 ));
		    actual[22]=req.selectMultipleTestCaseFromGrid(testCaseNo);
		    bp.waitForElement();
			req.clickOnImportSelected.click();
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

	@When("^User copy the imported defect folder and paste in the release node$")
	public void user_copy_the_imported_defect_folder_and_paste_in_the_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",2,9);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
		    req=new RequirementsPage(driver);
	    	//actual[8]=tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	actual[23]=tr.navigateToNodes(ImportedName, fields);
	    	
		 	bp.waitForElement();
       		actual[24]=tr.copyNode();
			//ip.drag_action_1();
		  
       		tp=new TestPlanningPage(driver);
       		String folder="Imported";
       		tp.doubleClickOnCycle(folder);
       		
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[25]= req.doubleClickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	actual[26]=tr.pasteNode();
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

	@When("^User map jira requirement to the testcase$")
	public void user_map_jira_requirement_to_the_testcase() throws Throwable {
		try
	    {	
			req=new RequirementsPage(driver);
			bp=new BasePage();
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
	    	req.doubleClickOnRelease(releaseName);
	    	String[] navigation=new String[2];
	    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",2,9);
	    	navigation[1]=Excel_Lib.getData(INPUT_PATH_3,"Import",1,10);
	    	actual[27]=tr.navigateNode(navigation);
	    	bp.waitForElement();
	    	
	    	//bp.waitForElement();
	    	//actual[41]=tr.clickDetailButton();
	    	//bp.waitForElement();
	    	tr.clickOnDetails();
	    	actual[28]=bp.waitForElement();
	    	actual[29]=req.MapTestCases();
	    	bp.waitForElement();
	    	
	    	req=new RequirementsPage(driver);
			bp=new BasePage();
			bp.waitForElement();
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			bp.waitForElement();
			
			//actual[43]=req.ExpandRelease(releaseName);
			
			
			//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Phases", 1, 1);
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3, "Releases", 1, 0);
			bp.waitForElement();
			actual[30]=req.ExpandRelease(releaseName1);
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			String[] field=new String[1];
			field[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 3, 1);
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	 actual[31]=tr.navigateNode(field);
		 	 bp.waitForElement();
		 	 //actual[31]=tr.navigateToNode(phaseName, fields);
		 	 bp.waitForElement();
			String[] testCaseNo=new String[3];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    bp.waitForElement();
		    bp.waitForElement();
		    //bp.waitForElement();
		    //bp.waitForElement();
		    ///actual[32]=req.selectMultipleTestCaseFromGrids(testCaseNo);
		    actual[32]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
		    bp.waitForElement();
		    bp.waitForElement();
		    //WebElement ele=req.clickOnSavejirareq;
		    req.clickOnSavejirareq.click();
	    	
	    	//actual[33]=pp.clickOnLogout();
	    	actual[33]=bp.waitForElement();
	    	tr.clickOnList();
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

	@When("^User Launch TestPlanning and create cycle,create phase and assign some testcases to tester and some to anyone$")
	public void user_Launch_TestPlanning_and_create_cycle_create_phase_and_assign_some_testcases_to_tester_and_some_to_anyone() throws Throwable {
		try
		   {
			bp=new BasePage();
			rp=new ReleasePage(driver);
			pp=new ProjectPage(driver);
			bp.waitForElement();
			  actual[34]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 3, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[35]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[36]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[37]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[38]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 3, 0);
				actual[39]=tp.navigateToCycle(cycle1);
				
				 bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 3, 1);
				actual[40]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				actual[41]=tp.bulkAssignment(Bulk_Type);
				
				String[] cycle11=new String[1];
				cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 3, 1);
				bp.waitForElement();
				actual[42]=tp.navigateToCycle(cycle11);
				bp.waitForElement();
				
				int[] testCaseNo1=new int[4];
				testCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 19);
				testCaseNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 19);
				testCaseNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 3, 19);
				testCaseNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 4, 19);
				actual[43]=tp.selectSingleMultipleTestcase(testCaseNo1);
				bp.waitForElement();
				
				bp.waitForElement();
				String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
				actual[44]=tp.assignAllSelected(assignee);
				bp.waitForElement();
				bp.waitForElement();
				
				int[] testCaseNo2=new int[4];
				testCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 19);
				testCaseNo2[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 6, 19);
				testCaseNo2[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 7, 19);
				testCaseNo2[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 8, 19);
				actual[45]=tp.selectSingleMultipleTestcase(testCaseNo2);
				bp.waitForElement();
				
				bp.waitForElement();
				String assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 6, 9);
				actual[46]=tp.assignAllSelected(assignee2);
				bp.waitForElement();
				
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

	@When("^Tester Launch TestExecution and expand release,cycle and navigate to phase$")
	public void tester_Launch_TestExecution_and_expand_release_cycle_and_navigate_to_phase() throws Throwable {
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
			
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[48]=rp.clickOnTestExecution();
		
		String[] cycleName1=new String[3];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement",3 ,0 );
	    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement",3 ,1 );
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[49]=tp.navigateToCycle(cycleName1);
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

	@When("^select the testcase and execute testcases to the status pass/fail/Blocked and link a defect$")
	public void select_the_testcase_and_execute_testcases_to_the_status_pass_fail_Blocked_and_link_a_defect() throws Throwable {
		try
		{   
			bp=new BasePage();
			bp.waitForElement();
			int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[50]=exep.executeStatus(tcNo1[0], statusType1);
	    bp.waitForElement();
	    
	    int[] tcNo2=new int[1];
		tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
	    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[51]=exep.executeStatus(tcNo2[0], statusType2);
	    bp.waitForElement();
	    
	    int[] tcNo3=new int[1];
		tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
	    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[52]=exep.executeStatus(tcNo3[0], statusType3);
	    bp.waitForElement();
	    
	    int[] tcNo4=new int[1];
		tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
	    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[53]=exep.executeStatus(tcNo4[0], statusType4);
	    bp.waitForElement();
	    
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
	    bp.waitForElement();
	    actual[54]=exep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    
	    bp.waitForElement();
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    actual[55]=exep.linkDefect(defectId);
	    bp.waitForElement();
	    bp.waitForElement();
	    
//	    pp=new ProjectPage(driver);
//	    pp.clickOnLogout();
//	    pp.closeBrowser();
	    
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
