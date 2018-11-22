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

public class Map_19 extends LaunchBrowser
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
	String fileName="Map_19";
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_REQ, "Release_1");
	boolean[] actual=new boolean[36];
	 SoftAssert soft=new SoftAssert();
@Given("^user in Repository Page to create Node and add test cases upto Eighth Level$")
public void user_in_Repository_Page_to_create_Node_and_add_test_cases_upto_Eighth_Level() throws Throwable 
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

@Given("^create node and add testcases upto Eighth Level$")
public void create_node_and_add_testcases_upto_Eighth_Level() throws Throwable 
{
	try
	{
		////////add phase////////
		tr=new TestRepositoryPage(driver);
		tr.clickOnRelease(releaseName);
		String phaseName1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		String phaseDesc=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 1);
		actual[2]=tr.addNode(phaseName1, phaseDesc);
		String phase1[]=new String[1];
		phase1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		actual[3]=tr.navigateToNode(releaseName, phase1);
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		///////add system/////////////////////////////////
		tr.navigateToNode(releaseName, phase1);
		String phaseName2=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		String phaseDesc2=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 3);
		actual[4]=tr.addNode(phaseName2, phaseDesc2);
		String phase2[]=new String[2];
		phase2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		phase2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		actual[5]=tr.navigateToNode(releaseName, phase2);
		actual[6]=tr.addTestCase();
		actual[7]=tr.addTestCase();
		actual[8]=tr.addTestCase();
		actual[9]=tr.addTestCase();
		////add subsystem///////////
		tr.navigateToNode(releaseName, phase2);
		String phaseName3=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
		String phaseDesc3=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 5);
		actual[4]=tr.addNode(phaseName3, phaseDesc3);
		String phase3[]=new String[3];
		phase3[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		phase3[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		phase3[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
		actual[10]=tr.navigateToNode(releaseName, phase3);
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		///level-4////////////
		tr.navigateToNode(releaseName, phase3);
		String phaseName4=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 6);
		String phaseDesc4=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 7);
		actual[11]=tr.addNode(phaseName4, phaseDesc4);
		String phase4[]=new String[4];
		phase4[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		phase4[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		phase4[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
		phase4[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 6);
		actual[12]=tr.navigateToNode(releaseName, phase4);
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		/////Level-5////////
		tr.navigateToNode(releaseName, phase4);
		String phaseName5=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 8);
		String phaseDesc5=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 9);
		actual[13]=tr.addNode(phaseName5, phaseDesc5);
		String phase5[]=new String[5];
		phase5[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		phase5[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		phase5[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
		phase5[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 6);
		phase5[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 8);
		actual[14]=tr.navigateToNode(releaseName, phase5);
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		///////level-6////
		tr.navigateToNode(releaseName, phase5);
		String phaseName6=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 10);
		String phaseDesc6=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 11);
		actual[15]=tr.addNode(phaseName6, phaseDesc6);
		String phase6[]=new String[6];
		phase6[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		phase6[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		phase6[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
		phase6[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 6);
		phase6[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 8);
		phase6[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 10);
		actual[16]=tr.navigateToNode(releaseName, phase6);
		tr.selectPhase(phase6[5]);
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		////level-7/////////////
		tr=new TestRepositoryPage(driver);
		tr.navigateToNode(releaseName, phase6);
		tr.selectPhase(phase6[5]);
		String phaseName7=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 12);
		String phaseDesc7=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 13);
		actual[17]=tr.addNode(phaseName7, phaseDesc7);
		String phase7[]=new String[7];
		phase7[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		phase7[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		phase7[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
		phase7[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 6);
		phase7[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 8);
		phase7[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 10);
		phase7[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 12);
		actual[18]=tr.navigateToNode(releaseName, phase7);
		for(int i=0;i<=3;i++)
		{
			bp.waitForElement();
		}
		tr.selectPhase(phase7[6]);
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		/////level-8/////////
		tr.navigateToNode(releaseName, phase7);
		tr.selectPhase(phase7[6]);
		String phaseName8=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 14);
		String phaseDesc8=Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 15);
		actual[19]=tr.addNode(phaseName8, phaseDesc8);
		String phase8[]=new String[8];
		phase8[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
		phase8[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
		phase8[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
		phase8[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 6);
		phase8[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 8);
		phase8[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 10);
		phase8[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 12);
		phase8[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 14);
		actual[20]=tr.navigateToNode(releaseName, phase8);
		for(int i=0;i<=3;i++)
		{
			bp.waitForElement();
		}
		tr.selectPhase(phase8[7]);
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
		tr.addTestCase();
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

@When("^Launch requirments create node and Add requirements$")
public void launch_requirments_create_node_and_Add_requirements() throws Throwable 
{
	 try
		{
	    	bp.waitForElement();
			rp= new ReleasePage(driver);
		    rp.clickOnRequirements();
		    bp.waitForElement();
			req=new RequirementsPage(driver);
			tr.clickOnRelease(releaseName);
			String p_Name1=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "Requirements", 1, 0);
			String p_Desc1=Excel_Lib.getData(INPUT_PATH_4, "Requirements", 1, 1);
			req.addNode(p_Name1,p_Desc1);
			bp.waitForElement();
			String[] phase=new String[1];
			phase[0]=p_Name1;
			tr=new TestRepositoryPage(driver);
			bp.waitForElement();
			actual[21]=tr.navigateToNode(releaseName, phase);
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

@When("^Select a single requirement from a node click on Map testcase Select one testcase from tree node and save$")
public void select_a_single_requirement_from_a_node_click_on_Map_testcase_Select_one_testcase_from_tree_node_and_save() throws Throwable 
{
	 try
	   {
		   tr.clickDetailButton();
		 	String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0 ));
			bp.waitForElement();
			actual[22]=req.selectMultipleRequirementFromGrids(testCaseNo1);
			bp.waitForElement();
			//tr.clickDetailButton();
			
			req=new RequirementsPage(driver);
			actual[23]=req.MapTestCases();
	    	actual[24]=req.ExpandRelease(releaseName);
	    	bp.waitForElement();
	    	String[] fields=new String[1];
	    	fields[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4, "NodeDetails", 66, 0);
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
			//tr.clickOnList();
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
			actual[27]=req.requirementCoverageDetails(tcNo);
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

@When("^Select another requirement from a node click on Map testcase Select Node from tree and save$")
public void select_another_requirement_from_a_node_click_on_Map_testcase_Select_Node_from_tree_and_save() throws Throwable 
{
	 try
	   {
		 	String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",2 ,0 ));
			bp.waitForElement();
			actual[28]=req.selectMultipleRequirementFromGrids(testCaseNo1);
			bp.waitForElement();
			req=new RequirementsPage(driver);
			actual[29]=req.MapTestCases();
	    	actual[30]=req.ExpandRelease(releaseName);
	    	bp.waitForElement();
	    	String[] phaseName2=new String[2];
	    	phaseName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
	    	phaseName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
	    	tr.navigateNode(phaseName2);
	    	String phase2=phaseName2[1];
	    	req.clickOnChecKBox(phase2);
	    	bp.waitForElement();
			req.clickOnSavejirareq.click();
			bp.waitForElement();
			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
			actual[31]=req.requirementCoverageDetails(tcNo);
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

@Then("^Select another requirement from a node click on Map testcase Select Release and save$")
public void select_another_requirement_from_a_node_click_on_Map_testcase_Select_Release_and_save() throws Throwable 
{
	 try
	   {
//		 	String[] testCaseNo1=new String[1];
//			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",3 ,0 ));
//			bp.waitForElement();
//			actual[5]=req.selectRequirementsFromGrids(testCaseNo1);
//			bp.waitForElement();
//			req=new RequirementsPage(driver);
//			actual[6]=req.MapTestCases();
//			bp.waitForElement();
//	    	req.clickOnChecKBox(releaseName);
//	    	bp.waitForElement();
//			req.clickOnSavejirareq.click();
//			bp.waitForElement();
//			int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
//			actual[10]=req.requirementCoverageDetails(tcNo);
//			bp.waitForElement();
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

@Then("^Select another requirement from a node click on Map testcase Select Eighth Level node and save$")
public void select_another_requirement_from_a_node_click_on_Map_testcase_Select_Eighth_Level_node_and_save() throws Throwable 
{
	 try
	   {
		 	String[] testCaseNo1=new String[1];
			testCaseNo1[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",4 ,0 ));
			bp.waitForElement();
			actual[32]=req.selectMultipleRequirementFromGrids(testCaseNo1);
			bp.waitForElement();
			req=new RequirementsPage(driver);
			actual[33]=req.MapTestCases();
	    	actual[34]=req.ExpandRelease(releaseName);
	    	bp.waitForElement();
	    	String[] phaseName2=new String[8];
	    	phaseName2[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 0);
	    	phaseName2[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 2);
	    	phaseName2[2]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 4);
	    	phaseName2[3]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 6);
	    	phaseName2[4]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 8);
	    	phaseName2[5]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 10);
	    	phaseName2[6]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 12);
	    	phaseName2[7]=UNIQUE+Excel_Lib.getData(INPUT_PATH_4,"NodeDetails", 66, 14);
	    	tr.navigateNode(phaseName2);
	    	String phase8=phaseName2[7];
	    	req.clickOnChecKBox(phase8);
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

@Then("^Able to map requirement to the testcase which is deep nested upto Eighth level$")
public void able_to_map_requirement_to_the_testcase_which_is_deep_nested_upto_Eighth_level() throws Throwable 
{
	try
	{
		int tcNo=Excel_Lib.getNumberData(INPUT_PATH_4, "TestcaseNames",1 ,0);
		actual[35]=req.requirementCoverageDetails(tcNo);
		bp.waitForElement();
		
		tr.clickOnList();
		bp.waitForElement();
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
