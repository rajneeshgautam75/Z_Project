package com.zephyr_batch_2.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.ImportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestExecution_878822 extends LaunchBrowser{

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
	ExternalJiraPage ejp;
	
	boolean[] actual=new boolean[71];
	SoftAssert soft=new SoftAssert();	
	
	 String fileName="TestExecution_878822";
	 
	@When("^Lead Launch TestRepository and create a phase with testcases$")
	public void lead_Launch_TestRepository_and_create_a_phase_with_testcases() throws Throwable {
		try
		   {
			lb=new LaunchBrowser();
			bp=new BasePage();
		   pp=new ProjectPage(driver);
		   pp.clickOnLogout();
		   lp=new LoginPage(driver);
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
			String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
			lp.enterUname(Uname);
			lp.enterPass(Pass);
			lp.clickOnLogin();
		   
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[0]=pp.selectProject(projectName);
	    	 actual[1]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[2]=rp.clickOnTestRep(); 
			   
		  
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 11, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 11, 4);
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			actual[3]=tr.doubleClickOnRelease(releaseName);
			actual[4]=tr.addNode(p_Name1,p_Desc1);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase);
			for(int i=0;i<=5;i++)
			{
			actual[5]=tr.addTestCase();
			}
	   
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

	@When("^Launch TestExecution and execute few testcases and link defects$")
	public void launch_TestExecution_and_execute_few_testcases_and_link_defects() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[6]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 11, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[7]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[8]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[9]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[10]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 11, 0);
				actual[11]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 11, 1);
				actual[12]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[13]=tp.bulkAssignment(Bulk_Type);
				
				/*actual[14]=pp.clickOnLogout();
				bp.waitForElement();
				
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
			    	 pp.selectRelease(releaseName);*/
					
				actual[14]=bp.waitForElement();
					rp= new ReleasePage(driver);
				actual[15]=rp.clickOnTestExecution();
				
				String[] cycleName1=new String[3];
			    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
			    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment",11 ,0 );
			    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment",11 ,1 );
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[16]=tp.navigateToCycle(cycleName1); 
				
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[17]=exep.executeStatus(tcNo1[0], statusType1);
			    bp.waitForElement();
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[18]=exep.executeStatus(tcNo2[0], statusType2);
			    bp.waitForElement();
			    
			    int[] tcNo3=new int[1];
				tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[19]=exep.executeStatus(tcNo3[0], statusType3);
			    bp.waitForElement();
			    
			    int[] tcNo4=new int[1];
				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[20]=exep.executeStatus(tcNo4[0], statusType4);
			    bp.waitForElement();
			    
			    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
			    bp.waitForElement();
			    actual[21]=exep.clickOnDefectButton(testcase1);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    actual[22]=exep.linkDefect(defectId1);
			    bp.waitForElement();
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			    bp.waitForElement();
			    actual[23]=exep.clickOnDefectButton(testcase2);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[24]=exep.linkDefect(defectId2);
			    bp.waitForElement();
			    bp.waitForElement();

			    bp.waitForElement();
			    int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
			    bp.waitForElement();
			    actual[25]=exep.clickOnDefectButton(testcase3);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[26]=exep.linkDefect(defectId3);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();

			    bp.waitForElement();
			    int testcase4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,8 );
			    bp.waitForElement();
			    actual[27]=exep.clickOnDefectButton(testcase4);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[28]=exep.linkDefect(defectId4);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();

			    
			    exep.clickOnLinkDefectID.click();
			    
			    //actual[29]=pp.clickOnLogout();
			    actual[29]=bp.waitForElement();
			    
			    
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

	@When("^Launch external Jira and edit priority$")
	public void launch_external_Jira_and_edit_priority() throws Throwable {
	   try
	   {   bp.waitForElement();
	   
		//driver.navigate().to("http://52.8.222.160:3530/login.jsp");
		bp.waitForElement();
		ejp=new ExternalJiraPage(driver);
		String username=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,3 );
		String password=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,2 );
		//actual[30]=ejp.loginToExternalJira(username, password);
		actual[30]=bp.waitForElement();
		
		//String projectName=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,26 );
		//actual[31]=ejp.selectProject(projectName);
		actual[31]=bp.waitForElement();
		
		//edit priority
		String[] priority=new String[1]; 
		 priority[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,27 );
		
		actual[32]=ejp.enterPriority(priority);
		bp.waitForElement();
		bp.waitForElement();
		actual[33]=ejp.logOutFromExternal_JIRA();
		   bp.waitForElement();
		   driver.close();
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

	@When("^As a Lead,Launch TestRepository and create a phase with testcases and add teststeps to few testcases and create two systems to phase$")
	public void as_a_Lead_Launch_TestRepository_and_create_a_phase_with_testcases_and_add_teststeps_to_few_testcases_and_create_two_systems_to_phase() throws Throwable {
		try
		   {
			bp=new BasePage();
			//lb=new LaunchBrowser();
			
			
			
			lb=new LaunchBrowser();
	    	 lb.preCond();
	    	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
	    	 lb.getUrl(url);
	    	 bp.waitForElement();
	    	 lp=new LoginPage(driver);
	    	 String name=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Username_1");
	    	 String passWord=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Lead_Password_1");
	    	 lp.enterUnameAndPassword(name, passWord);
	    	 bp.waitForElement();
	    	// lp.clickOnLogin();
	    	 bp.waitForElement();
	    	
			
			
			

			 bp.waitForElement();
		   pp=new ProjectPage(driver);
		   String releaseName=Excel_Lib.getData(INPUT_PATH_3,"Releases",6,0);
		   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Normal_Project_1");
	    	 bp.waitForElement();
	    	 actual[34]=pp.selectProject(projectName);
	    	 actual[35]=pp.selectRelease(releaseName);
	    	 
	    	 rp= new ReleasePage(driver);
			   bp.waitForElement();
			   actual[36]=rp.clickOnTestRep(); 
			   
		  // String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 6, 0);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 12, 1);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 11, 4);
			tr=new TestRepositoryPage(driver);
			bp=new BasePage();
			actual[37]=tr.doubleClickOnRelease(releaseName);
			actual[38]=tr.addNode(p_Name1,p_Desc1);
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr.doubleClickOnRelease(releaseName);
			bp.waitForElement();
			tr.navigateToNode(releaseName, phase);
			for(int i=0;i<=5;i++)
			{
			actual[39]=tr.addTestCase();
			}
	   
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
	
	@When("^Launch TestExecution and execute the few testcases and link defects$")
	public void launch_TestExecution_and_execute_the_few_testcases_and_link_defects() throws Throwable {
		try
		   {
			bp.waitForElement();
			  actual[40]=rp.clickOnTestPlanning();
			  
			  tp=new TestPlanningPage(driver);
				//String[] str=new String[4];
				String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 12, 0);
				String Build=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 2, 0);
				String environ=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 3, 0);
				String hide=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 100, 100);
				actual[41]=tp.clickOnAddTestCycleSymbol();
				bp.waitForElement();
				bp.waitForElement();
				actual[42]=tp.CreateCycle(cycle, Build, environ, hide);
				String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 23));
				String smonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 10, 22);
				String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 21));
				String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 26));
				String emonth=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning", 8, 25);
				String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning", 1, 24));
				bp.waitForElement();
				actual[43]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
				bp.waitForElement();
				actual[44]=tp.saveTestCycle();
				
				String[] cycle1=new String[1];
				cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 12, 0);
				actual[45]=tp.navigateToCycle(cycle1);
				
				bp.waitForElement();
				String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 12, 1);
				actual[46]=tp.addPhaseToCycle(Phase);
				bp.waitForElement();
				
				
				
				bp.waitForElement();
				String Bulk_Type=Excel_Lib.getData(INPUT_PATH_3, "BulkAssignment", 1, 0);
				bp.waitForElement();
				actual[47]=tp.bulkAssignment(Bulk_Type);
				bp.waitForElement();
				String[] phase2=new String[1];
				phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment", 12, 1);
				tp.navigateToCycle(phase2);
				
				int[] testcase=new int[4];
				testcase[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
				testcase[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
				testcase[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
				testcase[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
				String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"User3");
				tp.individualAssinTo(testcase, assignee);
				bp.waitForElement();
				actual[48]=pp.clickOnLogout();
				bp.waitForElement();
				
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
				actual[49]=rp.clickOnTestExecution();
				
				String[] cycleName1=new String[3];
			    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
			    cycleName1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment",12 ,0 );
			    cycleName1[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "TestExecution_Attachment",12 ,1 );
			    bp.waitForElement();
			    tp=new TestPlanningPage(driver);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();
				actual[50]=tp.navigateToCycle(cycleName1); 
				
				int[] tcNo1=new int[1];
				tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,19 );
			    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[51]=exep.executeStatus(tcNo1[0], statusType1);
			    bp.waitForElement();
			    
			    int[] tcNo2=new int[1];
				tcNo2[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,19 );
			    String statusType2=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[52]=exep.executeStatus(tcNo2[0], statusType2);
			    bp.waitForElement();
			    
			    int[] tcNo3=new int[1];
				tcNo3[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,19 );
			    String statusType3=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",2 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[53]=exep.executeStatus(tcNo3[0], statusType3);
			    bp.waitForElement();
			    
			    int[] tcNo4=new int[1];
				tcNo4[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,19 );
			    String statusType4=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",4 ,18 );
			    bp.waitForElement();
			    bp.waitForElement();
			    exep=new ExecutionPage(driver);
			    actual[54]=exep.executeStatus(tcNo4[0], statusType4);
			    bp.waitForElement();
			    
			    int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",1 ,8 );
			    bp.waitForElement();
			    actual[55]=exep.clickOnDefectButton(testcase1);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId1=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    actual[56]=exep.linkDefect(defectId1);
			    bp.waitForElement();
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    int testcase2=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",2 ,8 );
			    bp.waitForElement();
			    actual[57]=exep.clickOnDefectButton(testcase2);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId2=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[58]=exep.linkDefect(defectId2);
			    bp.waitForElement();
			    bp.waitForElement();

			    bp.waitForElement();
			    int testcase3=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",3 ,8 );
			    bp.waitForElement();
			    actual[59]=exep.clickOnDefectButton(testcase3);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId3=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[60]=exep.linkDefect(defectId3);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();

			    bp.waitForElement();
			    int testcase4=Excel_Lib.getNumberData(INPUT_PATH_3, "TestPlanning",4 ,8 );
			    bp.waitForElement();
			    actual[61]=exep.clickOnDefectButton(testcase4);
			    bp.waitForElement();
			    
			    bp.waitForElement();
			    String defectId4=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,21 );
			    bp.waitForElement();
			    bp.waitForElement();
			    actual[62]=exep.linkDefect(defectId4);
			    bp.waitForElement();
			    bp.waitForElement();
			    bp.waitForElement();

			    actual[63]=pp.clickOnLogout();
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

	@When("^Launch External Jira and edit priority$")
	public void launch_External_Jira_and_edit_priority() throws Throwable {
		try
		   {
			bp.waitForElement();
			driver.navigate().to("http://52.8.222.160:3530/login.jsp");
			bp.waitForElement();
			
			String username=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,3 );
			String password=Excel_Lib.getData(INPUT_PATH_3, "Login",1 ,2 );
			actual[64]=ejp.loginToExternalJira(username, password);
			bp.waitForElement();
			
			String projectName=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",1 ,26 );
			actual[65]=ejp.selectProject(projectName);
			bp.waitForElement();
			
			//edit priority
			String[] priority=new String[1];
		 priority[0]=Excel_Lib.getData(INPUT_PATH_3, "ExecuteStatus",2 ,27 );
			//priority[0]=
			actual[66]=ejp.enterPriority(priority);
			bp.waitForElement();
			
			actual[67]=ejp.logOutFromExternal_JIRA();
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

	@When("^Launch TestExecution and select release node and click on sync$")
	public void launch_TestExecution_and_select_release_node_and_click_on_sync() throws Throwable {
	    try
	    {
	    	lp=new LoginPage(driver);
	    	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"URL");
			String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Username_1");
			   String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_TPE,"Tester_Password_1");
			   driver.navigate().to(url);
			   bp.waitForElement();
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
			actual[68]=rp.clickOnTestExecution();
			
			String[] cycleName1=new String[1];
		    cycleName1[0]=Excel_Lib.getData(INPUT_PATH_3, "Releases",6 ,0 );
		    bp.waitForElement();
		    tp=new TestPlanningPage(driver);
		    bp.waitForElement();
		    bp.waitForElement();
		    bp.waitForElement();
			actual[69]=tp.navigateToCycle(cycleName1); 
			
			actual[70]=exep.syncDefects();
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

	@Then("^view progress bar window with % of completion$")
	public void view_progress_bar_window_with_of_completion() throws Throwable {
	   try
	   {
		   pp=new ProjectPage(driver);
		   bp.waitForElement();
		   pp.clickOnLogout();
		   pp.closeBrowser();

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
