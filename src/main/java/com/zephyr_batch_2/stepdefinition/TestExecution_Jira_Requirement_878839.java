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

public class TestExecution_Jira_Requirement_878839 extends LaunchBrowser{

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
	
	boolean[] actual=new boolean[55];
	SoftAssert soft=new SoftAssert();
	
	 String fileName="TestExecution_Jira_Requirement_878839";
	 
	@Given("^Manager is in administration page and click on general configuration,click on jira remote link$")
	public void manager_is_in_administration_page_and_click_on_general_configuration_click_on_jira_remote_link() throws Throwable {
		try
	    {
			lb=new LaunchBrowser();
			bp=new BasePage();
	    	pp=new ProjectPage(driver);
	    	bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	ccp=new CreateCustomFieldsPage(driver);
			lp=new LoginPage(driver);
			
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Manager_Password_1");
			   
			   lp.enterUname(Uname);
			   lp.enterPass(Pass);
			   lp.clickOnLogin();
			
	    	exep=new ExecutionPage(driver);
	    	bp.waitForElement();
	    	actual[0]=ccp.navigatingToGeneralConfigurationTab();
	    	bp.waitForElement();
	    	String linkType=Excel_Lib.getData(INPUT_PATH_3,"Map_Jira_Requirement",1,3);
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

	@When("^Lead Launch TestRepository and creates a phase and create testcases$")
	public void lead_Launch_TestRepository_and_creates_a_phase_and_create_testcases() throws Throwable {
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
				String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 1, 1);
				String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 1, 2);
				
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
				
				
				bp.waitForElement();
				ep=new ExportPage(driver);
				String[] testcase11=new String[1];
				testcase11[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 8));
				actual[9]=ep.selectMultipleTestCaseFromGrid(testcase11);
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

	@When("^User Launch TestPlanning and create a cycle and create a phase and assign testcases to tester$")
	public void user_Launch_TestPlanning_and_create_a_cycle_and_create_a_phase_and_assign_testcases_to_tester() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[17]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 1, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[18]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[19]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[20]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[21]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 1, 0);
				actual[22]=tp.navigateToCycle(cycle1);
				
				 bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 1, 1);
				actual[23 ]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				actual[24]=tp.bulkAssignment(Bulk_Type);
				
				String[] cycle11=new String[1];
				cycle11[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 1, 1);
				bp.waitForElement();
				actual[25]=tp.navigateToCycle(cycle11);
				bp.waitForElement();
				
				int[] testCaseNo1=new int[4];
				testCaseNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 19);
				testCaseNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 2, 19);
				testCaseNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 3, 19);
				testCaseNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 4, 19);
				actual[26]=tp.selectSingleMultipleTestcase(testCaseNo1);
				bp.waitForElement();
				
				bp.waitForElement();
				String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User2");
				actual[27]=tp.assignAllSelected(assignee);
				bp.waitForElement();
				
				int[] testCaseNo2=new int[4];
				testCaseNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 5, 19);
				testCaseNo2[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 6, 19);
				testCaseNo2[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 7, 19);
				testCaseNo2[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 8, 19);
				actual[28]=tp.selectSingleMultipleTestcase(testCaseNo2);
				bp.waitForElement();
				
				bp.waitForElement();
				String assignee2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 6, 9);
				actual[29]=tp.assignAllSelected(assignee2);
				bp.waitForElement();
				
				tp.goBackToCycle();
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

	@When("^User Launch Requirement and select release and perform import operation$")
	public void user_Launch_Requirement_and_select_release_and_perform_import_operation() throws Throwable {
	    try
	    {
	    	/*bp=new BasePage();//
	    	pp=new ProjectPage(driver);
	    	bp.waitForElement();
	    	pp.clickOnLogout();
	    	bp.waitForElement();
	    	tp=new TestPlanningPage(driver);
	    	exep=new ExecutionPage(driver);
		
			lp=new LoginPage(driver);
			
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
		    	 pp.selectRelease(releaseName);*///
	    	bp=new BasePage();
	    	rp= new ReleasePage(driver);
	    	exep=new ExecutionPage(driver);
			   bp.waitForElement();
			   actual[30]=rp.clickOnRequirements();
			   
			   req=new RequirementsPage(driver);
		    	req.import_Requirement.click();
			String importType=Excel_Lib.getData(INPUT_PATH_3, "Import",1 ,5 );
			actual[31]=req.chooseImportType(importType);
			
			bp.waitForElement();
			String username=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,3 );
			String password=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,2 );
			bp.waitForElement();
			actual[32]=exep.loginToDTS(username, password);
			bp.waitForElement();
			
			String selectQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",1,8 );
			String enterQuerry=Excel_Lib.getData(INPUT_PATH_3, "Import",2 ,6 );
			actual[33]=req.selectQuerry(selectQuerry, enterQuerry);
	     
	     String accessType=Excel_Lib.getData(INPUT_PATH_3, "Import",6 ,7 );
	     String folderName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Import",3 ,9 );
	     actual[34]=req.selectAccessTypeAndFolderName(accessType, folderName);
	     req.clickjiraSearchButton.click();
	     
	     	bp.waitForElement();
			String[] testCaseNo=new String[6];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    testCaseNo[3]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",4 ,4 ));
		    testCaseNo[4]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",5 ,4 ));
		    testCaseNo[5]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",6 ,4 ));
		    actual[35]=req.selectMultipleTestCaseFromGrid(testCaseNo);
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

	@When("^User copy the imported defect from imported folder and paste in release node$")
	public void user_copy_the_imported_defect_from_imported_folder_and_paste_in_release_node() throws Throwable {
		try
	    {
		  bp=new BasePage();
		String fileName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",3,9);
		String ImportedName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,2);
		
		    tr=new TestRepositoryPage(driver);
	    	//actual[8]=tr.doubleClickOnRelease(ImportedName);
	    	String[] fields=new String[1];
		 	 fields[0]=fileName;
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	actual[36]=tr.navigateToNodes(ImportedName, fields);
	    	
		 	bp.waitForElement();
       		actual[37]=tr.copyNode();
       		
       		tp=new TestPlanningPage(driver);
       		String folder="Imported";
       		tp.doubleClickOnCycle(folder);
			//ip.drag_action_1();
		  
		    bp.waitForElement();
			String releaseName1=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
		 	actual[38]= req.clickOnRelease(releaseName1);
		 	bp.waitForElement();
		 	actual[39]=tr.pasteNode();
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

	@When("^User map jira requirement to testcase$")
	public void user_map_jira_requirement_to_testcase() throws Throwable {
	    try
	    {	
	    	req=new RequirementsPage(driver);
			bp=new BasePage();
	    	String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",1,0);
	    	req.doubleClickOnRelease(releaseName);
	    	String[] navigation=new String[2];
	    	navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3,"Import",3,9);
	    	navigation[1]=Excel_Lib.getData(INPUT_PATH_3,"Import",1,10);
	    	actual[40]=tr.navigateNode(navigation);
	    	bp.waitForElement();
	    	
	    	String requirementNum =Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    	//req.selectRequirement(requirementNum);
	    	bp.waitForElement();
	    	
	    	//bp.waitForElement();
	    	//actual[41]=tr.clickDetailButton();
	    	//bp.waitForElement();
	    	tr.clickOnDetails();
	    	actual[41]=bp.waitForElement();
	    	
	    	//String requirementNum =Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
	    	req.selectRequirement(requirementNum);
	    	bp.waitForElement();
	    	
	    	actual[42]=req.MapTestCases();
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
			req.ExpandRelease(releaseName1);
			tr=new TestRepositoryPage(driver);
			actual[43]=bp.waitForElement();
			String[] field=new String[1];
			field[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement", 1, 1);
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	 actual[44]=tr.navigateNode(field);
		 	 bp.waitForElement();
			String[] testCaseNo=new String[3];
		    testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",1 ,4 ));
		    testCaseNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",2 ,4 ));
		    testCaseNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestCases",3 ,4 ));
		    bp.waitForElement();
		    req=new RequirementsPage(driver);
		   // actual[45]=req.selectMultipleTestCaseFromGrids(testCaseNo);
		    
		    actual[45]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
		    bp.waitForElement();
		    bp.waitForElement();
		    //WebElement ele=req.clickOnSavejirareq;
		    req.clickOnSavejirareq.click();
		    bp.waitForElement();
		    tr.clickOnList();
	    	
		    pp=new ProjectPage(driver);
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

	@When("^User login as Tester,Launch TestExecution and expand release,cycle and select phase$")
	public void user_login_as_Tester_Launch_TestExecution_and_expand_release_cycle_and_select_phase() throws Throwable {
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
			
			bp.waitForElement();
			rp= new ReleasePage(driver);
		actual[47]=rp.clickOnTestExecution();
		
		String[] cycleName1=new String[3];
	    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
	    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement",1 ,0 );
	    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Map_Jira_Requirement",1 ,1 );
	    bp.waitForElement();
	    tp=new TestPlanningPage(driver);
	    bp.waitForElement();
	    bp.waitForElement();
	    bp.waitForElement();
		actual[48]=tp.navigateToCycle(cycleName1);
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

	@When("^User select testcase and execute testcase to pass/fail/blocked and link a defect$")
	public void user_select_testcase_and_execute_testcase_to_pass_fail_blocked_and_link_a_defect() throws Throwable {
		try
		{
			bp.waitForElement();
			int[] tcNo1=new int[1];
		tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
	    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[49]=exep.executeStatus(tcNo1[0], statusType1);
	    bp.waitForElement();
	    
	    int[] tcNo2=new int[1];
		tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
	    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[50]=exep.executeStatus(tcNo2[0], statusType2);
	    bp.waitForElement();
	    
	    int[] tcNo3=new int[1];
		tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
	    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",6 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[51]=exep.executeStatus(tcNo3[0], statusType3);
	    bp.waitForElement();
	    
	    int[] tcNo4=new int[1];
		tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
	    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
	    bp.waitForElement();
	    bp.waitForElement();
	    exep=new ExecutionPage(driver);
	    actual[52]=exep.executeStatus(tcNo4[0], statusType4);
	    bp.waitForElement();
	    
	    
//	    int[] tcNo5=new int[1];
//		tcNo5[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",5 ,19 );
//	    String statusType5=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",8 ,18 );
//	    bp.waitForElement();
//	    bp.waitForElement();
//	    exep=new ExecutionPage(driver);
//	    actual[53]=exep.executeStatus(tcNo5[0], statusType5);
	    bp.waitForElement();
	    
	    int testcase=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
	    bp.waitForElement();
	    actual[53]=exep.clickOnDefectButton(testcase);
	    bp.waitForElement();
	    
	    bp.waitForElement();
	    String defectId=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
	    bp.waitForElement();
	    bp.waitForElement();
	    actual[54]=exep.linkDefect(defectId);
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

	@Then("^testcase jira defect remote link should be created$")
	public void testcase_jira_defect_remote_link_should_be_created() throws Throwable {
		try
	    {
			
			//pp=new ProjectPage(driver);
			
			bp.waitForElement();
//			pp.closeBrowser();
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
