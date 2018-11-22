package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_82 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ReleasePage rp;
	TestRepositoryPage tr;
	BasePage bp;
	TestPlanningPage tl;
	ExecutionPage epp;
	DefectTracking dt;
	ProjectPage pp;
	boolean[] actual=new boolean[75];
	SoftAssert soft=new SoftAssert();
	String filename="Defect_Tracking_Search_82";
	
	
	@Given("^user will be in a test Repository app$")
	public void user_will_be_in_a_test_Repository_app() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			rp= new ReleasePage(driver);
			String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
			actual[0]=pp.selectProject(projectName);
			bp.waitForElement();
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[1]=pp.selectRelease(releaseName);
			bp.waitForElement();
			actual[2]=rp.clickOnTestRep();
			bp.waitForElement();
		}
		   catch(Exception e)
			{
			   lb=new LaunchBrowser();
			   lb.getScreenShot(filename);
				e.printStackTrace();
			   driver.close();
		      	Relogin_TPE rl=new Relogin_TPE();
		      	rl.reLogin();
		      	throw e; 	 
			}
	   
	}

	@When("^user creates a phase ,node and subnode$")
	public void user_creates_a_phase_node_and_subnode() throws Throwable {
		try
		{
			tr=new TestRepositoryPage(driver);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
	    	String name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
	    	String name2=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
	    	String name3=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
	    	String descp1=Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 1, 1);
	    	String[] phase1=new String[1];
	    	phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[2];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
	    	actual[3]=tr.clickOnRelease(releaseName);
	    	bp.waitForElement();
			bp.waitForElement();
			actual[4]=tr.addNode(name1,descp1);
			bp.waitForElement();
			bp.waitForElement();
		    actual[5]=tr.navigateToNode(releaseName, phase1);
		    bp.waitForElement();
		    actual[6]=tr.addNode(name2,descp1);
			bp.waitForElement();
			bp.waitForElement();
		    actual[7]=tr.navigateToNode(releaseName, phase2);
		    bp.waitForElement();
		    actual[8]=tr.addNode(name3,descp1);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@When("^user adds testcase to all three levels of nodes$")
	public void user_adds_testcase_to_all_three_levels_of_nodes() throws Throwable {
		try
		{
			String[] phase1=new String[1];
	    	phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[2];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			String[] phase3=new String[3];
			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			phase3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[9]=tr.navigateToNode(releaseName, phase1);
			bp.waitForElement();
			actual[10]=tr.addTestCase();
			bp.waitForElement();
			actual[11]=tr.navigateToNode(releaseName, phase2);
			bp.waitForElement();
			actual[12]=tr.addTestCase();
			bp.waitForElement();
			actual[13]=tr.navigateToNode(releaseName, phase3);
			bp.waitForElement();
			actual[14]=tr.addTestCase();
			bp.waitForElement();
 
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@Then("^testcase is successfully added to all three levels of nodes$")
	public void testcase_is_successfully_added_to_all_three_levels_of_nodes() throws Throwable {
		try
		{
			String[] phase1=new String[1];
	    	phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[2];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			String[] phase3=new String[3];
			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			phase3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			actual[15]=tr.navigateToNode(releaseName, phase1);
			bp.waitForElement();
			actual[16]=tr.verifyPresentTestCase();
			bp.waitForElement();
			actual[17]=tr.navigateToNode(releaseName, phase2);
			bp.waitForElement();
			actual[18]=tr.verifyPresentTestCase();
			bp.waitForElement();
    		actual[19]=tr.navigateToNode(releaseName, phase3);
			bp.waitForElement();
			actual[20]=tr.verifyPresentTestCase();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	@When("^user navigates to Test Planning app$")
	public void user_navigates_to_Test_Planning_app() throws Throwable {
		try
		{
			tl=new TestPlanningPage(driver);
			 actual[21]=rp.clickOnTestPlanning();
			 bp.waitForElement();
			 actual[22]=tl.clickOnAddTestCycleSymbol();
			 bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	     
	}

	@When("^user creates a cycle by entering all details$")
	public void user_creates_a_cycle_by_entering_all_details() throws Throwable {
		try
		{
			 String cyclename=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
		     String build=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 1);
		  	 String environment=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 2);
			 String hide=Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 1, 11);
			 String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 4));
			 String smonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 5);
		 	 String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 6));
			 String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 7));
			 String emonth=Excel_Lib.getData(INPUT_PATH_8, "Release", 1, 8);
			 String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_8, "Release", 1, 9));
			 actual[23]=tl.CreateCycle(cyclename, build, environment,hide); 
			 actual[24]=tl.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			 bp.waitForElement();
			 actual[25]=tl.saveTestCycle();
			 bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	  
	}

	@Then("^cycle created is validated successfullys$")
	public void cycle_created_is_validated_successfullys() throws Throwable {
		try
		{
			 actual[26]=tl.verifyAddTestCyclePage();	
			 bp.waitForElement();  
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	   
	}

	@When("^user clicks on test cycle and assign the phase$")
	public void user_clicks_on_test_cycle_and_assign_the_phase() throws Throwable {
		try
		{
			String cyclename1[]=new String[1];
			 cyclename1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
			 String nodeName=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);		
			 actual[27]=tl.navigateToCycle(cyclename1);
			 bp.waitForElement();		
			 actual[28]=tl.addPhaseToCycle(nodeName);
			 bp.waitForElement();  
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	  
	}

	@When("^user will assign bulk assignment to user$")
	public void user_will_assign_bulk_assignment_to_user() throws Throwable {
		try
		{
			 String bulk_Type=Excel_Lib.getData(INPUT_PATH_8,"Create cycle", 1, 4);
			 actual[29]=tl.bulkAssignment(bulk_Type);
		     bp.waitForElement();
		 	
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	

	@Then("^assign testcase to user is successfully validated of all three level nodes$")
	public void assign_testcase_to_user_is_successfully_validated_of_all_three_level_nodes() throws Throwable {
		try
		{
			String[] phase1=new String[1];
	    	phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[1];
			//phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			String[] phase3=new String[1];
//			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
//			phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
			String assignee=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_1");
			int tcNo[]=new int[1];
		    tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    actual[30]=tl.navigateToCycle(phase1);
		    bp.waitForElement();
			actual[31]=tl.validateAllAssigned(tcNo, assignee);
			bp.waitForElement();
			actual[32]=tl.navigateToCycle(phase2);
			bp.waitForElement();
			actual[33]=tl.validateAllAssigned(tcNo, assignee);
			bp.waitForElement();
			actual[34]=tl.navigateToCycle(phase3);
			bp.waitForElement();
			actual[35]=tl.validateAllAssigned(tcNo, assignee);
			bp.waitForElement();
			actual[36]=tl.goBackToCycle();
		    bp.waitForElement();    
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	@When("^user naviagtes to test Execution page$")
	public void user_naviagtes_to_test_Execution_page() throws Throwable {
		try
		{
			actual[37]=rp.clickOnTestExecution();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	  
	}

	@When("^user selects all three level nodes and changes the status$")
	public void user_selects_all_three_level_nodes_and_changes_the_status() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			String[] phase1=new String[2];
			phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[3];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			String[] phase3=new String[4];
			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			phase3[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[38]=tr.navigateToNode(releaseName, phase1);
		    bp.waitForElement();
		    actual[39]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		    actual[40]=tr.navigateToNode(releaseName, phase2);
		    bp.waitForElement();
		    actual[41]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		    actual[42]=tr.navigateToNode(releaseName, phase3);
		    bp.waitForElement();
		    actual[43]=epp.changeStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	@Then("^status changes of all three nodes must be validated successfully$")
	public void status_changes_of_all_three_nodes_must_be_validated_successfully() throws Throwable {
		try
		{
			epp=new ExecutionPage(driver);
			String[] phase1=new String[2];
			phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[3];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			String[] phase3=new String[4];
			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			phase3[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			int tcNo[]=new int[1];
			tcNo[0]=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
		    String statusType=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 3, 2);
		    actual[44]=tr.navigateToNode(releaseName, phase1);
		    bp.waitForElement();
		    actual[45]=epp.ValidateStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		    actual[46]=tr.navigateToNode(releaseName, phase2);
		    bp.waitForElement();
		    actual[47]=epp.ValidateStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		    actual[48]=tr.navigateToNode(releaseName, phase3);
		    bp.waitForElement();
		    actual[49]=epp.ValidateStatusOfTestCases(tcNo, statusType);
		    bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	@When("^user clicks on D icon button and will search the defect and links all three level nodes testcases$")
	public void user_clicks_on_D_icon_button_and_will_search_the_defect_and_links_all_three_level_nodes_testcases() throws Throwable {
		try
		{
			
			String[] phase1=new String[2];
			phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[3];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			String[] phase3=new String[4];
			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			phase3[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			  actual[50]=tr.navigateToNode(releaseName, phase1);
			  bp.waitForElement();
			  actual[51]=epp.clickOnDefectButton(tcno);
			  bp.waitForElement();
			  actual[52]=epp.searchDefect(defectId);
			  bp.waitForElement();
		      actual[53]=epp.validateSearchedDefect(defectId);
			  bp.waitForElement();
			  actual[54]=epp.linkDefect();
			  bp.waitForElement();
		      actual[55]=tr.navigateToNode(releaseName, phase2);
		      bp.waitForElement();
			  actual[56]=epp.clickOnDefectButton(tcno);
			  bp.waitForElement();
			  actual[57]=epp.searchDefect(defectId);
	   	      bp.waitForElement();
			  actual[58]=epp.validateSearchedDefect(defectId);
			  bp.waitForElement();
			  actual[59]=epp.linkDefect();
			  bp.waitForElement();
		      actual[60]=tr.navigateToNode(releaseName, phase3);
		      bp.waitForElement();
			  actual[61]=epp.clickOnDefectButton(tcno);
			  bp.waitForElement();
			  actual[62]=epp.searchDefect(defectId);
			  bp.waitForElement();
			  actual[63]=epp.validateSearchedDefect(defectId);
			  bp.waitForElement();
			  actual[64]=epp.linkDefect();
			  bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	}

	@Then("^linked testcase of all three level node must be validated successfully$")
	public void linked_testcase_of_all_three_level_node_must_be_validated_successfully() throws Throwable {
		try
		{
			
			String[] phase1=new String[2];
			phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase1[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			String[] phase2=new String[3];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			String[] phase3=new String[4];
			phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
	    	phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 0);
			phase3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 1);
			phase3[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Defect_Tracking", 7, 2);
			String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
			int tcno=Excel_Lib.getNumberData(INPUT_PATH_8, "TestExec", 1, 0);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[65]=tr.navigateToNode(releaseName, phase1);
			bp.waitForElement();
			actual[66]=epp.validateLinkedDefect(tcno, defectId);
			bp.waitForElement();
			actual[67]=tr.navigateToNode(releaseName, phase1);
			bp.waitForElement();
			actual[68]=epp.validateLinkedDefect(tcno, defectId);
			bp.waitForElement();
			actual[69]=tr.navigateToNode(releaseName, phase1);
			bp.waitForElement();
			actual[70]=epp.validateLinkedDefect(tcno, defectId);
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	  
	}

	@When("^user navigates to DT page$")
	public void user_navigates_to_DT_page() throws Throwable {
		try
		{
			
			actual[71]=pp.clickOnDefectTracking();
			bp.waitForElement();
			bp.waitForElement();
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	@When("^user searches for the defectID and clicked on seacrched button$")
	public void user_searches_for_the_defectID_and_clicked_on_seacrched_button() throws Throwable {
		try
		{
			dt=new DefectTracking(driver);
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			actual[72]=dt.searchDefect(defectId);
			bp.waitForElement();
			
		}
		catch(Exception e)
		{
		   lb=new LaunchBrowser();
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	    
	}

	@Then("^user Search linked defect at phase,node,subnode and also must view cycle and testcase in search grid in defect tracking app$")
	public void user_Search_linked_defect_at_phase_node_subnode_and_also_must_view_cycle_and_testcase_in_search_grid_in_defect_tracking_app() throws Throwable {
		try
		{
			String defectId=Excel_Lib.getData(INPUT_PATH_8, "TestExec", 1, 4);
			String testCycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_8, "Create cycle", 4, 0);
			actual[73]=dt.validateDefect(defectId);
			bp.waitForElement();
			actual[74]=dt.vlaidateTestCaseCycle(testCycle);
			bp.waitForElement();
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
		   lb.getScreenShot(filename);
			e.printStackTrace();
		   driver.close();
	      	Relogin_TPE rl=new Relogin_TPE();
	      	rl.reLogin();
	      	throw e; 	 
		}
	}



}
