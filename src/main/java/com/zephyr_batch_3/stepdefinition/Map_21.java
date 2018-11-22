package com.zephyr_batch_3.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.NavigationPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Map_21 extends LaunchBrowser
{
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	TestRepositoryPage tp;
	NavigationPage np;
	RequirementsPage req;
	BasePage bp;
	String fileName="Map_21";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[34];
	 SoftAssert soft=new SoftAssert();
	@Given("^user in Repository Page to create Node and add test cases$")
	public void user_in_Repository_Page_to_create_Node_and_add_test_cases() throws Throwable 
	{
		try
		   {
			   pp=new ProjectPage(driver);
			   bp=new BasePage();
			   rp=new ReleasePage(driver);
			   String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Normal_Project_1");
			   actual[0]=pp.selectProject(projectName);
			   actual[1]=pp.selectRelease(releaseName);
			   bp.waitForElement();
			   rp.clickOnTestRep();
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

	@Given("^create node and add testcases for phase and system$")
	public void create_node_and_add_testcases_for_phase_and_system() throws Throwable 
	{
		try
		{
			////////add phase////////
			tr=new TestRepositoryPage(driver);
			tr.clickOnRelease(releaseName);
			String phaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 0);
			String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 1);
			actual[2]=tr.addNode(phaseName1, phaseDesc);
			String phase1[]=new String[1];
			phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 0);
			actual[6]=tr.navigateToNode(releaseName, phase1);
			actual[7]=tr.addTestCase();
			actual[7]=tr.addTestCase();
			actual[7]=tr.addTestCase();
			actual[7]=tr.addTestCase();
			///////add system/////////////////////////////////
			tr.navigateToNode(releaseName, phase1);
			String phaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 2);
			String phaseDesc2=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 3);
			actual[3]=tr.addNode(phaseName2, phaseDesc2);
			String phase2[]=new String[2];
			phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 0);
			phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 2);
			actual[4]=tr.navigateToNode(releaseName, phase2);
			actual[5]=tr.addTestCase();
			actual[6]=tr.addTestCase();
			actual[7]=tr.addTestCase();
			actual[8]=tr.addTestCase();
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

	@When("^Launch Requirments Create node and Add Requirements$")
	public void launch_Requirments_Create_node_and_Add_Requirements() throws Throwable 
	{
		try
		{
	    	bp.waitForElement();
			rp= new ReleasePage(driver);
		    rp.clickOnRequirements();
		    bp.waitForElement();
			req=new RequirementsPage(driver);
			tr.clickOnRelease(releaseName);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Requirements", 2, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_4, "Requirements", 2, 1);
			req.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[9]=tr.navigateToNode(releaseName, phase);
			for(int i=0;i<=5;i++)
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

	@When("^Select a One requirement from a Phase click on Map Testcase Select One testcase from tree Phase and save$")
	public void select_a_One_requirement_from_a_Phase_click_on_Map_Testcase_Select_One_testcase_from_tree_Phase_and_save() throws Throwable {
		 try
		   {
			 
			 tr.clickDetailButton();
			 	String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0 ));
				bp.waitForElement();
				actual[10]=req.selectMultipleRequirementFromGrids(testCaseNo1);
				bp.waitForElement();
				req=new RequirementsPage(driver);
				actual[11]=req.MapTestCases();
		    	actual[12]=req.ExpandRelease(releaseName);
		    	bp.waitForElement();
		    	String[] fields=new String[1];
		    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 67, 0);
			 	 bp.waitForElement();
			 	 bp.waitForElement();
			 	 actual[13]=tr.navigateNode(fields);
			 	 bp.waitForElement();
				String[] testCaseNo=new String[1];
				testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0 ));
				actual[14]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
				bp.waitForElement();
				req.clickOnSavejirareq.click();
				bp.waitForElement();
				int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
				actual[15]=req.requirementCoverageDetails(tcNo);
				bp.waitForElement();
				actual[16]=req.selectMultipleRequirementFromGrids(testCaseNo1);
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

	@When("^Select One more requirement from a Phase click on Map testcase Select Complete Node from tree and save$")
	public void select_One_more_requirement_from_a_Phase_click_on_Map_testcase_Select_Complete_Node_from_tree_and_save() throws Throwable {
		 try
		   {
			 	String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",2 ,0 ));
				bp.waitForElement();
				actual[17]=req.selectMultipleRequirementFromGrids(testCaseNo1);
				bp.waitForElement();
				req=new RequirementsPage(driver);
				actual[18]=req.MapTestCases();
		    	actual[19]=req.ExpandRelease(releaseName);
		    	bp.waitForElement();
		    	String[] phaseName1=new String[1];
		    	phaseName1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 0);
		    	//phaseName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 2);
		    	tr.navigateNode(phaseName1);
		    	String Phase1=phaseName1[0];
		    	req.clickOnChecKBox(Phase1);
		    	bp.waitForElement();
				req.clickOnSavejirareq.click();
				bp.waitForElement();
				int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
				actual[20]=req.requirementCoverageDetails(tcNo);
				bp.waitForElement();
				actual[21]=req.selectMultipleRequirementFromGrids(testCaseNo1);
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

	@Then("^select the same requirement and uncheck the checked testcases and check$")
	public void select_the_same_requirement_and_uncheck_the_checked_testcases_and_check() throws Throwable {
		try
		{
			String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0 ));
			bp.waitForElement();
			actual[22]=req.selectMultipleRequirementFromGrids(testCaseNo1);
			bp.waitForElement();
			bp.waitForElement();
			req=new RequirementsPage(driver);
			actual[23]=req.MapTestCases();
	    	actual[24]=req.ExpandRelease(releaseName);
	    	bp.waitForElement();
	    	String[] fields=new String[1];
	    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 67, 0);
		 	 bp.waitForElement();
		 	 bp.waitForElement();
		 	 actual[25]=tr.navigateNode(fields);
		 	 bp.waitForElement();
			String[] testCaseNo=new String[1];
			testCaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0 ));
			actual[26]=req.mapTestCasesToRequirementsFromGrids(testCaseNo);
			bp.waitForElement();
			req.clickOnSavejirareq.click();
			bp.waitForElement();
			//check whether it is unmapped
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
			//actual[27]=req.requirementCoverageDetails(tcNo);
			//bp.waitForElement();
			actual[27]=req.selectMultipleRequirementFromGrids(testCaseNo1);
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

	@Then("^Select another single requirement from a node click on Map testcase Select Complete sub Node from tree and save$")
	public void select_another_single_requirement_from_a_node_click_on_Map_testcase_Select_Complete_sub_Node_from_tree_and_save() throws Throwable {
		 try
		   {
			 	String[] testCaseNo1=new String[1];
				testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",3,0 ));
				bp.waitForElement();
				actual[28]=req.selectMultipleRequirementFromGrids(testCaseNo1);
				bp.waitForElement();
				req=new RequirementsPage(driver);
				actual[29]=req.MapTestCases();
		    	actual[30]=req.ExpandRelease(releaseName);
		    	bp.waitForElement();
		    	String[] phaseName2=new String[2];
		    	phaseName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 0);
		    	phaseName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 2);
		    	tr.navigateNode(phaseName2);
		    	String phase2=phaseName2[1];
		    	req.clickOnChecKBox(phase2);
		    	bp.waitForElement();
				req.clickOnSavejirareq.click();
				bp.waitForElement();
				int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",3 ,0);
				actual[31]=req.requirementCoverageDetails(tcNo);
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

	@Then("^Select same requirement from a Phase click on Map testcase uncheck sub Node from tree and save$")
	public void select_same_requirement_from_a_Phase_click_on_Map_testcase_uncheck_sub_Node_from_tree_and_save() throws Throwable {
		try
		{
			req=new RequirementsPage(driver);
			actual[32]=req.MapTestCases();
	    	actual[33]=req.ExpandRelease(releaseName);
	    	bp.waitForElement();
	    	String[] phaseName2=new String[2];
	    	phaseName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 0);
	    	phaseName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 67, 2);
	    	tr.navigateNode(phaseName2);
	    	String phase2=phaseName2[1];
	    	req.clickOnChecKBox(phase2);
	    	bp.waitForElement();
			req.clickOnSavejirareq.click();
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

	@Then("^Requirement to testcase had been unmapped$")
	public void requirement_to_testcase_had_been_unmapped() throws Throwable 
	{
		try
		{
			//int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
			//actual[34]=req.requirementCoverageDetails(tcNo);
			bp.waitForElement();
			tr.clickOnList();
			//bp.waitForElement();
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
